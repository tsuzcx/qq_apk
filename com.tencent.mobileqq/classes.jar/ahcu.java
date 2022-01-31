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

public class ahcu
  extends ahbj
{
  private List<String> a;
  
  public View a(int paramInt, Object paramObject, ahbe paramahbe, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahdb paramahdb)
  {
    paramahdb = null;
    paramViewGroup = paramahdb;
    if (paramView != null)
    {
      paramViewGroup = paramahdb;
      if (paramView.getTag() != null)
      {
        paramViewGroup = paramahdb;
        if ((paramView.getTag() instanceof ahcv)) {
          paramViewGroup = (ahcv)paramView.getTag();
        }
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new ahcv();
      paramView = super.a(paramContext, 2131495455, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131309823));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311221));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131312826));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131299391));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311479));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131313433));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131301372));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131298398));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131313715));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131298502));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131298969));
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131309994));
      paramView.setTag(paramViewGroup);
      if (this.jdField_a_of_type_Ahai != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ahai.a());
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(13.0F, 1);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramahdb = null;
        if (paramahbe != null) {
          paramahdb = paramahbe.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramahdb);
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
  
  public void a(Context paramContext, ahcv paramahcv, RecentSayHelloListItem paramRecentSayHelloListItem)
  {
    int k = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    int j;
    if (paramRecentSayHelloListItem.age > 0)
    {
      paramahcv.c.setText(String.valueOf(paramRecentSayHelloListItem.age));
      localStringBuilder.append(paramRecentSayHelloListItem.mTitleName);
      switch (paramRecentSayHelloListItem.gender)
      {
      default: 
        i = 2130840113;
        paramahcv.c.setBackgroundDrawable(azlj.a(paramahcv.c.getResources(), Color.parseColor("#ff9cc4f7")));
        j = 0;
      }
    }
    for (;;)
    {
      label97:
      if ((AppSetting.c) && (paramRecentSayHelloListItem.age > 0)) {
        localStringBuilder.append(paramRecentSayHelloListItem.age).append("岁");
      }
      paramahcv.c.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      label153:
      label178:
      Object localObject;
      label205:
      label238:
      int m;
      if (j != 0)
      {
        paramahcv.c.setVisibility(0);
        i = 1;
        if ((paramRecentSayHelloListItem.career > 0) && (paramRecentSayHelloListItem.career < 14)) {
          break label874;
        }
        paramahcv.d.setVisibility(8);
        localObject = azyk.a((byte)paramRecentSayHelloListItem.constellation);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label963;
        }
        paramahcv.e.setVisibility(8);
        if (paramRecentSayHelloListItem.vip <= 0) {
          break label1040;
        }
        paramahcv.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (paramRecentSayHelloListItem.vip != 1) {
          break label1027;
        }
        paramahcv.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840897);
        paramahcv.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131101389));
        i += 1;
        label261:
        if (!paramRecentSayHelloListItem.charmIcon) {
          break label1069;
        }
        if (paramahcv.f.getVisibility() != 0) {
          paramahcv.f.setVisibility(0);
        }
        paramahcv.f.setText("LV" + paramRecentSayHelloListItem.charmLevel);
        paramContext = paramahcv.f.getContext().getResources().getDrawable(2130844594);
        localObject = asdj.a(paramahcv.f.getContext());
        m = Color.parseColor("#FFCC59");
        j = m;
        if (localObject != null)
        {
          j = m;
          if (paramRecentSayHelloListItem.charmLevel < localObject.length) {
            j = localObject[paramRecentSayHelloListItem.charmLevel];
          }
        }
        paramahcv.f.setBackgroundDrawable(azlj.a(paramahcv.f.getContext().getResources(), j, paramContext));
        if (AppSetting.c) {
          localStringBuilder.append(",").append("拥有魅力勋章");
        }
        j = i + 1;
        label435:
        if ((paramRecentSayHelloListItem.commonId <= 0) || (TextUtils.isEmpty(paramRecentSayHelloListItem.common))) {
          break label1112;
        }
        m = j + 1;
        paramahcv.e.setVisibility(8);
        paramahcv.g.setVisibility(0);
        paramahcv.g.setText(paramRecentSayHelloListItem.common);
        paramahcv.g.setTag(Integer.valueOf(paramRecentSayHelloListItem.commonId));
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
          paramahcv.g.setVisibility(8);
          paramahcv.g.setTag(Integer.valueOf(0));
        }
        if (j > 0) {
          paramahcv.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        for (;;)
        {
          if (AppSetting.c)
          {
            if (paramRecentSayHelloListItem.mUnreadNum > 0) {
              localStringBuilder.append(",").append(paramRecentSayHelloListItem.mUnreadNum).append("条未读消息");
            }
            localStringBuilder.append(",").append(paramahcv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().toString());
            localStringBuilder.append(",").append(paramahcv.jdField_a_of_type_AndroidWidgetTextView.getText().toString());
            if (localStringBuilder.length() > 0) {
              paramRecentSayHelloListItem.mContentDesc = localStringBuilder.toString();
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.recent", 2, "talkback|" + localStringBuilder.toString());
            }
          }
          return;
          paramahcv.c.setText("");
          break;
          j = 2130840893;
          paramahcv.c.setBackgroundDrawable(azlj.a(paramahcv.c.getResources(), Color.parseColor("#ff9cc4f7")));
          i = j;
          if (!AppSetting.c) {
            break label1118;
          }
          localStringBuilder.append(",").append("男");
          m = 1;
          i = j;
          j = m;
          break label97;
          j = 2130840891;
          paramahcv.c.setBackgroundDrawable(azlj.a(paramahcv.c.getResources(), Color.parseColor("#ffffb4c8")));
          i = j;
          if (!AppSetting.c) {
            break label1118;
          }
          localStringBuilder.append(",").append("女");
          m = 1;
          i = j;
          j = m;
          break label97;
          paramahcv.c.setVisibility(8);
          i = 0;
          break label153;
          label874:
          j = i + 1;
          paramahcv.d.setText(azyf.e[paramRecentSayHelloListItem.career]);
          paramahcv.d.setBackgroundDrawable(azlj.a(paramahcv.d.getResources(), Color.parseColor("#ff81d4f3")));
          paramahcv.d.setVisibility(0);
          i = j;
          if (!AppSetting.c) {
            break label178;
          }
          localStringBuilder.append(",").append(azyf.e[paramRecentSayHelloListItem.career]);
          i = j;
          break label178;
          label963:
          j = i + 1;
          paramahcv.e.setText((CharSequence)localObject);
          paramahcv.e.setBackgroundResource(2130844656);
          paramahcv.e.setVisibility(0);
          i = j;
          if (!AppSetting.c) {
            break label205;
          }
          localStringBuilder.append(",").append((String)localObject);
          i = j;
          break label205;
          label1027:
          paramahcv.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840898);
          break label238;
          label1040:
          paramahcv.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramContext.getResources().getColorStateList(2131101320));
          paramahcv.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label261;
          label1069:
          j = i;
          if (paramahcv.f.getVisibility() == 8) {
            break label435;
          }
          paramahcv.f.setVisibility(8);
          j = i;
          break label435;
          paramahcv.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
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
    if ((localObject instanceof ahcv)) {}
    for (ahcv localahcv = (ahcv)localObject;; localahcv = null) {
      for (;;)
      {
        if (localahcv == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
          return;
        }
        localahcv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
        RecentSayHelloListItem localRecentSayHelloListItem;
        CharSequence localCharSequence;
        int i;
        if ((paramRecentBaseData instanceof RecentSayHelloListItem))
        {
          localRecentSayHelloListItem = (RecentSayHelloListItem)paramRecentBaseData;
          localObject = localRecentSayHelloListItem.mTitleName;
          localCharSequence = localahcv.jdField_b_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localahcv.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          i = paramRecentBaseData.mExtraInfoColor;
          paramDrawable = paramRecentBaseData.mMsgExtroInfo;
          if (paramDrawable == null) {
            break label489;
          }
          paramDrawable = paramDrawable.toString();
          if (!TextUtils.isEmpty(paramDrawable)) {
            localahcv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
          }
          localahcv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(paramDrawable, 1);
          localObject = localRecentSayHelloListItem.mLastMsg;
          localCharSequence = localahcv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (paramDrawable.equals(localCharSequence)) {}
        }
        try
        {
          localahcv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable);
          localahcv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(null, null);
          if (paramRecentBaseData.mStatus == 4) {
            localahcv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawables(paramContext.getResources().getDrawable(2130839239), null);
          }
          localObject = localRecentSayHelloListItem.mShowTime;
          localCharSequence = localahcv.jdField_a_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localahcv.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          m = localRecentSayHelloListItem.mUnreadNum;
          i = localRecentSayHelloListItem.mUnreadFlag;
          if (m > 0) {
            if (i == 0)
            {
              localahcv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              k = 99;
              m = 0;
              j = 0;
              i = 0;
              beih.a(localahcv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              if (localahcv.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                localahcv.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              a(paramContext, localahcv, localRecentSayHelloListItem);
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
            localahcv.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramDrawable + " ");
            continue;
            if (i == 2)
            {
              localahcv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1);
              m = 0;
              j = 0;
              i = 1;
              k = 99;
            }
            else if (i == 3)
            {
              j = 2130849061;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              localahcv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
              localahcv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131101378));
              k = 99;
              i = 3;
            }
            else
            {
              j = 2130849057;
              localahcv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
              localahcv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131101379));
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
 * Qualified Name:     ahcu
 * JD-Core Version:    0.7.0.1
 */