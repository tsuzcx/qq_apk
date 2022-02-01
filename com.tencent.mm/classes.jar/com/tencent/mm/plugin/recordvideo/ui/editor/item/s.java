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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MARGIN", "", "TAG", "", "originMatrix", "Landroid/graphics/Matrix;", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "createBitmap", "Landroid/graphics/Bitmap;", "item", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowText", "", "setText", "plugin-recordvideo_release"})
public final class s
  extends b
{
  private final String TAG;
  private final int api;
  private final Matrix yeQ;
  private q yfi;
  
  public s(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76176);
    this.TAG = "MicroMsg.TipItemView";
    this.api = aq.fromDPToPix(paramContext, 32);
    this.yeQ = new Matrix();
    setTextSize(getResources().getDimension(2131166199));
    AppMethodBeat.o(76176);
  }
  
  public final void b(q paramq)
  {
    AppMethodBeat.i(207004);
    p.h(paramq, "item");
    setText(paramq);
    setViewMatrix(paramq.gR);
    setSourceDataType(d.ydL);
    AppMethodBeat.o(207004);
  }
  
  public final Bitmap c(q paramq)
  {
    AppMethodBeat.i(207005);
    p.h(paramq, "item");
    setSourceDataType(d.ydL);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    ((PhotoEditText)localObject).setPadding(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
    ((PhotoEditText)localObject).setTextColor(paramq.textColor);
    ((PhotoEditText)localObject).setTextBackground(paramq.yfg);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText(paramq.text);
    ((PhotoEditText)localObject).setSingleLine(false);
    ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
    if ((paramq.yfg == 0) && (paramq.textColor != -16777216)) {
      com.tencent.mm.ac.c.e((TextView)localObject);
    }
    int i = this.api;
    paramq = e.xKl;
    if (i >= e.dIe().left)
    {
      paramq = e.xKl;
      i = e.dIe().width();
      j = this.api;
      paramq = e.xKl;
      i -= (j - e.dIe().left) * 2;
      ((PhotoEditText)localObject).setMaxWidth(i);
      ((PhotoEditText)localObject).measure(0, 0);
      if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
      {
        i = ((PhotoEditText)localObject).getMeasuredWidth();
        paramq = e.xKl;
        if (i <= e.dIe().width()) {
          break label414;
        }
      }
      paramq = e.xKl;
      i = e.dIe().width();
      label245:
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        j = ((PhotoEditText)localObject).getMeasuredHeight();
        paramq = e.xKl;
        if (j <= e.dIe().height()) {
          break label423;
        }
      }
      paramq = e.xKl;
    }
    label414:
    label423:
    for (int j = e.dIe().height();; j = ((PhotoEditText)localObject).getMeasuredHeight())
    {
      ae.i(this.TAG, "measuredWidth:" + ((PhotoEditText)localObject).getMeasuredWidth() + " , measuredHeight:" + ((PhotoEditText)localObject).getMeasuredHeight());
      paramq = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramq);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(getPaddingLeft(), getPaddingTop());
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      p.g(paramq, "bitmap");
      AppMethodBeat.o(207005);
      return paramq;
      paramq = e.xKl;
      i = e.dIe().width();
      break;
      i = ((PhotoEditText)localObject).getMeasuredWidth();
      break label245;
    }
  }
  
  public final a clM()
  {
    AppMethodBeat.i(207007);
    a locala = super.clM();
    if (locala != null) {
      locala.b(d.ydL);
    }
    AppMethodBeat.o(207007);
    return locala;
  }
  
  public final a getEditorData()
  {
    AppMethodBeat.i(207006);
    Object localObject = this.yfi;
    if (localObject != null)
    {
      localObject = ((a)localObject).gR;
      if (localObject != null) {
        ((Matrix)localObject).set(getTouchTracker().gR);
      }
    }
    localObject = this.yfi;
    if (localObject != null) {
      ((q)localObject).b(d.ydL);
    }
    localObject = (a)this.yfi;
    AppMethodBeat.o(207006);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.ygC;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76172);
    p.h(paramMotionEvent, "event");
    this.yeQ.set(getTouchTracker().gR);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().gR.set(this.yeQ);
    AppMethodBeat.o(76172);
    return bool;
  }
  
  public final void setText(q paramq)
  {
    AppMethodBeat.i(207003);
    p.h(paramq, "item");
    this.yfi = paramq;
    setText(paramq.text);
    Bitmap localBitmap = c(paramq);
    setSourceDataType(d.ydL);
    setColor(paramq.textColor);
    setTextBg(paramq.yfg);
    int i;
    float f2;
    float f3;
    float f4;
    if (paramq.ydz == 0)
    {
      i = paramq.ydz;
      setMarginBottom(i);
      setBitmap(localBitmap);
      paramq = getBitmap();
      if (paramq != null)
      {
        f2 = getValidRect().height() - aq.fromDPToPix(getContext(), 128) - ar.en(getContext());
        f3 = getMarginBottom();
        f4 = paramq.getHeight();
        i = this.api;
        paramq = e.xKl;
        if (i < e.dIe().left) {
          break label206;
        }
      }
    }
    for (float f1 = this.api;; f1 = e.dIe().left)
    {
      getTouchTracker().gR.setTranslate(f1, f2 - f3 - f4);
      postInvalidate();
      AppMethodBeat.o(207003);
      return;
      i = paramq.ydz + aq.fromDPToPix(getContext(), 24);
      break;
      label206:
      paramq = e.xKl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.s
 * JD-Core Version:    0.7.0.1
 */