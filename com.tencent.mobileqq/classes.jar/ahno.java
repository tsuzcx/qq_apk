import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class ahno
  extends ahny
{
  public static int a;
  private List<String> a;
  
  private int a(View paramView)
  {
    int i = paramView.getResources().getDisplayMetrics().widthPixels;
    int j = paramView.getPaddingRight();
    int k = paramView.getPaddingLeft();
    paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int m = paramView.leftMargin;
    return i - (paramView.rightMargin + (k + (0 + j) + m));
  }
  
  public static void a(int paramInt, TextView paramTextView, View... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramInt <= 0)) {}
    label276:
    label283:
    for (;;)
    {
      return;
      int m = paramVarArgs.length;
      int j = 0;
      int i = 0;
      Object localObject;
      if (j < m)
      {
        localObject = paramVarArgs[j];
        if (((View)localObject).getVisibility() == 8) {}
        int k;
        do
        {
          j += 1;
          break;
          if (!(localObject instanceof TextView)) {
            break label240;
          }
          String str = ((TextView)localObject).getText().toString();
          if (TextUtils.isEmpty(str)) {
            break label276;
          }
          TextPaint localTextPaint = ((TextView)localObject).getPaint();
          float f = i;
          i = (int)(localTextPaint.measureText(str) + 0.5F + f);
          i = i + ((View)localObject).getPaddingLeft() + ((View)localObject).getPaddingRight();
          localObject = (LinearLayout.LayoutParams)((View)localObject).getLayoutParams();
          k = ((LinearLayout.LayoutParams)localObject).leftMargin + i + ((LinearLayout.LayoutParams)localObject).rightMargin;
          i = k;
        } while (k <= paramInt);
        j = 0;
        i = k;
      }
      for (;;)
      {
        if (i == 0) {
          break label283;
        }
        if (j != 0)
        {
          paramVarArgs = paramTextView.getText().toString();
          if (!TextUtils.isEmpty(paramVarArgs))
          {
            j = (int)(paramTextView.getPaint().measureText(paramVarArgs) + 0.5F);
            label211:
            if (j + i < paramInt) {
              paramInt = 1;
            }
          }
        }
        for (;;)
        {
          paramTextView = (LinearLayout.LayoutParams)paramTextView.getLayoutParams();
          if (paramInt != 0)
          {
            paramTextView.weight = 0.0F;
            return;
            label240:
            i = ((View)localObject).getWidth() + i;
            break;
            paramInt = 0;
            continue;
          }
          paramTextView.weight = 1.0F;
          return;
          j = 0;
          break label211;
          paramInt = j;
        }
        break;
        j = 1;
      }
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, ahnt paramahnt, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ahpq paramahpq)
  {
    paramahpq = null;
    paramViewGroup = paramahpq;
    if (paramView != null)
    {
      paramViewGroup = paramahpq;
      if ((paramView.getTag() instanceof ahnp)) {
        paramViewGroup = (ahnp)paramView.getTag();
      }
    }
    Object localObject;
    if (paramViewGroup == null)
    {
      paramahpq = new ahnp();
      localObject = a(paramContext, 2131562320, paramahpq);
      paramahpq.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)((View)localObject).findViewById(2131367679));
      paramahpq.jdField_a_of_type_ComTencentWidgetThemeImageView.setSupportMaskView(true);
      paramahpq.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131378650));
      paramahpq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131368885));
      paramahpq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131364757));
      paramahpq.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(16908308));
      paramahpq.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131376452));
      paramahpq.c = ((TextView)((View)localObject).findViewById(2131367157));
      paramahpq.d = ((TextView)((View)localObject).findViewById(2131365818));
      paramahpq.e = ((TextView)((View)localObject).findViewById(16908309));
      paramahpq.e.setGravity(16);
      a((View)localObject, paramahpq.jdField_a_of_type_AndroidWidgetTextView, paramContext);
      ((View)localObject).setTag(paramahpq);
      paramView = (View)localObject;
      paramViewGroup = paramahpq;
      if (this.jdField_a_of_type_Ahmx != null)
      {
        paramahpq.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ahmx.a());
        paramViewGroup = paramahpq;
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.d) {
        paramView.setContentDescription(null);
      }
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        localObject = (RecentBaseData)paramObject;
        paramahpq = null;
        if (paramahnt != null) {
          paramahpq = paramahnt.a((RecentBaseData)localObject);
        }
        a(paramView, (RecentBaseData)localObject, paramContext, paramahpq);
        if ((paramObject instanceof RecentItemEcShop))
        {
          paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setOnClickListener(paramOnClickListener);
          paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setTag(-1, Integer.valueOf(paramInt));
          if (AppSetting.d) {
            paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setContentDescription(String.format(ajyc.a(2131713150), new Object[] { ((RecentItemEcShop)paramObject).b() }));
          }
        }
      }
      for (;;)
      {
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        if (paramViewGroup != null)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.c.setVisibility(8);
          paramViewGroup.c.setText("");
          paramViewGroup.d.setText("");
          paramViewGroup.e.setText("");
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("");
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
      }
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int i = paramRecentBaseData.mMenuFlag;
    paramRecentBaseData = paramContext.getResources();
    int j;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      j = 0xF0000 & i;
      if (j != 131072) {
        break label149;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[5]));
      label72:
      j = i & 0xF0;
      if (j != 32) {
        break label179;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[2]));
    }
    for (;;)
    {
      if ((i & 0xF) == 1) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[0]));
      }
      return this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      label149:
      if (j != 65536) {
        break label72;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[4]));
      break label72;
      label179:
      if (j == 16) {
        this.jdField_a_of_type_JavaUtilList.add(paramRecentBaseData.getString(jdField_a_of_type_ArrayOfInt[3]));
      }
    }
  }
  
  public void a(ahnp paramahnp, RecentBaseData paramRecentBaseData)
  {
    switch (paramRecentBaseData.mStatus)
    {
    default: 
      paramahnp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramahnp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      return;
    case 1: 
      paramahnp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramahnp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841610);
      return;
    case 2: 
      paramahnp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramRecentBaseData.mIsGroupVideo)
      {
        paramahnp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841620);
        return;
      }
      paramahnp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841610);
      return;
    case 3: 
      paramahnp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramRecentBaseData.mIsGroupVideo)
      {
        paramahnp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841620);
        return;
      }
      paramahnp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841621);
      return;
    case 5: 
      paramahnp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramahnp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841621);
      return;
    }
    paramahnp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramahnp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839263);
  }
  
  protected void a(View paramView, TextView paramTextView, Context paramContext)
  {
    try
    {
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131377032);
      paramView = ahpl.a().a("000000", 1225168973512L);
      if (TextUtils.isEmpty(paramView))
      {
        paramView = ahpl.a().a();
        if ((!TextUtils.isEmpty(paramView)) && (paramView.length() != "yyyy-MM-dd".length()))
        {
          i = 1;
          int j;
          if ((jdField_a_of_type_Int <= 0) || (i != 0))
          {
            f = paramContext.getResources().getDisplayMetrics().density;
            paramContext = paramTextView.getPaint();
            paramTextView = paramContext;
            if (paramContext == null)
            {
              paramTextView = new TextPaint();
              paramTextView.setTextSize(12.0F * f);
            }
            if (i == 0) {
              break label242;
            }
            i = (int)(paramTextView.measureText("yyyy-MM-dd") + f * 6.0F);
            j = (int)(paramTextView.measureText(paramView) + f * 6.0F);
            if (j <= i) {
              break label215;
            }
          }
          label215:
          for (jdField_a_of_type_Int = j; localLinearLayout.getPaddingRight() < jdField_a_of_type_Int; jdField_a_of_type_Int = i)
          {
            i = localLinearLayout.getPaddingLeft();
            j = localLinearLayout.getPaddingTop();
            int k = localLinearLayout.getPaddingBottom();
            int m = jdField_a_of_type_Int;
            localLinearLayout.setPadding(i, j, jdField_a_of_type_Int, k);
            return;
          }
        }
      }
    }
    catch (Exception paramView)
    {
      int i;
      float f;
      while (QLog.isDevelopLevel())
      {
        QLog.i("RecentDefaultItemBuilder", 4, paramView.toString());
        return;
        label242:
        jdField_a_of_type_Int = (int)(paramTextView.measureText("yyyy-MM-dd") + f * 6.0F);
        continue;
        i = 0;
      }
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
    if ((localObject instanceof ahnp)) {}
    for (ahnp localahnp = (ahnp)localObject;; localahnp = null) {
      for (;;)
      {
        if (localahnp == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
          return;
        }
        localahnp.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramDrawable);
        localObject = paramRecentBaseData.mTitleName;
        CharSequence localCharSequence = localahnp.jdField_b_of_type_AndroidWidgetTextView.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localCharSequence)) {
          localahnp.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
        }
        int i = paramRecentBaseData.mAuthenIconId;
        if (i > 0)
        {
          localahnp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          localahnp.jdField_b_of_type_AndroidWidgetImageView.setImageResource(i);
          label175:
          localObject = paramRecentBaseData.mExtraInfo;
          localCharSequence = localahnp.c.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!TextUtils.isEmpty(paramDrawable)) {
            break label623;
          }
          localahnp.c.setVisibility(8);
          a(a((View)localahnp.jdField_b_of_type_AndroidWidgetTextView.getParent()), localahnp.jdField_b_of_type_AndroidWidgetTextView, new View[] { localahnp.jdField_b_of_type_AndroidWidgetImageView, localahnp.c });
          localObject = paramRecentBaseData.mMsgExtroInfo;
          localCharSequence = localahnp.d.getText();
          i = localahnp.d.getCurrentTextColor();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localahnp.d.setText(paramDrawable);
          }
          if ((i != paramRecentBaseData.mExtraInfoColor) && (paramRecentBaseData.mExtraInfoColor != 0)) {
            localahnp.d.setTextColor(paramRecentBaseData.mExtraInfoColor);
          }
          localObject = paramRecentBaseData.mLastMsg;
          localCharSequence = localahnp.e.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (paramDrawable.equals(localCharSequence)) {}
        }
        try
        {
          localahnp.e.setText(paramDrawable);
          localObject = paramRecentBaseData.mShowTime;
          localCharSequence = localahnp.jdField_a_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localahnp.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          a(localahnp, paramRecentBaseData);
          m = paramRecentBaseData.mUnreadNum;
          i = paramRecentBaseData.mUnreadFlag;
          if (m > 0) {
            if (i == 0)
            {
              localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              k = 99;
              m = 0;
              j = 0;
              i = 0;
              bfqb.a(localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              if (localahnp.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                localahnp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              if (AppSetting.d) {
                paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              }
              if ((paramRecentBaseData.mMenuFlag & 0xF0) != 32) {
                break label825;
              }
              localahnp.g.setBackgroundResource(2130839133);
              long l = paramRecentBaseData.c();
              if (!(localahnp.jdField_a_of_type_ComTencentWidgetThemeImageView instanceof bfsb)) {
                break;
              }
              ((bfsb)localahnp.jdField_a_of_type_ComTencentWidgetThemeImageView).a(l);
              return;
              localahnp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              break label175;
              label623:
              if (!paramDrawable.equals(localCharSequence)) {
                localahnp.c.setText(paramDrawable);
              }
              localahnp.c.setVisibility(0);
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
            localahnp.e.setText(paramDrawable + " ");
            continue;
            if (i == 2)
            {
              localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              m = 0;
              j = 0;
              i = 1;
              k = 99;
            }
            else if (i == 3)
            {
              j = 2130849296;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
              localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131166973));
              k = 99;
              i = 3;
            }
            else
            {
              j = 2130849292;
              localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              localahnp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131166974));
              k = 99;
              i = 3;
              continue;
              label825:
              localahnp.g.setBackgroundResource(2130839132);
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
 * Qualified Name:     ahno
 * JD-Core Version:    0.7.0.1
 */