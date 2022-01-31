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

public class ahig
  extends ahgy
  implements View.OnClickListener
{
  public ahig(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
    this.jdField_a_of_type_Bhxa = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297295);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ahih localahih;
    QIMFollwerAdd localQIMFollwerAdd;
    label249:
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahih)))
    {
      localahih = new ahih();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561309, localahih);
      a(paramView, this.b);
      localahih.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localahih.h = ((TextView)paramView.findViewById(2131371142));
      localahih.i = ((TextView)paramView.findViewById(2131375678));
      localahih.l = ((TextView)paramView.findViewById(2131362215));
      localahih.j = ((TextView)paramView.findViewById(2131376845));
      localahih.k = ((TextView)paramView.findViewById(2131375675));
      localahih.a = ((Button)paramView.findViewById(2131375665));
      b(localahih.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localahih);
      localahih.g.setTag(localahih);
      localahih.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Avqe, localahih, this);
      localahih.g.setBackgroundResource(2130839213);
      localQIMFollwerAdd = ((avqo)this.jdField_a_of_type_Avqe).a;
      if (TextUtils.isEmpty(localQIMFollwerAdd.smartRemark)) {
        break label470;
      }
      localahih.h.setVisibility(0);
      localahih.h.setText(localQIMFollwerAdd.smartRemark);
      localObject = localahih.g;
      if (this.jdField_a_of_type_Avqe.a()) {
        break label483;
      }
      bool = true;
      label268:
      a((View)localObject, bool);
      localObject = new StringBuilder(256);
      a(localahih.l, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
      if (!TextUtils.isEmpty(localQIMFollwerAdd.longNick)) {
        break label488;
      }
      localahih.i.setVisibility(8);
      label323:
      if (TextUtils.isEmpty(localQIMFollwerAdd.source)) {
        break label535;
      }
      localObject = String.format(Locale.getDefault(), alpo.a(2131710187), new Object[] { localQIMFollwerAdd.source });
      localahih.j.setText((CharSequence)localObject);
      localahih.j.setVisibility(0);
    }
    for (;;)
    {
      localahih.k.setVisibility(8);
      localahih.a.setText(alpo.a(2131710186));
      localahih.a.setVisibility(0);
      localahih.a.setOnClickListener(this);
      localahih.jdField_f_of_type_JavaLangString = String.valueOf(localQIMFollwerAdd.uin);
      localahih.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(1, String.valueOf(localQIMFollwerAdd.uin)));
      return paramView;
      localahih = (ahih)paramView.getTag();
      break;
      label470:
      localahih.h.setVisibility(8);
      break label249;
      label483:
      bool = false;
      break label268;
      label488:
      localahih.i.setVisibility(0);
      localahih.i.setText(localQIMFollwerAdd.longNick);
      if (!AppSetting.c) {
        break label323;
      }
      ((StringBuilder)localObject).append(",").append(localQIMFollwerAdd.longNick);
      break label323;
      label535:
      localahih.j.setVisibility(8);
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
    case 2131375820: 
      return;
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(this.jdField_a_of_type_AndroidContentContext, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahig
 * JD-Core Version:    0.7.0.1
 */