import Wallet.RedPackGrapInfo;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.qphone.base.util.QLog;

public class agmj
  extends FrameLayout
{
  adnc jdField_a_of_type_Adnc;
  Context jdField_a_of_type_AndroidContentContext;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public agmj(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList, @NonNull Context paramContext, adnc paramadnc)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Adnc = paramadnc;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramTroopUnAccalimedRedPacketList = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramTroopUnAccalimedRedPacketList.width = -2;
    paramTroopUnAccalimedRedPacketList.height = -2;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130846384);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    paramTroopUnAccalimedRedPacketList = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    paramTroopUnAccalimedRedPacketList.width = vms.a(paramContext, 29.0F);
    paramTroopUnAccalimedRedPacketList.height = vms.a(paramContext, 29.0F);
    paramTroopUnAccalimedRedPacketList.gravity = 1;
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    paramTroopUnAccalimedRedPacketList = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramTroopUnAccalimedRedPacketList.width = vms.a(paramContext, 28.0F);
    paramTroopUnAccalimedRedPacketList.height = vms.a(paramContext, 28.0F);
    paramTroopUnAccalimedRedPacketList.gravity = 17;
  }
  
  public void a(RedPackGrapInfo paramRedPackGrapInfo)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = azwp.a(TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList), String.valueOf(paramRedPackGrapInfo.lUin), (byte)3);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    if (this.jdField_a_of_type_Adnc != null)
    {
      this.jdField_a_of_type_Adnc.a(paramRedPackGrapInfo);
      localObject = this.jdField_a_of_type_Adnc.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (localObject == null) {
        break label120;
      }
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = vms.a(this.jdField_a_of_type_AndroidContentContext, 11.5F);
      localLayoutParams.gravity = 16;
      ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Adnc.a((FrameLayout)localObject, paramRedPackGrapInfo, new agmk(this));
    }
    label120:
    while (!QLog.isColorLevel())
    {
      LinearLayout.LayoutParams localLayoutParams;
      return;
    }
    QLog.w(TroopUnAccalimedRedPacketList.b(), 2, "red packet item layout is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agmj
 * JD-Core Version:    0.7.0.1
 */