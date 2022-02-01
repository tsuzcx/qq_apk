import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment;
import com.tencent.mobileqq.app.face.FaceDecoder;

public class ajgv
  extends RecyclerView.OnScrollListener
{
  public ajgv(TroopSuspiciousFragment paramTroopSuspiciousFragment) {}
  
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
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      if (paramInt == 0) {
        break label94;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
    }
    label94:
    while (!this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgv
 * JD-Core Version:    0.7.0.1
 */