package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.q.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SnsNotInterestUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private static final String[] rTA = { "sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other" };
  private static final int[] rTB = { 1, 2, 4, 8, 16, 32, 64 };
  private static final int[] rTF = { 2131303807, 2131303812, 2131303813, 2131303806, 2131303805, 2131303810, 2131303808 };
  private com.tencent.mm.ui.base.p ehb;
  private com.tencent.mm.ui.base.preference.f iLA;
  private String pHZ;
  private HashMap<String, Boolean> rTC;
  private HashMap<Integer, Boolean> rTD;
  private HashMap<String, Integer> rTE;
  private TextView rTG;
  private EditText rTH;
  private ListView rTI;
  private LinearLayout rTJ;
  private int rTK;
  private int rTL;
  private long rTM;
  private boolean rTN;
  private boolean rTO;
  r rTP;
  
  public SnsNotInterestUI()
  {
    AppMethodBeat.i(39127);
    this.rTC = new HashMap(rTA.length);
    this.rTD = new HashMap(rTB.length);
    this.rTE = new HashMap(rTB.length);
    this.pHZ = null;
    this.rTN = false;
    this.rTO = false;
    this.ehb = null;
    this.rTP = null;
    AppMethodBeat.o(39127);
  }
  
  private void cvG()
  {
    int k = 0;
    AppMethodBeat.i(39129);
    Object localObject1 = rTA;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      this.rTC.put(localObject2, Boolean.FALSE);
      i += 1;
    }
    localObject1 = rTB;
    int m = localObject1.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = localObject1[i];
      this.rTD.put(Integer.valueOf(j), Boolean.FALSE);
      i += 1;
    }
    while (j < rTB.length)
    {
      this.rTE.put(rTA[j], Integer.valueOf(rTB[j]));
      j += 1;
    }
    AppMethodBeat.o(39129);
  }
  
  public int getLayoutId()
  {
    return 2130970822;
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39131);
    super.initView();
    setMMTitle(2131303816);
    setBackBtn(new SnsNotInterestUI.1(this));
    this.rTG = ((TextView)findViewById(2131827970));
    this.rTH = ((EditText)findViewById(2131827971));
    this.rTI = ((ListView)findViewById(16908298));
    this.rTJ = ((LinearLayout)findViewById(2131827969));
    this.rTJ.setOnClickListener(new SnsNotInterestUI.2(this));
    this.rTH.setVisibility(8);
    this.rTG.setVisibility(8);
    this.iLA = getPreferenceScreen();
    if (this.iLA == null) {
      ab.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(2131297683), new SnsNotInterestUI.3(this), null, q.b.zby);
      enableOptionMenu(0, false);
      AppMethodBeat.o(39131);
      return;
      Object localObject;
      if (this.iLA.atx("sns_expose_desc") == null)
      {
        localObject = new PreferenceTitleCategory(this);
        ((Preference)localObject).setTitle(2131303803);
        ((Preference)localObject).setKey("sns_expose_desc");
        this.iLA.b((Preference)localObject);
      }
      int i = 0;
      while (i < rTA.length)
      {
        localObject = rTA[i];
        int j = rTF[i];
        if (this.iLA.atx((String)localObject) == null)
        {
          Preference localPreference = new Preference(this);
          localPreference.setTitle(j);
          localPreference.setKey((String)localObject);
          localPreference.setLayoutResource(2130970179);
          localPreference.setWidgetLayoutResource(2130970189);
          this.iLA.b(localPreference);
        }
        i += 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39128);
    super.onCreate(paramBundle);
    this.rTK = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
    this.rTM = getIntent().getLongExtra("sns_info_svr_id", 0L);
    if (this.rTM != 0L)
    {
      paramBundle = ag.cpf().lZ(this.rTM).field_userName;
      if (paramBundle != null)
      {
        g.RM();
        paramBundle = ((j)g.E(j.class)).YA().arv(paramBundle);
        if (paramBundle.dqC != 2) {
          break label141;
        }
        rTF[1] = 2131303811;
      }
    }
    for (;;)
    {
      g.RM();
      g.RK().eHt.a(218, this);
      cvG();
      initView();
      AppMethodBeat.o(39128);
      return;
      label141:
      if (paramBundle.dqC == 1) {
        rTF[1] = 2131303812;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39130);
    super.onDestroy();
    cvG();
    g.RM();
    g.RK().eHt.b(218, this);
    gn localgn = new gn();
    localgn.cvv.cvw = this.rTN;
    localgn.cvv.cvx = this.rTM;
    a.ymk.l(localgn);
    AppMethodBeat.o(39130);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(39133);
    if (paramPreference == null)
    {
      AppMethodBeat.o(39133);
      return false;
    }
    String str = paramPreference.mKey;
    if (this.rTC.containsKey(str))
    {
      boolean bool = ((Boolean)this.rTC.get(str)).booleanValue();
      label79:
      int i;
      if (bool)
      {
        paramPreference.setWidgetLayoutResource(2130970189);
        paramf.notifyDataSetChanged();
        if (bool) {
          break label274;
        }
        bool = true;
        this.rTC.put(str, Boolean.valueOf(bool));
        i = ((Integer)this.rTE.get(str)).intValue();
        this.rTD.put(Integer.valueOf(i), Boolean.valueOf(bool));
        ab.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
        paramf = this.rTC.values().iterator();
        while (paramf.hasNext()) {
          if (((Boolean)paramf.next()).booleanValue())
          {
            i = 1;
            label198:
            if (i == 0) {
              break label285;
            }
            enableOptionMenu(0, true);
            label208:
            if ((!bool) || (!str.equals("sns_expose_reason_other"))) {
              break label294;
            }
            this.rTH.setVisibility(0);
            this.rTG.setVisibility(0);
            this.rTH.requestFocus();
            this.rTO = true;
            showVKB();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(39133);
        return true;
        paramPreference.setWidgetLayoutResource(2130970188);
        break;
        label274:
        bool = false;
        break label79;
        i = 0;
        break label198;
        label285:
        enableOptionMenu(0, false);
        break label208;
        label294:
        if (!((Boolean)this.rTC.get("sns_expose_reason_other")).booleanValue())
        {
          this.rTH.setVisibility(8);
          this.rTG.setVisibility(8);
          this.rTI.requestFocus();
          this.rTO = false;
          hideVKB();
        }
        else
        {
          this.rTI.requestFocus();
          hideVKB();
        }
      }
    }
    AppMethodBeat.o(39133);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(39134);
    ab.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramm.getType() == 218)
    {
      this.ehb.dismiss();
      this.ehb = null;
      if (((r)paramm).type == 9)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.rTN = true;
          Toast.makeText(this, 2131303815, 1).show();
          finish();
          AppMethodBeat.o(39134);
          return;
        }
        this.rTN = false;
        Toast.makeText(this, 2131303804, 1).show();
      }
    }
    AppMethodBeat.o(39134);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotInterestUI
 * JD-Core Version:    0.7.0.1
 */