import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;
import com.tencent.mobileqq.util.FaceDecoder;

class agrb
  extends RecyclerView.OnScrollListener
{
  agrb(agra paramagra) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    agra.a(this.a, paramInt);
    if (agra.a(this.a) == 0)
    {
      if (agra.a(this.a).a()) {
        agra.a(this.a).b();
      }
      int i = agra.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = agra.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (agrd)agra.a(this.a).getChildViewHolder(paramRecyclerView);
        agrd.a(paramRecyclerView).setImageBitmap(agra.a(this.a, agrd.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    agra.a(this.a).a();
    agra.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agrb
 * JD-Core Version:    0.7.0.1
 */