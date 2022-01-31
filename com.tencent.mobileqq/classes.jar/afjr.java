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

public class afjr
  extends afjv
  implements View.OnClickListener
{
  protected int a;
  private akac jdField_a_of_type_Akac;
  private akbo jdField_a_of_type_Akbo;
  private int c;
  
  public afjr(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
    this.c = paramInt;
    this.jdField_a_of_type_Bfvm = a(paramContext);
    this.jdField_a_of_type_Akac = ((akac)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_Akbo = ((akbo)paramQQAppInterface.getManager(34));
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297276);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    afjs localafjs;
    MayKnowRecommend localMayKnowRecommend;
    label266:
    StringBuilder localStringBuilder;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof afjs)))
    {
      localafjs = new afjs();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561125, localafjs);
      localafjs.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localafjs.h = ((TextView)paramView.findViewById(2131370832));
      localafjs.k = ((TextView)paramView.findViewById(2131375191));
      localafjs.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375181));
      localafjs.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131377827));
      localafjs.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      localafjs.m = ((TextView)paramView.findViewById(2131369839));
      localafjs.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376657));
      b(localafjs.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localafjs);
      localafjs.g.setTag(localafjs);
      localafjs.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atyy, localafjs, this);
      localMayKnowRecommend = ((atyv)this.jdField_a_of_type_Atyy).a;
      if (this.jdField_a_of_type_Atyy.a()) {
        break label633;
      }
      a(localafjs.g, true);
      if (bbbd.b(String.valueOf(localMayKnowRecommend.uin))) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Aipp.b() == 23) {
        b();
      }
      localStringBuilder = new StringBuilder(256);
      bool = false;
      if (this.jdField_a_of_type_Akac != null) {
        bool = this.jdField_a_of_type_Akac.a();
      }
      Object localObject = localMayKnowRecommend.getDisplayName(bool);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label645;
      }
      localafjs.h.setVisibility(0);
      localafjs.h.setText((CharSequence)localObject);
      if (AppSetting.d) {
        localStringBuilder.append((String)localObject);
      }
      label360:
      if ((TextUtils.isEmpty(localMayKnowRecommend.uin)) || (!bbbd.b(localMayKnowRecommend.uin))) {
        break label658;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841313);
      ((Drawable)localObject).setBounds(0, 0, actn.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), actn.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localafjs.h.setCompoundDrawables(null, null, (Drawable)localObject, null);
      label440:
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        break label673;
      }
      localafjs.m.setVisibility(8);
      label461:
      localafjs.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label712;
      }
      localafjs.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localafjs.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localafjs.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131689628));
      localafjs.jdField_a_of_type_AndroidWidgetButton.setTag(localMayKnowRecommend);
      localafjs.k.setVisibility(8);
      if (AppSetting.d)
      {
        localStringBuilder.append(",点击添加");
        localafjs.jdField_a_of_type_AndroidWidgetButton.setContentDescription(ajyc.a(2131689628));
      }
    }
    for (;;)
    {
      if (AppSetting.d) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localafjs.jdField_f_of_type_JavaLangString = localMayKnowRecommend.uin;
      localafjs.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aipp.a(1, localMayKnowRecommend.uin));
      a(localafjs.jdField_a_of_type_AndroidWidgetTextView, localMayKnowRecommend, bool);
      return paramView;
      localafjs = (afjs)paramView.getTag();
      break;
      label633:
      a(localafjs.g, false);
      break label266;
      label645:
      localafjs.h.setVisibility(8);
      break label360;
      label658:
      localafjs.h.setCompoundDrawables(null, null, null, null);
      break label440;
      label673:
      localafjs.m.setText(localMayKnowRecommend.recommendReason);
      if (!AppSetting.d) {
        break label461;
      }
      localStringBuilder.append(",").append(localMayKnowRecommend.recommendReason);
      break label461;
      label712:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        localafjs.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localafjs.k.setVisibility(0);
        localafjs.k.setText(2131718743);
        if (AppSetting.d)
        {
          localStringBuilder.append(",等待验证");
          localafjs.k.setContentDescription(ajyc.a(2131706477));
        }
      }
      else
      {
        localafjs.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localafjs.k.setVisibility(0);
        localafjs.k.setText(2131690035);
        if (AppSetting.d)
        {
          localStringBuilder.append(",已添加");
          localafjs.k.setContentDescription(ajyc.a(2131706479));
        }
      }
    }
  }
  
  public String a()
  {
    return ((atyv)this.jdField_a_of_type_Atyy).a.recommendReason;
  }
  
  protected void a()
  {
    if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    String str = ((atyv)this.jdField_a_of_type_Atyy).a.uin;
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f(str);
    this.jdField_a_of_type_Aipp.a(this);
    this.jdField_a_of_type_Aipp.a(200L);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
    Object localObject = ((atyv)this.jdField_a_of_type_Atyy).a;
    if (localObject != null) {}
    for (localObject = ((MayKnowRecommend)localObject).msgLabel;; localObject = null)
    {
      int i = this.jdField_a_of_type_Aipp.b();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "frd_list_dlt", i, 0, ((atyv)this.jdField_a_of_type_Atyy).a.recommendReason, this.jdField_a_of_type_Int, ((atyv)this.jdField_a_of_type_Atyy).a.algBuffer, ContactReportUtils.a((List)localObject), 0, "3");
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
    return ((atyv)this.jdField_a_of_type_Atyy).a.algBuffer;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return ((atyv)this.jdField_a_of_type_Atyy).a.uin;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Akac != null) {
      this.jdField_a_of_type_Akac.a(((atyv)this.jdField_a_of_type_Atyy).a, 23, this.c, 1);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Akac != null) {
      this.jdField_a_of_type_Akac.b(((atyv)this.jdField_a_of_type_Atyy).a, 23, this.c, 1);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Aipp.b();
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131375333: 
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof afjs)));
        paramView = ((atyv)this.jdField_a_of_type_Atyy).a;
      } while (paramView == null);
      localObject = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject == null) || (!((ajxn)localObject).b(paramView.uin))) {
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
      if (this.jdField_a_of_type_Akac != null) {
        bool = this.jdField_a_of_type_Akac.a();
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
      this.jdField_a_of_type_Akbo.h();
      if ((j == 23) && (this.jdField_a_of_type_Akac != null)) {
        this.jdField_a_of_type_Akac.a(paramView, 23, this.c, 2);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_clk", j, 0, paramView.recommendReason, this.jdField_a_of_type_Int, paramView.algBuffer, str, 0, "3");
      return;
      paramView = paramView.getTag();
      if ((paramView == null) || (!(paramView instanceof MayKnowRecommend))) {
        break;
      }
      if (!bbev.g(this.jdField_a_of_type_AndroidContentContext))
      {
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692321), 0).b(c());
        return;
      }
      paramView = (MayKnowRecommend)paramView;
      localObject = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((!((ajxn)localObject).b(paramView.uin)) && (!((ajxn)localObject).d(paramView.uin)))
      {
        bool = false;
        if (this.jdField_a_of_type_Akac != null) {
          bool = this.jdField_a_of_type_Akac.a();
        }
        localObject = paramView.getDisplayName(bool);
        i = this.jdField_a_of_type_Aipp.b();
        localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, paramView.uin, null, 3045, i, (String)localObject, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689628), null);
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(i), "", "", "");
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 228);
      }
      for (;;)
      {
        this.jdField_a_of_type_Akbo.h();
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
        if (bbbd.b(String.valueOf(paramView.uin))) {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
        }
        if ((j == 23) && (this.jdField_a_of_type_Akac != null)) {
          this.jdField_a_of_type_Akac.a(paramView, 23, this.c, 3);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_add", j, 1, paramView.recommendReason, this.jdField_a_of_type_Int, paramView.algBuffer, ContactReportUtils.a(paramView.msgLabel), 0, "3");
        return;
        if (((ajxn)localObject).b(paramView.uin))
        {
          paramView.friendStatus = 2;
          this.jdField_a_of_type_Aipp.notifyDataSetChanged();
        }
        else
        {
          paramView.friendStatus = 1;
          this.jdField_a_of_type_Aipp.notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afjr
 * JD-Core Version:    0.7.0.1
 */