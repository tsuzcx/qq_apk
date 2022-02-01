import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.List;

public class aakp
  extends aakr
{
  private int jdField_a_of_type_Int;
  protected aakl a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private List<aako> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b;
  
  public aakp(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    a(2131559186);
    this.b = 4;
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramInt3 > paramInt1)
    {
      if (paramInt3 > paramInt2 * 2)
      {
        localLayoutParams.leftMargin = (paramInt2 - i / 2);
        return;
      }
      if (paramInt3 > (paramInt4 - paramInt2) * 2)
      {
        localLayoutParams.leftMargin = (paramInt2 + paramInt3 - paramInt4 - i / 2);
        return;
      }
      localLayoutParams.addRule(14);
      return;
    }
    localLayoutParams.addRule(14);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (this.b)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131755041);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, null));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131370895));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362991));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    super.b(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(aakl paramaakl)
  {
    this.jdField_a_of_type_Aakl = paramaakl;
  }
  
  public void a(aako paramaako)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramaako);
    String str = paramaako.b();
    Drawable localDrawable = paramaako.a();
    if (this.jdField_a_of_type_Int != 0)
    {
      localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject1).setBackgroundResource(2130839714);
      localObject2 = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      ((LinearLayout.LayoutParams)localObject2).setMargins(AIOUtils.dp2px(15.0F, ((ImageView)localObject1).getResources()), 0, AIOUtils.dp2px(15.0F, ((ImageView)localObject1).getResources()), 0);
      this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    Object localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559185, null);
    Object localObject2 = (ImageView)((View)localObject1).findViewById(2131370901);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131370913);
    if (localDrawable != null)
    {
      ((ImageView)localObject2).setImageDrawable(localDrawable);
      if (str == null) {
        break label267;
      }
      if (nwn.a(str) <= 18) {
        break label258;
      }
      localTextView.setText(nwn.a(str, 18, "..."));
    }
    for (;;)
    {
      ((View)localObject1).setOnClickListener(new aakq(this, paramaako.c(), paramaako.a()));
      ((View)localObject1).setFocusable(true);
      ((View)localObject1).setClickable(true);
      paramaako = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      paramaako.gravity = 17;
      ((View)localObject1).setLayoutParams(paramaako);
      this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1);
      this.jdField_a_of_type_Int += 1;
      return;
      ((ImageView)localObject2).setVisibility(8);
      break;
      label258:
      localTextView.setText(str);
      continue;
      label267:
      localTextView.setVisibility(8);
    }
  }
  
  public void a(View paramView)
  {
    a();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    this.jdField_a_of_type_AndroidViewView.measure(-2, -2);
    int i = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int k = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getWidth();
    int m = arrayOfInt[0];
    int n = (paramView.getWidth() - i) / 2;
    int i1 = localRect.top;
    a(paramView.getWidth(), localRect.centerX(), i, k);
    a(k, localRect.centerX(), true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, m + n, i1 - j - 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aakp
 * JD-Core Version:    0.7.0.1
 */