package com.tencent.mm.plugin.sns.cover.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverNoFadeImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onSizeChanged", "", "w", "", "h", "oldw", "oldh", "setImageBitmap", "bm", "Landroid/graphics/Bitmap;", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsCoverNoFadeImageView
  extends AppCompatImageView
{
  public static final a QlZ;
  
  static
  {
    AppMethodBeat.i(307486);
    QlZ = new a((byte)0);
    AppMethodBeat.o(307486);
  }
  
  public SnsCoverNoFadeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(307477);
    AppMethodBeat.o(307477);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(307500);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = getDrawable();
    if ((localObject instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)localObject;
      if (localObject != null) {
        break label60;
      }
    }
    label60:
    for (localObject = null;; localObject = ((BitmapDrawable)localObject).getBitmap())
    {
      if (localObject != null) {
        break label70;
      }
      AppMethodBeat.o(307500);
      return;
      localObject = null;
      break;
    }
    label70:
    if (((Bitmap)localObject).getHeight() * 1.0F / ((Bitmap)localObject).getWidth() > paramInt2 * 1.0F / paramInt1)
    {
      setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(307500);
      return;
    }
    setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(307500);
  }
  
  public final void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(307492);
    float f2 = 1.777778F;
    float f1 = f2;
    if (getWidth() > 0)
    {
      f1 = f2;
      if (getHeight() > 0) {
        f1 = getHeight() * 1.0F / getWidth();
      }
    }
    if (paramBitmap != null)
    {
      if (paramBitmap.getHeight() * 1.0F / paramBitmap.getWidth() < f1) {
        break label80;
      }
      setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    for (;;)
    {
      super.setImageBitmap(paramBitmap);
      AppMethodBeat.o(307492);
      return;
      label80:
      if (paramBitmap.getHeight() < paramBitmap.getWidth()) {
        break;
      }
      setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
    super.setImageBitmap(null);
    AppMethodBeat.o(307492);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/preview/SnsCoverNoFadeImageView$Companion;", "", "()V", "PREVIEW_RATIO", "", "TAG", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.preview.SnsCoverNoFadeImageView
 * JD-Core Version:    0.7.0.1
 */