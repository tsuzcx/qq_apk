package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SnsNotInterestUI
  extends MMPreference
  implements i
{
  private static final String[] EGO = { "sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other" };
  private static final int[] EGP = { 1, 2, 4, 8, 16, 32, 64 };
  private static final int[] EGT = { 2131766040, 2131766045, 2131766046, 2131766039, 2131766038, 2131766043, 2131766041 };
  private String Bqt;
  private HashMap<String, Boolean> EGQ;
  private HashMap<Integer, Boolean> EGR;
  private HashMap<String, Integer> EGS;
  private TextView EGU;
  private EditText EGV;
  private ListView EGW;
  private LinearLayout EGX;
  private int EGY;
  private int EGZ;
  private long EHa;
  private boolean EHb;
  private boolean EHc;
  s EHd;
  private com.tencent.mm.ui.base.q gxX;
  private f nRm;
  
  public SnsNotInterestUI()
  {
    AppMethodBeat.i(98923);
    this.EGQ = new HashMap(EGO.length);
    this.EGR = new HashMap(EGP.length);
    this.EGS = new HashMap(EGP.length);
    this.Bqt = null;
    this.EHb = false;
    this.EHc = false;
    this.gxX = null;
    this.EHd = null;
    AppMethodBeat.o(98923);
  }
  
  private void fiy()
  {
    int k = 0;
    AppMethodBeat.i(98925);
    Object localObject1 = EGO;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      this.EGQ.put(localObject2, Boolean.FALSE);
      i += 1;
    }
    localObject1 = EGP;
    int m = localObject1.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = localObject1[i];
      this.EGR.put(Integer.valueOf(j), Boolean.FALSE);
      i += 1;
    }
    while (j < EGP.length)
    {
      this.EGS.put(EGO[j], Integer.valueOf(EGP[j]));
      j += 1;
    }
    AppMethodBeat.o(98925);
  }
  
  public int getLayoutId()
  {
    return 2131496433;
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98927);
    super.initView();
    setMMTitle(2131766049);
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
    this.EGU = ((TextView)findViewById(2131308117));
    this.EGV = ((EditText)findViewById(2131308118));
    this.EGW = ((ListView)findViewById(16908298));
    this.EGX = ((LinearLayout)findViewById(2131300239));
    this.EGX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98920);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsNotInterestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SnsNotInterestUI.a(SnsNotInterestUI.this).requestFocus();
        SnsNotInterestUI.this.hideVKB();
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsNotInterestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98920);
      }
    });
    this.EGV.setVisibility(8);
    this.EGU.setVisibility(8);
    this.nRm = getPreferenceScreen();
    if (this.nRm == null) {
      Log.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(2131756735), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98921);
          SnsNotInterestUI.b(SnsNotInterestUI.this);
          AppMethodBeat.o(98921);
          return true;
        }
      }, null, t.b.OGU);
      enableOptionMenu(0, false);
      AppMethodBeat.o(98927);
      return;
      Object localObject;
      if (this.nRm.bmg("sns_expose_desc") == null)
      {
        localObject = new PreferenceTitleCategory(this);
        ((Preference)localObject).setTitle(2131766036);
        ((Preference)localObject).setKey("sns_expose_desc");
        this.nRm.c((Preference)localObject);
      }
      int i = 0;
      while (i < EGO.length)
      {
        localObject = EGO[i];
        int j = EGT[i];
        if (this.nRm.bmg((String)localObject) == null)
        {
          Preference localPreference = new Preference(this);
          localPreference.setTitle(j);
          localPreference.setKey((String)localObject);
          localPreference.setLayoutResource(2131495538);
          localPreference.setWidgetLayoutResource(2131495548);
          this.nRm.c(localPreference);
        }
        i += 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98924);
    super.onCreate(paramBundle);
    this.EGY = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
    this.EHa = getIntent().getLongExtra("sns_info_svr_id", 0L);
    if (this.EHa != 0L)
    {
      paramBundle = aj.faO().JJ(this.EHa).getUserName();
      if (paramBundle != null)
      {
        g.aAi();
        paramBundle = ((l)g.af(l.class)).aSN().bjK(paramBundle);
        if (paramBundle.fuA != 2) {
          break label141;
        }
        EGT[1] = 2131766044;
      }
    }
    for (;;)
    {
      g.aAi();
      g.aAg().hqi.a(218, this);
      fiy();
      initView();
      AppMethodBeat.o(98924);
      return;
      label141:
      if (paramBundle.fuA == 1) {
        EGT[1] = 2131766045;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98926);
    super.onDestroy();
    fiy();
    g.aAi();
    g.aAg().hqi.b(218, this);
    ij localij = new ij();
    localij.dMY.dMZ = this.EHb;
    localij.dMY.dNa = this.EHa;
    EventCenter.instance.publish(localij);
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
    if (this.EGQ.containsKey(str))
    {
      boolean bool = ((Boolean)this.EGQ.get(str)).booleanValue();
      label79:
      int i;
      if (bool)
      {
        paramPreference.setWidgetLayoutResource(2131495548);
        paramf.notifyDataSetChanged();
        if (bool) {
          break label274;
        }
        bool = true;
        this.EGQ.put(str, Boolean.valueOf(bool));
        i = ((Integer)this.EGS.get(str)).intValue();
        this.EGR.put(Integer.valueOf(i), Boolean.valueOf(bool));
        Log.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
        paramf = this.EGQ.values().iterator();
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
            this.EGV.setVisibility(0);
            this.EGU.setVisibility(0);
            this.EGV.requestFocus();
            this.EHc = true;
            showVKB();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(98928);
        return true;
        paramPreference.setWidgetLayoutResource(2131495547);
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
        if (!((Boolean)this.EGQ.get("sns_expose_reason_other")).booleanValue())
        {
          this.EGV.setVisibility(8);
          this.EGU.setVisibility(8);
          this.EGW.requestFocus();
          this.EHc = false;
          hideVKB();
        }
        else
        {
          this.EGW.requestFocus();
          hideVKB();
        }
      }
    }
    AppMethodBeat.o(98928);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(98929);
    Log.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramq.getType() == 218)
    {
      this.gxX.dismiss();
      this.gxX = null;
      if (((s)paramq).type == 9)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.EHb = true;
          Toast.makeText(this, 2131766048, 1).show();
          finish();
          AppMethodBeat.o(98929);
          return;
        }
        this.EHb = false;
        Toast.makeText(this, 2131766037, 1).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotInterestUI
 * JD-Core Version:    0.7.0.1
 */