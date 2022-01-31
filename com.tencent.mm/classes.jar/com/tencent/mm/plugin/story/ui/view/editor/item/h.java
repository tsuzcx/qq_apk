package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
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
import com.tencent.mm.ab.b;
import com.tencent.mm.media.editor.a.e;
import com.tencent.mm.media.editor.c.c;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.ui.view.editor.PhotoEditText;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.al;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/item/TipItemView;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MARGIN", "", "TAG", "", "originMatrix", "Landroid/graphics/Matrix;", "validRect", "Landroid/graphics/Rect;", "createBitmap", "Landroid/graphics/Bitmap;", "text", "", "textColor", "textBgColor", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowText", "", "marginBottom", "viewMatrix", "setText", "setValidArea", "heightPercent", "", "plugin-story_release"})
public final class h
  extends a
{
  private final int MARGIN;
  private final String TAG;
  private final Matrix sRa;
  private Rect sRc;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(151300);
    this.TAG = "MicroMsg.TipItemView";
    this.MARGIN = al.fromDPToPix(paramContext, 32);
    this.sRc = new Rect();
    this.sRa = new Matrix();
    setTextSize(getResources().getDimension(2131428346));
    AppMethodBeat.o(151300);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(151296);
    j.q(paramRect, "validRect");
    this.sRc.set(paramRect);
    AppMethodBeat.o(151296);
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, Matrix paramMatrix)
  {
    AppMethodBeat.i(151298);
    j.q(paramMatrix, "viewMatrix");
    b(paramCharSequence, paramInt1, paramInt2, paramInt3);
    setViewMatrix(paramMatrix);
    setSourceDataType(e.eSF);
    AppMethodBeat.o(151298);
  }
  
  public final void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(151297);
    Bitmap localBitmap = k(paramCharSequence, paramInt1, paramInt2);
    setText(paramCharSequence);
    setSourceDataType(e.eSF);
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
        f2 = this.sRc.height() - al.fromDPToPix(getContext(), 128) - getNavigateBarHeight();
        f3 = getMarginBottom();
        f4 = paramCharSequence.getHeight();
        paramInt1 = this.MARGIN;
        paramCharSequence = k.sCp;
        if (paramInt1 < k.cCr().left) {
          break label175;
        }
      }
    }
    for (float f1 = this.MARGIN;; f1 = k.cCr().left)
    {
      getTouchTracker().asO.setTranslate(f1, f2 - f3 - f4);
      postInvalidate();
      AppMethodBeat.o(151297);
      return;
      paramInt3 += al.fromDPToPix(getContext(), 24);
      break;
      label175:
      paramCharSequence = k.sCp;
    }
  }
  
  public final Bitmap k(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151299);
    setSourceDataType(e.eSF);
    Object localObject = getContext();
    j.p(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    ((PhotoEditText)localObject).setPadding(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingTop());
    ((PhotoEditText)localObject).setTextColor(paramInt1);
    ((PhotoEditText)localObject).setTextBackground(paramInt2);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText(paramCharSequence);
    ((PhotoEditText)localObject).setSingleLine(false);
    ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
    if ((paramInt2 == 0) && (paramInt1 != -16777216)) {
      b.e((TextView)localObject);
    }
    paramInt1 = this.MARGIN;
    paramCharSequence = k.sCp;
    if (paramInt1 >= k.cCr().left)
    {
      paramCharSequence = k.sCp;
      paramInt1 = k.cCr().width();
      paramInt2 = this.MARGIN;
      paramCharSequence = k.sCp;
      paramInt1 -= (paramInt2 - k.cCr().left) * 2;
      ((PhotoEditText)localObject).setMaxWidth(paramInt1);
      ((PhotoEditText)localObject).measure(0, 0);
      if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
      {
        paramInt1 = ((PhotoEditText)localObject).getMeasuredWidth();
        paramCharSequence = k.sCp;
        if (paramInt1 <= k.cCr().width()) {
          break label395;
        }
      }
      paramCharSequence = k.sCp;
      paramInt1 = k.cCr().width();
      label224:
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        paramInt2 = ((PhotoEditText)localObject).getMeasuredHeight();
        paramCharSequence = k.sCp;
        if (paramInt2 <= k.cCr().height()) {
          break label404;
        }
      }
      paramCharSequence = k.sCp;
    }
    label395:
    label404:
    for (paramInt2 = k.cCr().height();; paramInt2 = ((PhotoEditText)localObject).getMeasuredHeight())
    {
      ab.i(this.TAG, "measuredWidth:" + ((PhotoEditText)localObject).getMeasuredWidth() + " , measuredHeight:" + ((PhotoEditText)localObject).getMeasuredHeight());
      paramCharSequence = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramCharSequence);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(getPaddingLeft(), getPaddingTop());
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      j.p(paramCharSequence, "bitmap");
      AppMethodBeat.o(151299);
      return paramCharSequence;
      paramCharSequence = k.sCp;
      paramInt1 = k.cCr().width();
      break;
      paramInt1 = ((PhotoEditText)localObject).getMeasuredWidth();
      break label224;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(151295);
    j.q(paramMotionEvent, "event");
    this.sRa.set(getTouchTracker().asO);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    getTouchTracker().asO.set(this.sRa);
    AppMethodBeat.o(151295);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.h
 * JD-Core Version:    0.7.0.1
 */