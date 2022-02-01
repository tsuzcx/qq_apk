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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ReaderAppSubscribeUI
  extends MMActivity
{
  private ListView uVP;
  private a uVQ;
  
  private void JT(int paramInt)
  {
    AppMethodBeat.i(102714);
    g.afB().afk().set(868518889, Integer.valueOf(paramInt));
    Object localObject = new brf();
    ((brf)localObject).DPa = paramInt;
    ((k)g.ab(k.class)).apL().c(new j.a(43, (com.tencent.mm.bx.a)localObject));
    localObject = new Intent();
    ((Intent)localObject).putExtra("Contact_User", "newsapp");
    ((Intent)localObject).addFlags(67108864);
    com.tencent.mm.plugin.readerapp.b.a.hYt.c((Intent)localObject, this);
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
    this.uVQ = new a(this, bt.l((Integer)g.afB().afk().get(868518889, null)));
    this.uVP = ((ListView)findViewById(2131303782));
    this.uVP.setAdapter(this.uVQ);
    this.uVP.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        int i = 1;
        AppMethodBeat.i(102706);
        paramAnonymousAdapterView = ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this);
        if ((paramAnonymousAdapterView.uVT & paramAnonymousAdapterView.uVS[paramAnonymousInt]) != 0)
        {
          paramAnonymousAdapterView.uVT &= (paramAnonymousAdapterView.uVS[paramAnonymousInt] ^ 0xFFFFFFFF);
          paramAnonymousAdapterView.uVV -= 1;
          if (paramAnonymousAdapterView.uVV < 0) {
            paramAnonymousAdapterView.uVV = 0;
          }
          paramAnonymousAdapterView.notifyDataSetChanged();
          paramAnonymousInt = i;
        }
        for (;;)
        {
          if (paramAnonymousInt == 0) {
            h.j(ReaderAppSubscribeUI.this, 2131757781, 2131755906);
          }
          AppMethodBeat.o(102706);
          return;
          if (paramAnonymousAdapterView.uVV < 3)
          {
            paramAnonymousAdapterView.uVT |= paramAnonymousAdapterView.uVS[paramAnonymousInt];
            paramAnonymousAdapterView.uVV += 1;
            if (paramAnonymousAdapterView.uVV > paramAnonymousAdapterView.uVS.length) {
              paramAnonymousAdapterView.uVV = paramAnonymousAdapterView.uVS.length;
            }
            paramAnonymousAdapterView.notifyDataSetChanged();
            paramAnonymousInt = i;
          }
          else
          {
            paramAnonymousInt = 0;
          }
        }
      }
    });
    this.uVQ.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(102707);
        ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this, ReaderAppSubscribeUI.a(ReaderAppSubscribeUI.this).uVT);
        AppMethodBeat.o(102707);
        return true;
      }
    });
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(102708);
        paramAnonymousView = ReaderAppSubscribeUI.b(ReaderAppSubscribeUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/readerapp/ui/ReaderAppSubscribeUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        AppMethodBeat.o(102708);
      }
    });
    AppMethodBeat.o(102712);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(102711);
    super.onCreate(paramBundle);
    g.afB().afk().set(868518890, "in");
    setMMTitle(2131757780);
    initView();
    AppMethodBeat.o(102711);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(102713);
    if (paramInt == 4)
    {
      if (this.uVQ != null) {
        JT(this.uVQ.uVT);
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
    this.uVQ.notifyDataSetChanged();
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
    final int[] uVS;
    int uVT;
    private String[] uVU;
    int uVV;
    
    public a(Context paramContext, int paramInt)
    {
      AppMethodBeat.i(102709);
      this.uVS = new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 };
      this.uVU = null;
      this.uVV = 0;
      this.context = paramContext;
      this.uVT = paramInt;
      this.uVU = paramContext.getString(2131762184).split(";");
      this.uVV = JU(paramInt);
      AppMethodBeat.o(102709);
    }
    
    private int JU(int paramInt)
    {
      int j = 0;
      int i = 0;
      if (j < this.uVS.length)
      {
        if ((this.uVS[j] & paramInt) == 0) {
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
      return this.uVU.length;
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
        paramViewGroup.ica = ((TextView)paramView.findViewById(2131303781));
        paramViewGroup.icb = ((CheckBox)paramView.findViewById(2131303780));
        paramView.setTag(paramViewGroup);
        paramViewGroup.ica.setText(this.uVU[paramInt]);
        paramViewGroup = paramViewGroup.icb;
        if ((this.uVT & this.uVS[paramInt]) == 0) {
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
      TextView ica;
      CheckBox icb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI
 * JD-Core Version:    0.7.0.1
 */