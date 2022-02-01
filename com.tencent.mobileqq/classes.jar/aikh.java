import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class aikh
  extends avlo
{
  aikh(aikg paramaikg) {}
  
  protected void a(Object paramObject)
  {
    QLog.i(aikg.g, 1, "[onGameUsrInfoChangedNotify]");
    for (;;)
    {
      avlc localavlc;
      try
      {
        if ((paramObject instanceof ArrayList))
        {
          paramObject = ((ArrayList)paramObject).iterator();
          if (paramObject.hasNext())
          {
            localavlc = (avlc)paramObject.next();
            if ((TextUtils.isEmpty(localavlc.b)) || (!localavlc.b.equals(this.a.a.a()))) {
              break label115;
            }
            aikg.a(this.a, localavlc);
            aikg.a(this.a, localavlc);
            QLog.i(aikg.g, 1, "update friend info.");
            continue;
          }
        }
        return;
      }
      catch (Throwable paramObject)
      {
        QLog.e(aikg.g, 1, paramObject.getMessage());
      }
      label115:
      if ((!TextUtils.isEmpty(localavlc.b)) && (localavlc.b.equals(this.a.a.b())))
      {
        aikg.b(this.a, localavlc);
        QLog.i(aikg.g, 1, "update my info.");
      }
    }
  }
  
  protected void b(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof JSONObject))) {
      QLog.i(aikg.g, 1, "[onGetAioPopInfo] data:" + paramObject.toString());
    }
    for (;;)
    {
      String str;
      ArrayList localArrayList;
      int i;
      try
      {
        Object localObject = (JSONObject)paramObject;
        paramObject = ((JSONObject)localObject).optString("title");
        str = ((JSONObject)localObject).optString("content");
        localObject = ((JSONObject)localObject).optJSONArray("buttons");
        if (TextUtils.isEmpty(str)) {
          break label285;
        }
        if (((JSONArray)localObject).length() == 0) {
          return;
        }
        localArrayList = new ArrayList();
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
          aiko localaiko = new aiko(this.a);
          localaiko.b = localJSONObject.optString("title");
          if (TextUtils.isEmpty(localaiko.b)) {
            break label286;
          }
          localaiko.jdField_a_of_type_JavaLangString = localJSONObject.optString("url");
          localaiko.jdField_a_of_type_Int = localJSONObject.optInt("type");
          localArrayList.add(localaiko);
        }
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      if (localArrayList.size() == 1)
      {
        aikg.a(this.a, paramObject, str, (aiko)localArrayList.get(0), null);
        return;
      }
      if (localArrayList.size() >= 2)
      {
        aikg.a(this.a, paramObject, str, (aiko)localArrayList.get(0), (aiko)localArrayList.get(1));
        return;
      }
      QLog.i(aikg.g, 1, "[onGetAioPopInfo] no button.");
      label285:
      return;
      label286:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikh
 * JD-Core Version:    0.7.0.1
 */