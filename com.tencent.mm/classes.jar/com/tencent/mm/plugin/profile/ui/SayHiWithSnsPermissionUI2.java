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
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.account.friend.a.au;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.d;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SayHiWithSnsPermissionUI2
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private String Azx;
  private MMSwitchBtn BhO;
  private MMSwitchBtn BhP;
  private WeImageView BhQ;
  private WeImageView BhR;
  private boolean BhS;
  private boolean BhT;
  private boolean BiE;
  private TextView Bia;
  private EditText Bii;
  private EditText Bij;
  private View Bik;
  private TextView Bil;
  private boolean Bim;
  private boolean Bin;
  private boolean Bio;
  private boolean Bip;
  private CharSequence Biq;
  final boolean[] Bir;
  final boolean[] Bis;
  private int Bit;
  private String cgo;
  private String chatroomName;
  private long dUy;
  private ProgressDialog gtM;
  private int kgm;
  private int[] kmr;
  private String nickName;
  private String userName;
  
  public SayHiWithSnsPermissionUI2()
  {
    AppMethodBeat.i(179689);
    this.gtM = null;
    this.kmr = new int[8];
    this.BhS = false;
    this.BhT = false;
    this.Bio = false;
    this.Bip = false;
    this.Biq = null;
    this.Bir = new boolean[] { true };
    this.Bis = new boolean[] { false };
    this.BiE = true;
    this.dUy = System.currentTimeMillis();
    this.Bit = 0;
    AppMethodBeat.o(179689);
  }
  
  private static boolean aKt(String paramString)
  {
    AppMethodBeat.i(179698);
    boolean bool = com.tencent.mm.plugin.sns.b.o.DCP.aKt(paramString);
    AppMethodBeat.o(179698);
    return bool;
  }
  
  private void dmp()
  {
    AppMethodBeat.i(179695);
    Object localObject = this.BhQ;
    if ((this.Bio) || (this.BhT))
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.BhR;
      if ((this.Bio) || (this.BhT)) {
        break label411;
      }
      i = 0;
      label52:
      ((WeImageView)localObject).setVisibility(i);
      if (this.BiE)
      {
        if ((!this.Bio) && (!this.BhT))
        {
          bg.aVF();
          int j = com.tencent.mm.model.c.aSN().c(ab.iCO, new String[] { z.aTY(), "weixin", "helper_entry", "filehelper" });
          i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slR, 200);
          if (j >= i)
          {
            this.BhQ.setVisibility(0);
            this.BhR.setVisibility(4);
            ((TextView)findViewById(2131308892)).setText(getString(2131764062, new Object[] { Integer.valueOf(i) }));
            j = g.aAh().azQ().getInt(ar.a.OnG, 0);
            if (j < ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slS, 3))
            {
              localObject = new f.a(this).bow(getString(2131764063, new Object[] { Integer.valueOf(i) }));
              ((f.a)localObject).JnN = true;
              ((f.a)localObject).apa(2131755873).b(new SayHiWithSnsPermissionUI2.8(this, j)).show();
            }
          }
        }
        this.BiE = false;
      }
      ((View)this.BhQ.getParent()).setOnClickListener(new SayHiWithSnsPermissionUI2.9(this));
      View localView = (View)this.BhR.getParent();
      if (!this.BhT) {
        break label416;
      }
      localObject = null;
      label328:
      localView.setOnClickListener((View.OnClickListener)localObject);
      findViewById(2131305488).setVisibility(8);
      localObject = (TextView)findViewById(2131308188);
      if (!this.BhT) {
        break label428;
      }
    }
    label411:
    label416:
    label428:
    for (int i = getResources().getColor(2131100594);; i = getResources().getColor(2131100904))
    {
      ((TextView)localObject).setTextColor(i);
      if (this.BhT) {
        this.Bia.setVisibility(0);
      }
      this.Bio = false;
      AppMethodBeat.o(179695);
      return;
      i = 4;
      break;
      i = 4;
      break label52;
      localObject = new SayHiWithSnsPermissionUI2.10(this);
      break label328;
    }
  }
  
  private String eEW()
  {
    AppMethodBeat.i(179696);
    String str = "";
    if (this.Bij.getText() != null) {
      str = this.Bij.getText().toString();
    }
    if (!Util.isNullOrNil(str))
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
  
  private void sL(boolean paramBoolean)
  {
    AppMethodBeat.i(179700);
    int k;
    int m;
    label32:
    int j;
    label44:
    int i;
    if (this.Bim)
    {
      k = 1;
      m = 1;
      if (!Util.isNullOrNil(eEW())) {
        break label426;
      }
      m = 3;
      j = 1;
      if (!this.BhT) {
        break label460;
      }
      j = 6;
      switch (this.kgm)
      {
      default: 
        i = 11;
      }
    }
    for (;;)
    {
      bg.aVF();
      int n = com.tencent.mm.model.c.aSN().c(ab.iCO, new String[] { z.aTY(), "weixin", "helper_entry", "filehelper" });
      com.tencent.mm.plugin.report.service.h.CyF.a(18713, new Object[] { this.userName, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - this.dUy), Integer.valueOf(n) });
      AppMethodBeat.o(179700);
      return;
      if (paramBoolean)
      {
        k = 2;
        break;
      }
      k = 3;
      break;
      label426:
      if ((!eEW().equals(this.nickName)) && (!eEW().equals(this.Azx))) {
        break label32;
      }
      m = 2;
      break label32;
      label460:
      if ((this.Bit & 0x8) != 0)
      {
        j = 5;
        break label44;
      }
      if (((this.Bit & 0x1) != 0) && ((this.Bit & 0x2) != 0))
      {
        j = 4;
        break label44;
      }
      if ((this.Bit & 0x2) != 0)
      {
        j = 3;
        break label44;
      }
      if ((this.Bit & 0x1) == 0) {
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
      continue;
      i = 12;
    }
  }
  
  public int getLayoutId()
  {
    return 2131496133;
  }
  
  public void initView()
  {
    AppMethodBeat.i(179694);
    this.Bim = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
    this.Bin = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
    this.userName = getIntent().getStringExtra("Contact_User");
    this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
    this.chatroomName = getIntent().getStringExtra("room_name");
    this.cgo = getIntent().getStringExtra("Contact_RemarkName");
    this.nickName = getIntent().getStringExtra("Contact_Nick");
    this.Azx = getIntent().getStringExtra("Contact_RoomNickname");
    this.Bik = findViewById(2131304818);
    this.Bil = ((TextView)findViewById(2131304819));
    Object localObject1 = ((com.tencent.mm.plugin.zero.b.a)g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ();
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
    if (BuildInfo.DEBUG)
    {
      i = 1;
      if (((f)localObject1).getInt("MMSocialBlackListFlag", i) != 1) {
        break label1166;
      }
      bool = true;
      this.BhS = bool;
      if (!this.BhS) {
        findViewById(2131308893).setVisibility(8);
      }
      g.aAi();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.userName);
      if (g.aAh().azQ().getInt(ar.a.Onw, 0) != 1) {
        break label1171;
      }
      bool = true;
      this.Bio = bool;
      this.BhO = ((MMSwitchBtn)findViewById(2131305486).findViewById(2131305490));
      getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
      this.BhO.setCheck(((as)localObject1).arB());
      this.BhQ = ((WeImageView)findViewById(2131308890));
      this.BhR = ((WeImageView)findViewById(2131308187));
      this.Bia = ((TextView)findViewById(2131308891));
      this.BhP = ((MMSwitchBtn)findViewById(2131308081).findViewById(2131305497));
      bool = aKt(this.userName);
      this.BhP.setCheck(bool);
      findViewById(2131297647).setOnClickListener(new SayHiWithSnsPermissionUI2.1(this));
      i = ((com.tencent.mm.g.c.ax)localObject1).fuA;
      Log.d("MicroMsg.SayHiWithSnsPermissionUI2", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject1 = (TextView)findViewById(2131305491);
      if (i != 1) {
        break label1176;
      }
      ((TextView)localObject1).setText(2131766157);
      localObject1 = (TextView)findViewById(2131305498);
      if (i != 1) {
        break label1191;
      }
      ((TextView)localObject1).setText(2131766008);
      bool = as.bjp(this.userName);
      this.Bip = bool;
      if (!bool) {
        break label1206;
      }
      findViewById(2131308893).setVisibility(8);
      localObject1 = findViewById(2131305488);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (this.Bip) {
        this.BhP.setCheck(true);
      }
      if (this.Bim)
      {
        this.Bii = ((EditText)findViewById(2131307219));
        com.tencent.mm.ui.tools.b.c.f(this.Bii).aoq(100).a(null);
        this.Bii.setFilters(com.tencent.mm.pluginsdk.ui.tools.l.KvQ);
        this.Bii.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(179675);
            if (SayHiWithSnsPermissionUI2.this.Bir[0] != 0)
            {
              SayHiWithSnsPermissionUI2.this.Bir[0] = false;
              com.tencent.mm.plugin.normsg.a.d.AEF.aIL("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.d.AEF.aIM("ie_ver_usr");
            AppMethodBeat.o(179675);
          }
        });
        ((LinearLayout)this.Bii.getParent()).setVisibility(0);
        bg.aVF();
        str1 = (String)com.tencent.mm.model.c.azQ().get(294913, null);
        localObject2 = z.aUa();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        str2 = getString(2131765230);
        if (str2.length() + ((String)localObject1).length() <= 50) {
          break label1923;
        }
        localObject1 = ((String)localObject1).substring(0, 50 - str2.length());
      }
    }
    label1923:
    for (;;)
    {
      localObject2 = str1;
      if (!Util.isNullOrNil(this.chatroomName))
      {
        as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.chatroomName);
        localObject2 = str1;
        if (localas != null)
        {
          localObject2 = str1;
          if (!Util.isNullOrNil(localas.field_nickname))
          {
            str1 = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(this.chatroomName).getDisplayName(z.aTY());
            localObject2 = str1;
            if (Util.isNullOrNil(str1)) {
              localObject2 = localObject1;
            }
            Log.i("MicroMsg.SayHiWithSnsPermissionUI2", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localas.field_nickname });
            localObject2 = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), getResources().getString(2131765231, new Object[] { localas.field_nickname, localObject2 }), this.Bii.getTextSize());
            this.Biq = ((CharSequence)localObject2);
          }
        }
      }
      if (Util.isNullOrNil(this.Biq)) {
        this.Biq = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), String.format(str2, new Object[] { localObject1 }), this.Bii.getTextSize());
      }
      if (Util.isNullOrNil((CharSequence)localObject2)) {
        this.Bii.setText(this.Biq);
      }
      for (;;)
      {
        this.Bii.clearFocus();
        if (this.Bin)
        {
          this.Bij = ((EditText)findViewById(2131307222));
          ((LinearLayout)this.Bij.getParent()).setVisibility(0);
          if (!this.Bim) {
            this.Bij.clearFocus();
          }
          com.tencent.mm.ui.tools.b.c.f(this.Bij).aoq(100).a(null);
          this.Bij.setFilters(com.tencent.mm.pluginsdk.ui.tools.l.KvQ);
          if (!this.Bim)
          {
            ((TextView)findViewById(2131309195)).setText(2131764074);
            this.kmr[0] = 1;
          }
          if (Util.isNullOrNil(this.cgo)) {
            break label1241;
          }
          this.Bij.setText(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), this.cgo, this.Bij.getTextSize()));
          this.kmr[6] = 1;
        }
        localObject1 = getString(2131755976);
        if (!this.Bim) {
          localObject1 = getString(2131755858);
        }
        localObject2 = com.tencent.mm.plugin.normsg.a.c.TN(3);
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
            if (SayHiWithSnsPermissionUI2.this.Bis[0] != 0)
            {
              SayHiWithSnsPermissionUI2.this.Bis[0] = false;
              com.tencent.mm.plugin.normsg.a.d.AEF.eW(this.Biy, 3);
              if (!SayHiWithSnsPermissionUI2.c(SayHiWithSnsPermissionUI2.this)) {
                break label553;
              }
              localObject2 = new LinkedList();
              ((LinkedList)localObject2).add(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this));
              localLinkedList = new LinkedList();
              localLinkedList.add(Integer.valueOf(SayHiWithSnsPermissionUI2.e(SayHiWithSnsPermissionUI2.this)));
              localObject1 = SayHiWithSnsPermissionUI2.f(SayHiWithSnsPermissionUI2.this);
              localHashMap = new HashMap();
              if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() == 0) {
                break label880;
              }
              if (!SayHiWithSnsPermissionUI2.h(SayHiWithSnsPermissionUI2.this).QDw) {
                break label875;
              }
              j = 1;
              label171:
              i = j;
              if (!SayHiWithSnsPermissionUI2.i(SayHiWithSnsPermissionUI2.this).QDw) {}
            }
            label553:
            label604:
            label875:
            label880:
            for (int i = j | 0x2;; i = 0)
            {
              j = i;
              if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() == 0) {
                j = i | 0x8;
              }
              SayHiWithSnsPermissionUI2.a(SayHiWithSnsPermissionUI2.this, j);
              localHashMap.put(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), Integer.valueOf(j));
              Log.d("MicroMsg.SayHiWithSnsPermissionUI2", "select sns permission, %s", new Object[] { Integer.valueOf(j) });
              if (SayHiWithSnsPermissionUI2.j(SayHiWithSnsPermissionUI2.this))
              {
                paramAnonymousMenuItem = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra(e.d.OyT);
                paramAnonymousMenuItem = new com.tencent.mm.openim.b.o(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), (String)localObject1, paramAnonymousMenuItem, j);
                bg.azz().a(paramAnonymousMenuItem, 0);
                localObject1 = SayHiWithSnsPermissionUI2.this;
                localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                SayHiWithSnsPermissionUI2.this.getString(2131755998);
                SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131765237), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(179677);
                    bg.azz().a(paramAnonymousMenuItem);
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
                  com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_ver_usr", "<VerifyUsr>", this.Biy);
                  paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
                  com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_ver_usr", paramAnonymousMenuItem);
                  com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_ver_usr");
                  break;
                  String str1 = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra("source_from_user_name");
                  String str2 = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra("source_from_nick_name");
                  paramAnonymousMenuItem = new aa(SayHiWithSnsPermissionUI2.this, null);
                  paramAnonymousMenuItem.content = ((String)localObject1);
                  paramAnonymousMenuItem.mw(str1, str2);
                  paramAnonymousMenuItem.Kgh = localHashMap;
                  paramAnonymousMenuItem.chatroomName = SayHiWithSnsPermissionUI2.k(SayHiWithSnsPermissionUI2.this);
                  paramAnonymousMenuItem.z((List)localObject2, localLinkedList);
                  localObject1 = SayHiWithSnsPermissionUI2.this;
                  localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                  SayHiWithSnsPermissionUI2.this.getString(2131755998);
                  SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131765237), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(179678);
                      paramAnonymousMenuItem.gpI();
                      AppMethodBeat.o(179678);
                    }
                  }));
                }
              } while (!SayHiWithSnsPermissionUI2.l(SayHiWithSnsPermissionUI2.this));
              paramAnonymousMenuItem = SayHiWithSnsPermissionUI2.this.getIntent().getStringExtra("Verify_ticket");
              if (SayHiWithSnsPermissionUI2.g(SayHiWithSnsPermissionUI2.this).getVisibility() != 0) {
                if (SayHiWithSnsPermissionUI2.h(SayHiWithSnsPermissionUI2.this).QDw)
                {
                  j = 1;
                  i = j;
                  if (!SayHiWithSnsPermissionUI2.i(SayHiWithSnsPermissionUI2.this).QDw) {}
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
                  Log.d("MicroMsg.SayHiWithSnsPermissionUI2", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
                  if (SayHiWithSnsPermissionUI2.j(SayHiWithSnsPermissionUI2.this))
                  {
                    paramAnonymousMenuItem = new com.tencent.mm.openim.b.q(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), paramAnonymousMenuItem, i);
                    bg.azz().a(paramAnonymousMenuItem, 0);
                    localObject1 = SayHiWithSnsPermissionUI2.this;
                    localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                    SayHiWithSnsPermissionUI2.this.getString(2131755998);
                    SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131757868), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                      {
                        AppMethodBeat.i(179679);
                        bg.azz().a(paramAnonymousMenuItem);
                        AppMethodBeat.o(179679);
                      }
                    }));
                    break;
                  }
                  paramAnonymousMenuItem = new p(SayHiWithSnsPermissionUI2.d(SayHiWithSnsPermissionUI2.this), paramAnonymousMenuItem, SayHiWithSnsPermissionUI2.e(SayHiWithSnsPermissionUI2.this), SayHiWithSnsPermissionUI2.k(SayHiWithSnsPermissionUI2.this), i);
                  bg.azz().a(paramAnonymousMenuItem, 0);
                  localObject1 = SayHiWithSnsPermissionUI2.this;
                  localObject2 = SayHiWithSnsPermissionUI2.this.getContext();
                  SayHiWithSnsPermissionUI2.this.getString(2131755998);
                  SayHiWithSnsPermissionUI2.a((SayHiWithSnsPermissionUI2)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI2.this.getString(2131757868), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(179680);
                      bg.azz().a(paramAnonymousMenuItem);
                      AppMethodBeat.o(179680);
                    }
                  }));
                  break;
                }
                j = 0;
                break label604;
              }
              j = 0;
              break label171;
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
              SayHiWithSnsPermissionUI2.this.Bis[0] = true;
              com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_ver_usr", "<VerifyUsr>", this.Biy);
              continue;
              com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_ver_usr", paramAnonymousMotionEvent);
              com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_ver_usr");
            }
          }
        }, t.b.OGU);
        setBackBtn(new SayHiWithSnsPermissionUI2.7(this));
        AppMethodBeat.o(179694);
        return;
        i = 0;
        break;
        label1166:
        bool = false;
        break label184;
        label1171:
        bool = false;
        break label255;
        label1176:
        if (i != 2) {
          break label447;
        }
        ((TextView)localObject1).setText(2131766156);
        break label447;
        label1191:
        if (i != 2) {
          break label470;
        }
        ((TextView)localObject1).setText(2131766007);
        break label470;
        label1206:
        dmp();
        break label517;
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), (CharSequence)localObject2, this.Bii.getTextSize());
        this.Bii.setText((CharSequence)localObject1);
      }
      label1241:
      if (!Util.isNullOrNil(this.nickName))
      {
        this.Bij.setHint(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), this.nickName, this.Bij.getTextSize()));
        this.Bij.setOnFocusChangeListener(new SayHiWithSnsPermissionUI2.4(this));
      }
      switch (this.kgm)
      {
      case 9: 
      case 12: 
      default: 
        i = 0;
      }
      while ((!this.Bim) && (i == 0))
      {
        localObject1 = com.tencent.mm.bj.d.bgM().bkv(this.userName);
        if (localObject1 == null) {
          break;
        }
        localObject2 = com.tencent.mm.pluginsdk.ui.preference.b.c(this, (bn)localObject1);
        if ((Util.isNullOrNil(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).iAq)) || (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).iAq.equals(getString(2131760786)))) {
          break;
        }
        str1 = getString(2131765230).substring(0, getString(2131765230).indexOf("%s"));
        localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).iAq;
        if (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).iAq.startsWith(str1)) {
          localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).iAq.substring(str1.length());
        }
        this.Bik.setVisibility(0);
        this.Bil.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(getString(2131758058, new Object[] { ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).iAq })), this.Bil.getTextSize()));
        localObject2 = new m(getString(2131768753));
        ((m)localObject2).setSpan(new SayHiWithSnsPermissionUI2.a(this, (String)localObject1), 0, ((m)localObject2).length(), 17);
        this.Bil.append(" ");
        this.Bil.append((CharSequence)localObject2);
        this.Bil.setMovementMethod(LinkMovementMethod.getInstance());
        this.kmr[3] = 3;
        break;
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.userName);
        if ((localObject1 == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK())) || (((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK().equals(this.Bij.getText().toString())))
        {
          i = 0;
        }
        else
        {
          this.Bik.setVisibility(0);
          this.Bil.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(getString(2131758056, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK() })), this.Bil.getTextSize()));
          localObject2 = new m(getString(2131768753));
          ((m)localObject2).setSpan(new SayHiWithSnsPermissionUI2.a(this, ((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK()), 0, ((m)localObject2).length(), 17);
          this.Bil.append(" ");
          this.Bil.append((CharSequence)localObject2);
          this.Bil.setMovementMethod(LinkMovementMethod.getInstance());
          this.kmr[3] = 1;
          i = 1;
          continue;
          if ((Util.isNullOrNil(this.Azx)) || (this.Azx.equals(this.Bij.getText().toString())))
          {
            i = 0;
          }
          else
          {
            this.Bik.setVisibility(0);
            this.Bil.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, Util.nullAsNil(getString(2131758055, new Object[] { this.Azx })), this.Bil.getTextSize()));
            localObject1 = new m(getString(2131768753));
            ((m)localObject1).setSpan(new SayHiWithSnsPermissionUI2.a(this, this.Azx), 0, ((m)localObject1).length(), 17);
            this.Bil.append(" ");
            this.Bil.append((CharSequence)localObject1);
            this.Bil.setMovementMethod(LinkMovementMethod.getInstance());
            this.kmr[3] = 2;
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
    setActionbarColor(getContext().getResources().getColor(2131101424));
    hideActionbarLine();
    setMMTitle("");
    initView();
    bg.azz().a(30, this);
    bg.azz().a(243, this);
    bg.azz().a(853, this);
    AppMethodBeat.o(179690);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(179693);
    bg.azz().b(30, this);
    bg.azz().b(243, this);
    bg.azz().b(853, this);
    com.tencent.mm.plugin.report.service.h.CyF.a(14036, new Object[] { Integer.valueOf(this.kmr[0]), Integer.valueOf(this.kmr[1]), Integer.valueOf(this.kmr[2]), Integer.valueOf(this.kmr[3]), Integer.valueOf(this.kmr[4]), Integer.valueOf(this.kmr[5]), Integer.valueOf(this.kmr[6]), Integer.valueOf(this.kmr[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_ver_usr");
    AppMethodBeat.o(179693);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(179699);
    if (paramInt == 4)
    {
      this.kmr[0] = 1;
      finish();
      sL(false);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(179697);
    long l1 = System.currentTimeMillis();
    Log.i("MicroMsg.SayHiWithSnsPermissionUI2", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    try
    {
      if (this.gtM != null)
      {
        this.gtM.dismiss();
        this.gtM = null;
      }
      if (this.Bim)
      {
        localObject = this.Bii.getText().toString().trim();
        if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.Biq)) && (Util.isNullOrNil(this.chatroomName))) {
          break label1061;
        }
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(294913, "");
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label1273;
      }
      com.tencent.mm.ui.base.h.cD(this, getString(2131765236));
      au.aI(this.userName, 1);
      paramString = new re();
      paramString.dXU.username = this.userName;
      paramString.dXU.type = 1;
      EventCenter.instance.publish(paramString);
      if ((this.kgm == 17) && ((paramq instanceof p)))
      {
        long l2 = getIntent().getLongExtra("key_msg_id", 0L);
        if (l2 > 0L)
        {
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(l2);
          if (paramString.field_msgId > 0L)
          {
            paramString.gDF();
            ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(l2, paramString);
          }
        }
      }
      if (!this.Bin) {
        break label925;
      }
      paramString = eEW();
      if (Util.isNullOrNil(paramString)) {
        break label1138;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI2", "set temp remark of %s", new Object[] { this.userName });
      bg.aVF();
      localObject = com.tencent.mm.model.c.aSN().Kn(this.userName);
      ((as)localObject).BD(paramString);
      bg.aVF();
      cn localcn = com.tencent.mm.model.c.aSO().aEZ(this.userName);
      localcn.field_encryptUsername = this.userName;
      localcn.field_conRemark = paramString;
      bg.aVF();
      com.tencent.mm.model.c.aSO().replace(localcn);
      bg.aVF();
      com.tencent.mm.model.c.aSN().ao((as)localObject);
      this.kmr[2] = 1;
      if ((!Util.isNullOrNil(this.nickName)) && (!paramString.equals(this.nickName))) {
        this.kmr[5] = 1;
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
        Log.e("MicroMsg.SayHiWithSnsPermissionUI2", "exception in onSceneEnd : " + paramString.getMessage());
        label925:
        label1061:
        return;
        label1029:
        label1138:
        if (Util.isNullOrNil(this.nickName)) {
          break;
        }
        this.kmr[2] = 0;
      }
    }
    finally
    {
      Log.i("MicroMsg.SayHiWithSnsPermissionUI2", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(179697);
    }
    paramString = new LinkedList();
    if ((paramq instanceof p))
    {
      paramInt1 = ((p)paramq).dKy;
      paramString = ((p)paramq).JVj;
      if ((paramInt1 == 3) || ((paramq instanceof com.tencent.mm.openim.b.q)))
      {
        localObject = com.tencent.mm.bj.d.bgM().bkv(this.userName);
        bg.aVF();
        paramq = com.tencent.mm.model.c.aSN().Kn(this.userName);
        if ((paramString != null) && (paramString.contains(this.userName)))
        {
          paramString = paramq;
          if ((int)paramq.gMZ != 0) {
            break label1228;
          }
          paramq = com.tencent.mm.pluginsdk.ui.preference.b.a((bn)localObject);
          paramq.setUsername(this.userName);
          bg.aVF();
          paramString = paramq;
          if (com.tencent.mm.model.c.aSN().ap(paramq)) {
            break label1228;
          }
          Log.e("MicroMsg.SayHiWithSnsPermissionUI2", "canAddContact fail, insert fail");
        }
        bg.aVF();
        paramString = com.tencent.mm.model.c.aSN().Kn(this.userName);
        paramq = new vx();
        paramq.ebX.ebZ = true;
        paramq.ebX.ebY = false;
        paramq.ebX.username = this.userName;
        EventCenter.instance.publish(paramq);
        if (!this.BhO.QDw) {
          break label1266;
        }
        ab.v(paramString);
        paramString = new vx();
        paramString.ebX.ebZ = false;
        paramString.ebX.ebY = true;
        paramString.ebX.username = this.userName;
        bool = aKt(this.userName);
        paramString.ebX.eca = bool;
        localObject = this.userName;
        if (this.BhP.QDw) {
          break label1497;
        }
        paramInt1 = 2;
        paramq = new LinkedList();
        paramq.add(localObject);
        localObject = new pr();
        ((pr)localObject).dVH.list = paramq;
        ((pr)localObject).dVH.dJY = paramInt1;
        ((pr)localObject).dVH.dVI = 5L;
        EventCenter.instance.publish((IEvent)localObject);
        EventCenter.instance.publish(paramString);
        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false))
        {
          paramString = new Intent();
          paramString.putExtra("friend_message_transfer_username", this.userName);
          paramString.setAction("friend_message_accept_" + this.userName);
          paramString.putExtra("MMActivity.OverrideEnterAnimation", 2130772169);
          paramString.putExtra("MMActivity.OverrideExitAnimation", 2130772166);
          com.tencent.mm.br.c.b(this, "subapp", ".ui.friend.FMessageTransferUI", paramString);
        }
      }
      getIntent().putExtra("CONTACT_INFO_UI_SOURCE", 7);
      com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(getIntent())), Integer.valueOf(1), Integer.valueOf(1), this.userName });
      setResult(-1, getIntent());
      finish();
      sL(true);
      if ((this.Bit & 0x8) == 0) {
        g.aAh().azQ().set(ar.a.Onw, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SayHiWithSnsPermissionUI2", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(179697);
      return;
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(294913, localObject);
      break;
      this.kmr[2] = 2;
      break label459;
      if (!(paramq instanceof com.tencent.mm.openim.b.q)) {
        break label1492;
      }
      paramString.add(((com.tencent.mm.openim.b.q)paramq).jGZ);
      break label1492;
      label1228:
      ab.B(paramString);
      bg.getNotification().alb();
      com.tencent.mm.bj.d.bgN().gP(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.cC(this.userName, this.kgm);
      break label610;
      label1266:
      ab.w(paramString);
      break label689;
      label1273:
      if ((paramInt1 != 4) || (paramInt2 != -24) || (Util.isNullOrNil(paramString))) {
        break label1502;
      }
      Toast.makeText(this, paramString, 1).show();
    }
    for (;;)
    {
      label1303:
      if (!Util.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131755921), null);
        break label1029;
      }
      label1492:
      label1497:
      label1502:
      do
      {
        do
        {
          if ((this.Bim) && ((paramInt2 == -24) || (paramInt2 == -34)))
          {
            Toast.makeText(this, 2131760794, 0).show();
            break label1029;
          }
          if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.BhS))
          {
            this.BhT = true;
            g.aAh().azQ().set(ar.a.Onw, Integer.valueOf(1));
            if (!Util.isNullOrNil(paramString)) {
              this.Bia.setText(paramString);
            }
            dmp();
            paramq = new f.a(this);
            paramq.bow(paramString).Dq(true).boB(getString(2131764037)).apa(2131764038);
            paramq.c(new SayHiWithSnsPermissionUI2.2(this)).show();
            break label1029;
          }
          Toast.makeText(this, 2131765235, 0).show();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2
 * JD-Core Version:    0.7.0.1
 */