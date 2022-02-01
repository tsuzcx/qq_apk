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
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.r;

public class ScannerHistoryUI
  extends MMActivity
{
  private View GG;
  private ListView mListView;
  private LinearLayout oQf;
  private View oQg;
  private TextView oQh;
  private a yBU;
  
  private void bWN()
  {
    AppMethodBeat.i(51604);
    if (j.dNQ().dNR().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.GG.setVisibility(8);
      this.oQg.setVisibility(0);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.yBU.notifyDataSetChanged();
      AppMethodBeat.o(51604);
      return;
      this.mListView.setVisibility(8);
      this.GG.setVisibility(0);
      this.oQg.setVisibility(8);
      enableOptionMenu(false);
    }
  }
  
  public int getLayoutId()
  {
    return 2131495295;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51603);
    setMMTitle(2131762825);
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
    this.mListView = ((ListView)findViewById(2131304313));
    this.oQf = ((LinearLayout)View.inflate(getBaseContext(), 2131495294, null));
    this.mListView.addHeaderView(this.oQf);
    this.yBU = new a();
    this.mListView.setAdapter(this.yBU);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(51589);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/history/ui/ScannerHistoryUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        if (paramAnonymousInt == 0)
        {
          ae.v("MicroMsg.ScannerHistoryUI", "onItemClick pos is 0, click headerview");
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
          ae.i("MicroMsg.ScannerHistoryUI", "onItemLongClick pos is 0");
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
    addTextOptionMenu(0, getString(2131756808), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(51591);
        ScannerHistoryUI.b(ScannerHistoryUI.this);
        AppMethodBeat.o(51591);
        return true;
      }
    });
    this.GG = findViewById(2131298768);
    this.oQg = View.inflate(this, 2131495293, null);
    if (this.oQf != null) {
      this.oQf.addView(this.oQg);
    }
    this.oQh = ((TextView)this.oQg.findViewById(2131300753));
    this.oQh.setText(2131760246);
    bWN();
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
    extends r<com.tencent.mm.plugin.scanner.history.a.a>
  {
    public a()
    {
      super(new com.tencent.mm.plugin.scanner.history.a.a());
      AppMethodBeat.i(51595);
      xs(true);
      AppMethodBeat.o(51595);
    }
    
    public final void ZD()
    {
      AppMethodBeat.i(51596);
      setCursor(j.dNQ().dNR().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(51596);
    }
    
    public final void ZE()
    {
      AppMethodBeat.i(51597);
      dhl();
      ZD();
      AppMethodBeat.o(51597);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(51598);
      Object localObject = (com.tencent.mm.plugin.scanner.history.a.a)getItem(paramInt);
      if (paramView == null)
      {
        paramView = View.inflate(ScannerHistoryUI.this.getContext(), 2131495292, null);
        paramViewGroup = new ScannerHistoryUI.b(ScannerHistoryUI.this, (byte)0);
        paramViewGroup.ka = ((ImageView)paramView.findViewById(2131301154));
        paramViewGroup.oPJ = ((TextView)paramView.findViewById(2131301198));
        paramViewGroup.oPK = ((TextView)paramView.findViewById(2131301196));
        paramViewGroup.oPL = ((TextView)paramView.findViewById(2131301149));
        paramView.setTag(paramViewGroup);
        k.a locala = p.eV(((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_xmlContent, ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_funcType);
        paramViewGroup.oPJ.setText(locala.field_title);
        long l = ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_ScanTime;
        paramViewGroup.oPK.setText(i.c(ScannerHistoryUI.this, l, true));
        paramViewGroup.oPL.setText(locala.field_subtitle);
        int i = ScannerHistoryUI.this.getResources().getDimensionPixelSize(2131166766);
        paramViewGroup.ka.setImageResource(2131233613);
        ae.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + paramInt + " logo_url :  " + locala.field_thumburl);
        if (TextUtils.isEmpty(locala.field_thumburl)) {
          break label423;
        }
        c.a locala1 = new c.a();
        locala1.prefixPath = com.tencent.mm.loader.j.b.asj();
        q.aJc();
        locala1.igB = null;
        localObject = j.dNQ();
        String str = locala.field_thumburl;
        if (!com.tencent.mm.kernel.g.ajM()) {
          break label415;
        }
        localObject = String.format("%s/scanbook_%s", new Object[] { ((j)localObject).gDT + "image/scan/img", com.tencent.mm.b.g.getMessageDigest(str.getBytes()) });
        label327:
        locala1.hgD = ((String)localObject);
        locala1.igk = true;
        locala1.hhW = false;
        locala1.igi = true;
        locala1.hgG = i;
        locala1.hgF = i;
        locala1.igv = 2131233613;
        localObject = locala1.aJu();
        q.aJb().a(locala.field_thumburl, paramViewGroup.ka, (c)localObject);
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
        paramViewGroup.ka.setImageResource(2131233613);
      }
    }
  }
  
  final class b
  {
    ImageView ka;
    TextView oPJ;
    TextView oPK;
    TextView oPL;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI
 * JD-Core Version:    0.7.0.1
 */