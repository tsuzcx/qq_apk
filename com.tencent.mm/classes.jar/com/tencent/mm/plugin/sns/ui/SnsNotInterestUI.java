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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.iz;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.w.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SnsNotInterestUI
  extends MMPreference
  implements i
{
  private static final String[] KUJ = { "sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other" };
  private static final int[] KUK = { 1, 2, 4, 8, 16, 32, 64 };
  private static final int[] KUO = { i.j.sns_expose_reason_not_fav, i.j.sns_expose_reason_too_freq_him, i.j.sns_expose_reason_too_many_same_content, i.j.sns_expose_reason_marketing, i.j.sns_expose_reason_content_sexy, i.j.sns_expose_reason_rumour, i.j.sns_expose_reason_other };
  private String HkM;
  private HashMap<String, Boolean> KUL;
  private HashMap<Integer, Boolean> KUM;
  private HashMap<String, Integer> KUN;
  private TextView KUP;
  private EditText KUQ;
  private ListView KUR;
  private LinearLayout KUS;
  private int KUT;
  private int KUU;
  private long KUV;
  private boolean KUW;
  private boolean KUX;
  com.tencent.mm.plugin.sns.model.s KUY;
  private com.tencent.mm.ui.base.s jhZ;
  private f mrf;
  
  public SnsNotInterestUI()
  {
    AppMethodBeat.i(98923);
    this.KUL = new HashMap(KUJ.length);
    this.KUM = new HashMap(KUK.length);
    this.KUN = new HashMap(KUK.length);
    this.HkM = null;
    this.KUW = false;
    this.KUX = false;
    this.jhZ = null;
    this.KUY = null;
    AppMethodBeat.o(98923);
  }
  
  private void fWL()
  {
    int k = 0;
    AppMethodBeat.i(98925);
    Object localObject1 = KUJ;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      this.KUL.put(localObject2, Boolean.FALSE);
      i += 1;
    }
    localObject1 = KUK;
    int m = localObject1.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = localObject1[i];
      this.KUM.put(Integer.valueOf(j), Boolean.FALSE);
      i += 1;
    }
    while (j < KUK.length)
    {
      this.KUN.put(KUJ[j], Integer.valueOf(KUK[j]));
      j += 1;
    }
    AppMethodBeat.o(98925);
  }
  
  public int getLayoutId()
  {
    return i.g.sns_expose_ui;
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98927);
    super.initView();
    setMMTitle(i.j.sns_expose_title);
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
    this.KUP = ((TextView)findViewById(i.f.sns_expose_input_hint));
    this.KUQ = ((EditText)findViewById(i.f.sns_expose_other_input));
    this.KUR = ((ListView)findViewById(16908298));
    this.KUS = ((LinearLayout)findViewById(i.f.expose_layout));
    this.KUS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98920);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/SnsNotInterestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        SnsNotInterestUI.a(SnsNotInterestUI.this).requestFocus();
        SnsNotInterestUI.this.hideVKB();
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsNotInterestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98920);
      }
    });
    this.KUQ.setVisibility(8);
    this.KUP.setVisibility(8);
    this.mrf = getPreferenceScreen();
    if (this.mrf == null) {
      Log.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(i.j.biz_report_send), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(98921);
          SnsNotInterestUI.b(SnsNotInterestUI.this);
          AppMethodBeat.o(98921);
          return true;
        }
      }, null, w.b.Wao);
      enableOptionMenu(0, false);
      AppMethodBeat.o(98927);
      return;
      Object localObject;
      if (this.mrf.byG("sns_expose_desc") == null)
      {
        localObject = new PreferenceTitleCategory(this);
        ((Preference)localObject).setTitle(i.j.sns_expose_desc);
        ((Preference)localObject).setKey("sns_expose_desc");
        this.mrf.b((Preference)localObject);
      }
      int i = 0;
      while (i < KUJ.length)
      {
        localObject = KUJ[i];
        int j = KUO[i];
        if (this.mrf.byG((String)localObject) == null)
        {
          Preference localPreference = new Preference(this);
          localPreference.setTitle(j);
          localPreference.setKey((String)localObject);
          localPreference.setLayoutResource(i.g.mm_preference);
          localPreference.auN(i.g.mm_preference_checkbox_unchecked);
          this.mrf.b(localPreference);
        }
        i += 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98924);
    super.onCreate(paramBundle);
    this.KUT = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
    this.KUV = getIntent().getLongExtra("sns_info_svr_id", 0L);
    if (this.KUV != 0L)
    {
      paramBundle = aj.fOI().Rd(this.KUV).getUserName();
      if (paramBundle != null)
      {
        h.aHH();
        paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwh(paramBundle);
        if (paramBundle.sex != 2) {
          break label141;
        }
        KUO[1] = i.j.sns_expose_reason_too_freq_her;
      }
    }
    for (;;)
    {
      h.aHH();
      h.aHF().kcd.a(218, this);
      fWL();
      initView();
      AppMethodBeat.o(98924);
      return;
      label141:
      if (paramBundle.sex == 1) {
        KUO[1] = i.j.sns_expose_reason_too_freq_him;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98926);
    super.onDestroy();
    fWL();
    h.aHH();
    h.aHF().kcd.b(218, this);
    iz localiz = new iz();
    localiz.fGi.fGj = this.KUW;
    localiz.fGi.fGk = this.KUV;
    EventCenter.instance.publish(localiz);
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
    if (this.KUL.containsKey(str))
    {
      boolean bool = ((Boolean)this.KUL.get(str)).booleanValue();
      label79:
      int i;
      if (bool)
      {
        paramPreference.auN(i.g.mm_preference_checkbox_unchecked);
        paramf.notifyDataSetChanged();
        if (bool) {
          break label274;
        }
        bool = true;
        this.KUL.put(str, Boolean.valueOf(bool));
        i = ((Integer)this.KUN.get(str)).intValue();
        this.KUM.put(Integer.valueOf(i), Boolean.valueOf(bool));
        Log.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
        paramf = this.KUL.values().iterator();
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
            this.KUQ.setVisibility(0);
            this.KUP.setVisibility(0);
            this.KUQ.requestFocus();
            this.KUX = true;
            showVKB();
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(98928);
        return true;
        paramPreference.auN(i.g.mm_preference_checkbox_checked);
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
        if (!((Boolean)this.KUL.get("sns_expose_reason_other")).booleanValue())
        {
          this.KUQ.setVisibility(8);
          this.KUP.setVisibility(8);
          this.KUR.requestFocus();
          this.KUX = false;
          hideVKB();
        }
        else
        {
          this.KUR.requestFocus();
          hideVKB();
        }
      }
    }
    AppMethodBeat.o(98928);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(98929);
    Log.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramq.getType() == 218)
    {
      this.jhZ.dismiss();
      this.jhZ = null;
      if (((com.tencent.mm.plugin.sns.model.s)paramq).type == 9)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.KUW = true;
          Toast.makeText(this, i.j.sns_expose_success, 1).show();
          finish();
          AppMethodBeat.o(98929);
          return;
        }
        this.KUW = false;
        Toast.makeText(this, i.j.sns_expose_failed, 1).show();
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