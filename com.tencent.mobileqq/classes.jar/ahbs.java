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

public class ahbs
  extends anak
{
  public int a;
  private WeakReference<ahbn> a;
  
  public ahbs(ahbn paramahbn)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramahbn);
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
    ahbn localahbn = (ahbn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localahbn == null) || (localahbn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] itemBuilder or app null");
      return;
    }
    ApolloGameData localApolloGameData = ((annx)localahbn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ChatItemBuilder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      anaf.a(localahbn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      ahbn.a(localahbn).post(new CmGameTipsItemBuilder.ISessionHandler.1(this, localahbn, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      ahbn.a(localahbn).post(new CmGameTipsItemBuilder.ISessionHandler.2(this, localahbn, localApolloGameData));
      return;
    }
    QLog.e("ChatItemBuilder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    ahbn.a(localahbn).post(new CmGameTipsItemBuilder.ISessionHandler.3(this, localahbn));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    ahbn localahbn = (ahbn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localahbn == null) {
      break label17;
    }
    label17:
    while (localahbn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
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
    ansi localansi = new ansi();
    Object localObject = (annx)localahbn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
    String str = anzj.a(2131701041);
    ApolloGameData localApolloGameData = ((annx)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((annx)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localansi.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localansi.jdField_a_of_type_JavaLangString = str;
        localansi.jdField_b_of_type_Int = paramInt2;
        localansi.jdField_a_of_type_Long = paramLong;
        localansi.jdField_a_of_type_Int = paramInt1;
        localansi.d = 3;
        localansi.e = 0;
        if ((localahbn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localahbn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        anaf.a(localahbn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localahbn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localansi);
        if (!anas.a(localahbn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((amsx)localahbn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).a().b(localahbn.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localansi.jdField_b_of_type_JavaLangString = anzj.a(2131701042);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbs
 * JD-Core Version:    0.7.0.1
 */