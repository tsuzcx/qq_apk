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
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ReaderAppSubscribeUI
  extends MMActivity
{
  private ListView xmn;
  private a xmo;
  
  private void Nr(int paramInt)
  {
    AppMethodBeat.i(102714);
    g.ajC().ajl().set(868518889, Integer.valueOf(paramInt));
    Object localObject = new cam();
    ((cam)localObject).GVa = paramInt;
    ((l)g.ab(l.class)).azo().c(new k.a(43, (com.tencent.mm.bx.a)localObject));
    localObject = new Intent();
    ((Intent)localObject).putExtra("Contact_User", "newsapp");
    ((Intent)localObject).addFlags(67108864);
    com.tencent.mm.plugin.readerapp.b.a.iRG.c((Intent)localObject, this);
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
    this.xmo = new a(this, bt.n((Integer)g.ajC().ajl().get(868518889, null)));
    this.xmn = ((ListView)findViewById(2131303782));
    this.xmn.setAdapter(this.xmo);
    this.xmn.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(102706);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this);
        if ((paramAnonymousAdapterView.xmr & paramAnonymousAdapterView.xmq[paramAnonymousInt]) != 0)
        {
          paramAnonymousAdapterView.xmr &= (paramAnonymousAdapterView.xmq[paramAnonymousInt] ^ 0xFFFFFFFF);
          paramAnonymousAdapterView.xmt -= 1;
          if (paramAnonymousAdapterView.xmt < 0) {
            paramAnonymousAdapterView.xmt = 0;
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
          if (paramAnonymousAdapterView.xmt < 3)
          {
            paramAnonymousAdapterView.xmr |= paramAnonymousAdapterView.xmq[paramAnonymousInt];
            paramAnonymousAdapterView.xmt += 1;
            if (paramAnonymousAdapterView.xmt > paramAnonymousAdapterView.xmq.length) {
              paramAnonymousAdapterView.xmt = paramAnonymousAdapterView.xmq.length;
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
    this.xmo.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(102707);
        ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this, ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this).xmr);
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = ReaderAppSubscribeUI.b(ReaderAppSubscribeUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
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
    g.ajC().ajl().set(868518890, "in");
    setMMTitle(2131757780);
    initView();
    AppMethodBeat.o(102711);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(102713);
    if (paramInt == 4)
    {
      if (this.xmo != null) {
        Nr(this.xmo.xmr);
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
    this.xmo.notifyDataSetChanged();
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
    final int[] xmq;
    int xmr;
    private String[] xms;
    int xmt;
    
    public a(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(102709);
      this.xmq = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };
      this.xms = null;
      this.xmt = 0;
      this.context = paramContext;
      this.xmr = paramInt;
      this.xms = paramContext.getString(2131762184).split(";");
      this.xmt = Ns(paramInt);
      AppMethodBeat.o(102709);
    }
    
    private int Ns(int paramInt)
    {
      int j = 0;
      int i = 0;
      if (j < this.xmq.length)
      {
        if ((this.xmq[j] & paramInt) == 0) {
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
      return this.xms.length;
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
        paramViewGroup.iVq = ((TextView)paramView.findViewById(2131303781));
        paramViewGroup.iVs = ((CheckBox)paramView.findViewById(2131303780));
        paramView.setTag(paramViewGroup);
        paramViewGroup.iVq.setText(this.xms[paramInt]);
        paramViewGroup = paramViewGroup.iVs;
        if ((this.xmr & this.xmq[paramInt]) == 0) {
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
      TextView iVq;
      CheckBox iVs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI
 * JD-Core Version:    0.7.0.1
 */