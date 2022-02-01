package com.tencent.mm.plugin.monitor;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am.a;
import com.tencent.mm.ui.base.a;
import java.util.HashSet;
import java.util.Set;

@a(3)
public class IllegalLogsActivity
  extends MMActivity
{
  public int getLayoutId()
  {
    return b.a.empty_view;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(266638);
    Log.d("MicroMsg.EmptyActivity", "onCreate %s", new Object[] { Integer.valueOf(hashCode()) });
    LinearLayout localLinearLayout = new LinearLayout(this);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(266645);
        IllegalLogsActivity.this.finish();
        AppMethodBeat.o(266645);
        return true;
      }
    });
    paramBundle = getIntent();
    if (paramBundle.hasExtra("process"))
    {
      paramBundle = paramBundle.getStringExtra("process");
      setMMTitle("违规日志，进程：".concat(String.valueOf(paramBundle)));
    }
    for (paramBundle = MultiProcessMMKV.getMMKV("xlog_illegal.txt").decodeStringSet(paramBundle);; paramBundle = new HashSet())
    {
      ListView localListView = new ListView(this);
      localListView.setAdapter(new ArrayAdapter(this, 17367043, (String[])paramBundle.toArray(new String[0])));
      localListView.setDivider(new ColorDrawable(getResources().getColor(am.a.black)));
      localListView.setDividerHeight(1);
      localLinearLayout.addView(localListView);
      setContentView(localLinearLayout);
      AppMethodBeat.o(266638);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(266652);
    super.onDestroy();
    AppMethodBeat.o(266652);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(266649);
    super.onPause();
    AppMethodBeat.o(266649);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(266643);
    super.onResume();
    AppMethodBeat.o(266643);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.monitor.IllegalLogsActivity
 * JD-Core Version:    0.7.0.1
 */