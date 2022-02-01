import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class alio
  extends alhd
{
  private List<String> a;
  
  public View a(int paramInt, Object paramObject, algy paramalgy, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alje paramalje)
  {
    paramalje = null;
    paramViewGroup = paramalje;
    if (paramView != null)
    {
      paramViewGroup = paramalje;
      if (paramView.getTag() != null)
      {
        paramViewGroup = paramalje;
        if ((paramView.getTag() instanceof alip)) {
          paramViewGroup = (alip)paramView.getTag();
        }
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new alip();
      paramView = super.a(paramContext, 2131561456, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377046));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378659));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380501));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131365449));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378941));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381243));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131367627));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131364356));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131381630));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131364474));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131364984));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377249));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_Algc != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Algc.a());
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(13.0F, 1);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramalje = null;
        if (paramalgy != null) {
          paramalje = paramalgy.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramalje);
      }
      for (;;)
      {
        super.a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        if (paramViewGroup != null)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
        }
      }
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    paramRecentBaseData = paramContext.getResources();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(Context paramContext, alip paramalip, RecentSayHelloListItem paramRecentSayHelloListItem)
  {
    int k = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRecentSayHelloListItem.mTitleName);
    int j;
    label113:
    Object localObject;
    switch (paramRecentSayHelloListItem.gender)
    {
    default: 
      i = 2130840533;
      paramalip.c.setBackgroundDrawable(TroopUtils.getTroopLevelBgDrawable(paramalip.c.getResources(), Color.parseColor("#ff9cc4f7")));
      j = 0;
      if (paramRecentSayHelloListItem.age > 0)
      {
        paramalip.c.setText(String.valueOf(paramRecentSayHelloListItem.age));
        localStringBuilder.append(paramRecentSayHelloListItem.age).append("岁");
        paramalip.c.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if (j == 0) {
          break label787;
        }
        paramalip.c.setVisibility(0);
        i = 1;
        label141:
        if ((paramRecentSayHelloListItem.career > 0) && (paramRecentSayHelloListItem.career < 14)) {
          break label802;
        }
        paramalip.d.setVisibility(8);
        label166:
        localObject = bhaa.a((byte)paramRecentSayHelloListItem.constellation);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label877;
        }
        paramalip.e.setVisibility(8);
        label193:
        if (paramRecentSayHelloListItem.vip <= 0) {
          break label940;
        }
        paramalip.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (paramRecentSayHelloListItem.vip != 1) {
          break label927;
        }
        paramalip.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841382);
        label226:
        paramalip.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131167168));
        i += 1;
        label249:
        if (!paramRecentSayHelloListItem.charmIcon) {
          break label969;
        }
        if (paramalip.f.getVisibility() != 0) {
          paramalip.f.setVisibility(0);
        }
        paramalip.f.setText("LV" + paramRecentSayHelloListItem.charmLevel);
        paramContext = paramalip.f.getContext().getResources().getDrawable(2130845487);
        localObject = axoi.a(paramalip.f.getContext());
        int m = Color.parseColor("#FFCC59");
        j = m;
        if (localObject != null)
        {
          j = m;
          if (paramRecentSayHelloListItem.charmLevel < localObject.length) {
            j = localObject[paramRecentSayHelloListItem.charmLevel];
          }
        }
        paramalip.f.setBackgroundDrawable(TroopUtils.getTroopLevelBgDrawable(paramalip.f.getContext().getResources(), j, paramContext));
        localStringBuilder.append(",").append("拥有魅力勋章");
        j = i + 1;
        label417:
        if ((paramRecentSayHelloListItem.commonId <= 0) || (TextUtils.isEmpty(paramRecentSayHelloListItem.common))) {
          break label1012;
        }
        j += 1;
        paramalip.e.setVisibility(8);
        paramalip.g.setVisibility(0);
        paramalip.g.setText(paramRecentSayHelloListItem.common);
        paramalip.g.setTag(Integer.valueOf(paramRecentSayHelloListItem.commonId));
        localStringBuilder.append(",").append(paramRecentSayHelloListItem.common);
      }
      break;
    }
    label787:
    label802:
    label877:
    label1012:
    for (int i = k;; i = 0)
    {
      if (i == 0)
      {
        paramalip.g.setVisibility(8);
        paramalip.g.setTag(Integer.valueOf(0));
      }
      if (j > 0) {
        paramalip.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      for (;;)
      {
        if (AppSetting.c)
        {
          if (paramRecentSayHelloListItem.mUnreadNum > 0) {
            localStringBuilder.append(",").append(paramRecentSayHelloListItem.mUnreadNum).append("条未读消息");
          }
          localStringBuilder.append(",").append(paramalip.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText().toString());
          localStringBuilder.append(",").append(paramalip.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
          if (localStringBuilder.length() > 0) {
            paramRecentSayHelloListItem.mContentDesc = localStringBuilder.toString();
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "talkback|" + localStringBuilder.toString());
          }
        }
        return;
        i = 2130841378;
        paramalip.c.setBackgroundDrawable(TroopUtils.getTroopLevelBgDrawable(paramalip.c.getResources(), Color.parseColor("#ff9cc4f7")));
        localStringBuilder.append(",").append("男");
        j = 1;
        break;
        i = 2130841376;
        paramalip.c.setBackgroundDrawable(TroopUtils.getTroopLevelBgDrawable(paramalip.c.getResources(), Color.parseColor("#ffffb4c8")));
        localStringBuilder.append(",").append("女");
        j = 1;
        break;
        paramalip.c.setText("");
        break label113;
        paramalip.c.setVisibility(8);
        i = 0;
        break label141;
        i += 1;
        paramalip.d.setText(bgzv.e[paramRecentSayHelloListItem.career]);
        paramalip.d.setBackgroundDrawable(TroopUtils.getTroopLevelBgDrawable(paramalip.d.getResources(), Color.parseColor("#ff81d4f3")));
        paramalip.d.setVisibility(0);
        localStringBuilder.append(",").append(bgzv.e[paramRecentSayHelloListItem.career]);
        break label166;
        i += 1;
        paramalip.e.setText((CharSequence)localObject);
        paramalip.e.setBackgroundResource(2130845549);
        paramalip.e.setVisibility(0);
        localStringBuilder.append(",").append((String)localObject);
        break label193;
        paramalip.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841383);
        break label226;
        paramalip.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131167093));
        paramalip.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label249;
        j = i;
        if (paramalip.f.getVisibility() == 8) {
          break label417;
        }
        paramalip.f.setVisibility(8);
        j = i;
        break label417;
        paramalip.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      QLog.i("Q.recent", 1, "bindView|param invalidate");
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof alip)) {}
    for (alip localalip = (alip)localObject;; localalip = null) {
      for (;;)
      {
        if (localalip == null)
        {
          QLog.i("Q.recent", 1, "bindView|holder is null, tag = " + localObject);
          return;
        }
        localalip.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        RecentSayHelloListItem localRecentSayHelloListItem;
        CharSequence localCharSequence;
        int i;
        if ((paramRecentBaseData instanceof RecentSayHelloListItem))
        {
          localRecentSayHelloListItem = (RecentSayHelloListItem)paramRecentBaseData;
          localObject = localRecentSayHelloListItem.mTitleName;
          localCharSequence = localalip.jdField_b_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localalip.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          i = paramRecentBaseData.mExtraInfoColor;
          paramDrawable = paramRecentBaseData.mMsgExtroInfo;
          if (paramDrawable == null) {
            break label471;
          }
          paramDrawable = paramDrawable.toString();
          if (!TextUtils.isEmpty(paramDrawable)) {
            localalip.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
          }
          localalip.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 1);
          localObject = localRecentSayHelloListItem.mLastMsg;
          localCharSequence = localalip.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (paramDrawable.equals(localCharSequence)) {}
        }
        try
        {
          localalip.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable);
          localalip.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
          if (paramRecentBaseData.mStatus == 4) {
            localalip.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramContext.getResources().getDrawable(2130839597), null);
          }
          localObject = localRecentSayHelloListItem.mShowTime;
          localCharSequence = localalip.jdField_a_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localalip.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          m = localRecentSayHelloListItem.mUnreadNum;
          i = localRecentSayHelloListItem.mUnreadFlag;
          if (m > 0) {
            if (i == 0)
            {
              localalip.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              k = 99;
              m = 0;
              j = 0;
              i = 0;
              blas.a(localalip.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              if (localalip.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                localalip.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              a(paramContext, localalip, localRecentSayHelloListItem);
              if (!AppSetting.c) {
                break;
              }
              paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              return;
              QLog.d("SayHelloListItemBuilder", 1, "data is not RecentSayHelloItem");
              throw new RuntimeException("data is null");
              label471:
              paramDrawable = "";
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int m;
            int k;
            int j;
            localException.printStackTrace();
            localalip.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable + " ");
            continue;
            if (i == 2)
            {
              localalip.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              m = 0;
              j = 0;
              i = 1;
              k = 99;
            }
            else if (i == 3)
            {
              j = 2130850435;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              localalip.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
              localalip.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167156));
              k = 99;
              i = 3;
            }
            else
            {
              j = 2130850431;
              localalip.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
              localalip.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167157));
              k = 99;
              i = 3;
              continue;
              k = 99;
              m = 0;
              j = 0;
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alio
 * JD-Core Version:    0.7.0.1
 */