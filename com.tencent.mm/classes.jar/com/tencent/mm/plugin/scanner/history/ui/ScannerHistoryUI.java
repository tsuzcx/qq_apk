package com.tencent.mm.plugin.scanner.history.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.scanner.model.r;
import com.tencent.mm.plugin.scanner.util.n.a;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.s;

public class ScannerHistoryUI
  extends MMActivity
{
  private a CEv;
  private View GQ;
  private ListView mListView;
  private LinearLayout qdT;
  private View qdU;
  private TextView qdV;
  
  private void cuE()
  {
    AppMethodBeat.i(51604);
    if (j.eOR().eOS().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.GQ.setVisibility(8);
      this.qdU.setVisibility(0);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.CEv.notifyDataSetChanged();
      AppMethodBeat.o(51604);
      return;
      this.mListView.setVisibility(8);
      this.GQ.setVisibility(0);
      this.qdU.setVisibility(8);
      enableOptionMenu(false);
    }
  }
  
  public int getLayoutId()
  {
    return 2131496145;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51603);
    setMMTitle(2131764923);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(51588);
        ScannerHistoryUI.this.finish();
        AppMethodBeat.o(51588);
        return true;
      }
    });
    this.mListView = ((ListView)findViewById(2131307241));
    this.qdT = ((LinearLayout)View.inflate(getBaseContext(), 2131496144, null));
    this.mListView.addHeaderView(this.qdT);
    this.CEv = new a();
    this.mListView.setAdapter(this.CEv);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(51589);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/history/ui/ScannerHistoryUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (paramAnonymousInt == 0)
        {
          Log.v("MicroMsg.ScannerHistoryUI", "onItemClick pos is 0, click headerview");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/history/ui/ScannerHistoryUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(51589);
          return;
        }
        int i = paramAnonymousInt;
        if (paramAnonymousInt > 0) {
          i = paramAnonymousInt - 1;
        }
        ScannerHistoryUI.a(ScannerHistoryUI.this, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/history/ui/ScannerHistoryUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(51589);
      }
    });
    this.mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(51590);
        if (paramAnonymousInt == 0)
        {
          Log.i("MicroMsg.ScannerHistoryUI", "onItemLongClick pos is 0");
          AppMethodBeat.o(51590);
          return true;
        }
        int i = paramAnonymousInt;
        if (paramAnonymousInt > 0) {
          i = paramAnonymousInt - 1;
        }
        if (i >= ScannerHistoryUI.a(ScannerHistoryUI.this).getCount())
        {
          AppMethodBeat.o(51590);
          return true;
        }
        ScannerHistoryUI.b(ScannerHistoryUI.this, i);
        AppMethodBeat.o(51590);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131756973), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(51591);
        ScannerHistoryUI.b(ScannerHistoryUI.this);
        AppMethodBeat.o(51591);
        return true;
      }
    });
    this.GQ = findViewById(2131299212);
    this.qdU = View.inflate(this, 2131496143, null);
    if (this.qdT != null) {
      this.qdT.addView(this.qdU);
    }
    this.qdV = ((TextView)this.qdU.findViewById(2131302341));
    this.qdV.setText(2131761632);
    cuE();
    AppMethodBeat.o(51603);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51600);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(51600);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(51602);
    super.onDestroy();
    AppMethodBeat.o(51602);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(51601);
    super.onResume();
    AppMethodBeat.o(51601);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends s<com.tencent.mm.plugin.scanner.history.a.a>
  {
    public a()
    {
      super(new com.tencent.mm.plugin.scanner.history.a.a());
      AppMethodBeat.i(51595);
      Bh(true);
      AppMethodBeat.o(51595);
    }
    
    public final void anp()
    {
      AppMethodBeat.i(51596);
      setCursor(j.eOR().eOS().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(51596);
    }
    
    public final void anq()
    {
      AppMethodBeat.i(51597);
      ebf();
      anp();
      AppMethodBeat.o(51597);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(51598);
      Object localObject = (com.tencent.mm.plugin.scanner.history.a.a)getItem(paramInt);
      if (paramView == null)
      {
        paramView = View.inflate(ScannerHistoryUI.this.getContext(), 2131496142, null);
        paramViewGroup = new ScannerHistoryUI.b(ScannerHistoryUI.this, (byte)0);
        paramViewGroup.kc = ((ImageView)paramView.findViewById(2131302812));
        paramViewGroup.qdx = ((TextView)paramView.findViewById(2131302870));
        paramViewGroup.qdy = ((TextView)paramView.findViewById(2131302868));
        paramViewGroup.qdz = ((TextView)paramView.findViewById(2131302804));
        paramView.setTag(paramViewGroup);
        n.a locala = r.fn(((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_xmlContent, ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_funcType);
        paramViewGroup.qdx.setText(locala.field_title);
        long l = ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_ScanTime;
        paramViewGroup.qdy.setText(f.c(ScannerHistoryUI.this, l, true));
        paramViewGroup.qdz.setText(locala.field_subtitle);
        int i = ScannerHistoryUI.this.getResources().getDimensionPixelSize(2131166889);
        paramViewGroup.kc.setImageResource(2131234422);
        Log.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + paramInt + " logo_url :  " + locala.field_thumburl);
        if (TextUtils.isEmpty(locala.field_thumburl)) {
          break label423;
        }
        c.a locala1 = new c.a();
        locala1.prefixPath = com.tencent.mm.loader.j.b.aKJ();
        q.bcW();
        locala1.jbw = null;
        localObject = j.eOR();
        String str = locala.field_thumburl;
        if (!com.tencent.mm.kernel.g.aAc()) {
          break label415;
        }
        localObject = String.format("%s/scanbook_%s", new Object[] { ((j)localObject).hqG + "image/scan/img", com.tencent.mm.b.g.getMessageDigest(str.getBytes()) });
        label327:
        locala1.fullPath = ((String)localObject);
        locala1.jbf = true;
        locala1.iaT = false;
        locala1.jbd = true;
        locala1.hZA = i;
        locala1.hZz = i;
        locala1.jbq = 2131234422;
        localObject = locala1.bdv();
        q.bcV().a(locala.field_thumburl, paramViewGroup.kc, (c)localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(51598);
        return paramView;
        paramViewGroup = (ScannerHistoryUI.b)paramView.getTag();
        break;
        label415:
        localObject = "";
        break label327;
        label423:
        paramViewGroup.kc.setImageResource(2131234422);
      }
    }
  }
  
  final class b
  {
    ImageView kc;
    TextView qdx;
    TextView qdy;
    TextView qdz;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI
 * JD-Core Version:    0.7.0.1
 */