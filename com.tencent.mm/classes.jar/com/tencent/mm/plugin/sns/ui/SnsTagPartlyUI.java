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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

public class SnsTagPartlyUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private ListView iWK;
  protected p tipDialog;
  private a yRT;
  private View.OnClickListener yRU;
  
  public SnsTagPartlyUI()
  {
    AppMethodBeat.i(99209);
    this.tipDialog = null;
    this.yRU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99203);
        if (SnsTagPartlyUI.a(SnsTagPartlyUI.this) == null)
        {
          ac.e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
          AppMethodBeat.o(99203);
          return;
        }
        paramAnonymousView = paramAnonymousView.getTag();
        if (paramAnonymousView == null)
        {
          ac.e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
          AppMethodBeat.o(99203);
          return;
        }
        if (!(paramAnonymousView instanceof Integer))
        {
          ac.e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
          AppMethodBeat.o(99203);
          return;
        }
        paramAnonymousView = (v)SnsTagPartlyUI.a(SnsTagPartlyUI.this).getItem(((Integer)paramAnonymousView).intValue());
        SnsTagPartlyUI.this.tipDialog = h.b(SnsTagPartlyUI.this, null, true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface) {}
        });
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.plugin.sns.model.w(paramAnonymousView.field_tagId, paramAnonymousView.field_tagName), 0);
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
    this.iWK = ((ListView)findViewById(2131305081));
    this.iWK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(99200);
        if (paramAnonymousInt < SnsTagPartlyUI.a(SnsTagPartlyUI.this).getCount() - 1)
        {
          paramAnonymousAdapterView = new Intent();
          paramAnonymousView = (v)SnsTagPartlyUI.a(SnsTagPartlyUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousView == null)
          {
            AppMethodBeat.o(99200);
            return;
          }
          paramAnonymousAdapterView.putExtra("k_sns_tag_id", paramAnonymousView.field_tagId);
          paramAnonymousAdapterView.setClass(SnsTagPartlyUI.this, SnsTagDetailUI.class);
          paramAnonymousView = SnsTagPartlyUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.aeD(), "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(99200);
          return;
        }
        paramAnonymousAdapterView = new Intent();
        paramAnonymousView = com.tencent.mm.model.u.axw();
        paramAnonymousAdapterView.putExtra("titile", SnsTagPartlyUI.this.getString(2131755229));
        paramAnonymousAdapterView.putExtra("list_type", 1);
        paramAnonymousAdapterView.putExtra("KBlockOpenImFav", true);
        paramAnonymousAdapterView.putExtra("list_attr", com.tencent.mm.ui.contact.u.jI(com.tencent.mm.ui.contact.u.I(new int[] { com.tencent.mm.ui.contact.u.IwQ, 1024 }), 16777216));
        paramAnonymousAdapterView.putExtra("block_contact", paramAnonymousView);
        d.c(SnsTagPartlyUI.this, ".ui.contact.SelectContactUI", paramAnonymousAdapterView, 1);
        AppMethodBeat.o(99200);
      }
    });
    this.yRT = new a(this);
    View localView = View.inflate(this, 2131495598, null);
    this.iWK.addFooterView(localView);
    this.iWK.setAdapter(this.yRT);
    addTextOptionMenu(0, getString(2131764007), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99201);
        paramAnonymousMenuItem = SnsTagPartlyUI.a(SnsTagPartlyUI.this);
        boolean bool;
        SnsTagPartlyUI localSnsTagPartlyUI;
        if (!SnsTagPartlyUI.a(SnsTagPartlyUI.this).yRX)
        {
          bool = true;
          paramAnonymousMenuItem.yRX = bool;
          localSnsTagPartlyUI = SnsTagPartlyUI.this;
          if (!SnsTagPartlyUI.a(SnsTagPartlyUI.this).yRX) {
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
    this.yRT.a(new r.a()
    {
      public final void aPg()
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
      localIntent.putExtra("k_sns_tag_name", bs.bG(paramIntent, ""));
      localIntent.putExtra("k_sns_tag_list", str);
      localIntent.setClass(this, SnsTagDetailUI.class);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsTagPartlyUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99210);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(292, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(290, this);
    initView();
    AppMethodBeat.o(99210);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99211);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(292, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(290, this);
    if (this.yRT != null) {
      this.yRT.cVi();
    }
    super.onDestroy();
    AppMethodBeat.o(99211);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99212);
    super.onResume();
    if (this.yRT != null) {
      this.yRT.a("", null);
    }
    AppMethodBeat.o(99212);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(99215);
    ac.i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (this.yRT != null) {
      this.yRT.a("", null);
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
    private Context context;
    public boolean yRX;
    
    public a(Context paramContext)
    {
      super(new v());
      AppMethodBeat.i(99204);
      this.yRX = false;
      this.context = paramContext;
      AppMethodBeat.o(99204);
    }
    
    public final void Xb()
    {
      AppMethodBeat.i(99206);
      setCursor(af.dHX().getCursor());
      notifyDataSetChanged();
      AppMethodBeat.o(99206);
    }
    
    public final void Xc()
    {
      AppMethodBeat.i(99207);
      cVi();
      Xb();
      AppMethodBeat.o(99207);
    }
    
    public final int cRx()
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
        paramViewGroup.yRY = ((TextView)paramView.findViewById(2131305630));
        paramViewGroup.yRZ = ((TextView)paramView.findViewById(2131305075));
        paramViewGroup.iPj = ((Button)paramView.findViewById(2131298954));
        paramView.setTag(paramViewGroup);
        if (GF(paramInt)) {
          break label229;
        }
        Object localObject = (v)getItem(paramInt);
        paramViewGroup.yRY.setText(((v)localObject).field_tagName);
        paramViewGroup.yRZ.setVisibility(0);
        paramViewGroup.yRZ.setText(" (" + ((v)localObject).field_count + ") ");
        localObject = paramViewGroup.iPj;
        if (!this.yRX) {
          break label222;
        }
        i = 0;
        label172:
        ((Button)localObject).setVisibility(i);
        paramViewGroup.iPj.setOnClickListener(SnsTagPartlyUI.b(SnsTagPartlyUI.this));
        paramViewGroup.iPj.setTag(Integer.valueOf(paramInt));
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
        paramViewGroup.yRY.setText(2131764344);
        paramViewGroup.yRZ.setVisibility(8);
        paramViewGroup.iPj.setVisibility(8);
      }
    }
    
    final class a
    {
      Button iPj;
      TextView yRY;
      TextView yRZ;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTagPartlyUI
 * JD-Core Version:    0.7.0.1
 */