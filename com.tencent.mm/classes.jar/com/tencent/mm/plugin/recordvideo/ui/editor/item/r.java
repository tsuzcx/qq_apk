package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.PhotoEditText;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "font", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "createBitmap", "Landroid/graphics/Bitmap;", "item", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "initScale", "", "sx", "", "sy", "reshowText", "setText", "plugin-recordvideo_release"})
public final class r
  extends b
{
  private String CeI;
  private q Cgi;
  private final String TAG;
  
  public r(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76171);
    this.TAG = "MicroMsg.TextItemView";
    setTextSize(getResources().getDimension(2131166236));
    this.CeI = "";
    AppMethodBeat.o(76171);
  }
  
  public final void af(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(76167);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      getTouchTracker().gT.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(76167);
  }
  
  public final void b(q paramq)
  {
    AppMethodBeat.i(237841);
    p.h(paramq, "item");
    setText(paramq);
    setViewMatrix(paramq.gT);
    getTouchTracker().gT.set(paramq.gT);
    setSourceDataType(d.CeK);
    AppMethodBeat.o(237841);
  }
  
  public final Bitmap c(q paramq)
  {
    AppMethodBeat.i(237842);
    p.h(paramq, "item");
    setSourceDataType(d.CeK);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    int k = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    int m = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    ((PhotoEditText)localObject).setPadding(k, m, k, m);
    ((PhotoEditText)localObject).setTextColor(paramq.textColor);
    ((PhotoEditText)localObject).setTextBackground(paramq.Cgg);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText(paramq.text);
    ((PhotoEditText)localObject).setSingleLine(false);
    int i;
    label163:
    label254:
    int j;
    if (((CharSequence)paramq.CeI).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label422;
      }
      if (!s.YS(paramq.CeI)) {
        break label411;
      }
      ((PhotoEditText)localObject).setTypeface(Typeface.createFromFile(paramq.CeI));
      if ((paramq.Cgg == 0) && (paramq.textColor != -16777216)) {
        com.tencent.mm.ac.d.f((TextView)localObject);
      }
      paramq = e.BKp;
      i = e.eIR().width();
      if (i > 0) {
        ((PhotoEditText)localObject).setMaxWidth(i);
      }
      ((PhotoEditText)localObject).measure(0, 0);
      if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
      {
        i = ((PhotoEditText)localObject).getMeasuredWidth();
        paramq = e.BKp;
        if (i <= e.eIR().width()) {
          break label436;
        }
      }
      paramq = e.BKp;
      i = e.eIR().width();
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        j = ((PhotoEditText)localObject).getMeasuredHeight();
        paramq = e.BKp;
        if (j <= e.eIR().height()) {
          break label445;
        }
      }
      paramq = e.BKp;
      j = e.eIR().height();
      label293:
      if ((i > 0) && (j > 0)) {
        break label454;
      }
      Log.w(this.TAG, "create bitmap size error: " + i + ", " + j);
    }
    label411:
    label422:
    label436:
    label445:
    label454:
    for (paramq = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; paramq = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas(paramq);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(k, m);
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      p.g(paramq, "bitmap");
      AppMethodBeat.o(237842);
      return paramq;
      i = 0;
      break;
      ((PhotoEditText)localObject).setTypeface(Typeface.DEFAULT);
      break label163;
      ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
      break label163;
      i = ((PhotoEditText)localObject).getMeasuredWidth();
      break label254;
      j = ((PhotoEditText)localObject).getMeasuredHeight();
      break label293;
    }
  }
  
  public final a cJO()
  {
    AppMethodBeat.i(237843);
    a locala = super.cJO();
    q localq = this.Cgi;
    if (localq != null)
    {
      Object localObject;
      if (locala != null)
      {
        localObject = localq.Cev;
        p.h(localObject, "range");
        locala.Cev.ai(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject).Cgx.getTime(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject).Cgy.getTime());
      }
      if (locala != null) {
        locala.objectId = localq.objectId;
      }
      if ((locala instanceof q))
      {
        localq = (q)locala;
        localObject = this.CeI;
        p.h(localObject, "<set-?>");
        localq.CeI = ((String)localObject);
      }
    }
    AppMethodBeat.o(237843);
    return locala;
  }
  
  public final a getEditorData()
  {
    return (a)this.Cgi;
  }
  
  public final String getFont()
  {
    return this.CeI;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Chy;
  }
  
  public final void setFont(String paramString)
  {
    AppMethodBeat.i(237839);
    p.h(paramString, "<set-?>");
    this.CeI = paramString;
    AppMethodBeat.o(237839);
  }
  
  public final void setText(q paramq)
  {
    AppMethodBeat.i(237840);
    p.h(paramq, "item");
    this.Cgi = paramq;
    Bitmap localBitmap = c(paramq);
    setText(paramq.text);
    setSourceDataType(d.CeK);
    setColor(paramq.textColor);
    setTextBg(paramq.Cgg);
    this.CeI = paramq.CeI;
    if (getBitmap() == null) {
      getTouchTracker().gT.postTranslate(-getWidth() / 2.0F, -((getDisplayRect().top + getDisplayRect().bottom) / 2 - (getValidRect().top + getValidRect().bottom) / 2.0F + getHeight() / 2.0F));
    }
    paramq = getBitmap();
    if (paramq != null) {
      getTouchTracker().gT.preTranslate(paramq.getWidth() / 2.0F, paramq.getHeight() / 2.0F);
    }
    setBitmap(localBitmap);
    postInvalidate();
    AppMethodBeat.o(237840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.r
 * JD-Core Version:    0.7.0.1
 */