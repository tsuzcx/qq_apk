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

public class ahhw
  extends ahgy
  implements View.OnClickListener
{
  private boolean a;
  
  public ahhw(Context paramContext, QQAppInterface paramQQAppInterface, akgy paramakgy, avqe paramavqe)
  {
    super(paramContext, paramQQAppInterface, paramakgy, paramavqe);
  }
  
  public View a(int paramInt, View paramView)
  {
    ahhx localahhx;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ahhx)))
    {
      localahhx = new ahhx();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561101, null);
      localahhx.a = ((LinearLayout)paramView.findViewById(2131364755));
      localahhx.b = ((LinearLayout)paramView.findViewById(2131364750));
      localObject = (ThemeImageView)paramView.findViewById(2131365746);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(bhxo.b);
      paramView.setTag(localahhx);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      localObject = new Rect();
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt = ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914) - bdkf.a(80.0F);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      a(paramView, paramInt);
      localahhx.a.setVisibility(8);
      localahhx.b.setVisibility(0);
      return paramView;
      localahhx = (ahhx)paramView.getTag();
    }
    a(paramView, paramInt);
    localahhx.a.setVisibility(0);
    localahhx.b.setVisibility(8);
    return paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhw
 * JD-Core Version:    0.7.0.1
 */