package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r.a;

public class SnsTagPartlyUI
  extends MMActivity
  implements f
{
  private ListView fry;
  private SnsTagPartlyUI.a pdS;
  private View.OnClickListener pdT = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if (SnsTagPartlyUI.a(SnsTagPartlyUI.this) == null)
      {
        y.e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
        return;
      }
      paramAnonymousView = paramAnonymousView.getTag();
      if (paramAnonymousView == null)
      {
        y.e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
        return;
      }
      if (!(paramAnonymousView instanceof Integer))
      {
        y.e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
        return;
      }
      paramAnonymousView = (t)SnsTagPartlyUI.a(SnsTagPartlyUI.this).getItem(((Integer)paramAnonymousView).intValue());
      SnsTagPartlyUI.this.tipDialog = h.b(SnsTagPartlyUI.this, null, true, new SnsTagPartlyUI.5.1(this));
      g.DQ();
      g.DO().dJT.a(new x(paramAnonymousView.field_tagId, paramAnonymousView.field_tagName), 0);
    }
  };
  protected com.tencent.mm.ui.base.p tipDialog = null;
  
  protected final int getLayoutId()
  {
    return i.g.sns_tag_partly_ui2;
  }
  
  protected final void initView()
  {
    setMMTitle(i.j.settings_privacy_edit_sns_group);
    setBackBtn(new SnsTagPartlyUI.1(this));
    this.fry = ((ListView)findViewById(i.f.sns_tag_list));
    this.fry.setOnItemClickListener(new SnsTagPartlyUI.2(this));
    this.pdS = new SnsTagPartlyUI.a(this, this);
    View localView = View.inflate(this, i.g.sns_tag_partly_footer, null);
    this.fry.addFooterView(localView);
    this.fry.setAdapter(this.pdS);
    addTextOptionMenu(0, getString(i.j.sns_tag_partly_edit), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuItem = SnsTagPartlyUI.a(SnsTagPartlyUI.this);
        boolean bool;
        SnsTagPartlyUI localSnsTagPartlyUI;
        if (!SnsTagPartlyUI.a(SnsTagPartlyUI.this).pdW)
        {
          bool = true;
          paramAnonymousMenuItem.pdW = bool;
          localSnsTagPartlyUI = SnsTagPartlyUI.this;
          if (!SnsTagPartlyUI.a(SnsTagPartlyUI.this).pdW) {
            break label80;
          }
        }
        label80:
        for (paramAnonymousMenuItem = SnsTagPartlyUI.this.getString(i.j.app_finish);; paramAnonymousMenuItem = SnsTagPartlyUI.this.getString(i.j.sns_tag_partly_edit))
        {
          localSnsTagPartlyUI.updateOptionMenuText(0, paramAnonymousMenuItem);
          SnsTagPartlyUI.a(SnsTagPartlyUI.this).notifyDataSetChanged();
          return true;
          bool = false;
          break;
        }
      }
    });
    this.pdS.uMi = new r.a()
    {
      public final void Wp()
      {
        boolean bool = true;
        SnsTagPartlyUI localSnsTagPartlyUI = SnsTagPartlyUI.this;
        if (SnsTagPartlyUI.a(SnsTagPartlyUI.this).getCount() > 1) {}
        for (;;)
        {
          localSnsTagPartlyUI.enableOptionMenu(bool);
          return;
          bool = false;
        }
      }
    };
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    String str;
    do
    {
      do
      {
        return;
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while (paramIntent == null);
      str = paramIntent.getStringExtra("Select_Contact");
      paramIntent = paramIntent.getStringExtra("Select_room_name");
    } while (str == null);
    Intent localIntent = new Intent();
    localIntent.putExtra("k_sns_tag_id", 0);
    localIntent.putExtra("k_sns_tag_name", bk.aM(paramIntent, ""));
    localIntent.putExtra("k_sns_tag_list", str);
    localIntent.setClass(this, SnsTagDetailUI.class);
    startActivity(localIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g.DQ();
    g.DO().dJT.a(292, this);
    g.DQ();
    g.DO().dJT.a(290, this);
    initView();
  }
  
  public void onDestroy()
  {
    g.DQ();
    g.DO().dJT.b(292, this);
    g.DQ();
    g.DO().dJT.b(290, this);
    if (this.pdS != null) {
      this.pdS.bcS();
    }
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.pdS != null) {
      this.pdS.a("", null);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.pdS != null) {
      this.pdS.a("", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI
 * JD-Core Version:    0.7.0.1
 */