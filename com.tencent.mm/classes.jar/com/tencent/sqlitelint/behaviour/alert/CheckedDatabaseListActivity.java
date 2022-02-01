package com.tencent.sqlitelint.behaviour.alert;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    this.mListView.setOnItemClickListener(new CheckedDatabaseListActivity.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.CheckedDatabaseListActivity
 * JD-Core Version:    0.7.0.1
 */