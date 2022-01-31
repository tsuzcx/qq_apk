import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder;
import com.tencent.mobileqq.hotpic.HotPicRecyclerView;

public class adge
  extends Handler
{
  public adge(HotPicPageView paramHotPicPageView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (HotPicPageView.b);
          this.a.i();
          return;
        } while ((HotPicPageView.b) || (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.getVisibility() != 0) || (this.a.jdField_a_of_type_Adgp == null) || (this.a.jdField_a_of_type_Adgp.getItemCount() == 0));
        i = this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a();
      } while (i < 0);
      paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.findViewHolderForPosition(i);
    } while ((paramMessage == null) || (!(paramMessage instanceof HotPicPageView.MyVideoViewHolder)));
    paramMessage = (HotPicPageView.MyVideoViewHolder)paramMessage;
    if (paramMessage.jdField_a_of_type_Int == 0)
    {
      this.a.b(paramMessage, i);
      return;
    }
    paramMessage.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adge
 * JD-Core Version:    0.7.0.1
 */