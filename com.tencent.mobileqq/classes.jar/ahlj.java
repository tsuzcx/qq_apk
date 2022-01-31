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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ahlj
  extends ahln
  implements View.OnClickListener
{
  protected int a;
  private alwd jdField_a_of_type_Alwd;
  private alxr jdField_a_of_type_Alxr;
  private int c;
  
  public ahlj(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
    this.c = paramInt;
    this.jdField_a_of_type_Bibh = a(paramContext);
    this.jdField_a_of_type_Alwd = ((alwd)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_Alxr = ((alxr)paramQQAppInterface.getManager(34));
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297295);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ahlk localahlk;
    MayKnowRecommend localMayKnowRecommend;
    label266:
    StringBuilder localStringBuilder;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahlk)))
    {
      localahlk = new ahlk();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561329, localahlk);
      localahlk.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localahlk.h = ((TextView)paramView.findViewById(2131371161));
      localahlk.k = ((TextView)paramView.findViewById(2131375726));
      localahlk.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375716));
      localahlk.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131378430));
      localahlk.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      localahlk.m = ((TextView)paramView.findViewById(2131370121));
      localahlk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377223));
      b(localahlk.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localahlk);
      localahlk.g.setTag(localahlk);
      localahlk.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Avun, localahlk, this);
      localMayKnowRecommend = ((avuk)this.jdField_a_of_type_Avun).a;
      if (this.jdField_a_of_type_Avun.a()) {
        break label633;
      }
      a(localahlk.g, true);
      if (bdeu.b(String.valueOf(localMayKnowRecommend.uin))) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Akln.b() == 23) {
        b();
      }
      localStringBuilder = new StringBuilder(256);
      bool = false;
      if (this.jdField_a_of_type_Alwd != null) {
        bool = this.jdField_a_of_type_Alwd.a();
      }
      Object localObject = localMayKnowRecommend.getDisplayName(bool);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label645;
      }
      localahlk.h.setVisibility(0);
      localahlk.h.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append((String)localObject);
      }
      label360:
      if ((TextUtils.isEmpty(localMayKnowRecommend.uin)) || (!bdeu.b(localMayKnowRecommend.uin))) {
        break label658;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841432);
      ((Drawable)localObject).setBounds(0, 0, aepi.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aepi.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localahlk.h.setCompoundDrawables(null, null, (Drawable)localObject, null);
      label440:
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        break label673;
      }
      localahlk.m.setVisibility(8);
      label461:
      localahlk.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label712;
      }
      localahlk.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localahlk.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localahlk.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131689628));
      localahlk.jdField_a_of_type_AndroidWidgetButton.setTag(localMayKnowRecommend);
      localahlk.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",点击添加");
        localahlk.jdField_a_of_type_AndroidWidgetButton.setContentDescription(alud.a(2131689628));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localahlk.jdField_f_of_type_JavaLangString = localMayKnowRecommend.uin;
      localahlk.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akln.a(1, localMayKnowRecommend.uin));
      a(localahlk.jdField_a_of_type_AndroidWidgetTextView, localMayKnowRecommend, bool);
      return paramView;
      localahlk = (ahlk)paramView.getTag();
      break;
      label633:
      a(localahlk.g, false);
      break label266;
      label645:
      localahlk.h.setVisibility(8);
      break label360;
      label658:
      localahlk.h.setCompoundDrawables(null, null, null, null);
      break label440;
      label673:
      localahlk.m.setText(localMayKnowRecommend.recommendReason);
      if (!AppSetting.c) {
        break label461;
      }
      localStringBuilder.append(",").append(localMayKnowRecommend.recommendReason);
      break label461;
      label712:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        localahlk.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localahlk.k.setVisibility(0);
        localahlk.k.setText(2131719239);
        if (AppSetting.c)
        {
          localStringBuilder.append(",等待验证");
          localahlk.k.setContentDescription(alud.a(2131706872));
        }
      }
      else
      {
        localahlk.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localahlk.k.setVisibility(0);
        localahlk.k.setText(2131690082);
        if (AppSetting.c)
        {
          localStringBuilder.append(",已添加");
          localahlk.k.setContentDescription(alud.a(2131706874));
        }
      }
    }
  }
  
  public String a()
  {
    return ((avuk)this.jdField_a_of_type_Avun).a.recommendReason;
  }
  
  protected void a()
  {
    if (!bdin.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692398), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    String str = ((avuk)this.jdField_a_of_type_Avun).a.uin;
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f(str);
    this.jdField_a_of_type_Akln.a(this);
    this.jdField_a_of_type_Akln.a(200L);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
    Object localObject = ((avuk)this.jdField_a_of_type_Avun).a;
    if (localObject != null) {}
    for (localObject = ((MayKnowRecommend)localObject).msgLabel;; localObject = null)
    {
      int i = this.jdField_a_of_type_Akln.b();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "frd_list_dlt", i, 0, ((avuk)this.jdField_a_of_type_Avun).a.recommendReason, this.jdField_a_of_type_Int, ((avuk)this.jdField_a_of_type_Avun).a.algBuffer, ContactReportUtils.a((List)localObject), 0, "3");
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
    return ((avuk)this.jdField_a_of_type_Avun).a.algBuffer;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return ((avuk)this.jdField_a_of_type_Avun).a.uin;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Alwd != null) {
      this.jdField_a_of_type_Alwd.a(((avuk)this.jdField_a_of_type_Avun).a, 23, this.c, 1);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Alwd != null) {
      this.jdField_a_of_type_Alwd.b(((avuk)this.jdField_a_of_type_Avun).a, 23, this.c, 1);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Akln.b();
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131375872: 
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof ahlk)));
        paramView = ((avuk)this.jdField_a_of_type_Avun).a;
      } while (paramView == null);
      localObject = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject == null) || (!((alto)localObject).b(paramView.uin))) {
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
      if (this.jdField_a_of_type_Alwd != null) {
        bool = this.jdField_a_of_type_Alwd.a();
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
      this.jdField_a_of_type_Alxr.h();
      if ((j == 23) && (this.jdField_a_of_type_Alwd != null)) {
        this.jdField_a_of_type_Alwd.a(paramView, 23, this.c, 2);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_clk", j, 0, paramView.recommendReason, this.jdField_a_of_type_Int, paramView.algBuffer, str, 0, "3");
      return;
      paramView = paramView.getTag();
      if ((paramView == null) || (!(paramView instanceof MayKnowRecommend))) {
        break;
      }
      if (!bdin.g(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692398), 0).b(c());
        return;
      }
      paramView = (MayKnowRecommend)paramView;
      localObject = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((!((alto)localObject).b(paramView.uin)) && (!((alto)localObject).d(paramView.uin)))
      {
        bool = false;
        if (this.jdField_a_of_type_Alwd != null) {
          bool = this.jdField_a_of_type_Alwd.a();
        }
        localObject = paramView.getDisplayName(bool);
        i = this.jdField_a_of_type_Akln.b();
        localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, paramView.uin, null, 3045, i, (String)localObject, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689628), null);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(i), "", "", "");
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 228);
      }
      for (;;)
      {
        this.jdField_a_of_type_Alxr.h();
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
        if (bdeu.b(String.valueOf(paramView.uin))) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
        }
        if ((j == 23) && (this.jdField_a_of_type_Alwd != null)) {
          this.jdField_a_of_type_Alwd.a(paramView, 23, this.c, 3);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_add", j, 1, paramView.recommendReason, this.jdField_a_of_type_Int, paramView.algBuffer, ContactReportUtils.a(paramView.msgLabel), 0, "3");
        return;
        if (((alto)localObject).b(paramView.uin))
        {
          paramView.friendStatus = 2;
          this.jdField_a_of_type_Akln.notifyDataSetChanged();
        }
        else
        {
          paramView.friendStatus = 1;
          this.jdField_a_of_type_Akln.notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlj
 * JD-Core Version:    0.7.0.1
 */