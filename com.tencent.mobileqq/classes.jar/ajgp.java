import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;

public class ajgp
  implements Runnable
{
  public ajgp(TroopGiftActionButton paramTroopGiftActionButton, String paramString) {}
  
  public void run()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = new AnimationDrawable();
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i < 7) {
        localObject = String.format("%sInteractGiftButton/image_0%d.png", new Object[] { TroopGiftUtil.a(this.jdField_a_of_type_JavaLangString), Integer.valueOf(i) });
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(new BitmapDrawable(BitmapFactory.decodeFile((String)localObject)), 50);
        label82:
        i += 1;
        continue;
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(true);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.addView(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.jdField_a_of_type_AndroidOsHandler.postDelayed(new ajgq(this), 350L);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label82;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajgp
 * JD-Core Version:    0.7.0.1
 */