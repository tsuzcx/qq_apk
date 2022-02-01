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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "font", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "createBitmap", "Landroid/graphics/Bitmap;", "item", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "initScale", "", "sx", "", "sy", "reshowText", "setText", "plugin-recordvideo_release"})
public final class r
  extends b
{
  private final String TAG;
  private String xNN;
  private q xPp;
  
  public r(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76171);
    this.TAG = "MicroMsg.TextItemView";
    setTextSize(getResources().getDimension(2131166195));
    this.xNN = "";
    AppMethodBeat.o(76171);
  }
  
  public final void aa(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(76167);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      getTouchTracker().gR.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(76167);
  }
  
  public final void b(q paramq)
  {
    AppMethodBeat.i(200742);
    p.h(paramq, "item");
    setText(paramq);
    setViewMatrix(paramq.gR);
    getTouchTracker().gR.set(paramq.gR);
    setSourceDataType(d.xNP);
    AppMethodBeat.o(200742);
  }
  
  public final Bitmap c(q paramq)
  {
    AppMethodBeat.i(200743);
    p.h(paramq, "item");
    setSourceDataType(d.xNP);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    int k = com.tencent.mm.cc.a.fromDPToPix(getContext(), 16);
    int m = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    ((PhotoEditText)localObject).setPadding(k, m, k, m);
    ((PhotoEditText)localObject).setTextColor(paramq.textColor);
    ((PhotoEditText)localObject).setTextBackground(paramq.xPn);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText(paramq.text);
    ((PhotoEditText)localObject).setSingleLine(false);
    int i;
    label153:
    label244:
    int j;
    if (((CharSequence)paramq.xNN).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label401;
      }
      ((PhotoEditText)localObject).setTypeface(Typeface.createFromFile(paramq.xNN));
      if ((paramq.xPn == 0) && (paramq.textColor != -16777216)) {
        com.tencent.mm.ad.c.e((TextView)localObject);
      }
      paramq = e.xuo;
      i = e.dEN().width();
      if (i > 0) {
        ((PhotoEditText)localObject).setMaxWidth(i);
      }
      ((PhotoEditText)localObject).measure(0, 0);
      if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
      {
        i = ((PhotoEditText)localObject).getMeasuredWidth();
        paramq = e.xuo;
        if (i <= e.dEN().width()) {
          break label415;
        }
      }
      paramq = e.xuo;
      i = e.dEN().width();
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        j = ((PhotoEditText)localObject).getMeasuredHeight();
        paramq = e.xuo;
        if (j <= e.dEN().height()) {
          break label424;
        }
      }
      paramq = e.xuo;
      j = e.dEN().height();
      label283:
      if ((i > 0) && (j > 0)) {
        break label433;
      }
      ad.w(this.TAG, "create bitmap size error: " + i + ", " + j);
    }
    label401:
    label415:
    label424:
    label433:
    for (paramq = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; paramq = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas(paramq);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(k, m);
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      p.g(paramq, "bitmap");
      AppMethodBeat.o(200743);
      return paramq;
      i = 0;
      break;
      ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
      break label153;
      i = ((PhotoEditText)localObject).getMeasuredWidth();
      break label244;
      j = ((PhotoEditText)localObject).getMeasuredHeight();
      break label283;
    }
  }
  
  public final a ckw()
  {
    AppMethodBeat.i(200744);
    a locala = super.ckw();
    q localq = this.xPp;
    if (localq != null)
    {
      Object localObject;
      if (locala != null)
      {
        localObject = localq.xNA;
        p.h(localObject, "range");
        locala.xNA.af(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject).xPF.getTime(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject).xPG.getTime());
      }
      if (locala != null) {
        locala.objectId = localq.objectId;
      }
      if ((locala instanceof q))
      {
        localq = (q)locala;
        localObject = this.xNN;
        p.h(localObject, "<set-?>");
        localq.xNN = ((String)localObject);
      }
    }
    AppMethodBeat.o(200744);
    return locala;
  }
  
  public final a getEditorData()
  {
    return (a)this.xPp;
  }
  
  public final String getFont()
  {
    return this.xNN;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.xQI;
  }
  
  public final void setFont(String paramString)
  {
    AppMethodBeat.i(200740);
    p.h(paramString, "<set-?>");
    this.xNN = paramString;
    AppMethodBeat.o(200740);
  }
  
  public final void setText(q paramq)
  {
    AppMethodBeat.i(200741);
    p.h(paramq, "item");
    this.xPp = paramq;
    Bitmap localBitmap = c(paramq);
    setText(paramq.text);
    setSourceDataType(d.xNP);
    setColor(paramq.textColor);
    setTextBg(paramq.xPn);
    this.xNN = paramq.xNN;
    if (getBitmap() == null) {
      getTouchTracker().gR.postTranslate(-getWidth() / 2.0F, -((getDisplayRect().top + getDisplayRect().bottom) / 2 - (getValidRect().top + getValidRect().bottom) / 2.0F + getHeight() / 2.0F));
    }
    paramq = getBitmap();
    if (paramq != null) {
      getTouchTracker().gR.preTranslate(paramq.getWidth() / 2.0F, paramq.getHeight() / 2.0F);
    }
    setBitmap(localBitmap);
    postInvalidate();
    AppMethodBeat.o(200741);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.r
 * JD-Core Version:    0.7.0.1
 */