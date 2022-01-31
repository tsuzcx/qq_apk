import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ahsi
  extends AsyncTask<Void, Void, ArrayList<String>>
{
  ahsi(ahsh paramahsh, List paramList) {}
  
  protected ArrayList<String> a(Void... paramVarArgs)
  {
    return this.jdField_a_of_type_Ahsh.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("SDKEmotionSettingManager", 1, " openSetEmotion error pathList = " + paramArrayList);
      ahsh.a(this.jdField_a_of_type_Ahsh, ahsh.a(this.jdField_a_of_type_Ahsh), Long.valueOf(ahsh.a(this.jdField_a_of_type_Ahsh)).longValue(), false, "");
      ahsh.a(this.jdField_a_of_type_Ahsh);
      return;
    }
    int i = paramArrayList.size();
    azmj.b(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, i + "", "", "", "");
    ahsh.a(this.jdField_a_of_type_Ahsh).clear();
    ahsh.a(this.jdField_a_of_type_Ahsh).addAll(paramArrayList);
    this.jdField_a_of_type_Ahsh.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsi
 * JD-Core Version:    0.7.0.1
 */