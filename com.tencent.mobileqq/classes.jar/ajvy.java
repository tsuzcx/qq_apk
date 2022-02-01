import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;

public class ajvy
  extends ajwa
{
  public ajvy(CommonRefreshLayout paramCommonRefreshLayout)
  {
    super(paramCommonRefreshLayout);
  }
  
  public void a()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof ajwf)) && ((ajwb.a(CommonRefreshLayout.a(this.a))) || (ajwb.h(CommonRefreshLayout.a(this.a)))))
    {
      CommonRefreshLayout.a(this.a).setVisibility(0);
      ((ajwf)CommonRefreshLayout.a(this.a)).a();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof ajwf)) && (ajwb.c(CommonRefreshLayout.a(this.a))))
    {
      if (CommonRefreshLayout.a(this.a).getVisibility() != 0) {
        CommonRefreshLayout.a(this.a).setVisibility(0);
      }
      ((ajwf)CommonRefreshLayout.a(this.a)).a(paramInt, paramBoolean1, paramBoolean2);
    }
  }
  
  public void b()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof ajwf)) && (ajwb.e(CommonRefreshLayout.a(this.a)))) {
      ((ajwf)CommonRefreshLayout.a(this.a)).b();
    }
  }
  
  public void c()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && (ajwb.b(CommonRefreshLayout.a(this.a))))
    {
      if ((CommonRefreshLayout.a(this.a) instanceof ajwe)) {
        ((ajwe)CommonRefreshLayout.a(this.a)).c();
      }
      if (CommonRefreshLayout.a(this.a) != null) {
        CommonRefreshLayout.a(this.a).a();
      }
    }
  }
  
  public void d()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof ajwf)) && ((ajwb.a(CommonRefreshLayout.a(this.a))) || (ajwb.h(CommonRefreshLayout.a(this.a))))) {
      ((ajwf)CommonRefreshLayout.a(this.a)).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvy
 * JD-Core Version:    0.7.0.1
 */