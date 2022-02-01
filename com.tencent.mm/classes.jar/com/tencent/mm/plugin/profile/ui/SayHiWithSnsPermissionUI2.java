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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.x;
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

public class SayHiWithSnsPermissionUI2
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String bLs;
  private String bLt;
  private String chatroomName;
  private long dpQ;
  private ProgressDialog fts;
  private int iMg;
  private int[] iSg;
  private String userName;
  private MMSwitchBtn vMR;
  private MMSwitchBtn vMS;
  private WeImageView vMT;
  private WeImageView vMU;
  private boolean vMV;
  private boolean vMW;
  private boolean vNG;
  private TextView vNd;
  private EditText vNl;
  private EditText vNm;
  private View vNn;
  private TextView vNo;
  private boolean vNp;
  private boolean vNq;
  private boolean vNr;
  private boolean vNs;
  private CharSequence vNt;
  final boolean[] vNu;
  final boolean[] vNv;
  private int vNw;
  private String viO;
  
  public SayHiWithSnsPermissionUI2()
  {
    AppMethodBeat.i(179689);
    this.fts = null;
    this.iSg = new int[8];
    this.vMV = false;
    this.vMW = false;
    this.vNr = false;
    this.vNs = false;
    this.vNt = null;
    this.vNu = new boolean[] { true };
    this.vNv = new boolean[] { false };
    this.vNG = true;
    this.dpQ = System.currentTimeMillis();
    this.vNw = 0;
    AppMethodBeat.o(179689);
  }
  
  private static boolean apG(String paramString)
  {
    AppMethodBeat.i(179698);
    boolean bool = com.tencent.mm.plugin.sns.b.o.xMd.apG(paramString);
    AppMethodBeat.o(179698);
    return bool;
  }
  
  private void dqE()
  {
    AppMethodBeat.i(179695);
    Object localObject = this.vMT;
    if ((this.vNr) || (this.vMW))
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.vMU;
      if ((this.vNr) || (this.vMW)) {
        break label411;
      }
      i = 0;
      label52:
      ((WeImageView)localObject).setVisibility(i);
      if (this.vNG)
      {
        if ((!this.vNr) && (!this.vMW))
        {
          az.ayM();
          final int j = com.tencent.mm.model.c.awB().c(w.hmW, new String[] { u.axw(), "weixin", "helper_entry", "filehelper" });
          i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbD, 200);
          if (j >= i)
          {
            this.vMT.setVisibility(0);
            this.vMU.setVisibility(4);
            ((TextView)findViewById(2131306437)).setText(getString(2131762045, new Object[] { Integer.valueOf(i) }));
            j = com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GWw, 0);
            if (j < ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qbE, 3))
            {
              localObject = new f.a(this).aRQ(getString(2131762046, new Object[] { Integer.valueOf(i) }));
              ((f.a)localObject).JfY = true;
              ((f.a)localObject).acQ(2131755792).b(new f.c()
              {
                public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
                {
                  AppMethodBeat.i(179684);
                  com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWw, Integer.valueOf(j + 1));
                  AppMethodBeat.o(179684);
                }
              }).show();
            }
          }
        }
        this.vNG = false;
      }
      ((View)this.vMT.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179685);
          if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() != 0)
          {
            SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).setVisibility(0);
            SayHiWithSnsPermissionUI2.o(SayHiWithSnsPermissionUI2.this).setVisibility(4);
            SayHiWithSnsPermissionUI2.this.findViewById(2131302905).setVisibility(8);
          }
          AppMethodBeat.o(179685);
        }
      });
      View localView = (View)this.vMU.getParent();
      if (!this.vMW) {
        break label416;
      }
      localObject = null;
      label328:
      localView.setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131302905).setVisibility(8);
      localObject = (TextView)findViewById(2131305037);
      if (!this.vMW) {
        break label428;
      }
    }
    label411:
    label416:
    label428:
    for (int i = getResources().getColor(2131100490);; i = getResources().getColor(2131100711))
    {
      ((TextView)localObject).setTextColor(i);
      if (this.vMW) {
        this.vNd.setVisibility(0);
      }
      this.vNr = false;
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
          if (SayHiWithSnsPermissionUI2.o(SayHiWithSnsPermissionUI2.this).getVisibility() != 0)
          {
            SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).setVisibility(4);
            SayHiWithSnsPermissionUI2.o(SayHiWithSnsPermissionUI2.this).setVisibility(0);
            SayHiWithSnsPermissionUI2.this.findViewById(2131302905).setVisibility(8);
          }
          AppMethodBeat.o(179686);
        }
      };
      break label328;
    }
  }
  
  private String dqH()
  {
    AppMethodBeat.i(179696);
    String str = "";
    if (this.vNm.getText() != null) {
      str = this.vNm.getText().toString();
    }
    if (!bs.isNullOrNil(str))
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
  
  private void oV(boolean paramBoolean)
  {
    AppMethodBeat.i(179700);
    int k;
    int m;
    label32:
    int j;
    label44:
    int i;
    if (this.vNp)
    {
      k = 1;
      m = 1;
      if (!bs.isNullOrNil(dqH())) {
        break label422;
      }
      m = 3;
      j = 1;
      if (!this.vMW) {
        break label456;
      }
      j = 6;
      switch (this.iMg)
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
      az.ayM();
      int n = com.tencent.mm.model.c.awB().c(w.hmW, new String[] { u.axw(), "weixin", "helper_entry", "filehelper" });
      com.tencent.mm.plugin.report.service.h.wUl.f(18713, new Object[] { this.userName, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - this.dpQ), Integer.valueOf(n) });
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
      if ((!dqH().equals(this.bLs)) && (!dqH().equals(this.viO))) {
        break label32;
      }
      m = 2;
      break label32;
      label456:
      if ((this.vNw & 0x8) != 0)
      {
        j = 5;
        break label44;
      }
      if (((this.vNw & 0x1) != 0) && ((this.vNw & 0x2) != 0))
      {
        j = 4;
        break label44;
      }
      if ((this.vNw & 0x2) != 0)
      {
        j = 3;
        break label44;
      }
      if ((this.vNw & 0x1) == 0) {
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
    this.vNp = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
    this.vNq = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
    this.userName = getIntent().getStringExtra("Contact_User");
    this.iMg = getIntent().getIntExtra("Contact_Scene", 9);
    this.chatroomName = getIntent().getStringExtra("room_name");
    this.bLt = getIntent().getStringExtra("Contact_RemarkName");
    this.bLs = getIntent().getStringExtra("Contact_Nick");
    this.viO = getIntent().getStringExtra("Contact_RoomNickname");
    this.vNn = findViewById(2131302421);
    this.vNo = ((TextView)findViewById(2131302422));
    Object localObject1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).ZY();
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
    if (com.tencent.mm.sdk.platformtools.h.DEBUG)
    {
      i = 1;
      if (((com.tencent.mm.m.e)localObject1).getInt("MMSocialBlackListFlag", i) != 1) {
        break label1156;
      }
      bool = true;
      this.vMV = bool;
      if (!this.vMV) {
        findViewById(2131305648).setVisibility(8);
      }
      com.tencent.mm.kernel.g.agS();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.userName);
      if (com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GWm, 0) != 1) {
        break label1161;
      }
      bool = true;
      this.vNr = bool;
      this.vMR = ((MMSwitchBtn)findViewById(2131302903).findViewById(2131302906));
      getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
      this.vMR.setCheck(((ai)localObject1).aaK());
      this.vMT = ((WeImageView)findViewById(2131305646));
      this.vMU = ((WeImageView)findViewById(2131305036));
      this.vNd = ((TextView)findViewById(2131305647));
      this.vMS = ((MMSwitchBtn)findViewById(2131304942).findViewById(2131302910));
      bool = apG(this.userName);
      this.vMS.setCheck(bool);
      findViewById(2131297422).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(179673);
          SayHiWithSnsPermissionUI2.this.hideVKB();
          AppMethodBeat.o(179673);
        }
      });
      i = ((av)localObject1).exL;
      ac.d("MicroMsg.SayHiWithSnsPermissionUI2", "sex:%d", new Object[] { Integer.valueOf(i) });
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
      bool = ai.aNc(this.userName);
      this.vNs = bool;
      if (!bool) {
        break label1196;
      }
      findViewById(2131305648).setVisibility(8);
      localObject1 = findViewById(2131302905);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (this.vNs) {
        this.vMS.setCheck(true);
      }
      if (this.vNp)
      {
        this.vNl = ((EditText)findViewById(2131304291));
        com.tencent.mm.ui.tools.b.c.d(this.vNl).acw(100).a(null);
        this.vNl.setFilters(j.DFp);
        this.vNl.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(179675);
            if (SayHiWithSnsPermissionUI2.this.vNu[0] != 0)
            {
              SayHiWithSnsPermissionUI2.this.vNu[0] = false;
              com.tencent.mm.plugin.normsg.a.b.vor.aop("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.b.vor.aoq("ie_ver_usr");
            AppMethodBeat.o(179675);
          }
        });
        ((LinearLayout)this.vNl.getParent()).setVisibility(0);
        az.ayM();
        str1 = (String)com.tencent.mm.model.c.agA().get(294913, null);
        localObject2 = u.axy();
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
      if (!bs.isNullOrNil(this.chatroomName))
      {
        ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.chatroomName);
        localObject2 = str1;
        if (localai != null)
        {
          localObject2 = str1;
          if (!bs.isNullOrNil(localai.field_nickname))
          {
            str1 = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xO(this.chatroomName).wk(u.axw());
            localObject2 = str1;
            if (bs.aj(str1)) {
              localObject2 = localObject1;
            }
            ac.i("MicroMsg.SayHiWithSnsPermissionUI2", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localai.field_nickname });
            localObject2 = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), getResources().getString(2131763072, new Object[] { localai.field_nickname, localObject2 }), this.vNl.getTextSize());
            this.vNt = ((CharSequence)localObject2);
          }
        }
      }
      if (bs.aj(this.vNt)) {
        this.vNt = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), String.format(str2, new Object[] { localObject1 }), this.vNl.getTextSize());
      }
      if (bs.aj((CharSequence)localObject2)) {
        this.vNl.setText(this.vNt);
      }
      for (;;)
      {
        this.vNl.clearFocus();
        if (this.vNq)
        {
          this.vNm = ((EditText)findViewById(2131304294));
          ((LinearLayout)this.vNm.getParent()).setVisibility(0);
          if (!this.vNp) {
            this.vNm.clearFocus();
          }
          com.tencent.mm.ui.tools.b.c.d(this.vNm).acw(100).a(null);
          this.vNm.setFilters(j.DFp);
          if (!this.vNp)
          {
            ((TextView)findViewById(2131305902)).setText(2131762056);
            this.iSg[0] = 1;
          }
          if (bs.isNullOrNil(this.bLt)) {
            break label1231;
          }
          this.vNm.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.bLt, this.vNm.getTextSize()));
          this.iSg[6] = 1;
        }
        localObject1 = getString(2131755884);
        if (!this.vNp) {
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
            if (SayHiWithSnsPermissionUI2.this.vNv[0] != 0)
            {
              SayHiWithSnsPermissionUI2.this.vNv[0] = false;
              if (!SayHiWithSnsPermissionUI2.c(SayHiWithSnsPermissionUI2.this)) {
                break label537;
              }
              localObject2 = new LinkedList();
              ((LinkedList)localObject2).add(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this));
              localLinkedList = new LinkedList();
              localLinkedList.add(Integer.valueOf(SayHiWithSnsPermissionUI2.e(SayHiWithSnsPermissionUI2.this)));
              localObject1 = SayHiWithSnsPermissionUI2.f(SayHiWithSnsPermissionUI2.this);
              localHashMap = new HashMap();
              if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() == 0) {
                break label861;
              }
              if (!SayHiWithSnsPermissionUI2.h(SayHiWithSnsPermissionUI2.this).JaE) {
                break label856;
              }
              j = 1;
              label160:
              i = j;
              if (!SayHiWithSnsPermissionUI2.i(SayHiWithSnsPermissionUI2.this).JaE) {}
            }
            label537:
            label681:
            label856:
            label861:
            for (int i = j | 0x2;; i = 0)
            {
              j = i;
              if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() == 0) {
                j = i | 0x8;
              }
              SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this, j);
              localHashMap.put(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), Integer.valueOf(j));
              ac.d("MicroMsg.SayHiWithSnsPermissionUI2", "select sns permission, %s", new Object[] { Integer.valueOf(j) });
              if (SayHiWithSnsPermissionUI2.j(SayHiWithSnsPermissionUI2.this))
              {
                paramAnonymousMenuItem = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra(e.c.HgZ);
                paramAnonymousMenuItem = new com.tencent.mm.openim.b.o(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), (String)localObject1, paramAnonymousMenuItem);
                az.agi().a(paramAnonymousMenuItem, 0);
                localObject1 = SayHiWithSnsPermissionUI2.this;
                localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                SayHiWithSnsPermissionUI2.this.getString(2131755906);
                SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(179677);
                    az.agi().a(paramAnonymousMenuItem);
                    AppMethodBeat.o(179677);
                  }
                }));
              }
              for (;;)
              {
                AppMethodBeat.o(179681);
                return false;
                com.tencent.mm.plugin.normsg.a.b.vor.id("ce_ver_usr", "<VerifyUsr>");
                paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
                com.tencent.mm.plugin.normsg.a.b.vor.a("ce_ver_usr", paramAnonymousMenuItem);
                com.tencent.mm.plugin.normsg.a.b.vor.aou("ce_ver_usr");
                break;
                String str1 = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra("source_from_user_name");
                String str2 = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra("source_from_nick_name");
                paramAnonymousMenuItem = new aa(SayHiWithSnsPermissionUI2.this, null);
                paramAnonymousMenuItem.content = ((String)localObject1);
                paramAnonymousMenuItem.kU(str1, str2);
                paramAnonymousMenuItem.DrS = localHashMap;
                paramAnonymousMenuItem.chatroomName = SayHiWithSnsPermissionUI2.k(SayHiWithSnsPermissionUI2.this);
                paramAnonymousMenuItem.C((List)localObject2, localLinkedList);
                localObject1 = SayHiWithSnsPermissionUI2.this;
                localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                SayHiWithSnsPermissionUI2.this.getString(2131755906);
                SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(179678);
                    paramAnonymousMenuItem.eNM();
                    AppMethodBeat.o(179678);
                  }
                }));
                continue;
                if (SayHiWithSnsPermissionUI2.l(SayHiWithSnsPermissionUI2.this))
                {
                  paramAnonymousMenuItem = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra("Verify_ticket");
                  if (!SayHiWithSnsPermissionUI2.j(SayHiWithSnsPermissionUI2.this)) {
                    break label653;
                  }
                  paramAnonymousMenuItem = new com.tencent.mm.openim.b.q(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), paramAnonymousMenuItem);
                  az.agi().a(paramAnonymousMenuItem, 0);
                  localObject1 = SayHiWithSnsPermissionUI2.this;
                  localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                  SayHiWithSnsPermissionUI2.this.getString(2131755906);
                  SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(179679);
                      az.agi().a(paramAnonymousMenuItem);
                      AppMethodBeat.o(179679);
                    }
                  }));
                }
              }
              if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() != 0) {
                if (SayHiWithSnsPermissionUI2.h(SayHiWithSnsPermissionUI2.this).JaE)
                {
                  j = 1;
                  i = j;
                  if (!SayHiWithSnsPermissionUI2.i(SayHiWithSnsPermissionUI2.this).JaE) {}
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
                  ac.d("MicroMsg.SayHiWithSnsPermissionUI2", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
                  paramAnonymousMenuItem = new com.tencent.mm.pluginsdk.model.o(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), paramAnonymousMenuItem, SayHiWithSnsPermissionUI2.e(SayHiWithSnsPermissionUI2.this), SayHiWithSnsPermissionUI2.k(SayHiWithSnsPermissionUI2.this), i);
                  az.agi().a(paramAnonymousMenuItem, 0);
                  localObject1 = SayHiWithSnsPermissionUI2.this;
                  localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                  SayHiWithSnsPermissionUI2.this.getString(2131755906);
                  SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(179680);
                      az.agi().a(paramAnonymousMenuItem);
                      AppMethodBeat.o(179680);
                    }
                  }));
                  break;
                }
                j = 0;
                break label681;
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
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(179682);
              return false;
              SayHiWithSnsPermissionUI2.this.vNv[0] = true;
              com.tencent.mm.plugin.normsg.a.b.vor.id("ce_ver_usr", "<VerifyUsr>");
              continue;
              com.tencent.mm.plugin.normsg.a.b.vor.a("ce_ver_usr", paramAnonymousMotionEvent);
              com.tencent.mm.plugin.normsg.a.b.vor.aou("ce_ver_usr");
            }
          }
        }, s.b.Hom);
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
        dqE();
        break label517;
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), (CharSequence)localObject2, this.vNl.getTextSize());
        this.vNl.setText((CharSequence)localObject1);
      }
      if (!bs.isNullOrNil(this.bLs))
      {
        this.vNm.setHint(com.tencent.mm.pluginsdk.ui.span.k.b(getContext(), this.bLs, this.vNm.getTextSize()));
        this.vNm.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(179676);
            if (paramAnonymousBoolean)
            {
              if ((!bs.aj(SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).getHint())) && (bs.aj(SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).getText())))
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
      switch (this.iMg)
      {
      case 9: 
      case 12: 
      default: 
        i = 0;
      }
      while ((!this.vNp) && (i == 0))
      {
        localObject1 = com.tencent.mm.bj.d.aJd().aOf(this.userName);
        if (localObject1 == null) {
          break;
        }
        localObject2 = com.tencent.mm.pluginsdk.ui.preference.b.c(this, (bd)localObject1);
        if ((bs.isNullOrNil(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hlf)) || (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hlf.equals(getString(2131759471)))) {
          break;
        }
        str1 = getString(2131763071).substring(0, getString(2131763071).indexOf("%s"));
        localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hlf;
        if (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hlf.startsWith(str1)) {
          localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hlf.substring(str1.length());
        }
        this.vNn.setVisibility(0);
        this.vNo.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, bs.nullAsNil(getString(2131757818, new Object[] { ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).hlf })), this.vNo.getTextSize()));
        localObject2 = new com.tencent.mm.pluginsdk.ui.span.l(getString(2131766242));
        ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).setSpan(new a((String)localObject1), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).length(), 17);
        this.vNo.append(" ");
        this.vNo.append((CharSequence)localObject2);
        this.vNo.setMovementMethod(LinkMovementMethod.getInstance());
        this.iSg[3] = 3;
        break;
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(this.userName);
        if ((localObject1 == null) || (bs.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPm())) || (((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPm().equals(this.vNm.getText().toString())))
        {
          i = 0;
        }
        else
        {
          this.vNn.setVisibility(0);
          this.vNo.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, bs.nullAsNil(getString(2131757816, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPm() })), this.vNo.getTextSize()));
          localObject2 = new com.tencent.mm.pluginsdk.ui.span.l(getString(2131766242));
          ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).setSpan(new a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPm()), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject2).length(), 17);
          this.vNo.append(" ");
          this.vNo.append((CharSequence)localObject2);
          this.vNo.setMovementMethod(LinkMovementMethod.getInstance());
          this.iSg[3] = 1;
          i = 1;
          continue;
          if ((bs.isNullOrNil(this.viO)) || (this.viO.equals(this.vNm.getText().toString())))
          {
            i = 0;
          }
          else
          {
            this.vNn.setVisibility(0);
            this.vNo.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, bs.nullAsNil(getString(2131757815, new Object[] { this.viO })), this.vNo.getTextSize()));
            localObject1 = new com.tencent.mm.pluginsdk.ui.span.l(getString(2131766242));
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).setSpan(new a(this.viO), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).length(), 17);
            this.vNo.append(" ");
            this.vNo.append((CharSequence)localObject1);
            this.vNo.setMovementMethod(LinkMovementMethod.getInstance());
            this.iSg[3] = 2;
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
    AppMethodBeat.o(179690);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(179693);
    com.tencent.mm.plugin.report.service.h.wUl.f(14036, new Object[] { Integer.valueOf(this.iSg[0]), Integer.valueOf(this.iSg[1]), Integer.valueOf(this.iSg[2]), Integer.valueOf(this.iSg[3]), Integer.valueOf(this.iSg[4]), Integer.valueOf(this.iSg[5]), Integer.valueOf(this.iSg[6]), Integer.valueOf(this.iSg[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_ver_usr");
    AppMethodBeat.o(179693);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(179699);
    if (paramInt == 4)
    {
      this.iSg[0] = 1;
      finish();
      oV(false);
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
    az.agi().a(30, this);
    az.agi().a(243, this);
    az.agi().a(853, this);
    AppMethodBeat.o(179691);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(179697);
    long l1 = System.currentTimeMillis();
    ac.i("MicroMsg.SayHiWithSnsPermissionUI2", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    try
    {
      if (this.fts != null)
      {
        this.fts.dismiss();
        this.fts = null;
      }
      if (this.vNp)
      {
        localObject = this.vNl.getText().toString().trim();
        if ((!bs.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.vNt)) && (bs.isNullOrNil(this.chatroomName))) {
          break label1061;
        }
        az.ayM();
        com.tencent.mm.model.c.agA().set(294913, "");
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label1273;
      }
      com.tencent.mm.ui.base.h.cg(this, getString(2131763076));
      au.aB(this.userName, 1);
      paramString = new py();
      paramString.dtc.username = this.userName;
      paramString.dtc.type = 1;
      com.tencent.mm.sdk.b.a.GpY.l(paramString);
      if ((this.iMg == 17) && ((paramn instanceof com.tencent.mm.pluginsdk.model.o)))
      {
        long l2 = getIntent().getLongExtra("key_msg_id", 0L);
        if (l2 > 0L)
        {
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(l2);
          if (paramString.field_msgId > 0L)
          {
            paramString.fbU();
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(l2, paramString);
          }
        }
      }
      if (!this.vNq) {
        break label925;
      }
      paramString = dqH();
      if (bs.isNullOrNil(paramString)) {
        break label1138;
      }
      ac.i("MicroMsg.SayHiWithSnsPermissionUI2", "set temp remark of %s", new Object[] { this.userName });
      az.ayM();
      localObject = com.tencent.mm.model.c.awB().aNt(this.userName);
      ((ai)localObject).qh(paramString);
      az.ayM();
      bz localbz = com.tencent.mm.model.c.awC().alK(this.userName);
      localbz.field_encryptUsername = this.userName;
      localbz.field_conRemark = paramString;
      az.ayM();
      com.tencent.mm.model.c.awC().replace(localbz);
      az.ayM();
      com.tencent.mm.model.c.awB().af((ai)localObject);
      this.iSg[2] = 1;
      if ((!bs.isNullOrNil(this.bLs)) && (!paramString.equals(this.bLs))) {
        this.iSg[5] = 1;
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
        ac.e("MicroMsg.SayHiWithSnsPermissionUI2", "exception in onSceneEnd : " + paramString.getMessage());
        label925:
        label1061:
        return;
        label1029:
        label1138:
        if (bs.isNullOrNil(this.bLs)) {
          break;
        }
        this.iSg[2] = 0;
      }
    }
    finally
    {
      ac.i("MicroMsg.SayHiWithSnsPermissionUI2", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(179697);
    }
    paramString = new LinkedList();
    if ((paramn instanceof com.tencent.mm.pluginsdk.model.o))
    {
      paramInt1 = ((com.tencent.mm.pluginsdk.model.o)paramn).dgL;
      paramString = ((com.tencent.mm.pluginsdk.model.o)paramn).Dhk;
      if ((paramInt1 == 3) || ((paramn instanceof com.tencent.mm.openim.b.q)))
      {
        localObject = com.tencent.mm.bj.d.aJd().aOf(this.userName);
        az.ayM();
        paramn = com.tencent.mm.model.c.awB().aNt(this.userName);
        if ((paramString != null) && (paramString.contains(this.userName)))
        {
          paramString = paramn;
          if ((int)paramn.fLJ != 0) {
            break label1228;
          }
          paramn = com.tencent.mm.pluginsdk.ui.preference.b.a((bd)localObject);
          paramn.setUsername(this.userName);
          az.ayM();
          paramString = paramn;
          if (com.tencent.mm.model.c.awB().ag(paramn)) {
            break label1228;
          }
          ac.e("MicroMsg.SayHiWithSnsPermissionUI2", "canAddContact fail, insert fail");
        }
        az.ayM();
        paramString = com.tencent.mm.model.c.awB().aNt(this.userName);
        paramn = new ub();
        paramn.dwJ.dwL = true;
        paramn.dwJ.dwK = false;
        paramn.dwJ.username = this.userName;
        com.tencent.mm.sdk.b.a.GpY.l(paramn);
        if (!this.vMR.JaE) {
          break label1266;
        }
        w.o(paramString);
        paramString = new ub();
        paramString.dwJ.dwL = false;
        paramString.dwJ.dwK = true;
        paramString.dwJ.username = this.userName;
        bool = apG(this.userName);
        paramString.dwJ.dwM = bool;
        localObject = this.userName;
        if (this.vMS.JaE) {
          break label1497;
        }
        paramInt1 = 2;
        paramn = new LinkedList();
        paramn.add(localObject);
        localObject = new op();
        ((op)localObject).dqX.list = paramn;
        ((op)localObject).dqX.dgm = paramInt1;
        ((op)localObject).dqX.dqY = 5L;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
        com.tencent.mm.sdk.b.a.GpY.l(paramString);
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
      com.tencent.mm.plugin.report.service.h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(getIntent())), Integer.valueOf(1), Integer.valueOf(1), this.userName });
      setResult(-1, getIntent());
      finish();
      oV(true);
      if ((this.vNw & 0x8) == 0) {
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWm, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.SayHiWithSnsPermissionUI2", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(179697);
      return;
      az.ayM();
      com.tencent.mm.model.c.agA().set(294913, localObject);
      break;
      this.iSg[2] = 2;
      break label459;
      if (!(paramn instanceof com.tencent.mm.openim.b.q)) {
        break label1492;
      }
      paramString.add(((com.tencent.mm.openim.b.q)paramn).iod);
      break label1492;
      label1228:
      w.u(paramString);
      az.getNotification().UP();
      com.tencent.mm.bj.d.aJe().fQ(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.co(this.userName, this.iMg);
      break label610;
      label1266:
      w.p(paramString);
      break label689;
      label1273:
      if ((paramInt1 != 4) || (paramInt2 != -24) || (bs.isNullOrNil(paramString))) {
        break label1502;
      }
      Toast.makeText(this, paramString, 1).show();
    }
    for (;;)
    {
      label1303:
      if (!bs.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131755835), null);
        break label1029;
      }
      label1492:
      label1497:
      label1502:
      do
      {
        do
        {
          if ((this.vNp) && ((paramInt2 == -24) || (paramInt2 == -34)))
          {
            Toast.makeText(this, 2131759479, 0).show();
            break label1029;
          }
          if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.vMV))
          {
            this.vMW = true;
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWm, Integer.valueOf(1));
            if (!bs.isNullOrNil(paramString)) {
              this.vNd.setText(paramString);
            }
            dqE();
            paramn = new f.a(this);
            paramn.aRQ(paramString).yi(true).aRV(getString(2131762023)).acQ(2131762024);
            paramn.c(new f.c()
            {
              public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                AppMethodBeat.i(179674);
                SayHiWithSnsPermissionUI2.this.hideVKB();
                if (!paramAnonymousBoolean)
                {
                  paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ab.iC(SayHiWithSnsPermissionUI2.this);
                  Intent localIntent = new Intent();
                  localIntent.putExtra("rawUrl", paramAnonymousString);
                  localIntent.putExtra("showShare", false);
                  localIntent.putExtra("show_bottom", false);
                  com.tencent.mm.br.d.b(SayHiWithSnsPermissionUI2.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
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
    az.agi().b(30, this);
    az.agi().b(243, this);
    az.agi().b(853, this);
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
    public String iAC;
    
    public a(String paramString)
    {
      this.iAC = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(179687);
      SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).setText(com.tencent.mm.pluginsdk.ui.span.k.b(SayHiWithSnsPermissionUI2.this, bs.nullAsNil(this.iAC), SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this).getTextSize()));
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