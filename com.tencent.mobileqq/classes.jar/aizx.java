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

public class aizx
  extends aiyi
  implements View.OnClickListener
{
  public aizx(Context paramContext, QQAppInterface paramQQAppInterface, ajae paramajae, ajax paramajax)
  {
    super(paramContext, paramQQAppInterface, paramajae, paramajax);
    this.jdField_a_of_type_Bkos = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297358);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aizy localaizy;
    QIMFollwerAdd localQIMFollwerAdd;
    label249:
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof aizy)))
    {
      localaizy = new aizy();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561560, localaizy);
      a(paramView, this.b);
      localaizy.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localaizy.h = ((TextView)paramView.findViewById(2131371720));
      localaizy.i = ((TextView)paramView.findViewById(2131376456));
      localaizy.l = ((TextView)paramView.findViewById(2131362290));
      localaizy.j = ((TextView)paramView.findViewById(2131377713));
      localaizy.k = ((TextView)paramView.findViewById(2131376453));
      localaizy.a = ((Button)paramView.findViewById(2131376443));
      b(localaizy.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaizy);
      localaizy.g.setTag(localaizy);
      localaizy.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajax, localaizy, this);
      localaizy.g.setBackgroundResource(2130839391);
      localQIMFollwerAdd = ((ajbh)this.jdField_a_of_type_Ajax).a;
      if (TextUtils.isEmpty(localQIMFollwerAdd.smartRemark)) {
        break label470;
      }
      localaizy.h.setVisibility(0);
      localaizy.h.setText(localQIMFollwerAdd.smartRemark);
      localObject = localaizy.g;
      if (this.jdField_a_of_type_Ajax.a()) {
        break label483;
      }
      bool = true;
      label268:
      a((View)localObject, bool);
      localObject = new StringBuilder(256);
      a(localaizy.l, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
      if (!TextUtils.isEmpty(localQIMFollwerAdd.longNick)) {
        break label488;
      }
      localaizy.i.setVisibility(8);
      label323:
      if (TextUtils.isEmpty(localQIMFollwerAdd.source)) {
        break label535;
      }
      localObject = String.format(Locale.getDefault(), anni.a(2131708575), new Object[] { localQIMFollwerAdd.source });
      localaizy.j.setText((CharSequence)localObject);
      localaizy.j.setVisibility(0);
    }
    for (;;)
    {
      localaizy.k.setVisibility(8);
      localaizy.a.setText(anni.a(2131708574));
      localaizy.a.setVisibility(0);
      localaizy.a.setOnClickListener(this);
      localaizy.jdField_f_of_type_JavaLangString = String.valueOf(localQIMFollwerAdd.uin);
      localaizy.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajae.a(1, String.valueOf(localQIMFollwerAdd.uin)));
      return paramView;
      localaizy = (aizy)paramView.getTag();
      break;
      label470:
      localaizy.h.setVisibility(8);
      break label249;
      label483:
      bool = false;
      break label268;
      label488:
      localaizy.i.setVisibility(0);
      localaizy.i.setText(localQIMFollwerAdd.longNick);
      if (!AppSetting.c) {
        break label323;
      }
      ((StringBuilder)localObject).append(",").append(localQIMFollwerAdd.longNick);
      break label323;
      label535:
      localaizy.j.setVisibility(8);
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
 * Qualified Name:     aizx
 * JD-Core Version:    0.7.0.1
 */