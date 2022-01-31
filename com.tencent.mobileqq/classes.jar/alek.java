import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class alek
  implements akrb
{
  private WeakReference<aleh> a;
  
  public alek(aleh paramaleh)
  {
    this.a = new WeakReference(paramaleh);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "mOtherSurfaceView onCompleteRender, roleName=", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (this.a != null)
      {
        aleh localaleh = (aleh)this.a.get();
        ApolloWebAvatarParam localApolloWebAvatarParam;
        if (localaleh != null)
        {
          localApolloWebAvatarParam = aleh.a(localaleh);
          if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)) && (localaleh.b != null))
          {
            aleh.b(localaleh);
            aleh.a(localaleh).removeMessages(24);
            localaleh.b.stopLoopDelayed(1000L);
            if (!TextUtils.isEmpty(aleh.a(localaleh)))
            {
              if (!aleh.a(localaleh)) {
                break label173;
              }
              if ((aleh.a(localaleh) == 1) && (localaleh.a != null)) {
                localaleh.a.b();
              }
            }
          }
        }
        while ((localaleh != null) && (localaleh.b != null))
        {
          return;
          label173:
          if (aleh.a(localaleh) == 1)
          {
            if (localaleh.a != null) {
              localaleh.a.a(true);
            }
          }
          else {
            localaleh.b.getRenderImpl().a(1, localApolloWebAvatarParam.apolloId, "Bubble");
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "mOtherSurfaceView onStartRender, roleName=", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {}
    aleh localaleh;
    ApolloWebAvatarParam localApolloWebAvatarParam;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a == null);
        localaleh = (aleh)this.a.get();
      } while (localaleh == null);
      localApolloWebAvatarParam = aleh.a(localaleh);
    } while ((localApolloWebAvatarParam == null) || (!paramString.equals(localApolloWebAvatarParam.apolloId)));
    aleh.a(localaleh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alek
 * JD-Core Version:    0.7.0.1
 */