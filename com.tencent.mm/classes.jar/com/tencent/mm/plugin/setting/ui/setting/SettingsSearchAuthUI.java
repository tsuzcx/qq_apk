package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable.Creator;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.plugin.setting.model.i;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.cpf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
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
  private ProgressDialog nVm;
  private byte[] qEE;
  private boolean qIE;
  private com.tencent.mm.plugin.fts.ui.widget.a qJQ;
  private View qJR;
  private TextView qJS;
  private TextView qJT;
  private List<cpe> qJU;
  private SettingsSearchAuthUI.a qJV;
  
  public SettingsSearchAuthUI()
  {
    AppMethodBeat.i(127456);
    this.qJU = new ArrayList();
    AppMethodBeat.o(127456);
  }
  
  private void ckl()
  {
    AppMethodBeat.i(127461);
    removeAllOptionMenu();
    if (!this.qJU.isEmpty())
    {
      if (this.qIE)
      {
        addTextOptionMenu(700, getString(2131296964), new SettingsSearchAuthUI.6(this));
        AppMethodBeat.o(127461);
        return;
      }
      addTextOptionMenu(700, getString(2131296991), new SettingsSearchAuthUI.7(this));
    }
    AppMethodBeat.o(127461);
  }
  
  public void finish()
  {
    AppMethodBeat.i(127462);
    super.finish();
    overridePendingTransition(2131034222, 2131034130);
    AppMethodBeat.o(127462);
  }
  
  public int getLayoutId()
  {
    return 2130970700;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127458);
    this.qJQ = new com.tencent.mm.plugin.fts.ui.widget.a(this);
    this.mListView = ((ListView)findViewById(2131827618));
    this.qJV = new SettingsSearchAuthUI.a(this, (byte)0);
    this.mListView.setAdapter(this.qJV);
    this.qJR = findViewById(2131827638);
    this.qJS = ((TextView)findViewById(2131827639));
    this.qJT = ((TextView)findViewById(2131827640));
    ckl();
    getSupportActionBar().setCustomView(this.qJQ);
    this.qJQ.setSearchViewListener(new SettingsSearchAuthUI.1(this));
    this.qJQ.getFtsEditText().setFtsEditTextListener(new SettingsSearchAuthUI.2(this));
    this.qJS.setOnClickListener(new SettingsSearchAuthUI.3(this));
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(127444);
        if (!SettingsSearchAuthUI.f(SettingsSearchAuthUI.this))
        {
          paramAnonymousAdapterView = SettingsSearchAuthUI.g(SettingsSearchAuthUI.this).Db(paramAnonymousInt);
          if (paramAnonymousAdapterView != null)
          {
            paramAnonymousView = new Intent(SettingsSearchAuthUI.this, SettingsModifyUserAuthUI.class);
            UserAuthItemParcelable[] arrayOfUserAuthItemParcelable = (UserAuthItemParcelable[])UserAuthItemParcelable.CREATOR.newArray(paramAnonymousAdapterView.xXW.size());
            paramAnonymousInt = 0;
            while (paramAnonymousInt < paramAnonymousAdapterView.xXW.size())
            {
              cpf localcpf = (cpf)paramAnonymousAdapterView.xXW.get(paramAnonymousInt);
              UserAuthItemParcelable localUserAuthItemParcelable = new UserAuthItemParcelable();
              localUserAuthItemParcelable.scope = localcpf.scope;
              localUserAuthItemParcelable.qFg = localcpf.qFg;
              localUserAuthItemParcelable.state = localcpf.state;
              localUserAuthItemParcelable.qFh = localcpf.qFh;
              arrayOfUserAuthItemParcelable[paramAnonymousInt] = localUserAuthItemParcelable;
              paramAnonymousInt += 1;
            }
            paramAnonymousView.putExtra("app_id", paramAnonymousAdapterView.cwc);
            paramAnonymousView.putExtra("app_name", paramAnonymousAdapterView.fhP);
            paramAnonymousView.putExtra("modify_scene", 2);
            paramAnonymousView.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(arrayOfUserAuthItemParcelable)));
            SettingsSearchAuthUI.this.startActivity(paramAnonymousView);
          }
        }
        AppMethodBeat.o(127444);
      }
    });
    this.mListView.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(127445);
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          ab.i("MicroMsg.SettingsSearchAuthUI", "scroll to the end");
          if (SettingsSearchAuthUI.h(SettingsSearchAuthUI.this) != null)
          {
            SettingsSearchAuthUI.a(SettingsSearchAuthUI.this, SettingsSearchAuthUI.h(SettingsSearchAuthUI.this));
            SettingsSearchAuthUI.i(SettingsSearchAuthUI.this);
          }
        }
        AppMethodBeat.o(127445);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(127458);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127457);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127457);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127460);
    super.onPause();
    g.Rc().b(1169, this);
    g.Rc().b(1127, this);
    AppMethodBeat.o(127460);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127459);
    super.onResume();
    g.Rc().a(1169, this);
    g.Rc().a(1127, this);
    AppMethodBeat.o(127459);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(127463);
    ab.i("MicroMsg.SettingsSearchAuthUI", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.nVm != null) {
      this.nVm.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 1169)
      {
        paramString = (i)paramm;
        label123:
        List localList;
        if ((paramString.qEH != null) && (paramString.qEH.xgr == 1))
        {
          paramString = paramString.qEH.xgp.toByteArray();
          this.qEE = paramString;
          if (((i)paramm).qEE == null) {
            break label235;
          }
          paramInt1 = 1;
          if (paramInt1 == 0) {
            this.qJU.clear();
          }
          localList = this.qJU;
          paramString = (i)paramm;
          if (paramString.qEH == null) {
            break label240;
          }
        }
        label235:
        label240:
        for (paramString = paramString.qEH.xgq;; paramString = Collections.emptyList())
        {
          localList.addAll(paramString);
          if (this.qJU.isEmpty()) {
            break label247;
          }
          this.qJV.qIG = this.qJU;
          this.qJV.notifyDataSetChanged();
          this.qJR.setVisibility(8);
          this.mListView.setVisibility(0);
          ckl();
          AppMethodBeat.o(127463);
          return;
          paramString = null;
          break;
          paramInt1 = 0;
          break label123;
        }
        label247:
        this.qJR.setVisibility(0);
        this.qJS.setVisibility(8);
        this.qJT.setVisibility(0);
        this.mListView.setVisibility(8);
        this.qJU.clear();
        ckl();
        AppMethodBeat.o(127463);
        return;
      }
      if (paramm.getType() == 1127)
      {
        paramString = ((c)paramm).appId;
        if (!bo.isNullOrNil(paramString))
        {
          if (!this.qJU.isEmpty())
          {
            paramm = this.qJU.iterator();
            while (paramm.hasNext()) {
              if (((cpe)paramm.next()).cwc.equals(paramString)) {
                paramm.remove();
              }
            }
          }
          this.qJV.notifyDataSetChanged();
        }
        AppMethodBeat.o(127463);
      }
    }
    else
    {
      h.bO(this, paramString);
    }
    AppMethodBeat.o(127463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI
 * JD-Core Version:    0.7.0.1
 */