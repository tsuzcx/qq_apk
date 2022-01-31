import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.AnimationScrollListener.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;

public class aila
  implements bhtv
{
  public aila(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      ((AvatarPendantManager)this.b.app.getManager(46)).a(this.b.jdField_a_of_type_Long).a(false);
    }
    for (;;)
    {
      this.b.u = paramInt;
      if (paramInt != 0) {
        break label127;
      }
      if (!this.b.jdField_a_of_type_Akhf.a) {
        break;
      }
      this.b.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new AvatarPendantActivity.AnimationScrollListener.1(this), 80L);
      return;
      ((AvatarPendantManager)this.b.app.getManager(46)).a(this.b.jdField_a_of_type_Long).a(true);
    }
    URLDrawable.resume();
    this.b.jdField_a_of_type_Akhf.notifyDataSetChanged();
    return;
    label127:
    URLDrawable.pause();
    this.b.jdField_a_of_type_Akhf.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aila
 * JD-Core Version:    0.7.0.1
 */