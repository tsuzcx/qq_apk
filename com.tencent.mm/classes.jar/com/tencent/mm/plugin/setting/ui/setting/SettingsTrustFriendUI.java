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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bjj;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.e.k;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingsTrustFriendUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private static int yJu = 5;
  private View nAt;
  private p reC;
  private GridView sUB;
  private TextView usH;
  private boolean yHk;
  private List<String> yJs;
  private a yJt;
  
  private void dOc()
  {
    AppMethodBeat.i(74490);
    String str = (String)g.ajC().ajl().get(352277, null);
    ArrayList localArrayList = new ArrayList();
    if (!bt.isNullOrNil(str)) {
      localArrayList = bt.U(str.split(","));
    }
    for (;;)
    {
      if ((this.yJs.size() == localArrayList.size()) && (this.yJs.containsAll(localArrayList)))
      {
        finish();
        AppMethodBeat.o(74490);
        return;
      }
      h.a(this, getString(2131762782), getString(2131755906), getString(2131755880), getString(2131755832), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    return 2131495408;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74487);
    setMMTitle(2131763466);
    this.sUB = ((GridView)findViewById(2131306084));
    this.yJt = new a((byte)0);
    int i = getResources().getDimensionPixelSize(2131165510);
    this.sUB.setColumnWidth(i);
    this.sUB.setNumColumns(-1);
    this.sUB.setStretchMode(1);
    this.sUB.setHorizontalSpacing(getResources().getDimensionPixelSize(2131166411) * 2);
    this.sUB.setVerticalSpacing(getResources().getDimensionPixelSize(2131166412));
    this.sUB.setAdapter(this.yJt);
    ((ViewGroup)this.sUB.getParent()).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74473);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (SettingsTrustFriendUI.b(SettingsTrustFriendUI.this))
        {
          SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
        }
        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74473);
      }
    });
    this.sUB.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(74474);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if ((SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) && (paramAnonymousMotionEvent.getAction() == 1) && (SettingsTrustFriendUI.d(SettingsTrustFriendUI.this).pointToPosition((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY()) == -1))
        {
          SettingsTrustFriendUI.a(SettingsTrustFriendUI.this, false);
          SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).notifyDataSetChanged();
          a.a(true, this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(74474);
          return true;
        }
        a.a(false, this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$4", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(74474);
        return false;
      }
    });
    this.sUB.setHorizontalScrollBarEnabled(false);
    this.sUB.setVerticalScrollBarEnabled(false);
    this.sUB.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(74475);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        if (SettingsTrustFriendUI.c(SettingsTrustFriendUI.this).getItemViewType(paramAnonymousInt) == 1)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("list_type", 12);
          paramAnonymousAdapterView.putExtra("titile", SettingsTrustFriendUI.this.getString(2131755234));
          paramAnonymousAdapterView.putExtra("scene", 2);
          paramAnonymousAdapterView.putExtra("max_limit_num", SettingsTrustFriendUI.yJu);
          paramAnonymousAdapterView.putExtra("stay_in_wechat", true);
          paramAnonymousAdapterView.putExtra("already_select_contact", bt.m(SettingsTrustFriendUI.e(SettingsTrustFriendUI.this), ","));
          paramAnonymousAdapterView.putExtra("block_contact", com.tencent.mm.model.u.aAm());
          paramAnonymousAdapterView.putExtra("list_attr", com.tencent.mm.ui.contact.u.jU(com.tencent.mm.ui.contact.u.jU(com.tencent.mm.ui.contact.u.KnD, 256), 16777216));
          paramAnonymousAdapterView.putExtra("KBlockOpenImFav", true);
          paramAnonymousAdapterView.putExtra("without_openim", true);
          paramAnonymousAdapterView.putExtra("too_many_member_tip_string", SettingsTrustFriendUI.this.getString(2131763468, new Object[] { Integer.valueOf(SettingsTrustFriendUI.yJu) }));
          d.c(SettingsTrustFriendUI.this, ".ui.contact.SelectContactUI", paramAnonymousAdapterView, 1);
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
    this.usH = ((TextView)findViewById(2131306083));
    String str = getIntent().getStringExtra(e.k.IUF);
    if (!bt.isNullOrNil(str)) {
      this.usH.setText(str);
    }
    for (;;)
    {
      this.nAt = findViewById(2131306087);
      this.nAt.setVisibility(8);
      ((TextView)this.nAt.findViewById(2131306866)).setText(getString(2131763469, new Object[] { Integer.valueOf(3) }));
      this.nAt.findViewById(2131298370).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74476);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          SettingsTrustFriendUI.f(SettingsTrustFriendUI.this).setVisibility(8);
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74476);
        }
      });
      findViewById(2131306085).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74477);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsTrustFriendUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=w_security_center_website/trusted_friend_guide");
          d.b(SettingsTrustFriendUI.this, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
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
      addTextOptionMenu(1, getString(2131755779), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(74479);
          SettingsTrustFriendUI.h(SettingsTrustFriendUI.this);
          AppMethodBeat.o(74479);
          return true;
        }
      }, null, s.b.JbS);
      showOptionMenu(true);
      AppMethodBeat.o(74487);
      return;
      this.usH.setText(getResources().getString(2131763470, new Object[] { Integer.valueOf(3) }));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74488);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!bt.isNullOrNil(paramIntent))
      {
        this.yJs.clear();
        this.yJs.addAll(bt.U(paramIntent.split(",")));
        this.yJt.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(74488);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74484);
    super.onCreate(paramBundle);
    paramBundle = (String)g.ajC().ajl().get(352277, null);
    if (!bt.isNullOrNil(paramBundle)) {
      this.yJs = bt.U(paramBundle.split(","));
    }
    if (this.yJs == null) {
      this.yJs = new ArrayList();
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
      dOc();
      AppMethodBeat.o(74491);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(74491);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74489);
    ad.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.reC != null) {
      this.reC.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 869)
      {
        paramString = (bjj)((com.tencent.mm.al.b)paramn.getReqResp()).hNL.hNQ;
        yJu = paramString.GDP;
        paramString = paramString.Fvz;
        if (paramString.size() == this.yJs.size()) {
          if (paramString.size() == 0) {
            paramInt1 = 0;
          }
        }
        while (paramInt1 != 0)
        {
          this.yJs.clear();
          paramString = paramString.iterator();
          for (;;)
          {
            if (paramString.hasNext())
            {
              paramn = (dqb)paramString.next();
              this.yJs.add(paramn.nDo);
              continue;
              paramn = paramString.iterator();
              for (;;)
              {
                if (paramn.hasNext())
                {
                  dqb localdqb = (dqb)paramn.next();
                  if (!this.yJs.contains(localdqb.nDo))
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
          this.yJt.notifyDataSetChanged();
        }
        if ((this.yJs.size() > 0) && (this.yJs.size() < 3)) {
          this.nAt.setVisibility(0);
        }
        g.ajC().ajl().set(352277, bt.m(this.yJs, ","));
        AppMethodBeat.o(74489);
        return;
      }
      if (paramn.getType() == 583)
      {
        g.ajC().ajl().set(352277, bt.m(this.yJs, ","));
        finish();
        AppMethodBeat.o(74489);
      }
    }
    else if (!bt.isNullOrNil(paramString))
    {
      h.cl(this, paramString);
    }
    AppMethodBeat.o(74489);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(74485);
    super.onStart();
    g.aiU().a(869, this);
    g.aiU().a(583, this);
    AppMethodBeat.o(74485);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(74486);
    super.onStop();
    g.aiU().b(869, this);
    g.aiU().b(583, this);
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
        } else if ((i > 0) && (i < SettingsTrustFriendUI.yJu)) {
          i += 2;
        } else if (i >= SettingsTrustFriendUI.yJu) {
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
      if (i >= SettingsTrustFriendUI.yJu)
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
        paramView = SettingsTrustFriendUI.this.getLayoutInflater().inflate(2131495409, null);
        Object localObject1 = (ImageView)paramView.findViewById(2131306081);
        Object localObject2 = (ImageView)paramView.findViewById(2131306082);
        TextView localTextView = (TextView)paramView.findViewById(2131306086);
        paramViewGroup = new a((byte)0);
        paramViewGroup.yvj = ((ImageView)localObject1);
        paramViewGroup.yJy = ((ImageView)localObject2);
        paramViewGroup.nCw = localTextView;
        paramView.setTag(paramViewGroup);
        if (getItemViewType(paramInt) != 0) {
          break label230;
        }
        localObject1 = (String)SettingsTrustFriendUI.e(SettingsTrustFriendUI.this).get(paramInt);
        localObject2 = ((l)g.ab(l.class)).azp().Bf((String)localObject1);
        paramViewGroup.yvj.setScaleType(ImageView.ScaleType.FIT_XY);
        a.b.c(paramViewGroup.yvj, (String)localObject1);
        paramViewGroup.nCw.setText(k.b(SettingsTrustFriendUI.this, ((am)localObject2).adv(), paramViewGroup.nCw.getTextSize()));
        if (!SettingsTrustFriendUI.b(SettingsTrustFriendUI.this)) {
          break label218;
        }
        paramViewGroup.yJy.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(74483);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label218:
        paramViewGroup.yJy.setVisibility(8);
        continue;
        label230:
        paramViewGroup.nCw.setVisibility(4);
        paramViewGroup.yJy.setVisibility(8);
        paramViewGroup.yvj.setScaleType(ImageView.ScaleType.FIT_XY);
        if (getItemViewType(paramInt) == 1) {
          paramViewGroup.yvj.setImageResource(2131231164);
        } else if (getItemViewType(paramInt) == 2) {
          paramViewGroup.yvj.setImageResource(2131231165);
        }
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
    
    final class a
    {
      TextView nCw;
      ImageView yJy;
      ImageView yvj;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI
 * JD-Core Version:    0.7.0.1
 */