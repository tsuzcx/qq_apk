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
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class afjp
  extends afjt
  implements View.OnClickListener
{
  protected int a;
  private akaa jdField_a_of_type_Akaa;
  private akbn jdField_a_of_type_Akbn;
  private int c;
  
  public afjp(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
    this.c = paramInt;
    this.jdField_a_of_type_Bfwd = a(paramContext);
    this.jdField_a_of_type_Akaa = ((akaa)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_Akbn = ((akbn)paramQQAppInterface.getManager(34));
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297276);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    afjq localafjq;
    MayKnowRecommend localMayKnowRecommend;
    label266:
    StringBuilder localStringBuilder;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof afjq)))
    {
      localafjq = new afjq();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561124, localafjq);
      localafjq.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localafjq.h = ((TextView)paramView.findViewById(2131370832));
      localafjq.k = ((TextView)paramView.findViewById(2131375193));
      localafjq.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375183));
      localafjq.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131377832));
      localafjq.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      localafjq.m = ((TextView)paramView.findViewById(2131369838));
      localafjq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376659));
      b(localafjq.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localafjq);
      localafjq.g.setTag(localafjq);
      localafjq.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atza, localafjq, this);
      localMayKnowRecommend = ((atyx)this.jdField_a_of_type_Atza).a;
      if (this.jdField_a_of_type_Atza.a()) {
        break label633;
      }
      a(localafjq.g, true);
      if (bbbr.b(String.valueOf(localMayKnowRecommend.uin))) {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Aipn.b() == 23) {
        b();
      }
      localStringBuilder = new StringBuilder(256);
      bool = false;
      if (this.jdField_a_of_type_Akaa != null) {
        bool = this.jdField_a_of_type_Akaa.a();
      }
      Object localObject = localMayKnowRecommend.getDisplayName(bool);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label645;
      }
      localafjq.h.setVisibility(0);
      localafjq.h.setText((CharSequence)localObject);
      if (AppSetting.d) {
        localStringBuilder.append((String)localObject);
      }
      label360:
      if ((TextUtils.isEmpty(localMayKnowRecommend.uin)) || (!bbbr.b(localMayKnowRecommend.uin))) {
        break label658;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841310);
      ((Drawable)localObject).setBounds(0, 0, actj.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actj.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localafjq.h.setCompoundDrawables(null, null, (Drawable)localObject, null);
      label440:
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        break label673;
      }
      localafjq.m.setVisibility(8);
      label461:
      localafjq.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label712;
      }
      localafjq.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localafjq.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localafjq.jdField_a_of_type_AndroidWidgetButton.setText(ajya.a(2131689628));
      localafjq.jdField_a_of_type_AndroidWidgetButton.setTag(localMayKnowRecommend);
      localafjq.k.setVisibility(8);
      if (AppSetting.d)
      {
        localStringBuilder.append(",点击添加");
        localafjq.jdField_a_of_type_AndroidWidgetButton.setContentDescription(ajya.a(2131689628));
      }
    }
    for (;;)
    {
      if (AppSetting.d) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localafjq.jdField_f_of_type_JavaLangString = localMayKnowRecommend.uin;
      localafjq.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipn.a(1, localMayKnowRecommend.uin));
      a(localafjq.jdField_a_of_type_AndroidWidgetTextView, localMayKnowRecommend, bool);
      return paramView;
      localafjq = (afjq)paramView.getTag();
      break;
      label633:
      a(localafjq.g, false);
      break label266;
      label645:
      localafjq.h.setVisibility(8);
      break label360;
      label658:
      localafjq.h.setCompoundDrawables(null, null, null, null);
      break label440;
      label673:
      localafjq.m.setText(localMayKnowRecommend.recommendReason);
      if (!AppSetting.d) {
        break label461;
      }
      localStringBuilder.append(",").append(localMayKnowRecommend.recommendReason);
      break label461;
      label712:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        localafjq.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localafjq.k.setVisibility(0);
        localafjq.k.setText(2131718754);
        if (AppSetting.d)
        {
          localStringBuilder.append(",等待验证");
          localafjq.k.setContentDescription(ajya.a(2131706488));
        }
      }
      else
      {
        localafjq.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localafjq.k.setVisibility(0);
        localafjq.k.setText(2131690035);
        if (AppSetting.d)
        {
          localStringBuilder.append(",已添加");
          localafjq.k.setContentDescription(ajya.a(2131706490));
        }
      }
    }
  }
  
  public String a()
  {
    return ((atyx)this.jdField_a_of_type_Atza).a.recommendReason;
  }
  
  protected void a()
  {
    if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    String str = ((atyx)this.jdField_a_of_type_Atza).a.uin;
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f(str);
    this.jdField_a_of_type_Aipn.a(this);
    this.jdField_a_of_type_Aipn.a(200L);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
    Object localObject = ((atyx)this.jdField_a_of_type_Atza).a;
    if (localObject != null) {}
    for (localObject = ((MayKnowRecommend)localObject).msgLabel;; localObject = null)
    {
      int i = this.jdField_a_of_type_Aipn.b();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "frd_list_dlt", i, 0, ((atyx)this.jdField_a_of_type_Atza).a.recommendReason, this.jdField_a_of_type_Int, ((atyx)this.jdField_a_of_type_Atza).a.algBuffer, ContactReportUtils.a((List)localObject), 0, "3");
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
    return ((atyx)this.jdField_a_of_type_Atza).a.algBuffer;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return ((atyx)this.jdField_a_of_type_Atza).a.uin;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Akaa != null) {
      this.jdField_a_of_type_Akaa.a(((atyx)this.jdField_a_of_type_Atza).a, 23, this.c, 1);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Akaa != null) {
      this.jdField_a_of_type_Akaa.b(((atyx)this.jdField_a_of_type_Atza).a, 23, this.c, 1);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Aipn.b();
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131375335: 
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof afjq)));
        paramView = ((atyx)this.jdField_a_of_type_Atza).a;
      } while (paramView == null);
      localObject = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject == null) || (!((ajxl)localObject).b(paramView.uin))) {
        break;
      }
    }
    for (int i = 1;; i = 110)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowRecommendBuilder", 2, "onClick rlSystemMsg， friendtype=" + i + ", gameSourceId=" + paramView.recommendReason);
      }
      localObject = new ProfileActivity.AllInOne(paramView.uin, i);
      boolean bool = false;
      if (this.jdField_a_of_type_Akaa != null) {
        bool = this.jdField_a_of_type_Akaa.a();
      }
      String str = paramView.getRecommendName(bool);
      if (!TextUtils.isEmpty(str)) {
        ((ProfileActivity.AllInOne)localObject).l = str;
      }
      if (!TextUtils.isEmpty(paramView.nick)) {
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = paramView.nick;
      }
      str = ContactReportUtils.a(paramView.msgLabel);
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 88;
      Bundle localBundle = new Bundle();
      localBundle.putString("recommend_entry_type", "3");
      localBundle.putString("recommend_reason", paramView.recommendReason);
      localBundle.putInt("recommend_pos", this.jdField_a_of_type_Int);
      localBundle.putByteArray("recommend_algh_id", paramView.algBuffer);
      localBundle.putString("recommend_label", str);
      localBundle.putInt("tabID", j);
      ProfileActivity.a((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject, 228, localBundle);
      this.jdField_a_of_type_Akbn.h();
      if ((j == 23) && (this.jdField_a_of_type_Akaa != null)) {
        this.jdField_a_of_type_Akaa.a(paramView, 23, this.c, 2);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_clk", j, 0, paramView.recommendReason, this.jdField_a_of_type_Int, paramView.algBuffer, str, 0, "3");
      return;
      paramView = paramView.getTag();
      if ((paramView == null) || (!(paramView instanceof MayKnowRecommend))) {
        break;
      }
      if (!bbfj.g(this.jdField_a_of_type_AndroidContentContext))
      {
        bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 0).b(c());
        return;
      }
      paramView = (MayKnowRecommend)paramView;
      localObject = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((!((ajxl)localObject).b(paramView.uin)) && (!((ajxl)localObject).d(paramView.uin)))
      {
        bool = false;
        if (this.jdField_a_of_type_Akaa != null) {
          bool = this.jdField_a_of_type_Akaa.a();
        }
        localObject = paramView.getDisplayName(bool);
        i = this.jdField_a_of_type_Aipn.b();
        localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, paramView.uin, null, 3045, i, (String)localObject, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689628), null);
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(i), "", "", "");
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 228);
      }
      for (;;)
      {
        this.jdField_a_of_type_Akbn.h();
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
        if (bbbr.b(String.valueOf(paramView.uin))) {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
        }
        if ((j == 23) && (this.jdField_a_of_type_Akaa != null)) {
          this.jdField_a_of_type_Akaa.a(paramView, 23, this.c, 3);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_add", j, 1, paramView.recommendReason, this.jdField_a_of_type_Int, paramView.algBuffer, ContactReportUtils.a(paramView.msgLabel), 0, "3");
        return;
        if (((ajxl)localObject).b(paramView.uin))
        {
          paramView.friendStatus = 2;
          this.jdField_a_of_type_Aipn.notifyDataSetChanged();
        }
        else
        {
          paramView.friendStatus = 1;
          this.jdField_a_of_type_Aipn.notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afjp
 * JD-Core Version:    0.7.0.1
 */