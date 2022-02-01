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
  List<b.a> DfN;
  SimpleAdapter DfO;
  ListView EO;
  List<Map<String, String>> oXp;
  
  public int getLayoutId()
  {
    return 2131494873;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(151618);
    super.onCreate(paramBundle);
    setTitle("Recovery Console");
    this.DfN = b.eKn();
    this.oXp = new ArrayList(this.DfN.size());
    paramBundle = this.DfN.iterator();
    while (paramBundle.hasNext())
    {
      b.a locala = (b.a)paramBundle.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("title", getString(locala.lMi));
      this.oXp.add(localHashMap);
    }
    this.DfO = new SimpleAdapter(this, this.oXp, 2131494804, new String[] { "title" }, new int[] { 16908310 });
    this.EO = ((ListView)findViewById(16908298));
    this.EO.setAdapter(this.DfO);
    this.EO.setOnItemClickListener(this);
    AppMethodBeat.o(151618);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(151619);
    paramAdapterView = (b.a)this.DfN.get(paramInt);
    if (paramAdapterView.DfS != null)
    {
      paramAdapterView.DfS.a(this, paramAdapterView.dCe.split(" +"), "");
      AppMethodBeat.o(151619);
      return;
    }
    b.I(this, paramAdapterView.dCe, "");
    AppMethodBeat.o(151619);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.cmd.RecoveryConsoleUI
 * JD-Core Version:    0.7.0.1
 */