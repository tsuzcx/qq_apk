import android.os.AsyncTask;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.List;

public class ah
  extends AsyncTask<Integer, Integer, String>
{
  public ah(LiteActivity paramLiteActivity, ArrayList paramArrayList) {}
  
  DataLineMsgRecord a(alqo paramalqo, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 == 0) {
      switch (arrr.a(paramString))
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.msgtype = alqo.a(i);
      localDataLineMsgRecord.sessionid = paramalqo.a(0, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a).longValue();
      localDataLineMsgRecord.path = paramString;
      localDataLineMsgRecord.thumbPath = null;
      localDataLineMsgRecord.groupId = paramInt2;
      localDataLineMsgRecord.groupSize = paramInt3;
      localDataLineMsgRecord.groupIndex = paramInt4;
      return localDataLineMsgRecord;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 2;
    }
  }
  
  protected String a(Integer... paramVarArgs)
  {
    int i = paramVarArgs[0].intValue();
    a(this.jdField_a_of_type_JavaUtilArrayList, i);
    return null;
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(false);
  }
  
  void a(List<String> paramList, int paramInt)
  {
    if (paramList == null) {}
    alqo localalqo;
    int j;
    int i;
    Object localObject;
    for (;;)
    {
      return;
      localalqo = (alqo)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(8);
      j = paramList.size();
      if (j > 3) {
        break;
      }
      i = 0;
      while (i < j)
      {
        localObject = a(localalqo, (String)paramList.get(i), paramInt, 0, 0, 0);
        if (localObject != null) {
          localalqo.a((DataLineMsgRecord)localObject, false);
        }
        i += 1;
      }
    }
    label117:
    DataLineMsgRecord localDataLineMsgRecord;
    if ((j > 3) && (j < 50))
    {
      localObject = new ArrayList();
      int k = localalqo.a();
      i = 0;
      if (i < j)
      {
        localDataLineMsgRecord = a(localalqo, (String)paramList.get(i), paramInt, k, j, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, k)) {
          break label408;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localalqo.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
    }
    label259:
    label405:
    label408:
    for (;;)
    {
      i += 1;
      break label117;
      if (((ArrayList)localObject).size() <= 0) {
        break;
      }
      localalqo.a((ArrayList)localObject, false);
      return;
      localObject = new ArrayList();
      j = localalqo.a();
      i = 0;
      if (i < 50)
      {
        localDataLineMsgRecord = a(localalqo, (String)paramList.get(i), paramInt, j, 50, i);
        if (localDataLineMsgRecord != null) {
          ((ArrayList)localObject).add(localDataLineMsgRecord);
        }
        if (!DataLineMsgSet.isSingle(paramInt, j)) {
          break label405;
        }
        if (localDataLineMsgRecord != null)
        {
          localDataLineMsgRecord.groupId = 0;
          localDataLineMsgRecord.groupIndex = 0;
          localDataLineMsgRecord.groupSize = 0;
        }
        if (((ArrayList)localObject).size() > 0) {
          localalqo.a((ArrayList)localObject, false);
        }
        localObject = new ArrayList();
      }
      for (;;)
      {
        i += 1;
        break label259;
        if (((ArrayList)localObject).size() > 0) {
          localalqo.a((ArrayList)localObject, false);
        }
        i = 0;
        while (i < 50)
        {
          paramList.remove(0);
          i += 1;
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ah
 * JD-Core Version:    0.7.0.1
 */