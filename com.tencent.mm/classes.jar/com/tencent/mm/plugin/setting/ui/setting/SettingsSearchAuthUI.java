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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  implements com.tencent.mm.ak.g
{
  private ListView mListView;
  private ProgressDialog rGq;
  private byte[] xol;
  private boolean xsB;
  private com.tencent.mm.ui.search.a xuc;
  private View xud;
  private TextView xue;
  private TextView xuf;
  private List<dnz> xug;
  private a xuh;
  
  public SettingsSearchAuthUI()
  {
    AppMethodBeat.i(74392);
    this.xug = new ArrayList();
    AppMethodBeat.o(74392);
  }
  
  private void dCf()
  {
    AppMethodBeat.i(74397);
    removeAllOptionMenu();
    if (!this.xug.isEmpty())
    {
      if (this.xsB)
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
    this.xuc = new com.tencent.mm.ui.search.a(this);
    this.mListView = ((ListView)findViewById(2131296982));
    this.xuh = new a((byte)0);
    this.mListView.setAdapter(this.xuh);
    this.xud = findViewById(2131304443);
    this.xue = ((TextView)findViewById(2131304395));
    this.xuf = ((TextView)findViewById(2131304435));
    dCf();
    getSupportActionBar().setCustomView(this.xuc);
    this.xuc.setSearchViewListener(new a.b()
    {
      public final void onClickBackBtn(View paramAnonymousView)
      {
        AppMethodBeat.i(74374);
        ac.i("MicroMsg.SettingsSearchAuthUI", "click search back");
        SettingsSearchAuthUI.this.finish();
        AppMethodBeat.o(74374);
      }
    });
    this.xuc.getFtsEditText().ftb();
    this.xuc.getFtsEditText().setFtsEditTextListener(new FTSEditTextView.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, List<a.c> paramAnonymousList, FTSEditTextView.b paramAnonymousb)
      {
        AppMethodBeat.i(164137);
        ac.i("MicroMsg.SettingsSearchAuthUI", "search totalText %s", new Object[] { paramAnonymousString1 });
        if (!bs.isNullOrNil(paramAnonymousString1))
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
      
      public final boolean bvs()
      {
        AppMethodBeat.i(74378);
        ac.i("MicroMsg.SettingsSearchAuthUI", "search key down");
        Editable localEditable = SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().getText();
        SettingsSearchAuthUI.b(SettingsSearchAuthUI.this).setVisibility(8);
        SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().clearFocus();
        SettingsSearchAuthUI.this.hideVKB();
        SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
        if (!bs.aj(localEditable)) {
          SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, localEditable.toString().trim());
        }
        AppMethodBeat.o(74378);
        return true;
      }
      
      public final void cxG() {}
      
      public final void lF(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(74376);
        ac.i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
        ac.i("MicroMsg.SettingsSearchAuthUI", "clear search text");
        SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
        AppMethodBeat.o(74377);
      }
    });
    this.xue.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74379);
        paramAnonymousView = SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().getText();
        if (!bs.aj(paramAnonymousView)) {
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
          paramAnonymousView = SettingsSearchAuthUI.g(SettingsSearchAuthUI.this).NC(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            paramAnonymousAdapterView = new Intent(SettingsSearchAuthUI.this, SettingsModifyUserAuthUI.class);
            UserAuthItemParcelable[] arrayOfUserAuthItemParcelable = (UserAuthItemParcelable[])UserAuthItemParcelable.CREATOR.newArray(paramAnonymousView.FVF.size());
            paramAnonymousInt = 0;
            while (paramAnonymousInt < paramAnonymousView.FVF.size())
            {
              doa localdoa = (doa)paramAnonymousView.FVF.get(paramAnonymousInt);
              UserAuthItemParcelable localUserAuthItemParcelable = new UserAuthItemParcelable();
              localUserAuthItemParcelable.scope = localdoa.scope;
              localUserAuthItemParcelable.xoN = localdoa.xoN;
              localUserAuthItemParcelable.state = localdoa.state;
              localUserAuthItemParcelable.xoO = localdoa.xoO;
              arrayOfUserAuthItemParcelable[paramAnonymousInt] = localUserAuthItemParcelable;
              paramAnonymousInt += 1;
            }
            paramAnonymousAdapterView.putExtra("app_id", paramAnonymousView.djj);
            paramAnonymousAdapterView.putExtra("app_name", paramAnonymousView.hiX);
            paramAnonymousAdapterView.putExtra("modify_scene", 2);
            paramAnonymousAdapterView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(arrayOfUserAuthItemParcelable)));
            paramAnonymousView = SettingsSearchAuthUI.this;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lR(0));
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
          ac.i("MicroMsg.SettingsSearchAuthUI", "scroll to the end");
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
    com.tencent.mm.kernel.g.agi().b(1169, this);
    com.tencent.mm.kernel.g.agi().b(1127, this);
    AppMethodBeat.o(74396);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74395);
    super.onResume();
    com.tencent.mm.kernel.g.agi().a(1169, this);
    com.tencent.mm.kernel.g.agi().a(1127, this);
    AppMethodBeat.o(74395);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74399);
    ac.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.rGq != null) {
      this.rGq.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 1169)
      {
        paramString = (j)paramn;
        label123:
        List localList;
        if ((paramString.xoo != null) && (paramString.xoo.EUM == 1))
        {
          paramString = paramString.xoo.EUK.toByteArray();
          this.xol = paramString;
          if (((j)paramn).xol == null) {
            break label235;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            this.xug.clear();
          }
          localList = this.xug;
          paramString = (j)paramn;
          if (paramString.xoo == null) {
            break label240;
          }
        }
        label235:
        label240:
        for (paramString = paramString.xoo.EUL;; paramString = Collections.emptyList())
        {
          localList.addAll(paramString);
          if (this.xug.isEmpty()) {
            break label247;
          }
          this.xuh.xsD = this.xug;
          this.xuh.notifyDataSetChanged();
          this.xud.setVisibility(8);
          this.mListView.setVisibility(0);
          dCf();
          AppMethodBeat.o(74399);
          return;
          paramString = null;
          break;
          paramInt1 = 0;
          break label123;
        }
        label247:
        this.xud.setVisibility(0);
        this.xue.setVisibility(8);
        this.xuf.setVisibility(0);
        this.mListView.setVisibility(8);
        this.xug.clear();
        dCf();
        AppMethodBeat.o(74399);
        return;
      }
      if (paramn.getType() == 1127)
      {
        paramString = ((c)paramn).appId;
        if (!bs.isNullOrNil(paramString))
        {
          if (!this.xug.isEmpty())
          {
            paramn = this.xug.iterator();
            while (paramn.hasNext()) {
              if (((dnz)paramn.next()).djj.equals(paramString)) {
                paramn.remove();
              }
            }
          }
          this.xuh.notifyDataSetChanged();
        }
        AppMethodBeat.o(74399);
      }
    }
    else
    {
      h.cg(this, paramString);
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
    List<dnz> xsD;
    
    private a() {}
    
    public final dnz NC(int paramInt)
    {
      AppMethodBeat.i(74389);
      if ((paramInt >= 0) && (paramInt < getCount()))
      {
        dnz localdnz = (dnz)this.xsD.get(paramInt);
        AppMethodBeat.o(74389);
        return localdnz;
      }
      AppMethodBeat.o(74389);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74388);
      if ((this.xsD != null) && (!this.xsD.isEmpty()))
      {
        int i = this.xsD.size();
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
        paramViewGroup.mmb = ((TextView)localView.findViewById(2131304638));
        paramViewGroup.xsH = ((TextView)localView.findViewById(2131304639));
        paramViewGroup.xsI = ((TextView)localView.findViewById(2131304637));
        paramViewGroup.iPj = ((Button)localView.findViewById(2131304636));
        paramViewGroup.iPj.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(74387);
            if (SettingsSearchAuthUI.a.this.NC(paramInt) != null)
            {
              paramAnonymousView = new c(SettingsSearchAuthUI.a.this.NC(paramInt).djj, 2);
              if (SettingsSearchAuthUI.j(SettingsSearchAuthUI.this) != null) {
                SettingsSearchAuthUI.j(SettingsSearchAuthUI.this).dismiss();
              }
              com.tencent.mm.kernel.g.agi().a(paramAnonymousView, 0);
              SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, h.b(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(74386);
                  com.tencent.mm.kernel.g.agi().a(paramAnonymousView);
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
        paramViewGroup.iPj.setVisibility(0);
      }
      for (;;)
      {
        if (NC(paramInt) != null)
        {
          paramViewGroup.mmb.setText(NC(paramInt).hiX);
          paramViewGroup.xsH.setText(NC(paramInt).FVG);
          paramViewGroup.xsI.setText(SettingsSearchAuthUI.fo(NC(paramInt).FVF));
        }
        AppMethodBeat.o(74390);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label210:
        paramViewGroup.iPj.setVisibility(8);
      }
    }
    
    final class a
    {
      Button iPj;
      TextView mmb;
      TextView xsH;
      TextView xsI;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI
 * JD-Core Version:    0.7.0.1
 */