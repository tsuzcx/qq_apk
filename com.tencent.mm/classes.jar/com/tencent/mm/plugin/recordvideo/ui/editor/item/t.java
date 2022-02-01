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
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.PhotoEditText;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MARGIN", "", "TAG", "", "originMatrix", "Landroid/graphics/Matrix;", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "createBitmap", "Landroid/graphics/Bitmap;", "item", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowText", "", "setText", "plugin-recordvideo_release"})
public final class t
  extends b
{
  private final Matrix IcI;
  private r IcY;
  private final String TAG;
  private final int YY;
  
  public t(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76176);
    this.TAG = "MicroMsg.TipItemView";
    this.YY = aw.fromDPToPix(paramContext, 32);
    this.IcI = new Matrix();
    setTextSize(getResources().getDimension(b.c.editor_tip_text_item_text_size));
    AppMethodBeat.o(76176);
  }
  
  private Bitmap c(r paramr)
  {
    AppMethodBeat.i(222912);
    p.k(paramr, "item");
    setSourceDataType(d.IbJ);
    Object localObject = getContext();
    p.j(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    ((PhotoEditText)localObject).setPadding(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
    ((PhotoEditText)localObject).setTextColor(paramr.textColor);
    ((PhotoEditText)localObject).setTextBackground(paramr.IcW);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText(paramr.LV);
    ((PhotoEditText)localObject).setSingleLine(false);
    ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
    if ((paramr.IcW == 0) && (paramr.textColor != -16777216)) {
      com.tencent.mm.ae.d.g((TextView)localObject);
    }
    int i = this.YY;
    paramr = e.HGz;
    if (i >= e.fuV().left)
    {
      paramr = e.HGz;
      i = e.fuV().width();
      j = this.YY;
      paramr = e.HGz;
      i -= (j - e.fuV().left) * 2;
      ((PhotoEditText)localObject).setMaxWidth(i);
      ((PhotoEditText)localObject).measure(0, 0);
      if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
      {
        i = ((PhotoEditText)localObject).getMeasuredWidth();
        paramr = e.HGz;
        if (i <= e.fuV().width()) {
          break label414;
        }
      }
      paramr = e.HGz;
      i = e.fuV().width();
      label245:
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        j = ((PhotoEditText)localObject).getMeasuredHeight();
        paramr = e.HGz;
        if (j <= e.fuV().height()) {
          break label423;
        }
      }
      paramr = e.HGz;
    }
    label414:
    label423:
    for (int j = e.fuV().height();; j = ((PhotoEditText)localObject).getMeasuredHeight())
    {
      Log.i(this.TAG, "measuredWidth:" + ((PhotoEditText)localObject).getMeasuredWidth() + " , measuredHeight:" + ((PhotoEditText)localObject).getMeasuredHeight());
      paramr = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramr);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(getPaddingLeft(), getPaddingTop());
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      p.j(paramr, "bitmap");
      AppMethodBeat.o(222912);
      return paramr;
      paramr = e.HGz;
      i = e.fuV().width();
      break;
      i = ((PhotoEditText)localObject).getMeasuredWidth();
      break label245;
    }
  }
  
  public final void b(r paramr)
  {
    AppMethodBeat.i(222887);
    p.k(paramr, "item");
    setText(paramr);
    setViewMatrix(paramr.aHZ);
    setSourceDataType(d.IbJ);
    AppMethodBeat.o(222887);
  }
  
  public final a cYy()
  {
    AppMethodBeat.i(222921);
    a locala = super.cYy();
    if (locala != null) {
      locala.b(d.IbJ);
    }
    AppMethodBeat.o(222921);
    return locala;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c d(r paramr)
  {
    AppMethodBeat.i(222916);
    p.k(paramr, "item");
    paramr = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(c(paramr), paramr.aHZ);
    AppMethodBeat.o(222916);
    return paramr;
  }
  
  public final a getEditorData()
  {
    AppMethodBeat.i(222919);
    Object localObject = this.IcY;
    if (localObject != null)
    {
      localObject = ((a)localObject).aHZ;
      if (localObject != null) {
        ((Matrix)localObject).set(getTouchTracker().aHZ);
      }
    }
    localObject = this.IcY;
    if (localObject != null) {
      ((r)localObject).b(d.IbJ);
    }
    localObject = (a)this.IcY;
    AppMethodBeat.o(222919);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Iep;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76172);
    p.k(paramMotionEvent, "event");
    this.IcI.set(getTouchTracker().aHZ);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().aHZ.set(this.IcI);
    AppMethodBeat.o(76172);
    return bool;
  }
  
  public final void setText(r paramr)
  {
    AppMethodBeat.i(222884);
    p.k(paramr, "item");
    this.IcY = paramr;
    setText(paramr.LV);
    Bitmap localBitmap = c(paramr);
    setSourceDataType(d.IbJ);
    setColor(paramr.textColor);
    setTextBg(paramr.IcW);
    int i;
    float f2;
    float f3;
    float f4;
    if (paramr.Ibx == 0)
    {
      i = paramr.Ibx;
      setMarginBottom(i);
      setBitmap(localBitmap);
      paramr = getBitmap();
      if (paramr != null)
      {
        f2 = getValidRect().height() - aw.fromDPToPix(getContext(), 128) - ax.aB(getContext());
        f3 = getMarginBottom();
        f4 = paramr.getHeight();
        i = this.YY;
        paramr = e.HGz;
        if (i < e.fuV().left) {
          break label206;
        }
      }
    }
    for (float f1 = this.YY;; f1 = e.fuV().left)
    {
      getTouchTracker().aHZ.setTranslate(f1, f2 - f3 - f4);
      postInvalidate();
      AppMethodBeat.o(222884);
      return;
      i = paramr.Ibx + aw.fromDPToPix(getContext(), 24);
      break;
      label206:
      paramr = e.HGz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.t
 * JD-Core Version:    0.7.0.1
 */