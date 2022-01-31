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
import android.graphics.RectF;
import android.text.Layout;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.e;
import com.tencent.mm.media.editor.c.c;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.ui.view.editor.PhotoEditText;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/item/TextItemView;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createBitmap", "Landroid/graphics/Bitmap;", "text", "", "textColor", "", "textBgColor", "initScale", "", "sx", "", "sy", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "reshowText", "viewMatrix", "Landroid/graphics/Matrix;", "setText", "setValidArea", "validRect", "Landroid/graphics/Rect;", "heightPercent", "plugin-story_release"})
public final class g
  extends a
{
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(110697);
    setTextSize(getResources().getDimension(2131428342));
    AppMethodBeat.o(110697);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(151292);
    j.q(paramRect, "validRect");
    getTouchTracker().asO.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    AppMethodBeat.o(151292);
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, Matrix paramMatrix)
  {
    AppMethodBeat.i(110695);
    j.q(paramMatrix, "viewMatrix");
    setText(paramCharSequence, paramInt1, paramInt2);
    setViewMatrix(paramMatrix);
    setSourceDataType(e.eSC);
    AppMethodBeat.o(110695);
  }
  
  public final void ai(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(151293);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      getTouchTracker().asO.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(151293);
  }
  
  public final Bitmap k(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110696);
    setSourceDataType(e.eSC);
    Object localObject = getContext();
    j.p(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    ((PhotoEditText)localObject).setPadding(i, j, i, j);
    ((PhotoEditText)localObject).setTextColor(paramInt1);
    ((PhotoEditText)localObject).setTextBackground(paramInt2);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText(paramCharSequence);
    ((PhotoEditText)localObject).setSingleLine(false);
    ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
    if ((paramInt2 == 0) && (paramInt1 != -16777216)) {
      com.tencent.mm.ab.b.e((TextView)localObject);
    }
    paramCharSequence = k.sCp;
    paramInt1 = k.cCr().width();
    if (paramInt1 > 0) {
      ((PhotoEditText)localObject).setMaxWidth(paramInt1);
    }
    ((PhotoEditText)localObject).measure(0, 0);
    if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
    {
      paramInt1 = ((PhotoEditText)localObject).getMeasuredWidth();
      paramCharSequence = k.sCp;
      if (paramInt1 <= k.cCr().width()) {}
    }
    else
    {
      paramCharSequence = k.sCp;
      paramInt1 = k.cCr().width();
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        paramInt2 = ((PhotoEditText)localObject).getMeasuredHeight();
        paramCharSequence = k.sCp;
        if (paramInt2 <= k.cCr().height()) {
          break label320;
        }
      }
      paramCharSequence = k.sCp;
    }
    label320:
    for (paramInt2 = k.cCr().height();; paramInt2 = ((PhotoEditText)localObject).getMeasuredHeight())
    {
      paramCharSequence = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramCharSequence);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(i, j);
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      j.p(paramCharSequence, "bitmap");
      AppMethodBeat.o(110696);
      return paramCharSequence;
      paramInt1 = ((PhotoEditText)localObject).getMeasuredWidth();
      break;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(151294);
    j.q(paramMotionEvent, "event");
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getActionMasked() == 1)
    {
      paramMotionEvent = new com.tencent.mm.media.editor.c.a();
      Object localObject = k.sCp;
      localObject = k.cCr();
      paramMotionEvent.arK = getTouchTracker().arK;
      paramMotionEvent.arJ = getTouchTracker().arJ;
      paramMotionEvent.g(new float[] { getTouchTracker().width / 2.0F, getTouchTracker().height / 2.0F });
      paramMotionEvent.b(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
      paramMotionEvent.a(getTouchTracker().asO, (a.f.a.b)new g.a(this));
    }
    AppMethodBeat.o(151294);
    return bool;
  }
  
  public final void setText(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110694);
    Bitmap localBitmap = k(paramCharSequence, paramInt1, paramInt2);
    setText(paramCharSequence);
    setSourceDataType(e.eSC);
    setColor(paramInt1);
    setTextBg(paramInt2);
    paramCharSequence = getBitmap();
    if (paramCharSequence != null) {
      getTouchTracker().asO.preTranslate(paramCharSequence.getWidth() / 2.0F, paramCharSequence.getHeight() / 2.0F);
    }
    setBitmap(localBitmap);
    postInvalidate();
    AppMethodBeat.o(110694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.g
 * JD-Core Version:    0.7.0.1
 */