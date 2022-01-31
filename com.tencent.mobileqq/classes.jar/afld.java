import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.newfriend.QIMFollowerAddBuilder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import java.util.Locale;

public class afld
  extends afjv
  implements View.OnClickListener
{
  public afld(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
    this.jdField_a_of_type_Bfvm = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297276);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    afle localafle;
    QIMFollwerAdd localQIMFollwerAdd;
    label249:
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof afle)))
    {
      localafle = new afle();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561123, localafle);
      a(paramView, this.b);
      localafle.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localafle.h = ((TextView)paramView.findViewById(2131370832));
      localafle.i = ((TextView)paramView.findViewById(2131375194));
      localafle.l = ((TextView)paramView.findViewById(2131362196));
      localafle.j = ((TextView)paramView.findViewById(2131376339));
      localafle.k = ((TextView)paramView.findViewById(2131375191));
      localafle.a = ((Button)paramView.findViewById(2131375181));
      b(localafle.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localafle);
      localafle.g.setTag(localafle);
      localafle.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atyy, localafle, this);
      localafle.g.setBackgroundResource(2130839129);
      localQIMFollwerAdd = ((atzi)this.jdField_a_of_type_Atyy).a;
      if (TextUtils.isEmpty(localQIMFollwerAdd.smartRemark)) {
        break label470;
      }
      localafle.h.setVisibility(0);
      localafle.h.setText(localQIMFollwerAdd.smartRemark);
      localObject = localafle.g;
      if (this.jdField_a_of_type_Atyy.a()) {
        break label483;
      }
      bool = true;
      label268:
      a((View)localObject, bool);
      localObject = new StringBuilder(256);
      a(localafle.l, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
      if (!TextUtils.isEmpty(localQIMFollwerAdd.longNick)) {
        break label488;
      }
      localafle.i.setVisibility(8);
      label323:
      if (TextUtils.isEmpty(localQIMFollwerAdd.source)) {
        break label535;
      }
      localObject = String.format(Locale.getDefault(), ajyc.a(2131709804), new Object[] { localQIMFollwerAdd.source });
      localafle.j.setText((CharSequence)localObject);
      localafle.j.setVisibility(0);
    }
    for (;;)
    {
      localafle.k.setVisibility(8);
      localafle.a.setText(ajyc.a(2131709803));
      localafle.a.setVisibility(0);
      localafle.a.setOnClickListener(this);
      localafle.jdField_f_of_type_JavaLangString = String.valueOf(localQIMFollwerAdd.uin);
      localafle.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(1, String.valueOf(localQIMFollwerAdd.uin)));
      return paramView;
      localafle = (afle)paramView.getTag();
      break;
      label470:
      localafle.h.setVisibility(8);
      break label249;
      label483:
      bool = false;
      break label268;
      label488:
      localafle.i.setVisibility(0);
      localafle.i.setText(localQIMFollwerAdd.longNick);
      if (!AppSetting.d) {
        break label323;
      }
      ((StringBuilder)localObject).append(",").append(localQIMFollwerAdd.longNick);
      break label323;
      label535:
      localafle.j.setVisibility(8);
    }
  }
  
  protected void a()
  {
    ThreadManager.postImmediately(new QIMFollowerAddBuilder.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131375333: 
      return;
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(this.jdField_a_of_type_AndroidContentContext, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afld
 * JD-Core Version:    0.7.0.1
 */