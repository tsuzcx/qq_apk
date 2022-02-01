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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.eom;
import com.tencent.mm.protocal.protobuf.eon;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  implements com.tencent.mm.ak.i
{
  private byte[] CXN;
  private a Dcj;
  private List<eom> Dck;
  private boolean Dcl;
  private ListView mListView;
  private ProgressDialog vIA;
  private View wMd;
  
  public SettingsManageAuthUI()
  {
    AppMethodBeat.i(74195);
    this.Dck = new ArrayList();
    AppMethodBeat.o(74195);
  }
  
  private static void cb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(74201);
    paramArrayOfByte = new com.tencent.mm.plugin.setting.model.i(paramArrayOfByte);
    g.azz().a(paramArrayOfByte, 0);
    AppMethodBeat.o(74201);
  }
  
  private void eTg()
  {
    AppMethodBeat.i(74198);
    removeAllOptionMenu();
    addIconOptionMenu(800, 2131689512, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74186);
        Object localObject = new Intent(SettingsManageAuthUI.this, SettingsSearchAuthUI.class);
        paramAnonymousMenuItem = SettingsManageAuthUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kb(SettingsManageAuthUI.this);
        AppMethodBeat.o(74186);
        return true;
      }
    });
    if (this.Dck.isEmpty())
    {
      this.wMd.setVisibility(0);
      AppMethodBeat.o(74198);
      return;
    }
    this.wMd.setVisibility(8);
    if (this.Dcl)
    {
      addTextOptionMenu(700, getString(2131755858), new MenuItem.OnMenuItemClickListener()
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
    addTextOptionMenu(700, getString(2131755890), new MenuItem.OnMenuItemClickListener()
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
    return 2131496256;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74197);
    this.mListView = ((ListView)findViewById(2131297100));
    this.wMd = findViewById(2131297099);
    this.Dcj = new a((byte)0);
    this.mListView.setAdapter(this.Dcj);
    this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(74183);
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          Log.i("MicroMsg.SettingsManageAuthUI", "scroll to the end");
          if (SettingsManageAuthUI.a(SettingsManageAuthUI.this) != null)
          {
            SettingsManageAuthUI.cc(SettingsManageAuthUI.a(SettingsManageAuthUI.this));
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (!SettingsManageAuthUI.c(SettingsManageAuthUI.this))
        {
          paramAnonymousView = SettingsManageAuthUI.d(SettingsManageAuthUI.this).Xp(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            paramAnonymousAdapterView = new Intent(SettingsManageAuthUI.this, SettingsModifyUserAuthUI.class);
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
            paramAnonymousAdapterView.putExtra("modify_scene", 1);
            paramAnonymousAdapterView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList((Object[])localObject)));
            paramAnonymousView = SettingsManageAuthUI.this;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(74184);
      }
    });
    eTg();
    setMMTitle(2131765343);
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
    g.azz().b(1146, this);
    g.azz().b(1127, this);
    AppMethodBeat.o(74200);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74199);
    super.onResume();
    g.azz().a(1146, this);
    g.azz().a(1127, this);
    cb(null);
    AppMethodBeat.o(74199);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74202);
    Log.i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.vIA != null) {
      this.vIA.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() == 1146)
      {
        paramString = (com.tencent.mm.plugin.setting.model.i)paramq;
        label120:
        List localList;
        if ((paramString.CXM != null) && (paramString.CXM.McB == 1))
        {
          paramString = paramString.CXM.Mcz.toByteArray();
          this.CXN = paramString;
          if (((com.tencent.mm.plugin.setting.model.i)paramq).CXN == null) {
            break label202;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            this.Dck.clear();
          }
          localList = this.Dck;
          paramString = (com.tencent.mm.plugin.setting.model.i)paramq;
          if (paramString.CXM == null) {
            break label207;
          }
        }
        label202:
        label207:
        for (paramString = paramString.CXM.McA;; paramString = Collections.emptyList())
        {
          localList.addAll(paramString);
          this.Dcj.Dcn = this.Dck;
          this.Dcj.notifyDataSetChanged();
          eTg();
          AppMethodBeat.o(74202);
          return;
          paramString = null;
          break;
          paramInt1 = 0;
          break label120;
        }
      }
      if (paramq.getType() == 1127)
      {
        paramString = ((d)paramq).appId;
        if (!Util.isNullOrNil(paramString))
        {
          if (!this.Dck.isEmpty())
          {
            paramq = this.Dck.iterator();
            while (paramq.hasNext()) {
              if (((eom)paramq.next()).dNI.equals(paramString)) {
                paramq.remove();
              }
            }
          }
          this.Dcj.notifyDataSetChanged();
        }
        AppMethodBeat.o(74202);
      }
    }
    else
    {
      h.cD(this, paramString);
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
    List<eom> Dcn;
    
    private a() {}
    
    public final eom Xp(int paramInt)
    {
      AppMethodBeat.i(74192);
      if ((paramInt >= 0) && (paramInt < getCount()))
      {
        eom localeom = (eom)this.Dcn.get(paramInt);
        AppMethodBeat.o(74192);
        return localeom;
      }
      AppMethodBeat.o(74192);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74191);
      if ((this.Dcn != null) && (!this.Dcn.isEmpty()))
      {
        int i = this.Dcn.size();
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
        localView = SettingsManageAuthUI.this.getLayoutInflater().inflate(2131496249, null);
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
            AppMethodBeat.i(74190);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (SettingsManageAuthUI.a.this.Xp(paramInt) != null)
            {
              paramAnonymousView = new d(SettingsManageAuthUI.a.this.Xp(paramInt).dNI, 1);
              if (SettingsManageAuthUI.f(SettingsManageAuthUI.this) != null) {
                SettingsManageAuthUI.f(SettingsManageAuthUI.this).dismiss();
              }
              g.azz().a(paramAnonymousView, 0);
              SettingsManageAuthUI.a(SettingsManageAuthUI.this, h.a(SettingsManageAuthUI.this, SettingsManageAuthUI.this.getString(2131755978), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(74189);
                  g.azz().a(paramAnonymousView);
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
        paramViewGroup.kjo.setVisibility(0);
      }
      for (;;)
      {
        if (Xp(paramInt) != null)
        {
          paramViewGroup.oeJ.setText(Xp(paramInt).ixZ);
          paramViewGroup.Dcr.setText(Xp(paramInt).Nmo);
          paramViewGroup.Dcs.setText(SettingsManageAuthUI.gG(Xp(paramInt).Nmn));
        }
        AppMethodBeat.o(74193);
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
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI
 * JD-Core Version:    0.7.0.1
 */