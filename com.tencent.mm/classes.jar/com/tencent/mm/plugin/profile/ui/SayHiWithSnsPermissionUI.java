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

public class SayHiWithSnsPermissionUI
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
  int scene;
  private String userName;
  private boolean wUA;
  private boolean wUB;
  private CharSequence wUC;
  final boolean[] wUD;
  final boolean[] wUE;
  private int wUF;
  int wUG;
  int wUH;
  private MMSwitchBtn wUa;
  private MMSwitchBtn wUb;
  private WeImageView wUc;
  private WeImageView wUd;
  private boolean wUe;
  private boolean wUf;
  private EditText wUu;
  private EditText wUv;
  private View wUw;
  private TextView wUx;
  private boolean wUy;
  private boolean wUz;
  private String woh;
  
  public SayHiWithSnsPermissionUI()
  {
    AppMethodBeat.i(27407);
    this.fMu = null;
    this.jlo = new int[8];
    this.wUe = false;
    this.wUf = false;
    this.wUA = false;
    this.wUB = false;
    this.wUC = null;
    this.wUD = new boolean[] { true };
    this.wUE = new boolean[] { false };
    this.dBD = System.currentTimeMillis();
    this.wUF = 0;
    this.wUG = 1;
    this.wUH = 1;
    this.scene = 11;
    AppMethodBeat.o(27407);
  }
  
  private static boolean auM(String paramString)
  {
    AppMethodBeat.i(27416);
    boolean bool = com.tencent.mm.plugin.sns.b.o.zbV.auM(paramString);
    AppMethodBeat.o(27416);
    return bool;
  }
  
  private void dBh()
  {
    int j = 8;
    int k = 4;
    AppMethodBeat.i(27413);
    Object localObject = this.wUc;
    if ((this.wUA) || (this.wUf))
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.wUd;
      i = k;
      if (!this.wUA)
      {
        i = k;
        if (!this.wUf) {
          i = 0;
        }
      }
      ((WeImageView)localObject).setVisibility(i);
      ((View)this.wUc.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27402);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).setVisibility(0);
          SayHiWithSnsPermissionUI.o(SayHiWithSnsPermissionUI.this).setVisibility(4);
          SayHiWithSnsPermissionUI.this.findViewById(2131302905).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27402);
        }
      });
      View localView = (View)this.wUd.getParent();
      if (!this.wUf) {
        break label235;
      }
      localObject = null;
      label114:
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = findViewById(2131302905);
      if ((!this.wUe) || ((!this.wUA) && (!this.wUf))) {
        break label248;
      }
      i = 8;
      label153:
      ((View)localObject).setVisibility(i);
      localObject = (TextView)findViewById(2131305037);
      if (!this.wUf) {
        break label253;
      }
    }
    label235:
    label248:
    label253:
    for (int i = getResources().getColor(2131100490);; i = getResources().getColor(2131100711))
    {
      ((TextView)localObject).setTextColor(i);
      localObject = findViewById(2131305647);
      i = j;
      if (this.wUf) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      this.wUA = false;
      AppMethodBeat.o(27413);
      return;
      i = 4;
      break;
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27403);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).setVisibility(4);
          SayHiWithSnsPermissionUI.o(SayHiWithSnsPermissionUI.this).setVisibility(0);
          SayHiWithSnsPermissionUI.this.findViewById(2131302905).setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27403);
        }
      };
      break label114;
      i = 0;
      break label153;
    }
  }
  
  private String dBk()
  {
    AppMethodBeat.i(27414);
    String str = "";
    if (this.wUv.getText() != null) {
      str = this.wUv.getText().toString();
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
  
  private void pu(boolean paramBoolean)
  {
    AppMethodBeat.i(27418);
    final int i;
    if (this.wUy)
    {
      i = 1;
      if (!bt.isNullOrNil(dBk())) {
        break label313;
      }
      this.wUG = 3;
      label30:
      if (!this.wUf) {
        break label349;
      }
      this.wUH = 6;
      label43:
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
        this.scene = 11;
      }
    }
    for (;;)
    {
      com.tencent.e.h.LTJ.aR(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193266);
          ba.aBQ();
          int i = com.tencent.mm.model.c.azp().c(w.hFm, new String[] { u.aAm(), "weixin", "helper_entry", "filehelper" });
          com.tencent.mm.plugin.report.service.g.yhR.f(18713, new Object[] { SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), Integer.valueOf(i), Integer.valueOf(SayHiWithSnsPermissionUI.this.wUG), Integer.valueOf(SayHiWithSnsPermissionUI.this.wUH), Integer.valueOf(SayHiWithSnsPermissionUI.this.scene), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - SayHiWithSnsPermissionUI.q(SayHiWithSnsPermissionUI.this)), Integer.valueOf(i) });
          AppMethodBeat.o(193266);
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
      if ((!dBk().equals(this.bVF)) && (!dBk().equals(this.woh))) {
        break label30;
      }
      this.wUG = 2;
      break label30;
      label349:
      if ((this.wUF & 0x8) != 0)
      {
        this.wUH = 5;
        break label43;
      }
      if (((this.wUF & 0x1) != 0) && ((this.wUF & 0x2) != 0))
      {
        this.wUH = 4;
        break label43;
      }
      if ((this.wUF & 0x2) != 0)
      {
        this.wUH = 3;
        break label43;
      }
      if ((this.wUF & 0x1) == 0) {
        break label43;
      }
      this.wUH = 2;
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
    Object localObject2;
    label433:
    label456:
    String str1;
    label534:
    String str2;
    if (com.tencent.mm.sdk.platformtools.i.DEBUG)
    {
      i = 1;
      if (((com.tencent.mm.n.e)localObject1).getInt("MMSocialBlackListFlag", i) != 1) {
        break label1157;
      }
      bool = true;
      this.wUe = bool;
      if (!this.wUe) {
        findViewById(2131305648).setVisibility(8);
      }
      com.tencent.mm.kernel.g.ajD();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.userName);
      if (com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IJk, 0) != 1) {
        break label1162;
      }
      bool = true;
      this.wUA = bool;
      this.wUa = ((MMSwitchBtn)findViewById(2131302903).findViewById(2131302906));
      getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
      this.wUa.setCheck(((am)localObject1).adn());
      this.wUc = ((WeImageView)findViewById(2131305646));
      this.wUd = ((WeImageView)findViewById(2131305036));
      this.wUb = ((MMSwitchBtn)findViewById(2131304942).findViewById(2131302910));
      bool = auM(this.userName);
      this.wUb.setCheck(bool);
      findViewById(2131297422).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27392);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          SayHiWithSnsPermissionUI.this.hideVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27392);
        }
      });
      i = ((aw)localObject1).ePk;
      ad.d("MicroMsg.SayHiWithSnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject1 = (TextView)findViewById(2131302907);
      if (i != 1) {
        break label1167;
      }
      ((TextView)localObject1).setText(2131763930);
      localObject1 = (TextView)findViewById(2131302911);
      if (i != 1) {
        break label1182;
      }
      ((TextView)localObject1).setText(2131763786);
      bool = am.aSQ(this.userName);
      this.wUB = bool;
      if (!bool) {
        break label1212;
      }
      findViewById(2131305648).setVisibility(8);
      localObject2 = findViewById(2131302903);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      ((TextView)findViewById(2131308368)).setText(2131762058);
      if (i != 1) {
        break label1197;
      }
      ((TextView)localObject1).setText(2131762033);
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
            AppMethodBeat.i(27393);
            if (SayHiWithSnsPermissionUI.this.wUD[0] != 0)
            {
              SayHiWithSnsPermissionUI.this.wUD[0] = false;
              com.tencent.mm.plugin.normsg.a.b.wtJ.atp("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.b.wtJ.atq("ie_ver_usr");
            AppMethodBeat.o(27393);
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
          break label1931;
        }
        localObject1 = ((String)localObject1).substring(0, 50 - str2.length());
      }
    }
    label1157:
    label1162:
    label1931:
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
            ad.i("MicroMsg.SayHiWithSnsPermissionUI", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localam.field_nickname });
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
            break label1247;
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
            AppMethodBeat.i(27399);
            if ((SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this) != null) && (SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this).isShowing()))
            {
              AppMethodBeat.o(27399);
              return false;
            }
            Object localObject2;
            Object localObject1;
            if (SayHiWithSnsPermissionUI.this.wUE[0] != 0)
            {
              SayHiWithSnsPermissionUI.this.wUE[0] = false;
              if (!SayHiWithSnsPermissionUI.c(SayHiWithSnsPermissionUI.this)) {
                break label574;
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
                if (SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this).KRP) {
                  j = 1;
                }
                i = j;
                if (SayHiWithSnsPermissionUI.i(SayHiWithSnsPermissionUI.this).KRP) {
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
                break label436;
              }
              paramAnonymousMenuItem = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra(e.c.IUp);
              paramAnonymousMenuItem = new com.tencent.mm.openim.b.o(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), (String)localObject1, paramAnonymousMenuItem, j);
              ba.aiU().a(paramAnonymousMenuItem, 0);
              localObject1 = SayHiWithSnsPermissionUI.this;
              localObject2 = SayHiWithSnsPermissionUI.this.getContext();
              SayHiWithSnsPermissionUI.this.getString(2131755906);
              SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(27395);
                  ba.aiU().a(paramAnonymousMenuItem);
                  AppMethodBeat.o(27395);
                }
              }));
            }
            label436:
            label574:
            while (!SayHiWithSnsPermissionUI.l(SayHiWithSnsPermissionUI.this)) {
              for (;;)
              {
                LinkedList localLinkedList;
                HashMap localHashMap;
                long l = SayHiWithSnsPermissionUI.this.getIntent().getLongExtra("key_msg_id", 0L);
                if (com.tencent.mm.plugin.messenger.e.a.ye(l)) {
                  com.tencent.mm.plugin.messenger.e.a.R(l, 4);
                }
                AppMethodBeat.o(27399);
                return false;
                com.tencent.mm.plugin.normsg.a.b.wtJ.io("ce_ver_usr", "<VerifyUsr>");
                paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
                com.tencent.mm.plugin.normsg.a.b.wtJ.a("ce_ver_usr", paramAnonymousMenuItem);
                com.tencent.mm.plugin.normsg.a.b.wtJ.atu("ce_ver_usr");
                break;
                String str1 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_user_name");
                String str2 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_nick_name");
                paramAnonymousMenuItem = new aa(SayHiWithSnsPermissionUI.this, null);
                paramAnonymousMenuItem.content = ((String)localObject1);
                paramAnonymousMenuItem.lr(str1, str2);
                paramAnonymousMenuItem.EWW = localHashMap;
                paramAnonymousMenuItem.chatroomName = SayHiWithSnsPermissionUI.k(SayHiWithSnsPermissionUI.this);
                paramAnonymousMenuItem.E((List)localObject2, localLinkedList);
                localObject1 = SayHiWithSnsPermissionUI.this;
                localObject2 = SayHiWithSnsPermissionUI.this.getContext();
                SayHiWithSnsPermissionUI.this.getString(2131755906);
                SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(27396);
                    paramAnonymousMenuItem.fcL();
                    AppMethodBeat.o(27396);
                  }
                }));
              }
            }
            paramAnonymousMenuItem = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("Verify_ticket");
            int i = 0;
            int j = 0;
            if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() != 0)
            {
              if (SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this).KRP) {
                j = 1;
              }
              i = j;
              if (SayHiWithSnsPermissionUI.i(SayHiWithSnsPermissionUI.this).KRP) {
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
              if (SayHiWithSnsPermissionUI.j(SayHiWithSnsPermissionUI.this))
              {
                paramAnonymousMenuItem = new com.tencent.mm.openim.b.q(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), paramAnonymousMenuItem, i);
                ba.aiU().a(paramAnonymousMenuItem, 0);
                localObject1 = SayHiWithSnsPermissionUI.this;
                localObject2 = SayHiWithSnsPermissionUI.this.getContext();
                SayHiWithSnsPermissionUI.this.getString(2131755906);
                SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(27397);
                    ba.aiU().a(paramAnonymousMenuItem);
                    AppMethodBeat.o(27397);
                  }
                }));
                break;
              }
              paramAnonymousMenuItem = new com.tencent.mm.pluginsdk.model.o(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), paramAnonymousMenuItem, SayHiWithSnsPermissionUI.e(SayHiWithSnsPermissionUI.this), SayHiWithSnsPermissionUI.k(SayHiWithSnsPermissionUI.this), i);
              ba.aiU().a(paramAnonymousMenuItem, 0);
              localObject1 = SayHiWithSnsPermissionUI.this;
              localObject2 = SayHiWithSnsPermissionUI.this.getContext();
              SayHiWithSnsPermissionUI.this.getString(2131755906);
              SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(27398);
                  ba.aiU().a(paramAnonymousMenuItem);
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
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(27400);
              return false;
              SayHiWithSnsPermissionUI.this.wUE[0] = true;
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
        bool = false;
        break label184;
        bool = false;
        break label255;
        label1167:
        if (i != 2) {
          break label433;
        }
        ((TextView)localObject1).setText(2131763929);
        break label433;
        label1182:
        if (i != 2) {
          break label456;
        }
        ((TextView)localObject1).setText(2131763785);
        break label456;
        label1197:
        if (i != 2) {
          break label534;
        }
        ((TextView)localObject1).setText(2131762031);
        break label534;
        label1212:
        dBh();
        break label534;
        localObject1 = k.b(getContext(), (CharSequence)localObject2, this.wUu.getTextSize());
        this.wUu.setText((CharSequence)localObject1);
      }
      label1247:
      if (!bt.isNullOrNil(this.bVF))
      {
        this.wUv.setHint(k.b(getContext(), this.bVF, this.wUv.getTextSize()));
        this.wUv.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
    AppMethodBeat.i(27408);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle("");
    initView();
    ba.aiU().a(30, this);
    ba.aiU().a(243, this);
    ba.aiU().a(853, this);
    AppMethodBeat.o(27408);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27411);
    ba.aiU().b(30, this);
    ba.aiU().b(243, this);
    ba.aiU().b(853, this);
    com.tencent.mm.plugin.report.service.g.yhR.f(14036, new Object[] { Integer.valueOf(this.jlo[0]), Integer.valueOf(this.jlo[1]), Integer.valueOf(this.jlo[2]), Integer.valueOf(this.jlo[3]), Integer.valueOf(this.jlo[4]), Integer.valueOf(this.jlo[5]), Integer.valueOf(this.jlo[6]), Integer.valueOf(this.jlo[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.b.wtJ.atr("ie_ver_usr");
    AppMethodBeat.o(27411);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27417);
    if (paramInt == 4)
    {
      this.jlo[0] = 1;
      finish();
      pu(false);
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
    AppMethodBeat.o(27409);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(27415);
    long l1 = System.currentTimeMillis();
    ad.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    try
    {
      if (this.fMu != null)
      {
        this.fMu.dismiss();
        this.fMu = null;
      }
      if ((this.wUB) && (this.wUb.KRP) && (!auM(this.userName)))
      {
        ba.aBQ();
        localObject2 = com.tencent.mm.model.c.azp().Bf(this.userName);
        localObject1 = new LinkedList();
        ((LinkedList)localObject1).add(((aw)localObject2).field_username);
        localObject2 = new oy();
        ((oy)localObject2).dCO.list = ((List)localObject1);
        ((oy)localObject2).dCO.drI = 1;
        ((oy)localObject2).dCO.dCP = 5L;
        ((oy)localObject2).dCO.dCQ = true;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
      }
      if (this.wUy)
      {
        localObject1 = this.wUu.getText().toString().trim();
        if ((!bt.isNullOrNil((String)localObject1)) && (!((String)localObject1).equals(this.wUC)) && (bt.isNullOrNil(this.chatroomName))) {
          break label1182;
        }
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(294913, "");
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label1394;
      }
      com.tencent.mm.ui.base.h.cl(this, getString(2131763076));
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
        break label1046;
      }
      paramString = dBk();
      if (bt.isNullOrNil(paramString)) {
        break label1259;
      }
      ad.i("MicroMsg.SayHiWithSnsPermissionUI", "set temp remark of %s", new Object[] { this.userName });
      ba.aBQ();
      localObject1 = com.tencent.mm.model.c.azp().Bf(this.userName);
      ((am)localObject1).sR(paramString);
      ba.aBQ();
      Object localObject2 = com.tencent.mm.model.c.azq().aqz(this.userName);
      ((cf)localObject2).field_encryptUsername = this.userName;
      ((cf)localObject2).field_conRemark = paramString;
      ba.aBQ();
      com.tencent.mm.model.c.azq().replace((com.tencent.mm.sdk.e.c)localObject2);
      ba.aBQ();
      com.tencent.mm.model.c.azp().af((am)localObject1);
      this.jlo[2] = 1;
      if ((!bt.isNullOrNil(this.bVF)) && (!paramString.equals(this.bVF))) {
        this.jlo[5] = 1;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject1;
        label580:
        label731:
        boolean bool;
        label810:
        label881:
        label1150:
        ad.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + paramString.getMessage());
        label1046:
        label1182:
        return;
        label1259:
        if (bt.isNullOrNil(this.bVF)) {
          break;
        }
        this.jlo[2] = 0;
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
      paramInt1 = ((com.tencent.mm.pluginsdk.model.o)paramn).dsi;
      paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).ELU;
      if ((paramInt1 == 3) || ((paramn instanceof com.tencent.mm.openim.b.q)))
      {
        localObject1 = com.tencent.mm.bk.d.aMn().aTW(this.userName);
        ba.aBQ();
        paramn = com.tencent.mm.model.c.azp().Bf(this.userName);
        if ((paramString != null) && (paramString.contains(this.userName)))
        {
          paramString = paramn;
          if ((int)paramn.gfj != 0) {
            break label1349;
          }
          paramn = com.tencent.mm.pluginsdk.ui.preference.b.a((bh)localObject1);
          paramn.setUsername(this.userName);
          ba.aBQ();
          paramString = paramn;
          if (com.tencent.mm.model.c.azp().ag(paramn)) {
            break label1349;
          }
          ad.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
        }
        ba.aBQ();
        paramString = com.tencent.mm.model.c.azp().Bf(this.userName);
        paramn = new uu();
        paramn.dIV.dIX = true;
        paramn.dIV.dIW = false;
        paramn.dIV.username = this.userName;
        com.tencent.mm.sdk.b.a.IbL.l(paramn);
        if (!this.wUa.KRP) {
          break label1387;
        }
        w.o(paramString);
        paramString = new uu();
        paramString.dIV.dIX = false;
        paramString.dIV.dIW = true;
        paramString.dIV.username = this.userName;
        bool = auM(this.userName);
        paramString.dIV.dIY = bool;
        localObject1 = this.userName;
        if (this.wUb.KRP) {
          break label1622;
        }
        paramInt1 = 2;
        paramn = new LinkedList();
        paramn.add(localObject1);
        localObject1 = new oy();
        ((oy)localObject1).dCO.list = paramn;
        ((oy)localObject1).dCO.drI = paramInt1;
        ((oy)localObject1).dCO.dCP = 5L;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
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
      ad.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(27415);
      return;
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(294913, localObject1);
      break;
      this.jlo[2] = 2;
      break label580;
      if (!(paramn instanceof com.tencent.mm.openim.b.q)) {
        break label1617;
      }
      paramString.add(((com.tencent.mm.openim.b.q)paramn).iHA);
      break label1617;
      label1349:
      w.u(paramString);
      ba.getNotification().Xg();
      com.tencent.mm.bk.d.aMo().gn(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.cr(this.userName, this.jfq);
      break label731;
      label1387:
      w.p(paramString);
      break label810;
      label1394:
      if ((paramInt1 != 4) || (paramInt2 != -24) || (bt.isNullOrNil(paramString))) {
        break label1627;
      }
      Toast.makeText(this, paramString, 1).show();
    }
    for (;;)
    {
      label1424:
      if (!bt.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131755835), null);
        break label1150;
      }
      label1617:
      label1622:
      label1627:
      do
      {
        do
        {
          if ((this.wUy) && ((paramInt2 == -24) || (paramInt2 == -34)))
          {
            Toast.makeText(this, 2131759479, 0).show();
            break label1150;
          }
          if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.wUe))
          {
            this.wUf = true;
            com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJk, Integer.valueOf(1));
            if (!bt.isNullOrNil(paramString)) {
              ((TextView)findViewById(2131305647)).setText(paramString);
            }
            dBh();
            paramn = new f.a(this);
            paramn.aXO(paramString).yU(true).aXT(getString(2131762023)).afp(2131762024);
            paramn.c(new f.c()
            {
              public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                AppMethodBeat.i(27404);
                SayHiWithSnsPermissionUI.this.hideVKB();
                if (!paramAnonymousBoolean)
                {
                  paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ac.iM(SayHiWithSnsPermissionUI.this);
                  Intent localIntent = new Intent();
                  localIntent.putExtra("rawUrl", paramAnonymousString);
                  localIntent.putExtra("showShare", false);
                  localIntent.putExtra("show_bottom", false);
                  com.tencent.mm.bs.d.b(SayHiWithSnsPermissionUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                }
                AppMethodBeat.o(27404);
              }
            }).show();
            break label1150;
          }
          Toast.makeText(this, 2131763075, 0).show();
          break label1150;
          paramInt1 = 0;
          break;
          paramInt1 = 1;
          break label881;
        } while (paramInt1 != 4);
        if (paramInt2 == -2) {
          break label1424;
        }
      } while (paramInt2 != -101);
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(27410);
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
    public String iTM;
    
    public a(String paramString)
    {
      this.iTM = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(27405);
      SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).setText(k.b(SayHiWithSnsPermissionUI.this, bt.nullAsNil(this.iTM), SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getTextSize()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI
 * JD-Core Version:    0.7.0.1
 */