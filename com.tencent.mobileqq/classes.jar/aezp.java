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

public class aezp
  extends aeyf
  implements View.OnClickListener
{
  public ajph a;
  
  public aezp(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
    this.jdField_a_of_type_Bens = a(paramContext);
    this.jdField_a_of_type_Ajph = ((ajph)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257));
    this.b = paramContext.getResources().getDimensionPixelSize(2131166193);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aezq localaezq;
    StringBuilder localStringBuilder;
    QIMNotifyAddFriend localQIMNotifyAddFriend;
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof aezq)))
    {
      localaezq = new aezq();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131495535, localaezq);
      a(paramView, this.b);
      localaezq.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296259));
      localaezq.h = ((TextView)paramView.findViewById(2131305159));
      localaezq.i = ((TextView)paramView.findViewById(2131309446));
      localaezq.l = ((TextView)paramView.findViewById(2131296655));
      localaezq.j = ((TextView)paramView.findViewById(2131310547));
      localaezq.k = ((TextView)paramView.findViewById(2131309443));
      localaezq.a = ((Button)paramView.findViewById(2131309433));
      b(localaezq.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaezq);
      localaezq.g.setTag(localaezq);
      localaezq.g.setClickable(false);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atcu, localaezq, this);
      localStringBuilder = new StringBuilder(256);
      localQIMNotifyAddFriend = ((atdf)this.jdField_a_of_type_Atcu).a;
      localaezq.h.setText(localQIMNotifyAddFriend.nickName);
      if (AppSetting.c) {
        localStringBuilder.append(localQIMNotifyAddFriend.nickName);
      }
      localObject = localaezq.g;
      if (this.jdField_a_of_type_Atcu.a()) {
        break label564;
      }
      bool = true;
      label267:
      a((View)localObject, bool);
      a(localaezq.l, localQIMNotifyAddFriend.gender, localQIMNotifyAddFriend.age, localStringBuilder);
      localObject = this.jdField_a_of_type_Ajph.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label569;
      }
      localaezq.i.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), ajjy.a(2131644024), new Object[] { localObject });
      localaezq.j.setText((CharSequence)localObject);
      localaezq.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
      localaezq.k.setVisibility(8);
      localaezq.a.setText(ajjy.a(2131644025));
      localaezq.a.setVisibility(0);
      localaezq.a.setOnClickListener(this);
      localaezq.jdField_f_of_type_JavaLangString = String.valueOf(localQIMNotifyAddFriend.uin);
      localaezq.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      awqx.b(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
      return paramView;
      localaezq = (aezq)paramView.getTag();
      break;
      label564:
      bool = false;
      break label267;
      label569:
      localaezq.i.setVisibility(0);
      localaezq.i.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
    }
  }
  
  protected void a()
  {
    awqx.b(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
    ThreadManager.postImmediately(new QIMNotifyAddFriendBuilder.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131309584: 
      return;
    }
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(this.jdField_a_of_type_AndroidContentContext, null);
    ((ajnf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
    paramView = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    QIMNotifyAddFriend localQIMNotifyAddFriend = ((atdf)this.jdField_a_of_type_Atcu).a;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localQIMNotifyAddFriend);
    paramView.a(localArrayList);
    awqx.b(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezp
 * JD-Core Version:    0.7.0.1
 */