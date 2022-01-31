package com.tencent.mm.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class CropImageNewUI$4
  implements View.OnClickListener
{
  CropImageNewUI$4(CropImageNewUI paramCropImageNewUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = CropImageNewUI.j(this.vYH);
    if (paramView.kJz == null)
    {
      y.w("MicroMsg.CropImageView", "rotate not done! cause: btmp is null!");
      return;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (paramView.kJz.getWidth() / 2);
    arrayOfFloat[1] = (paramView.kJz.getHeight() / 2);
    paramView.getImageMatrix().mapPoints(arrayOfFloat);
    paramView.getImageMatrix().postRotate(90.0F, arrayOfFloat[0], arrayOfFloat[1]);
    paramView.setImageBitmap(paramView.kJz);
    paramView.invalidate();
    paramView.bQN += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI.4
 * JD-Core Version:    0.7.0.1
 */