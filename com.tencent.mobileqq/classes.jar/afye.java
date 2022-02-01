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

public class afye
  extends alve
{
  public int a;
  private WeakReference<afxz> a;
  
  public afye(afxz paramafxz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramafxz);
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
    afxz localafxz = (afxz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localafxz == null) || (localafxz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] itemBuilder or app null");
      return;
    }
    ApolloGameData localApolloGameData = ((amir)localafxz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      aluz.a(localafxz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      afxz.a(localafxz).post(new CmGameTipsItemBuilder.ISessionHandler.1(this, localafxz, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      afxz.a(localafxz).post(new CmGameTipsItemBuilder.ISessionHandler.2(this, localafxz, localApolloGameData));
      return;
    }
    QLog.e("ChatItemBuilder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    afxz.a(localafxz).post(new CmGameTipsItemBuilder.ISessionHandler.3(this, localafxz));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    afxz localafxz = (afxz)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localafxz == null) {
      break label17;
    }
    label17:
    while (localafxz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
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
    ammz localammz = new ammz();
    Object localObject = (amir)localafxz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = amtj.a(2131701276);
    ApolloGameData localApolloGameData = ((amir)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((amir)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localammz.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localammz.jdField_a_of_type_JavaLangString = str;
        localammz.jdField_b_of_type_Int = paramInt2;
        localammz.jdField_a_of_type_Long = paramLong;
        localammz.jdField_a_of_type_Int = paramInt1;
        localammz.d = 3;
        localammz.e = 0;
        if ((localafxz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localafxz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        aluz.a(localafxz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localafxz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, localammz);
        if (!alvm.a(localafxz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
          break;
        }
        ((alnr)localafxz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localafxz.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramInt1, paramLong);
        return;
        localammz.jdField_b_of_type_JavaLangString = amtj.a(2131701277);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afye
 * JD-Core Version:    0.7.0.1
 */