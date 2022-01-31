import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class alei
  implements akrb
{
  alei(aleh paramaleh) {}
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[onCompleteRender] taskId=", Integer.valueOf(paramInt1), ", roleName=", paramString, ", errCode=", Integer.valueOf(paramInt2) });
    }
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("ApolloViewController", 1, "[onCompleteRender] roleName null");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!aleh.a(this.a).containsKey(paramString))
          {
            QLog.e("ApolloViewController", 1, "[onCompleteRender] roleName not showing");
            return;
          }
          if ((aleh.a(this.a) == null) || (TextUtils.isEmpty(aleh.a(this.a).apolloId)) || (!aleh.a(this.a).apolloId.equals(paramString))) {
            break;
          }
          aleh.b(this.a);
          if (this.a.c != 5) {
            this.a.jdField_a_of_type_Int = 1;
          }
          paramString = aleh.a(this.a).obtainMessage(18, 1, 0);
          aleh.a(this.a).sendMessage(paramString);
          this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
        } while (TextUtils.isEmpty(aleh.a(this.a)));
        if (!aleh.a(this.a)) {
          break;
        }
      } while ((aleh.a(this.a) != 1) || (this.a.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null));
      this.a.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.b();
      return;
      if (aleh.a(this.a) != 1) {
        break;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a(true);
    return;
    this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, aleh.a(this.a).apolloId, "Bubble");
    return;
    synchronized (aleh.a(this.a))
    {
      if (aleh.a(this.a).containsKey(paramString))
      {
        Message localMessage = aleh.a(this.a).obtainMessage(28);
        localMessage.obj = paramString;
        aleh.a(this.a).sendMessage(localMessage);
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
      }
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[onStartRender] taskId=", Integer.valueOf(paramInt), ", roleName=", paramString });
    }
    if ((aleh.a(this.a) != null) && (!TextUtils.isEmpty(aleh.a(this.a).apolloId)) && (aleh.a(this.a).apolloId.equals(paramString))) {
      aleh.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alei
 * JD-Core Version:    0.7.0.1
 */