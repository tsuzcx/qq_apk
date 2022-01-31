import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;

public class akgd
  implements Manager
{
  public static final String a;
  public static boolean a;
  private QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = akgd.class.getSimpleName();
  }
  
  public akgd() {}
  
  public akgd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private static String a()
  {
    return (String)bhvh.a("search_keyword_list", "");
  }
  
  private static void b(String paramString)
  {
    jdField_a_of_type_Boolean = true;
    bhvh.a("search_keyword_list", paramString);
  }
  
  public ArrayList<String> a()
  {
    localArrayList = new ArrayList();
    Object localObject = a();
    if (localObject != null) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          localArrayList.add(((JSONArray)localObject).optString(i));
          i += 1;
        }
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    b("");
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList = a();
    if ((localArrayList != null) && (paramInt < localArrayList.size())) {
      localArrayList.remove(paramInt);
    }
    JSONArray localJSONArray = new JSONArray();
    paramInt = 0;
    while (paramInt < localArrayList.size())
    {
      localJSONArray.put(localArrayList.get(paramInt));
      paramInt += 1;
    }
    b(localJSONArray.toString());
  }
  
  public void a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "addSearchHistory key word is null");
      }
      return;
    }
    ArrayList localArrayList = a();
    if (localArrayList.size() >= 10) {
      localArrayList.remove(localArrayList.size() - 1);
    }
    localArrayList.remove(paramString);
    localArrayList.add(0, paramString);
    paramString = new JSONArray();
    while (i < localArrayList.size())
    {
      paramString.put(localArrayList.get(i));
      i += 1;
    }
    b(paramString.toString());
  }
  
  public void a(JSONArray paramJSONArray)
  {
    int j = 0;
    if (paramJSONArray == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "addAllSearchHistory key word is null");
      }
      return;
    }
    ArrayList localArrayList2 = a();
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      String str = paramJSONArray.optString(i);
      if (!TextUtils.isEmpty(str))
      {
        localArrayList2.add(str);
        localArrayList1.remove(str);
      }
      i += 1;
    }
    localArrayList2.addAll(localArrayList1);
    paramJSONArray = new JSONArray();
    if (localArrayList2.size() > 10) {
      i = 10;
    }
    while (j < i)
    {
      paramJSONArray.put(localArrayList2.get(j));
      j += 1;
      continue;
      i = localArrayList2.size();
    }
    b(paramJSONArray.toString());
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akgd
 * JD-Core Version:    0.7.0.1
 */