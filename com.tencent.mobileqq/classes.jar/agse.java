import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.CmGameTipsItemBuilder.ISessionHandler.1;
import com.tencent.mobileqq.activity.aio.item.CmGameTipsItemBuilder.ISessionHandler.2;
import com.tencent.mobileqq.activity.aio.item.CmGameTipsItemBuilder.ISessionHandler.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class agse
  extends amoq
{
  public int a;
  private WeakReference<agrz> a;
  
  public agse(agrz paramagrz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramagrz);
  }
  
  public void a(int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    }
    if (this.jdField_a_of_type_Int != paramInt2)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] mCreateRoomReqCode != reqCode");
      return;
    }
    agrz localagrz = (agrz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localagrz == null) || (localagrz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] itemBuilder or app null");
      return;
    }
    ApolloGameData localApolloGameData = ((ancd)localagrz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      amol.a(localagrz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      agrz.a(localagrz).post(new CmGameTipsItemBuilder.ISessionHandler.1(this, localagrz, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      agrz.a(localagrz).post(new CmGameTipsItemBuilder.ISessionHandler.2(this, localagrz, localApolloGameData));
      return;
    }
    QLog.e("ChatItemBuilder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    agrz.a(localagrz).post(new CmGameTipsItemBuilder.ISessionHandler.3(this, localagrz));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    agrz localagrz = (agrz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localagrz == null) {
      break label17;
    }
    label17:
    while (localagrz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_Int != paramInt2)
    {
      QLog.e("ChatItemBuilder", 1, "onCreateRoomId mCreateRoomReqCode != reqCode");
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("ChatItemBuilder", 1, "onCreateRoomId createSuccess:false");
      return;
    }
    super.a(paramBoolean, paramInt1, paramLong, paramInt2);
    angn localangn = new angn();
    Object localObject = (ancd)localagrz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = anni.a(2131700934);
    ApolloGameData localApolloGameData = ((ancd)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((ancd)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localangn.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localangn.jdField_a_of_type_JavaLangString = str;
        localangn.jdField_b_of_type_Int = paramInt2;
        localangn.jdField_a_of_type_Long = paramLong;
        localangn.jdField_a_of_type_Int = paramInt1;
        localangn.d = 3;
        localangn.e = 0;
        if ((localagrz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localagrz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        amol.a(localagrz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localagrz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localangn);
        if (!amoy.a(localagrz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((amhd)localagrz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localagrz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localangn.jdField_b_of_type_JavaLangString = anni.a(2131700935);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agse
 * JD-Core Version:    0.7.0.1
 */