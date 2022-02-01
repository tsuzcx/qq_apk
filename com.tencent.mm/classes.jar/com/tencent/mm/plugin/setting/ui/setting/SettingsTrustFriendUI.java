package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.d;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.protocal.protobuf.fqm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.f.p;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SettingsTrustFriendUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private static int PwD = 5;
  private TextView FcR;
  private GridView GzA;
  private boolean Pty;
  private List<String> PwB;
  private a PwC;
  private View vdX;
  private com.tencent.mm.ui.base.w zQl;
  
  private void gWl()
  {
    AppMethodBeat.i(74490);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().d(352277, null);
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullOrNil(str)) {
      localArrayList = Util.stringsToList(str.split(","));
    }
    for (;;)
    {
      if ((this.PwB.size() == localArrayList.size()) && (this.PwB.containsAll(localArrayList)))
      {
        finish();
        AppMethodBeat.o(74490);
        return;
      }
      k.a(this, getString(b.i.save_label_msg), getString(b.i.app_tip), getString(b.i.app_save), getString(b.i.app_not_save), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74470);
          SettingsTrustFriendUI.h(SettingsTrustFriendUI.this);
          AppMethodBeat.o(74470);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74471);
          SettingsTrustFriendUI.this.finish();
          AppMethodBeat.o(74471);
        }
      });
      AppMethodBeat.o(74490);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return b.g.settings_trust_friend;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74487);
    setMMTitle(b.i.settings_trust_friend);
    this.GzA = ((GridView)findViewById(b.f.trust_friend_grid));
    this.PwC = new a((byte)0);
    int i = getResources().getDimensionPixelSize(b.d.NormalAvatarWrapSize);
    this.GzA.setColumnWidth(i);
    this.GzA.setNumColumns(-1);
    this.GzA.setStretchMode(1);
    this.GzA.setHorizontalSpacing(getResources().getDimensionPixelSize(b.d.grid_item_left_right_padding) * 2);
    this.GzA.setVerticalSpacing(getResources().getDimensionPixelSize(b.d.grid_item_top_bottom_padding));
    this.GzA.setAdapter(this.PwC);
    ((ViewGroup)this.GzA.getParent()).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74473);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (SettingsTrustFriendUI.b(SettingsTrustFriendUI.this))
        {
          SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
        }
        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74473);
      }
    });
    this.GzA.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(74474);
        if ((SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) && (paramAnonymousMotionEvent.getAction() == 1) && (SettingsTrustFriendUI.d(SettingsTrustFriendUI.this).pointToPosition((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY()) == -1))
        {
          SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
          AppMethodBeat.o(74474);
          return true;
        }
        AppMethodBeat.o(74474);
        return false;
      }
    });
    this.GzA.setHorizontalScrollBarEnabled(false);
    this.GzA.setVerticalScrollBarEnabled(false);
    this.GzA.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(74475);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItemViewType(paramAnonymousInt) == 1)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("list_type", 12);
          paramAnonymousAdapterView.putExtra("titile", SettingsTrustFriendUI.this.getString(b.i.address_title_select_contact));
          paramAnonymousAdapterView.putExtra("scene", 2);
          paramAnonymousAdapterView.putExtra("max_limit_num", SettingsTrustFriendUI.PwD);
          paramAnonymousAdapterView.putExtra("stay_in_wechat", true);
          paramAnonymousAdapterView.putExtra("already_select_contact", Util.listToString(SettingsTrustFriendUI.e(SettingsTrustFriendUI.this), ","));
          paramAnonymousAdapterView.putExtra("block_contact", z.bAM());
          paramAnonymousAdapterView.putExtra("list_attr", com.tencent.mm.ui.contact.w.ow(com.tencent.mm.ui.contact.w.ow(com.tencent.mm.ui.contact.w.affv, 256), 16777216));
          paramAnonymousAdapterView.putExtra("KBlockOpenImFav", true);
          paramAnonymousAdapterView.putExtra("without_openim", true);
          paramAnonymousAdapterView.putExtra("too_many_member_tip_string", SettingsTrustFriendUI.this.getString(b.i.settings_trust_friend_max_limit_tip, new Object[] { Integer.valueOf(SettingsTrustFriendUI.PwD) }));
          com.tencent.mm.br.c.d(SettingsTrustFriendUI.this, ".ui.contact.SelectContactUI", paramAnonymousAdapterView, 1);
        }
        do
        {
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(74475);
          return;
          if (SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItemViewType(paramAnonymousInt) != 2) {
            break;
          }
        } while (SettingsTrustFriendUI.b(SettingsTrustFriendUI.this));
        SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, true);
        for (;;)
        {
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
          break;
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
    this.FcR = ((TextView)findViewById(b.f.trust_friend_desc));
    String str = getIntent().getStringExtra(f.p.adwJ);
    if (!Util.isNullOrNil(str)) {
      this.FcR.setText(str);
    }
    for (;;)
    {
      this.vdX = findViewById(b.f.trust_friend_warn_banner);
      this.vdX.setVisibility(8);
      ((TextView)this.vdX.findViewById(b.f.warn_tip)).setText(getString(b.i.settings_trust_friend_min_limit_tip, new Object[] { Integer.valueOf(3) }));
      this.vdX.findViewById(b.f.close_icon).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74476);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          SettingsTrustFriendUI.f(SettingsTrustFriendUI.this).setVisibility(8);
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74476);
        }
      });
      findViewById(b.f.trust_friend_link).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74477);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", "https://" + WeChatHosts.domainString(b.i.host_weixin110_qq_com) + "/security/readtemplate?t=w_security_center_website/trusted_friend_guide");
          com.tencent.mm.br.c.b(SettingsTrustFriendUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74477);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74478);
          SettingsTrustFriendUI.g(SettingsTrustFriendUI.this);
          AppMethodBeat.o(74478);
          return true;
        }
      });
      addTextOptionMenu(1, getString(b.i.app_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74479);
          SettingsTrustFriendUI.h(SettingsTrustFriendUI.this);
          AppMethodBeat.o(74479);
          return true;
        }
      }, null, y.b.adEJ);
      showOptionMenu(true);
      AppMethodBeat.o(74487);
      return;
      this.FcR.setText(getResources().getString(b.i.settings_trust_friend_tip, new Object[] { Integer.valueOf(3) }));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74488);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!Util.isNullOrNil(paramIntent))
      {
        this.PwB.clear();
        this.PwB.addAll(Util.stringsToList(paramIntent.split(",")));
        this.PwC.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(74488);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74484);
    super.onCreate(paramBundle);
    paramBundle = (String)com.tencent.mm.kernel.h.baE().ban().d(352277, null);
    if (!Util.isNullOrNil(paramBundle)) {
      this.PwB = Util.stringsToList(paramBundle.split(","));
    }
    if (this.PwB == null) {
      this.PwB = new ArrayList();
    }
    getContentView().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74468);
        SettingsTrustFriendUI.a(SettingsTrustFriendUI.this);
        AppMethodBeat.o(74468);
      }
    });
    initView();
    AppMethodBeat.o(74484);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74491);
    if (paramInt == 4)
    {
      gWl();
      AppMethodBeat.o(74491);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(74491);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(74489);
    Log.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.zQl != null) {
      this.zQl.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp.getType() == 869)
      {
        paramString = (cty)c.c.b(((com.tencent.mm.am.c)paramp.getReqResp()).otC);
        PwD = paramString.aazz;
        paramString = paramString.YGj;
        if (paramString.size() == this.PwB.size()) {
          if (paramString.size() == 0) {
            paramInt1 = 0;
          }
        }
        while (paramInt1 != 0)
        {
          this.PwB.clear();
          paramString = paramString.iterator();
          for (;;)
          {
            if (paramString.hasNext())
            {
              paramp = (fqm)paramString.next();
              this.PwB.add(paramp.UserName);
              continue;
              paramp = paramString.iterator();
              for (;;)
              {
                if (paramp.hasNext())
                {
                  fqm localfqm = (fqm)paramp.next();
                  if (!this.PwB.contains(localfqm.UserName))
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
          this.PwC.notifyDataSetChanged();
        }
        if ((this.PwB.size() > 0) && (this.PwB.size() < 3)) {
          this.vdX.setVisibility(0);
        }
        com.tencent.mm.kernel.h.baE().ban().B(352277, Util.listToString(this.PwB, ","));
        AppMethodBeat.o(74489);
        return;
      }
      if (paramp.getType() == 583)
      {
        com.tencent.mm.kernel.h.baE().ban().B(352277, Util.listToString(this.PwB, ","));
        finish();
        AppMethodBeat.o(74489);
      }
    }
    else if (!Util.isNullOrNil(paramString))
    {
      k.cZ(this, paramString);
    }
    AppMethodBeat.o(74489);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(74485);
    super.onStart();
    com.tencent.mm.kernel.h.aZW().a(869, this);
    com.tencent.mm.kernel.h.aZW().a(583, this);
    AppMethodBeat.o(74485);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(74486);
    super.onStop();
    com.tencent.mm.kernel.h.aZW().b(869, this);
    com.tencent.mm.kernel.h.aZW().b(583, this);
    AppMethodBeat.o(74486);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(299008);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.setting.ui.a.c.class);
    AppMethodBeat.o(299008);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(74480);
      int i = SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).size();
      if (SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) {}
      for (;;)
      {
        AppMethodBeat.o(74480);
        return i;
        if (i == 0) {
          i = 1;
        } else if ((i > 0) && (i < SettingsTrustFriendUI.PwD)) {
          i += 2;
        } else if (i >= SettingsTrustFriendUI.PwD) {
          i += 1;
        } else {
          i = 0;
        }
      }
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(74481);
      if (getItemViewType(paramInt) == 0)
      {
        Object localObject = SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).get(paramInt);
        AppMethodBeat.o(74481);
        return localObject;
      }
      AppMethodBeat.o(74481);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(74482);
      int i = SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).size();
      if ((SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) || (paramInt < i))
      {
        AppMethodBeat.o(74482);
        return 0;
      }
      if (i == 0)
      {
        AppMethodBeat.o(74482);
        return 1;
      }
      if (i >= SettingsTrustFriendUI.PwD)
      {
        AppMethodBeat.o(74482);
        return 2;
      }
      if (paramInt == i)
      {
        AppMethodBeat.o(74482);
        return 1;
      }
      if (paramInt == i + 1)
      {
        AppMethodBeat.o(74482);
        return 2;
      }
      AppMethodBeat.o(74482);
      return -1;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(74483);
      if (paramView == null)
      {
        paramView = SettingsTrustFriendUI.this.getLayoutInflater().inflate(b.g.settings_trust_friend_item, null);
        Object localObject1 = (ImageView)paramView.findViewById(b.f.trust_friend_avatar);
        Object localObject2 = (ImageView)paramView.findViewById(b.f.trust_friend_del_btn);
        TextView localTextView = (TextView)paramView.findViewById(b.f.trust_friend_name);
        paramViewGroup = new a((byte)0);
        paramViewGroup.Pdq = ((ImageView)localObject1);
        paramViewGroup.PwH = ((ImageView)localObject2);
        paramViewGroup.vgb = localTextView;
        paramView.setTag(paramViewGroup);
        if (getItemViewType(paramInt) != 0) {
          break label252;
        }
        localObject1 = (String)SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).get(paramInt);
        localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject1);
        paramViewGroup.Pdq.setScaleType(ImageView.ScaleType.FIT_XY);
        a.b.g(paramViewGroup.Pdq, (String)localObject1);
        paramViewGroup.vgb.setText(com.tencent.mm.pluginsdk.ui.span.p.b(SettingsTrustFriendUI.this, ((au)localObject2).aSV(), paramViewGroup.vgb.getTextSize()));
        if (!SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) {
          break label240;
        }
        paramViewGroup.PwH.setVisibility(0);
      }
      for (;;)
      {
        paramViewGroup.Pdq.setTag(b.f.setting_accessibility_trust_friend_tag, Integer.valueOf(getItemViewType(paramInt)));
        AppMethodBeat.o(74483);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label240:
        paramViewGroup.PwH.setVisibility(8);
        continue;
        label252:
        paramViewGroup.vgb.setVisibility(4);
        paramViewGroup.PwH.setVisibility(8);
        paramViewGroup.Pdq.setScaleType(ImageView.ScaleType.FIT_XY);
        if (getItemViewType(paramInt) == 1) {
          paramViewGroup.Pdq.setImageResource(b.e.big_add_selector);
        } else if (getItemViewType(paramInt) == 2) {
          paramViewGroup.Pdq.setImageResource(b.e.big_del_selector);
        }
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
    
    final class a
    {
      ImageView Pdq;
      ImageView PwH;
      TextView vgb;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI
 * JD-Core Version:    0.7.0.1
 */