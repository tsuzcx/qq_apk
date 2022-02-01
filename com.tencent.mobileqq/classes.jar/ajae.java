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

public class ajae
  extends aiyz
  implements View.OnClickListener
{
  private boolean a;
  
  public ajae(Context paramContext, QQAppInterface paramQQAppInterface, ajav paramajav, ajbn paramajbn)
  {
    super(paramContext, paramQQAppInterface, paramajav, paramajbn);
  }
  
  public View a(int paramInt, View paramView)
  {
    ajaf localajaf;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajaf)))
    {
      localajaf = new ajaf();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561304, null);
      localajaf.a = ((LinearLayout)paramView.findViewById(2131365142));
      localajaf.b = ((LinearLayout)paramView.findViewById(2131365137));
      localObject = (ThemeImageView)paramView.findViewById(2131366166);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(blfw.b);
      paramView.setTag(localajaf);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt = ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080) - ViewUtils.dip2px(80.0F);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      a(paramView, paramInt);
      localajaf.a.setVisibility(8);
      localajaf.b.setVisibility(0);
      return paramView;
      localajaf = (ajaf)paramView.getTag();
    }
    a(paramView, paramInt);
    localajaf.a.setVisibility(0);
    localajaf.b.setVisibility(8);
    return paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajae
 * JD-Core Version:    0.7.0.1
 */