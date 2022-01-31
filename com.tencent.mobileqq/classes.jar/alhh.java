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

public class alhh
  extends akqv
{
  public int a;
  private WeakReference<algy> a;
  
  public alhh(algy paramalgy)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramalgy);
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
    algy localalgy = (algy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localalgy == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder null");
      return;
    }
    if (algy.a(localalgy) == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder app null");
      return;
    }
    ApolloGameData localApolloGameData = ((aleh)algy.a(localalgy).getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      akqq.a(algy.a(localalgy), paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      algy.a(localalgy).post(new ApolloGameViewBinder.ISessionHandler.1(this, localalgy, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      algy.a(localalgy).post(new ApolloGameViewBinder.ISessionHandler.2(this, localalgy, localApolloGameData));
      return;
    }
    QLog.e("ApolloGameViewBinder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    algy.a(localalgy).post(new ApolloGameViewBinder.ISessionHandler.3(this, localalgy));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    algy localalgy = (algy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localalgy == null) {
      break label17;
    }
    label17:
    while (algy.a(localalgy) == null) {
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
    aliq localaliq = new aliq();
    Object localObject = (aleh)algy.a(localalgy).getManager(155);
    String str = alpo.a(2131700716);
    ApolloGameData localApolloGameData = ((aleh)localObject).a(paramInt1);
    if ((localApolloGameData != null) && (!TextUtils.isEmpty(localApolloGameData.name)))
    {
      localObject = ((aleh)localObject).a(localApolloGameData.actionId);
      if (localObject == null) {
        break label296;
      }
      str = ((ApolloActionData)localObject).actionName;
    }
    label296:
    for (;;)
    {
      paramInt2 = localApolloGameData.actionId;
      localaliq.jdField_b_of_type_JavaLangString = localApolloGameData.name;
      for (;;)
      {
        localaliq.jdField_a_of_type_JavaLangString = str;
        localaliq.jdField_b_of_type_Int = paramInt2;
        localaliq.jdField_a_of_type_Long = paramLong;
        localaliq.jdField_a_of_type_Int = paramInt1;
        localaliq.d = 3;
        localaliq.e = 0;
        if ((algy.a(localalgy) == null) || (algy.a(localalgy) == null)) {
          break;
        }
        akqq.a(algy.a(localalgy), algy.a(localalgy).jdField_a_of_type_JavaLangString, localaliq);
        if (!akrd.a(algy.a(localalgy).jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((akji)algy.a(localalgy).getManager(153)).a().b(algy.a(localalgy).jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localaliq.jdField_b_of_type_JavaLangString = alpo.a(2131700756);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhh
 * JD-Core Version:    0.7.0.1
 */