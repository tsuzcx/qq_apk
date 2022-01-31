import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.MessageRoamHandler.ChatHistoryMessageObserver.1;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class akwc
  extends akat
{
  private int a;
  
  public akwc(akwb paramakwb, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Akwb.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {
      return;
    }
    akaw localakaw = (akaw)this.jdField_a_of_type_Akwb.app.getManager(92);
    if (!paramBoolean)
    {
      localakaw.a(8, null);
      return;
    }
    localakaw.a(9, null);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    paramObject = (Bundle)paramObject;
    String str1 = paramObject.getString("PEER_UIN");
    long l = paramObject.getLong("BEGTIME");
    boolean bool1 = paramObject.getBoolean("NO_MSG");
    int i = paramObject.getInt("SVR_CODE");
    String str2 = paramObject.getString("SVR_MSG");
    boolean bool2 = paramObject.getBoolean("FETCH_MORE");
    int j = paramObject.getInt("MSG_COUNT");
    boolean bool3 = paramObject.getBoolean("IS_PRELOAD_TYPE");
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "beginTime: " + l + ",isNoMsg: " + bool1 + ",svrCode: " + i + ",msgCount:" + j + ",fetchMore: " + bool2 + ",svrMsg: " + str2 + ",isPreloadType:" + bool3);
    }
    if (bool3) {
      return;
    }
    if ((paramBoolean) && (bool2) && (j > 0) && (j <= 8))
    {
      ThreadManager.getSubThreadHandler().post(new MessageRoamHandler.ChatHistoryMessageObserver.1(this, l, j, str1, bool2));
      return;
    }
    paramObject = (akaw)this.jdField_a_of_type_Akwb.app.getManager(92);
    i = 1;
    if (!paramBoolean)
    {
      if (bool1) {
        i = 2;
      }
      paramObject.b(false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg", 2, "onUpdateGetRoamChat isSuccess: " + paramBoolean + ", whatMsg: " + i + ", beginTime: " + l);
      }
      if (!bool2) {
        break label348;
      }
    }
    label348:
    for (j = 1;; j = 0)
    {
      paramObject.a(i, j, Long.valueOf(l));
      return;
      j = 0;
      i = j;
      if (!bool2)
      {
        i = j;
        if (!paramObject.a(l)) {
          i = 4;
        }
      }
      paramObject.b(true);
      break;
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Akwb.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {
      return;
    }
    akaw localakaw = (akaw)this.jdField_a_of_type_Akwb.app.getManager(92);
    if (!paramBoolean)
    {
      localakaw.a(7, null);
      return;
    }
    localakaw.a(6, null);
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    Object localObject1;
    do
    {
      return;
      localObject2 = (HashMap)paramObject;
      localObject1 = (String)((HashMap)localObject2).get("KEYWORD");
      long l = ((Long)((HashMap)localObject2).get("SEARCHSEQUENCE")).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg", 2, "onUpdateRoamMsgSearchResult isSuccess:" + paramBoolean + ",keyword:" + (String)localObject1 + ",sequence:" + l);
      }
      localObject1 = this.jdField_a_of_type_Akwb.app.getHandler(agdv.class);
      if (!paramBoolean)
      {
        localObject2 = ((MqqHandler)localObject1).obtainMessage(4);
        ((Message)localObject2).obj = paramObject;
        ((MqqHandler)localObject1).sendMessage((Message)localObject2);
        return;
      }
    } while (((HashMap)localObject2).get("SEARCHRESULT") == null);
    Object localObject2 = ((MqqHandler)localObject1).obtainMessage(5);
    ((Message)localObject2).obj = paramObject;
    ((MqqHandler)localObject1).sendMessage((Message)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akwc
 * JD-Core Version:    0.7.0.1
 */