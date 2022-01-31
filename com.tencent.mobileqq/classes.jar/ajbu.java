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

public class ajbu
  extends aims
{
  public int a;
  private WeakReference<ajbl> a;
  
  public ajbu(ajbl paramajbl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramajbl);
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
    ajbl localajbl = (ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localajbl == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder null");
      return;
    }
    if (ajbl.a(localajbl) == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] viewBinder app null");
      return;
    }
    ApolloGameData localApolloGameData = ((aiyu)ajbl.a(localajbl).getManager(155)).a(paramInt1);
    if (localApolloGameData == null)
    {
      QLog.e("ApolloGameViewBinder", 1, "[onQueryVirtualRoomInfo] gameData null");
      return;
    }
    if (paramLong == 0L)
    {
      aimn.a(ajbl.a(localajbl), paramString1, paramString2);
      return;
    }
    if (paramLong == -300404L)
    {
      ajbl.a(localajbl).post(new ApolloGameViewBinder.ISessionHandler.1(this, localajbl, localApolloGameData));
      return;
    }
    if (paramLong == -300405L)
    {
      ajbl.a(localajbl).post(new ApolloGameViewBinder.ISessionHandler.2(this, localajbl, localApolloGameData));
      return;
    }
    QLog.e("ApolloGameViewBinder", 1, new Object[] { "[onQueryVirtualRoomInfo] errCode=", Long.valueOf(paramLong) });
    ajbl.a(localajbl).post(new ApolloGameViewBinder.ISessionHandler.3(this, localajbl));
  }
  
  public void a(boolean paramBoolean, int paramInt1, long paramLong, int paramInt2)
  {
    ajbl localajbl = (ajbl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localajbl == null) {
      break label17;
    }
    label17:
    while (ajbl.a(localajbl) == null) {
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
    ajdd localajdd = new ajdd();
    Object localObject = (aiyu)ajbl.a(localajbl).getManager(155);
    String str = ajjy.a(2131634548);
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
        if ((ajbl.a(localajbl) == null) || (ajbl.a(localajbl) == null)) {
          break;
        }
        aimn.a(ajbl.a(localajbl), ajbl.a(localajbl).jdField_a_of_type_JavaLangString, localajdd);
        if (!aina.a(ajbl.a(localajbl).jdField_a_of_type_JavaLangString)) {
          break;
        }
        ((aifg)ajbl.a(localajbl).getManager(153)).a().b(ajbl.a(localajbl).jdField_a_of_type_JavaLangString, paramInt1, paramLong);
        return;
        localajdd.jdField_b_of_type_JavaLangString = ajjy.a(2131634588);
        paramInt2 = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajbu
 * JD-Core Version:    0.7.0.1
 */