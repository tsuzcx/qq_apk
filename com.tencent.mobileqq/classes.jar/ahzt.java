import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahzt
{
  private ahzw jdField_a_of_type_Ahzw;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private arqb jdField_a_of_type_Arqb = new ahzv(this);
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private ImageView e;
  
  public ahzt(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramViewGroup;
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560621, null, false);
    Object localObject = paramViewGroup;
    if (!(paramViewGroup instanceof RelativeLayout))
    {
      localObject = new RelativeLayout(paramContext);
      paramViewGroup.addView((View)localObject, new RelativeLayout.LayoutParams(-1, -1));
    }
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(12);
    ((ViewGroup)localObject).addView(this.jdField_b_of_type_AndroidViewView, paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365546));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365543));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365548));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365544));
    this.e = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365542));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131365539);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Arqb);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Arqb);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Arqb);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_Arqb);
    this.e.setOnClickListener(this.jdField_a_of_type_Arqb);
    b();
  }
  
  private void a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramView);
    for (;;)
    {
      if (!localArrayList.isEmpty())
      {
        paramView = (View)localArrayList.remove(0);
        if ((paramView instanceof ListView)) {
          this.jdField_d_of_type_AndroidViewView = paramView;
        }
      }
      else
      {
        return;
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          localArrayList.add(paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  private boolean a()
  {
    if (!bdee.d(this.jdField_a_of_type_AndroidContentContext))
    {
      arni.a(this.jdField_a_of_type_AndroidContentContext.getString(2131693415));
      return false;
    }
    return true;
  }
  
  public int a()
  {
    return aekt.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  public void a()
  {
    if (this.jdField_d_of_type_AndroidViewView == null)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      if (this.jdField_d_of_type_AndroidViewView == null) {
        this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    c();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
      return;
    case 2: 
      this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
      return;
    case 3: 
      this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
      return;
    case 4: 
      this.e.setEnabled(paramBoolean);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
  }
  
  public void a(ahzw paramahzw)
  {
    this.jdField_a_of_type_Ahzw = paramahzw;
  }
  
  public void a(List<Integer> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        default: 
          break;
        case 1: 
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          break;
        case 2: 
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          break;
        case 3: 
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          break;
        case 4: 
          this.e.setVisibility(0);
          break;
        case 5: 
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(1, paramBoolean);
    a(2, paramBoolean);
    a(3, paramBoolean);
    a(4, paramBoolean);
    a(5, paramBoolean);
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
  }
  
  @TargetApi(19)
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    if (this.jdField_d_of_type_AndroidViewView == null) {
      return;
    }
    if (!ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130843786);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379417));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_d_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ahzu(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzt
 * JD-Core Version:    0.7.0.1
 */