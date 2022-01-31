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

public class ajpw
  extends aizl
{
  public int a;
  private WeakReference<ajpn> a;
  
  public ajpw(ajpn paramajpn)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramajpn);
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
    ajpn localajpn = (ajpn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localajpn == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder null");
      return;
    }
    if (ajpn.a(localajpn) == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder app null");
      return;
    }
    ApolloGameData localApolloGameData = ((ajmw)ajpn.a(localajpn).getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      aizg.a(ajpn.a(localajpn), paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      ajpn.a(localajpn).post(new ApolloGameViewBinder.ISessionHandler.1(this, localajpn, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      ajpn.a(localajpn).post(new ApolloGameViewBinder.ISessionHandler.2(this, localajpn, localApolloGameData));
      return;
    }
    QLog.e("ApolloGameViewBinder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    ajpn.a(localajpn).post(new ApolloGameViewBinder.ISessionHandler.3(this, localajpn));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    ajpn localajpn = (ajpn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localajpn == null) {
      break label17;
    }
    label17:
    while (ajpn.a(localajpn) == null) {
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
    ajrf localajrf = new ajrf();
    Object localObject = (ajmw)ajpn.a(localajpn).getManager(155);
    String str = ajyc.a(2131700336);
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
        if ((ajpn.a(localajpn) == null) || (ajpn.a(localajpn) == null)) {
          break;
        }
        aizg.a(ajpn.a(localajpn), ajpn.a(localajpn).jdField_a_of_type_JavaLangString, localajrf);
        if (!aizt.a(ajpn.a(localajpn).jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((airz)ajpn.a(localajpn).getManager(153)).a().b(ajpn.a(localajpn).jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localajrf.jdField_b_of_type_JavaLangString = ajyc.a(2131700376);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajpw
 * JD-Core Version:    0.7.0.1
 */