package com.tencent.sqlitelint.behaviour.alert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.R.id;
import com.tencent.sqlitelint.R.layout;
import com.tencent.sqlitelint.R.string;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.behaviour.persistence.SQLiteLintDbHelper;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.List;

public class CheckedDatabaseListActivity
  extends SQLiteLintBaseActivity
{
  private static final String TAG = "SQLiteLint.CheckedDatabaseListActivity";
  private CheckedDatabaseListAdapter mListAdapter;
  private ListView mListView;
  
  private void initView()
  {
    AppMethodBeat.i(52899);
    setTitle(getString(R.string.checked_database_list_title));
    this.mListView = ((ListView)findViewById(R.id.list));
    this.mListAdapter = new CheckedDatabaseListAdapter(this);
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
        paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aFh(), "com/tencent/sqlitelint/behaviour/alert/CheckedDatabaseListActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/sqlitelint/behaviour/alert/CheckedDatabaseListActivity$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    return R.layout.activity_checked_database_list;
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
  
  static class CheckedDatabaseListAdapter
    extends BaseAdapter
  {
    private List<String> mDefectiveDbList;
    private final LayoutInflater mInflater;
    
    CheckedDatabaseListAdapter(Context paramContext)
    {
      AppMethodBeat.i(52891);
      this.mInflater = LayoutInflater.from(paramContext);
      AppMethodBeat.o(52891);
    }
    
    public int getCount()
    {
      AppMethodBeat.i(52893);
      if (this.mDefectiveDbList == null)
      {
        AppMethodBeat.o(52893);
        return 0;
      }
      int i = this.mDefectiveDbList.size();
      AppMethodBeat.o(52893);
      return i;
    }
    
    public String getItem(int paramInt)
    {
      AppMethodBeat.i(52894);
      String str = (String)this.mDefectiveDbList.get(paramInt);
      AppMethodBeat.o(52894);
      return str;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(52895);
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(R.layout.view_checked_database_item, paramViewGroup, false);
        paramViewGroup = new CheckedDatabaseListActivity.ViewHolder();
        paramViewGroup.dbPathTv = ((TextView)paramView.findViewById(R.id.db_path));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        String str = getItem(paramInt);
        paramViewGroup.dbPathTv.setText(str);
        AppMethodBeat.o(52895);
        return paramView;
        paramViewGroup = (CheckedDatabaseListActivity.ViewHolder)paramView.getTag();
      }
    }
    
    public void setData(List<String> paramList)
    {
      AppMethodBeat.i(52892);
      this.mDefectiveDbList = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(52892);
    }
  }
  
  static class ViewHolder
  {
    public TextView dbPathTv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.CheckedDatabaseListActivity
 * JD-Core Version:    0.7.0.1
 */