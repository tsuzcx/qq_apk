import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class afik
{
  public static afik a()
  {
    return afin.a();
  }
  
  private ArrayList<afim> b(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("group_search_local_history_" + paramString, 0).getAll();
    paramString = new ArrayList();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramString.add(new afim(this, (String)localEntry.getKey(), (Long)localEntry.getValue()));
    }
    Collections.sort(paramString);
    return paramString;
  }
  
  ArrayList<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = b(paramString).iterator();
    while (paramString.hasNext()) {
      localArrayList.add(((afim)paramString.next()).a());
    }
    return localArrayList;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString2.trim()))) {
      return;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("group_search_local_history_" + paramString1, 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    if (localSharedPreferences.getLong(paramString2, -1L) == -1L)
    {
      paramString1 = b(paramString1);
      if ((paramString1 != null) && (paramString1.size() >= 3))
      {
        int i = 2;
        while (i < paramString1.size())
        {
          localEditor.remove(((afim)paramString1.get(i)).a());
          i += 1;
        }
      }
    }
    localEditor.putLong(paramString2, System.currentTimeMillis());
    localEditor.apply();
  }
  
  void b(String paramString1, String paramString2)
  {
    paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("group_search_local_history_" + paramString1, 0).edit();
    paramString1.remove(paramString2);
    paramString1.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afik
 * JD-Core Version:    0.7.0.1
 */