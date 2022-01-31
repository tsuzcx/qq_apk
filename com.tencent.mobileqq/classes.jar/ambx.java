import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.portal.HongBaoPendantHolder;
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.HongBaoListViewListener;

public class ambx
  implements Handler.Callback
{
  public ambx(HongBaoListView paramHongBaoListView) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            this.a.setIsShowingPreguide(true);
            this.a.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(this.a.f / 5, 300L);
            this.a.springBackTo(-this.a.f);
            if (this.a.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener != null) {
              this.a.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.b(false);
            }
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 2000L);
            this.a.invalidate();
            return false;
            this.a.a(300L);
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 300L);
          } while (this.a.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener == null);
          this.a.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.a(false);
          return false;
          this.a.setIsShowingPreguide(true);
          i = this.a.f / 2;
          this.a.setSpringbackOffset(-this.a.f);
          if (paramMessage.arg1 != 0) {
            i = paramMessage.arg1;
          }
          this.a.springBackTo(-i);
          this.a.jdField_a_of_type_ComTencentMobileqqPortalHongBaoPendantHolder.a(this.a.f / 5, 300L);
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 2000L);
        } while (this.a.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener == null);
        this.a.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.b(false);
        return false;
        this.a.a(300L);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 300L);
      } while (this.a.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener == null);
      this.a.jdField_a_of_type_ComTencentWidgetHongBaoListViewListener.a(false);
      return false;
      this.a.setIsShowingPreguide(false);
      this.a.setSpringbackOffset(0);
      return false;
      if (!this.a.isStackFromBottom()) {
        this.a.setStackFromBottom(true);
      }
      this.a.setStackFromBottom(false);
    } while (this.a.k);
    int i = (int)this.a.getResources().getDimension(2131559588);
    this.a.springBackTo(-i);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambx
 * JD-Core Version:    0.7.0.1
 */