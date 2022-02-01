package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.text.Layout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.PhotoEditText;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItemView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "createBitmap", "Landroid/graphics/Bitmap;", "text", "", "textColor", "", "textBgColor", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditItemType;", "initScale", "", "sx", "", "sy", "reshowText", "viewMatrix", "Landroid/graphics/Matrix;", "setText", "plugin-recordvideo_release"})
public final class g
  extends a
{
  private final String TAG;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76171);
    this.TAG = "MicroMsg.TextItemView";
    setTextSize(getResources().getDimension(2131166195));
    AppMethodBeat.o(76171);
  }
  
  public final void Y(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(76167);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      getTouchTracker().eY.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(76167);
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, Matrix paramMatrix)
  {
    AppMethodBeat.i(76169);
    k.h(paramMatrix, "viewMatrix");
    setText(paramCharSequence, paramInt1, paramInt2);
    setViewMatrix(paramMatrix);
    setSourceDataType(e.gPo);
    AppMethodBeat.o(76169);
  }
  
  public final b getType()
  {
    return b.wCK;
  }
  
  public final Bitmap l(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76170);
    setSourceDataType(e.gPo);
    Object localObject = getContext();
    k.g(localObject, "context");
    localObject = new PhotoEditText((Context)localObject);
    int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 16);
    int j = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    ((PhotoEditText)localObject).setPadding(i, j, i, j);
    ((PhotoEditText)localObject).setTextColor(paramInt1);
    ((PhotoEditText)localObject).setTextBackground(paramInt2);
    ((PhotoEditText)localObject).setTextSize(0, getTextSize());
    ((PhotoEditText)localObject).setText(paramCharSequence);
    ((PhotoEditText)localObject).setSingleLine(false);
    ((PhotoEditText)localObject).setTypeface(((PhotoEditText)localObject).getTypeface(), 1);
    if ((paramInt2 == 0) && (paramInt1 != -16777216)) {
      com.tencent.mm.ac.c.e((TextView)localObject);
    }
    paramCharSequence = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    paramInt1 = com.tencent.mm.plugin.recordvideo.background.g.dur().width();
    if (paramInt1 > 0) {
      ((PhotoEditText)localObject).setMaxWidth(paramInt1);
    }
    ((PhotoEditText)localObject).measure(0, 0);
    if (((PhotoEditText)localObject).getMeasuredWidth() > 0)
    {
      paramInt1 = ((PhotoEditText)localObject).getMeasuredWidth();
      paramCharSequence = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      if (paramInt1 <= com.tencent.mm.plugin.recordvideo.background.g.dur().width()) {}
    }
    else
    {
      paramCharSequence = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      paramInt1 = com.tencent.mm.plugin.recordvideo.background.g.dur().width();
      if (((PhotoEditText)localObject).getMeasuredHeight() > 0)
      {
        paramInt2 = ((PhotoEditText)localObject).getMeasuredHeight();
        paramCharSequence = com.tencent.mm.plugin.recordvideo.background.g.wmx;
        if (paramInt2 <= com.tencent.mm.plugin.recordvideo.background.g.dur().height()) {
          break label361;
        }
      }
      paramCharSequence = com.tencent.mm.plugin.recordvideo.background.g.wmx;
      paramInt2 = com.tencent.mm.plugin.recordvideo.background.g.dur().height();
      label240:
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        break label370;
      }
      ac.w(this.TAG, "create bitmap size error: " + paramInt1 + ", " + paramInt2);
    }
    label361:
    label370:
    for (paramCharSequence = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; paramCharSequence = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas(paramCharSequence);
      ((PhotoEditText)localObject).draw(localCanvas);
      localCanvas.save();
      localCanvas.translate(i, j);
      ((PhotoEditText)localObject).getLayout().draw(localCanvas);
      localCanvas.restore();
      k.g(paramCharSequence, "bitmap");
      AppMethodBeat.o(76170);
      return paramCharSequence;
      paramInt1 = ((PhotoEditText)localObject).getMeasuredWidth();
      break;
      paramInt2 = ((PhotoEditText)localObject).getMeasuredHeight();
      break label240;
    }
  }
  
  public final void setText(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76168);
    Bitmap localBitmap = l(paramCharSequence, paramInt1, paramInt2);
    setText(paramCharSequence);
    setSourceDataType(e.gPo);
    setColor(paramInt1);
    setTextBg(paramInt2);
    if (getBitmap() == null) {
      getTouchTracker().eY.postTranslate(-getWidth() / 2.0F, -((getDisplayRect().top + getDisplayRect().bottom) / 2 - (getValidRect().top + getValidRect().bottom) / 2.0F + getHeight() / 2.0F));
    }
    paramCharSequence = getBitmap();
    if (paramCharSequence != null) {
      getTouchTracker().eY.preTranslate(paramCharSequence.getWidth() / 2.0F, paramCharSequence.getHeight() / 2.0F);
    }
    setBitmap(localBitmap);
    postInvalidate();
    AppMethodBeat.o(76168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.g
 * JD-Core Version:    0.7.0.1
 */