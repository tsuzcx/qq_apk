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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
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
  private ProgressDialog sMH;
  private View tuW;
  private byte[] ySV;
  private a yXs;
  private List<dun> yXt;
  private boolean yXu;
  
  public SettingsManageAuthUI()
  {
    AppMethodBeat.i(74195);
    this.yXt = new ArrayList();
    AppMethodBeat.o(74195);
  }
  
  private static void bJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(74201);
    paramArrayOfByte = new com.tencent.mm.plugin.setting.model.h(paramArrayOfByte);
    g.ajj().a(paramArrayOfByte, 0);
    AppMethodBeat.o(74201);
  }
  
  private void dRf()
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
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kj(SettingsManageAuthUI.this);
        AppMethodBeat.o(74186);
        return true;
      }
    });
    if (this.yXt.isEmpty())
    {
      this.tuW.setVisibility(0);
      AppMethodBeat.o(74198);
      return;
    }
    this.tuW.setVisibility(8);
    if (this.yXu)
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
    this.tuW = findViewById(2131296981);
    this.yXs = new a((byte)0);
    this.mListView.setAdapter(this.yXs);
    this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(74183);
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          ae.i("MicroMsg.SettingsManageAuthUI", "scroll to the end");
          if (SettingsManageAuthUI.a(SettingsManageAuthUI.this) != null)
          {
            SettingsManageAuthUI.bK(SettingsManageAuthUI.a(SettingsManageAuthUI.this));
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (!SettingsManageAuthUI.c(SettingsManageAuthUI.this))
        {
          paramAnonymousView = SettingsManageAuthUI.d(SettingsManageAuthUI.this).PM(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            paramAnonymousAdapterView = new Intent(SettingsManageAuthUI.this, SettingsModifyUserAuthUI.class);
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
            paramAnonymousAdapterView.putExtra("modify_scene", 1);
            paramAnonymousAdapterView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList((Object[])localObject)));
            paramAnonymousView = SettingsManageAuthUI.this;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(74184);
      }
    });
    dRf();
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
    g.ajj().b(1146, this);
    g.ajj().b(1127, this);
    AppMethodBeat.o(74200);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74199);
    super.onResume();
    g.ajj().a(1146, this);
    g.ajj().a(1127, this);
    bJ(null);
    AppMethodBeat.o(74199);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74202);
    ae.i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.sMH != null) {
      this.sMH.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 1146)
      {
        paramString = (com.tencent.mm.plugin.setting.model.h)paramn;
        label120:
        List localList;
        if ((paramString.ySU != null) && (paramString.ySU.GXM == 1))
        {
          paramString = paramString.ySU.GXK.toByteArray();
          this.ySV = paramString;
          if (((com.tencent.mm.plugin.setting.model.h)paramn).ySV == null) {
            break label202;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            this.yXt.clear();
          }
          localList = this.yXt;
          paramString = (com.tencent.mm.plugin.setting.model.h)paramn;
          if (paramString.ySU == null) {
            break label207;
          }
        }
        label202:
        label207:
        for (paramString = paramString.ySU.GXL;; paramString = Collections.emptyList())
        {
          localList.addAll(paramString);
          this.yXs.yXw = this.yXt;
          this.yXs.notifyDataSetChanged();
          dRf();
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
        paramString = ((d)paramn).appId;
        if (!bu.isNullOrNil(paramString))
        {
          if (!this.yXt.isEmpty())
          {
            paramn = this.yXt.iterator();
            while (paramn.hasNext()) {
              if (((dun)paramn.next()).dwb.equals(paramString)) {
                paramn.remove();
              }
            }
          }
          this.yXs.notifyDataSetChanged();
        }
        AppMethodBeat.o(74202);
      }
    }
    else
    {
      com.tencent.mm.ui.base.h.cm(this, paramString);
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
    List<dun> yXw;
    
    private a() {}
    
    public final dun PM(int paramInt)
    {
      AppMethodBeat.i(74192);
      if ((paramInt >= 0) && (paramInt < getCount()))
      {
        dun localdun = (dun)this.yXw.get(paramInt);
        AppMethodBeat.o(74192);
        return localdun;
      }
      AppMethodBeat.o(74192);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74191);
      if ((this.yXw != null) && (!this.yXw.isEmpty()))
      {
        int i = this.yXw.size();
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
        paramViewGroup.mRG = ((TextView)localView.findViewById(2131304638));
        paramViewGroup.yXA = ((TextView)localView.findViewById(2131304639));
        paramViewGroup.yXB = ((TextView)localView.findViewById(2131304637));
        paramViewGroup.jll = ((Button)localView.findViewById(2131304636));
        paramViewGroup.jll.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(74190);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (SettingsManageAuthUI.a.this.PM(paramInt) != null)
            {
              paramAnonymousView = new d(SettingsManageAuthUI.a.this.PM(paramInt).dwb, 1);
              if (SettingsManageAuthUI.f(SettingsManageAuthUI.this) != null) {
                SettingsManageAuthUI.f(SettingsManageAuthUI.this).dismiss();
              }
              g.ajj().a(paramAnonymousView, 0);
              SettingsManageAuthUI.a(SettingsManageAuthUI.this, com.tencent.mm.ui.base.h.b(SettingsManageAuthUI.this, SettingsManageAuthUI.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(74189);
                  g.ajj().a(paramAnonymousView);
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
        paramViewGroup.jll.setVisibility(0);
      }
      for (;;)
      {
        if (PM(paramInt) != null)
        {
          paramViewGroup.mRG.setText(PM(paramInt).hDU);
          paramViewGroup.yXA.setText(PM(paramInt).Iah);
          paramViewGroup.yXB.setText(SettingsManageAuthUI.fH(PM(paramInt).Iag));
        }
        AppMethodBeat.o(74193);
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
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI
 * JD-Core Version:    0.7.0.1
 */