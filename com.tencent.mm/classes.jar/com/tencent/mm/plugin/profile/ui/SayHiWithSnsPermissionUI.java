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
  private long dCI;
  private ProgressDialog fOC;
  private int jij;
  private int[] joi;
  int scene;
  private String userName;
  private String wDQ;
  private MMSwitchBtn xjR;
  private MMSwitchBtn xjS;
  private WeImageView xjT;
  private WeImageView xjU;
  private boolean xjV;
  private boolean xjW;
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
  int xkx;
  int xky;
  
  public SayHiWithSnsPermissionUI()
  {
    AppMethodBeat.i(27407);
    this.fOC = null;
    this.joi = new int[8];
    this.xjV = false;
    this.xjW = false;
    this.xkr = false;
    this.xks = false;
    this.xkt = null;
    this.xku = new boolean[] { true };
    this.xkv = new boolean[] { false };
    this.dCI = System.currentTimeMillis();
    this.xkw = 0;
    this.xkx = 1;
    this.xky = 1;
    this.scene = 11;
    AppMethodBeat.o(27407);
  }
  
  private static boolean awb(String paramString)
  {
    AppMethodBeat.i(27416);
    boolean bool = com.tencent.mm.plugin.sns.b.o.zsy.awb(paramString);
    AppMethodBeat.o(27416);
    return bool;
  }
  
  private String dEB()
  {
    AppMethodBeat.i(27414);
    String str = "";
    if (this.xkm.getText() != null) {
      str = this.xkm.getText().toString();
    }
    if (!bu.isNullOrNil(str))
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
  
  private void dEy()
  {
    int j = 8;
    int k = 4;
    AppMethodBeat.i(27413);
    Object localObject = this.xjT;
    if ((this.xkr) || (this.xjW))
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.xjU;
      i = k;
      if (!this.xkr)
      {
        i = k;
        if (!this.xjW) {
          i = 0;
        }
      }
      ((WeImageView)localObject).setVisibility(i);
      ((View)this.xjT.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27402);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).setVisibility(0);
          SayHiWithSnsPermissionUI.o(SayHiWithSnsPermissionUI.this).setVisibility(4);
          SayHiWithSnsPermissionUI.this.findViewById(2131302905).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27402);
        }
      });
      View localView = (View)this.xjU.getParent();
      if (!this.xjW) {
        break label235;
      }
      localObject = null;
      label114:
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = findViewById(2131302905);
      if ((!this.xjV) || ((!this.xkr) && (!this.xjW))) {
        break label248;
      }
      i = 8;
      label153:
      ((View)localObject).setVisibility(i);
      localObject = (TextView)findViewById(2131305037);
      if (!this.xjW) {
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
      if (this.xjW) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      this.xkr = false;
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
  
  private void pC(boolean paramBoolean)
  {
    AppMethodBeat.i(27418);
    final int i;
    if (this.xkp)
    {
      i = 1;
      if (!bu.isNullOrNil(dEB())) {
        break label313;
      }
      this.xkx = 3;
      label30:
      if (!this.xjW) {
        break label349;
      }
      this.xky = 6;
      label43:
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
        this.scene = 11;
      }
    }
    for (;;)
    {
      com.tencent.e.h.MqF.aO(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186540);
          bc.aCg();
          int i = com.tencent.mm.model.c.azF().c(x.hIe, new String[] { v.aAC(), "weixin", "helper_entry", "filehelper" });
          com.tencent.mm.plugin.report.service.g.yxI.f(18713, new Object[] { SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), Integer.valueOf(i), Integer.valueOf(SayHiWithSnsPermissionUI.this.xkx), Integer.valueOf(SayHiWithSnsPermissionUI.this.xky), Integer.valueOf(SayHiWithSnsPermissionUI.this.scene), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - SayHiWithSnsPermissionUI.q(SayHiWithSnsPermissionUI.this)), Integer.valueOf(i) });
          AppMethodBeat.o(186540);
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
      if ((!dEB().equals(this.bVF)) && (!dEB().equals(this.wDQ))) {
        break label30;
      }
      this.xkx = 2;
      break label30;
      label349:
      if ((this.xkw & 0x8) != 0)
      {
        this.xky = 5;
        break label43;
      }
      if (((this.xkw & 0x1) != 0) && ((this.xkw & 0x2) != 0))
      {
        this.xky = 4;
        break label43;
      }
      if ((this.xkw & 0x2) != 0)
      {
        this.xky = 3;
        break label43;
      }
      if ((this.xkw & 0x1) == 0) {
        break label43;
      }
      this.xky = 2;
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
    Object localObject2;
    label433:
    label456:
    String str1;
    label534:
    String str2;
    if (com.tencent.mm.sdk.platformtools.j.DEBUG)
    {
      i = 1;
      if (((com.tencent.mm.n.e)localObject1).getInt("MMSocialBlackListFlag", i) != 1) {
        break label1157;
      }
      bool = true;
      this.xjV = bool;
      if (!this.xjV) {
        findViewById(2131305648).setVisibility(8);
      }
      com.tencent.mm.kernel.g.ajS();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.userName);
      if (com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.JdQ, 0) != 1) {
        break label1162;
      }
      bool = true;
      this.xkr = bool;
      this.xjR = ((MMSwitchBtn)findViewById(2131302903).findViewById(2131302906));
      getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
      this.xjR.setCheck(((an)localObject1).ady());
      this.xjT = ((WeImageView)findViewById(2131305646));
      this.xjU = ((WeImageView)findViewById(2131305036));
      this.xjS = ((MMSwitchBtn)findViewById(2131304942).findViewById(2131302910));
      bool = awb(this.userName);
      this.xjS.setCheck(bool);
      findViewById(2131297422).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27392);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          SayHiWithSnsPermissionUI.this.hideVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27392);
        }
      });
      i = ((aw)localObject1).eQV;
      ae.d("MicroMsg.SayHiWithSnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
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
      bool = an.aUq(this.userName);
      this.xks = bool;
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
            AppMethodBeat.i(27393);
            if (SayHiWithSnsPermissionUI.this.xku[0] != 0)
            {
              SayHiWithSnsPermissionUI.this.xku[0] = false;
              com.tencent.mm.plugin.normsg.a.b.wJt.auC("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.b.wJt.auD("ie_ver_usr");
            AppMethodBeat.o(27393);
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
            ae.i("MicroMsg.SayHiWithSnsPermissionUI", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localan.field_nickname });
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
            break label1247;
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
            AppMethodBeat.i(27399);
            if ((SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this) != null) && (SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this).isShowing()))
            {
              AppMethodBeat.o(27399);
              return false;
            }
            Object localObject2;
            Object localObject1;
            if (SayHiWithSnsPermissionUI.this.xkv[0] != 0)
            {
              SayHiWithSnsPermissionUI.this.xkv[0] = false;
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
                if (SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this).Lon) {
                  j = 1;
                }
                i = j;
                if (SayHiWithSnsPermissionUI.i(SayHiWithSnsPermissionUI.this).Lon) {
                  i = j | 0x2;
                }
              }
              j = i;
              if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() == 0) {
                j = i | 0x8;
              }
              SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this, j);
              localHashMap.put(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), Integer.valueOf(j));
              ae.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[] { Integer.valueOf(j) });
              if (!SayHiWithSnsPermissionUI.j(SayHiWithSnsPermissionUI.this)) {
                break label436;
              }
              paramAnonymousMenuItem = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra(e.c.JoX);
              paramAnonymousMenuItem = new com.tencent.mm.openim.b.o(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), (String)localObject1, paramAnonymousMenuItem, j);
              bc.ajj().a(paramAnonymousMenuItem, 0);
              localObject1 = SayHiWithSnsPermissionUI.this;
              localObject2 = SayHiWithSnsPermissionUI.this.getContext();
              SayHiWithSnsPermissionUI.this.getString(2131755906);
              SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(27395);
                  bc.ajj().a(paramAnonymousMenuItem);
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
                if (com.tencent.mm.plugin.messenger.e.a.yy(l)) {
                  com.tencent.mm.plugin.messenger.e.a.R(l, 4);
                }
                AppMethodBeat.o(27399);
                return false;
                com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_ver_usr", "<VerifyUsr>");
                paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
                com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_ver_usr", paramAnonymousMenuItem);
                com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_ver_usr");
                break;
                String str1 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_user_name");
                String str2 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_nick_name");
                paramAnonymousMenuItem = new aa(SayHiWithSnsPermissionUI.this, null);
                paramAnonymousMenuItem.content = ((String)localObject1);
                paramAnonymousMenuItem.ly(str1, str2);
                paramAnonymousMenuItem.Fpq = localHashMap;
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
                    paramAnonymousMenuItem.fgz();
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
              if (SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this).Lon) {
                j = 1;
              }
              i = j;
              if (SayHiWithSnsPermissionUI.i(SayHiWithSnsPermissionUI.this).Lon) {
                i = j | 0x2;
              }
            }
            if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() == 0) {
              i |= 0x8;
            }
            for (;;)
            {
              SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this, i);
              ae.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
              if (SayHiWithSnsPermissionUI.j(SayHiWithSnsPermissionUI.this))
              {
                paramAnonymousMenuItem = new com.tencent.mm.openim.b.q(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), paramAnonymousMenuItem, i);
                bc.ajj().a(paramAnonymousMenuItem, 0);
                localObject1 = SayHiWithSnsPermissionUI.this;
                localObject2 = SayHiWithSnsPermissionUI.this.getContext();
                SayHiWithSnsPermissionUI.this.getString(2131755906);
                SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(27397);
                    bc.ajj().a(paramAnonymousMenuItem);
                    AppMethodBeat.o(27397);
                  }
                }));
                break;
              }
              paramAnonymousMenuItem = new com.tencent.mm.pluginsdk.model.o(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), paramAnonymousMenuItem, SayHiWithSnsPermissionUI.e(SayHiWithSnsPermissionUI.this), SayHiWithSnsPermissionUI.k(SayHiWithSnsPermissionUI.this), i);
              bc.ajj().a(paramAnonymousMenuItem, 0);
              localObject1 = SayHiWithSnsPermissionUI.this;
              localObject2 = SayHiWithSnsPermissionUI.this.getContext();
              SayHiWithSnsPermissionUI.this.getString(2131755906);
              SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(27398);
                  bc.ajj().a(paramAnonymousMenuItem);
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$5", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(27400);
              return false;
              SayHiWithSnsPermissionUI.this.xkv[0] = true;
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
        dEy();
        break label534;
        localObject1 = k.b(getContext(), (CharSequence)localObject2, this.xkl.getTextSize());
        this.xkl.setText((CharSequence)localObject1);
      }
      label1247:
      if (!bu.isNullOrNil(this.bVF))
      {
        this.xkm.setHint(k.b(getContext(), this.bVF, this.xkm.getTextSize()));
        this.xkm.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(27394);
            if (paramAnonymousBoolean)
            {
              if ((!bu.ah(SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getHint())) && (bu.ah(SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getText())))
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
    AppMethodBeat.i(27408);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle("");
    initView();
    bc.ajj().a(30, this);
    bc.ajj().a(243, this);
    bc.ajj().a(853, this);
    AppMethodBeat.o(27408);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27411);
    bc.ajj().b(30, this);
    bc.ajj().b(243, this);
    bc.ajj().b(853, this);
    com.tencent.mm.plugin.report.service.g.yxI.f(14036, new Object[] { Integer.valueOf(this.joi[0]), Integer.valueOf(this.joi[1]), Integer.valueOf(this.joi[2]), Integer.valueOf(this.joi[3]), Integer.valueOf(this.joi[4]), Integer.valueOf(this.joi[5]), Integer.valueOf(this.joi[6]), Integer.valueOf(this.joi[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_ver_usr");
    AppMethodBeat.o(27411);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27417);
    if (paramInt == 4)
    {
      this.joi[0] = 1;
      finish();
      pC(false);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(27415);
    long l1 = System.currentTimeMillis();
    ae.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    try
    {
      if (this.fOC != null)
      {
        this.fOC.dismiss();
        this.fOC = null;
      }
      if ((this.xks) && (this.xjS.Lon) && (!awb(this.userName)))
      {
        bc.aCg();
        localObject2 = com.tencent.mm.model.c.azF().BH(this.userName);
        localObject1 = new LinkedList();
        ((LinkedList)localObject1).add(((aw)localObject2).field_username);
        localObject2 = new oz();
        ((oz)localObject2).dDT.list = ((List)localObject1);
        ((oz)localObject2).dDT.dsO = 1;
        ((oz)localObject2).dDT.dDU = 5L;
        ((oz)localObject2).dDT.dDV = true;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
      }
      if (this.xkp)
      {
        localObject1 = this.xkl.getText().toString().trim();
        if ((!bu.isNullOrNil((String)localObject1)) && (!((String)localObject1).equals(this.xkt)) && (bu.isNullOrNil(this.chatroomName))) {
          break label1182;
        }
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(294913, "");
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label1394;
      }
      com.tencent.mm.ui.base.h.cm(this, getString(2131763076));
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
        break label1046;
      }
      paramString = dEB();
      if (bu.isNullOrNil(paramString)) {
        break label1259;
      }
      ae.i("MicroMsg.SayHiWithSnsPermissionUI", "set temp remark of %s", new Object[] { this.userName });
      bc.aCg();
      localObject1 = com.tencent.mm.model.c.azF().BH(this.userName);
      ((an)localObject1).tm(paramString);
      bc.aCg();
      Object localObject2 = com.tencent.mm.model.c.azG().arE(this.userName);
      ((cg)localObject2).field_encryptUsername = this.userName;
      ((cg)localObject2).field_conRemark = paramString;
      bc.aCg();
      com.tencent.mm.model.c.azG().replace((com.tencent.mm.sdk.e.c)localObject2);
      bc.aCg();
      com.tencent.mm.model.c.azF().am((an)localObject1);
      this.joi[2] = 1;
      if ((!bu.isNullOrNil(this.bVF)) && (!paramString.equals(this.bVF))) {
        this.joi[5] = 1;
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
        ae.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + paramString.getMessage());
        label1046:
        label1182:
        return;
        label1259:
        if (bu.isNullOrNil(this.bVF)) {
          break;
        }
        this.joi[2] = 0;
      }
    }
    finally
    {
      ae.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(27415);
    }
    paramString = new LinkedList();
    if ((paramn instanceof com.tencent.mm.pluginsdk.model.o))
    {
      paramInt1 = ((com.tencent.mm.pluginsdk.model.o)paramn).dto;
      paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).Fes;
      if ((paramInt1 == 3) || ((paramn instanceof com.tencent.mm.openim.b.q)))
      {
        localObject1 = com.tencent.mm.bj.d.aML().aVx(this.userName);
        bc.aCg();
        paramn = com.tencent.mm.model.c.azF().BH(this.userName);
        if ((paramString != null) && (paramString.contains(this.userName)))
        {
          paramString = paramn;
          if ((int)paramn.ght != 0) {
            break label1349;
          }
          paramn = com.tencent.mm.pluginsdk.ui.preference.b.a((bi)localObject1);
          paramn.setUsername(this.userName);
          bc.aCg();
          paramString = paramn;
          if (com.tencent.mm.model.c.azF().an(paramn)) {
            break label1349;
          }
          ae.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
        }
        bc.aCg();
        paramString = com.tencent.mm.model.c.azF().BH(this.userName);
        paramn = new uy();
        paramn.dKj.dKl = true;
        paramn.dKj.dKk = false;
        paramn.dKj.username = this.userName;
        com.tencent.mm.sdk.b.a.IvT.l(paramn);
        if (!this.xjR.Lon) {
          break label1387;
        }
        x.v(paramString);
        paramString = new uy();
        paramString.dKj.dKl = false;
        paramString.dKj.dKk = true;
        paramString.dKj.username = this.userName;
        bool = awb(this.userName);
        paramString.dKj.dKm = bool;
        localObject1 = this.userName;
        if (this.xjS.Lon) {
          break label1622;
        }
        paramInt1 = 2;
        paramn = new LinkedList();
        paramn.add(localObject1);
        localObject1 = new oz();
        ((oz)localObject1).dDT.list = paramn;
        ((oz)localObject1).dDT.dsO = paramInt1;
        ((oz)localObject1).dDT.dDU = 5L;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
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
      ae.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(27415);
      return;
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(294913, localObject1);
      break;
      this.joi[2] = 2;
      break label580;
      if (!(paramn instanceof com.tencent.mm.openim.b.q)) {
        break label1617;
      }
      paramString.add(((com.tencent.mm.openim.b.q)paramn).iKt);
      break label1617;
      label1349:
      x.B(paramString);
      bc.getNotification().Xo();
      com.tencent.mm.bj.d.aMM().gw(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.cv(this.userName, this.jij);
      break label731;
      label1387:
      x.w(paramString);
      break label810;
      label1394:
      if ((paramInt1 != 4) || (paramInt2 != -24) || (bu.isNullOrNil(paramString))) {
        break label1627;
      }
      Toast.makeText(this, paramString, 1).show();
    }
    for (;;)
    {
      label1424:
      if (!bu.isNullOrNil(paramString))
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
          if ((this.xkp) && ((paramInt2 == -24) || (paramInt2 == -34)))
          {
            Toast.makeText(this, 2131759479, 0).show();
            break label1150;
          }
          if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.xjV))
          {
            this.xjW = true;
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JdQ, Integer.valueOf(1));
            if (!bu.isNullOrNil(paramString)) {
              ((TextView)findViewById(2131305647)).setText(paramString);
            }
            dEy();
            paramn = new f.a(this);
            paramn.aZq(paramString).zi(true).aZv(getString(2131762023)).afY(2131762024);
            paramn.c(new f.c()
            {
              public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                AppMethodBeat.i(27404);
                SayHiWithSnsPermissionUI.this.hideVKB();
                if (!paramAnonymousBoolean)
                {
                  paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ad.iR(SayHiWithSnsPermissionUI.this);
                  Intent localIntent = new Intent();
                  localIntent.putExtra("rawUrl", paramAnonymousString);
                  localIntent.putExtra("showShare", false);
                  localIntent.putExtra("show_bottom", false);
                  com.tencent.mm.br.d.b(SayHiWithSnsPermissionUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
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
    public String iWF;
    
    public a(String paramString)
    {
      this.iWF = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(27405);
      SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).setText(k.b(SayHiWithSnsPermissionUI.this, bu.nullAsNil(this.iWF), SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getTextSize()));
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