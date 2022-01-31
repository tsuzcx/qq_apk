package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.gi;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.s.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SnsNotInterestUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private static final String[] paN = { "sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other" };
  private static final int[] paO = { 1, 2, 4, 8, 16, 32, 64 };
  private static final int[] paS = { i.j.sns_expose_reason_not_fav, i.j.sns_expose_reason_too_freq_him, i.j.sns_expose_reason_too_many_same_content, i.j.sns_expose_reason_marketing, i.j.sns_expose_reason_content_sexy, i.j.sns_expose_reason_rumour, i.j.sns_expose_reason_other };
  private com.tencent.mm.ui.base.p dpF = null;
  private com.tencent.mm.ui.base.preference.f hcp;
  private String ncH = null;
  private HashMap<String, Boolean> paP = new HashMap(paN.length);
  private HashMap<Integer, Boolean> paQ = new HashMap(paO.length);
  private HashMap<String, Integer> paR = new HashMap(paO.length);
  private TextView paT;
  private EditText paU;
  private ListView paV;
  private LinearLayout paW;
  private int paX;
  private int paY;
  private long paZ;
  private boolean pba = false;
  private boolean pbb = false;
  r pbc = null;
  
  private void bJf()
  {
    int k = 0;
    Object localObject1 = paN;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      this.paP.put(localObject2, Boolean.valueOf(false));
      i += 1;
    }
    localObject1 = paO;
    int m = localObject1.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = localObject1[i];
      this.paQ.put(Integer.valueOf(j), Boolean.valueOf(false));
      i += 1;
    }
    while (j < paO.length)
    {
      this.paR.put(paN[j], Integer.valueOf(paO[j]));
      j += 1;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    if (paramPreference == null) {}
    String str;
    do
    {
      return false;
      str = paramPreference.mKey;
    } while (!this.paP.containsKey(str));
    boolean bool = ((Boolean)this.paP.get(str)).booleanValue();
    label67:
    int i;
    if (bool)
    {
      paramPreference.setWidgetLayoutResource(i.g.mm_preference_checkbox_unchecked);
      paramf.notifyDataSetChanged();
      if (bool) {
        break label256;
      }
      bool = true;
      this.paP.put(str, Boolean.valueOf(bool));
      i = ((Integer)this.paR.get(str)).intValue();
      this.paQ.put(Integer.valueOf(i), Boolean.valueOf(bool));
      y.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
      paramf = this.paP.values().iterator();
      while (paramf.hasNext()) {
        if (((Boolean)paramf.next()).booleanValue())
        {
          i = 1;
          label186:
          if (i == 0) {
            break label267;
          }
          enableOptionMenu(0, true);
          label196:
          if ((!bool) || (!str.equals("sns_expose_reason_other"))) {
            break label276;
          }
          this.paU.setVisibility(0);
          this.paT.setVisibility(0);
          this.paU.requestFocus();
          this.pbb = true;
          showVKB();
        }
      }
    }
    for (;;)
    {
      return true;
      paramPreference.setWidgetLayoutResource(i.g.mm_preference_checkbox_checked);
      break;
      label256:
      bool = false;
      break label67;
      i = 0;
      break label186;
      label267:
      enableOptionMenu(0, false);
      break label196;
      label276:
      if (!((Boolean)this.paP.get("sns_expose_reason_other")).booleanValue())
      {
        this.paU.setVisibility(8);
        this.paT.setVisibility(8);
        this.paV.requestFocus();
        this.pbb = false;
        XM();
      }
      else
      {
        this.paV.requestFocus();
        XM();
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_expose_ui;
  }
  
  protected final void initView()
  {
    super.initView();
    setMMTitle(i.j.sns_expose_title);
    setBackBtn(new SnsNotInterestUI.1(this));
    this.paT = ((TextView)findViewById(i.f.sns_expose_input_hint));
    this.paU = ((EditText)findViewById(i.f.sns_expose_other_input));
    this.paV = ((ListView)findViewById(16908298));
    this.paW = ((LinearLayout)findViewById(i.f.expose_layout));
    this.paW.setOnClickListener(new SnsNotInterestUI.2(this));
    this.paU.setVisibility(8);
    this.paT.setVisibility(8);
    this.hcp = this.vdd;
    if (this.hcp == null) {
      y.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
    }
    for (;;)
    {
      a(0, getString(i.j.biz_report_send), new SnsNotInterestUI.3(this), s.b.uNx);
      enableOptionMenu(0, false);
      return;
      Object localObject;
      if (this.hcp.add("sns_expose_desc") == null)
      {
        localObject = new PreferenceTitleCategory(this);
        ((Preference)localObject).setTitle(i.j.sns_expose_desc);
        ((Preference)localObject).setKey("sns_expose_desc");
        this.hcp.a((Preference)localObject);
      }
      int i = 0;
      while (i < paN.length)
      {
        localObject = paN[i];
        int j = paS[i];
        if (this.hcp.add((String)localObject) == null)
        {
          Preference localPreference = new Preference(this);
          localPreference.setTitle(j);
          localPreference.setKey((String)localObject);
          localPreference.setLayoutResource(i.g.mm_preference);
          localPreference.setWidgetLayoutResource(i.g.mm_preference_checkbox_unchecked);
          this.hcp.a(localPreference);
        }
        i += 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.paX = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
    this.paZ = getIntent().getLongExtra("sns_info_svr_id", 0L);
    if (this.paZ != 0L)
    {
      paramBundle = af.bDF().gt(this.paZ).field_userName;
      if (paramBundle != null)
      {
        g.DQ();
        paramBundle = ((j)g.r(j.class)).Fw().abk(paramBundle);
        if (paramBundle.sex != 2) {
          break label129;
        }
        paS[1] = i.j.sns_expose_reason_too_freq_her;
      }
    }
    for (;;)
    {
      g.DQ();
      g.DO().dJT.a(218, this);
      bJf();
      initView();
      return;
      label129:
      if (paramBundle.sex == 1) {
        paS[1] = i.j.sns_expose_reason_too_freq_him;
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    bJf();
    g.DQ();
    g.DO().dJT.b(218, this);
    gi localgi = new gi();
    localgi.bOd.bOe = this.pba;
    localgi.bOd.bOf = this.paZ;
    a.udP.m(localgi);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramm.getType() == 218)
    {
      this.dpF.dismiss();
      this.dpF = null;
      if (((r)paramm).type == 9)
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label91;
        }
        this.pba = true;
        Toast.makeText(this, i.j.sns_expose_success, 1).show();
        finish();
      }
    }
    return;
    label91:
    this.pba = false;
    Toast.makeText(this, i.j.sns_expose_failed, 1).show();
  }
  
  public final int xj()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotInterestUI
 * JD-Core Version:    0.7.0.1
 */