import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeLabelTextView;

public abstract class aeyf
{
  public static final int[] a;
  public static final int[] b;
  public static final int[] c = { 2131304236 };
  public aicw a;
  protected Context a;
  public atcu a;
  protected bens a;
  public QQAppInterface a;
  protected int b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131625931 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130839215 };
  }
  
  public aeyf(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aicw = paramaicw;
    this.jdField_a_of_type_Atcu = paramatcu;
    this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131166194);
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839106);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839104);
      return;
    }
    paramView.setBackgroundResource(2130839101);
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    int j;
    int i;
    switch (paramInt1)
    {
    default: 
      paramTextView.setBackgroundResource(2130844934);
      j = 0;
      i = 0;
    }
    for (;;)
    {
      if ((paramInt2 > 0) && ((paramInt1 == 0) || (paramInt1 == 1)))
      {
        paramTextView.setText(String.valueOf(paramInt2));
        if ((paramStringBuilder == null) || (!AppSetting.c)) {
          break label225;
        }
        paramStringBuilder.append(",").append(String.valueOf(paramInt2));
        i = 1;
      }
      for (;;)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
        if (i != 0)
        {
          if ((paramTextView instanceof ThemeLabelTextView)) {
            ((ThemeLabelTextView)paramTextView).setSupportMaskView(true);
          }
          paramTextView.setVisibility(0);
          return;
          j = 2130844933;
          paramTextView.setBackgroundResource(2130844934);
          i = j;
          if (paramStringBuilder == null) {
            break label231;
          }
          i = j;
          if (!AppSetting.c) {
            break label231;
          }
          paramStringBuilder.append(",男");
          j = 2130844933;
          i = 1;
          break;
          j = 2130844931;
          paramTextView.setBackgroundResource(2130844932);
          i = j;
          if (paramStringBuilder == null) {
            break label231;
          }
          i = j;
          if (!AppSetting.c) {
            break label231;
          }
          paramStringBuilder.append(",女");
          j = 2130844931;
          i = 1;
          break;
          paramTextView.setText("");
          continue;
        }
        paramTextView.setVisibility(8);
        return;
        label225:
        i = 1;
      }
      label231:
      j = i;
      i = 1;
    }
  }
  
  public static void b(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = new AbsListView.LayoutParams(-1, paramInt);
    }
    for (;;)
    {
      paramView.setMinimumHeight(paramInt);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).width = -1;
      ((ViewGroup.LayoutParams)localObject).height = paramInt;
    }
  }
  
  public static void b(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    int i = paramView.getPaddingBottom();
    int j = paramView.getPaddingTop();
    int k = paramView.getPaddingRight();
    int m = paramView.getPaddingLeft();
    if (paramBoolean) {
      paramView.setBackgroundResource(2130839106);
    }
    for (;;)
    {
      paramView.setPadding(m, j, k, i);
      return;
      if (ThemeUtil.isDefaultTheme()) {
        paramView.setBackgroundResource(2130839104);
      } else {
        paramView.setBackgroundResource(2130839101);
      }
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  public abstract View a(int paramInt, View paramView);
  
  protected View a(Context paramContext, int paramInt, aeyh paramaeyh)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.jdField_a_of_type_Aicw != null) {
      return this.jdField_a_of_type_Bens.a(paramContext, localView, paramaeyh, -1);
    }
    paramaeyh.g = localView;
    paramaeyh.a = null;
    return localView;
  }
  
  protected bens a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131167510);
    int j = paramContext.getResources().getDimensionPixelSize(2131167511);
    paramContext = c;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new aeyg(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  protected void a() {}
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, bent parambent, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Bens != null) {}
    for (int i = this.jdField_a_of_type_Bens.a(paramContext, paramView, paramInt, paramObject, parambent, paramOnClickListener);; i = 0)
    {
      if ((this.jdField_a_of_type_Aicw != null) && (this.jdField_a_of_type_Aicw.a != -1))
      {
        if (paramInt != this.jdField_a_of_type_Aicw.a) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
  }
  
  protected void a(View paramView)
  {
    if (!azzz.a("tag_swip_icon_menu_item", paramView.getTag())) {}
    for (;;)
    {
      return;
      if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626719), 0).b(c());
        return;
      }
      Object localObject1 = paramView.getTag(-1);
      Object localObject2 = paramView.getTag(-2);
      if ((!(localObject1 instanceof Integer)) || (!(localObject2 instanceof Integer)))
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("Q.newfriend", 4, "SystemMsgListAdpater onClick tag is not int");
        return;
      }
      int i = ((Integer)localObject1).intValue();
      int j = ((Integer)localObject2).intValue();
      localObject1 = null;
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriend", 2, "SystemMsgListAdpater onClick position = " + i + "nMenuStrId = " + j + "v.getId() = " + paramView.getId());
      }
      try
      {
        paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(j);
        if (!azzz.a(paramView, this.jdField_a_of_type_AndroidContentContext.getResources().getString(jdField_a_of_type_ArrayOfInt[0]))) {
          continue;
        }
        a();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramView = localObject1;
          if (QLog.isDevelopLevel())
          {
            QLog.i("Q.newfriend", 4, localException.toString());
            paramView = localObject1;
          }
        }
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    View localView;
    do
    {
      return;
      localView = paramView.findViewById(2131309584);
      if ((localView == paramView) || (localView == null))
      {
        b(paramView, paramInt);
        return;
      }
      paramView = localView.getLayoutParams();
    } while (paramView == null);
    paramView.width = -1;
    paramView.height = paramInt;
    localView.setLayoutParams(paramView);
  }
  
  public void a(atcu paramatcu)
  {
    this.jdField_a_of_type_Atcu = paramatcu;
  }
  
  public void b(View paramView)
  {
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(true);
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeyf
 * JD-Core Version:    0.7.0.1
 */