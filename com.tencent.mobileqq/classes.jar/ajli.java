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

public class ajli
  extends ajjr
  implements View.OnClickListener
{
  public aoej a;
  
  public ajli(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
    this.jdField_a_of_type_Blpv = a(paramContext);
    this.jdField_a_of_type_Aoej = ((aoej)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(257));
    this.b = paramContext.getResources().getDimensionPixelSize(2131297368);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ajlj localajlj;
    StringBuilder localStringBuilder;
    QIMNotifyAddFriend localQIMNotifyAddFriend;
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajlj)))
    {
      localajlj = new ajlj();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561601, localajlj);
      a(paramView, this.b);
      localajlj.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localajlj.h = ((TextView)paramView.findViewById(2131371827));
      localajlj.i = ((TextView)paramView.findViewById(2131376588));
      localajlj.l = ((TextView)paramView.findViewById(2131362302));
      localajlj.j = ((TextView)paramView.findViewById(2131377861));
      localajlj.k = ((TextView)paramView.findViewById(2131376585));
      localajlj.a = ((Button)paramView.findViewById(2131376575));
      b(localajlj.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localajlj);
      localajlj.g.setTag(localajlj);
      localajlj.g.setClickable(false);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajmf, localajlj, this);
      localStringBuilder = new StringBuilder(256);
      localQIMNotifyAddFriend = ((ajmq)this.jdField_a_of_type_Ajmf).a;
      localajlj.h.setText(localQIMNotifyAddFriend.nickName);
      if (AppSetting.c) {
        localStringBuilder.append(localQIMNotifyAddFriend.nickName);
      }
      localObject = localajlj.g;
      if (this.jdField_a_of_type_Ajmf.a()) {
        break label564;
      }
      bool = true;
      label267:
      a((View)localObject, bool);
      a(localajlj.l, localQIMNotifyAddFriend.gender, localQIMNotifyAddFriend.age, localStringBuilder);
      localObject = this.jdField_a_of_type_Aoej.a(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label569;
      }
      localajlj.i.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).c();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), anzj.a(2131708689), new Object[] { localObject });
      localajlj.j.setText((CharSequence)localObject);
      localajlj.j.setVisibility(0);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
      localajlj.k.setVisibility(8);
      localajlj.a.setText(anzj.a(2131708690));
      localajlj.a.setVisibility(0);
      localajlj.a.setOnClickListener(this);
      localajlj.jdField_f_of_type_JavaLangString = String.valueOf(localQIMNotifyAddFriend.uin);
      localajlj.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      bdll.b(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
      return paramView;
      localajlj = (ajlj)paramView.getTag();
      break;
      label564:
      bool = false;
      break label267;
      label569:
      localajlj.i.setVisibility(0);
      localajlj.i.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append(",").append((String)localObject);
      }
    }
  }
  
  protected void a()
  {
    bdll.b(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
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
      ((ajka)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34)).g();
      FriendListHandler localFriendListHandler = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
      QIMNotifyAddFriend localQIMNotifyAddFriend = ((ajmq)this.jdField_a_of_type_Ajmf).a;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localQIMNotifyAddFriend);
      localFriendListHandler.b(localArrayList);
      bdll.b(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajli
 * JD-Core Version:    0.7.0.1
 */