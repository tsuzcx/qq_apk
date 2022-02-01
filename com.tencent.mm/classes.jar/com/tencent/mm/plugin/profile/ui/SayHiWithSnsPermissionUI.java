package com.tencent.mm.plugin.profile.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.sd;
import com.tencent.mm.autogen.a.tu;
import com.tencent.mm.autogen.a.yv;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.ma;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.model.r;
import com.tencent.mm.openim.model.t;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.protocal.protobuf.fwv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SayHiWithSnsPermissionUI
  extends MMActivity
  implements com.tencent.mm.am.h, com.tencent.mm.ui.tools.h
{
  String His;
  boolean JVi;
  private HashSet<String> JWF;
  private HashSet<String> JWG;
  private HashSet<String> JWH;
  private ObjectAnimator JWJ;
  private m JWf;
  private View JWm;
  private MMSwitchBtn MZL;
  private MMSwitchBtn MZM;
  private WeImageView MZN;
  private WeImageView MZO;
  private boolean MZP;
  private boolean MZQ;
  private String MoA;
  private Button NaA;
  private String NaB;
  private String NaC;
  private int NaD;
  private boolean NaE;
  private int NaF;
  private int NaG;
  private List<String> NaH;
  private HashSet<String> NaI;
  private CharSequence NaJ;
  final boolean[] NaK;
  final boolean[] NaL;
  private int NaM;
  int NaN;
  int NaO;
  int NaP;
  TextView NaQ;
  View NaR;
  private EditText Nah;
  private EditText Nai;
  private View Naj;
  private TextView Nak;
  private TextView Nal;
  private TextView Nam;
  private TextView Nan;
  private TextView Nao;
  private boolean Nap;
  private boolean Naq;
  private boolean Nar;
  private boolean Nas;
  private boolean Nat;
  private List<String> Nau;
  private ArrayList<String> Nav;
  private ArrayList<String> Naw;
  private ImageView Nax;
  private LinearLayout Nay;
  private TextView Naz;
  private boolean akiI;
  private String chatroomName;
  private String dYO;
  private long hTS;
  private ScrollView lDL;
  private com.tencent.mm.ui.tools.i lKz;
  private ProgressDialog lzP;
  private String nickName;
  View pRt;
  e pRv;
  private int pUt;
  private int[] pZy;
  int scene;
  EditText tID;
  String userName;
  
  public SayHiWithSnsPermissionUI()
  {
    AppMethodBeat.i(27407);
    this.lzP = null;
    this.pZy = new int[8];
    this.MZP = false;
    this.MZQ = false;
    this.Nar = false;
    this.Nas = false;
    this.Nat = false;
    this.akiI = false;
    this.Nau = new ArrayList();
    this.Nav = new ArrayList();
    this.Naw = new ArrayList();
    this.JVi = false;
    this.NaD = 0;
    this.NaH = new ArrayList();
    this.NaI = new HashSet();
    this.JWF = new HashSet();
    this.JWG = new HashSet();
    this.JWH = new HashSet();
    this.NaJ = null;
    this.NaK = new boolean[] { true };
    this.NaL = new boolean[] { false };
    this.hTS = System.currentTimeMillis();
    this.NaM = 0;
    this.NaN = 1;
    this.NaO = 1;
    this.scene = 11;
    this.NaP = 0;
    this.JWJ = null;
    this.pRv = null;
    AppMethodBeat.o(27407);
  }
  
  private void Az(boolean paramBoolean)
  {
    AppMethodBeat.i(27418);
    final int i;
    label30:
    label43:
    int j;
    if (this.Nap)
    {
      i = 1;
      if (!Util.isNullOrNil(gCg())) {
        break label342;
      }
      this.NaN = 3;
      if (!this.MZQ) {
        break label378;
      }
      this.NaO = 6;
      switch (this.pUt)
      {
      default: 
        this.scene = 11;
        label278:
        j = getIntent().getIntExtra("Contact_Source_Add", -1);
        if (j == 185) {
          this.scene = 14;
        }
        break;
      }
    }
    for (;;)
    {
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(305673);
          Object localObject = SayHiWithSnsPermissionUI.v(SayHiWithSnsPermissionUI.this);
          int j = ((List)localObject).size();
          StringBuilder localStringBuilder1 = new StringBuilder();
          int k = SayHiWithSnsPermissionUI.w(SayHiWithSnsPermissionUI.this).size();
          if (k > 0)
          {
            i = 0;
            while (i < k)
            {
              localStringBuilder1.append((String)SayHiWithSnsPermissionUI.w(SayHiWithSnsPermissionUI.this).get(i));
              if (i < k - 1) {
                localStringBuilder1.append("#");
              }
              i += 1;
            }
          }
          StringBuilder localStringBuilder2 = new StringBuilder();
          k = ((List)localObject).size();
          if (k > 0)
          {
            i = 0;
            while (i < k)
            {
              localStringBuilder2.append((String)((List)localObject).get(i));
              if (i < k - 1) {
                localStringBuilder2.append("#");
              }
              i += 1;
            }
          }
          localObject = localStringBuilder2.toString();
          bh.bCz();
          int i = com.tencent.mm.model.c.bzA().d(com.tencent.mm.model.ab.oko, new String[] { z.bAM(), "weixin", "helper_entry", "filehelper" });
          com.tencent.mm.plugin.report.service.h.OAn.b(18713, new Object[] { SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), Integer.valueOf(i), Integer.valueOf(SayHiWithSnsPermissionUI.this.NaN), Integer.valueOf(SayHiWithSnsPermissionUI.this.NaO), Integer.valueOf(SayHiWithSnsPermissionUI.this.scene), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - SayHiWithSnsPermissionUI.x(SayHiWithSnsPermissionUI.this)), Integer.valueOf(i), "", localObject, localStringBuilder1, Integer.valueOf(j), Integer.valueOf(SayHiWithSnsPermissionUI.this.NaP) });
          AppMethodBeat.o(305673);
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
      label342:
      if ((!gCg().equals(this.nickName)) && (!gCg().equals(this.MoA))) {
        break label30;
      }
      this.NaN = 2;
      break label30;
      label378:
      if ((this.NaM & 0x8) != 0)
      {
        this.NaO = 5;
        break label43;
      }
      if (((this.NaM & 0x1) != 0) && ((this.NaM & 0x2) != 0))
      {
        this.NaO = 4;
        break label43;
      }
      if ((this.NaM & 0x2) != 0)
      {
        this.NaO = 3;
        break label43;
      }
      if ((this.NaM & 0x1) == 0) {
        break label43;
      }
      this.NaO = 2;
      break label43;
      this.scene = 1;
      break label278;
      this.scene = 2;
      break label278;
      this.scene = 3;
      break label278;
      this.scene = 4;
      break label278;
      this.scene = 5;
      break label278;
      this.scene = 6;
      break label278;
      this.scene = 7;
      break label278;
      this.scene = 8;
      break label278;
      this.scene = 9;
      break label278;
      this.scene = 10;
      break label278;
      this.scene = 12;
      break label278;
      if (j == 184) {
        this.scene = 13;
      }
    }
  }
  
  private static boolean H(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(305487);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.addAll(paramList1);
    localArrayList2.addAll(paramList2);
    Collections.sort(localArrayList1);
    Collections.sort(localArrayList2);
    if (localArrayList1.equals(localArrayList2))
    {
      AppMethodBeat.o(305487);
      return false;
    }
    AppMethodBeat.o(305487);
    return true;
  }
  
  private static boolean aRZ(String paramString)
  {
    AppMethodBeat.i(27416);
    boolean bool = com.tencent.mm.plugin.sns.c.q.Qkl.aRZ(paramString);
    AppMethodBeat.o(27416);
    return bool;
  }
  
  private void eGg()
  {
    AppMethodBeat.i(305499);
    Log.i("MicroMsg.SayHiWithSnsPermissionUI", "dismissTipDialog");
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    AppMethodBeat.o(305499);
  }
  
  private void evt()
  {
    int j = 8;
    AppMethodBeat.i(27413);
    Object localObject1 = this.MZN;
    int i;
    label56:
    Object localObject2;
    label107:
    StringBuilder localStringBuilder;
    if ((this.Nar) || (this.MZQ))
    {
      i = 0;
      ((WeImageView)localObject1).setVisibility(i);
      localObject1 = this.MZO;
      if ((this.Nar) || (this.MZQ)) {
        break label294;
      }
      i = 0;
      ((WeImageView)localObject1).setVisibility(i);
      gCk();
      ((View)this.MZN.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27403);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).setVisibility(0);
          SayHiWithSnsPermissionUI.r(SayHiWithSnsPermissionUI.this).setVisibility(4);
          SayHiWithSnsPermissionUI.this.findViewById(R.h.fRF).setVisibility(8);
          SayHiWithSnsPermissionUI.s(SayHiWithSnsPermissionUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27403);
        }
      });
      localObject2 = (View)this.MZO.getParent();
      if (!this.MZQ) {
        break label299;
      }
      localObject1 = null;
      ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
      localObject1 = findViewById(R.h.fRF);
      if ((!this.MZP) || ((!this.Nar) && (!this.MZQ))) {
        break label311;
      }
      i = 8;
      label145:
      ((View)localObject1).setVisibility(i);
      this.Nao = ((TextView)findViewById(R.h.fXR));
      localObject1 = this.Nao;
      if (!this.MZQ) {
        break label316;
      }
      i = getResources().getColor(R.e.hint_text_color);
      label187:
      ((TextView)localObject1).setTextColor(i);
      localObject1 = findViewById(R.h.fYF);
      i = j;
      if (this.MZQ) {
        i = 0;
      }
      ((View)localObject1).setVisibility(i);
      localObject2 = this.Nao;
      localStringBuilder = new StringBuilder().append(this.Nao.getText());
      if (this.MZO.getVisibility() != 4) {
        break label330;
      }
    }
    label294:
    label299:
    label311:
    label316:
    label330:
    for (localObject1 = getResources().getString(R.l.say_permission_contentdes_select);; localObject1 = getResources().getString(R.l.say_permission_contentdes_unselect))
    {
      ((TextView)localObject2).setContentDescription((String)localObject1);
      this.Nar = false;
      AppMethodBeat.o(27413);
      return;
      i = 4;
      break;
      i = 4;
      break label56;
      localObject1 = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305672);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).setVisibility(4);
          SayHiWithSnsPermissionUI.r(SayHiWithSnsPermissionUI.this).setVisibility(0);
          SayHiWithSnsPermissionUI.this.findViewById(R.h.fRF).setVisibility(0);
          SayHiWithSnsPermissionUI.s(SayHiWithSnsPermissionUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305672);
        }
      };
      break label107;
      i = 0;
      break label145;
      i = getResources().getColor(R.e.normal_text_color);
      break label187;
    }
  }
  
  private String gCf()
  {
    AppMethodBeat.i(305492);
    String str = this.Nah.getText().toString().trim();
    if (str.length() <= 50)
    {
      AppMethodBeat.o(305492);
      return str;
    }
    str = str.substring(0, 50);
    AppMethodBeat.o(305492);
    return str;
  }
  
  private String gCg()
  {
    AppMethodBeat.i(27414);
    String str2 = "";
    String str1 = str2;
    if (this.Nai != null)
    {
      str1 = str2;
      if (this.Nai.getText() != null) {
        str1 = this.Nai.getText().toString();
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
  
  private void gCh()
  {
    AppMethodBeat.i(305497);
    Object localObject1;
    if ((this.Nas) && (this.MZM.afTT) && (!aRZ(this.userName)))
    {
      bh.bCz();
      Object localObject2 = com.tencent.mm.model.c.bzA().JE(this.userName);
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add(((com.tencent.mm.autogen.b.az)localObject2).field_username);
      localObject2 = new sd();
      ((sd)localObject2).hVg.list = ((List)localObject1);
      ((sd)localObject2).hVg.hHC = 1;
      ((sd)localObject2).hVg.hVh = 5L;
      ((sd)localObject2).hVg.hJv = true;
      ((sd)localObject2).publish();
    }
    if (this.Nap)
    {
      localObject1 = this.Nah.getText().toString().trim();
      if ((Util.isNullOrNil((String)localObject1)) || (((String)localObject1).equals(this.NaJ)) || (!Util.isNullOrNil(this.chatroomName)))
      {
        bh.bCz();
        com.tencent.mm.model.c.ban().B(294913, "");
        AppMethodBeat.o(305497);
        return;
      }
      bh.bCz();
      com.tencent.mm.model.c.ban().B(294913, localObject1);
    }
    AppMethodBeat.o(305497);
  }
  
  private void gCi()
  {
    AppMethodBeat.i(305506);
    MMSwitchBtn localMMSwitchBtn;
    StringBuilder localStringBuilder;
    if ((this.MZL != null) && (this.Nal != null))
    {
      localMMSwitchBtn = this.MZL;
      localStringBuilder = new StringBuilder().append(this.Nal.getText());
      if (this.MZL.afTT) {
        break label98;
      }
    }
    label98:
    for (String str = getResources().getString(R.l.say_permission_contentdes_unselect);; str = getResources().getString(R.l.say_permission_contentdes_select))
    {
      localMMSwitchBtn.setContentDescription(str);
      this.MZL.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(305677);
          MMSwitchBtn localMMSwitchBtn = SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this);
          StringBuilder localStringBuilder = new StringBuilder().append(SayHiWithSnsPermissionUI.L(SayHiWithSnsPermissionUI.this).getText());
          if (!SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this).afTT) {}
          for (String str = SayHiWithSnsPermissionUI.this.getResources().getString(R.l.say_permission_contentdes_unselect);; str = SayHiWithSnsPermissionUI.this.getResources().getString(R.l.say_permission_contentdes_select))
          {
            localMMSwitchBtn.setContentDescription(str);
            AppMethodBeat.o(305677);
            return;
          }
        }
      });
      AppMethodBeat.o(305506);
      return;
    }
  }
  
  private void gCj()
  {
    AppMethodBeat.i(305509);
    MMSwitchBtn localMMSwitchBtn;
    StringBuilder localStringBuilder;
    if ((this.MZM != null) && (this.Nam != null))
    {
      localMMSwitchBtn = this.MZM;
      localStringBuilder = new StringBuilder().append(this.Nam.getText());
      if (this.MZM.afTT) {
        break label98;
      }
    }
    label98:
    for (String str = getResources().getString(R.l.say_permission_contentdes_unselect);; str = getResources().getString(R.l.say_permission_contentdes_select))
    {
      localMMSwitchBtn.setContentDescription(str);
      this.MZM.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(305679);
          MMSwitchBtn localMMSwitchBtn = SayHiWithSnsPermissionUI.i(SayHiWithSnsPermissionUI.this);
          StringBuilder localStringBuilder = new StringBuilder().append(SayHiWithSnsPermissionUI.M(SayHiWithSnsPermissionUI.this).getText());
          if (!SayHiWithSnsPermissionUI.i(SayHiWithSnsPermissionUI.this).afTT) {}
          for (String str = SayHiWithSnsPermissionUI.this.getResources().getString(R.l.say_permission_contentdes_unselect);; str = SayHiWithSnsPermissionUI.this.getResources().getString(R.l.say_permission_contentdes_select))
          {
            localMMSwitchBtn.setContentDescription(str);
            AppMethodBeat.o(305679);
            return;
          }
        }
      });
      AppMethodBeat.o(305509);
      return;
    }
  }
  
  private void gCk()
  {
    AppMethodBeat.i(305515);
    TextView localTextView;
    StringBuilder localStringBuilder;
    if ((this.Nao != null) && (this.MZN != null))
    {
      localTextView = this.Nao;
      localStringBuilder = new StringBuilder().append(this.Nao.getText());
      if (this.MZN.getVisibility() != 4)
      {
        str = getResources().getString(R.l.say_permission_contentdes_unselect);
        localTextView.setContentDescription(str);
      }
    }
    else if ((this.Nan != null) && (this.MZN != null))
    {
      localTextView = this.Nan;
      localStringBuilder = new StringBuilder().append(this.Nan.getText());
      if (this.MZN.getVisibility() != 4) {
        break label169;
      }
    }
    label169:
    for (String str = getResources().getString(R.l.say_permission_contentdes_unselect);; str = getResources().getString(R.l.say_permission_contentdes_select))
    {
      localTextView.setContentDescription(str);
      AppMethodBeat.o(305515);
      return;
      str = getResources().getString(R.l.say_permission_contentdes_select);
      break;
    }
  }
  
  private void jw(List<String> paramList)
  {
    AppMethodBeat.i(305485);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.Naz.setText("");
      AppMethodBeat.o(305485);
      return;
    }
    String str = "";
    int i = 0;
    if (i < paramList.size())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str).append((String)paramList.get(i));
      if (i < paramList.size() - 1) {}
      for (str = "，";; str = "")
      {
        str = str;
        i += 1;
        break;
      }
    }
    this.Naz.setText(str);
    AppMethodBeat.o(305485);
  }
  
  public final void AA(boolean paramBoolean)
  {
    AppMethodBeat.i(305631);
    Object localObject = new Intent(this, SayHiWithSnsPermissionUI.class);
    ((Intent)localObject).putExtras(getIntent().getExtras());
    ((Intent)localObject).putExtra("Contact_IsForceVerifyFriend", true);
    int j;
    if (this.MZN.getVisibility() != 0) {
      if (this.MZL.afTT)
      {
        j = 1;
        i = j;
        if (!this.MZM.afTT) {}
      }
    }
    for (int i = j | 0x2;; i = 0)
    {
      j = i;
      if (this.MZN.getVisibility() == 0) {
        j = i | 0x8;
      }
      if (paramBoolean) {
        ((Intent)localObject).putExtra("sayhi_with_sns_perm_send_verify", true);
      }
      ((Intent)localObject).putExtra("Contact_default_permission", j);
      ((Intent)localObject).putExtra("Contact_RemarkName", gCg());
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI", "gotoSelfPageWithoutDialog", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI", "gotoSelfPageWithoutDialog", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(305631);
      return;
      j = 0;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return R.i.gnF;
  }
  
  public final void hm(final long paramLong)
  {
    AppMethodBeat.i(305636);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(305671);
        ma localma = new ma();
        if (SayHiWithSnsPermissionUI.v(SayHiWithSnsPermissionUI.this) == null) {
          SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this, new ArrayList());
        }
        if (SayHiWithSnsPermissionUI.A(SayHiWithSnsPermissionUI.this) == null) {
          SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this, new ArrayList());
        }
        if (SayHiWithSnsPermissionUI.A(SayHiWithSnsPermissionUI.this) == null) {
          SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this, new ArrayList());
        }
        Object localObject1 = SayHiWithSnsPermissionUI.v(SayHiWithSnsPermissionUI.this);
        localma.uI(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this));
        long l;
        Object localObject2;
        int i;
        label142:
        String str;
        if (SayHiWithSnsPermissionUI.B(SayHiWithSnsPermissionUI.this))
        {
          l = 1L;
          localma.jaJ = l;
          localObject2 = ((List)localObject1).iterator();
          i = 0;
          if (!((Iterator)localObject2).hasNext()) {
            break label192;
          }
          str = (String)((Iterator)localObject2).next();
          if (!SayHiWithSnsPermissionUI.C(SayHiWithSnsPermissionUI.this).contains(str)) {
            break label1010;
          }
          i += 1;
        }
        label192:
        label998:
        label1001:
        label1004:
        label1007:
        label1010:
        for (;;)
        {
          break label142;
          l = 0L;
          break;
          localma.jaL = i;
          l = 0L;
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (SayHiWithSnsPermissionUI.D(SayHiWithSnsPermissionUI.this).contains(str)) {
              l += 1L;
            }
          }
          localma.jaN = l;
          localObject2 = ((List)localObject1).iterator();
          int j = 0;
          if (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (!SayHiWithSnsPermissionUI.E(SayHiWithSnsPermissionUI.this).contains(str)) {
              break label1007;
            }
            j += 1;
          }
          for (;;)
          {
            break;
            localma.jaM = j;
            localObject2 = ((List)localObject1).iterator();
            int k = 0;
            if (((Iterator)localObject2).hasNext())
            {
              str = (String)((Iterator)localObject2).next();
              if (!SayHiWithSnsPermissionUI.F(SayHiWithSnsPermissionUI.this).contains(str)) {
                break label1004;
              }
              k += 1;
            }
            for (;;)
            {
              break;
              localma.jaK = k;
              localma.iGM = (System.currentTimeMillis() - SayHiWithSnsPermissionUI.x(SayHiWithSnsPermissionUI.this));
              localma.jaR = SayHiWithSnsPermissionUI.G(SayHiWithSnsPermissionUI.this);
              localma.jaS = paramLong;
              localma.jaO = SayHiWithSnsPermissionUI.H(SayHiWithSnsPermissionUI.this);
              int n = 0;
              localObject2 = ((List)localObject1).iterator();
              int m = 0;
              if (((Iterator)localObject2).hasNext())
              {
                str = (String)((Iterator)localObject2).next();
                if (SayHiWithSnsPermissionUI.A(SayHiWithSnsPermissionUI.this).contains(str)) {
                  break label1001;
                }
                m += 1;
              }
              for (;;)
              {
                break;
                localObject2 = SayHiWithSnsPermissionUI.A(SayHiWithSnsPermissionUI.this).iterator();
                if (((Iterator)localObject2).hasNext())
                {
                  if (((List)localObject1).contains((String)((Iterator)localObject2).next())) {
                    break label998;
                  }
                  n += 1;
                }
                for (;;)
                {
                  break;
                  localma.iuA = 2L;
                  localObject2 = "";
                  localObject1 = localObject2;
                  if (SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this) != null)
                  {
                    localObject1 = localObject2;
                    if (SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getText() != null)
                    {
                      localObject1 = localObject2;
                      if (SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getText().toString() != null) {
                        localObject1 = SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getText().toString().trim();
                      }
                    }
                  }
                  localObject2 = localObject1;
                  if (localObject1 == null) {
                    localObject2 = "";
                  }
                  if (!com.tencent.mm.platformtools.ab.isNullOrNil(SayHiWithSnsPermissionUI.I(SayHiWithSnsPermissionUI.this))) {
                    if (SayHiWithSnsPermissionUI.I(SayHiWithSnsPermissionUI.this).equals(localObject2)) {
                      SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this, 3);
                    }
                  }
                  for (;;)
                  {
                    localma.jaT = SayHiWithSnsPermissionUI.K(SayHiWithSnsPermissionUI.this);
                    localma.jaQ = m;
                    localma.jaP = n;
                    localma.bMH();
                    Log.i("MicroMsg.SayHiWithSnsPermissionUI", "22865 setAddedLabelCnt = " + m + ",setRemovedLabelCnt = " + n + ",oriLabelCnt = " + SayHiWithSnsPermissionUI.H(SayHiWithSnsPermissionUI.this) + ",opResult = " + paramLong + ",totalLabelCnt = " + SayHiWithSnsPermissionUI.G(SayHiWithSnsPermissionUI.this) + ",selectNewLabelCnt = " + k + ",selectAddLabelCnt = " + j + ",addRemarkType = " + SayHiWithSnsPermissionUI.K(SayHiWithSnsPermissionUI.this) + ",scene= 2,newLebalCountBySearch = " + i + ",searchAddLabelCnt = " + l);
                    AppMethodBeat.o(305671);
                    return;
                    SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this, 2);
                    continue;
                    if (!SayHiWithSnsPermissionUI.this.JVi) {
                      SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this, 3);
                    } else if (!com.tencent.mm.platformtools.ab.isNullOrNil(SayHiWithSnsPermissionUI.J(SayHiWithSnsPermissionUI.this)))
                    {
                      if (SayHiWithSnsPermissionUI.J(SayHiWithSnsPermissionUI.this).equals(localObject2)) {
                        SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this, 1);
                      } else if (Util.isNullOrNil((String)localObject2)) {
                        SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this, 3);
                      } else {
                        SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this, 2);
                      }
                    }
                    else if (((String)localObject2).equals(SayHiWithSnsPermissionUI.J(SayHiWithSnsPermissionUI.this))) {
                      SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this, 3);
                    } else {
                      SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this, 2);
                    }
                  }
                }
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(305636);
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(305592);
    HashSet localHashSet = new HashSet(super.importUIComponents());
    localHashSet.add(com.tencent.mm.plugin.profile.ui.a.d.class);
    AppMethodBeat.o(305592);
    return localHashSet;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27412);
    this.Nap = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
    this.Naq = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
    this.userName = getIntent().getStringExtra("Contact_User");
    this.pUt = getIntent().getIntExtra("Contact_Scene", 9);
    this.chatroomName = getIntent().getStringExtra("room_name");
    this.dYO = getIntent().getStringExtra("Contact_RemarkName");
    this.NaC = this.dYO;
    this.nickName = getIntent().getStringExtra("Contact_Nick");
    this.MoA = getIntent().getStringExtra("Contact_RoomNickname");
    this.Naj = findViewById(R.h.fOr);
    this.Nak = ((TextView)findViewById(R.h.fOs));
    boolean bool;
    label202:
    Object localObject1;
    label255:
    int i;
    label308:
    label379:
    Object localObject3;
    label577:
    label606:
    Object localObject2;
    label684:
    Object localObject4;
    if ((com.tencent.mm.plugin.profile.c.aRQ(this.userName)) && (!getIntent().getBooleanExtra("Contact_IsForceVerifyFriend", false)))
    {
      bool = true;
      this.Nat = bool;
      if ((this.Nat) || (!this.Nap)) {
        break label1549;
      }
      bool = true;
      this.akiI = bool;
      if (!au.bwO(this.userName)) {
        break label1554;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI", "initLabelPanelAll, isOpenIM, userName: %s.", new Object[] { this.userName });
      localObject1 = findViewById(R.h.fMg);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI", "isCurrentHappenChatting = " + this.Nat);
      if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("MMSocialBlackListFlag", 1) != 1) {
        break label1942;
      }
      bool = true;
      this.MZP = bool;
      if (!this.MZP) {
        findViewById(R.h.fYH).setVisibility(8);
      }
      com.tencent.mm.kernel.h.baF();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.userName);
      if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adfD, 0) != 1) {
        break label1947;
      }
      bool = true;
      this.Nar = bool;
      this.MZL = ((MMSwitchBtn)findViewById(R.h.fRD).findViewById(R.h.fRH));
      getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
      this.MZL.setCheck(((au)localObject1).aSL());
      this.MZN = ((WeImageView)findViewById(R.h.fYE));
      this.MZO = ((WeImageView)findViewById(R.h.fXP));
      this.Nan = ((TextView)findViewById(R.h.fYJ));
      this.MZM = ((MMSwitchBtn)findViewById(R.h.fXO).findViewById(R.h.fRJ));
      bool = aRZ(this.userName);
      this.MZM.setCheck(bool);
      findViewById(R.h.fuN).setOnClickListener(new SayHiWithSnsPermissionUI.1(this));
      i = ((com.tencent.mm.autogen.b.az)localObject1).sex;
      Log.d("MicroMsg.SayHiWithSnsPermissionUI", "sex:%d", new Object[] { Integer.valueOf(i) });
      this.Nal = ((TextView)findViewById(R.h.fRI));
      if (i != 1) {
        break label1952;
      }
      this.Nal.setText(R.l.sns_outside_permiss_male);
      this.Nam = ((TextView)findViewById(R.h.fRK));
      if (i != 1) {
        break label1970;
      }
      this.Nam.setText(R.l.sns_black_permiss_male);
      bool = au.bwO(this.userName);
      this.Nas = bool;
      if (!bool) {
        break label2006;
      }
      findViewById(R.h.fYH).setVisibility(8);
      localObject1 = findViewById(R.h.fRD);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      ((TextView)findViewById(R.h.fRG)).setText(R.l.gSC);
      if (i != 1) {
        break label1988;
      }
      this.Nam.setText(R.l.gSl);
      if (this.Nap)
      {
        this.Nah = ((EditText)findViewById(R.h.fVk));
        com.tencent.mm.ui.tools.b.c.i(this.Nah).aEg(100).a(null);
        this.Nah.setFilters(com.tencent.mm.pluginsdk.ui.tools.k.Ytp);
        this.Nah.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(27393);
            if (SayHiWithSnsPermissionUI.this.NaK[0] != 0)
            {
              SayHiWithSnsPermissionUI.this.NaK[0] = false;
              com.tencent.mm.plugin.normsg.a.d.MtP.aQh("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.d.MtP.aQi("ie_ver_usr");
            AppMethodBeat.o(27393);
          }
        });
        bh.bCz();
        localObject3 = (String)com.tencent.mm.model.c.ban().d(294913, null);
        localObject2 = z.bAO();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject4 = getString(R.l.sendgreeting_content);
        if (((String)localObject4).length() + ((String)localObject1).length() <= 50) {
          break label2958;
        }
        localObject1 = ((String)localObject1).substring(0, 50 - ((String)localObject4).length());
      }
    }
    label1549:
    label2958:
    for (;;)
    {
      localObject2 = localObject3;
      if (!Util.isNullOrNil(this.chatroomName))
      {
        au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.chatroomName);
        localObject2 = localObject3;
        if (localau != null)
        {
          localObject2 = localObject3;
          if (!Util.isNullOrNil(localau.field_nickname))
          {
            localObject3 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jv(this.chatroomName).getDisplayName(z.bAM());
            localObject2 = localObject3;
            if (Util.isNullOrNil((CharSequence)localObject3)) {
              localObject2 = localObject1;
            }
            Log.i("MicroMsg.SayHiWithSnsPermissionUI", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localau.field_nickname });
            localObject2 = com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), getResources().getString(R.l.sendgreeting_content_chatroom, new Object[] { localau.field_nickname, localObject2 }), this.Nah.getTextSize());
            this.NaJ = ((CharSequence)localObject2);
          }
        }
      }
      if (Util.isNullOrNil(this.NaJ)) {
        this.NaJ = com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), String.format((String)localObject4, new Object[] { localObject1 }), this.Nah.getTextSize());
      }
      if (Util.isNullOrNil((CharSequence)localObject2))
      {
        this.Nah.setText(this.NaJ);
        label1066:
        this.Nah.clearFocus();
        if ((this.Nah != null) && ((this.Nah.getParent() instanceof LinearLayout))) {
          break label2176;
        }
        Log.i("MicroMsg.SayHiWithSnsPermissionUI", "updateSayHiContextVisiable");
        label1102:
        if (this.Naq)
        {
          this.Nai = ((EditText)findViewById(R.h.fVl));
          ((LinearLayout)this.Nai.getParent()).setVisibility(0);
          if (!this.Nap) {
            this.Nai.clearFocus();
          }
          com.tencent.mm.ui.tools.b.c.i(this.Nai).aEg(100).a(null);
          this.Nai.setFilters(com.tencent.mm.pluginsdk.ui.tools.k.Ytp);
          if (this.Nap) {
            break label2261;
          }
          setMMTitle(R.l.gSA);
          this.pZy[0] = 1;
          if (Util.isNullOrNil(this.dYO)) {
            break label2271;
          }
          this.Nai.setText(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), this.dYO, this.Nai.getTextSize()));
          this.pZy[6] = 1;
          if ((this.Nai.getHint() != null) && (!Util.isNullOrNil(this.Nai.getHint().toString()))) {
            this.NaB = this.Nai.getHint().toString();
          }
          if ((this.Nai.getText() != null) && (!Util.isNullOrNil(this.Nai.getText().toString()))) {
            this.NaB = this.Nai.getText().toString();
          }
        }
        label1198:
        localObject1 = getString(R.l.app_send);
        if (!this.Nap) {
          localObject1 = getString(R.l.app_finish);
        }
        if (!this.Nat) {
          break label2955;
        }
        localObject1 = getString(R.l.app_finish);
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.plugin.normsg.a.c.aeT(3);
        this.NaA = ((Button)findViewById(R.h.finish_btn));
        this.NaA.setText((CharSequence)localObject1);
        this.NaA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(305685);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
            if ((SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this) != null) && (SayHiWithSnsPermissionUI.b(SayHiWithSnsPermissionUI.this).isShowing()))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(305685);
              return;
            }
            final LinkedList localLinkedList2;
            final LinkedList localLinkedList1;
            final HashMap localHashMap;
            int j;
            if (SayHiWithSnsPermissionUI.this.NaL[0] != 0)
            {
              SayHiWithSnsPermissionUI.this.NaL[0] = false;
              com.tencent.mm.plugin.normsg.a.d.MtP.gq(this.NaW, 3);
              if (!SayHiWithSnsPermissionUI.c(SayHiWithSnsPermissionUI.this)) {
                break label771;
              }
              localLinkedList2 = new LinkedList();
              localLinkedList2.add(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this));
              localLinkedList1 = new LinkedList();
              localLinkedList1.add(Integer.valueOf(SayHiWithSnsPermissionUI.e(SayHiWithSnsPermissionUI.this)));
              localObject1 = SayHiWithSnsPermissionUI.f(SayHiWithSnsPermissionUI.this);
              localHashMap = new HashMap();
              if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() == 0) {
                break label1101;
              }
              if (!SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this).afTT) {
                break label1096;
              }
              j = 1;
              label214:
              i = j;
              if (!SayHiWithSnsPermissionUI.i(SayHiWithSnsPermissionUI.this).afTT) {}
            }
            label771:
            label823:
            label1096:
            label1101:
            for (int i = j | 0x2;; i = 0)
            {
              j = i;
              if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() == 0) {
                j = i | 0x8;
              }
              SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this, j);
              localHashMap.put(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), Integer.valueOf(j));
              Log.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[] { Integer.valueOf(j) });
              Object localObject2;
              if (SayHiWithSnsPermissionUI.j(SayHiWithSnsPermissionUI.this))
              {
                paramAnonymousView = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra(f.e.adwe);
                paramAnonymousView = new r(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), (String)localObject1, paramAnonymousView, j);
                bh.aZW().a(paramAnonymousView, 0);
                localObject1 = SayHiWithSnsPermissionUI.this;
                localObject2 = SayHiWithSnsPermissionUI.this.getContext();
                SayHiWithSnsPermissionUI.this.getString(R.l.app_tip);
                SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.k.a((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(27395);
                    bh.aZW().a(paramAnonymousView);
                    AppMethodBeat.o(27395);
                  }
                }));
              }
              do
              {
                long l = SayHiWithSnsPermissionUI.this.getIntent().getLongExtra("key_msg_id", 0L);
                if (com.tencent.mm.plugin.messenger.g.a.sr(l)) {
                  com.tencent.mm.plugin.messenger.g.a.aq(l, 4);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(305685);
                return;
                com.tencent.mm.plugin.normsg.a.d.MtP.aJ("ce_ver_usr", "<VerifyUsr>", this.NaW);
                paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
                com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_ver_usr", paramAnonymousView);
                com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_ver_usr");
                break;
                Log.i("MicroMsg.SayHiWithSnsPermissionUI", "addTextOptionMenu:send addcontact.");
                final String str1 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_user_name");
                final String str2 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_nick_name");
                localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(SayHiWithSnsPermissionUI.this, null);
                if (SayHiWithSnsPermissionUI.k(SayHiWithSnsPermissionUI.this)) {}
                for (paramAnonymousView = "";; paramAnonymousView = (View)localObject1)
                {
                  ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).content = paramAnonymousView;
                  ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).pk(str1, str2);
                  ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).YaW = localHashMap;
                  ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).chatroomName = SayHiWithSnsPermissionUI.l(SayHiWithSnsPermissionUI.this);
                  ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).YaM = new a.b()
                  {
                    public final boolean n(final String paramAnonymous2String1, int paramAnonymous2Int, String paramAnonymous2String2)
                    {
                      AppMethodBeat.i(305455);
                      Object localObject;
                      if (paramAnonymous2Int == -4000)
                      {
                        Log.i("MicroMsg.SayHiWithSnsPermissionUI", "addTextOptionMenu:send addcontact.");
                        localObject = new com.tencent.mm.pluginsdk.ui.applet.a(SayHiWithSnsPermissionUI.this, null);
                        if (SayHiWithSnsPermissionUI.k(SayHiWithSnsPermissionUI.this))
                        {
                          paramAnonymous2String1 = "";
                          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).content = paramAnonymous2String1;
                          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).pk(str1, str2);
                          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).YaW = localHashMap;
                          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).chatroomName = SayHiWithSnsPermissionUI.l(SayHiWithSnsPermissionUI.this);
                          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).YaM = new a.b()
                          {
                            public final boolean n(String paramAnonymous3String1, int paramAnonymous3Int, String paramAnonymous3String2)
                            {
                              return true;
                            }
                          };
                          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).hks = false;
                          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).YaZ = paramAnonymous2String2;
                          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).YaV = new ab.a()
                          {
                            public final void gCl()
                            {
                              AppMethodBeat.i(305624);
                              SayHiWithSnsPermissionUI.m(SayHiWithSnsPermissionUI.this);
                              AppMethodBeat.o(305624);
                            }
                            
                            public final void gCm()
                            {
                              SayHiWithSnsPermissionUI localSayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.this;
                              localSayHiWithSnsPermissionUI.NaP += 1;
                            }
                          };
                          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).YaZ = paramAnonymous2String2;
                          com.tencent.mm.kernel.h.baF();
                          paramAnonymous2String1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this));
                          ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).a(SayHiWithSnsPermissionUI.this, paramAnonymous2String1, SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), localLinkedList1);
                          SayHiWithSnsPermissionUI.n(SayHiWithSnsPermissionUI.this);
                          paramAnonymous2String1 = SayHiWithSnsPermissionUI.this;
                          paramAnonymous2String2 = SayHiWithSnsPermissionUI.this.getContext();
                          SayHiWithSnsPermissionUI.this.getString(R.l.app_tip);
                          SayHiWithSnsPermissionUI.a(paramAnonymous2String1, com.tencent.mm.ui.base.k.a(paramAnonymous2String2, SayHiWithSnsPermissionUI.this.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
                          {
                            public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                            {
                              AppMethodBeat.i(305626);
                              this.Nbc.iKU();
                              AppMethodBeat.o(305626);
                            }
                          }));
                        }
                      }
                      for (;;)
                      {
                        AppMethodBeat.o(305455);
                        return true;
                        paramAnonymous2String1 = this.val$content;
                        break;
                        if (SayHiWithSnsPermissionUI.k(SayHiWithSnsPermissionUI.this))
                        {
                          paramAnonymous2String1 = SayHiWithSnsPermissionUI.this;
                          bh.bCz();
                          paramAnonymous2String2 = com.tencent.mm.model.c.bzA().JE(paramAnonymous2String1.userName);
                          label357:
                          boolean bool;
                          if (paramAnonymous2String2 != null)
                          {
                            paramAnonymous2String1.His = paramAnonymous2String1.getResources().getString(R.l.contact_info_verify_content, new Object[] { paramAnonymous2String2.field_nickname });
                            paramAnonymous2String1.pRt = View.inflate(paramAnonymous2String1, c.f.sendrequest_dialog, null);
                            if (paramAnonymous2String1.His != null) {
                              break label617;
                            }
                            bool = true;
                            label379:
                            if (paramAnonymous2String1.His != null) {
                              break label623;
                            }
                          }
                          label617:
                          label623:
                          for (paramAnonymous2Int = 0;; paramAnonymous2Int = paramAnonymous2String1.His.length())
                          {
                            Log.i("MicroMsg.SayHiWithSnsPermissionUI", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymous2Int), paramAnonymous2String1.His });
                            if (!Util.isNullOrNil(paramAnonymous2String1.His)) {
                              ((TextView)paramAnonymous2String1.pRt.findViewById(c.e.sendrequest_tip)).setText(paramAnonymous2String1.His);
                            }
                            paramAnonymous2String1.NaR = paramAnonymous2String1.pRt.findViewById(c.e.edittext_container);
                            paramAnonymous2String1.tID = ((EditText)paramAnonymous2String1.pRt.findViewById(c.e.sendrequest_content));
                            paramAnonymous2String1.NaQ = ((TextView)paramAnonymous2String1.pRt.findViewById(c.e.wordcount));
                            paramAnonymous2String1.NaQ.setVisibility(0);
                            paramAnonymous2String1.tID.setText(null);
                            paramAnonymous2String1.NaQ.setText("50");
                            paramAnonymous2String1.tID.setVisibility(8);
                            paramAnonymous2String1.NaR.setVisibility(8);
                            paramAnonymous2String2 = new SayHiWithSnsPermissionUI.7(paramAnonymous2String1);
                            localObject = new SayHiWithSnsPermissionUI.8(paramAnonymous2String1);
                            paramAnonymous2String1.pRv = com.tencent.mm.ui.base.k.a(paramAnonymous2String1, "", paramAnonymous2String1.getString(c.h.contact_info_verify_accept), paramAnonymous2String1.pRt, paramAnonymous2String2, (DialogInterface.OnClickListener)localObject);
                            if (paramAnonymous2String1.pRv != null) {
                              break;
                            }
                            paramAnonymous2String1.onStop();
                            break;
                            paramAnonymous2String1.His = paramAnonymous2String1.getResources().getString(R.l.contact_info_verify_content_default);
                            break label357;
                            bool = false;
                            break label379;
                          }
                        }
                        Log.i("MicroMsg.SayHiWithSnsPermissionUI", "dealAddContactError, resend request ver.");
                        paramAnonymous2String2 = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_user_name");
                        localObject = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("source_from_nick_name");
                        paramAnonymous2String1 = new com.tencent.mm.pluginsdk.ui.applet.ab(SayHiWithSnsPermissionUI.this, null);
                        paramAnonymous2String1.content = this.val$content;
                        paramAnonymous2String1.pg(paramAnonymous2String2, (String)localObject);
                        paramAnonymous2String1.YaW = localHashMap;
                        paramAnonymous2String1.chatroomName = SayHiWithSnsPermissionUI.l(SayHiWithSnsPermissionUI.this);
                        paramAnonymous2String1.S(localLinkedList2, localLinkedList1);
                        SayHiWithSnsPermissionUI.n(SayHiWithSnsPermissionUI.this);
                        paramAnonymous2String2 = SayHiWithSnsPermissionUI.this;
                        localObject = SayHiWithSnsPermissionUI.this.getContext();
                        SayHiWithSnsPermissionUI.this.getString(R.l.app_tip);
                        SayHiWithSnsPermissionUI.a(paramAnonymous2String2, com.tencent.mm.ui.base.k.a((Context)localObject, SayHiWithSnsPermissionUI.this.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
                        {
                          public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                          {
                            AppMethodBeat.i(305625);
                            paramAnonymous2String1.iKU();
                            AppMethodBeat.o(305625);
                          }
                        }));
                      }
                    }
                  };
                  ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).hks = false;
                  ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).YaV = new ab.a()
                  {
                    public final void gCl()
                    {
                      AppMethodBeat.i(305433);
                      SayHiWithSnsPermissionUI.m(SayHiWithSnsPermissionUI.this);
                      AppMethodBeat.o(305433);
                    }
                    
                    public final void gCm()
                    {
                      SayHiWithSnsPermissionUI localSayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.this;
                      localSayHiWithSnsPermissionUI.NaP += 1;
                    }
                  };
                  com.tencent.mm.kernel.h.baF();
                  paramAnonymousView = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this));
                  ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).a(SayHiWithSnsPermissionUI.this, paramAnonymousView, SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), localLinkedList1);
                  SayHiWithSnsPermissionUI.n(SayHiWithSnsPermissionUI.this);
                  paramAnonymousView = SayHiWithSnsPermissionUI.this;
                  localObject1 = SayHiWithSnsPermissionUI.this.getContext();
                  SayHiWithSnsPermissionUI.this.getString(R.l.app_tip);
                  SayHiWithSnsPermissionUI.a(paramAnonymousView, com.tencent.mm.ui.base.k.a((Context)localObject1, SayHiWithSnsPermissionUI.this.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(27398);
                      this.Nbc.iKU();
                      AppMethodBeat.o(27398);
                    }
                  }));
                  break;
                }
              } while (!SayHiWithSnsPermissionUI.o(SayHiWithSnsPermissionUI.this));
              paramAnonymousView = SayHiWithSnsPermissionUI.this.getIntent().getStringExtra("Verify_ticket");
              if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() != 0) {
                if (SayHiWithSnsPermissionUI.h(SayHiWithSnsPermissionUI.this).afTT)
                {
                  j = 1;
                  i = j;
                  if (!SayHiWithSnsPermissionUI.i(SayHiWithSnsPermissionUI.this).afTT) {}
                }
              }
              for (i = j | 0x2;; i = 0)
              {
                if (SayHiWithSnsPermissionUI.g(SayHiWithSnsPermissionUI.this).getVisibility() == 0) {
                  i |= 0x8;
                }
                for (;;)
                {
                  SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this, i);
                  Log.d("MicroMsg.SayHiWithSnsPermissionUI", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
                  if (SayHiWithSnsPermissionUI.j(SayHiWithSnsPermissionUI.this))
                  {
                    paramAnonymousView = new t(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), paramAnonymousView, i);
                    bh.aZW().a(paramAnonymousView, 0);
                    localObject1 = SayHiWithSnsPermissionUI.this;
                    localObject2 = SayHiWithSnsPermissionUI.this.getContext();
                    SayHiWithSnsPermissionUI.this.getString(R.l.app_tip);
                    SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.k.a((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(R.l.gBk), true, new DialogInterface.OnCancelListener()
                    {
                      public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                      {
                        AppMethodBeat.i(305443);
                        bh.aZW().a(paramAnonymousView);
                        AppMethodBeat.o(305443);
                      }
                    }));
                    break;
                  }
                  paramAnonymousView = new v(SayHiWithSnsPermissionUI.d(SayHiWithSnsPermissionUI.this), paramAnonymousView, SayHiWithSnsPermissionUI.e(SayHiWithSnsPermissionUI.this), SayHiWithSnsPermissionUI.l(SayHiWithSnsPermissionUI.this), i);
                  bh.aZW().a(paramAnonymousView, 0);
                  localObject1 = SayHiWithSnsPermissionUI.this;
                  localObject2 = SayHiWithSnsPermissionUI.this.getContext();
                  SayHiWithSnsPermissionUI.this.getString(R.l.app_tip);
                  SayHiWithSnsPermissionUI.a((SayHiWithSnsPermissionUI)localObject1, com.tencent.mm.ui.base.k.a((Context)localObject2, SayHiWithSnsPermissionUI.this.getString(R.l.gBk), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(305454);
                      bh.aZW().a(paramAnonymousView);
                      AppMethodBeat.o(305454);
                    }
                  }));
                  break;
                }
                j = 0;
                break label823;
              }
              j = 0;
              break label214;
            }
          }
        });
        this.NaA.setOnTouchListener(new View.OnTouchListener()
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
              SayHiWithSnsPermissionUI.this.NaL[0] = true;
              com.tencent.mm.plugin.normsg.a.d.MtP.aJ("ce_ver_usr", "<VerifyUsr>", this.NaW);
              continue;
              com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_ver_usr", paramAnonymousMotionEvent);
              com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_ver_usr");
            }
          }
        });
        this.NaA.setTextColor(getResources().getColor(a.d.color_btn_text_selector));
        this.NaA.setBackground(getDrawable(a.f.btn_solid_green));
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(27401);
            if (SayHiWithSnsPermissionUI.o(SayHiWithSnsPermissionUI.this)) {
              SayHiWithSnsPermissionUI.p(SayHiWithSnsPermissionUI.this)[1] = 1;
            }
            SayHiWithSnsPermissionUI.this.finish();
            SayHiWithSnsPermissionUI.q(SayHiWithSnsPermissionUI.this);
            SayHiWithSnsPermissionUI.this.hm(2L);
            AppMethodBeat.o(27401);
            return true;
          }
        });
        this.lKz = new com.tencent.mm.ui.tools.i(this);
        this.lKz.afIL = this;
        if (this.Nat) {
          setMMTitle(R.l.gSB);
        }
        gCk();
        gCj();
        gCi();
        com.tencent.mm.ui.tools.b.c.i(this.Nai).aEg(32).a(new c.a()
        {
          public final void Tw(String paramAnonymousString) {}
          
          public final void Tx(String paramAnonymousString) {}
          
          public final void eY(String paramAnonymousString) {}
        });
        AppMethodBeat.o(27412);
        return;
        bool = false;
        break;
        bool = false;
        break label202;
        label1554:
        this.Naz = ((TextView)findViewById(R.h.fCs));
        this.Naz.setVisibility(0);
        this.Nay = ((LinearLayout)findViewById(R.h.fCt));
        this.Nax = ((ImageView)findViewById(R.h.fso));
        if (this.Nax != null) {
          this.Nax.setImageDrawable(bb.m(this, R.k.icons_outlined_arrow, com.tencent.mm.cd.a.w(getContext(), R.e.BW_70)));
        }
        this.Nay.setOnClickListener(new SayHiWithSnsPermissionUI.2(this));
        this.lDL = ((ScrollView)findViewById(R.h.scrollView));
        this.JWm = findViewById(R.h.fMh);
        this.JWm.setBackgroundDrawable(null);
        this.JWm.setVisibility(0);
        this.Nau = com.tencent.mm.plugin.label.d.fTa().iZN();
        localObject1 = null;
        if (this.Nav != null)
        {
          localObject1 = null;
          bh.bCz();
          localObject2 = com.tencent.mm.model.c.bzB().aMi(this.userName);
          if (localObject2 != null) {
            localObject1 = ((cr)localObject2).field_contactLabels;
          }
          localObject3 = localObject1;
          if (Util.isNullOrNil((String)localObject1))
          {
            bh.bCz();
            localObject4 = com.tencent.mm.model.c.bzA().JE(this.userName);
            localObject3 = ((com.tencent.mm.autogen.b.az)localObject4).field_encryptUsername;
            localObject2 = localObject1;
            if (!Util.isNullOrNil((String)localObject3))
            {
              bh.bCz();
              localObject3 = com.tencent.mm.model.c.bzB().aMi((String)localObject3);
              localObject2 = localObject1;
              if (localObject3 != null) {
                localObject2 = ((cr)localObject3).field_contactLabels;
              }
            }
            localObject3 = localObject2;
            if (Util.isNullOrNil((String)localObject2))
            {
              localObject1 = ((com.tencent.mm.autogen.b.az)localObject4).field_username;
              bh.bCz();
              localObject1 = com.tencent.mm.model.c.bzB().aMi((String)localObject1);
              localObject3 = localObject2;
              if (localObject1 != null) {
                localObject3 = ((cr)localObject1).field_contactLabels;
              }
            }
          }
          localObject1 = (ArrayList)com.tencent.mm.plugin.label.a.a.fTb().aJI((String)localObject3);
        }
        if (localObject1 != null) {
          this.Nav.addAll((Collection)localObject1);
        }
        if (this.Nau != null) {
          this.NaF = this.Nau.size();
        }
        if (localObject1 != null)
        {
          this.NaG = ((ArrayList)localObject1).size();
          this.NaH.addAll((Collection)localObject1);
        }
        jw((List)localObject1);
        break label255;
        label1942:
        bool = false;
        break label308;
        label1947:
        bool = false;
        break label379;
        label1952:
        if (i != 2) {
          break label577;
        }
        this.Nal.setText(R.l.sns_outside_permiss_female);
        break label577;
        label1970:
        if (i != 2) {
          break label606;
        }
        this.Nam.setText(R.l.sns_black_permiss_female);
        break label606;
        label1988:
        if (i != 2) {
          break label684;
        }
        this.Nam.setText(R.l.gSj);
        break label684;
        label2006:
        localObject1 = u.Naf;
        u.iE(findViewById(R.h.fRG));
        evt();
        i = getIntent().getIntExtra("Contact_default_permission", -1);
        if (i <= 0) {
          break label684;
        }
        if ((i & 0x8) == 8)
        {
          this.MZN.setVisibility(0);
          this.MZO.setVisibility(4);
          findViewById(R.h.fRF).setVisibility(8);
          gCi();
          break label684;
        }
        this.MZN.setVisibility(4);
        this.MZO.setVisibility(0);
        findViewById(R.h.fRF).setVisibility(0);
        if ((i & 0x1) == 1) {
          this.MZL.setCheck(true);
        }
        if ((i & 0x2) == 2) {
          this.MZM.setCheck(true);
        }
        gCj();
        break label684;
        localObject1 = com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), (CharSequence)localObject2, this.Nah.getTextSize());
        this.Nah.setText((CharSequence)localObject1);
        break label1066;
        Log.i("MicroMsg.SayHiWithSnsPermissionUI", "updateSayHiContextVisiable, needVerify = %s, sayHiContent= %s, isNeedSendSayHiContext= %s.", new Object[] { Boolean.valueOf(this.Nap), Boolean.valueOf(this.Nat), Boolean.valueOf(this.akiI) });
        if (this.akiI)
        {
          ((LinearLayout)this.Nah.getParent()).setVisibility(0);
          break label1102;
        }
        ((LinearLayout)this.Nah.getParent()).setVisibility(8);
        break label1102;
        label2261:
        setMMTitle(R.l.gSD);
        break label1198;
        label2271:
        if (!Util.isNullOrNil(this.nickName))
        {
          this.Nai.setHint(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), this.nickName, this.Nai.getTextSize()));
          this.Nai.setOnFocusChangeListener(new View.OnFocusChangeListener()
          {
            public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(27394);
              if (paramAnonymousBoolean)
              {
                if ((!Util.isNullOrNil(SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getHint())) && (Util.isNullOrNil(SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getText())))
                {
                  SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).setText(SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getHint());
                  SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).setHint(null);
                }
                SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).setSelection(SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getText().length());
                SayHiWithSnsPermissionUI.this.JVi = true;
              }
              AppMethodBeat.o(27394);
            }
          });
        }
        switch (this.pUt)
        {
        case 9: 
        case 12: 
        default: 
          i = 0;
        }
        while ((!this.Nap) && (i == 0))
        {
          localObject1 = com.tencent.mm.modelverify.d.bNH().byn(this.userName);
          if (localObject1 == null) {
            break;
          }
          localObject2 = com.tencent.mm.pluginsdk.ui.preference.b.c(this, (bp)localObject1);
          if ((Util.isNullOrNil(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).nUO)) || (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).nUO.equals(getString(R.l.gIf)))) {
            break;
          }
          localObject3 = getString(R.l.sendgreeting_content).substring(0, getString(R.l.sendgreeting_content).indexOf("%s"));
          localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).nUO;
          if (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).nUO.startsWith((String)localObject3)) {
            localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).nUO.substring(((String)localObject3).length());
          }
          this.Naj.setVisibility(0);
          this.Nak.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(getString(R.l.gCe, new Object[] { ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).nUO })), this.Nak.getTextSize()));
          localObject2 = new com.tencent.mm.pluginsdk.ui.span.q(getString(R.l.write_contact_remark));
          ((com.tencent.mm.pluginsdk.ui.span.q)localObject2).setSpan(new a((String)localObject1), 0, ((com.tencent.mm.pluginsdk.ui.span.q)localObject2).length(), 17);
          this.Nak.append(" ");
          this.Nak.append((CharSequence)localObject2);
          this.Nak.setMovementMethod(LinkMovementMethod.getInstance());
          this.pZy[3] = 3;
          break;
          localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(this.userName);
          if ((localObject1 == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWI())) || (((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWI().equals(this.Nai.getText().toString())))
          {
            i = 0;
          }
          else
          {
            this.Naj.setVisibility(0);
            this.Nak.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(getString(R.l.gCd, new Object[] { ((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWI() })), this.Nak.getTextSize()));
            localObject2 = new com.tencent.mm.pluginsdk.ui.span.q(getString(R.l.write_contact_remark));
            ((com.tencent.mm.pluginsdk.ui.span.q)localObject2).setSpan(new a(((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWI()), 0, ((com.tencent.mm.pluginsdk.ui.span.q)localObject2).length(), 17);
            this.Nak.append(" ");
            this.Nak.append((CharSequence)localObject2);
            this.Nak.setMovementMethod(LinkMovementMethod.getInstance());
            this.pZy[3] = 1;
            i = 1;
            continue;
            if ((Util.isNullOrNil(this.MoA)) || (this.MoA.equals(this.Nai.getText().toString())))
            {
              i = 0;
            }
            else
            {
              this.Naj.setVisibility(0);
              this.Nak.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(getString(R.l.gCc, new Object[] { this.MoA })), this.Nak.getTextSize()));
              localObject1 = new com.tencent.mm.pluginsdk.ui.span.q(getString(R.l.write_contact_remark));
              ((com.tencent.mm.pluginsdk.ui.span.q)localObject1).setSpan(new a(this.MoA), 0, ((com.tencent.mm.pluginsdk.ui.span.q)localObject1).length(), 17);
              this.Nak.append(" ");
              this.Nak.append((CharSequence)localObject1);
              this.Nak.setMovementMethod(LinkMovementMethod.getInstance());
              this.pZy[3] = 2;
              i = 1;
            }
          }
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(305622);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(305622);
      return;
    }
    ArrayList localArrayList;
    if (paramInt1 == 600)
    {
      localArrayList = paramIntent.getStringArrayListExtra("result_label_id_list");
      if (localArrayList != null) {
        break label503;
      }
      localArrayList = new ArrayList();
    }
    label503:
    for (;;)
    {
      Object localObject1 = com.tencent.mm.plugin.label.a.a.fTb().fSY();
      if ((!H(localArrayList, this.Nav)) && (!H((List)localObject1, this.Nau)))
      {
        AppMethodBeat.o(305622);
        return;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI", "cpan[All onActivityResult], labelLists: %s", new Object[] { localArrayList });
      if (localObject1 == null) {
        localObject1 = new ArrayList();
      }
      for (;;)
      {
        if (this.Nau == null) {
          this.Nau = new ArrayList();
        }
        Object localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if ((!this.Nau.contains(str)) && (!this.Naw.contains(str))) {
            this.Naw.add(str);
          }
        }
        this.Nau = ((List)localObject1);
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (this.Nau.contains(localObject2)) {
            this.Nau.remove(localObject2);
          }
        }
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.Nau);
        this.Nau.clear();
        this.Nau.addAll(localArrayList);
        this.Nau.addAll((Collection)localObject1);
        this.Nav.clear();
        this.Nav.addAll(localArrayList);
        localObject1 = paramIntent.getStringArrayListExtra("contact_search_label_new_list");
        if (localObject1 != null) {
          this.NaI.addAll((Collection)localObject1);
        }
        localObject1 = paramIntent.getStringArrayListExtra("contact_search_label_add_list");
        if (localObject1 != null) {
          this.JWF.addAll((Collection)localObject1);
        }
        localObject1 = paramIntent.getStringArrayListExtra("contact_select_label_add_list");
        if (localObject1 != null) {
          this.JWH.addAll((Collection)localObject1);
        }
        paramIntent = paramIntent.getStringArrayListExtra("contact_select_label_new_list");
        if (paramIntent != null) {
          this.JWG.addAll(paramIntent);
        }
        Log.i("MicroMsg.SayHiWithSnsPermissionUI", "cpan[All onActivityResult], labelLists: %s, mCurrentSelectLabelStrList: %s,mAllCanShowLabelStrList:%s.", new Object[] { localArrayList, this.Nav, this.Nau });
        jw(this.Nav);
        AppMethodBeat.o(305622);
        return;
        AppMethodBeat.o(305622);
        return;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27408);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(R.e.white));
    hideActionbarLine();
    initView();
    bh.aZW().a(30, this);
    bh.aZW().a(243, this);
    bh.aZW().a(853, this);
    AppMethodBeat.o(27408);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27411);
    bh.aZW().b(30, this);
    bh.aZW().b(243, this);
    bh.aZW().b(853, this);
    com.tencent.mm.plugin.report.service.h.OAn.b(14036, new Object[] { Integer.valueOf(this.pZy[0]), Integer.valueOf(this.pZy[1]), Integer.valueOf(this.pZy[2]), Integer.valueOf(this.pZy[3]), Integer.valueOf(this.pZy[4]), Integer.valueOf(this.pZy[5]), Integer.valueOf(this.pZy[6]), Integer.valueOf(this.pZy[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.d.MtP.aQj("ie_ver_usr");
    if (this.lKz != null) {
      this.lKz.close();
    }
    AppMethodBeat.o(27411);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(27417);
    if (paramInt == 4)
    {
      this.pZy[0] = 1;
      finish();
      Az(false);
      AppMethodBeat.o(27417);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(27417);
    return bool;
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(305629);
    Log.i("MicroMsg.SayHiWithSnsPermissionUI", "height:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.JWJ != null) && (this.JWJ.isRunning())) {
      this.JWJ.cancel();
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.JWf != null)
    {
      localObject1 = localObject2;
      if (this.JWf.isShowing())
      {
        localObject1 = localObject2;
        if (this.JWf.rootView != null)
        {
          localObject1 = localObject2;
          if ((this.JWf.rootView.getParent() instanceof View)) {
            localObject1 = (View)this.JWf.rootView.getParent();
          }
        }
      }
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(305629);
      return;
    }
    if (paramInt > 0) {
      if (((View)localObject1).getTranslationY() != 0.0F) {
        ((View)localObject1).setTranslationY(0.0F);
      }
    }
    for (this.JWJ = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { 0.0F, -paramInt });; this.JWJ = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { ((View)localObject1).getTranslationY(), 0.0F }))
    {
      this.JWJ.setDuration(200L);
      this.JWJ.setInterpolator(new androidx.g.a.a.b());
      this.JWJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(305674);
          Log.i("MicroMsg.SayHiWithSnsPermissionUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramAnonymousValueAnimator.getAnimatedValue("translationY")).floatValue()) });
          AppMethodBeat.o(305674);
        }
      });
      this.JWJ.start();
      AppMethodBeat.o(305629);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(305594);
    bh.aZW().b(635, this);
    if (this.lKz != null) {
      this.lKz.close();
    }
    super.onPause();
    AppMethodBeat.o(305594);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27409);
    super.onResume();
    bh.aZW().a(635, this);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(27409);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(27415);
    long l1 = System.currentTimeMillis();
    Log.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    try
    {
      eGg();
      if ((paramp instanceof v))
      {
        Log.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: getopCode: %s.", new Object[] { Integer.valueOf(((v)paramp).hId) });
        if (((paramInt1 != 0) || (paramInt2 != 0)) && (((v)paramp).hId == 1))
        {
          Log.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd:is MM_VERIFYUSER_ADDCONTACT return");
          return;
        }
        if (!this.Nas)
        {
          localObject1 = (v)paramp;
          if (!(localObject1 instanceof v)) {
            bool = false;
          }
          while (bool)
          {
            Log.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd:is needShowErrorDialog return");
            return;
            localObject2 = ((v)localObject1).iId();
            if (localObject2 == null)
            {
              Log.i("MicroMsg.AddContact", "needShowErrorDialog, response is null.");
              bool = false;
            }
            else if (((v)localObject1).hId != 1)
            {
              Log.i("MicroMsg.AddContact", "needShowErrorDialog, MM_VERIFYUSER_ADDCONTACT is not.");
              bool = false;
            }
            else
            {
              bool = com.tencent.mm.pluginsdk.ui.applet.a.a((v)localObject1, ((fwv)localObject2).abUH);
            }
          }
        }
      }
      else
      {
        Log.i("MicroMsg.SayHiWithSnsPermissionUI", "onSceneEnd: is no NetSceneVerifyUser.");
      }
      gCh();
      Log.i("MicroMsg.SayHiWithSnsPermissionUI", "sendrequest_second");
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label1409;
      }
      com.tencent.mm.ui.base.k.cZ(this, getString(R.l.sendrequest_send_success));
      com.tencent.mm.plugin.account.friend.model.ar.br(this.userName, 1);
      paramString = new tu();
      paramString.hXJ.username = this.userName;
      paramString.hXJ.type = 1;
      paramString.publish();
      if ((this.pUt == 17) && ((paramp instanceof v)))
      {
        long l2 = getIntent().getLongExtra("key_msg_id", 0L);
        if (l2 > 0L)
        {
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(l2);
          if (paramString.field_msgId > 0L)
          {
            paramString.jbX();
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(l2, paramString);
          }
        }
      }
      if (!this.Naq) {
        break label1085;
      }
      paramString = gCg();
      if (Util.isNullOrNil(paramString)) {
        break label1215;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI", "set temp remark of %s", new Object[] { this.userName });
      bh.bCz();
      localObject1 = com.tencent.mm.model.c.bzA().JE(this.userName);
      ((au)localObject1).AW(paramString);
      bh.bCz();
      Object localObject2 = com.tencent.mm.model.c.bzB().aMi(this.userName);
      ((cr)localObject2).field_encryptUsername = this.userName;
      ((cr)localObject2).field_conRemark = paramString;
      bh.bCz();
      com.tencent.mm.model.c.bzB().replace((IAutoDBItem)localObject2);
      bh.bCz();
      com.tencent.mm.model.c.bzA().aA((au)localObject1);
      this.pZy[2] = 1;
      if ((!Util.isNullOrNil(this.nickName)) && (!paramString.equals(this.nickName))) {
        this.pZy[5] = 1;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject1;
        boolean bool;
        label779:
        label855:
        Log.e("MicroMsg.SayHiWithSnsPermissionUI", "exception in onSceneEnd : " + paramString.getMessage());
        label926:
        label1085:
        label1215:
        return;
        label1183:
        this.pZy[2] = 2;
      }
    }
    finally
    {
      Log.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(27415);
    }
    paramString = new LinkedList();
    if ((paramp instanceof v))
    {
      paramInt1 = ((v)paramp).hId;
      paramString = ((v)paramp).XRr;
      if ((paramInt1 == 3) || ((paramp instanceof t)))
      {
        localObject1 = com.tencent.mm.modelverify.d.bNH().byn(this.userName);
        bh.bCz();
        paramp = com.tencent.mm.model.c.bzA().JE(this.userName);
        if ((paramString != null) && (paramString.contains(this.userName)))
        {
          paramString = paramp;
          if ((int)paramp.maN != 0) {
            break label1364;
          }
          paramp = com.tencent.mm.pluginsdk.ui.preference.b.a((bp)localObject1);
          paramp.setUsername(this.userName);
          bh.bCz();
          paramString = paramp;
          if (com.tencent.mm.model.c.bzA().aB(paramp)) {
            break label1364;
          }
          Log.e("MicroMsg.SayHiWithSnsPermissionUI", "canAddContact fail, insert fail");
        }
        bh.bCz();
        paramString = com.tencent.mm.model.c.bzA().JE(this.userName);
        paramp = new yv();
        paramp.ibZ.icb = true;
        paramp.ibZ.ica = false;
        paramp.ibZ.username = this.userName;
        paramp.publish();
        if (!this.MZL.afTT) {
          break label1402;
        }
        com.tencent.mm.model.ab.C(paramString);
        paramString = new yv();
        paramString.ibZ.icb = false;
        paramString.ibZ.ica = true;
        paramString.ibZ.username = this.userName;
        bool = aRZ(this.userName);
        paramString.ibZ.icc = bool;
        localObject1 = this.userName;
        if (this.MZM.afTT) {
          break label1746;
        }
        paramInt1 = 2;
        paramp = new LinkedList();
        paramp.add(localObject1);
        localObject1 = new sd();
        ((sd)localObject1).hVg.list = paramp;
        ((sd)localObject1).hVg.hHC = paramInt1;
        ((sd)localObject1).hVg.hVh = 5L;
        ((sd)localObject1).publish();
        paramString.publish();
        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false))
        {
          paramString = new Intent();
          paramString.putExtra("friend_message_transfer_username", this.userName);
          paramString.setAction("friend_message_accept_" + this.userName);
          paramString.putExtra("MMActivity.OverrideEnterAnimation", R.a.slide_right_in);
          paramString.putExtra("MMActivity.OverrideExitAnimation", R.a.slide_left_out);
          com.tencent.mm.br.c.b(this, "subapp", ".ui.friend.FMessageTransferUI", paramString);
        }
      }
      getIntent().putExtra("CONTACT_INFO_UI_SOURCE", 7);
      com.tencent.mm.plugin.profile.d.b(getIntent(), 1, 1, this.userName);
      setResult(-1, getIntent());
      if (this.akiI) {
        com.tencent.mm.plugin.profile.c.p(this.userName, gCf(), 1, this.pUt);
      }
      finish();
      Az(true);
      hm(1L);
      if ((this.NaM & 0x8) == 0) {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adfD, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(27415);
      return;
      if (!Util.isNullOrNil(this.nickName))
      {
        this.pZy[2] = 0;
        break;
      }
      if (!(paramp instanceof t)) {
        break label1741;
      }
      paramString.add(((t)paramp).psp);
      break label1741;
      label1364:
      com.tencent.mm.model.ab.I(paramString);
      bh.getNotification().aKV();
      com.tencent.mm.modelverify.d.bNI().fP(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.dz(this.userName, this.pUt);
      break label779;
      label1402:
      com.tencent.mm.model.ab.D(paramString);
      break label855;
      label1409:
      if ((paramInt1 == 4) && (paramInt2 == -302))
      {
        paramInt1 = 0;
        if (paramp.getType() == 30) {
          paramInt1 = ((v)paramp).hId;
        }
        Log.w("MicroMsg.SayHiWithSnsPermissionUI", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
        com.tencent.mm.ui.base.k.b(this, getString(R.l.contact_info_verify_outofdate_msg), getString(R.l.app_tip), getString(R.l.app_add), getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(305675);
            SayHiWithSnsPermissionUI.this.AA(true);
            AppMethodBeat.o(305675);
          }
        }, null);
      }
      else
      {
        if ((paramInt1 != 4) || (paramInt2 != -24) || (Util.isNullOrNil(paramString))) {
          break label1751;
        }
        Toast.makeText(this, paramString, 1).show();
      }
    }
    for (;;)
    {
      label1537:
      if (!Util.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.k.a(this, paramString, "", getString(R.l.app_ok), null);
        break label1183;
      }
      label1741:
      label1746:
      label1751:
      do
      {
        do
        {
          if ((this.Nap) && ((paramInt2 == -24) || (paramInt2 == -34)))
          {
            Toast.makeText(this, R.l.fmessage_request_too_offen, 0).show();
            break label1183;
          }
          if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.MZP))
          {
            this.MZQ = true;
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adfD, Integer.valueOf(1));
            if (!Util.isNullOrNil(paramString)) {
              ((TextView)findViewById(R.h.fYF)).setText(paramString);
            }
            evt();
            paramp = new g.a(this);
            paramp.bDE(paramString).NF(true).bDJ(getString(R.l.gSe)).aEX(R.l.gSf);
            paramp.c(new SayHiWithSnsPermissionUI.4(this)).show();
            break label1183;
          }
          Toast.makeText(this, R.l.sendrequest_send_fail, 0).show();
          Log.i("MicroMsg.SayHiWithSnsPermissionUI", "[onCreate] sendrequest_send_fail");
          break label1183;
          paramInt1 = 0;
          break;
          paramInt1 = 1;
          break label926;
        } while (paramInt1 != 4);
        if (paramInt2 == -2) {
          break label1537;
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
    AppMethodBeat.i(305599);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(305599);
  }
  
  final class a
    extends ClickableSpan
  {
    public String remark;
    
    public a(String paramString)
    {
      this.remark = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(27405);
      paramView = Util.nullAsNil(com.tencent.mm.ui.tools.b.c.bCI(this.remark));
      if ((paramView != null) && (this.remark != null) && (paramView.length() < this.remark.length())) {
        Toast.makeText(SayHiWithSnsPermissionUI.this, SayHiWithSnsPermissionUI.this.getString(R.l.remark_name_mast_count), 0).show();
      }
      SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).setText(com.tencent.mm.pluginsdk.ui.span.p.b(SayHiWithSnsPermissionUI.this, paramView, SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).getTextSize()));
      SayHiWithSnsPermissionUI.a(SayHiWithSnsPermissionUI.this).setSelection(paramView.length());
      SayHiWithSnsPermissionUI.u(SayHiWithSnsPermissionUI.this).setVisibility(8);
      SayHiWithSnsPermissionUI.p(SayHiWithSnsPermissionUI.this)[4] = 1;
      AppMethodBeat.o(27405);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(27406);
      paramTextPaint.setColor(SayHiWithSnsPermissionUI.this.getResources().getColor(R.e.blue_text_color));
      paramTextPaint.setUnderlineText(false);
      AppMethodBeat.o(27406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI
 * JD-Core Version:    0.7.0.1
 */