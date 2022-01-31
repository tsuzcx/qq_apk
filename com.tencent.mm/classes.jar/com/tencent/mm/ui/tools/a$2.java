package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.h;

final class a$2
  extends AsyncTask<Integer, Integer, Integer>
{
  private ProgressDialog Aqr;
  private boolean Aqs;
  private String filePath;
  private Uri uri;
  
  a$2(Intent paramIntent1, Activity paramActivity, String paramString, a.a parama, Intent paramIntent2, int paramInt) {}
  
  private Integer dNE()
  {
    AppMethodBeat.i(107593);
    try
    {
      Object localObject = this.uri;
      if (localObject == null)
      {
        AppMethodBeat.o(107593);
        return null;
      }
      localObject = d.n(this.uri);
      this.filePath = a.v(this.Aqu, (Bitmap)localObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AsyncObtainImage", localException, "doInBackground", new Object[0]);
      }
    }
    AppMethodBeat.o(107593);
    return null;
  }
  
  protected final void onPreExecute()
  {
    AppMethodBeat.i(107592);
    try
    {
      this.uri = this.val$data.getData();
      this.Aqs = false;
      Activity localActivity = this.Aqx;
      this.Aqx.getString(2131297087);
      this.Aqr = h.b(localActivity, this.Aqx.getString(2131296972), true, new a.2.1(this));
      AppMethodBeat.o(107592);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AsyncObtainImage", localException, "onPreExecute", new Object[0]);
      AppMethodBeat.o(107592);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.a.2
 * JD-Core Version:    0.7.0.1
 */