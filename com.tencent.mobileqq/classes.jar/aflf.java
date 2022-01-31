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

public class aflf
  extends afjv
  implements View.OnClickListener
{
  public akdr a;
  
  public aflf(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
    this.jdField_a_of_type_Bfvm = a(paramContext);
    this.jdField_a_of_type_Akdr = ((akdr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257));
    this.b = paramContext.getResources().getDimensionPixelSize(2131297274);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aflg localaflg;
    StringBuilder localStringBuilder;
    QIMNotifyAddFriend localQIMNotifyAddFriend;
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof aflg)))
    {
      localaflg = new aflg();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561123, localaflg);
      a(paramView, this.b);
      localaflg.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localaflg.h = ((TextView)paramView.findViewById(2131370832));
      localaflg.i = ((TextView)paramView.findViewById(2131375194));
      localaflg.l = ((TextView)paramView.findViewById(2131362196));
      localaflg.j = ((TextView)paramView.findViewById(2131376339));
      localaflg.k = ((TextView)paramView.findViewById(2131375191));
      localaflg.a = ((Button)paramView.findViewById(2131375181));
      b(localaflg.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaflg);
      localaflg.g.setTag(localaflg);
      localaflg.g.setClickable(false);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atyy, localaflg, this);
      localStringBuilder = new StringBuilder(256);
      localQIMNotifyAddFriend = ((atzj)this.jdField_a_of_type_Atyy).a;
      localaflg.h.setText(localQIMNotifyAddFriend.nickName);
      if (AppSetting.d) {
        localStringBuilder.append(localQIMNotifyAddFriend.nickName);
      }
      localObject = localaflg.g;
      if (this.jdField_a_of_type_Atyy.a()) {
        break label564;
      }
      bool = true;
      label267:
      a((View)localObject, bool);
      a(localaflg.l, localQIMNotifyAddFriend.gender, localQIMNotifyAddFriend.age, localStringBuilder);
      localObject = this.jdField_a_of_type_Akdr.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label569;
      }
      localaflg.i.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), ajyc.a(2131709809), new Object[] { localObject });
      localaflg.j.setText((CharSequence)localObject);
      localaflg.j.setVisibility(0);
      if (AppSetting.d) {
        localStringBuilder.append(",").append((String)localObject);
      }
      localaflg.k.setVisibility(8);
      localaflg.a.setText(ajyc.a(2131709810));
      localaflg.a.setVisibility(0);
      localaflg.a.setOnClickListener(this);
      localaflg.jdField_f_of_type_JavaLangString = String.valueOf(localQIMNotifyAddFriend.uin);
      localaflg.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
      if (AppSetting.d) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      axqw.b(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
      return paramView;
      localaflg = (aflg)paramView.getTag();
      break;
      label564:
      bool = false;
      break label267;
      label569:
      localaflg.i.setVisibility(0);
      localaflg.i.setText((CharSequence)localObject);
      if (AppSetting.d) {
        localStringBuilder.append(",").append((String)localObject);
      }
    }
  }
  
  protected void a()
  {
    axqw.b(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
    ThreadManager.postImmediately(new QIMNotifyAddFriendBuilder.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131375333: 
      return;
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(this.jdField_a_of_type_AndroidContentContext, null);
    ((akbo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
    paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    QIMNotifyAddFriend localQIMNotifyAddFriend = ((atzj)this.jdField_a_of_type_Atyy).a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localQIMNotifyAddFriend);
    paramView.a(localArrayList);
    axqw.b(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aflf
 * JD-Core Version:    0.7.0.1
 */