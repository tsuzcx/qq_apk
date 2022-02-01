package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

public class SnsTagPartlyUI
  extends MMActivity
  implements f
{
  private a Aju;
  private View.OnClickListener Ajv;
  private ListView jpT;
  protected p tipDialog;
  
  public SnsTagPartlyUI()
  {
    AppMethodBeat.i(99209);
    this.tipDialog = null;
    this.Ajv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99203);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (SnsTagPartlyUI.a(SnsTagPartlyUI.this) == null)
        {
          ad.e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99203);
          return;
        }
        paramAnonymousView = paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          ad.e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99203);
          return;
        }
        if (!(paramAnonymousView instanceof Integer))
        {
          ad.e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99203);
          return;
        }
        paramAnonymousView = (v)SnsTagPartlyUI.a(SnsTagPartlyUI.this).getItem(((Integer)paramAnonymousView).intValue());
        SnsTagPartlyUI.this.tipDialog = h.b(SnsTagPartlyUI.this, null, true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
        });
        g.ajD();
        g.ajB().gAO.a(new com.tencent.mm.plugin.sns.model.w(paramAnonymousView.field_tagId, paramAnonymousView.field_tagName), 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99203);
      }
    };
    AppMethodBeat.o(99209);
  }
  
  public int getLayoutId()
  {
    return 2131495599;
  }
  
  public void initView()
  {
    AppMethodBeat.i(99213);
    setMMTitle(2131763371);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99199);
        SnsTagPartlyUI.this.finish();
        AppMethodBeat.o(99199);
        return true;
      }
    });
    this.jpT = ((ListView)findViewById(2131305081));
    this.jpT.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(99200);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        if (paramAnonymousInt < SnsTagPartlyUI.a(SnsTagPartlyUI.this).getCount() - 1)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousView = (v)SnsTagPartlyUI.a(SnsTagPartlyUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(99200);
            return;
          }
          paramAnonymousAdapterView.putExtra("k_sns_tag_id", paramAnonymousView.field_tagId);
          paramAnonymousAdapterView.setClass(SnsTagPartlyUI.this, SnsTagDetailUI.class);
          paramAnonymousView = SnsTagPartlyUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahp(), "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(99200);
          return;
          paramAnonymousAdapterView = new Intent();
          paramAnonymousView = com.tencent.mm.model.u.aAm();
          paramAnonymousAdapterView.putExtra("titile", SnsTagPartlyUI.this.getString(2131755229));
          paramAnonymousAdapterView.putExtra("list_type", 1);
          paramAnonymousAdapterView.putExtra("KBlockOpenImFav", true);
          paramAnonymousAdapterView.putExtra("list_attr", com.tencent.mm.ui.contact.u.jU(com.tencent.mm.ui.contact.u.I(new int[] { com.tencent.mm.ui.contact.u.Kny, 1024 }), 16777216));
          paramAnonymousAdapterView.putExtra("block_contact", paramAnonymousView);
          d.c(SnsTagPartlyUI.this, ".ui.contact.SelectContactUI", paramAnonymousAdapterView, 1);
        }
      }
    });
    this.Aju = new a(this);
    View localView = View.inflate(this, 2131495598, null);
    this.jpT.addFooterView(localView);
    this.jpT.setAdapter(this.Aju);
    addTextOptionMenu(0, getString(2131764007), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99201);
        paramAnonymousMenuItem = SnsTagPartlyUI.a(SnsTagPartlyUI.this);
        boolean bool;
        SnsTagPartlyUI localSnsTagPartlyUI;
        if (!SnsTagPartlyUI.a(SnsTagPartlyUI.this).Ajy)
        {
          bool = true;
          paramAnonymousMenuItem.Ajy = bool;
          localSnsTagPartlyUI = SnsTagPartlyUI.this;
          if (!SnsTagPartlyUI.a(SnsTagPartlyUI.this).Ajy) {
            break label89;
          }
        }
        label89:
        for (paramAnonymousMenuItem = SnsTagPartlyUI.this.getString(2131755779);; paramAnonymousMenuItem = SnsTagPartlyUI.this.getString(2131764007))
        {
          localSnsTagPartlyUI.updateOptionMenuText(0, paramAnonymousMenuItem);
          SnsTagPartlyUI.a(SnsTagPartlyUI.this).notifyDataSetChanged();
          AppMethodBeat.o(99201);
          return true;
          bool = false;
          break;
        }
      }
    });
    this.Aju.a(new r.a()
    {
      public final void aSs()
      {
        boolean bool = true;
        AppMethodBeat.i(99202);
        SnsTagPartlyUI localSnsTagPartlyUI = SnsTagPartlyUI.this;
        if (SnsTagPartlyUI.a(SnsTagPartlyUI.this).getCount() > 1) {}
        for (;;)
        {
          localSnsTagPartlyUI.enableOptionMenu(bool);
          AppMethodBeat.o(99202);
          return;
          bool = false;
        }
      }
    });
    AppMethodBeat.o(99213);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99214);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(99214);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99214);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(99214);
        return;
      }
      String str = paramIntent.getStringExtra("Select_Contact");
      paramIntent = paramIntent.getStringExtra("Select_room_name");
      if (str == null)
      {
        AppMethodBeat.o(99214);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("k_sns_tag_id", 0);
      localIntent.putExtra("k_sns_tag_name", bt.bI(paramIntent, ""));
      localIntent.putExtra("k_sns_tag_list", str);
      localIntent.setClass(this, SnsTagDetailUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahp(), "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99210);
    super.onCreate(paramBundle);
    g.ajD();
    g.ajB().gAO.a(292, this);
    g.ajD();
    g.ajB().gAO.a(290, this);
    initView();
    AppMethodBeat.o(99210);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99211);
    g.ajD();
    g.ajB().gAO.b(292, this);
    g.ajD();
    g.ajB().gAO.b(290, this);
    if (this.Aju != null) {
      this.Aju.det();
    }
    super.onDestroy();
    AppMethodBeat.o(99211);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99212);
    super.onResume();
    if (this.Aju != null) {
      this.Aju.a("", null);
    }
    AppMethodBeat.o(99212);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(99215);
    ad.i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.Aju != null) {
      this.Aju.a("", null);
    }
    AppMethodBeat.o(99215);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends r<v>
  {
    public boolean Ajy;
    private Context context;
    
    public a(Context paramContext)
    {
      super(new v());
      AppMethodBeat.i(99204);
      this.Ajy = false;
      this.context = paramContext;
      AppMethodBeat.o(99204);
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(99206);
      setCursor(ag.dUk().getCursor());
      notifyDataSetChanged();
      AppMethodBeat.o(99206);
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(99207);
      det();
      Zu();
      AppMethodBeat.o(99207);
    }
    
    public final int dac()
    {
      return 1;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(99205);
      int i;
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131495063, null);
        paramViewGroup.Ajz = ((TextView)paramView.findViewById(2131305630));
        paramViewGroup.AjA = ((TextView)paramView.findViewById(2131305075));
        paramViewGroup.jis = ((Button)paramView.findViewById(2131298954));
        paramView.setTag(paramViewGroup);
        if (HY(paramInt)) {
          break label229;
        }
        Object localObject = (v)getItem(paramInt);
        paramViewGroup.Ajz.setText(((v)localObject).field_tagName);
        paramViewGroup.AjA.setVisibility(0);
        paramViewGroup.AjA.setText(" (" + ((v)localObject).field_count + ") ");
        localObject = paramViewGroup.jis;
        if (!this.Ajy) {
          break label222;
        }
        i = 0;
        label172:
        ((Button)localObject).setVisibility(i);
        paramViewGroup.jis.setOnClickListener(SnsTagPartlyUI.b(SnsTagPartlyUI.this));
        paramViewGroup.jis.setTag(Integer.valueOf(paramInt));
      }
      for (;;)
      {
        AppMethodBeat.o(99205);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label222:
        i = 8;
        break label172;
        label229:
        paramViewGroup.Ajz.setText(2131764344);
        paramViewGroup.AjA.setVisibility(8);
        paramViewGroup.jis.setVisibility(8);
      }
    }
    
    final class a
    {
      TextView AjA;
      TextView Ajz;
      Button jis;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI
 * JD-Core Version:    0.7.0.1
 */