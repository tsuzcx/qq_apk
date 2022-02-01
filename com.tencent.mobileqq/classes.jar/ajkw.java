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

public class ajkw
  extends ajjr
  implements View.OnClickListener
{
  private boolean a;
  
  public ajkw(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
  }
  
  public View a(int paramInt, View paramView)
  {
    ajkx localajkx;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ajkx)))
    {
      localajkx = new ajkx();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561368, null);
      localajkx.a = ((LinearLayout)paramView.findViewById(2131365031));
      localajkx.b = ((LinearLayout)paramView.findViewById(2131365026));
      localObject = (ThemeImageView)paramView.findViewById(2131366035);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(blqj.b);
      paramView.setTag(localajkx);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt = ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011) - bhtq.a(80.0F);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      a(paramView, paramInt);
      localajkx.a.setVisibility(8);
      localajkx.b.setVisibility(0);
      return paramView;
      localajkx = (ajkx)paramView.getTag();
    }
    a(paramView, paramInt);
    localajkx.a.setVisibility(0);
    localajkx.b.setVisibility(8);
    return paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkw
 * JD-Core Version:    0.7.0.1
 */