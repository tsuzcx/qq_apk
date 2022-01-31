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
import com.tencent.widget.ThemeImageView;

public class afkt
  extends afjv
  implements View.OnClickListener
{
  private boolean a;
  
  public afkt(Context paramContext, QQAppInterface paramQQAppInterface, aipp paramaipp, atyy paramatyy)
  {
    super(paramContext, paramQQAppInterface, paramaipp, paramatyy);
  }
  
  public View a(int paramInt, View paramView)
  {
    afku localafku;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof afku)))
    {
      localafku = new afku();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560919, null);
      localafku.a = ((LinearLayout)paramView.findViewById(2131364677));
      localafku.b = ((LinearLayout)paramView.findViewById(2131364672));
      localObject = (ThemeImageView)paramView.findViewById(2131365663);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(bfwa.b);
      paramView.setTag(localafku);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt = ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865) - bbkx.a(80.0F);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      a(paramView, paramInt);
      localafku.a.setVisibility(8);
      localafku.b.setVisibility(0);
      return paramView;
      localafku = (afku)paramView.getTag();
    }
    a(paramView, paramInt);
    localafku.a.setVisibility(0);
    localafku.b.setVisibility(8);
    return paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkt
 * JD-Core Version:    0.7.0.1
 */