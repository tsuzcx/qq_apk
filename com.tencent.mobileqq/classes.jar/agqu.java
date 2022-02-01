import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.CmGameTipsItemBuilder.ISessionHandler.1;
import com.tencent.mobileqq.activity.aio.item.CmGameTipsItemBuilder.ISessionHandler.2;
import com.tencent.mobileqq.activity.aio.item.CmGameTipsItemBuilder.ISessionHandler.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class agqu
  extends amug
{
  public int a;
  private WeakReference<agqp> a;
  
  public agqu(agqp paramagqp)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramagqp);
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
    agqp localagqp = (agqp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localagqp == null) || (localagqp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] itemBuilder or app null");
      return;
    }
    ApolloGameData localApolloGameData = ((ankc)localagqp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      amub.a(localagqp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      agqp.a(localagqp).post(new CmGameTipsItemBuilder.ISessionHandler.1(this, localagqp, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      agqp.a(localagqp).post(new CmGameTipsItemBuilder.ISessionHandler.2(this, localagqp, localApolloGameData));
      return;
    }
    QLog.e("ChatItemBuilder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    agqp.a(localagqp).post(new CmGameTipsItemBuilder.ISessionHandler.3(this, localagqp));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    agqp localagqp = (agqp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localagqp == null) {
      break label17;
    }
    label17:
    while (localagqp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
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
    amri localamri = new amri();
    Object localObject = (ankc)localagqp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
    String str = anvx.a(2131701627);
    ApolloGameData localApolloGameData = ((ankc)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((ankc)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localamri.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localamri.jdField_a_of_type_JavaLangString = str;
        localamri.jdField_b_of_type_Int = paramInt2;
        localamri.jdField_a_of_type_Long = paramLong;
        localamri.jdField_a_of_type_Int = paramInt1;
        localamri.d = 3;
        localamri.e = 0;
        if ((localagqp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localagqp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        amub.a(localagqp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localagqp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, localamri);
        if (!amuo.a(localagqp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
          break;
        }
        ((amme)localagqp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_MANAGER)).a().b(localagqp.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramInt1, paramLong);
        return;
        localamri.jdField_b_of_type_JavaLangString = anvx.a(2131701628);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqu
 * JD-Core Version:    0.7.0.1
 */