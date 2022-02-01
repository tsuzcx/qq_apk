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
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;

public class alnj
  extends alnt
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
  
  private void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, alnk paramalnk)
  {
    int j = 1;
    int k = 0;
    int i = paramRecentBaseData.mUnreadNum;
    int m = paramRecentBaseData.mUnreadFlag;
    if (i > 0) {
      if (m == 0)
      {
        paramalnk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
        j = 0;
        i = 0;
      }
    }
    for (;;)
    {
      blkk.a(paramalnk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, k, j, 99, null);
      return;
      if (m == 2)
      {
        paramalnk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, paramView);
        m = 0;
        i = j;
        j = m;
      }
      else if (m == 3)
      {
        if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
        paramalnk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
        paramalnk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167120));
        j = 2130850408;
        m = 3;
        k = i;
        i = m;
      }
      else
      {
        j = 2130850404;
        paramalnk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramView);
        paramalnk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTextColor(paramContext.getResources().getColor(2131167121));
        k = i;
        i = 3;
        continue;
        j = 0;
        i = 0;
      }
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData, alnk paramalnk)
  {
    CharSequence localCharSequence1 = paramRecentBaseData.mMsgExtroInfo;
    CharSequence localCharSequence2 = paramalnk.d.getText();
    int i = paramalnk.d.getCurrentTextColor();
    Object localObject = localCharSequence1;
    if (localCharSequence1 == null) {
      localObject = "";
    }
    if (!localObject.equals(localCharSequence2)) {
      paramalnk.d.setText((CharSequence)localObject);
    }
    if ((i != paramRecentBaseData.mExtraInfoColor) && (paramRecentBaseData.mExtraInfoColor != 0)) {
      paramalnk.d.setTextColor(paramRecentBaseData.mExtraInfoColor);
    }
  }
  
  private void b(RecentBaseData paramRecentBaseData, alnk paramalnk)
  {
    CharSequence localCharSequence1 = paramRecentBaseData.mLastMsg;
    CharSequence localCharSequence2 = paramalnk.e.getText();
    paramRecentBaseData = localCharSequence1;
    if (localCharSequence1 == null) {
      paramRecentBaseData = "";
    }
    if (!paramRecentBaseData.equals(localCharSequence2)) {}
    try
    {
      paramalnk.e.setText(paramRecentBaseData);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramalnk.e.setText(paramRecentBaseData + " ");
    }
  }
  
  private void c(RecentBaseData paramRecentBaseData, alnk paramalnk)
  {
    String str = paramRecentBaseData.mShowTime;
    CharSequence localCharSequence = paramalnk.jdField_a_of_type_AndroidWidgetTextView.getText();
    paramRecentBaseData = str;
    if (str == null) {
      paramRecentBaseData = "";
    }
    if (!paramRecentBaseData.equals(localCharSequence)) {
      paramalnk.jdField_a_of_type_AndroidWidgetTextView.setText(paramRecentBaseData);
    }
  }
  
  private void d(RecentBaseData paramRecentBaseData, alnk paramalnk)
  {
    if ((paramRecentBaseData.mMenuFlag & 0xF0) == 32)
    {
      paramalnk.g.setBackgroundResource(2130839403);
      return;
    }
    paramalnk.g.setBackgroundResource(2130839402);
  }
  
  public int a()
  {
    return 3;
  }
  
  public View a(int paramInt, Object paramObject, alno paramalno, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, alpv paramalpv)
  {
    paramalpv = null;
    paramViewGroup = paramalpv;
    if (paramView != null)
    {
      paramViewGroup = paramalpv;
      if ((paramView.getTag() instanceof alnk)) {
        paramViewGroup = (alnk)paramView.getTag();
      }
    }
    Object localObject;
    if (paramViewGroup == null)
    {
      paramalpv = new alnk();
      localObject = a(paramContext, 2131562813, paramalpv);
      paramalpv.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)((View)localObject).findViewById(2131368212));
      paramalpv.jdField_a_of_type_ComTencentWidgetThemeImageView.setSupportMaskView(true);
      paramalpv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject).findViewById(2131380442));
      paramalpv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131369615));
      paramalpv.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131365116));
      paramalpv.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(16908308));
      paramalpv.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131377965));
      paramalpv.c = ((TextView)((View)localObject).findViewById(2131367674));
      paramalpv.d = ((TextView)((View)localObject).findViewById(2131366206));
      paramalpv.e = ((TextView)((View)localObject).findViewById(16908309));
      paramalpv.e.setGravity(16);
      a((View)localObject, paramalpv.jdField_a_of_type_AndroidWidgetTextView, paramContext);
      ((View)localObject).setTag(paramalpv);
      paramView = (View)localObject;
      paramViewGroup = paramalpv;
      if (this.jdField_a_of_type_Alms != null)
      {
        paramalpv.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Alms.a());
        paramViewGroup = paramalpv;
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
        paramalpv = null;
        if (paramalno != null) {
          paramalpv = paramalno.a((RecentBaseData)localObject);
        }
        a(paramView, (RecentBaseData)localObject, paramContext, paramalpv);
        if ((paramObject instanceof RecentItemEcShop))
        {
          paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setOnClickListener(paramOnClickListener);
          paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setTag(-1, Integer.valueOf(paramInt));
          if (AppSetting.c) {
            paramViewGroup.jdField_a_of_type_ComTencentWidgetThemeImageView.setContentDescription(String.format(anzj.a(2131712033), new Object[] { ((RecentItemEcShop)paramObject).getTitleName() }));
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
  
  public void a(alnk paramalnk, RecentBaseData paramRecentBaseData)
  {
    switch (paramRecentBaseData.mStatus)
    {
    default: 
      paramalnk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramalnk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      return;
    case 1: 
      paramalnk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramalnk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842092);
      return;
    case 2: 
      paramalnk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramRecentBaseData.mIsGroupVideo)
      {
        paramalnk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842102);
        return;
      }
      paramalnk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842092);
      return;
    case 3: 
      paramalnk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramRecentBaseData.mIsGroupVideo)
      {
        paramalnk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842102);
        return;
      }
      paramalnk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842103);
      return;
    case 5: 
      paramalnk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramalnk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842103);
      return;
    }
    paramalnk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramalnk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839541);
  }
  
  protected void a(View paramView, TextView paramTextView, Context paramContext)
  {
    try
    {
      LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131378605);
      paramView = TimeManager.getInstance().getMsgDisplayTime("000000", 1225168973512L);
      if (TextUtils.isEmpty(paramView))
      {
        paramView = TimeManager.getInstance().getDateFormat();
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
    if ((localObject instanceof alnk)) {}
    for (alnk localalnk = (alnk)localObject;; localalnk = null)
    {
      if (localalnk == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
        return;
      }
      localalnk.jdField_a_of_type_ComTencentWidgetThemeImageView.setImageDrawable(paramDrawable);
      localObject = paramRecentBaseData.mTitleName;
      CharSequence localCharSequence = localalnk.jdField_b_of_type_AndroidWidgetTextView.getText();
      paramDrawable = (Drawable)localObject;
      if (localObject == null) {
        paramDrawable = "";
      }
      if (!paramDrawable.equals(localCharSequence)) {
        localalnk.jdField_b_of_type_AndroidWidgetTextView.setText(paramDrawable);
      }
      int i = paramRecentBaseData.mAuthenIconId;
      if (i > 0)
      {
        localalnk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localalnk.jdField_b_of_type_AndroidWidgetImageView.setImageResource(i);
        label175:
        localObject = paramRecentBaseData.mExtraInfo;
        localCharSequence = localalnk.c.getText();
        paramDrawable = (Drawable)localObject;
        if (localObject == null) {
          paramDrawable = "";
        }
        if (!TextUtils.isEmpty(paramDrawable)) {
          break label389;
        }
        localalnk.c.setVisibility(8);
      }
      for (;;)
      {
        a(a((View)localalnk.jdField_b_of_type_AndroidWidgetTextView.getParent()), localalnk.jdField_b_of_type_AndroidWidgetTextView, new View[] { localalnk.jdField_b_of_type_AndroidWidgetImageView, localalnk.c });
        a(paramRecentBaseData, localalnk);
        b(paramRecentBaseData, localalnk);
        c(paramRecentBaseData, localalnk);
        a(localalnk, paramRecentBaseData);
        a(paramView, paramRecentBaseData, paramContext, localalnk);
        if (localalnk.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
          localalnk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (AppSetting.c) {
          paramView.setContentDescription(paramRecentBaseData.mContentDesc);
        }
        d(paramRecentBaseData, localalnk);
        long l = paramRecentBaseData.getFaceExtraFlag();
        if (!(localalnk.jdField_a_of_type_ComTencentWidgetThemeImageView instanceof blml)) {
          break;
        }
        ((blml)localalnk.jdField_a_of_type_ComTencentWidgetThemeImageView).a(l);
        return;
        localalnk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label175;
        label389:
        if (!paramDrawable.equals(localCharSequence)) {
          localalnk.c.setText(paramDrawable);
        }
        localalnk.c.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnj
 * JD-Core Version:    0.7.0.1
 */