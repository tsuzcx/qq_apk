package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class a$2
  extends AsyncTask<Integer, Integer, Integer>
{
  private String filePath;
  private Uri uri;
  private ProgressDialog vYf;
  private boolean vYg;
  
  a$2(Intent paramIntent1, Activity paramActivity, String paramString, a.a parama, Intent paramIntent2, int paramInt) {}
  
  private Integer cIQ()
  {
    try
    {
      if (this.uri == null) {
        return null;
      }
      Bitmap localBitmap = c.l(this.uri);
      this.filePath = a.t(this.vYi, localBitmap);
      return null;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.AsyncObtainImage", localException, "doInBackground", new Object[0]);
    }
    return null;
  }
  
  protected final void onPreExecute()
  {
    try
    {
      this.uri = this.hSF.getData();
      this.vYg = false;
      Activity localActivity = this.vYl;
      this.vYl.getString(a.k.app_tip);
      this.vYf = h.b(localActivity, this.vYl.getString(a.k.app_getting_img), true, new a.2.1(this));
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.AsyncObtainImage", localException, "onPreExecute", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.a.2
 * JD-Core Version:    0.7.0.1
 */