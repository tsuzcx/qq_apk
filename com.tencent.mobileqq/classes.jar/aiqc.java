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

public class aiqc
{
  private static aiqc jdField_a_of_type_Aiqc;
  private Comparator<aiqe> jdField_a_of_type_JavaUtilComparator = new aiqd(this);
  private List<aiqe> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentHashMap<String, Boolean> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private aiqc()
  {
    ThreadManagerV2.executeOnFileThread(new CmGameShareDataHandler.1(this));
  }
  
  public static aiqc a()
  {
    try
    {
      if (jdField_a_of_type_Aiqc == null) {
        jdField_a_of_type_Aiqc = new aiqc();
      }
      aiqc localaiqc = jdField_a_of_type_Aiqc;
      return localaiqc;
    }
    finally {}
  }
  
  private void a()
  {
    Object localObject = new File(aiys.s + "gameShareResult.txt");
    if (((File)localObject).exists()) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = aivc.a((File)localObject);
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
          aiqe localaiqe = new aiqe();
          localaiqe.d = localJSONObject.optInt("shareTo");
          localaiqe.b = localJSONObject.optInt("activity");
          localaiqe.c = localJSONObject.optInt("aioType");
          localaiqe.jdField_a_of_type_Int = localJSONObject.optInt("gameId");
          localaiqe.jdField_a_of_type_JavaLangString = localJSONObject.optString("uin");
          localaiqe.jdField_a_of_type_Long = localJSONObject.optLong("shareTS");
          localaiqe.e = localJSONObject.optInt("shareRet");
          this.jdField_a_of_type_JavaUtilList.add(localaiqe);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localaiqe.a(), Boolean.TRUE);
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
  
  public void a(aiqe paramaiqe)
  {
    if (paramaiqe == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameShareDataHandler", 2, new Object[] { "saveShareResult, result:", paramaiqe });
    }
    this.jdField_a_of_type_JavaUtilList.add(0, paramaiqe);
    if (this.jdField_a_of_type_JavaUtilList.size() > 100) {
      this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList(this.jdField_a_of_type_JavaUtilList.subList(0, 100));
    }
    ThreadManagerV2.executeOnFileThread(new CmGameShareDataHandler.3(this));
  }
  
  public boolean a(aiqe paramaiqe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "isDuplicateShare result:", paramaiqe });
    }
    boolean bool1;
    if (paramaiqe == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramaiqe = (Boolean)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramaiqe.a());
      if (paramaiqe == null) {
        break;
      }
      bool2 = paramaiqe.booleanValue();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "isDuplicateShare sameValue:", Boolean.valueOf(bool2) });
    return bool2;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiqc
 * JD-Core Version:    0.7.0.1
 */