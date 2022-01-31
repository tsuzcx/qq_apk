import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ajpa
  implements aivc, aive
{
  public WeakReference<BaseChatPie> a;
  private WeakReference<aivc> b;
  
  public ajpa(BaseChatPie paramBaseChatPie)
  {
    if (((paramBaseChatPie instanceof aeoo)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof aeoe)) || ((paramBaseChatPie instanceof aeqd))) {
      this.a = new WeakReference(paramBaseChatPie);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBackgroundViewListener", 2, "onCompleteRender");
    }
    if ((this.b != null) && (this.b.get() != null)) {
      ((aivc)this.b.get()).a(paramInt1, paramInt2, paramString);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBackgroundViewListener", 2, "onStartRender");
    }
    if ((this.b != null) && (this.b.get() != null)) {
      ((aivc)this.b.get()).a(paramInt, paramString);
    }
  }
  
  public void a(aivc paramaivc)
  {
    this.b = new WeakReference(paramaivc);
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    Object localObject2 = (BaseChatPie)this.a.get();
    if ((localObject2 == null) || (((BaseChatPie)localObject2).jdField_a_of_type_Aitz == null)) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject2 = ((BaseChatPie)localObject2).jdField_a_of_type_Aitz.a();
      } while ((localObject1 == null) || (localObject2 == null));
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBackgroundViewListener", 2, "surfaceView.getWidth():" + ((ApolloTextureView)localObject2).getWidth());
      }
      ((ApolloTextureView)localObject2).getRenderImpl().a(1, null, 0, 1.0F, 250.0F, 0.0F);
      ((ApolloTextureView)localObject2).getRenderImpl().a(1000L);
      localObject1 = ((ajfg)((AppInterface)localObject1).getManager(249)).a();
    } while (localObject1 == null);
    ((ajex)localObject1).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajpa
 * JD-Core Version:    0.7.0.1
 */