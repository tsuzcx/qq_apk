import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.net.GdtAdHandler;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class aihx
  implements View.OnClickListener
{
  public aihx(StructMsgForGeneralShare paramStructMsgForGeneralShare, Context paramContext, Resources paramResources, PopupWindow paramPopupWindow) {}
  
  public void onClick(View paramView)
  {
    int k;
    int m;
    try
    {
      ViewGroup localViewGroup = (ViewGroup)((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().c.findViewById(2131363026);
      if (localViewGroup == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        arrayOfInt1 = null;
      }
      int[] arrayOfInt2 = new int[2];
      arrayOfInt1.getLocationOnScreen(arrayOfInt2);
      int i = arrayOfInt2[0];
      i = arrayOfInt2[1];
      int j = arrayOfInt1.getHeight();
      k = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
      int[] arrayOfInt1 = new int[2];
      paramView.getLocationOnScreen(arrayOfInt1);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionX = arrayOfInt1[0];
      this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionY = arrayOfInt1[1];
      k = AIOUtils.a(106.0F, this.jdField_a_of_type_AndroidContentResResources);
      m = paramView.getHeight();
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionY - i + m + k <= j) {
        break label276;
      }
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843950));
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionX, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionY - k);
    for (;;)
    {
      ((GdtAdHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(110)).a(9, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message);
      paramView = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getAttributes();
      paramView.alpha = 0.5F;
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().setAttributes(paramView);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(new aihy(this));
      return;
      label276:
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843949));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionX, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.mClickpositionY + m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihx
 * JD-Core Version:    0.7.0.1
 */