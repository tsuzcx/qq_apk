import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class akwx
  implements AbsListView.OnScrollListener
{
  public akwx(SlideDetectListView paramSlideDetectListView) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.a.c = paramInt;
    if (SlideDetectListView.a(this.a) != null) {
      SlideDetectListView.a(this.a).a(paramAbsListView, paramInt);
    }
    if (SlideDetectListView.b(this.a) != null) {
      SlideDetectListView.b(this.a).a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (SlideDetectListView.a(this.a) != null) {
      SlideDetectListView.a(this.a).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (SlideDetectListView.b(this.a) != null) {
      SlideDetectListView.b(this.a).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akwx
 * JD-Core Version:    0.7.0.1
 */