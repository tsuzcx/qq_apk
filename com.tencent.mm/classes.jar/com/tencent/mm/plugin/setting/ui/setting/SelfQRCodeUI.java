package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.af;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.ahz;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public class SelfQRCodeUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private static final String nSA = com.tencent.mm.compatible.util.h.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/";
  private ProgressDialog dnm = null;
  private Bitmap ebo = null;
  private ImageView gSx = null;
  private long iKA;
  private TextView ifO = null;
  private ImageView nRF = null;
  private byte[] nRG = null;
  private TextView nSx = null;
  private boolean nSy = false;
  private SelfQRCodeUI.b nSz;
  private String userName = "";
  
  private void a(int paramInt1, int paramInt2, String paramString, SelfQRCodeUI.a parama)
  {
    if (com.tencent.mm.plugin.setting.b.eUS.b(this.mController.uMN, paramInt1, paramInt2, paramString)) {
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Toast.makeText(this, getString(a.i.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
    }
    this.nRG = parama.byM();
    this.ebo = com.tencent.mm.sdk.platformtools.c.bu(this.nRG);
    if ((com.tencent.mm.model.s.gZ(this.userName)) || (com.tencent.mm.ai.f.lc(this.userName)))
    {
      enableOptionMenu(true);
      paramString = parama.byN();
      if (!bk.bl(paramString)) {
        ((TextView)findViewById(a.f.qrcode_tip)).setText(paramString);
      }
    }
    for (;;)
    {
      this.nRF.setImageBitmap(this.ebo);
      return;
      if (this.nSy)
      {
        paramString = parama.byO();
        parama = (TextView)findViewById(a.f.tips_banner_tv);
        View localView = (View)parama.getParent();
        if (!bk.bl(paramString))
        {
          parama.setText(paramString);
          localView.setOnClickListener(new SelfQRCodeUI.3(this));
          localView.setVisibility(0);
        }
        else
        {
          localView.setVisibility(8);
        }
      }
    }
  }
  
  public static void byL()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 14L, 1L, true);
  }
  
  private void xb(int paramInt)
  {
    if (this.nSy) {}
    for (int i = bk.g((Integer)com.tencent.mm.kernel.g.DP().Dz().get(66561, null));; i = 0)
    {
      Object localObject;
      if (com.tencent.mm.model.s.hb(this.userName))
      {
        localObject = new com.tencent.mm.openim.b.g(this.userName);
        com.tencent.mm.kernel.g.Dk().a((m)localObject, 0);
      }
      for (;;)
      {
        AppCompatActivity localAppCompatActivity = this.mController.uMN;
        getString(a.i.app_tip);
        this.dnm = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(a.i.self_qrcode_getting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            com.tencent.mm.kernel.g.Dk().c(this.bEe);
            if ((com.tencent.mm.model.s.gZ(SelfQRCodeUI.c(SelfQRCodeUI.this))) || (com.tencent.mm.ai.f.lc(SelfQRCodeUI.c(SelfQRCodeUI.this)))) {
              SelfQRCodeUI.this.finish();
            }
          }
        });
        return;
        localObject = new com.tencent.mm.ba.a(this.userName, i, paramInt);
        com.tencent.mm.kernel.g.Dk().a((m)localObject, 0);
      }
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.self_qrcode;
  }
  
  protected final void initView()
  {
    this.userName = getIntent().getStringExtra("from_userName");
    if (bk.bl(this.userName)) {
      this.userName = q.Gj();
    }
    if (q.Gj().equals(this.userName)) {
      this.nSy = true;
    }
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.model.s.gZ(this.userName))
    {
      setMMTitle(a.i.settings_room_qrcode_card);
      ((TextView)findViewById(a.f.qrcode_tip)).setText("");
      enableOptionMenu(false);
      this.nRF = ((ImageView)findViewById(a.f.self_qrcode_iv));
      this.gSx = ((ImageView)findViewById(a.f.header_icon));
      this.ifO = ((TextView)findViewById(a.f.nick_name));
      this.nSx = ((TextView)findViewById(a.f.district));
      if ((!com.tencent.mm.model.s.gZ(this.userName)) && (!com.tencent.mm.ai.f.lc(this.userName))) {
        break label429;
      }
      xb(1);
      a.b.a(this.gSx, this.userName);
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.userName);
      this.ifO.setSingleLine(false);
      this.ifO.setMaxLines(3);
      if (!com.tencent.mm.model.s.hb(this.userName)) {
        break label403;
      }
      localObject2 = getResources().getDrawable(a.h.open_im_main_logo);
      this.ifO.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject2, null);
      label250:
      if (localObject1 == null) {
        break label417;
      }
      localObject2 = ((ao)localObject1).field_nickname;
      localObject1 = localObject2;
      if (bk.bl((String)localObject2)) {
        localObject1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().io(this.userName).field_displayname;
      }
      this.ifO.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this, (CharSequence)localObject1, this.ifO.getTextSize()));
      label314:
      this.nSx.setVisibility(8);
    }
    for (;;)
    {
      addIconOptionMenu(0, a.e.mm_title_btn_menu, new SelfQRCodeUI.4(this));
      setBackBtn(new SelfQRCodeUI.5(this));
      return;
      if (com.tencent.mm.ai.f.lc(this.userName))
      {
        setMMTitle(a.i.enterprise_qrcode);
        ((TextView)findViewById(a.f.qrcode_tip)).setText(a.i.enterprise_qrcode_tip);
        enableOptionMenu(false);
        break;
      }
      setMMTitle(a.i.settings_qrcode_card);
      break;
      label403:
      this.ifO.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label250;
      label417:
      this.ifO.setVisibility(8);
      break label314;
      label429:
      localObject2 = (String)com.tencent.mm.kernel.g.DP().Dz().get(42, null);
      localObject1 = getString(a.i.app_field_username);
      if (!bk.bl((String)localObject2))
      {
        localObject1 = (String)localObject1 + (String)localObject2;
        label479:
        y.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", new Object[] { localObject1 });
        if (this.ebo != null) {
          break label773;
        }
        y.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[] { "bitmap == null" });
        xb(1);
      }
      for (;;)
      {
        a.b.a(this.gSx, q.Gj());
        localObject1 = (String)com.tencent.mm.kernel.g.DP().Dz().get(4, null);
        y.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[] { localObject1 });
        this.ifO.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject1, com.tencent.mm.cb.a.aa(this.mController.uMN, a.d.HintTextSize)));
        localObject2 = bn.Id();
        localObject1 = bk.pm(((bn)localObject2).getProvince());
        localObject2 = bk.pm(((bn)localObject2).getCity());
        localObject1 = r.gX((String)localObject1) + " " + (String)localObject2;
        y.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[] { localObject1 });
        this.nSx.setText((CharSequence)localObject1);
        switch (bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(12290, null), 0))
        {
        default: 
          break;
        case 1: 
          this.ifO.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.g(this, a.h.ic_sex_male), null);
          break;
          localObject2 = (String)com.tencent.mm.kernel.g.DP().Dz().get(2, null);
          localObject1 = (String)localObject1 + (String)localObject2;
          ad.aaX((String)localObject2);
          break label479;
          label773:
          this.nRF.setImageBitmap(this.ebo);
        }
      }
      this.ifO.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.g(this, a.h.ic_sex_female), null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    czo();
    this.nSz = new SelfQRCodeUI.b(this, this);
    this.nSz.start();
    com.tencent.mm.kernel.g.Dk().a(168, this);
    com.tencent.mm.kernel.g.Dk().a(890, this);
    initView();
    this.nRF.post(new SelfQRCodeUI.1(this));
  }
  
  public void onDestroy()
  {
    com.tencent.mm.kernel.g.Dk().b(168, this);
    com.tencent.mm.kernel.g.Dk().b(890, this);
    if (this.nSz != null) {
      this.nSz.stop();
    }
    if ((this.ebo != null) && (!this.ebo.isRecycled())) {
      this.ebo.recycle();
    }
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((com.tencent.mm.model.s.gZ(this.userName)) || (com.tencent.mm.ai.f.lc(this.userName))) {
      return;
    }
    View localView = findViewById(a.f.self_qrcode_verify_open_prompt);
    this.iKA = q.Go();
    y.d("MicroMsg.SelfQRCodeNewUI", (this.iKA & 0x2) + ",extstatus:" + this.iKA);
    if ((this.iKA & 0x2) != 0L)
    {
      localView.setVisibility(0);
      this.nRF.setAlpha(0.1F);
      findViewById(a.f.self_qrcode_verify_openBt).setOnClickListener(new SelfQRCodeUI.6(this));
      return;
    }
    localView.setVisibility(8);
    this.nRF.setAlpha(1.0F);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramm instanceof com.tencent.mm.ba.a)) {
      a(paramInt1, paramInt2, paramString, new SelfQRCodeUI.a()
      {
        public final byte[] byM()
        {
          return this.nSD.exe;
        }
        
        public final String byN()
        {
          return this.nSD.exc;
        }
        
        public final String byO()
        {
          return this.nSD.exd;
        }
      });
    }
    while (!(paramm instanceof com.tencent.mm.openim.b.g)) {
      return;
    }
    paramm = (ahz)((com.tencent.mm.ah.b)((com.tencent.mm.openim.b.g)paramm).edi).ecF.ecN;
    a(paramInt1, paramInt2, paramString, new SelfQRCodeUI.2(this, paramm.tfq.oY, paramm.stw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI
 * JD-Core Version:    0.7.0.1
 */