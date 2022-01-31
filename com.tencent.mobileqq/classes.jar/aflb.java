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

public class aflb
  extends afjt
  implements View.OnClickListener
{
  public aflb(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
    this.jdField_a_of_type_Bfwd = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297276);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aflc localaflc;
    QIMFollwerAdd localQIMFollwerAdd;
    label249:
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof aflc)))
    {
      localaflc = new aflc();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561122, localaflc);
      a(paramView, this.b);
      localaflc.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localaflc.h = ((TextView)paramView.findViewById(2131370832));
      localaflc.i = ((TextView)paramView.findViewById(2131375196));
      localaflc.l = ((TextView)paramView.findViewById(2131362195));
      localaflc.j = ((TextView)paramView.findViewById(2131376341));
      localaflc.k = ((TextView)paramView.findViewById(2131375193));
      localaflc.a = ((Button)paramView.findViewById(2131375183));
      b(localaflc.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaflc);
      localaflc.g.setTag(localaflc);
      localaflc.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atza, localaflc, this);
      localaflc.g.setBackgroundResource(2130839129);
      localQIMFollwerAdd = ((atzk)this.jdField_a_of_type_Atza).a;
      if (TextUtils.isEmpty(localQIMFollwerAdd.smartRemark)) {
        break label470;
      }
      localaflc.h.setVisibility(0);
      localaflc.h.setText(localQIMFollwerAdd.smartRemark);
      localObject = localaflc.g;
      if (this.jdField_a_of_type_Atza.a()) {
        break label483;
      }
      bool = true;
      label268:
      a((View)localObject, bool);
      localObject = new StringBuilder(256);
      a(localaflc.l, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
      if (!TextUtils.isEmpty(localQIMFollwerAdd.longNick)) {
        break label488;
      }
      localaflc.i.setVisibility(8);
      label323:
      if (TextUtils.isEmpty(localQIMFollwerAdd.source)) {
        break label535;
      }
      localObject = String.format(Locale.getDefault(), ajya.a(2131709815), new Object[] { localQIMFollwerAdd.source });
      localaflc.j.setText((CharSequence)localObject);
      localaflc.j.setVisibility(0);
    }
    for (;;)
    {
      localaflc.k.setVisibility(8);
      localaflc.a.setText(ajya.a(2131709814));
      localaflc.a.setVisibility(0);
      localaflc.a.setOnClickListener(this);
      localaflc.jdField_f_of_type_JavaLangString = String.valueOf(localQIMFollwerAdd.uin);
      localaflc.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(1, String.valueOf(localQIMFollwerAdd.uin)));
      return paramView;
      localaflc = (aflc)paramView.getTag();
      break;
      label470:
      localaflc.h.setVisibility(8);
      break label249;
      label483:
      bool = false;
      break label268;
      label488:
      localaflc.i.setVisibility(0);
      localaflc.i.setText(localQIMFollwerAdd.longNick);
      if (!AppSetting.d) {
        break label323;
      }
      ((StringBuilder)localObject).append(",").append(localQIMFollwerAdd.longNick);
      break label323;
      label535:
      localaflc.j.setVisibility(8);
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
    case 2131375335: 
      return;
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(this.jdField_a_of_type_AndroidContentContext, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aflb
 * JD-Core Version:    0.7.0.1
 */