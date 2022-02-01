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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ajaq
  extends aiyz
  implements View.OnClickListener
{
  public aoay a;
  
  public ajaq(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
    this.jdField_a_of_type_Blfk = a(paramContext);
    this.jdField_a_of_type_Aoay = ((aoay)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER));
    this.b = paramContext.getResources().getDimensionPixelSize(2131297424);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ajar localajar;
    StringBuilder localStringBuilder;
    QIMNotifyAddFriend localQIMNotifyAddFriend;
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajar)))
    {
      localajar = new ajar();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561541, localajar);
      a(paramView, this.b);
      localajar.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localajar.h = ((TextView)paramView.findViewById(2131371981));
      localajar.i = ((TextView)paramView.findViewById(2131376609));
      localajar.l = ((TextView)paramView.findViewById(2131362310));
      localajar.j = ((TextView)paramView.findViewById(2131377905));
      localajar.k = ((TextView)paramView.findViewById(2131376606));
      localajar.a = ((Button)paramView.findViewById(2131376596));
      b(localajar.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localajar);
      localajar.g.setTag(localajar);
      localajar.g.setClickable(false);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajbn, localajar, this);
      localStringBuilder = new StringBuilder(256);
      localQIMNotifyAddFriend = ((ajby)this.jdField_a_of_type_Ajbn).a;
      localajar.h.setText(localQIMNotifyAddFriend.nickName);
      if (AppSetting.c) {
        localStringBuilder.append(localQIMNotifyAddFriend.nickName);
      }
      localObject = localajar.g;
      if (this.jdField_a_of_type_Ajbn.a()) {
        break label564;
      }
      bool = true;
      label267:
      a((View)localObject, bool);
      a(localajar.l, localQIMNotifyAddFriend.gender, localQIMNotifyAddFriend.age, localStringBuilder);
      localObject = this.jdField_a_of_type_Aoay.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label569;
      }
      localajar.i.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), anvx.a(2131709268), new Object[] { localObject });
      localajar.j.setText((CharSequence)localObject);
      localajar.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
      localajar.k.setVisibility(8);
      localajar.a.setText(anvx.a(2131709269));
      localajar.a.setVisibility(0);
      localajar.a.setOnClickListener(this);
      localajar.jdField_f_of_type_JavaLangString = String.valueOf(localQIMNotifyAddFriend.uin);
      localajar.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      bdla.b(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
      return paramView;
      localajar = (ajar)paramView.getTag();
      break;
      label564:
      bool = false;
      break label267;
      label569:
      localajar.i.setVisibility(0);
      localajar.i.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
    }
  }
  
  protected void a()
  {
    bdla.b(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
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
      ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, null);
      ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).g();
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      QIMNotifyAddFriend localQIMNotifyAddFriend = ((ajby)this.jdField_a_of_type_Ajbn).a;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localQIMNotifyAddFriend);
      localFriendListHandler.addBatchQIMFriends(localArrayList);
      bdla.b(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajaq
 * JD-Core Version:    0.7.0.1
 */