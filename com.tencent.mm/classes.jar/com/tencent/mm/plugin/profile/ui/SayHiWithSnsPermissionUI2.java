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
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.a.uy;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.al;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cg;
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
  private long dCI;
  private ProgressDialog fOC;
  private int jij;
  private int[] joi;
  private String userName;
  private String wDQ;
  private MMSwitchBtn xjR;
  private MMSwitchBtn xjS;
  private WeImageView xjT;
  private WeImageView xjU;
  private boolean xjV;
  private boolean xjW;
  private boolean xkG;
  private TextView xkd;
  private EditText xkl;
  private EditText xkm;
  private View xkn;
  private TextView xko;
  private boolean xkp;
  private boolean xkq;
  private boolean xkr;
  private boolean xks;
  private CharSequence xkt;
  final boolean[] xku;
  final boolean[] xkv;
  private int xkw;
  
  public SayHiWithSnsPermissionUI2()
  {
    AppMethodBeat.i(179689);
    this.fOC = null;
    this.joi = new int[8];
    this.xjV = false;
    this.xjW = false;
    this.xkr = false;
    this.xks = false;
    this.xkt = null;
    this.xku = new boolean[] { true };
    this.xkv = new boolean[] { false };
    this.xkG = true;
    this.dCI = System.currentTimeMillis();
    this.xkw = 0;
    AppMethodBeat.o(179689);
  }
  
  private static boolean awb(String paramString)
  {
    AppMethodBeat.i(179698);
    boolean bool = com.tencent.mm.plugin.sns.b.o.zsy.awb(paramString);
    AppMethodBeat.o(179698);
    return bool;
  }
  
  private String dEB()
  {
    AppMethodBeat.i(179696);
    String str = "";
    if (this.xkm.getText() != null) {
      str = this.xkm.getText().toString();
    }
    if (!bu.isNullOrNil(str))
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
  
  private void dEy()
  {
    AppMethodBeat.i(179695);
    Object localObject = this.xjT;
    if ((this.xkr) || (this.xjW))
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.xjU;
      if ((this.xkr) || (this.xjW)) {
        break label411;
      }
      i = 0;
      label52:
      ((WeImageView)localObject).setVisibility(i);
      if (this.xkG)
      {
        if ((!this.xkr) && (!this.xjW))
        {
          bc.aCg();
          final int j = com.tencent.mm.model.c.azF().c(x.hIe, new String[] { v.aAC(), "weixin", "helper_entry", "filehelper" });
          i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOL, 200);
          if (j >= i)
          {
            this.xjT.setVisibility(0);
            this.xjU.setVisibility(4);
            ((TextView)findViewById(2131306437)).setText(getString(2131762045, new Object[] { Integer.valueOf(i) }));
            j = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.Jea, 0);
            if (j < ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOM, 3))
            {
              localObject = new f.a(this).aZq(getString(2131762046, new Object[] { Integer.valueOf(i) }));
              ((f.a)localObject).EyN = true;
              ((f.a)localObject).afY(2131755792).b(new f.c()
              {
                public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
                {
                  AppMethodBeat.i(179684);
                  com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jea, Integer.valueOf(j + 1));
                  AppMethodBeat.o(179684);
                }
              }).show();
            }
          }
        }
        this.xkG = false;
      }
      ((View)this.xjT.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179685);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
      View localView = (View)this.xjU.getParent();
      if (!this.xjW) {
        break label416;
      }
      localObject = null;
      label328:
      localView.setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131302905).setVisibility(8);
      localObject = (TextView)findViewById(2131305037);
      if (!this.xjW) {
        break label428;
      }
    }
    label411:
    label416:
    label428:
    for (int i = getResources().getColor(2131100490);; i = getResources().getColor(2131100711))
    {
      ((TextView)localObject).setTextColor(i);
      if (this.xjW) {
        this.xkd.setVisibility(0);
      }
      this.xkr = false;
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
  
  private void pC(boolean paramBoolean)
  {
    AppMethodBeat.i(179700);
    int k;
    int m;
    label32:
    int j;
    label44:
    int i;
    if (this.xkp)
    {
      k = 1;
      m = 1;
      if (!bu.isNullOrNil(dEB())) {
        break label422;
      }
      m = 3;
      j = 1;
      if (!this.xjW) {
        break label456;
      }
      j = 6;
      switch (this.jij)
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
      bc.aCg();
      int n = com.tencent.mm.model.c.azF().c(x.hIe, new String[] { v.aAC(), "weixin", "helper_entry", "filehelper" });
      com.tencent.mm.plugin.report.service.g.yxI.f(18713, new Object[] { this.userName, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - this.dCI), Integer.valueOf(n) });
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
      if ((!dEB().equals(this.bVF)) && (!dEB().equals(this.wDQ))) {
        break label32;
      }
      m = 2;
      break label32;
      label456:
      if ((this.xkw & 0x8) != 0)
      {
        j = 5;
        break label44;
      }
      if (((this.xkw & 0x1) != 0) && ((this.xkw & 0x2) != 0))
      {
        j = 4;
        break label44;
      }
      if ((this.xkw & 0x2) != 0)
      {
        j = 3;
        break label44;
      }
      if ((this.xkw & 0x1) == 0) {
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
    this.xkp = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
    this.xkq = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
    this.userName = getIntent().getStringExtra("Contact_User");
    this.jij = getIntent().getIntExtra("Contact_Scene", 9);
    this.chatroomName = getIntent().getStringExtra("room_name");
    this.bVG = getIntent().getStringExtra("Contact_RemarkName");
    this.bVF = getIntent().getStringExtra("Contact_Nick");
    this.wDQ = getIntent().getStringExtra("Contact_RoomNickname");
    this.xkn = findViewById(2131302421);
    this.xko = ((TextView)findViewById(2131302422));
    Object localObject1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL();
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
    if (com.tencent.mm.sdk.platformtools.j.DEBUG)
    {
      i = 1;
      if (((com.tencent.mm.n.e)localObject1).getInt("MMSocialBlackListFlag", i) != 1) {
        break label1155;
      }
      bool = true;
      this.xjV = bool;
      if (!this.xjV) {
        findViewById(2131305648).setVisibility(8);
      }
      com.tencent.mm.kernel.g.ajS();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.userName);
      if (com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.JdQ, 0) != 1) {
        break label1160;
      }
      bool = true;
      this.xkr = bool;
      this.xjR = ((MMSwitchBtn)findViewById(2131302903).findViewById(2131302906));
      getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
      this.xjR.setCheck(((an)localObject1).ady());
      this.xjT = ((WeImageView)findViewById(2131305646));
      this.xjU = ((WeImageView)findViewById(2131305036));
      this.xkd = ((TextView)findViewById(2131305647));
      this.xjS = ((MMSwitchBtn)findViewById(2131304942).findViewById(2131302910));
      bool = awb(this.userName);
      this.xjS.setCheck(bool);
      findViewById(2131297422).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179673);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          SayHiWithSnsPermissionUI2.this.hideVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179673);
        }
      });
      i = ((aw)localObject1).eQV;
      ae.d("MicroMsg.SayHiWithSnsPermissionUI2", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject1 = (TextView)findViewById(2131302907);
      if (i != 1) {
        break label1165;
      }
      ((TextView)localObject1).setText(2131763930);
      localObject1 = (TextView)findViewById(2131302911);
      if (i != 1) {
        break label1180;
      }
      ((TextView)localObject1).setText(2131763786);
      bool = an.aUq(this.userName);
      this.xks = bool;
      if (!bool) {
        break label1195;
      }
      findViewById(2131305648).setVisibility(8);
      localObject1 = findViewById(2131302905);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (this.xks) {
        this.xjS.setCheck(true);
      }
      if (this.xkp)
      {
        this.xkl = ((EditText)findViewById(2131304291));
        com.tencent.mm.ui.tools.b.c.d(this.xkl).afD(100).a(null);
        this.xkl.setFilters(com.tencent.mm.pluginsdk.ui.tools.j.FCS);
        this.xkl.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(179675);
            if (SayHiWithSnsPermissionUI2.this.xku[0] != 0)
            {
              SayHiWithSnsPermissionUI2.this.xku[0] = false;
              com.tencent.mm.plugin.normsg.a.b.wJt.auC("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.b.wJt.auD("ie_ver_usr");
            AppMethodBeat.o(179675);
          }
        });
        ((LinearLayout)this.xkl.getParent()).setVisibility(0);
        bc.aCg();
        str1 = (String)com.tencent.mm.model.c.ajA().get(294913, null);
        localObject2 = v.aAE();
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
    label1155:
    label1160:
    label1165:
    label1180:
    label1195:
    label1230:
    label1915:
    for (;;)
    {
      localObject2 = str1;
      if (!bu.isNullOrNil(this.chatroomName))
      {
        an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.chatroomName);
        localObject2 = str1;
        if (localan != null)
        {
          localObject2 = str1;
          if (!bu.isNullOrNil(localan.field_nickname))
          {
            str1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().By(this.chatroomName).zP(v.aAC());
            localObject2 = str1;
            if (bu.ah(str1)) {
              localObject2 = localObject1;
            }
            ae.i("MicroMsg.SayHiWithSnsPermissionUI2", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localan.field_nickname });
            localObject2 = k.b(getContext(), getResources().getString(2131763072, new Object[] { localan.field_nickname, localObject2 }), this.xkl.getTextSize());
            this.xkt = ((CharSequence)localObject2);
          }
        }
      }
      if (bu.ah(this.xkt)) {
        this.xkt = k.b(getContext(), String.format(str2, new Object[] { localObject1 }), this.xkl.getTextSize());
      }
      if (bu.ah((CharSequence)localObject2)) {
        this.xkl.setText(this.xkt);
      }
      for (;;)
      {
        this.xkl.clearFocus();
        if (this.xkq)
        {
          this.xkm = ((EditText)findViewById(2131304294));
          ((LinearLayout)this.xkm.getParent()).setVisibility(0);
          if (!this.xkp) {
            this.xkm.clearFocus();
          }
          com.tencent.mm.ui.tools.b.c.d(this.xkm).afD(100).a(null);
          this.xkm.setFilters(com.tencent.mm.pluginsdk.ui.tools.j.FCS);
          if (!this.xkp)
          {
            ((TextView)findViewById(2131305902)).setText(2131762056);
            this.joi[0] = 1;
          }
          if (bu.isNullOrNil(this.bVG)) {
            break label1230;
          }
          this.xkm.setText(k.b(getContext(), this.bVG, this.xkm.getTextSize()));
          this.joi[6] = 1;
        }
        localObject1 = getString(2131755884);
        if (!this.xkp) {
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
            if (SayHiWithSnsPermissionUI2.this.xkv[0] != 0)
            {
              SayHiWithSnsPermissionUI2.this.xkv[0] = false;
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
              if (!SayHiWithSnsPermissionUI2.h(SayHiWithSnsPermissionUI2.this).Lon) {
                break label858;
              }
              j = 1;
              label160:
              i = j;
              if (!SayHiWithSnsPermissionUI2.i(SayHiWithSnsPermissionUI2.this).Lon) {}
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
              ae.d("MicroMsg.SayHiWithSnsPermissionUI2", "select sns permission, %s", new Object[] { Integer.valueOf(j) });
              if (SayHiWithSnsPermissionUI2.j(SayHiWithSnsPermissionUI2.this))
              {
                paramAnonymousMenuItem = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra(e.c.JoX);
                paramAnonymousMenuItem = new com.tencent.mm.openim.b.o(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), (String)localObject1, paramAnonymousMenuItem, j);
                bc.ajj().a(paramAnonymousMenuItem, 0);
                localObject1 = SayHiWithSnsPermissionUI2.this;
                localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                SayHiWithSnsPermissionUI2.this.getString(2131755906);
                SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, h.b((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(179677);
                    bc.ajj().a(paramAnonymousMenuItem);
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
                  com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_ver_usr", "<VerifyUsr>");
                  paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
                  com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_ver_usr", paramAnonymousMenuItem);
                  com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_ver_usr");
                  break;
                  String str1 = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra("source_from_user_name");
                  String str2 = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra("source_from_nick_name");
                  paramAnonymousMenuItem = new aa(SayHiWithSnsPermissionUI2.this, null);
                  paramAnonymousMenuItem.content = ((String)localObject1);
                  paramAnonymousMenuItem.ly(str1, str2);
                  paramAnonymousMenuItem.Fpq = localHashMap;
                  paramAnonymousMenuItem.chatroomName = SayHiWithSnsPermissionUI2.k(SayHiWithSnsPermissionUI2.this);
                  paramAnonymousMenuItem.D((List)localObject2, localLinkedList);
                  localObject1 = SayHiWithSnsPermissionUI2.this;
                  localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                  SayHiWithSnsPermissionUI2.this.getString(2131755906);
                  SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, h.b((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(179678);
                      paramAnonymousMenuItem.fgz();
                      AppMethodBeat.o(179678);
                    }
                  }));
                }
              } while (!SayHiWithSnsPermissionUI2.l(SayHiWithSnsPermissionUI2.this));
              paramAnonymousMenuItem = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra("Verify_ticket");
              if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() != 0) {
                if (SayHiWithSnsPermissionUI2.h(SayHiWithSnsPermissionUI2.this).Lon)
                {
                  j = 1;
                  i = j;
                  if (!SayHiWithSnsPermissionUI2.i(SayHiWithSnsPermissionUI2.this).Lon) {}
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
                  ae.d("MicroMsg.SayHiWithSnsPermissionUI2", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
                  if (SayHiWithSnsPermissionUI2.j(SayHiWithSnsPermissionUI2.this))
                  {
                    paramAnonymousMenuItem = new com.tencent.mm.openim.b.q(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), paramAnonymousMenuItem, i);
                    bc.ajj().a(paramAnonymousMenuItem, 0);
                    localObject1 = SayHiWithSnsPermissionUI2.this;
                    localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                    SayHiWithSnsPermissionUI2.this.getString(2131755906);
                    SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, h.b((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                      {
                        AppMethodBeat.i(179679);
                        bc.ajj().a(paramAnonymousMenuItem);
                        AppMethodBeat.o(179679);
                      }
                    }));
                    break;
                  }
                  paramAnonymousMenuItem = new com.tencent.mm.pluginsdk.model.o(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), paramAnonymousMenuItem, SayHiWithSnsPermissionUI2.e(SayHiWithSnsPermissionUI2.this), SayHiWithSnsPermissionUI2.k(SayHiWithSnsPermissionUI2.this), i);
                  bc.ajj().a(paramAnonymousMenuItem, 0);
                  localObject1 = SayHiWithSnsPermissionUI2.this;
                  localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                  SayHiWithSnsPermissionUI2.this.getString(2131755906);
                  SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, h.b((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(179680);
                      bc.ajj().a(paramAnonymousMenuItem);
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(179682);
              return false;
              SayHiWithSnsPermissionUI2.this.xkv[0] = true;
              com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_ver_usr", "<VerifyUsr>");
              continue;
              com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_ver_usr", paramAnonymousMotionEvent);
              com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_ver_usr");
            }
          }
        }, s.b.JwA);
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
        dEy();
        break label517;
        localObject1 = k.b(getContext(), (CharSequence)localObject2, this.xkl.getTextSize());
        this.xkl.setText((CharSequence)localObject1);
      }
      if (!bu.isNullOrNil(this.bVF))
      {
        this.xkm.setHint(k.b(getContext(), this.bVF, this.xkm.getTextSize()));
        this.xkm.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(179676);
            if (paramAnonymousBoolean)
            {
              if ((!bu.ah(SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).getHint())) && (bu.ah(SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).getText())))
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
      switch (this.jij)
      {
      case 9: 
      case 12: 
      default: 
        i = 0;
      }
      while ((!this.xkp) && (i == 0))
      {
        localObject1 = com.tencent.mm.bj.d.aML().aVx(this.userName);
        if (localObject1 == null) {
          break;
        }
        localObject2 = com.tencent.mm.pluginsdk.ui.preference.b.c(this, (bi)localObject1);
        if ((bu.isNullOrNil(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hGg)) || (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hGg.equals(getString(2131759471)))) {
          break;
        }
        str1 = getString(2131763071).substring(0, getString(2131763071).indexOf("%s"));
        localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hGg;
        if (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hGg.startsWith(str1)) {
          localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hGg.substring(str1.length());
        }
        this.xkn.setVisibility(0);
        this.xko.setText(k.b(this, bu.nullAsNil(getString(2131757818, new Object[] { ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hGg })), this.xko.getTextSize()));
        localObject2 = new com.tencent.mm.pluginsdk.ui.span.l(getString(2131766242));
        ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).setSpan(new a((String)localObject1), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).length(), 17);
        this.xko.append(" ");
        this.xko.append((CharSequence)localObject2);
        this.xko.setMovementMethod(LinkMovementMethod.getInstance());
        this.joi[3] = 3;
        break;
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(this.userName);
        if ((localObject1 == null) || (bu.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSX())) || (((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSX().equals(this.xkm.getText().toString())))
        {
          i = 0;
        }
        else
        {
          this.xkn.setVisibility(0);
          this.xko.setText(k.b(this, bu.nullAsNil(getString(2131757816, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSX() })), this.xko.getTextSize()));
          localObject2 = new com.tencent.mm.pluginsdk.ui.span.l(getString(2131766242));
          ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).setSpan(new a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSX()), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).length(), 17);
          this.xko.append(" ");
          this.xko.append((CharSequence)localObject2);
          this.xko.setMovementMethod(LinkMovementMethod.getInstance());
          this.joi[3] = 1;
          i = 1;
          continue;
          if ((bu.isNullOrNil(this.wDQ)) || (this.wDQ.equals(this.xkm.getText().toString())))
          {
            i = 0;
          }
          else
          {
            this.xkn.setVisibility(0);
            this.xko.setText(k.b(this, bu.nullAsNil(getString(2131757815, new Object[] { this.wDQ })), this.xko.getTextSize()));
            localObject1 = new com.tencent.mm.pluginsdk.ui.span.l(getString(2131766242));
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).setSpan(new a(this.wDQ), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).length(), 17);
            this.xko.append(" ");
            this.xko.append((CharSequence)localObject1);
            this.xko.setMovementMethod(LinkMovementMethod.getInstance());
            this.joi[3] = 2;
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
    bc.ajj().a(30, this);
    bc.ajj().a(243, this);
    bc.ajj().a(853, this);
    AppMethodBeat.o(179690);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(179693);
    bc.ajj().b(30, this);
    bc.ajj().b(243, this);
    bc.ajj().b(853, this);
    com.tencent.mm.plugin.report.service.g.yxI.f(14036, new Object[] { Integer.valueOf(this.joi[0]), Integer.valueOf(this.joi[1]), Integer.valueOf(this.joi[2]), Integer.valueOf(this.joi[3]), Integer.valueOf(this.joi[4]), Integer.valueOf(this.joi[5]), Integer.valueOf(this.joi[6]), Integer.valueOf(this.joi[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_ver_usr");
    AppMethodBeat.o(179693);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(179699);
    if (paramInt == 4)
    {
      this.joi[0] = 1;
      finish();
      pC(false);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(179697);
    long l1 = System.currentTimeMillis();
    ae.i("MicroMsg.SayHiWithSnsPermissionUI2", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    try
    {
      if (this.fOC != null)
      {
        this.fOC.dismiss();
        this.fOC = null;
      }
      if (this.xkp)
      {
        localObject = this.xkl.getText().toString().trim();
        if ((!bu.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.xkt)) && (bu.isNullOrNil(this.chatroomName))) {
          break label1060;
        }
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(294913, "");
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label1272;
      }
      h.cm(this, getString(2131763076));
      au.aE(this.userName, 1);
      paramString = new qk();
      paramString.dGj.username = this.userName;
      paramString.dGj.type = 1;
      com.tencent.mm.sdk.b.a.IvT.l(paramString);
      if ((this.jij == 17) && ((paramn instanceof com.tencent.mm.pluginsdk.model.o)))
      {
        long l2 = getIntent().getLongExtra("key_msg_id", 0L);
        if (l2 > 0L)
        {
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(l2);
          if (paramString.field_msgId > 0L)
          {
            paramString.fvY();
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(l2, paramString);
          }
        }
      }
      if (!this.xkq) {
        break label924;
      }
      paramString = dEB();
      if (bu.isNullOrNil(paramString)) {
        break label1137;
      }
      ae.i("MicroMsg.SayHiWithSnsPermissionUI2", "set temp remark of %s", new Object[] { this.userName });
      bc.aCg();
      localObject = com.tencent.mm.model.c.azF().BH(this.userName);
      ((an)localObject).tm(paramString);
      bc.aCg();
      cg localcg = com.tencent.mm.model.c.azG().arE(this.userName);
      localcg.field_encryptUsername = this.userName;
      localcg.field_conRemark = paramString;
      bc.aCg();
      com.tencent.mm.model.c.azG().replace(localcg);
      bc.aCg();
      com.tencent.mm.model.c.azF().am((an)localObject);
      this.joi[2] = 1;
      if ((!bu.isNullOrNil(this.bVF)) && (!paramString.equals(this.bVF))) {
        this.joi[5] = 1;
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
        ae.e("MicroMsg.SayHiWithSnsPermissionUI2", "exception in onSceneEnd : " + paramString.getMessage());
        label924:
        label1060:
        return;
        label1028:
        label1137:
        if (bu.isNullOrNil(this.bVF)) {
          break;
        }
        this.joi[2] = 0;
      }
    }
    finally
    {
      ae.i("MicroMsg.SayHiWithSnsPermissionUI2", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(179697);
    }
    paramString = new LinkedList();
    if ((paramn instanceof com.tencent.mm.pluginsdk.model.o))
    {
      paramInt1 = ((com.tencent.mm.pluginsdk.model.o)paramn).dto;
      paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).Fes;
      if ((paramInt1 == 3) || ((paramn instanceof com.tencent.mm.openim.b.q)))
      {
        localObject = com.tencent.mm.bj.d.aML().aVx(this.userName);
        bc.aCg();
        paramn = com.tencent.mm.model.c.azF().BH(this.userName);
        if ((paramString != null) && (paramString.contains(this.userName)))
        {
          paramString = paramn;
          if ((int)paramn.ght != 0) {
            break label1227;
          }
          paramn = com.tencent.mm.pluginsdk.ui.preference.b.a((bi)localObject);
          paramn.setUsername(this.userName);
          bc.aCg();
          paramString = paramn;
          if (com.tencent.mm.model.c.azF().an(paramn)) {
            break label1227;
          }
          ae.e("MicroMsg.SayHiWithSnsPermissionUI2", "canAddContact fail, insert fail");
        }
        bc.aCg();
        paramString = com.tencent.mm.model.c.azF().BH(this.userName);
        paramn = new uy();
        paramn.dKj.dKl = true;
        paramn.dKj.dKk = false;
        paramn.dKj.username = this.userName;
        com.tencent.mm.sdk.b.a.IvT.l(paramn);
        if (!this.xjR.Lon) {
          break label1265;
        }
        x.v(paramString);
        paramString = new uy();
        paramString.dKj.dKl = false;
        paramString.dKj.dKk = true;
        paramString.dKj.username = this.userName;
        bool = awb(this.userName);
        paramString.dKj.dKm = bool;
        localObject = this.userName;
        if (this.xjS.Lon) {
          break label1495;
        }
        paramInt1 = 2;
        paramn = new LinkedList();
        paramn.add(localObject);
        localObject = new oz();
        ((oz)localObject).dDT.list = paramn;
        ((oz)localObject).dDT.dsO = paramInt1;
        ((oz)localObject).dDT.dDU = 5L;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        com.tencent.mm.sdk.b.a.IvT.l(paramString);
        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false))
        {
          paramString = new Intent();
          paramString.putExtra("friend_message_transfer_username", this.userName);
          paramString.setAction("friend_message_accept_" + this.userName);
          paramString.putExtra("MMActivity.OverrideEnterAnimation", 2130772144);
          paramString.putExtra("MMActivity.OverrideExitAnimation", 2130772141);
          com.tencent.mm.br.d.b(this, "subapp", ".ui.friend.FMessageTransferUI", paramString);
        }
      }
      getIntent().putExtra("CONTACT_INFO_UI_SOURCE", 7);
      com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(getIntent())), Integer.valueOf(1), Integer.valueOf(1), this.userName });
      setResult(-1, getIntent());
      finish();
      pC(true);
      if ((this.xkw & 0x8) == 0) {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JdQ, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.SayHiWithSnsPermissionUI2", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(179697);
      return;
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(294913, localObject);
      break;
      this.joi[2] = 2;
      break label458;
      if (!(paramn instanceof com.tencent.mm.openim.b.q)) {
        break label1490;
      }
      paramString.add(((com.tencent.mm.openim.b.q)paramn).iKt);
      break label1490;
      label1227:
      x.B(paramString);
      bc.getNotification().Xo();
      com.tencent.mm.bj.d.aMM().gw(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.cv(this.userName, this.jij);
      break label609;
      label1265:
      x.w(paramString);
      break label688;
      label1272:
      if ((paramInt1 != 4) || (paramInt2 != -24) || (bu.isNullOrNil(paramString))) {
        break label1500;
      }
      Toast.makeText(this, paramString, 1).show();
    }
    for (;;)
    {
      label1302:
      if (!bu.isNullOrNil(paramString))
      {
        h.a(this, paramString, "", getString(2131755835), null);
        break label1028;
      }
      label1490:
      label1495:
      label1500:
      do
      {
        do
        {
          if ((this.xkp) && ((paramInt2 == -24) || (paramInt2 == -34)))
          {
            Toast.makeText(this, 2131759479, 0).show();
            break label1028;
          }
          if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.xjV))
          {
            this.xjW = true;
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JdQ, Integer.valueOf(1));
            if (!bu.isNullOrNil(paramString)) {
              this.xkd.setText(paramString);
            }
            dEy();
            paramn = new f.a(this);
            paramn.aZq(paramString).zi(true).aZv(getString(2131762023)).afY(2131762024);
            paramn.c(new f.c()
            {
              public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                AppMethodBeat.i(179674);
                SayHiWithSnsPermissionUI2.this.hideVKB();
                if (!paramAnonymousBoolean)
                {
                  paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ad.iR(SayHiWithSnsPermissionUI2.this);
                  Intent localIntent = new Intent();
                  localIntent.putExtra("rawUrl", paramAnonymousString);
                  localIntent.putExtra("showShare", false);
                  localIntent.putExtra("show_bottom", false);
                  com.tencent.mm.br.d.b(SayHiWithSnsPermissionUI2.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                }
                AppMethodBeat.o(179674);
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
    public String iWF;
    
    public a(String paramString)
    {
      this.iWF = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(179687);
      SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).setText(k.b(SayHiWithSnsPermissionUI2.this, bu.nullAsNil(this.iWF), SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).getTextSize()));
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