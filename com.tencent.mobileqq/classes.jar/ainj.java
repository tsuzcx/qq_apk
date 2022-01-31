import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.widget.HotChatPostItemView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ainj
  extends BaseAdapter
{
  protected int a;
  Context jdField_a_of_type_AndroidContentContext;
  ArrayList<JSONObject> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  JSONObject jdField_a_of_type_OrgJsonJSONObject = null;
  xjm jdField_a_of_type_Xjm;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = true;
  
  public ainj(Context paramContext, JSONArray paramJSONArray, xjm paramxjm)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Xjm = paramxjm;
    if (this.jdField_a_of_type_Xjm != null) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      b(paramJSONArray);
      return;
      bool = false;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return i + this.jdField_a_of_type_Int;
    }
  }
  
  public void a()
  {
    try
    {
      this.b = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList;
    StringBuilder localStringBuilder;
    int i;
    if (paramJSONArray != null)
    {
      localArrayList = new ArrayList();
      localStringBuilder = new StringBuilder("filterPids:");
      i = 0;
    }
    for (;;)
    {
      if (i < paramJSONArray.length())
      {
        try
        {
          JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
          if (!localJSONObject.has("pid")) {
            break label171;
          }
          String str = localJSONObject.optString("pid");
          if (!this.jdField_a_of_type_JavaUtilHashSet.add(str))
          {
            localStringBuilder.append(str).append(",");
            this.jdField_a_of_type_Int += 1;
          }
          else
          {
            localArrayList.add(localJSONObject);
          }
        }
        catch (JSONException localJSONException)
        {
          if (!QLog.isColorLevel()) {
            break label171;
          }
        }
        QLog.e("HotChatPostListAdapterQ.hotchat.aio_post_list_req", 2, "process array" + localJSONException.toString());
      }
      else
      {
        if (!localArrayList.isEmpty())
        {
          this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
          notifyDataSetChanged();
        }
        return;
      }
      label171:
      i += 1;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    try
    {
      this.b = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      int i = 0;
      for (;;)
      {
        if (i < paramJSONArray.length()) {
          try
          {
            JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
            String str = localJSONObject.optString("pid");
            this.jdField_a_of_type_JavaUtilHashSet.add(str);
            this.jdField_a_of_type_JavaUtilArrayList.add(localJSONObject);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("HotChatPostListAdapterQ.hotchat.aio_post_list_req", 2, "setListItemsAndNotify JSONException:" + localJSONException.toString());
              }
            }
          }
        }
      }
      notifyDataSetChanged();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Xjm != null)
      {
        this.jdField_a_of_type_Xjm.a("com.tencent.biz.hotchatpostlist.widget.HotChatPostItemView");
        this.jdField_a_of_type_Xjm = null;
      }
      return;
    }
    HotChatPostItemView.jdField_a_of_type_JavaUtilHashMap.clear();
    HotChatPostItemView.jdField_a_of_type_JavaUtilQueue.clear();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    return (JSONObject)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) && (this.jdField_a_of_type_Boolean)) {
      paramView = this.jdField_a_of_type_Xjm.a("com.tencent.biz.hotchatpostlist.widget.HotChatPostItemView");
    }
    for (;;)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new HotChatPostItemView(this.jdField_a_of_type_AndroidContentContext);
        if (QLog.isColorLevel()) {
          QLog.e("HotChatPostListAdapter", 2, "loadPluginView failed");
        }
        this.jdField_a_of_type_Boolean = false;
      }
      paramView = (JSONObject)getItem(paramInt);
      if (paramView != null) {
        paramViewGroup.setOnClickListener(new ainl(this, paramView.optString("bid"), paramView.optString("pid")));
      }
      try
      {
        if (this.jdField_a_of_type_OrgJsonJSONObject == null)
        {
          this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
          paramInt = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay().getWidth();
          this.jdField_a_of_type_OrgJsonJSONObject.put("densityDpi", this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi);
          this.jdField_a_of_type_OrgJsonJSONObject.put("screenWidth", paramInt);
        }
        this.jdField_a_of_type_OrgJsonJSONObject.put("currentTime", NetConnInfoCenter.getServerTime());
        paramView.put("extra_info_key", this.jdField_a_of_type_OrgJsonJSONObject);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("HotChatPostListAdapter", 2, localJSONException.toString());
          }
        }
        ((HotChatPostItemView)paramViewGroup).setData(paramView.toString());
        return paramViewGroup;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        xjm.a(paramViewGroup, paramView.toString());
        return paramViewGroup;
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, new aink(this));
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ainj
 * JD-Core Version:    0.7.0.1
 */