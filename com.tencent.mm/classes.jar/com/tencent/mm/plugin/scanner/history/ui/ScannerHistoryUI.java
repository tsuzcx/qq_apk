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
import com.tencent.mm.av.o;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.util.k.a;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.r;

public class ScannerHistoryUI
  extends MMActivity
{
  private View EP;
  private ListView mListView;
  private LinearLayout ogk;
  private View ogl;
  private TextView ogm;
  private a wYm;
  
  private void bQT()
  {
    AppMethodBeat.i(51604);
    if (i.dza().dzb().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.EP.setVisibility(8);
      this.ogl.setVisibility(0);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.wYm.notifyDataSetChanged();
      AppMethodBeat.o(51604);
      return;
      this.mListView.setVisibility(8);
      this.EP.setVisibility(0);
      this.ogl.setVisibility(8);
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
    this.ogk = ((LinearLayout)View.inflate(getBaseContext(), 2131495294, null));
    this.mListView.addHeaderView(this.ogk);
    this.wYm = new a();
    this.mListView.setAdapter(this.wYm);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(51589);
        if (paramAnonymousInt == 0)
        {
          ac.v("MicroMsg.ScannerHistoryUI", "onItemClick pos is 0, click headerview");
          AppMethodBeat.o(51589);
          return;
        }
        int i = paramAnonymousInt;
        if (paramAnonymousInt > 0) {
          i = paramAnonymousInt - 1;
        }
        ScannerHistoryUI.a(ScannerHistoryUI.this, i);
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
          ac.i("MicroMsg.ScannerHistoryUI", "onItemLongClick pos is 0");
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
    this.EP = findViewById(2131298768);
    this.ogl = View.inflate(this, 2131495293, null);
    if (this.ogk != null) {
      this.ogk.addView(this.ogl);
    }
    this.ogm = ((TextView)this.ogl.findViewById(2131300753));
    this.ogm.setText(2131760246);
    bQT();
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
      wy(true);
      AppMethodBeat.o(51595);
    }
    
    public final void Xb()
    {
      AppMethodBeat.i(51596);
      setCursor(i.dza().dzb().getAll());
      notifyDataSetChanged();
      AppMethodBeat.o(51596);
    }
    
    public final void Xc()
    {
      AppMethodBeat.i(51597);
      cVi();
      Xb();
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
        paramViewGroup.ig = ((ImageView)paramView.findViewById(2131301154));
        paramViewGroup.ofO = ((TextView)paramView.findViewById(2131301198));
        paramViewGroup.ofP = ((TextView)paramView.findViewById(2131301196));
        paramViewGroup.ofQ = ((TextView)paramView.findViewById(2131301149));
        paramView.setTag(paramViewGroup);
        k.a locala = m.ev(((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_xmlContent, ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_funcType);
        paramViewGroup.ofO.setText(locala.field_title);
        long l = ((com.tencent.mm.plugin.scanner.history.a.a)localObject).field_ScanTime;
        paramViewGroup.ofP.setText(h.c(ScannerHistoryUI.this, l, true));
        paramViewGroup.ofQ.setText(locala.field_subtitle);
        int i = ScannerHistoryUI.this.getResources().getDimensionPixelSize(2131166766);
        paramViewGroup.ig.setImageResource(2131233613);
        ac.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + paramInt + " logo_url :  " + locala.field_thumburl);
        if (TextUtils.isEmpty(locala.field_thumburl)) {
          break label423;
        }
        c.a locala1 = new c.a();
        locala1.prefixPath = b.aph();
        o.aFC();
        locala1.hKO = null;
        localObject = i.dza();
        String str = locala.field_thumburl;
        if (!com.tencent.mm.kernel.g.agM()) {
          break label415;
        }
        localObject = String.format("%s/scanbook_%s", new Object[] { ((i)localObject).ghC + "image/scan/img", com.tencent.mm.b.g.getMessageDigest(str.getBytes()) });
        label327:
        locala1.gKe = ((String)localObject);
        locala1.hKx = true;
        locala1.gLt = false;
        locala1.hKv = true;
        locala1.gKh = i;
        locala1.gKg = i;
        locala1.hKI = 2131233613;
        localObject = locala1.aFT();
        o.aFB().a(locala.field_thumburl, paramViewGroup.ig, (c)localObject);
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
        paramViewGroup.ig.setImageResource(2131233613);
      }
    }
  }
  
  final class b
  {
    ImageView ig;
    TextView ofO;
    TextView ofP;
    TextView ofQ;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI
 * JD-Core Version:    0.7.0.1
 */