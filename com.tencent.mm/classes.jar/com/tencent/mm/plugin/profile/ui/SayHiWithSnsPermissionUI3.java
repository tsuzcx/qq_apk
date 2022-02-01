package com.tencent.mm.plugin.profile.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
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
import android.view.ViewGroup;
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
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
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
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SayHiWithSnsPermissionUI3
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
  private int BiI;
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
  
  public SayHiWithSnsPermissionUI3()
  {
    AppMethodBeat.i(231918);
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
    this.BiI = 0;
    AppMethodBeat.o(231918);
  }
  
  private static <T extends View> ArrayList<T> a(ViewGroup paramViewGroup, Class<T> paramClass)
  {
    AppMethodBeat.i(231925);
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
    AppMethodBeat.o(231925);
    return localArrayList;
  }
  
  private void a(final Object paramObject, int paramInt1, int paramInt2, int paramInt3, final Runnable paramRunnable)
  {
    AppMethodBeat.i(258243);
    ValueAnimator localValueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(258239);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        if ((paramObject instanceof TextView))
        {
          ((TextView)paramObject).setTextColor(i);
          AppMethodBeat.o(258239);
          return;
        }
        if ((paramObject instanceof GradientDrawable)) {
          ((GradientDrawable)paramObject).setColor(i);
        }
        AppMethodBeat.o(258239);
      }
    });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(258240);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        AppMethodBeat.o(258240);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.start();
    AppMethodBeat.o(258243);
  }
  
  private static boolean aKt(String paramString)
  {
    AppMethodBeat.i(231928);
    boolean bool = com.tencent.mm.plugin.sns.b.o.DCP.aKt(paramString);
    AppMethodBeat.o(231928);
    return bool;
  }
  
  private String eEW()
  {
    AppMethodBeat.i(231926);
    String str = "";
    if (this.Bij.getText() != null) {
      str = this.Bij.getText().toString();
    }
    if (!Util.isNullOrNil(str))
    {
      if (str.length() <= 50)
      {
        AppMethodBeat.o(231926);
        return str;
      }
      str = str.substring(0, 50);
      AppMethodBeat.o(231926);
      return str;
    }
    AppMethodBeat.o(231926);
    return str;
  }
  
  private void eEX()
  {
    AppMethodBeat.i(231924);
    Object localObject2;
    if (this.BhQ.getVisibility() == 0)
    {
      localObject2 = this.BhQ.getParent();
      localObject1 = this.BhR.getParent();
    }
    for (;;)
    {
      ((View)localObject2).setBackgroundResource(2131231932);
      ((View)localObject1).setBackgroundResource(2131231933);
      localObject2 = a((ViewGroup)localObject2, TextView.class).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((TextView)((Iterator)localObject2).next()).setTextColor(getResources().getColor(2131099710));
      }
      localObject1 = this.BhQ.getParent();
      localObject2 = this.BhR.getParent();
    }
    Object localObject1 = a((ViewGroup)localObject1, TextView.class);
    ((TextView)((List)localObject1).get(0)).setTextColor(getResources().getColor(2131100904));
    ((TextView)((List)localObject1).get(1)).setTextColor(getResources().getColor(2131100594));
    AppMethodBeat.o(231924);
  }
  
  private void sL(final boolean paramBoolean)
  {
    AppMethodBeat.i(231930);
    com.tencent.f.h.RTc.aY(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(258242);
        int k;
        int m;
        if (SayHiWithSnsPermissionUI3.h(SayHiWithSnsPermissionUI3.this))
        {
          k = 1;
          if (!Util.isNullOrNil(SayHiWithSnsPermissionUI3.u(SayHiWithSnsPermissionUI3.this))) {
            break label449;
          }
          m = 3;
        }
        for (;;)
        {
          label33:
          int j;
          if (SayHiWithSnsPermissionUI3.w(SayHiWithSnsPermissionUI3.this)) {
            j = 6;
          }
          for (;;)
          {
            label46:
            int i;
            switch (SayHiWithSnsPermissionUI3.j(SayHiWithSnsPermissionUI3.this))
            {
            default: 
              i = 11;
            }
            for (;;)
            {
              bg.aVF();
              int n = com.tencent.mm.model.c.aSN().c(ab.iCO, new String[] { z.aTY(), "weixin", "helper_entry", "filehelper" });
              com.tencent.mm.plugin.report.service.h.CyF.a(18713, new Object[] { SayHiWithSnsPermissionUI3.i(SayHiWithSnsPermissionUI3.this), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - SayHiWithSnsPermissionUI3.y(SayHiWithSnsPermissionUI3.this)), Integer.valueOf(n), Integer.valueOf(SayHiWithSnsPermissionUI3.z(SayHiWithSnsPermissionUI3.this)) });
              AppMethodBeat.o(258242);
              return;
              if (paramBoolean)
              {
                k = 2;
                break;
              }
              k = 3;
              break;
              label449:
              if ((!SayHiWithSnsPermissionUI3.u(SayHiWithSnsPermissionUI3.this).equals(SayHiWithSnsPermissionUI3.t(SayHiWithSnsPermissionUI3.this))) && (!SayHiWithSnsPermissionUI3.u(SayHiWithSnsPermissionUI3.this).equals(SayHiWithSnsPermissionUI3.v(SayHiWithSnsPermissionUI3.this)))) {
                break label642;
              }
              m = 2;
              break label33;
              if ((SayHiWithSnsPermissionUI3.x(SayHiWithSnsPermissionUI3.this) & 0x8) != 0)
              {
                j = 5;
                break label46;
              }
              if (((SayHiWithSnsPermissionUI3.x(SayHiWithSnsPermissionUI3.this) & 0x1) != 0) && ((SayHiWithSnsPermissionUI3.x(SayHiWithSnsPermissionUI3.this) & 0x2) != 0))
              {
                j = 4;
                break label46;
              }
              if ((SayHiWithSnsPermissionUI3.x(SayHiWithSnsPermissionUI3.this) & 0x2) != 0)
              {
                j = 3;
                break label46;
              }
              if ((SayHiWithSnsPermissionUI3.x(SayHiWithSnsPermissionUI3.this) & 0x1) == 0) {
                break label637;
              }
              j = 2;
              break label46;
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
            label637:
            j = 0;
          }
          label642:
          m = 1;
        }
      }
    });
    AppMethodBeat.o(231930);
  }
  
  public int getLayoutId()
  {
    return 2131496134;
  }
  
  public void initView()
  {
    AppMethodBeat.i(231923);
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
    String str2;
    if (BuildInfo.DEBUG)
    {
      i = 1;
      if (((f)localObject1).getInt("MMSocialBlackListFlag", i) != 1) {
        break label1165;
      }
      bool = true;
      this.BhS = bool;
      if (!this.BhS) {
        findViewById(2131308893).setVisibility(8);
      }
      g.aAi();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.userName);
      if (g.aAh().azQ().getInt(ar.a.Onw, 0) != 1) {
        break label1170;
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
      findViewById(2131297647).setOnClickListener(new SayHiWithSnsPermissionUI3.1(this));
      i = ((com.tencent.mm.g.c.ax)localObject1).fuA;
      Log.d("MicroMsg.SayHiWithSnsPermissionUI3", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject1 = (TextView)findViewById(2131305491);
      if (i != 1) {
        break label1175;
      }
      ((TextView)localObject1).setText(2131766157);
      localObject1 = (TextView)findViewById(2131305498);
      if (i != 1) {
        break label1190;
      }
      ((TextView)localObject1).setText(2131766008);
      bool = as.bjp(this.userName);
      this.Bip = bool;
      if (!bool) {
        break label1205;
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
            AppMethodBeat.i(231906);
            if (SayHiWithSnsPermissionUI3.this.Bir[0] != 0)
            {
              SayHiWithSnsPermissionUI3.this.Bir[0] = false;
              com.tencent.mm.plugin.normsg.a.d.AEF.aIL("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.d.AEF.aIM("ie_ver_usr");
            AppMethodBeat.o(231906);
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
          break label1979;
        }
        localObject1 = ((String)localObject1).substring(0, 50 - str2.length());
      }
    }
    label1165:
    label1170:
    label1175:
    label1190:
    label1205:
    label1979:
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
            Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localas.field_nickname });
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
            break label1296;
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
            AppMethodBeat.i(231912);
            if ((SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this) != null) && (SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).isShowing()))
            {
              AppMethodBeat.o(231912);
              return false;
            }
            if (SayHiWithSnsPermissionUI3.this.Bis[0] != 0) {
              SayHiWithSnsPermissionUI3.this.Bis[0] = false;
            }
            while ((SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() != 0) && (SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).getVisibility() != 0))
            {
              SayHiWithSnsPermissionUI3.f(SayHiWithSnsPermissionUI3.this);
              SayHiWithSnsPermissionUI3.g(SayHiWithSnsPermissionUI3.this);
              AppMethodBeat.o(231912);
              return false;
              com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_ver_usr", "<VerifyUsr>", this.Biy);
              paramAnonymousMenuItem = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_ver_usr", paramAnonymousMenuItem);
              com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.d.AEF.eW(this.Biy, 3);
            Object localObject2;
            LinkedList localLinkedList;
            Object localObject1;
            HashMap localHashMap;
            int j;
            if (SayHiWithSnsPermissionUI3.h(SayHiWithSnsPermissionUI3.this))
            {
              localObject2 = new LinkedList();
              ((LinkedList)localObject2).add(SayHiWithSnsPermissionUI3.i(SayHiWithSnsPermissionUI3.this));
              localLinkedList = new LinkedList();
              localLinkedList.add(Integer.valueOf(SayHiWithSnsPermissionUI3.j(SayHiWithSnsPermissionUI3.this)));
              localObject1 = SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this);
              localHashMap = new HashMap();
              if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() == 0) {
                break label929;
              }
              if (!SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this).QDw) {
                break label924;
              }
              j = 1;
              i = j;
              if (!SayHiWithSnsPermissionUI3.m(SayHiWithSnsPermissionUI3.this).QDw) {}
            }
            label653:
            label924:
            label929:
            for (int i = j | 0x2;; i = 0)
            {
              j = i;
              if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() == 0) {
                j = i | 0x8;
              }
              SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, j);
              localHashMap.put(SayHiWithSnsPermissionUI3.i(SayHiWithSnsPermissionUI3.this), Integer.valueOf(j));
              Log.d("MicroMsg.SayHiWithSnsPermissionUI3", "select sns permission, %s", new Object[] { Integer.valueOf(j) });
              if (SayHiWithSnsPermissionUI3.n(SayHiWithSnsPermissionUI3.this))
              {
                paramAnonymousMenuItem = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra(e.d.OyT);
                paramAnonymousMenuItem = new com.tencent.mm.openim.b.o(SayHiWithSnsPermissionUI3.i(SayHiWithSnsPermissionUI3.this), (String)localObject1, paramAnonymousMenuItem, j);
                bg.azz().a(paramAnonymousMenuItem, 0);
                localObject1 = SayHiWithSnsPermissionUI3.this;
                localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
                SayHiWithSnsPermissionUI3.this.getString(2131755998);
                SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(2131765237), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(231908);
                    bg.azz().a(paramAnonymousMenuItem);
                    AppMethodBeat.o(231908);
                  }
                }));
              }
              do
              {
                for (;;)
                {
                  AppMethodBeat.o(231912);
                  return false;
                  String str1 = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_user_name");
                  String str2 = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_nick_name");
                  paramAnonymousMenuItem = new aa(SayHiWithSnsPermissionUI3.this, null);
                  paramAnonymousMenuItem.content = ((String)localObject1);
                  paramAnonymousMenuItem.mw(str1, str2);
                  paramAnonymousMenuItem.Kgh = localHashMap;
                  paramAnonymousMenuItem.chatroomName = SayHiWithSnsPermissionUI3.o(SayHiWithSnsPermissionUI3.this);
                  paramAnonymousMenuItem.z((List)localObject2, localLinkedList);
                  localObject1 = SayHiWithSnsPermissionUI3.this;
                  localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
                  SayHiWithSnsPermissionUI3.this.getString(2131755998);
                  SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(2131765237), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(231909);
                      paramAnonymousMenuItem.gpI();
                      AppMethodBeat.o(231909);
                    }
                  }));
                }
              } while (!SayHiWithSnsPermissionUI3.p(SayHiWithSnsPermissionUI3.this));
              paramAnonymousMenuItem = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("Verify_ticket");
              if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() != 0) {
                if (SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this).QDw)
                {
                  j = 1;
                  i = j;
                  if (!SayHiWithSnsPermissionUI3.m(SayHiWithSnsPermissionUI3.this).QDw) {}
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
                  Log.d("MicroMsg.SayHiWithSnsPermissionUI3", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
                  if (SayHiWithSnsPermissionUI3.n(SayHiWithSnsPermissionUI3.this))
                  {
                    paramAnonymousMenuItem = new com.tencent.mm.openim.b.q(SayHiWithSnsPermissionUI3.i(SayHiWithSnsPermissionUI3.this), paramAnonymousMenuItem, i);
                    bg.azz().a(paramAnonymousMenuItem, 0);
                    localObject1 = SayHiWithSnsPermissionUI3.this;
                    localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
                    SayHiWithSnsPermissionUI3.this.getString(2131755998);
                    SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(2131757868), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                      {
                        AppMethodBeat.i(231910);
                        bg.azz().a(paramAnonymousMenuItem);
                        AppMethodBeat.o(231910);
                      }
                    }));
                    break;
                  }
                  paramAnonymousMenuItem = new p(SayHiWithSnsPermissionUI3.i(SayHiWithSnsPermissionUI3.this), paramAnonymousMenuItem, SayHiWithSnsPermissionUI3.j(SayHiWithSnsPermissionUI3.this), SayHiWithSnsPermissionUI3.o(SayHiWithSnsPermissionUI3.this), i);
                  bg.azz().a(paramAnonymousMenuItem, 0);
                  localObject1 = SayHiWithSnsPermissionUI3.this;
                  localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
                  SayHiWithSnsPermissionUI3.this.getString(2131755998);
                  SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(2131757868), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(231911);
                      bg.azz().a(paramAnonymousMenuItem);
                      AppMethodBeat.o(231911);
                    }
                  }));
                  break;
                }
                j = 0;
                break label653;
              }
              j = 0;
              break;
            }
          }
        }, null, new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(231913);
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(231913);
              return false;
              SayHiWithSnsPermissionUI3.this.Bis[0] = true;
              com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_ver_usr", "<VerifyUsr>", this.Biy);
              continue;
              com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_ver_usr", paramAnonymousMotionEvent);
              com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_ver_usr");
            }
          }
        }, t.b.OGZ);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(231914);
            if (SayHiWithSnsPermissionUI3.p(SayHiWithSnsPermissionUI3.this)) {
              SayHiWithSnsPermissionUI3.q(SayHiWithSnsPermissionUI3.this)[1] = 1;
            }
            SayHiWithSnsPermissionUI3.this.finish();
            SayHiWithSnsPermissionUI3.r(SayHiWithSnsPermissionUI3.this);
            AppMethodBeat.o(231914);
            return true;
          }
        });
        AppMethodBeat.o(231923);
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
        ((TextView)localObject1).setText(2131766156);
        break label447;
        if (i != 2) {
          break label470;
        }
        ((TextView)localObject1).setText(2131766007);
        break label470;
        ((View)this.BhQ.getParent()).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(231904);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() != 0)
            {
              SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).setVisibility(0);
              SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).setVisibility(4);
              SayHiWithSnsPermissionUI3.this.updateOptionMenuStyle(0, t.b.OGU);
              SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(231904);
          }
        });
        localObject2 = (View)this.BhR.getParent();
        if (this.BhT) {}
        for (localObject1 = null;; localObject1 = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(231905);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                if (SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).getVisibility() != 0)
                {
                  SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).setVisibility(4);
                  SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).setVisibility(0);
                  SayHiWithSnsPermissionUI3.this.updateOptionMenuStyle(0, t.b.OGU);
                  SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(231905);
              }
            })
        {
          ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
          break;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), (CharSequence)localObject2, this.Bii.getTextSize());
        this.Bii.setText((CharSequence)localObject1);
      }
      if (!Util.isNullOrNil(this.nickName))
      {
        this.Bij.setHint(com.tencent.mm.pluginsdk.ui.span.l.b(getContext(), this.nickName, this.Bij.getTextSize()));
        this.Bij.setOnFocusChangeListener(new SayHiWithSnsPermissionUI3.8(this));
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
        ((m)localObject2).setSpan(new SayHiWithSnsPermissionUI3.a(this, (String)localObject1), 0, ((m)localObject2).length(), 17);
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
          ((m)localObject2).setSpan(new SayHiWithSnsPermissionUI3.a(this, ((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK()), 0, ((m)localObject2).length(), 17);
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
            ((m)localObject1).setSpan(new SayHiWithSnsPermissionUI3.a(this, this.Azx), 0, ((m)localObject1).length(), 17);
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
    AppMethodBeat.i(231919);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(2131101424));
    hideActionbarLine();
    setMMTitle("");
    initView();
    bg.azz().a(30, this);
    bg.azz().a(243, this);
    bg.azz().a(853, this);
    AppMethodBeat.o(231919);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(231922);
    bg.azz().b(30, this);
    bg.azz().b(243, this);
    bg.azz().b(853, this);
    com.tencent.mm.plugin.report.service.h.CyF.a(14036, new Object[] { Integer.valueOf(this.kmr[0]), Integer.valueOf(this.kmr[1]), Integer.valueOf(this.kmr[2]), Integer.valueOf(this.kmr[3]), Integer.valueOf(this.kmr[4]), Integer.valueOf(this.kmr[5]), Integer.valueOf(this.kmr[6]), Integer.valueOf(this.kmr[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_ver_usr");
    AppMethodBeat.o(231922);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(231929);
    if (paramInt == 4)
    {
      this.kmr[0] = 1;
      finish();
      sL(false);
      AppMethodBeat.o(231929);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(231929);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(231920);
    super.onResume();
    AppMethodBeat.o(231920);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(231927);
    long l1 = System.currentTimeMillis();
    Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    Object localObject;
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
          break label1060;
        }
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(294913, "");
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label1272;
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
        break label924;
      }
      paramString = eEW();
      if (Util.isNullOrNil(paramString)) {
        break label1137;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "set temp remark of %s", new Object[] { this.userName });
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
        label458:
        label609:
        boolean bool;
        label688:
        label759:
        Log.e("MicroMsg.SayHiWithSnsPermissionUI3", "exception in onSceneEnd : " + paramString.getMessage());
        label924:
        label1060:
        return;
        label1028:
        label1137:
        if (Util.isNullOrNil(this.nickName)) {
          break;
        }
        this.kmr[2] = 0;
      }
    }
    finally
    {
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(231927);
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
            break label1227;
          }
          paramq = com.tencent.mm.pluginsdk.ui.preference.b.a((bn)localObject);
          paramq.setUsername(this.userName);
          bg.aVF();
          paramString = paramq;
          if (com.tencent.mm.model.c.aSN().ap(paramq)) {
            break label1227;
          }
          Log.e("MicroMsg.SayHiWithSnsPermissionUI3", "canAddContact fail, insert fail");
        }
        bg.aVF();
        paramString = com.tencent.mm.model.c.aSN().Kn(this.userName);
        paramq = new vx();
        paramq.ebX.ebZ = true;
        paramq.ebX.ebY = false;
        paramq.ebX.username = this.userName;
        EventCenter.instance.publish(paramq);
        if (!this.BhO.QDw) {
          break label1265;
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
          break label1697;
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
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(231927);
      return;
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(294913, localObject);
      break;
      this.kmr[2] = 2;
      break label458;
      if (!(paramq instanceof com.tencent.mm.openim.b.q)) {
        break label1692;
      }
      paramString.add(((com.tencent.mm.openim.b.q)paramq).jGZ);
      break label1692;
      label1227:
      ab.B(paramString);
      bg.getNotification().alb();
      com.tencent.mm.bj.d.bgN().gP(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.cC(this.userName, this.kgm);
      break label609;
      label1265:
      ab.w(paramString);
      break label688;
      label1272:
      if ((paramInt1 != 4) || (paramInt2 != -24) || (Util.isNullOrNil(paramString))) {
        break label1702;
      }
      Toast.makeText(this, paramString, 1).show();
      continue;
      label1302:
      if (!Util.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131755921), null);
      }
      else
      {
        label1328:
        if ((!this.Bim) || ((paramInt2 != -24) && (paramInt2 != -34))) {
          break label1361;
        }
        Toast.makeText(this, 2131760794, 0).show();
      }
    }
    label1361:
    if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.BhS))
    {
      this.BhT = true;
      g.aAh().azQ().set(ar.a.Onw, Integer.valueOf(1));
      if (!Util.isNullOrNil(paramString)) {
        this.Bia.setText(paramString);
      }
      paramq = this.BhQ;
      if (this.Bio) {
        break label1722;
      }
      if (!this.BhT) {
        break label1727;
      }
      break label1722;
      paramq.setVisibility(paramInt1);
      paramq = this.BhR;
      if ((this.Bio) || (this.BhT)) {
        break label1732;
      }
    }
    label1439:
    label1697:
    label1702:
    label1722:
    label1727:
    label1732:
    for (paramInt1 = 0;; paramInt1 = 4)
    {
      paramq.setVisibility(paramInt1);
      ((View)this.BhQ.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(231915);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).getVisibility() != 0)
          {
            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).setVisibility(0);
            SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).setVisibility(4);
            SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(231915);
        }
      });
      localObject = (View)this.BhR.getParent();
      if (this.BhT)
      {
        paramq = null;
        label1516:
        ((View)localObject).setOnClickListener(paramq);
        findViewById(2131305488).setVisibility(8);
        paramq = (TextView)findViewById(2131308188);
        if (!this.BhT) {
          break label1664;
        }
      }
      for (paramInt1 = getResources().getColor(2131100594);; paramInt1 = getResources().getColor(2131100904))
      {
        paramq.setTextColor(paramInt1);
        if (this.BhT) {
          this.Bia.setVisibility(0);
        }
        this.Bio = false;
        eEX();
        paramq = new f.a(this);
        paramq.bow(paramString).Dq(true).boB(getString(2131764037)).apa(2131764038);
        paramq.c(new f.c()
        {
          public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(258241);
            SayHiWithSnsPermissionUI3.this.hideVKB();
            if (!paramAnonymousBoolean)
            {
              paramAnonymousString = "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=contact/faq1&wechat_real_lang=" + LocaleUtil.getCurrentLanguage(SayHiWithSnsPermissionUI3.this);
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", paramAnonymousString);
              localIntent.putExtra("showShare", false);
              localIntent.putExtra("show_bottom", false);
              com.tencent.mm.br.c.b(SayHiWithSnsPermissionUI3.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            }
            AppMethodBeat.o(258241);
          }
        }).show();
        break;
        paramq = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(231901);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).getVisibility() != 0)
            {
              SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this).setVisibility(4);
              SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).setVisibility(0);
              SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(231901);
          }
        };
        break label1516;
      }
      Toast.makeText(this, 2131765235, 0).show();
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
    AppMethodBeat.i(231921);
    super.onStop();
    AppMethodBeat.o(231921);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3
 * JD-Core Version:    0.7.0.1
 */