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

public class afko
  extends akvk
{
  public int a;
  private WeakReference<afkj> a;
  
  public afko(afkj paramafkj)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramafkj);
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
    afkj localafkj = (afkj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localafkj == null) || (localafkj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] itemBuilder or app null");
      return;
    }
    ApolloGameData localApolloGameData = ((aliw)localafkj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      akvf.a(localafkj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      afkj.a(localafkj).post(new CmGameTipsItemBuilder.ISessionHandler.1(this, localafkj, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      afkj.a(localafkj).post(new CmGameTipsItemBuilder.ISessionHandler.2(this, localafkj, localApolloGameData));
      return;
    }
    QLog.e("ChatItemBuilder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    afkj.a(localafkj).post(new CmGameTipsItemBuilder.ISessionHandler.3(this, localafkj));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    afkj localafkj = (afkj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localafkj == null) {
      break label17;
    }
    label17:
    while (localafkj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
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
    alnf localalnf = new alnf();
    Object localObject = (aliw)localafkj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = alud.a(2131702514);
    ApolloGameData localApolloGameData = ((aliw)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((aliw)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localalnf.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localalnf.jdField_a_of_type_JavaLangString = str;
        localalnf.jdField_b_of_type_Int = paramInt2;
        localalnf.jdField_a_of_type_Long = paramLong;
        localalnf.jdField_a_of_type_Int = paramInt1;
        localalnf.d = 3;
        localalnf.e = 0;
        if ((localafkj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localafkj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        akvf.a(localafkj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localafkj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localalnf);
        if (!akvs.a(localafkj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((aknx)localafkj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localafkj.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localalnf.jdField_b_of_type_JavaLangString = alud.a(2131702515);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afko
 * JD-Core Version:    0.7.0.1
 */