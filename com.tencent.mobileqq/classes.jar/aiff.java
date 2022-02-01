import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ThemeImageView;

public class aiff
  extends aiea
  implements View.OnClickListener
{
  private boolean a;
  
  public aiff(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
  }
  
  public View a(int paramInt, View paramView)
  {
    aifg localaifg;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof aifg)))
    {
      localaifg = new aifg();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561243, null);
      localaifg.a = ((LinearLayout)paramView.findViewById(2131365058));
      localaifg.b = ((LinearLayout)paramView.findViewById(2131365053));
      localObject = (ThemeImageView)paramView.findViewById(2131366065);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(bjuk.b);
      paramView.setTag(localaifg);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt = ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076) - ViewUtils.dip2px(80.0F);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      a(paramView, paramInt);
      localaifg.a.setVisibility(8);
      localaifg.b.setVisibility(0);
      return paramView;
      localaifg = (aifg)paramView.getTag();
    }
    a(paramView, paramInt);
    localaifg.a.setVisibility(0);
    localaifg.b.setVisibility(8);
    return paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiff
 * JD-Core Version:    0.7.0.1
 */