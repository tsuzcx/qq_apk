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

public class ahmx
  extends ahln
  implements View.OnClickListener
{
  public alzu a;
  
  public ahmx(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
    this.jdField_a_of_type_Bibh = a(paramContext);
    this.jdField_a_of_type_Alzu = ((alzu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257));
    this.b = paramContext.getResources().getDimensionPixelSize(2131297293);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ahmy localahmy;
    StringBuilder localStringBuilder;
    QIMNotifyAddFriend localQIMNotifyAddFriend;
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahmy)))
    {
      localahmy = new ahmy();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561327, localahmy);
      a(paramView, this.b);
      localahmy.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localahmy.h = ((TextView)paramView.findViewById(2131371161));
      localahmy.i = ((TextView)paramView.findViewById(2131375729));
      localahmy.l = ((TextView)paramView.findViewById(2131362215));
      localahmy.j = ((TextView)paramView.findViewById(2131376899));
      localahmy.k = ((TextView)paramView.findViewById(2131375726));
      localahmy.a = ((Button)paramView.findViewById(2131375716));
      b(localahmy.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localahmy);
      localahmy.g.setTag(localahmy);
      localahmy.g.setClickable(false);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Avun, localahmy, this);
      localStringBuilder = new StringBuilder(256);
      localQIMNotifyAddFriend = ((avuy)this.jdField_a_of_type_Avun).a;
      localahmy.h.setText(localQIMNotifyAddFriend.nickName);
      if (AppSetting.c) {
        localStringBuilder.append(localQIMNotifyAddFriend.nickName);
      }
      localObject = localahmy.g;
      if (this.jdField_a_of_type_Avun.a()) {
        break label564;
      }
      bool = true;
      label267:
      a((View)localObject, bool);
      a(localahmy.l, localQIMNotifyAddFriend.gender, localQIMNotifyAddFriend.age, localStringBuilder);
      localObject = this.jdField_a_of_type_Alzu.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label569;
      }
      localahmy.i.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), alud.a(2131710204), new Object[] { localObject });
      localahmy.j.setText((CharSequence)localObject);
      localahmy.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
      localahmy.k.setVisibility(8);
      localahmy.a.setText(alud.a(2131710205));
      localahmy.a.setVisibility(0);
      localahmy.a.setOnClickListener(this);
      localahmy.jdField_f_of_type_JavaLangString = String.valueOf(localQIMNotifyAddFriend.uin);
      localahmy.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      azqs.b(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
      return paramView;
      localahmy = (ahmy)paramView.getTag();
      break;
      label564:
      bool = false;
      break label267;
      label569:
      localahmy.i.setVisibility(0);
      localahmy.i.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
    }
  }
  
  protected void a()
  {
    azqs.b(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
    ThreadManager.postImmediately(new QIMNotifyAddFriendBuilder.1(this), null, true);
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
    ((alxr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
    paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    QIMNotifyAddFriend localQIMNotifyAddFriend = ((avuy)this.jdField_a_of_type_Avun).a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localQIMNotifyAddFriend);
    paramView.a(localArrayList);
    azqs.b(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmx
 * JD-Core Version:    0.7.0.1
 */