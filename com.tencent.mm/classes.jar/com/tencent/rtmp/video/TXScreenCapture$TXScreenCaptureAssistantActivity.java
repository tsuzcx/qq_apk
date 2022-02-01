package com.tencent.rtmp.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.screencapture.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;

@TargetApi(21)
public class TXScreenCapture$TXScreenCaptureAssistantActivity
  extends HellActivity
{
  private static final int REQUEST_CODE = 100;
  private static final String TAG = "TXScreenCaptureAssistantActivity";
  private MediaProjectionManager mMediaProjectionManager;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13943);
    TXCLog.i("TXScreenCaptureAssistantActivity", "onActivityResult ".concat(String.valueOf(this)));
    paramIntent = this.mMediaProjectionManager.getMediaProjection(paramInt2, paramIntent);
    c.a(this).a(paramIntent);
    finish();
    AppMethodBeat.o(13943);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13941);
    super.onCreate(paramBundle);
    TXCLog.i("TXScreenCaptureAssistantActivity", "onCreate ".concat(String.valueOf(this)));
    requestWindowFeature(1);
    this.mMediaProjectionManager = ((MediaProjectionManager)getApplicationContext().getSystemService("media_projection"));
    paramBundle = this.mMediaProjectionManager.createScreenCaptureIntent();
    try
    {
      startActivityForResult(paramBundle, 100);
      AppMethodBeat.o(13941);
      return;
    }
    catch (Exception paramBundle)
    {
      TXCLog.e("TXScreenCaptureAssistantActivity", "start permission activity failed. ".concat(String.valueOf(paramBundle)));
      c.a(this).a(null);
      finish();
      AppMethodBeat.o(13941);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(218814);
    super.onDestroy();
    TXCLog.i("TXScreenCaptureAssistantActivity", "onDestroy ".concat(String.valueOf(this)));
    AppMethodBeat.o(218814);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.video.TXScreenCapture.TXScreenCaptureAssistantActivity
 * JD-Core Version:    0.7.0.1
 */