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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;

public class ajao
  extends aiyz
  implements View.OnClickListener
{
  public ajao(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
    this.jdField_a_of_type_Blfk = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297426);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ajap localajap;
    QIMFollwerAdd localQIMFollwerAdd;
    label249:
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajap)))
    {
      localajap = new ajap();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561541, localajap);
      a(paramView, this.b);
      localajap.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localajap.h = ((TextView)paramView.findViewById(2131371981));
      localajap.i = ((TextView)paramView.findViewById(2131376609));
      localajap.l = ((TextView)paramView.findViewById(2131362310));
      localajap.j = ((TextView)paramView.findViewById(2131377905));
      localajap.k = ((TextView)paramView.findViewById(2131376606));
      localajap.a = ((Button)paramView.findViewById(2131376596));
      b(localajap.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localajap);
      localajap.g.setTag(localajap);
      localajap.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajbn, localajap, this);
      localajap.g.setBackgroundResource(2130839455);
      localQIMFollwerAdd = ((ajbx)this.jdField_a_of_type_Ajbn).a;
      if (TextUtils.isEmpty(localQIMFollwerAdd.smartRemark)) {
        break label470;
      }
      localajap.h.setVisibility(0);
      localajap.h.setText(localQIMFollwerAdd.smartRemark);
      localObject = localajap.g;
      if (this.jdField_a_of_type_Ajbn.a()) {
        break label483;
      }
      bool = true;
      label268:
      a((View)localObject, bool);
      localObject = new StringBuilder(256);
      a(localajap.l, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
      if (!TextUtils.isEmpty(localQIMFollwerAdd.longNick)) {
        break label488;
      }
      localajap.i.setVisibility(8);
      label323:
      if (TextUtils.isEmpty(localQIMFollwerAdd.source)) {
        break label535;
      }
      localObject = String.format(Locale.getDefault(), anvx.a(2131709263), new Object[] { localQIMFollwerAdd.source });
      localajap.j.setText((CharSequence)localObject);
      localajap.j.setVisibility(0);
    }
    for (;;)
    {
      localajap.k.setVisibility(8);
      localajap.a.setText(anvx.a(2131709262));
      localajap.a.setVisibility(0);
      localajap.a.setOnClickListener(this);
      localajap.jdField_f_of_type_JavaLangString = String.valueOf(localQIMFollwerAdd.uin);
      localajap.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(1, String.valueOf(localQIMFollwerAdd.uin)));
      return paramView;
      localajap = (ajap)paramView.getTag();
      break;
      label470:
      localajap.h.setVisibility(8);
      break label249;
      label483:
      bool = false;
      break label268;
      label488:
      localajap.i.setVisibility(0);
      localajap.i.setText(localQIMFollwerAdd.longNick);
      if (!AppSetting.c) {
        break label323;
      }
      ((StringBuilder)localObject).append(",").append(localQIMFollwerAdd.longNick);
      break label323;
      label535:
      localajap.j.setVisibility(8);
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
      ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajao
 * JD-Core Version:    0.7.0.1
 */