package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.c.k;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public class SnsTagContactListUI
  extends MMActivity
{
  private ListView JVY;
  private SnsTagContactListUI.a afiS;
  private List<Long> afiT;
  
  public SnsTagContactListUI()
  {
    AppMethodBeat.i(38084);
    this.afiT = new ArrayList();
    AppMethodBeat.o(38084);
  }
  
  public int getLayoutId()
  {
    return R.i.address;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38086);
    setMMTitle(R.l.sns_tag_see);
    findViewById(R.h.loading_tips_area).setVisibility(8);
    this.JVY = ((ListView)findViewById(R.h.address_contactlist));
    long[] arrayOfLong = getIntent().getLongArrayExtra("sns_tag_list");
    if (arrayOfLong == null)
    {
      finish();
      AppMethodBeat.o(38086);
      return;
    }
    int i = 0;
    while (i < arrayOfLong.length)
    {
      this.afiT.add(Long.valueOf(arrayOfLong[i]));
      i += 1;
    }
    ((TextView)findViewById(R.h.fGB)).setVisibility(8);
    findViewById(R.h.fqN).setVisibility(8);
    this.JVY.setBackgroundColor(getResources().getColor(R.e.white));
    ((View)this.JVY.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
    this.afiS = new SnsTagContactListUI.a(this, this.afiT);
    this.JVY.setAdapter(this.afiS);
    this.JVY.setVisibility(0);
    this.JVY.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38077);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousAdapterView);
        ((b)localObject).cH(paramAnonymousView);
        ((b)localObject).sc(paramAnonymousInt);
        ((b)localObject).hB(paramAnonymousLong);
        a.c("com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
        paramAnonymousAdapterView = new Intent();
        paramAnonymousView = (d)SnsTagContactListUI.a(SnsTagContactListUI.this).getItem(paramAnonymousInt);
        localObject = q.Qkn;
        if (localObject == null)
        {
          SnsTagContactListUI.this.finish();
          a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38077);
          return;
        }
        paramAnonymousAdapterView = ((k)localObject).h(paramAnonymousAdapterView, paramAnonymousView.field_username);
        if (paramAnonymousAdapterView == null)
        {
          SnsTagContactListUI.this.finish();
          a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38077);
          return;
        }
        paramAnonymousAdapterView.putExtra("sns_adapter_type", 1);
        c.b(SnsTagContactListUI.this.getContext(), "sns", ".ui.SnsTimeLineUserPagerUI", paramAnonymousAdapterView);
        a.a(this, "com/tencent/mm/ui/contact/SnsTagContactListUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(38077);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38078);
        SnsTagContactListUI.this.finish();
        AppMethodBeat.o(38078);
        return true;
      }
    });
    showOptionMenu(false);
    AppMethodBeat.o(38086);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38085);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(38085);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38088);
    super.onDestroy();
    AppMethodBeat.o(38088);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38087);
    super.onResume();
    if (this.afiS != null) {
      this.afiS.notifyDataSetChanged();
    }
    AppMethodBeat.o(38087);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsTagContactListUI
 * JD-Core Version:    0.7.0.1
 */