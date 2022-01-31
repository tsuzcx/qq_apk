import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class afiv
  extends AsyncTask<Void, Void, ArrayList<String>>
{
  afiv(afiu paramafiu, List paramList) {}
  
  protected ArrayList<String> a(Void... paramVarArgs)
  {
    return this.jdField_a_of_type_Afiu.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SDKEmotionSettingManager", 2, " openSetEmotion error pathList = " + paramArrayList);
      }
      afiu.a(this.jdField_a_of_type_Afiu, afiu.a(this.jdField_a_of_type_Afiu), Long.valueOf(afiu.a(this.jdField_a_of_type_Afiu)).longValue(), false, "");
      afiu.a(this.jdField_a_of_type_Afiu);
      return;
    }
    int i = paramArrayList.size();
    awqx.b(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, i + "", "", "", "");
    afiu.a(this.jdField_a_of_type_Afiu).clear();
    afiu.a(this.jdField_a_of_type_Afiu).addAll(paramArrayList);
    this.jdField_a_of_type_Afiu.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afiv
 * JD-Core Version:    0.7.0.1
 */