package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bzc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e.g;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsTrustFriendUI
  extends MMActivity
  implements f
{
  private static int nWo = 5;
  private com.tencent.mm.ui.base.p jLo;
  private GridView kHX;
  private TextView leV;
  private boolean nUz;
  private List<String> nWl;
  private SettingsTrustFriendUI.a nWm;
  private View nWn;
  
  private void bzs()
  {
    String str = (String)g.DP().Dz().get(352277, null);
    ArrayList localArrayList = new ArrayList();
    if (!bk.bl(str)) {
      localArrayList = bk.G(str.split(","));
    }
    for (;;)
    {
      if ((this.nWl.size() == localArrayList.size()) && (this.nWl.containsAll(localArrayList)))
      {
        finish();
        return;
      }
      h.a(this, getString(a.i.save_label_msg), getString(a.i.app_tip), getString(a.i.app_save), getString(a.i.app_not_save), true, new SettingsTrustFriendUI.3(this), new SettingsTrustFriendUI.4(this));
      return;
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.settings_trust_friend;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_trust_friend);
    this.kHX = ((GridView)findViewById(a.f.trust_friend_grid));
    this.nWm = new SettingsTrustFriendUI.a(this, (byte)0);
    int i = getResources().getDimensionPixelSize(a.d.NormalAvatarWrapSize);
    this.kHX.setColumnWidth(i);
    this.kHX.setNumColumns(-1);
    this.kHX.setStretchMode(1);
    this.kHX.setHorizontalSpacing(getResources().getDimensionPixelSize(a.d.grid_item_left_right_padding) * 2);
    this.kHX.setVerticalSpacing(getResources().getDimensionPixelSize(a.d.grid_item_top_bottom_padding));
    this.kHX.setAdapter(this.nWm);
    ((ViewGroup)this.kHX.getParent()).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (SettingsTrustFriendUI.b(SettingsTrustFriendUI.this))
        {
          SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
        }
      }
    });
    this.kHX.setOnTouchListener(new SettingsTrustFriendUI.7(this));
    this.kHX.setHorizontalScrollBarEnabled(false);
    this.kHX.setVerticalScrollBarEnabled(false);
    this.kHX.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItemViewType(paramAnonymousInt) == 1)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("list_type", 12);
          paramAnonymousAdapterView.putExtra("titile", SettingsTrustFriendUI.this.getString(a.i.address_title_select_contact));
          paramAnonymousAdapterView.putExtra("scene", 2);
          paramAnonymousAdapterView.putExtra("max_limit_num", SettingsTrustFriendUI.su());
          paramAnonymousAdapterView.putExtra("stay_in_wechat", true);
          paramAnonymousAdapterView.putExtra("already_select_contact", bk.c(SettingsTrustFriendUI.e(SettingsTrustFriendUI.this), ","));
          paramAnonymousAdapterView.putExtra("block_contact", q.Gj());
          paramAnonymousAdapterView.putExtra("list_attr", com.tencent.mm.ui.contact.s.fB(com.tencent.mm.ui.contact.s.vMx, 256));
          paramAnonymousAdapterView.putExtra("too_many_member_tip_string", SettingsTrustFriendUI.this.getString(a.i.settings_trust_friend_max_limit_tip, new Object[] { Integer.valueOf(SettingsTrustFriendUI.su()) }));
          d.c(SettingsTrustFriendUI.this, ".ui.contact.SelectContactUI", paramAnonymousAdapterView, 1);
        }
        do
        {
          return;
          if (SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItemViewType(paramAnonymousInt) != 2) {
            break;
          }
        } while (SettingsTrustFriendUI.b(SettingsTrustFriendUI.this));
        SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, true);
        for (;;)
        {
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
          return;
          if ((SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItemViewType(paramAnonymousInt) != 0) || (!SettingsTrustFriendUI.b(SettingsTrustFriendUI.this))) {
            break;
          }
          SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).remove(SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItem(paramAnonymousInt));
          if (SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).size() == 0) {
            SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          }
        }
      }
    });
    this.leV = ((TextView)findViewById(a.f.trust_friend_desc));
    String str = getIntent().getStringExtra(e.g.uHU);
    if (!bk.bl(str)) {
      this.leV.setText(str);
    }
    for (;;)
    {
      this.nWn = findViewById(a.f.trust_friend_warn_banner);
      this.nWn.setVisibility(8);
      ((TextView)this.nWn.findViewById(a.f.warn_tip)).setText(getString(a.i.settings_trust_friend_min_limit_tip, new Object[] { Integer.valueOf(3) }));
      this.nWn.findViewById(a.f.close_icon).setOnClickListener(new SettingsTrustFriendUI.9(this));
      findViewById(a.f.trust_friend_link).setOnClickListener(new SettingsTrustFriendUI.10(this));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          SettingsTrustFriendUI.g(SettingsTrustFriendUI.this);
          return true;
        }
      });
      a(1, getString(a.i.app_finish), new SettingsTrustFriendUI.12(this), s.b.uNx);
      showOptionMenu(true);
      return;
      this.leV.setText(getResources().getString(a.i.settings_trust_friend_tip, new Object[] { Integer.valueOf(3) }));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!bk.bl(paramIntent))
      {
        this.nWl.clear();
        this.nWl.addAll(bk.G(paramIntent.split(",")));
        this.nWm.notifyDataSetChanged();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = (String)g.DP().Dz().get(352277, null);
    if (!bk.bl(paramBundle)) {
      this.nWl = bk.G(paramBundle.split(","));
    }
    if (this.nWl == null) {
      this.nWl = new ArrayList();
    }
    this.mController.contentView.post(new SettingsTrustFriendUI.1(this));
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      bzs();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.jLo != null) {
      this.jLo.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramm.getType() == 869)
      {
        paramString = (alh)((b)paramm.edi).ecF.ecN;
        nWo = paramString.thm;
        paramString = paramString.svU;
        if (paramString.size() == this.nWl.size()) {
          if (paramString.size() == 0) {
            paramInt1 = 0;
          }
        }
        while (paramInt1 != 0)
        {
          this.nWl.clear();
          paramString = paramString.iterator();
          for (;;)
          {
            if (paramString.hasNext())
            {
              paramm = (bzc)paramString.next();
              this.nWl.add(paramm.hPY);
              continue;
              paramm = paramString.iterator();
              for (;;)
              {
                if (paramm.hasNext())
                {
                  localbzc = (bzc)paramm.next();
                  if (!this.nWl.contains(localbzc.hPY))
                  {
                    paramInt1 = 1;
                    break;
                  }
                }
              }
              paramInt1 = 0;
              break;
            }
          }
          this.nWm.notifyDataSetChanged();
        }
        if ((this.nWl.size() > 0) && (this.nWl.size() < 3)) {
          this.nWn.setVisibility(0);
        }
        g.DP().Dz().o(352277, bk.c(this.nWl, ","));
      }
    }
    while (bk.bl(paramString))
    {
      bzc localbzc;
      do
      {
        return;
      } while (paramm.getType() != 583);
      g.DP().Dz().o(352277, bk.c(this.nWl, ","));
      finish();
      return;
    }
    h.bC(this, paramString);
  }
  
  public void onStart()
  {
    super.onStart();
    g.Dk().a(869, this);
    g.Dk().a(583, this);
  }
  
  protected void onStop()
  {
    super.onStop();
    g.Dk().b(869, this);
    g.Dk().b(583, this);
  }
  
  private final class a$a
  {
    TextView hPg;
    ImageView nOd;
    ImageView nWs;
    
    private a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI
 * JD-Core Version:    0.7.0.1
 */