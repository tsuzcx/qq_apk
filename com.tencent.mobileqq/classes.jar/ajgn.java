import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class ajgn
  extends ajff
{
  protected ajfa a;
  private List<String> a;
  
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    this.jdField_a_of_type_Ajfa = paramajfa;
    paramViewGroup = null;
    paramajfa = paramViewGroup;
    if (paramView != null)
    {
      paramajfa = paramViewGroup;
      if (paramView.getTag() != null)
      {
        paramajfa = paramViewGroup;
        if ((paramView.getTag() instanceof ajgp)) {
          paramajfa = (ajgp)paramView.getTag();
        }
      }
    }
    if (paramajfa == null)
    {
      paramViewGroup = new ajgp();
      paramajgx = super.a(paramContext, 2131561045, paramViewGroup);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramajgx.findViewById(2131367831));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramajgx.findViewById(2131377979));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramajgx.findViewById(2131379271));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramajgx.findViewById(2131370808));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)paramajgx.findViewById(2131370779));
      paramajfa = paramContext.getResources();
      paramView = paramajfa.getDisplayMetrics();
      int m = (int)(Math.min(paramView.widthPixels, paramView.heightPixels) - paramView.density * 119.0F);
      int i = paramajfa.getDimensionPixelSize(2131298691);
      int k = paramajfa.getDimensionPixelSize(2131298690);
      if (i <= 0)
      {
        i = 45;
        int j = k;
        if (k <= 0) {
          j = 10;
        }
        m /= (i + j);
        k = m;
        if (m > 6) {
          k = 6;
        }
        paramajfa = new ajgo(this, paramContext, k, i);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setColumnWidth(i);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setNumColumns(k);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setHorizontalSpacing(j);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setStretchMode(0);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.a();
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(paramajfa);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(14.0F, 1);
        paramajgx.setTag(paramViewGroup);
        paramView = paramajgx;
        paramajfa = paramViewGroup;
        if (this.jdField_a_of_type_Ajee != null)
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ajee.a());
          paramajfa = paramViewGroup;
          paramView = paramajgx;
        }
      }
    }
    for (;;)
    {
      paramajfa.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      paramViewGroup = paramContext.getResources().getDrawable(2130845079);
      if ((paramajfa != null) && ((paramObject instanceof RecentBaseData))) {
        a(paramView, (RecentBaseData)paramObject, paramContext, paramViewGroup);
      }
      for (;;)
      {
        super.a(paramContext, paramView, paramInt, paramObject, paramajfa, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.c) {
          paramView.setContentDescription(null);
        }
        return paramView;
        if (paramajfa != null)
        {
          paramajfa.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
          paramajfa.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramajfa.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText("");
        }
      }
      break;
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
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable arg4)
  {
    int i = 0;
    if ((paramView == null) || (paramRecentBaseData == null) || (!(paramRecentBaseData instanceof RecentSayHelloBoxItem))) {}
    do
    {
      return;
      localObject = paramView.getTag();
    } while (!(localObject instanceof ajgp));
    Object localObject = (ajgp)localObject;
    RecentSayHelloBoxItem localRecentSayHelloBoxItem = (RecentSayHelloBoxItem)paramRecentBaseData;
    ((ajgp)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(???);
    ((ajgp)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(2131699480);
    int k = paramRecentBaseData.mUnreadNum;
    int j = paramRecentBaseData.mUnreadFlag;
    if (k > 0) {
      if (j == 3)
      {
        j = 2130849736;
        ((ajgp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1);
        i = 3;
      }
    }
    for (;;)
    {
      label105:
      bhro.a(((ajgp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, k, j, 99, null);
      i = paramRecentBaseData.mExtraInfoColor;
      ??? = paramRecentBaseData.mMsgExtroInfo;
      if (??? != null)
      {
        ??? = ???.toString();
        label148:
        if (!TextUtils.isEmpty(???)) {
          ((ajgp)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(ColorStateList.valueOf(i), 1);
        }
        ((ajgp)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(???, 1);
      }
      for (;;)
      {
        synchronized (localRecentSayHelloBoxItem.lock)
        {
          if (!TextUtils.isEmpty(localRecentSayHelloBoxItem.mMsgExtroInfo))
          {
            ((ajgp)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
            ((ajgp)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
            ((ajgp)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentSayHelloBoxItem.mLastMsg);
            ((ajgp)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131166975));
            if (!AppSetting.c) {
              break;
            }
            paramView.setContentDescription(paramRecentBaseData.mContentDesc);
            return;
            j = 2130849732;
            ((ajgp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
            i = 3;
            break label105;
            ??? = "";
            break label148;
          }
          if ((localRecentSayHelloBoxItem.mUnreadMRList != null) && (localRecentSayHelloBoxItem.mUnreadMRList.size() > 0))
          {
            ((ajgp)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(8);
            ((ajgp)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(0);
            ((ajgp)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131166975));
            if (((ajgp)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getAdapter() == null) {
              continue;
            }
            ajgo.a((ajgo)((ajgp)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getAdapter(), localRecentSayHelloBoxItem.mUnreadMRList);
          }
        }
        ((ajgp)localObject).jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
        ((ajgp)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setVisibility(0);
        ((ajgp)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentSayHelloBoxItem.mLastMsg);
        ((ajgp)localObject).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(paramContext.getResources().getColor(2131166975));
      }
      j = 0;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, MessageRecord paramMessageRecord, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramMessageRecord == null) || (paramDrawable == null) || (!(paramRecentBaseData instanceof RecentSayHelloBoxItem))) {}
    for (;;)
    {
      return;
      paramView = paramView.getTag();
      if ((paramView instanceof ajgp))
      {
        paramView = (ajgp)paramView;
        int j = paramView.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getCount();
        int i = 0;
        while (i < j)
        {
          paramRecentBaseData = paramView.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(i);
          if ((paramRecentBaseData != null) && ((paramRecentBaseData.getTag(-1) instanceof String)))
          {
            String str = (String)paramRecentBaseData.getTag(-1);
            if (str.equals(paramMessageRecord.senderuin))
            {
              ((CustomImgView)paramRecentBaseData).setImageDrawable(paramDrawable);
              return;
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("SAYHELL_BOX", 4, "updateMsgHeader,childView uin:" + str);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgn
 * JD-Core Version:    0.7.0.1
 */