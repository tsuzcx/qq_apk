import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;
import com.tencent.mobileqq.util.FaceDecoder;

class ahju
  extends RecyclerView.OnScrollListener
{
  ahju(ahjt paramahjt) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    ahjt.a(this.a, paramInt);
    if (ahjt.a(this.a) == 0)
    {
      if (ahjt.a(this.a).a()) {
        ahjt.a(this.a).b();
      }
      int i = ahjt.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = ahjt.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (ahjw)ahjt.a(this.a).getChildViewHolder(paramRecyclerView);
        ahjw.a(paramRecyclerView).setImageBitmap(ahjt.a(this.a, ahjw.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    ahjt.a(this.a).a();
    ahjt.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahju
 * JD-Core Version:    0.7.0.1
 */