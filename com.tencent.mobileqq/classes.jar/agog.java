import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class agog
  extends RecyclerView.OnScrollListener
{
  agog(agof paramagof, PersonalityLabelInfo paramPersonalityLabelInfo) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "onScrollStateChanged newState:" + paramInt);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "onScrolled dx:" + paramInt1 + " dy:" + paramInt2);
    }
    int i;
    int j;
    if (paramInt1 > 0)
    {
      paramRecyclerView = (StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager();
      paramInt2 = paramRecyclerView.getChildCount();
      i = paramRecyclerView.getItemCount();
      j = paramRecyclerView.findLastVisibleItemPositions(null)[0];
      paramRecyclerView = PersonalityLabelGalleryActivity.c(this.jdField_a_of_type_Agof.a).get(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo.id));
      if (paramRecyclerView == null) {
        break label271;
      }
      if (((Integer)paramRecyclerView).intValue() != 1) {
        break label252;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      PersonalityLabelHandler localPersonalityLabelHandler;
      if ((!PersonalityLabelGalleryActivity.b(this.jdField_a_of_type_Agof.a)) && (paramInt1 == 0) && (paramInt2 > 0) && (j >= i - 1))
      {
        PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Agof.a, true);
        QLog.i("PersonalityLabelGalleryActivity", 2, "load more photos");
        localPersonalityLabelHandler = (PersonalityLabelHandler)this.jdField_a_of_type_Agof.a.app.a(112);
        if (!PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Agof.a)) {
          break label257;
        }
      }
      label257:
      for (paramRecyclerView = this.jdField_a_of_type_Agof.a.app.getCurrentAccountUin();; paramRecyclerView = PersonalityLabelGalleryActivity.a(this.jdField_a_of_type_Agof.a))
      {
        localPersonalityLabelHandler.a(paramRecyclerView, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo.id, 20, (byte[])PersonalityLabelGalleryActivity.b(this.jdField_a_of_type_Agof.a).get(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo.id)));
        return;
        label252:
        paramInt1 = 0;
        break;
      }
      label271:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agog
 * JD-Core Version:    0.7.0.1
 */