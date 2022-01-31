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

public class ahml
  extends ahln
  implements View.OnClickListener
{
  private boolean a;
  
  public ahml(Context paramContext, QQAppInterface paramQQAppInterface, akln paramakln, avun paramavun)
  {
    super(paramContext, paramQQAppInterface, paramakln, paramavun);
  }
  
  public View a(int paramInt, View paramView)
  {
    ahmm localahmm;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahmm)))
    {
      localahmm = new ahmm();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561119, null);
      localahmm.a = ((LinearLayout)paramView.findViewById(2131364756));
      localahmm.b = ((LinearLayout)paramView.findViewById(2131364751));
      localObject = (ThemeImageView)paramView.findViewById(2131365748);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(bibv.b);
      paramView.setTag(localahmm);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt = ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914) - bdoo.a(80.0F);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      a(paramView, paramInt);
      localahmm.a.setVisibility(8);
      localahmm.b.setVisibility(0);
      return paramView;
      localahmm = (ahmm)paramView.getTag();
    }
    a(paramView, paramInt);
    localahmm.a.setVisibility(0);
    localahmm.b.setVisibility(8);
    return paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahml
 * JD-Core Version:    0.7.0.1
 */