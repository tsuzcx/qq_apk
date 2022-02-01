package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.Layout;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.PhotoEditText;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MARGIN", "", "TAG", "", "originMatrix", "Landroid/graphics/Matrix;", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "createBitmap", "Landroid/graphics/Bitmap;", "item", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowText", "", "setText", "plugin-recordvideo_release"})
public final class s
  extends b
{
  private final String TAG;
  private final int api;
  private final Matrix xOX;
  private q xPp;
  
  public s(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76176);
    this.TAG = "MicroMsg.TipItemView";
    this.api = aq.fromDPToPix(paramContext, 32);
    this.xOX = new Matrix();
    setTextSize(getResources().getDimension(2131166199));
    AppMethodBeat.o(76176);
  }
  
  public final void b(q paramq)
  {
    AppMethodBeat.i(200746);
    p.h(paramq, "item");
    setText(paramq);
    setViewMatrix(paramq.gR);
    setSourceDataType(d.xNS);
    AppMethodBeat.o(200746);
  }
  
  public final Bitmap c(q paramq)
  {
    AppMethodBeat.i(200747);
    p.h(paramq, "item");
    setSourceDataType(d.xNS);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    ((PhotoEditText)localObject).setPadding(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
    ((PhotoEditText)localObject).setTextColor(paramq.textColor);
    ((PhotoEditText)localObject).setTextBackground(paramq.xPn);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText(paramq.text);
    ((PhotoEditText)localObject).setSingleLine(false);
    ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
    if ((paramq.xPn == 0) && (paramq.textColor != -16777216)) {
      com.tencent.mm.ad.c.e((TextView)localObject);
    }
    int i = this.api;
    paramq = e.xuo;
    if (i >= e.dEN().left)
    {
      paramq = e.xuo;
      i = e.dEN().width();
      j = this.api;
      paramq = e.xuo;
      i -= (j - e.dEN().left) * 2;
      ((PhotoEditText)localObject).setMaxWidth(i);
      ((PhotoEditText)localObject).measure(0, 0);
      if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
      {
        i = ((PhotoEditText)localObject).getMeasuredWidth();
        paramq = e.xuo;
        if (i <= e.dEN().width()) {
          break label414;
        }
      }
      paramq = e.xuo;
      i = e.dEN().width();
      label245:
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        j = ((PhotoEditText)localObject).getMeasuredHeight();
        paramq = e.xuo;
        if (j <= e.dEN().height()) {
          break label423;
        }
      }
      paramq = e.xuo;
    }
    label414:
    label423:
    for (int j = e.dEN().height();; j = ((PhotoEditText)localObject).getMeasuredHeight())
    {
      ad.i(this.TAG, "measuredWidth:" + ((PhotoEditText)localObject).getMeasuredWidth() + " , measuredHeight:" + ((PhotoEditText)localObject).getMeasuredHeight());
      paramq = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramq);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(getPaddingLeft(), getPaddingTop());
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      p.g(paramq, "bitmap");
      AppMethodBeat.o(200747);
      return paramq;
      paramq = e.xuo;
      i = e.dEN().width();
      break;
      i = ((PhotoEditText)localObject).getMeasuredWidth();
      break label245;
    }
  }
  
  public final a ckw()
  {
    AppMethodBeat.i(200749);
    a locala = super.ckw();
    if (locala != null) {
      locala.b(d.xNS);
    }
    AppMethodBeat.o(200749);
    return locala;
  }
  
  public final a getEditorData()
  {
    AppMethodBeat.i(200748);
    Object localObject = this.xPp;
    if (localObject != null)
    {
      localObject = ((a)localObject).gR;
      if (localObject != null) {
        ((Matrix)localObject).set(getTouchTracker().gR);
      }
    }
    localObject = this.xPp;
    if (localObject != null) {
      ((q)localObject).b(d.xNS);
    }
    localObject = (a)this.xPp;
    AppMethodBeat.o(200748);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.xQJ;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76172);
    p.h(paramMotionEvent, "event");
    this.xOX.set(getTouchTracker().gR);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().gR.set(this.xOX);
    AppMethodBeat.o(76172);
    return bool;
  }
  
  public final void setText(q paramq)
  {
    AppMethodBeat.i(200745);
    p.h(paramq, "item");
    this.xPp = paramq;
    setText(paramq.text);
    Bitmap localBitmap = c(paramq);
    setSourceDataType(d.xNS);
    setColor(paramq.textColor);
    setTextBg(paramq.xPn);
    int i;
    float f2;
    float f3;
    float f4;
    if (paramq.xNG == 0)
    {
      i = paramq.xNG;
      setMarginBottom(i);
      setBitmap(localBitmap);
      paramq = getBitmap();
      if (paramq != null)
      {
        f2 = getValidRect().height() - aq.fromDPToPix(getContext(), 128) - ar.ej(getContext());
        f3 = getMarginBottom();
        f4 = paramq.getHeight();
        i = this.api;
        paramq = e.xuo;
        if (i < e.dEN().left) {
          break label206;
        }
      }
    }
    for (float f1 = this.api;; f1 = e.dEN().left)
    {
      getTouchTracker().gR.setTranslate(f1, f2 - f3 - f4);
      postInvalidate();
      AppMethodBeat.o(200745);
      return;
      i = paramq.xNG + aq.fromDPToPix(getContext(), 24);
      break;
      label206:
      paramq = e.xuo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.s
 * JD-Core Version:    0.7.0.1
 */