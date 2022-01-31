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

public class ajpu
  extends aizj
{
  public int a;
  private WeakReference<ajpl> a;
  
  public ajpu(ajpl paramajpl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramajpl);
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
    ajpl localajpl = (ajpl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localajpl == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder null");
      return;
    }
    if (ajpl.a(localajpl) == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder app null");
      return;
    }
    ApolloGameData localApolloGameData = ((ajmu)ajpl.a(localajpl).getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      aize.a(ajpl.a(localajpl), paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      ajpl.a(localajpl).post(new ApolloGameViewBinder.ISessionHandler.1(this, localajpl, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      ajpl.a(localajpl).post(new ApolloGameViewBinder.ISessionHandler.2(this, localajpl, localApolloGameData));
      return;
    }
    QLog.e("ApolloGameViewBinder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    ajpl.a(localajpl).post(new ApolloGameViewBinder.ISessionHandler.3(this, localajpl));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    ajpl localajpl = (ajpl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localajpl == null) {
      break label17;
    }
    label17:
    while (ajpl.a(localajpl) == null) {
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
    ajrd localajrd = new ajrd();
    Object localObject = (ajmu)ajpl.a(localajpl).getManager(155);
    String str = ajya.a(2131700347);
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
        if ((ajpl.a(localajpl) == null) || (ajpl.a(localajpl) == null)) {
          break;
        }
        aize.a(ajpl.a(localajpl), ajpl.a(localajpl).jdField_a_of_type_JavaLangString, localajrd);
        if (!aizr.a(ajpl.a(localajpl).jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((airx)ajpl.a(localajpl).getManager(153)).a().b(ajpl.a(localajpl).jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localajrd.jdField_b_of_type_JavaLangString = ajya.a(2131700387);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajpu
 * JD-Core Version:    0.7.0.1
 */