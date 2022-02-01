package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bwi;
import com.tencent.mm.protocal.protobuf.eku;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsTrustFriendUI
  extends MMActivity
  implements i
{
  private static int Dew = 5;
  private boolean Dcl;
  private List<String> Deu;
  private a Dev;
  private View oQL;
  private com.tencent.mm.ui.base.q sOk;
  private GridView wmW;
  private TextView xVY;
  
  private void eTA()
  {
    AppMethodBeat.i(74490);
    String str = (String)g.aAh().azQ().get(352277, null);
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullOrNil(str)) {
      localArrayList = Util.stringsToList(str.split(","));
    }
    for (;;)
    {
      if ((this.Deu.size() == localArrayList.size()) && (this.Deu.containsAll(localArrayList)))
      {
        finish();
        AppMethodBeat.o(74490);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131764867), getString(2131755998), getString(2131755970), getString(2131755918), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    return 2131496276;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74487);
    setMMTitle(2131765649);
    this.wmW = ((GridView)findViewById(2131309422));
    this.Dev = new a((byte)0);
    int i = getResources().getDimensionPixelSize(2131165528);
    this.wmW.setColumnWidth(i);
    this.wmW.setNumColumns(-1);
    this.wmW.setStretchMode(1);
    this.wmW.setHorizontalSpacing(getResources().getDimensionPixelSize(2131166503) * 2);
    this.wmW.setVerticalSpacing(getResources().getDimensionPixelSize(2131166504));
    this.wmW.setAdapter(this.Dev);
    ((ViewGroup)this.wmW.getParent()).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74473);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (SettingsTrustFriendUI.b(SettingsTrustFriendUI.this))
        {
          SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
        }
        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74473);
      }
    });
    this.wmW.setOnTouchListener(new View.OnTouchListener()
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
    this.wmW.setHorizontalScrollBarEnabled(false);
    this.wmW.setVerticalScrollBarEnabled(false);
    this.wmW.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(74475);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItemViewType(paramAnonymousInt) == 1)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("list_type", 12);
          paramAnonymousAdapterView.putExtra("titile", SettingsTrustFriendUI.this.getString(2131755268));
          paramAnonymousAdapterView.putExtra("scene", 2);
          paramAnonymousAdapterView.putExtra("max_limit_num", SettingsTrustFriendUI.Dew);
          paramAnonymousAdapterView.putExtra("stay_in_wechat", true);
          paramAnonymousAdapterView.putExtra("already_select_contact", Util.listToString(SettingsTrustFriendUI.e(SettingsTrustFriendUI.this), ","));
          paramAnonymousAdapterView.putExtra("block_contact", z.aTY());
          paramAnonymousAdapterView.putExtra("list_attr", u.ll(u.ll(u.PWY, 256), 16777216));
          paramAnonymousAdapterView.putExtra("KBlockOpenImFav", true);
          paramAnonymousAdapterView.putExtra("without_openim", true);
          paramAnonymousAdapterView.putExtra("too_many_member_tip_string", SettingsTrustFriendUI.this.getString(2131765651, new Object[] { Integer.valueOf(SettingsTrustFriendUI.Dew) }));
          com.tencent.mm.br.c.c(SettingsTrustFriendUI.this, ".ui.contact.SelectContactUI", paramAnonymousAdapterView, 1);
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
    this.xVY = ((TextView)findViewById(2131309421));
    String str = getIntent().getStringExtra(e.m.Ozm);
    if (!Util.isNullOrNil(str)) {
      this.xVY.setText(str);
    }
    for (;;)
    {
      this.oQL = findViewById(2131309425);
      this.oQL.setVisibility(8);
      ((TextView)this.oQL.findViewById(2131310330)).setText(getString(2131765652, new Object[] { Integer.valueOf(3) }));
      this.oQL.findViewById(2131298778).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74476);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          SettingsTrustFriendUI.f(SettingsTrustFriendUI.this).setVisibility(8);
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74476);
        }
      });
      findViewById(2131309423).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74477);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", "https://" + WeChatHosts.domainString(2131761748) + "/security/readtemplate?t=w_security_center_website/trusted_friend_guide");
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
      addTextOptionMenu(1, getString(2131755858), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74479);
          SettingsTrustFriendUI.h(SettingsTrustFriendUI.this);
          AppMethodBeat.o(74479);
          return true;
        }
      }, null, t.b.OGU);
      showOptionMenu(true);
      AppMethodBeat.o(74487);
      return;
      this.xVY.setText(getResources().getString(2131765653, new Object[] { Integer.valueOf(3) }));
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
        this.Deu.clear();
        this.Deu.addAll(Util.stringsToList(paramIntent.split(",")));
        this.Dev.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(74488);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74484);
    super.onCreate(paramBundle);
    paramBundle = (String)g.aAh().azQ().get(352277, null);
    if (!Util.isNullOrNil(paramBundle)) {
      this.Deu = Util.stringsToList(paramBundle.split(","));
    }
    if (this.Deu == null) {
      this.Deu = new ArrayList();
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
      eTA();
      AppMethodBeat.o(74491);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(74491);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(74489);
    Log.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.sOk != null) {
      this.sOk.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() == 869)
      {
        paramString = (bwi)((d)paramq.getReqResp()).iLL.iLR;
        Dew = paramString.Mch;
        paramString = paramString.KHC;
        if (paramString.size() == this.Deu.size()) {
          if (paramString.size() == 0) {
            paramInt1 = 0;
          }
        }
        while (paramInt1 != 0)
        {
          this.Deu.clear();
          paramString = paramString.iterator();
          for (;;)
          {
            if (paramString.hasNext())
            {
              paramq = (eku)paramString.next();
              this.Deu.add(paramq.UserName);
              continue;
              paramq = paramString.iterator();
              for (;;)
              {
                if (paramq.hasNext())
                {
                  eku localeku = (eku)paramq.next();
                  if (!this.Deu.contains(localeku.UserName))
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
          this.Dev.notifyDataSetChanged();
        }
        if ((this.Deu.size() > 0) && (this.Deu.size() < 3)) {
          this.oQL.setVisibility(0);
        }
        g.aAh().azQ().set(352277, Util.listToString(this.Deu, ","));
        AppMethodBeat.o(74489);
        return;
      }
      if (paramq.getType() == 583)
      {
        g.aAh().azQ().set(352277, Util.listToString(this.Deu, ","));
        finish();
        AppMethodBeat.o(74489);
      }
    }
    else if (!Util.isNullOrNil(paramString))
    {
      com.tencent.mm.ui.base.h.cD(this, paramString);
    }
    AppMethodBeat.o(74489);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(74485);
    super.onStart();
    g.azz().a(869, this);
    g.azz().a(583, this);
    AppMethodBeat.o(74485);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(74486);
    super.onStop();
    g.azz().b(869, this);
    g.azz().b(583, this);
    AppMethodBeat.o(74486);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
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
        } else if ((i > 0) && (i < SettingsTrustFriendUI.Dew)) {
          i += 2;
        } else if (i >= SettingsTrustFriendUI.Dew) {
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
      if (i >= SettingsTrustFriendUI.Dew)
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
        paramView = SettingsTrustFriendUI.this.getLayoutInflater().inflate(2131496277, null);
        Object localObject1 = (ImageView)paramView.findViewById(2131309419);
        Object localObject2 = (ImageView)paramView.findViewById(2131309420);
        TextView localTextView = (TextView)paramView.findViewById(2131309424);
        paramViewGroup = new a((byte)0);
        paramViewGroup.COW = ((ImageView)localObject1);
        paramViewGroup.DeA = ((ImageView)localObject2);
        paramViewGroup.oSN = localTextView;
        paramView.setTag(paramViewGroup);
        if (getItemViewType(paramInt) != 0) {
          break label230;
        }
        localObject1 = (String)SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).get(paramInt);
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)localObject1);
        paramViewGroup.COW.setScaleType(ImageView.ScaleType.FIT_XY);
        a.b.c(paramViewGroup.COW, (String)localObject1);
        paramViewGroup.oSN.setText(com.tencent.mm.pluginsdk.ui.span.l.b(SettingsTrustFriendUI.this, ((as)localObject2).arJ(), paramViewGroup.oSN.getTextSize()));
        if (!SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) {
          break label218;
        }
        paramViewGroup.DeA.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(74483);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label218:
        paramViewGroup.DeA.setVisibility(8);
        continue;
        label230:
        paramViewGroup.oSN.setVisibility(4);
        paramViewGroup.DeA.setVisibility(8);
        paramViewGroup.COW.setScaleType(ImageView.ScaleType.FIT_XY);
        if (getItemViewType(paramInt) == 1) {
          paramViewGroup.COW.setImageResource(2131231212);
        } else if (getItemViewType(paramInt) == 2) {
          paramViewGroup.COW.setImageResource(2131231213);
        }
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
    
    final class a
    {
      ImageView COW;
      ImageView DeA;
      TextView oSN;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI
 * JD-Core Version:    0.7.0.1
 */