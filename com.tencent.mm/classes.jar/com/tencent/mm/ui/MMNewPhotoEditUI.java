package com.tencent.mm.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.api.b;
import com.tencent.mm.api.f;
import com.tencent.mm.api.q.a.a;
import com.tencent.mm.api.q.b;
import com.tencent.mm.api.q.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.vfs.e;

@a(19)
public class MMNewPhotoEditUI
  extends MMActivity
  implements f
{
  private com.tencent.mm.ui.base.p dpF = null;
  private int drX;
  private com.tencent.mm.api.q mqU;
  private String uOr;
  private String uOs;
  private String uOt;
  private boolean uOu;
  private boolean uOv;
  private final com.tencent.mm.remoteservice.d uOw = new com.tencent.mm.remoteservice.d(this);
  private PhotoEditProxy uOx;
  private Dialog uOy;
  
  private void FV(int paramInt)
  {
    ew(true);
    this.mqU.a(new MMNewPhotoEditUI.5(this, paramInt));
  }
  
  private void ew(boolean paramBoolean)
  {
    y.i("MicroMsg.MMNewPhotoEditUI", "[setProgress] isVisible:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      this.dpF = com.tencent.mm.ui.base.p.b(this, getString(ag.d.processing), true, 0, null);
    }
    while ((this.dpF == null) || (!this.dpF.isShowing())) {
      return;
    }
    this.dpF.dismiss();
    this.dpF = null;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return ag.c.new_photo_edit_ui;
  }
  
  protected final void initView()
  {
    FrameLayout localFrameLayout = (FrameLayout)findViewById(ag.b.content);
    this.mqU = com.tencent.mm.api.q.buU.rJ();
    Object localObject = this.mqU;
    q.a.a locala = new q.a.a();
    if ((this.drX != 291) && (this.drX != 293)) {}
    for (boolean bool = true;; bool = false)
    {
      locala.buW = bool;
      locala.buY = true;
      locala.buV = q.c.bvb;
      locala.path = this.uOr;
      ((com.tencent.mm.api.q)localObject).a(locala.sh());
      localObject = this.mqU.ax(this.mController.uMN);
      ((b)localObject).setActionBarCallback(this);
      localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
      ((b)localObject).setSelectedFeatureListener(new com.tencent.mm.api.p()
      {
        public final void a(com.tencent.mm.api.d paramAnonymousd)
        {
          y.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedFeature] features:%s", new Object[] { paramAnonymousd.name() });
        }
        
        public final void a(com.tencent.mm.api.d paramAnonymousd, int paramAnonymousInt)
        {
          y.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousd.name(), Integer.valueOf(paramAnonymousInt) });
        }
        
        public final void aL(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            MMNewPhotoEditUI.this.showVKB();
            return;
          }
          MMNewPhotoEditUI.this.hideVKB(MMNewPhotoEditUI.this.mController.contentView);
        }
      });
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1) && (paramIntent != null))
    {
      str = paramIntent.getStringExtra("Select_Conv_User");
      y.d("MicroMsg.MMNewPhotoEditUI", "select %s for sending imagePath:%s", new Object[] { str, this.uOt });
      this.uOy = com.tencent.mm.ui.base.h.b(this.mController.uMN, getString(ag.d.photo_edit_forward_tips), false, null);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      this.uOx.sendImage(paramIntent, this.uOt, this.uOx.getSelfUsername(), str);
      this.uOy.dismiss();
      if (!this.uOu)
      {
        e.deleteFile(this.uOt);
        finish();
      }
    }
    while ((paramIntent != null) || (bk.bl(this.uOt)) || (this.drX != 291)) {
      for (;;)
      {
        String str;
        return;
        com.tencent.mm.platformtools.q.a(this.uOt, this);
      }
    }
    e.deleteFile(this.uOt);
  }
  
  public void onBackPressed()
  {
    if (!this.mqU.rG())
    {
      if ((this.drX != 290) && (this.drX != 291)) {
        break label62;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(13859, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
    }
    for (;;)
    {
      finish();
      return;
      label62:
      if ((this.drX == 4) || (this.drX == 293)) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13859, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
      } else {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13859, new Object[] { Integer.valueOf(0), Integer.valueOf(2) });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.czx();
    this.uOx = new PhotoEditProxy(this.uOw);
    this.uOw.connect(new MMNewPhotoEditUI.1(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mqU.onDestroy();
    this.uOw.release();
  }
  
  public final void onFinish()
  {
    if ((this.drX == 290) || (this.drX == 291)) {
      com.tencent.mm.plugin.report.service.h.nFQ.f(13859, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    }
    while ((this.drX == 291) || (this.drX == 293))
    {
      j localj = new j(this.mController.uMN);
      localj.phH = new MMNewPhotoEditUI.3(this);
      localj.phI = new MMNewPhotoEditUI.4(this);
      com.tencent.mm.ui.base.h.a(this.mController.uMN, localj.bJQ());
      return;
      if ((this.drX == 4) || (this.drX == 293)) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13859, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      } else {
        com.tencent.mm.plugin.report.service.h.nFQ.f(13859, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
      }
    }
    FV(-1);
  }
  
  public final void rX()
  {
    onBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MMNewPhotoEditUI
 * JD-Core Version:    0.7.0.1
 */