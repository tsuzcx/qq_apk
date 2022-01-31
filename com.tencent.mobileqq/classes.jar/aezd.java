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

public class aezd
  extends aeyf
  implements View.OnClickListener
{
  private boolean a;
  
  public aezd(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
  }
  
  public View a(int paramInt, View paramView)
  {
    aeze localaeze;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof aeze)))
    {
      localaeze = new aeze();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495341, null);
      localaeze.a = ((LinearLayout)paramView.findViewById(2131299117));
      localaeze.b = ((LinearLayout)paramView.findViewById(2131299112));
      localObject = (ThemeImageView)paramView.findViewById(2131300066);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(beog.b);
      paramView.setTag(localaeze);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt = ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766) - bajq.a(80.0F);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      a(paramView, paramInt);
      localaeze.a.setVisibility(8);
      localaeze.b.setVisibility(0);
      return paramView;
      localaeze = (aeze)paramView.getTag();
    }
    a(paramView, paramInt);
    localaeze.a.setVisibility(0);
    localaeze.b.setVisibility(8);
    return paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezd
 * JD-Core Version:    0.7.0.1
 */