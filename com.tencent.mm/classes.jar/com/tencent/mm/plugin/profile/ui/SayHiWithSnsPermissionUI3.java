package com.tencent.mm.plugin.profile.ui;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.tencent.mm.f.a.qp;
import com.tencent.mm.f.a.se;
import com.tencent.mm.f.a.xc;
import com.tencent.mm.f.b.a.jo;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.b.o;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
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
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.f.d;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.f.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SayHiWithSnsPermissionUI3
  extends MMActivity
  implements com.tencent.mm.an.i, com.tencent.mm.ui.tools.h
{
  String BAU;
  private View EeB;
  private HashSet<String> EeR;
  private HashSet<String> EeS;
  private HashSet<String> EeT;
  private ObjectAnimator EeU;
  private k Eeu;
  private String GsA;
  private MMSwitchBtn HbE;
  private MMSwitchBtn HbF;
  private boolean HbI;
  private boolean HbJ;
  private TextView HbQ;
  private EditText HbZ;
  final boolean[] HcA;
  private int HcB;
  int HcE;
  TextView HcF;
  View HcG;
  private EditText Hca;
  private View Hcb;
  private TextView Hcc;
  private boolean Hcd;
  private boolean Hce;
  private boolean Hcf;
  private boolean Hcg;
  private boolean Hch;
  private List<String> Hci;
  private ArrayList<String> Hcj;
  private ArrayList<String> Hck;
  private ImageView Hcl;
  private LinearLayout Hcm;
  private TextView Hcn;
  private Button Hco;
  private boolean Hcp;
  private String Hcq;
  private String Hcr;
  private int Hcs;
  private boolean Hct;
  private int Hcu;
  private int Hcv;
  private List<String> Hcw;
  private HashSet<String> Hcx;
  private CharSequence Hcy;
  final boolean[] Hcz;
  private ImageView Hdb;
  private ImageView Hdc;
  private Boolean Hdd;
  private int Hde;
  private String chatroomName;
  private String cip;
  private long fOa;
  private ProgressDialog iXX;
  private ScrollView jbL;
  private com.tencent.mm.ui.tools.i jij;
  View mUM;
  com.tencent.mm.ui.widget.a.d mUO;
  private int mXL;
  private int[] nei;
  private String nickName;
  EditText qDO;
  String userName;
  
  public SayHiWithSnsPermissionUI3()
  {
    AppMethodBeat.i(274493);
    this.iXX = null;
    this.nei = new int[8];
    this.HbI = false;
    this.HbJ = false;
    this.Hcf = false;
    this.Hcg = false;
    this.Hci = new ArrayList();
    this.Hcj = new ArrayList();
    this.Hck = new ArrayList();
    this.Hch = false;
    this.Hcp = false;
    this.Hcs = 0;
    this.Hcw = new ArrayList();
    this.Hcx = new HashSet();
    this.EeR = new HashSet();
    this.EeS = new HashSet();
    this.EeT = new HashSet();
    this.Hcy = null;
    this.Hcz = new boolean[] { true };
    this.HcA = new boolean[] { false };
    this.fOa = System.currentTimeMillis();
    this.HcB = 0;
    this.Hde = 0;
    this.HcE = 0;
    this.EeU = null;
    this.mUO = null;
    AppMethodBeat.o(274493);
  }
  
  private static boolean aUR(String paramString)
  {
    AppMethodBeat.i(274521);
    boolean bool = p.JPf.aUR(paramString);
    AppMethodBeat.o(274521);
    return bool;
  }
  
  private String fqL()
  {
    AppMethodBeat.i(274518);
    String str = "";
    if (this.Hca.getText() != null) {
      str = this.Hca.getText().toString();
    }
    if (!Util.isNullOrNil(str))
    {
      if (str.length() <= 50)
      {
        AppMethodBeat.o(274518);
        return str;
      }
      str = str.substring(0, 50);
      AppMethodBeat.o(274518);
      return str;
    }
    AppMethodBeat.o(274518);
    return str;
  }
  
  private void fqM()
  {
    AppMethodBeat.i(274520);
    if (this.Hcd)
    {
      String str = this.HbZ.getText().toString().trim();
      if ((Util.isNullOrNil(str)) || (str.equals(this.Hcy)) || (!Util.isNullOrNil(this.chatroomName)))
      {
        bh.beI();
        com.tencent.mm.model.c.aHp().i(294913, "");
        AppMethodBeat.o(274520);
        return;
      }
      bh.beI();
      com.tencent.mm.model.c.aHp().i(294913, str);
    }
    AppMethodBeat.o(274520);
  }
  
  private void gw(List<String> paramList)
  {
    AppMethodBeat.i(274515);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.Hcn.setText("");
      AppMethodBeat.o(274515);
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
    this.Hcn.setText(str);
    AppMethodBeat.o(274515);
  }
  
  private static boolean t(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(274517);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.addAll(paramList1);
    localArrayList2.addAll(paramList2);
    Collections.sort(localArrayList1);
    Collections.sort(localArrayList2);
    if (localArrayList1.equals(localArrayList2))
    {
      AppMethodBeat.o(274517);
      return false;
    }
    AppMethodBeat.o(274517);
    return true;
  }
  
  private void wc(final boolean paramBoolean)
  {
    AppMethodBeat.i(274523);
    com.tencent.e.h.ZvG.bf(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(280733);
        int k;
        int m;
        if (SayHiWithSnsPermissionUI3.j(SayHiWithSnsPermissionUI3.this))
        {
          k = 1;
          if (!Util.isNullOrNil(SayHiWithSnsPermissionUI3.y(SayHiWithSnsPermissionUI3.this))) {
            break label401;
          }
          m = 3;
        }
        for (;;)
        {
          label33:
          int j;
          if (SayHiWithSnsPermissionUI3.B(SayHiWithSnsPermissionUI3.this)) {
            j = 6;
          }
          for (;;)
          {
            label46:
            int i;
            switch (SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this))
            {
            default: 
              i = 11;
            }
            int i1;
            StringBuilder localStringBuilder1;
            for (;;)
            {
              localObject = SayHiWithSnsPermissionUI3.D(SayHiWithSnsPermissionUI3.this);
              i1 = ((List)localObject).size();
              localStringBuilder1 = new StringBuilder();
              i2 = SayHiWithSnsPermissionUI3.E(SayHiWithSnsPermissionUI3.this).size();
              if (i2 <= 0) {
                break label589;
              }
              n = 0;
              while (n < i2)
              {
                localStringBuilder1.append((String)SayHiWithSnsPermissionUI3.E(SayHiWithSnsPermissionUI3.this).get(n));
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
              if ((!SayHiWithSnsPermissionUI3.y(SayHiWithSnsPermissionUI3.this).equals(SayHiWithSnsPermissionUI3.z(SayHiWithSnsPermissionUI3.this))) && (!SayHiWithSnsPermissionUI3.y(SayHiWithSnsPermissionUI3.this).equals(SayHiWithSnsPermissionUI3.A(SayHiWithSnsPermissionUI3.this)))) {
                break label862;
              }
              m = 2;
              break label33;
              if ((SayHiWithSnsPermissionUI3.C(SayHiWithSnsPermissionUI3.this) & 0x8) != 0)
              {
                j = 5;
                break label46;
              }
              if (((SayHiWithSnsPermissionUI3.C(SayHiWithSnsPermissionUI3.this) & 0x1) != 0) && ((SayHiWithSnsPermissionUI3.C(SayHiWithSnsPermissionUI3.this) & 0x2) != 0))
              {
                j = 4;
                break label46;
              }
              if ((SayHiWithSnsPermissionUI3.C(SayHiWithSnsPermissionUI3.this) & 0x2) != 0)
              {
                j = 3;
                break label46;
              }
              if ((SayHiWithSnsPermissionUI3.C(SayHiWithSnsPermissionUI3.this) & 0x1) == 0) {
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
            bh.beI();
            int n = com.tencent.mm.model.c.bbL().c(ab.lsO, new String[] { z.bcZ(), "weixin", "helper_entry", "filehelper" });
            com.tencent.mm.plugin.report.service.h.IzE.a(18713, new Object[] { SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(System.currentTimeMillis() - SayHiWithSnsPermissionUI3.F(SayHiWithSnsPermissionUI3.this)), Integer.valueOf(n), Integer.valueOf(SayHiWithSnsPermissionUI3.G(SayHiWithSnsPermissionUI3.this)), localObject, localStringBuilder1, Integer.valueOf(i1), Integer.valueOf(SayHiWithSnsPermissionUI3.this.HcE) });
            AppMethodBeat.o(280733);
            return;
            label857:
            j = 0;
          }
          label862:
          m = 1;
        }
      }
    });
    AppMethodBeat.o(274523);
  }
  
  private void wd(boolean paramBoolean)
  {
    AppMethodBeat.i(274525);
    this.Hdc.setVisibility(0);
    this.Hdb.setVisibility(0);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.downloader_app.b.e(this.Hdc, "checkbox_cell_on");
      com.tencent.mm.plugin.downloader_app.b.e(this.Hdb, "checkbox_cell_off");
      this.Hdc.setTag(Boolean.TRUE);
      this.Hdb.setTag(Boolean.FALSE);
      AppMethodBeat.o(274525);
      return;
    }
    com.tencent.mm.plugin.downloader_app.b.e(this.Hdc, "checkbox_cell_off");
    com.tencent.mm.plugin.downloader_app.b.e(this.Hdb, "checkbox_cell_on");
    this.Hdc.setTag(Boolean.FALSE);
    this.Hdb.setTag(Boolean.TRUE);
    AppMethodBeat.o(274525);
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(274524);
    Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "height:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.EeU != null) && (this.EeU.isRunning())) {
      this.EeU.cancel();
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.Eeu != null)
    {
      localObject1 = localObject2;
      if (this.Eeu.isShowing())
      {
        localObject1 = localObject2;
        if (this.Eeu.oFW != null)
        {
          localObject1 = localObject2;
          if ((this.Eeu.oFW.getParent() instanceof View)) {
            localObject1 = (View)this.Eeu.oFW.getParent();
          }
        }
      }
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(274524);
      return;
    }
    if (paramInt > 0) {
      if (((View)localObject1).getTranslationY() != 0.0F) {
        ((View)localObject1).setTranslationY(0.0F);
      }
    }
    for (this.EeU = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { 0.0F, -paramInt });; this.EeU = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { ((View)localObject1).getTranslationY(), 0.0F }))
    {
      this.EeU.setDuration(200L);
      this.EeU.setInterpolator(new androidx.f.a.a.b());
      this.EeU.addUpdateListener(new SayHiWithSnsPermissionUI3.6(this));
      this.EeU.start();
      AppMethodBeat.o(274524);
      return;
    }
  }
  
  public final void Ph(final long paramLong)
  {
    AppMethodBeat.i(274528);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(285712);
        jo localjo = new jo();
        if (SayHiWithSnsPermissionUI3.D(SayHiWithSnsPermissionUI3.this) == null) {
          SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, new ArrayList());
        }
        if (SayHiWithSnsPermissionUI3.J(SayHiWithSnsPermissionUI3.this) == null) {
          SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, new ArrayList());
        }
        if (SayHiWithSnsPermissionUI3.J(SayHiWithSnsPermissionUI3.this) == null) {
          SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, new ArrayList());
        }
        Object localObject1 = SayHiWithSnsPermissionUI3.D(SayHiWithSnsPermissionUI3.this);
        localjo.AC(SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this));
        long l;
        Object localObject2;
        int i;
        label142:
        String str;
        if (SayHiWithSnsPermissionUI3.K(SayHiWithSnsPermissionUI3.this))
        {
          l = 1L;
          localjo.gLo = l;
          localObject2 = ((List)localObject1).iterator();
          i = 0;
          if (!((Iterator)localObject2).hasNext()) {
            break label192;
          }
          str = (String)((Iterator)localObject2).next();
          if (!SayHiWithSnsPermissionUI3.L(SayHiWithSnsPermissionUI3.this).contains(str)) {
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
          localjo.gLq = i;
          l = 0L;
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (SayHiWithSnsPermissionUI3.M(SayHiWithSnsPermissionUI3.this).contains(str)) {
              l += 1L;
            }
          }
          localjo.gLs = l;
          localObject2 = ((List)localObject1).iterator();
          int j = 0;
          if (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (!SayHiWithSnsPermissionUI3.N(SayHiWithSnsPermissionUI3.this).contains(str)) {
              break label1007;
            }
            j += 1;
          }
          for (;;)
          {
            break;
            localjo.gLr = j;
            localObject2 = ((List)localObject1).iterator();
            int k = 0;
            if (((Iterator)localObject2).hasNext())
            {
              str = (String)((Iterator)localObject2).next();
              if (!SayHiWithSnsPermissionUI3.O(SayHiWithSnsPermissionUI3.this).contains(str)) {
                break label1004;
              }
              k += 1;
            }
            for (;;)
            {
              break;
              localjo.gLp = k;
              localjo.guX = (System.currentTimeMillis() - SayHiWithSnsPermissionUI3.F(SayHiWithSnsPermissionUI3.this));
              localjo.gLw = SayHiWithSnsPermissionUI3.P(SayHiWithSnsPermissionUI3.this);
              localjo.gLx = paramLong;
              localjo.gLt = SayHiWithSnsPermissionUI3.Q(SayHiWithSnsPermissionUI3.this);
              int n = 0;
              localObject2 = ((List)localObject1).iterator();
              int m = 0;
              if (((Iterator)localObject2).hasNext())
              {
                str = (String)((Iterator)localObject2).next();
                if (SayHiWithSnsPermissionUI3.J(SayHiWithSnsPermissionUI3.this).contains(str)) {
                  break label1001;
                }
                m += 1;
              }
              for (;;)
              {
                break;
                localObject2 = SayHiWithSnsPermissionUI3.J(SayHiWithSnsPermissionUI3.this).iterator();
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
                  localjo.gmT = 2L;
                  localObject2 = "";
                  localObject1 = localObject2;
                  if (SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this) != null)
                  {
                    localObject1 = localObject2;
                    if (SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).getText() != null)
                    {
                      localObject1 = localObject2;
                      if (SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).getText().toString() != null) {
                        localObject1 = SayHiWithSnsPermissionUI3.d(SayHiWithSnsPermissionUI3.this).getText().toString().trim();
                      }
                    }
                  }
                  localObject2 = localObject1;
                  if (localObject1 == null) {
                    localObject2 = "";
                  }
                  if (!ae.isNullOrNil(SayHiWithSnsPermissionUI3.S(SayHiWithSnsPermissionUI3.this))) {
                    if (SayHiWithSnsPermissionUI3.S(SayHiWithSnsPermissionUI3.this).equals(localObject2)) {
                      SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 3);
                    }
                  }
                  for (;;)
                  {
                    localjo.gLy = SayHiWithSnsPermissionUI3.U(SayHiWithSnsPermissionUI3.this);
                    localjo.gLv = m;
                    localjo.gLu = n;
                    localjo.bpa();
                    Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "22865 setAddedLabelCnt = " + m + ",setRemovedLabelCnt = " + n + ",oriLabelCnt = " + SayHiWithSnsPermissionUI3.Q(SayHiWithSnsPermissionUI3.this) + ",opResult = " + paramLong + ",totalLabelCnt = " + SayHiWithSnsPermissionUI3.P(SayHiWithSnsPermissionUI3.this) + ",selectNewLabelCnt = " + k + ",selectAddLabelCnt = " + j + ",addRemarkType = " + SayHiWithSnsPermissionUI3.U(SayHiWithSnsPermissionUI3.this) + ",scene= 2,newLebalCountBySearch = " + i + ",searchAddLabelCnt = " + l);
                    AppMethodBeat.o(285712);
                    return;
                    SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 2);
                    continue;
                    if (!SayHiWithSnsPermissionUI3.R(SayHiWithSnsPermissionUI3.this)) {
                      SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 3);
                    } else if (!ae.isNullOrNil(SayHiWithSnsPermissionUI3.T(SayHiWithSnsPermissionUI3.this)))
                    {
                      if (SayHiWithSnsPermissionUI3.T(SayHiWithSnsPermissionUI3.this).equals(localObject2)) {
                        SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 1);
                      } else if (Util.isNullOrNil((String)localObject2)) {
                        SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 3);
                      } else {
                        SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this, 2);
                      }
                    }
                    else if (((String)localObject2).equals(SayHiWithSnsPermissionUI3.T(SayHiWithSnsPermissionUI3.this))) {
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
    AppMethodBeat.o(274528);
  }
  
  protected final void fqP()
  {
    AppMethodBeat.i(274527);
    this.Hco.setTextColor(getResources().getColor(a.d.color_btn_text_selector));
    this.Hco.setBackground(getDrawable(a.f.btn_solid_green));
    AppMethodBeat.o(274527);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(274497);
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWH, 0) != 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = R.i.ekC;
      AppMethodBeat.o(274497);
      return i;
    }
    i = R.i.ekD;
    AppMethodBeat.o(274497);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(274514);
    this.Hcd = getIntent().getBooleanExtra("sayhi_with_sns_perm_send_verify", false);
    this.Hce = getIntent().getBooleanExtra("sayhi_with_sns_perm_add_remark", false);
    this.userName = getIntent().getStringExtra("Contact_User");
    this.mXL = getIntent().getIntExtra("Contact_Scene", 9);
    this.chatroomName = getIntent().getStringExtra("room_name");
    this.cip = getIntent().getStringExtra("Contact_RemarkName");
    this.Hcr = this.cip;
    this.nickName = getIntent().getStringExtra("Contact_Nick");
    this.GsA = getIntent().getStringExtra("Contact_RoomNickname");
    this.Hcb = findViewById(R.h.dMG);
    this.Hcc = ((TextView)findViewById(R.h.dMH));
    if ((com.tencent.mm.plugin.profile.c.aUI(this.userName)) && (!getIntent().getBooleanExtra("Contact_IsForceVerifyFriend", false))) {}
    label261:
    label332:
    int i;
    label580:
    label603:
    Object localObject3;
    label650:
    Object localObject2;
    Object localObject4;
    for (boolean bool = true;; bool = false)
    {
      this.Hch = bool;
      if (!as.bvK(this.userName)) {
        break;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "initLabelPanelAll, isOpenIM, userName: %s.", new Object[] { this.userName });
      localObject1 = findViewById(R.h.dKH);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("MMSocialBlackListFlag", 1) != 1) {
        break label1934;
      }
      bool = true;
      this.HbI = bool;
      if (!this.HbI) {
        findViewById(R.h.dWd).setVisibility(8);
      }
      com.tencent.mm.kernel.h.aHH();
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.userName);
      if (com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VCJ, 0) != 1) {
        break label1939;
      }
      bool = true;
      this.Hcf = bool;
      this.HbE = ((MMSwitchBtn)findViewById(R.h.dPy).findViewById(R.h.dPC));
      getIntent().getBooleanExtra("sayhi_with_sns_permission", false);
      this.HbE.setCheck(((as)localObject1).ayi());
      this.Hdb = ((ImageView)findViewById(R.h.dWa));
      this.Hdc = ((ImageView)findViewById(R.h.dVu));
      this.Hdc.setVisibility(0);
      this.Hdb.setVisibility(0);
      com.tencent.mm.plugin.downloader_app.b.e(this.Hdc, "checkbox_cell_off");
      com.tencent.mm.plugin.downloader_app.b.e(this.Hdb, "checkbox_cell_off");
      this.Hdc.setTag(Boolean.FALSE);
      this.Hdb.setTag(Boolean.FALSE);
      this.HbQ = ((TextView)findViewById(R.h.dWb));
      this.HbF = ((MMSwitchBtn)findViewById(R.h.dVt).findViewById(R.h.dPE));
      bool = aUR(this.userName);
      this.HbF.setCheck(bool);
      findViewById(R.h.dux).setOnClickListener(new SayHiWithSnsPermissionUI3.1(this));
      i = ((com.tencent.mm.f.c.ax)localObject1).sex;
      Log.d("MicroMsg.SayHiWithSnsPermissionUI3", "sex:%d", new Object[] { Integer.valueOf(i) });
      localObject1 = (TextView)findViewById(R.h.dPD);
      if (i != 1) {
        break label1944;
      }
      ((TextView)localObject1).setText(R.l.sns_outside_permiss_male);
      localObject1 = (TextView)findViewById(R.h.dPF);
      if (i != 1) {
        break label1959;
      }
      ((TextView)localObject1).setText(R.l.sns_black_permiss_male);
      bool = as.bvK(this.userName);
      this.Hcg = bool;
      if (!bool) {
        break label1974;
      }
      findViewById(R.h.dWd).setVisibility(8);
      localObject1 = findViewById(R.h.dPA);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (this.Hcg) {
        this.HbF.setCheck(true);
      }
      if (this.Hcd)
      {
        this.HbZ = ((EditText)findViewById(R.h.dTd));
        com.tencent.mm.ui.tools.b.c.i(this.HbZ).axx(100).a(null);
        this.HbZ.setFilters(com.tencent.mm.pluginsdk.ui.tools.m.Rxd);
        this.HbZ.addTextChangedListener(new TextWatcher()
        {
          public final void afterTextChanged(Editable paramAnonymousEditable) {}
          
          public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
          
          public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            AppMethodBeat.i(276470);
            if (SayHiWithSnsPermissionUI3.this.Hcz[0] != 0)
            {
              SayHiWithSnsPermissionUI3.this.Hcz[0] = false;
              com.tencent.mm.plugin.normsg.a.d.GxJ.aTh("ie_ver_usr");
            }
            com.tencent.mm.plugin.normsg.a.d.GxJ.aTi("ie_ver_usr");
            AppMethodBeat.o(276470);
          }
        });
        ((LinearLayout)this.HbZ.getParent()).setVisibility(0);
        bh.beI();
        localObject3 = (String)com.tencent.mm.model.c.aHp().b(294913, null);
        localObject2 = z.bdb();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject4 = getString(R.l.sendgreeting_content);
        if (((String)localObject4).length() + ((String)localObject1).length() <= 50) {
          break label2826;
        }
        localObject1 = ((String)localObject1).substring(0, 50 - ((String)localObject4).length());
        label815:
        localObject2 = localObject3;
        if (!Util.isNullOrNil(this.chatroomName))
        {
          as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.chatroomName);
          localObject2 = localObject3;
          if (localas != null)
          {
            localObject2 = localObject3;
            if (!Util.isNullOrNil(localas.field_nickname))
            {
              localObject3 = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rx(this.chatroomName).PJ(z.bcZ());
              localObject2 = localObject3;
              if (Util.isNullOrNil((CharSequence)localObject3)) {
                localObject2 = localObject1;
              }
              Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "chatroomName:%s nick:%s", new Object[] { this.chatroomName, localas.field_nickname });
              localObject2 = l.b(getContext(), getResources().getString(R.l.sendgreeting_content_chatroom, new Object[] { localas.field_nickname, localObject2 }), this.HbZ.getTextSize());
              this.Hcy = ((CharSequence)localObject2);
            }
          }
        }
        if (Util.isNullOrNil(this.Hcy)) {
          this.Hcy = l.b(getContext(), String.format((String)localObject4, new Object[] { localObject1 }), this.HbZ.getTextSize());
        }
        if (!Util.isNullOrNil((CharSequence)localObject2)) {
          break label2101;
        }
        this.HbZ.setText(this.Hcy);
        label1061:
        this.HbZ.clearFocus();
      }
      if (this.Hce)
      {
        this.Hca = ((EditText)findViewById(R.h.dTe));
        ((LinearLayout)this.Hca.getParent()).setVisibility(0);
        if (!this.Hcd) {
          this.Hca.clearFocus();
        }
        com.tencent.mm.ui.tools.b.c.i(this.Hca).axx(100).a(null);
        this.Hca.setFilters(com.tencent.mm.pluginsdk.ui.tools.m.Rxd);
        if (this.Hcd) {
          break label2129;
        }
        setMMTitle(R.l.ePW);
        this.nei[0] = 1;
        label1164:
        if (Util.isNullOrNil(this.cip)) {
          break label2139;
        }
        this.Hca.setText(l.b(getContext(), this.cip, this.Hca.getTextSize()));
        this.nei[6] = 1;
        if ((this.Hca.getHint() != null) && (!Util.isNullOrNil(this.Hca.getHint().toString()))) {
          this.Hcq = this.Hca.getHint().toString();
        }
        if ((this.Hca.getText() != null) && (!Util.isNullOrNil(this.Hca.getText().toString()))) {
          this.Hcq = this.Hca.getText().toString();
        }
      }
      localObject1 = getString(R.l.app_send);
      if (!this.Hcd) {
        localObject1 = getString(R.l.app_finish);
      }
      if (!this.Hch) {
        break label2823;
      }
      localObject1 = getString(R.l.app_finish);
      label1329:
      localObject2 = com.tencent.mm.plugin.normsg.a.c.aaA(3);
      this.Hco = ((Button)findViewById(R.h.finish_btn));
      this.Hco.setText((CharSequence)localObject1);
      this.Hco.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(final View paramAnonymousView)
        {
          AppMethodBeat.i(292353);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
          if ((SayHiWithSnsPermissionUI3.f(SayHiWithSnsPermissionUI3.this) != null) && (SayHiWithSnsPermissionUI3.f(SayHiWithSnsPermissionUI3.this).isShowing()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(292353);
            return;
          }
          if (SayHiWithSnsPermissionUI3.this.HcA[0] != 0) {
            SayHiWithSnsPermissionUI3.this.HcA[0] = false;
          }
          while ((!SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this)) && (!SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this)) && (SayHiWithSnsPermissionUI3.g(SayHiWithSnsPermissionUI3.this)))
          {
            SayHiWithSnsPermissionUI3.h(SayHiWithSnsPermissionUI3.this);
            SayHiWithSnsPermissionUI3.i(SayHiWithSnsPermissionUI3.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(292353);
            return;
            com.tencent.mm.plugin.normsg.a.d.GxJ.av("ce_ver_usr", "<VerifyUsr>", this.HcL);
            paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
            com.tencent.mm.plugin.normsg.a.d.GxJ.a("ce_ver_usr", paramAnonymousView);
            com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_ver_usr");
          }
          com.tencent.mm.plugin.normsg.a.d.GxJ.fx(this.HcL, 3);
          final LinkedList localLinkedList2;
          final LinkedList localLinkedList1;
          final HashMap localHashMap;
          int j;
          if (SayHiWithSnsPermissionUI3.j(SayHiWithSnsPermissionUI3.this))
          {
            localLinkedList2 = new LinkedList();
            localLinkedList2.add(SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this));
            localLinkedList1 = new LinkedList();
            localLinkedList1.add(Integer.valueOf(SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this)));
            localObject1 = SayHiWithSnsPermissionUI3.m(SayHiWithSnsPermissionUI3.this);
            localHashMap = new HashMap();
            if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this)) {
              break label1111;
            }
            if (!SayHiWithSnsPermissionUI3.n(SayHiWithSnsPermissionUI3.this).YbZ) {
              break label1106;
            }
            j = 1;
            i = j;
            if (!SayHiWithSnsPermissionUI3.o(SayHiWithSnsPermissionUI3.this).YbZ) {}
          }
          label836:
          label1106:
          label1111:
          for (int i = j | 0x2;; i = 0)
          {
            j = i;
            if (SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this)) {
              j = i | 0x8;
            }
            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, j);
            localHashMap.put(SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this), Integer.valueOf(j));
            Log.d("MicroMsg.SayHiWithSnsPermissionUI3", "select sns permission, %s", new Object[] { Integer.valueOf(j) });
            Object localObject2;
            if (SayHiWithSnsPermissionUI3.p(SayHiWithSnsPermissionUI3.this))
            {
              paramAnonymousView = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra(f.d.VRW);
              paramAnonymousView = new o(SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this), (String)localObject1, paramAnonymousView, j);
              bh.aGY().a(paramAnonymousView, 0);
              localObject1 = SayHiWithSnsPermissionUI3.this;
              localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
              SayHiWithSnsPermissionUI3.this.getString(R.l.app_tip);
              SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(288109);
                  bh.aGY().a(paramAnonymousView);
                  AppMethodBeat.o(288109);
                }
              }));
            }
            do
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(292353);
              return;
              Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "addTextOptionMenu:send addcontact.");
              final String str1 = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_user_name");
              final String str2 = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_nick_name");
              localObject2 = new com.tencent.mm.pluginsdk.ui.applet.a(SayHiWithSnsPermissionUI3.this, null);
              if (SayHiWithSnsPermissionUI3.q(SayHiWithSnsPermissionUI3.this)) {}
              for (paramAnonymousView = "";; paramAnonymousView = (View)localObject1)
              {
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).content = paramAnonymousView;
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).np(str1, str2);
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).ReR = localHashMap;
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).chatroomName = SayHiWithSnsPermissionUI3.r(SayHiWithSnsPermissionUI3.this);
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).ReH = new a.b()
                {
                  public final boolean m(final String paramAnonymous2String1, int paramAnonymous2Int, String paramAnonymous2String2)
                  {
                    AppMethodBeat.i(287931);
                    Object localObject;
                    if (paramAnonymous2Int == -4000)
                    {
                      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "addTextOptionMenu:send addcontact.");
                      localObject = new com.tencent.mm.pluginsdk.ui.applet.a(SayHiWithSnsPermissionUI3.this, null);
                      if (SayHiWithSnsPermissionUI3.q(SayHiWithSnsPermissionUI3.this))
                      {
                        paramAnonymous2String1 = "";
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).content = paramAnonymous2String1;
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).np(str1, str2);
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).ReR = localHashMap;
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).chatroomName = SayHiWithSnsPermissionUI3.r(SayHiWithSnsPermissionUI3.this);
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).ReH = new a.b()
                        {
                          public final boolean m(String paramAnonymous3String1, int paramAnonymous3Int, String paramAnonymous3String2)
                          {
                            return true;
                          }
                        };
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).fgi = false;
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).ReU = paramAnonymous2String2;
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).ReQ = new aa.a()
                        {
                          public final void fqN()
                          {
                            AppMethodBeat.i(202901);
                            SayHiWithSnsPermissionUI3.s(SayHiWithSnsPermissionUI3.this);
                            AppMethodBeat.o(202901);
                          }
                          
                          public final void fqO()
                          {
                            SayHiWithSnsPermissionUI3 localSayHiWithSnsPermissionUI3 = SayHiWithSnsPermissionUI3.this;
                            localSayHiWithSnsPermissionUI3.HcE += 1;
                          }
                        };
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).ReU = paramAnonymous2String2;
                        com.tencent.mm.kernel.h.aHH();
                        paramAnonymous2String1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this));
                        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).a(SayHiWithSnsPermissionUI3.this, paramAnonymous2String1, SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this), localLinkedList1);
                        paramAnonymous2String1 = SayHiWithSnsPermissionUI3.this;
                        paramAnonymous2String2 = SayHiWithSnsPermissionUI3.this.getContext();
                        SayHiWithSnsPermissionUI3.this.getString(R.l.app_tip);
                        SayHiWithSnsPermissionUI3.a(paramAnonymous2String1, com.tencent.mm.ui.base.h.a(paramAnonymous2String2, SayHiWithSnsPermissionUI3.this.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
                        {
                          public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                          {
                            AppMethodBeat.i(291067);
                            this.HcR.hkc();
                            AppMethodBeat.o(291067);
                          }
                        }));
                      }
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(287931);
                      return true;
                      paramAnonymous2String1 = this.val$content;
                      break;
                      if (SayHiWithSnsPermissionUI3.q(SayHiWithSnsPermissionUI3.this))
                      {
                        paramAnonymous2String1 = SayHiWithSnsPermissionUI3.this;
                        bh.beI();
                        paramAnonymous2String2 = com.tencent.mm.model.c.bbL().RG(paramAnonymous2String1.userName);
                        label347:
                        boolean bool;
                        if (paramAnonymous2String2 != null)
                        {
                          paramAnonymous2String1.BAU = paramAnonymous2String1.getResources().getString(R.l.contact_info_verify_content, new Object[] { paramAnonymous2String2.field_nickname });
                          paramAnonymous2String1.mUM = View.inflate(paramAnonymous2String1, c.f.sendrequest_dialog, null);
                          if (paramAnonymous2String1.BAU != null) {
                            break label607;
                          }
                          bool = true;
                          label369:
                          if (paramAnonymous2String1.BAU != null) {
                            break label613;
                          }
                        }
                        label607:
                        label613:
                        for (paramAnonymous2Int = 0;; paramAnonymous2Int = paramAnonymous2String1.BAU.length())
                        {
                          Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "verifyTip is null: %b, length : %d, value : [%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramAnonymous2Int), paramAnonymous2String1.BAU });
                          if (!Util.isNullOrNil(paramAnonymous2String1.BAU)) {
                            ((TextView)paramAnonymous2String1.mUM.findViewById(c.e.sendrequest_tip)).setText(paramAnonymous2String1.BAU);
                          }
                          paramAnonymous2String1.HcG = paramAnonymous2String1.mUM.findViewById(c.e.edittext_container);
                          paramAnonymous2String1.qDO = ((EditText)paramAnonymous2String1.mUM.findViewById(c.e.sendrequest_content));
                          paramAnonymous2String1.HcF = ((TextView)paramAnonymous2String1.mUM.findViewById(c.e.wordcount));
                          paramAnonymous2String1.HcF.setVisibility(0);
                          paramAnonymous2String1.qDO.setText(null);
                          paramAnonymous2String1.HcF.setText("50");
                          paramAnonymous2String1.qDO.setVisibility(8);
                          paramAnonymous2String1.HcG.setVisibility(8);
                          paramAnonymous2String2 = new SayHiWithSnsPermissionUI3.9(paramAnonymous2String1);
                          localObject = new SayHiWithSnsPermissionUI3.11(paramAnonymous2String1);
                          paramAnonymous2String1.mUO = com.tencent.mm.ui.base.h.a(paramAnonymous2String1, "", paramAnonymous2String1.getString(c.h.contact_info_verify_accept), paramAnonymous2String1.mUM, paramAnonymous2String2, (DialogInterface.OnClickListener)localObject);
                          if (paramAnonymous2String1.mUO != null) {
                            break;
                          }
                          paramAnonymous2String1.onStop();
                          break;
                          paramAnonymous2String1.BAU = paramAnonymous2String1.getResources().getString(R.l.contact_info_verify_content_default);
                          break label347;
                          bool = false;
                          break label369;
                        }
                      }
                      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "dealAddContactError, resend request ver.");
                      paramAnonymous2String2 = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_user_name");
                      localObject = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("source_from_nick_name");
                      paramAnonymous2String1 = new aa(SayHiWithSnsPermissionUI3.this, null);
                      paramAnonymous2String1.content = this.val$content;
                      paramAnonymous2String1.nl(paramAnonymous2String2, (String)localObject);
                      paramAnonymous2String1.ReR = localHashMap;
                      paramAnonymous2String1.chatroomName = SayHiWithSnsPermissionUI3.r(SayHiWithSnsPermissionUI3.this);
                      paramAnonymous2String1.F(localLinkedList2, localLinkedList1);
                      paramAnonymous2String2 = SayHiWithSnsPermissionUI3.this;
                      localObject = SayHiWithSnsPermissionUI3.this.getContext();
                      SayHiWithSnsPermissionUI3.this.getString(R.l.app_tip);
                      SayHiWithSnsPermissionUI3.a(paramAnonymous2String2, com.tencent.mm.ui.base.h.a((Context)localObject, SayHiWithSnsPermissionUI3.this.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
                      {
                        public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                        {
                          AppMethodBeat.i(271168);
                          paramAnonymous2String1.hkc();
                          AppMethodBeat.o(271168);
                        }
                      }));
                    }
                  }
                };
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).fgi = false;
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).ReQ = new aa.a()
                {
                  public final void fqN()
                  {
                    AppMethodBeat.i(276113);
                    SayHiWithSnsPermissionUI3.s(SayHiWithSnsPermissionUI3.this);
                    AppMethodBeat.o(276113);
                  }
                  
                  public final void fqO()
                  {
                    SayHiWithSnsPermissionUI3 localSayHiWithSnsPermissionUI3 = SayHiWithSnsPermissionUI3.this;
                    localSayHiWithSnsPermissionUI3.HcE += 1;
                  }
                };
                com.tencent.mm.kernel.h.aHH();
                paramAnonymousView = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this));
                ((com.tencent.mm.pluginsdk.ui.applet.a)localObject2).a(SayHiWithSnsPermissionUI3.this, paramAnonymousView, SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this), localLinkedList1);
                paramAnonymousView = SayHiWithSnsPermissionUI3.this;
                localObject1 = SayHiWithSnsPermissionUI3.this.getContext();
                SayHiWithSnsPermissionUI3.this.getString(R.l.app_tip);
                SayHiWithSnsPermissionUI3.a(paramAnonymousView, com.tencent.mm.ui.base.h.a((Context)localObject1, SayHiWithSnsPermissionUI3.this.getString(R.l.sendrequest_sending), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(208679);
                    this.HcR.hkc();
                    AppMethodBeat.o(208679);
                  }
                }));
                break;
              }
            } while (!SayHiWithSnsPermissionUI3.t(SayHiWithSnsPermissionUI3.this));
            paramAnonymousView = SayHiWithSnsPermissionUI3.this.getIntent().getStringExtra("Verify_ticket");
            if (!SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this)) {
              if (SayHiWithSnsPermissionUI3.n(SayHiWithSnsPermissionUI3.this).YbZ)
              {
                j = 1;
                i = j;
                if (!SayHiWithSnsPermissionUI3.o(SayHiWithSnsPermissionUI3.this).YbZ) {}
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
                if (SayHiWithSnsPermissionUI3.p(SayHiWithSnsPermissionUI3.this))
                {
                  paramAnonymousView = new com.tencent.mm.openim.b.q(SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this), paramAnonymousView, i);
                  bh.aGY().a(paramAnonymousView, 0);
                  localObject1 = SayHiWithSnsPermissionUI3.this;
                  localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
                  SayHiWithSnsPermissionUI3.this.getString(R.l.app_tip);
                  SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(R.l.eys), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(290579);
                      bh.aGY().a(paramAnonymousView);
                      AppMethodBeat.o(290579);
                    }
                  }));
                  break;
                }
                paramAnonymousView = new com.tencent.mm.pluginsdk.model.t(SayHiWithSnsPermissionUI3.k(SayHiWithSnsPermissionUI3.this), paramAnonymousView, SayHiWithSnsPermissionUI3.l(SayHiWithSnsPermissionUI3.this), SayHiWithSnsPermissionUI3.r(SayHiWithSnsPermissionUI3.this), i);
                bh.aGY().a(paramAnonymousView, 0);
                localObject1 = SayHiWithSnsPermissionUI3.this;
                localObject2 = SayHiWithSnsPermissionUI3.this.getContext();
                SayHiWithSnsPermissionUI3.this.getString(R.l.app_tip);
                SayHiWithSnsPermissionUI3.a((SayHiWithSnsPermissionUI3)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, SayHiWithSnsPermissionUI3.this.getString(R.l.eys), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(288330);
                    bh.aGY().a(paramAnonymousView);
                    AppMethodBeat.o(288330);
                  }
                }));
                break;
              }
              j = 0;
              break label836;
            }
            j = 0;
            break;
          }
        }
      });
      this.Hco.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(286678);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(286678);
            return false;
            SayHiWithSnsPermissionUI3.this.HcA[0] = true;
            com.tencent.mm.plugin.normsg.a.d.GxJ.av("ce_ver_usr", "<VerifyUsr>", this.HcL);
            continue;
            com.tencent.mm.plugin.normsg.a.d.GxJ.a("ce_ver_usr", paramAnonymousMotionEvent);
            com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_ver_usr");
          }
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(278298);
          if (SayHiWithSnsPermissionUI3.t(SayHiWithSnsPermissionUI3.this)) {
            SayHiWithSnsPermissionUI3.u(SayHiWithSnsPermissionUI3.this)[1] = 1;
          }
          SayHiWithSnsPermissionUI3.this.finish();
          SayHiWithSnsPermissionUI3.v(SayHiWithSnsPermissionUI3.this);
          SayHiWithSnsPermissionUI3.this.Ph(2L);
          AppMethodBeat.o(278298);
          return true;
        }
      });
      this.Hco.setTextColor(getResources().getColor(a.d.BW_0_Alpha_0_2));
      this.Hco.setBackground(getDrawable(a.f.btn_solid_white));
      if (!this.HbI) {
        fqP();
      }
      this.jij = new com.tencent.mm.ui.tools.i(this);
      this.jij.XSx = this;
      if (this.Hch)
      {
        setMMTitle(R.l.ePX);
        if ((this.HbZ != null) && ((LinearLayout)this.HbZ.getParent() != null)) {
          ((LinearLayout)this.HbZ.getParent()).setVisibility(8);
        }
      }
      i = getIntent().getIntExtra("Contact_default_permission", -1);
      if ((!this.Hcg) && (i > 0)) {
        fqP();
      }
      AppMethodBeat.o(274514);
      return;
    }
    this.Hcn = ((TextView)findViewById(R.h.dBe));
    this.Hcn.setVisibility(0);
    this.Hcm = ((LinearLayout)findViewById(R.h.dBf));
    this.Hcl = ((ImageView)findViewById(R.h.drW));
    if (this.Hcl != null) {
      this.Hcl.setImageDrawable(com.tencent.mm.ui.au.o(this, R.k.icons_outlined_arrow, com.tencent.mm.ci.a.w(getContext(), R.e.BW_70)));
    }
    this.Hcm.setOnClickListener(new SayHiWithSnsPermissionUI3.3(this));
    this.jbL = ((ScrollView)findViewById(R.h.scrollView));
    this.EeB = findViewById(R.h.dKI);
    this.EeB.setBackgroundDrawable(null);
    this.EeB.setVisibility(0);
    this.Hci = e.eLd().hyg();
    if (this.Hcj != null)
    {
      bh.beI();
      localObject1 = com.tencent.mm.model.c.bbM().aPj(this.userName);
      if (localObject1 != null)
      {
        localObject1 = ((co)localObject1).field_contactLabels;
        label1733:
        localObject3 = localObject1;
        if (Util.isNullOrNil((String)localObject1))
        {
          bh.beI();
          localObject4 = com.tencent.mm.model.c.bbL().RG(this.userName);
          localObject3 = ((com.tencent.mm.f.c.ax)localObject4).field_encryptUsername;
          localObject2 = localObject1;
          if (!Util.isNullOrNil((String)localObject3))
          {
            bh.beI();
            localObject3 = com.tencent.mm.model.c.bbM().aPj((String)localObject3);
            localObject2 = localObject1;
            if (localObject3 != null) {
              localObject2 = ((co)localObject3).field_contactLabels;
            }
          }
          localObject3 = localObject2;
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject1 = ((com.tencent.mm.f.c.ax)localObject4).field_username;
            bh.beI();
            localObject1 = com.tencent.mm.model.c.bbM().aPj((String)localObject1);
            localObject3 = localObject2;
            if (localObject1 != null) {
              localObject3 = ((co)localObject1).field_contactLabels;
            }
          }
        }
      }
    }
    for (Object localObject1 = (ArrayList)com.tencent.mm.plugin.label.a.a.eLe().aMP((String)localObject3);; localObject1 = null)
    {
      if (localObject1 != null) {
        this.Hcj.addAll((Collection)localObject1);
      }
      if (this.Hci != null) {
        this.Hcu = this.Hci.size();
      }
      if (localObject1 != null)
      {
        this.Hcv = ((ArrayList)localObject1).size();
        this.Hcw.addAll((Collection)localObject1);
      }
      gw((List)localObject1);
      break;
      label1934:
      bool = false;
      break label261;
      label1939:
      bool = false;
      break label332;
      label1944:
      if (i != 2) {
        break label580;
      }
      ((TextView)localObject1).setText(R.l.sns_outside_permiss_female);
      break label580;
      label1959:
      if (i != 2) {
        break label603;
      }
      ((TextView)localObject1).setText(R.l.sns_black_permiss_female);
      break label603;
      label1974:
      ((View)this.Hdb.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(287029);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this))
          {
            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, Boolean.FALSE);
            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).booleanValue());
            SayHiWithSnsPermissionUI3.this.fqP();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(287029);
        }
      });
      localObject2 = (View)this.Hdc.getParent();
      if (this.HbJ) {}
      for (localObject1 = null;; localObject1 = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(286100);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (!SayHiWithSnsPermissionUI3.c(SayHiWithSnsPermissionUI3.this))
              {
                SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, Boolean.TRUE);
                SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).booleanValue());
                SayHiWithSnsPermissionUI3.this.fqP();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(286100);
            }
          })
      {
        ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
        i = getIntent().getIntExtra("Contact_default_permission", -1);
        if (i <= 0) {
          break;
        }
        if ((i & 0x8) != 8) {
          break label2080;
        }
        this.Hdd = Boolean.FALSE;
        wd(this.Hdd.booleanValue());
        break;
      }
      label2080:
      this.Hdd = Boolean.TRUE;
      wd(this.Hdd.booleanValue());
      break label650;
      label2101:
      localObject1 = l.b(getContext(), (CharSequence)localObject2, this.HbZ.getTextSize());
      this.HbZ.setText((CharSequence)localObject1);
      break label1061;
      label2129:
      setMMTitle(R.l.ePZ);
      break label1164;
      label2139:
      if (!Util.isNullOrNil(this.nickName))
      {
        this.Hca.setHint(l.b(getContext(), this.nickName, this.Hca.getTextSize()));
        this.Hca.setOnFocusChangeListener(new SayHiWithSnsPermissionUI3.15(this));
      }
      switch (this.mXL)
      {
      case 9: 
      case 12: 
      default: 
        i = 0;
      }
      while ((!this.Hcd) && (i == 0))
      {
        localObject1 = com.tencent.mm.bl.d.bqb().bwU(this.userName);
        if (localObject1 == null) {
          break;
        }
        localObject2 = com.tencent.mm.pluginsdk.ui.preference.b.c(this, (bn)localObject1);
        if ((Util.isNullOrNil(((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).lpM)) || (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).lpM.equals(getString(R.l.eFl)))) {
          break;
        }
        localObject3 = getString(R.l.sendgreeting_content).substring(0, getString(R.l.sendgreeting_content).indexOf("%s"));
        localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).lpM;
        if (((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).lpM.startsWith((String)localObject3)) {
          localObject1 = ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).lpM.substring(((String)localObject3).length());
        }
        this.Hcb.setVisibility(0);
        this.Hcc.setText(l.b(this, Util.nullAsNil(getString(R.l.ezp, new Object[] { ((com.tencent.mm.pluginsdk.ui.preference.b)localObject2).lpM })), this.Hcc.getTextSize()));
        localObject2 = new com.tencent.mm.pluginsdk.ui.span.m(getString(R.l.write_contact_remark));
        ((com.tencent.mm.pluginsdk.ui.span.m)localObject2).setSpan(new SayHiWithSnsPermissionUI3.a(this, (String)localObject1), 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject2).length(), 17);
        this.Hcc.append(" ");
        this.Hcc.append((CharSequence)localObject2);
        this.Hcc.setMovementMethod(LinkMovementMethod.getInstance());
        this.nei[3] = 3;
        break;
        localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(this.userName);
        if ((localObject1 == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxT())) || (((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxT().equals(this.Hca.getText().toString())))
        {
          i = 0;
        }
        else
        {
          this.Hcb.setVisibility(0);
          this.Hcc.setText(l.b(this, Util.nullAsNil(getString(R.l.ezo, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxT() })), this.Hcc.getTextSize()));
          localObject2 = new com.tencent.mm.pluginsdk.ui.span.m(getString(R.l.write_contact_remark));
          ((com.tencent.mm.pluginsdk.ui.span.m)localObject2).setSpan(new SayHiWithSnsPermissionUI3.a(this, ((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxT()), 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject2).length(), 17);
          this.Hcc.append(" ");
          this.Hcc.append((CharSequence)localObject2);
          this.Hcc.setMovementMethod(LinkMovementMethod.getInstance());
          this.nei[3] = 1;
          i = 1;
          continue;
          if ((Util.isNullOrNil(this.GsA)) || (this.GsA.equals(this.Hca.getText().toString())))
          {
            i = 0;
          }
          else
          {
            this.Hcb.setVisibility(0);
            this.Hcc.setText(l.b(this, Util.nullAsNil(getString(R.l.ezn, new Object[] { this.GsA })), this.Hcc.getTextSize()));
            localObject1 = new com.tencent.mm.pluginsdk.ui.span.m(getString(R.l.write_contact_remark));
            ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).setSpan(new SayHiWithSnsPermissionUI3.a(this, this.GsA), 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).length(), 17);
            this.Hcc.append(" ");
            this.Hcc.append((CharSequence)localObject1);
            this.Hcc.setMovementMethod(LinkMovementMethod.getInstance());
            this.nei[3] = 2;
            i = 1;
          }
        }
      }
      label2823:
      break label1329;
      label2826:
      break label815;
      localObject1 = null;
      break label1733;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(274516);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 != -1) || (paramIntent == null))
    {
      AppMethodBeat.o(274516);
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
      Object localObject1 = com.tencent.mm.plugin.label.a.a.eLe().eLb();
      if ((!t(localArrayList, this.Hcj)) && (!t((List)localObject1, this.Hci)))
      {
        AppMethodBeat.o(274516);
        return;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "cpan[All onActivityResult], labelLists: %s", new Object[] { localArrayList });
      if (localObject1 == null) {
        localObject1 = new ArrayList();
      }
      for (;;)
      {
        if (this.Hci == null) {
          this.Hci = new ArrayList();
        }
        Object localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if ((!this.Hci.contains(str)) && (!this.Hck.contains(str))) {
            this.Hck.add(str);
          }
        }
        this.Hci = ((List)localObject1);
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (this.Hci.contains(localObject2)) {
            this.Hci.remove(localObject2);
          }
        }
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.Hci);
        this.Hci.clear();
        this.Hci.addAll(localArrayList);
        this.Hci.addAll((Collection)localObject1);
        this.Hcj.clear();
        this.Hcj.addAll(localArrayList);
        localObject1 = paramIntent.getStringArrayListExtra("contact_search_label_new_list");
        if (localObject1 != null) {
          this.Hcx.addAll((Collection)localObject1);
        }
        localObject1 = paramIntent.getStringArrayListExtra("contact_search_label_add_list");
        if (localObject1 != null) {
          this.EeR.addAll((Collection)localObject1);
        }
        localObject1 = paramIntent.getStringArrayListExtra("contact_select_label_add_list");
        if (localObject1 != null) {
          this.EeT.addAll((Collection)localObject1);
        }
        paramIntent = paramIntent.getStringArrayListExtra("contact_select_label_new_list");
        if (paramIntent != null) {
          this.EeS.addAll(paramIntent);
        }
        Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "cpan[All onActivityResult], labelLists: %s, mCurrentSelectLabelStrList: %s,mAllCanShowLabelStrList:%s.", new Object[] { localArrayList, this.Hcj, this.Hci });
        gw(this.Hcj);
        AppMethodBeat.o(274516);
        return;
        AppMethodBeat.o(274516);
        return;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(274495);
    super.onCreate(paramBundle);
    setActionbarColor(getContext().getResources().getColor(R.e.white));
    hideActionbarLine();
    initView();
    bh.aGY().a(30, this);
    bh.aGY().a(243, this);
    bh.aGY().a(853, this);
    AppMethodBeat.o(274495);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(274507);
    bh.aGY().b(30, this);
    bh.aGY().b(243, this);
    bh.aGY().b(853, this);
    com.tencent.mm.plugin.report.service.h.IzE.a(14036, new Object[] { Integer.valueOf(this.nei[0]), Integer.valueOf(this.nei[1]), Integer.valueOf(this.nei[2]), Integer.valueOf(this.nei[3]), Integer.valueOf(this.nei[4]), Integer.valueOf(this.nei[5]), Integer.valueOf(this.nei[6]), Integer.valueOf(this.nei[7]), this.userName });
    super.onDestroy();
    removeAllOptionMenu();
    com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_ver_usr");
    if (this.jij != null) {
      this.jij.close();
    }
    AppMethodBeat.o(274507);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(274522);
    if (paramInt == 4)
    {
      this.nei[0] = 1;
      finish();
      wc(false);
      AppMethodBeat.o(274522);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(274522);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(274501);
    bh.aGY().b(635, this);
    if (this.jij != null) {
      this.jij.close();
    }
    super.onPause();
    AppMethodBeat.o(274501);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(274499);
    super.onResume();
    bh.aGY().a(635, this);
    if (this.jij != null) {
      this.jij.start();
    }
    AppMethodBeat.o(274499);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(274519);
    long l1 = System.currentTimeMillis();
    Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    Object localObject;
    try
    {
      if (this.iXX != null)
      {
        this.iXX.dismiss();
        this.iXX = null;
      }
      if ((paramq instanceof com.tencent.mm.pluginsdk.model.t))
      {
        Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "onSceneEnd: getopCode: %s.", new Object[] { Integer.valueOf(((com.tencent.mm.pluginsdk.model.t)paramq).fDn) });
        if (((paramInt1 != 0) || (paramInt2 != 0)) && (((com.tencent.mm.pluginsdk.model.t)paramq).fDn == 1)) {
          Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "onSceneEnd:is MM_VERIFYUSER_ADDCONTACT return");
        }
      }
      else
      {
        Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "onSceneEnd: is no NetSceneVerifyUser.");
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "sendrequest_second");
      fqM();
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label1276;
      }
      com.tencent.mm.ui.base.h.cO(this, getString(R.l.sendrequest_send_success));
      com.tencent.mm.plugin.account.friend.a.au.bb(this.userName, 1);
      paramString = new se();
      paramString.fRL.username = this.userName;
      paramString.fRL.type = 1;
      EventCenter.instance.publish(paramString);
      if ((this.mXL == 17) && ((paramq instanceof com.tencent.mm.pluginsdk.model.t)))
      {
        long l2 = getIntent().getLongExtra("key_msg_id", 0L);
        if (l2 > 0L)
        {
          paramString = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(l2);
          if (paramString.field_msgId > 0L)
          {
            paramString.hzS();
            ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().a(l2, paramString);
          }
        }
      }
      if (!this.Hce) {
        break label975;
      }
      paramString = fqL();
      if (Util.isNullOrNil(paramString)) {
        break label1082;
      }
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "set temp remark of %s", new Object[] { this.userName });
      bh.beI();
      localObject = com.tencent.mm.model.c.bbL().RG(this.userName);
      ((as)localObject).Ir(paramString);
      bh.beI();
      co localco = com.tencent.mm.model.c.bbM().aPj(this.userName);
      localco.field_encryptUsername = this.userName;
      localco.field_conRemark = paramString;
      bh.beI();
      com.tencent.mm.model.c.bbM().replace(localco);
      bh.beI();
      com.tencent.mm.model.c.bbL().au((as)localObject);
      this.nei[2] = 1;
      if ((!Util.isNullOrNil(this.nickName)) && (!paramString.equals(this.nickName))) {
        this.nei[5] = 1;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label660:
        label739:
        Log.e("MicroMsg.SayHiWithSnsPermissionUI3", "exception in onSceneEnd : " + paramString.getMessage());
        label810:
        label975:
        return;
        label1050:
        label1082:
        this.nei[2] = 2;
      }
    }
    finally
    {
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(274519);
    }
    paramString = new LinkedList();
    if ((paramq instanceof com.tencent.mm.pluginsdk.model.t))
    {
      paramInt1 = ((com.tencent.mm.pluginsdk.model.t)paramq).fDn;
      paramString = ((com.tencent.mm.pluginsdk.model.t)paramq).QVu;
      if ((paramInt1 == 3) || ((paramq instanceof com.tencent.mm.openim.b.q)))
      {
        localObject = com.tencent.mm.bl.d.bqb().bwU(this.userName);
        bh.beI();
        paramq = com.tencent.mm.model.c.bbL().RG(this.userName);
        if ((paramString != null) && (paramString.contains(this.userName)))
        {
          paramString = paramq;
          if ((int)paramq.jxt != 0) {
            break label1231;
          }
          paramq = com.tencent.mm.pluginsdk.ui.preference.b.a((bn)localObject);
          paramq.setUsername(this.userName);
          bh.beI();
          paramString = paramq;
          if (com.tencent.mm.model.c.bbL().av(paramq)) {
            break label1231;
          }
          Log.e("MicroMsg.SayHiWithSnsPermissionUI3", "canAddContact fail, insert fail");
        }
        bh.beI();
        paramString = com.tencent.mm.model.c.bbL().RG(this.userName);
        paramq = new xc();
        paramq.fVZ.fWb = true;
        paramq.fVZ.fWa = false;
        paramq.fVZ.username = this.userName;
        EventCenter.instance.publish(paramq);
        if (!this.HbE.YbZ) {
          break label1269;
        }
        ab.B(paramString);
        paramString = new xc();
        paramString.fVZ.fWb = false;
        paramString.fVZ.fWa = true;
        paramString.fVZ.username = this.userName;
        bool = aUR(this.userName);
        paramString.fVZ.fWc = bool;
        localObject = this.userName;
        if (this.HbF.YbZ) {
          break label1694;
        }
        paramInt1 = 2;
        paramq = new LinkedList();
        paramq.add(localObject);
        localObject = new qp();
        ((qp)localObject).fPl.list = paramq;
        ((qp)localObject).fPl.fCN = paramInt1;
        ((qp)localObject).fPl.fPm = 5L;
        EventCenter.instance.publish((IEvent)localObject);
        EventCenter.instance.publish(paramString);
        if (getIntent().getBooleanExtra("sayhi_with_jump_to_profile", false))
        {
          paramString = new Intent();
          paramString.putExtra("friend_message_transfer_username", this.userName);
          paramString.setAction("friend_message_accept_" + this.userName);
          paramString.putExtra("MMActivity.OverrideEnterAnimation", R.a.slide_right_in);
          paramString.putExtra("MMActivity.OverrideExitAnimation", R.a.slide_left_out);
          com.tencent.mm.by.c.b(this, "subapp", ".ui.friend.FMessageTransferUI", paramString);
        }
      }
      getIntent().putExtra("CONTACT_INFO_UI_SOURCE", 7);
      com.tencent.mm.plugin.profile.d.a(getIntent(), 1, 1, this.userName);
      setResult(-1, getIntent());
      finish();
      wc(true);
      Ph(1L);
      if ((this.HcB & 0x8) == 0) {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCJ, Integer.valueOf(0));
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.SayHiWithSnsPermissionUI3", "[onCreate] %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(274519);
      return;
      if (!Util.isNullOrNil(this.nickName))
      {
        this.nei[2] = 0;
        break;
      }
      if (!(paramq instanceof com.tencent.mm.openim.b.q)) {
        break label1689;
      }
      paramString.add(((com.tencent.mm.openim.b.q)paramq).myd);
      break label1689;
      label1231:
      ab.H(paramString);
      bh.getNotification().aqY();
      com.tencent.mm.bl.d.bqc().hx(this.userName, 1);
      com.tencent.mm.pluginsdk.ui.preference.b.cX(this.userName, this.mXL);
      break label660;
      label1269:
      ab.C(paramString);
      break label739;
      label1276:
      if ((paramInt1 != 4) || (paramInt2 != -24) || (Util.isNullOrNil(paramString))) {
        break label1699;
      }
      Toast.makeText(this, paramString, 1).show();
      continue;
      label1306:
      if (!Util.isNullOrNil(paramString))
      {
        com.tencent.mm.ui.base.h.a(this, paramString, "", getString(R.l.app_ok), null);
      }
      else
      {
        label1333:
        if ((!this.Hcd) || ((paramInt2 != -24) && (paramInt2 != -34))) {
          break label1366;
        }
        Toast.makeText(this, R.l.fmessage_request_too_offen, 0).show();
      }
    }
    label1366:
    if ((paramInt1 == 4) && (paramInt2 == -3400) && (this.HbI))
    {
      this.HbJ = true;
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCJ, Integer.valueOf(1));
      if (!Util.isNullOrNil(paramString)) {
        this.HbQ.setText(paramString);
      }
      if ((this.Hcf) || (this.HbJ)) {
        break label1719;
      }
    }
    label1689:
    label1694:
    label1699:
    label1719:
    for (boolean bool = true;; bool = false)
    {
      this.Hdd = Boolean.valueOf(bool);
      this.Hdb.setVisibility(0);
      this.Hdc.setVisibility(0);
      wd(this.Hdd.booleanValue());
      ((View)this.Hdb.getParent()).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(264324);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, Boolean.FALSE);
          SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).booleanValue());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(264324);
        }
      });
      localObject = (View)this.Hdc.getParent();
      if (this.HbJ)
      {
        paramq = null;
        label1517:
        ((View)localObject).setOnClickListener(paramq);
        findViewById(R.h.dPA).setVisibility(8);
        paramq = (TextView)findViewById(R.h.dVv);
        if (!this.HbJ) {
          break label1661;
        }
      }
      label1661:
      for (paramInt1 = getResources().getColor(R.e.hint_text_color);; paramInt1 = getResources().getColor(R.e.normal_text_color))
      {
        paramq.setTextColor(paramInt1);
        if (this.HbJ) {
          this.HbQ.setVisibility(0);
        }
        this.Hcf = false;
        paramq = new f.a(this);
        paramq.bBl(paramString).HL(true).bBq(getString(R.l.ePC)).ayp(R.l.ePD);
        paramq.c(new SayHiWithSnsPermissionUI3.4(this)).show();
        break;
        paramq = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(272898);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, Boolean.TRUE);
            SayHiWithSnsPermissionUI3.a(SayHiWithSnsPermissionUI3.this, SayHiWithSnsPermissionUI3.b(SayHiWithSnsPermissionUI3.this).booleanValue());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(272898);
          }
        };
        break label1517;
      }
      Toast.makeText(this, R.l.sendrequest_send_fail, 0).show();
      break label1050;
      paramInt1 = 0;
      break;
      paramInt1 = 1;
      break label810;
      if (paramInt1 != 4) {
        break label1333;
      }
      if (paramInt2 == -2) {
        break label1306;
      }
      if (paramInt2 != -101) {
        break label1333;
      }
      break label1306;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(274503);
    super.onStop();
    AppMethodBeat.o(274503);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(274505);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.jij != null) {
      this.jij.start();
    }
    AppMethodBeat.o(274505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3
 * JD-Core Version:    0.7.0.1
 */