package com.tencent.sqlitelint.behaviour.alert;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.behaviour.persistence.SQLiteLintDbHelper;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.List;

public class CheckedDatabaseListActivity
  extends SQLiteLintBaseActivity
{
  private static final String TAG = "SQLiteLint.CheckedDatabaseListActivity";
  private CheckedDatabaseListActivity.CheckedDatabaseListAdapter mListAdapter;
  private ListView mListView;
  
  private void initView()
  {
    AppMethodBeat.i(52899);
    setTitle(getString(2131757344));
    this.mListView = ((ListView)findViewById(2131301443));
    this.mListAdapter = new CheckedDatabaseListActivity.CheckedDatabaseListAdapter(this);
    this.mListView.setAdapter(this.mListAdapter);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      private byte _hellAccFlag_;
      
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(52890);
        paramAnonymousView = (String)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        if (SQLiteLintUtil.isNullOrNil(paramAnonymousView))
        {
          AppMethodBeat.o(52890);
          return;
        }
        paramAnonymousAdapterView = new Intent();
        paramAnonymousAdapterView.setClass(CheckedDatabaseListActivity.this, CheckResultActivity.class);
        paramAnonymousAdapterView.putExtra("db_label", paramAnonymousView);
        paramAnonymousView = CheckedDatabaseListActivity.this;
        paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahE(), "com/tencent/sqlitelint/behaviour/alert/CheckedDatabaseListActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/sqlitelint/behaviour/alert/CheckedDatabaseListActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(52890);
      }
    });
    AppMethodBeat.o(52899);
  }
  
  private void refreshView()
  {
    AppMethodBeat.i(52900);
    List localList = IssueStorage.getDbPathList();
    SLog.i("SQLiteLint.CheckedDatabaseListActivity", "refreshView defectiveDbList is %d", new Object[] { Integer.valueOf(localList.size()) });
    this.mListAdapter.setData(localList);
    AppMethodBeat.o(52900);
  }
  
  protected int getLayoutId()
  {
    return 2131492931;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(52897);
    super.onCreate(paramBundle);
    SQLiteLintDbHelper.INSTANCE.initialize(this);
    initView();
    AppMethodBeat.o(52897);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(52898);
    super.onResume();
    refreshView();
    AppMethodBeat.o(52898);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.CheckedDatabaseListActivity
 * JD-Core Version:    0.7.0.1
 */