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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class alpf
  extends alnt
{
  private List<String> a;
  
  public View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv)
  {
    paramalpv = null;
    paramViewGroup = paramalpv;
    if (paramView != null)
    {
      paramViewGroup = paramalpv;
      if (paramView.getTag() != null)
      {
        paramViewGroup = paramalpv;
        if ((paramView.getTag() instanceof alpg)) {
          paramViewGroup = (alpg)paramView.getTag();
        }
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new alpg();
      paramView = super.a(paramContext, 2131561510, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131377027));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378604));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380442));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131365326));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378876));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381172));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131367467));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131364259));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131381550));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131364375));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131364869));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131377227));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_Alms != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Alms.a());
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(13.0F, 1);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramalpv = null;
        if (paramalno != null) {
          paramalpv = paramalno.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramalpv);
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
  
  public void a(Context paramContext, alpg paramalpg, RecentSayHelloListItem paramRecentSayHelloListItem)
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
      i = 2130840454;
      paramalpg.c.setBackgroundDrawable(bguq.a(paramalpg.c.getResources(), Color.parseColor("#ff9cc4f7")));
      j = 0;
      if (paramRecentSayHelloListItem.age > 0)
      {
        paramalpg.c.setText(String.valueOf(paramRecentSayHelloListItem.age));
        localStringBuilder.append(paramRecentSayHelloListItem.age).append("岁");
        paramalpg.c.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if (j == 0) {
          break label787;
        }
        paramalpg.c.setVisibility(0);
        i = 1;
        label141:
        if ((paramRecentSayHelloListItem.career > 0) && (paramRecentSayHelloListItem.career < 14)) {
          break label802;
        }
        paramalpg.d.setVisibility(8);
        label166:
        localObject = bhhz.a((byte)paramRecentSayHelloListItem.constellation);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label877;
        }
        paramalpg.e.setVisibility(8);
        label193:
        if (paramRecentSayHelloListItem.vip <= 0) {
          break label940;
        }
        paramalpg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (paramRecentSayHelloListItem.vip != 1) {
          break label927;
        }
        paramalpg.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841340);
        label226:
        paramalpg.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131167131));
        i += 1;
        label249:
        if (!paramRecentSayHelloListItem.charmIcon) {
          break label969;
        }
        if (paramalpg.f.getVisibility() != 0) {
          paramalpg.f.setVisibility(0);
        }
        paramalpg.f.setText("LV" + paramRecentSayHelloListItem.charmLevel);
        paramContext = paramalpg.f.getContext().getResources().getDrawable(2130845523);
        localObject = axuz.a(paramalpg.f.getContext());
        int m = Color.parseColor("#FFCC59");
        j = m;
        if (localObject != null)
        {
          j = m;
          if (paramRecentSayHelloListItem.charmLevel < localObject.length) {
            j = localObject[paramRecentSayHelloListItem.charmLevel];
          }
        }
        paramalpg.f.setBackgroundDrawable(bguq.a(paramalpg.f.getContext().getResources(), j, paramContext));
        localStringBuilder.append(",").append("拥有魅力勋章");
        j = i + 1;
        label417:
        if ((paramRecentSayHelloListItem.commonId <= 0) || (TextUtils.isEmpty(paramRecentSayHelloListItem.common))) {
          break label1012;
        }
        j += 1;
        paramalpg.e.setVisibility(8);
        paramalpg.g.setVisibility(0);
        paramalpg.g.setText(paramRecentSayHelloListItem.common);
        paramalpg.g.setTag(Integer.valueOf(paramRecentSayHelloListItem.commonId));
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
        paramalpg.g.setVisibility(8);
        paramalpg.g.setTag(Integer.valueOf(0));
      }
      if (j > 0) {
        paramalpg.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      for (;;)
      {
        if (AppSetting.c)
        {
          if (paramRecentSayHelloListItem.mUnreadNum > 0) {
            localStringBuilder.append(",").append(paramRecentSayHelloListItem.mUnreadNum).append("条未读消息");
          }
          localStringBuilder.append(",").append(paramalpg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().toString());
          localStringBuilder.append(",").append(paramalpg.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
          if (localStringBuilder.length() > 0) {
            paramRecentSayHelloListItem.mContentDesc = localStringBuilder.toString();
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "talkback|" + localStringBuilder.toString());
          }
        }
        return;
        i = 2130841336;
        paramalpg.c.setBackgroundDrawable(bguq.a(paramalpg.c.getResources(), Color.parseColor("#ff9cc4f7")));
        localStringBuilder.append(",").append("男");
        j = 1;
        break;
        i = 2130841334;
        paramalpg.c.setBackgroundDrawable(bguq.a(paramalpg.c.getResources(), Color.parseColor("#ffffb4c8")));
        localStringBuilder.append(",").append("女");
        j = 1;
        break;
        paramalpg.c.setText("");
        break label113;
        paramalpg.c.setVisibility(8);
        i = 0;
        break label141;
        i += 1;
        paramalpg.d.setText(bhhu.e[paramRecentSayHelloListItem.career]);
        paramalpg.d.setBackgroundDrawable(bguq.a(paramalpg.d.getResources(), Color.parseColor("#ff81d4f3")));
        paramalpg.d.setVisibility(0);
        localStringBuilder.append(",").append(bhhu.e[paramRecentSayHelloListItem.career]);
        break label166;
        i += 1;
        paramalpg.e.setText((CharSequence)localObject);
        paramalpg.e.setBackgroundResource(2130845585);
        paramalpg.e.setVisibility(0);
        localStringBuilder.append(",").append((String)localObject);
        break label193;
        paramalpg.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841341);
        break label226;
        paramalpg.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131167057));
        paramalpg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label249;
        j = i;
        if (paramalpg.f.getVisibility() == 8) {
          break label417;
        }
        paramalpg.f.setVisibility(8);
        j = i;
        break label417;
        paramalpg.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
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
    if ((localObject instanceof alpg)) {}
    for (alpg localalpg = (alpg)localObject;; localalpg = null) {
      for (;;)
      {
        if (localalpg == null)
        {
          QLog.i("Q.recent", 1, "bindView|holder is null, tag = " + localObject);
          return;
        }
        localalpg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        RecentSayHelloListItem localRecentSayHelloListItem;
        CharSequence localCharSequence;
        int i;
        if ((paramRecentBaseData instanceof RecentSayHelloListItem))
        {
          localRecentSayHelloListItem = (RecentSayHelloListItem)paramRecentBaseData;
          localObject = localRecentSayHelloListItem.mTitleName;
          localCharSequence = localalpg.jdField_b_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localalpg.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          i = paramRecentBaseData.mExtraInfoColor;
          paramDrawable = paramRecentBaseData.mMsgExtroInfo;
          if (paramDrawable == null) {
            break label471;
          }
          paramDrawable = paramDrawable.toString();
          if (!TextUtils.isEmpty(paramDrawable)) {
            localalpg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
          }
          localalpg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 1);
          localObject = localRecentSayHelloListItem.mLastMsg;
          localCharSequence = localalpg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (paramDrawable.equals(localCharSequence)) {}
        }
        try
        {
          localalpg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable);
          localalpg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
          if (paramRecentBaseData.mStatus == 4) {
            localalpg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramContext.getResources().getDrawable(2130839541), null);
          }
          localObject = localRecentSayHelloListItem.mShowTime;
          localCharSequence = localalpg.jdField_a_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localalpg.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          m = localRecentSayHelloListItem.mUnreadNum;
          i = localRecentSayHelloListItem.mUnreadFlag;
          if (m > 0) {
            if (i == 0)
            {
              localalpg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              k = 99;
              m = 0;
              j = 0;
              i = 0;
              blkk.a(localalpg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              if (localalpg.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                localalpg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              a(paramContext, localalpg, localRecentSayHelloListItem);
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
            localalpg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable + " ");
            continue;
            if (i == 2)
            {
              localalpg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              m = 0;
              j = 0;
              i = 1;
              k = 99;
            }
            else if (i == 3)
            {
              j = 2130850408;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              localalpg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
              localalpg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167120));
              k = 99;
              i = 3;
            }
            else
            {
              j = 2130850404;
              localalpg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
              localalpg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167121));
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
 * Qualified Name:     alpf
 * JD-Core Version:    0.7.0.1
 */