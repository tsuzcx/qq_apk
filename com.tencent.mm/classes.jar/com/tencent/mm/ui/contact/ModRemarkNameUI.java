package com.tencent.mm.ui.contact;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.tools.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.MMEditText.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ModRemarkNameUI
  extends MMActivity
  implements com.tencent.mm.an.i, com.tencent.mm.ui.tools.h
{
  private HashSet<String> EeR;
  private HashSet<String> EeS;
  private HashSet<String> EeT;
  private ObjectAnimator EeU;
  private k Eeu;
  private String GYH;
  private List<String> Hci;
  private ImageView Hcl;
  private LinearLayout Hcm;
  private TextView Hcn;
  private boolean Hcp;
  private String Hcq;
  private String Hcr;
  private int Hcs;
  private boolean Hct;
  private int Hcu;
  private int Hcv;
  private List<String> Hcw;
  private HashSet<String> Hcx;
  private co Hvc;
  private TextView XrB;
  private View XrC;
  private List<String> XrL;
  private HashSet<String> XrM;
  private ScrollView Xru;
  private TextView XtV;
  private int XtW;
  private String XtX;
  private TextView XtY;
  private EditText XtZ;
  private TextView Xua;
  private String Xub;
  private boolean Xuc;
  private ModRemarkNameUI.a Xud;
  private View Xue;
  private TextView Xuf;
  private MMClearEditText aadg;
  private int aadh;
  private as contact;
  private long fOa;
  private String fPV;
  private com.tencent.mm.ui.tools.i jij;
  private int mXL;
  private String remark;
  private View ybl;
  
  public ModRemarkNameUI()
  {
    AppMethodBeat.i(37872);
    this.XtX = "";
    this.remark = "";
    this.aadh = -1;
    this.Hcp = false;
    this.XtY = null;
    this.XtZ = null;
    this.Xua = null;
    this.Xub = "";
    this.Xuc = false;
    this.mXL = 9;
    this.Xud = new ModRemarkNameUI.a(this, (byte)0);
    this.Hcs = 0;
    this.Hci = new ArrayList();
    this.Hcw = new ArrayList();
    this.XrL = new ArrayList();
    this.XrM = new HashSet();
    this.Hcx = new HashSet();
    this.EeR = new HashSet();
    this.EeS = new HashSet();
    this.EeT = new HashSet();
    this.EeU = null;
    AppMethodBeat.o(37872);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(293228);
    boolean bool1 = iWC();
    boolean bool2 = hUx();
    if ((bool1) || (bool2))
    {
      com.tencent.mm.ui.base.h.c(this, getString(R.l.eyW), null, getString(R.l.eyY), getString(R.l.eyX), new ModRemarkNameUI.9(this), new ModRemarkNameUI.10(this));
      AppMethodBeat.o(293228);
      return;
    }
    finish();
    Ph(2L);
    AppMethodBeat.o(293228);
  }
  
  private void gw(List<String> paramList)
  {
    AppMethodBeat.i(269668);
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.Hcn.setText("");
      AppMethodBeat.o(269668);
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
    AppMethodBeat.o(269668);
  }
  
  private void hUB()
  {
    AppMethodBeat.i(269667);
    List localList = null;
    bh.beI();
    this.Hvc = com.tencent.mm.model.c.bbM().aPj(this.fPV);
    if (this.Hvc != null)
    {
      this.GYH = this.Hvc.field_contactLabels;
      localList = com.tencent.mm.plugin.label.a.a.eLe().aMP(this.GYH);
    }
    if (this.Hci == null) {
      this.Hci = new ArrayList();
    }
    this.Hcw.clear();
    this.Hci.clear();
    this.XrL.clear();
    if (localList != null)
    {
      this.Hci.addAll(localList);
      this.Hcw.addAll(localList);
      this.XrL.addAll(localList);
    }
    for (;;)
    {
      localList = com.tencent.mm.plugin.label.a.a.eLe().eLb();
      if (localList == null) {
        break;
      }
      int i = 0;
      while (i < localList.size())
      {
        if (!this.Hci.contains(localList.get(i))) {
          this.Hci.add(localList.get(i));
        }
        i += 1;
      }
      new ArrayList();
    }
    gw(this.Hcw);
    this.Hcu = localList.size();
    this.Hcv = this.Hcw.size();
    this.XrM.addAll(this.Hcw);
    AppMethodBeat.o(269667);
  }
  
  private boolean hUx()
  {
    AppMethodBeat.i(293226);
    String str = this.XtZ.getText().toString().trim();
    if (((this.Xub == null) || (!this.Xub.equals(str))) && ((!Util.isNullOrNil(this.Xub)) || (!Util.isNullOrNil(str))))
    {
      AppMethodBeat.o(293226);
      return true;
    }
    AppMethodBeat.o(293226);
    return false;
  }
  
  private boolean iWC()
  {
    AppMethodBeat.i(293227);
    String str2 = this.aadg.getText().toString().trim();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    if (this.XtW == 0)
    {
      if (this.aadh == 1)
      {
        if (Util.isNullOrNil(str1))
        {
          if (this.Hcp)
          {
            AppMethodBeat.o(293227);
            return true;
          }
          AppMethodBeat.o(293227);
          return false;
        }
        AppMethodBeat.o(293227);
        return true;
      }
      if (this.aadh == 2)
      {
        if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(this.Hcq)))
        {
          AppMethodBeat.o(293227);
          return false;
        }
        if (!str1.equals(this.Hcq))
        {
          AppMethodBeat.o(293227);
          return true;
        }
        AppMethodBeat.o(293227);
        return false;
      }
    }
    if ((this.XtW == 3) && (!Util.isNullOrNil(this.Hcq)))
    {
      if (!this.Hcq.equals(str1))
      {
        AppMethodBeat.o(293227);
        return true;
      }
      AppMethodBeat.o(293227);
      return false;
    }
    if (((this.remark == null) || (!this.remark.equals(str1))) && ((!Util.isNullOrNil(this.remark)) || (!Util.isNullOrNil(str1))))
    {
      AppMethodBeat.o(293227);
      return true;
    }
    AppMethodBeat.o(293227);
    return false;
  }
  
  private List<EditText> iy(View paramView)
  {
    AppMethodBeat.i(269665);
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
        localArrayList.addAll(iy(localView));
        i += 1;
      }
    }
    AppMethodBeat.o(269665);
    return localArrayList;
  }
  
  private static boolean t(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(269671);
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
      AppMethodBeat.o(269671);
      return false;
    }
    AppMethodBeat.o(269671);
    return true;
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(269666);
    Log.i("MiroMsg.ModRemarkName", "height:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.EeU != null) && (this.EeU.isRunning())) {
      this.EeU.cancel();
    }
    Object localObject1 = this.Xru;
    if ((this.Eeu != null) && (this.Eeu.isShowing()))
    {
      if ((this.Eeu.oFW == null) || (!(this.Eeu.oFW.getParent() instanceof View))) {
        break label353;
      }
      localObject1 = (View)this.Eeu.oFW.getParent();
    }
    label353:
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(269666);
        return;
        localObject1 = this.Xru;
      }
      else
      {
        int i = paramInt;
        if (localObject1 == this.Xru)
        {
          Object localObject2 = iy(this.Xru);
          if (((List)localObject2).isEmpty())
          {
            AppMethodBeat.o(269666);
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
        for (this.EeU = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { 0.0F, -i });; this.EeU = ObjectAnimator.ofFloat(localObject1, "translationY", new float[] { ((View)localObject1).getTranslationY(), 0.0F }))
        {
          this.EeU.setDuration(200L);
          this.EeU.setInterpolator(new androidx.f.a.a.b());
          this.EeU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
              AppMethodBeat.i(293369);
              Log.i("MiroMsg.ModRemarkName", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramAnonymousValueAnimator.getAnimatedValue("translationY")).floatValue()) });
              AppMethodBeat.o(293369);
            }
          });
          this.EeU.start();
          AppMethodBeat.o(269666);
          return;
        }
      }
    }
  }
  
  public final void Ph(long paramLong)
  {
    AppMethodBeat.i(269672);
    com.tencent.e.h.ZvG.be(new ModRemarkNameUI.8(this, paramLong));
    AppMethodBeat.o(269672);
  }
  
  public int getLayoutId()
  {
    return R.i.eji;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37874);
    this.fPV = getIntent().getStringExtra("Contact_User");
    if ((this.fPV != null) && (this.fPV.length() > 0))
    {
      bh.beI();
      this.contact = com.tencent.mm.model.c.bbL().RG(this.fPV);
      bh.beI();
      this.Hvc = com.tencent.mm.model.c.bbM().aPj(this.fPV);
      if ((this.contact == null) || (Util.isNullOrNil(this.contact.field_username)))
      {
        this.contact = new as(this.fPV);
        this.contact.setNickname(Util.nullAsNil(this.XtX));
        this.contact.Ir(Util.nullAsNil(this.remark));
      }
    }
    this.Xru = ((ScrollView)findViewById(R.h.scrollview));
    this.XtV = ((TextView)findViewById(R.h.title_area_container));
    this.aadg = ((MMClearEditText)findViewById(R.h.dBj));
    Object localObject1 = new ModRemarkNameUI.1(this);
    this.aadg.setClearBtnListener(new ModRemarkNameUI.2(this));
    Object localObject2 = new m.a();
    ((m.a)localObject2).Rxe = ((MMEditText.b)localObject1);
    this.aadg.addTextChangedListener((TextWatcher)localObject2);
    this.aadg.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(293224);
        if (paramAnonymousBoolean)
        {
          if ((!Util.isNullOrNil(ModRemarkNameUI.a(ModRemarkNameUI.this).getHint())) && (Util.isNullOrNil(ModRemarkNameUI.a(ModRemarkNameUI.this).getText())))
          {
            ModRemarkNameUI.a(ModRemarkNameUI.this).setText(ModRemarkNameUI.a(ModRemarkNameUI.this).getHint());
            ModRemarkNameUI.a(ModRemarkNameUI.this).setHint(null);
          }
          ModRemarkNameUI.f(ModRemarkNameUI.this);
          ModRemarkNameUI.a(ModRemarkNameUI.this).setSelection(ModRemarkNameUI.a(ModRemarkNameUI.this).getText().length());
          ModRemarkNameUI.a(ModRemarkNameUI.this, 1);
        }
        AppMethodBeat.o(293224);
      }
    });
    com.tencent.mm.ui.tools.b.c.i(this.aadg).axx(32).a(null);
    int i;
    if ((this.contact != null) && (this.XtW != 3)) {
      if (this.XtW == 4)
      {
        this.aadg.setText(l.b(this, Util.nullAsNil(this.XtX), this.aadg.getTextSize()));
        i = 0;
        this.aadg.setSelection(this.aadg.getText().length());
      }
    }
    for (;;)
    {
      if ((this.XtW == 0) && (!as.aEF(this.fPV)))
      {
        this.XtV.setText(R.l.eyI);
        localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(this.contact.field_username);
        if ((localObject1 == null) || (Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxT())) || (((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxT().equals(this.aadg.getText())))
        {
          label399:
          setMMTitle("");
          if ((this.aadg.getHint() != null) && (!Util.isNullOrNil(this.aadg.getHint().toString())))
          {
            this.Hcq = this.aadg.getHint().toString();
            this.aadh = 1;
          }
          if ((this.aadg.getText() != null) && (!Util.isNullOrNil(this.aadg.getText().toString())))
          {
            this.Hcq = this.aadg.getText().toString();
            this.aadh = 2;
          }
          addTextOptionMenu(0, getString(R.l.app_save), new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(284104);
              ModRemarkNameUI.d(ModRemarkNameUI.this);
              AppMethodBeat.o(284104);
              return true;
            }
          }, null, w.b.Wao);
          setActionbarColor(getContext().getResources().getColor(R.e.white));
          hideActionbarLine();
          this.mController.setStatusBarColor(getResources().getColor(a.c.white));
          if ((this.aadg == null) || (this.aadg.getText().toString().trim().length() <= 0) || (i != 0)) {
            break label1603;
          }
          enableOptionMenu(true);
        }
      }
      for (;;)
      {
        setBackBtn(new ModRemarkNameUI.5(this));
        this.XtY = ((TextView)findViewById(R.h.dBp));
        this.XtZ = ((EditText)findViewById(R.h.dBi));
        this.Xua = ((TextView)findViewById(R.h.wordcount));
        this.ybl = findViewById(R.h.dBh);
        com.tencent.mm.ui.tools.b.c.i(this.XtZ).axx(800).a(null);
        this.Xua.setText(g.dq(800, this.XtZ.getEditableText().toString()));
        this.XtZ.append(l.b(this, Util.nullAsNil(this.Xub), this.XtZ.getTextSize()));
        this.XtY.append(l.b(this, Util.nullAsNil(this.Xub), this.XtY.getTextSize()));
        if (this.Hvc != null)
        {
          this.Xub = Util.nullAsNil(this.Hvc.field_conDescription);
          this.XtZ.setText(l.b(this, Util.nullAsNil(this.Hvc.field_conDescription), this.XtZ.getTextSize()));
          this.XtY.setText(l.b(this, Util.nullAsNil(this.Hvc.field_conDescription), this.XtZ.getTextSize()));
        }
        this.XtZ.addTextChangedListener(new ModRemarkNameUI.b(this, (byte)0));
        this.XtY.setOnClickListener(new ModRemarkNameUI.6(this));
        AppMethodBeat.o(37874);
        return;
        if (!Util.isNullOrNil(this.contact.field_conRemark))
        {
          if ((this.XtW == 0) && (!Util.isNullOrNil(this.remark))) {
            this.aadg.setText(l.b(this, this.remark, this.aadg.getTextSize()));
          }
          for (;;)
          {
            if (!this.contact.field_conRemark.equals(this.remark)) {
              break label1264;
            }
            i = 1;
            break;
            this.aadg.setText(l.b(this, Util.nullAsNil(this.contact.field_conRemark), this.aadg.getTextSize()));
          }
        }
        if (!Util.isNullOrNil(this.remark))
        {
          this.aadg.setText(l.b(this, Util.nullAsNil(this.remark), this.aadg.getTextSize()));
          if (!this.contact.field_conRemark.equals(this.remark)) {
            break label1264;
          }
          i = 1;
          break;
        }
        if (!Util.isNullOrNil(this.contact.field_nickname))
        {
          if ((this.XtW == 0) && (!Util.isNullOrNil(this.XtX)) && (!d.rk(this.contact.field_type)))
          {
            this.aadg.setHint(l.b(this, Util.nullAsNil(this.XtX), this.aadg.getTextSize()));
            i = 0;
            break;
          }
          this.aadg.setText(l.b(this, Util.nullAsNil(this.contact.field_nickname), this.aadg.getTextSize()));
          i = 0;
          break;
        }
        if (!Util.isNullOrNil(this.XtX))
        {
          this.aadg.setText(l.b(this, Util.nullAsNil(this.XtX), this.aadg.getTextSize()));
          i = 0;
          break;
        }
        localObject1 = this.contact.field_nickname;
        if ((Util.isNullOrNil((String)localObject1)) || (((String)localObject1).length() > 50)) {}
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label1255;
          }
          this.aadg.setText(l.b(this, Util.nullAsNil(this.contact.ays()), this.aadg.getTextSize()));
          i = 0;
          break;
        }
        label1255:
        this.aadg.setText("");
        label1264:
        i = 0;
        break;
        this.XrB = ((TextView)findViewById(R.h.dMJ));
        this.XrC = findViewById(R.h.dME);
        this.XrC.setVisibility(0);
        this.XrB.setText(Util.nullAsNil(getString(R.l.ezo, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxT() })));
        localObject2 = new m(getString(R.l.write_contact_remark));
        ((m)localObject2).setSpan(new ModRemarkNameUI.c(this, ((com.tencent.mm.plugin.account.friend.a.a)localObject1).bxT()), 0, ((m)localObject2).length(), 17);
        this.XrB.append(" ");
        this.XrB.append((CharSequence)localObject2);
        this.XrB.setMovementMethod(LinkMovementMethod.getInstance());
        break label399;
        if (this.XtW == 3)
        {
          this.XtV.setText(R.l.tag_rename);
          this.aadg.setHint("");
          if (!Util.isNullOrNil(this.XtX)) {
            this.aadg.setText(this.XtX);
          }
          localObject1 = (TextView)findViewById(R.h.dBk);
          ((TextView)localObject1).setText(R.l.set_tag_name);
          ((TextView)localObject1).setVisibility(0);
          findViewById(R.h.dMF).setVisibility(8);
          localObject1 = findViewById(R.h.nmH);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          i = 1;
          break label399;
        }
        if (this.XtW == 4)
        {
          this.XtV.setText(R.l.eRl);
          this.aadg.setHint("");
          localObject1 = (TextView)findViewById(R.h.dBk);
          ((TextView)localObject1).setText(R.l.eRr);
          ((TextView)localObject1).setVisibility(0);
          break label399;
        }
        if (as.aEF(this.fPV))
        {
          this.XtV.setText(R.l.tag_rename);
          if (findViewById(R.h.label_layout) != null) {
            findViewById(R.h.label_layout).setVisibility(8);
          }
        }
        break label399;
        label1603:
        enableOptionMenu(false);
      }
      i = 0;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(269670);
    Log.i("MiroMsg.ModRemarkName", "onAcvityResult requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramIntent == null)
    {
      Log.e("MiroMsg.ModRemarkName", "data shouldnot be null");
      AppMethodBeat.o(269670);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(269670);
      return;
    }
    ArrayList localArrayList = paramIntent.getStringArrayListExtra("result_label_id_list");
    List localList = com.tencent.mm.plugin.label.a.a.eLe().eLb();
    Log.i("MiroMsg.ModRemarkName", "onAcvityResult，labelLists: %s, allLabelListsNow: %s.", new Object[] { localArrayList, localList });
    if ((!t(localArrayList, this.XrL)) && (!t(localList, this.Hci)))
    {
      Log.i("MiroMsg.ModRemarkName", "onAcvityResult checkLebalChanges.");
      AppMethodBeat.o(269670);
      return;
    }
    localArrayList = paramIntent.getStringArrayListExtra("contact_search_label_new_list");
    if (localArrayList != null) {
      this.Hcx.addAll(localArrayList);
    }
    localArrayList = paramIntent.getStringArrayListExtra("contact_search_label_add_list");
    if (localArrayList != null) {
      this.EeR.addAll(localArrayList);
    }
    localArrayList = paramIntent.getStringArrayListExtra("contact_select_label_add_list");
    if (localArrayList != null) {
      this.EeT.addAll(localArrayList);
    }
    paramIntent = paramIntent.getStringArrayListExtra("contact_select_label_new_list");
    if (paramIntent != null) {
      this.EeS.addAll(paramIntent);
    }
    if (this.Hci == null) {
      this.Hci = new ArrayList();
    }
    hUB();
    AppMethodBeat.o(269670);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(37873);
    super.onCreate(paramBundle);
    this.fOa = System.currentTimeMillis();
    this.mXL = getIntent().getIntExtra("Contact_Scene", 9);
    this.XtW = getIntent().getIntExtra("Contact_mode_name_type", 0);
    this.XtX = Util.nullAsNil(getIntent().getStringExtra("Contact_Nick"));
    this.remark = Util.nullAsNil(getIntent().getStringExtra("Contact_RemarkName"));
    this.Hcr = this.remark;
    this.Xuc = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
    initView();
    if (as.bvK(this.fPV))
    {
      Log.i("MiroMsg.ModRemarkName", "initLabelPanelAll, isOpenIM, userName: %s.", new Object[] { this.fPV });
      paramBundle = findViewById(R.h.dBg);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = findViewById(R.h.dBf);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      if ((this.contact == null) || (!as.bvK(this.contact.field_username))) {
        break label444;
      }
    }
    label444:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (this.aadg == null)) {
        break label449;
      }
      paramBundle = (ViewGroup)this.aadg.getParent();
      int k = paramBundle.getChildCount();
      i = j;
      while (i < k)
      {
        View localView = paramBundle.getChildAt(i);
        j = localView.getId();
        if ((j != R.h.dBk) && (j != R.h.dBj)) {
          localView.setVisibility(8);
        }
        i += 1;
      }
      this.Xuf = ((TextView)findViewById(R.h.dBg));
      this.Xue = findViewById(R.h.dBf);
      this.Hcm = ((LinearLayout)findViewById(R.h.dBf));
      this.Hcn = ((TextView)findViewById(R.h.dBe));
      this.Hcl = ((ImageView)findViewById(R.h.drW));
      if (this.Hcl != null) {
        this.Hcl.setImageDrawable(au.o(this, R.k.icons_outlined_arrow, com.tencent.mm.ci.a.w(getContext(), R.e.BW_70)));
      }
      this.Hcm.setOnClickListener(this.Xud);
      if (this.XtW != 0)
      {
        this.Xue.setVisibility(8);
        this.Xuf.setVisibility(8);
      }
      for (;;)
      {
        hUB();
        break;
        this.Xue.setVisibility(0);
        this.Xuf.setVisibility(0);
        this.Hcn.setVisibility(0);
      }
    }
    label449:
    this.jij = new com.tencent.mm.ui.tools.i(this);
    this.jij.XSx = this;
    AppMethodBeat.o(37873);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37876);
    if (this.jij != null) {
      this.jij.close();
    }
    super.onDestroy();
    AppMethodBeat.o(37876);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(293225);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      goBack();
      AppMethodBeat.o(293225);
      return true;
    }
    AppMethodBeat.o(293225);
    return false;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(269663);
    bh.aGY().b(635, this);
    if (this.jij != null) {
      this.jij.close();
    }
    super.onPause();
    AppMethodBeat.o(269663);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37875);
    super.onResume();
    bh.aGY().a(635, this);
    if (this.jij != null) {
      this.jij.start();
    }
    AppMethodBeat.o(37875);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(37877);
    Log.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() == 44)
    {
      if ((paramInt1 != 0) && (paramInt2 < 0))
      {
        Log.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
        Toast.makeText(this, getString(R.l.eRp, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      finish();
    }
    AppMethodBeat.o(37877);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(269664);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.jij != null) {
      this.jij.start();
    }
    AppMethodBeat.o(269664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI
 * JD-Core Version:    0.7.0.1
 */