package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.pp;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SayHiWithSnsPermissionUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String bNK;
  private String bNL;
  private String chatroomName;
  private long dsf;
  private ProgressDialog fpP;
  private int ima;
  private int[] isb;
  int scene;
  private String tZO;
  private boolean uEA;
  private boolean uEB;
  private CharSequence uEC;
  final boolean[] uED;
  final boolean[] uEE;
  private int uEF;
  int uEG;
  int uEH;
  private MMSwitchBtn uEa;
  private MMSwitchBtn uEb;
  private WeImageView uEc;
  private WeImageView uEd;
  private boolean uEe;
  private boolean uEf;
  private EditText uEu;
  private EditText uEv;
  private View uEw;
  private TextView uEx;
  private boolean uEy;
  private boolean uEz;
  private String userName;
  
  public SayHiWithSnsPermissionUI()
  {
    AppMethodBeat.i(27407);
    this.fpP = null;
    this.isb = new int[8];
    this.uEe = false;
    this.uEf = false;
    this.uEA = false;
    this.uEB = false;
    this.uEC = null;
    this.uED = new boolean[] { true };
    this.uEE = new boolean[] { false };
    this.dsf = System.currentTimeMillis();
    this.uEF = 0;
    this.uEG = 1;
    this.uEH = 1;
    this.scene = 11;
    AppMethodBeat.o(27407);
  }
  
  private static boolean akH(String paramString)
  {
    AppMethodBeat.i(27416);
    boolean bool = com.tencent.mm.plugin.sns.c.o.wzJ.akH(paramString);
    AppMethodBeat.o(27416);
    return bool;
  }
  
  private void dcW()
  {
    int j = 8;
    int k = 4;
    AppMethodBeat.i(27413);
    Object localObject = this.uEc;
    if ((this.uEA) || (this.uEf))
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.uEd;
      i = k;
      if (!this.uEA)
      {
        i = k;
        if (!this.uEf) {
          i = 0;
        }
      }
      ((WeImageView)localObject).setVisibility(i);
      ((View)this.uEc.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27402);
          SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).setVisibility(0);
          SayHiWithSnsPermissionUI.o(SayHiWithSnsPermissionUI.this).setVisibility(4);
          SayHiWithSnsPermissionUI.this.findViewById(2131302905).setVisibility(8);
          AppMethodBeat.o(27402);
        }
      });
      View localView = (View)this.uEd.getParent();
      if (!this.uEf) {
        break label242;
      }
      localObject = null;
      label114:
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = findViewById(2131302905);
      if ((!this.uEB) && ((!this.uEe) || ((!this.uEA) && (!this.uEf)))) {
        break label255;
      }
      i = 8;
      label160:
      ((View)localObject).setVisibility(i);
      localObject = (TextView)findViewById(2131305037);
      if (!this.uEf) {
        break label260;
      }
    }
    label260:
    for (int i = getResources().getColor(2131100490);; i = getResources().getColor(2131100711))
    {
      ((TextView)localObject).setTextColor(i);
      localObject = findViewById(2131305647);
      i = j;
      if (this.uEf) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      this.uEA = false;
      AppMethodBeat.o(27413);
      return;
      i = 4;
      break;
      label242:
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27403);
          SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).setVisibility(4);
          SayHiWithSnsPermissionUI.o(SayHiWithSnsPermissionUI.this).setVisibility(0);
          SayHiWithSnsPermissionUI.this.findViewById(2131302905).setVisibility(0);
          AppMethodBeat.o(27403);
        }
      };
      break label114;
      label255:
      i = 0;
      break label160;
    }
  }
  
  private String dcZ()
  {
    AppMethodBeat.i(27414);
    String str = "";
    if (this.uEv.getText() != null) {
      str = this.uEv.getText().toString();
    }
    if (!bt.isNullOrNil(str))
    {
      if (str.length() <= 50)
      {
        AppMethodBeat.o(27414);
        return str;
      }
      str = str.substring(0, 50);
      AppMethodBeat.o(27414);
      return str;
    }
    AppMethodBeat.o(27414);
    return str;
  }
  
  private void ob(boolean paramBoolean)
  {
    AppMethodBeat.i(27418);
    final int i;
    if (this.uEy)
    {
      i = 1;
      if (!bt.isNullOrNil(dcZ())) {
        break label313;
      }
      this.uEG = 3;
      label30:
      if (!this.uEf) {
        break label349;
      }
      this.uEH = 6;
      label43:
      switch (this.ima)
      {
      case 2: 
      case 4: 
      case 5: 
      case 7: 
      case 8: 
      case 9: 
      case 11: 
      case 12: 
      case 16: 
      case 19: 
      case 20: 
      case 25: 
      case 31: 
      case 32: 
      case 33: 
      case 34: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      case 42: 
      case 43: 
      case 46: 
      case 47: 
      case 50: 
      case 51: 
      default: 
        this.scene = 11;
      }
    }
    for (;;)
    {
      com.tencent.e.h.Iye.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191197);
          com.tencent.mm.model.az.arV();
          int i = com.tencent.mm.model.c.apM().c(com.tencent.mm.model.w.gMw, new String[] { u.aqG(), "weixin", "helper_entry", "filehelper" });
          com.tencent.mm.plugin.report.service.h.vKh.f(18713, new Object[] { SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), Integer.valueOf(i), Integer.valueOf(SayHiWithSnsPermissionUI.this.uEG), Integer.valueOf(SayHiWithSnsPermissionUI.this.uEH), Integer.valueOf(SayHiWithSnsPermissionUI.this.scene), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - SayHiWithSnsPermissionUI.q(SayHiWithSnsPermissionUI.this)), Integer.valueOf(i) });
          AppMethodBeat.o(191197);
        }
      });
      AppMethodBeat.o(27418);
      return;
      if (paramBoolean)
      {
        i = 2;
        break;
      }
      i = 3;
      break;
      label313:
      if ((!dcZ().equals(this.bNK)) && (!dcZ().equals(this.tZO))) {
        break label30;
      }
      this.uEG = 2;
      break label30;
      label349:
      if ((this.uEF & 0x8) != 0)
      {
        this.uEH = 5;
        break label43;
      }
      if (((this.uEF & 0x1) != 0) && ((this.uEF & 0x2) != 0))
      {
        this.uEH = 4;
        break label43;
      }
      if ((this.uEF & 0x2) != 0)
      {
        this.uEH = 3;
        break label43;
      }
      if ((this.uEF & 0x1) == 0) {
        break label43;
      }
      this.uEH = 2;
      break label43;
      this.scene = 1;
      continue;
      this.scene = 2;
      continue;
      this.scene = 3;
      continue;
      this.scene = 4;
      continue;
      this.scene = 5;
      continue;
      this.scene = 6;
      continue;
      this.scene = 7;
      continue;
      this.scene = 8;
      continue;
      this.scene = 9;
      continue;
      this.scene = 10;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495282;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27412);
    this.uEy = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
    this.uEz = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
    this.userName = getIntent().getStringExtra("Contact_User");
    this.ima = getIntent().getIntExtra("Contact_Scene", 9);
    this.chatroomName = getIntent().getStringExtra("room_name");
    this.bNL = getIntent().getStringExtra("Contact_RemarkName");
    this.bNK = getIntent().getStringExtra("Contact_Nick");
    this.tZO = getIntent().getStringExtra("Contact_RoomNickname");
    this.uEw = findViewById(2131302421);
    this.uEx = ((TextView)findViewById(2131302422));
    Object localObject1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd();
    int i;
    boolean bool;
    label184:
    label255:
    String str1;
    label433:
    label456:
    label502:
    Object localObject2;
    String str2;
    if (com.tencent.mm.sdk.platformtools.h.DEBUG)
    {
      i = 1;
      if (((com.tencent.mm.m.e)localObject1).getInt("MMSocialBlackListFlag", i) != 1) {
        break label1125;
      }
      bool = true;
      this.uEe = bool;
      if (!this.uEe) {
        findViewById(2131305648).setVisibility(8);
      }
      com.tencent.mm.kernel.g.afC();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.userName);
      if (com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.Fxs, 0) != 1) {
        break label1130;
      }
      bool = true;
      this.uEA = bool;
      this.uEa = ((MMSwitchBtn)findViewById(2131302903).findViewById(2131302906));
      getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
      this.uEa.setCheck(((af)localObject1).ZP());
      this.uEc = ((WeImageView)findViewById(2131305646));
      this.uEd = ((WeImageView)findViewById(2131305036));
      this.uEb = ((MMSwitchBtn)findViewById(2131304942).findViewById(2131302910));
      bool = akH(this.userName);
      this.uEb.setCheck(bool);
      findViewById(2131297422).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27392);
          SayHiWithSnsPermissionUI.this.hideVKB();
          AppMethodBeat.o(27392);
        }
      });
      i = ((com.tencent.mm.g.c.au)localObject1).evp;
      ad.d("MicroMsg.SayHiWithSnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject1 = (TextView)findViewById(2131302907);
      if (i != 1) {
        break label1135;
      }
      ((TextView)localObject1).setText(2131763930);
      localObject1 = (TextView)findViewById(2131302911);
      if (i != 1) {
        break label1150;
      }
      ((TextView)localObject1).setText(2131763786);
      bool = af.aHH(this.userName);
      this.uEB = bool;
      if (!bool) {
        break label1165;
      }
      findViewById(2131305648).setVisibility(8);
      localObject1 = findViewById(2131302905);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (this.uEy)
      {
        this.uEu = ((EditText)findViewById(2131304291));
        com.tencent.mm.ui.tools.b.c.d(this.uEu).aaj(100).a(null);
        this.uEu.setFilters(j.CmX);
        this.uEu.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(27393);
            if (SayHiWithSnsPermissionUI.this.uED[0] != 0)
            {
              SayHiWithSnsPermissionUI.this.uED[0] = false;
              com.tencent.mm.plugin.normsg.a.b.ufs.ajr("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.b.ufs.ajs("ie_ver_usr");
            AppMethodBeat.o(27393);
          }
        });
        ((LinearLayout)this.uEu.getParent()).setVisibility(0);
        com.tencent.mm.model.az.arV();
        str1 = (String)com.tencent.mm.model.c.afk().get(294913, null);
        localObject2 = u.aqI();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        str2 = getString(2131763071);
        if (str2.length() + ((String)localObject1).length() <= 50) {
          break label1883;
        }
        localObject1 = ((String)localObject1).substring(0, 50 - str2.length());
      }
    }
    label1165:
    label1200:
    label1883:
    for (;;)
    {
      localObject2 = str1;
      if (!bt.isNullOrNil(this.chatroomName))
      {
        af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.chatroomName);
        localObject2 = str1;
        if (localaf != null)
        {
          localObject2 = str1;
          if (!bt.isNullOrNil(localaf.field_nickname))
          {
            str1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tI(this.chatroomName).sh(u.aqG());
            localObject2 = str1;
            if (bt.ai(str1)) {
              localObject2 = localObject1;
            }
            ad.i("MicroMsg.SayHiWithSnsPermissionUI", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localaf.field_nickname });
            localObject2 = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), getResources().getString(2131763072, new Object[] { localaf.field_nickname, localObject2 }), this.uEu.getTextSize());
            this.uEC = ((CharSequence)localObject2);
          }
        }
      }
      if (bt.ai(this.uEC)) {
        this.uEC = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), String.format(str2, new Object[] { localObject1 }), this.uEu.getTextSize());
      }
      if (bt.ai((CharSequence)localObject2)) {
        this.uEu.setText(this.uEC);
      }
      for (;;)
      {
        this.uEu.clearFocus();
        if (this.uEz)
        {
          this.uEv = ((EditText)findViewById(2131304294));
          ((LinearLayout)this.uEv.getParent()).setVisibility(0);
          if (!this.uEy) {
            this.uEv.clearFocus();
          }
          com.tencent.mm.ui.tools.b.c.d(this.uEv).aaj(100).a(null);
          this.uEv.setFilters(j.CmX);
          if (!this.uEy)
          {
            ((TextView)findViewById(2131305902)).setText(2131762056);
            this.isb[0] = 1;
          }
          if (bt.isNullOrNil(this.bNL)) {
            break label1200;
          }
          this.uEv.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.bNL, this.uEv.getTextSize()));
          this.isb[6] = 1;
        }
        localObject1 = getString(2131755884);
        if (!this.uEy) {
          localObject1 = getString(2131755779);
        }
        addTextOptionMenu(0, (String)localObject1, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(27399);
            if ((SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this) != null) && (SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this).isShowing()))
            {
              AppMethodBeat.o(27399);
              return false;
            }
            Object localObject2;
            LinkedList localLinkedList;
            Object localObject1;
            HashMap localHashMap;
            if (SayHiWithSnsPermissionUI.this.uEE[0] != 0)
            {
              SayHiWithSnsPermissionUI.this.uEE[0] = false;
              if (!SayHiWithSnsPermissionUI.c(SayHiWithSnsPermissionUI.this)) {
                break label573;
              }
              localObject2 = new LinkedList();
              ((LinkedList)localObject2).add(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this));
              localLinkedList = new LinkedList();
              localLinkedList.add(Integer.valueOf(SayHiWithSnsPermissionUI.e(SayHiWithSnsPermissionUI.this)));
              localObject1 = SayHiWithSnsPermissionUI.f(SayHiWithSnsPermissionUI.this);
              localHashMap = new HashMap();
              i = 0;
              j = 0;
              if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() != 0)
              {
                if (SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this).HAh) {
                  j = 1;
                }
                i = j;
                if (SayHiWithSnsPermissionUI.i(SayHiWithSnsPermissionUI.this).HAh) {
                  i = j | 0x2;
                }
              }
              j = i;
              if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() == 0) {
                j = i | 0x8;
              }
              SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this, j);
              localHashMap.put(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), Integer.valueOf(j));
              ad.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[] { Integer.valueOf(j) });
              if (!SayHiWithSnsPermissionUI.j(SayHiWithSnsPermissionUI.this)) {
                break label435;
              }
              paramAnonymousMenuItem = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra(e.c.FHR);
              paramAnonymousMenuItem = new com.tencent.mm.openim.b.o(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), (String)localObject1, paramAnonymousMenuItem);
              com.tencent.mm.model.az.aeS().a(paramAnonymousMenuItem, 0);
              localObject1 = SayHiWithSnsPermissionUI.this;
              localObject2 = SayHiWithSnsPermissionUI.this.getContext();
              SayHiWithSnsPermissionUI.this.getString(2131755906);
              SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(27395);
                  com.tencent.mm.model.az.aeS().a(paramAnonymousMenuItem);
                  AppMethodBeat.o(27395);
                }
              }));
            }
            for (;;)
            {
              long l = SayHiWithSnsPermissionUI.this.getIntent().getLongExtra("key_msg_id", 0L);
              if (com.tencent.mm.plugin.messenger.e.a.rs(l)) {
                com.tencent.mm.plugin.messenger.e.a.K(l, 4);
              }
              AppMethodBeat.o(27399);
              return false;
              com.tencent.mm.plugin.normsg.a.b.ufs.hK("ce_ver_usr", "<VerifyUsr>");
              paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.ufs.a("ce_ver_usr", paramAnonymousMenuItem);
              com.tencent.mm.plugin.normsg.a.b.ufs.ajw("ce_ver_usr");
              break;
              label435:
              String str1 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_user_name");
              String str2 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_nick_name");
              paramAnonymousMenuItem = new aa(SayHiWithSnsPermissionUI.this, null);
              paramAnonymousMenuItem.content = ((String)localObject1);
              paramAnonymousMenuItem.kx(str1, str2);
              paramAnonymousMenuItem.BZC = localHashMap;
              paramAnonymousMenuItem.chatroomName = SayHiWithSnsPermissionUI.k(SayHiWithSnsPermissionUI.this);
              paramAnonymousMenuItem.D((List)localObject2, localLinkedList);
              localObject1 = SayHiWithSnsPermissionUI.this;
              localObject2 = SayHiWithSnsPermissionUI.this.getContext();
              SayHiWithSnsPermissionUI.this.getString(2131755906);
              SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(27396);
                  paramAnonymousMenuItem.eys();
                  AppMethodBeat.o(27396);
                }
              }));
              continue;
              label573:
              if (SayHiWithSnsPermissionUI.l(SayHiWithSnsPermissionUI.this))
              {
                paramAnonymousMenuItem = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("Verify_ticket");
                if (!SayHiWithSnsPermissionUI.j(SayHiWithSnsPermissionUI.this)) {
                  break label691;
                }
                paramAnonymousMenuItem = new com.tencent.mm.openim.b.q(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), paramAnonymousMenuItem);
                com.tencent.mm.model.az.aeS().a(paramAnonymousMenuItem, 0);
                localObject1 = SayHiWithSnsPermissionUI.this;
                localObject2 = SayHiWithSnsPermissionUI.this.getContext();
                SayHiWithSnsPermissionUI.this.getString(2131755906);
                SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(27397);
                    com.tencent.mm.model.az.aeS().a(paramAnonymousMenuItem);
                    AppMethodBeat.o(27397);
                  }
                }));
              }
            }
            label691:
            int i = 0;
            int j = 0;
            if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() != 0)
            {
              if (SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this).HAh) {
                j = 1;
              }
              i = j;
              if (SayHiWithSnsPermissionUI.i(SayHiWithSnsPermissionUI.this).HAh) {
                i = j | 0x2;
              }
            }
            if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() == 0) {
              i |= 0x8;
            }
            for (;;)
            {
              SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this, i);
              ad.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
              paramAnonymousMenuItem = new com.tencent.mm.pluginsdk.model.o(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), paramAnonymousMenuItem, SayHiWithSnsPermissionUI.e(SayHiWithSnsPermissionUI.this), SayHiWithSnsPermissionUI.k(SayHiWithSnsPermissionUI.this), i);
              com.tencent.mm.model.az.aeS().a(paramAnonymousMenuItem, 0);
              localObject1 = SayHiWithSnsPermissionUI.this;
              localObject2 = SayHiWithSnsPermissionUI.this.getContext();
              SayHiWithSnsPermissionUI.this.getString(2131755906);
              SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(27398);
                  com.tencent.mm.model.az.aeS().a(paramAnonymousMenuItem);
                  AppMethodBeat.o(27398);
                }
              }));
              break;
            }
          }
        }, null, new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(27400);
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(27400);
              return false;
              SayHiWithSnsPermissionUI.this.uEE[0] = true;
              com.tencent.mm.plugin.normsg.a.b.ufs.hK("ce_ver_usr", "<VerifyUsr>");
              continue;
              com.tencent.mm.plugin.normsg.a.b.ufs.a("ce_ver_usr", paramAnonymousMotionEvent);
              com.tencent.mm.plugin.normsg.a.b.ufs.ajw("ce_ver_usr");
            }
          }
        }, r.b.FOB);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(27401);
            if (SayHiWithSnsPermissionUI.l(SayHiWithSnsPermissionUI.this)) {
              SayHiWithSnsPermissionUI.m(SayHiWithSnsPermissionUI.this)[1] = 1;
            }
            SayHiWithSnsPermissionUI.this.finish();
            SayHiWithSnsPermissionUI.n(SayHiWithSnsPermissionUI.this);
            AppMethodBeat.o(27401);
            return true;
          }
        });
        AppMethodBeat.o(27412);
        return;
        i = 0;
        break;
        label1125:
        bool = false;
        break label184;
        label1130:
        bool = false;
        break label255;
        label1135:
        if (i != 2) {
          break label433;
        }
        ((TextView)localObject1).setText(2131763929);
        break label433;
        label1150:
        if (i != 2) {
          break label456;
        }
        ((TextView)localObject1).setText(2131763785);
        break label456;
        dcW();
        break label502;
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), (CharSequence)localObject2, this.uEu.getTextSize());
        this.uEu.setText((CharSequence)localObject1);
      }
      if (!bt.isNullOrNil(this.bNK))
      {
        this.uEv.setHint(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.bNK, this.uEv.getTextSize()));
        this.uEv.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(27394);
            if (paramAnonymousBoolean)
            {
              if ((!bt.ai(SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getHint())) && (bt.ai(SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getText())))
              {
                SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).setText(SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getHint());
                SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).setHint(null);
              }
              SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).setSelection(SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getText().length());
            }
            AppMethodBeat.o(27394);
          }
        });
      }
      switch (this.ima)
      {
      case 9: 
      case 12: 
      default: 
        i = 0;
      }
      while ((!this.uEy) && (i == 0))
      {
        localObject1 = com.tencent.mm.bk.d.aCn().aIJ(this.userName);
        if (localObject1 == null) {
          break;
        }
        localObject2 = com.tencent.mm.pluginsdk.ui.preference.b.c(this, (ba)localObject1);
        if ((bt.isNullOrNil(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).gKF)) || (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).gKF.equals(getString(2131759471)))) {
          break;
        }
        str1 = getString(2131763071).substring(0, getString(2131763071).indexOf("%s"));
        localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).gKF;
        if (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).gKF.startsWith(str1)) {
          localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).gKF.substring(str1.length());
        }
        this.uEw.setVisibility(0);
        this.uEx.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, bt.nullAsNil(getString(2131757818, new Object[] { ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).gKF })), this.uEx.getTextSize()));
        localObject2 = new com.tencent.mm.pluginsdk.ui.span.l(getString(2131766242));
        ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).setSpan(new a((String)localObject1), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).length(), 17);
        this.uEx.append(" ");
        this.uEx.append((CharSequence)localObject2);
        this.uEx.setMovementMethod(LinkMovementMethod.getInstance());
        this.isb[3] = 3;
        break;
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(this.userName);
        if ((localObject1 == null) || (bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIv())) || (((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIv().equals(this.uEv.getText().toString())))
        {
          i = 0;
        }
        else
        {
          this.uEw.setVisibility(0);
          this.uEx.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, bt.nullAsNil(getString(2131757816, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIv() })), this.uEx.getTextSize()));
          localObject2 = new com.tencent.mm.pluginsdk.ui.span.l(getString(2131766242));
          ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).setSpan(new a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIv()), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).length(), 17);
          this.uEx.append(" ");
          this.uEx.append((CharSequence)localObject2);
          this.uEx.setMovementMethod(LinkMovementMethod.getInstance());
          this.isb[3] = 1;
          i = 1;
          continue;
          if ((bt.isNullOrNil(this.tZO)) || (this.tZO.equals(this.uEv.getText().toString())))
          {
            i = 0;
          }
          else
          {
            this.uEw.setVisibility(0);
            this.uEx.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, bt.nullAsNil(getString(2131757815, new Object[] { this.tZO })), this.uEx.getTextSize()));
            localObject1 = new com.tencent.mm.pluginsdk.ui.span.l(getString(2131766242));
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).setSpan(new a(this.tZO), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).length(), 17);
            this.uEx.append(" ");
            this.uEx.append((CharSequence)localObject1);
            this.uEx.setMovementMethod(LinkMovementMethod.getInstance());
            this.isb[3] = 2;
            i = 1;
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27408);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle("");
    initView();
    AppMethodBeat.o(27408);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27411);
    com.tencent.mm.plugin.report.service.h.vKh.f(14036, new Object[] { Integer.valueOf(this.isb[0]), Integer.valueOf(this.isb[1]), Integer.valueOf(this.isb[2]), Integer.valueOf(this.isb[3]), Integer.valueOf(this.isb[4]), Integer.valueOf(this.isb[5]), Integer.valueOf(this.isb[6]), Integer.valueOf(this.isb[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.b.ufs.ajt("ie_ver_usr");
    AppMethodBeat.o(27411);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27417);
    if (paramInt == 4)
    {
      this.isb[0] = 1;
      finish();
      ob(false);
      AppMethodBeat.o(27417);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(27417);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27409);
    super.onResume();
    com.tencent.mm.model.az.aeS().a(30, this);
    com.tencent.mm.model.az.aeS().a(243, this);
    com.tencent.mm.model.az.aeS().a(853, this);
    AppMethodBeat.o(27409);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27415);
    long l1 = System.currentTimeMillis();
    ad.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    try
    {
      if (this.fpP != null)
      {
        this.fpP.dismiss();
        this.fpP = null;
      }
      if (this.uEy)
      {
        localObject = this.uEu.getText().toString().trim();
        if ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.uEC)) && (bt.isNullOrNil(this.chatroomName))) {
          break label1060;
        }
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.afk().set(294913, "");
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label1272;
      }
      com.tencent.mm.ui.base.h.cf(this, getString(2131763076));
      com.tencent.mm.plugin.account.friend.a.au.ax(this.userName, 1);
      paramString = new pp();
      paramString.dvq.username = this.userName;
      paramString.dvq.type = 1;
      com.tencent.mm.sdk.b.a.ESL.l(paramString);
      if ((this.ima == 17) && ((paramn instanceof com.tencent.mm.pluginsdk.model.o)))
      {
        long l2 = getIntent().getLongExtra("key_msg_id", 0L);
        if (l2 > 0L)
        {
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(l2);
          if (paramString.field_msgId > 0L)
          {
            paramString.eMp();
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(l2, paramString);
          }
        }
      }
      if (!this.uEz) {
        break label924;
      }
      paramString = dcZ();
      if (bt.isNullOrNil(paramString)) {
        break label1137;
      }
      ad.i("MicroMsg.SayHiWithSnsPermissionUI", "set temp remark of %s", new Object[] { this.userName });
      com.tencent.mm.model.az.arV();
      localObject = com.tencent.mm.model.c.apM().aHY(this.userName);
      ((af)localObject).nb(paramString);
      com.tencent.mm.model.az.arV();
      bw localbw = com.tencent.mm.model.c.apN().agQ(this.userName);
      localbw.field_encryptUsername = this.userName;
      localbw.field_conRemark = paramString;
      com.tencent.mm.model.az.arV();
      com.tencent.mm.model.c.apN().replace(localbw);
      com.tencent.mm.model.az.arV();
      com.tencent.mm.model.c.apM().ae((af)localObject);
      this.isb[2] = 1;
      if ((!bt.isNullOrNil(this.bNK)) && (!paramString.equals(this.bNK))) {
        this.isb[5] = 1;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        label458:
        label609:
        boolean bool;
        label688:
        label759:
        ad.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + paramString.getMessage());
        label924:
        label1060:
        return;
        label1028:
        label1137:
        if (bt.isNullOrNil(this.bNK)) {
          break;
        }
        this.isb[2] = 0;
      }
    }
    finally
    {
      ad.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(27415);
    }
    paramString = new LinkedList();
    if ((paramn instanceof com.tencent.mm.pluginsdk.model.o))
    {
      paramInt1 = ((com.tencent.mm.pluginsdk.model.o)paramn).djq;
      paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).BOW;
      if ((paramInt1 == 3) || ((paramn instanceof com.tencent.mm.openim.b.q)))
      {
        localObject = com.tencent.mm.bk.d.aCn().aIJ(this.userName);
        com.tencent.mm.model.az.arV();
        paramn = com.tencent.mm.model.c.apM().aHY(this.userName);
        if ((paramString != null) && (paramString.contains(this.userName)))
        {
          paramString = paramn;
          if ((int)paramn.fId != 0) {
            break label1227;
          }
          paramn = com.tencent.mm.pluginsdk.ui.preference.b.a((ba)localObject);
          paramn.setUsername(this.userName);
          com.tencent.mm.model.az.arV();
          paramString = paramn;
          if (com.tencent.mm.model.c.apM().af(paramn)) {
            break label1227;
          }
          ad.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
        }
        com.tencent.mm.model.az.arV();
        paramString = com.tencent.mm.model.c.apM().aHY(this.userName);
        paramn = new ts();
        paramn.dyX.dyZ = true;
        paramn.dyX.dyY = false;
        paramn.dyX.username = this.userName;
        com.tencent.mm.sdk.b.a.ESL.l(paramn);
        if (!this.uEa.HAh) {
          break label1265;
        }
        com.tencent.mm.model.w.o(paramString);
        paramString = new ts();
        paramString.dyX.dyZ = false;
        paramString.dyX.dyY = true;
        paramString.dyX.username = this.userName;
        bool = akH(this.userName);
        paramString.dyX.dza = bool;
        localObject = this.userName;
        if (this.uEb.HAh) {
          break label1500;
        }
        paramInt1 = 2;
        paramn = new LinkedList();
        paramn.add(localObject);
        localObject = new og();
        ((og)localObject).dtn.list = paramn;
        ((og)localObject).dtn.diR = paramInt1;
        ((og)localObject).dtn.dto = 5L;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        com.tencent.mm.sdk.b.a.ESL.l(paramString);
        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false))
        {
          paramString = new Intent();
          paramString.putExtra("friend_message_transfer_username", this.userName);
          paramString.setAction("friend_message_accept_" + this.userName);
          paramString.putExtra("MMActivity.OverrideEnterAnimation", 2130772144);
          paramString.putExtra("MMActivity.OverrideExitAnimation", 2130772141);
          com.tencent.mm.bs.d.b(this, "subapp", ".ui.friend.FMessageTransferUI", paramString);
        }
      }
      getIntent().putExtra("CONTACT_INFO_UI_SOURCE", 7);
      com.tencent.mm.plugin.report.service.h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(getIntent())), Integer.valueOf(1), Integer.valueOf(1), this.userName });
      setResult(-1, getIntent());
      finish();
      ob(true);
      if ((this.uEF & 0x8) == 0) {
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fxs, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(27415);
      return;
      com.tencent.mm.model.az.arV();
      com.tencent.mm.model.c.afk().set(294913, localObject);
      break;
      this.isb[2] = 2;
      break label458;
      if (!(paramn instanceof com.tencent.mm.openim.b.q)) {
        break label1495;
      }
      paramString.add(((com.tencent.mm.openim.b.q)paramn).hNH);
      break label1495;
      label1227:
      com.tencent.mm.model.w.u(paramString);
      com.tencent.mm.model.az.getNotification().TU();
      com.tencent.mm.bk.d.aCo().fM(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.cj(this.userName, this.ima);
      break label609;
      label1265:
      com.tencent.mm.model.w.p(paramString);
      break label688;
      label1272:
      if ((paramInt1 != 4) || (paramInt2 != -24) || (bt.isNullOrNil(paramString))) {
        break label1505;
      }
      Toast.makeText(this, paramString, 1).show();
    }
    for (;;)
    {
      label1302:
      if (!bt.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131755835), null);
        break label1028;
      }
      label1495:
      label1500:
      label1505:
      do
      {
        do
        {
          if ((this.uEy) && ((paramInt2 == -24) || (paramInt2 == -34)))
          {
            Toast.makeText(this, 2131759479, 0).show();
            break label1028;
          }
          if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.uEe))
          {
            this.uEf = true;
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fxs, Integer.valueOf(1));
            if (!bt.isNullOrNil(paramString)) {
              ((TextView)findViewById(2131305647)).setText(paramString);
            }
            dcW();
            paramn = new f.a(this);
            paramn.aMo(paramString).wZ(true).aMt(getString(2131762023)).aaF(2131762024);
            paramn.c(new f.c()
            {
              public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                AppMethodBeat.i(27404);
                SayHiWithSnsPermissionUI.this.hideVKB();
                if (!paramAnonymousBoolean)
                {
                  paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ac.ir(SayHiWithSnsPermissionUI.this);
                  Intent localIntent = new Intent();
                  localIntent.putExtra("rawUrl", paramAnonymousString);
                  localIntent.putExtra("showShare", false);
                  localIntent.putExtra("show_bottom", false);
                  com.tencent.mm.bs.d.b(SayHiWithSnsPermissionUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                }
                AppMethodBeat.o(27404);
              }
            }).show();
            break label1028;
          }
          Toast.makeText(this, 2131763075, 0).show();
          break label1028;
          paramInt1 = 0;
          break;
          paramInt1 = 1;
          break label759;
        } while (paramInt1 != 4);
        if (paramInt2 == -2) {
          break label1302;
        }
      } while (paramInt2 != -101);
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(27410);
    com.tencent.mm.model.az.aeS().b(30, this);
    com.tencent.mm.model.az.aeS().b(243, this);
    com.tencent.mm.model.az.aeS().b(853, this);
    super.onStop();
    AppMethodBeat.o(27410);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends ClickableSpan
  {
    public String iaz;
    
    public a(String paramString)
    {
      this.iaz = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(27405);
      SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).setText(com.tencent.mm.pluginsdk.ui.span.k.b(SayHiWithSnsPermissionUI.this, bt.nullAsNil(this.iaz), SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getTextSize()));
      SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).setSelection(SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getText().length());
      SayHiWithSnsPermissionUI.p(SayHiWithSnsPermissionUI.this).setVisibility(8);
      SayHiWithSnsPermissionUI.m(SayHiWithSnsPermissionUI.this)[4] = 1;
      AppMethodBeat.o(27405);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(27406);
      paramTextPaint.setColor(SayHiWithSnsPermissionUI.this.getResources().getColor(2131100027));
      paramTextPaint.setUnderlineText(false);
      AppMethodBeat.o(27406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI
 * JD-Core Version:    0.7.0.1
 */