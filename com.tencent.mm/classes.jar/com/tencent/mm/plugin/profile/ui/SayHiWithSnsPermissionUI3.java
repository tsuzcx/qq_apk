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
import android.view.ViewGroup;
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
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SayHiWithSnsPermissionUI3
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
  private int xkK;
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
  
  public SayHiWithSnsPermissionUI3()
  {
    AppMethodBeat.i(186558);
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
    this.xkK = 0;
    AppMethodBeat.o(186558);
  }
  
  private static <T extends View> ArrayList<T> a(ViewGroup paramViewGroup, Class<T> paramClass)
  {
    AppMethodBeat.i(186564);
    ArrayList localArrayList = new ArrayList();
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if ((localView instanceof ViewGroup)) {
        localArrayList.addAll(a((ViewGroup)localView, paramClass));
      }
      if (paramClass.isInstance(localView)) {
        localArrayList.add(paramClass.cast(localView));
      }
      i += 1;
    }
    AppMethodBeat.o(186564);
    return localArrayList;
  }
  
  private static boolean awb(String paramString)
  {
    AppMethodBeat.i(186567);
    boolean bool = com.tencent.mm.plugin.sns.b.o.zsy.awb(paramString);
    AppMethodBeat.o(186567);
    return bool;
  }
  
  private String dEB()
  {
    AppMethodBeat.i(186565);
    String str = "";
    if (this.xkm.getText() != null) {
      str = this.xkm.getText().toString();
    }
    if (!bu.isNullOrNil(str))
    {
      if (str.length() <= 50)
      {
        AppMethodBeat.o(186565);
        return str;
      }
      str = str.substring(0, 50);
      AppMethodBeat.o(186565);
      return str;
    }
    AppMethodBeat.o(186565);
    return str;
  }
  
  private void pC(boolean paramBoolean)
  {
    AppMethodBeat.i(186569);
    int k;
    int m;
    if (this.xkp)
    {
      k = 1;
      if (!bu.isNullOrNil(dEB())) {
        break label428;
      }
      m = 3;
    }
    for (;;)
    {
      label29:
      int j;
      if (this.xjW) {
        j = 6;
      }
      for (;;)
      {
        label39:
        int i;
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
        for (;;)
        {
          bc.aCg();
          int n = com.tencent.mm.model.c.azF().c(x.hIe, new String[] { v.aAC(), "weixin", "helper_entry", "filehelper" });
          com.tencent.mm.plugin.report.service.g.yxI.f(18713, new Object[] { this.userName, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - this.dCI), Integer.valueOf(n), Integer.valueOf(this.xkK) });
          AppMethodBeat.o(186569);
          return;
          if (paramBoolean)
          {
            k = 2;
            break;
          }
          k = 3;
          break;
          label428:
          if ((!dEB().equals(this.bVF)) && (!dEB().equals(this.wDQ))) {
            break label588;
          }
          m = 2;
          break label29;
          if ((this.xkw & 0x8) != 0)
          {
            j = 5;
            break label39;
          }
          if (((this.xkw & 0x1) != 0) && ((this.xkw & 0x2) != 0))
          {
            j = 4;
            break label39;
          }
          if ((this.xkw & 0x2) != 0)
          {
            j = 3;
            break label39;
          }
          if ((this.xkw & 0x1) == 0) {
            break label583;
          }
          j = 2;
          break label39;
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
        label583:
        j = 0;
      }
      label588:
      m = 1;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495284;
  }
  
  public void initView()
  {
    AppMethodBeat.i(186563);
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
          AppMethodBeat.i(186541);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          SayHiWithSnsPermissionUI3.this.hideVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(186541);
        }
      });
      i = ((aw)localObject1).eQV;
      ae.d("MicroMsg.SayHiWithSnsPermissionUI3", "sex:%d", new Object[] { Integer.valueOf(i) });
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
            AppMethodBeat.i(186546);
            if (SayHiWithSnsPermissionUI3.this.xku[0] != 0)
            {
              SayHiWithSnsPermissionUI3.this.xku[0] = false;
              com.tencent.mm.plugin.normsg.a.b.wJt.auC("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.b.wJt.auD("ie_ver_usr");
            AppMethodBeat.o(186546);
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
          break label1971;
        }
        localObject1 = ((String)localObject1).substring(0, 50 - str2.length());
      }
    }
    label1155:
    label1160:
    label1165:
    label1180:
    label1195:
    label1971:
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
            ae.i("MicroMsg.SayHiWithSnsPermissionUI3", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localan.field_nickname });
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
            break label1286;
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
            AppMethodBeat.i(186552);
            if ((SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this) != null) && (SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).isShowing()))
            {
              AppMethodBeat.o(186552);
              return false;
            }
            if (SayHiWithSnsPermissionUI3.this.xkv[0] != 0) {
              SayHiWithSnsPermissionUI3.this.xkv[0] = false;
            }
            while ((SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() != 0) && (SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).getVisibility() != 0))
            {
              t.co(SayHiWithSnsPermissionUI3.this, "请先设置朋友权限");
              SayHiWithSnsPermissionUI3.f(SayHiWithSnsPermissionUI3.this);
              AppMethodBeat.o(186552);
              return false;
              com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_ver_usr", "<VerifyUsr>");
              paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_ver_usr", paramAnonymousMenuItem);
              com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_ver_usr");
            }
            Object localObject2;
            LinkedList localLinkedList;
            Object localObject1;
            HashMap localHashMap;
            int j;
            if (SayHiWithSnsPermissionUI3.g(SayHiWithSnsPermissionUI3.this))
            {
              localObject2 = new LinkedList();
              ((LinkedList)localObject2).add(SayHiWithSnsPermissionUI3.h(SayHiWithSnsPermissionUI3.this));
              localLinkedList = new LinkedList();
              localLinkedList.add(Integer.valueOf(SayHiWithSnsPermissionUI3.i(SayHiWithSnsPermissionUI3.this)));
              localObject1 = SayHiWithSnsPermissionUI3.j(SayHiWithSnsPermissionUI3.this);
              localHashMap = new HashMap();
              if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() == 0) {
                break label916;
              }
              if (!SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this).Lon) {
                break label911;
              }
              j = 1;
              i = j;
              if (!SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this).Lon) {}
            }
            label640:
            label911:
            label916:
            for (int i = j | 0x2;; i = 0)
            {
              j = i;
              if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() == 0) {
                j = i | 0x8;
              }
              SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, j);
              localHashMap.put(SayHiWithSnsPermissionUI3.h(SayHiWithSnsPermissionUI3.this), Integer.valueOf(j));
              ae.d("MicroMsg.SayHiWithSnsPermissionUI3", "select sns permission, %s", new Object[] { Integer.valueOf(j) });
              if (SayHiWithSnsPermissionUI3.m(SayHiWithSnsPermissionUI3.this))
              {
                paramAnonymousMenuItem = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra(e.c.JoX);
                paramAnonymousMenuItem = new com.tencent.mm.openim.b.o(SayHiWithSnsPermissionUI3.h(SayHiWithSnsPermissionUI3.this), (String)localObject1, paramAnonymousMenuItem, j);
                bc.ajj().a(paramAnonymousMenuItem, 0);
                localObject1 = SayHiWithSnsPermissionUI3.this;
                localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
                SayHiWithSnsPermissionUI3.this.getString(2131755906);
                SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, h.b((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(186548);
                    bc.ajj().a(paramAnonymousMenuItem);
                    AppMethodBeat.o(186548);
                  }
                }));
              }
              do
              {
                for (;;)
                {
                  AppMethodBeat.o(186552);
                  return false;
                  String str1 = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_user_name");
                  String str2 = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_nick_name");
                  paramAnonymousMenuItem = new aa(SayHiWithSnsPermissionUI3.this, null);
                  paramAnonymousMenuItem.content = ((String)localObject1);
                  paramAnonymousMenuItem.ly(str1, str2);
                  paramAnonymousMenuItem.Fpq = localHashMap;
                  paramAnonymousMenuItem.chatroomName = SayHiWithSnsPermissionUI3.n(SayHiWithSnsPermissionUI3.this);
                  paramAnonymousMenuItem.D((List)localObject2, localLinkedList);
                  localObject1 = SayHiWithSnsPermissionUI3.this;
                  localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
                  SayHiWithSnsPermissionUI3.this.getString(2131755906);
                  SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, h.b((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(2131763077), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(186549);
                      paramAnonymousMenuItem.fgz();
                      AppMethodBeat.o(186549);
                    }
                  }));
                }
              } while (!SayHiWithSnsPermissionUI3.o(SayHiWithSnsPermissionUI3.this));
              paramAnonymousMenuItem = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("Verify_ticket");
              if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() != 0) {
                if (SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this).Lon)
                {
                  j = 1;
                  i = j;
                  if (!SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this).Lon) {}
                }
              }
              for (i = j | 0x2;; i = 0)
              {
                if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() == 0) {
                  i |= 0x8;
                }
                for (;;)
                {
                  SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, i);
                  ae.d("MicroMsg.SayHiWithSnsPermissionUI3", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
                  if (SayHiWithSnsPermissionUI3.m(SayHiWithSnsPermissionUI3.this))
                  {
                    paramAnonymousMenuItem = new com.tencent.mm.openim.b.q(SayHiWithSnsPermissionUI3.h(SayHiWithSnsPermissionUI3.this), paramAnonymousMenuItem, i);
                    bc.ajj().a(paramAnonymousMenuItem, 0);
                    localObject1 = SayHiWithSnsPermissionUI3.this;
                    localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
                    SayHiWithSnsPermissionUI3.this.getString(2131755906);
                    SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, h.b((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                      {
                        AppMethodBeat.i(186550);
                        bc.ajj().a(paramAnonymousMenuItem);
                        AppMethodBeat.o(186550);
                      }
                    }));
                    break;
                  }
                  paramAnonymousMenuItem = new com.tencent.mm.pluginsdk.model.o(SayHiWithSnsPermissionUI3.h(SayHiWithSnsPermissionUI3.this), paramAnonymousMenuItem, SayHiWithSnsPermissionUI3.i(SayHiWithSnsPermissionUI3.this), SayHiWithSnsPermissionUI3.n(SayHiWithSnsPermissionUI3.this), i);
                  bc.ajj().a(paramAnonymousMenuItem, 0);
                  localObject1 = SayHiWithSnsPermissionUI3.this;
                  localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
                  SayHiWithSnsPermissionUI3.this.getString(2131755906);
                  SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, h.b((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(2131757640), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(186551);
                      bc.ajj().a(paramAnonymousMenuItem);
                      AppMethodBeat.o(186551);
                    }
                  }));
                  break;
                }
                j = 0;
                break label640;
              }
              j = 0;
              break;
            }
          }
        }, null, new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(186553);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(186553);
              return false;
              SayHiWithSnsPermissionUI3.this.xkv[0] = true;
              com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_ver_usr", "<VerifyUsr>");
              continue;
              com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_ver_usr", paramAnonymousMotionEvent);
              com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_ver_usr");
            }
          }
        }, s.b.JwF);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(186554);
            if (SayHiWithSnsPermissionUI3.o(SayHiWithSnsPermissionUI3.this)) {
              SayHiWithSnsPermissionUI3.p(SayHiWithSnsPermissionUI3.this)[1] = 1;
            }
            SayHiWithSnsPermissionUI3.this.finish();
            SayHiWithSnsPermissionUI3.q(SayHiWithSnsPermissionUI3.this);
            AppMethodBeat.o(186554);
            return true;
          }
        });
        AppMethodBeat.o(186563);
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
        ((View)this.xjT.getParent()).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186544);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() != 0)
            {
              SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).setVisibility(0);
              SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).setVisibility(4);
              SayHiWithSnsPermissionUI3.this.updateOptionMenuStyle(0, s.b.JwA);
              SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(186544);
          }
        });
        localObject2 = (View)this.xjU.getParent();
        if (this.xjW) {}
        for (localObject1 = null;; localObject1 = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(186545);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if (SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).getVisibility() != 0)
                {
                  SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).setVisibility(4);
                  SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).setVisibility(0);
                  SayHiWithSnsPermissionUI3.this.updateOptionMenuStyle(0, s.b.JwA);
                  SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(186545);
              }
            })
        {
          ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
          break;
        }
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
            AppMethodBeat.i(186547);
            if (paramAnonymousBoolean)
            {
              if ((!bu.ah(SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).getHint())) && (bu.ah(SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).getText())))
              {
                SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).setText(SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).getHint());
                SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).setHint(null);
              }
              SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).setSelection(SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).getText().length());
            }
            AppMethodBeat.o(186547);
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
    AppMethodBeat.i(186559);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle("");
    initView();
    bc.ajj().a(30, this);
    bc.ajj().a(243, this);
    bc.ajj().a(853, this);
    AppMethodBeat.o(186559);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(186562);
    bc.ajj().b(30, this);
    bc.ajj().b(243, this);
    bc.ajj().b(853, this);
    com.tencent.mm.plugin.report.service.g.yxI.f(14036, new Object[] { Integer.valueOf(this.joi[0]), Integer.valueOf(this.joi[1]), Integer.valueOf(this.joi[2]), Integer.valueOf(this.joi[3]), Integer.valueOf(this.joi[4]), Integer.valueOf(this.joi[5]), Integer.valueOf(this.joi[6]), Integer.valueOf(this.joi[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_ver_usr");
    AppMethodBeat.o(186562);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(186568);
    if (paramInt == 4)
    {
      this.joi[0] = 1;
      finish();
      pC(false);
      AppMethodBeat.o(186568);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(186568);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(186560);
    super.onResume();
    AppMethodBeat.o(186560);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(186566);
    long l1 = System.currentTimeMillis();
    ae.i("MicroMsg.SayHiWithSnsPermissionUI3", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    Object localObject;
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
      ae.i("MicroMsg.SayHiWithSnsPermissionUI3", "set temp remark of %s", new Object[] { this.userName });
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
        label458:
        label609:
        boolean bool;
        label688:
        label759:
        ae.e("MicroMsg.SayHiWithSnsPermissionUI3", "exception in onSceneEnd : " + paramString.getMessage());
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
      ae.i("MicroMsg.SayHiWithSnsPermissionUI3", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(186566);
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
          ae.e("MicroMsg.SayHiWithSnsPermissionUI3", "canAddContact fail, insert fail");
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
          break label1691;
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
      ae.i("MicroMsg.SayHiWithSnsPermissionUI3", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(186566);
      return;
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(294913, localObject);
      break;
      this.joi[2] = 2;
      break label458;
      if (!(paramn instanceof com.tencent.mm.openim.b.q)) {
        break label1686;
      }
      paramString.add(((com.tencent.mm.openim.b.q)paramn).iKt);
      break label1686;
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
        break label1696;
      }
      Toast.makeText(this, paramString, 1).show();
      continue;
      label1302:
      if (!bu.isNullOrNil(paramString))
      {
        h.a(this, paramString, "", getString(2131755835), null);
      }
      else
      {
        label1328:
        if ((!this.xkp) || ((paramInt2 != -24) && (paramInt2 != -34))) {
          break label1361;
        }
        Toast.makeText(this, 2131759479, 0).show();
      }
    }
    label1361:
    if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.xjV))
    {
      this.xjW = true;
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JdQ, Integer.valueOf(1));
      if (!bu.isNullOrNil(paramString)) {
        this.xkd.setText(paramString);
      }
      paramn = this.xjT;
      if (this.xkr) {
        break label1716;
      }
      if (!this.xjW) {
        break label1721;
      }
      break label1716;
      paramn.setVisibility(paramInt1);
      paramn = this.xjU;
      if ((this.xkr) || (this.xjW)) {
        break label1726;
      }
    }
    label1439:
    label1696:
    label1716:
    label1721:
    label1726:
    for (paramInt1 = 0;; paramInt1 = 4)
    {
      paramn.setVisibility(paramInt1);
      ((View)this.xjT.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(186555);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() != 0)
          {
            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).setVisibility(0);
            SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).setVisibility(4);
            SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(186555);
        }
      });
      localObject = (View)this.xjU.getParent();
      if (this.xjW)
      {
        paramn = null;
        label1516:
        ((View)localObject).setOnClickListener(paramn);
        findViewById(2131302905).setVisibility(8);
        paramn = (TextView)findViewById(2131305037);
        if (!this.xjW) {
          break label1659;
        }
      }
      label1659:
      for (paramInt1 = getResources().getColor(2131100490);; paramInt1 = getResources().getColor(2131100711))
      {
        paramn.setTextColor(paramInt1);
        if (this.xjW) {
          this.xkd.setVisibility(0);
        }
        this.xkr = false;
        paramn = new f.a(this);
        paramn.aZq(paramString).zi(true).aZv(getString(2131762023)).afY(2131762024);
        paramn.c(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(186543);
            SayHiWithSnsPermissionUI3.this.hideVKB();
            if (!paramAnonymousBoolean)
            {
              paramAnonymousString = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + ad.iR(SayHiWithSnsPermissionUI3.this);
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", paramAnonymousString);
              localIntent.putExtra("showShare", false);
              localIntent.putExtra("show_bottom", false);
              com.tencent.mm.br.d.b(SayHiWithSnsPermissionUI3.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            }
            AppMethodBeat.o(186543);
          }
        }).show();
        break;
        paramn = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186542);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).getVisibility() != 0)
            {
              SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).setVisibility(4);
              SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).setVisibility(0);
              SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(186542);
          }
        };
        break label1516;
      }
      Toast.makeText(this, 2131763075, 0).show();
      break label1028;
      paramInt1 = 0;
      break;
      paramInt1 = 1;
      break label759;
      if (paramInt1 != 4) {
        break label1328;
      }
      if (paramInt2 == -2) {
        break label1302;
      }
      if (paramInt2 != -101) {
        break label1328;
      }
      break label1302;
      paramInt1 = 0;
      break label1439;
      paramInt1 = 4;
      break label1439;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(186561);
    super.onStop();
    AppMethodBeat.o(186561);
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
      AppMethodBeat.i(186556);
      SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).setText(k.b(SayHiWithSnsPermissionUI3.this, bu.nullAsNil(this.iWF), SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).getTextSize()));
      SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).setSelection(SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).getText().length());
      SayHiWithSnsPermissionUI3.r(SayHiWithSnsPermissionUI3.this).setVisibility(8);
      SayHiWithSnsPermissionUI3.p(SayHiWithSnsPermissionUI3.this)[4] = 1;
      AppMethodBeat.o(186556);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(186557);
      paramTextPaint.setColor(SayHiWithSnsPermissionUI3.this.getResources().getColor(2131100027));
      paramTextPaint.setUnderlineText(false);
      AppMethodBeat.o(186557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3
 * JD-Core Version:    0.7.0.1
 */