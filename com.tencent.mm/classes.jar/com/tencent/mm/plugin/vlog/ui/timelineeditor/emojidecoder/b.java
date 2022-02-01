package com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.util.Size;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.PhotoEditText;
import com.tencent.mm.vfs.y;
import com.tencent.mm.xeffect.effect.IStickerDecoder;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/TextDecoder;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "context", "Landroid/content/Context;", "path", "", "(Landroid/content/Context;Ljava/lang/String;)V", "height", "", "textBitmap", "Landroid/graphics/Bitmap;", "textSize", "textView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoEditText;", "width", "commonShadow", "", "Landroid/widget/TextView;", "destroy", "duration", "", "getFrame", "seekTo", "time", "size", "Landroid/util/Size;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements IStickerDecoder
{
  public static final a UqI;
  private Bitmap UqH;
  private PhotoEditText UqJ;
  private int height;
  private final int textSize;
  private int width;
  
  static
  {
    AppMethodBeat.i(282156);
    UqI = new a((byte)0);
    AppMethodBeat.o(282156);
  }
  
  public b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(282148);
    this.textSize = a.br(paramContext, b.c.editor_text_item_text_size);
    this.UqJ = new PhotoEditText(paramContext);
    Bitmap localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    s.s(localBitmap, "createBitmap(1, 1, Bitmap.Config.ALPHA_8)");
    this.UqH = localBitmap;
    int j = a.fromDPToPix(paramContext, 16);
    int k = a.fromDPToPix(paramContext, 8);
    this.UqJ.setPadding(j, k, j, k);
    this.UqJ.setSingleLine(false);
    this.UqJ.setTextSize(0, this.textSize * 1.0F);
    for (;;)
    {
      try
      {
        paramContext = new JSONObject(paramString);
        this.UqJ.setTextColor(paramContext.optInt("font_color"));
        this.UqJ.setTextBackground(paramContext.optInt("bg_color"));
        this.UqJ.setText((CharSequence)paramContext.optString("text"));
        paramString = paramContext.optString("font_style");
        s.s(paramString, "fontStyle");
        if (((CharSequence)paramString).length() > 0)
        {
          i = 1;
          if (i == 0) {
            break label492;
          }
          if (y.ZC(paramString))
          {
            this.UqJ.setTypeface(Typeface.createFromFile(paramString));
            if ((paramContext.optInt("bg_color") == 0) && (paramContext.optInt("font_color") != -16777216)) {
              d.h((TextView)this.UqJ);
            }
            paramContext = e.NDU;
            i = e.gGL().width();
            if (i > 0) {
              this.UqJ.setMaxWidth(i);
            }
            this.UqJ.measure(0, 0);
            if (this.UqJ.getMeasuredWidth() > 0)
            {
              i = this.UqJ.getMeasuredWidth();
              paramContext = e.NDU;
              if (i <= e.gGL().width()) {
                break label510;
              }
            }
            paramContext = e.NDU;
            i = e.gGL().width();
            this.width = i;
            if (this.UqJ.getMeasuredHeight() > 0)
            {
              i = this.UqJ.getMeasuredHeight();
              paramContext = e.NDU;
              if (i <= e.gGL().height()) {
                break label521;
              }
            }
            paramContext = e.NDU;
            i = e.gGL().height();
            this.height = i;
            if ((this.width > 0) && (this.height > 0)) {
              break label532;
            }
            paramContext = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            paramString = new Canvas(paramContext);
            this.UqJ.draw(paramString);
            paramString.save();
            paramString.translate(j, k);
            this.UqJ.getLayout().draw(paramString);
            paramString.restore();
            s.s(paramContext, "bitmap");
            this.UqH = paramContext;
            AppMethodBeat.o(282148);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        this.UqJ.setTypeface(Typeface.DEFAULT);
        continue;
        this.UqJ.setTypeface(this.UqJ.getTypeface(), 1);
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(282148);
        return;
      }
      label492:
      continue;
      label510:
      int i = this.UqJ.getMeasuredWidth();
      continue;
      label521:
      i = this.UqJ.getMeasuredHeight();
      continue;
      label532:
      paramContext = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
    }
  }
  
  public final void destroy() {}
  
  public final long duration()
  {
    return 1073741824L;
  }
  
  public final Bitmap getFrame()
  {
    return this.UqH;
  }
  
  public final void seekTo(long paramLong) {}
  
  public final Size size()
  {
    AppMethodBeat.i(282187);
    Size localSize = new Size(this.width, this.height);
    AppMethodBeat.o(282187);
    return localSize;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/TextDecoder$Companion;", "", "()V", "BG_COLOR", "", "FONT_COLOR", "FONT_STYLE", "TEXT_SCHEME", "getTextValue", "text", "fontColor", "", "bgColor", "fontStyle", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String q(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      AppMethodBeat.i(282151);
      s.u(paramString1, "text");
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("scheme", "text");
        localJSONObject.put("text", paramString1);
        localJSONObject.put("font_color", paramInt1);
        localJSONObject.put("bg_color", paramInt2);
        localJSONObject.put("font_style", paramString2);
        label66:
        paramString1 = localJSONObject.toString();
        s.s(paramString1, "value.toString()");
        AppMethodBeat.o(282151);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        break label66;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.b
 * JD-Core Version:    0.7.0.1
 */