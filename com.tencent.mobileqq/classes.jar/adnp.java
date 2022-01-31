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

public class adnp
  extends aizj
{
  public int a;
  private WeakReference<adnk> a;
  
  public adnp(adnk paramadnk)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramadnk);
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
    adnk localadnk = (adnk)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localadnk == null) || (localadnk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] itemBuilder or app null");
      return;
    }
    ApolloGameData localApolloGameData = ((ajmu)localadnk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      aize.a(localadnk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      adnk.a(localadnk).post(new CmGameTipsItemBuilder.ISessionHandler.1(this, localadnk, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      adnk.a(localadnk).post(new CmGameTipsItemBuilder.ISessionHandler.2(this, localadnk, localApolloGameData));
      return;
    }
    QLog.e("ChatItemBuilder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    adnk.a(localadnk).post(new CmGameTipsItemBuilder.ISessionHandler.3(this, localadnk));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    adnk localadnk = (adnk)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localadnk == null) {
      break label17;
    }
    label17:
    while (localadnk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
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
    ajrd localajrd = new ajrd();
    Object localObject = (ajmu)localadnk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = ajya.a(2131702130);
    ApolloGameData localApolloGameData = ((ajmu)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((ajmu)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localajrd.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localajrd.jdField_a_of_type_JavaLangString = str;
        localajrd.jdField_b_of_type_Int = paramInt2;
        localajrd.jdField_a_of_type_Long = paramLong;
        localajrd.jdField_a_of_type_Int = paramInt1;
        localajrd.d = 3;
        localajrd.e = 0;
        if ((localadnk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localadnk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        aize.a(localadnk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localadnk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localajrd);
        if (!aizr.a(localadnk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((airx)localadnk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localadnk.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localajrd.jdField_b_of_type_JavaLangString = ajya.a(2131702131);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adnp
 * JD-Core Version:    0.7.0.1
 */