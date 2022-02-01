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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class aifr
  extends aiea
  implements View.OnClickListener
{
  public amyk a;
  
  public aifr(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
    this.jdField_a_of_type_Bjty = a(paramContext);
    this.jdField_a_of_type_Amyk = ((amyk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257));
    this.b = paramContext.getResources().getDimensionPixelSize(2131297423);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aifs localaifs;
    StringBuilder localStringBuilder;
    QIMNotifyAddFriend localQIMNotifyAddFriend;
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof aifs)))
    {
      localaifs = new aifs();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561479, localaifs);
      a(paramView, this.b);
      localaifs.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localaifs.h = ((TextView)paramView.findViewById(2131371791));
      localaifs.i = ((TextView)paramView.findViewById(2131376354));
      localaifs.l = ((TextView)paramView.findViewById(2131362305));
      localaifs.j = ((TextView)paramView.findViewById(2131377631));
      localaifs.k = ((TextView)paramView.findViewById(2131376351));
      localaifs.a = ((Button)paramView.findViewById(2131376341));
      b(localaifs.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaifs);
      localaifs.g.setTag(localaifs);
      localaifs.g.setClickable(false);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Aigo, localaifs, this);
      localStringBuilder = new StringBuilder(256);
      localQIMNotifyAddFriend = ((aigz)this.jdField_a_of_type_Aigo).a;
      localaifs.h.setText(localQIMNotifyAddFriend.nickName);
      if (AppSetting.c) {
        localStringBuilder.append(localQIMNotifyAddFriend.nickName);
      }
      localObject = localaifs.g;
      if (this.jdField_a_of_type_Aigo.a()) {
        break label564;
      }
      bool = true;
      label267:
      a((View)localObject, bool);
      a(localaifs.l, localQIMNotifyAddFriend.gender, localQIMNotifyAddFriend.age, localStringBuilder);
      localObject = this.jdField_a_of_type_Amyk.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label569;
      }
      localaifs.i.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), amtj.a(2131708921), new Object[] { localObject });
      localaifs.j.setText((CharSequence)localObject);
      localaifs.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
      localaifs.k.setVisibility(8);
      localaifs.a.setText(amtj.a(2131708922));
      localaifs.a.setVisibility(0);
      localaifs.a.setOnClickListener(this);
      localaifs.jdField_f_of_type_JavaLangString = String.valueOf(localQIMNotifyAddFriend.uin);
      localaifs.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      bcef.b(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
      return paramView;
      localaifs = (aifs)paramView.getTag();
      break;
      label564:
      bool = false;
      break label267;
      label569:
      localaifs.i.setVisibility(0);
      localaifs.i.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
    }
  }
  
  protected void a()
  {
    bcef.b(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
    ThreadManager.postImmediately(new QIMNotifyAddFriendBuilder.1(this), null, true);
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
      ((aiej)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1);
      QIMNotifyAddFriend localQIMNotifyAddFriend = ((aigz)this.jdField_a_of_type_Aigo).a;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localQIMNotifyAddFriend);
      localFriendListHandler.addBatchQIMFriends(localArrayList);
      bcef.b(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifr
 * JD-Core Version:    0.7.0.1
 */