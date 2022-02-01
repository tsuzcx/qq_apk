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
import com.tencent.mm.g.a.ht;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.s.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SnsNotInterestUI
  extends MMPreference
  implements com.tencent.mm.al.f
{
  private static final String[] Agm = { "sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other" };
  private static final int[] Agn = { 1, 2, 4, 8, 16, 32, 64 };
  private static final int[] Agr = { 2131763816, 2131763821, 2131763822, 2131763815, 2131763814, 2131763819, 2131763817 };
  private boolean AgA;
  com.tencent.mm.plugin.sns.model.q AgB;
  private HashMap<String, Boolean> Ago;
  private HashMap<Integer, Boolean> Agp;
  private HashMap<String, Integer> Agq;
  private TextView Ags;
  private EditText Agt;
  private ListView Agu;
  private LinearLayout Agv;
  private int Agw;
  private int Agx;
  private long Agy;
  private boolean Agz;
  private com.tencent.mm.ui.base.p fQJ;
  private com.tencent.mm.ui.base.preference.f mzx;
  private String xaq;
  
  public SnsNotInterestUI()
  {
    AppMethodBeat.i(98923);
    this.Ago = new HashMap(Agm.length);
    this.Agp = new HashMap(Agn.length);
    this.Agq = new HashMap(Agn.length);
    this.xaq = null;
    this.Agz = false;
    this.AgA = false;
    this.fQJ = null;
    this.AgB = null;
    AppMethodBeat.o(98923);
  }
  
  private void ecr()
  {
    int k = 0;
    AppMethodBeat.i(98925);
    Object localObject1 = Agm;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      this.Ago.put(localObject2, Boolean.FALSE);
      i += 1;
    }
    localObject1 = Agn;
    int m = localObject1.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = localObject1[i];
      this.Agp.put(Integer.valueOf(j), Boolean.FALSE);
      i += 1;
    }
    while (j < Agn.length)
    {
      this.Agq.put(Agm[j], Integer.valueOf(Agn[j]));
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
    this.Ags = ((TextView)findViewById(2131304977));
    this.Agt = ((EditText)findViewById(2131304978));
    this.Agu = ((ListView)findViewById(16908298));
    this.Agv = ((LinearLayout)findViewById(2131299605));
    this.Agv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98920);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsNotInterestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        SnsNotInterestUI.a(SnsNotInterestUI.this).requestFocus();
        SnsNotInterestUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsNotInterestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98920);
      }
    });
    this.Agt.setVisibility(8);
    this.Ags.setVisibility(8);
    this.mzx = getPreferenceScreen();
    if (this.mzx == null) {
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
      }, null, s.b.JbS);
      enableOptionMenu(0, false);
      AppMethodBeat.o(98927);
      return;
      Object localObject;
      if (this.mzx.aVD("sns_expose_desc") == null)
      {
        localObject = new PreferenceTitleCategory(this);
        ((Preference)localObject).setTitle(2131763812);
        ((Preference)localObject).setKey("sns_expose_desc");
        this.mzx.b((Preference)localObject);
      }
      int i = 0;
      while (i < Agm.length)
      {
        localObject = Agm[i];
        int j = Agr[i];
        if (this.mzx.aVD((String)localObject) == null)
        {
          Preference localPreference = new Preference(this);
          localPreference.setTitle(j);
          localPreference.setKey((String)localObject);
          localPreference.setLayoutResource(2131494804);
          localPreference.setWidgetLayoutResource(2131494814);
          this.mzx.b(localPreference);
        }
        i += 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98924);
    super.onCreate(paramBundle);
    this.Agw = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
    this.Agy = getIntent().getLongExtra("sns_info_svr_id", 0L);
    if (this.Agy != 0L)
    {
      paramBundle = ag.dUe().Ai(this.Agy).field_userName;
      if (paramBundle != null)
      {
        g.ajD();
        paramBundle = ((l)g.ab(l.class)).azp().aTk(paramBundle);
        if (paramBundle.ePk != 2) {
          break label141;
        }
        Agr[1] = 2131763820;
      }
    }
    for (;;)
    {
      g.ajD();
      g.ajB().gAO.a(218, this);
      ecr();
      initView();
      AppMethodBeat.o(98924);
      return;
      label141:
      if (paramBundle.ePk == 1) {
        Agr[1] = 2131763821;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98926);
    super.onDestroy();
    ecr();
    g.ajD();
    g.ajB().gAO.b(218, this);
    ht localht = new ht();
    localht.dun.duo = this.Agz;
    localht.dun.dup = this.Agy;
    com.tencent.mm.sdk.b.a.IbL.l(localht);
    AppMethodBeat.o(98926);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(98928);
    if (paramPreference == null)
    {
      AppMethodBeat.o(98928);
      return false;
    }
    String str = paramPreference.mKey;
    if (this.Ago.containsKey(str))
    {
      boolean bool = ((Boolean)this.Ago.get(str)).booleanValue();
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
        this.Ago.put(str, Boolean.valueOf(bool));
        i = ((Integer)this.Agq.get(str)).intValue();
        this.Agp.put(Integer.valueOf(i), Boolean.valueOf(bool));
        ad.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
        paramf = this.Ago.values().iterator();
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
            this.Agt.setVisibility(0);
            this.Ags.setVisibility(0);
            this.Agt.requestFocus();
            this.AgA = true;
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
        if (!((Boolean)this.Ago.get("sns_expose_reason_other")).booleanValue())
        {
          this.Agt.setVisibility(8);
          this.Ags.setVisibility(8);
          this.Agu.requestFocus();
          this.AgA = false;
          hideVKB();
        }
        else
        {
          this.Agu.requestFocus();
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
      this.fQJ.dismiss();
      this.fQJ = null;
      if (((com.tencent.mm.plugin.sns.model.q)paramn).type == 9)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.Agz = true;
          Toast.makeText(this, 2131763824, 1).show();
          finish();
          AppMethodBeat.o(98929);
          return;
        }
        this.Agz = false;
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