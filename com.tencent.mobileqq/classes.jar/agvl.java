import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.qcall.QCallProxy.QueryRecentCallsListener;
import com.tencent.mobileqq.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agvl
  implements Runnable
{
  public agvl(QCallProxy paramQCallProxy, QCallProxy.QueryRecentCallsListener paramQueryRecentCallsListener) {}
  
  public void run()
  {
    Object localObject8;
    Object localObject6;
    Object localObject5;
    Object localObject4;
    int k;
    int i;
    int j;
    Object localObject9;
    Object localObject10;
    label224:
    label242:
    int m;
    for (;;)
    {
      Object localObject11;
      synchronized (QCallProxy.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy))
      {
        Object localObject1 = new ArrayList();
        localObject8 = new ArrayList();
        localObject7 = new ArrayList();
        localObject6 = new ArrayList();
        localObject5 = (PhoneContactManager)QCallProxy.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy).getManager(10);
        localObject4 = (FriendsManager)QCallProxy.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy).getManager(50);
        k = 0;
        i = 0;
        j = k;
        if (localObject5 == null) {
          break label1088;
        }
        j = k;
        if (!((PhoneContactManager)localObject5).c()) {
          break label1088;
        }
        j = k;
        if (localObject4 == null) {
          break label1088;
        }
        localObject9 = QCallProxy.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy).iterator();
        if (((Iterator)localObject9).hasNext())
        {
          localObject10 = (QCallRecent)((Iterator)localObject9).next();
          j = i;
          if (localObject10 == null) {
            break label1227;
          }
          j = i;
          if (((QCallRecent)localObject10).uin == null) {
            break label1227;
          }
          j = i;
          if (((QCallRecent)localObject10).uin.length() < 2) {
            break label1227;
          }
          if (((QCallRecent)localObject10).type == 1006)
          {
            localObject11 = ((PhoneContactManager)localObject5).c(((QCallRecent)localObject10).uin);
            if ((localObject11 == null) || (!((FriendsManager)localObject4).b(((PhoneContact)localObject11).uin))) {
              break label1232;
            }
            j = 1;
            if ((localObject11 == null) || (!TextUtils.isEmpty(((PhoneContact)localObject11).uin))) {
              break label1237;
            }
            k = 1;
            if (j != 0)
            {
              ((List)localObject1).add(localObject10);
              i = 1;
            }
            j = i;
            if (k == 0) {
              break label1227;
            }
            ((List)localObject8).add(localObject10);
            i = 1;
            break label1229;
          }
          j = i;
          if (((QCallRecent)localObject10).type != 56938) {
            break label1227;
          }
          localObject11 = ((PhoneContactManager)localObject5).b(((QCallRecent)localObject10).uin);
          if ((localObject11 == null) || (!((FriendsManager)localObject4).b(((PhoneContact)localObject11).uin))) {
            break label1242;
          }
          j = 1;
          label325:
          if ((localObject11 == null) || (TextUtils.isEmpty(((PhoneContact)localObject11).uin))) {
            break label1247;
          }
          k = 1;
          label343:
          if (j != 0)
          {
            ((List)localObject7).add(localObject10);
            i = 1;
          }
          j = i;
          if (k == 0) {
            break label1227;
          }
          ((List)localObject6).add(localObject10);
          i = 1;
          break label1229;
        }
        localObject9 = ((List)localObject1).iterator();
        if (!((Iterator)localObject9).hasNext()) {
          break;
        }
        localObject4 = (QCallRecent)((Iterator)localObject9).next();
        localObject10 = ((QCallRecent)localObject4).uin;
        this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.a((QCallRecent)localObject4);
        localObject1 = ((PhoneContactManager)localObject5).c((String)localObject10);
        if (localObject1 == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.a((QCallRecent)localObject4);
        localObject11 = ((PhoneContact)localObject1).uin;
        int[] arrayOfInt = MsgProxyUtils.q;
        k = arrayOfInt.length;
        localObject1 = null;
        j = 0;
        if (j < k)
        {
          m = arrayOfInt[j];
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.b((String)localObject11, m);
          if (localObject1 == null) {}
        }
        else
        {
          if (localObject1 == null) {
            break label637;
          }
          if (((QCallRecent)localObject4).lastCallTime <= ((QCallRecent)localObject1).lastCallTime) {
            break label616;
          }
          ((QCallRecent)localObject4).uin = ((String)localObject11);
          ((QCallRecent)localObject4).type = ((QCallRecent)localObject1).type;
          ((QCallRecent)localObject4).troopUin = ((QCallRecent)localObject1).troopUin;
          j = ((QCallRecent)localObject4).missedCallCount;
          ((QCallRecent)localObject1).missedCallCount += j;
          localObject1 = localObject4;
          this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.a((String)localObject10, 1006, (String)localObject11, ((QCallRecent)localObject1).type);
          this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.d((QCallRecent)localObject1);
        }
      }
      j += 1;
      continue;
      label616:
      j = localObject2.missedCallCount;
      localObject2.missedCallCount = (((QCallRecent)localObject4).missedCallCount + j);
      continue;
      label637:
      ((QCallRecent)localObject4).uin = ((String)localObject11);
      ((QCallRecent)localObject4).type = 0;
      localObject3 = localObject4;
    }
    Object localObject3 = ((List)localObject8).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (QCallRecent)((Iterator)localObject3).next();
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.a((QCallRecent)localObject4);
      this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.a(((QCallRecent)localObject4).uin, ((QCallRecent)localObject4).type);
    }
    Object localObject7 = ((List)localObject7).iterator();
    while (((Iterator)localObject7).hasNext())
    {
      localObject4 = (QCallRecent)((Iterator)localObject7).next();
      localObject3 = ((PhoneContactManager)localObject5).b(((QCallRecent)localObject4).uin);
      if (localObject3 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.a((QCallRecent)localObject4);
        localObject8 = ((PhoneContact)localObject3).mobileCode;
        localObject9 = ((PhoneContact)localObject3).uin;
        localObject10 = MsgProxyUtils.q;
        k = localObject10.length;
        localObject3 = null;
        j = 0;
      }
    }
    for (;;)
    {
      if (j < k)
      {
        m = localObject10[j];
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.b((String)localObject9, m);
        if (localObject3 == null) {}
      }
      else
      {
        if (localObject3 != null) {
          if (((QCallRecent)localObject4).lastCallTime > ((QCallRecent)localObject3).lastCallTime)
          {
            ((QCallRecent)localObject4).uin = ((String)localObject9);
            ((QCallRecent)localObject4).type = ((QCallRecent)localObject3).type;
            ((QCallRecent)localObject4).troopUin = ((QCallRecent)localObject3).troopUin;
            j = ((QCallRecent)localObject4).missedCallCount;
            ((QCallRecent)localObject3).missedCallCount += j;
            localObject3 = localObject4;
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.a((String)localObject8, 1006, (String)localObject9, ((QCallRecent)localObject3).type);
          this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.d((QCallRecent)localObject3);
          break;
          j = ((QCallRecent)localObject3).missedCallCount;
          ((QCallRecent)localObject4).missedCallCount += j;
          continue;
          ((QCallRecent)localObject4).uin = ((String)localObject9);
          ((QCallRecent)localObject4).type = 0;
          localObject3 = localObject4;
        }
        localObject3 = ((List)localObject6).iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (QCallRecent)((Iterator)localObject3).next();
          localObject6 = ((QCallRecent)localObject4).uin;
          localObject7 = ((PhoneContactManager)localObject5).b((String)localObject6);
          if (localObject7 != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.a((QCallRecent)localObject4);
            localObject7 = ((PhoneContact)localObject7).mobileCode;
            this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.a((String)localObject6, 56938, (String)localObject7, 1006);
            ((QCallRecent)localObject4).uin = ((String)localObject7);
            ((QCallRecent)localObject4).type = 1006;
            this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy.d((QCallRecent)localObject4);
          }
        }
        label1088:
        if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy$QueryRecentCallsListener != null))
        {
          localObject3 = new ArrayList();
          localObject4 = QCallProxy.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (QCallRecent)((Iterator)localObject4).next();
            if ((localObject5 == null) || (((QCallRecent)localObject5).uin == null) || (((QCallRecent)localObject5).uin.length() < 2)) {
              Utils.a("QCallProxy");
            }
            if ((localObject5 != null) && (((QCallRecent)localObject5).uin != null) && (((QCallRecent)localObject5).uin.length() >= 2)) {
              ((List)localObject3).add(localObject5);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqQcallQCallProxy$QueryRecentCallsListener.a((List)localObject3);
        }
        return;
        label1227:
        i = j;
        label1229:
        break;
        label1232:
        j = 0;
        break label224;
        label1237:
        k = 0;
        break label242;
        label1242:
        j = 0;
        break label325;
        label1247:
        k = 0;
        break label343;
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agvl
 * JD-Core Version:    0.7.0.1
 */