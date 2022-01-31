package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable.Creator;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.bv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.protocal.c.alp;
import com.tencent.mm.protocal.c.cby;
import com.tencent.mm.protocal.c.cbz;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SettingsManageAuthUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private ListView Nn;
  private ProgressDialog lxZ;
  private byte[] nQH;
  private View nUw;
  private SettingsManageAuthUI.a nUx;
  private List<cby> nUy = new ArrayList();
  private boolean nUz;
  
  private static void aJ(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new com.tencent.mm.plugin.setting.model.f(paramArrayOfByte);
    g.Dk().a(paramArrayOfByte, 0);
  }
  
  private void bzb()
  {
    this.mController.removeAllOptionMenu();
    addIconOptionMenu(800, a.h.actionbar_search_icon, new SettingsManageAuthUI.4(this));
    if (this.nUy.isEmpty())
    {
      this.nUw.setVisibility(0);
      return;
    }
    this.nUw.setVisibility(8);
    if (this.nUz)
    {
      addTextOptionMenu(700, getString(a.i.app_finish), new SettingsManageAuthUI.5(this));
      return;
    }
    addTextOptionMenu(700, getString(a.i.app_manage), new SettingsManageAuthUI.6(this));
  }
  
  protected final int getLayoutId()
  {
    return a.g.settings_manage_auth;
  }
  
  protected final void initView()
  {
    this.Nn = ((ListView)findViewById(a.f.auth_list_view));
    this.nUw = findViewById(a.f.auth_list_empty_tip);
    this.nUx = new SettingsManageAuthUI.a(this, (byte)0);
    this.Nn.setAdapter(this.nUx);
    this.Nn.setOnScrollListener(new SettingsManageAuthUI.1(this));
    this.Nn.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (!SettingsManageAuthUI.c(SettingsManageAuthUI.this))
        {
          paramAnonymousAdapterView = SettingsManageAuthUI.d(SettingsManageAuthUI.this).xd(paramAnonymousInt);
          if (paramAnonymousAdapterView != null)
          {
            paramAnonymousView = new Intent(SettingsManageAuthUI.this, SettingsModifyUserAuthUI.class);
            UserAuthItemParcelable[] arrayOfUserAuthItemParcelable = (UserAuthItemParcelable[])UserAuthItemParcelable.CREATOR.newArray(paramAnonymousAdapterView.tRc.size());
            paramAnonymousInt = 0;
            while (paramAnonymousInt < paramAnonymousAdapterView.tRc.size())
            {
              cbz localcbz = (cbz)paramAnonymousAdapterView.tRc.get(paramAnonymousInt);
              UserAuthItemParcelable localUserAuthItemParcelable = new UserAuthItemParcelable();
              localUserAuthItemParcelable.scope = localcbz.scope;
              localUserAuthItemParcelable.nRj = localcbz.nRj;
              localUserAuthItemParcelable.state = localcbz.state;
              localUserAuthItemParcelable.nRk = localcbz.nRk;
              arrayOfUserAuthItemParcelable[paramAnonymousInt] = localUserAuthItemParcelable;
              paramAnonymousInt += 1;
            }
            paramAnonymousView.putExtra("app_id", paramAnonymousAdapterView.bOL);
            paramAnonymousView.putExtra("app_name", paramAnonymousAdapterView.dRQ);
            paramAnonymousView.putExtra("modify_scene", 1);
            paramAnonymousView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(arrayOfUserAuthItemParcelable)));
            SettingsManageAuthUI.this.startActivity(paramAnonymousView);
          }
        }
      }
    });
    bzb();
    setMMTitle(a.i.settings_auth_manage);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        SettingsManageAuthUI.this.finish();
        return true;
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  protected void onPause()
  {
    super.onPause();
    g.Dk().b(1146, this);
    g.Dk().b(1127, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    g.Dk().a(1146, this);
    g.Dk().a(1127, this);
    aJ(null);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.lxZ != null) {
      this.lxZ.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 1146)
      {
        paramString = (com.tencent.mm.plugin.setting.model.f)paramm;
        if ((paramString.nQG != null) && (paramString.nQG.thD == 1))
        {
          paramString = paramString.nQG.thB.toByteArray();
          this.nQH = paramString;
          if (((com.tencent.mm.plugin.setting.model.f)paramm).nQH == null) {
            break label194;
          }
          paramInt1 = 1;
          label117:
          if (paramInt1 == 0) {
            this.nUy.clear();
          }
          List localList = this.nUy;
          paramString = (com.tencent.mm.plugin.setting.model.f)paramm;
          if (paramString.nQG == null) {
            break label199;
          }
          paramString = paramString.nQG.thC;
          label157:
          localList.addAll(paramString);
          this.nUx.nUB = this.nUy;
          this.nUx.notifyDataSetChanged();
          bzb();
        }
      }
      label194:
      label199:
      do
      {
        do
        {
          return;
          paramString = null;
          break;
          paramInt1 = 0;
          break label117;
          paramString = Collections.emptyList();
          break label157;
        } while (paramm.getType() != 1127);
        paramString = ((c)paramm).appId;
      } while (bk.bl(paramString));
      if (!this.nUy.isEmpty())
      {
        paramm = this.nUy.iterator();
        while (paramm.hasNext()) {
          if (((cby)paramm.next()).bOL.equals(paramString)) {
            paramm.remove();
          }
        }
      }
      this.nUx.notifyDataSetChanged();
      return;
    }
    h.bC(this, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI
 * JD-Core Version:    0.7.0.1
 */