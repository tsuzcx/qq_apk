import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aiuj
  implements aiij
{
  private WeakReference<aiug> a;
  
  public aiuj(aiug paramaiug)
  {
    this.a = new WeakReference(paramaiug);
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
        aiug localaiug = (aiug)this.a.get();
        ApolloWebAvatarParam localApolloWebAvatarParam;
        if (localaiug != null)
        {
          localApolloWebAvatarParam = aiug.a(localaiug);
          if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)) && (localaiug.b != null))
          {
            aiug.b(localaiug);
            aiug.a(localaiug).removeMessages(24);
            localaiug.b.stopLoopDelayed(1000L);
            if (!TextUtils.isEmpty(aiug.a(localaiug)))
            {
              if (!aiug.a(localaiug)) {
                break label173;
              }
              if ((aiug.a(localaiug) == 1) && (localaiug.a != null)) {
                localaiug.a.b();
              }
            }
          }
        }
        while ((localaiug != null) && (localaiug.b != null))
        {
          return;
          label173:
          if (aiug.a(localaiug) == 1)
          {
            if (localaiug.a != null) {
              localaiug.a.a(true);
            }
          }
          else {
            localaiug.b.getRenderImpl().a(1, localApolloWebAvatarParam.apolloId, "Bubble");
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
    aiug localaiug;
    ApolloWebAvatarParam localApolloWebAvatarParam;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a == null);
        localaiug = (aiug)this.a.get();
      } while (localaiug == null);
      localApolloWebAvatarParam = aiug.a(localaiug);
    } while ((localApolloWebAvatarParam == null) || (!paramString.equals(localApolloWebAvatarParam.apolloId)));
    aiug.a(localaiug);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiuj
 * JD-Core Version:    0.7.0.1
 */