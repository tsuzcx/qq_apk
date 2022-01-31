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

public class aeyb
  extends aeyf
  implements View.OnClickListener
{
  protected int a;
  private ajls jdField_a_of_type_Ajls;
  private ajnf jdField_a_of_type_Ajnf;
  private int c;
  
  public aeyb(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
    this.c = paramInt;
    this.jdField_a_of_type_Bens = a(paramContext);
    this.jdField_a_of_type_Ajls = ((ajls)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_Ajnf = ((ajnf)paramQQAppInterface.getManager(34));
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131166195);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    aeyc localaeyc;
    MayKnowRecommend localMayKnowRecommend;
    label266:
    StringBuilder localStringBuilder;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof aeyc)))
    {
      localaeyc = new aeyc();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131495537, localaeyc);
      localaeyc.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296259));
      localaeyc.h = ((TextView)paramView.findViewById(2131305159));
      localaeyc.k = ((TextView)paramView.findViewById(2131309443));
      localaeyc.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131309433));
      localaeyc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131312004));
      localaeyc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      localaeyc.m = ((TextView)paramView.findViewById(2131304161));
      localaeyc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131310850));
      b(localaeyc.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localaeyc);
      localaeyc.g.setTag(localaeyc);
      localaeyc.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Atcu, localaeyc, this);
      localMayKnowRecommend = ((atcr)this.jdField_a_of_type_Atcu).a;
      if (this.jdField_a_of_type_Atcu.a()) {
        break label633;
      }
      a(localaeyc.g, true);
      if (azzz.b(String.valueOf(localMayKnowRecommend.uin))) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Aicw.b() == 23) {
        b();
      }
      localStringBuilder = new StringBuilder(256);
      bool = false;
      if (this.jdField_a_of_type_Ajls != null) {
        bool = this.jdField_a_of_type_Ajls.a();
      }
      Object localObject = localMayKnowRecommend.getDisplayName(bool);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label645;
      }
      localaeyc.h.setVisibility(0);
      localaeyc.h.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append((String)localObject);
      }
      label360:
      if ((TextUtils.isEmpty(localMayKnowRecommend.uin)) || (!azzz.b(localMayKnowRecommend.uin))) {
        break label658;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841234);
      ((Drawable)localObject).setBounds(0, 0, aciy.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aciy.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localaeyc.h.setCompoundDrawables(null, null, (Drawable)localObject, null);
      label440:
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        break label673;
      }
      localaeyc.m.setVisibility(8);
      label461:
      localaeyc.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label712;
      }
      localaeyc.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localaeyc.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localaeyc.jdField_a_of_type_AndroidWidgetButton.setText(ajjy.a(2131624088));
      localaeyc.jdField_a_of_type_AndroidWidgetButton.setTag(localMayKnowRecommend);
      localaeyc.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",点击添加");
        localaeyc.jdField_a_of_type_AndroidWidgetButton.setContentDescription(ajjy.a(2131624088));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localaeyc.jdField_f_of_type_JavaLangString = localMayKnowRecommend.uin;
      localaeyc.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Aicw.a(1, localMayKnowRecommend.uin));
      a(localaeyc.jdField_a_of_type_AndroidWidgetTextView, localMayKnowRecommend, bool);
      return paramView;
      localaeyc = (aeyc)paramView.getTag();
      break;
      label633:
      a(localaeyc.g, false);
      break label266;
      label645:
      localaeyc.h.setVisibility(8);
      break label360;
      label658:
      localaeyc.h.setCompoundDrawables(null, null, null, null);
      break label440;
      label673:
      localaeyc.m.setText(localMayKnowRecommend.recommendReason);
      if (!AppSetting.c) {
        break label461;
      }
      localStringBuilder.append(",").append(localMayKnowRecommend.recommendReason);
      break label461;
      label712:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        localaeyc.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localaeyc.k.setVisibility(0);
        localaeyc.k.setText(2131652918);
        if (AppSetting.c)
        {
          localStringBuilder.append(",等待验证");
          localaeyc.k.setContentDescription(ajjy.a(2131640692));
        }
      }
      else
      {
        localaeyc.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localaeyc.k.setVisibility(0);
        localaeyc.k.setText(2131624481);
        if (AppSetting.c)
        {
          localStringBuilder.append(",已添加");
          localaeyc.k.setContentDescription(ajjy.a(2131640694));
        }
      }
    }
  }
  
  public String a()
  {
    return ((atcr)this.jdField_a_of_type_Atcu).a.recommendReason;
  }
  
  protected void a()
  {
    if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626719), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      return;
    }
    String str = ((atcr)this.jdField_a_of_type_Atcu).a.uin;
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f(str);
    this.jdField_a_of_type_Aicw.a(this);
    this.jdField_a_of_type_Aicw.a(200L);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
    Object localObject = ((atcr)this.jdField_a_of_type_Atcu).a;
    if (localObject != null) {}
    for (localObject = ((MayKnowRecommend)localObject).msgLabel;; localObject = null)
    {
      int i = this.jdField_a_of_type_Aicw.b();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "frd_list_dlt", i, 0, ((atcr)this.jdField_a_of_type_Atcu).a.recommendReason, this.jdField_a_of_type_Int, ((atcr)this.jdField_a_of_type_Atcu).a.algBuffer, ContactReportUtils.a((List)localObject), 0, "3");
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
    return ((atcr)this.jdField_a_of_type_Atcu).a.algBuffer;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return ((atcr)this.jdField_a_of_type_Atcu).a.uin;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ajls != null) {
      this.jdField_a_of_type_Ajls.a(((atcr)this.jdField_a_of_type_Atcu).a, 23, this.c, 1);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ajls != null) {
      this.jdField_a_of_type_Ajls.b(((atcr)this.jdField_a_of_type_Atcu).a, 23, this.c, 1);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Aicw.b();
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131309584: 
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof aeyc)));
        paramView = ((atcr)this.jdField_a_of_type_Atcu).a;
      } while (paramView == null);
      localObject = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject == null) || (!((ajjj)localObject).b(paramView.uin))) {
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
      if (this.jdField_a_of_type_Ajls != null) {
        bool = this.jdField_a_of_type_Ajls.a();
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
      this.jdField_a_of_type_Ajnf.h();
      if ((j == 23) && (this.jdField_a_of_type_Ajls != null)) {
        this.jdField_a_of_type_Ajls.a(paramView, 23, this.c, 2);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_clk", j, 0, paramView.recommendReason, this.jdField_a_of_type_Int, paramView.algBuffer, str, 0, "3");
      return;
      paramView = paramView.getTag();
      if ((paramView == null) || (!(paramView instanceof MayKnowRecommend))) {
        break;
      }
      if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626719), 0).b(c());
        return;
      }
      paramView = (MayKnowRecommend)paramView;
      localObject = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((!((ajjj)localObject).b(paramView.uin)) && (!((ajjj)localObject).d(paramView.uin)))
      {
        bool = false;
        if (this.jdField_a_of_type_Ajls != null) {
          bool = this.jdField_a_of_type_Ajls.a();
        }
        localObject = paramView.getDisplayName(bool);
        i = this.jdField_a_of_type_Aicw.b();
        localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, paramView.uin, null, 3045, i, (String)localObject, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131624088), null);
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(i), "", "", "");
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 228);
      }
      for (;;)
      {
        this.jdField_a_of_type_Ajnf.h();
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
        if (azzz.b(String.valueOf(paramView.uin))) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
        }
        if ((j == 23) && (this.jdField_a_of_type_Ajls != null)) {
          this.jdField_a_of_type_Ajls.a(paramView, 23, this.c, 3);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_add", j, 1, paramView.recommendReason, this.jdField_a_of_type_Int, paramView.algBuffer, ContactReportUtils.a(paramView.msgLabel), 0, "3");
        return;
        if (((ajjj)localObject).b(paramView.uin))
        {
          paramView.friendStatus = 2;
          this.jdField_a_of_type_Aicw.notifyDataSetChanged();
        }
        else
        {
          paramView.friendStatus = 1;
          this.jdField_a_of_type_Aicw.notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeyb
 * JD-Core Version:    0.7.0.1
 */