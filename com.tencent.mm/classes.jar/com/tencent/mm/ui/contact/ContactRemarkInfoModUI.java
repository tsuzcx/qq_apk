package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private MMClearEditText AbR;
  private TextView AbS;
  private MMEditText AbT;
  private TextView AbU;
  private TextView AbV;
  private TextView AbW;
  private TextView AbX;
  private ImageView AbY;
  private ImageView AbZ;
  private TextView Aca;
  private View Acb;
  private View Acc;
  private String Acd;
  private boolean Ace;
  private boolean Acf;
  private boolean Acg;
  private boolean Ach;
  private boolean Aci;
  private ContactRemarkInfoModUI.a Acj;
  private TextView Ack;
  private ScrollView Acl;
  private ProfileEditPhoneNumberView Acm;
  private String Acn;
  private String Aco;
  private TextWatcher Acp;
  private ContactRemarkInfoModUI.b Acq;
  private String Acr;
  boolean Acs;
  boolean Act;
  private boolean Acu;
  private String bma;
  private ad contact;
  private String dqT;
  private String fNq;
  private ProgressDialog fsw;
  private int gyR;
  private String nZn;
  private MMTagPanel pCL;
  private List<String> pCM;
  private n.b pCN;
  private String username;
  private String wbt;
  
  public ContactRemarkInfoModUI()
  {
    AppMethodBeat.i(33651);
    this.Ace = false;
    this.Acf = false;
    this.Acg = false;
    this.Ach = false;
    this.Aci = false;
    this.Acj = new ContactRemarkInfoModUI.a(this, (byte)0);
    this.Acp = new ContactRemarkInfoModUI.1(this);
    this.Acq = new ContactRemarkInfoModUI.b(this, (byte)0);
    this.pCN = new ContactRemarkInfoModUI.10(this);
    this.Acs = true;
    this.Act = false;
    this.Acu = false;
    AppMethodBeat.o(33651);
  }
  
  private void J(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(33657);
    if (this.Acg)
    {
      this.AbU.setVisibility(8);
      if ((paramBoolean) && (ah.isNullOrNil(this.dqT)))
      {
        this.AbV.setVisibility(0);
        this.Acc.setVisibility(8);
      }
      for (;;)
      {
        this.AbR.setVisibility(0);
        AppMethodBeat.o(33657);
        return;
        if (paramInt == 2131823235)
        {
          this.AbV.setVisibility(8);
          this.Acc.setVisibility(0);
        }
      }
    }
    this.AbU.setVisibility(0);
    this.AbV.setVisibility(0);
    this.AbR.setVisibility(8);
    this.Acc.setVisibility(8);
    AppMethodBeat.o(33657);
  }
  
  private void JW()
  {
    AppMethodBeat.i(33652);
    ProfileEditPhoneNumberView localProfileEditPhoneNumberView = this.Acm;
    Object localObject = localProfileEditPhoneNumberView.getPhoneNumberList();
    boolean bool;
    if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
    {
      if (localProfileEditPhoneNumberView.vRt == null) {
        break label166;
      }
      bool = true;
    }
    for (;;)
    {
      this.Acu = bool;
      if ((!dLN()) && (!dLO()) && (!rh(false)) && (!this.Acu)) {
        break;
      }
      enableOptionMenu(true);
      AppMethodBeat.o(33652);
      return;
      if (localProfileEditPhoneNumberView.vRt == null)
      {
        bool = true;
      }
      else if (((ArrayList)localObject).size() != localProfileEditPhoneNumberView.vRt.length)
      {
        bool = true;
      }
      else
      {
        localObject = ((ArrayList)localObject).iterator();
        int i = 0;
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label166;
          }
          if (!((String)((Iterator)localObject).next()).equals(localProfileEditPhoneNumberView.vRt[i]))
          {
            bool = true;
            break;
          }
          i += 1;
        }
        label166:
        bool = false;
      }
    }
    enableOptionMenu(false);
    AppMethodBeat.o(33652);
  }
  
  private String auA(String paramString)
  {
    AppMethodBeat.i(33674);
    if (!e.cN(paramString))
    {
      AppMethodBeat.o(33674);
      return null;
    }
    int i = BackwardSupportUtil.ExifHelper.bY(paramString);
    Object localObject = new StringBuilder();
    com.tencent.mm.bc.c.aiT();
    localObject = com.tencent.mm.bc.c.tU(this.username) + ".tmp";
    if (!com.tencent.mm.sdk.platformtools.d.a(paramString, 960, 960, Bitmap.CompressFormat.JPEG, 70, (String)localObject))
    {
      ab.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
      AppMethodBeat.o(33674);
      return null;
    }
    if ((i != 0) && (!com.tencent.mm.sdk.platformtools.d.a((String)localObject, i, Bitmap.CompressFormat.JPEG, 70, (String)localObject)))
    {
      ab.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
      AppMethodBeat.o(33674);
      return null;
    }
    AppMethodBeat.o(33674);
    return localObject;
  }
  
  private void auz(String paramString)
  {
    AppMethodBeat.i(33662);
    if (ah.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33662);
      return;
    }
    paramString = new com.tencent.mm.vfs.b(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(33662);
      return;
    }
    if (paramString.length() > 204800L)
    {
      h.b(this, getString(2131298566), null, true);
      AppMethodBeat.o(33662);
      return;
    }
    float f = com.tencent.mm.cb.a.getDensity(this);
    paramString = BackwardSupportUtil.b.k(this.Acd, f);
    if (paramString != null)
    {
      this.AbW.setVisibility(8);
      this.AbZ.setVisibility(8);
      this.AbY.setVisibility(0);
      this.AbY.setImageBitmap(paramString);
      this.Ace = true;
    }
    AppMethodBeat.o(33662);
  }
  
  private void ccH()
  {
    AppMethodBeat.i(33676);
    aw.aaz();
    this.contact = com.tencent.mm.model.c.YA().arw(this.username);
    this.nZn = this.contact.field_contactLabelIds;
    this.pCM = com.tencent.mm.plugin.label.a.a.bKV().RQ(this.nZn);
    ccI();
    AppMethodBeat.o(33676);
  }
  
  private void ccI()
  {
    AppMethodBeat.i(33675);
    if (!ah.isNullOrNil(this.nZn))
    {
      this.pCL.setVisibility(0);
      this.Ack.setVisibility(8);
      this.pCL.a(this.pCM, this.pCM);
      AppMethodBeat.o(33675);
      return;
    }
    this.pCL.setVisibility(8);
    this.Ack.setVisibility(0);
    AppMethodBeat.o(33675);
  }
  
  private void dLK()
  {
    AppMethodBeat.i(33659);
    this.AbS.setFocusableInTouchMode(true);
    this.AbS.requestFocus();
    this.AbR.clearFocus();
    this.AbT.clearFocus();
    this.Acm.clearFocus();
    hideVKB();
    AppMethodBeat.o(33659);
  }
  
  private void dLL()
  {
    AppMethodBeat.i(33661);
    com.tencent.mm.bc.c.aiT();
    Bitmap localBitmap = com.tencent.mm.bc.c.tX(this.username);
    if (localBitmap != null)
    {
      this.AbW.setVisibility(8);
      this.AbZ.setVisibility(8);
      this.AbY.setVisibility(0);
      this.AbY.setImageBitmap(localBitmap);
    }
    this.Ace = true;
    AppMethodBeat.o(33661);
  }
  
  private void dLM()
  {
    AppMethodBeat.i(33665);
    if (!this.Acu)
    {
      AppMethodBeat.o(33665);
      return;
    }
    Object localObject2 = new bej();
    ((bej)localObject2).xtI = this.username;
    Object localObject3 = new bmi();
    Object localObject1 = this.Acm.getPhoneNumberList();
    if (localObject1 == null) {}
    for (int i = 0;; i = ((ArrayList)localObject1).size())
    {
      ((bmi)localObject3).jJu = i;
      ((bmi)localObject3).xAM = new LinkedList();
      if (localObject1 == null) {
        break;
      }
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        bmh localbmh = new bmh();
        localbmh.xAL = str;
        ((bmi)localObject3).xAM.add(localbmh);
      }
    }
    ((bej)localObject2).xtE = ((bmi)localObject3);
    aw.aaz();
    com.tencent.mm.model.c.Yz().c(new j.a(60, (com.tencent.mm.bv.a)localObject2));
    aw.aaz();
    localObject2 = com.tencent.mm.model.c.YA().arw(this.username);
    if ((localObject2 != null) && ((int)((com.tencent.mm.n.a)localObject2).euF > 0) && (com.tencent.mm.n.a.je(((aq)localObject2).field_type)))
    {
      if (localObject1 != null)
      {
        localObject3 = ((ArrayList)localObject1).iterator();
        for (localObject1 = "";; localObject1 = (String)localObject1 + ",")
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject3).next();
          localObject1 = (String)localObject1 + (String)localObject2;
        }
      }
      localObject2 = "";
      ab.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", new Object[] { this.username, localObject2 });
      this.contact.jS((String)localObject2);
      aw.aaz();
      com.tencent.mm.model.c.YA().X(this.contact);
    }
    AppMethodBeat.o(33665);
  }
  
  private boolean dLN()
  {
    AppMethodBeat.i(33667);
    String str = this.AbT.getText().toString();
    if (((this.dqT == null) || (!this.dqT.equals(str))) && ((!ah.isNullOrNil(this.dqT)) || (!ah.isNullOrNil(str))))
    {
      AppMethodBeat.o(33667);
      return true;
    }
    AppMethodBeat.o(33667);
    return false;
  }
  
  private boolean dLO()
  {
    AppMethodBeat.i(33668);
    if ((!ah.isNullOrNil(this.Acd)) || (this.Aci))
    {
      AppMethodBeat.o(33668);
      return true;
    }
    AppMethodBeat.o(33668);
    return false;
  }
  
  private void dLP()
  {
    AppMethodBeat.i(33672);
    this.Aci = true;
    this.AbZ.setVisibility(8);
    this.AbW.setVisibility(0);
    this.AbY.setVisibility(8);
    this.AbY.setImageBitmap(null);
    JW();
    AppMethodBeat.o(33672);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(33669);
    boolean bool1 = dLO();
    boolean bool2 = rh(true);
    boolean bool3 = dLN();
    if ((bool1) || (bool2) || (bool3))
    {
      h.d(this, getString(2131298726), null, getString(2131298728), getString(2131298727), new ContactRemarkInfoModUI.8(this), new ContactRemarkInfoModUI.9(this));
      AppMethodBeat.o(33669);
      return;
    }
    hideVKB();
    finish();
    AppMethodBeat.o(33669);
  }
  
  private boolean rh(boolean paramBoolean)
  {
    AppMethodBeat.i(33666);
    String str = this.AbR.getText().toString();
    if (!paramBoolean)
    {
      if (((this.bma == null) || (!this.bma.equals(str))) && ((!ah.isNullOrNil(this.bma)) || (!ah.isNullOrNil(str))))
      {
        AppMethodBeat.o(33666);
        return true;
      }
      AppMethodBeat.o(33666);
      return false;
    }
    if (((this.bma == null) || (!this.bma.equals(str))) && ((!ah.isNullOrNil(this.bma)) || (!ah.isNullOrNil(str)))) {}
    for (int i = 1; (i != 0) && ((str == null) || (!str.equals(this.contact.field_nickname))); i = 0)
    {
      AppMethodBeat.o(33666);
      return true;
    }
    AppMethodBeat.o(33666);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130969268;
  }
  
  public void initView()
  {
    AppMethodBeat.i(33660);
    this.AbS = ((TextView)findViewById(2131823223));
    this.AbU = ((TextView)findViewById(2131823225));
    this.AbV = ((TextView)findViewById(2131823235));
    this.AbW = ((TextView)findViewById(2131823236));
    this.AbR = ((MMClearEditText)findViewById(2131823224));
    this.AbT = ((MMEditText)findViewById(2131823233));
    this.AbY = ((ImageView)findViewById(2131823238));
    this.AbZ = ((ImageView)findViewById(2131823237));
    this.AbX = ((TextView)findViewById(2131823234));
    this.Acc = findViewById(2131823232);
    this.Acm = ((ProfileEditPhoneNumberView)findViewById(2131823231));
    this.Acm.lpe = this.contact;
    Object localObject1 = this.Acm;
    Object localObject2 = this.Acn;
    String str = this.Aco;
    ((ProfileEditPhoneNumberView)localObject1).vRr = ((String)localObject2);
    ((ProfileEditPhoneNumberView)localObject1).vRs = str;
    ((ProfileEditPhoneNumberView)localObject1).ccG();
    this.Acm.vRw = new ContactRemarkInfoModUI.11(this);
    this.pCL = ((MMTagPanel)findViewById(2131823230));
    this.pCL.setPanelClickable(false);
    this.Acl = ((ScrollView)findViewById(2131823222));
    this.Ack = ((TextView)findViewById(2131823229));
    this.Ack.setText(2131301604);
    this.pCL.setOnClickListener(this.Acj);
    this.Ack.setOnClickListener(this.Acj);
    setMMTitle(2131298670);
    label631:
    int i;
    if (!ah.isNullOrNil(this.bma))
    {
      this.AbR.setText(j.b(this, ah.nullAsNil(this.bma), this.AbR.getTextSize()));
      this.AbU.setText(j.b(this, ah.nullAsNil(this.bma), this.AbU.getTextSize()));
      this.AbR.setSelection(this.AbR.getText().length());
      localObject1 = j.b(this, ah.nullAsNil(this.dqT), this.AbV.getTextSize());
      this.AbT.setText((CharSequence)localObject1);
      this.AbT.setSelection(this.AbT.getText().length());
      if (!ah.isNullOrNil(this.dqT))
      {
        this.AbV.setText(j.b(this, ah.nullAsNil(this.dqT), this.AbV.getTextSize()));
        this.AbV.setTextColor(getResources().getColor(2131690322));
      }
      this.AbU.setOnClickListener(new ContactRemarkInfoModUI.12(this));
      this.AbV.setOnClickListener(new ContactRemarkInfoModUI.13(this));
      this.AbR.addTextChangedListener(this.Acp);
      this.AbX.setText(com.tencent.mm.ui.tools.f.bO(800, this.AbT.getEditableText().toString()));
      this.AbT.addTextChangedListener(this.Acq);
      if (ah.isNullOrNil(this.fNq)) {
        break label915;
      }
      this.AbW.setVisibility(8);
      this.AbY.setVisibility(0);
      com.tencent.mm.bc.c.aiT();
      if (com.tencent.mm.bc.c.tV(this.username)) {
        break label908;
      }
      com.tencent.mm.bc.c.aiT().a(this.username, this.fNq, new com.tencent.mm.bc.c.a()
      {
        public final void db(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(153954);
          ContactRemarkInfoModUI.t(ContactRemarkInfoModUI.this).post(new ContactRemarkInfoModUI.5.1(this, paramAnonymousBoolean));
          AppMethodBeat.o(153954);
        }
      });
      this.AbY.setOnClickListener(new ContactRemarkInfoModUI.14(this));
      this.AbW.setOnClickListener(new ContactRemarkInfoModUI.15(this));
      localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(this.contact.field_username);
      if ((localObject1 != null) && (!ah.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).apZ())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).apZ().equals(this.AbR.getText().toString()))) {
        break label935;
      }
      i = 0;
      label711:
      if ((i == 0) && (this.gyR == 14) && (!ah.isNullOrNil(this.wbt)) && (!this.wbt.equals(this.AbR.getText().toString()))) {
        break label1067;
      }
      label754:
      addTextOptionMenu(0, getString(2131296964), new ContactRemarkInfoModUI.16(this), null, q.b.zby);
      setBackBtn(new ContactRemarkInfoModUI.17(this));
      if (!ah.isNullOrNil(this.bma)) {
        break label1208;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.AbZ.setOnClickListener(new ContactRemarkInfoModUI.2(this));
      if (!this.Ach)
      {
        this.Acg = true;
        J(true, -1);
      }
      dLK();
      AppMethodBeat.o(33660);
      return;
      this.AbR.setText(j.b(this, ah.nullAsNil(this.contact.Oe()), this.AbR.getTextSize()));
      this.AbU.setText(j.b(this, ah.nullAsNil(this.contact.Oe()), this.AbR.getTextSize()));
      break;
      label908:
      dLL();
      break label631;
      label915:
      this.AbW.setVisibility(0);
      this.AbY.setVisibility(8);
      break label631;
      label935:
      this.Aca = ((TextView)findViewById(2131823227));
      this.Acb = findViewById(2131823226);
      this.Acb.setVisibility(0);
      this.Aca.setText(ah.nullAsNil(getString(2131298753, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).apZ() })));
      localObject2 = new k(getString(2131305994));
      ((k)localObject2).setSpan(new ContactRemarkInfoModUI.c(this, ((com.tencent.mm.plugin.account.friend.a.a)localObject1).apZ()), 0, ((k)localObject2).length(), 17);
      this.Aca.append(" ");
      this.Aca.append((CharSequence)localObject2);
      this.Aca.setMovementMethod(LinkMovementMethod.getInstance());
      i = 1;
      break label711;
      label1067:
      this.Aca = ((TextView)findViewById(2131823227));
      this.Acb = findViewById(2131823226);
      this.Acb.setVisibility(0);
      this.Aca.setText(j.b(this, ah.nullAsNil(getString(2131298752, new Object[] { this.wbt })), this.Aca.getTextSize()));
      localObject1 = new k(getString(2131305994));
      ((k)localObject1).setSpan(new ContactRemarkInfoModUI.c(this, this.wbt), 0, ((k)localObject1).length(), 17);
      this.Aca.append(" ");
      this.Aca.append((CharSequence)localObject1);
      this.Aca.setMovementMethod(LinkMovementMethod.getInstance());
      break label754;
      label1208:
      enableOptionMenu(false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(33671);
    ab.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      ab.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
      AppMethodBeat.o(33671);
      return;
    }
    Context localContext;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(33671);
      return;
    case 100: 
      localContext = getApplicationContext();
      aw.aaz();
      paramIntent = n.h(localContext, paramIntent, com.tencent.mm.model.c.YK());
      if (paramIntent == null)
      {
        AppMethodBeat.o(33671);
        return;
      }
      this.Acd = auA(paramIntent);
      auz(this.Acd);
      this.Acf = true;
      this.Aci = false;
      JW();
      AppMethodBeat.o(33671);
      return;
    case 200: 
      localContext = getApplicationContext();
      aw.aaz();
      paramIntent = com.tencent.mm.ui.tools.a.i(localContext, paramIntent, com.tencent.mm.model.c.YK());
      if (paramIntent == null)
      {
        AppMethodBeat.o(33671);
        return;
      }
      this.Acd = auA(paramIntent);
      auz(this.Acd);
      this.Acf = true;
      this.Aci = false;
      JW();
      AppMethodBeat.o(33671);
      return;
    case 400: 
      if (paramIntent.getBooleanExtra("response_delete", false)) {
        dLP();
      }
      AppMethodBeat.o(33671);
      return;
    }
    if ((rh(true)) || (dLN()) || (dLO()) || (paramIntent.getBooleanExtra("hasLableChange", false)))
    {
      enableOptionMenu(true);
      AppMethodBeat.o(33671);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(33671);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(33653);
    super.onCreate(paramBundle);
    aw.Rc().a(575, this);
    aw.Rc().a(576, this);
    this.gyR = getIntent().getIntExtra("Contact_Scene", 9);
    this.wbt = getIntent().getStringExtra("Contact_RoomNickname");
    this.Ach = getIntent().getBooleanExtra("view_mode", false);
    this.Acr = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
    this.Acn = getIntent().getStringExtra("contact_phone_number_by_md5");
    this.Aco = getIntent().getStringExtra("contact_phone_number_list");
    this.username = getIntent().getStringExtra("Contact_User");
    if (ah.isNullOrNil(this.username))
    {
      finish();
      AppMethodBeat.o(33653);
      return;
    }
    aw.aaz();
    this.contact = com.tencent.mm.model.c.YA().arw(this.username);
    this.bma = this.contact.field_conRemark;
    this.dqT = this.contact.dqT;
    this.fNq = this.contact.dqU;
    this.nZn = this.contact.field_contactLabelIds;
    this.pCM = com.tencent.mm.plugin.label.a.a.bKV().RQ(this.nZn);
    initView();
    JW();
    int i;
    if ((this.contact != null) && (ad.arf(this.contact.field_username))) {
      i = 1;
    }
    while (i != 0) {
      if (this.AbR == null)
      {
        AppMethodBeat.o(33653);
        return;
        i = 0;
      }
      else
      {
        paramBundle = (ViewGroup)this.AbR.getParent();
        ViewGroup localViewGroup = (ViewGroup)paramBundle.getParent();
        int k = localViewGroup.getChildCount();
        i = j;
        while (i < k)
        {
          View localView = localViewGroup.getChildAt(i);
          if (localView != paramBundle) {
            localView.setVisibility(8);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(33653);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33656);
    aw.Rc().b(575, this);
    aw.Rc().b(576, this);
    this.AbR.removeTextChangedListener(this.Acp);
    this.AbT.removeTextChangedListener(this.Acq);
    super.onDestroy();
    AppMethodBeat.o(33656);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33670);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      goBack();
      AppMethodBeat.o(33670);
      return true;
    }
    AppMethodBeat.o(33670);
    return false;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33655);
    aw.aaz();
    com.tencent.mm.model.c.YA().b(this.pCN);
    super.onPause();
    AppMethodBeat.o(33655);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33654);
    super.onResume();
    aw.aaz();
    com.tencent.mm.model.c.YA().a(this.pCN);
    ccH();
    AppMethodBeat.o(33654);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(33673);
    ab.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fsw != null)
    {
      this.fsw.dismiss();
      this.fsw = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      h.b(this, getString(2131296925), null, true);
      AppMethodBeat.o(33673);
      return;
    }
    if (paramm.getType() == 575)
    {
      if (this.Acd != null)
      {
        paramString = new com.tencent.mm.vfs.b(this.Acd);
        if (paramString.exists())
        {
          com.tencent.mm.bc.c.aiT();
          paramString.p(new com.tencent.mm.vfs.b(com.tencent.mm.bc.c.tU(this.username)));
        }
      }
      paramString = ((com.tencent.mm.bc.b)paramm).fNq;
      if (!ah.isNullOrNil(paramString)) {
        this.fNq = paramString;
      }
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(33673);
      return;
      if (paramm.getType() == 576)
      {
        this.Acd = null;
        this.fNq = null;
        this.Ace = false;
        aw.aaz();
        this.contact = com.tencent.mm.model.c.YA().arw(this.username);
        this.contact.jN("");
        aw.aaz();
        com.tencent.mm.model.c.YA().b(this.username, this.contact);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI
 * JD-Core Version:    0.7.0.1
 */