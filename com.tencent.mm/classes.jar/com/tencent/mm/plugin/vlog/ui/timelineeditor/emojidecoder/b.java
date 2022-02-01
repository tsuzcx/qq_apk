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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.PhotoEditText;
import com.tencent.mm.vfs.u;
import com.tencent.mm.xeffect.effect.IStickerDecoder;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/TextDecoder;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "context", "Landroid/content/Context;", "path", "", "(Landroid/content/Context;Ljava/lang/String;)V", "height", "", "textBitmap", "Landroid/graphics/Bitmap;", "textSize", "textView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoEditText;", "width", "commonShadow", "", "Landroid/widget/TextView;", "destroy", "duration", "", "getFrame", "seekTo", "time", "size", "Landroid/util/Size;", "Companion", "plugin-vlog_release"})
public final class b
  implements IStickerDecoder
{
  public static final a NEy;
  private Bitmap NEw;
  private PhotoEditText NEx;
  private int height;
  private final int textSize;
  private int width;
  
  static
  {
    AppMethodBeat.i(228193);
    NEy = new a((byte)0);
    AppMethodBeat.o(228193);
  }
  
  public b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(228191);
    this.textSize = a.aY(paramContext, b.c.editor_text_item_text_size);
    this.NEx = new PhotoEditText(paramContext);
    Bitmap localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    p.j(localBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8)");
    this.NEw = localBitmap;
    int j = a.fromDPToPix(paramContext, 16);
    int k = a.fromDPToPix(paramContext, 8);
    this.NEx.setPadding(j, k, j, k);
    this.NEx.setSingleLine(false);
    this.NEx.setTextSize(0, this.textSize * 1.0F);
    for (;;)
    {
      try
      {
        paramContext = new JSONObject(paramString);
        this.NEx.setTextColor(paramContext.optInt("font_color"));
        this.NEx.setTextBackground(paramContext.optInt("bg_color"));
        this.NEx.setText((CharSequence)paramContext.optString("text"));
        paramString = paramContext.optString("font_style");
        p.j(paramString, "fontStyle");
        if (((CharSequence)paramString).length() > 0)
        {
          i = 1;
          if (i == 0) {
            break label492;
          }
          if (u.agG(paramString))
          {
            this.NEx.setTypeface(Typeface.createFromFile(paramString));
            if ((paramContext.optInt("bg_color") == 0) && (paramContext.optInt("font_color") != -16777216)) {
              d.g((TextView)this.NEx);
            }
            paramContext = e.HGz;
            i = e.fuV().width();
            if (i > 0) {
              this.NEx.setMaxWidth(i);
            }
            this.NEx.measure(0, 0);
            if (this.NEx.getMeasuredWidth() > 0)
            {
              i = this.NEx.getMeasuredWidth();
              paramContext = e.HGz;
              if (i <= e.fuV().width()) {
                break label510;
              }
            }
            paramContext = e.HGz;
            i = e.fuV().width();
            this.width = i;
            if (this.NEx.getMeasuredHeight() > 0)
            {
              i = this.NEx.getMeasuredHeight();
              paramContext = e.HGz;
              if (i <= e.fuV().height()) {
                break label521;
              }
            }
            paramContext = e.HGz;
            i = e.fuV().height();
            this.height = i;
            if ((this.width > 0) && (this.height > 0)) {
              break label532;
            }
            paramContext = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            paramString = new Canvas(paramContext);
            this.NEx.draw(paramString);
            paramString.save();
            paramString.translate(j, k);
            this.NEx.getLayout().draw(paramString);
            paramString.restore();
            p.j(paramContext, "bitmap");
            this.NEw = paramContext;
            AppMethodBeat.o(228191);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        this.NEx.setTypeface(Typeface.DEFAULT);
        continue;
        this.NEx.setTypeface(this.NEx.getTypeface(), 1);
      }
      catch (Exception paramContext)
      {
        AppMethodBeat.o(228191);
        return;
      }
      label492:
      continue;
      label510:
      int i = this.NEx.getMeasuredWidth();
      continue;
      label521:
      i = this.NEx.getMeasuredHeight();
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
    return this.NEw;
  }
  
  public final void seekTo(long paramLong) {}
  
  public final Size size()
  {
    AppMethodBeat.i(228186);
    Size localSize = new Size(this.width, this.height);
    AppMethodBeat.o(228186);
    return localSize;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/TextDecoder$Companion;", "", "()V", "BG_COLOR", "", "FONT_COLOR", "FONT_STYLE", "TEXT_SCHEME", "getTextValue", "text", "fontColor", "", "bgColor", "fontStyle", "plugin-vlog_release"})
  public static final class a
  {
    public static String p(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      AppMethodBeat.i(227321);
      p.k(paramString1, "text");
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
        p.j(paramString1, "value.toString()");
        AppMethodBeat.o(227321);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        break label66;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.b
 * JD-Core Version:    0.7.0.1
 */