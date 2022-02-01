import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aiyv
  extends aiyz
  implements View.OnClickListener
{
  protected int a;
  private aizi jdField_a_of_type_Aizi;
  private anyb jdField_a_of_type_Anyb;
  private int c;
  
  public aiyv(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
    this.c = paramInt;
    this.jdField_a_of_type_Blfk = a(paramContext);
    this.jdField_a_of_type_Anyb = ((anyb)paramQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER));
    this.jdField_a_of_type_Aizi = ((aizi)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297426);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aiyw localaiyw;
    MayKnowRecommend localMayKnowRecommend;
    label266:
    StringBuilder localStringBuilder;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof aiyw)))
    {
      localaiyw = new aiyw();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561543, localaiyw);
      localaiyw.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localaiyw.h = ((TextView)paramView.findViewById(2131371981));
      localaiyw.k = ((TextView)paramView.findViewById(2131376606));
      localaiyw.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376596));
      localaiyw.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131379521));
      localaiyw.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      localaiyw.m = ((TextView)paramView.findViewById(2131370817));
      localaiyw.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378247));
      b(localaiyw.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaiyw);
      localaiyw.g.setTag(localaiyw);
      localaiyw.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajbn, localaiyw, this);
      localMayKnowRecommend = ((ajbk)this.jdField_a_of_type_Ajbn).a;
      if (this.jdField_a_of_type_Ajbn.a()) {
        break label633;
      }
      a(localaiyw.g, true);
      if (bhbx.b(String.valueOf(localMayKnowRecommend.uin))) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Ajav.b() == 23) {
        b();
      }
      localStringBuilder = new StringBuilder(256);
      bool = false;
      if (this.jdField_a_of_type_Anyb != null) {
        bool = this.jdField_a_of_type_Anyb.a();
      }
      Object localObject = localMayKnowRecommend.getDisplayName(bool);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label645;
      }
      localaiyw.h.setVisibility(0);
      localaiyw.h.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append((String)localObject);
      }
      label360:
      if ((TextUtils.isEmpty(localMayKnowRecommend.uin)) || (!bhbx.b(localMayKnowRecommend.uin))) {
        break label658;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841803);
      ((Drawable)localObject).setBounds(0, 0, AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localaiyw.h.setCompoundDrawables(null, null, (Drawable)localObject, null);
      label440:
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        break label673;
      }
      localaiyw.m.setVisibility(8);
      label461:
      localaiyw.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label712;
      }
      localaiyw.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localaiyw.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localaiyw.jdField_a_of_type_AndroidWidgetButton.setText(anvx.a(2131689550));
      localaiyw.jdField_a_of_type_AndroidWidgetButton.setTag(localMayKnowRecommend);
      localaiyw.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",点击添加");
        localaiyw.jdField_a_of_type_AndroidWidgetButton.setContentDescription(anvx.a(2131689550));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localaiyw.jdField_f_of_type_JavaLangString = localMayKnowRecommend.uin;
      localaiyw.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajav.a(1, localMayKnowRecommend.uin));
      a(localaiyw.jdField_a_of_type_AndroidWidgetTextView, localMayKnowRecommend, bool);
      return paramView;
      localaiyw = (aiyw)paramView.getTag();
      break;
      label633:
      a(localaiyw.g, false);
      break label266;
      label645:
      localaiyw.h.setVisibility(8);
      break label360;
      label658:
      localaiyw.h.setCompoundDrawables(null, null, null, null);
      break label440;
      label673:
      localaiyw.m.setText(localMayKnowRecommend.recommendReason);
      if (!AppSetting.c) {
        break label461;
      }
      localStringBuilder.append(",").append(localMayKnowRecommend.recommendReason);
      break label461;
      label712:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        localaiyw.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localaiyw.k.setVisibility(0);
        localaiyw.k.setText(2131718061);
        if (AppSetting.c)
        {
          localStringBuilder.append(",等待验证");
          localaiyw.k.setContentDescription(anvx.a(2131705951));
        }
      }
      else
      {
        localaiyw.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localaiyw.k.setVisibility(0);
        localaiyw.k.setText(2131690030);
        if (AppSetting.c)
        {
          localStringBuilder.append(",已添加");
          localaiyw.k.setContentDescription(anvx.a(2131705953));
        }
      }
    }
  }
  
  public String a()
  {
    return ((ajbk)this.jdField_a_of_type_Ajbn).a.recommendReason;
  }
  
  protected void a()
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692125), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    String str = ((ajbk)this.jdField_a_of_type_Ajbn).a.uin;
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend(str);
    this.jdField_a_of_type_Ajav.a(this);
    this.jdField_a_of_type_Ajav.a(200L);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
    Object localObject = ((ajbk)this.jdField_a_of_type_Ajbn).a;
    if (localObject != null) {}
    for (localObject = ((MayKnowRecommend)localObject).msgLabel;; localObject = null)
    {
      int i = this.jdField_a_of_type_Ajav.b();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "frd_list_dlt", i, 0, ((ajbk)this.jdField_a_of_type_Ajbn).a.recommendReason, this.jdField_a_of_type_Int, ((ajbk)this.jdField_a_of_type_Ajbn).a.algBuffer, ContactReportUtils.a((List)localObject), 0, "3");
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(TextView paramTextView, MayKnowRecommend paramMayKnowRecommend, boolean paramBoolean)
  {
    if (paramMayKnowRecommend == null) {
      return;
    }
    String str = paramMayKnowRecommend.getDisplayName(paramBoolean);
    if ((!TextUtils.isEmpty(paramMayKnowRecommend.mobile_name)) && (!str.equals(paramMayKnowRecommend.mobile_name)))
    {
      paramTextView.setText("(" + paramMayKnowRecommend.mobile_name + ")");
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public byte[] a()
  {
    return ((ajbk)this.jdField_a_of_type_Ajbn).a.algBuffer;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return ((ajbk)this.jdField_a_of_type_Ajbn).a.uin;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Anyb != null) {
      this.jdField_a_of_type_Anyb.a(((ajbk)this.jdField_a_of_type_Ajbn).a, 23, this.c, 1);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Anyb != null) {
      this.jdField_a_of_type_Anyb.b(((ajbk)this.jdField_a_of_type_Ajbn).a, 23, this.c, 1);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Ajav.b();
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131376771: 
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject1 = paramView.getTag();
        } while ((localObject1 == null) || (!(localObject1 instanceof aiyw)));
        localObject1 = ((ajbk)this.jdField_a_of_type_Ajbn).a;
      } while (localObject1 == null);
      localObject2 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject2 == null) || (!((anvk)localObject2).b(((MayKnowRecommend)localObject1).uin))) {
        break;
      }
    }
    for (int i = 1;; i = 110)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowRecommendBuilder", 2, "onClick rlSystemMsg， friendtype=" + i + ", gameSourceId=" + ((MayKnowRecommend)localObject1).recommendReason);
      }
      localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, i);
      boolean bool = false;
      if (this.jdField_a_of_type_Anyb != null) {
        bool = this.jdField_a_of_type_Anyb.a();
      }
      String str = ((MayKnowRecommend)localObject1).getRecommendName(bool);
      if (!TextUtils.isEmpty(str)) {
        ((ProfileActivity.AllInOne)localObject2).l = str;
      }
      if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
        ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((MayKnowRecommend)localObject1).nick;
      }
      str = ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel);
      ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 88;
      Bundle localBundle = new Bundle();
      localBundle.putString("recommend_entry_type", "3");
      localBundle.putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
      localBundle.putInt("recommend_pos", this.jdField_a_of_type_Int);
      localBundle.putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
      localBundle.putString("recommend_label", str);
      localBundle.putInt("tabID", j);
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject2, 228, localBundle);
      this.jdField_a_of_type_Aizi.h();
      if ((j == 23) && (this.jdField_a_of_type_Anyb != null)) {
        this.jdField_a_of_type_Anyb.a((MayKnowRecommend)localObject1, 23, this.c, 2);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", j, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_Int, ((MayKnowRecommend)localObject1).algBuffer, str, 0, "3");
      break;
      localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof MayKnowRecommend))) {
        break;
      }
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692125), 0).b(c());
        break;
      }
      localObject1 = (MayKnowRecommend)localObject1;
      localObject2 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((!((anvk)localObject2).b(((MayKnowRecommend)localObject1).uin)) && (!((anvk)localObject2).d(((MayKnowRecommend)localObject1).uin)))
      {
        bool = false;
        if (this.jdField_a_of_type_Anyb != null) {
          bool = this.jdField_a_of_type_Anyb.a();
        }
        localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
        i = this.jdField_a_of_type_Ajav.b();
        localObject2 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, i, (String)localObject2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689550), null);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(i), "", "", "");
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject2, 228);
      }
      for (;;)
      {
        this.jdField_a_of_type_Aizi.h();
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
        if (bhbx.b(String.valueOf(((MayKnowRecommend)localObject1).uin))) {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
        }
        if ((j == 23) && (this.jdField_a_of_type_Anyb != null)) {
          this.jdField_a_of_type_Anyb.a((MayKnowRecommend)localObject1, 23, this.c, 3);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_add", j, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_Int, ((MayKnowRecommend)localObject1).algBuffer, ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel), 0, "3");
        break;
        if (((anvk)localObject2).b(((MayKnowRecommend)localObject1).uin))
        {
          ((MayKnowRecommend)localObject1).friendStatus = 2;
          this.jdField_a_of_type_Ajav.notifyDataSetChanged();
        }
        else
        {
          ((MayKnowRecommend)localObject1).friendStatus = 1;
          this.jdField_a_of_type_Ajav.notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyv
 * JD-Core Version:    0.7.0.1
 */