import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class aibz
  extends BaseAdapter
{
  private aicb jdField_a_of_type_Aicb;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<aica> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public aibz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a(float paramFloat, int paramInt)
  {
    return (Math.min(255, Math.max(0, (int)(255.0F * paramFloat))) << 24) + (0xFFFFFF & paramInt);
  }
  
  private ColorStateList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt1 = { 16842919, 16842910 };
    int[] arrayOfInt2 = { 16842908 };
    int[] arrayOfInt3 = { 16842909 };
    int[] arrayOfInt4 = new int[0];
    return new ColorStateList(new int[][] { arrayOfInt1, { 16842910, 16842908 }, { 16842910 }, arrayOfInt2, arrayOfInt3, arrayOfInt4 }, new int[] { paramInt2, paramInt3, paramInt1, paramInt3, paramInt4, paramInt1 });
  }
  
  private Drawable a(int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(42.0F);
    localGradientDrawable.setColor(paramInt);
    return localGradientDrawable;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = a(paramInt1);
    localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
    localDrawable = a(paramInt1);
    localStateListDrawable.addState(new int[] { 16842908 }, localDrawable);
    localDrawable = a(paramInt1);
    localStateListDrawable.addState(new int[] { 16842913 }, localDrawable);
    localDrawable = a(paramInt2);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  public aica a(int paramInt)
  {
    return (aica)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(aica paramaica)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramaica);
  }
  
  public void a(aicb paramaicb)
  {
    this.jdField_a_of_type_Aicb = paramaicb;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    aica localaica;
    Object localObject;
    label104:
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561111, null, false);
      paramView = new aicc(this);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379863));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramView);
      localView.setTag(paramView);
      localaica = a(paramInt);
      if (localaica != null)
      {
        paramView.jdField_a_of_type_JavaLangString = localaica.jdField_a_of_type_JavaLangString;
        paramView.jdField_a_of_type_Int = paramInt;
        TextView localTextView = paramView.jdField_a_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(localaica.jdField_a_of_type_JavaLangString)) {
          break label216;
        }
        localObject = "";
        localTextView.setText((CharSequence)localObject);
        if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
          break label226;
        }
        i = Color.parseColor("#A8A8A8");
        paramView.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845200));
      }
    }
    for (;;)
    {
      int j = a(0.5F, i);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(i, j, j, i));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (aicc)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label216:
      localObject = localaica.jdField_a_of_type_JavaLangString;
      break label104;
      label226:
      if (localaica.b == null)
      {
        i = Color.parseColor("#03081A");
        paramView.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845199));
      }
      else
      {
        i = Color.parseColor(localaica.b);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(a(0.1F, i), a(0.2F, i)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibz
 * JD-Core Version:    0.7.0.1
 */