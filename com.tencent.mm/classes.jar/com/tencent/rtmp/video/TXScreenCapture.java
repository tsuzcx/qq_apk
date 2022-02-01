package com.tencent.rtmp.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

public class TXScreenCapture
{
  public static class TXScreenCaptureAssistantActivity
    extends HellActivity
  {
    @TargetApi(21)
    public void Start()
    {
      AppMethodBeat.i(13942);
      Intent localIntent1 = (Intent)getIntent().getParcelableExtra("TXScreenCapture.ScreenCaptureIntent");
      try
      {
        startActivityForResult(localIntent1, 1001);
        AppMethodBeat.o(13942);
        return;
      }
      catch (Exception localException)
      {
        Intent localIntent2 = new Intent("TXScreenCapture.OnAssistantActivityResult");
        localIntent2.putExtra("TXScreenCapture.RequestCode", 1001);
        localIntent2.putExtra("TXScreenCapture.ResultCode", 20000002);
        sendBroadcast(localIntent2);
        finish();
        AppMethodBeat.o(13942);
      }
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(13943);
      Intent localIntent = new Intent("TXScreenCapture.OnAssistantActivityResult");
      localIntent.putExtra("TXScreenCapture.RequestCode", paramInt1);
      localIntent.putExtra("TXScreenCapture.ResultCode", paramInt2);
      localIntent.putExtra("TXScreenCapture.ResultData", paramIntent);
      sendBroadcast(localIntent);
      finish();
      AppMethodBeat.o(13943);
    }
    
    public void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(13941);
      super.onCreate(paramBundle);
      requestWindowFeature(1);
      Start();
      AppMethodBeat.o(13941);
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      AppMethodBeat.at(this, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.rtmp.video.TXScreenCapture
 * JD-Core Version:    0.7.0.1
 */