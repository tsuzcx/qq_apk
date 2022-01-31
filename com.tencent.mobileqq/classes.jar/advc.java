import android.util.SparseArray;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class advc
  implements Runnable
{
  public advc(EmoticonManager paramEmoticonManager, EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "recommendresp is null");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend);
    int i = this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.int32_exposure_num.get();
    if (i > 0) {
      EmoticonManager.jdField_a_of_type_Int = i;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveAndUpdateRecommendEmosInfo maxexposenum = " + EmoticonManager.jdField_a_of_type_Int);
    }
    List localList = this.jdField_a_of_type_ComTencentPbEmosmEmosmPb$SubCmd0x5RspBQRecommend.st_new_tab_info.get();
    if ((localList != null) && (QLog.isColorLevel())) {
      QLog.d("EmoticonManager", 2, "saveAndUpdateRecommendEmosInfo recommend emotion num = " + localList.size());
    }
    EmoticonManager.b(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     advc
 * JD-Core Version:    0.7.0.1
 */