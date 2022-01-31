package com.tencent.mm.plugin.mmsight.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;

public class MMSightRecordViewTestUI
  extends MMActivity
{
  private int gNQ = 720;
  private float gNS = 0.67F;
  private MMSightRecordView hIG;
  
  public int getLayoutId()
  {
    return 2130970286;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55125);
    super.onCreate(paramBundle);
    setBackBtn(new MMSightRecordViewTestUI.1(this));
    this.hIG = ((MMSightRecordView)findViewById(2131826292));
    this.hIG.setDisplayRatio(this.gNS);
    this.hIG.setPreviewSizeLimit(this.gNQ);
    this.hIG.setVideoPara$2e715812(100000);
    this.hIG.setVideoFilePath(e.eQz + "mmsighttest.mp4");
    this.hIG.setClipPictureSize(true);
    this.hIG.setClipVideoSize(true);
    this.hIG.oGg.asM();
    this.hIG.setFlashMode(3);
    this.hIG.setFrameDataCallback(new MMSightRecordViewTestUI.2(this));
    this.hIG.oGg.startPreview();
    this.hIG.oGg.asH();
    findViewById(2131826293).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55119);
        MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).a(new MMSightRecordViewTestUI.3.1(this), true);
        AppMethodBeat.o(55119);
      }
    });
    findViewById(2131826294).setOnClickListener(new MMSightRecordViewTestUI.4(this));
    al.p(new MMSightRecordViewTestUI.5(this, (TextView)findViewById(2131826291)), 1000L);
    findViewById(2131826295).setOnClickListener(new MMSightRecordViewTestUI.6(this));
    AppMethodBeat.o(55125);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55126);
    super.onDestroy();
    this.hIG.oGg.release();
    AppMethodBeat.o(55126);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI
 * JD-Core Version:    0.7.0.1
 */