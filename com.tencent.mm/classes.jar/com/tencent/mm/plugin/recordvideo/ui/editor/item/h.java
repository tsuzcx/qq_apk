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
import com.tencent.mm.media.editor.a.e;
import com.tencent.mm.plugin.recordvideo.background.f;
import com.tencent.mm.plugin.recordvideo.ui.editor.PhotoEditText;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TipItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MARGIN", "", "TAG", "", "originMatrix", "Landroid/graphics/Matrix;", "createBitmap", "Landroid/graphics/Bitmap;", "text", "", "textColor", "textBgColor", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditItemType;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowText", "", "marginBottom", "viewMatrix", "setText", "plugin-recordvideo_release"})
public final class h
  extends a
{
  private final int MARGIN;
  private final String TAG;
  private final Matrix vtt;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76176);
    this.TAG = "MicroMsg.TipItemView";
    this.MARGIN = ao.fromDPToPix(paramContext, 32);
    this.vtt = new Matrix();
    setTextSize(getResources().getDimension(2131166199));
    AppMethodBeat.o(76176);
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76173);
    Bitmap localBitmap = k(paramCharSequence, paramInt1, paramInt2);
    setText(paramCharSequence);
    setSourceDataType(e.goJ);
    setColor(paramInt1);
    setTextBg(paramInt2);
    float f2;
    float f3;
    float f4;
    if (paramInt3 == 0)
    {
      setMarginBottom(paramInt3);
      setBitmap(localBitmap);
      paramCharSequence = getBitmap();
      if (paramCharSequence != null)
      {
        f2 = getValidRect().height() - ao.fromDPToPix(getContext(), 128) - ap.eb(getContext());
        f3 = getMarginBottom();
        f4 = paramCharSequence.getHeight();
        paramInt1 = this.MARGIN;
        paramCharSequence = f.vdH;
        if (paramInt1 < f.dgJ().left) {
          break label178;
        }
      }
    }
    for (float f1 = this.MARGIN;; f1 = f.dgJ().left)
    {
      getTouchTracker().dY.setTranslate(f1, f2 - f3 - f4);
      postInvalidate();
      AppMethodBeat.o(76173);
      return;
      paramInt3 += ao.fromDPToPix(getContext(), 24);
      break;
      label178:
      paramCharSequence = f.vdH;
    }
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, Matrix paramMatrix)
  {
    AppMethodBeat.i(76174);
    k.h(paramMatrix, "viewMatrix");
    a(paramCharSequence, paramInt1, paramInt2, paramInt3);
    setViewMatrix(paramMatrix);
    setSourceDataType(e.goJ);
    AppMethodBeat.o(76174);
  }
  
  public final b getType()
  {
    return b.vsL;
  }
  
  public final Bitmap k(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76175);
    setSourceDataType(e.goJ);
    Object localObject = getContext();
    k.g(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    ((PhotoEditText)localObject).setPadding(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
    ((PhotoEditText)localObject).setTextColor(paramInt1);
    ((PhotoEditText)localObject).setTextBackground(paramInt2);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText(paramCharSequence);
    ((PhotoEditText)localObject).setSingleLine(false);
    ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
    if ((paramInt2 == 0) && (paramInt1 != -16777216)) {
      com.tencent.mm.ad.c.e((TextView)localObject);
    }
    paramInt1 = this.MARGIN;
    paramCharSequence = f.vdH;
    if (paramInt1 >= f.dgJ().left)
    {
      paramCharSequence = f.vdH;
      paramInt1 = f.dgJ().width();
      paramInt2 = this.MARGIN;
      paramCharSequence = f.vdH;
      paramInt1 -= (paramInt2 - f.dgJ().left) * 2;
      ((PhotoEditText)localObject).setMaxWidth(paramInt1);
      ((PhotoEditText)localObject).measure(0, 0);
      if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
      {
        paramInt1 = ((PhotoEditText)localObject).getMeasuredWidth();
        paramCharSequence = f.vdH;
        if (paramInt1 <= f.dgJ().width()) {
          break label395;
        }
      }
      paramCharSequence = f.vdH;
      paramInt1 = f.dgJ().width();
      label224:
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        paramInt2 = ((PhotoEditText)localObject).getMeasuredHeight();
        paramCharSequence = f.vdH;
        if (paramInt2 <= f.dgJ().height()) {
          break label404;
        }
      }
      paramCharSequence = f.vdH;
    }
    label395:
    label404:
    for (paramInt2 = f.dgJ().height();; paramInt2 = ((PhotoEditText)localObject).getMeasuredHeight())
    {
      ad.i(this.TAG, "measuredWidth:" + ((PhotoEditText)localObject).getMeasuredWidth() + " , measuredHeight:" + ((PhotoEditText)localObject).getMeasuredHeight());
      paramCharSequence = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramCharSequence);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(getPaddingLeft(), getPaddingTop());
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      k.g(paramCharSequence, "bitmap");
      AppMethodBeat.o(76175);
      return paramCharSequence;
      paramCharSequence = f.vdH;
      paramInt1 = f.dgJ().width();
      break;
      paramInt1 = ((PhotoEditText)localObject).getMeasuredWidth();
      break label224;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76172);
    k.h(paramMotionEvent, "event");
    this.vtt.set(getTouchTracker().dY);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().dY.set(this.vtt);
    AppMethodBeat.o(76172);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.h
 * JD-Core Version:    0.7.0.1
 */