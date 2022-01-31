import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;

public class aftj
  extends aftl
{
  public aftj(CommonRefreshLayout paramCommonRefreshLayout)
  {
    super(paramCommonRefreshLayout);
  }
  
  public void a()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof aftq)) && ((aftm.a(CommonRefreshLayout.a(this.a))) || (aftm.h(CommonRefreshLayout.a(this.a)))))
    {
      CommonRefreshLayout.a(this.a).setVisibility(0);
      ((aftq)CommonRefreshLayout.a(this.a)).a();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof aftq)) && (aftm.c(CommonRefreshLayout.a(this.a))))
    {
      if (CommonRefreshLayout.a(this.a).getVisibility() != 0) {
        CommonRefreshLayout.a(this.a).setVisibility(0);
      }
      ((aftq)CommonRefreshLayout.a(this.a)).a(paramInt, paramBoolean1, paramBoolean2);
    }
  }
  
  public void b()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof aftq)) && (aftm.e(CommonRefreshLayout.a(this.a)))) {
      ((aftq)CommonRefreshLayout.a(this.a)).b();
    }
  }
  
  public void c()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && (aftm.b(CommonRefreshLayout.a(this.a))))
    {
      if ((CommonRefreshLayout.a(this.a) instanceof aftp)) {
        ((aftp)CommonRefreshLayout.a(this.a)).c();
      }
      if (CommonRefreshLayout.a(this.a) != null) {
        CommonRefreshLayout.a(this.a).a();
      }
    }
  }
  
  public void d()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof aftq)) && ((aftm.a(CommonRefreshLayout.a(this.a))) || (aftm.h(CommonRefreshLayout.a(this.a))))) {
      ((aftq)CommonRefreshLayout.a(this.a)).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aftj
 * JD-Core Version:    0.7.0.1
 */