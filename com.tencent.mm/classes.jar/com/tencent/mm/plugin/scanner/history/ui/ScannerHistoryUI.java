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
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.e;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.p;
import com.tencent.mm.plugin.scanner.o;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.v;

public class ScannerHistoryUI
  extends MMActivity
{
  private a IIX;
  private View Xd;
  private ListView mListView;
  private LinearLayout tzQ;
  private View tzR;
  private TextView tzS;
  
  private void cIg()
  {
    AppMethodBeat.i(51604);
    if (o.fBS().fBU().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.Xd.setVisibility(8);
      this.tzR.setVisibility(0);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.IIX.notifyDataSetChanged();
      AppMethodBeat.o(51604);
      return;
      this.mListView.setVisibility(8);
      this.Xd.setVisibility(0);
      this.tzR.setVisibility(8);
      enableOptionMenu(false);
    }
  }
  
  public int getLayoutId()
  {
    return l.g.IEv;
  }
  
  public void initView()
  {
    AppMethodBeat.i(51603);
    setMMTitle(l.i.IET);
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
    this.mListView = ((ListView)findViewById(l.f.IDl));
    this.tzQ = ((LinearLayout)View.inflate(getBaseContext(), l.g.IEu, null));
    this.mListView.addHeaderView(this.tzQ);
    this.IIX = new a();
    this.mListView.setAdapter(this.IIX);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(51589);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/history/ui/ScannerHistoryUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
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
    this.Xd = findViewById(l.f.tfq);
    this.tzR = View.inflate(this, l.g.IEt, null);
    if (this.tzQ != null) {
      this.tzQ.addView(this.tzR);
    }
    this.tzS = ((TextView)this.tzR.findViewById(l.f.ICJ));
    this.tzS.setText(l.i.IEC);
    cIg();
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
    extends v<com.tencent.mm.plugin.scanner.history.a.a>
  {
    public a()
    {
      super(new com.tencent.mm.plugin.scanner.history.a.a());
      AppMethodBeat.i(51595);
      Fx(true);
      AppMethodBeat.o(51595);
    }
    
    public final void atr()
    {
      AppMethodBeat.i(51596);
      v(o.fBS().fBU().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(51596);
    }
    
    public final void ats()
    {
      AppMethodBeat.i(51597);
      eKd();
      atr();
      AppMethodBeat.o(51597);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(51598);
      Object localObject = (com.tencent.mm.plugin.scanner.history.a.a)getItem(paramInt);
      if (paramView == null)
      {
        paramView = View.inflate(ScannerHistoryUI.this.getContext(), l.g.IEs, null);
        paramViewGroup = new ScannerHistoryUI.b(ScannerHistoryUI.this, (byte)0);
        paramViewGroup.bwJ = ((ImageView)paramView.findViewById(l.f.item_icon));
        paramViewGroup.tzu = ((TextView)paramView.findViewById(l.f.item_title));
        paramViewGroup.tzv = ((TextView)paramView.findViewById(l.f.dKp));
        paramViewGroup.tzw = ((TextView)paramView.findViewById(l.f.item_desc));
        paramView.setTag(paramViewGroup);
        o.a locala = p.fP(((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_xmlContent, ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_funcType);
        paramViewGroup.tzu.setText(locala.field_title);
        long l = ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_ScanTime;
        paramViewGroup.tzv.setText(f.d(ScannerHistoryUI.this, l, true));
        paramViewGroup.tzw.setText(locala.field_subtitle);
        int i = ScannerHistoryUI.this.getResources().getDimensionPixelSize(l.d.ICf);
        paramViewGroup.bwJ.setImageResource(l.e.pic_thumb_bg);
        Log.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + paramInt + " logo_url :  " + locala.field_thumburl);
        if (TextUtils.isEmpty(locala.field_thumburl)) {
          break label433;
        }
        c.a locala1 = new c.a();
        locala1.prefixPath = com.tencent.mm.loader.j.b.aSL();
        q.bmm();
        locala1.lRV = null;
        localObject = o.fBS();
        String str = locala.field_thumburl;
        if (!h.aHB()) {
          break label425;
        }
        localObject = String.format("%s/scanbook_%s", new Object[] { ((o)localObject).kcB + "image/scan/img", g.getMessageDigest(str.getBytes()) });
        label336:
        locala1.fullPath = ((String)localObject);
        locala1.lRD = true;
        locala1.kPz = false;
        locala1.lRB = true;
        locala1.kOg = i;
        locala1.kOf = i;
        locala1.lRP = l.e.pic_thumb_bg;
        localObject = locala1.bmL();
        q.bml().a(locala.field_thumburl, paramViewGroup.bwJ, (c)localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(51598);
        return paramView;
        paramViewGroup = (ScannerHistoryUI.b)paramView.getTag();
        break;
        label425:
        localObject = "";
        break label336;
        label433:
        paramViewGroup.bwJ.setImageResource(l.e.pic_thumb_bg);
      }
    }
  }
  
  final class b
  {
    ImageView bwJ;
    TextView tzu;
    TextView tzv;
    TextView tzw;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI
 * JD-Core Version:    0.7.0.1
 */