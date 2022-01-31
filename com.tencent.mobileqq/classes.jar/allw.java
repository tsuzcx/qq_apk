import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.ISessionHandler.1;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.ISessionHandler.2;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.ISessionHandler.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class allw
  extends akvk
{
  public int a;
  private WeakReference<alln> a;
  
  public allw(alln paramalln)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramalln);
  }
  
  public void a(int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameViewBinder", 2, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong), ", gameId=", Integer.valueOf(paramInt1), ", resultStr=", paramString2 });
    }
    if (this.jdField_a_of_type_Int != paramInt2)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] mCreateRoomReqCode != reqCode");
      return;
    }
    alln localalln = (alln)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localalln == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder null");
      return;
    }
    if (alln.a(localalln) == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder app null");
      return;
    }
    ApolloGameData localApolloGameData = ((aliw)alln.a(localalln).getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      akvf.a(alln.a(localalln), paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      alln.a(localalln).post(new ApolloGameViewBinder.ISessionHandler.1(this, localalln, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      alln.a(localalln).post(new ApolloGameViewBinder.ISessionHandler.2(this, localalln, localApolloGameData));
      return;
    }
    QLog.e("ApolloGameViewBinder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    alln.a(localalln).post(new ApolloGameViewBinder.ISessionHandler.3(this, localalln));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    alln localalln = (alln)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localalln == null) {
      break label17;
    }
    label17:
    while (alln.a(localalln) == null) {
      return;
    }
    if (this.jdField_a_of_type_Int != paramInt2)
    {
      QLog.e("ApolloGameViewBinder", 1, "onCreateRoomId mCreateRoomReqCode != reqCode");
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("ApolloGameViewBinder", 1, "onCreateRoomId createSuccess:false");
      return;
    }
    super.a(paramBoolean, paramInt1, paramLong, paramInt2);
    alnf localalnf = new alnf();
    Object localObject = (aliw)alln.a(localalln).getManager(155);
    String str = alud.a(2131700728);
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
        if ((alln.a(localalln) == null) || (alln.a(localalln) == null)) {
          break;
        }
        akvf.a(alln.a(localalln), alln.a(localalln).jdField_a_of_type_JavaLangString, localalnf);
        if (!akvs.a(alln.a(localalln).jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((aknx)alln.a(localalln).getManager(153)).a().b(alln.a(localalln).jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localalnf.jdField_b_of_type_JavaLangString = alud.a(2131700768);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allw
 * JD-Core Version:    0.7.0.1
 */