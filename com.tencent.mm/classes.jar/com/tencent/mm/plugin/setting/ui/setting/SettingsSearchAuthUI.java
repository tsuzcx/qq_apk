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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.plugin.setting.model.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.czr;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private ProgressDialog sMH;
  private byte[] ySV;
  private boolean yXu;
  private com.tencent.mm.ui.search.a yYX;
  private View yYY;
  private TextView yYZ;
  private TextView yZa;
  private List<dun> yZb;
  private a yZc;
  
  public SettingsSearchAuthUI()
  {
    AppMethodBeat.i(74392);
    this.yZb = new ArrayList();
    AppMethodBeat.o(74392);
  }
  
  private void dRf()
  {
    AppMethodBeat.i(74397);
    removeAllOptionMenu();
    if (!this.yZb.isEmpty())
    {
      if (this.yXu)
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
    this.yYX = new com.tencent.mm.ui.search.a(this);
    this.mListView = ((ListView)findViewById(2131296982));
    this.yZc = new a((byte)0);
    this.mListView.setAdapter(this.yZc);
    this.yYY = findViewById(2131304443);
    this.yYZ = ((TextView)findViewById(2131304395));
    this.yZa = ((TextView)findViewById(2131304435));
    dRf();
    getSupportActionBar().setCustomView(this.yYX);
    this.yYX.setSearchViewListener(new a.b()
    {
      public final void onClickBackBtn(View paramAnonymousView)
      {
        AppMethodBeat.i(74374);
        ae.i("MicroMsg.SettingsSearchAuthUI", "click search back");
        SettingsSearchAuthUI.this.finish();
        AppMethodBeat.o(74374);
      }
    });
    this.yYX.getFtsEditText().fOg();
    this.yYX.getFtsEditText().setFtsEditTextListener(new FTSEditTextView.a()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, List<a.c> paramAnonymousList, FTSEditTextView.b paramAnonymousb)
      {
        AppMethodBeat.i(164137);
        ae.i("MicroMsg.SettingsSearchAuthUI", "search totalText %s", new Object[] { paramAnonymousString1 });
        if (!bu.isNullOrNil(paramAnonymousString1))
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
      
      public final boolean bAu()
      {
        AppMethodBeat.i(74378);
        ae.i("MicroMsg.SettingsSearchAuthUI", "search key down");
        Editable localEditable = SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().getText();
        SettingsSearchAuthUI.b(SettingsSearchAuthUI.this).setVisibility(8);
        SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().clearFocus();
        SettingsSearchAuthUI.this.hideVKB();
        SettingsSearchAuthUI.e(SettingsSearchAuthUI.this);
        if (!bu.ah(localEditable)) {
          SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, localEditable.toString().trim());
        }
        AppMethodBeat.o(74378);
        return true;
      }
      
      public final void cGz() {}
      
      public final void mb(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(74376);
        ae.i("MicroMsg.SettingsSearchAuthUI", "searchView hasFocus %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
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
        ae.i("MicroMsg.SettingsSearchAuthUI", "clear search text");
        SettingsSearchAuthUI.c(SettingsSearchAuthUI.this);
        AppMethodBeat.o(74377);
      }
    });
    this.yYZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74379);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = SettingsSearchAuthUI.d(SettingsSearchAuthUI.this).getFtsEditText().getEditText().getText();
        if (!bu.ah(paramAnonymousView)) {
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (!SettingsSearchAuthUI.f(SettingsSearchAuthUI.this))
        {
          paramAnonymousView = SettingsSearchAuthUI.g(SettingsSearchAuthUI.this).PM(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            paramAnonymousAdapterView = new Intent(SettingsSearchAuthUI.this, SettingsModifyUserAuthUI.class);
            localObject = (UserAuthItemParcelable[])UserAuthItemParcelable.CREATOR.newArray(paramAnonymousView.Iag.size());
            paramAnonymousInt = 0;
            while (paramAnonymousInt < paramAnonymousView.Iag.size())
            {
              duo localduo = (duo)paramAnonymousView.Iag.get(paramAnonymousInt);
              UserAuthItemParcelable localUserAuthItemParcelable = new UserAuthItemParcelable();
              localUserAuthItemParcelable.scope = localduo.scope;
              localUserAuthItemParcelable.yTx = localduo.yTx;
              localUserAuthItemParcelable.state = localduo.state;
              localUserAuthItemParcelable.yTy = localduo.yTy;
              localObject[paramAnonymousInt] = localUserAuthItemParcelable;
              paramAnonymousInt += 1;
            }
            paramAnonymousAdapterView.putExtra("app_id", paramAnonymousView.dwb);
            paramAnonymousAdapterView.putExtra("app_name", paramAnonymousView.hDU);
            paramAnonymousAdapterView.putExtra("modify_scene", 2);
            paramAnonymousAdapterView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList((Object[])localObject)));
            paramAnonymousView = SettingsSearchAuthUI.this;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$4", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mt(0));
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
          ae.i("MicroMsg.SettingsSearchAuthUI", "scroll to the end");
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
    g.ajj().b(1169, this);
    g.ajj().b(1127, this);
    AppMethodBeat.o(74396);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74395);
    super.onResume();
    g.ajj().a(1169, this);
    g.ajj().a(1127, this);
    AppMethodBeat.o(74395);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74399);
    ae.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.sMH != null) {
      this.sMH.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 1169)
      {
        paramString = (k)paramn;
        label123:
        List localList;
        if ((paramString.ySY != null) && (paramString.ySY.GXM == 1))
        {
          paramString = paramString.ySY.GXK.toByteArray();
          this.ySV = paramString;
          if (((k)paramn).ySV == null) {
            break label235;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            this.yZb.clear();
          }
          localList = this.yZb;
          paramString = (k)paramn;
          if (paramString.ySY == null) {
            break label240;
          }
        }
        label235:
        label240:
        for (paramString = paramString.ySY.GXL;; paramString = Collections.emptyList())
        {
          localList.addAll(paramString);
          if (this.yZb.isEmpty()) {
            break label247;
          }
          this.yZc.yXw = this.yZb;
          this.yZc.notifyDataSetChanged();
          this.yYY.setVisibility(8);
          this.mListView.setVisibility(0);
          dRf();
          AppMethodBeat.o(74399);
          return;
          paramString = null;
          break;
          paramInt1 = 0;
          break label123;
        }
        label247:
        this.yYY.setVisibility(0);
        this.yYZ.setVisibility(8);
        this.yZa.setVisibility(0);
        this.mListView.setVisibility(8);
        this.yZb.clear();
        dRf();
        AppMethodBeat.o(74399);
        return;
      }
      if (paramn.getType() == 1127)
      {
        paramString = ((d)paramn).appId;
        if (!bu.isNullOrNil(paramString))
        {
          if (!this.yZb.isEmpty())
          {
            paramn = this.yZb.iterator();
            while (paramn.hasNext()) {
              if (((dun)paramn.next()).dwb.equals(paramString)) {
                paramn.remove();
              }
            }
          }
          this.yZc.notifyDataSetChanged();
        }
        AppMethodBeat.o(74399);
      }
    }
    else
    {
      h.cm(this, paramString);
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
    List<dun> yXw;
    
    private a() {}
    
    public final dun PM(int paramInt)
    {
      AppMethodBeat.i(74389);
      if ((paramInt >= 0) && (paramInt < getCount()))
      {
        dun localdun = (dun)this.yXw.get(paramInt);
        AppMethodBeat.o(74389);
        return localdun;
      }
      AppMethodBeat.o(74389);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74388);
      if ((this.yXw != null) && (!this.yXw.isEmpty()))
      {
        int i = this.yXw.size();
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
        paramViewGroup.mRG = ((TextView)localView.findViewById(2131304638));
        paramViewGroup.yXA = ((TextView)localView.findViewById(2131304639));
        paramViewGroup.yXB = ((TextView)localView.findViewById(2131304637));
        paramViewGroup.jll = ((Button)localView.findViewById(2131304636));
        paramViewGroup.jll.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(74387);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSearchAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (SettingsSearchAuthUI.a.this.PM(paramInt) != null)
            {
              paramAnonymousView = new d(SettingsSearchAuthUI.a.this.PM(paramInt).dwb, 2);
              if (SettingsSearchAuthUI.j(SettingsSearchAuthUI.this) != null) {
                SettingsSearchAuthUI.j(SettingsSearchAuthUI.this).dismiss();
              }
              g.ajj().a(paramAnonymousView, 0);
              SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, h.b(SettingsSearchAuthUI.this, SettingsSearchAuthUI.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(74386);
                  g.ajj().a(paramAnonymousView);
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
        paramViewGroup.jll.setVisibility(0);
      }
      for (;;)
      {
        if (PM(paramInt) != null)
        {
          paramViewGroup.mRG.setText(PM(paramInt).hDU);
          paramViewGroup.yXA.setText(PM(paramInt).Iah);
          paramViewGroup.yXB.setText(SettingsSearchAuthUI.fJ(PM(paramInt).Iag));
        }
        AppMethodBeat.o(74390);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label210:
        paramViewGroup.jll.setVisibility(8);
      }
    }
    
    final class a
    {
      Button jll;
      TextView mRG;
      TextView yXA;
      TextView yXB;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI
 * JD-Core Version:    0.7.0.1
 */