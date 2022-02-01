package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.e;
import com.tencent.mm.protocal.protobuf.fun;
import com.tencent.mm.protocal.protobuf.fuo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SettingsManageAuthUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private ProgressDialog FPA;
  private View HoL;
  private byte[] PnI;
  private a Ptw;
  private List<fun> Ptx;
  private boolean Pty;
  private ListView mListView;
  
  public SettingsManageAuthUI()
  {
    AppMethodBeat.i(74195);
    this.Ptx = new ArrayList();
    AppMethodBeat.o(74195);
  }
  
  private static void cu(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(74201);
    paramArrayOfByte = new com.tencent.mm.plugin.setting.model.k(paramArrayOfByte);
    com.tencent.mm.kernel.h.aZW().a(paramArrayOfByte, 0);
    AppMethodBeat.o(74201);
  }
  
  private void gVK()
  {
    AppMethodBeat.i(74198);
    removeAllOptionMenu();
    if (this.Ptx.isEmpty())
    {
      this.HoL.setVisibility(0);
      AppMethodBeat.o(74198);
      return;
    }
    this.HoL.setVisibility(8);
    if (this.Pty)
    {
      addTextOptionMenu(700, getString(b.i.app_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74186);
          if (paramAnonymousMenuItem.getItemId() == 700)
          {
            SettingsManageAuthUI.a(SettingsManageAuthUI.this, false);
            SettingsManageAuthUI.d(SettingsManageAuthUI.this).notifyDataSetChanged();
            SettingsManageAuthUI.e(SettingsManageAuthUI.this);
          }
          AppMethodBeat.o(74186);
          return true;
        }
      });
      AppMethodBeat.o(74198);
      return;
    }
    addTextOptionMenu(700, getString(b.i.app_manage), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74187);
        if (paramAnonymousMenuItem.getItemId() == 700)
        {
          SettingsManageAuthUI.a(SettingsManageAuthUI.this, true);
          SettingsManageAuthUI.d(SettingsManageAuthUI.this).notifyDataSetChanged();
          SettingsManageAuthUI.e(SettingsManageAuthUI.this);
        }
        AppMethodBeat.o(74187);
        return true;
      }
    });
    AppMethodBeat.o(74198);
  }
  
  public int getLayoutId()
  {
    return b.g.settings_manage_auth;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74197);
    this.mListView = ((ListView)findViewById(b.f.auth_list_view));
    this.HoL = findViewById(b.f.auth_list_empty_tip);
    this.Ptw = new a((byte)0);
    this.mListView.setAdapter(this.Ptw);
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
            SettingsManageAuthUI.cv(SettingsManageAuthUI.a(SettingsManageAuthUI.this));
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
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousAdapterView);
        ((b)localObject).cH(paramAnonymousView);
        ((b)localObject).sc(paramAnonymousInt);
        ((b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
        if (!SettingsManageAuthUI.c(SettingsManageAuthUI.this))
        {
          paramAnonymousView = SettingsManageAuthUI.d(SettingsManageAuthUI.this).aiV(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            paramAnonymousAdapterView = new Intent(SettingsManageAuthUI.this, SettingsModifyUserAuthUI.class);
            localObject = (UserAuthItemParcelable[])UserAuthItemParcelable.CREATOR.newArray(paramAnonymousView.abSJ.size());
            paramAnonymousInt = 0;
            while (paramAnonymousInt < paramAnonymousView.abSJ.size())
            {
              fuo localfuo = (fuo)paramAnonymousView.abSJ.get(paramAnonymousInt);
              UserAuthItemParcelable localUserAuthItemParcelable = new UserAuthItemParcelable();
              localUserAuthItemParcelable.scope = localfuo.scope;
              localUserAuthItemParcelable.Poo = localfuo.Poo;
              localUserAuthItemParcelable.state = localfuo.state;
              localUserAuthItemParcelable.Pop = localfuo.Pop;
              localObject[paramAnonymousInt] = localUserAuthItemParcelable;
              paramAnonymousInt += 1;
            }
            paramAnonymousAdapterView.putExtra("app_id", paramAnonymousView.appid);
            paramAnonymousAdapterView.putExtra("app_name", paramAnonymousView.nSt);
            paramAnonymousAdapterView.putExtra("modify_scene", 1);
            paramAnonymousAdapterView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList((Object[])localObject)));
            paramAnonymousView = SettingsManageAuthUI.this;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(74184);
      }
    });
    gVK();
    setMMTitle(b.i.settings_auth_manage);
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
    com.tencent.mm.kernel.h.aZW().b(1146, this);
    com.tencent.mm.kernel.h.aZW().b(1127, this);
    AppMethodBeat.o(74200);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74199);
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(1146, this);
    com.tencent.mm.kernel.h.aZW().a(1127, this);
    cu(null);
    AppMethodBeat.o(74199);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(74202);
    Log.i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.FPA != null) {
      this.FPA.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp.getType() == 1146)
      {
        this.PnI = ((com.tencent.mm.plugin.setting.model.k)paramp).gUW();
        if (!((com.tencent.mm.plugin.setting.model.k)paramp).gUX()) {
          this.Ptx.clear();
        }
        this.Ptx.addAll(((com.tencent.mm.plugin.setting.model.k)paramp).gUV());
        this.Ptw.PtA = this.Ptx;
        this.Ptw.notifyDataSetChanged();
        gVK();
        AppMethodBeat.o(74202);
        return;
      }
      if (paramp.getType() == 1127)
      {
        paramString = ((e)paramp).appId;
        if (!Util.isNullOrNil(paramString))
        {
          if (!this.Ptx.isEmpty())
          {
            paramp = this.Ptx.iterator();
            while (paramp.hasNext()) {
              if (((fun)paramp.next()).appid.equals(paramString)) {
                paramp.remove();
              }
            }
          }
          this.Ptw.notifyDataSetChanged();
        }
        AppMethodBeat.o(74202);
      }
    }
    else
    {
      com.tencent.mm.ui.base.k.cZ(this, paramString);
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
    List<fun> PtA;
    
    private a() {}
    
    public final fun aiV(int paramInt)
    {
      AppMethodBeat.i(74192);
      if ((paramInt >= 0) && (paramInt < getCount()))
      {
        fun localfun = (fun)this.PtA.get(paramInt);
        AppMethodBeat.o(74192);
        return localfun;
      }
      AppMethodBeat.o(74192);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74191);
      if ((this.PtA != null) && (!this.PtA.isEmpty()))
      {
        int i = this.PtA.size();
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
        localView = SettingsManageAuthUI.this.getLayoutInflater().inflate(b.g.settings_auth_list_item, null);
        paramView = new a((byte)0);
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.uov = ((TextView)localView.findViewById(b.f.settings_auth_item_name));
        paramViewGroup.PtE = ((TextView)localView.findViewById(b.f.settings_auth_item_type));
        paramViewGroup.PtF = ((TextView)localView.findViewById(b.f.settings_auth_item_auth_list));
        paramViewGroup.pYm = ((Button)localView.findViewById(b.f.settings_auth_del_btn));
        paramViewGroup.pYm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(74190);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (SettingsManageAuthUI.a.this.aiV(paramInt) != null)
            {
              paramAnonymousView = new e(SettingsManageAuthUI.a.this.aiV(paramInt).appid, 1);
              if (SettingsManageAuthUI.f(SettingsManageAuthUI.this) != null) {
                SettingsManageAuthUI.f(SettingsManageAuthUI.this).dismiss();
              }
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousView, 0);
              SettingsManageAuthUI.a(SettingsManageAuthUI.this, com.tencent.mm.ui.base.k.a(SettingsManageAuthUI.this, SettingsManageAuthUI.this.getString(b.i.app_sending), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(74189);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousView);
                  AppMethodBeat.o(74189);
                }
              }));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$AuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74190);
          }
        });
        if (!SettingsManageAuthUI.c(SettingsManageAuthUI.this)) {
          break label215;
        }
        paramViewGroup.pYm.setVisibility(0);
      }
      for (;;)
      {
        if (aiV(paramInt) != null)
        {
          paramViewGroup.uov.setText(aiV(paramInt).nSt);
          paramViewGroup.PtE.setText(aiV(paramInt).abSK);
          paramViewGroup.PtF.setText(SettingsManageAuthUI.kp(aiV(paramInt).abSJ));
        }
        AppMethodBeat.o(74193);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label215:
        paramViewGroup.pYm.setVisibility(8);
      }
    }
    
    final class a
    {
      TextView PtE;
      TextView PtF;
      Button pYm;
      TextView uov;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI
 * JD-Core Version:    0.7.0.1
 */