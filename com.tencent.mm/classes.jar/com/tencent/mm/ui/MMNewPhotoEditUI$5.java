package com.tencent.mm.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.mm.api.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class MMNewPhotoEditUI$5
  implements m
{
  MMNewPhotoEditUI$5(MMNewPhotoEditUI paramMMNewPhotoEditUI, int paramInt) {}
  
  public final void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    y.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] w:%s h:%s", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    String str;
    try
    {
      str = q.pd("jpg");
      c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, str, true);
      y.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] photoPath:%s", new Object[] { str });
      if ((MMNewPhotoEditUI.c(this.uOz)) || (this.val$index == 2)) {
        q.a(str, this.uOz);
      }
      if ((this.val$index != 0) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      MMNewPhotoEditUI.a(this.uOz, str);
      if ((MMNewPhotoEditUI.d(this.uOz) != 291) && (MMNewPhotoEditUI.d(this.uOz) != 293)) {
        break label314;
      }
      if (this.val$index == 0)
      {
        MMNewPhotoEditUI.b(this.uOz, str);
        MMNewPhotoEditUI.b(this.uOz);
        MMNewPhotoEditUI.b(this.uOz, 1);
        return;
      }
      if (this.val$index == 1)
      {
        MMNewPhotoEditUI.c(this.uOz, str);
        MMNewPhotoEditUI.b(this.uOz, 2);
        Toast.makeText(this.uOz.mController.uMN, this.uOz.getString(ag.d.fav_edit_photo_successfully), 1).show();
        MMNewPhotoEditUI.b(this.uOz);
        this.uOz.finish();
        return;
      }
    }
    catch (IOException paramBitmap)
    {
      b(paramBitmap);
      return;
    }
    if (this.val$index == 2)
    {
      Toast.makeText(this.uOz.mController.uMN, this.uOz.getString(ag.d.exports_saved, new Object[] { e.dzD }), 1).show();
      MMNewPhotoEditUI.b(this.uOz, 3);
      MMNewPhotoEditUI.b(this.uOz);
      this.uOz.finish();
      return;
      label314:
      MMNewPhotoEditUI.d(this.uOz, str);
    }
  }
  
  public final void b(Exception paramException)
  {
    MMNewPhotoEditUI.b(this.uOz);
    y.e("MicroMsg.MMNewPhotoEditUI", "[onRefreshed] %s", new Object[] { paramException });
    Toast.makeText(this.uOz, this.uOz.getResources().getString(ag.d.err_save_edit_photo), 1).show();
    this.uOz.setResult(0);
    this.uOz.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MMNewPhotoEditUI.5
 * JD-Core Version:    0.7.0.1
 */