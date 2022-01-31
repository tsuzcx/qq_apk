import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import com.tencent.mobileqq.troop.utils.TroopNameHelper.GenTroopNameCallback;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ajqc
  extends ajqe
{
  TroopNameHelper.GenTroopNameCallback jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$GenTroopNameCallback;
  String jdField_a_of_type_JavaLangString;
  
  public ajqc(TroopNameHelper paramTroopNameHelper, String paramString, TroopNameHelper.GenTroopNameCallback paramGenTroopNameCallback)
  {
    super(paramTroopNameHelper);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$GenTroopNameCallback = paramGenTroopNameCallback;
  }
  
  public void a()
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(localTroopInfo.troopowneruin))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(Long.parseLong(this.jdField_a_of_type_JavaLangString), 0L, 1, 0, 0);
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.b.put(this.jdField_a_of_type_JavaLangString, this);
        return;
      }
      if ((localObject2 != null) && (((List)localObject2).size() != 0) && ((localTroopInfo.wMemberNum <= 1) || (((List)localObject2).size() > 1))) {
        break;
      }
      localObject1 = (Long)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.jdField_a_of_type_JavaLangString);
    } while ((localObject1 != null) && (System.currentTimeMillis() - ((Long)localObject1).longValue() <= 86400000L));
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.m(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.b.put(this.jdField_a_of_type_JavaLangString, this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(System.currentTimeMillis()));
    return;
    Iterator localIterator = ((List)localObject2).iterator();
    Object localObject3 = null;
    label228:
    if (localIterator.hasNext())
    {
      Object localObject4 = (TroopMemberInfo)localIterator.next();
      localObject2 = new ajqd(this);
      ((ajqd)localObject2).jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject4).memberuin;
      ((ajqd)localObject2).jdField_b_of_type_JavaLangString = ((TroopMemberInfo)localObject4).friendnick;
      ((ajqd)localObject2).c = ((TroopMemberInfo)localObject4).troopnick;
      ((ajqd)localObject2).jdField_a_of_type_Boolean = TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, ((ajqd)localObject2).jdField_a_of_type_JavaLangString);
      ((ajqd)localObject2).jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((ajqd)localObject2).jdField_a_of_type_JavaLangString);
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.c(((ajqd)localObject2).jdField_a_of_type_JavaLangString);
      if ((localObject4 != null) && (((Friends)localObject4).isFriend()))
      {
        ((ajqd)localObject2).d = ((Friends)localObject4).remark;
        ((ajqd)localObject2).jdField_b_of_type_JavaLangString = ((Friends)localObject4).name;
      }
      if ((localObject4 != null) && (((ajqd)localObject2).jdField_b_of_type_Boolean)) {
        ((ajqd)localObject2).jdField_b_of_type_JavaLangString = ((Friends)localObject4).name;
      }
      if (!TextUtils.isEmpty(((ajqd)localObject2).c))
      {
        ((ajqd)localObject2).e = ((ajqd)localObject2).c;
        ((ajqd)localObject2).f = ChnToSpell.a(((ajqd)localObject2).c, 2);
        if ((!((ajqd)localObject2).jdField_b_of_type_Boolean) && (!((ajqd)localObject2).jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(((ajqd)localObject2).e))) {
          localArrayList.add(localObject2);
        }
        if (((ajqd)localObject2).jdField_a_of_type_Boolean) {
          localObject3 = localObject2;
        }
        if (!((ajqd)localObject2).jdField_b_of_type_Boolean) {
          break label756;
        }
        localObject1 = localObject2;
      }
    }
    label427:
    label756:
    for (;;)
    {
      break label228;
      if (!TextUtils.isEmpty(((ajqd)localObject2).d))
      {
        ((ajqd)localObject2).e = ((ajqd)localObject2).d;
        ((ajqd)localObject2).f = ChnToSpell.a(((ajqd)localObject2).d, 2);
        break label427;
      }
      if (TextUtils.isEmpty(((ajqd)localObject2).jdField_b_of_type_JavaLangString)) {
        break label427;
      }
      ((ajqd)localObject2).e = ((ajqd)localObject2).jdField_b_of_type_JavaLangString;
      ((ajqd)localObject2).f = ChnToSpell.a(((ajqd)localObject2).jdField_b_of_type_JavaLangString, 2);
      break label427;
      Collections.sort(localArrayList);
      if ((localObject3 != null) && (localObject1 != null))
      {
        if (!((ajqd)localObject3).jdField_a_of_type_JavaLangString.equals(((ajqd)localObject1).jdField_a_of_type_JavaLangString)) {
          break label646;
        }
        localArrayList.add(localArrayList.size(), localObject3);
      }
      for (;;)
      {
        localObject1 = new ArrayList();
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ajqd)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(((ajqd)localObject3).e)) {
            ((ArrayList)localObject1).add(((ajqd)localObject3).e);
          }
        }
        localArrayList.add(0, localObject3);
        localArrayList.add(localArrayList.size(), localObject1);
      }
      localObject1 = TroopNameHelper.a((ArrayList)localObject1);
      localTroopInfo.newTroopName = ((String)localObject1);
      localTroopInfo.newTroopNameTimeStamp = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(localTroopInfo);
      localObject2 = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(111, true, new Object[] { localObject2, localObject1 });
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$GenTroopNameCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNameHelper$GenTroopNameCallback.a(this.jdField_a_of_type_JavaLangString, (String)localObject1);
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ajqc)) {
      return ((ajqc)paramObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString);
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqc
 * JD-Core Version:    0.7.0.1
 */