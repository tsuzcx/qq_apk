package com.tencent.mm.pluginsdk.cmd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  List<b.a> EJJ;
  SimpleAdapter EJK;
  ListView GF;
  List<Map<String, String>> pAZ;
  
  public int getLayoutId()
  {
    return 2131494873;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(151618);
    super.onCreate(paramBundle);
    setTitle("Recovery Console");
    this.EJJ = b.eZb();
    this.pAZ = new ArrayList(this.EJJ.size());
    paramBundle = this.EJJ.iterator();
    while (paramBundle.hasNext())
    {
      b.a locala = (b.a)paramBundle.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("title", getString(locala.mlW));
      this.pAZ.add(localHashMap);
    }
    this.EJK = new SimpleAdapter(this, this.pAZ, 2131494804, new String[] { "title" }, new int[] { 16908310 });
    this.GF = ((ListView)findViewById(16908298));
    this.GF.setAdapter(this.EJK);
    this.GF.setOnItemClickListener(this);
    AppMethodBeat.o(151618);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(151619);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/cmd/RecoveryConsoleUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    paramAdapterView = (b.a)this.EJJ.get(paramInt);
    if (paramAdapterView.EJO != null) {
      paramAdapterView.EJO.a(this, paramAdapterView.dOr.split(" +"), "");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/cmd/RecoveryConsoleUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(151619);
      return;
      b.L(this, paramAdapterView.dOr, "");
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