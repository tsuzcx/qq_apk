import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;

class aiex
  extends onv
{
  aiex(aido paramaido) {}
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (aido.a(this.a).getVisibility() != 0))
    {
      if (mbl.a().a(this.a.app.getCurrentAccountUin()))
      {
        aido.b(this.a).setVisibility(0);
        aido.c(this.a).setOnClickListener(this.a);
        this.a.mCustomTitleView.setRight2Icon(2130847096, 2130847097);
      }
    }
    else {
      return;
    }
    aido.d(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiex
 * JD-Core Version:    0.7.0.1
 */