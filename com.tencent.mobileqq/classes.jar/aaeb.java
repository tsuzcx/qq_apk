import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.GroupInfo;

class aaeb
  extends Handler
{
  public aaeb(aady paramaady)
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    Bundle localBundle;
    int i;
    boolean bool;
    int j;
    Iterator localIterator;
    label610:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localBundle = paramMessage.getData();
          } while (localBundle == null);
          localBundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
          i = localBundle.getInt("seq", -1);
          switch (paramMessage.what)
          {
          }
        } while (i == -1);
        paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      } while (paramMessage == null);
      paramMessage.callback(localBundle);
      return;
      i = localBundle.getInt("type");
      bool = localBundle.getBoolean("isSuccess", false);
      paramMessage = localBundle.getSerializable("data");
      j = localBundle.getInt("observer_type");
      localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    } while (!localIterator.hasNext());
    BusinessObserver localBusinessObserver = (BusinessObserver)localIterator.next();
    Object localObject;
    if (((j == 1) && ((localBusinessObserver instanceof anxj))) || ((j == 2) && ((localBusinessObserver instanceof anvi)))) {
      if (28 == i)
      {
        localObject = localBundle.getByteArray("groupInfo");
        paramMessage = new cmd0x7f5.GroupInfo();
        if (localObject == null) {
          break label2216;
        }
      }
    }
    label2216:
    for (;;)
    {
      try
      {
        paramMessage.mergeFrom((byte[])localObject);
        localObject = new Object[2];
        localObject[0] = Integer.valueOf(localBundle.getInt("count"));
        localObject[1] = paramMessage;
        paramMessage = (Message)localObject;
        localBusinessObserver.onUpdate(i, bool, paramMessage);
      }
      catch (InvalidProtocolBufferMicroException paramMessage)
      {
        paramMessage.printStackTrace();
        paramMessage = null;
        continue;
      }
      if ((j == 3) && ((localBusinessObserver instanceof aofu)))
      {
        ((aofu)localBusinessObserver).onUpdate(i, bool, paramMessage);
        break label610;
      }
      if ((j == 4) && ((localBusinessObserver instanceof anrc)))
      {
        ((anrc)localBusinessObserver).onUpdate(i, bool, paramMessage);
        break label610;
      }
      if ((j != 5) || (!(localBusinessObserver instanceof anwo))) {
        break label610;
      }
      ((anwo)localBusinessObserver).onUpdate(i, bool, paramMessage);
      break label610;
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i != -1)
      {
        j = localBundle.getInt("retCode", -1);
        int k = localBundle.getInt("rate", -1);
        paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
        if (paramMessage != null)
        {
          paramMessage.callback(localBundle);
          if ((j != 0) || (k == 100))
          {
            QLog.d("ReadInJoy", 4, "download finish:" + localBundle);
            this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("readinjoy", 4, "client MSG_READINJOY_LOAD_SKIN retCode=" + j + ",rate=" + k);
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("readinjoy", 4, "client MSG_READINJOY_LOAD_SKIN callback null");
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("readinjoy", 4, "client MSG_READINJOY_LOAD_SKIN seq=" + i);
      return;
      if (this.a.jdField_a_of_type_Anrc == null) {
        break;
      }
      paramMessage = localBundle.getString("pageUrl");
      localObject = localBundle.getStringArrayList("lstVideoUrl");
      i = localBundle.getInt("totalTime", 0);
      this.a.jdField_a_of_type_Anrc.onUpdate(localBundle.getInt("type"), true, new Object[] { paramMessage, localObject, Integer.valueOf(i) });
      return;
      this.a.a().a(localBundle);
      return;
      this.a.a().a(localBundle);
      return;
      localObject = (BusinessObserver)this.a.jdField_a_of_type_AndroidUtilSparseArray.get(localBundle.getInt("req_seq"));
      if (localObject == null) {
        break;
      }
      this.a.jdField_a_of_type_AndroidUtilSparseArray.remove(localBundle.getInt("req_seq"));
      ((BusinessObserver)localObject).onUpdate(paramMessage.what, true, localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq1", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq1", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if ((i == -1) || (paramMessage == null)) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (localBundle == null) {
        break;
      }
      i = localBundle.getInt("seq", -1);
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      paramMessage = localBundle.getString("FileName");
      i = localBundle.getInt("Status");
      if ((aady.a(this.a) == null) || (paramMessage == null) || (aady.a(this.a).get(paramMessage) == null)) {
        break;
      }
      j = ((Integer)aady.a(this.a).get(paramMessage)).intValue();
      if (j == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(j));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      if (i != 11) {
        break;
      }
      this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(j));
      return;
      paramMessage = localBundle.getString("FilePath");
      i = localBundle.getInt("size");
      localObject = paramMessage + "/" + i;
      if ((aady.b(this.a) == null) || (paramMessage == null) || (aady.b(this.a).get(localObject) == null)) {
        break;
      }
      i = ((Integer)aady.b(this.a).get(localObject)).intValue();
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (aady.a(this.a) == null) {
        break;
      }
      aady.a(this.a).callback(localBundle);
      return;
      if (aady.a(this.a) == null) {
        break;
      }
      aady.a(this.a).callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      localBundle.putString("type", "troopCreateOpenAIO");
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      if (paramMessage == null) {
        break;
      }
      localBundle.putBoolean("isSuccess", localBundle.getBoolean("isSuccess"));
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      paramMessage = (aaea)this.a.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      if ((paramMessage == null) || (localBundle == null)) {
        break;
      }
      paramMessage.callback(localBundle);
      return;
      if (i == -1) {
        break;
      }
      this.a.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaeb
 * JD-Core Version:    0.7.0.1
 */