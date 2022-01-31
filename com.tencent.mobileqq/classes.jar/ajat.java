import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.logic.TroopAvatarWallEditCtrl.IGridItemStatusCallBack;
import com.tencent.mobileqq.troop.widget.TroopAvatarWallGalleryAdapter;
import com.tencent.widget.Gallery;
import java.util.List;

public class ajat
  implements TroopAvatarWallEditCtrl.IGridItemStatusCallBack
{
  public ajat(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition() != paramInt) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setSelection(paramInt);
    }
    TroopAvatarWallEditActivity.a(this.a, paramInt);
  }
  
  public void a(String paramString)
  {
    this.a.jdField_a_of_type_JavaUtilList.add(paramString);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    if (this.a.jdField_a_of_type_JavaUtilList.size() > paramInt)
    {
      this.a.jdField_a_of_type_JavaUtilList.remove(paramInt);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajat
 * JD-Core Version:    0.7.0.1
 */