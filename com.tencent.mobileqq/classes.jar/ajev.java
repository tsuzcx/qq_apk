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

public class ajev
  extends ajff
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
  
  public View a(int paramInt, Object paramObject, ajfa paramajfa, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, ajgx paramajgx)
  {
    paramajgx = null;
    paramViewGroup = paramajgx;
    if (paramView != null)
    {
      paramViewGroup = paramajgx;
      if ((paramView.getTag() instanceof ajew)) {
        paramViewGroup = (ajew)paramView.getTag();
      }
    }
    Object localObject;
    if (paramViewGroup == null)
    {
      paramajgx = new ajew();
      localObject = a(paramContext, 2131562523, paramajgx);
      paramajgx.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)((View)localObject).findViewById(2131367808));
      paramajgx.jdField_a_of_type_ComTencentWidgetThemeImageView.setSupportMaskView(true);
      paramajgx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131379273));
      paramajgx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131369115));
      paramajgx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131364836));
      paramajgx.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(16908308));
      paramajgx.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131376954));
      paramajgx.c = ((TextView)((View)localObject).findViewById(2131367287));
      paramajgx.d = ((TextView)((View)localObject).findViewById(2131365903));
      paramajgx.e = ((TextView)((View)localObject).findViewById(16908309));
      paramajgx.e.setGravity(16);
      a((View)localObject, paramajgx.jdField_a_of_type_AndroidWidgetTextView, paramContext);
      ((View)localObject).setTag(paramajgx);
      paramView = (View)localObject;
      paramViewGroup = paramajgx;
      if (this.jdField_a_of_type_Ajee != null)
      {
        paramajgx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Ajee.a());
        paramViewGroup = paramajgx;
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      if (AppSetting.c) {
        paramView.setContentDescription(null);
      }
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        localObject = (RecentBaseData)paramObject;
        paramajgx = null;
        if (paramajfa != null) {
          paramajgx = paramajfa.a((RecentBaseData)localObject);
        }
        a(paramView, (RecentBaseData)localObject, paramContext, paramajgx);
        if ((paramObject instanceof RecentItemEcShop))
        {
          paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setOnClickListener(paramOnClickListener);
          paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setTag(-1, Integer.valueOf(paramInt));
          if (AppSetting.c) {
            paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setContentDescription(String.format(alpo.a(2131713533), new Object[] { ((RecentItemEcShop)paramObject).b() }));
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
  
  public void a(ajew paramajew, RecentBaseData paramRecentBaseData)
  {
    switch (paramRecentBaseData.mStatus)
    {
    default: 
      paramajew.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramajew.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      return;
    case 1: 
      paramajew.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramajew.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841761);
      return;
    case 2: 
      paramajew.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramRecentBaseData.mIsGroupVideo)
      {
        paramajew.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841771);
        return;
      }
      paramajew.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841761);
      return;
    case 3: 
      paramajew.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramRecentBaseData.mIsGroupVideo)
      {
        paramajew.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841771);
        return;
      }
      paramajew.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841772);
      return;
    case 5: 
      paramajew.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramajew.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841772);
      return;
    }
    paramajew.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramajew.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839352);
  }
  
  protected void a(View paramView, TextView paramTextView, Context paramContext)
  {
    try
    {
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131377554);
      paramView = ajgs.a().a("000000", 1225168973512L);
      if (TextUtils.isEmpty(paramView))
      {
        paramView = ajgs.a().a();
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
    if ((localObject instanceof ajew)) {}
    for (ajew localajew = (ajew)localObject;; localajew = null) {
      for (;;)
      {
        if (localajew == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
          return;
        }
        localajew.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramDrawable);
        localObject = paramRecentBaseData.mTitleName;
        CharSequence localCharSequence = localajew.jdField_b_of_type_AndroidWidgetTextView.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!paramDrawable.equals(localCharSequence)) {
          localajew.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
        }
        int i = paramRecentBaseData.mAuthenIconId;
        if (i > 0)
        {
          localajew.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          localajew.jdField_b_of_type_AndroidWidgetImageView.setImageResource(i);
          label175:
          localObject = paramRecentBaseData.mExtraInfo;
          localCharSequence = localajew.c.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!TextUtils.isEmpty(paramDrawable)) {
            break label623;
          }
          localajew.c.setVisibility(8);
          a(a((View)localajew.jdField_b_of_type_AndroidWidgetTextView.getParent()), localajew.jdField_b_of_type_AndroidWidgetTextView, new View[] { localajew.jdField_b_of_type_AndroidWidgetImageView, localajew.c });
          localObject = paramRecentBaseData.mMsgExtroInfo;
          localCharSequence = localajew.d.getText();
          i = localajew.d.getCurrentTextColor();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localajew.d.setText(paramDrawable);
          }
          if ((i != paramRecentBaseData.mExtraInfoColor) && (paramRecentBaseData.mExtraInfoColor != 0)) {
            localajew.d.setTextColor(paramRecentBaseData.mExtraInfoColor);
          }
          localObject = paramRecentBaseData.mLastMsg;
          localCharSequence = localajew.e.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (paramDrawable.equals(localCharSequence)) {}
        }
        try
        {
          localajew.e.setText(paramDrawable);
          localObject = paramRecentBaseData.mShowTime;
          localCharSequence = localajew.jdField_a_of_type_AndroidWidgetTextView.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            localajew.jdField_a_of_type_AndroidWidgetTextView.setText(paramDrawable);
          }
          a(localajew, paramRecentBaseData);
          m = paramRecentBaseData.mUnreadNum;
          i = paramRecentBaseData.mUnreadFlag;
          if (m > 0) {
            if (i == 0)
            {
              localajew.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              k = 99;
              m = 0;
              j = 0;
              i = 0;
              bhro.a(localajew.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, k, null);
              if (localajew.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
                localajew.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              }
              if (AppSetting.c) {
                paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              }
              if ((paramRecentBaseData.mMenuFlag & 0xF0) != 32) {
                break label825;
              }
              localajew.g.setBackgroundResource(2130839217);
              long l = paramRecentBaseData.c();
              if (!(localajew.jdField_a_of_type_ComTencentWidgetThemeImageView instanceof bhtp)) {
                break;
              }
              ((bhtp)localajew.jdField_a_of_type_ComTencentWidgetThemeImageView).a(l);
              return;
              localajew.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
              break label175;
              label623:
              if (!paramDrawable.equals(localCharSequence)) {
                localajew.c.setText(paramDrawable);
              }
              localajew.c.setVisibility(0);
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
            localajew.e.setText(paramDrawable + " ");
            continue;
            if (i == 2)
            {
              localajew.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
              m = 0;
              j = 0;
              i = 1;
              k = 99;
            }
            else if (i == 3)
            {
              j = 2130849736;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              localajew.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
              localajew.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167024));
              k = 99;
              i = 3;
            }
            else
            {
              j = 2130849732;
              localajew.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
              localajew.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167025));
              k = 99;
              i = 3;
              continue;
              label825:
              localajew.g.setBackgroundResource(2130839216);
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
 * Qualified Name:     ajev
 * JD-Core Version:    0.7.0.1
 */