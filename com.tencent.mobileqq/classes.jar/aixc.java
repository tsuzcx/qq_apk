import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;

public class aixc
  extends ContentObserver
{
  private ContentResolver jdField_a_of_type_AndroidContentContentResolver;
  
  public aixc(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, Handler paramHandler)
  {
    super(paramHandler);
    this.jdField_a_of_type_AndroidContentContentResolver = paramTroopAvatarWallPreviewActivity.getContentResolver();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContentResolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContentResolver.unregisterContentObserver(this);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    if (Settings.System.getInt(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getContentResolver(), "accelerometer_rotation", -1) == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.setRequestedOrientation(4);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.setRequestedOrientation(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixc
 * JD-Core Version:    0.7.0.1
 */