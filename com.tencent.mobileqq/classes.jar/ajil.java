import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ajil
  implements aivc
{
  private WeakReference<ajii> a;
  
  public ajil(ajii paramajii)
  {
    this.a = new WeakReference(paramajii);
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
        ajii localajii = (ajii)this.a.get();
        ApolloWebAvatarParam localApolloWebAvatarParam;
        if (localajii != null)
        {
          localApolloWebAvatarParam = ajii.a(localajii);
          if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)) && (localajii.b != null))
          {
            ajii.b(localajii);
            ajii.a(localajii).removeMessages(24);
            localajii.b.stopLoopDelayed(1000L);
            if (!TextUtils.isEmpty(ajii.a(localajii)))
            {
              if (!ajii.a(localajii)) {
                break label173;
              }
              if ((ajii.a(localajii) == 1) && (localajii.a != null)) {
                localajii.a.b();
              }
            }
          }
        }
        while ((localajii != null) && (localajii.b != null))
        {
          return;
          label173:
          if (ajii.a(localajii) == 1)
          {
            if (localajii.a != null) {
              localajii.a.a(true);
            }
          }
          else {
            localajii.b.getRenderImpl().a(1, localApolloWebAvatarParam.apolloId, "Bubble");
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
    ajii localajii;
    ApolloWebAvatarParam localApolloWebAvatarParam;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a == null);
        localajii = (ajii)this.a.get();
      } while (localajii == null);
      localApolloWebAvatarParam = ajii.a(localajii);
    } while ((localApolloWebAvatarParam == null) || (!paramString.equals(localApolloWebAvatarParam.apolloId)));
    ajii.a(localajii);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajil
 * JD-Core Version:    0.7.0.1
 */