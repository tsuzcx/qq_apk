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

public class ajgq
  extends ajff
{
  private List<String> a;
  
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    paramajgx = null;
    paramViewGroup = paramajgx;
    if (paramView != null)
    {
      paramViewGroup = paramajgx;
      if (paramView.getTag() != null)
      {
        paramViewGroup = paramajgx;
        if ((paramView.getTag() instanceof ajgr)) {
          paramViewGroup = (ajgr)paramView.getTag();
        }
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new ajgr();
      paramView = super.a(paramContext, 2131561227, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376074));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377553));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131379273));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131365043));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377822));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379973));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131367104));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131364011));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131380298));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131364121));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131364602));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376254));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_Ajee != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ajee.a());
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(13.0F, 1);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramajgx = null;
        if (paramajfa != null) {
          paramajgx = paramajfa.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramajgx);
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
  
  public void a(Context paramContext, ajgr paramajgr, RecentSayHelloListItem paramRecentSayHelloListItem)
  {
    int k = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    int j;
    if (paramRecentSayHelloListItem.age > 0)
    {
      paramajgr.c.setText(String.valueOf(paramRecentSayHelloListItem.age));
      localStringBuilder.append(paramRecentSayHelloListItem.mTitleName);
      switch (paramRecentSayHelloListItem.gender)
      {
      default: 
        i = 2130840262;
        paramajgr.c.setBackgroundDrawable(bclo.a(paramajgr.c.getResources(), Color.parseColor("#ff9cc4f7")));
        j = 0;
      }
    }
    for (;;)
    {
      label97:
      if ((AppSetting.c) && (paramRecentSayHelloListItem.age > 0)) {
        localStringBuilder.append(paramRecentSayHelloListItem.age).append("岁");
      }
      paramajgr.c.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      label153:
      label178:
      Object localObject;
      label205:
      label238:
      int m;
      if (j != 0)
      {
        paramajgr.c.setVisibility(0);
        i = 1;
        if ((paramRecentSayHelloListItem.career > 0) && (paramRecentSayHelloListItem.career < 14)) {
          break label874;
        }
        paramajgr.d.setVisibility(8);
        localObject = bcyw.a((byte)paramRecentSayHelloListItem.constellation);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label963;
        }
        paramajgr.e.setVisibility(8);
        if (paramRecentSayHelloListItem.vip <= 0) {
          break label1040;
        }
        paramajgr.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (paramRecentSayHelloListItem.vip != 1) {
          break label1027;
        }
        paramajgr.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841079);
        paramajgr.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131167035));
        i += 1;
        label261:
        if (!paramRecentSayHelloListItem.charmIcon) {
          break label1069;
        }
        if (paramajgr.f.getVisibility() != 0) {
          paramajgr.f.setVisibility(0);
        }
        paramajgr.f.setText("LV" + paramRecentSayHelloListItem.charmLevel);
        paramContext = paramajgr.f.getContext().getResources().getDrawable(2130845040);
        localObject = auqm.a(paramajgr.f.getContext());
        m = Color.parseColor("#FFCC59");
        j = m;
        if (localObject != null)
        {
          j = m;
          if (paramRecentSayHelloListItem.charmLevel < localObject.length) {
            j = localObject[paramRecentSayHelloListItem.charmLevel];
          }
        }
        paramajgr.f.setBackgroundDrawable(bclo.a(paramajgr.f.getContext().getResources(), j, paramContext));
        if (AppSetting.c) {
          localStringBuilder.append(",").append("拥有魅力勋章");
        }
        j = i + 1;
        label435:
        if ((paramRecentSayHelloListItem.commonId <= 0) || (TextUtils.isEmpty(paramRecentSayHelloListItem.common))) {
          break label1112;
        }
        m = j + 1;
        paramajgr.e.setVisibility(8);
        paramajgr.g.setVisibility(0);
        paramajgr.g.setText(paramRecentSayHelloListItem.common);
        paramajgr.g.setTag(Integer.valueOf(paramRecentSayHelloListItem.commonId));
        j = m;
        i = k;
        if (AppSetting.c)
        {
          localStringBuilder.append(",").append(paramRecentSayHelloListItem.common);
          i = k;
          j = m;
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          paramajgr.g.setVisibility(8);
          paramajgr.g.setTag(Integer.valueOf(0));
        }
        if (j > 0) {
          paramajgr.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        for (;;)
        {
          if (AppSetting.c)
          {
            if (paramRecentSayHelloListItem.mUnreadNum > 0) {
              localStringBuilder.append(",").append(paramRecentSayHelloListItem.mUnreadNum).append("条未读消息");
            }
            localStringBuilder.append(",").append(paramajgr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().toString());
            localStringBuilder.append(",").append(paramajgr.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
            if (localStringBuilder.length() > 0) {
              paramRecentSayHelloListItem.mContentDesc = localStringBuilder.toString();
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.recent", 2, "talkback|" + localStringBuilder.toString());
            }
          }
          return;
          paramajgr.c.setText("");
          break;
          j = 2130841075;
          paramajgr.c.setBackgroundDrawable(bclo.a(paramajgr.c.getResources(), Color.parseColor("#ff9cc4f7")));
          i = j;
          if (!AppSetting.c) {
            break label1118;
          }
          localStringBuilder.append(",").append("男");
          m = 1;
          i = j;
          j = m;
          break label97;
          j = 2130841073;
          paramajgr.c.setBackgroundDrawable(bclo.a(paramajgr.c.getResources(), Color.parseColor("#ffffb4c8")));
          i = j;
          if (!AppSetting.c) {
            break label1118;
          }
          localStringBuilder.append(",").append("女");
          m = 1;
          i = j;
          j = m;
          break label97;
          paramajgr.c.setVisibility(8);
          i = 0;
          break label153;
          label874:
          j = i + 1;
          paramajgr.d.setText(bcyr.e[paramRecentSayHelloListItem.career]);
          paramajgr.d.setBackgroundDrawable(bclo.a(paramajgr.d.getResources(), Color.parseColor("#ff81d4f3")));
          paramajgr.d.setVisibility(0);
          i = j;
          if (!AppSetting.c) {
            break label178;
          }
          localStringBuilder.append(",").append(bcyr.e[paramRecentSayHelloListItem.career]);
          i = j;
          break label178;
          label963:
          j = i + 1;
          paramajgr.e.setText((CharSequence)localObject);
          paramajgr.e.setBackgroundResource(2130845102);
          paramajgr.e.setVisibility(0);
          i = j;
          if (!AppSetting.c) {
            break label205;
          }
          localStringBuilder.append(",").append((String)localObject);
          i = j;
          break label205;
          label1027:
          paramajgr.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841080);
          break label238;
          label1040:
          paramajgr.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131166962));
          paramajgr.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label261;
          label1069:
          j = i;
          if (paramajgr.f.getVisibility() == 8) {
            break label435;
          }
          paramajgr.f.setVisibility(8);
          j = i;
          break label435;
          paramajgr.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
        }
        label1112:
        i = 0;
      }
      label1118:
      j = 1;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof ajgr)) {}
    for (ajgr localajgr = (ajgr)localObject;; localajgr = null) {
      for (;;)
      {
        if (localajgr == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
          return;
        }
        localajgr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        RecentSayHelloListItem localRecentSayHelloListItem;
        CharSequence localCharSequence;
        int i;
        if ((paramRecentBaseData instanceof RecentSayHelloListItem))
        {
          localRecentSayHelloListItem = (RecentSayHelloListItem)paramRecentBaseData;
          localObject = localRecentSayHelloListItem.mTitleName;
          localCharSequence = localajgr.jdField_b_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localajgr.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          i = paramRecentBaseData.mExtraInfoColor;
          paramDrawable = paramRecentBaseData.mMsgExtroInfo;
          if (paramDrawable == null) {
            break label489;
          }
          paramDrawable = paramDrawable.toString();
          if (!TextUtils.isEmpty(paramDrawable)) {
            localajgr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
          }
          localajgr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 1);
          localObject = localRecentSayHelloListItem.mLastMsg;
          localCharSequence = localajgr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (paramDrawable.equals(localCharSequence)) {}
        }
        try
        {
          localajgr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable);
          localajgr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
          if (paramRecentBaseData.mStatus == 4) {
            localajgr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramContext.getResources().getDrawable(2130839352), null);
          }
          localObject = localRecentSayHelloListItem.mShowTime;
          localCharSequence = localajgr.jdField_a_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localajgr.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          m = localRecentSayHelloListItem.mUnreadNum;
          i = localRecentSayHelloListItem.mUnreadFlag;
          if (m > 0) {
            if (i == 0)
            {
              localajgr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              k = 99;
              m = 0;
              j = 0;
              i = 0;
              bhro.a(localajgr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              if (localajgr.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                localajgr.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              a(paramContext, localajgr, localRecentSayHelloListItem);
              if (!AppSetting.c) {
                break;
              }
              paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("SayHelloListItemBuilder", 2, "data is not RecentSayHelloItem");
              }
              throw new RuntimeException("data is null");
              label489:
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
            localajgr.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable + " ");
            continue;
            if (i == 2)
            {
              localajgr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              m = 0;
              j = 0;
              i = 1;
              k = 99;
            }
            else if (i == 3)
            {
              j = 2130849736;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              localajgr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
              localajgr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167024));
              k = 99;
              i = 3;
            }
            else
            {
              j = 2130849732;
              localajgr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
              localajgr.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167025));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgq
 * JD-Core Version:    0.7.0.1
 */