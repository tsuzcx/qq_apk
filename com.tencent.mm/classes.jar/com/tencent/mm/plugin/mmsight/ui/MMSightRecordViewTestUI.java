package com.tencent.mm.plugin.mmsight.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;

public class MMSightRecordViewTestUI
  extends MMActivity
{
  private float ilP = 0.67F;
  private int kyq = 720;
  private MMSightRecordView lPv;
  
  public int getLayoutId()
  {
    return 2131495658;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94565);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(94557);
        MMSightRecordViewTestUI.this.finish();
        AppMethodBeat.o(94557);
        return false;
      }
    });
    this.lPv = ((MMSightRecordView)findViewById(2131306747));
    this.lPv.setDisplayRatio(this.ilP);
    this.lPv.setPreviewSizeLimit(this.kyq);
    this.lPv.setVideoPara$2e715812(100000);
    this.lPv.setVideoFilePath(com.tencent.mm.loader.j.b.aKJ() + "mmsighttest.mp4");
    this.lPv.setClipPictureSize(true);
    this.lPv.setClipVideoSize(true);
    this.lPv.zsX.bqN();
    this.lPv.setFlashMode(3);
    this.lPv.setFrameDataCallback(new MMSightRecordView.a()
    {
      public final void C(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2) {}
    });
    this.lPv.zsX.startPreview();
    this.lPv.zsX.bqI();
    findViewById(2131308886).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94559);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).a(new MMSightRecordView.g()
        {
          public final void R(Bitmap paramAnonymous2Bitmap)
          {
            AppMethodBeat.i(94558);
            if (paramAnonymous2Bitmap != null) {
              ((ImageView)MMSightRecordViewTestUI.this.findViewById(2131302573)).setImageBitmap(paramAnonymous2Bitmap);
            }
            AppMethodBeat.o(94558);
          }
          
          public final void bFZ() {}
        }, true);
        a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(94559);
      }
    });
    findViewById(2131308371).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94562);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).zsX.aai();
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94561);
            MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).a(new MMSightRecordView.h()
            {
              public final void hs(boolean paramAnonymous3Boolean)
              {
                AppMethodBeat.i(94560);
                Toast.makeText(MMSightRecordViewTestUI.this, "record finish, error: ".concat(String.valueOf(paramAnonymous3Boolean)), 0).show();
                AppMethodBeat.o(94560);
              }
            });
            AppMethodBeat.o(94561);
          }
        }, 5000L);
        a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(94562);
      }
    });
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94563);
        this.zBT.setText("");
        this.zBT.append(String.format("picture size: %s, ratio: %s\n", new Object[] { MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize(), Float.valueOf(Math.min(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize().x, MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize().y) / Math.max(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize().x, MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize().y)) }));
        this.zBT.append(String.format("video size: %s, ratio: %s\n", new Object[] { MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize(), Float.valueOf(Math.min(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize().x, MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize().y) / Math.max(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize().x, MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize().y)) }));
        this.zBT.append(String.format("preview size limit: %s\n", new Object[] { Integer.valueOf(MMSightRecordViewTestUI.b(MMSightRecordViewTestUI.this)) }));
        this.zBT.append(String.format("display ratio: %s\n", new Object[] { Float.valueOf(MMSightRecordViewTestUI.c(MMSightRecordViewTestUI.this)) }));
        this.zBT.append(String.format("view size: %s, ratio: %s\n", new Object[] { new Point(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getWidth(), MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getHeight()), Float.valueOf(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getWidth() / MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getHeight()) }));
        AppMethodBeat.o(94563);
      }
    }, 1000L);
    findViewById(2131308800).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94564);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).zsX.switchCamera();
        a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(94564);
      }
    });
    AppMethodBeat.o(94565);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94566);
    super.onDestroy();
    this.lPv.zsX.release();
    AppMethodBeat.o(94566);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI
 * JD-Core Version:    0.7.0.1
 */