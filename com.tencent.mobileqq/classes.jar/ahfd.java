import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.widget.ImageView;
import com.tencent.mobileqq.util.FaceDecoder;

class ahfd
  extends RecyclerView.OnScrollListener
{
  ahfd(ahfc paramahfc) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    ahfc.a(this.a, paramInt);
    if (ahfc.a(this.a) == 0)
    {
      if (ahfc.a(this.a).a()) {
        ahfc.a(this.a).b();
      }
      int i = ahfc.a(this.a).getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        paramRecyclerView = ahfc.a(this.a).getChildAt(paramInt);
        paramRecyclerView = (ahff)ahfc.a(this.a).getChildViewHolder(paramRecyclerView);
        ahff.a(paramRecyclerView).setImageBitmap(ahfc.a(this.a, ahff.a(paramRecyclerView)));
        paramInt += 1;
      }
    }
    ahfc.a(this.a).a();
    ahfc.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfd
 * JD-Core Version:    0.7.0.1
 */