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
  List<Map<String, String>> lee;
  List<b.a> vJI;
  SimpleAdapter vJJ;
  ListView xx;
  
  public int getLayoutId()
  {
    return 2130970245;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79197);
    super.onCreate(paramBundle);
    setTitle("Recovery Console");
    this.vJI = b.dkW();
    this.lee = new ArrayList(this.vJI.size());
    paramBundle = this.vJI.iterator();
    while (paramBundle.hasNext())
    {
      b.a locala = (b.a)paramBundle.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("title", getString(locala.vJN));
      this.lee.add(localHashMap);
    }
    this.vJJ = new SimpleAdapter(this, this.lee, 2130970179, new String[] { "title" }, new int[] { 16908310 });
    this.xx = ((ListView)findViewById(16908298));
    this.xx.setAdapter(this.vJJ);
    this.xx.setOnItemClickListener(this);
    AppMethodBeat.o(79197);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(79198);
    paramAdapterView = (b.a)this.vJI.get(paramInt);
    if (paramAdapterView.vJO != null)
    {
      paramAdapterView.vJO.a(this, paramAdapterView.cNu.split(" +"), "");
      AppMethodBeat.o(79198);
      return;
    }
    b.B(this, paramAdapterView.cNu, "");
    AppMethodBeat.o(79198);
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