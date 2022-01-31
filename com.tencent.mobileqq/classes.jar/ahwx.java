import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ahwx
  extends AsyncTask<Void, Void, ArrayList<String>>
{
  ahwx(ahww paramahww, List paramList) {}
  
  protected ArrayList<String> a(Void... paramVarArgs)
  {
    return this.jdField_a_of_type_Ahww.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("SDKEmotionSettingManager", 1, " openSetEmotion error pathList = " + paramArrayList);
      ahww.a(this.jdField_a_of_type_Ahww, ahww.a(this.jdField_a_of_type_Ahww), Long.valueOf(ahww.a(this.jdField_a_of_type_Ahww)).longValue(), false, "");
      ahww.a(this.jdField_a_of_type_Ahww);
      return;
    }
    int i = paramArrayList.size();
    azqs.b(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, i + "", "", "", "");
    ahww.a(this.jdField_a_of_type_Ahww).clear();
    ahww.a(this.jdField_a_of_type_Ahww).addAll(paramArrayList);
    this.jdField_a_of_type_Ahww.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwx
 * JD-Core Version:    0.7.0.1
 */