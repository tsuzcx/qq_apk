import android.os.AsyncTask;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.List;

public class am
  extends AsyncTask<Integer, Integer, String>
{
  public am(LiteActivity paramLiteActivity, ArrayList paramArrayList) {}
  
  DataLineMsgRecord a(amqd paramamqd, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramInt1;
    if (paramInt1 == 0) {
      switch (aszt.a(paramString))
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.msgtype = amqd.a(i);
      localDataLineMsgRecord.sessionid = paramamqd.a(0, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a).longValue();
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
    amqd localamqd;
    int j;
    int i;
    Object localObject1;
    for (;;)
    {
      return;
      localamqd = (amqd)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getBusinessHandler(8);
      j = paramList.size();
      if (j > 3) {
        break;
      }
      i = 0;
      while (i < j)
      {
        localObject1 = (String)paramList.get(i);
        localObject1 = a(localamqd, LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (String)localObject1), paramInt, 0, 0, 0);
        if (localObject1 != null) {
          localamqd.a((DataLineMsgRecord)localObject1, false);
        }
        i += 1;
      }
    }
    label128:
    Object localObject2;
    if ((j > 3) && (j < 50))
    {
      localObject1 = new ArrayList();
      int k = localamqd.a();
      i = 0;
      if (i < j)
      {
        localObject2 = (String)paramList.get(i);
        localObject2 = a(localamqd, LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (String)localObject2), paramInt, k, j, i);
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
        if (!DataLineMsgSet.isSingle(paramInt, k)) {
          break label441;
        }
        if (localObject2 != null)
        {
          ((DataLineMsgRecord)localObject2).groupId = 0;
          ((DataLineMsgRecord)localObject2).groupIndex = 0;
          ((DataLineMsgRecord)localObject2).groupSize = 0;
        }
        if (((ArrayList)localObject1).size() > 0) {
          localamqd.a((ArrayList)localObject1, false);
        }
        localObject1 = new ArrayList();
      }
    }
    label281:
    label438:
    label441:
    for (;;)
    {
      i += 1;
      break label128;
      if (((ArrayList)localObject1).size() <= 0) {
        break;
      }
      localamqd.a((ArrayList)localObject1, false);
      return;
      localObject1 = new ArrayList();
      j = localamqd.a();
      i = 0;
      if (i < 50)
      {
        localObject2 = (String)paramList.get(i);
        localObject2 = a(localamqd, LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, (String)localObject2), paramInt, j, 50, i);
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
        if (!DataLineMsgSet.isSingle(paramInt, j)) {
          break label438;
        }
        if (localObject2 != null)
        {
          ((DataLineMsgRecord)localObject2).groupId = 0;
          ((DataLineMsgRecord)localObject2).groupIndex = 0;
          ((DataLineMsgRecord)localObject2).groupSize = 0;
        }
        if (((ArrayList)localObject1).size() > 0) {
          localamqd.a((ArrayList)localObject1, false);
        }
        localObject1 = new ArrayList();
      }
      for (;;)
      {
        i += 1;
        break label281;
        if (((ArrayList)localObject1).size() > 0) {
          localamqd.a((ArrayList)localObject1, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     am
 * JD-Core Version:    0.7.0.1
 */