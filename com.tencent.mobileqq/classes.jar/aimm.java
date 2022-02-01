import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.app.face.FaceDecoder;

public class aimm
  extends RecyclerView.OnScrollListener
{
  public aimm(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    this.a.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager)) {
        ((LinearLayoutManager)paramRecyclerView).findLastVisibleItemPosition();
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      if (paramInt == 0) {
        break label73;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
    }
    label73:
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
 * Qualified Name:     aimm
 * JD-Core Version:    0.7.0.1
 */