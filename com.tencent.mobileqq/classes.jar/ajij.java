import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ajij
  implements aiva
{
  private WeakReference<ajig> a;
  
  public ajij(ajig paramajig)
  {
    this.a = new WeakReference(paramajig);
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
        ajig localajig = (ajig)this.a.get();
        ApolloWebAvatarParam localApolloWebAvatarParam;
        if (localajig != null)
        {
          localApolloWebAvatarParam = ajig.a(localajig);
          if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)) && (localajig.b != null))
          {
            ajig.b(localajig);
            ajig.a(localajig).removeMessages(24);
            localajig.b.stopLoopDelayed(1000L);
            if (!TextUtils.isEmpty(ajig.a(localajig)))
            {
              if (!ajig.a(localajig)) {
                break label173;
              }
              if ((ajig.a(localajig) == 1) && (localajig.a != null)) {
                localajig.a.b();
              }
            }
          }
        }
        while ((localajig != null) && (localajig.b != null))
        {
          return;
          label173:
          if (ajig.a(localajig) == 1)
          {
            if (localajig.a != null) {
              localajig.a.a(true);
            }
          }
          else {
            localajig.b.getRenderImpl().a(1, localApolloWebAvatarParam.apolloId, "Bubble");
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
    ajig localajig;
    ApolloWebAvatarParam localApolloWebAvatarParam;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a == null);
        localajig = (ajig)this.a.get();
      } while (localajig == null);
      localApolloWebAvatarParam = ajig.a(localajig);
    } while ((localApolloWebAvatarParam == null) || (!paramString.equals(localApolloWebAvatarParam.apolloId)));
    ajig.a(localajig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajij
 * JD-Core Version:    0.7.0.1
 */