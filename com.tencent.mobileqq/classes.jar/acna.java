import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.mtt.abtestsdk.entity.RomaExpEntity;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import java.util.Iterator;
import java.util.List;

class acna
  implements GetExperimentListener
{
  acna(acmz paramacmz, long paramLong, String paramString) {}
  
  public void getExperimentFailed(int paramInt, String paramString)
  {
    ABTestController.a("ExperimentInfo", "abtest api load exp failed, i:" + paramInt + ", s:" + paramString);
  }
  
  public void getExperimentSucceed(List<RomaExpEntity> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      ABTestController.a("ExperimentInfo", "abtest api load exp failed, list empty");
    }
    for (;;)
    {
      return;
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      ABTestController.a("ExperimentInfo", "abtest api load exp success, size:" + paramList.size() + ", cost:" + (l1 - l2));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RomaExpEntity localRomaExpEntity = (RomaExpEntity)paramList.next();
        if ((localRomaExpEntity != null) && (localRomaExpEntity.getLayerCode().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {
          acmz.a(this.jdField_a_of_type_Acmz, localRomaExpEntity);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acna
 * JD-Core Version:    0.7.0.1
 */