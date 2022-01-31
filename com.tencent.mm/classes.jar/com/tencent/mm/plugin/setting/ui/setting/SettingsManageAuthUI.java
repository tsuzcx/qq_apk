package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SettingsManageAuthUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private View mHF;
  private ListView mListView;
  private ProgressDialog nVm;
  private byte[] qEE;
  private SettingsManageAuthUI.a qIC;
  private List<cpe> qID;
  private boolean qIE;
  
  public SettingsManageAuthUI()
  {
    AppMethodBeat.i(127258);
    this.qID = new ArrayList();
    AppMethodBeat.o(127258);
  }
  
  private static void bh(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127264);
    paramArrayOfByte = new com.tencent.mm.plugin.setting.model.f(paramArrayOfByte);
    g.Rc().a(paramArrayOfByte, 0);
    AppMethodBeat.o(127264);
  }
  
  private void ckl()
  {
    AppMethodBeat.i(127261);
    removeAllOptionMenu();
    addIconOptionMenu(800, 2131230757, new SettingsManageAuthUI.4(this));
    if (this.qID.isEmpty())
    {
      this.mHF.setVisibility(0);
      AppMethodBeat.o(127261);
      return;
    }
    this.mHF.setVisibility(8);
    if (this.qIE)
    {
      addTextOptionMenu(700, getString(2131296964), new SettingsManageAuthUI.5(this));
      AppMethodBeat.o(127261);
      return;
    }
    addTextOptionMenu(700, getString(2131296991), new SettingsManageAuthUI.6(this));
    AppMethodBeat.o(127261);
  }
  
  public int getLayoutId()
  {
    return 2130970694;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127260);
    this.mListView = ((ListView)findViewById(2131827618));
    this.mHF = findViewById(2131827619);
    this.qIC = new SettingsManageAuthUI.a(this, (byte)0);
    this.mListView.setAdapter(this.qIC);
    this.mListView.setOnScrollListener(new SettingsManageAuthUI.1(this));
    this.mListView.setOnItemClickListener(new SettingsManageAuthUI.2(this));
    ckl();
    setMMTitle(2131303207);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(127248);
        SettingsManageAuthUI.this.finish();
        AppMethodBeat.o(127248);
        return true;
      }
    });
    AppMethodBeat.o(127260);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127259);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127259);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127263);
    super.onPause();
    g.Rc().b(1146, this);
    g.Rc().b(1127, this);
    AppMethodBeat.o(127263);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127262);
    super.onResume();
    g.Rc().a(1146, this);
    g.Rc().a(1127, this);
    bh(null);
    AppMethodBeat.o(127262);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(127265);
    ab.i("MicroMsg.SettingsManageAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.nVm != null) {
      this.nVm.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 1146)
      {
        paramString = (com.tencent.mm.plugin.setting.model.f)paramm;
        label120:
        List localList;
        if ((paramString.qED != null) && (paramString.qED.xgr == 1))
        {
          paramString = paramString.qED.xgp.toByteArray();
          this.qEE = paramString;
          if (((com.tencent.mm.plugin.setting.model.f)paramm).qEE == null) {
            break label202;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            this.qID.clear();
          }
          localList = this.qID;
          paramString = (com.tencent.mm.plugin.setting.model.f)paramm;
          if (paramString.qED == null) {
            break label207;
          }
        }
        label202:
        label207:
        for (paramString = paramString.qED.xgq;; paramString = Collections.emptyList())
        {
          localList.addAll(paramString);
          this.qIC.qIG = this.qID;
          this.qIC.notifyDataSetChanged();
          ckl();
          AppMethodBeat.o(127265);
          return;
          paramString = null;
          break;
          paramInt1 = 0;
          break label120;
        }
      }
      if (paramm.getType() == 1127)
      {
        paramString = ((c)paramm).appId;
        if (!bo.isNullOrNil(paramString))
        {
          if (!this.qID.isEmpty())
          {
            paramm = this.qID.iterator();
            while (paramm.hasNext()) {
              if (((cpe)paramm.next()).cwc.equals(paramString)) {
                paramm.remove();
              }
            }
          }
          this.qIC.notifyDataSetChanged();
        }
        AppMethodBeat.o(127265);
      }
    }
    else
    {
      h.bO(this, paramString);
    }
    AppMethodBeat.o(127265);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageAuthUI
 * JD-Core Version:    0.7.0.1
 */