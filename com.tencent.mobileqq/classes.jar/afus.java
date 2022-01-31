import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class afus
  extends AsyncTask<Void, Void, ArrayList<String>>
{
  afus(afur paramafur, List paramList) {}
  
  protected ArrayList<String> a(Void... paramVarArgs)
  {
    return this.jdField_a_of_type_Afur.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SDKEmotionSettingManager", 2, " openSetEmotion error pathList = " + paramArrayList);
      }
      afur.a(this.jdField_a_of_type_Afur, afur.a(this.jdField_a_of_type_Afur), Long.valueOf(afur.a(this.jdField_a_of_type_Afur)).longValue(), false, "");
      afur.a(this.jdField_a_of_type_Afur);
      return;
    }
    int i = paramArrayList.size();
    axqw.b(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, i + "", "", "", "");
    afur.a(this.jdField_a_of_type_Afur).clear();
    afur.a(this.jdField_a_of_type_Afur).addAll(paramArrayList);
    this.jdField_a_of_type_Afur.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afus
 * JD-Core Version:    0.7.0.1
 */