import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.qphone.base.util.QLog;

public class aaqd
  implements ArkViewImplement.LoadCallback
{
  boolean jdField_a_of_type_Boolean = true;
  
  public aaqd(ArkRecommendController paramArkRecommendController, boolean paramBoolean, View paramView1, BaseChatItemLayout paramBaseChatItemLayout, View paramView2) {}
  
  @TargetApi(11)
  public void onLoadFinish(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a();
    if ((paramInt != 1) || (localObject == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "getAttachArkView.loadFinish.chatPie == null!");
      }
    }
    do
    {
      return;
      if ((!this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
        break;
      }
      paramInt = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
      if ((((BaseChatPie)localObject).f() != 0) && (((BaseChatPie)localObject).a.getHeight() < this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getMeasuredHeight() + paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkRecommendController", 2, "listView.getHeight() < height, hide panel!");
        }
        ((BaseChatPie)localObject).ai();
      }
      localObject = new ValueAnimation(Integer.valueOf(0), Integer.valueOf(paramInt), new aaqe(this, paramInt));
      ((ValueAnimation)localObject).setInterpolator(new AccelerateInterpolator());
      ((ValueAnimation)localObject).setDuration(200L);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.startAnimation((Animation)localObject);
      this.jdField_a_of_type_Boolean = false;
    } while (!QLog.isColorLevel());
    QLog.d("ArkRecommendController", 2, "getAttachArkView.do animation..");
    return;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_b_of_type_AndroidViewView.setAlpha(1.0F);
    }
    this.jdField_b_of_type_AndroidViewView.requestLayout();
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqd
 * JD-Core Version:    0.7.0.1
 */