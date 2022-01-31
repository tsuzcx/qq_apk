import com.tencent.mobileqq.app.NumRedMsgHandler;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.NumRedGetMsgCallback;
import com.tencent.mobileqq.redtouch.NumRedMsgManager;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgRspBody;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ahkb
  implements Runnable
{
  public ahkb(NumRedMsgManager paramNumRedMsgManager, long[] paramArrayOfLong, NumRedGetMsgCallback paramNumRedGetMsgCallback, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    int k = 0;
    if ((this.jdField_a_of_type_ArrayOfLong.length < 1) || (this.jdField_a_of_type_ComTencentMobileqqRedtouchNumRedGetMsgCallback == null)) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqRedtouchNumRedMsgManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRedtouchNumRedGetMsgCallback.a))) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchNumRedMsgManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRedtouchNumRedGetMsgCallback.a), this.jdField_a_of_type_ComTencentMobileqqRedtouchNumRedGetMsgCallback);
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRedtouchNumRedMsgManager.a();
    int j;
    if (localObject != null)
    {
      localObject = ((NumRedMsg.NumMsgRspBody)localObject).rpt_num_red.get();
      if (localObject != null)
      {
        i = 0;
        if (i < this.jdField_a_of_type_ArrayOfLong.length)
        {
          j = 0;
          for (;;)
          {
            if (j >= ((List)localObject).size()) {
              break label355;
            }
            if (((NumRedMsg.NumMsgBusi)((List)localObject).get(j)).ui64_msgid.get() == this.jdField_a_of_type_ArrayOfLong[i])
            {
              localArrayList1.add(((List)localObject).get(j));
              j = 1;
              if (j == 0)
              {
                NumRedMsg.NumMsgBusi localNumMsgBusi = new NumRedMsg.NumMsgBusi();
                localNumMsgBusi.ui64_msgid.set(this.jdField_a_of_type_ArrayOfLong[i]);
                localArrayList2.add(localNumMsgBusi);
              }
              i += 1;
              break;
            }
            j += 1;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        i = k;
        while (i < this.jdField_a_of_type_ArrayOfLong.length)
        {
          localObject = new NumRedMsg.NumMsgBusi();
          ((NumRedMsg.NumMsgBusi)localObject).ui64_msgid.set(this.jdField_a_of_type_ArrayOfLong[i]);
          localArrayList2.add(localObject);
          i += 1;
        }
      }
      if ((localArrayList1.size() == this.jdField_a_of_type_ArrayOfLong.length) || (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchNumRedGetMsgCallback.a(this.jdField_a_of_type_JavaLangString, localArrayList1);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchNumRedMsgManager.jdField_a_of_type_ComTencentMobileqqAppNumRedMsgHandler.a(localArrayList2, this.jdField_a_of_type_ComTencentMobileqqRedtouchNumRedGetMsgCallback.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfLong);
      return;
      label355:
      j = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahkb
 * JD-Core Version:    0.7.0.1
 */