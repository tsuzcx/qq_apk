import Wallet.RedPackGrapInfo;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qphone.base.util.QLog;

public class aktr
  extends FrameLayout
{
  aheu jdField_a_of_type_Aheu;
  Context jdField_a_of_type_AndroidContentContext;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public aktr(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList, @NonNull Context paramContext, aheu paramaheu)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aheu = paramaheu;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    paramTroopUnAccalimedRedPacketList = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    paramTroopUnAccalimedRedPacketList.width = -2;
    paramTroopUnAccalimedRedPacketList.height = -2;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramContext);
    if (!bdfk.b()) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130847491);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    paramTroopUnAccalimedRedPacketList = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    paramTroopUnAccalimedRedPacketList.width = UIUtils.dip2px(paramContext, 29.0F);
    paramTroopUnAccalimedRedPacketList.height = UIUtils.dip2px(paramContext, 29.0F);
    paramTroopUnAccalimedRedPacketList.gravity = 1;
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    paramTroopUnAccalimedRedPacketList = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramTroopUnAccalimedRedPacketList.width = UIUtils.dip2px(paramContext, 28.0F);
    paramTroopUnAccalimedRedPacketList.height = UIUtils.dip2px(paramContext, 28.0F);
    paramTroopUnAccalimedRedPacketList.gravity = 17;
  }
  
  public void a(RedPackGrapInfo paramRedPackGrapInfo)
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = FaceDrawable.getUserFaceDrawable(TroopUnAccalimedRedPacketList.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTroopUnAccalimedRedPacketList), String.valueOf(paramRedPackGrapInfo.lUin), (byte)3);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    if (this.jdField_a_of_type_Aheu != null)
    {
      this.jdField_a_of_type_Aheu.a(paramRedPackGrapInfo);
      localObject = this.jdField_a_of_type_Aheu.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (localObject == null) {
        break label120;
      }
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 11.5F);
      localLayoutParams.gravity = 16;
      ((FrameLayout)localObject).setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Aheu.a((FrameLayout)localObject, paramRedPackGrapInfo, new akts(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktr
 * JD-Core Version:    0.7.0.1
 */