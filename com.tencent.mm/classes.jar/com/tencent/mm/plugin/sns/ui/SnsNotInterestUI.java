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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SnsNotInterestUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  private static final String[] yOQ = { "sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other" };
  private static final int[] yOR = { 1, 2, 4, 8, 16, 32, 64 };
  private static final int[] yOV = { 2131763816, 2131763821, 2131763822, 2131763815, 2131763814, 2131763819, 2131763817 };
  private com.tencent.mm.ui.base.p fxw;
  private f lZC;
  private String vTg;
  private HashMap<String, Boolean> yOS;
  private HashMap<Integer, Boolean> yOT;
  private HashMap<String, Integer> yOU;
  private TextView yOW;
  private EditText yOX;
  private ListView yOY;
  private LinearLayout yOZ;
  private int yPa;
  private int yPb;
  private long yPc;
  private boolean yPd;
  private boolean yPe;
  com.tencent.mm.plugin.sns.model.q yPf;
  
  public SnsNotInterestUI()
  {
    AppMethodBeat.i(98923);
    this.yOS = new HashMap(yOQ.length);
    this.yOT = new HashMap(yOR.length);
    this.yOU = new HashMap(yOR.length);
    this.vTg = null;
    this.yPd = false;
    this.yPe = false;
    this.fxw = null;
    this.yPf = null;
    AppMethodBeat.o(98923);
  }
  
  private void dQb()
  {
    int k = 0;
    AppMethodBeat.i(98925);
    Object localObject1 = yOQ;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      this.yOS.put(localObject2, Boolean.FALSE);
      i += 1;
    }
    localObject1 = yOR;
    int m = localObject1.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = localObject1[i];
      this.yOT.put(Integer.valueOf(j), Boolean.FALSE);
      i += 1;
    }
    while (j < yOR.length)
    {
      this.yOU.put(yOQ[j], Integer.valueOf(yOR[j]));
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
    this.yOW = ((TextView)findViewById(2131304977));
    this.yOX = ((EditText)findViewById(2131304978));
    this.yOY = ((ListView)findViewById(16908298));
    this.yOZ = ((LinearLayout)findViewById(2131299605));
    this.yOZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98920);
        SnsNotInterestUI.a(SnsNotInterestUI.this).requestFocus();
        SnsNotInterestUI.this.hideVKB();
        AppMethodBeat.o(98920);
      }
    });
    this.yOX.setVisibility(8);
    this.yOW.setVisibility(8);
    this.lZC = getPreferenceScreen();
    if (this.lZC == null) {
      ac.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
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
      }, null, s.b.Hom);
      enableOptionMenu(0, false);
      AppMethodBeat.o(98927);
      return;
      Object localObject;
      if (this.lZC.aPN("sns_expose_desc") == null)
      {
        localObject = new PreferenceTitleCategory(this);
        ((Preference)localObject).setTitle(2131763812);
        ((Preference)localObject).setKey("sns_expose_desc");
        this.lZC.b((Preference)localObject);
      }
      int i = 0;
      while (i < yOQ.length)
      {
        localObject = yOQ[i];
        int j = yOV[i];
        if (this.lZC.aPN((String)localObject) == null)
        {
          Preference localPreference = new Preference(this);
          localPreference.setTitle(j);
          localPreference.setKey((String)localObject);
          localPreference.setLayoutResource(2131494804);
          localPreference.setWidgetLayoutResource(2131494814);
          this.lZC.b(localPreference);
        }
        i += 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98924);
    super.onCreate(paramBundle);
    this.yPa = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
    this.yPc = getIntent().getLongExtra("sns_info_svr_id", 0L);
    if (this.yPc != 0L)
    {
      paramBundle = af.dHR().xK(this.yPc).field_userName;
      if (paramBundle != null)
      {
        com.tencent.mm.kernel.g.agS();
        paramBundle = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNs(paramBundle);
        if (paramBundle.exL != 2) {
          break label141;
        }
        yOV[1] = 2131763820;
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(218, this);
      dQb();
      initView();
      AppMethodBeat.o(98924);
      return;
      label141:
      if (paramBundle.exL == 1) {
        yOV[1] = 2131763821;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98926);
    super.onDestroy();
    dQb();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(218, this);
    hm localhm = new hm();
    localhm.diB.diC = this.yPd;
    localhm.diB.diD = this.yPc;
    a.GpY.l(localhm);
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
    if (this.yOS.containsKey(str))
    {
      boolean bool = ((Boolean)this.yOS.get(str)).booleanValue();
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
        this.yOS.put(str, Boolean.valueOf(bool));
        i = ((Integer)this.yOU.get(str)).intValue();
        this.yOT.put(Integer.valueOf(i), Boolean.valueOf(bool));
        ac.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
        paramf = this.yOS.values().iterator();
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
            this.yOX.setVisibility(0);
            this.yOW.setVisibility(0);
            this.yOX.requestFocus();
            this.yPe = true;
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
        if (!((Boolean)this.yOS.get("sns_expose_reason_other")).booleanValue())
        {
          this.yOX.setVisibility(8);
          this.yOW.setVisibility(8);
          this.yOY.requestFocus();
          this.yPe = false;
          hideVKB();
        }
        else
        {
          this.yOY.requestFocus();
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
    ac.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.getType() == 218)
    {
      this.fxw.dismiss();
      this.fxw = null;
      if (((com.tencent.mm.plugin.sns.model.q)paramn).type == 9)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.yPd = true;
          Toast.makeText(this, 2131763824, 1).show();
          finish();
          AppMethodBeat.o(98929);
          return;
        }
        this.yPd = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotInterestUI
 * JD-Core Version:    0.7.0.1
 */