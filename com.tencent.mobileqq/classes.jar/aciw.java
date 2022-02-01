import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.ad.tangram.ark.AdArkAdapter.Callback;

class aciw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aciw(aciu paramaciu, AdArkAdapter.Callback paramCallback) {}
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$Callback != null) {
      this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$Callback.onGlobalLayout(aciu.a(this.jdField_a_of_type_Aciu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aciw
 * JD-Core Version:    0.7.0.1
 */