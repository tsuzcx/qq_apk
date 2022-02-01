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
import com.tencent.mm.plugin.recordvideo.ui.editor.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MARGIN", "", "TAG", "", "originMatrix", "Landroid/graphics/Matrix;", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "createBitmap", "Landroid/graphics/Bitmap;", "item", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowText", "", "setText", "plugin-recordvideo_release"})
public final class s
  extends b
{
  private final Matrix CfS;
  private q Cgi;
  private final String TAG;
  private final int apv;
  
  public s(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76176);
    this.TAG = "MicroMsg.TipItemView";
    this.apv = at.fromDPToPix(paramContext, 32);
    this.CfS = new Matrix();
    setTextSize(getResources().getDimension(2131166240));
    AppMethodBeat.o(76176);
  }
  
  public final void b(q paramq)
  {
    AppMethodBeat.i(237845);
    p.h(paramq, "item");
    setText(paramq);
    setViewMatrix(paramq.gT);
    setSourceDataType(d.CeN);
    AppMethodBeat.o(237845);
  }
  
  public final Bitmap c(q paramq)
  {
    AppMethodBeat.i(237846);
    p.h(paramq, "item");
    setSourceDataType(d.CeN);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    ((PhotoEditText)localObject).setPadding(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
    ((PhotoEditText)localObject).setTextColor(paramq.textColor);
    ((PhotoEditText)localObject).setTextBackground(paramq.Cgg);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText(paramq.text);
    ((PhotoEditText)localObject).setSingleLine(false);
    ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
    if ((paramq.Cgg == 0) && (paramq.textColor != -16777216)) {
      com.tencent.mm.ac.d.f((TextView)localObject);
    }
    int i = this.apv;
    paramq = e.BKp;
    if (i >= e.eIR().left)
    {
      paramq = e.BKp;
      i = e.eIR().width();
      j = this.apv;
      paramq = e.BKp;
      i -= (j - e.eIR().left) * 2;
      ((PhotoEditText)localObject).setMaxWidth(i);
      ((PhotoEditText)localObject).measure(0, 0);
      if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
      {
        i = ((PhotoEditText)localObject).getMeasuredWidth();
        paramq = e.BKp;
        if (i <= e.eIR().width()) {
          break label414;
        }
      }
      paramq = e.BKp;
      i = e.eIR().width();
      label245:
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        j = ((PhotoEditText)localObject).getMeasuredHeight();
        paramq = e.BKp;
        if (j <= e.eIR().height()) {
          break label423;
        }
      }
      paramq = e.BKp;
    }
    label414:
    label423:
    for (int j = e.eIR().height();; j = ((PhotoEditText)localObject).getMeasuredHeight())
    {
      Log.i(this.TAG, "measuredWidth:" + ((PhotoEditText)localObject).getMeasuredWidth() + " , measuredHeight:" + ((PhotoEditText)localObject).getMeasuredHeight());
      paramq = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramq);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(getPaddingLeft(), getPaddingTop());
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      p.g(paramq, "bitmap");
      AppMethodBeat.o(237846);
      return paramq;
      paramq = e.BKp;
      i = e.eIR().width();
      break;
      i = ((PhotoEditText)localObject).getMeasuredWidth();
      break label245;
    }
  }
  
  public final a cJO()
  {
    AppMethodBeat.i(237848);
    a locala = super.cJO();
    if (locala != null) {
      locala.b(d.CeN);
    }
    AppMethodBeat.o(237848);
    return locala;
  }
  
  public final a getEditorData()
  {
    AppMethodBeat.i(237847);
    Object localObject = this.Cgi;
    if (localObject != null)
    {
      localObject = ((a)localObject).gT;
      if (localObject != null) {
        ((Matrix)localObject).set(getTouchTracker().gT);
      }
    }
    localObject = this.Cgi;
    if (localObject != null) {
      ((q)localObject).b(d.CeN);
    }
    localObject = (a)this.Cgi;
    AppMethodBeat.o(237847);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Chz;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76172);
    p.h(paramMotionEvent, "event");
    this.CfS.set(getTouchTracker().gT);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().gT.set(this.CfS);
    AppMethodBeat.o(76172);
    return bool;
  }
  
  public final void setText(q paramq)
  {
    AppMethodBeat.i(237844);
    p.h(paramq, "item");
    this.Cgi = paramq;
    setText(paramq.text);
    Bitmap localBitmap = c(paramq);
    setSourceDataType(d.CeN);
    setColor(paramq.textColor);
    setTextBg(paramq.Cgg);
    int i;
    float f2;
    float f3;
    float f4;
    if (paramq.CeB == 0)
    {
      i = paramq.CeB;
      setMarginBottom(i);
      setBitmap(localBitmap);
      paramq = getBitmap();
      if (paramq != null)
      {
        f2 = getValidRect().height() - at.fromDPToPix(getContext(), 128) - au.aD(getContext());
        f3 = getMarginBottom();
        f4 = paramq.getHeight();
        i = this.apv;
        paramq = e.BKp;
        if (i < e.eIR().left) {
          break label206;
        }
      }
    }
    for (float f1 = this.apv;; f1 = e.eIR().left)
    {
      getTouchTracker().gT.setTranslate(f1, f2 - f3 - f4);
      postInvalidate();
      AppMethodBeat.o(237844);
      return;
      i = paramq.CeB + at.fromDPToPix(getContext(), 24);
      break;
      label206:
      paramq = e.BKp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.s
 * JD-Core Version:    0.7.0.1
 */