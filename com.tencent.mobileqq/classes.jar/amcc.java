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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class amcc
  extends ambn
  implements bbgs, bkhe
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private boolean jdField_b_of_type_Boolean;
  
  public amcc(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, List<bbgl> paramList, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2, boolean paramBoolean)
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
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramTextView.getContext().getResources().getDrawable(2130841741);
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
  
  protected boolean a(ambo paramambo)
  {
    boolean bool2 = super.a(paramambo);
    boolean bool1 = bool2;
    if ((paramambo instanceof amcd))
    {
      paramambo = (amcd)paramambo;
      if ((bool2) && (!paramambo.jdField_a_of_type_Boolean)) {
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
    amcd localamcd;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558960, paramViewGroup, false);
      localamcd = new amcd();
      localamcd.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369156));
      localamcd.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369301));
      localamcd.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369130));
      localamcd.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379779));
      localamcd.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376645);
      localamcd.jdField_a_of_type_AndroidViewView.setContentDescription(anni.a(2131701353));
      bbhd.a(localamcd.jdField_a_of_type_AndroidWidgetTextView);
      localamcd.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379763));
      localamcd.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379987));
      localamcd.d = ((TextView)paramView.findViewById(2131369158));
      localamcd.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131379878);
      paramView.setTag(localamcd);
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = (bbgl)getItem(paramInt);
      if (localObject1 != null) {
        break;
      }
      QLog.w("ContactsSearchResultAdapter", 1, "getView entity is null.");
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localamcd = (amcd)paramView.getTag();
    }
    Object localObject2 = ((bbgl)localObject1).c();
    localamcd.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    if (String.valueOf(9954L).equals(((bbgl)localObject1).d())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a(localamcd.jdField_a_of_type_AndroidWidgetTextView, bool1);
      localamcd.jdField_b_of_type_AndroidWidgetTextView.setText(((bbgl)localObject1).b());
      localamcd.jdField_b_of_type_AndroidWidgetImageView.setImageResource(((bbgl)localObject1).b());
      localamcd.jdField_c_of_type_AndroidWidgetTextView.setText(((bbgl)localObject1).a());
      localamcd.jdField_a_of_type_JavaLangString = ((bbgl)localObject1).d();
      localamcd.jdField_a_of_type_Int = ((bbgl)localObject1).c();
      if ((localObject1 instanceof bbfh))
      {
        SearchHistory localSearchHistory = ((bbfh)localObject1).a();
        bool1 = bool2;
        if (localSearchHistory.type != 56938)
        {
          if (localSearchHistory.type != 56942) {
            break label573;
          }
          bool1 = bool2;
        }
      }
      for (;;)
      {
        label380:
        localamcd.jdField_a_of_type_Boolean = bool1;
        if (localamcd.jdField_a_of_type_Boolean)
        {
          localamcd.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842050);
          localamcd.d.setVisibility(0);
          localamcd.d.setText(bglf.a((String)localObject2));
          label428:
          localObject2 = ((bbgl)localObject1).a();
          if (localObject2 != null) {
            break label614;
          }
          localamcd.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          label450:
          if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
          {
            paramView.setTag(-1, Integer.valueOf(paramInt));
            paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
          if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null)
          {
            localamcd.jdField_a_of_type_AndroidViewView.setTag(-1, Long.valueOf(((SearchHistory)((bbgl)localObject1).a()).getId()));
            localamcd.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          }
          localObject1 = paramView.findViewById(2131365606);
          if (paramInt != getCount() - 1) {
            break label636;
          }
          ((View)localObject1).setVisibility(8);
          label542:
          if (localamcd.jdField_b_of_type_AndroidViewView != null)
          {
            if (!bbhd.a(localamcd.jdField_a_of_type_JavaLangString)) {
              break label645;
            }
            localamcd.jdField_b_of_type_AndroidViewView.setVisibility(0);
          }
        }
        for (;;)
        {
          break;
          label573:
          bool1 = false;
          break label380;
          localamcd.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(localamcd.jdField_a_of_type_JavaLangString, localamcd.jdField_a_of_type_Int));
          localamcd.d.setVisibility(8);
          break label428;
          label614:
          localamcd.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localamcd.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          break label450;
          label636:
          ((View)localObject1).setVisibility(0);
          break label542;
          label645:
          localamcd.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcc
 * JD-Core Version:    0.7.0.1
 */