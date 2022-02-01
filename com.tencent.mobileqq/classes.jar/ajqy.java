import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;

public class ajqy
  extends RecyclerView.OnScrollListener
{
  public ajqy(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    this.a.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (((paramRecyclerView instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition() + 1 == TroopSuspiciousFragment.a(this.a).getItemCount())) {
        TroopSuspiciousFragment.a(this.a);
      }
    }
    if (this.a.jdField_a_of_type_Aoof != null)
    {
      if (paramInt == 0) {
        break label94;
      }
      this.a.jdField_a_of_type_Aoof.a();
      this.a.jdField_a_of_type_Aoof.c();
    }
    label94:
    while (!this.a.jdField_a_of_type_Aoof.a()) {
      return;
    }
    this.a.jdField_a_of_type_Aoof.b();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqy
 * JD-Core Version:    0.7.0.1
 */