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

public class afkr
  extends afjt
  implements View.OnClickListener
{
  private boolean a;
  
  public afkr(Context paramContext, QQAppInterface paramQQAppInterface, aipn paramaipn, atza paramatza)
  {
    super(paramContext, paramQQAppInterface, paramaipn, paramatza);
  }
  
  public View a(int paramInt, View paramView)
  {
    afks localafks;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof afks)))
    {
      localafks = new afks();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560918, null);
      localafks.a = ((LinearLayout)paramView.findViewById(2131364676));
      localafks.b = ((LinearLayout)paramView.findViewById(2131364671));
      localObject = (ThemeImageView)paramView.findViewById(2131365662);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(bfwr.b);
      paramView.setTag(localafks);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt = ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865) - bbll.a(80.0F);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      a(paramView, paramInt);
      localafks.a.setVisibility(8);
      localafks.b.setVisibility(0);
      return paramView;
      localafks = (afks)paramView.getTag();
    }
    a(paramView, paramInt);
    localafks.a.setVisibility(0);
    localafks.b.setVisibility(8);
    return paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkr
 * JD-Core Version:    0.7.0.1
 */