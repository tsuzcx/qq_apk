package com.tencent.mm.plugin.scanner.history.ui;

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
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.e;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.o;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k.d;

public class ScannerHistoryUI
  extends MMActivity
{
  private a OPL;
  private View bEx;
  private ListView mListView;
  private LinearLayout wEl;
  private View wEm;
  private TextView wEn;
  
  private void dlx()
  {
    AppMethodBeat.i(51604);
    if (o.gPw().gPy().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.bEx.setVisibility(8);
      this.wEm.setVisibility(0);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.OPL.notifyDataSetChanged();
      AppMethodBeat.o(51604);
      return;
      this.mListView.setVisibility(8);
      this.bEx.setVisibility(0);
      this.wEm.setVisibility(8);
      enableOptionMenu(false);
    }
  }
  
  public int getLayoutId()
  {
    return l.g.OKy;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51603);
    setMMTitle(l.i.OLa);
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
    this.mListView = ((ListView)findViewById(l.f.OJm));
    this.wEl = ((LinearLayout)View.inflate(getBaseContext(), l.g.OKx, null));
    this.mListView.addHeaderView(this.wEl);
    this.OPL = new a();
    this.mListView.setAdapter(this.OPL);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(51589);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/history/ui/ScannerHistoryUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
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
    addTextOptionMenu(0, getString(l.i.card_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(51591);
        ScannerHistoryUI.b(ScannerHistoryUI.this);
        AppMethodBeat.o(51591);
        return true;
      }
    });
    this.bEx = findViewById(l.f.wjH);
    this.wEm = View.inflate(this, l.g.OKw, null);
    if (this.wEl != null) {
      this.wEl.addView(this.wEm);
    }
    this.wEn = ((TextView)this.wEm.findViewById(l.f.OIK));
    this.wEn.setText(l.i.OKF);
    dlx();
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
    extends com.tencent.mm.ui.x<com.tencent.mm.plugin.scanner.history.a.a>
  {
    public a()
    {
      super(new com.tencent.mm.plugin.scanner.history.a.a());
      AppMethodBeat.i(51595);
      Lh(true);
      AppMethodBeat.o(51595);
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(51596);
      w(o.gPw().gPy().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(51596);
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(51597);
      fSd();
      aNy();
      AppMethodBeat.o(51597);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(51598);
      Object localObject = (com.tencent.mm.plugin.scanner.history.a.a)getItem(paramInt);
      if (paramView == null)
      {
        paramView = View.inflate(ScannerHistoryUI.this.getContext(), l.g.OKv, null);
        paramViewGroup = new ScannerHistoryUI.b(ScannerHistoryUI.this, (byte)0);
        paramViewGroup.dpM = ((ImageView)paramView.findViewById(l.f.item_icon));
        paramViewGroup.wDQ = ((TextView)paramView.findViewById(l.f.item_title));
        paramViewGroup.wDR = ((TextView)paramView.findViewById(l.f.fLK));
        paramViewGroup.wDS = ((TextView)paramView.findViewById(l.f.item_desc));
        paramView.setTag(paramViewGroup);
        q.a locala = com.tencent.mm.plugin.scanner.model.x.gI(((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_xmlContent, ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_funcType);
        paramViewGroup.wDQ.setText(locala.field_title);
        long l = ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_ScanTime;
        paramViewGroup.wDR.setText(f.d(ScannerHistoryUI.this, l, true));
        paramViewGroup.wDS.setText(locala.field_subtitle);
        int i = ScannerHistoryUI.this.getResources().getDimensionPixelSize(l.d.OIh);
        paramViewGroup.dpM.setImageResource(l.e.pic_thumb_bg);
        Log.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + paramInt + " logo_url :  " + locala.field_thumburl);
        if (TextUtils.isEmpty(locala.field_thumburl)) {
          break label431;
        }
        c.a locala1 = new c.a();
        locala1.prefixPath = com.tencent.mm.loader.i.b.bmz();
        locala1.oKH = r.bKf();
        localObject = o.gPw();
        String str = locala.field_thumburl;
        if (!h.baz()) {
          break label423;
        }
        localObject = String.format("%s/scanbook_%s", new Object[] { ((o)localObject).mCJ + "image/scan/img", g.getMessageDigest(str.getBytes()) });
        label334:
        locala1.fullPath = ((String)localObject);
        locala1.oKp = true;
        locala1.nrc = false;
        locala1.oKn = true;
        locala1.npV = i;
        locala1.npU = i;
        locala1.oKB = l.e.pic_thumb_bg;
        localObject = locala1.bKx();
        r.bKe().a(locala.field_thumburl, paramViewGroup.dpM, (c)localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(51598);
        return paramView;
        paramViewGroup = (ScannerHistoryUI.b)paramView.getTag();
        break;
        label423:
        localObject = "";
        break label334;
        label431:
        paramViewGroup.dpM.setImageResource(l.e.pic_thumb_bg);
      }
    }
  }
  
  final class b
  {
    ImageView dpM;
    TextView wDQ;
    TextView wDR;
    TextView wDS;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI
 * JD-Core Version:    0.7.0.1
 */