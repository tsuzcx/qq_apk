import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ajyu
  extends AsyncTask<Void, Void, ArrayList<String>>
{
  ajyu(ajyt paramajyt, List paramList) {}
  
  protected ArrayList<String> a(Void... paramVarArgs)
  {
    return this.jdField_a_of_type_Ajyt.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("SDKEmotionSettingManager", 1, " openSetEmotion error pathList = " + paramArrayList);
      ajyt.a(this.jdField_a_of_type_Ajyt, ajyt.a(this.jdField_a_of_type_Ajyt), Long.valueOf(ajyt.a(this.jdField_a_of_type_Ajyt)).longValue(), false, "");
      ajyt.a(this.jdField_a_of_type_Ajyt);
      return;
    }
    int i = paramArrayList.size();
    bdll.b(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, i + "", "", "", "");
    ajyt.a(this.jdField_a_of_type_Ajyt).clear();
    ajyt.a(this.jdField_a_of_type_Ajyt).addAll(paramArrayList);
    this.jdField_a_of_type_Ajyt.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyu
 * JD-Core Version:    0.7.0.1
 */