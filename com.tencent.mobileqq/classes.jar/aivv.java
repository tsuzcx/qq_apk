import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import java.util.HashMap;
import java.util.List;

class aivv
  implements aivw
{
  aivv(aivu paramaivu) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    int i = 1;
    aivu localaivu = this.a;
    localaivu.jdField_a_of_type_Int += 1;
    if (paramInt == 0)
    {
      this.a.jdField_a_of_type_JavaUtilHashMap.put(paramPathResult.url, paramPathResult);
      if ((this.a.jdField_a_of_type_Int >= this.a.jdField_a_of_type_JavaUtilList.size()) && (this.a.jdField_a_of_type_Aivx != null))
      {
        paramPathResult = this.a.jdField_a_of_type_Aivx;
        if (!this.a.jdField_a_of_type_Boolean) {
          break label118;
        }
      }
    }
    label118:
    for (paramInt = i;; paramInt = 0)
    {
      paramPathResult.a(paramInt, this.a.jdField_a_of_type_JavaUtilHashMap);
      return;
      this.a.jdField_a_of_type_Boolean = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivv
 * JD-Core Version:    0.7.0.1
 */