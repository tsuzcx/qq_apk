import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

public class alds
  implements akrd
{
  private SoftReference<ApolloGuestsStateActivity> a;
  
  public alds(ApolloGuestsStateActivity paramApolloGuestsStateActivity)
  {
    this.a = new SoftReference(paramApolloGuestsStateActivity);
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGuestsStateActivity", 2, "apollo view is Ready.");
    }
    ApolloGuestsStateActivity localApolloGuestsStateActivity = (ApolloGuestsStateActivity)this.a.get();
    if ((localApolloGuestsStateActivity == null) || (localApolloGuestsStateActivity.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (ApolloGuestsStateActivity.a(localApolloGuestsStateActivity) == null)) {
      return;
    }
    float f3 = alsf.a() / 16.0F;
    float f2 = localApolloGuestsStateActivity.c;
    float f1 = f2;
    if (0.0F != f3) {
      f1 = f2 / f3;
    }
    localApolloGuestsStateActivity.jdField_a_of_type_Float = (paramInt1 / 2 / f1);
    if (localApolloGuestsStateActivity.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null) {
      localApolloGuestsStateActivity.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a();
    }
    ApolloGuestsStateActivity.a(localApolloGuestsStateActivity).c();
    localApolloGuestsStateActivity.b = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alds
 * JD-Core Version:    0.7.0.1
 */