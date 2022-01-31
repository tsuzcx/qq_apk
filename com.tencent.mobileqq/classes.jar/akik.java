import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class akik
  extends akho
  implements ayhu, bhtv
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_b_of_type_Boolean;
  
  public akik(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, List<ayhr> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramList);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener1;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = paramOnClickListener2;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramTextView.getContext().getResources().getDrawable(2130841432);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      ThemeUtil.setThemeFilter(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ThemeUtil.curThemeId);
      paramTextView.setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      return;
    }
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void a()
  {
    super.a();
  }
  
  protected boolean a(akhp paramakhp)
  {
    boolean bool2 = super.a(paramakhp);
    boolean bool1 = bool2;
    if ((paramakhp instanceof akil))
    {
      paramakhp = (akil)paramakhp;
      if ((bool2) && (!paramakhp.jdField_a_of_type_Boolean)) {
        bool1 = true;
      }
    }
    else
    {
      return bool1;
    }
    return false;
  }
  
  public void c()
  {
    super.b();
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if (i > 5) {
      return 5;
    }
    return i;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558892, paramViewGroup, false);
      paramViewGroup = new akil();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368809));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368925));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368787));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378896));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131375906);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setContentDescription(alud.a(2131702946));
      ayif.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378881));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379072));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131368811));
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131378980);
      paramView.setTag(paramViewGroup);
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = (ayhr)getItem(paramInt);
      if (localObject1 != null) {
        break;
      }
      QLog.w("ContactsSearchResultAdapter", 1, "getView entity is null.");
      return paramView;
      paramViewGroup = (akil)paramView.getTag();
    }
    Object localObject2 = ((ayhr)localObject1).c();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    if (String.valueOf(9954L).equals(((ayhr)localObject1).d())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, bool1);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((ayhr)localObject1).b());
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(((ayhr)localObject1).b());
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText(((ayhr)localObject1).a());
      paramViewGroup.jdField_a_of_type_JavaLangString = ((ayhr)localObject1).d();
      paramViewGroup.jdField_a_of_type_Int = ((ayhr)localObject1).c();
      if ((localObject1 instanceof aygz))
      {
        SearchHistory localSearchHistory = ((aygz)localObject1).a();
        bool1 = bool2;
        if (localSearchHistory.type != 56938)
        {
          if (localSearchHistory.type != 56942) {
            break label524;
          }
          bool1 = bool2;
        }
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_Boolean = bool1;
        if (paramViewGroup.jdField_a_of_type_Boolean)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841744);
          paramViewGroup.d.setVisibility(0);
          paramViewGroup.d.setText(bdgc.a((String)localObject2));
          label386:
          localObject2 = ((ayhr)localObject1).a();
          if (localObject2 != null) {
            break label561;
          }
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          label407:
          if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
          {
            paramView.setTag(-1, Integer.valueOf(paramInt));
            paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null)
          {
            paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(-1, Long.valueOf(((SearchHistory)((ayhr)localObject1).a()).getId()));
            paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          }
          localObject1 = paramView.findViewById(2131365369);
          if (paramInt != getCount() - 1) {
            break label581;
          }
          ((View)localObject1).setVisibility(8);
        }
        for (;;)
        {
          if (paramViewGroup.jdField_b_of_type_AndroidViewView == null) {
            break label588;
          }
          if (!ayif.a(paramViewGroup.jdField_a_of_type_JavaLangString)) {
            break label590;
          }
          paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
          return paramView;
          label524:
          bool1 = false;
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramViewGroup.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_a_of_type_Int));
          paramViewGroup.d.setVisibility(8);
          break label386;
          label561:
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          break label407;
          label581:
          ((View)localObject1).setVisibility(0);
        }
        label588:
        break;
        label590:
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
        return paramView;
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akik
 * JD-Core Version:    0.7.0.1
 */