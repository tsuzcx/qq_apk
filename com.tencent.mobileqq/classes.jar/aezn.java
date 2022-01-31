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

public class aezn
  extends aeyf
  implements View.OnClickListener
{
  public aezn(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
    this.jdField_a_of_type_Bens = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131166195);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aezo localaezo;
    QIMFollwerAdd localQIMFollwerAdd;
    label249:
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof aezo)))
    {
      localaezo = new aezo();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131495535, localaezo);
      a(paramView, this.b);
      localaezo.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296259));
      localaezo.h = ((TextView)paramView.findViewById(2131305159));
      localaezo.i = ((TextView)paramView.findViewById(2131309446));
      localaezo.l = ((TextView)paramView.findViewById(2131296655));
      localaezo.j = ((TextView)paramView.findViewById(2131310547));
      localaezo.k = ((TextView)paramView.findViewById(2131309443));
      localaezo.a = ((Button)paramView.findViewById(2131309433));
      b(localaezo.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaezo);
      localaezo.g.setTag(localaezo);
      localaezo.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atcu, localaezo, this);
      localaezo.g.setBackgroundResource(2130839101);
      localQIMFollwerAdd = ((atde)this.jdField_a_of_type_Atcu).a;
      if (TextUtils.isEmpty(localQIMFollwerAdd.smartRemark)) {
        break label470;
      }
      localaezo.h.setVisibility(0);
      localaezo.h.setText(localQIMFollwerAdd.smartRemark);
      localObject = localaezo.g;
      if (this.jdField_a_of_type_Atcu.a()) {
        break label483;
      }
      bool = true;
      label268:
      a((View)localObject, bool);
      localObject = new StringBuilder(256);
      a(localaezo.l, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
      if (!TextUtils.isEmpty(localQIMFollwerAdd.longNick)) {
        break label488;
      }
      localaezo.i.setVisibility(8);
      label323:
      if (TextUtils.isEmpty(localQIMFollwerAdd.source)) {
        break label535;
      }
      localObject = String.format(Locale.getDefault(), ajjy.a(2131644019), new Object[] { localQIMFollwerAdd.source });
      localaezo.j.setText((CharSequence)localObject);
      localaezo.j.setVisibility(0);
    }
    for (;;)
    {
      localaezo.k.setVisibility(8);
      localaezo.a.setText(ajjy.a(2131644018));
      localaezo.a.setVisibility(0);
      localaezo.a.setOnClickListener(this);
      localaezo.jdField_f_of_type_JavaLangString = String.valueOf(localQIMFollwerAdd.uin);
      localaezo.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(1, String.valueOf(localQIMFollwerAdd.uin)));
      return paramView;
      localaezo = (aezo)paramView.getTag();
      break;
      label470:
      localaezo.h.setVisibility(8);
      break label249;
      label483:
      bool = false;
      break label268;
      label488:
      localaezo.i.setVisibility(0);
      localaezo.i.setText(localQIMFollwerAdd.longNick);
      if (!AppSetting.c) {
        break label323;
      }
      ((StringBuilder)localObject).append(",").append(localQIMFollwerAdd.longNick);
      break label323;
      label535:
      localaezo.j.setVisibility(8);
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
    case 2131309584: 
      return;
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(this.jdField_a_of_type_AndroidContentContext, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezn
 * JD-Core Version:    0.7.0.1
 */