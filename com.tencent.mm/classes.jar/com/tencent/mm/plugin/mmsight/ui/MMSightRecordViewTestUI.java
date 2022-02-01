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
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;

public class MMSightRecordViewTestUI
  extends MMActivity
{
  private float hpf = 0.67F;
  private int juM = 720;
  private MMSightRecordView kHz;
  
  public int getLayoutId()
  {
    return 2131494918;
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
    this.kHz = ((MMSightRecordView)findViewById(2131303906));
    this.kHz.setDisplayRatio(this.hpf);
    this.kHz.setPreviewSizeLimit(this.juM);
    this.kHz.setVideoPara$2e715812(100000);
    this.kHz.setVideoFilePath(com.tencent.mm.loader.j.b.arU() + "mmsighttest.mp4");
    this.kHz.setClipPictureSize(true);
    this.kHz.setClipVideoSize(true);
    this.kHz.vMS.aVr();
    this.kHz.setFlashMode(3);
    this.kHz.setFrameDataCallback(new MMSightRecordView.a()
    {
      public final void s(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2) {}
    });
    this.kHz.vMS.startPreview();
    this.kHz.vMS.aVm();
    findViewById(2131305642).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94559);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).a(new MMSightRecordView.g()
        {
          public final void N(Bitmap paramAnonymous2Bitmap)
          {
            AppMethodBeat.i(94558);
            if (paramAnonymous2Bitmap != null) {
              ((ImageView)MMSightRecordViewTestUI.this.findViewById(2131300943)).setImageBitmap(paramAnonymous2Bitmap);
            }
            AppMethodBeat.o(94558);
          }
          
          public final void bjU() {}
        }, true);
        a.a(this, "com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(94559);
      }
    });
    findViewById(2131305181).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94562);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).vMS.PP();
        aq.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(94561);
            MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).a(new MMSightRecordView.h()
            {
              public final void gw(boolean paramAnonymous3Boolean)
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
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94563);
        this.vVp.setText("");
        this.vVp.append(String.format("picture size: %s, ratio: %s\n", new Object[] { MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize(), Float.valueOf(Math.min(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize().x, MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize().y) / Math.max(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize().x, MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getPictureSize().y)) }));
        this.vVp.append(String.format("video size: %s, ratio: %s\n", new Object[] { MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize(), Float.valueOf(Math.min(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize().x, MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize().y) / Math.max(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize().x, MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getVideoSize().y)) }));
        this.vVp.append(String.format("preview size limit: %s\n", new Object[] { Integer.valueOf(MMSightRecordViewTestUI.b(MMSightRecordViewTestUI.this)) }));
        this.vVp.append(String.format("display ratio: %s\n", new Object[] { Float.valueOf(MMSightRecordViewTestUI.c(MMSightRecordViewTestUI.this)) }));
        this.vVp.append(String.format("view size: %s, ratio: %s\n", new Object[] { new Point(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getWidth(), MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getHeight()), Float.valueOf(MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getWidth() / MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).getHeight()) }));
        AppMethodBeat.o(94563);
      }
    }, 1000L);
    findViewById(2131305576).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(94564);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/mmsight/ui/MMSightRecordViewTestUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        MMSightRecordViewTestUI.a(MMSightRecordViewTestUI.this).vMS.switchCamera();
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
    this.kHz.vMS.release();
    AppMethodBeat.o(94566);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI
 * JD-Core Version:    0.7.0.1
 */