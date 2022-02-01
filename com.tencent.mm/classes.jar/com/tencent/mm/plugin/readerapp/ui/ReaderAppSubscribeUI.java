package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ReaderAppSubscribeUI
  extends MMActivity
{
  private ListView xCk;
  private a xCl;
  
  private void NX(int paramInt)
  {
    AppMethodBeat.i(102714);
    g.ajR().ajA().set(868518889, Integer.valueOf(paramInt));
    Object localObject = new cbg();
    ((cbg)localObject).HoB = paramInt;
    ((l)g.ab(l.class)).azE().d(new k.a(43, (com.tencent.mm.bw.a)localObject));
    localObject = new Intent();
    ((Intent)localObject).putExtra("Contact_User", "newsapp");
    ((Intent)localObject).addFlags(67108864);
    com.tencent.mm.plugin.readerapp.b.a.iUz.c((Intent)localObject, this);
    finish();
    AppMethodBeat.o(102714);
  }
  
  public int getLayoutId()
  {
    return 2131495194;
  }
  
  public void initView()
  {
    AppMethodBeat.i(102712);
    this.xCl = new a(this, bu.o((Integer)g.ajR().ajA().get(868518889, null)));
    this.xCk = ((ListView)findViewById(2131303782));
    this.xCk.setAdapter(this.xCl);
    this.xCk.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(102706);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this);
        if ((paramAnonymousAdapterView.xCo & paramAnonymousAdapterView.xCn[paramAnonymousInt]) != 0)
        {
          paramAnonymousAdapterView.xCo &= (paramAnonymousAdapterView.xCn[paramAnonymousInt] ^ 0xFFFFFFFF);
          paramAnonymousAdapterView.xCq -= 1;
          if (paramAnonymousAdapterView.xCq < 0) {
            paramAnonymousAdapterView.xCq = 0;
          }
          paramAnonymousAdapterView.notifyDataSetChanged();
          paramAnonymousInt = 1;
        }
        for (;;)
        {
          if (paramAnonymousInt == 0) {
            h.l(ReaderAppSubscribeUI.this, 2131757781, 2131755906);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(102706);
          return;
          if (paramAnonymousAdapterView.xCq < 3)
          {
            paramAnonymousAdapterView.xCo |= paramAnonymousAdapterView.xCn[paramAnonymousInt];
            paramAnonymousAdapterView.xCq += 1;
            if (paramAnonymousAdapterView.xCq > paramAnonymousAdapterView.xCn.length) {
              paramAnonymousAdapterView.xCq = paramAnonymousAdapterView.xCn.length;
            }
            paramAnonymousAdapterView.notifyDataSetChanged();
            paramAnonymousInt = 1;
          }
          else
          {
            paramAnonymousInt = 0;
          }
        }
      }
    });
    this.xCl.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(102707);
        ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this, ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this).xCo);
        AppMethodBeat.o(102707);
        return true;
      }
    });
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(102708);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramAnonymousView = ReaderAppSubscribeUI.b(ReaderAppSubscribeUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(102708);
      }
    });
    AppMethodBeat.o(102712);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102711);
    super.onCreate(paramBundle);
    g.ajR().ajA().set(868518890, "in");
    setMMTitle(2131757780);
    initView();
    AppMethodBeat.o(102711);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(102713);
    if (paramInt == 4)
    {
      if (this.xCl != null) {
        NX(this.xCl.xCo);
      }
      AppMethodBeat.o(102713);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(102713);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(102715);
    super.onResume();
    this.xCl.notifyDataSetChanged();
    AppMethodBeat.o(102715);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    private final Context context;
    final int[] xCn;
    int xCo;
    private String[] xCp;
    int xCq;
    
    public a(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(102709);
      this.xCn = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };
      this.xCp = null;
      this.xCq = 0;
      this.context = paramContext;
      this.xCo = paramInt;
      this.xCp = paramContext.getString(2131762184).split(";");
      this.xCq = NY(paramInt);
      AppMethodBeat.o(102709);
    }
    
    private int NY(int paramInt)
    {
      int j = 0;
      int i = 0;
      if (j < this.xCn.length)
      {
        if ((this.xCn[j] & paramInt) == 0) {
          break label37;
        }
        i += 1;
      }
      label37:
      for (;;)
      {
        j += 1;
        break;
        return i;
      }
    }
    
    public final int getCount()
    {
      return this.xCp.length;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102710);
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131495193, null);
        paramViewGroup.iYj = ((TextView)paramView.findViewById(2131303781));
        paramViewGroup.iYl = ((CheckBox)paramView.findViewById(2131303780));
        paramView.setTag(paramViewGroup);
        paramViewGroup.iYj.setText(this.xCp[paramInt]);
        paramViewGroup = paramViewGroup.iYl;
        if ((this.xCo & this.xCn[paramInt]) == 0) {
          break label118;
        }
      }
      label118:
      for (boolean bool = true;; bool = false)
      {
        paramViewGroup.setChecked(bool);
        AppMethodBeat.o(102710);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
      }
    }
    
    static final class a
    {
      TextView iYj;
      CheckBox iYl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI
 * JD-Core Version:    0.7.0.1
 */