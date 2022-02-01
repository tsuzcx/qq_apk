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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SayHiWithSnsPermissionUI2
  extends MMActivity
  implements f
{
  private String bVF;
  private String bVG;
  private String chatroomName;
  private long dBD;
  private ProgressDialog fMu;
  private int jfq;
  private int[] jlo;
  private String userName;
  private boolean wUA;
  private boolean wUB;
  private CharSequence wUC;
  final boolean[] wUD;
  final boolean[] wUE;
  private int wUF;
  private boolean wUP;
  private MMSwitchBtn wUa;
  private MMSwitchBtn wUb;
  private WeImageView wUc;
  private WeImageView wUd;
  private boolean wUe;
  private boolean wUf;
  private TextView wUm;
  private EditText wUu;
  private EditText wUv;
  private View wUw;
  private TextView wUx;
  private boolean wUy;
  private boolean wUz;
  private String woh;
  
  public SayHiWithSnsPermissionUI2()
  {
    AppMethodBeat.i(179689);
    this.fMu = null;
    this.jlo = new int[8];
    this.wUe = false;
    this.wUf = false;
    this.wUA = false;
    this.wUB = false;
    this.wUC = null;
    this.wUD = new boolean[] { true };
    this.wUE = new boolean[] { false };
    this.wUP = true;
    this.dBD = System.currentTimeMillis();
    this.wUF = 0;
    AppMethodBeat.o(179689);
  }
  
  private static boolean auM(String paramString)
  {
    AppMethodBeat.i(179698);
    boolean bool = com.tencent.mm.plugin.sns.b.o.zbV.auM(paramString);
    AppMethodBeat.o(179698);
    return bool;
  }
  
  private void dBh()
  {
    AppMethodBeat.i(179695);
    Object localObject = this.wUc;
    if ((this.wUA) || (this.wUf))
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.wUd;
      if ((this.wUA) || (this.wUf)) {
        break label411;
      }
      i = 0;
      label52:
      ((WeImageView)localObject).setVisibility(i);
      if (this.wUP)
      {
        if ((!this.wUA) && (!this.wUf))
        {
          ba.aBQ();
          final int j = com.tencent.mm.model.c.azp().c(w.hFm, new String[] { u.aAm(), "weixin", "helper_entry", "filehelper" });
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHf, 200);
          if (j >= i)
          {
            this.wUc.setVisibility(0);
            this.wUd.setVisibility(4);
            ((TextView)findViewById(2131306437)).setText(getString(2131762045, new Object[] { Integer.valueOf(i) }));
            j = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IJu, 0);
            if (j < ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHg, 3))
            {
              localObject = new f.a(this).aXO(getString(2131762046, new Object[] { Integer.valueOf(i) }));
              ((f.a)localObject).EgK = true;
              ((f.a)localObject).afp(2131755792).b(new f.c()
              {
                public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
                {
                  AppMethodBeat.i(179684);
                  com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJu, Integer.valueOf(j + 1));
                  AppMethodBeat.o(179684);
                }
              }).show();
            }
          }
        }
        this.wUP = false;
      }
      ((View)this.wUc.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179685);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() != 0)
          {
            SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).setVisibility(0);
            SayHiWithSnsPermissionUI2.o(SayHiWithSnsPermissionUI2.this).setVisibility(4);
            SayHiWithSnsPermissionUI2.this.findViewById(2131302905).setVisibility(8);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179685);
        }
      });
      View localView = (View)this.wUd.getParent();
      if (!this.wUf) {
        break label416;
      }
      localObject = null;
      label328:
      localView.setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131302905).setVisibility(8);
      localObject = (TextView)findViewById(2131305037);
      if (!this.wUf) {
        break label428;
      }
    }
    label411:
    label416:
    label428:
    for (int i = getResources().getColor(2131100490);; i = getResources().getColor(2131100711))
    {
      ((TextView)localObject).setTextColor(i);
      if (this.wUf) {
        this.wUm.setVisibility(0);
      }
      this.wUA = false;
      AppMethodBeat.o(179695);
      return;
      i = 4;
      break;
      i = 4;
      break label52;
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179686);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (SayHiWithSnsPermissionUI2.o(SayHiWithSnsPermissionUI2.this).getVisibility() != 0)
          {
            SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).setVisibility(4);
            SayHiWithSnsPermissionUI2.o(SayHiWithSnsPermissionUI2.this).setVisibility(0);
            SayHiWithSnsPermissionUI2.this.findViewById(2131302905).setVisibility(8);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179686);
        }
      };
      break label328;
    }
  }
  
  private String dBk()
  {
    AppMethodBeat.i(179696);
    String str = "";
    if (this.wUv.getText() != null) {
      str = this.wUv.getText().toString();
    }
    if (!bt.isNullOrNil(str))
    {
      if (str.length() <= 50)
      {
        AppMethodBeat.o(179696);
        return str;
      }
      str = str.substring(0, 50);
      AppMethodBeat.o(179696);
      return str;
    }
    AppMethodBeat.o(179696);
    return str;
  }
  
  private void pu(boolean paramBoolean)
  {
    AppMethodBeat.i(179700);
    int k;
    int m;
    label32:
    int j;
    label44:
    int i;
    if (this.wUy)
    {
      k = 1;
      m = 1;
      if (!bt.isNullOrNil(dBk())) {
        break label422;
      }
      m = 3;
      j = 1;
      if (!this.wUf) {
        break label456;
      }
      j = 6;
      switch (this.jfq)
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
        i = 11;
      }
    }
    for (;;)
    {
      ba.aBQ();
      int n = com.tencent.mm.model.c.azp().c(w.hFm, new String[] { u.aAm(), "weixin", "helper_entry", "filehelper" });
      com.tencent.mm.plugin.report.service.g.yhR.f(18713, new Object[] { this.userName, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - this.dBD), Integer.valueOf(n) });
      AppMethodBeat.o(179700);
      return;
      if (paramBoolean)
      {
        k = 2;
        break;
      }
      k = 3;
      break;
      label422:
      if ((!dBk().equals(this.bVF)) && (!dBk().equals(this.woh))) {
        break label32;
      }
      m = 2;
      break label32;
      label456:
      if ((this.wUF & 0x8) != 0)
      {
        j = 5;
        break label44;
      }
      if (((this.wUF & 0x1) != 0) && ((this.wUF & 0x2) != 0))
      {
        j = 4;
        break label44;
      }
      if ((this.wUF & 0x2) != 0)
      {
        j = 3;
        break label44;
      }
      if ((this.wUF & 0x1) == 0) {
        break label44;
      }
      j = 2;
      break label44;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
      continue;
      i = 9;
      continue;
      i = 10;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495283;
  }
  
  public void initView()
  {
    AppMethodBeat.i(179694);
    this.wUy = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
    this.wUz = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
    this.userName = getIntent().getStringExtra("Contact_User");
    this.jfq = getIntent().getIntExtra("Contact_Scene", 9);
    this.chatroomName = getIntent().getStringExtra("room_name");
    this.bVG = getIntent().getStringExtra("Contact_RemarkName");
    this.bVF = getIntent().getStringExtra("Contact_Nick");
    this.woh = getIntent().getStringExtra("Contact_RoomNickname");
    this.wUw = findViewById(2131302421);
    this.wUx = ((TextView)findViewById(2131302422));
    Object localObject1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA();
    int i;
    boolean bool;
    label184:
    label255:
    String str1;
    label447:
    label470:
    Object localObject2;
    label517:
    String str2;
    if (com.tencent.mm.sdk.platformtools.i.DEBUG)
    {
      i = 1;
      if (((com.tencent.mm.n.e)localObject1).getInt("MMSocialBlackListFlag", i) != 1) {
        break label1156;
      }
      bool = true;
      this.wUe = bool;
      if (!this.wUe) {
        findViewById(2131305648).setVisibility(8);
      }
      com.tencent.mm.kernel.g.ajD();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.userName);
      if (com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IJk, 0) != 1) {
        break label1161;
      }
      bool = true;
      this.wUA = bool;
      this.wUa = ((MMSwitchBtn)findViewById(2131302903).findViewById(2131302906));
      getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
      this.wUa.setCheck(((am)localObject1).adn());
      this.wUc = ((WeImageView)findViewById(2131305646));
      this.wUd = ((WeImageView)findViewById(2131305036));
      this.wUm = ((TextView)findViewById(2131305647));
      this.wUb = ((MMSwitchBtn)findViewById(2131304942).findViewById(2131302910));
      bool = auM(this.userName);
      this.wUb.setCheck(bool);
      findViewById(2131297422).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179673);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          SayHiWithSnsPermissionUI2.this.hideVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179673);
        }
      });
      i = ((aw)localObject1).ePk;
      ad.d("MicroMsg.SayHiWithSnsPermissionUI2", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject1 = (TextView)findViewById(2131302907);
      if (i != 1) {
        break label1166;
      }
      ((TextView)localObject1).setText(2131763930);
      localObject1 = (TextView)findViewById(2131302911);
      if (i != 1) {
        break label1181;
      }
      ((TextView)localObject1).setText(2131763786);
      bool = am.aSQ(this.userName);
      this.wUB = bool;
      if (!bool) {
        break label1196;
      }
      findViewById(2131305648).setVisibility(8);
      localObject1 = findViewById(2131302905);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (this.wUB) {
        this.wUb.setCheck(true);
      }
      if (this.wUy)
      {
        this.wUu = ((EditText)findViewById(2131304291));
        com.tencent.mm.ui.tools.b.c.d(this.wUu).aeU(100).a(null);
        this.wUu.setFilters(j.Fku);
        this.wUu.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(179675);
            if (SayHiWithSnsPermissionUI2.this.wUD[0] != 0)
            {
              SayHiWithSnsPermissionUI2.this.wUD[0] = false;
              com.tencent.mm.plugin.normsg.a.b.wtJ.atp("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.b.wtJ.atq("ie_ver_usr");
            AppMethodBeat.o(179675);
          }
        });
        ((LinearLayout)this.wUu.getParent()).setVisibility(0);
        ba.aBQ();
        str1 = (String)com.tencent.mm.model.c.ajl().get(294913, null);
        localObject2 = u.aAo();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        str2 = getString(2131763071);
        if (str2.length() + ((String)localObject1).length() <= 50) {
          break label1915;
        }
        localObject1 = ((String)localObject1).substring(0, 50 - str2.length());
      }
    }
    label1156:
    label1161:
    label1166:
    label1181:
    label1196:
    label1231:
    label1915:
    for (;;)
    {
      localObject2 = str1;
      if (!bt.isNullOrNil(this.chatroomName))
      {
        am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.chatroomName);
        localObject2 = str1;
        if (localam != null)
        {
          localObject2 = str1;
          if (!bt.isNullOrNil(localam.field_nickname))
          {
            str1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AO(this.chatroomName).zf(u.aAm());
            localObject2 = str1;
            if (bt.ai(str1)) {
              localObject2 = localObject1;
            }
            ad.i("MicroMsg.SayHiWithSnsPermissionUI2", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localam.field_nickname });
            localObject2 = k.b(getContext(), getResources().getString(2131763072, new Object[] { localam.field_nickname, localObject2 }), this.wUu.getTextSize());
            this.wUC = ((CharSequence)localObject2);
          }
        }
      }
      if (bt.ai(this.wUC)) {
        this.wUC = k.b(getContext(), String.format(str2, new Object[] { localObject1 }), this.wUu.getTextSize());
      }
      if (bt.ai((CharSequence)localObject2)) {
        this.wUu.setText(this.wUC);
      }
      for (;;)
      {
        this.wUu.clearFocus();
        if (this.wUz)
        {
          this.wUv = ((EditText)findViewById(2131304294));
          ((LinearLayout)this.wUv.getParent()).setVisibility(0);
          if (!this.wUy) {
            this.wUv.clearFocus();
          }
          com.tencent.mm.ui.tools.b.c.d(this.wUv).aeU(100).a(null);
          this.wUv.setFilters(j.Fku);
          if (!this.wUy)
          {
            ((TextView)findViewById(2131305902)).setText(2131762056);
            this.jlo[0] = 1;
          }
          if (bt.isNullOrNil(this.bVG)) {
            break label1231;
          }
          this.wUv.setText(k.b(getContext(), this.bVG, this.wUv.getTextSize()));
          this.jlo[6] = 1;
        }
        localObject1 = getString(2131755884);
        if (!this.wUy) {
          localObject1 = getString(2131755779);
        }
        addTextOptionMenu(0, (String)localObject1, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(179681);
            if ((SayHiWithSnsPermissionUI2.b(SayHiWithSnsPermissionUI2.this) != null) && (SayHiWithSnsPermissionUI2.b(SayHiWithSnsPermissionUI2.this).isShowing()))
            {
              AppMethodBeat.o(179681);
              return false;
            }
            Object localObject2;
            LinkedList localLinkedList;
            Object localObject1;
            HashMap localHashMap;
            int j;
            if (SayHiWithSnsPermissionUI2.this.wUE[0] != 0)
            {
              SayHiWithSnsPermissionUI2.this.wUE[0] = false;
              if (!SayHiWithSnsPermissionUI2.c(SayHiWithSnsPermissionUI2.this)) {
                break label538;
              }
              localObject2 = new LinkedList();
              ((LinkedList)localObject2).add(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this));
              localLinkedList = new LinkedList();
              localLinkedList.add(Integer.valueOf(SayHiWithSnsPermissionUI2.e(SayHiWithSnsPermissionUI2.this)));
              localObject1 = SayHiWithSnsPermissionUI2.f(SayHiWithSnsPermissionUI2.this);
              localHashMap = new HashMap();
              if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() == 0) {
                break label863;
              }
              if (!SayHiWithSnsPermissionUI2.h(SayHiWithSnsPermissionUI2.this).KRP) {
                break label858;
              }
              j = 1;
              label160:
              i = j;
              if (!SayHiWithSnsPermissionUI2.i(SayHiWithSnsPermissionUI2.this).KRP) {}
            }
            label538:
            label589:
            label858:
            label863:
            for (int i = j | 0x2;; i = 0)
            {
              j = i;
              if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() == 0) {
                j = i | 0x8;
              }
              SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this, j);
              localHashMap.put(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), Integer.valueOf(j));
              ad.d("MicroMsg.SayHiWithSnsPermissionUI2", "select sns permission, %s", new Object[] { Integer.valueOf(j) });
              if (SayHiWithSnsPermissionUI2.j(SayHiWithSnsPermissionUI2.this))
              {
                paramAnonymousMenuItem = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra(e.c.IUp);
                paramAnonymousMenuItem = new com.tencent.mm.openim.b.o(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), (String)localObject1, paramAnonymousMenuItem, j);
                ba.aiU().a(paramAnonymousMenuItem, 0);
                localObject1 = SayHiWithSnsPermissionUI2.this;
                localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                SayHiWithSnsPermissionUI2.this.getString(2131755906);
                SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, h.b((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(179677);
                    ba.aiU().a(paramAnonymousMenuItem);
                    AppMethodBeat.o(179677);
                  }
                }));
              }
              do
              {
                for (;;)
                {
                  AppMethodBeat.o(179681);
                  return false;
                  com.tencent.mm.plugin.normsg.a.b.wtJ.io("ce_ver_usr", "<VerifyUsr>");
                  paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
                  com.tencent.mm.plugin.normsg.a.b.wtJ.a("ce_ver_usr", paramAnonymousMenuItem);
                  com.tencent.mm.plugin.normsg.a.b.wtJ.atu("ce_ver_usr");
                  break;
                  String str1 = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra("source_from_user_name");
                  String str2 = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra("source_from_nick_name");
                  paramAnonymousMenuItem = new aa(SayHiWithSnsPermissionUI2.this, null);
                  paramAnonymousMenuItem.content = ((String)localObject1);
                  paramAnonymousMenuItem.lr(str1, str2);
                  paramAnonymousMenuItem.EWW = localHashMap;
                  paramAnonymousMenuItem.chatroomName = SayHiWithSnsPermissionUI2.k(SayHiWithSnsPermissionUI2.this);
                  paramAnonymousMenuItem.E((List)localObject2, localLinkedList);
                  localObject1 = SayHiWithSnsPermissionUI2.this;
                  localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                  SayHiWithSnsPermissionUI2.this.getString(2131755906);
                  SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, h.b((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(179678);
                      paramAnonymousMenuItem.fcL();
                      AppMethodBeat.o(179678);
                    }
                  }));
                }
              } while (!SayHiWithSnsPermissionUI2.l(SayHiWithSnsPermissionUI2.this));
              paramAnonymousMenuItem = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra("Verify_ticket");
              if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() != 0) {
                if (SayHiWithSnsPermissionUI2.h(SayHiWithSnsPermissionUI2.this).KRP)
                {
                  j = 1;
                  i = j;
                  if (!SayHiWithSnsPermissionUI2.i(SayHiWithSnsPermissionUI2.this).KRP) {}
                }
              }
              for (i = j | 0x2;; i = 0)
              {
                if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() == 0) {
                  i |= 0x8;
                }
                for (;;)
                {
                  SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this, i);
                  ad.d("MicroMsg.SayHiWithSnsPermissionUI2", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
                  if (SayHiWithSnsPermissionUI2.j(SayHiWithSnsPermissionUI2.this))
                  {
                    paramAnonymousMenuItem = new com.tencent.mm.openim.b.q(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), paramAnonymousMenuItem, i);
                    ba.aiU().a(paramAnonymousMenuItem, 0);
                    localObject1 = SayHiWithSnsPermissionUI2.this;
                    localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                    SayHiWithSnsPermissionUI2.this.getString(2131755906);
                    SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, h.b((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                      {
                        AppMethodBeat.i(179679);
                        ba.aiU().a(paramAnonymousMenuItem);
                        AppMethodBeat.o(179679);
                      }
                    }));
                    break;
                  }
                  paramAnonymousMenuItem = new com.tencent.mm.pluginsdk.model.o(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), paramAnonymousMenuItem, SayHiWithSnsPermissionUI2.e(SayHiWithSnsPermissionUI2.this), SayHiWithSnsPermissionUI2.k(SayHiWithSnsPermissionUI2.this), i);
                  ba.aiU().a(paramAnonymousMenuItem, 0);
                  localObject1 = SayHiWithSnsPermissionUI2.this;
                  localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                  SayHiWithSnsPermissionUI2.this.getString(2131755906);
                  SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, h.b((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(179680);
                      ba.aiU().a(paramAnonymousMenuItem);
                      AppMethodBeat.o(179680);
                    }
                  }));
                  break;
                }
                j = 0;
                break label589;
              }
              j = 0;
              break label160;
            }
          }
        }, null, new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(179682);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(179682);
              return false;
              SayHiWithSnsPermissionUI2.this.wUE[0] = true;
              com.tencent.mm.plugin.normsg.a.b.wtJ.io("ce_ver_usr", "<VerifyUsr>");
              continue;
              com.tencent.mm.plugin.normsg.a.b.wtJ.a("ce_ver_usr", paramAnonymousMotionEvent);
              com.tencent.mm.plugin.normsg.a.b.wtJ.atu("ce_ver_usr");
            }
          }
        }, s.b.JbS);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(179683);
            if (SayHiWithSnsPermissionUI2.l(SayHiWithSnsPermissionUI2.this)) {
              SayHiWithSnsPermissionUI2.m(SayHiWithSnsPermissionUI2.this)[1] = 1;
            }
            SayHiWithSnsPermissionUI2.this.finish();
            SayHiWithSnsPermissionUI2.n(SayHiWithSnsPermissionUI2.this);
            AppMethodBeat.o(179683);
            return true;
          }
        });
        AppMethodBeat.o(179694);
        return;
        i = 0;
        break;
        bool = false;
        break label184;
        bool = false;
        break label255;
        if (i != 2) {
          break label447;
        }
        ((TextView)localObject1).setText(2131763929);
        break label447;
        if (i != 2) {
          break label470;
        }
        ((TextView)localObject1).setText(2131763785);
        break label470;
        dBh();
        break label517;
        localObject1 = k.b(getContext(), (CharSequence)localObject2, this.wUu.getTextSize());
        this.wUu.setText((CharSequence)localObject1);
      }
      if (!bt.isNullOrNil(this.bVF))
      {
        this.wUv.setHint(k.b(getContext(), this.bVF, this.wUv.getTextSize()));
        this.wUv.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(179676);
            if (paramAnonymousBoolean)
            {
              if ((!bt.ai(SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).getHint())) && (bt.ai(SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).getText())))
              {
                SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).setText(SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).getHint());
                SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).setHint(null);
              }
              SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).setSelection(SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).getText().length());
            }
            AppMethodBeat.o(179676);
          }
        });
      }
      switch (this.jfq)
      {
      case 9: 
      case 12: 
      default: 
        i = 0;
      }
      while ((!this.wUy) && (i == 0))
      {
        localObject1 = com.tencent.mm.bk.d.aMn().aTW(this.userName);
        if (localObject1 == null) {
          break;
        }
        localObject2 = com.tencent.mm.pluginsdk.ui.preference.b.c(this, (bh)localObject1);
        if ((bt.isNullOrNil(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hDo)) || (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hDo.equals(getString(2131759471)))) {
          break;
        }
        str1 = getString(2131763071).substring(0, getString(2131763071).indexOf("%s"));
        localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hDo;
        if (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hDo.startsWith(str1)) {
          localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hDo.substring(str1.length());
        }
        this.wUw.setVisibility(0);
        this.wUx.setText(k.b(this, bt.nullAsNil(getString(2131757818, new Object[] { ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hDo })), this.wUx.getTextSize()));
        localObject2 = new com.tencent.mm.pluginsdk.ui.span.l(getString(2131766242));
        ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).setSpan(new a((String)localObject1), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).length(), 17);
        this.wUx.append(" ");
        this.wUx.append((CharSequence)localObject2);
        this.wUx.setMovementMethod(LinkMovementMethod.getInstance());
        this.jlo[3] = 3;
        break;
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(this.userName);
        if ((localObject1 == null) || (bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSy())) || (((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSy().equals(this.wUv.getText().toString())))
        {
          i = 0;
        }
        else
        {
          this.wUw.setVisibility(0);
          this.wUx.setText(k.b(this, bt.nullAsNil(getString(2131757816, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSy() })), this.wUx.getTextSize()));
          localObject2 = new com.tencent.mm.pluginsdk.ui.span.l(getString(2131766242));
          ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).setSpan(new a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSy()), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).length(), 17);
          this.wUx.append(" ");
          this.wUx.append((CharSequence)localObject2);
          this.wUx.setMovementMethod(LinkMovementMethod.getInstance());
          this.jlo[3] = 1;
          i = 1;
          continue;
          if ((bt.isNullOrNil(this.woh)) || (this.woh.equals(this.wUv.getText().toString())))
          {
            i = 0;
          }
          else
          {
            this.wUw.setVisibility(0);
            this.wUx.setText(k.b(this, bt.nullAsNil(getString(2131757815, new Object[] { this.woh })), this.wUx.getTextSize()));
            localObject1 = new com.tencent.mm.pluginsdk.ui.span.l(getString(2131766242));
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).setSpan(new a(this.woh), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).length(), 17);
            this.wUx.append(" ");
            this.wUx.append((CharSequence)localObject1);
            this.wUx.setMovementMethod(LinkMovementMethod.getInstance());
            this.jlo[3] = 2;
            i = 1;
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(179690);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle("");
    initView();
    ba.aiU().a(30, this);
    ba.aiU().a(243, this);
    ba.aiU().a(853, this);
    AppMethodBeat.o(179690);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(179693);
    ba.aiU().b(30, this);
    ba.aiU().b(243, this);
    ba.aiU().b(853, this);
    com.tencent.mm.plugin.report.service.g.yhR.f(14036, new Object[] { Integer.valueOf(this.jlo[0]), Integer.valueOf(this.jlo[1]), Integer.valueOf(this.jlo[2]), Integer.valueOf(this.jlo[3]), Integer.valueOf(this.jlo[4]), Integer.valueOf(this.jlo[5]), Integer.valueOf(this.jlo[6]), Integer.valueOf(this.jlo[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.b.wtJ.atr("ie_ver_usr");
    AppMethodBeat.o(179693);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(179699);
    if (paramInt == 4)
    {
      this.jlo[0] = 1;
      finish();
      pu(false);
      AppMethodBeat.o(179699);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(179699);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(179691);
    super.onResume();
    AppMethodBeat.o(179691);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(179697);
    long l1 = System.currentTimeMillis();
    ad.i("MicroMsg.SayHiWithSnsPermissionUI2", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    try
    {
      if (this.fMu != null)
      {
        this.fMu.dismiss();
        this.fMu = null;
      }
      if (this.wUy)
      {
        localObject = this.wUu.getText().toString().trim();
        if ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.wUC)) && (bt.isNullOrNil(this.chatroomName))) {
          break label1061;
        }
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(294913, "");
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label1273;
      }
      h.cl(this, getString(2131763076));
      au.aD(this.userName, 1);
      paramString = new qj();
      paramString.dFe.username = this.userName;
      paramString.dFe.type = 1;
      com.tencent.mm.sdk.b.a.IbL.l(paramString);
      if ((this.jfq == 17) && ((paramn instanceof com.tencent.mm.pluginsdk.model.o)))
      {
        long l2 = getIntent().getLongExtra("key_msg_id", 0L);
        if (l2 > 0L)
        {
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(l2);
          if (paramString.field_msgId > 0L)
          {
            paramString.frX();
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(l2, paramString);
          }
        }
      }
      if (!this.wUz) {
        break label925;
      }
      paramString = dBk();
      if (bt.isNullOrNil(paramString)) {
        break label1138;
      }
      ad.i("MicroMsg.SayHiWithSnsPermissionUI2", "set temp remark of %s", new Object[] { this.userName });
      ba.aBQ();
      localObject = com.tencent.mm.model.c.azp().Bf(this.userName);
      ((am)localObject).sR(paramString);
      ba.aBQ();
      cf localcf = com.tencent.mm.model.c.azq().aqz(this.userName);
      localcf.field_encryptUsername = this.userName;
      localcf.field_conRemark = paramString;
      ba.aBQ();
      com.tencent.mm.model.c.azq().replace(localcf);
      ba.aBQ();
      com.tencent.mm.model.c.azp().af((am)localObject);
      this.jlo[2] = 1;
      if ((!bt.isNullOrNil(this.bVF)) && (!paramString.equals(this.bVF))) {
        this.jlo[5] = 1;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        label459:
        label610:
        boolean bool;
        label689:
        label760:
        ad.e("MicroMsg.SayHiWithSnsPermissionUI2", "exception in onSceneEnd : " + paramString.getMessage());
        label925:
        label1061:
        return;
        label1029:
        label1138:
        if (bt.isNullOrNil(this.bVF)) {
          break;
        }
        this.jlo[2] = 0;
      }
    }
    finally
    {
      ad.i("MicroMsg.SayHiWithSnsPermissionUI2", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(179697);
    }
    paramString = new LinkedList();
    if ((paramn instanceof com.tencent.mm.pluginsdk.model.o))
    {
      paramInt1 = ((com.tencent.mm.pluginsdk.model.o)paramn).dsi;
      paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).ELU;
      if ((paramInt1 == 3) || ((paramn instanceof com.tencent.mm.openim.b.q)))
      {
        localObject = com.tencent.mm.bk.d.aMn().aTW(this.userName);
        ba.aBQ();
        paramn = com.tencent.mm.model.c.azp().Bf(this.userName);
        if ((paramString != null) && (paramString.contains(this.userName)))
        {
          paramString = paramn;
          if ((int)paramn.gfj != 0) {
            break label1228;
          }
          paramn = com.tencent.mm.pluginsdk.ui.preference.b.a((bh)localObject);
          paramn.setUsername(this.userName);
          ba.aBQ();
          paramString = paramn;
          if (com.tencent.mm.model.c.azp().ag(paramn)) {
            break label1228;
          }
          ad.e("MicroMsg.SayHiWithSnsPermissionUI2", "canAddContact fail, insert fail");
        }
        ba.aBQ();
        paramString = com.tencent.mm.model.c.azp().Bf(this.userName);
        paramn = new uu();
        paramn.dIV.dIX = true;
        paramn.dIV.dIW = false;
        paramn.dIV.username = this.userName;
        com.tencent.mm.sdk.b.a.IbL.l(paramn);
        if (!this.wUa.KRP) {
          break label1266;
        }
        w.o(paramString);
        paramString = new uu();
        paramString.dIV.dIX = false;
        paramString.dIV.dIW = true;
        paramString.dIV.username = this.userName;
        bool = auM(this.userName);
        paramString.dIV.dIY = bool;
        localObject = this.userName;
        if (this.wUb.KRP) {
          break label1497;
        }
        paramInt1 = 2;
        paramn = new LinkedList();
        paramn.add(localObject);
        localObject = new oy();
        ((oy)localObject).dCO.list = paramn;
        ((oy)localObject).dCO.drI = paramInt1;
        ((oy)localObject).dCO.dCP = 5L;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        com.tencent.mm.sdk.b.a.IbL.l(paramString);
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
      com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(getIntent())), Integer.valueOf(1), Integer.valueOf(1), this.userName });
      setResult(-1, getIntent());
      finish();
      pu(true);
      if ((this.wUF & 0x8) == 0) {
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJk, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.SayHiWithSnsPermissionUI2", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(179697);
      return;
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(294913, localObject);
      break;
      this.jlo[2] = 2;
      break label459;
      if (!(paramn instanceof com.tencent.mm.openim.b.q)) {
        break label1492;
      }
      paramString.add(((com.tencent.mm.openim.b.q)paramn).iHA);
      break label1492;
      label1228:
      w.u(paramString);
      ba.getNotification().Xg();
      com.tencent.mm.bk.d.aMo().gn(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.cr(this.userName, this.jfq);
      break label610;
      label1266:
      w.p(paramString);
      break label689;
      label1273:
      if ((paramInt1 != 4) || (paramInt2 != -24) || (bt.isNullOrNil(paramString))) {
        break label1502;
      }
      Toast.makeText(this, paramString, 1).show();
    }
    for (;;)
    {
      label1303:
      if (!bt.isNullOrNil(paramString))
      {
        h.a(this, paramString, "", getString(2131755835), null);
        break label1029;
      }
      label1492:
      label1497:
      label1502:
      do
      {
        do
        {
          if ((this.wUy) && ((paramInt2 == -24) || (paramInt2 == -34)))
          {
            Toast.makeText(this, 2131759479, 0).show();
            break label1029;
          }
          if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.wUe))
          {
            this.wUf = true;
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJk, Integer.valueOf(1));
            if (!bt.isNullOrNil(paramString)) {
              this.wUm.setText(paramString);
            }
            dBh();
            paramn = new f.a(this);
            paramn.aXO(paramString).yU(true).aXT(getString(2131762023)).afp(2131762024);
            paramn.c(new f.c()
            {
              public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                AppMethodBeat.i(179674);
                SayHiWithSnsPermissionUI2.this.hideVKB();
                if (!paramAnonymousBoolean)
                {
                  paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ac.iM(SayHiWithSnsPermissionUI2.this);
                  Intent localIntent = new Intent();
                  localIntent.putExtra("rawUrl", paramAnonymousString);
                  localIntent.putExtra("showShare", false);
                  localIntent.putExtra("show_bottom", false);
                  com.tencent.mm.bs.d.b(SayHiWithSnsPermissionUI2.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                }
                AppMethodBeat.o(179674);
              }
            }).show();
            break label1029;
          }
          Toast.makeText(this, 2131763075, 0).show();
          break label1029;
          paramInt1 = 0;
          break;
          paramInt1 = 1;
          break label760;
        } while (paramInt1 != 4);
        if (paramInt2 == -2) {
          break label1303;
        }
      } while (paramInt2 != -101);
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(179692);
    super.onStop();
    AppMethodBeat.o(179692);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends ClickableSpan
  {
    public String iTM;
    
    public a(String paramString)
    {
      this.iTM = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(179687);
      SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).setText(k.b(SayHiWithSnsPermissionUI2.this, bt.nullAsNil(this.iTM), SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).getTextSize()));
      SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).setSelection(SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).getText().length());
      SayHiWithSnsPermissionUI2.p(SayHiWithSnsPermissionUI2.this).setVisibility(8);
      SayHiWithSnsPermissionUI2.m(SayHiWithSnsPermissionUI2.this)[4] = 1;
      AppMethodBeat.o(179687);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(179688);
      paramTextPaint.setColor(SayHiWithSnsPermissionUI2.this.getResources().getColor(2131100027));
      paramTextPaint.setUnderlineText(false);
      AppMethodBeat.o(179688);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2
 * JD-Core Version:    0.7.0.1
 */