package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p.a;

public class SnsTagPartlyUI
  extends MMActivity
  implements f
{
  private ListView gJa;
  private SnsTagPartlyUI.a rWF;
  private View.OnClickListener rWG;
  protected com.tencent.mm.ui.base.p tipDialog;
  
  public SnsTagPartlyUI()
  {
    AppMethodBeat.i(39386);
    this.tipDialog = null;
    this.rWG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39380);
        if (SnsTagPartlyUI.a(SnsTagPartlyUI.this) == null)
        {
          ab.e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
          AppMethodBeat.o(39380);
          return;
        }
        paramAnonymousView = paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          ab.e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
          AppMethodBeat.o(39380);
          return;
        }
        if (!(paramAnonymousView instanceof Integer))
        {
          ab.e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
          AppMethodBeat.o(39380);
          return;
        }
        paramAnonymousView = (t)SnsTagPartlyUI.a(SnsTagPartlyUI.this).getItem(((Integer)paramAnonymousView).intValue());
        SnsTagPartlyUI.this.tipDialog = h.b(SnsTagPartlyUI.this, null, true, new SnsTagPartlyUI.5.1(this));
        g.RM();
        g.RK().eHt.a(new x(paramAnonymousView.field_tagId, paramAnonymousView.field_tagName), 0);
        AppMethodBeat.o(39380);
      }
    };
    AppMethodBeat.o(39386);
  }
  
  public int getLayoutId()
  {
    return 2130970874;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39390);
    setMMTitle(2131303389);
    setBackBtn(new SnsTagPartlyUI.1(this));
    this.gJa = ((ListView)findViewById(2131828101));
    this.gJa.setOnItemClickListener(new SnsTagPartlyUI.2(this));
    this.rWF = new SnsTagPartlyUI.a(this, this);
    View localView = View.inflate(this, 2130970873, null);
    this.gJa.addFooterView(localView);
    this.gJa.setAdapter(this.rWF);
    addTextOptionMenu(0, getString(2131303990), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39378);
        paramAnonymousMenuItem = SnsTagPartlyUI.a(SnsTagPartlyUI.this);
        boolean bool;
        SnsTagPartlyUI localSnsTagPartlyUI;
        if (!SnsTagPartlyUI.a(SnsTagPartlyUI.this).rWJ)
        {
          bool = true;
          paramAnonymousMenuItem.rWJ = bool;
          localSnsTagPartlyUI = SnsTagPartlyUI.this;
          if (!SnsTagPartlyUI.a(SnsTagPartlyUI.this).rWJ) {
            break label89;
          }
        }
        label89:
        for (paramAnonymousMenuItem = SnsTagPartlyUI.this.getString(2131296964);; paramAnonymousMenuItem = SnsTagPartlyUI.this.getString(2131303990))
        {
          localSnsTagPartlyUI.updateOptionMenuText(0, paramAnonymousMenuItem);
          SnsTagPartlyUI.a(SnsTagPartlyUI.this).notifyDataSetChanged();
          AppMethodBeat.o(39378);
          return true;
          bool = false;
          break;
        }
      }
    });
    this.rWF.a(new p.a()
    {
      public final void apT()
      {
        boolean bool = true;
        AppMethodBeat.i(39379);
        SnsTagPartlyUI localSnsTagPartlyUI = SnsTagPartlyUI.this;
        if (SnsTagPartlyUI.a(SnsTagPartlyUI.this).getCount() > 1) {}
        for (;;)
        {
          localSnsTagPartlyUI.enableOptionMenu(bool);
          AppMethodBeat.o(39379);
          return;
          bool = false;
        }
      }
    });
    AppMethodBeat.o(39390);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39391);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(39391);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39391);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(39391);
        return;
      }
      String str = paramIntent.getStringExtra("Select_Contact");
      paramIntent = paramIntent.getStringExtra("Select_room_name");
      if (str == null)
      {
        AppMethodBeat.o(39391);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("k_sns_tag_id", 0);
      localIntent.putExtra("k_sns_tag_name", bo.bf(paramIntent, ""));
      localIntent.putExtra("k_sns_tag_list", str);
      localIntent.setClass(this, SnsTagDetailUI.class);
      startActivity(localIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39387);
    super.onCreate(paramBundle);
    g.RM();
    g.RK().eHt.a(292, this);
    g.RM();
    g.RK().eHt.a(290, this);
    initView();
    AppMethodBeat.o(39387);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39388);
    g.RM();
    g.RK().eHt.b(292, this);
    g.RM();
    g.RK().eHt.b(290, this);
    if (this.rWF != null) {
      this.rWF.bKb();
    }
    super.onDestroy();
    AppMethodBeat.o(39388);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39389);
    super.onResume();
    if (this.rWF != null) {
      this.rWF.a("", null);
    }
    AppMethodBeat.o(39389);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(39392);
    ab.i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.rWF != null) {
      this.rWF.a("", null);
    }
    AppMethodBeat.o(39392);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI
 * JD-Core Version:    0.7.0.1
 */