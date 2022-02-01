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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
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
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
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

public class SayHiWithSnsPermissionUI3
  extends MMActivity
  implements com.tencent.mm.am.h, com.tencent.mm.ui.tools.h
{
  String His;
  private boolean JVi;
  private HashSet<String> JWF;
  private HashSet<String> JWG;
  private HashSet<String> JWH;
  private ObjectAnimator JWJ;
  private m JWf;
  private View JWm;
  private MMSwitchBtn MZL;
  private MMSwitchBtn MZM;
  private boolean MZP;
  private boolean MZQ;
  private TextView MZY;
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
  private ImageView Nbo;
  private ImageView Nbp;
  private Boolean Nbq;
  private int Nbr;
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
  EditText tID;
  String userName;
  
  public SayHiWithSnsPermissionUI3()
  {
    AppMethodBeat.i(305697);
    this.lzP = null;
    this.pZy = new int[8];
    this.MZP = false;
    this.MZQ = false;
    this.Nar = false;
    this.Nas = false;
    this.Nau = new ArrayList();
    this.Nav = new ArrayList();
    this.Naw = new ArrayList();
    this.Nat = false;
    this.akiI = false;
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
    this.Nbr = 0;
    this.NaP = 0;
    this.JWJ = null;
    this.pRv = null;
    AppMethodBeat.o(305697);
  }
  
  private void AB(boolean paramBoolean)
  {
    AppMethodBeat.i(305718);
    this.Nbp.setVisibility(0);
    this.Nbo.setVisibility(0);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.downloader_app.b.i(this.Nbp, "checkbox_cell_on");
      com.tencent.mm.plugin.downloader_app.b.i(this.Nbo, "checkbox_cell_off");
      this.Nbp.setTag(Boolean.TRUE);
      this.Nbo.setTag(Boolean.FALSE);
      AppMethodBeat.o(305718);
      return;
    }
    com.tencent.mm.plugin.downloader_app.b.i(this.Nbp, "checkbox_cell_off");
    com.tencent.mm.plugin.downloader_app.b.i(this.Nbo, "checkbox_cell_on");
    this.Nbp.setTag(Boolean.FALSE);
    this.Nbo.setTag(Boolean.TRUE);
    AppMethodBeat.o(305718);
  }
  
  private void Az(final boolean paramBoolean)
  {
    AppMethodBeat.i(305715);
    com.tencent.threadpool.h.ahAA.bn(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(305565);
        int k;
        int m;
        if (SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this))
        {
          k = 1;
          if (!Util.isNullOrNil(SayHiWithSnsPermissionUI3.A(SayHiWithSnsPermissionUI3.this))) {
            break label401;
          }
          m = 3;
        }
        for (;;)
        {
          label33:
          int j;
          if (SayHiWithSnsPermissionUI3.D(SayHiWithSnsPermissionUI3.this)) {
            j = 6;
          }
          for (;;)
          {
            label46:
            int i;
            switch (SayHiWithSnsPermissionUI3.m(SayHiWithSnsPermissionUI3.this))
            {
            default: 
              i = 11;
            }
            int i1;
            StringBuilder localStringBuilder1;
            for (;;)
            {
              localObject = SayHiWithSnsPermissionUI3.F(SayHiWithSnsPermissionUI3.this);
              i1 = ((List)localObject).size();
              localStringBuilder1 = new StringBuilder();
              i2 = SayHiWithSnsPermissionUI3.G(SayHiWithSnsPermissionUI3.this).size();
              if (i2 <= 0) {
                break label589;
              }
              n = 0;
              while (n < i2)
              {
                localStringBuilder1.append((String)SayHiWithSnsPermissionUI3.G(SayHiWithSnsPermissionUI3.this).get(n));
                if (n < i2 - 1) {
                  localStringBuilder1.append("#");
                }
                n += 1;
              }
              if (paramBoolean)
              {
                k = 2;
                break;
              }
              k = 3;
              break;
              label401:
              if ((!SayHiWithSnsPermissionUI3.A(SayHiWithSnsPermissionUI3.this).equals(SayHiWithSnsPermissionUI3.B(SayHiWithSnsPermissionUI3.this))) && (!SayHiWithSnsPermissionUI3.A(SayHiWithSnsPermissionUI3.this).equals(SayHiWithSnsPermissionUI3.C(SayHiWithSnsPermissionUI3.this)))) {
                break label862;
              }
              m = 2;
              break label33;
              if ((SayHiWithSnsPermissionUI3.E(SayHiWithSnsPermissionUI3.this) & 0x8) != 0)
              {
                j = 5;
                break label46;
              }
              if (((SayHiWithSnsPermissionUI3.E(SayHiWithSnsPermissionUI3.this) & 0x1) != 0) && ((SayHiWithSnsPermissionUI3.E(SayHiWithSnsPermissionUI3.this) & 0x2) != 0))
              {
                j = 4;
                break label46;
              }
              if ((SayHiWithSnsPermissionUI3.E(SayHiWithSnsPermissionUI3.this) & 0x2) != 0)
              {
                j = 3;
                break label46;
              }
              if ((SayHiWithSnsPermissionUI3.E(SayHiWithSnsPermissionUI3.this) & 0x1) == 0) {
                break label857;
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
            label589:
            StringBuilder localStringBuilder2 = new StringBuilder();
            int i2 = ((List)localObject).size();
            if (i2 > 0)
            {
              n = 0;
              while (n < i2)
              {
                localStringBuilder2.append((String)((List)localObject).get(n));
                if (n < i2 - 1) {
                  localStringBuilder2.append("#");
                }
                n += 1;
              }
            }
            Object localObject = localStringBuilder2.toString();
            bh.bCz();
            int n = com.tencent.mm.model.c.bzA().d(com.tencent.mm.model.ab.oko, new String[] { z.bAM(), "weixin", "helper_entry", "filehelper" });
            com.tencent.mm.plugin.report.service.h.OAn.b(18713, new Object[] { SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - SayHiWithSnsPermissionUI3.H(SayHiWithSnsPermissionUI3.this)), Integer.valueOf(n), Integer.valueOf(SayHiWithSnsPermissionUI3.I(SayHiWithSnsPermissionUI3.this)), localObject, localStringBuilder1, Integer.valueOf(i1), Integer.valueOf(SayHiWithSnsPermissionUI3.this.NaP) });
            AppMethodBeat.o(305565);
            return;
            label857:
            j = 0;
          }
          label862:
          m = 1;
        }
      }
    });
    AppMethodBeat.o(305715);
  }
  
  private static boolean H(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(305702);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.addAll(paramList1);
    localArrayList2.addAll(paramList2);
    Collections.sort(localArrayList1);
    Collections.sort(localArrayList2);
    if (localArrayList1.equals(localArrayList2))
    {
      AppMethodBeat.o(305702);
      return false;
    }
    AppMethodBeat.o(305702);
    return true;
  }
  
  private static boolean aRZ(String paramString)
  {
    AppMethodBeat.i(305711);
    boolean bool = com.tencent.mm.plugin.sns.c.q.Qkl.aRZ(paramString);
    AppMethodBeat.o(305711);
    return bool;
  }
  
  private void eGg()
  {
    AppMethodBeat.i(305709);
    Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "dismissTipDialog");
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    AppMethodBeat.o(305709);
  }
  
  private String gCf()
  {
    AppMethodBeat.i(305705);
    String str = this.Nah.getText().toString().trim();
    if (str.length() <= 50)
    {
      AppMethodBeat.o(305705);
      return str;
    }
    str = str.substring(0, 50);
    AppMethodBeat.o(305705);
    return str;
  }
  
  private String gCg()
  {
    AppMethodBeat.i(305707);
    String str = "";
    if (this.Nai.getText() != null) {
      str = this.Nai.getText().toString();
    }
    if (!Util.isNullOrNil(str))
    {
      if (str.length() <= 50)
      {
        AppMethodBeat.o(305707);
        return str;
      }
      str = str.substring(0, 50);
      AppMethodBeat.o(305707);
      return str;
    }
    AppMethodBeat.o(305707);
    return str;
  }
  
  private void gCh()
  {
    AppMethodBeat.i(305710);
    if (this.Nap)
    {
      String str = this.Nah.getText().toString().trim();
      if ((Util.isNullOrNil(str)) || (str.equals(this.NaJ)) || (!Util.isNullOrNil(this.chatroomName)))
      {
        bh.bCz();
        com.tencent.mm.model.c.ban().B(294913, "");
        AppMethodBeat.o(305710);
        return;
      }
      bh.bCz();
      com.tencent.mm.model.c.ban().B(294913, str);
    }
    AppMethodBeat.o(305710);
  }
  
  private void gCk()
  {
    AppMethodBeat.i(305723);
    ImageView localImageView;
    if (this.Nbp != null)
    {
      localImageView = this.Nbp;
      if (!gCo())
      {
        str = getResources().getString(R.l.say_permission_contentdes_unselect);
        localImageView.setContentDescription(str);
      }
    }
    else if (this.Nbo != null)
    {
      localImageView = this.Nbo;
      if (gCn()) {
        break label97;
      }
    }
    label97:
    for (String str = getResources().getString(R.l.say_permission_contentdes_unselect);; str = getResources().getString(R.l.say_permission_contentdes_select))
    {
      localImageView.setContentDescription(str);
      AppMethodBeat.o(305723);
      return;
      str = getResources().getString(R.l.say_permission_contentdes_select);
      break;
    }
  }
  
  private boolean gCn()
  {
    AppMethodBeat.i(305719);
    boolean bool = ((Boolean)this.Nbo.getTag()).booleanValue();
    AppMethodBeat.o(305719);
    return bool;
  }
  
  private boolean gCo()
  {
    AppMethodBeat.i(305721);
    boolean bool = ((Boolean)this.Nbp.getTag()).booleanValue();
    AppMethodBeat.o(305721);
    return bool;
  }
  
  private void jw(List<String> paramList)
  {
    AppMethodBeat.i(305701);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.Naz.setText("");
      AppMethodBeat.o(305701);
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
    AppMethodBeat.o(305701);
  }
  
  public final void AA(boolean paramBoolean)
  {
    AppMethodBeat.i(306123);
    Object localObject = new Intent(this, SayHiWithSnsPermissionUI3.class);
    ((Intent)localObject).putExtras(getIntent().getExtras());
    ((Intent)localObject).putExtra("Contact_IsForceVerifyFriend", true);
    if (gCn()) {}
    for (int i = 8;; i = 1)
    {
      if (paramBoolean) {
        ((Intent)localObject).putExtra("sayhi_with_sns_perm_send_verify", true);
      }
      ((Intent)localObject).putExtra("Contact_default_permission", i);
      ((Intent)localObject).putExtra("Contact_RemarkName", gCg());
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3", "gotoSelfPageWithoutDialog", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3", "gotoSelfPageWithoutDialog", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(306123);
      return;
    }
  }
  
  protected final void gCp()
  {
    AppMethodBeat.i(306115);
    this.NaA.setTextColor(getResources().getColor(a.d.color_btn_text_selector));
    this.NaA.setBackground(getDrawable(a.f.btn_solid_green));
    AppMethodBeat.o(306115);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(305952);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpm, 0) != 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = R.i.gnH;
      AppMethodBeat.o(305952);
      return i;
    }
    i = R.i.gnI;
    AppMethodBeat.o(305952);
    return i;
  }
  
  public final void hm(final long paramLong)
  {
    AppMethodBeat.i(306128);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(305544);
        ma localma = new ma();
        if (SayHiWithSnsPermissionUI3.F(SayHiWithSnsPermissionUI3.this) == null) {
          SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, new ArrayList());
        }
        if (SayHiWithSnsPermissionUI3.L(SayHiWithSnsPermissionUI3.this) == null) {
          SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, new ArrayList());
        }
        if (SayHiWithSnsPermissionUI3.L(SayHiWithSnsPermissionUI3.this) == null) {
          SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, new ArrayList());
        }
        Object localObject1 = SayHiWithSnsPermissionUI3.F(SayHiWithSnsPermissionUI3.this);
        localma.uI(SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this));
        long l;
        Object localObject2;
        int i;
        label142:
        String str;
        if (SayHiWithSnsPermissionUI3.M(SayHiWithSnsPermissionUI3.this))
        {
          l = 1L;
          localma.jaJ = l;
          localObject2 = ((List)localObject1).iterator();
          i = 0;
          if (!((Iterator)localObject2).hasNext()) {
            break label192;
          }
          str = (String)((Iterator)localObject2).next();
          if (!SayHiWithSnsPermissionUI3.N(SayHiWithSnsPermissionUI3.this).contains(str)) {
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
            if (SayHiWithSnsPermissionUI3.O(SayHiWithSnsPermissionUI3.this).contains(str)) {
              l += 1L;
            }
          }
          localma.jaN = l;
          localObject2 = ((List)localObject1).iterator();
          int j = 0;
          if (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (!SayHiWithSnsPermissionUI3.P(SayHiWithSnsPermissionUI3.this).contains(str)) {
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
              if (!SayHiWithSnsPermissionUI3.Q(SayHiWithSnsPermissionUI3.this).contains(str)) {
                break label1004;
              }
              k += 1;
            }
            for (;;)
            {
              break;
              localma.jaK = k;
              localma.iGM = (System.currentTimeMillis() - SayHiWithSnsPermissionUI3.H(SayHiWithSnsPermissionUI3.this));
              localma.jaR = SayHiWithSnsPermissionUI3.R(SayHiWithSnsPermissionUI3.this);
              localma.jaS = paramLong;
              localma.jaO = SayHiWithSnsPermissionUI3.S(SayHiWithSnsPermissionUI3.this);
              int n = 0;
              localObject2 = ((List)localObject1).iterator();
              int m = 0;
              if (((Iterator)localObject2).hasNext())
              {
                str = (String)((Iterator)localObject2).next();
                if (SayHiWithSnsPermissionUI3.L(SayHiWithSnsPermissionUI3.this).contains(str)) {
                  break label1001;
                }
                m += 1;
              }
              for (;;)
              {
                break;
                localObject2 = SayHiWithSnsPermissionUI3.L(SayHiWithSnsPermissionUI3.this).iterator();
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
                  if (SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this) != null)
                  {
                    localObject1 = localObject2;
                    if (SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).getText() != null)
                    {
                      localObject1 = localObject2;
                      if (SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).getText().toString() != null) {
                        localObject1 = SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).getText().toString().trim();
                      }
                    }
                  }
                  localObject2 = localObject1;
                  if (localObject1 == null) {
                    localObject2 = "";
                  }
                  if (!com.tencent.mm.platformtools.ab.isNullOrNil(SayHiWithSnsPermissionUI3.T(SayHiWithSnsPermissionUI3.this))) {
                    if (SayHiWithSnsPermissionUI3.T(SayHiWithSnsPermissionUI3.this).equals(localObject2)) {
                      SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 3);
                    }
                  }
                  for (;;)
                  {
                    localma.jaT = SayHiWithSnsPermissionUI3.W(SayHiWithSnsPermissionUI3.this);
                    localma.jaQ = m;
                    localma.jaP = n;
                    localma.bMH();
                    Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "22865 setAddedLabelCnt = " + m + ",setRemovedLabelCnt = " + n + ",oriLabelCnt = " + SayHiWithSnsPermissionUI3.S(SayHiWithSnsPermissionUI3.this) + ",opResult = " + paramLong + ",totalLabelCnt = " + SayHiWithSnsPermissionUI3.R(SayHiWithSnsPermissionUI3.this) + ",selectNewLabelCnt = " + k + ",selectAddLabelCnt = " + j + ",addRemarkType = " + SayHiWithSnsPermissionUI3.W(SayHiWithSnsPermissionUI3.this) + ",scene= 2,newLebalCountBySearch = " + i + ",searchAddLabelCnt = " + l);
                    AppMethodBeat.o(305544);
                    return;
                    SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 2);
                    continue;
                    if (!SayHiWithSnsPermissionUI3.U(SayHiWithSnsPermissionUI3.this)) {
                      SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 3);
                    } else if (!com.tencent.mm.platformtools.ab.isNullOrNil(SayHiWithSnsPermissionUI3.V(SayHiWithSnsPermissionUI3.this)))
                    {
                      if (SayHiWithSnsPermissionUI3.V(SayHiWithSnsPermissionUI3.this).equals(localObject2)) {
                        SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 1);
                      } else if (Util.isNullOrNil((String)localObject2)) {
                        SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 3);
                      } else {
                        SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 2);
                      }
                    }
                    else if (((String)localObject2).equals(SayHiWithSnsPermissionUI3.V(SayHiWithSnsPermissionUI3.this))) {
                      SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 3);
                    } else {
                      SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 2);
                    }
                  }
                }
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(306128);
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(306138);
    HashSet localHashSet = new HashSet(super.importUIComponents());
    localHashSet.add(com.tencent.mm.plugin.profile.ui.a.d.class);
    AppMethodBeat.o(306138);
    return localHashSet;
  }
  
  public void initView()
  {
    AppMethodBeat.i(306038);
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
    if ((com.tencent.mm.plugin.profile.c.aRQ(this.userName)) && (!getIntent().getBooleanExtra("Contact_IsForceVerifyFriend", false)))
    {
      bool = true;
      this.Nat = bool;
      if ((this.Nat) || (!this.Nap)) {
        break label1633;
      }
    }
    label308:
    label379:
    int i;
    label647:
    label676:
    label723:
    Object localObject3;
    Object localObject2;
    Object localObject4;
    label1120:
    label1633:
    for (boolean bool = true;; bool = false)
    {
      this.akiI = bool;
      if (!au.bwO(this.userName)) {
        break label1638;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "initLabelPanelAll, isOpenIM, userName: %s.", new Object[] { this.userName });
      localObject1 = findViewById(R.h.fMg);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "isCurrentHappenChatting = " + this.Nat);
      if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("MMSocialBlackListFlag", 1) != 1) {
        break label2019;
      }
      bool = true;
      this.MZP = bool;
      if (!this.MZP) {
        findViewById(R.h.fYH).setVisibility(8);
      }
      com.tencent.mm.kernel.h.baF();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.userName);
      if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adfD, 0) != 1) {
        break label2024;
      }
      bool = true;
      this.Nar = bool;
      this.MZL = ((MMSwitchBtn)findViewById(R.h.fRD).findViewById(R.h.fRH));
      getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
      this.MZL.setCheck(((au)localObject1).aSL());
      this.Nbo = ((ImageView)findViewById(R.h.fYE));
      this.Nbp = ((ImageView)findViewById(R.h.fXP));
      this.Nbp.setVisibility(0);
      this.Nbo.setVisibility(0);
      com.tencent.mm.plugin.downloader_app.b.i(this.Nbp, "checkbox_cell_off");
      com.tencent.mm.plugin.downloader_app.b.i(this.Nbo, "checkbox_cell_off");
      this.Nbp.setTag(Boolean.FALSE);
      this.Nbo.setTag(Boolean.FALSE);
      this.MZY = ((TextView)findViewById(R.h.fYF));
      this.Nan = ((TextView)findViewById(R.h.fYJ));
      this.MZM = ((MMSwitchBtn)findViewById(R.h.fXO).findViewById(R.h.fRJ));
      bool = aRZ(this.userName);
      this.MZM.setCheck(bool);
      findViewById(R.h.fuN).setOnClickListener(new SayHiWithSnsPermissionUI3.1(this));
      i = ((com.tencent.mm.autogen.b.az)localObject1).sex;
      Log.d("MicroMsg.SayHiWithSnsPermissionUI3", "sex:%d", new Object[] { Integer.valueOf(i) });
      this.Nal = ((TextView)findViewById(R.h.fRI));
      if (i != 1) {
        break label2029;
      }
      this.Nal.setText(R.l.sns_outside_permiss_male);
      this.Nam = ((TextView)findViewById(R.h.fRK));
      if (i != 1) {
        break label2047;
      }
      this.Nam.setText(R.l.sns_black_permiss_male);
      bool = au.bwO(this.userName);
      this.Nas = bool;
      if (!bool) {
        break label2065;
      }
      findViewById(R.h.fYH).setVisibility(8);
      localObject1 = findViewById(R.h.fRF);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (this.Nas) {
        this.MZM.setCheck(true);
      }
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
            AppMethodBeat.i(305533);
            if (SayHiWithSnsPermissionUI3.this.NaK[0] != 0)
            {
              SayHiWithSnsPermissionUI3.this.NaK[0] = false;
              com.tencent.mm.plugin.normsg.a.d.MtP.aQh("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.d.MtP.aQi("ie_ver_usr");
            AppMethodBeat.o(305533);
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
          break label3002;
        }
        localObject1 = ((String)localObject1).substring(0, 50 - ((String)localObject4).length());
        label874:
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
              Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localau.field_nickname });
              localObject2 = com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), getResources().getString(R.l.sendgreeting_content_chatroom, new Object[] { localau.field_nickname, localObject2 }), this.Nah.getTextSize());
              this.NaJ = ((CharSequence)localObject2);
            }
          }
        }
        if (Util.isNullOrNil(this.NaJ)) {
          this.NaJ = com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), String.format((String)localObject4, new Object[] { localObject1 }), this.Nah.getTextSize());
        }
        if (!Util.isNullOrNil((CharSequence)localObject2)) {
          break label2192;
        }
        this.Nah.setText(this.NaJ);
        this.Nah.clearFocus();
      }
      if ((this.Nah != null) && ((this.Nah.getParent() instanceof LinearLayout))) {
        break label2220;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "updateSayHiContextVisiable");
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
          break label2305;
        }
        setMMTitle(R.l.gSA);
        this.pZy[0] = 1;
        label1252:
        if (Util.isNullOrNil(this.dYO)) {
          break label2315;
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
      localObject1 = getString(R.l.app_send);
      if (!this.Nap) {
        localObject1 = getString(R.l.app_finish);
      }
      if (!this.Nat) {
        break label2999;
      }
      localObject1 = getString(R.l.app_finish);
      localObject2 = com.tencent.mm.plugin.normsg.a.c.aeT(3);
      this.NaA = ((Button)findViewById(R.h.finish_btn));
      this.NaA.setText((CharSequence)localObject1);
      this.NaA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(305548);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
          if ((SayHiWithSnsPermissionUI3.g(SayHiWithSnsPermissionUI3.this) != null) && (SayHiWithSnsPermissionUI3.g(SayHiWithSnsPermissionUI3.this).isShowing()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(305548);
            return;
          }
          if (SayHiWithSnsPermissionUI3.this.NaL[0] != 0) {
            SayHiWithSnsPermissionUI3.this.NaL[0] = false;
          }
          while ((!SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this)) && (!SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this)) && (SayHiWithSnsPermissionUI3.h(SayHiWithSnsPermissionUI3.this)))
          {
            SayHiWithSnsPermissionUI3.i(SayHiWithSnsPermissionUI3.this);
            SayHiWithSnsPermissionUI3.j(SayHiWithSnsPermissionUI3.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(305548);
            return;
            com.tencent.mm.plugin.normsg.a.d.MtP.aJ("ce_ver_usr", "<VerifyUsr>", this.NaW);
            paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
            com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_ver_usr", paramAnonymousView);
            com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_ver_usr");
          }
          com.tencent.mm.plugin.normsg.a.d.MtP.gq(this.NaW, 3);
          final LinkedList localLinkedList2;
          final LinkedList localLinkedList1;
          final HashMap localHashMap;
          int j;
          if (SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this))
          {
            localLinkedList2 = new LinkedList();
            localLinkedList2.add(SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this));
            localLinkedList1 = new LinkedList();
            localLinkedList1.add(Integer.valueOf(SayHiWithSnsPermissionUI3.m(SayHiWithSnsPermissionUI3.this)));
            localObject1 = SayHiWithSnsPermissionUI3.n(SayHiWithSnsPermissionUI3.this);
            localHashMap = new HashMap();
            if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this)) {
              break label1118;
            }
            if (!SayHiWithSnsPermissionUI3.o(SayHiWithSnsPermissionUI3.this).afTT) {
              break label1113;
            }
            j = 1;
            i = j;
            if (!SayHiWithSnsPermissionUI3.p(SayHiWithSnsPermissionUI3.this).afTT) {}
          }
          label843:
          label1113:
          label1118:
          for (int i = j | 0x2;; i = 0)
          {
            j = i;
            if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this)) {
              j = i | 0x8;
            }
            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, j);
            localHashMap.put(SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this), Integer.valueOf(j));
            Log.d("MicroMsg.SayHiWithSnsPermissionUI3", "select sns permission, %s", new Object[] { Integer.valueOf(j) });
            Object localObject2;
            if (SayHiWithSnsPermissionUI3.q(SayHiWithSnsPermissionUI3.this))
            {
              paramAnonymousView = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra(f.e.adwe);
              paramAnonymousView = new r(SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this), (String)localObject1, paramAnonymousView, j);
              bh.aZW().a(paramAnonymousView, 0);
              localObject1 = SayHiWithSnsPermissionUI3.this;
              localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
              SayHiWithSnsPermissionUI3.this.getString(R.l.app_tip);
              SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, com.tencent.mm.ui.base.k.a((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(305493);
                  bh.aZW().a(paramAnonymousView);
                  AppMethodBeat.o(305493);
                }
              }));
            }
            do
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(305548);
              return;
              Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "addTextOptionMenu:send addcontact.");
              final String str1 = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_user_name");
              final String str2 = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_nick_name");
              localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(SayHiWithSnsPermissionUI3.this, null);
              if (SayHiWithSnsPermissionUI3.r(SayHiWithSnsPermissionUI3.this)) {}
              for (paramAnonymousView = "";; paramAnonymousView = (View)localObject1)
              {
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).content = paramAnonymousView;
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).pk(str1, str2);
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).YaW = localHashMap;
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).chatroomName = SayHiWithSnsPermissionUI3.s(SayHiWithSnsPermissionUI3.this);
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).YaM = new a.b()
                {
                  public final boolean n(final String paramAnonymous2String1, int paramAnonymous2Int, String paramAnonymous2String2)
                  {
                    AppMethodBeat.i(305498);
                    Object localObject;
                    if (paramAnonymous2Int == -4000)
                    {
                      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "addTextOptionMenu:send addcontact.");
                      localObject = new com.tencent.mm.pluginsdk.ui.applet.a(SayHiWithSnsPermissionUI3.this, null);
                      if (SayHiWithSnsPermissionUI3.r(SayHiWithSnsPermissionUI3.this))
                      {
                        paramAnonymous2String1 = "";
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).content = paramAnonymous2String1;
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).pk(str1, str2);
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).YaW = localHashMap;
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).chatroomName = SayHiWithSnsPermissionUI3.s(SayHiWithSnsPermissionUI3.this);
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
                            AppMethodBeat.i(305620);
                            SayHiWithSnsPermissionUI3.t(SayHiWithSnsPermissionUI3.this);
                            AppMethodBeat.o(305620);
                          }
                          
                          public final void gCm()
                          {
                            SayHiWithSnsPermissionUI3 localSayHiWithSnsPermissionUI3 = SayHiWithSnsPermissionUI3.this;
                            localSayHiWithSnsPermissionUI3.NaP += 1;
                          }
                        };
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).YaZ = paramAnonymous2String2;
                        com.tencent.mm.kernel.h.baF();
                        paramAnonymous2String1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this));
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).a(SayHiWithSnsPermissionUI3.this, paramAnonymous2String1, SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this), localLinkedList1);
                        SayHiWithSnsPermissionUI3.u(SayHiWithSnsPermissionUI3.this);
                        paramAnonymous2String1 = SayHiWithSnsPermissionUI3.this;
                        paramAnonymous2String2 = SayHiWithSnsPermissionUI3.this.getContext();
                        SayHiWithSnsPermissionUI3.this.getString(R.l.app_tip);
                        SayHiWithSnsPermissionUI3.a(paramAnonymous2String1, com.tencent.mm.ui.base.k.a(paramAnonymous2String2, SayHiWithSnsPermissionUI3.this.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
                        {
                          public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                          {
                            AppMethodBeat.i(305618);
                            this.Nbc.iKU();
                            AppMethodBeat.o(305618);
                          }
                        }));
                      }
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(305498);
                      return true;
                      paramAnonymous2String1 = this.val$content;
                      break;
                      if (SayHiWithSnsPermissionUI3.r(SayHiWithSnsPermissionUI3.this))
                      {
                        paramAnonymous2String1 = SayHiWithSnsPermissionUI3.this;
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
                          Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymous2Int), paramAnonymous2String1.His });
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
                          paramAnonymous2String2 = new SayHiWithSnsPermissionUI3.12(paramAnonymous2String1);
                          localObject = new SayHiWithSnsPermissionUI3.13(paramAnonymous2String1);
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
                      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "dealAddContactError, resend request ver.");
                      paramAnonymous2String2 = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_user_name");
                      localObject = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_nick_name");
                      paramAnonymous2String1 = new com.tencent.mm.pluginsdk.ui.applet.ab(SayHiWithSnsPermissionUI3.this, null);
                      paramAnonymous2String1.content = this.val$content;
                      paramAnonymous2String1.pg(paramAnonymous2String2, (String)localObject);
                      paramAnonymous2String1.YaW = localHashMap;
                      paramAnonymous2String1.chatroomName = SayHiWithSnsPermissionUI3.s(SayHiWithSnsPermissionUI3.this);
                      paramAnonymous2String1.S(localLinkedList2, localLinkedList1);
                      SayHiWithSnsPermissionUI3.u(SayHiWithSnsPermissionUI3.this);
                      paramAnonymous2String2 = SayHiWithSnsPermissionUI3.this;
                      localObject = SayHiWithSnsPermissionUI3.this.getContext();
                      SayHiWithSnsPermissionUI3.this.getString(R.l.app_tip);
                      SayHiWithSnsPermissionUI3.a(paramAnonymous2String2, com.tencent.mm.ui.base.k.a((Context)localObject, SayHiWithSnsPermissionUI3.this.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
                      {
                        public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                        {
                          AppMethodBeat.i(305613);
                          paramAnonymous2String1.iKU();
                          AppMethodBeat.o(305613);
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
                    AppMethodBeat.i(305489);
                    SayHiWithSnsPermissionUI3.t(SayHiWithSnsPermissionUI3.this);
                    AppMethodBeat.o(305489);
                  }
                  
                  public final void gCm()
                  {
                    SayHiWithSnsPermissionUI3 localSayHiWithSnsPermissionUI3 = SayHiWithSnsPermissionUI3.this;
                    localSayHiWithSnsPermissionUI3.NaP += 1;
                  }
                };
                com.tencent.mm.kernel.h.baF();
                paramAnonymousView = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this));
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).a(SayHiWithSnsPermissionUI3.this, paramAnonymousView, SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this), localLinkedList1);
                SayHiWithSnsPermissionUI3.u(SayHiWithSnsPermissionUI3.this);
                paramAnonymousView = SayHiWithSnsPermissionUI3.this;
                localObject1 = SayHiWithSnsPermissionUI3.this.getContext();
                SayHiWithSnsPermissionUI3.this.getString(R.l.app_tip);
                SayHiWithSnsPermissionUI3.a(paramAnonymousView, com.tencent.mm.ui.base.k.a((Context)localObject1, SayHiWithSnsPermissionUI3.this.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(305488);
                    this.Nbc.iKU();
                    AppMethodBeat.o(305488);
                  }
                }));
                break;
              }
            } while (!SayHiWithSnsPermissionUI3.v(SayHiWithSnsPermissionUI3.this));
            paramAnonymousView = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("Verify_ticket");
            if (!SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this)) {
              if (SayHiWithSnsPermissionUI3.o(SayHiWithSnsPermissionUI3.this).afTT)
              {
                j = 1;
                i = j;
                if (!SayHiWithSnsPermissionUI3.p(SayHiWithSnsPermissionUI3.this).afTT) {}
              }
            }
            for (i = j | 0x2;; i = 0)
            {
              if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this)) {
                i |= 0x8;
              }
              for (;;)
              {
                SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, i);
                Log.d("MicroMsg.SayHiWithSnsPermissionUI3", "select sns permission, %s", new Object[] { Integer.valueOf(i) });
                if (SayHiWithSnsPermissionUI3.q(SayHiWithSnsPermissionUI3.this))
                {
                  paramAnonymousView = new t(SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this), paramAnonymousView, i);
                  bh.aZW().a(paramAnonymousView, 0);
                  localObject1 = SayHiWithSnsPermissionUI3.this;
                  localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
                  SayHiWithSnsPermissionUI3.this.getString(R.l.app_tip);
                  SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, com.tencent.mm.ui.base.k.a((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(R.l.gBk), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(305526);
                      bh.aZW().a(paramAnonymousView);
                      AppMethodBeat.o(305526);
                    }
                  }));
                  break;
                }
                paramAnonymousView = new v(SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this), paramAnonymousView, SayHiWithSnsPermissionUI3.m(SayHiWithSnsPermissionUI3.this), SayHiWithSnsPermissionUI3.s(SayHiWithSnsPermissionUI3.this), i);
                bh.aZW().a(paramAnonymousView, 0);
                localObject1 = SayHiWithSnsPermissionUI3.this;
                localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
                SayHiWithSnsPermissionUI3.this.getString(R.l.app_tip);
                SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, com.tencent.mm.ui.base.k.a((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(R.l.gBk), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(305527);
                    bh.aZW().a(paramAnonymousView);
                    AppMethodBeat.o(305527);
                  }
                }));
                break;
              }
              j = 0;
              break label843;
            }
            j = 0;
            break;
          }
        }
      });
      this.NaA.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(305531);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(305531);
            return false;
            SayHiWithSnsPermissionUI3.this.NaL[0] = true;
            com.tencent.mm.plugin.normsg.a.d.MtP.aJ("ce_ver_usr", "<VerifyUsr>", this.NaW);
            continue;
            com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_ver_usr", paramAnonymousMotionEvent);
            com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_ver_usr");
          }
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(305505);
          if (SayHiWithSnsPermissionUI3.v(SayHiWithSnsPermissionUI3.this)) {
            SayHiWithSnsPermissionUI3.w(SayHiWithSnsPermissionUI3.this)[1] = 1;
          }
          SayHiWithSnsPermissionUI3.this.finish();
          SayHiWithSnsPermissionUI3.x(SayHiWithSnsPermissionUI3.this);
          SayHiWithSnsPermissionUI3.this.hm(2L);
          AppMethodBeat.o(305505);
          return true;
        }
      });
      this.NaA.setTextColor(getResources().getColor(a.d.BW_0_Alpha_0_2));
      this.NaA.setBackground(getDrawable(a.f.btn_solid_white));
      if (!this.MZP) {
        gCp();
      }
      this.lKz = new com.tencent.mm.ui.tools.i(this);
      this.lKz.afIL = this;
      if (this.Nat) {
        setMMTitle(R.l.gSB);
      }
      i = getIntent().getIntExtra("Contact_default_permission", -1);
      if ((!this.Nas) && (i > 0)) {
        gCp();
      }
      gCk();
      com.tencent.mm.ui.tools.b.c.i(this.Nai).aEg(32).a(new com.tencent.mm.ui.tools.b.c.a()
      {
        public final void Tw(String paramAnonymousString) {}
        
        public final void Tx(String paramAnonymousString) {}
        
        public final void eY(String paramAnonymousString) {}
      });
      AppMethodBeat.o(306038);
      return;
      bool = false;
      break;
    }
    label1156:
    label1417:
    label1638:
    this.Naz = ((TextView)findViewById(R.h.fCs));
    this.Naz.setVisibility(0);
    this.Nay = ((LinearLayout)findViewById(R.h.fCt));
    this.Nax = ((ImageView)findViewById(R.h.fso));
    if (this.Nax != null) {
      this.Nax.setImageDrawable(bb.m(this, R.k.icons_outlined_arrow, com.tencent.mm.cd.a.w(getContext(), R.e.BW_70)));
    }
    this.Nay.setOnClickListener(new SayHiWithSnsPermissionUI3.4(this));
    this.lDL = ((ScrollView)findViewById(R.h.scrollView));
    this.JWm = findViewById(R.h.fMh);
    this.JWm.setBackgroundDrawable(null);
    this.JWm.setVisibility(0);
    this.Nau = com.tencent.mm.plugin.label.d.fTa().iZN();
    if (this.Nav != null)
    {
      bh.bCz();
      localObject1 = com.tencent.mm.model.c.bzB().aMi(this.userName);
      if (localObject1 != null)
      {
        localObject1 = ((cr)localObject1).field_contactLabels;
        label1818:
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
      }
    }
    for (Object localObject1 = (ArrayList)com.tencent.mm.plugin.label.a.a.fTb().aJI((String)localObject3);; localObject1 = null)
    {
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
      break;
      label2019:
      bool = false;
      break label308;
      label2024:
      bool = false;
      break label379;
      label2029:
      if (i != 2) {
        break label647;
      }
      this.Nal.setText(R.l.sns_outside_permiss_female);
      break label647;
      label2047:
      if (i != 2) {
        break label676;
      }
      this.Nam.setText(R.l.sns_black_permiss_female);
      break label676;
      label2065:
      ((View)this.Nbo.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305547);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this))
          {
            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, Boolean.FALSE);
            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).booleanValue());
            SayHiWithSnsPermissionUI3.this.gCp();
          }
          SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305547);
        }
      });
      localObject2 = (View)this.Nbp.getParent();
      if (this.MZQ) {}
      for (localObject1 = null;; localObject1 = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(305539);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if (!SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this))
              {
                SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, Boolean.TRUE);
                SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).booleanValue());
                SayHiWithSnsPermissionUI3.this.gCp();
              }
              SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(305539);
            }
          })
      {
        ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
        i = getIntent().getIntExtra("Contact_default_permission", -1);
        if (i <= 0) {
          break;
        }
        if ((i & 0x8) != 8) {
          break label2171;
        }
        this.Nbq = Boolean.FALSE;
        AB(this.Nbq.booleanValue());
        break;
      }
      label2171:
      this.Nbq = Boolean.TRUE;
      AB(this.Nbq.booleanValue());
      break label723;
      label2192:
      localObject1 = com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), (CharSequence)localObject2, this.Nah.getTextSize());
      this.Nah.setText((CharSequence)localObject1);
      break label1120;
      label2220:
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "updateSayHiContextVisiable, needVerify = %s, sayHiContent= %s, isNeedSendSayHiContext= %s.", new Object[] { Boolean.valueOf(this.Nap), Boolean.valueOf(this.Nat), Boolean.valueOf(this.akiI) });
      if (this.akiI)
      {
        ((LinearLayout)this.Nah.getParent()).setVisibility(0);
        break label1156;
      }
      ((LinearLayout)this.Nah.getParent()).setVisibility(8);
      break label1156;
      label2305:
      setMMTitle(R.l.gSD);
      break label1252;
      label2315:
      if (!Util.isNullOrNil(this.nickName))
      {
        this.Nai.setHint(com.tencent.mm.pluginsdk.ui.span.p.b(getContext(), this.nickName, this.Nai.getTextSize()));
        this.Nai.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(305530);
            if (paramAnonymousBoolean)
            {
              if ((!Util.isNullOrNil(SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).getHint())) && (Util.isNullOrNil(SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).getText())))
              {
                SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).setText(SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).getHint());
                SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).setHint(null);
              }
              SayHiWithSnsPermissionUI3.f(SayHiWithSnsPermissionUI3.this);
              SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).setSelection(SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).getText().length());
            }
            AppMethodBeat.o(305530);
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
      label2999:
      break label1417;
      label3002:
      break label874;
      localObject1 = null;
      break label1818;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(306050);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(306050);
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
        AppMethodBeat.o(306050);
        return;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "cpan[All onActivityResult], labelLists: %s", new Object[] { localArrayList });
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
        Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "cpan[All onActivityResult], labelLists: %s, mCurrentSelectLabelStrList: %s,mAllCanShowLabelStrList:%s.", new Object[] { localArrayList, this.Nav, this.Nau });
        jw(this.Nav);
        AppMethodBeat.o(306050);
        return;
        AppMethodBeat.o(306050);
        return;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305942);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(R.e.white));
    hideActionbarLine();
    initView();
    bh.aZW().a(30, this);
    bh.aZW().a(243, this);
    bh.aZW().a(853, this);
    AppMethodBeat.o(305942);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(305984);
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
    AppMethodBeat.o(305984);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(306098);
    if (paramInt == 4)
    {
      this.pZy[0] = 1;
      finish();
      Az(false);
      AppMethodBeat.o(306098);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(306098);
    return bool;
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(306110);
    Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "height:%s", new Object[] { Integer.valueOf(paramInt) });
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
      AppMethodBeat.o(306110);
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
          AppMethodBeat.i(305563);
          Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramAnonymousValueAnimator.getAnimatedValue("translationY")).floatValue()) });
          AppMethodBeat.o(305563);
        }
      });
      this.JWJ.start();
      AppMethodBeat.o(306110);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(305964);
    bh.aZW().b(635, this);
    if (this.lKz != null) {
      this.lKz.close();
    }
    super.onPause();
    AppMethodBeat.o(305964);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(305959);
    super.onResume();
    bh.aZW().a(635, this);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(305959);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(306088);
    long l1 = System.currentTimeMillis();
    Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    Object localObject;
    try
    {
      eGg();
      if ((paramp instanceof v))
      {
        Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "onSceneEnd: getopCode: %s.", new Object[] { Integer.valueOf(((v)paramp).hId) });
        if (((paramInt1 != 0) || (paramInt2 != 0)) && (((v)paramp).hId == 1)) {
          Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "onSceneEnd:is MM_VERIFYUSER_ADDCONTACT return");
        }
      }
      else
      {
        Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "onSceneEnd: is no NetSceneVerifyUser.");
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "sendrequest_second");
      gCh();
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label1272;
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
        break label948;
      }
      paramString = gCg();
      if (Util.isNullOrNil(paramString)) {
        break label1078;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "set temp remark of %s", new Object[] { this.userName });
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzA().JE(this.userName);
      ((au)localObject).AW(paramString);
      bh.bCz();
      cr localcr = com.tencent.mm.model.c.bzB().aMi(this.userName);
      localcr.field_encryptUsername = this.userName;
      localcr.field_conRemark = paramString;
      bh.bCz();
      com.tencent.mm.model.c.bzB().replace(localcr);
      bh.bCz();
      com.tencent.mm.model.c.bzA().aA((au)localObject);
      this.pZy[2] = 1;
      if ((!Util.isNullOrNil(this.nickName)) && (!paramString.equals(this.nickName))) {
        this.pZy[5] = 1;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label642:
        label718:
        Log.e("MicroMsg.SayHiWithSnsPermissionUI3", "exception in onSceneEnd : " + paramString.getMessage());
        label789:
        label948:
        label1078:
        return;
        label1046:
        this.pZy[2] = 2;
      }
    }
    finally
    {
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(306088);
    }
    paramString = new LinkedList();
    if ((paramp instanceof v))
    {
      paramInt1 = ((v)paramp).hId;
      paramString = ((v)paramp).XRr;
      if ((paramInt1 == 3) || ((paramp instanceof t)))
      {
        localObject = com.tencent.mm.modelverify.d.bNH().byn(this.userName);
        bh.bCz();
        paramp = com.tencent.mm.model.c.bzA().JE(this.userName);
        if ((paramString != null) && (paramString.contains(this.userName)))
        {
          paramString = paramp;
          if ((int)paramp.maN != 0) {
            break label1227;
          }
          paramp = com.tencent.mm.pluginsdk.ui.preference.b.a((bp)localObject);
          paramp.setUsername(this.userName);
          bh.bCz();
          paramString = paramp;
          if (com.tencent.mm.model.c.bzA().aB(paramp)) {
            break label1227;
          }
          Log.e("MicroMsg.SayHiWithSnsPermissionUI3", "canAddContact fail, insert fail");
        }
        bh.bCz();
        paramString = com.tencent.mm.model.c.bzA().JE(this.userName);
        paramp = new yv();
        paramp.ibZ.icb = true;
        paramp.ibZ.ica = false;
        paramp.ibZ.username = this.userName;
        paramp.publish();
        if (!this.MZL.afTT) {
          break label1265;
        }
        com.tencent.mm.model.ab.C(paramString);
        paramString = new yv();
        paramString.ibZ.icb = false;
        paramString.ibZ.ica = true;
        paramString.ibZ.username = this.userName;
        bool = aRZ(this.userName);
        paramString.ibZ.icc = bool;
        localObject = this.userName;
        if (this.MZM.afTT) {
          break label1788;
        }
        paramInt1 = 2;
        paramp = new LinkedList();
        paramp.add(localObject);
        localObject = new sd();
        ((sd)localObject).hVg.list = paramp;
        ((sd)localObject).hVg.hHC = paramInt1;
        ((sd)localObject).hVg.hVh = 5L;
        ((sd)localObject).publish();
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
    label1427:
    for (;;)
    {
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(306088);
      return;
      if (!Util.isNullOrNil(this.nickName))
      {
        this.pZy[2] = 0;
        break;
      }
      if (!(paramp instanceof t)) {
        break label1783;
      }
      paramString.add(((t)paramp).psp);
      break label1783;
      label1227:
      com.tencent.mm.model.ab.I(paramString);
      bh.getNotification().aKV();
      com.tencent.mm.modelverify.d.bNI().fP(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.dz(this.userName, this.pUt);
      break label642;
      label1265:
      com.tencent.mm.model.ab.D(paramString);
      break label718;
      label1272:
      if ((paramInt1 == 4) && (paramInt2 == -302))
      {
        paramInt1 = 0;
        if (paramp.getType() == 30) {
          paramInt1 = ((v)paramp).hId;
        }
        Log.w("MicroMsg.SayHiWithSnsPermissionUI3", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
        com.tencent.mm.ui.base.k.b(this, getString(R.l.contact_info_verify_outofdate_msg), getString(R.l.app_tip), getString(R.l.app_add), getString(R.l.app_cancel), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(305561);
            SayHiWithSnsPermissionUI3.this.AA(true);
            AppMethodBeat.o(305561);
          }
        }, null);
      }
      else
      {
        if ((paramInt1 != 4) || (paramInt2 != -24) || (Util.isNullOrNil(paramString))) {
          break label1793;
        }
        Toast.makeText(this, paramString, 1).show();
        continue;
        label1400:
        if (!Util.isNullOrNil(paramString))
        {
          com.tencent.mm.ui.base.k.a(this, paramString, "", getString(R.l.app_ok), null);
        }
        else
        {
          if ((!this.Nap) || ((paramInt2 != -24) && (paramInt2 != -34))) {
            break label1460;
          }
          Toast.makeText(this, R.l.fmessage_request_too_offen, 0).show();
        }
      }
    }
    label1460:
    if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.MZP))
    {
      this.MZQ = true;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfD, Integer.valueOf(1));
      if (!Util.isNullOrNil(paramString)) {
        this.MZY.setText(paramString);
      }
      if ((this.Nar) || (this.MZQ)) {
        break label1813;
      }
    }
    label1793:
    label1813:
    for (boolean bool = true;; bool = false)
    {
      this.Nbq = Boolean.valueOf(bool);
      this.Nbo.setVisibility(0);
      this.Nbp.setVisibility(0);
      AB(this.Nbq.booleanValue());
      ((View)this.Nbo.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305564);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, Boolean.FALSE);
          SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).booleanValue());
          SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305564);
        }
      });
      localObject = (View)this.Nbp.getParent();
      if (this.MZQ)
      {
        paramp = null;
        label1611:
        ((View)localObject).setOnClickListener(paramp);
        findViewById(R.h.fRF).setVisibility(8);
        paramp = (TextView)findViewById(R.h.fXR);
        if (!this.MZQ) {
          break label1755;
        }
      }
      label1755:
      for (paramInt1 = getResources().getColor(R.e.hint_text_color);; paramInt1 = getResources().getColor(R.e.normal_text_color))
      {
        paramp.setTextColor(paramInt1);
        if (this.MZQ) {
          this.MZY.setVisibility(0);
        }
        this.Nar = false;
        paramp = new g.a(this);
        paramp.bDE(paramString).NF(true).bDJ(getString(R.l.gSe)).aEX(R.l.gSf);
        paramp.c(new SayHiWithSnsPermissionUI3.6(this)).show();
        break;
        paramp = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(305571);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, Boolean.TRUE);
            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).booleanValue());
            SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(305571);
          }
        };
        break label1611;
      }
      Toast.makeText(this, R.l.sendrequest_send_fail, 0).show();
      break label1046;
      label1783:
      paramInt1 = 0;
      break;
      label1788:
      paramInt1 = 1;
      break label789;
      if (paramInt1 != 4) {
        break label1427;
      }
      if (paramInt2 == -2) {
        break label1400;
      }
      if (paramInt2 != -101) {
        break label1427;
      }
      break label1400;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(305971);
    super.onStop();
    AppMethodBeat.o(305971);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(305976);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(305976);
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
      AppMethodBeat.i(305508);
      paramView = Util.nullAsNil(com.tencent.mm.ui.tools.b.c.bCI(this.remark));
      if ((paramView != null) && (this.remark != null) && (paramView.length() < this.remark.length())) {
        Toast.makeText(SayHiWithSnsPermissionUI3.this, SayHiWithSnsPermissionUI3.this.getString(R.l.remark_name_mast_count), 0).show();
      }
      SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).setText(com.tencent.mm.pluginsdk.ui.span.p.b(SayHiWithSnsPermissionUI3.this, paramView, SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).getTextSize()));
      SayHiWithSnsPermissionUI3.e(SayHiWithSnsPermissionUI3.this).setSelection(paramView.length());
      SayHiWithSnsPermissionUI3.z(SayHiWithSnsPermissionUI3.this).setVisibility(8);
      SayHiWithSnsPermissionUI3.w(SayHiWithSnsPermissionUI3.this)[4] = 1;
      AppMethodBeat.o(305508);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(305513);
      paramTextPaint.setColor(SayHiWithSnsPermissionUI3.this.getResources().getColor(R.e.blue_text_color));
      paramTextPaint.setUnderlineText(false);
      AppMethodBeat.o(305513);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3
 * JD-Core Version:    0.7.0.1
 */