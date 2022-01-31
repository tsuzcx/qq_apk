import android.os.Handler;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ajsn
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  
  public ajsn(VoicePlayer paramVoicePlayer) {}
  
  public void run()
  {
    if ((VoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer) == 4) || (VoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer) == 5) || (VoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer) == 6) || (VoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer) == 8)) {
      this.jdField_a_of_type_Int = 0;
    }
    do
    {
      return;
      if (VoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer) == 3)
      {
        this.jdField_a_of_type_Int = VoicePlayer.b(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer);
        return;
      }
    } while (VoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer) == null);
    int k = VoicePlayer.c(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer);
    int i = VoicePlayer.b(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer);
    if (i < this.jdField_a_of_type_Int) {
      i = this.jdField_a_of_type_Int;
    }
    for (;;)
    {
      int j = k;
      if (this.jdField_a_of_type_Int != 0)
      {
        j = k;
        if (this.jdField_a_of_type_Int == i)
        {
          j = k;
          if (this.jdField_a_of_type_Int > k - 200)
          {
            QLog.d("Q.profilecard.VoicePlayer", 2, "change duration from " + i + " to " + i);
            j = i;
          }
        }
      }
      if (i > this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = i;
      }
      Iterator localIterator = VoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer).iterator();
      while (localIterator.hasNext()) {
        ((VoicePlayer.VoicePlayerListener)localIterator.next()).a(VoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer), j, i);
      }
      if (VoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer) == null) {
        break;
      }
      VoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer).postDelayed(this, 50L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ajsn
 * JD-Core Version:    0.7.0.1
 */