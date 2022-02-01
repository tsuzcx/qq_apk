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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;

public class aifp
  extends aiea
  implements View.OnClickListener
{
  public aifp(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
    this.jdField_a_of_type_Bjty = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297425);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aifq localaifq;
    QIMFollwerAdd localQIMFollwerAdd;
    label249:
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof aifq)))
    {
      localaifq = new aifq();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561479, localaifq);
      a(paramView, this.b);
      localaifq.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localaifq.h = ((TextView)paramView.findViewById(2131371791));
      localaifq.i = ((TextView)paramView.findViewById(2131376354));
      localaifq.l = ((TextView)paramView.findViewById(2131362305));
      localaifq.j = ((TextView)paramView.findViewById(2131377631));
      localaifq.k = ((TextView)paramView.findViewById(2131376351));
      localaifq.a = ((Button)paramView.findViewById(2131376341));
      b(localaifq.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaifq);
      localaifq.g.setTag(localaifq);
      localaifq.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Aigo, localaifq, this);
      localaifq.g.setBackgroundResource(2130839434);
      localQIMFollwerAdd = ((aigy)this.jdField_a_of_type_Aigo).a;
      if (TextUtils.isEmpty(localQIMFollwerAdd.smartRemark)) {
        break label470;
      }
      localaifq.h.setVisibility(0);
      localaifq.h.setText(localQIMFollwerAdd.smartRemark);
      localObject = localaifq.g;
      if (this.jdField_a_of_type_Aigo.a()) {
        break label483;
      }
      bool = true;
      label268:
      a((View)localObject, bool);
      localObject = new StringBuilder(256);
      a(localaifq.l, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
      if (!TextUtils.isEmpty(localQIMFollwerAdd.longNick)) {
        break label488;
      }
      localaifq.i.setVisibility(8);
      label323:
      if (TextUtils.isEmpty(localQIMFollwerAdd.source)) {
        break label535;
      }
      localObject = String.format(Locale.getDefault(), amtj.a(2131708916), new Object[] { localQIMFollwerAdd.source });
      localaifq.j.setText((CharSequence)localObject);
      localaifq.j.setVisibility(0);
    }
    for (;;)
    {
      localaifq.k.setVisibility(8);
      localaifq.a.setText(amtj.a(2131708915));
      localaifq.a.setVisibility(0);
      localaifq.a.setOnClickListener(this);
      localaifq.jdField_f_of_type_JavaLangString = String.valueOf(localQIMFollwerAdd.uin);
      localaifq.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(1, String.valueOf(localQIMFollwerAdd.uin)));
      return paramView;
      localaifq = (aifq)paramView.getTag();
      break;
      label470:
      localaifq.h.setVisibility(8);
      break label249;
      label483:
      bool = false;
      break label268;
      label488:
      localaifq.i.setVisibility(0);
      localaifq.i.setText(localQIMFollwerAdd.longNick);
      if (!AppSetting.c) {
        break label323;
      }
      ((StringBuilder)localObject).append(",").append(localQIMFollwerAdd.longNick);
      break label323;
      label535:
      localaifq.j.setVisibility(8);
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(this.jdField_a_of_type_AndroidContentContext, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifp
 * JD-Core Version:    0.7.0.1
 */