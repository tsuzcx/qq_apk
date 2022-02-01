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
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.s.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SnsNotInterestUI
  extends MMPreference
  implements com.tencent.mm.ak.f
{
  private static final int[] AxD = { 2131763816, 2131763821, 2131763822, 2131763815, 2131763814, 2131763819, 2131763817 };
  private static final String[] Axy = { "sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other" };
  private static final int[] Axz = { 1, 2, 4, 8, 16, 32, 64 };
  private HashMap<String, Boolean> AxA;
  private HashMap<Integer, Boolean> AxB;
  private HashMap<String, Integer> AxC;
  private TextView AxE;
  private EditText AxF;
  private ListView AxG;
  private LinearLayout AxH;
  private int AxI;
  private int AxJ;
  private long AxK;
  private boolean AxL;
  private boolean AxM;
  r AxN;
  private com.tencent.mm.ui.base.p fSP;
  private com.tencent.mm.ui.base.preference.f mEx;
  private String xqh;
  
  public SnsNotInterestUI()
  {
    AppMethodBeat.i(98923);
    this.AxA = new HashMap(Axy.length);
    this.AxB = new HashMap(Axz.length);
    this.AxC = new HashMap(Axz.length);
    this.xqh = null;
    this.AxL = false;
    this.AxM = false;
    this.fSP = null;
    this.AxN = null;
    AppMethodBeat.o(98923);
  }
  
  private void efY()
  {
    int k = 0;
    AppMethodBeat.i(98925);
    Object localObject1 = Axy;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      this.AxA.put(localObject2, Boolean.FALSE);
      i += 1;
    }
    localObject1 = Axz;
    int m = localObject1.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = localObject1[i];
      this.AxB.put(Integer.valueOf(j), Boolean.FALSE);
      i += 1;
    }
    while (j < Axz.length)
    {
      this.AxC.put(Axy[j], Integer.valueOf(Axz[j]));
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
    this.AxE = ((TextView)findViewById(2131304977));
    this.AxF = ((EditText)findViewById(2131304978));
    this.AxG = ((ListView)findViewById(16908298));
    this.AxH = ((LinearLayout)findViewById(2131299605));
    this.AxH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98920);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsNotInterestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        SnsNotInterestUI.a(SnsNotInterestUI.this).requestFocus();
        SnsNotInterestUI.this.hideVKB();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsNotInterestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98920);
      }
    });
    this.AxF.setVisibility(8);
    this.AxE.setVisibility(8);
    this.mEx = getPreferenceScreen();
    if (this.mEx == null) {
      ae.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
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
      }, null, s.b.JwA);
      enableOptionMenu(0, false);
      AppMethodBeat.o(98927);
      return;
      Object localObject;
      if (this.mEx.aXe("sns_expose_desc") == null)
      {
        localObject = new PreferenceTitleCategory(this);
        ((Preference)localObject).setTitle(2131763812);
        ((Preference)localObject).setKey("sns_expose_desc");
        this.mEx.b((Preference)localObject);
      }
      int i = 0;
      while (i < Axy.length)
      {
        localObject = Axy[i];
        int j = AxD[i];
        if (this.mEx.aXe((String)localObject) == null)
        {
          Preference localPreference = new Preference(this);
          localPreference.setTitle(j);
          localPreference.setKey((String)localObject);
          localPreference.setLayoutResource(2131494804);
          localPreference.setWidgetLayoutResource(2131494814);
          this.mEx.b(localPreference);
        }
        i += 1;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98924);
    super.onCreate(paramBundle);
    this.AxI = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
    this.AxK = getIntent().getLongExtra("sns_info_svr_id", 0L);
    if (this.AxK != 0L)
    {
      paramBundle = ah.dXE().AG(this.AxK).field_userName;
      if (paramBundle != null)
      {
        g.ajS();
        paramBundle = ((l)g.ab(l.class)).azF().aUL(paramBundle);
        if (paramBundle.eQV != 2) {
          break label141;
        }
        AxD[1] = 2131763820;
      }
    }
    for (;;)
    {
      g.ajS();
      g.ajQ().gDv.a(218, this);
      efY();
      initView();
      AppMethodBeat.o(98924);
      return;
      label141:
      if (paramBundle.eQV == 1) {
        AxD[1] = 2131763821;
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98926);
    super.onDestroy();
    efY();
    g.ajS();
    g.ajQ().gDv.b(218, this);
    hu localhu = new hu();
    localhu.dvs.dvt = this.AxL;
    localhu.dvs.dvu = this.AxK;
    com.tencent.mm.sdk.b.a.IvT.l(localhu);
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
    if (this.AxA.containsKey(str))
    {
      boolean bool = ((Boolean)this.AxA.get(str)).booleanValue();
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
        this.AxA.put(str, Boolean.valueOf(bool));
        i = ((Integer)this.AxC.get(str)).intValue();
        this.AxB.put(Integer.valueOf(i), Boolean.valueOf(bool));
        ae.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
        paramf = this.AxA.values().iterator();
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
            this.AxF.setVisibility(0);
            this.AxE.setVisibility(0);
            this.AxF.requestFocus();
            this.AxM = true;
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
        if (!((Boolean)this.AxA.get("sns_expose_reason_other")).booleanValue())
        {
          this.AxF.setVisibility(8);
          this.AxE.setVisibility(8);
          this.AxG.requestFocus();
          this.AxM = false;
          hideVKB();
        }
        else
        {
          this.AxG.requestFocus();
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
    ae.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramn.getType() == 218)
    {
      this.fSP.dismiss();
      this.fSP = null;
      if (((r)paramn).type == 9)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.AxL = true;
          Toast.makeText(this, 2131763824, 1).show();
          finish();
          AppMethodBeat.o(98929);
          return;
        }
        this.AxL = false;
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