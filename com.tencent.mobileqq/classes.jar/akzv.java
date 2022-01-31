import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class akzv
  implements akmm
{
  private WeakReference<akzs> a;
  
  public akzv(akzs paramakzs)
  {
    this.a = new WeakReference(paramakzs);
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
        akzs localakzs = (akzs)this.a.get();
        ApolloWebAvatarParam localApolloWebAvatarParam;
        if (localakzs != null)
        {
          localApolloWebAvatarParam = akzs.a(localakzs);
          if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)) && (localakzs.b != null))
          {
            akzs.b(localakzs);
            akzs.a(localakzs).removeMessages(24);
            localakzs.b.stopLoopDelayed(1000L);
            if (!TextUtils.isEmpty(akzs.a(localakzs)))
            {
              if (!akzs.a(localakzs)) {
                break label173;
              }
              if ((akzs.a(localakzs) == 1) && (localakzs.a != null)) {
                localakzs.a.b();
              }
            }
          }
        }
        while ((localakzs != null) && (localakzs.b != null))
        {
          return;
          label173:
          if (akzs.a(localakzs) == 1)
          {
            if (localakzs.a != null) {
              localakzs.a.a(true);
            }
          }
          else {
            localakzs.b.getRenderImpl().a(1, localApolloWebAvatarParam.apolloId, "Bubble");
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
    akzs localakzs;
    ApolloWebAvatarParam localApolloWebAvatarParam;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a == null);
        localakzs = (akzs)this.a.get();
      } while (localakzs == null);
      localApolloWebAvatarParam = akzs.a(localakzs);
    } while ((localApolloWebAvatarParam == null) || (!paramString.equals(localApolloWebAvatarParam.apolloId)));
    akzs.a(localakzs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzv
 * JD-Core Version:    0.7.0.1
 */