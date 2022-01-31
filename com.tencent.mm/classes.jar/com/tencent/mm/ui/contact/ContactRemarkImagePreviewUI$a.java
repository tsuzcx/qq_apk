package com.tencent.mm.ui.contact;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class ContactRemarkImagePreviewUI$a
  extends BaseAdapter
{
  String imagePath;
  
  ContactRemarkImagePreviewUI$a(ContactRemarkImagePreviewUI paramContactRemarkImagePreviewUI) {}
  
  public final int getCount()
  {
    return 1;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.imagePath;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33618);
    paramView = View.inflate(this.AbP, 2130969267, null);
    paramViewGroup = (MultiTouchImageView)paramView.findViewById(2131820629);
    paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
    paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    Bitmap localBitmap = BackwardSupportUtil.b.k(this.imagePath, a.getDensity(this.AbP));
    int i;
    Matrix localMatrix;
    if (localBitmap != null)
    {
      paramInt = ContactRemarkImagePreviewUI.e(this.AbP).getWidth();
      i = ContactRemarkImagePreviewUI.e(this.AbP).getHeight();
      localMatrix = new Matrix();
      localMatrix.reset();
      f1 = localBitmap.getWidth() / localBitmap.getHeight();
      f2 = localBitmap.getHeight() / localBitmap.getWidth();
      ab.v("MicroMsg.ImagePreviewUI", "whDiv is " + f1 + " hwDiv is " + f2);
      if ((f2 < 2.0F) || (localBitmap.getHeight() < 480)) {
        break label318;
      }
      f1 = localBitmap.getWidth() / paramInt;
      f2 = paramInt / localBitmap.getWidth();
      if (f1 <= 1.0D) {
        break label290;
      }
      localMatrix.postScale(f2, f2);
      localBitmap.getHeight();
      localMatrix.postTranslate((paramInt - f2 * localBitmap.getWidth()) / 2.0F, 0.0F);
    }
    for (;;)
    {
      paramViewGroup.setImageMatrix(localMatrix);
      paramViewGroup.cb(localBitmap.getWidth(), localBitmap.getHeight());
      paramViewGroup.setImageBitmap(localBitmap);
      AppMethodBeat.o(33618);
      return paramView;
      label290:
      localMatrix.postScale(1.0F, 1.0F);
      localMatrix.postTranslate((paramInt - localBitmap.getWidth()) / 2, 0.0F);
      continue;
      label318:
      if ((f1 < 2.0F) || (localBitmap.getWidth() < 480)) {
        break;
      }
      f1 = localBitmap.getHeight() / 480.0F;
      f2 = 480.0F / localBitmap.getHeight();
      if (f1 > 1.0D)
      {
        localMatrix.postScale(f1, f2);
        localMatrix.postTranslate(0.0F, (i - 480) / 2);
      }
      else
      {
        localMatrix.postScale(1.0F, 1.0F);
        f1 = (i - localBitmap.getHeight()) / 2;
        ab.d("MicroMsg.ImagePreviewUI", " offsety ".concat(String.valueOf(f1)));
        localMatrix.postTranslate(0.0F, f1);
      }
    }
    float f1 = paramInt / localBitmap.getWidth();
    float f2 = i / localBitmap.getHeight();
    label474:
    float f3;
    if (f1 < f2)
    {
      f2 = localBitmap.getWidth() / paramInt;
      f3 = localBitmap.getHeight() / i;
      if (f2 <= f3) {
        break label568;
      }
      label505:
      if (f2 <= 1.0D) {
        break label575;
      }
      localMatrix.postScale(f1, f1);
    }
    for (;;)
    {
      localMatrix.postTranslate((paramInt - localBitmap.getWidth() * f1) / 2.0F, (i - f1 * localBitmap.getHeight()) / 2.0F);
      break;
      f1 = f2;
      break label474;
      label568:
      f2 = f3;
      break label505;
      label575:
      f1 = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.a
 * JD-Core Version:    0.7.0.1
 */