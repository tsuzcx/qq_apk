import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ajpj
  extends AsyncTask<Void, Void, ArrayList<String>>
{
  ajpj(ajpi paramajpi, List paramList) {}
  
  protected ArrayList<String> a(Void... paramVarArgs)
  {
    return this.jdField_a_of_type_Ajpi.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("SDKEmotionSettingManager", 1, " openSetEmotion error pathList = " + paramArrayList);
      ajpi.a(this.jdField_a_of_type_Ajpi, ajpi.a(this.jdField_a_of_type_Ajpi), Long.valueOf(ajpi.a(this.jdField_a_of_type_Ajpi)).longValue(), false, "");
      ajpi.a(this.jdField_a_of_type_Ajpi);
      return;
    }
    int i = paramArrayList.size();
    bdla.b(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, i + "", "", "", "");
    ajpi.a(this.jdField_a_of_type_Ajpi).clear();
    ajpi.a(this.jdField_a_of_type_Ajpi).addAll(paramArrayList);
    this.jdField_a_of_type_Ajpi.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpj
 * JD-Core Version:    0.7.0.1
 */