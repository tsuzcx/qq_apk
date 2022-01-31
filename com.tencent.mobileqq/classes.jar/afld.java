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

public class afld
  extends afjt
  implements View.OnClickListener
{
  public akdq a;
  
  public afld(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
    this.jdField_a_of_type_Bfwd = a(paramContext);
    this.jdField_a_of_type_Akdq = ((akdq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257));
    this.b = paramContext.getResources().getDimensionPixelSize(2131297274);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    afle localafle;
    StringBuilder localStringBuilder;
    QIMNotifyAddFriend localQIMNotifyAddFriend;
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof afle)))
    {
      localafle = new afle();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561122, localafle);
      a(paramView, this.b);
      localafle.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localafle.h = ((TextView)paramView.findViewById(2131370832));
      localafle.i = ((TextView)paramView.findViewById(2131375196));
      localafle.l = ((TextView)paramView.findViewById(2131362195));
      localafle.j = ((TextView)paramView.findViewById(2131376341));
      localafle.k = ((TextView)paramView.findViewById(2131375193));
      localafle.a = ((Button)paramView.findViewById(2131375183));
      b(localafle.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localafle);
      localafle.g.setTag(localafle);
      localafle.g.setClickable(false);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atza, localafle, this);
      localStringBuilder = new StringBuilder(256);
      localQIMNotifyAddFriend = ((atzl)this.jdField_a_of_type_Atza).a;
      localafle.h.setText(localQIMNotifyAddFriend.nickName);
      if (AppSetting.d) {
        localStringBuilder.append(localQIMNotifyAddFriend.nickName);
      }
      localObject = localafle.g;
      if (this.jdField_a_of_type_Atza.a()) {
        break label564;
      }
      bool = true;
      label267:
      a((View)localObject, bool);
      a(localafle.l, localQIMNotifyAddFriend.gender, localQIMNotifyAddFriend.age, localStringBuilder);
      localObject = this.jdField_a_of_type_Akdq.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label569;
      }
      localafle.i.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), ajya.a(2131709820), new Object[] { localObject });
      localafle.j.setText((CharSequence)localObject);
      localafle.j.setVisibility(0);
      if (AppSetting.d) {
        localStringBuilder.append(",").append((String)localObject);
      }
      localafle.k.setVisibility(8);
      localafle.a.setText(ajya.a(2131709821));
      localafle.a.setVisibility(0);
      localafle.a.setOnClickListener(this);
      localafle.jdField_f_of_type_JavaLangString = String.valueOf(localQIMNotifyAddFriend.uin);
      localafle.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
      if (AppSetting.d) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      axqy.b(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
      return paramView;
      localafle = (afle)paramView.getTag();
      break;
      label564:
      bool = false;
      break label267;
      label569:
      localafle.i.setVisibility(0);
      localafle.i.setText((CharSequence)localObject);
      if (AppSetting.d) {
        localStringBuilder.append(",").append((String)localObject);
      }
    }
  }
  
  protected void a()
  {
    axqy.b(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
    ThreadManager.postImmediately(new QIMNotifyAddFriendBuilder.1(this), null, true);
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
    ((akbn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
    paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    QIMNotifyAddFriend localQIMNotifyAddFriend = ((atzl)this.jdField_a_of_type_Atza).a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localQIMNotifyAddFriend);
    paramView.a(localArrayList);
    axqy.b(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afld
 * JD-Core Version:    0.7.0.1
 */