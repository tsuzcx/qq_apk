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

public class ahgu
  extends ahgy
  implements View.OnClickListener
{
  protected int a;
  private alro jdField_a_of_type_Alro;
  private altc jdField_a_of_type_Altc;
  private int c;
  
  public ahgu(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
    this.c = paramInt;
    this.jdField_a_of_type_Bhxa = a(paramContext);
    this.jdField_a_of_type_Alro = ((alro)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_Altc = ((altc)paramQQAppInterface.getManager(34));
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297295);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ahgv localahgv;
    MayKnowRecommend localMayKnowRecommend;
    label266:
    StringBuilder localStringBuilder;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahgv)))
    {
      localahgv = new ahgv();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561311, localahgv);
      localahgv.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localahgv.h = ((TextView)paramView.findViewById(2131371142));
      localahgv.k = ((TextView)paramView.findViewById(2131375675));
      localahgv.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375665));
      localahgv.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131378376));
      localahgv.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      localahgv.m = ((TextView)paramView.findViewById(2131370102));
      localahgv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377169));
      b(localahgv.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localahgv);
      localahgv.g.setTag(localahgv);
      localahgv.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Avqe, localahgv, this);
      localMayKnowRecommend = ((avqb)this.jdField_a_of_type_Avqe).a;
      if (this.jdField_a_of_type_Avqe.a()) {
        break label633;
      }
      a(localahgv.g, true);
      if (bdal.b(String.valueOf(localMayKnowRecommend.uin))) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Akgy.b() == 23) {
        b();
      }
      localStringBuilder = new StringBuilder(256);
      bool = false;
      if (this.jdField_a_of_type_Alro != null) {
        bool = this.jdField_a_of_type_Alro.a();
      }
      Object localObject = localMayKnowRecommend.getDisplayName(bool);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label645;
      }
      localahgv.h.setVisibility(0);
      localahgv.h.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append((String)localObject);
      }
      label360:
      if ((TextUtils.isEmpty(localMayKnowRecommend.uin)) || (!bdal.b(localMayKnowRecommend.uin))) {
        break label658;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841431);
      ((Drawable)localObject).setBounds(0, 0, aekt.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localahgv.h.setCompoundDrawables(null, null, (Drawable)localObject, null);
      label440:
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        break label673;
      }
      localahgv.m.setVisibility(8);
      label461:
      localahgv.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label712;
      }
      localahgv.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localahgv.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localahgv.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131689628));
      localahgv.jdField_a_of_type_AndroidWidgetButton.setTag(localMayKnowRecommend);
      localahgv.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",点击添加");
        localahgv.jdField_a_of_type_AndroidWidgetButton.setContentDescription(alpo.a(2131689628));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localahgv.jdField_f_of_type_JavaLangString = localMayKnowRecommend.uin;
      localahgv.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Akgy.a(1, localMayKnowRecommend.uin));
      a(localahgv.jdField_a_of_type_AndroidWidgetTextView, localMayKnowRecommend, bool);
      return paramView;
      localahgv = (ahgv)paramView.getTag();
      break;
      label633:
      a(localahgv.g, false);
      break label266;
      label645:
      localahgv.h.setVisibility(8);
      break label360;
      label658:
      localahgv.h.setCompoundDrawables(null, null, null, null);
      break label440;
      label673:
      localahgv.m.setText(localMayKnowRecommend.recommendReason);
      if (!AppSetting.c) {
        break label461;
      }
      localStringBuilder.append(",").append(localMayKnowRecommend.recommendReason);
      break label461;
      label712:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        localahgv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localahgv.k.setVisibility(0);
        localahgv.k.setText(2131719227);
        if (AppSetting.c)
        {
          localStringBuilder.append(",等待验证");
          localahgv.k.setContentDescription(alpo.a(2131706860));
        }
      }
      else
      {
        localahgv.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localahgv.k.setVisibility(0);
        localahgv.k.setText(2131690082);
        if (AppSetting.c)
        {
          localStringBuilder.append(",已添加");
          localahgv.k.setContentDescription(alpo.a(2131706862));
        }
      }
    }
  }
  
  public String a()
  {
    return ((avqb)this.jdField_a_of_type_Avqe).a.recommendReason;
  }
  
  protected void a()
  {
    if (!bdee.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692397), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    String str = ((avqb)this.jdField_a_of_type_Avqe).a.uin;
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f(str);
    this.jdField_a_of_type_Akgy.a(this);
    this.jdField_a_of_type_Akgy.a(200L);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
    Object localObject = ((avqb)this.jdField_a_of_type_Avqe).a;
    if (localObject != null) {}
    for (localObject = ((MayKnowRecommend)localObject).msgLabel;; localObject = null)
    {
      int i = this.jdField_a_of_type_Akgy.b();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "frd_list_dlt", i, 0, ((avqb)this.jdField_a_of_type_Avqe).a.recommendReason, this.jdField_a_of_type_Int, ((avqb)this.jdField_a_of_type_Avqe).a.algBuffer, ContactReportUtils.a((List)localObject), 0, "3");
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
    return ((avqb)this.jdField_a_of_type_Avqe).a.algBuffer;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return ((avqb)this.jdField_a_of_type_Avqe).a.uin;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Alro != null) {
      this.jdField_a_of_type_Alro.a(((avqb)this.jdField_a_of_type_Avqe).a, 23, this.c, 1);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Alro != null) {
      this.jdField_a_of_type_Alro.b(((avqb)this.jdField_a_of_type_Avqe).a, 23, this.c, 1);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Akgy.b();
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131375820: 
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof ahgv)));
        paramView = ((avqb)this.jdField_a_of_type_Avqe).a;
      } while (paramView == null);
      localObject = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject == null) || (!((aloz)localObject).b(paramView.uin))) {
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
      if (this.jdField_a_of_type_Alro != null) {
        bool = this.jdField_a_of_type_Alro.a();
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
      this.jdField_a_of_type_Altc.h();
      if ((j == 23) && (this.jdField_a_of_type_Alro != null)) {
        this.jdField_a_of_type_Alro.a(paramView, 23, this.c, 2);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_clk", j, 0, paramView.recommendReason, this.jdField_a_of_type_Int, paramView.algBuffer, str, 0, "3");
      return;
      paramView = paramView.getTag();
      if ((paramView == null) || (!(paramView instanceof MayKnowRecommend))) {
        break;
      }
      if (!bdee.g(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692397), 0).b(c());
        return;
      }
      paramView = (MayKnowRecommend)paramView;
      localObject = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((!((aloz)localObject).b(paramView.uin)) && (!((aloz)localObject).d(paramView.uin)))
      {
        bool = false;
        if (this.jdField_a_of_type_Alro != null) {
          bool = this.jdField_a_of_type_Alro.a();
        }
        localObject = paramView.getDisplayName(bool);
        i = this.jdField_a_of_type_Akgy.b();
        localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, paramView.uin, null, 3045, i, (String)localObject, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689628), null);
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(i), "", "", "");
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 228);
      }
      for (;;)
      {
        this.jdField_a_of_type_Altc.h();
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
        if (bdal.b(String.valueOf(paramView.uin))) {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
        }
        if ((j == 23) && (this.jdField_a_of_type_Alro != null)) {
          this.jdField_a_of_type_Alro.a(paramView, 23, this.c, 3);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uin, "frd_list_add", j, 1, paramView.recommendReason, this.jdField_a_of_type_Int, paramView.algBuffer, ContactReportUtils.a(paramView.msgLabel), 0, "3");
        return;
        if (((aloz)localObject).b(paramView.uin))
        {
          paramView.friendStatus = 2;
          this.jdField_a_of_type_Akgy.notifyDataSetChanged();
        }
        else
        {
          paramView.friendStatus = 1;
          this.jdField_a_of_type_Akgy.notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgu
 * JD-Core Version:    0.7.0.1
 */