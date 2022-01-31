import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class afuq
  extends AsyncTask<Void, Void, ArrayList<String>>
{
  afuq(afup paramafup, List paramList) {}
  
  protected ArrayList<String> a(Void... paramVarArgs)
  {
    return this.jdField_a_of_type_Afup.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SDKEmotionSettingManager", 2, " openSetEmotion error pathList = " + paramArrayList);
      }
      afup.a(this.jdField_a_of_type_Afup, afup.a(this.jdField_a_of_type_Afup), Long.valueOf(afup.a(this.jdField_a_of_type_Afup)).longValue(), false, "");
      afup.a(this.jdField_a_of_type_Afup);
      return;
    }
    int i = paramArrayList.size();
    axqy.b(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, i + "", "", "", "");
    afup.a(this.jdField_a_of_type_Afup).clear();
    afup.a(this.jdField_a_of_type_Afup).addAll(paramArrayList);
    this.jdField_a_of_type_Afup.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afuq
 * JD-Core Version:    0.7.0.1
 */