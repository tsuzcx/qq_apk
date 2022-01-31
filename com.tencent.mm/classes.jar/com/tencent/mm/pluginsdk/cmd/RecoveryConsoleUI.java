package com.tencent.mm.pluginsdk.cmd;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.tencent.mm.plugin.comm.a.f;
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
  List<Map<String, String>> iVa;
  ListView mQH;
  List<b.a> rSK;
  SimpleAdapter rSL;
  
  protected final int getLayoutId()
  {
    return a.f.mm_preference_list_content;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitle("Recovery Console");
    this.rSK = b.ckq();
    this.iVa = new ArrayList(this.rSK.size());
    paramBundle = this.rSK.iterator();
    while (paramBundle.hasNext())
    {
      b.a locala = (b.a)paramBundle.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("title", getString(locala.rSP));
      this.iVa.add(localHashMap);
    }
    this.rSL = new SimpleAdapter(this, this.iVa, a.f.mm_preference, new String[] { "title" }, new int[] { 16908310 });
    this.mQH = ((ListView)findViewById(16908298));
    this.mQH.setAdapter(this.rSL);
    this.mQH.setOnItemClickListener(this);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (b.a)this.rSK.get(paramInt);
    if (paramAdapterView.rSQ != null)
    {
      paramAdapterView.rSQ.a(this, paramAdapterView.ceO.split(" +"));
      return;
    }
    b.bg(this, paramAdapterView.ceO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.cmd.RecoveryConsoleUI
 * JD-Core Version:    0.7.0.1
 */