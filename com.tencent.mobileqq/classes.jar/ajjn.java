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
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ajjn
  extends ajjr
  implements View.OnClickListener
{
  protected int a;
  private ajka jdField_a_of_type_Ajka;
  private aobl jdField_a_of_type_Aobl;
  private int c;
  
  public ajjn(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
    this.c = paramInt;
    this.jdField_a_of_type_Blpv = a(paramContext);
    this.jdField_a_of_type_Aobl = ((aobl)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_Ajka = ((ajka)paramQQAppInterface.getManager(34));
    this.b = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297370);
  }
  
  protected int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView)
  {
    ajjo localajjo;
    MayKnowRecommend localMayKnowRecommend;
    label266:
    StringBuilder localStringBuilder;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajjo)))
    {
      localajjo = new ajjo();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561603, localajjo);
      localajjo.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      localajjo.h = ((TextView)paramView.findViewById(2131371827));
      localajjo.k = ((TextView)paramView.findViewById(2131376585));
      localajjo.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376575));
      localajjo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout = ((TroopLabelLayout)paramView.findViewById(2131379447));
      localajjo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.setLabelType(1);
      localajjo.m = ((TextView)paramView.findViewById(2131370666));
      localajjo.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378189));
      b(localajjo.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localajjo);
      localajjo.g.setTag(localajjo);
      localajjo.g.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_Ajmf, localajjo, this);
      localMayKnowRecommend = ((ajmc)this.jdField_a_of_type_Ajmf).a;
      if (this.jdField_a_of_type_Ajmf.a()) {
        break label633;
      }
      a(localajjo.g, true);
      if (bhjx.b(String.valueOf(localMayKnowRecommend.uin))) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Ajln.b() == 23) {
        b();
      }
      localStringBuilder = new StringBuilder(256);
      bool = false;
      if (this.jdField_a_of_type_Aobl != null) {
        bool = this.jdField_a_of_type_Aobl.a();
      }
      Object localObject = localMayKnowRecommend.getDisplayName(bool);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label645;
      }
      localajjo.h.setVisibility(0);
      localajjo.h.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localStringBuilder.append((String)localObject);
      }
      label360:
      if ((TextUtils.isEmpty(localMayKnowRecommend.uin)) || (!bhjx.b(localMayKnowRecommend.uin))) {
        break label658;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841751);
      ((Drawable)localObject).setBounds(0, 0, agej.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), agej.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localajjo.h.setCompoundDrawables(null, null, (Drawable)localObject, null);
      label440:
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        break label673;
      }
      localajjo.m.setVisibility(8);
      label461:
      localajjo.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopLabelLayout.a(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label712;
      }
      localajjo.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      localajjo.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      localajjo.jdField_a_of_type_AndroidWidgetButton.setText(anzj.a(2131689551));
      localajjo.jdField_a_of_type_AndroidWidgetButton.setTag(localMayKnowRecommend);
      localajjo.k.setVisibility(8);
      if (AppSetting.c)
      {
        localStringBuilder.append(",点击添加");
        localajjo.jdField_a_of_type_AndroidWidgetButton.setContentDescription(anzj.a(2131689551));
      }
    }
    for (;;)
    {
      if (AppSetting.c) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      localajjo.jdField_f_of_type_JavaLangString = localMayKnowRecommend.uin;
      localajjo.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_Ajln.a(1, localMayKnowRecommend.uin));
      a(localajjo.jdField_a_of_type_AndroidWidgetTextView, localMayKnowRecommend, bool);
      return paramView;
      localajjo = (ajjo)paramView.getTag();
      break;
      label633:
      a(localajjo.g, false);
      break label266;
      label645:
      localajjo.h.setVisibility(8);
      break label360;
      label658:
      localajjo.h.setCompoundDrawables(null, null, null, null);
      break label440;
      label673:
      localajjo.m.setText(localMayKnowRecommend.recommendReason);
      if (!AppSetting.c) {
        break label461;
      }
      localStringBuilder.append(",").append(localMayKnowRecommend.recommendReason);
      break label461;
      label712:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        localajjo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localajjo.k.setVisibility(0);
        localajjo.k.setText(2131717458);
        if (AppSetting.c)
        {
          localStringBuilder.append(",等待验证");
          localajjo.k.setContentDescription(anzj.a(2131705370));
        }
      }
      else
      {
        localajjo.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        localajjo.k.setVisibility(0);
        localajjo.k.setText(2131689982);
        if (AppSetting.c)
        {
          localStringBuilder.append(",已添加");
          localajjo.k.setContentDescription(anzj.a(2131705372));
        }
      }
    }
  }
  
  public String a()
  {
    return ((ajmc)this.jdField_a_of_type_Ajmf).a.recommendReason;
  }
  
  protected void a()
  {
    if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691989), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    String str = ((ajmc)this.jdField_a_of_type_Ajmf).a.uin;
    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).f(str);
    this.jdField_a_of_type_Ajln.a(this);
    this.jdField_a_of_type_Ajln.a(200L);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
    Object localObject = ((ajmc)this.jdField_a_of_type_Ajmf).a;
    if (localObject != null) {}
    for (localObject = ((MayKnowRecommend)localObject).msgLabel;; localObject = null)
    {
      int i = this.jdField_a_of_type_Ajln.b();
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, "frd_list_dlt", i, 0, ((ajmc)this.jdField_a_of_type_Ajmf).a.recommendReason, this.jdField_a_of_type_Int, ((ajmc)this.jdField_a_of_type_Ajmf).a.algBuffer, ContactReportUtils.a((List)localObject), 0, "3");
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
    return ((ajmc)this.jdField_a_of_type_Ajmf).a.algBuffer;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return ((ajmc)this.jdField_a_of_type_Ajmf).a.uin;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aobl != null) {
      this.jdField_a_of_type_Aobl.a(((ajmc)this.jdField_a_of_type_Ajmf).a, 23, this.c, 1);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aobl != null) {
      this.jdField_a_of_type_Aobl.b(((ajmc)this.jdField_a_of_type_Ajmf).a, 23, this.c, 1);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Ajln.b();
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    case 2131376742: 
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject1 = paramView.getTag();
        } while ((localObject1 == null) || (!(localObject1 instanceof ajjo)));
        localObject1 = ((ajmc)this.jdField_a_of_type_Ajmf).a;
      } while (localObject1 == null);
      localObject2 = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject2 == null) || (!((anyw)localObject2).b(((MayKnowRecommend)localObject1).uin))) {
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
      if (this.jdField_a_of_type_Aobl != null) {
        bool = this.jdField_a_of_type_Aobl.a();
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
      this.jdField_a_of_type_Ajka.h();
      if ((j == 23) && (this.jdField_a_of_type_Aobl != null)) {
        this.jdField_a_of_type_Aobl.a((MayKnowRecommend)localObject1, 23, this.c, 2);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", j, 0, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_Int, ((MayKnowRecommend)localObject1).algBuffer, str, 0, "3");
      break;
      localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof MayKnowRecommend))) {
        break;
      }
      if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691989), 0).b(c());
        break;
      }
      localObject1 = (MayKnowRecommend)localObject1;
      localObject2 = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((!((anyw)localObject2).b(((MayKnowRecommend)localObject1).uin)) && (!((anyw)localObject2).d(((MayKnowRecommend)localObject1).uin)))
      {
        bool = false;
        if (this.jdField_a_of_type_Aobl != null) {
          bool = this.jdField_a_of_type_Aobl.a();
        }
        localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
        i = this.jdField_a_of_type_Ajln.b();
        localObject2 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, i, (String)localObject2, null, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689551), null);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(i), "", "", "");
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject2, 228);
      }
      for (;;)
      {
        this.jdField_a_of_type_Ajka.h();
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
        if (bhjx.b(String.valueOf(((MayKnowRecommend)localObject1).uin))) {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
        }
        if ((j == 23) && (this.jdField_a_of_type_Aobl != null)) {
          this.jdField_a_of_type_Aobl.a((MayKnowRecommend)localObject1, 23, this.c, 3);
        }
        ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MayKnowRecommend)localObject1).uin, "frd_list_add", j, 1, ((MayKnowRecommend)localObject1).recommendReason, this.jdField_a_of_type_Int, ((MayKnowRecommend)localObject1).algBuffer, ContactReportUtils.a(((MayKnowRecommend)localObject1).msgLabel), 0, "3");
        break;
        if (((anyw)localObject2).b(((MayKnowRecommend)localObject1).uin))
        {
          ((MayKnowRecommend)localObject1).friendStatus = 2;
          this.jdField_a_of_type_Ajln.notifyDataSetChanged();
        }
        else
        {
          ((MayKnowRecommend)localObject1).friendStatus = 1;
          this.jdField_a_of_type_Ajln.notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjn
 * JD-Core Version:    0.7.0.1
 */