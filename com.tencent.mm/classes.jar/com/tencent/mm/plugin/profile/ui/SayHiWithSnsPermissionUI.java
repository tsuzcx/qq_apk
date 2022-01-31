package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.an;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.b.q;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SayHiWithSnsPermissionUI
  extends MMActivity
  implements f
{
  private String blZ;
  private String bma;
  private String chatroomName;
  private ProgressDialog eeN;
  private int[] gEs;
  private int gyR;
  private String nZn;
  private EditText pCC;
  private EditText pCD;
  private View pCE;
  private TextView pCF;
  private MMSwitchBtn pCG;
  private boolean pCH;
  private boolean pCI;
  private boolean pCJ;
  private TextView pCK;
  private MMTagPanel pCL;
  private List<String> pCM;
  private n.b pCN;
  private CharSequence pCO;
  final boolean[] pCP;
  final boolean[] pCQ;
  private String pcq;
  private String userName;
  
  public SayHiWithSnsPermissionUI()
  {
    AppMethodBeat.i(23779);
    this.eeN = null;
    this.gEs = new int[8];
    this.pCN = new SayHiWithSnsPermissionUI.1(this);
    this.pCO = null;
    this.pCP = new boolean[] { true };
    this.pCQ = new boolean[] { false };
    AppMethodBeat.o(23779);
  }
  
  private void ccH()
  {
    AppMethodBeat.i(23785);
    com.tencent.mm.model.aw.aaz();
    bv localbv = com.tencent.mm.model.c.YB().TM(this.userName);
    if (localbv != null)
    {
      this.nZn = localbv.field_contactLabels;
      this.pCM = ((ArrayList)com.tencent.mm.plugin.label.a.a.bKV().RP(this.nZn));
    }
    if (this.pCJ) {
      ccI();
    }
    AppMethodBeat.o(23785);
  }
  
  private void ccI()
  {
    AppMethodBeat.i(23786);
    if (!bo.isNullOrNil(this.nZn))
    {
      this.pCL.setVisibility(0);
      this.pCK.setVisibility(4);
      this.pCL.a(this.pCM, this.pCM);
      AppMethodBeat.o(23786);
      return;
    }
    this.pCL.setVisibility(4);
    this.pCK.setVisibility(0);
    AppMethodBeat.o(23786);
  }
  
  public int getLayoutId()
  {
    return 2130970597;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23784);
    this.pCG = ((MMSwitchBtn)findViewById(2131827407).findViewById(2131820950));
    boolean bool = getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
    this.pCG.setCheck(bool);
    this.pCH = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
    this.pCI = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
    this.pCJ = getIntent().getBooleanExtra("sayhi_with_sns_perm_set_label", false);
    this.userName = getIntent().getStringExtra("Contact_User");
    this.gyR = getIntent().getIntExtra("Contact_Scene", 9);
    this.chatroomName = getIntent().getStringExtra("room_name");
    this.bma = getIntent().getStringExtra("Contact_RemarkName");
    this.blZ = getIntent().getStringExtra("Contact_Nick");
    this.pcq = getIntent().getStringExtra("Contact_RoomNickname");
    this.pCE = findViewById(2131827402);
    this.pCF = ((TextView)findViewById(2131827403));
    setMMTitle(getString(2131297005));
    Object localObject1;
    if (ad.arf(this.userName))
    {
      localObject1 = findViewById(2131827406);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    String str1;
    Object localObject2;
    String str2;
    if (this.pCH)
    {
      setMMTitle(getString(2131303132));
      this.pCC = ((EditText)findViewById(2131827397));
      this.pCC.setMinHeight(getContext().getResources().getDimensionPixelSize(2131427783));
      com.tencent.mm.ui.tools.b.c.d(this.pCC).QS(100).a(null);
      this.pCC.setFilters(com.tencent.mm.pluginsdk.ui.tools.g.wfe);
      this.pCC.addTextChangedListener(new SayHiWithSnsPermissionUI.2(this));
      ((LinearLayout)this.pCC.getParent()).setVisibility(0);
      com.tencent.mm.model.aw.aaz();
      str1 = (String)com.tencent.mm.model.c.Ru().get(294913, null);
      localObject2 = r.Zp();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      str2 = getString(2131303122);
      if (str2.length() + ((String)localObject1).length() <= 50) {
        break label1803;
      }
      localObject1 = ((String)localObject1).substring(0, 50 - str2.length());
    }
    label1803:
    for (;;)
    {
      localObject2 = str1;
      if (!bo.isNullOrNil(this.chatroomName))
      {
        ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.chatroomName);
        localObject2 = str1;
        if (localad != null)
        {
          localObject2 = str1;
          if (!bo.isNullOrNil(localad.field_nickname))
          {
            str1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oV(this.chatroomName).nE(r.Zn());
            localObject2 = str1;
            if (bo.aa(str1)) {
              localObject2 = localObject1;
            }
            ab.i("MicroMsg.SayHiWithSnsPermissionUI", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localad.field_nickname });
            localObject2 = com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), getResources().getString(2131303123, new Object[] { localad.field_nickname, localObject2 }), this.pCC.getTextSize());
            this.pCO = ((CharSequence)localObject2);
          }
        }
      }
      if (bo.aa(this.pCO)) {
        this.pCO = com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), String.format(str2, new Object[] { localObject1 }), this.pCC.getTextSize());
      }
      if (bo.aa((CharSequence)localObject2)) {
        this.pCC.setText(this.pCO);
      }
      for (;;)
      {
        this.pCC.requestFocus();
        this.pCC.postDelayed(new SayHiWithSnsPermissionUI.3(this), 100L);
        if (this.pCI)
        {
          this.pCD = ((EditText)findViewById(2131827401));
          ((LinearLayout)this.pCD.getParent()).setVisibility(0);
          if (!this.pCH) {
            this.pCD.clearFocus();
          }
          this.pCD.setMinHeight(getContext().getResources().getDimensionPixelSize(2131427783));
          com.tencent.mm.ui.tools.b.c.d(this.pCD).QS(100).a(null);
          this.pCD.setFilters(com.tencent.mm.pluginsdk.ui.tools.g.wfe);
          if (!this.pCH)
          {
            this.gEs[0] = 1;
            setMMTitle(getString(2131298858));
            localObject1 = (LinearLayout.LayoutParams)((View)this.pCD.getParent()).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, 0, ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
          }
          if (bo.isNullOrNil(this.bma)) {
            break;
          }
          this.pCD.setText(com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), this.bma, this.pCD.getTextSize()));
          this.gEs[6] = 1;
        }
        if (ad.arf(this.userName)) {
          this.pCJ = false;
        }
        if (this.pCJ)
        {
          this.pCK = ((TextView)findViewById(2131827404));
          this.pCL = ((MMTagPanel)findViewById(2131827405));
          this.pCL.setPanelClickable(false);
          ((LinearLayout)((FrameLayout)this.pCL.getParent()).getParent()).setVisibility(0);
          this.pCK.setOnClickListener(new SayHiWithSnsPermissionUI.5(this));
          this.pCL.setOnClickListener(new SayHiWithSnsPermissionUI.6(this));
        }
        ccH();
        if (!bo.isNullOrNil(this.nZn)) {
          this.gEs[7] = 1;
        }
        localObject1 = getString(2131297067);
        if (!this.pCH) {
          localObject1 = getString(2131296964);
        }
        addTextOptionMenu(0, (String)localObject1, new SayHiWithSnsPermissionUI.7(this), null, new SayHiWithSnsPermissionUI.8(this), q.b.zby);
        setBackBtn(new SayHiWithSnsPermissionUI.9(this));
        AppMethodBeat.o(23784);
        return;
        localObject1 = com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), (CharSequence)localObject2, this.pCC.getTextSize());
        this.pCC.setText((CharSequence)localObject1);
      }
      if (!bo.isNullOrNil(this.blZ))
      {
        this.pCD.setHint(com.tencent.mm.pluginsdk.ui.d.j.b(getContext(), this.blZ, this.pCD.getTextSize()));
        this.pCD.setOnFocusChangeListener(new SayHiWithSnsPermissionUI.4(this));
      }
      int i;
      switch (this.gyR)
      {
      case 9: 
      case 12: 
      default: 
        i = 0;
      }
      while ((!this.pCH) && (i == 0))
      {
        localObject1 = com.tencent.mm.bi.d.alh().ase(this.userName);
        if (localObject1 == null) {
          break;
        }
        localObject2 = com.tencent.mm.pluginsdk.ui.preference.b.c(this, (ax)localObject1);
        if ((bo.isNullOrNil(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).fjL)) || (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).fjL.equals(getString(2131300005)))) {
          break;
        }
        str1 = getString(2131303122).substring(0, getString(2131303122).indexOf("%s"));
        localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).fjL;
        if (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).fjL.startsWith(str1)) {
          localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).fjL.substring(str1.length());
        }
        this.pCE.setVisibility(0);
        this.pCF.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, bo.nullAsNil(getString(2131298755, new Object[] { ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).fjL })), this.pCF.getTextSize()));
        localObject2 = new k(getString(2131305994));
        ((k)localObject2).setSpan(new SayHiWithSnsPermissionUI.a(this, (String)localObject1), 0, ((k)localObject2).length(), 17);
        this.pCF.append(" ");
        this.pCF.append((CharSequence)localObject2);
        this.pCF.setMovementMethod(LinkMovementMethod.getInstance());
        this.gEs[3] = 3;
        break;
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(this.userName);
        if ((localObject1 == null) || (bo.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).apZ())) || (((com.tencent.mm.plugin.account.friend.a.a)localObject1).apZ().equals(this.pCD.getText().toString())))
        {
          i = 0;
        }
        else
        {
          this.pCE.setVisibility(0);
          this.pCF.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, bo.nullAsNil(getString(2131298753, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).apZ() })), this.pCF.getTextSize()));
          localObject2 = new k(getString(2131305994));
          ((k)localObject2).setSpan(new SayHiWithSnsPermissionUI.a(this, ((com.tencent.mm.plugin.account.friend.a.a)localObject1).apZ()), 0, ((k)localObject2).length(), 17);
          this.pCF.append(" ");
          this.pCF.append((CharSequence)localObject2);
          this.pCF.setMovementMethod(LinkMovementMethod.getInstance());
          this.gEs[3] = 1;
          i = 1;
          continue;
          if ((bo.isNullOrNil(this.pcq)) || (this.pcq.equals(this.pCD.getText().toString())))
          {
            i = 0;
          }
          else
          {
            this.pCE.setVisibility(0);
            this.pCF.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, bo.nullAsNil(getString(2131298752, new Object[] { this.pcq })), this.pCF.getTextSize()));
            localObject1 = new k(getString(2131305994));
            ((k)localObject1).setSpan(new SayHiWithSnsPermissionUI.a(this, this.pcq), 0, ((k)localObject1).length(), 17);
            this.pCF.append(" ");
            this.pCF.append((CharSequence)localObject1);
            this.pCF.setMovementMethod(LinkMovementMethod.getInstance());
            this.gEs[3] = 2;
            i = 1;
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23780);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(23780);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(23783);
    com.tencent.mm.plugin.report.service.h.qsU.e(14036, new Object[] { Integer.valueOf(this.gEs[0]), Integer.valueOf(this.gEs[1]), Integer.valueOf(this.gEs[2]), Integer.valueOf(this.gEs[3]), Integer.valueOf(this.gEs[4]), Integer.valueOf(this.gEs[5]), Integer.valueOf(this.gEs[6]), Integer.valueOf(this.gEs[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.b.pgQ.VX("ie_ver_usr");
    AppMethodBeat.o(23783);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(23791);
    if (paramInt == 4)
    {
      this.gEs[0] = 1;
      finish();
      AppMethodBeat.o(23791);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(23791);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(23781);
    if (this.pCJ)
    {
      com.tencent.mm.model.aw.aaz();
      com.tencent.mm.model.c.YA().a(this.pCN);
      ccH();
    }
    com.tencent.mm.model.aw.Rc().a(30, this);
    com.tencent.mm.model.aw.Rc().a(243, this);
    com.tencent.mm.model.aw.Rc().a(853, this);
    super.onResume();
    AppMethodBeat.o(23781);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(23790);
    long l = System.currentTimeMillis();
    ab.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    try
    {
      if (this.eeN != null)
      {
        this.eeN.dismiss();
        this.eeN = null;
      }
      if (this.pCH)
      {
        localObject = this.pCC.getText().toString().trim();
        if ((!bo.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.pCO)) && (bo.isNullOrNil(this.chatroomName))) {
          break label772;
        }
        com.tencent.mm.model.aw.aaz();
        com.tencent.mm.model.c.Ru().set(294913, "");
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label984;
      }
      com.tencent.mm.ui.base.h.bO(this, getString(2131303127));
      if (!this.pCI) {
        break label667;
      }
      paramString = "";
      if (this.pCD.getText() != null) {
        paramString = this.pCD.getText().toString();
      }
      localObject = paramString;
      if (!bo.isNullOrNil(paramString))
      {
        localObject = paramString;
        if (paramString.length() > 50) {
          localObject = paramString.substring(0, 50);
        }
      }
      if (bo.isNullOrNil((String)localObject)) {
        break label849;
      }
      com.tencent.mm.model.aw.aaz();
      paramString = com.tencent.mm.model.c.YA().arw(this.userName);
      paramString.jn((String)localObject);
      com.tencent.mm.model.aw.aaz();
      bv localbv = com.tencent.mm.model.c.YB().TM(this.userName);
      localbv.field_encryptUsername = this.userName;
      localbv.field_conRemark = ((String)localObject);
      com.tencent.mm.model.aw.aaz();
      com.tencent.mm.model.c.YB().replace(localbv);
      com.tencent.mm.model.aw.aaz();
      com.tencent.mm.model.c.YA().X(paramString);
      this.gEs[2] = 1;
      if ((!bo.isNullOrNil(this.blZ)) && (!((String)localObject).equals(this.blZ))) {
        this.gEs[5] = 1;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        label354:
        label496:
        ab.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + paramString.getMessage());
        label575:
        label740:
        return;
        label667:
        label849:
        if (bo.isNullOrNil(this.blZ)) {
          break;
        }
        label772:
        this.gEs[2] = 0;
      }
    }
    finally
    {
      ab.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(23790);
    }
    paramString = new LinkedList();
    if ((paramm instanceof com.tencent.mm.pluginsdk.model.m))
    {
      paramInt1 = ((com.tencent.mm.pluginsdk.model.m)paramm).cut;
      paramString = ((com.tencent.mm.pluginsdk.model.m)paramm).vKs;
      if ((paramInt1 == 3) || ((paramm instanceof q)))
      {
        localObject = com.tencent.mm.bi.d.alh().ase(this.userName);
        com.tencent.mm.model.aw.aaz();
        paramm = com.tencent.mm.model.c.YA().arw(this.userName);
        if ((paramString != null) && (paramString.contains(this.userName)))
        {
          paramString = paramm;
          if ((int)paramm.euF != 0) {
            break label939;
          }
          paramm = com.tencent.mm.pluginsdk.ui.preference.b.a((ax)localObject);
          com.tencent.mm.model.aw.aaz();
          paramString = paramm;
          if (com.tencent.mm.model.c.YA().Y(paramm)) {
            break label939;
          }
          ab.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
        }
        com.tencent.mm.model.aw.aaz();
        paramString = com.tencent.mm.model.c.YA().arw(this.userName);
        paramm = new ry();
        paramm.cIh.cIj = true;
        paramm.cIh.cIi = false;
        paramm.cIh.username = this.userName;
        com.tencent.mm.sdk.b.a.ymk.l(paramm);
        if (!this.pCG.ADA) {
          break label977;
        }
        t.k(paramString);
        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false))
        {
          paramString = new Intent();
          paramString.putExtra("friend_message_transfer_username", this.userName);
          paramString.setAction("friend_message_accept_" + this.userName);
          paramString.putExtra("MMActivity.OverrideEnterAnimation", 2131034266);
          paramString.putExtra("MMActivity.OverrideExitAnimation", 2131034263);
          com.tencent.mm.bq.d.b(this, "subapp", ".ui.friend.FMessageTransferUI", paramString);
        }
      }
      getIntent().putExtra("CONTACT_INFO_UI_SOURCE", 7);
      com.tencent.mm.plugin.report.service.h.qsU.e(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.al(getIntent())), Integer.valueOf(1), Integer.valueOf(1), this.userName });
      setResult(-1, getIntent());
      finish();
    }
    for (;;)
    {
      ab.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(23790);
      return;
      com.tencent.mm.model.aw.aaz();
      com.tencent.mm.model.c.Ru().set(294913, localObject);
      break;
      this.gEs[2] = 2;
      break label354;
      if (!(paramm instanceof q)) {
        break label1092;
      }
      paramString.add(((q)paramm).gfL);
      break label1092;
      label939:
      t.q(paramString);
      com.tencent.mm.model.aw.getNotification().IG();
      com.tencent.mm.bi.d.ali().eD(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.bI(this.userName, this.gyR);
      break label496;
      label977:
      t.l(paramString);
      break label575;
      label984:
      if ((paramInt1 != 4) || (paramInt2 != -24) || (bo.isNullOrNil(paramString))) {
        break label1097;
      }
      Toast.makeText(this, paramString, 1).show();
    }
    for (;;)
    {
      label1014:
      if (!bo.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.a(this, paramString, getString(2131297087), getString(2131297018), null);
        break label740;
      }
      label1092:
      label1097:
      do
      {
        do
        {
          if ((this.pCH) && ((paramInt2 == -24) || (paramInt2 == -34)))
          {
            Toast.makeText(this, 2131300013, 0).show();
            break label740;
          }
          Toast.makeText(this, 2131303126, 0).show();
          break label740;
          paramInt1 = 0;
          break;
        } while (paramInt1 != 4);
        if (paramInt2 == -2) {
          break label1014;
        }
      } while (paramInt2 != -101);
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(23782);
    com.tencent.mm.model.aw.Rc().b(30, this);
    com.tencent.mm.model.aw.Rc().b(243, this);
    com.tencent.mm.model.aw.Rc().b(853, this);
    if (this.pCJ)
    {
      com.tencent.mm.model.aw.aaz();
      com.tencent.mm.model.c.YA().b(this.pCN);
    }
    super.onStop();
    AppMethodBeat.o(23782);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI
 * JD-Core Version:    0.7.0.1
 */