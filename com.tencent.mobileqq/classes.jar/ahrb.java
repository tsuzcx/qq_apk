import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;

public class ahrb
  extends ahrd
{
  public ahrb(CommonRefreshLayout paramCommonRefreshLayout)
  {
    super(paramCommonRefreshLayout);
  }
  
  public void a()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof ahri)) && ((ahre.a(CommonRefreshLayout.a(this.a))) || (ahre.h(CommonRefreshLayout.a(this.a)))))
    {
      CommonRefreshLayout.a(this.a).setVisibility(0);
      ((ahri)CommonRefreshLayout.a(this.a)).a();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof ahri)) && (ahre.c(CommonRefreshLayout.a(this.a))))
    {
      if (CommonRefreshLayout.a(this.a).getVisibility() != 0) {
        CommonRefreshLayout.a(this.a).setVisibility(0);
      }
      ((ahri)CommonRefreshLayout.a(this.a)).a(paramInt, paramBoolean1, paramBoolean2);
    }
  }
  
  public void b()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof ahri)) && (ahre.e(CommonRefreshLayout.a(this.a)))) {
      ((ahri)CommonRefreshLayout.a(this.a)).b();
    }
  }
  
  public void c()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && (ahre.b(CommonRefreshLayout.a(this.a))))
    {
      if ((CommonRefreshLayout.a(this.a) instanceof ahrh)) {
        ((ahrh)CommonRefreshLayout.a(this.a)).c();
      }
      if (CommonRefreshLayout.a(this.a) != null) {
        CommonRefreshLayout.a(this.a).a();
      }
    }
  }
  
  public void d()
  {
    if ((CommonRefreshLayout.a(this.a) != null) && ((CommonRefreshLayout.a(this.a) instanceof ahri)) && ((ahre.a(CommonRefreshLayout.a(this.a))) || (ahre.h(CommonRefreshLayout.a(this.a))))) {
      ((ahri)CommonRefreshLayout.a(this.a)).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrb
 * JD-Core Version:    0.7.0.1
 */