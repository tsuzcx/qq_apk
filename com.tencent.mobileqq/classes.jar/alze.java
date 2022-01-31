import com.tencent.av.switchface.SwitchFaceProcessorItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.module_switchface.SwitchFaceProcessor;
import java.util.List;

public class alze
  implements Runnable
{
  public alze(SwitchFaceProcessor paramSwitchFaceProcessor, List paramList1, int paramInt1, int paramInt2, List paramList2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SwitchFaceProcessor", 2, "WL_DEBUG process run start");
    }
    SwitchFaceProcessor.a(this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor)[0].a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    SwitchFaceProcessor.a(this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor)[1].a(this.jdField_b_of_type_JavaUtilList, this.c, this.d);
    int i = 0;
    while (i < SwitchFaceProcessor.a(this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor).length)
    {
      SwitchFaceProcessor.a(this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor)[i].a();
      i += 1;
    }
    SwitchFaceProcessor.a(this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor);
    if (QLog.isColorLevel())
    {
      i = j;
      while (i < SwitchFaceProcessor.a(this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor).length)
      {
        QLog.d("SwitchFaceProcessor", 2, "WL_DEBUG process run mSwitchFaceItem[" + i + "].mUser = (" + SwitchFaceProcessor.a(this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor)[i].a + ", " + SwitchFaceProcessor.a(this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor)[i].b + ", " + SwitchFaceProcessor.a(this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor)[i].c + ")");
        QLog.d("SwitchFaceProcessor", 2, "WL_DEBUG process run mSwitchFaceItem[" + i + "].mDiff = (" + SwitchFaceProcessor.a(this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor)[i].d + ", " + SwitchFaceProcessor.a(this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor)[i].e + ", " + SwitchFaceProcessor.a(this.jdField_a_of_type_ComTencentTtpicModule_switchfaceSwitchFaceProcessor)[i].f + ")");
        i += 1;
      }
      QLog.d("SwitchFaceProcessor", 2, "WL_DEBUG process run end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alze
 * JD-Core Version:    0.7.0.1
 */