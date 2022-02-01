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

public class aizn
  extends aiyi
  implements View.OnClickListener
{
  private boolean a;
  
  public aizn(Context paramContext, QQAppInterface paramQQAppInterface, ajae paramajae, ajax paramajax)
  {
    super(paramContext, paramQQAppInterface, paramajae, paramajax);
  }
  
  public View a(int paramInt, View paramView)
  {
    aizo localaizo;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof aizo)))
    {
      localaizo = new aizo();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561330, null);
      localaizo.a = ((LinearLayout)paramView.findViewById(2131364984));
      localaizo.b = ((LinearLayout)paramView.findViewById(2131364979));
      localObject = (ThemeImageView)paramView.findViewById(2131365989);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(bkpg.b);
      paramView.setTag(localaizo);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt = ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998) - bgtn.a(80.0F);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      a(paramView, paramInt);
      localaizo.a.setVisibility(8);
      localaizo.b.setVisibility(0);
      return paramView;
      localaizo = (aizo)paramView.getTag();
    }
    a(paramView, paramInt);
    localaizo.a.setVisibility(0);
    localaizo.b.setVisibility(8);
    return paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizn
 * JD-Core Version:    0.7.0.1
 */