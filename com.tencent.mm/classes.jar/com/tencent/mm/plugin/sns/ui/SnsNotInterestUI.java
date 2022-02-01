package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.r.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SnsNotInterestUI
  extends MMPreference
  implements com.tencent.mm.al.g
{
  private static final String[] xCc = { "sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other" };
  private static final int[] xCd = { 1, 2, 4, 8, 16, 32, 64 };
  private static final int[] xCh = { 2131763816, 2131763821, 2131763822, 2131763815, 2131763814, 2131763819, 2131763817 };
  private com.tencent.mm.ui.base.p ftP;
  private f lxI;
  private String uKp;
  private HashMap<String, Boolean> xCe;
  private HashMap<Integer, Boolean> xCf;
  private HashMap<String, Integer> xCg;
  private TextView xCi;
  private EditText xCj;
  private ListView xCk;
  private LinearLayout xCl;
  private int xCm;
  private int xCn;
  private long xCo;
  private boolean xCp;
  private boolean xCq;
  com.tencent.mm.plugin.sns.model.q xCr;
  
  public SnsNotInterestUI()
  {
    AppMethodBeat.i(98923);
    this.xCe = new HashMap(xCc.length);
    this.xCf = new HashMap(xCd.length);
    this.xCg = new HashMap(xCd.length);
    this.uKp = null;
    this.xCp = false;
    this.xCq = false;
    this.ftP = null;
    this.xCr = null;
    AppMethodBeat.o(98923);
  }
  
  private void dBE()
  {
    int k = 0;
    AppMethodBeat.i(98925);
    Object localObject1 = xCc;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      this.xCe.put(localObject2, Boolean.FALSE);
      i += 1;
    }
    localObject1 = xCd;
    int m = localObject1.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = localObject1[i];
      this.xCf.put(Integer.valueOf(j), Boolean.FALSE);
      i += 1;
    }
    while (j < xCd.length)
    {
      this.xCg.put(xCc[j], Integer.valueOf(xCd[j]));
      j += 1;
    }
    AppMethodBeat.o(98925);
  }
  
  public int getLayoutId()
  {
    return 2131495545;
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98927);
    super.initView();
    setMMTitle(2131763825);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98919);
        SnsNotInterestUI.this.finish();
        AppMethodBeat.o(98919);
        return true;
      }
    });
    this.xCi = ((TextView)findViewById(2131304977));
    this.xCj = ((EditText)findViewById(2131304978));
    this.xCk = ((ListView)findViewById(16908298));
    this.xCl = ((LinearLayout)findViewById(2131299605));
    this.xCl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98920);
        SnsNotInterestUI.a(SnsNotInterestUI.this).requestFocus();
        SnsNotInterestUI.this.hideVKB();
        AppMethodBeat.o(98920);
      }
    });
    this.xCj.setVisibility(8);
    this.xCi.setVisibility(8);
    this.lxI = getPreferenceScreen();
    if (this.lxI == null) {
      ad.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(2131756595), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98921);
          SnsNotInterestUI.b(SnsNotInterestUI.this);
          AppMethodBeat.o(98921);
          return true;
        }
      }, null, r.b.FOB);
      enableOptionMenu(0, false);
      AppMethodBeat.o(98927);
      return;
      Object localObject;
      if (this.lxI.aKk("sns_expose_desc") == null)
      {
        localObject = new PreferenceTitleCategory(this);
        ((Preference)localObject).setTitle(2131763812);
        ((Preference)localObject).setKey("sns_expose_desc");
        this.lxI.b((Preference)localObject);
      }
      int i = 0;
      while (i < xCc.length)
      {
        localObject = xCc[i];
        int j = xCh[i];
        if (this.lxI.aKk((String)localObject) == null)
        {
          Preference localPreference = new Preference(this);
          localPreference.setTitle(j);
          localPreference.setKey((String)localObject);
          localPreference.setLayoutResource(2131494804);
          localPreference.setWidgetLayoutResource(2131494814);
          this.lxI.b(localPreference);
        }
        i += 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98924);
    super.onCreate(paramBundle);
    this.xCm = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
    this.xCo = getIntent().getLongExtra("sns_info_svr_id", 0L);
    if (this.xCo != 0L)
    {
      paramBundle = af.dtu().th(this.xCo).field_userName;
      if (paramBundle != null)
      {
        com.tencent.mm.kernel.g.afC();
        paramBundle = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHX(paramBundle);
        if (paramBundle.evp != 2) {
          break label141;
        }
        xCh[1] = 2131763820;
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(218, this);
      dBE();
      initView();
      AppMethodBeat.o(98924);
      return;
      label141:
      if (paramBundle.evp == 1) {
        xCh[1] = 2131763821;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98926);
    super.onDestroy();
    dBE();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(218, this);
    hg localhg = new hg();
    localhg.dkS.dkT = this.xCp;
    localhg.dkS.dkU = this.xCo;
    a.ESL.l(localhg);
    AppMethodBeat.o(98926);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(98928);
    if (paramPreference == null)
    {
      AppMethodBeat.o(98928);
      return false;
    }
    String str = paramPreference.mKey;
    if (this.xCe.containsKey(str))
    {
      boolean bool = ((Boolean)this.xCe.get(str)).booleanValue();
      label79:
      int i;
      if (bool)
      {
        paramPreference.setWidgetLayoutResource(2131494814);
        paramf.notifyDataSetChanged();
        if (bool) {
          break label274;
        }
        bool = true;
        this.xCe.put(str, Boolean.valueOf(bool));
        i = ((Integer)this.xCg.get(str)).intValue();
        this.xCf.put(Integer.valueOf(i), Boolean.valueOf(bool));
        ad.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
        paramf = this.xCe.values().iterator();
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
            this.xCj.setVisibility(0);
            this.xCi.setVisibility(0);
            this.xCj.requestFocus();
            this.xCq = true;
            showVKB();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(98928);
        return true;
        paramPreference.setWidgetLayoutResource(2131494813);
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
        if (!((Boolean)this.xCe.get("sns_expose_reason_other")).booleanValue())
        {
          this.xCj.setVisibility(8);
          this.xCi.setVisibility(8);
          this.xCk.requestFocus();
          this.xCq = false;
          hideVKB();
        }
        else
        {
          this.xCk.requestFocus();
          hideVKB();
        }
      }
    }
    AppMethodBeat.o(98928);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(98929);
    ad.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.getType() == 218)
    {
      this.ftP.dismiss();
      this.ftP = null;
      if (((com.tencent.mm.plugin.sns.model.q)paramn).type == 9)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.xCp = true;
          Toast.makeText(this, 2131763824, 1).show();
          finish();
          AppMethodBeat.o(98929);
          return;
        }
        this.xCp = false;
        Toast.makeText(this, 2131763813, 1).show();
      }
    }
    AppMethodBeat.o(98929);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotInterestUI
 * JD-Core Version:    0.7.0.1
 */