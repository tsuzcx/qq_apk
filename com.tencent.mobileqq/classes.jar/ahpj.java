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

public class ahpj
  extends ahny
{
  private List<String> a;
  
  public View a(int paramInt, Object paramObject, ahnt paramahnt, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpq paramahpq)
  {
    paramahpq = null;
    paramViewGroup = paramahpq;
    if (paramView != null)
    {
      paramViewGroup = paramahpq;
      if (paramView.getTag() != null)
      {
        paramViewGroup = paramahpq;
        if ((paramView.getTag() instanceof ahpk)) {
          paramViewGroup = (ahpk)paramView.getTag();
        }
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new ahpk();
      paramView = super.a(paramContext, 2131561042, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375582));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377031));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131378650));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131364957));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377292));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379267));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131366981));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131363954));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131379550));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131364060));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131364529));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131375757));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_Ahmx != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ahmx.a());
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(13.0F, 1);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramahpq = null;
        if (paramahnt != null) {
          paramahpq = paramahnt.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramahpq);
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
  
  public void a(Context paramContext, ahpk paramahpk, RecentSayHelloListItem paramRecentSayHelloListItem)
  {
    int k = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    int j;
    if (paramRecentSayHelloListItem.age > 0)
    {
      paramahpk.c.setText(String.valueOf(paramRecentSayHelloListItem.age));
      localStringBuilder.append(paramRecentSayHelloListItem.mTitleName);
      switch (paramRecentSayHelloListItem.gender)
      {
      default: 
        i = 2130840162;
        paramahpk.c.setBackgroundDrawable(bamn.a(paramahpk.c.getResources(), Color.parseColor("#ff9cc4f7")));
        j = 0;
      }
    }
    for (;;)
    {
      label97:
      if ((AppSetting.d) && (paramRecentSayHelloListItem.age > 0)) {
        localStringBuilder.append(paramRecentSayHelloListItem.age).append("岁");
      }
      paramahpk.c.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      label153:
      label178:
      Object localObject;
      label205:
      label238:
      int m;
      if (j != 0)
      {
        paramahpk.c.setVisibility(0);
        i = 1;
        if ((paramRecentSayHelloListItem.career > 0) && (paramRecentSayHelloListItem.career < 14)) {
          break label874;
        }
        paramahpk.d.setVisibility(8);
        localObject = bazo.a((byte)paramRecentSayHelloListItem.constellation);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label963;
        }
        paramahpk.e.setVisibility(8);
        if (paramRecentSayHelloListItem.vip <= 0) {
          break label1040;
        }
        paramahpk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (paramRecentSayHelloListItem.vip != 1) {
          break label1027;
        }
        paramahpk.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840964);
        paramahpk.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131166984));
        i += 1;
        label261:
        if (!paramRecentSayHelloListItem.charmIcon) {
          break label1069;
        }
        if (paramahpk.f.getVisibility() != 0) {
          paramahpk.f.setVisibility(0);
        }
        paramahpk.f.setText("LV" + paramRecentSayHelloListItem.charmLevel);
        paramContext = paramahpk.f.getContext().getResources().getDrawable(2130844675);
        localObject = aszn.a(paramahpk.f.getContext());
        m = Color.parseColor("#FFCC59");
        j = m;
        if (localObject != null)
        {
          j = m;
          if (paramRecentSayHelloListItem.charmLevel < localObject.length) {
            j = localObject[paramRecentSayHelloListItem.charmLevel];
          }
        }
        paramahpk.f.setBackgroundDrawable(bamn.a(paramahpk.f.getContext().getResources(), j, paramContext));
        if (AppSetting.d) {
          localStringBuilder.append(",").append("拥有魅力勋章");
        }
        j = i + 1;
        label435:
        if ((paramRecentSayHelloListItem.commonId <= 0) || (TextUtils.isEmpty(paramRecentSayHelloListItem.common))) {
          break label1112;
        }
        m = j + 1;
        paramahpk.e.setVisibility(8);
        paramahpk.g.setVisibility(0);
        paramahpk.g.setText(paramRecentSayHelloListItem.common);
        paramahpk.g.setTag(Integer.valueOf(paramRecentSayHelloListItem.commonId));
        j = m;
        i = k;
        if (AppSetting.d)
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
          paramahpk.g.setVisibility(8);
          paramahpk.g.setTag(Integer.valueOf(0));
        }
        if (j > 0) {
          paramahpk.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        for (;;)
        {
          if (AppSetting.d)
          {
            if (paramRecentSayHelloListItem.mUnreadNum > 0) {
              localStringBuilder.append(",").append(paramRecentSayHelloListItem.mUnreadNum).append("条未读消息");
            }
            localStringBuilder.append(",").append(paramahpk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().toString());
            localStringBuilder.append(",").append(paramahpk.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
            if (localStringBuilder.length() > 0) {
              paramRecentSayHelloListItem.mContentDesc = localStringBuilder.toString();
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.recent", 2, "talkback|" + localStringBuilder.toString());
            }
          }
          return;
          paramahpk.c.setText("");
          break;
          j = 2130840960;
          paramahpk.c.setBackgroundDrawable(bamn.a(paramahpk.c.getResources(), Color.parseColor("#ff9cc4f7")));
          i = j;
          if (!AppSetting.d) {
            break label1118;
          }
          localStringBuilder.append(",").append("男");
          m = 1;
          i = j;
          j = m;
          break label97;
          j = 2130840958;
          paramahpk.c.setBackgroundDrawable(bamn.a(paramahpk.c.getResources(), Color.parseColor("#ffffb4c8")));
          i = j;
          if (!AppSetting.d) {
            break label1118;
          }
          localStringBuilder.append(",").append("女");
          m = 1;
          i = j;
          j = m;
          break label97;
          paramahpk.c.setVisibility(8);
          i = 0;
          break label153;
          label874:
          j = i + 1;
          paramahpk.d.setText(bazj.e[paramRecentSayHelloListItem.career]);
          paramahpk.d.setBackgroundDrawable(bamn.a(paramahpk.d.getResources(), Color.parseColor("#ff81d4f3")));
          paramahpk.d.setVisibility(0);
          i = j;
          if (!AppSetting.d) {
            break label178;
          }
          localStringBuilder.append(",").append(bazj.e[paramRecentSayHelloListItem.career]);
          i = j;
          break label178;
          label963:
          j = i + 1;
          paramahpk.e.setText((CharSequence)localObject);
          paramahpk.e.setBackgroundResource(2130844737);
          paramahpk.e.setVisibility(0);
          i = j;
          if (!AppSetting.d) {
            break label205;
          }
          localStringBuilder.append(",").append((String)localObject);
          i = j;
          break label205;
          label1027:
          paramahpk.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840965);
          break label238;
          label1040:
          paramahpk.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131166915));
          paramahpk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label261;
          label1069:
          j = i;
          if (paramahpk.f.getVisibility() == 8) {
            break label435;
          }
          paramahpk.f.setVisibility(8);
          j = i;
          break label435;
          paramahpk.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
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
    if ((localObject instanceof ahpk)) {}
    for (ahpk localahpk = (ahpk)localObject;; localahpk = null) {
      for (;;)
      {
        if (localahpk == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
          return;
        }
        localahpk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        RecentSayHelloListItem localRecentSayHelloListItem;
        CharSequence localCharSequence;
        int i;
        if ((paramRecentBaseData instanceof RecentSayHelloListItem))
        {
          localRecentSayHelloListItem = (RecentSayHelloListItem)paramRecentBaseData;
          localObject = localRecentSayHelloListItem.mTitleName;
          localCharSequence = localahpk.jdField_b_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localahpk.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          i = paramRecentBaseData.mExtraInfoColor;
          paramDrawable = paramRecentBaseData.mMsgExtroInfo;
          if (paramDrawable == null) {
            break label489;
          }
          paramDrawable = paramDrawable.toString();
          if (!TextUtils.isEmpty(paramDrawable)) {
            localahpk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
          }
          localahpk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 1);
          localObject = localRecentSayHelloListItem.mLastMsg;
          localCharSequence = localahpk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (paramDrawable.equals(localCharSequence)) {}
        }
        try
        {
          localahpk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable);
          localahpk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
          if (paramRecentBaseData.mStatus == 4) {
            localahpk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramContext.getResources().getDrawable(2130839263), null);
          }
          localObject = localRecentSayHelloListItem.mShowTime;
          localCharSequence = localahpk.jdField_a_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localahpk.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          m = localRecentSayHelloListItem.mUnreadNum;
          i = localRecentSayHelloListItem.mUnreadFlag;
          if (m > 0) {
            if (i == 0)
            {
              localahpk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              k = 99;
              m = 0;
              j = 0;
              i = 0;
              bfqb.a(localahpk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              if (localahpk.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                localahpk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              a(paramContext, localahpk, localRecentSayHelloListItem);
              if (!AppSetting.d) {
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
            localahpk.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable + " ");
            continue;
            if (i == 2)
            {
              localahpk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              m = 0;
              j = 0;
              i = 1;
              k = 99;
            }
            else if (i == 3)
            {
              j = 2130849296;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              localahpk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
              localahpk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131166973));
              k = 99;
              i = 3;
            }
            else
            {
              j = 2130849292;
              localahpk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
              localahpk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131166974));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahpj
 * JD-Core Version:    0.7.0.1
 */