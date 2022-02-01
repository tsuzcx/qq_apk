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

public class ajlg
  extends ajjr
  implements View.OnClickListener
{
  public ajlg(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
    this.jdField_a_of_type_Blpv = a(paramContext);
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297370);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ajlh localajlh;
    QIMFollwerAdd localQIMFollwerAdd;
    label249:
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajlh)))
    {
      localajlh = new ajlh();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561601, localajlh);
      a(paramView, this.b);
      localajlh.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localajlh.h = ((TextView)paramView.findViewById(2131371827));
      localajlh.i = ((TextView)paramView.findViewById(2131376588));
      localajlh.l = ((TextView)paramView.findViewById(2131362302));
      localajlh.j = ((TextView)paramView.findViewById(2131377861));
      localajlh.k = ((TextView)paramView.findViewById(2131376585));
      localajlh.a = ((Button)paramView.findViewById(2131376575));
      b(localajlh.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localajlh);
      localajlh.g.setTag(localajlh);
      localajlh.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajmf, localajlh, this);
      localajlh.g.setBackgroundResource(2130839399);
      localQIMFollwerAdd = ((ajmp)this.jdField_a_of_type_Ajmf).a;
      if (TextUtils.isEmpty(localQIMFollwerAdd.smartRemark)) {
        break label470;
      }
      localajlh.h.setVisibility(0);
      localajlh.h.setText(localQIMFollwerAdd.smartRemark);
      localObject = localajlh.g;
      if (this.jdField_a_of_type_Ajmf.a()) {
        break label483;
      }
      bool = true;
      label268:
      a((View)localObject, bool);
      localObject = new StringBuilder(256);
      a(localajlh.l, localQIMFollwerAdd.gender, 0, (StringBuilder)localObject);
      if (!TextUtils.isEmpty(localQIMFollwerAdd.longNick)) {
        break label488;
      }
      localajlh.i.setVisibility(8);
      label323:
      if (TextUtils.isEmpty(localQIMFollwerAdd.source)) {
        break label535;
      }
      localObject = String.format(Locale.getDefault(), anzj.a(2131708684), new Object[] { localQIMFollwerAdd.source });
      localajlh.j.setText((CharSequence)localObject);
      localajlh.j.setVisibility(0);
    }
    for (;;)
    {
      localajlh.k.setVisibility(8);
      localajlh.a.setText(anzj.a(2131708683));
      localajlh.a.setVisibility(0);
      localajlh.a.setOnClickListener(this);
      localajlh.jdField_f_of_type_JavaLangString = String.valueOf(localQIMFollwerAdd.uin);
      localajlh.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(1, String.valueOf(localQIMFollwerAdd.uin)));
      return paramView;
      localajlh = (ajlh)paramView.getTag();
      break;
      label470:
      localajlh.h.setVisibility(8);
      break label249;
      label483:
      bool = false;
      break label268;
      label488:
      localajlh.i.setVisibility(0);
      localajlh.i.setText(localQIMFollwerAdd.longNick);
      if (!AppSetting.c) {
        break label323;
      }
      ((StringBuilder)localObject).append(",").append(localQIMFollwerAdd.longNick);
      break label323;
      label535:
      localajlh.j.setVisibility(8);
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
 * Qualified Name:     ajlg
 * JD-Core Version:    0.7.0.1
 */