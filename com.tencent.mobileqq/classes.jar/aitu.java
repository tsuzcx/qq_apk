import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class aitu
  extends AsyncTask<Void, Void, ArrayList<String>>
{
  aitu(aitt paramaitt, List paramList) {}
  
  protected ArrayList<String> a(Void... paramVarArgs)
  {
    return this.jdField_a_of_type_Aitt.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("SDKEmotionSettingManager", 1, " openSetEmotion error pathList = " + paramArrayList);
      aitt.a(this.jdField_a_of_type_Aitt, aitt.a(this.jdField_a_of_type_Aitt), Long.valueOf(aitt.a(this.jdField_a_of_type_Aitt)).longValue(), false, "");
      aitt.a(this.jdField_a_of_type_Aitt);
      return;
    }
    int i = paramArrayList.size();
    bcef.b(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, i + "", "", "", "");
    aitt.a(this.jdField_a_of_type_Aitt).clear();
    aitt.a(this.jdField_a_of_type_Aitt).addAll(paramArrayList);
    this.jdField_a_of_type_Aitt.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitu
 * JD-Core Version:    0.7.0.1
 */