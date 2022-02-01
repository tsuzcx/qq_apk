package com.tencent.mm.pluginsdk.cmd;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RecoveryConsoleUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  List<b.a> XOc;
  SimpleAdapter XOd;
  ListView bEw;
  List<Map<String, String>> xGG;
  
  public int getLayoutId()
  {
    return c.f.mm_preference_list_content;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(151618);
    super.onCreate(paramBundle);
    setTitle("Recovery Console");
    this.XOc = b.iGM();
    this.xGG = new ArrayList(this.XOc.size());
    paramBundle = this.XOc.iterator();
    while (paramBundle.hasNext())
    {
      b.a locala = (b.a)paramBundle.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("title", getString(locala.tIF));
      this.xGG.add(localHashMap);
    }
    this.XOd = new SimpleAdapter(this, this.xGG, c.f.mm_preference, new String[] { "title" }, new int[] { 16908310 });
    this.bEw = ((ListView)findViewById(16908298));
    this.bEw.setAdapter(this.XOd);
    this.bEw.setOnItemClickListener(this);
    AppMethodBeat.o(151618);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(151619);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/cmd/RecoveryConsoleUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    paramAdapterView = (b.a)this.XOc.get(paramInt);
    if (paramAdapterView.XOh != null) {
      paramAdapterView.XOh.a(this, paramAdapterView.iin.split(" +"), "");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/cmd/RecoveryConsoleUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(151619);
      return;
      b.ac(this, paramAdapterView.iin, "");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.cmd.RecoveryConsoleUI
 * JD-Core Version:    0.7.0.1
 */