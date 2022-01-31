import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.newfriend.QIMNotifyAddFriendBuilder.1;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ahii
  extends ahgy
  implements View.OnClickListener
{
  public alvf a;
  
  public ahii(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
    this.jdField_a_of_type_Bhxa = a(paramContext);
    this.jdField_a_of_type_Alvf = ((alvf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257));
    this.b = paramContext.getResources().getDimensionPixelSize(2131297293);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ahij localahij;
    StringBuilder localStringBuilder;
    QIMNotifyAddFriend localQIMNotifyAddFriend;
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahij)))
    {
      localahij = new ahij();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561309, localahij);
      a(paramView, this.b);
      localahij.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localahij.h = ((TextView)paramView.findViewById(2131371142));
      localahij.i = ((TextView)paramView.findViewById(2131375678));
      localahij.l = ((TextView)paramView.findViewById(2131362215));
      localahij.j = ((TextView)paramView.findViewById(2131376845));
      localahij.k = ((TextView)paramView.findViewById(2131375675));
      localahij.a = ((Button)paramView.findViewById(2131375665));
      b(localahij.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localahij);
      localahij.g.setTag(localahij);
      localahij.g.setClickable(false);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Avqe, localahij, this);
      localStringBuilder = new StringBuilder(256);
      localQIMNotifyAddFriend = ((avqp)this.jdField_a_of_type_Avqe).a;
      localahij.h.setText(localQIMNotifyAddFriend.nickName);
      if (AppSetting.c) {
        localStringBuilder.append(localQIMNotifyAddFriend.nickName);
      }
      localObject = localahij.g;
      if (this.jdField_a_of_type_Avqe.a()) {
        break label564;
      }
      bool = true;
      label267:
      a((View)localObject, bool);
      a(localahij.l, localQIMNotifyAddFriend.gender, localQIMNotifyAddFriend.age, localStringBuilder);
      localObject = this.jdField_a_of_type_Alvf.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label569;
      }
      localahij.i.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), alpo.a(2131710192), new Object[] { localObject });
      localahij.j.setText((CharSequence)localObject);
      localahij.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
      localahij.k.setVisibility(8);
      localahij.a.setText(alpo.a(2131710193));
      localahij.a.setVisibility(0);
      localahij.a.setOnClickListener(this);
      localahij.jdField_f_of_type_JavaLangString = String.valueOf(localQIMNotifyAddFriend.uin);
      localahij.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      azmj.b(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
      return paramView;
      localahij = (ahij)paramView.getTag();
      break;
      label564:
      bool = false;
      break label267;
      label569:
      localahij.i.setVisibility(0);
      localahij.i.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
    }
  }
  
  protected void a()
  {
    azmj.b(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
    ThreadManager.postImmediately(new QIMNotifyAddFriendBuilder.1(this), null, true);
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
    ((altc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
    paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    QIMNotifyAddFriend localQIMNotifyAddFriend = ((avqp)this.jdField_a_of_type_Avqe).a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localQIMNotifyAddFriend);
    paramView.a(localArrayList);
    azmj.b(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahii
 * JD-Core Version:    0.7.0.1
 */