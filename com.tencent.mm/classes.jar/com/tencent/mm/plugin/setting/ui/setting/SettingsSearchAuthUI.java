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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.protocal.protobuf.dil;
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
  implements com.tencent.mm.al.g
{
  private ListView mListView;
  private ProgressDialog qLE;
  private byte[] wcX;
  private boolean whl;
  private com.tencent.mm.ui.search.a wiM;
  private View wiN;
  private TextView wiO;
  private TextView wiP;
  private List<dik> wiQ;
  private a wiR;
  
  public SettingsSearchAuthUI()
  {
    AppMethodBeat.i(74392);
    this.wiQ = new ArrayList();
    AppMethodBeat.o(74392);
  }
  
  private void dnX()
  {
    AppMethodBeat.i(74397);
    removeAllOptionMenu();
    if (!this.wiQ.isEmpty())
    {
      if (this.whl)
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
    this.wiM = new com.tencent.mm.ui.search.a(this);
    this.mListView = ((ListView)findViewById(2131296982));
    this.wiR = new a((byte)0);
    this.mListView.setAdapter(this.wiR);
    this.wiN = findViewById(2131304443);
    this.wiO = ((TextView)findViewById(2131304395));
    this.wiP = ((TextView)findViewById(2131304435));
    dnX();
    getSupportActionBar().setCustomView(this.wiM);
    this.wiM.setSearchViewListener(new a.b()
    {
      public final void onClickBackBtn(View paramAnonymousView)
      {
        AppMethodBeat.i(74374);
        ad.i("MicroMsg.SettingsSearchAuthUI", "click search back");
        SettingsSearchAuthUI.this.finish();
        AppMethodBeat.o(74374);
      }
    });
    this.wiM.getFtsEditText().fdg();
    this.wiM.getFtsEditText().setFtsEditTextListener(new FTSEditTextView.a()
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
      
      public final boolean bow()
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
      
      public final void cok() {}
      
      public final void lb(boolean paramAnonymousBoolean)
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
    this.wiO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74379);
        paramAnonymousView = SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().getText();
        if (!bt.ai(paramAnonymousView)) {
          SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, paramAnonymousView.toString().trim());
        }
        AppMethodBeat.o(74379);
      }
    });
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(74380);
        if (!SettingsSearchAuthUI.f(SettingsSearchAuthUI.this))
        {
          paramAnonymousView = SettingsSearchAuthUI.g(SettingsSearchAuthUI.this).LC(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            paramAnonymousAdapterView = new Intent(SettingsSearchAuthUI.this, SettingsModifyUserAuthUI.class);
            UserAuthItemParcelable[] arrayOfUserAuthItemParcelable = (UserAuthItemParcelable[])UserAuthItemParcelable.CREATOR.newArray(paramAnonymousView.EyD.size());
            paramAnonymousInt = 0;
            while (paramAnonymousInt < paramAnonymousView.EyD.size())
            {
              dil localdil = (dil)paramAnonymousView.EyD.get(paramAnonymousInt);
              UserAuthItemParcelable localUserAuthItemParcelable = new UserAuthItemParcelable();
              localUserAuthItemParcelable.scope = localdil.scope;
              localUserAuthItemParcelable.wdz = localdil.wdz;
              localUserAuthItemParcelable.state = localdil.state;
              localUserAuthItemParcelable.wdA = localdil.wdA;
              arrayOfUserAuthItemParcelable[paramAnonymousInt] = localUserAuthItemParcelable;
              paramAnonymousInt += 1;
            }
            paramAnonymousAdapterView.putExtra("app_id", paramAnonymousView.dlB);
            paramAnonymousAdapterView.putExtra("app_name", paramAnonymousView.gIw);
            paramAnonymousAdapterView.putExtra("modify_scene", 2);
            paramAnonymousAdapterView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(arrayOfUserAuthItemParcelable)));
            paramAnonymousView = SettingsSearchAuthUI.this;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
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
    com.tencent.mm.kernel.g.aeS().b(1169, this);
    com.tencent.mm.kernel.g.aeS().b(1127, this);
    AppMethodBeat.o(74396);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74395);
    super.onResume();
    com.tencent.mm.kernel.g.aeS().a(1169, this);
    com.tencent.mm.kernel.g.aeS().a(1127, this);
    AppMethodBeat.o(74395);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74399);
    ad.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.qLE != null) {
      this.qLE.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 1169)
      {
        paramString = (j)paramn;
        label123:
        List localList;
        if ((paramString.wda != null) && (paramString.wda.Dzq == 1))
        {
          paramString = paramString.wda.Dzo.toByteArray();
          this.wcX = paramString;
          if (((j)paramn).wcX == null) {
            break label235;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            this.wiQ.clear();
          }
          localList = this.wiQ;
          paramString = (j)paramn;
          if (paramString.wda == null) {
            break label240;
          }
        }
        label235:
        label240:
        for (paramString = paramString.wda.Dzp;; paramString = Collections.emptyList())
        {
          localList.addAll(paramString);
          if (this.wiQ.isEmpty()) {
            break label247;
          }
          this.wiR.whn = this.wiQ;
          this.wiR.notifyDataSetChanged();
          this.wiN.setVisibility(8);
          this.mListView.setVisibility(0);
          dnX();
          AppMethodBeat.o(74399);
          return;
          paramString = null;
          break;
          paramInt1 = 0;
          break label123;
        }
        label247:
        this.wiN.setVisibility(0);
        this.wiO.setVisibility(8);
        this.wiP.setVisibility(0);
        this.mListView.setVisibility(8);
        this.wiQ.clear();
        dnX();
        AppMethodBeat.o(74399);
        return;
      }
      if (paramn.getType() == 1127)
      {
        paramString = ((c)paramn).appId;
        if (!bt.isNullOrNil(paramString))
        {
          if (!this.wiQ.isEmpty())
          {
            paramn = this.wiQ.iterator();
            while (paramn.hasNext()) {
              if (((dik)paramn.next()).dlB.equals(paramString)) {
                paramn.remove();
              }
            }
          }
          this.wiR.notifyDataSetChanged();
        }
        AppMethodBeat.o(74399);
      }
    }
    else
    {
      h.cf(this, paramString);
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
    List<dik> whn;
    
    private a() {}
    
    public final dik LC(int paramInt)
    {
      AppMethodBeat.i(74389);
      if ((paramInt >= 0) && (paramInt < getCount()))
      {
        dik localdik = (dik)this.whn.get(paramInt);
        AppMethodBeat.o(74389);
        return localdik;
      }
      AppMethodBeat.o(74389);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74388);
      if ((this.whn != null) && (!this.whn.isEmpty()))
      {
        int i = this.whn.size();
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
        paramViewGroup.lKe = ((TextView)localView.findViewById(2131304638));
        paramViewGroup.whr = ((TextView)localView.findViewById(2131304639));
        paramViewGroup.whs = ((TextView)localView.findViewById(2131304637));
        paramViewGroup.ipd = ((Button)localView.findViewById(2131304636));
        paramViewGroup.ipd.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(74387);
            if (SettingsSearchAuthUI.a.this.LC(paramInt) != null)
            {
              paramAnonymousView = new c(SettingsSearchAuthUI.a.this.LC(paramInt).dlB, 2);
              if (SettingsSearchAuthUI.j(SettingsSearchAuthUI.this) != null) {
                SettingsSearchAuthUI.j(SettingsSearchAuthUI.this).dismiss();
              }
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousView, 0);
              SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, h.b(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(74386);
                  com.tencent.mm.kernel.g.aeS().a(paramAnonymousView);
                  AppMethodBeat.o(74386);
                }
              }));
            }
            AppMethodBeat.o(74387);
          }
        });
        if (!SettingsSearchAuthUI.f(SettingsSearchAuthUI.this)) {
          break label210;
        }
        paramViewGroup.ipd.setVisibility(0);
      }
      for (;;)
      {
        if (LC(paramInt) != null)
        {
          paramViewGroup.lKe.setText(LC(paramInt).gIw);
          paramViewGroup.whr.setText(LC(paramInt).EyE);
          paramViewGroup.whs.setText(SettingsSearchAuthUI.fg(LC(paramInt).EyD));
        }
        AppMethodBeat.o(74390);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label210:
        paramViewGroup.ipd.setVisibility(8);
      }
    }
    
    final class a
    {
      Button ipd;
      TextView lKe;
      TextView whr;
      TextView whs;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI
 * JD-Core Version:    0.7.0.1
 */