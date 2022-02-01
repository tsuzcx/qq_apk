package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable.Creator;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.plugin.setting.model.l;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.protocal.protobuf.eom;
import com.tencent.mm.protocal.protobuf.eon;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SettingsSearchAuthUI
  extends MMActivity
  implements i
{
  private byte[] CXN;
  private boolean Dcl;
  private com.tencent.mm.ui.search.a DdQ;
  private View DdR;
  private TextView DdS;
  private TextView DdT;
  private List<eom> DdU;
  private a DdV;
  private ListView mListView;
  private ProgressDialog vIA;
  
  public SettingsSearchAuthUI()
  {
    AppMethodBeat.i(74392);
    this.DdU = new ArrayList();
    AppMethodBeat.o(74392);
  }
  
  private void eTg()
  {
    AppMethodBeat.i(74397);
    removeAllOptionMenu();
    if (!this.DdU.isEmpty())
    {
      if (this.Dcl)
      {
        addTextOptionMenu(700, getString(2131755858), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(74382);
            if (paramAnonymousMenuItem.getItemId() == 700)
            {
              SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, false);
              SettingsSearchAuthUI.g(SettingsSearchAuthUI.this).notifyDataSetChanged();
              SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
            }
            AppMethodBeat.o(74382);
            return true;
          }
        });
        AppMethodBeat.o(74397);
        return;
      }
      addTextOptionMenu(700, getString(2131755890), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74383);
          if (paramAnonymousMenuItem.getItemId() == 700)
          {
            SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, true);
            SettingsSearchAuthUI.g(SettingsSearchAuthUI.this).notifyDataSetChanged();
            SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
          }
          AppMethodBeat.o(74383);
          return true;
        }
      });
    }
    AppMethodBeat.o(74397);
  }
  
  public void finish()
  {
    AppMethodBeat.i(74398);
    super.finish();
    overridePendingTransition(2130772124, 2130771986);
    AppMethodBeat.o(74398);
  }
  
  public int getLayoutId()
  {
    return 2131496265;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74394);
    this.DdQ = new com.tencent.mm.ui.search.a(this);
    this.mListView = ((ListView)findViewById(2131297100));
    this.DdV = new a((byte)0);
    this.mListView.setAdapter(this.DdV);
    this.DdR = findViewById(2131307419);
    this.DdS = ((TextView)findViewById(2131307360));
    this.DdT = ((TextView)findViewById(2131307410));
    eTg();
    getSupportActionBar().setCustomView(this.DdQ);
    this.DdQ.setSearchViewListener(new a.b()
    {
      public final void onClickBackBtn(View paramAnonymousView)
      {
        AppMethodBeat.i(74374);
        Log.i("MicroMsg.SettingsSearchAuthUI", "click search back");
        SettingsSearchAuthUI.this.finish();
        AppMethodBeat.o(74374);
      }
    });
    this.DdQ.getFtsEditText().gWY();
    this.DdQ.getFtsEditText().setFtsEditTextListener(new FTSEditTextView.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, List<a.c> paramAnonymousList, FTSEditTextView.b paramAnonymousb)
      {
        AppMethodBeat.i(164137);
        Log.i("MicroMsg.SettingsSearchAuthUI", "search totalText %s", new Object[] { paramAnonymousString1 });
        if (!Util.isNullOrNil(paramAnonymousString1))
        {
          SettingsSearchAuthUI.a(SettingsSearchAuthUI.this);
          paramAnonymousString2 = SettingsSearchAuthUI.this.getString(2131755972);
          paramAnonymousString1 = new m(paramAnonymousString2 + " " + paramAnonymousString1.trim());
          paramAnonymousString1.setSpan(new ForegroundColorSpan(SettingsSearchAuthUI.this.getResources().getColor(2131100063)), paramAnonymousString2.length(), paramAnonymousString1.length(), 33);
          SettingsSearchAuthUI.b(SettingsSearchAuthUI.this).setText(paramAnonymousString1);
          AppMethodBeat.o(164137);
          return;
        }
        SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
        AppMethodBeat.o(164137);
      }
      
      public final boolean awE()
      {
        AppMethodBeat.i(74378);
        Log.i("MicroMsg.SettingsSearchAuthUI", "search key down");
        Editable localEditable = SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().getText();
        SettingsSearchAuthUI.b(SettingsSearchAuthUI.this).setVisibility(8);
        SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().clearFocus();
        SettingsSearchAuthUI.this.hideVKB();
        SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
        if (!Util.isNullOrNil(localEditable)) {
          SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, localEditable.toString().trim());
        }
        AppMethodBeat.o(74378);
        return true;
      }
      
      public final void dpw() {}
      
      public final void eh(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(74376);
        Log.i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          SettingsSearchAuthUI.this.showVKB();
          AppMethodBeat.o(74376);
          return;
        }
        SettingsSearchAuthUI.this.hideVKB();
        AppMethodBeat.o(74376);
      }
      
      public final void onClickClearTextBtn(View paramAnonymousView)
      {
        AppMethodBeat.i(74377);
        Log.i("MicroMsg.SettingsSearchAuthUI", "clear search text");
        SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
        AppMethodBeat.o(74377);
      }
    });
    this.DdS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74379);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().getText();
        if (!Util.isNullOrNil(paramAnonymousView)) {
          SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, paramAnonymousView.toString().trim());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74379);
      }
    });
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(74380);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (!SettingsSearchAuthUI.f(SettingsSearchAuthUI.this))
        {
          paramAnonymousView = SettingsSearchAuthUI.g(SettingsSearchAuthUI.this).Xp(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            paramAnonymousAdapterView = new Intent(SettingsSearchAuthUI.this, SettingsModifyUserAuthUI.class);
            localObject = (UserAuthItemParcelable[])UserAuthItemParcelable.CREATOR.newArray(paramAnonymousView.Nmn.size());
            paramAnonymousInt = 0;
            while (paramAnonymousInt < paramAnonymousView.Nmn.size())
            {
              eon localeon = (eon)paramAnonymousView.Nmn.get(paramAnonymousInt);
              UserAuthItemParcelable localUserAuthItemParcelable = new UserAuthItemParcelable();
              localUserAuthItemParcelable.scope = localeon.scope;
              localUserAuthItemParcelable.CYp = localeon.CYp;
              localUserAuthItemParcelable.state = localeon.state;
              localUserAuthItemParcelable.CYq = localeon.CYq;
              localObject[paramAnonymousInt] = localUserAuthItemParcelable;
              paramAnonymousInt += 1;
            }
            paramAnonymousAdapterView.putExtra("app_id", paramAnonymousView.dNI);
            paramAnonymousAdapterView.putExtra("app_name", paramAnonymousView.ixZ);
            paramAnonymousAdapterView.putExtra("modify_scene", 2);
            paramAnonymousAdapterView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList((Object[])localObject)));
            paramAnonymousView = SettingsSearchAuthUI.this;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(74380);
      }
    });
    this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(74381);
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          Log.i("MicroMsg.SettingsSearchAuthUI", "scroll to the end");
          if (SettingsSearchAuthUI.h(SettingsSearchAuthUI.this) != null)
          {
            SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, SettingsSearchAuthUI.h(SettingsSearchAuthUI.this));
            SettingsSearchAuthUI.i(SettingsSearchAuthUI.this);
          }
        }
        AppMethodBeat.o(74381);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(74394);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74393);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(74393);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74396);
    super.onPause();
    g.azz().b(1169, this);
    g.azz().b(1127, this);
    AppMethodBeat.o(74396);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74395);
    super.onResume();
    g.azz().a(1169, this);
    g.azz().a(1127, this);
    AppMethodBeat.o(74395);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74399);
    Log.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.vIA != null) {
      this.vIA.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() == 1169)
      {
        paramString = (l)paramq;
        label123:
        List localList;
        if ((paramString.CXQ != null) && (paramString.CXQ.McB == 1))
        {
          paramString = paramString.CXQ.Mcz.toByteArray();
          this.CXN = paramString;
          if (((l)paramq).CXN == null) {
            break label235;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            this.DdU.clear();
          }
          localList = this.DdU;
          paramString = (l)paramq;
          if (paramString.CXQ == null) {
            break label240;
          }
        }
        label235:
        label240:
        for (paramString = paramString.CXQ.McA;; paramString = Collections.emptyList())
        {
          localList.addAll(paramString);
          if (this.DdU.isEmpty()) {
            break label247;
          }
          this.DdV.Dcn = this.DdU;
          this.DdV.notifyDataSetChanged();
          this.DdR.setVisibility(8);
          this.mListView.setVisibility(0);
          eTg();
          AppMethodBeat.o(74399);
          return;
          paramString = null;
          break;
          paramInt1 = 0;
          break label123;
        }
        label247:
        this.DdR.setVisibility(0);
        this.DdS.setVisibility(8);
        this.DdT.setVisibility(0);
        this.mListView.setVisibility(8);
        this.DdU.clear();
        eTg();
        AppMethodBeat.o(74399);
        return;
      }
      if (paramq.getType() == 1127)
      {
        paramString = ((d)paramq).appId;
        if (!Util.isNullOrNil(paramString))
        {
          if (!this.DdU.isEmpty())
          {
            paramq = this.DdU.iterator();
            while (paramq.hasNext()) {
              if (((eom)paramq.next()).dNI.equals(paramString)) {
                paramq.remove();
              }
            }
          }
          this.DdV.notifyDataSetChanged();
        }
        AppMethodBeat.o(74399);
      }
    }
    else
    {
      h.cD(this, paramString);
    }
    AppMethodBeat.o(74399);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    List<eom> Dcn;
    
    private a() {}
    
    public final eom Xp(int paramInt)
    {
      AppMethodBeat.i(74389);
      if ((paramInt >= 0) && (paramInt < getCount()))
      {
        eom localeom = (eom)this.Dcn.get(paramInt);
        AppMethodBeat.o(74389);
        return localeom;
      }
      AppMethodBeat.o(74389);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74388);
      if ((this.Dcn != null) && (!this.Dcn.isEmpty()))
      {
        int i = this.Dcn.size();
        AppMethodBeat.o(74388);
        return i;
      }
      AppMethodBeat.o(74388);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(74390);
      View localView;
      if (paramView == null)
      {
        localView = SettingsSearchAuthUI.this.getLayoutInflater().inflate(2131496249, null);
        paramView = new a((byte)0);
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.oeJ = ((TextView)localView.findViewById(2131307691));
        paramViewGroup.Dcr = ((TextView)localView.findViewById(2131307692));
        paramViewGroup.Dcs = ((TextView)localView.findViewById(2131307690));
        paramViewGroup.kjo = ((Button)localView.findViewById(2131307689));
        paramViewGroup.kjo.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(74387);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (SettingsSearchAuthUI.a.this.Xp(paramInt) != null)
            {
              paramAnonymousView = new d(SettingsSearchAuthUI.a.this.Xp(paramInt).dNI, 2);
              if (SettingsSearchAuthUI.j(SettingsSearchAuthUI.this) != null) {
                SettingsSearchAuthUI.j(SettingsSearchAuthUI.this).dismiss();
              }
              g.azz().a(paramAnonymousView, 0);
              SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, h.a(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.getString(2131755978), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(74386);
                  g.azz().a(paramAnonymousView);
                  AppMethodBeat.o(74386);
                }
              }));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74387);
          }
        });
        if (!SettingsSearchAuthUI.f(SettingsSearchAuthUI.this)) {
          break label210;
        }
        paramViewGroup.kjo.setVisibility(0);
      }
      for (;;)
      {
        if (Xp(paramInt) != null)
        {
          paramViewGroup.oeJ.setText(Xp(paramInt).ixZ);
          paramViewGroup.Dcr.setText(Xp(paramInt).Nmo);
          paramViewGroup.Dcs.setText(SettingsSearchAuthUI.gH(Xp(paramInt).Nmn));
        }
        AppMethodBeat.o(74390);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label210:
        paramViewGroup.kjo.setVisibility(8);
      }
    }
    
    final class a
    {
      TextView Dcr;
      TextView Dcs;
      Button kjo;
      TextView oeJ;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI
 * JD-Core Version:    0.7.0.1
 */