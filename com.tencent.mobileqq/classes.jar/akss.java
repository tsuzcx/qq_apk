import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.widget.AlphaClickableButton;
import com.tencent.widget.AlphaClickableTextView;

public class akss
  implements LayoutInflater.Factory2
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16843087, 16843088, 16844078, 2131034503, 2131034785, 2131034916, 2131034914 };
  private Activity jdField_a_of_type_AndroidAppActivity;
  
  public akss(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    paramView = null;
    int i;
    label39:
    int j;
    if (paramString.equals("TextView"))
    {
      paramView = new TextView(paramContext, paramAttributeSet);
      if (paramView == null) {
        return paramView;
      }
      paramString = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
      i = 0;
      if (i >= jdField_a_of_type_ArrayOfInt.length) {
        break label548;
      }
      j = paramString.getResourceId(i, 0);
      if (j != 0) {
        break label255;
      }
    }
    for (;;)
    {
      i += 1;
      break label39;
      if (paramString.equals("Button"))
      {
        paramView = new Button(paramContext, paramAttributeSet);
        break;
      }
      if (paramString.endsWith("DragTextView"))
      {
        paramView = new DragTextView(paramContext, paramAttributeSet);
        break;
      }
      if (paramString.equals("com.tencent.mobileqq.widget.FormSwitchItem"))
      {
        paramView = new FormSwitchItem(paramContext, paramAttributeSet);
        break;
      }
      if (paramString.equals("com.tencent.mobileqq.widget.FormSimpleItem"))
      {
        paramView = new FormSimpleItem(paramContext, paramAttributeSet);
        break;
      }
      if (paramString.equals("com.tencent.mobileqq.widget.FormSwitchSimpleItem"))
      {
        paramView = new FormSwitchSimpleItem(paramContext, paramAttributeSet);
        break;
      }
      if (paramString.equals("com.tencent.mobileqq.widget.FormMultiLineSwitchItem"))
      {
        paramView = new FormMultiLineSwitchItem(paramContext, paramAttributeSet);
        break;
      }
      if (paramString.equals("com.tencent.widget.AlphaClickableTextView"))
      {
        paramView = new AlphaClickableTextView(paramContext, paramAttributeSet);
        break;
      }
      if (!paramString.equals("com.tencent.widget.AlphaClickableButton")) {
        break;
      }
      paramView = new AlphaClickableButton(paramContext, paramAttributeSet);
      break;
      label255:
      paramAttributeSet = paramContext.getString(j);
      switch (jdField_a_of_type_ArrayOfInt[i])
      {
      default: 
        break;
      case 16843087: 
        if ((paramView instanceof TextView)) {
          ((TextView)paramView).setText(paramAttributeSet);
        } else if ((paramView instanceof Button)) {
          ((Button)paramView).setText(paramAttributeSet);
        } else if ((paramView instanceof FormSwitchItem)) {
          ((FormSwitchItem)paramView).setText(paramAttributeSet);
        }
        break;
      case 16843088: 
        if ((paramView instanceof TextView)) {
          ((TextView)paramView).setHint(paramAttributeSet);
        } else if ((paramView instanceof Button)) {
          ((Button)paramView).setHint(paramAttributeSet);
        }
        break;
      case 16844078: 
        if ((paramView instanceof TextView)) {
          ((TextView)paramView).setContentDescription(paramAttributeSet);
        } else if ((paramView instanceof Button)) {
          ((Button)paramView).setContentDescription(paramAttributeSet);
        }
        break;
      case 2131034503: 
        if ((paramView instanceof FormSimpleItem)) {
          ((FormSimpleItem)paramView).setLeftText(paramAttributeSet);
        }
        break;
      case 2131034785: 
        if ((paramView instanceof FormSimpleItem)) {
          ((FormSimpleItem)paramView).setRightText(paramAttributeSet);
        }
        break;
      case 2131034916: 
        if ((paramView instanceof FormSwitchItem)) {
          ((FormSwitchItem)paramView).setText(paramAttributeSet);
        }
        break;
      case 2131034914: 
        if ((paramView instanceof FormMultiLineSwitchItem)) {
          ((FormMultiLineSwitchItem)paramView).setSecendLineText(paramAttributeSet);
        }
        break;
      }
    }
    label548:
    paramString.recycle();
    return paramView;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akss
 * JD-Core Version:    0.7.0.1
 */