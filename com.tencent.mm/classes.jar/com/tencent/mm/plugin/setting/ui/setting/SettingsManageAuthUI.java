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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.protocal.protobuf.bbt;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.protocal.protobuf.dil;
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
  implements com.tencent.mm.al.g
{
  private ListView mListView;
  private ProgressDialog qLE;
  private View reJ;
  private byte[] wcX;
  private a whj;
  private List<dik> whk;
  private boolean whl;
  
  public SettingsManageAuthUI()
  {
    AppMethodBeat.i(74195);
    this.whk = new ArrayList();
    AppMethodBeat.o(74195);
  }
  
  private static void bA(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(74201);
    paramArrayOfByte = new com.tencent.mm.plugin.setting.model.g(paramArrayOfByte);
    com.tencent.mm.kernel.g.aeS().a(paramArrayOfByte, 0);
    AppMethodBeat.o(74201);
  }
  
  private void dnX()
  {
    AppMethodBeat.i(74198);
    removeAllOptionMenu();
    addIconOptionMenu(800, 2131689510, new SettingsManageAuthUI.4(this));
    if (this.whk.isEmpty())
    {
      this.reJ.setVisibility(0);
      AppMethodBeat.o(74198);
      return;
    }
    this.reJ.setVisibility(8);
    if (this.whl)
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
    this.reJ = findViewById(2131296981);
    this.whj = new a((byte)0);
    this.mListView.setAdapter(this.whj);
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
            SettingsManageAuthUI.bB(SettingsManageAuthUI.a(SettingsManageAuthUI.this));
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
        if (!SettingsManageAuthUI.c(SettingsManageAuthUI.this))
        {
          paramAnonymousView = SettingsManageAuthUI.d(SettingsManageAuthUI.this).LC(paramAnonymousInt);
          if (paramAnonymousView != null)
          {
            paramAnonymousAdapterView = new Intent(SettingsManageAuthUI.this, SettingsModifyUserAuthUI.class);
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
            paramAnonymousAdapterView.putExtra("modify_scene", 1);
            paramAnonymousAdapterView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(arrayOfUserAuthItemParcelable)));
            paramAnonymousView = SettingsManageAuthUI.this;
            paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousAdapterView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageAuthUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(74184);
      }
    });
    dnX();
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
    com.tencent.mm.kernel.g.aeS().b(1146, this);
    com.tencent.mm.kernel.g.aeS().b(1127, this);
    AppMethodBeat.o(74200);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74199);
    super.onResume();
    com.tencent.mm.kernel.g.aeS().a(1146, this);
    com.tencent.mm.kernel.g.aeS().a(1127, this);
    bA(null);
    AppMethodBeat.o(74199);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74202);
    ad.i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.qLE != null) {
      this.qLE.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 1146)
      {
        paramString = (com.tencent.mm.plugin.setting.model.g)paramn;
        label120:
        List localList;
        if ((paramString.wcW != null) && (paramString.wcW.Dzq == 1))
        {
          paramString = paramString.wcW.Dzo.toByteArray();
          this.wcX = paramString;
          if (((com.tencent.mm.plugin.setting.model.g)paramn).wcX == null) {
            break label202;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            this.whk.clear();
          }
          localList = this.whk;
          paramString = (com.tencent.mm.plugin.setting.model.g)paramn;
          if (paramString.wcW == null) {
            break label207;
          }
        }
        label202:
        label207:
        for (paramString = paramString.wcW.Dzp;; paramString = Collections.emptyList())
        {
          localList.addAll(paramString);
          this.whj.whn = this.whk;
          this.whj.notifyDataSetChanged();
          dnX();
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
          if (!this.whk.isEmpty())
          {
            paramn = this.whk.iterator();
            while (paramn.hasNext()) {
              if (((dik)paramn.next()).dlB.equals(paramString)) {
                paramn.remove();
              }
            }
          }
          this.whj.notifyDataSetChanged();
        }
        AppMethodBeat.o(74202);
      }
    }
    else
    {
      h.cf(this, paramString);
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
    List<dik> whn;
    
    private a() {}
    
    public final dik LC(int paramInt)
    {
      AppMethodBeat.i(74192);
      if ((paramInt >= 0) && (paramInt < getCount()))
      {
        dik localdik = (dik)this.whn.get(paramInt);
        AppMethodBeat.o(74192);
        return localdik;
      }
      AppMethodBeat.o(74192);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(74191);
      if ((this.whn != null) && (!this.whn.isEmpty()))
      {
        int i = this.whn.size();
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
        paramViewGroup.lKe = ((TextView)localView.findViewById(2131304638));
        paramViewGroup.whr = ((TextView)localView.findViewById(2131304639));
        paramViewGroup.whs = ((TextView)localView.findViewById(2131304637));
        paramViewGroup.ipd = ((Button)localView.findViewById(2131304636));
        paramViewGroup.ipd.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(final View paramAnonymousView)
          {
            AppMethodBeat.i(74190);
            if (SettingsManageAuthUI.a.this.LC(paramInt) != null)
            {
              paramAnonymousView = new c(SettingsManageAuthUI.a.this.LC(paramInt).dlB, 1);
              if (SettingsManageAuthUI.f(SettingsManageAuthUI.this) != null) {
                SettingsManageAuthUI.f(SettingsManageAuthUI.this).dismiss();
              }
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousView, 0);
              SettingsManageAuthUI.a(SettingsManageAuthUI.this, h.b(SettingsManageAuthUI.this, SettingsManageAuthUI.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(74189);
                  com.tencent.mm.kernel.g.aeS().a(paramAnonymousView);
                  AppMethodBeat.o(74189);
                }
              }));
            }
            AppMethodBeat.o(74190);
          }
        });
        if (!SettingsManageAuthUI.c(SettingsManageAuthUI.this)) {
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
          paramViewGroup.whs.setText(SettingsManageAuthUI.fe(LC(paramInt).EyD));
        }
        AppMethodBeat.o(74193);
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
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI
 * JD-Core Version:    0.7.0.1
 */