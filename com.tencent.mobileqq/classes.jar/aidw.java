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
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class aidw
  extends aiea
  implements View.OnClickListener
{
  protected int a;
  private aiej jdField_a_of_type_Aiej;
  private amvo jdField_a_of_type_Amvo;
  private int c;
  
  public aidw(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
    this.c = paramInt;
    this.jdField_a_of_type_Bjty = a(paramContext);
    this.jdField_a_of_type_Amvo = ((amvo)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_Aiej = ((aiej)paramQQAppInterface.getManager(34));
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297425);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aidx localaidx;
    MayKnowRecommend localMayKnowRecommend;
    label266:
    StringBuilder localStringBuilder;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof aidx)))
    {
      localaidx = new aidx();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561481, localaidx);
      localaidx.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localaidx.h = ((TextView)paramView.findViewById(2131371791));
      localaidx.k = ((TextView)paramView.findViewById(2131376351));
      localaidx.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376341));
      localaidx.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131379217));
      localaidx.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      localaidx.m = ((TextView)paramView.findViewById(2131370634));
      localaidx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377959));
      b(localaidx.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaidx);
      localaidx.g.setTag(localaidx);
      localaidx.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Aigo, localaidx, this);
      localMayKnowRecommend = ((aigl)this.jdField_a_of_type_Aigo).a;
      if (this.jdField_a_of_type_Aigo.a()) {
        break label633;
      }
      a(localaidx.g, true);
      if (bftf.b(String.valueOf(localMayKnowRecommend.uin))) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Aifw.b() == 23) {
        b();
      }
      localStringBuilder = new StringBuilder(256);
      bool = false;
      if (this.jdField_a_of_type_Amvo != null) {
        bool = this.jdField_a_of_type_Amvo.a();
      }
      Object localObject = localMayKnowRecommend.getDisplayName(bool);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label645;
      }
      localaidx.h.setVisibility(0);
      localaidx.h.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append((String)localObject);
      }
      label360:
      if ((TextUtils.isEmpty(localMayKnowRecommend.uin)) || (!bftf.b(localMayKnowRecommend.uin))) {
        break label658;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841793);
      ((Drawable)localObject).setBounds(0, 0, AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localaidx.h.setCompoundDrawables(null, null, (Drawable)localObject, null);
      label440:
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        break label673;
      }
      localaidx.m.setVisibility(8);
      label461:
      localaidx.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label712;
      }
      localaidx.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localaidx.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localaidx.jdField_a_of_type_AndroidWidgetButton.setText(amtj.a(2131689550));
      localaidx.jdField_a_of_type_AndroidWidgetButton.setTag(localMayKnowRecommend);
      localaidx.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",点击添加");
        localaidx.jdField_a_of_type_AndroidWidgetButton.setContentDescription(amtj.a(2131689550));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localaidx.jdField_f_of_type_JavaLangString = localMayKnowRecommend.uin;
      localaidx.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aifw.a(1, localMayKnowRecommend.uin));
      a(localaidx.jdField_a_of_type_AndroidWidgetTextView, localMayKnowRecommend, bool);
      return paramView;
      localaidx = (aidx)paramView.getTag();
      break;
      label633:
      a(localaidx.g, false);
      break label266;
      label645:
      localaidx.h.setVisibility(8);
      break label360;
      label658:
      localaidx.h.setCompoundDrawables(null, null, null, null);
      break label440;
      label673:
      localaidx.m.setText(localMayKnowRecommend.recommendReason);
      if (!AppSetting.c) {
        break label461;
      }
      localStringBuilder.append(",").append(localMayKnowRecommend.recommendReason);
      break label461;
      label712:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        localaidx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localaidx.k.setVisibility(0);
        localaidx.k.setText(2131717690);
        if (AppSetting.c)
        {
          localStringBuilder.append(",等待验证");
          localaidx.k.setContentDescription(amtj.a(2131705600));
        }
      }
      else
      {
        localaidx.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localaidx.k.setVisibility(0);
        localaidx.k.setText(2131690001);
        if (AppSetting.c)
        {
          localStringBuilder.append(",已添加");
          localaidx.k.setContentDescription(amtj.a(2131705602));
        }
      }
    }
  }
  
  public String a()
  {
    return ((aigl)this.jdField_a_of_type_Aigo).a.recommendReason;
  }
  
  protected void a()
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692035), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    String str = ((aigl)this.jdField_a_of_type_Aigo).a.uin;
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).cancelMayKnowRecommend(str);
    this.jdField_a_of_type_Aifw.a(this);
    this.jdField_a_of_type_Aifw.a(200L);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
    Object localObject = ((aigl)this.jdField_a_of_type_Aigo).a;
    if (localObject != null) {}
    for (localObject = ((MayKnowRecommend)localObject).msgLabel;; localObject = null)
    {
      int i = this.jdField_a_of_type_Aifw.b();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "frd_list_dlt", i, 0, ((aigl)this.jdField_a_of_type_Aigo).a.recommendReason, this.jdField_a_of_type_Int, ((aigl)this.jdField_a_of_type_Aigo).a.algBuffer, ContactReportUtils.a((List)localObject), 0, "3");
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
    return ((aigl)this.jdField_a_of_type_Aigo).a.algBuffer;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return ((aigl)this.jdField_a_of_type_Aigo).a.uin;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Amvo != null) {
      this.jdField_a_of_type_Amvo.a(((aigl)this.jdField_a_of_type_Aigo).a, 23, this.c, 1);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Amvo != null) {
      this.jdField_a_of_type_Amvo.b(((aigl)this.jdField_a_of_type_Aigo).a, 23, this.c, 1);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Aifw.b();
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131376512: 
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject1 = paramView.getTag();
        } while ((localObject1 == null) || (!(localObject1 instanceof aidx)));
        localObject1 = ((aigl)this.jdField_a_of_type_Aigo).a;
      } while (localObject1 == null);
      localObject2 = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject2 == null) || (!((amsw)localObject2).b(((MayKnowRecommend)localObject1).uin))) {
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
      if (this.jdField_a_of_type_Amvo != null) {
        bool = this.jdField_a_of_type_Amvo.a();
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
      this.jdField_a_of_type_Aiej.h();
      if ((j == 23) && (this.jdField_a_of_type_Amvo != null)) {
        this.jdField_a_of_type_Amvo.a((MayKnowRecommend)localObject1, 23, this.c, 2);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", j, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_Int, ((MayKnowRecommend)localObject1).algBuffer, str, 0, "3");
      break;
      localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof MayKnowRecommend))) {
        break;
      }
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692035), 0).b(c());
        break;
      }
      localObject1 = (MayKnowRecommend)localObject1;
      localObject2 = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((!((amsw)localObject2).b(((MayKnowRecommend)localObject1).uin)) && (!((amsw)localObject2).d(((MayKnowRecommend)localObject1).uin)))
      {
        bool = false;
        if (this.jdField_a_of_type_Amvo != null) {
          bool = this.jdField_a_of_type_Amvo.a();
        }
        localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
        i = this.jdField_a_of_type_Aifw.b();
        localObject2 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, i, (String)localObject2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689550), null);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(i), "", "", "");
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject2, 228);
      }
      for (;;)
      {
        this.jdField_a_of_type_Aiej.h();
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
        if (bftf.b(String.valueOf(((MayKnowRecommend)localObject1).uin))) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
        }
        if ((j == 23) && (this.jdField_a_of_type_Amvo != null)) {
          this.jdField_a_of_type_Amvo.a((MayKnowRecommend)localObject1, 23, this.c, 3);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_add", j, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_Int, ((MayKnowRecommend)localObject1).algBuffer, ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel), 0, "3");
        break;
        if (((amsw)localObject2).b(((MayKnowRecommend)localObject1).uin))
        {
          ((MayKnowRecommend)localObject1).friendStatus = 2;
          this.jdField_a_of_type_Aifw.notifyDataSetChanged();
        }
        else
        {
          ((MayKnowRecommend)localObject1).friendStatus = 1;
          this.jdField_a_of_type_Aifw.notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidw
 * JD-Core Version:    0.7.0.1
 */