package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.qo;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SayHiWithSnsPermissionUI
  extends MMActivity
  implements f
{
  private String aVr;
  private String aVs;
  private String chatroomName;
  private ProgressDialog dnm = null;
  private int fhj;
  private int[] fmY = new int[8];
  private String lCb;
  private String mCz;
  private EditText mZb;
  private EditText mZc;
  private View mZd;
  private TextView mZe;
  private MMSwitchBtn mZf;
  private boolean mZg;
  private boolean mZh;
  private boolean mZi;
  private TextView mZj;
  private MMTagPanel mZk;
  private List<String> mZl;
  private m.b mZm = new SayHiWithSnsPermissionUI.1(this);
  private CharSequence mZn = null;
  private String userName;
  
  private void bsQ()
  {
    au.Hx();
    bv localbv = com.tencent.mm.model.c.Fx().Id(this.userName);
    if (localbv != null)
    {
      this.lCb = localbv.field_contactLabels;
      this.mZl = ((ArrayList)com.tencent.mm.plugin.label.a.a.bdA().Gm(this.lCb));
    }
    if (this.mZi)
    {
      if (!bk.bl(this.lCb))
      {
        this.mZk.setVisibility(0);
        this.mZj.setVisibility(4);
        this.mZk.a(this.mZl, this.mZl);
      }
    }
    else {
      return;
    }
    this.mZk.setVisibility(4);
    this.mZj.setVisibility(0);
  }
  
  protected final int getLayoutId()
  {
    return R.i.say_hi_with_sns_permission;
  }
  
  protected final void initView()
  {
    this.mZf = ((MMSwitchBtn)findViewById(R.h.not_allow_see_permission).findViewById(R.h.checkbox));
    this.mZf.setCheck(false);
    this.mZg = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
    this.mZh = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
    this.mZi = getIntent().getBooleanExtra("sayhi_with_sns_perm_set_label", false);
    this.userName = getIntent().getStringExtra("Contact_User");
    this.fhj = getIntent().getIntExtra("Contact_Scene", 9);
    this.chatroomName = getIntent().getStringExtra("room_name");
    this.aVs = getIntent().getStringExtra("Contact_RemarkName");
    this.aVr = getIntent().getStringExtra("Contact_Nick");
    this.mCz = getIntent().getStringExtra("Contact_RoomNickname");
    this.mZd = findViewById(R.h.mod_remark_recommend_name_area);
    this.mZe = ((TextView)findViewById(R.h.mod_remark_recommend_tip));
    setMMTitle(getString(R.l.app_name));
    Object localObject1;
    if (ad.aaU(this.userName))
    {
      localObject1 = findViewById(R.h.not_allow_see_permission_layout);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    String str1;
    Object localObject2;
    if (this.mZg)
    {
      setMMTitle(getString(R.l.sendrequest_title));
      this.mZb = ((EditText)findViewById(R.h.say_hi_content));
      this.mZb.setMinHeight(this.mController.uMN.getResources().getDimensionPixelSize(R.f.MMClearEditTextMinHeight));
      com.tencent.mm.ui.tools.a.c.d(this.mZb).Ig(100).a(null);
      this.mZb.setFilters(com.tencent.mm.pluginsdk.ui.tools.h.smJ);
      ((LinearLayout)this.mZb.getParent()).setVisibility(0);
      au.Hx();
      str1 = (String)com.tencent.mm.model.c.Dz().get(294913, null);
      localObject2 = q.Gl();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      String str2 = getString(R.l.sendgreeting_content);
      localObject2 = localObject1;
      if (str2.length() + ((String)localObject1).length() > 50) {
        localObject2 = ((String)localObject1).substring(0, 50 - str2.length());
      }
      this.mZn = j.a(this.mController.uMN, String.format(str2, new Object[] { localObject2 }), this.mZb.getTextSize());
      if (!bk.bl(str1)) {
        break label860;
      }
      this.mZb.setText(this.mZn);
    }
    for (;;)
    {
      this.mZb.requestFocus();
      this.mZb.postDelayed(new SayHiWithSnsPermissionUI.2(this), 100L);
      if (this.mZh)
      {
        this.mZc = ((EditText)findViewById(R.h.say_hi_remark));
        ((LinearLayout)this.mZc.getParent()).setVisibility(0);
        if (!this.mZg) {
          this.mZc.clearFocus();
        }
        this.mZc.setMinHeight(this.mController.uMN.getResources().getDimensionPixelSize(R.f.MMClearEditTextMinHeight));
        com.tencent.mm.ui.tools.a.c.d(this.mZc).Ig(100).a(null);
        this.mZc.setFilters(com.tencent.mm.pluginsdk.ui.tools.h.smJ);
        if (!this.mZg)
        {
          this.fmY[0] = 1;
          setMMTitle(getString(R.l.contact_verify_title));
          localObject1 = (LinearLayout.LayoutParams)((View)this.mZc.getParent()).getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, 0, ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
        }
        if (bk.bl(this.aVs)) {
          break;
        }
        this.mZc.setText(j.a(this.mController.uMN, this.aVs, this.mZc.getTextSize()));
        this.fmY[6] = 1;
      }
      if (ad.aaU(this.userName)) {
        this.mZi = false;
      }
      if (this.mZi)
      {
        this.mZj = ((TextView)findViewById(R.h.mod_label_edit_text));
        this.mZk = ((MMTagPanel)findViewById(R.h.contact_label_display_panel));
        this.mZk.setPanelClickable(false);
        ((LinearLayout)((FrameLayout)this.mZk.getParent()).getParent()).setVisibility(0);
        this.mZj.setOnClickListener(new SayHiWithSnsPermissionUI.4(this));
        this.mZk.setOnClickListener(new SayHiWithSnsPermissionUI.5(this));
      }
      bsQ();
      if (!bk.bl(this.lCb)) {
        this.fmY[7] = 1;
      }
      localObject1 = getString(R.l.app_send);
      if (!this.mZg) {
        localObject1 = getString(R.l.app_finish);
      }
      a(0, (String)localObject1, new SayHiWithSnsPermissionUI.6(this), s.b.uNx);
      setBackBtn(new SayHiWithSnsPermissionUI.7(this));
      return;
      label860:
      localObject1 = j.a(this.mController.uMN, str1, this.mZb.getTextSize());
      this.mZb.setText((CharSequence)localObject1);
    }
    if (!bk.bl(this.aVr))
    {
      this.mZc.setHint(j.a(this.mController.uMN, this.aVr, this.mZc.getTextSize()));
      this.mZc.setOnFocusChangeListener(new SayHiWithSnsPermissionUI.3(this));
    }
    int i;
    switch (this.fhj)
    {
    case 9: 
    case 12: 
    default: 
      i = 0;
    }
    while ((!this.mZg) && (i == 0))
    {
      localObject1 = com.tencent.mm.bh.d.RX().abU(this.userName);
      if (localObject1 == null) {
        break;
      }
      localObject2 = com.tencent.mm.pluginsdk.ui.preference.b.a(this, (ax)localObject1);
      if ((bk.bl(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).dTF)) || (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).dTF.equals(getString(R.l.fmessage_from_verify_digest_tip)))) {
        break;
      }
      str1 = getString(R.l.sendgreeting_content).substring(0, getString(R.l.sendgreeting_content).indexOf("%s"));
      localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).dTF;
      if (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).dTF.startsWith(str1)) {
        localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).dTF.substring(str1.length());
      }
      this.mZd.setVisibility(0);
      this.mZe.setText(j.a(this, bk.pm(getString(R.l.contact_info_set_remark_verify_info, new Object[] { ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).dTF })), this.mZe.getTextSize()));
      localObject2 = new k(getString(R.l.write_contact_remark));
      ((k)localObject2).setSpan(new SayHiWithSnsPermissionUI.a(this, (String)localObject1), 0, ((k)localObject2).length(), 17);
      this.mZe.append(" ");
      this.mZe.append((CharSequence)localObject2);
      this.mZe.setMovementMethod(LinkMovementMethod.getInstance());
      this.fmY[3] = 3;
      break;
      localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(this.userName);
      if ((localObject1 == null) || (bk.bl(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wx())) || (((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wx().equals(this.mZc.getText().toString())))
      {
        i = 0;
      }
      else
      {
        this.mZd.setVisibility(0);
        this.mZe.setText(j.a(this, bk.pm(getString(R.l.contact_info_set_reamrk_mobile_name, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wx() })), this.mZe.getTextSize()));
        localObject2 = new k(getString(R.l.write_contact_remark));
        ((k)localObject2).setSpan(new SayHiWithSnsPermissionUI.a(this, ((com.tencent.mm.plugin.account.friend.a.a)localObject1).Wx()), 0, ((k)localObject2).length(), 17);
        this.mZe.append(" ");
        this.mZe.append((CharSequence)localObject2);
        this.mZe.setMovementMethod(LinkMovementMethod.getInstance());
        this.fmY[3] = 1;
        i = 1;
        continue;
        if ((bk.bl(this.mCz)) || (this.mCz.equals(this.mZc.getText().toString())))
        {
          i = 0;
        }
        else
        {
          this.mZd.setVisibility(0);
          this.mZe.setText(j.a(this, bk.pm(getString(R.l.contact_info_set_reamrk_chatroom_name, new Object[] { this.mCz })), this.mZe.getTextSize()));
          localObject1 = new k(getString(R.l.write_contact_remark));
          ((k)localObject1).setSpan(new SayHiWithSnsPermissionUI.a(this, this.mCz), 0, ((k)localObject1).length(), 17);
          this.mZe.append(" ");
          this.mZe.append((CharSequence)localObject1);
          this.mZe.setMovementMethod(LinkMovementMethod.getInstance());
          this.fmY[3] = 2;
          i = 1;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(14036, new Object[] { Integer.valueOf(this.fmY[0]), Integer.valueOf(this.fmY[1]), Integer.valueOf(this.fmY[2]), Integer.valueOf(this.fmY[3]), Integer.valueOf(this.fmY[4]), Integer.valueOf(this.fmY[5]), Integer.valueOf(this.fmY[6]), Integer.valueOf(this.fmY[7]) });
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.fmY[0] = 1;
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    if (this.mZi)
    {
      au.Hx();
      com.tencent.mm.model.c.Fw().a(this.mZm);
      bsQ();
    }
    au.Dk().a(30, this);
    au.Dk().a(243, this);
    au.Dk().a(853, this);
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    long l = System.currentTimeMillis();
    y.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    for (;;)
    {
      try
      {
        if (this.dnm != null)
        {
          this.dnm.dismiss();
          this.dnm = null;
        }
        if (!this.mZg) {
          continue;
        }
        localObject = this.mZb.getText().toString().trim();
        if ((!bk.bl((String)localObject)) && (!((String)localObject).equals(this.mZn))) {
          continue;
        }
        au.Hx();
        com.tencent.mm.model.c.Dz().o(294913, "");
        switch (paramInt2)
        {
        default: 
          i = 0;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + paramString.getMessage());
        return;
        Toast.makeText(this, R.l.sendrequest_send_fail, 0).show();
        int i = 1;
        continue;
        Toast.makeText(this, R.l.fmessage_request_too_offen, 0).show();
        i = 1;
        continue;
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1039;
        }
        com.tencent.mm.ui.base.h.bC(this, getString(R.l.sendrequest_send_success));
        if (!this.mZh) {
          continue;
        }
        paramString = "";
        if (this.mZc.getText() == null) {
          continue;
        }
        paramString = this.mZc.getText().toString();
        Object localObject = paramString;
        if (bk.bl(paramString)) {
          continue;
        }
        localObject = paramString;
        if (paramString.length() <= 50) {
          continue;
        }
        localObject = paramString.substring(0, 50);
        if (bk.bl((String)localObject)) {
          continue;
        }
        au.Hx();
        paramString = com.tencent.mm.model.c.Fw().abl(this.userName);
        paramString.df((String)localObject);
        au.Hx();
        localbv = com.tencent.mm.model.c.Fx().Id(this.userName);
        localbv.field_encryptUsername = this.userName;
        localbv.field_conRemark = ((String)localObject);
        au.Hx();
        com.tencent.mm.model.c.Fx().a(localbv);
        au.Hx();
        com.tencent.mm.model.c.Fw().U(paramString);
        this.fmY[2] = 1;
        if ((bk.bl(this.aVr)) || (((String)localObject).equals(this.aVr))) {
          continue;
        }
        this.fmY[5] = 1;
        paramString = new LinkedList();
        if (!(paramm instanceof com.tencent.mm.pluginsdk.model.m)) {
          break label968;
        }
        paramInt1 = ((com.tencent.mm.pluginsdk.model.m)paramm).bNb;
        paramString = ((com.tencent.mm.pluginsdk.model.m)paramm).rTv;
        if ((paramInt1 != 3) && (!(paramm instanceof com.tencent.mm.openim.b.p))) {
          continue;
        }
        localObject = com.tencent.mm.bh.d.RX().abU(this.userName);
        au.Hx();
        paramm = com.tencent.mm.model.c.Fw().abl(this.userName);
        if ((paramString == null) || (!paramString.contains(this.userName))) {
          continue;
        }
        paramString = paramm;
        if ((int)paramm.dBe != 0) {
          break label994;
        }
        paramm = com.tencent.mm.pluginsdk.ui.preference.b.a((ax)localObject);
        au.Hx();
        paramString = paramm;
        if (com.tencent.mm.model.c.Fw().V(paramm)) {
          break label994;
        }
        y.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
        au.Hx();
        paramString = com.tencent.mm.model.c.Fw().abl(this.userName);
        paramm = new qo();
        paramm.bZP.bZR = true;
        paramm.bZP.bZQ = false;
        paramm.bZP.username = this.userName;
        com.tencent.mm.sdk.b.a.udP.m(paramm);
        if (!this.mZf.wjS) {
          break label1032;
        }
        com.tencent.mm.model.s.k(paramString);
        if (!getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false)) {
          continue;
        }
        paramString = new Intent();
        paramString.putExtra("friend_message_transfer_username", this.userName);
        paramString.setAction("friend_message_accept_" + this.userName);
        paramString.putExtra("MMActivity.OverrideEnterAnimation", R.a.slide_right_in);
        paramString.putExtra("MMActivity.OverrideExitAnimation", R.a.slide_left_out);
        com.tencent.mm.br.d.b(this, "subapp", ".ui.friend.FMessageTransferUI", paramString);
        getIntent().putExtra("CONTACT_INFO_UI_SOURCE", 7);
        com.tencent.mm.plugin.report.service.h.nFQ.f(16055, new Object[] { Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.profile.b.S(getIntent())) });
        setResult(-1, getIntent());
        finish();
        return;
        if (bk.bl(this.aVr)) {
          break label958;
        }
        this.fmY[2] = 0;
        continue;
      }
      finally
      {
        y.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      if (i == 0) {
        continue;
      }
      y.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      au.Hx();
      com.tencent.mm.model.c.Dz().o(294913, localObject);
    }
    for (;;)
    {
      bv localbv;
      label884:
      this.fmY[2] = 2;
      label958:
      continue;
      label968:
      if (!(paramm instanceof com.tencent.mm.openim.b.p)) {
        break;
      }
      paramString.add(((com.tencent.mm.openim.b.p)paramm).ePQ);
      break;
      label994:
      com.tencent.mm.model.s.q(paramString);
      au.getNotification().wp();
      com.tencent.mm.bh.d.RY().du(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.bh(this.userName, this.fhj);
      continue;
      label1032:
      com.tencent.mm.model.s.l(paramString);
      continue;
      label1039:
      if ((paramInt1 != 4) || (paramInt2 != -24) || (bk.bl(paramString))) {
        break label1119;
      }
      Toast.makeText(this, paramString, 1).show();
    }
    for (;;)
    {
      label1069:
      if (!bk.bl(paramString))
      {
        com.tencent.mm.ui.base.h.a(this, paramString, getString(R.l.app_tip), getString(R.l.app_ok), null);
        break label884;
      }
      label1119:
      do
      {
        do
        {
          Toast.makeText(this, R.l.sendrequest_send_fail, 0).show();
          break label884;
          paramInt1 = 0;
          break;
        } while (paramInt1 != 4);
        if (paramInt2 == -2) {
          break label1069;
        }
      } while (paramInt2 != -101);
    }
  }
  
  public void onStop()
  {
    au.Dk().b(30, this);
    au.Dk().b(243, this);
    au.Dk().b(853, this);
    if (this.mZi)
    {
      au.Hx();
      com.tencent.mm.model.c.Fw().b(this.mZm);
    }
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI
 * JD-Core Version:    0.7.0.1
 */