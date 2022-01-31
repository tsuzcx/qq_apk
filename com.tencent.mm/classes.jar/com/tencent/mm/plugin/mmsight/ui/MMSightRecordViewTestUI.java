package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.plugin.u.a.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;

public class MMSightRecordViewTestUI
  extends MMActivity
{
  private int fwP = 720;
  private float fwQ = 0.67F;
  private MMSightRecordView goJ;
  
  protected final int getLayoutId()
  {
    return a.f.mmsight_record_view_testui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new MMSightRecordViewTestUI.1(this));
    this.goJ = ((MMSightRecordView)findViewById(a.e.record_view));
    this.goJ.setDisplayRatio(this.fwQ);
    this.goJ.setPreviewSizeLimit(this.fwP);
    this.goJ.setVideoPara$2e715812(100000);
    this.goJ.setVideoFilePath(e.bkH + "mmsighttest.mp4");
    this.goJ.setClipPictureSize(true);
    this.goJ.setClipVideoSize(true);
    this.goJ.mfG.Zd();
    this.goJ.setFlashMode(3);
    this.goJ.setFrameDataCallback(new MMSightRecordViewTestUI.2(this));
    this.goJ.mfG.startPreview();
    this.goJ.mfG.YY();
    findViewById(a.e.take_picture_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).a(new MMSightRecordViewTestUI.3.1(this), true);
      }
    });
    findViewById(a.e.start_record_btn).setOnClickListener(new MMSightRecordViewTestUI.4(this));
    ai.l(new Runnable()
    {
      public final void run()
      {
        this.mpc.setText("");
        this.mpc.append(String.format("picture size: %s, ratio: %s\n", new Object[] { MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize(), Float.valueOf(Math.min(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize().x, MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize().y) / Math.max(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize().x, MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize().y)) }));
        this.mpc.append(String.format("video size: %s, ratio: %s\n", new Object[] { MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize(), Float.valueOf(Math.min(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize().x, MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize().y) / Math.max(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize().x, MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize().y)) }));
        this.mpc.append(String.format("preview size limit: %s\n", new Object[] { Integer.valueOf(MMSightRecordViewTestUI.b(MMSightRecordViewTestUI.this)) }));
        this.mpc.append(String.format("display ratio: %s\n", new Object[] { Float.valueOf(MMSightRecordViewTestUI.c(MMSightRecordViewTestUI.this)) }));
        this.mpc.append(String.format("view size: %s, ratio: %s\n", new Object[] { new Point(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getWidth(), MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getHeight()), Float.valueOf(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getWidth() / MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getHeight()) }));
      }
    }, 1000L);
    findViewById(a.e.switch_camera_btn).setOnClickListener(new MMSightRecordViewTestUI.6(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.goJ.mfG.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI
 * JD-Core Version:    0.7.0.1
 */