package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.c.a;

public class SnsUserUI
  extends MMActivity
  implements h.a
{
  private long dFe = 0L;
  private int dmY;
  private long ekk = 0L;
  private com.tencent.mm.sdk.b.c giK = new SnsUserUI.10(this);
  private String hcm;
  private com.tencent.matrix.trace.c.a kho = new SnsUserUI.14(this);
  private boolean oPz;
  private boolean peI = false;
  private String peN;
  private boolean peO;
  private int peP;
  private View pfk;
  private c.a pfl;
  private MenuItem.OnMenuItemClickListener pfw = new SnsUserUI.7(this);
  private Runnable pjA = new Runnable()
  {
    public final void run()
    {
      SnsUserUI.a(SnsUserUI.this).bJj();
      SnsUserUI.a(SnsUserUI.this).bHx();
    }
  };
  private as pjt;
  private ba pju;
  private am.a pjv;
  private ba.a pjw;
  private RelativeLayout pjx = null;
  private TextView pjy = null;
  private int pjz = 0;
  
  private void bKd()
  {
    if (com.tencent.mm.r.a.bi(this)) {}
    boolean bool;
    do
    {
      do
      {
        return;
        bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 18, "", "");
        y.d("MicroMsg.SnsUserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this });
      } while (!bool);
      bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "");
      y.d("MicroMsg.SnsUserUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this });
    } while (!bool);
    Intent localIntent = new Intent();
    l.z(this.mController.uMN, localIntent);
  }
  
  public final void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, int paramInt, long paramLong)
  {
    af.aXq().removeCallbacks(this.pjA);
    String str;
    if (this.pjt != null)
    {
      this.pjt.pbM = paramBoolean2;
      this.pjt.oSZ = paramString;
      str = this.pjt.jKL;
      if (paramString.compareTo(str) < 0)
      {
        y.i("MicroMsg.SnsUserUI", "onNpAddSize addsize %s %s", new Object[] { paramString, str });
        this.pjt.bJj();
        this.pjt.bHx();
      }
    }
    else
    {
      if ((!paramBoolean3) || (this.peN.equals(this.hcm))) {
        break label147;
      }
      this.pju.pio = true;
      this.pju.yA(paramInt);
    }
    label147:
    do
    {
      return;
      y.i("MicroMsg.SnsUserUI", "onNpAddSize addsize passed %s %s", new Object[] { paramString, str });
      break;
      if ((this.peN.equals(this.hcm)) && (paramLong != 0L))
      {
        g.DQ();
        g.DP().Dz().c(ac.a.uuS, Long.valueOf(paramLong));
        this.pjt.gy(paramLong);
      }
      this.pju.pio = paramBoolean1;
    } while (!paramBoolean1);
    this.pju.jq(paramBoolean2);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4, int paramInt, long paramLong)
  {
    String str;
    if (this.pjt != null)
    {
      this.pjt.oSZ = paramString;
      str = this.pjt.jKL;
      if (paramString.compareTo(str) < 0)
      {
        y.i("MicroMsg.SnsUserUI", "onFpSetSize addsize %s %s isNeedNP %s", new Object[] { paramString, str, Boolean.valueOf(paramBoolean1) });
        this.pjt.bJj();
        this.pjt.bHx();
      }
    }
    else
    {
      if ((!paramBoolean4) || (this.peN.equals(this.hcm))) {
        break label158;
      }
      this.pju.pio = true;
      this.pju.yA(paramInt);
    }
    for (;;)
    {
      if (paramBoolean3) {
        this.pju.oxg.bIM();
      }
      return;
      y.i("MicroMsg.SnsUserUI", "onFpSetSize addsize passed %s %s isNeedNP %s", new Object[] { paramString, str, Boolean.valueOf(paramBoolean1) });
      break;
      label158:
      if ((this.peN.equals(this.hcm)) && (paramLong != 0L))
      {
        g.DQ();
        g.DP().Dz().c(ac.a.uuS, Long.valueOf(paramLong));
        this.pjt.gy(paramLong);
      }
      this.pju.pio = paramBoolean2;
      if (paramBoolean2) {
        this.pju.jq(false);
      } else if (paramBoolean1) {
        this.pjv.b(this.pjw.getType(), this.hcm, this.oPz, this.peP);
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_self;
  }
  
  protected final void initView()
  {
    this.pjx = ((RelativeLayout)findViewById(i.f.sns_user_year_tip_layout));
    this.pjy = ((TextView)findViewById(i.f.sns_user_year_tip));
    this.pjx.post(new SnsUserUI.15(this));
    this.pjt = new as(this, new SnsUserUI.16(this), this.hcm, new SnsUserUI.17(this));
    this.pju.lwE.setAdapter(this.pjt);
    this.pju.lwE.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
    });
    this.pju.lwE.postDelayed(new Runnable()
    {
      public final void run()
      {
        if (SnsUserUI.l(SnsUserUI.this)) {
          y.w("MicroMsg.SnsUserUI", "too fast that it finish");
        }
        do
        {
          return;
          SnsUserUI.b(SnsUserUI.this).a(SnsUserUI.m(SnsUserUI.this).getType(), SnsUserUI.c(SnsUserUI.this), SnsUserUI.this);
          if ((SnsUserUI.m(SnsUserUI.this).getType() == 1) && (SnsUserUI.m(SnsUserUI.this).bJF())) {
            af.bDv().x(af.bDM().oto, -1);
          }
        } while (SnsUserUI.m(SnsUserUI.this).bJF());
        am.a locala = SnsUserUI.b(SnsUserUI.this);
        int i = SnsUserUI.m(SnsUserUI.this).getType();
        String str = SnsUserUI.c(SnsUserUI.this);
        SnsUserUI.d(SnsUserUI.this);
        locala.a(i, str, SnsUserUI.f(SnsUserUI.this), SnsUserUI.e(SnsUserUI.this));
      }
    }, 500L);
    setBackBtn(this.pfw, i.i.actionbar_icon_dark_back);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.SnsUserUI", "on activity result, %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((5985 == paramInt1) && (paramInt2 == -1))
    {
      finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.pju.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (this.mController != null) {
      this.mController.ap(2, false);
    }
    super.onCreate(paramBundle);
    if (!g.DN().Dc())
    {
      finish();
      return;
    }
    this.pfk = findViewById(i.f.action_bar_container);
    String str2;
    String str3;
    if ((this.pfk == null) || (!com.tencent.mm.ui.statusbar.c.vXv))
    {
      getWindow().getDecorView().setSystemUiVisibility(1280);
      ta(this.mController.uMN.getResources().getColor(i.c.transparent));
      b(new SnsUserUI.11(this), new SnsUserUI.12(this));
      this.pjv = af.bDv();
      this.peP = getIntent().getIntExtra("sns_source", 0);
      this.hcm = getIntent().getStringExtra("sns_userName");
      if (this.hcm == null) {
        this.hcm = "";
      }
      g.DQ();
      this.peO = ((j)g.r(j.class)).Fw().abg(this.hcm);
      this.peN = q.Gj();
      this.oPz = this.peN.equals(this.hcm);
      paramBundle = af.bDt();
      str2 = bk.aM(getIntent().getStringExtra("sns_signature"), "");
      str3 = bk.aM(getIntent().getStringExtra("sns_nickName"), "");
      if ((this.hcm != null) && (!this.hcm.equals(""))) {
        break label509;
      }
    }
    label509:
    for (paramBundle = paramBundle.abl(this.peN);; paramBundle = paramBundle.abl(this.hcm))
    {
      String str1 = str3;
      Object localObject = str2;
      if (paramBundle != null)
      {
        str1 = str3;
        localObject = str2;
        if ((int)paramBundle.dBe > 0)
        {
          localObject = paramBundle.signature;
          str1 = paramBundle.Bp();
          y.i("MicroMsg.SnsUserUI", "contact:user[%s] id[%d] nickname[%s]", new Object[] { paramBundle.field_username, Integer.valueOf((int)paramBundle.dBe), str1 });
        }
      }
      this.pju = new ba(this);
      this.pju.a(this.peN, this.hcm, str1, (String)localObject, this.peO, this.oPz, this.peP);
      paramBundle = this.pju;
      localObject = new SnsUserUI.13(this);
      this.pjw = ((ba.a)localObject);
      paramBundle.piq = ((ba.a)localObject);
      this.pju.onCreate();
      if (getIntent().getExtras() != null) {
        getIntent().getExtras().setClassLoader(getClass().getClassLoader());
      }
      initView();
      com.tencent.mm.sdk.b.a.udP.c(this.giK);
      return;
      paramBundle = com.tencent.mm.ui.statusbar.c.af(this);
      localObject = new SnsUserUI.4(this);
      this.pfl = ((c.a)localObject);
      paramBundle.a((c.a)localObject);
      getWindow().getDecorView().requestApplyInsets();
      com.tencent.mm.ui.statusbar.d.a(getWindow());
      break;
    }
  }
  
  public void onDestroy()
  {
    this.peI = true;
    com.tencent.mm.sdk.b.a.udP.d(this.giK);
    b localb = b.i(getIntent());
    if (localb != null)
    {
      localb.update();
      localb.QX();
    }
    if ((this.pju != null) && (this.pju.tipDialog != null))
    {
      this.pju.tipDialog.dismiss();
      this.pju.tipDialog = null;
    }
    g.DQ();
    if ((g.DN().Dc()) && (this.pjv != null)) {
      this.pjv.a(this, this.pjw.getType());
    }
    if (this.pju != null) {
      this.pju.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onDrag()
  {
    super.onDrag();
  }
  
  public void onPause()
  {
    WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcSNSUserScrollEnable, this.dmY);
    this.dmY = 0;
    ba.onPause();
    super.onPause();
    ((com.tencent.matrix.trace.a)com.tencent.matrix.a.qO().l(com.tencent.matrix.trace.a.class)).bqu.b(this.kho);
    if (bk.UX() > this.ekk) {}
    for (long l = bk.UX() - this.ekk;; l = 1L)
    {
      this.ekk = l;
      WXHardCoderJNI.reportFPS(704, WXHardCoderJNI.hcSNSUserScrollAction, 1, this.dFe, this.ekk);
      this.dFe = 0L;
      this.ekk = 0L;
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.SnsUserUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bKd();
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = i.j.permission_camera_request_again_msg; paramArrayOfInt[0] != 0; paramInt = i.j.permission_microphone_request_again_msg)
      {
        h.a(this, getString(paramInt), getString(i.j.permission_tips_title), getString(i.j.jump_to_settings), getString(i.j.app_cancel), false, new SnsUserUI.8(this), new SnsUserUI.9(this));
        return;
      }
    }
  }
  
  public void onResume()
  {
    this.ekk = bk.UX();
    ((com.tencent.matrix.trace.a)com.tencent.matrix.a.qO().l(com.tencent.matrix.trace.a.class)).bqu.a(this.kho);
    if (this.pjt != null) {
      this.pjt.notifyDataSetChanged();
    }
    setRequestedOrientation(-1);
    if (!this.oPz) {
      enableOptionMenu(false);
    }
    for (;;)
    {
      setBackBtn(this.pfw, i.i.actionbar_icon_dark_back);
      if (!this.oPz) {
        break;
      }
      setMMTitle(i.j.sns_photo_ui_title);
      ba.onResume();
      super.onResume();
      return;
      a(getString(i.j.sns_message_desc), i.i.actionbar_list_icon, new SnsUserUI.3(this));
    }
    y.d("MicroMsg.SnsUserUI", "SnsUserUI, userName:%s, title:%s", new Object[] { this.hcm, this.pju.title });
    Object localObject = af.bDt().abl(this.hcm);
    if (localObject != null) {
      y.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is not null");
    }
    for (localObject = ((com.tencent.mm.n.a)localObject).Bq();; localObject = this.pju.title)
    {
      setMMTitle(i.z((CharSequence)localObject));
      break;
      y.d("MicroMsg.SnsUserUI", "SnsUserUI, contact is null, title:%s", new Object[] { this.pju.title });
    }
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return super.supportNavigationSwipeBack();
  }
  
  public final void ta(int paramInt)
  {
    super.ta(paramInt);
    if ((Build.VERSION.SDK_INT >= 21) && (this.pfk != null))
    {
      this.pfk.setBackgroundColor(getWindow().getStatusBarColor());
      com.tencent.mm.ui.statusbar.d.a(getWindow());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI
 * JD-Core Version:    0.7.0.1
 */