import android.view.View;
import com.tencent.ad.tangram.ark.AdArkAdapter.Callback;
import com.tencent.ark.ArkViewImplement.InputCallback;

class abyz
  implements ArkViewImplement.InputCallback
{
  abyz(abyw paramabyw, AdArkAdapter.Callback paramCallback) {}
  
  public void onFocusChanged(View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$Callback != null) {
      this.jdField_a_of_type_ComTencentAdTangramArkAdArkAdapter$Callback.onFocusChanged(paramView, paramBoolean);
    }
  }
  
  public void onHideMenu(View paramView) {}
  
  public void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyz
 * JD-Core Version:    0.7.0.1
 */