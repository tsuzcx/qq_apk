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

public class adnr
  extends aizl
{
  public int a;
  private WeakReference<adnm> a;
  
  public adnr(adnm paramadnm)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramadnm);
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
    adnm localadnm = (adnm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localadnm == null) || (localadnm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] itemBuilder or app null");
      return;
    }
    ApolloGameData localApolloGameData = ((ajmw)localadnm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      aizg.a(localadnm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      adnm.a(localadnm).post(new CmGameTipsItemBuilder.ISessionHandler.1(this, localadnm, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      adnm.a(localadnm).post(new CmGameTipsItemBuilder.ISessionHandler.2(this, localadnm, localApolloGameData));
      return;
    }
    QLog.e("ChatItemBuilder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    adnm.a(localadnm).post(new CmGameTipsItemBuilder.ISessionHandler.3(this, localadnm));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    adnm localadnm = (adnm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localadnm == null) {
      break label17;
    }
    label17:
    while (localadnm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
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
    ajrf localajrf = new ajrf();
    Object localObject = (ajmw)localadnm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = ajyc.a(2131702119);
    ApolloGameData localApolloGameData = ((ajmw)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((ajmw)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localajrf.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localajrf.jdField_a_of_type_JavaLangString = str;
        localajrf.jdField_b_of_type_Int = paramInt2;
        localajrf.jdField_a_of_type_Long = paramLong;
        localajrf.jdField_a_of_type_Int = paramInt1;
        localajrf.d = 3;
        localajrf.e = 0;
        if ((localadnm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localadnm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        aizg.a(localadnm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localadnm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localajrf);
        if (!aizt.a(localadnm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((airz)localadnm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localadnm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localajrf.jdField_b_of_type_JavaLangString = ajyc.a(2131702120);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adnr
 * JD-Core Version:    0.7.0.1
 */