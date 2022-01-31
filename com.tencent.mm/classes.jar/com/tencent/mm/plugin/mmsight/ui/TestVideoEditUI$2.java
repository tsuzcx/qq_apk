package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.api.m;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

final class TestVideoEditUI$2
  implements m
{
  TestVideoEditUI$2(TestVideoEditUI paramTestVideoEditUI) {}
  
  public final void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    y.i("MicroMsg.TestVideoEditUI", "[onSuccess] w:%s h:%s", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    String str = e.dzC + String.format("%s%d.%s", new Object[] { "wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), "png" });
    try
    {
      c.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, str, true);
      return;
    }
    catch (IOException paramBitmap) {}
  }
  
  public final void b(Exception paramException) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI.2
 * JD-Core Version:    0.7.0.1
 */