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
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.s.a;

public class SnsTagPartlyUI
  extends MMActivity
  implements i
{
  private a EKb;
  private View.OnClickListener EKc;
  private ListView krb;
  protected com.tencent.mm.ui.base.q tipDialog;
  
  public SnsTagPartlyUI()
  {
    AppMethodBeat.i(99209);
    this.tipDialog = null;
    this.EKc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99203);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (SnsTagPartlyUI.a(SnsTagPartlyUI.this) == null)
        {
          Log.e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99203);
          return;
        }
        paramAnonymousView = paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          Log.e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99203);
          return;
        }
        if (!(paramAnonymousView instanceof Integer))
        {
          Log.e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99203);
          return;
        }
        paramAnonymousView = (com.tencent.mm.plugin.sns.storage.s)SnsTagPartlyUI.a(SnsTagPartlyUI.this).getItem(((Integer)paramAnonymousView).intValue());
        SnsTagPartlyUI.this.tipDialog = h.a(SnsTagPartlyUI.this, null, true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
        });
        g.aAi();
        g.aAg().hqi.a(new y(paramAnonymousView.field_tagId, paramAnonymousView.field_tagName), 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99203);
      }
    };
    AppMethodBeat.o(99209);
  }
  
  public int getLayoutId()
  {
    return 2131496498;
  }
  
  public void initView()
  {
    AppMethodBeat.i(99213);
    setMMTitle(2131765553);
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
    this.krb = ((ListView)findViewById(2131308237));
    this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(99200);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (paramAnonymousInt < SnsTagPartlyUI.a(SnsTagPartlyUI.this).getCount() - 1)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousView = (com.tencent.mm.plugin.sns.storage.s)SnsTagPartlyUI.a(SnsTagPartlyUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(99200);
            return;
          }
          paramAnonymousAdapterView.putExtra("k_sns_tag_id", paramAnonymousView.field_tagId);
          paramAnonymousAdapterView.setClass(SnsTagPartlyUI.this, SnsTagDetailUI.class);
          paramAnonymousView = SnsTagPartlyUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(99200);
          return;
          paramAnonymousAdapterView = new Intent();
          paramAnonymousView = z.aTY();
          paramAnonymousAdapterView.putExtra("titile", SnsTagPartlyUI.this.getString(2131755263));
          paramAnonymousAdapterView.putExtra("list_type", 1);
          paramAnonymousAdapterView.putExtra("KBlockOpenImFav", true);
          paramAnonymousAdapterView.putExtra("list_attr", u.ll(u.Q(new int[] { u.PWT, 1024 }), 16777216));
          paramAnonymousAdapterView.putExtra("block_contact", paramAnonymousView);
          c.c(SnsTagPartlyUI.this, ".ui.contact.SelectContactUI", paramAnonymousAdapterView, 1);
        }
      }
    });
    this.EKb = new a(this);
    View localView = View.inflate(this, 2131496497, null);
    this.krb.addFooterView(localView);
    this.krb.setAdapter(this.EKb);
    addTextOptionMenu(0, getString(2131766245), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99201);
        paramAnonymousMenuItem = SnsTagPartlyUI.a(SnsTagPartlyUI.this);
        boolean bool;
        SnsTagPartlyUI localSnsTagPartlyUI;
        if (!SnsTagPartlyUI.a(SnsTagPartlyUI.this).EKf)
        {
          bool = true;
          paramAnonymousMenuItem.EKf = bool;
          localSnsTagPartlyUI = SnsTagPartlyUI.this;
          if (!SnsTagPartlyUI.a(SnsTagPartlyUI.this).EKf) {
            break label89;
          }
        }
        label89:
        for (paramAnonymousMenuItem = SnsTagPartlyUI.this.getString(2131755858);; paramAnonymousMenuItem = SnsTagPartlyUI.this.getString(2131766245))
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
    this.EKb.a(new s.a()
    {
      public final void bnE()
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
      localIntent.putExtra("k_sns_tag_name", Util.nullAs(paramIntent, ""));
      localIntent.putExtra("k_sns_tag_list", str);
      localIntent.setClass(this, SnsTagDetailUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99210);
    super.onCreate(paramBundle);
    g.aAi();
    g.aAg().hqi.a(292, this);
    g.aAi();
    g.aAg().hqi.a(290, this);
    initView();
    AppMethodBeat.o(99210);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99211);
    g.aAi();
    g.aAg().hqi.b(292, this);
    g.aAi();
    g.aAg().hqi.b(290, this);
    if (this.EKb != null) {
      this.EKb.ebf();
    }
    super.onDestroy();
    AppMethodBeat.o(99211);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99212);
    super.onResume();
    if (this.EKb != null) {
      this.EKb.onNotifyChange("", null);
    }
    AppMethodBeat.o(99212);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(99215);
    Log.i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.EKb != null) {
      this.EKb.onNotifyChange("", null);
    }
    AppMethodBeat.o(99215);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends com.tencent.mm.ui.s<com.tencent.mm.plugin.sns.storage.s>
  {
    public boolean EKf;
    private Context context;
    
    public a(Context paramContext)
    {
      super(new com.tencent.mm.plugin.sns.storage.s());
      AppMethodBeat.i(99204);
      this.EKf = false;
      this.context = paramContext;
      AppMethodBeat.o(99204);
    }
    
    public final void anp()
    {
      AppMethodBeat.i(99206);
      setCursor(aj.faU().getCursor());
      notifyDataSetChanged();
      AppMethodBeat.o(99206);
    }
    
    public final void anq()
    {
      AppMethodBeat.i(99207);
      ebf();
      anp();
      AppMethodBeat.o(99207);
    }
    
    public final int dWu()
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
        paramView = View.inflate(this.context, 2131495897, null);
        paramViewGroup.EKg = ((TextView)paramView.findViewById(2131308872));
        paramViewGroup.EKh = ((TextView)paramView.findViewById(2131308231));
        paramViewGroup.kjo = ((Button)paramView.findViewById(2131299448));
        paramView.setTag(paramViewGroup);
        if (Ox(paramInt)) {
          break label229;
        }
        Object localObject = (com.tencent.mm.plugin.sns.storage.s)getItem(paramInt);
        paramViewGroup.EKg.setText(((com.tencent.mm.plugin.sns.storage.s)localObject).field_tagName);
        paramViewGroup.EKh.setVisibility(0);
        paramViewGroup.EKh.setText(" (" + ((com.tencent.mm.plugin.sns.storage.s)localObject).field_count + ") ");
        localObject = paramViewGroup.kjo;
        if (!this.EKf) {
          break label222;
        }
        i = 0;
        label172:
        ((Button)localObject).setVisibility(i);
        paramViewGroup.kjo.setOnClickListener(SnsTagPartlyUI.b(SnsTagPartlyUI.this));
        paramViewGroup.kjo.setTag(Integer.valueOf(paramInt));
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
        paramViewGroup.EKg.setText(2131766603);
        paramViewGroup.EKh.setVisibility(8);
        paramViewGroup.kjo.setVisibility(8);
      }
    }
    
    final class a
    {
      TextView EKg;
      TextView EKh;
      Button kjo;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI
 * JD-Core Version:    0.7.0.1
 */