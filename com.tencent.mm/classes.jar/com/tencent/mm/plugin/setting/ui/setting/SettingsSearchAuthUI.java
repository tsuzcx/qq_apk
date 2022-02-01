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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.protocal.protobuf.dtr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  implements f
{
  private ListView mListView;
  private ProgressDialog sBI;
  private byte[] yCQ;
  private boolean yHk;
  private com.tencent.mm.ui.search.a yIN;
  private View yIO;
  private TextView yIP;
  private TextView yIQ;
  private List<dtq> yIR;
  private a yIS;
  
  public SettingsSearchAuthUI()
  {
    AppMethodBeat.i(74392);
    this.yIR = new ArrayList();
    AppMethodBeat.o(74392);
  }
  
  private void dNI()
  {
    AppMethodBeat.i(74397);
    removeAllOptionMenu();
    if (!this.yIR.isEmpty())
    {
      if (this.yHk)
      {
        addTextOptionMenu(700, getString(2131755779), new MenuItem.OnMenuItemClickListener()
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
      addTextOptionMenu(700, getString(2131755808), new MenuItem.OnMenuItemClickListener()
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
    overridePendingTransition(2130772100, 2130771986);
    AppMethodBeat.o(74398);
  }
  
  public int getLayoutId()
  {
    return 2131495403;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74394);
    this.yIN = new com.tencent.mm.ui.search.a(this);
    this.mListView = ((ListView)findViewById(2131296982));
    this.yIS = new a((byte)0);
    this.mListView.setAdapter(this.yIS);
    this.yIO = findViewById(2131304443);
    this.yIP = ((TextView)findViewById(2131304395));
    this.yIQ = ((TextView)findViewById(2131304435));
    dNI();
    getSupportActionBar().setCustomView(this.yIN);
    this.yIN.setSearchViewListener(new a.b()
    {
      public final void onClickBackBtn(View paramAnonymousView)
      {
        AppMethodBeat.i(74374);
        ad.i("MicroMsg.SettingsSearchAuthUI", "click search back");
        SettingsSearchAuthUI.this.finish();
        AppMethodBeat.o(74374);
      }
    });
    this.yIN.getFtsEditText().fJP();
    this.yIN.getFtsEditText().setFtsEditTextListener(new FTSEditTextView.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, List<a.c> paramAnonymousList, FTSEditTextView.b paramAnonymousb)
      {
        AppMethodBeat.i(164137);
        ad.i("MicroMsg.SettingsSearchAuthUI", "search totalText %s", new Object[] { paramAnonymousString1 });
        if (!bt.isNullOrNil(paramAnonymousString1))
        {
          SettingsSearchAuthUI.a(SettingsSearchAuthUI.this);
          paramAnonymousString2 = SettingsSearchAuthUI.this.getString(2131755882);
          paramAnonymousString1 = new l(paramAnonymousString2 + " " + paramAnonymousString1.trim());
          paramAnonymousString1.setSpan(new ForegroundColorSpan(SettingsSearchAuthUI.this.getResources().getColor(2131100035)), paramAnonymousString2.length(), paramAnonymousString1.length(), 33);
          SettingsSearchAuthUI.b(SettingsSearchAuthUI.this).setText(paramAnonymousString1);
          AppMethodBeat.o(164137);
          return;
        }
        SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
        AppMethodBeat.o(164137);
      }
      
      public final boolean bzz()
      {
        AppMethodBeat.i(74378);
        ad.i("MicroMsg.SettingsSearchAuthUI", "search key down");
        Editable localEditable = SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().getText();
        SettingsSearchAuthUI.b(SettingsSearchAuthUI.this).setVisibility(8);
        SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().clearFocus();
        SettingsSearchAuthUI.this.hideVKB();
        SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
        if (!bt.ai(localEditable)) {
          SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, localEditable.toString().trim());
        }
        AppMethodBeat.o(74378);
        return true;
      }
      
      public final void cED() {}
      
      public final void ma(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(74376);
        ad.i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
        ad.i("MicroMsg.SettingsSearchAuthUI", "clear search text");
        SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
        AppMethodBeat.o(74377);
      }
    });
    this.yIP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74379);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().getText();
        if (!bt.ai(paramAnonymousView)) {
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (!SettingsSearchAuthUI.f(SettingsSearchAuthUI.this))
        {
          paramAnonymousView = SettingsSearchAuthUI.g(SettingsSearchAuthUI.this).Pf(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            paramAnonymousAdapterView = new Intent(SettingsSearchAuthUI.this, SettingsModifyUserAuthUI.class);
            localObject = (UserAuthItemParcelable[])UserAuthItemParcelable.CREATOR.newArray(paramAnonymousView.HGt.size());
            paramAnonymousInt = 0;
            while (paramAnonymousInt < paramAnonymousView.HGt.size())
            {
              dtr localdtr = (dtr)paramAnonymousView.HGt.get(paramAnonymousInt);
              UserAuthItemParcelable localUserAuthItemParcelable = new UserAuthItemParcelable();
              localUserAuthItemParcelable.scope = localdtr.scope;
              localUserAuthItemParcelable.yDs = localdtr.yDs;
              localUserAuthItemParcelable.state = localdtr.state;
              localUserAuthItemParcelable.yDt = localdtr.yDt;
              localObject[paramAnonymousInt] = localUserAuthItemParcelable;
              paramAnonymousInt += 1;
            }
            paramAnonymousAdapterView.putExtra("app_id", paramAnonymousView.duW);
            paramAnonymousAdapterView.putExtra("app_name", paramAnonymousView.hBg);
            paramAnonymousAdapterView.putExtra("modify_scene", 2);
            paramAnonymousAdapterView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList((Object[])localObject)));
            paramAnonymousView = SettingsSearchAuthUI.this;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mq(0));
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
          ad.i("MicroMsg.SettingsSearchAuthUI", "scroll to the end");
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
    g.aiU().b(1169, this);
    g.aiU().b(1127, this);
    AppMethodBeat.o(74396);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74395);
    super.onResume();
    g.aiU().a(1169, this);
    g.aiU().a(1127, this);
    AppMethodBeat.o(74395);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74399);
    ad.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.sBI != null) {
      this.sBI.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 1169)
      {
        paramString = (j)paramn;
        label123:
        List localList;
        if ((paramString.yCT != null) && (paramString.yCT.GEj == 1))
        {
          paramString = paramString.yCT.GEh.toByteArray();
          this.yCQ = paramString;
          if (((j)paramn).yCQ == null) {
            break label235;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            this.yIR.clear();
          }
          localList = this.yIR;
          paramString = (j)paramn;
          if (paramString.yCT == null) {
            break label240;
          }
        }
        label235:
        label240:
        for (paramString = paramString.yCT.GEi;; paramString = Collections.emptyList())
        {
          localList.addAll(paramString);
          if (this.yIR.isEmpty()) {
            break label247;
          }
          this.yIS.yHm = this.yIR;
          this.yIS.notifyDataSetChanged();
          this.yIO.setVisibility(8);
          this.mListView.setVisibility(0);
          dNI();
          AppMethodBeat.o(74399);
          return;
          paramString = null;
          break;
          paramInt1 = 0;
          break label123;
        }
        label247:
        this.yIO.setVisibility(0);
        this.yIP.setVisibility(8);
        this.yIQ.setVisibility(0);
        this.mListView.setVisibility(8);
        this.yIR.clear();
        dNI();
        AppMethodBeat.o(74399);
        return;
      }
      if (paramn.getType() == 1127)
      {
        paramString = ((c)paramn).appId;
        if (!bt.isNullOrNil(paramString))
        {
          if (!this.yIR.isEmpty())
          {
            paramn = this.yIR.iterator();
            while (paramn.hasNext()) {
              if (((dtq)paramn.next()).duW.equals(paramString)) {
                paramn.remove();
              }
            }
          }
          this.yIS.notifyDataSetChanged();
        }
        AppMethodBeat.o(74399);
      }
    }
    else
    {
      h.cl(this, paramString);
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
    List<dtq> yHm;
    
    private a() {}
    
    public final dtq Pf(int paramInt)
    {
      AppMethodBeat.i(74389);
      if ((paramInt >= 0) && (paramInt < getCount()))
      {
        dtq localdtq = (dtq)this.yHm.get(paramInt);
        AppMethodBeat.o(74389);
        return localdtq;
      }
      AppMethodBeat.o(74389);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74388);
      if ((this.yHm != null) && (!this.yHm.isEmpty()))
      {
        int i = this.yHm.size();
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
        localView = SettingsSearchAuthUI.this.getLayoutInflater().inflate(2131495388, null);
        paramView = new a((byte)0);
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.mMD = ((TextView)localView.findViewById(2131304638));
        paramViewGroup.yHq = ((TextView)localView.findViewById(2131304639));
        paramViewGroup.yHr = ((TextView)localView.findViewById(2131304637));
        paramViewGroup.jis = ((Button)localView.findViewById(2131304636));
        paramViewGroup.jis.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(74387);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (SettingsSearchAuthUI.a.this.Pf(paramInt) != null)
            {
              paramAnonymousView = new c(SettingsSearchAuthUI.a.this.Pf(paramInt).duW, 2);
              if (SettingsSearchAuthUI.j(SettingsSearchAuthUI.this) != null) {
                SettingsSearchAuthUI.j(SettingsSearchAuthUI.this).dismiss();
              }
              g.aiU().a(paramAnonymousView, 0);
              SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, h.b(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(74386);
                  g.aiU().a(paramAnonymousView);
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
        paramViewGroup.jis.setVisibility(0);
      }
      for (;;)
      {
        if (Pf(paramInt) != null)
        {
          paramViewGroup.mMD.setText(Pf(paramInt).hBg);
          paramViewGroup.yHq.setText(Pf(paramInt).HGu);
          paramViewGroup.yHr.setText(SettingsSearchAuthUI.fB(Pf(paramInt).HGt));
        }
        AppMethodBeat.o(74390);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label210:
        paramViewGroup.jis.setVisibility(8);
      }
    }
    
    final class a
    {
      Button jis;
      TextView mMD;
      TextView yHq;
      TextView yHr;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI
 * JD-Core Version:    0.7.0.1
 */