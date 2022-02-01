package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable.Creator;
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
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.protocal.protobuf.dtr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SettingsManageAuthUI
  extends MMActivity
  implements f
{
  private ListView mListView;
  private ProgressDialog sBI;
  private View tke;
  private byte[] yCQ;
  private a yHi;
  private List<dtq> yHj;
  private boolean yHk;
  
  public SettingsManageAuthUI()
  {
    AppMethodBeat.i(74195);
    this.yHj = new ArrayList();
    AppMethodBeat.o(74195);
  }
  
  private static void bG(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(74201);
    paramArrayOfByte = new com.tencent.mm.plugin.setting.model.g(paramArrayOfByte);
    com.tencent.mm.kernel.g.aiU().a(paramArrayOfByte, 0);
    AppMethodBeat.o(74201);
  }
  
  private void dNI()
  {
    AppMethodBeat.i(74198);
    removeAllOptionMenu();
    addIconOptionMenu(800, 2131689510, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74186);
        Object localObject = new Intent(SettingsManageAuthUI.this, SettingsSearchAuthUI.class);
        paramAnonymousMenuItem = SettingsManageAuthUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kc(SettingsManageAuthUI.this);
        AppMethodBeat.o(74186);
        return true;
      }
    });
    if (this.yHj.isEmpty())
    {
      this.tke.setVisibility(0);
      AppMethodBeat.o(74198);
      return;
    }
    this.tke.setVisibility(8);
    if (this.yHk)
    {
      addTextOptionMenu(700, getString(2131755779), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74187);
          if (paramAnonymousMenuItem.getItemId() == 700)
          {
            SettingsManageAuthUI.a(SettingsManageAuthUI.this, false);
            SettingsManageAuthUI.d(SettingsManageAuthUI.this).notifyDataSetChanged();
            SettingsManageAuthUI.e(SettingsManageAuthUI.this);
          }
          AppMethodBeat.o(74187);
          return true;
        }
      });
      AppMethodBeat.o(74198);
      return;
    }
    addTextOptionMenu(700, getString(2131755808), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74188);
        if (paramAnonymousMenuItem.getItemId() == 700)
        {
          SettingsManageAuthUI.a(SettingsManageAuthUI.this, true);
          SettingsManageAuthUI.d(SettingsManageAuthUI.this).notifyDataSetChanged();
          SettingsManageAuthUI.e(SettingsManageAuthUI.this);
        }
        AppMethodBeat.o(74188);
        return true;
      }
    });
    AppMethodBeat.o(74198);
  }
  
  public int getLayoutId()
  {
    return 2131495395;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74197);
    this.mListView = ((ListView)findViewById(2131296982));
    this.tke = findViewById(2131296981);
    this.yHi = new a((byte)0);
    this.mListView.setAdapter(this.yHi);
    this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(74183);
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          ad.i("MicroMsg.SettingsManageAuthUI", "scroll to the end");
          if (SettingsManageAuthUI.a(SettingsManageAuthUI.this) != null)
          {
            SettingsManageAuthUI.bH(SettingsManageAuthUI.a(SettingsManageAuthUI.this));
            SettingsManageAuthUI.b(SettingsManageAuthUI.this);
          }
        }
        AppMethodBeat.o(74183);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(74184);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (!SettingsManageAuthUI.c(SettingsManageAuthUI.this))
        {
          paramAnonymousView = SettingsManageAuthUI.d(SettingsManageAuthUI.this).Pf(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            paramAnonymousAdapterView = new Intent(SettingsManageAuthUI.this, SettingsModifyUserAuthUI.class);
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
            paramAnonymousAdapterView.putExtra("modify_scene", 1);
            paramAnonymousAdapterView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList((Object[])localObject)));
            paramAnonymousView = SettingsManageAuthUI.this;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(74184);
      }
    });
    dNI();
    setMMTitle(2131763175);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74185);
        SettingsManageAuthUI.this.finish();
        AppMethodBeat.o(74185);
        return true;
      }
    });
    AppMethodBeat.o(74197);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74196);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(74196);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74200);
    super.onPause();
    com.tencent.mm.kernel.g.aiU().b(1146, this);
    com.tencent.mm.kernel.g.aiU().b(1127, this);
    AppMethodBeat.o(74200);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74199);
    super.onResume();
    com.tencent.mm.kernel.g.aiU().a(1146, this);
    com.tencent.mm.kernel.g.aiU().a(1127, this);
    bG(null);
    AppMethodBeat.o(74199);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74202);
    ad.i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.sBI != null) {
      this.sBI.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 1146)
      {
        paramString = (com.tencent.mm.plugin.setting.model.g)paramn;
        label120:
        List localList;
        if ((paramString.yCP != null) && (paramString.yCP.GEj == 1))
        {
          paramString = paramString.yCP.GEh.toByteArray();
          this.yCQ = paramString;
          if (((com.tencent.mm.plugin.setting.model.g)paramn).yCQ == null) {
            break label202;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            this.yHj.clear();
          }
          localList = this.yHj;
          paramString = (com.tencent.mm.plugin.setting.model.g)paramn;
          if (paramString.yCP == null) {
            break label207;
          }
        }
        label202:
        label207:
        for (paramString = paramString.yCP.GEi;; paramString = Collections.emptyList())
        {
          localList.addAll(paramString);
          this.yHi.yHm = this.yHj;
          this.yHi.notifyDataSetChanged();
          dNI();
          AppMethodBeat.o(74202);
          return;
          paramString = null;
          break;
          paramInt1 = 0;
          break label120;
        }
      }
      if (paramn.getType() == 1127)
      {
        paramString = ((c)paramn).appId;
        if (!bt.isNullOrNil(paramString))
        {
          if (!this.yHj.isEmpty())
          {
            paramn = this.yHj.iterator();
            while (paramn.hasNext()) {
              if (((dtq)paramn.next()).duW.equals(paramString)) {
                paramn.remove();
              }
            }
          }
          this.yHi.notifyDataSetChanged();
        }
        AppMethodBeat.o(74202);
      }
    }
    else
    {
      h.cl(this, paramString);
    }
    AppMethodBeat.o(74202);
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
      AppMethodBeat.i(74192);
      if ((paramInt >= 0) && (paramInt < getCount()))
      {
        dtq localdtq = (dtq)this.yHm.get(paramInt);
        AppMethodBeat.o(74192);
        return localdtq;
      }
      AppMethodBeat.o(74192);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74191);
      if ((this.yHm != null) && (!this.yHm.isEmpty()))
      {
        int i = this.yHm.size();
        AppMethodBeat.o(74191);
        return i;
      }
      AppMethodBeat.o(74191);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(74193);
      View localView;
      if (paramView == null)
      {
        localView = SettingsManageAuthUI.this.getLayoutInflater().inflate(2131495388, null);
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
            AppMethodBeat.i(74190);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (SettingsManageAuthUI.a.this.Pf(paramInt) != null)
            {
              paramAnonymousView = new c(SettingsManageAuthUI.a.this.Pf(paramInt).duW, 1);
              if (SettingsManageAuthUI.f(SettingsManageAuthUI.this) != null) {
                SettingsManageAuthUI.f(SettingsManageAuthUI.this).dismiss();
              }
              com.tencent.mm.kernel.g.aiU().a(paramAnonymousView, 0);
              SettingsManageAuthUI.a(SettingsManageAuthUI.this, h.b(SettingsManageAuthUI.this, SettingsManageAuthUI.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(74189);
                  com.tencent.mm.kernel.g.aiU().a(paramAnonymousView);
                  AppMethodBeat.o(74189);
                }
              }));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74190);
          }
        });
        if (!SettingsManageAuthUI.c(SettingsManageAuthUI.this)) {
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
          paramViewGroup.yHr.setText(SettingsManageAuthUI.fz(Pf(paramInt).HGt));
        }
        AppMethodBeat.o(74193);
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
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI
 * JD-Core Version:    0.7.0.1
 */