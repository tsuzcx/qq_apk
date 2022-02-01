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
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ReaderAppSubscribeUI
  extends MMActivity
{
  private ListView BCj;
  private a BCk;
  
  private void Vm(int paramInt)
  {
    AppMethodBeat.i(102714);
    g.aAh().azQ().set(868518889, Integer.valueOf(paramInt));
    Object localObject = new cqi();
    ((cqi)localObject).MvW = paramInt;
    ((l)g.af(l.class)).aSM().d(new k.a(43, (com.tencent.mm.bw.a)localObject));
    localObject = new Intent();
    ((Intent)localObject).putExtra("Contact_User", "newsapp");
    ((Intent)localObject).addFlags(67108864);
    com.tencent.mm.plugin.readerapp.b.a.jRt.c((Intent)localObject, this);
    finish();
    AppMethodBeat.o(102714);
  }
  
  public int getLayoutId()
  {
    return 2131496037;
  }
  
  public void initView()
  {
    AppMethodBeat.i(102712);
    this.BCk = new a(this, Util.nullAsNil((Integer)g.aAh().azQ().get(868518889, null)));
    this.BCj = ((ListView)findViewById(2131306572));
    this.BCj.setAdapter(this.BCk);
    this.BCj.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(102706);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this);
        if ((paramAnonymousAdapterView.BCn & paramAnonymousAdapterView.BCm[paramAnonymousInt]) != 0)
        {
          paramAnonymousAdapterView.BCn &= (paramAnonymousAdapterView.BCm[paramAnonymousInt] ^ 0xFFFFFFFF);
          paramAnonymousAdapterView.BCp -= 1;
          if (paramAnonymousAdapterView.BCp < 0) {
            paramAnonymousAdapterView.BCp = 0;
          }
          paramAnonymousAdapterView.notifyDataSetChanged();
          paramAnonymousInt = 1;
        }
        for (;;)
        {
          if (paramAnonymousInt == 0) {
            h.n(ReaderAppSubscribeUI.this, 2131758021, 2131755998);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(102706);
          return;
          if (paramAnonymousAdapterView.BCp < 3)
          {
            paramAnonymousAdapterView.BCn |= paramAnonymousAdapterView.BCm[paramAnonymousInt];
            paramAnonymousAdapterView.BCp += 1;
            if (paramAnonymousAdapterView.BCp > paramAnonymousAdapterView.BCm.length) {
              paramAnonymousAdapterView.BCp = paramAnonymousAdapterView.BCm.length;
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
    this.BCk.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(102707);
        ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this, ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this).BCn);
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
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramAnonymousView = ReaderAppSubscribeUI.b(ReaderAppSubscribeUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.pG(0));
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
    g.aAh().azQ().set(868518890, "in");
    setMMTitle(2131758020);
    initView();
    AppMethodBeat.o(102711);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(102713);
    if (paramInt == 4)
    {
      if (this.BCk != null) {
        Vm(this.BCk.BCn);
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
    this.BCk.notifyDataSetChanged();
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
    final int[] BCm;
    int BCn;
    private String[] BCo;
    int BCp;
    private final Context context;
    
    public a(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(102709);
      this.BCm = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };
      this.BCo = null;
      this.BCp = 0;
      this.context = paramContext;
      this.BCn = paramInt;
      this.BCo = paramContext.getString(2131764205).split(";");
      this.BCp = Vn(paramInt);
      AppMethodBeat.o(102709);
    }
    
    private int Vn(int paramInt)
    {
      int j = 0;
      int i = 0;
      if (j < this.BCm.length)
      {
        if ((this.BCm[j] & paramInt) == 0) {
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
      return this.BCo.length;
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
        paramView = View.inflate(this.context, 2131496036, null);
        paramViewGroup.jVO = ((TextView)paramView.findViewById(2131306571));
        paramViewGroup.jVQ = ((CheckBox)paramView.findViewById(2131306570));
        paramView.setTag(paramViewGroup);
        paramViewGroup.jVO.setText(this.BCo[paramInt]);
        paramViewGroup = paramViewGroup.jVQ;
        if ((this.BCn & this.BCm[paramInt]) == 0) {
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
      TextView jVO;
      CheckBox jVQ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI
 * JD-Core Version:    0.7.0.1
 */