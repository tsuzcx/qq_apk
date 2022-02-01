package com.tencent.mm.plugin.readerapp.ui;

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
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.a.f;
import com.tencent.mm.plugin.readerapp.a.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.dqf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public class ReaderAppSubscribeUI
  extends MMActivity
{
  private ListView NvS;
  private a NvT;
  
  private void agi(int paramInt)
  {
    AppMethodBeat.i(102714);
    h.baE().ban().B(868518889, Integer.valueOf(paramInt));
    Object localObject = new dqf();
    ((dqf)localObject).aaWB = paramInt;
    ((n)h.ax(n.class)).bzz().d(new k.a(43, (com.tencent.mm.bx.a)localObject));
    localObject = new Intent();
    ((Intent)localObject).putExtra("Contact_User", "newsapp");
    ((Intent)localObject).addFlags(67108864);
    com.tencent.mm.plugin.readerapp.b.a.pFn.c((Intent)localObject, this);
    finish();
    AppMethodBeat.o(102714);
  }
  
  public int getLayoutId()
  {
    return a.f.Nvx;
  }
  
  public void initView()
  {
    AppMethodBeat.i(102712);
    this.NvT = new a(this, Util.nullAsNil((Integer)h.baE().ban().d(868518889, null)));
    this.NvS = ((ListView)findViewById(a.e.Nvl));
    this.NvS.setAdapter(this.NvT);
    this.NvS.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(102706);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this);
        if ((paramAnonymousAdapterView.NvW & paramAnonymousAdapterView.NvV[paramAnonymousInt]) != 0)
        {
          paramAnonymousAdapterView.NvW &= (paramAnonymousAdapterView.NvV[paramAnonymousInt] ^ 0xFFFFFFFF);
          paramAnonymousAdapterView.NvY -= 1;
          if (paramAnonymousAdapterView.NvY < 0) {
            paramAnonymousAdapterView.NvY = 0;
          }
          paramAnonymousAdapterView.notifyDataSetChanged();
          paramAnonymousInt = 1;
        }
        for (;;)
        {
          if (paramAnonymousInt == 0) {
            k.s(ReaderAppSubscribeUI.this, a.h.Nvz, a.h.app_tip);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(102706);
          return;
          if (paramAnonymousAdapterView.NvY < 3)
          {
            paramAnonymousAdapterView.NvW |= paramAnonymousAdapterView.NvV[paramAnonymousInt];
            paramAnonymousAdapterView.NvY += 1;
            if (paramAnonymousAdapterView.NvY > paramAnonymousAdapterView.NvV.length) {
              paramAnonymousAdapterView.NvY = paramAnonymousAdapterView.NvV.length;
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
    this.NvT.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(102707);
        ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this, ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this).NvW);
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
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        paramAnonymousView = ReaderAppSubscribeUI.b(ReaderAppSubscribeUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
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
    h.baE().ban().B(868518890, "in");
    setMMTitle(a.h.Nvy);
    initView();
    AppMethodBeat.o(102711);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(102713);
    if (paramInt == 4)
    {
      if (this.NvT != null) {
        agi(this.NvT.NvW);
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
    this.NvT.notifyDataSetChanged();
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
    final int[] NvV;
    int NvW;
    private String[] NvX;
    int NvY;
    private final Context context;
    
    public a(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(102709);
      this.NvV = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };
      this.NvX = null;
      this.NvY = 0;
      this.context = paramContext;
      this.NvW = paramInt;
      this.NvX = paramContext.getString(a.h.NvD).split(";");
      this.NvY = agj(paramInt);
      AppMethodBeat.o(102709);
    }
    
    private int agj(int paramInt)
    {
      int j = 0;
      int i = 0;
      if (j < this.NvV.length)
      {
        if ((this.NvV[j] & paramInt) == 0) {
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
      return this.NvX.length;
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
        paramView = View.inflate(this.context, a.f.Nvw, null);
        paramViewGroup.pJJ = ((TextView)paramView.findViewById(a.e.Nvk));
        paramViewGroup.pJL = ((CheckBox)paramView.findViewById(a.e.Nvj));
        paramView.setTag(paramViewGroup);
        paramViewGroup.pJJ.setText(this.NvX[paramInt]);
        paramViewGroup = paramViewGroup.pJL;
        if ((this.NvW & this.NvV[paramInt]) == 0) {
          break label121;
        }
      }
      label121:
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
      TextView pJJ;
      CheckBox pJL;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI
 * JD-Core Version:    0.7.0.1
 */