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

public class adcp
  extends aims
{
  public int a;
  private WeakReference<adck> a;
  
  public adcp(adck paramadck)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramadck);
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
    adck localadck = (adck)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localadck == null) || (localadck.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] itemBuilder or app null");
      return;
    }
    ApolloGameData localApolloGameData = ((aiyu)localadck.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      aimn.a(localadck.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      adck.a(localadck).post(new CmGameTipsItemBuilder.ISessionHandler.1(this, localadck, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      adck.a(localadck).post(new CmGameTipsItemBuilder.ISessionHandler.2(this, localadck, localApolloGameData));
      return;
    }
    QLog.e("ChatItemBuilder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    adck.a(localadck).post(new CmGameTipsItemBuilder.ISessionHandler.3(this, localadck));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    adck localadck = (adck)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localadck == null) {
      break label17;
    }
    label17:
    while (localadck.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
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
    ajdd localajdd = new ajdd();
    Object localObject = (aiyu)localadck.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = ajjy.a(2131636335);
    ApolloGameData localApolloGameData = ((aiyu)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((aiyu)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localajdd.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localajdd.jdField_a_of_type_JavaLangString = str;
        localajdd.jdField_b_of_type_Int = paramInt2;
        localajdd.jdField_a_of_type_Long = paramLong;
        localajdd.jdField_a_of_type_Int = paramInt1;
        localajdd.d = 3;
        localajdd.e = 0;
        if ((localadck.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localadck.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        aimn.a(localadck.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localadck.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localajdd);
        if (!aina.a(localadck.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((aifg)localadck.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localadck.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localajdd.jdField_b_of_type_JavaLangString = ajjy.a(2131636336);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adcp
 * JD-Core Version:    0.7.0.1
 */