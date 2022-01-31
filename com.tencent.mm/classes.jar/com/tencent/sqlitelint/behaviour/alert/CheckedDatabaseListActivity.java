package com.tencent.sqlitelint.behaviour.alert;

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
import com.tencent.sqlitelint.behaviour.a.a;
import com.tencent.sqlitelint.behaviour.a.c;
import com.tencent.sqlitelint.d.b;
import com.tencent.sqlitelint.d.c;
import com.tencent.sqlitelint.d.d;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.List;

public class CheckedDatabaseListActivity
  extends SQLiteLintBaseActivity
{
  private ListView Nn;
  private a wRq;
  
  protected final int getLayoutId()
  {
    return d.c.activity_checked_database_list;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    c.wRD.initialize(this);
    setTitle(getString(d.d.checked_database_list_title));
    this.Nn = ((ListView)findViewById(d.b.list));
    this.wRq = new a(this);
    this.Nn.setAdapter(this.wRq);
    this.Nn.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = (String)paramAnonymousAdapterView.getItemAtPosition(paramAnonymousInt);
        if (SQLiteLintUtil.bl(paramAnonymousAdapterView)) {
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.setClass(CheckedDatabaseListActivity.this, CheckResultActivity.class);
        paramAnonymousView.putExtra("db_label", paramAnonymousAdapterView);
        CheckedDatabaseListActivity.this.startActivity(paramAnonymousView);
      }
    });
  }
  
  protected void onResume()
  {
    super.onResume();
    List localList = a.cPS();
    SLog.i("SQLiteLint.CheckedDatabaseListActivity", "refreshView defectiveDbList is %d", new Object[] { Integer.valueOf(localList.size()) });
    a locala = this.wRq;
    locala.wRs = localList;
    locala.notifyDataSetChanged();
  }
  
  private static final class a
    extends BaseAdapter
  {
    private final LayoutInflater Lu;
    List<String> wRs;
    
    a(Context paramContext)
    {
      this.Lu = LayoutInflater.from(paramContext);
    }
    
    private String ke(int paramInt)
    {
      return (String)this.wRs.get(paramInt);
    }
    
    public final int getCount()
    {
      if (this.wRs == null) {
        return 0;
      }
      return this.wRs.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = this.Lu.inflate(d.c.view_checked_database_item, paramViewGroup, false);
        paramViewGroup = new CheckedDatabaseListActivity.b();
        paramViewGroup.wRt = ((TextView)paramView.findViewById(d.b.db_path));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        String str = ke(paramInt);
        paramViewGroup.wRt.setText(str);
        return paramView;
        paramViewGroup = (CheckedDatabaseListActivity.b)paramView.getTag();
      }
    }
  }
  
  static final class b
  {
    public TextView wRt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.CheckedDatabaseListActivity
 * JD-Core Version:    0.7.0.1
 */