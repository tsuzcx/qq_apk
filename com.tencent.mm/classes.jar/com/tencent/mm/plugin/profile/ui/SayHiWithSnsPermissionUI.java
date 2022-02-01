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
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
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

public class SayHiWithSnsPermissionUI
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
  int Biu;
  int Biv;
  private String cgo;
  private String chatroomName;
  private long dUy;
  private ProgressDialog gtM;
  private int kgm;
  private int[] kmr;
  private String nickName;
  int scene;
  private String userName;
  
  public SayHiWithSnsPermissionUI()
  {
    AppMethodBeat.i(27407);
    this.gtM = null;
    this.kmr = new int[8];
    this.BhS = false;
    this.BhT = false;
    this.Bio = false;
    this.Bip = false;
    this.Biq = null;
    this.Bir = new boolean[] { true };
    this.Bis = new boolean[] { false };
    this.dUy = System.currentTimeMillis();
    this.Bit = 0;
    this.Biu = 1;
    this.Biv = 1;
    this.scene = 11;
    AppMethodBeat.o(27407);
  }
  
  private static boolean aKt(String paramString)
  {
    AppMethodBeat.i(27416);
    boolean bool = com.tencent.mm.plugin.sns.b.o.DCP.aKt(paramString);
    AppMethodBeat.o(27416);
    return bool;
  }
  
  private void dmp()
  {
    int j = 8;
    int k = 4;
    AppMethodBeat.i(27413);
    Object localObject = this.BhQ;
    if ((this.Bio) || (this.BhT))
    {
      i = 0;
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.BhR;
      i = k;
      if (!this.Bio)
      {
        i = k;
        if (!this.BhT) {
          i = 0;
        }
      }
      ((WeImageView)localObject).setVisibility(i);
      ((View)this.BhQ.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27402);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).setVisibility(0);
          SayHiWithSnsPermissionUI.o(SayHiWithSnsPermissionUI.this).setVisibility(4);
          SayHiWithSnsPermissionUI.this.findViewById(2131305488).setVisibility(8);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27402);
        }
      });
      View localView = (View)this.BhR.getParent();
      if (!this.BhT) {
        break label235;
      }
      localObject = null;
      label114:
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = findViewById(2131305488);
      if ((!this.BhS) || ((!this.Bio) && (!this.BhT))) {
        break label248;
      }
      i = 8;
      label153:
      ((View)localObject).setVisibility(i);
      localObject = (TextView)findViewById(2131308188);
      if (!this.BhT) {
        break label253;
      }
    }
    label235:
    label248:
    label253:
    for (int i = getResources().getColor(2131100594);; i = getResources().getColor(2131100904))
    {
      ((TextView)localObject).setTextColor(i);
      localObject = findViewById(2131308891);
      i = j;
      if (this.BhT) {
        i = 0;
      }
      ((View)localObject).setVisibility(i);
      this.Bio = false;
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
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).setVisibility(4);
          SayHiWithSnsPermissionUI.o(SayHiWithSnsPermissionUI.this).setVisibility(0);
          SayHiWithSnsPermissionUI.this.findViewById(2131305488).setVisibility(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27403);
        }
      };
      break label114;
      i = 0;
      break label153;
    }
  }
  
  private String eEW()
  {
    AppMethodBeat.i(27414);
    String str2 = "";
    String str1 = str2;
    if (this.Bij != null)
    {
      str1 = str2;
      if (this.Bij.getText() != null) {
        str1 = this.Bij.getText().toString();
      }
    }
    if (!Util.isNullOrNil(str1))
    {
      if (str1.length() <= 50)
      {
        AppMethodBeat.o(27414);
        return str1;
      }
      str1 = str1.substring(0, 50);
      AppMethodBeat.o(27414);
      return str1;
    }
    AppMethodBeat.o(27414);
    return str1;
  }
  
  private void sL(boolean paramBoolean)
  {
    AppMethodBeat.i(27418);
    final int i;
    if (this.Bim)
    {
      i = 1;
      if (!Util.isNullOrNil(eEW())) {
        break label317;
      }
      this.Biu = 3;
      label30:
      if (!this.BhT) {
        break label353;
      }
      this.Biv = 6;
      label43:
      switch (this.kgm)
      {
      default: 
        this.scene = 11;
      }
    }
    for (;;)
    {
      com.tencent.f.h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231899);
          bg.aVF();
          int i = com.tencent.mm.model.c.aSN().c(ab.iCO, new String[] { z.aTY(), "weixin", "helper_entry", "filehelper" });
          com.tencent.mm.plugin.report.service.h.CyF.a(18713, new Object[] { SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), Integer.valueOf(i), Integer.valueOf(SayHiWithSnsPermissionUI.this.Biu), Integer.valueOf(SayHiWithSnsPermissionUI.this.Biv), Integer.valueOf(SayHiWithSnsPermissionUI.this.scene), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - SayHiWithSnsPermissionUI.q(SayHiWithSnsPermissionUI.this)), Integer.valueOf(i) });
          AppMethodBeat.o(231899);
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
      label317:
      if ((!eEW().equals(this.nickName)) && (!eEW().equals(this.Azx))) {
        break label30;
      }
      this.Biu = 2;
      break label30;
      label353:
      if ((this.Bit & 0x8) != 0)
      {
        this.Biv = 5;
        break label43;
      }
      if (((this.Bit & 0x1) != 0) && ((this.Bit & 0x2) != 0))
      {
        this.Biv = 4;
        break label43;
      }
      if ((this.Bit & 0x2) != 0)
      {
        this.Biv = 3;
        break label43;
      }
      if ((this.Bit & 0x1) == 0) {
        break label43;
      }
      this.Biv = 2;
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
      continue;
      this.scene = 12;
    }
  }
  
  public int getLayoutId()
  {
    return 2131496132;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27412);
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
    Object localObject2;
    label433:
    label456:
    String str1;
    label534:
    String str2;
    if (BuildInfo.DEBUG)
    {
      i = 1;
      if (((f)localObject1).getInt("MMSocialBlackListFlag", i) != 1) {
        break label1167;
      }
      bool = true;
      this.BhS = bool;
      if (!this.BhS) {
        findViewById(2131308893).setVisibility(8);
      }
      g.aAi();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.userName);
      if (g.aAh().azQ().getInt(ar.a.Onw, 0) != 1) {
        break label1172;
      }
      bool = true;
      this.Bio = bool;
      this.BhO = ((MMSwitchBtn)findViewById(2131305486).findViewById(2131305490));
      getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
      this.BhO.setCheck(((as)localObject1).arB());
      this.BhQ = ((WeImageView)findViewById(2131308890));
      this.BhR = ((WeImageView)findViewById(2131308187));
      this.BhP = ((MMSwitchBtn)findViewById(2131308081).findViewById(2131305497));
      bool = aKt(this.userName);
      this.BhP.setCheck(bool);
      findViewById(2131297647).setOnClickListener(new SayHiWithSnsPermissionUI.1(this));
      i = ((com.tencent.mm.g.c.ax)localObject1).fuA;
      Log.d("MicroMsg.SayHiWithSnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject1 = (TextView)findViewById(2131305491);
      if (i != 1) {
        break label1177;
      }
      ((TextView)localObject1).setText(2131766157);
      localObject1 = (TextView)findViewById(2131305498);
      if (i != 1) {
        break label1192;
      }
      ((TextView)localObject1).setText(2131766008);
      bool = as.bjp(this.userName);
      this.Bip = bool;
      if (!bool) {
        break label1222;
      }
      findViewById(2131308893).setVisibility(8);
      localObject2 = findViewById(2131305486);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      ((TextView)findViewById(2131305489)).setText(2131764076);
      if (i != 1) {
        break label1207;
      }
      ((TextView)localObject1).setText(2131764050);
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
            AppMethodBeat.i(27393);
            if (SayHiWithSnsPermissionUI.this.Bir[0] != 0)
            {
              SayHiWithSnsPermissionUI.this.Bir[0] = false;
              com.tencent.mm.plugin.normsg.a.d.AEF.aIL("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.d.AEF.aIM("ie_ver_usr");
            AppMethodBeat.o(27393);
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
          break label1955;
        }
        localObject1 = ((String)localObject1).substring(0, 50 - str2.length());
      }
    }
    label1167:
    label1172:
    label1177:
    label1955:
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
            Log.i("MicroMsg.SayHiWithSnsPermissionUI", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localas.field_nickname });
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
            break label1271;
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
            AppMethodBeat.i(27399);
            if ((SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this) != null) && (SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this).isShowing()))
            {
              AppMethodBeat.o(27399);
              return false;
            }
            Object localObject2;
            Object localObject1;
            if (SayHiWithSnsPermissionUI.this.Bis[0] != 0)
            {
              SayHiWithSnsPermissionUI.this.Bis[0] = false;
              com.tencent.mm.plugin.normsg.a.d.AEF.eW(this.Biy, 3);
              if (!SayHiWithSnsPermissionUI.c(SayHiWithSnsPermissionUI.this)) {
                break label589;
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
                if (SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this).QDw) {
                  j = 1;
                }
                i = j;
                if (SayHiWithSnsPermissionUI.i(SayHiWithSnsPermissionUI.this).QDw) {
                  i = j | 0x2;
                }
              }
              j = i;
              if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() == 0) {
                j = i | 0x8;
              }
              SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this, j);
              localHashMap.put(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), Integer.valueOf(j));
              Log.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[] { Integer.valueOf(j) });
              if (!SayHiWithSnsPermissionUI.j(SayHiWithSnsPermissionUI.this)) {
                break label451;
              }
              paramAnonymousMenuItem = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra(e.d.OyT);
              paramAnonymousMenuItem = new com.tencent.mm.openim.b.o(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), (String)localObject1, paramAnonymousMenuItem, j);
              bg.azz().a(paramAnonymousMenuItem, 0);
              localObject1 = SayHiWithSnsPermissionUI.this;
              localObject2 = SayHiWithSnsPermissionUI.this.getContext();
              SayHiWithSnsPermissionUI.this.getString(2131755998);
              SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131765237), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(27395);
                  bg.azz().a(paramAnonymousMenuItem);
                  AppMethodBeat.o(27395);
                }
              }));
            }
            label451:
            label589:
            while (!SayHiWithSnsPermissionUI.l(SayHiWithSnsPermissionUI.this)) {
              for (;;)
              {
                LinkedList localLinkedList;
                HashMap localHashMap;
                long l = SayHiWithSnsPermissionUI.this.getIntent().getLongExtra("key_msg_id", 0L);
                if (com.tencent.mm.plugin.messenger.e.a.Hh(l)) {
                  com.tencent.mm.plugin.messenger.e.a.Q(l, 4);
                }
                AppMethodBeat.o(27399);
                return false;
                com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_ver_usr", "<VerifyUsr>", this.Biy);
                paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
                com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_ver_usr", paramAnonymousMenuItem);
                com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_ver_usr");
                break;
                String str1 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_user_name");
                String str2 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_nick_name");
                paramAnonymousMenuItem = new aa(SayHiWithSnsPermissionUI.this, null);
                paramAnonymousMenuItem.content = ((String)localObject1);
                paramAnonymousMenuItem.mw(str1, str2);
                paramAnonymousMenuItem.Kgh = localHashMap;
                paramAnonymousMenuItem.chatroomName = SayHiWithSnsPermissionUI.k(SayHiWithSnsPermissionUI.this);
                paramAnonymousMenuItem.z((List)localObject2, localLinkedList);
                localObject1 = SayHiWithSnsPermissionUI.this;
                localObject2 = SayHiWithSnsPermissionUI.this.getContext();
                SayHiWithSnsPermissionUI.this.getString(2131755998);
                SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131765237), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(27396);
                    paramAnonymousMenuItem.gpI();
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
              if (SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this).QDw) {
                j = 1;
              }
              i = j;
              if (SayHiWithSnsPermissionUI.i(SayHiWithSnsPermissionUI.this).QDw) {
                i = j | 0x2;
              }
            }
            if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() == 0) {
              i |= 0x8;
            }
            for (;;)
            {
              SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this, i);
              Log.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
              if (SayHiWithSnsPermissionUI.j(SayHiWithSnsPermissionUI.this))
              {
                paramAnonymousMenuItem = new com.tencent.mm.openim.b.q(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), paramAnonymousMenuItem, i);
                bg.azz().a(paramAnonymousMenuItem, 0);
                localObject1 = SayHiWithSnsPermissionUI.this;
                localObject2 = SayHiWithSnsPermissionUI.this.getContext();
                SayHiWithSnsPermissionUI.this.getString(2131755998);
                SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131757868), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(27397);
                    bg.azz().a(paramAnonymousMenuItem);
                    AppMethodBeat.o(27397);
                  }
                }));
                break;
              }
              paramAnonymousMenuItem = new p(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), paramAnonymousMenuItem, SayHiWithSnsPermissionUI.e(SayHiWithSnsPermissionUI.this), SayHiWithSnsPermissionUI.k(SayHiWithSnsPermissionUI.this), i);
              bg.azz().a(paramAnonymousMenuItem, 0);
              localObject1 = SayHiWithSnsPermissionUI.this;
              localObject2 = SayHiWithSnsPermissionUI.this.getContext();
              SayHiWithSnsPermissionUI.this.getString(2131755998);
              SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(2131757868), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(27398);
                  bg.azz().a(paramAnonymousMenuItem);
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
              SayHiWithSnsPermissionUI.this.Bis[0] = true;
              com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_ver_usr", "<VerifyUsr>", this.Biy);
              continue;
              com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_ver_usr", paramAnonymousMotionEvent);
              com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_ver_usr");
            }
          }
        }, t.b.OGU);
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
        if (i != 2) {
          break label433;
        }
        ((TextView)localObject1).setText(2131766156);
        break label433;
        label1192:
        if (i != 2) {
          break label456;
        }
        ((TextView)localObject1).setText(2131766007);
        break label456;
        label1207:
        if (i != 2) {
          break label534;
        }
        ((TextView)localObject1).setText(2131764048);
        break label534;
        label1222:
        localObject1 = t.Urt;
        t.hT(findViewById(2131305489));
        dmp();
        break label534;
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), (CharSequence)localObject2, this.Bii.getTextSize());
        this.Bii.setText((CharSequence)localObject1);
      }
      label1271:
      if (!Util.isNullOrNil(this.nickName))
      {
        this.Bij.setHint(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), this.nickName, this.Bij.getTextSize()));
        this.Bij.setOnFocusChangeListener(new SayHiWithSnsPermissionUI.4(this));
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
        ((m)localObject2).setSpan(new SayHiWithSnsPermissionUI.a(this, (String)localObject1), 0, ((m)localObject2).length(), 17);
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
          ((m)localObject2).setSpan(new SayHiWithSnsPermissionUI.a(this, ((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK()), 0, ((m)localObject2).length(), 17);
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
            ((m)localObject1).setSpan(new SayHiWithSnsPermissionUI.a(this, this.Azx), 0, ((m)localObject1).length(), 17);
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
    AppMethodBeat.i(27408);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131101424));
    hideActionbarLine();
    setMMTitle("");
    initView();
    bg.azz().a(30, this);
    bg.azz().a(243, this);
    bg.azz().a(853, this);
    AppMethodBeat.o(27408);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27411);
    bg.azz().b(30, this);
    bg.azz().b(243, this);
    bg.azz().b(853, this);
    com.tencent.mm.plugin.report.service.h.CyF.a(14036, new Object[] { Integer.valueOf(this.kmr[0]), Integer.valueOf(this.kmr[1]), Integer.valueOf(this.kmr[2]), Integer.valueOf(this.kmr[3]), Integer.valueOf(this.kmr[4]), Integer.valueOf(this.kmr[5]), Integer.valueOf(this.kmr[6]), Integer.valueOf(this.kmr[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_ver_usr");
    AppMethodBeat.o(27411);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27417);
    if (paramInt == 4)
    {
      this.kmr[0] = 1;
      finish();
      sL(false);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(27415);
    long l1 = System.currentTimeMillis();
    Log.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    try
    {
      if (this.gtM != null)
      {
        this.gtM.dismiss();
        this.gtM = null;
      }
      if ((this.Bip) && (this.BhP.QDw) && (!aKt(this.userName)))
      {
        bg.aVF();
        localObject2 = com.tencent.mm.model.c.aSN().Kn(this.userName);
        localObject1 = new LinkedList();
        ((LinkedList)localObject1).add(((com.tencent.mm.g.c.ax)localObject2).field_username);
        localObject2 = new pr();
        ((pr)localObject2).dVH.list = ((List)localObject1);
        ((pr)localObject2).dVH.dJY = 1;
        ((pr)localObject2).dVH.dVI = 5L;
        ((pr)localObject2).dVH.dLQ = true;
        EventCenter.instance.publish((IEvent)localObject2);
      }
      if (this.Bim)
      {
        localObject1 = this.Bii.getText().toString().trim();
        if ((!Util.isNullOrNil((String)localObject1)) && (!((String)localObject1).equals(this.Biq)) && (Util.isNullOrNil(this.chatroomName))) {
          break label1182;
        }
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(294913, "");
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label1394;
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
        break label1046;
      }
      paramString = eEW();
      if (Util.isNullOrNil(paramString)) {
        break label1259;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI", "set temp remark of %s", new Object[] { this.userName });
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aSN().Kn(this.userName);
      ((as)localObject1).BD(paramString);
      bg.aVF();
      Object localObject2 = com.tencent.mm.model.c.aSO().aEZ(this.userName);
      ((cn)localObject2).field_encryptUsername = this.userName;
      ((cn)localObject2).field_conRemark = paramString;
      bg.aVF();
      com.tencent.mm.model.c.aSO().replace((IAutoDBItem)localObject2);
      bg.aVF();
      com.tencent.mm.model.c.aSN().ao((as)localObject1);
      this.kmr[2] = 1;
      if ((!Util.isNullOrNil(this.nickName)) && (!paramString.equals(this.nickName))) {
        this.kmr[5] = 1;
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
        Log.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + paramString.getMessage());
        label1046:
        label1182:
        return;
        label1259:
        if (Util.isNullOrNil(this.nickName)) {
          break;
        }
        this.kmr[2] = 0;
      }
    }
    finally
    {
      Log.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(27415);
    }
    paramString = new LinkedList();
    if ((paramq instanceof p))
    {
      paramInt1 = ((p)paramq).dKy;
      paramString = ((p)paramq).JVj;
      if ((paramInt1 == 3) || ((paramq instanceof com.tencent.mm.openim.b.q)))
      {
        localObject1 = com.tencent.mm.bj.d.bgM().bkv(this.userName);
        bg.aVF();
        paramq = com.tencent.mm.model.c.aSN().Kn(this.userName);
        if ((paramString != null) && (paramString.contains(this.userName)))
        {
          paramString = paramq;
          if ((int)paramq.gMZ != 0) {
            break label1349;
          }
          paramq = com.tencent.mm.pluginsdk.ui.preference.b.a((bn)localObject1);
          paramq.setUsername(this.userName);
          bg.aVF();
          paramString = paramq;
          if (com.tencent.mm.model.c.aSN().ap(paramq)) {
            break label1349;
          }
          Log.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
        }
        bg.aVF();
        paramString = com.tencent.mm.model.c.aSN().Kn(this.userName);
        paramq = new vx();
        paramq.ebX.ebZ = true;
        paramq.ebX.ebY = false;
        paramq.ebX.username = this.userName;
        EventCenter.instance.publish(paramq);
        if (!this.BhO.QDw) {
          break label1387;
        }
        ab.v(paramString);
        paramString = new vx();
        paramString.ebX.ebZ = false;
        paramString.ebX.ebY = true;
        paramString.ebX.username = this.userName;
        bool = aKt(this.userName);
        paramString.ebX.eca = bool;
        localObject1 = this.userName;
        if (this.BhP.QDw) {
          break label1622;
        }
        paramInt1 = 2;
        paramq = new LinkedList();
        paramq.add(localObject1);
        localObject1 = new pr();
        ((pr)localObject1).dVH.list = paramq;
        ((pr)localObject1).dVH.dJY = paramInt1;
        ((pr)localObject1).dVH.dVI = 5L;
        EventCenter.instance.publish((IEvent)localObject1);
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
      Log.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(27415);
      return;
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(294913, localObject1);
      break;
      this.kmr[2] = 2;
      break label580;
      if (!(paramq instanceof com.tencent.mm.openim.b.q)) {
        break label1617;
      }
      paramString.add(((com.tencent.mm.openim.b.q)paramq).jGZ);
      break label1617;
      label1349:
      ab.B(paramString);
      bg.getNotification().alb();
      com.tencent.mm.bj.d.bgN().gP(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.cC(this.userName, this.kgm);
      break label731;
      label1387:
      ab.w(paramString);
      break label810;
      label1394:
      if ((paramInt1 != 4) || (paramInt2 != -24) || (Util.isNullOrNil(paramString))) {
        break label1627;
      }
      Toast.makeText(this, paramString, 1).show();
    }
    for (;;)
    {
      label1424:
      if (!Util.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131755921), null);
        break label1150;
      }
      label1617:
      label1622:
      label1627:
      do
      {
        do
        {
          if ((this.Bim) && ((paramInt2 == -24) || (paramInt2 == -34)))
          {
            Toast.makeText(this, 2131760794, 0).show();
            break label1150;
          }
          if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.BhS))
          {
            this.BhT = true;
            g.aAh().azQ().set(ar.a.Onw, Integer.valueOf(1));
            if (!Util.isNullOrNil(paramString)) {
              ((TextView)findViewById(2131308891)).setText(paramString);
            }
            dmp();
            paramq = new f.a(this);
            paramq.bow(paramString).Dq(true).boB(getString(2131764037)).apa(2131764038);
            paramq.c(new SayHiWithSnsPermissionUI.10(this)).show();
            break label1150;
          }
          Toast.makeText(this, 2131765235, 0).show();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI
 * JD-Core Version:    0.7.0.1
 */