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
import java.util.ArrayList;
import java.util.List;

public class ahkl
  extends BaseAdapter
{
  private ahkn jdField_a_of_type_Ahkn;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<ahkm> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ahkl(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a(float paramFloat, int paramInt)
  {
    return (Math.min(255, Math.max(0, (int)(255.0F * paramFloat))) << 24) + (0xFFFFFF & paramInt);
  }
  
  private ColorStateList a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt1 = { 16842908 };
    int[] arrayOfInt2 = { 16842909 };
    int[] arrayOfInt3 = new int[0];
    return new ColorStateList(new int[][] { { 16842919, 16842910 }, { 16842910, 16842908 }, { 16842910 }, arrayOfInt1, arrayOfInt2, arrayOfInt3 }, new int[] { paramInt2, paramInt3, paramInt1, paramInt3, paramInt4, paramInt1 });
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
  
  public ahkm a(int paramInt)
  {
    return (ahkm)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(ahkm paramahkm)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramahkm);
  }
  
  public void a(ahkn paramahkn)
  {
    this.jdField_a_of_type_Ahkn = paramahkn;
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
    ahkm localahkm;
    String str;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560991, null, false);
      paramViewGroup = new ahko(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379025));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramViewGroup);
      paramView.setTag(paramViewGroup);
      localahkm = a(paramInt);
      if (localahkm != null)
      {
        paramViewGroup.jdField_a_of_type_JavaLangString = localahkm.jdField_a_of_type_JavaLangString;
        paramViewGroup.jdField_a_of_type_Int = paramInt;
        TextView localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(localahkm.jdField_a_of_type_JavaLangString)) {
          break label186;
        }
        str = "";
        label101:
        localTextView.setText(str);
        if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
          break label196;
        }
        paramInt = Color.parseColor("#A8A8A8");
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844909));
      }
    }
    for (;;)
    {
      int i = a(0.5F, paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(a(paramInt, i, i, paramInt));
      return paramView;
      paramViewGroup = (ahko)paramView.getTag();
      break;
      label186:
      str = localahkm.jdField_a_of_type_JavaLangString;
      break label101;
      label196:
      if (localahkm.b == null)
      {
        paramInt = Color.parseColor("#03081A");
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844908));
      }
      else
      {
        paramInt = Color.parseColor(localahkm.b);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(a(a(0.1F, paramInt), a(0.2F, paramInt)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkl
 * JD-Core Version:    0.7.0.1
 */