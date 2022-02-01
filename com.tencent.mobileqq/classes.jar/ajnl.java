import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ajnl
  extends AsyncTask<Void, Void, ArrayList<String>>
{
  ajnl(ajnk paramajnk, List paramList) {}
  
  protected ArrayList<String> a(Void... paramVarArgs)
  {
    return this.jdField_a_of_type_Ajnk.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("SDKEmotionSettingManager", 1, " openSetEmotion error pathList = " + paramArrayList);
      ajnk.a(this.jdField_a_of_type_Ajnk, ajnk.a(this.jdField_a_of_type_Ajnk), Long.valueOf(ajnk.a(this.jdField_a_of_type_Ajnk)).longValue(), false, "");
      ajnk.a(this.jdField_a_of_type_Ajnk);
      return;
    }
    int i = paramArrayList.size();
    bcst.b(null, "dc00898", "", "", "0X8009DC8", "0X8009DC8", 0, 0, i + "", "", "", "");
    ajnk.a(this.jdField_a_of_type_Ajnk).clear();
    ajnk.a(this.jdField_a_of_type_Ajnk).addAll(paramArrayList);
    this.jdField_a_of_type_Ajnk.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnl
 * JD-Core Version:    0.7.0.1
 */