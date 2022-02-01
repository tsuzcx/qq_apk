package com.tencent.mm.ui.contact;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.DialogInterface;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.ma;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMClearEditText.b;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText.b;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ModRemarkNameUI
  extends MMActivity
  implements com.tencent.mm.am.h, com.tencent.mm.ui.tools.h
{
  private View CzL;
  private String IMS;
  private boolean JVi;
  private HashSet<String> JWF;
  private HashSet<String> JWG;
  private HashSet<String> JWH;
  private ObjectAnimator JWJ;
  private m JWf;
  private String MWK;
  private String NaB;
  private String NaC;
  private int NaD;
  private boolean NaE;
  private int NaF;
  private int NaG;
  private List<String> NaH;
  private HashSet<String> NaI;
  private List<String> Nau;
  private ImageView Nax;
  private LinearLayout Nay;
  private TextView Naz;
  private cr NsP;
  private ScrollView afcV;
  private TextView afdc;
  private View afdd;
  private List<String> afdm;
  private HashSet<String> afdo;
  private TextView affA;
  private int affB;
  private String affC;
  private int affD;
  private TextView affE;
  private EditText affF;
  private TextView affG;
  private String affH;
  private boolean affI;
  private ModRemarkNameUI.a affJ;
  private View affK;
  private TextView affL;
  private MMClearEditText affz;
  private au contact;
  private long hTS;
  private String hVQ;
  private com.tencent.mm.ui.tools.i lKz;
  private int pUt;
  private String remark;
  
  public ModRemarkNameUI()
  {
    AppMethodBeat.i(37872);
    this.affC = "";
    this.remark = "";
    this.affD = -1;
    this.JVi = false;
    this.affE = null;
    this.affF = null;
    this.affG = null;
    this.affH = "";
    this.affI = false;
    this.pUt = 9;
    this.affJ = new ModRemarkNameUI.a(this, (byte)0);
    this.NaD = 0;
    this.Nau = new ArrayList();
    this.NaH = new ArrayList();
    this.afdm = new ArrayList();
    this.afdo = new HashSet();
    this.NaI = new HashSet();
    this.JWF = new HashSet();
    this.JWG = new HashSet();
    this.JWH = new HashSet();
    this.JWJ = null;
    AppMethodBeat.o(37872);
  }
  
  private static boolean H(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(253062);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramList1 != null) {
      localArrayList1.addAll(paramList1);
    }
    if (paramList2 != null) {
      localArrayList2.addAll(paramList2);
    }
    Collections.sort(localArrayList1);
    Collections.sort(localArrayList2);
    if (localArrayList1.equals(localArrayList2))
    {
      AppMethodBeat.o(253062);
      return false;
    }
    AppMethodBeat.o(253062);
    return true;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(253051);
    boolean bool1 = jyY();
    boolean bool2 = jyn();
    if ((bool1) || (bool2))
    {
      k.b(this, getString(R.l.gBO), null, getString(R.l.gBQ), getString(R.l.gBP), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(253015);
          ModRemarkNameUI.d(ModRemarkNameUI.this);
          AppMethodBeat.o(253015);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(253016);
          ModRemarkNameUI.this.finish();
          ModRemarkNameUI.this.hm(2L);
          AppMethodBeat.o(253016);
        }
      });
      AppMethodBeat.o(253051);
      return;
    }
    finish();
    hm(2L);
    AppMethodBeat.o(253051);
  }
  
  private void jw(List<String> paramList)
  {
    AppMethodBeat.i(253059);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.Naz.setText("");
      AppMethodBeat.o(253059);
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
    AppMethodBeat.o(253059);
  }
  
  private boolean jyY()
  {
    AppMethodBeat.i(253048);
    String str2 = this.affz.getText().toString().trim();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    if (this.affB == 0)
    {
      if (this.affD == 1)
      {
        if (Util.isNullOrNil(str1))
        {
          if (this.JVi)
          {
            AppMethodBeat.o(253048);
            return true;
          }
          AppMethodBeat.o(253048);
          return false;
        }
        AppMethodBeat.o(253048);
        return true;
      }
      if (this.affD == 2)
      {
        if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(this.NaB)))
        {
          AppMethodBeat.o(253048);
          return false;
        }
        if (!str1.equals(this.NaB))
        {
          AppMethodBeat.o(253048);
          return true;
        }
        AppMethodBeat.o(253048);
        return false;
      }
    }
    if ((this.affB == 3) && (!Util.isNullOrNil(this.NaB)))
    {
      if (!this.NaB.equals(str1))
      {
        AppMethodBeat.o(253048);
        return true;
      }
      AppMethodBeat.o(253048);
      return false;
    }
    if (((this.remark == null) || (!this.remark.equals(str1))) && ((!Util.isNullOrNil(this.remark)) || (!Util.isNullOrNil(str1))))
    {
      AppMethodBeat.o(253048);
      return true;
    }
    AppMethodBeat.o(253048);
    return false;
  }
  
  private boolean jyn()
  {
    AppMethodBeat.i(253044);
    String str = this.affF.getText().toString().trim();
    if (((this.affH == null) || (!this.affH.equals(str))) && ((!Util.isNullOrNil(this.affH)) || (!Util.isNullOrNil(str))))
    {
      AppMethodBeat.o(253044);
      return true;
    }
    AppMethodBeat.o(253044);
    return false;
  }
  
  private void jyq()
  {
    AppMethodBeat.i(253057);
    List localList = null;
    bh.bCz();
    this.NsP = com.tencent.mm.model.c.bzB().aMi(this.hVQ);
    if (this.NsP != null)
    {
      this.MWK = this.NsP.field_contactLabels;
      localList = com.tencent.mm.plugin.label.a.a.fTb().aJI(this.MWK);
    }
    if (this.Nau == null) {
      this.Nau = new ArrayList();
    }
    this.NaH.clear();
    this.Nau.clear();
    this.afdm.clear();
    if (localList != null)
    {
      this.Nau.addAll(localList);
      this.NaH.addAll(localList);
      this.afdm.addAll(localList);
    }
    for (;;)
    {
      localList = com.tencent.mm.plugin.label.a.a.fTb().fSY();
      if (localList == null) {
        break;
      }
      int i = 0;
      while (i < localList.size())
      {
        if (!this.Nau.contains(localList.get(i))) {
          this.Nau.add((String)localList.get(i));
        }
        i += 1;
      }
      new ArrayList();
    }
    jw(this.NaH);
    this.NaF = localList.size();
    this.NaG = this.NaH.size();
    this.afdo.addAll(this.NaH);
    AppMethodBeat.o(253057);
  }
  
  private List<EditText> lU(View paramView)
  {
    AppMethodBeat.i(253054);
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        View localView = paramView.getChildAt(i);
        if (((localView instanceof EditText)) && (((EditText)localView).isFocused())) {
          localArrayList.add((EditText)localView);
        }
        localArrayList.addAll(lU(localView));
        i += 1;
      }
    }
    AppMethodBeat.o(253054);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return R.i.gmj;
  }
  
  public final void hm(final long paramLong)
  {
    AppMethodBeat.i(253231);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(253010);
        ma localma = new ma();
        Object localObject1 = ModRemarkNameUI.l(ModRemarkNameUI.this);
        localma.uI(ModRemarkNameUI.m(ModRemarkNameUI.this));
        long l;
        Object localObject2;
        int i;
        label67:
        String str;
        if (ModRemarkNameUI.n(ModRemarkNameUI.this))
        {
          l = 1L;
          localma.jaJ = l;
          localObject2 = ((List)localObject1).iterator();
          i = 0;
          if (!((Iterator)localObject2).hasNext()) {
            break label117;
          }
          str = (String)((Iterator)localObject2).next();
          if (!ModRemarkNameUI.o(ModRemarkNameUI.this).contains(str)) {
            break label916;
          }
          i += 1;
        }
        label904:
        label907:
        label910:
        label913:
        label916:
        for (;;)
        {
          break label67;
          l = 0L;
          break;
          label117:
          localma.jaL = i;
          l = 0L;
          localObject2 = ((List)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (ModRemarkNameUI.p(ModRemarkNameUI.this).contains(str)) {
              l += 1L;
            }
          }
          localma.jaN = l;
          localObject2 = ((List)localObject1).iterator();
          int j = 0;
          if (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            if (!ModRemarkNameUI.q(ModRemarkNameUI.this).contains(str)) {
              break label913;
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
              if (!ModRemarkNameUI.r(ModRemarkNameUI.this).contains(str)) {
                break label910;
              }
              k += 1;
            }
            for (;;)
            {
              break;
              localma.jaK = k;
              localma.iGM = (System.currentTimeMillis() - ModRemarkNameUI.s(ModRemarkNameUI.this));
              localma.jaR = ModRemarkNameUI.t(ModRemarkNameUI.this);
              localma.jaS = paramLong;
              localma.jaO = ModRemarkNameUI.u(ModRemarkNameUI.this);
              int i1 = ModRemarkNameUI.this.getIntent().getIntExtra("key_label_click_source", 0);
              if (i1 != 0) {
                localma.aIQ();
              }
              int n = 0;
              localObject2 = ((List)localObject1).iterator();
              int m = 0;
              if (((Iterator)localObject2).hasNext())
              {
                str = (String)((Iterator)localObject2).next();
                if (ModRemarkNameUI.v(ModRemarkNameUI.this).contains(str)) {
                  break label907;
                }
                m += 1;
              }
              for (;;)
              {
                break;
                localObject2 = ModRemarkNameUI.v(ModRemarkNameUI.this).iterator();
                if (((Iterator)localObject2).hasNext())
                {
                  if (((List)localObject1).contains((String)((Iterator)localObject2).next())) {
                    break label904;
                  }
                  n += 1;
                }
                for (;;)
                {
                  break;
                  localma.iuA = 3L;
                  localObject2 = ModRemarkNameUI.a(ModRemarkNameUI.this).getText().toString().trim();
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = "";
                  }
                  if (!ab.isNullOrNil(ModRemarkNameUI.w(ModRemarkNameUI.this))) {
                    if (ModRemarkNameUI.w(ModRemarkNameUI.this).equals(localObject1)) {
                      ModRemarkNameUI.a(ModRemarkNameUI.this, 3);
                    }
                  }
                  for (;;)
                  {
                    localma.jaT = ModRemarkNameUI.z(ModRemarkNameUI.this);
                    localma.jaQ = m;
                    localma.jaP = n;
                    localma.bMH();
                    Log.i("MiroMsg.ModRemarkName", "22865 setAddedLabelCnt = " + m + ",setRemovedLabelCnt = " + n + ",source = " + i1 + ",oriLabelCnt = " + ModRemarkNameUI.u(ModRemarkNameUI.this) + ",opResult = " + paramLong + ",totalLabelCnt = " + ModRemarkNameUI.t(ModRemarkNameUI.this) + ",selectNewLabelCnt = " + k + ",addRemarkType = " + ModRemarkNameUI.z(ModRemarkNameUI.this) + ",scene= 3,selectAddLabelCnt = " + j + ",newLebalCountBySearch = " + i + ",searchAddLabelCnt = " + l);
                    AppMethodBeat.o(253010);
                    return;
                    ModRemarkNameUI.a(ModRemarkNameUI.this, 2);
                    continue;
                    if (!ModRemarkNameUI.x(ModRemarkNameUI.this)) {
                      ModRemarkNameUI.a(ModRemarkNameUI.this, 3);
                    } else if (!ab.isNullOrNil(ModRemarkNameUI.y(ModRemarkNameUI.this)))
                    {
                      if (ModRemarkNameUI.y(ModRemarkNameUI.this).equals(localObject1)) {
                        ModRemarkNameUI.a(ModRemarkNameUI.this, 1);
                      } else if (Util.isNullOrNil((String)localObject1)) {
                        ModRemarkNameUI.a(ModRemarkNameUI.this, 3);
                      } else {
                        ModRemarkNameUI.a(ModRemarkNameUI.this, 2);
                      }
                    }
                    else if (((String)localObject1).equals(ModRemarkNameUI.y(ModRemarkNameUI.this))) {
                      ModRemarkNameUI.a(ModRemarkNameUI.this, 3);
                    } else {
                      ModRemarkNameUI.a(ModRemarkNameUI.this, 2);
                    }
                  }
                }
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(253231);
  }
  
  public void initView()
  {
    AppMethodBeat.i(37874);
    this.hVQ = getIntent().getStringExtra("Contact_User");
    if ((this.hVQ != null) && (this.hVQ.length() > 0))
    {
      bh.bCz();
      this.contact = com.tencent.mm.model.c.bzA().JE(this.hVQ);
      bh.bCz();
      this.NsP = com.tencent.mm.model.c.bzB().aMi(this.hVQ);
      if ((this.contact == null) || (Util.isNullOrNil(this.contact.field_username)))
      {
        this.contact = new au(this.hVQ);
        this.contact.setNickname(Util.nullAsNil(this.affC));
        this.contact.AW(Util.nullAsNil(this.remark));
      }
    }
    this.afcV = ((ScrollView)findViewById(R.h.scrollview));
    this.affA = ((TextView)findViewById(R.h.title_area_container));
    this.affz = ((MMClearEditText)findViewById(R.h.fCx));
    Object localObject1 = new MMEditText.b()
    {
      public final void bXT()
      {
        AppMethodBeat.i(37864);
        if (ModRemarkNameUI.a(ModRemarkNameUI.this).getText().toString().trim().length() > 0) {
          ModRemarkNameUI.this.enableOptionMenu(true);
        }
        AppMethodBeat.o(37864);
      }
    };
    this.affz.setClearBtnListener(new MMClearEditText.b()
    {
      public final void jmh()
      {
        AppMethodBeat.i(253006);
        ModRemarkNameUI.b(ModRemarkNameUI.this);
        AppMethodBeat.o(253006);
      }
    });
    Object localObject2 = new k.a();
    ((k.a)localObject2).Ytq = ((MMEditText.b)localObject1);
    this.affz.addTextChangedListener((TextWatcher)localObject2);
    this.affz.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(253007);
        if (paramAnonymousBoolean)
        {
          if ((!Util.isNullOrNil(ModRemarkNameUI.a(ModRemarkNameUI.this).getHint())) && (Util.isNullOrNil(ModRemarkNameUI.a(ModRemarkNameUI.this).getText())))
          {
            ModRemarkNameUI.a(ModRemarkNameUI.this).setText(ModRemarkNameUI.a(ModRemarkNameUI.this).getHint());
            ModRemarkNameUI.a(ModRemarkNameUI.this).setHint(null);
          }
          ModRemarkNameUI.c(ModRemarkNameUI.this);
          ModRemarkNameUI.a(ModRemarkNameUI.this).setSelection(ModRemarkNameUI.a(ModRemarkNameUI.this).getText().length());
          ModRemarkNameUI.a(ModRemarkNameUI.this, 1);
        }
        AppMethodBeat.o(253007);
      }
    });
    com.tencent.mm.ui.tools.b.c.i(this.affz).aEg(32).a(null);
    int i;
    if ((this.contact != null) && (this.affB != 3)) {
      if (this.affB == 4)
      {
        this.affz.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(this.affC), this.affz.getTextSize()));
        i = 0;
        this.affz.setSelection(this.affz.getText().length());
      }
    }
    for (;;)
    {
      if ((this.affB == 0) && (!au.aAy(this.hVQ)))
      {
        this.affA.setText(R.l.gBA);
        localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(this.contact.field_username);
        if ((localObject1 == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWI())) || (((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWI().equals(this.affz.getText())))
        {
          label399:
          if ((!Util.isNullOrNil(this.IMS)) && ((this.afdc == null) || (Util.isNullOrNil(this.afdc.getText()))) && ((this.affz.getText() == null) || (!this.IMS.equals(this.affz.getText().toString())))) {
            break label1459;
          }
          label459:
          setMMTitle("");
          if ((this.affz.getHint() != null) && (!Util.isNullOrNil(this.affz.getHint().toString())))
          {
            this.NaB = this.affz.getHint().toString();
            this.affD = 1;
          }
          if ((this.affz.getText() != null) && (!Util.isNullOrNil(this.affz.getText().toString())))
          {
            this.NaB = this.affz.getText().toString();
            this.affD = 2;
          }
          addTextOptionMenu(0, getString(R.l.app_save), new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(253009);
              ModRemarkNameUI.d(ModRemarkNameUI.this);
              AppMethodBeat.o(253009);
              return true;
            }
          }, null, y.b.adEJ);
          setActionbarColor(getContext().getResources().getColor(R.e.white_color));
          hideActionbarLine();
          this.mController.setStatusBarColor(getResources().getColor(a.c.white_color));
          if ((this.affz == null) || (this.affz.getText().toString().trim().length() <= 0) || (i != 0)) {
            break label1804;
          }
          enableOptionMenu(true);
        }
      }
      for (;;)
      {
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(253011);
            ModRemarkNameUI.e(ModRemarkNameUI.this);
            AppMethodBeat.o(253011);
            return true;
          }
        });
        this.affE = ((TextView)findViewById(R.h.fCD));
        this.affF = ((EditText)findViewById(R.h.fCw));
        this.affG = ((TextView)findViewById(R.h.wordcount));
        this.CzL = findViewById(R.h.fCv);
        com.tencent.mm.ui.tools.b.c.i(this.affF).aEg(400).a(null);
        this.affG.setText(g.ej(400, this.affF.getEditableText().toString()));
        this.affF.append(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(this.affH), this.affF.getTextSize()));
        this.affE.append(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(this.affH), this.affE.getTextSize()));
        if (this.NsP != null)
        {
          this.affH = Util.nullAsNil(this.NsP.field_conDescription);
          this.affF.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(this.NsP.field_conDescription), this.affF.getTextSize()));
          this.affE.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(this.NsP.field_conDescription), this.affF.getTextSize()));
        }
        this.affF.addTextChangedListener(new b((byte)0));
        this.affE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(253014);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ModRemarkNameUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            ModRemarkNameUI.f(ModRemarkNameUI.this).setVisibility(0);
            ModRemarkNameUI.g(ModRemarkNameUI.this).setVisibility(8);
            ModRemarkNameUI.h(ModRemarkNameUI.this).requestFocus();
            ModRemarkNameUI.h(ModRemarkNameUI.this).setSelection(ModRemarkNameUI.h(ModRemarkNameUI.this).getText().length());
            ModRemarkNameUI.this.showVKB();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ModRemarkNameUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(253014);
          }
        });
        AppMethodBeat.o(37874);
        return;
        if (!Util.isNullOrNil(this.contact.field_conRemark))
        {
          if ((this.affB == 0) && (!Util.isNullOrNil(this.remark))) {
            this.affz.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, this.remark, this.affz.getTextSize()));
          }
          for (;;)
          {
            if (!this.contact.field_conRemark.equals(this.remark)) {
              break label1324;
            }
            i = 1;
            break;
            this.affz.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(this.contact.field_conRemark), this.affz.getTextSize()));
          }
        }
        if (!Util.isNullOrNil(this.remark))
        {
          this.affz.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(this.remark), this.affz.getTextSize()));
          if (!this.contact.field_conRemark.equals(this.remark)) {
            break label1324;
          }
          i = 1;
          break;
        }
        if (!Util.isNullOrNil(this.contact.field_nickname))
        {
          if ((this.affB == 0) && (!Util.isNullOrNil(this.affC)) && (!d.rs(this.contact.field_type)))
          {
            this.affz.setHint(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(this.affC), this.affz.getTextSize()));
            i = 0;
            break;
          }
          this.affz.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(this.contact.field_nickname), this.affz.getTextSize()));
          i = 0;
          break;
        }
        if (!Util.isNullOrNil(this.affC))
        {
          this.affz.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(this.affC), this.affz.getTextSize()));
          i = 0;
          break;
        }
        localObject1 = this.contact.field_nickname;
        if ((Util.isNullOrNil((String)localObject1)) || (((String)localObject1).length() > 50)) {}
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label1315;
          }
          this.affz.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(this.contact.aSV()), this.affz.getTextSize()));
          i = 0;
          break;
        }
        label1315:
        this.affz.setText("");
        label1324:
        i = 0;
        break;
        this.afdc = ((TextView)findViewById(R.h.fOt));
        this.afdd = findViewById(R.h.fOp);
        this.afdd.setVisibility(0);
        this.afdc.setText(Util.nullAsNil(getString(R.l.gCd, new Object[] { ((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWI() })));
        localObject2 = new q(getString(R.l.write_contact_remark));
        ((q)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWI()), 0, ((q)localObject2).length(), 17);
        this.afdc.append(" ");
        this.afdc.append((CharSequence)localObject2);
        this.afdc.setMovementMethod(LinkMovementMethod.getInstance());
        break label399;
        label1459:
        this.afdc = ((TextView)findViewById(R.h.fOt));
        this.afdd = findViewById(R.h.fOp);
        this.afdd.setVisibility(0);
        this.afdc.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(getString(R.l.gCc, new Object[] { this.IMS })), this.afdc.getTextSize()));
        localObject1 = new q(getString(R.l.write_contact_remark));
        ((q)localObject1).setSpan(new c(this.IMS), 0, ((q)localObject1).length(), 17);
        this.afdc.append(" ");
        this.afdc.append((CharSequence)localObject1);
        this.afdc.setMovementMethod(LinkMovementMethod.getInstance());
        break label459;
        if (this.affB == 3)
        {
          this.affA.setText(R.l.tag_rename);
          this.affz.setHint("");
          if (!Util.isNullOrNil(this.affC)) {
            this.affz.setText(this.affC);
          }
          localObject1 = (TextView)findViewById(R.h.fCy);
          ((TextView)localObject1).setText(R.l.set_tag_name);
          ((TextView)localObject1).setVisibility(0);
          findViewById(R.h.fOq).setVisibility(8);
          localObject1 = findViewById(R.h.fOn);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          i = 1;
          break label459;
        }
        if (this.affB == 4)
        {
          this.affA.setText(R.l.gTR);
          this.affz.setHint("");
          localObject1 = (TextView)findViewById(R.h.fCy);
          ((TextView)localObject1).setText(R.l.gTX);
          ((TextView)localObject1).setVisibility(0);
          break label459;
        }
        if (au.aAy(this.hVQ))
        {
          this.affA.setText(R.l.tag_rename);
          if (findViewById(R.h.label_layout) != null) {
            findViewById(R.h.label_layout).setVisibility(8);
          }
        }
        break label459;
        label1804:
        enableOptionMenu(false);
      }
      i = 0;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(253228);
    Log.i("MiroMsg.ModRemarkName", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      Log.e("MiroMsg.ModRemarkName", "data shouldnot be null");
      AppMethodBeat.o(253228);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(253228);
      return;
    }
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("result_label_id_list");
    List localList = com.tencent.mm.plugin.label.a.a.fTb().fSY();
    Log.i("MiroMsg.ModRemarkName", "onAcvityResult，labelLists: %s, allLabelListsNow: %s.", new Object[] { localArrayList, localList });
    if ((!H(localArrayList, this.afdm)) && (!H(localList, this.Nau)))
    {
      Log.i("MiroMsg.ModRemarkName", "onAcvityResult checkLebalChanges.");
      AppMethodBeat.o(253228);
      return;
    }
    localArrayList = paramIntent.getStringArrayListExtra("contact_search_label_new_list");
    if (localArrayList != null) {
      this.NaI.addAll(localArrayList);
    }
    localArrayList = paramIntent.getStringArrayListExtra("contact_search_label_add_list");
    if (localArrayList != null) {
      this.JWF.addAll(localArrayList);
    }
    localArrayList = paramIntent.getStringArrayListExtra("contact_select_label_add_list");
    if (localArrayList != null) {
      this.JWH.addAll(localArrayList);
    }
    paramIntent = paramIntent.getStringArrayListExtra("contact_select_label_new_list");
    if (paramIntent != null) {
      this.JWG.addAll(paramIntent);
    }
    if (this.Nau == null) {
      this.Nau = new ArrayList();
    }
    jyq();
    AppMethodBeat.o(253228);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(37873);
    super.onCreate(paramBundle);
    this.hTS = System.currentTimeMillis();
    this.pUt = getIntent().getIntExtra("Contact_Scene", 9);
    this.IMS = getIntent().getStringExtra("Contact_RoomNickname");
    this.affB = getIntent().getIntExtra("Contact_mode_name_type", 0);
    this.affC = Util.nullAsNil(getIntent().getStringExtra("Contact_Nick"));
    this.remark = Util.nullAsNil(getIntent().getStringExtra("Contact_RemarkName"));
    this.NaC = this.remark;
    this.affI = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
    initView();
    if (au.bwO(this.hVQ))
    {
      Log.i("MiroMsg.ModRemarkName", "initLabelPanelAll, isOpenIM, userName: %s.", new Object[] { this.hVQ });
      paramBundle = findViewById(R.h.fCu);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(R.h.fCt);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      if ((this.contact == null) || (!au.bwO(this.contact.field_username))) {
        break label458;
      }
    }
    label458:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (this.affz == null)) {
        break label463;
      }
      paramBundle = (ViewGroup)this.affz.getParent();
      int k = paramBundle.getChildCount();
      i = j;
      while (i < k)
      {
        View localView = paramBundle.getChildAt(i);
        j = localView.getId();
        if ((j != R.h.fCy) && (j != R.h.fCx)) {
          localView.setVisibility(8);
        }
        i += 1;
      }
      this.affL = ((TextView)findViewById(R.h.fCu));
      this.affK = findViewById(R.h.fCt);
      this.Nay = ((LinearLayout)findViewById(R.h.fCt));
      this.Naz = ((TextView)findViewById(R.h.fCs));
      this.Nax = ((ImageView)findViewById(R.h.fso));
      if (this.Nax != null) {
        this.Nax.setImageDrawable(bb.m(this, R.k.icons_outlined_arrow, com.tencent.mm.cd.a.w(getContext(), R.e.BW_70)));
      }
      this.Nay.setOnClickListener(this.affJ);
      if (this.affB != 0)
      {
        this.affK.setVisibility(8);
        this.affL.setVisibility(8);
      }
      for (;;)
      {
        jyq();
        break;
        this.affK.setVisibility(0);
        this.affL.setVisibility(0);
        this.Naz.setVisibility(0);
      }
    }
    label463:
    this.lKz = new com.tencent.mm.ui.tools.i(this);
    this.lKz.afIL = this;
    AppMethodBeat.o(37873);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37876);
    if (this.lKz != null) {
      this.lKz.close();
    }
    super.onDestroy();
    AppMethodBeat.o(37876);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(253190);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      goBack();
      AppMethodBeat.o(253190);
      return true;
    }
    AppMethodBeat.o(253190);
    return false;
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(253222);
    Log.i("MiroMsg.ModRemarkName", "height:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.JWJ != null) && (this.JWJ.isRunning())) {
      this.JWJ.cancel();
    }
    Object localObject1 = this.afcV;
    if ((this.JWf != null) && (this.JWf.isShowing()))
    {
      if ((this.JWf.rootView == null) || (!(this.JWf.rootView.getParent() instanceof View))) {
        break label353;
      }
      localObject1 = (View)this.JWf.rootView.getParent();
    }
    label353:
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(253222);
        return;
        localObject1 = this.afcV;
      }
      else
      {
        int i = paramInt;
        if (localObject1 == this.afcV)
        {
          Object localObject2 = lU(this.afcV);
          if (((List)localObject2).isEmpty())
          {
            AppMethodBeat.o(253222);
            return;
          }
          localObject2 = (EditText)((List)localObject2).get(((List)localObject2).size() - 1);
          int[] arrayOfInt = new int[2];
          ((EditText)localObject2).getLocationOnScreen(arrayOfInt);
          i = com.tencent.mm.ui.widget.happybubble.c.getScreenWH(getContext())[1];
          i = arrayOfInt[1] - (i - paramInt);
        }
        if (i > 0) {
          if (((View)localObject1).getTranslationY() != 0.0F) {
            ((View)localObject1).setTranslationY(0.0F);
          }
        }
        for (this.JWJ = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { 0.0F, -i });; this.JWJ = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { ((View)localObject1).getTranslationY(), 0.0F }))
        {
          this.JWJ.setDuration(200L);
          this.JWJ.setInterpolator(new androidx.g.a.a.b());
          this.JWJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
              AppMethodBeat.i(253598);
              Log.i("MiroMsg.ModRemarkName", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramAnonymousValueAnimator.getAnimatedValue("translationY")).floatValue()) });
              AppMethodBeat.o(253598);
            }
          });
          this.JWJ.start();
          AppMethodBeat.o(253222);
          return;
        }
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(253201);
    bh.aZW().b(635, this);
    if (this.lKz != null) {
      this.lKz.close();
    }
    super.onPause();
    AppMethodBeat.o(253201);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37875);
    super.onResume();
    bh.aZW().a(635, this);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(37875);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(37877);
    Log.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramp.getType() == 44)
    {
      if ((paramInt1 != 0) && (paramInt2 < 0))
      {
        Log.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
        Toast.makeText(this, getString(R.l.gTV, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      finish();
    }
    AppMethodBeat.o(37877);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(253211);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(253211);
  }
  
  final class b
    implements TextWatcher
  {
    private int Ppb = 400;
    
    private b() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(37869);
      this.Ppb = g.ej(400, paramEditable.toString());
      if (this.Ppb < 0) {
        this.Ppb = 0;
      }
      if (ModRemarkNameUI.i(ModRemarkNameUI.this) != null) {
        ModRemarkNameUI.i(ModRemarkNameUI.this).setText(this.Ppb);
      }
      ModRemarkNameUI.b(ModRemarkNameUI.this);
      AppMethodBeat.o(37869);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  final class c
    extends ClickableSpan
  {
    public String remark;
    
    public c(String paramString)
    {
      this.remark = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37870);
      ModRemarkNameUI.a(ModRemarkNameUI.this).setText(com.tencent.mm.pluginsdk.ui.span.p.b(ModRemarkNameUI.this, Util.nullAsNil(this.remark), ModRemarkNameUI.a(ModRemarkNameUI.this).getTextSize()));
      ModRemarkNameUI.a(ModRemarkNameUI.this).setSelection(ModRemarkNameUI.a(ModRemarkNameUI.this).getText().length());
      ModRemarkNameUI.k(ModRemarkNameUI.this).setVisibility(8);
      AppMethodBeat.o(37870);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(37871);
      paramTextPaint.setColor(ModRemarkNameUI.this.getResources().getColor(R.e.blue_text_color));
      paramTextPaint.setUnderlineText(false);
      AppMethodBeat.o(37871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI
 * JD-Core Version:    0.7.0.1
 */