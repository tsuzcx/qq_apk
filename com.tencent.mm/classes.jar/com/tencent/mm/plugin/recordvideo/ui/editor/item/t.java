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
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MARGIN", "", "TAG", "", "originMatrix", "Landroid/graphics/Matrix;", "textItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "createBitmap", "Landroid/graphics/Bitmap;", "item", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "getBitmapEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BitmapEditorItem;", "getEditorData", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowText", "", "setText", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends b
{
  private final Matrix NZe;
  private r NZu;
  private final String TAG;
  private final int bGt;
  
  public t(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76176);
    this.TAG = "MicroMsg.TipItemView";
    this.bGt = bd.fromDPToPix(paramContext, 32);
    this.NZe = new Matrix();
    setTextSize(getResources().getDimension(b.c.editor_tip_text_item_text_size));
    AppMethodBeat.o(76176);
  }
  
  private Bitmap c(r paramr)
  {
    AppMethodBeat.i(280295);
    s.u(paramr, "item");
    setSourceDataType(d.NYg);
    Object localObject = getContext();
    s.s(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    ((PhotoEditText)localObject).setPadding(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
    ((PhotoEditText)localObject).setTextColor(paramr.textColor);
    ((PhotoEditText)localObject).setTextBackground(paramr.NZt);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText(paramr.bba);
    ((PhotoEditText)localObject).setSingleLine(false);
    ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
    if ((paramr.NZt == 0) && (paramr.textColor != -16777216)) {
      com.tencent.mm.ae.d.h((TextView)localObject);
    }
    int i = this.bGt;
    paramr = e.NDU;
    if (i >= e.gGL().left)
    {
      paramr = e.NDU;
      i = e.gGL().width();
      j = this.bGt;
      paramr = e.NDU;
      i -= (j - e.gGL().left) * 2;
      ((PhotoEditText)localObject).setMaxWidth(i);
      ((PhotoEditText)localObject).measure(0, 0);
      if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
      {
        i = ((PhotoEditText)localObject).getMeasuredWidth();
        paramr = e.NDU;
        if (i <= e.gGL().width()) {
          break label414;
        }
      }
      paramr = e.NDU;
      i = e.gGL().width();
      label245:
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        j = ((PhotoEditText)localObject).getMeasuredHeight();
        paramr = e.NDU;
        if (j <= e.gGL().height()) {
          break label423;
        }
      }
      paramr = e.NDU;
    }
    label414:
    label423:
    for (int j = e.gGL().height();; j = ((PhotoEditText)localObject).getMeasuredHeight())
    {
      Log.i(this.TAG, "measuredWidth:" + ((PhotoEditText)localObject).getMeasuredWidth() + " , measuredHeight:" + ((PhotoEditText)localObject).getMeasuredHeight());
      paramr = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramr);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(getPaddingLeft(), getPaddingTop());
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      s.s(paramr, "bitmap");
      AppMethodBeat.o(280295);
      return paramr;
      paramr = e.NDU;
      i = e.gGL().width();
      break;
      i = ((PhotoEditText)localObject).getMeasuredWidth();
      break label245;
    }
  }
  
  public final void b(r paramr)
  {
    AppMethodBeat.i(280323);
    s.u(paramr, "item");
    setText(paramr);
    setViewMatrix(paramr.matrix);
    setSourceDataType(d.NYg);
    AppMethodBeat.o(280323);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c d(r paramr)
  {
    AppMethodBeat.i(280332);
    s.u(paramr, "item");
    paramr = new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(c(paramr), paramr.matrix);
    AppMethodBeat.o(280332);
    return paramr;
  }
  
  public final a dEP()
  {
    AppMethodBeat.i(280344);
    a locala = super.dEP();
    if (locala != null) {
      locala.b(d.NYg);
    }
    AppMethodBeat.o(280344);
    return locala;
  }
  
  public final a getEditorData()
  {
    AppMethodBeat.i(280337);
    Object localObject = this.NZu;
    if (localObject != null)
    {
      localObject = ((a)localObject).matrix;
      if (localObject != null) {
        ((Matrix)localObject).set(getTouchTracker().matrix);
      }
    }
    localObject = this.NZu;
    if (localObject != null) {
      ((r)localObject).b(d.NYg);
    }
    localObject = (a)this.NZu;
    AppMethodBeat.o(280337);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    return com.tencent.mm.plugin.recordvideo.ui.editor.view.b.OaF;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76172);
    s.u(paramMotionEvent, "event");
    this.NZe.set(getTouchTracker().matrix);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().matrix.set(this.NZe);
    AppMethodBeat.o(76172);
    return bool;
  }
  
  public final void setText(r paramr)
  {
    AppMethodBeat.i(280314);
    s.u(paramr, "item");
    this.NZu = paramr;
    setText(paramr.bba);
    Bitmap localBitmap = c(paramr);
    setSourceDataType(d.NYg);
    setColor(paramr.textColor);
    setTextBg(paramr.NZt);
    int i;
    float f2;
    float f3;
    float f4;
    if (paramr.CMB == 0)
    {
      i = paramr.CMB;
      setMarginBottom(i);
      setBitmap(localBitmap);
      paramr = getBitmap();
      if (paramr != null)
      {
        f2 = getValidRect().height() - bd.fromDPToPix(getContext(), 128) - bf.bk(getContext());
        f3 = getMarginBottom();
        f4 = paramr.getHeight();
        i = this.bGt;
        paramr = e.NDU;
        if (i < e.gGL().left) {
          break label206;
        }
      }
    }
    for (float f1 = this.bGt;; f1 = e.gGL().left)
    {
      getTouchTracker().matrix.setTranslate(f1, f2 - f3 - f4);
      postInvalidate();
      AppMethodBeat.o(280314);
      return;
      i = paramr.CMB + bd.fromDPToPix(getContext(), 24);
      break;
      label206:
      paramr = e.NDU;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.t
 * JD-Core Version:    0.7.0.1
 */