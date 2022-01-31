import android.text.TextUtils;
import com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.1;
import com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.3;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ajda
{
  private static ajda jdField_a_of_type_Ajda;
  private Comparator<ajdc> jdField_a_of_type_JavaUtilComparator = new ajdb(this);
  private List<ajdc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private ajda()
  {
    ThreadManagerV2.executeOnFileThread(new CmGameShareDataHandler.1(this));
  }
  
  public static ajda a()
  {
    try
    {
      if (jdField_a_of_type_Ajda == null) {
        jdField_a_of_type_Ajda = new ajda();
      }
      ajda localajda = jdField_a_of_type_Ajda;
      return localajda;
    }
    finally {}
  }
  
  private void a()
  {
    Object localObject = new File(ajmu.s + "gameShareResult.txt");
    if (((File)localObject).exists()) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = ajje.a((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.e("cmgame_process.CmGameShareDataHandler", 1, "initCache, ApolloClientUtil.readFileSafety null");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameShareDataHandler", 2, new Object[] { "initCache content:", localObject });
        }
        localObject = new JSONArray((String)localObject);
        int j = ((JSONArray)localObject).length();
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          if (localJSONObject == null) {
            break label320;
          }
          ajdc localajdc = new ajdc();
          localajdc.d = localJSONObject.optInt("shareTo");
          localajdc.b = localJSONObject.optInt("activity");
          localajdc.c = localJSONObject.optInt("aioType");
          localajdc.jdField_a_of_type_Int = localJSONObject.optInt("gameId");
          localajdc.jdField_a_of_type_JavaLangString = localJSONObject.optString("uin");
          localajdc.jdField_a_of_type_Long = localJSONObject.optLong("shareTS");
          localajdc.e = localJSONObject.optInt("shareRet");
          this.jdField_a_of_type_JavaUtilList.add(localajdc);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localajdc.a(), Boolean.TRUE);
          break label320;
        }
        Collections.sort(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
        QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "initCache finish mShareResultCache.size():", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
        return;
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameShareDataHandler", 1, "initCache e:", localException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          break label319;
        }
      }
      QLog.e("cmgame_process.CmGameShareDataHandler", 1, localOutOfMemoryError, new Object[0]);
      return;
      QLog.e("cmgame_process.CmGameShareDataHandler", 1, "file gameShareResult.txt no exsit");
      label319:
      return;
      label320:
      i += 1;
    }
  }
  
  public void a(ajdc paramajdc)
  {
    if (paramajdc == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameShareDataHandler", 2, new Object[] { "saveShareResult, result:", paramajdc });
    }
    this.jdField_a_of_type_JavaUtilList.add(0, paramajdc);
    if (this.jdField_a_of_type_JavaUtilList.size() > 100) {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilList.subList(0, 100));
    }
    ThreadManagerV2.executeOnFileThread(new CmGameShareDataHandler.3(this));
  }
  
  public boolean a(ajdc paramajdc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "isDuplicateShare result:", paramajdc });
    }
    boolean bool1;
    if (paramajdc == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramajdc = (Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramajdc.a());
      if (paramajdc == null) {
        break;
      }
      bool2 = paramajdc.booleanValue();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "isDuplicateShare sameValue:", Boolean.valueOf(bool2) });
    return bool2;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajda
 * JD-Core Version:    0.7.0.1
 */