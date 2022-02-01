package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.jy;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.y.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SnsNotInterestUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private static final String[] RuH = { "sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other" };
  private static final int[] RuI = { 1, 2, 4, 8, 16, 32, 64 };
  private static final int[] RuM = { b.j.sns_expose_reason_not_fav, b.j.sns_expose_reason_too_freq_him, b.j.sns_expose_reason_too_many_same_content, b.j.sns_expose_reason_marketing, b.j.sns_expose_reason_content_sexy, b.j.sns_expose_reason_rumour, b.j.sns_expose_reason_other };
  private String Niz;
  private HashMap<String, Boolean> RuJ;
  private HashMap<Integer, Boolean> RuK;
  private HashMap<String, Integer> RuL;
  private TextView RuN;
  private EditText RuO;
  private ListView RuP;
  private LinearLayout RuQ;
  private int RuR;
  private int RuS;
  private long RuT;
  private boolean RuU;
  private boolean RuV;
  com.tencent.mm.plugin.sns.model.s RuW;
  private com.tencent.mm.ui.base.w lKp;
  private f pkD;
  
  public SnsNotInterestUI()
  {
    AppMethodBeat.i(98923);
    this.RuJ = new HashMap(RuH.length);
    this.RuK = new HashMap(RuI.length);
    this.RuL = new HashMap(RuI.length);
    this.Niz = null;
    this.RuU = false;
    this.RuV = false;
    this.lKp = null;
    this.RuW = null;
    AppMethodBeat.o(98923);
  }
  
  private void hpc()
  {
    int k = 0;
    AppMethodBeat.i(98925);
    Object localObject1 = RuH;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      this.RuJ.put(localObject2, Boolean.FALSE);
      i += 1;
    }
    localObject1 = RuI;
    int m = localObject1.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = localObject1[i];
      this.RuK.put(Integer.valueOf(j), Boolean.FALSE);
      i += 1;
    }
    while (j < RuI.length)
    {
      this.RuL.put(RuH[j], Integer.valueOf(RuI[j]));
      j += 1;
    }
    AppMethodBeat.o(98925);
  }
  
  public int getLayoutId()
  {
    return b.g.sns_expose_ui;
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98927);
    super.initView();
    setMMTitle(b.j.sns_expose_title);
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
    this.RuN = ((TextView)findViewById(b.f.sns_expose_input_hint));
    this.RuO = ((EditText)findViewById(b.f.sns_expose_other_input));
    this.RuP = ((ListView)findViewById(16908298));
    this.RuQ = ((LinearLayout)findViewById(b.f.expose_layout));
    this.RuQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98920);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/SnsNotInterestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        SnsNotInterestUI.a(SnsNotInterestUI.this).requestFocus();
        SnsNotInterestUI.this.hideVKB();
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsNotInterestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98920);
      }
    });
    this.RuO.setVisibility(8);
    this.RuN.setVisibility(8);
    this.pkD = getPreferenceScreen();
    if (this.pkD == null) {
      Log.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(b.j.biz_report_send), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98921);
          SnsNotInterestUI.b(SnsNotInterestUI.this);
          AppMethodBeat.o(98921);
          return true;
        }
      }, null, y.b.adEJ);
      enableOptionMenu(0, false);
      AppMethodBeat.o(98927);
      return;
      Object localObject;
      if (this.pkD.bAi("sns_expose_desc") == null)
      {
        localObject = new PreferenceTitleCategory(this);
        ((Preference)localObject).setTitle(b.j.sns_expose_desc);
        ((Preference)localObject).setKey("sns_expose_desc");
        this.pkD.c((Preference)localObject);
      }
      int i = 0;
      while (i < RuH.length)
      {
        localObject = RuH[i];
        int j = RuM[i];
        if (this.pkD.bAi((String)localObject) == null)
        {
          Preference localPreference = new Preference(this);
          localPreference.setTitle(j);
          localPreference.setKey((String)localObject);
          localPreference.setLayoutResource(b.g.mm_preference);
          localPreference.aBp(b.g.mm_preference_checkbox_unchecked);
          this.pkD.c(localPreference);
        }
        i += 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98924);
    super.onCreate(paramBundle);
    this.RuR = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
    this.RuT = getIntent().getLongExtra("sns_info_svr_id", 0L);
    if (this.RuT != 0L)
    {
      paramBundle = al.hgB().vj(this.RuT).getUserName();
      if (paramBundle != null)
      {
        com.tencent.mm.kernel.h.baF();
        paramBundle = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxv(paramBundle);
        if (paramBundle.sex != 2) {
          break label141;
        }
        RuM[1] = b.j.sns_expose_reason_too_freq_her;
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(218, this);
      hpc();
      initView();
      AppMethodBeat.o(98924);
      return;
      label141:
      if (paramBundle.sex == 1) {
        RuM[1] = b.j.sns_expose_reason_too_freq_him;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98926);
    super.onDestroy();
    hpc();
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(218, this);
    jy localjy = new jy();
    localjy.hLz.hLA = this.RuU;
    localjy.hLz.hLB = this.RuT;
    localjy.publish();
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
    if (this.RuJ.containsKey(str))
    {
      boolean bool = ((Boolean)this.RuJ.get(str)).booleanValue();
      label79:
      int i;
      if (bool)
      {
        paramPreference.aBp(b.g.mm_preference_checkbox_unchecked);
        paramf.notifyDataSetChanged();
        if (bool) {
          break label274;
        }
        bool = true;
        this.RuJ.put(str, Boolean.valueOf(bool));
        i = ((Integer)this.RuL.get(str)).intValue();
        this.RuK.put(Integer.valueOf(i), Boolean.valueOf(bool));
        Log.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
        paramf = this.RuJ.values().iterator();
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
            this.RuO.setVisibility(0);
            this.RuN.setVisibility(0);
            this.RuO.requestFocus();
            this.RuV = true;
            showVKB();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(98928);
        return true;
        paramPreference.aBp(b.g.mm_preference_checkbox_checked);
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
        if (!((Boolean)this.RuJ.get("sns_expose_reason_other")).booleanValue())
        {
          this.RuO.setVisibility(8);
          this.RuN.setVisibility(8);
          this.RuP.requestFocus();
          this.RuV = false;
          hideVKB();
        }
        else
        {
          this.RuP.requestFocus();
          hideVKB();
        }
      }
    }
    AppMethodBeat.o(98928);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(98929);
    Log.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramp.getType() == 218)
    {
      this.lKp.dismiss();
      this.lKp = null;
      if (((com.tencent.mm.plugin.sns.model.s)paramp).type == 9)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.RuU = true;
          Toast.makeText(this, b.j.sns_expose_success, 1).show();
          finish();
          AppMethodBeat.o(98929);
          return;
        }
        this.RuU = false;
        Toast.makeText(this, b.j.sns_expose_failed, 1).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsNotInterestUI
 * JD-Core Version:    0.7.0.1
 */