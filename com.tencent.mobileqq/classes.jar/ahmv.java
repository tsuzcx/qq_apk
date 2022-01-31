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

public class ahmv
  extends ahln
  implements View.OnClickListener
{
  public ahmv(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
    this.jdField_a_of_type_Bibh = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297295);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ahmw localahmw;
    QIMFollwerAdd localQIMFollwerAdd;
    label249:
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahmw)))
    {
      localahmw = new ahmw();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561327, localahmw);
      a(paramView, this.b);
      localahmw.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localahmw.h = ((TextView)paramView.findViewById(2131371161));
      localahmw.i = ((TextView)paramView.findViewById(2131375729));
      localahmw.l = ((TextView)paramView.findViewById(2131362215));
      localahmw.j = ((TextView)paramView.findViewById(2131376899));
      localahmw.k = ((TextView)paramView.findViewById(2131375726));
      localahmw.a = ((Button)paramView.findViewById(2131375716));
      b(localahmw.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localahmw);
      localahmw.g.setTag(localahmw);
      localahmw.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Avun, localahmw, this);
      localahmw.g.setBackgroundResource(2130839214);
      localQIMFollwerAdd = ((avux)this.jdField_a_of_type_Avun).a;
      if (TextUtils.isEmpty(localQIMFollwerAdd.smartRemark)) {
        break label470;
      }
      localahmw.h.setVisibility(0);
      localahmw.h.setText(localQIMFollwerAdd.smartRemark);
      localObject = localahmw.g;
      if (this.jdField_a_of_type_Avun.a()) {
        break label483;
      }
      bool = true;
      label268:
      a((View)localObject, bool);
      localObject = new StringBuilder(256);
      a(localahmw.l, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
      if (!TextUtils.isEmpty(localQIMFollwerAdd.longNick)) {
        break label488;
      }
      localahmw.i.setVisibility(8);
      label323:
      if (TextUtils.isEmpty(localQIMFollwerAdd.source)) {
        break label535;
      }
      localObject = String.format(Locale.getDefault(), alud.a(2131710199), new Object[] { localQIMFollwerAdd.source });
      localahmw.j.setText((CharSequence)localObject);
      localahmw.j.setVisibility(0);
    }
    for (;;)
    {
      localahmw.k.setVisibility(8);
      localahmw.a.setText(alud.a(2131710198));
      localahmw.a.setVisibility(0);
      localahmw.a.setOnClickListener(this);
      localahmw.jdField_f_of_type_JavaLangString = String.valueOf(localQIMFollwerAdd.uin);
      localahmw.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(1, String.valueOf(localQIMFollwerAdd.uin)));
      return paramView;
      localahmw = (ahmw)paramView.getTag();
      break;
      label470:
      localahmw.h.setVisibility(8);
      break label249;
      label483:
      bool = false;
      break label268;
      label488:
      localahmw.i.setVisibility(0);
      localahmw.i.setText(localQIMFollwerAdd.longNick);
      if (!AppSetting.c) {
        break label323;
      }
      ((StringBuilder)localObject).append(",").append(localQIMFollwerAdd.longNick);
      break label323;
      label535:
      localahmw.j.setVisibility(8);
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
    case 2131375872: 
      return;
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(this.jdField_a_of_type_AndroidContentContext, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmv
 * JD-Core Version:    0.7.0.1
 */