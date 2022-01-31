import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class akpk
{
  public static int a(MessageRecord paramMessageRecord, int paramInt)
  {
    paramMessageRecord = a(paramMessageRecord);
    int j;
    if (paramMessageRecord != null)
    {
      paramMessageRecord = paramMessageRecord.iterator();
      int i = 0;
      j = i;
      if (!paramMessageRecord.hasNext()) {
        break label62;
      }
      akpl localakpl = (akpl)paramMessageRecord.next();
      if (localakpl.a != paramInt) {
        break label64;
      }
      i = localakpl.b + i;
    }
    label62:
    label64:
    for (;;)
    {
      break;
      j = 0;
      return j;
    }
  }
  
  public static List<akpl> a(MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList;
    String str;
    int j;
    int i;
    if (((paramMessageRecord instanceof MessageForStructing)) && ((((MessageForStructing)paramMessageRecord).structingMsg instanceof AbsShareMsg)) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 52))
    {
      paramMessageRecord = (AbsShareMsg)((MessageForStructing)paramMessageRecord).structingMsg;
      localArrayList = new ArrayList();
      Iterator localIterator = paramMessageRecord.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramMessageRecord = (axup)localIterator.next();
          if (paramMessageRecord != null)
          {
            str = ajya.a(2131705276);
            j = 1;
            if ((paramMessageRecord instanceof axxb))
            {
              i = ((axxb)paramMessageRecord).a.getInt("count");
              j = 1;
              paramMessageRecord = str;
            }
          }
        }
      }
    }
    for (;;)
    {
      localArrayList.add(new akpl(paramMessageRecord, j, i));
      break;
      Object localObject = paramMessageRecord.h;
      if (localObject != null)
      {
        i = j;
        paramMessageRecord = str;
        try
        {
          localObject = new JSONObject((String)localObject);
          i = j;
          paramMessageRecord = str;
          str = ((JSONObject)localObject).getString("giftName");
          i = j;
          paramMessageRecord = str;
          j = ((JSONObject)localObject).getInt("giftType");
          i = j;
          paramMessageRecord = str;
          int k = ((JSONObject)localObject).getInt("giftCount");
          i = k;
          paramMessageRecord = str;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          j = i;
          i = 0;
        }
        continue;
        return localArrayList;
        return null;
      }
      else
      {
        i = 0;
        j = 1;
        paramMessageRecord = localJSONException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akpk
 * JD-Core Version:    0.7.0.1
 */