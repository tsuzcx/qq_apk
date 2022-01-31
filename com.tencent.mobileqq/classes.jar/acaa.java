import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

public class acaa
  extends AsyncTask<String, Void, HashMap<Integer, Integer>>
{
  public acaa(ScoreQAVFragment paramScoreQAVFragment) {}
  
  protected HashMap<Integer, Integer> a(String... paramVarArgs)
  {
    int i = 0;
    if ((this.a.jdField_d_of_type_JavaLangString == null) || (this.a.jdField_d_of_type_JavaLangString.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScoreActivity", 2, "mSelfUin is null!");
      }
      return null;
    }
    paramVarArgs = bbkb.e(this.a.jdField_d_of_type_JavaLangString);
    this.a.b = paramVarArgs.getString(ldd.h, "");
    paramVarArgs = msy.a();
    this.a.b(paramVarArgs);
    paramVarArgs = lct.b(270).a;
    this.a.a(paramVarArgs);
    if (this.a.e.isEmpty())
    {
      this.a.e = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131696145);
      if (QLog.isColorLevel()) {
        QLog.d("ScoreActivity", 2, "mProblem_Video config data is invalid, use default!");
      }
    }
    if (this.a.f.isEmpty())
    {
      this.a.f = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131696143);
      if (QLog.isColorLevel()) {
        QLog.d("ScoreActivity", 2, "mProblem_Audio config data is invalid, use default!");
      }
    }
    if (this.a.g.isEmpty())
    {
      this.a.g = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131696144);
      if (QLog.isColorLevel()) {
        QLog.d("ScoreActivity", 2, "mProblem_Net config data is invalid, use default!");
      }
    }
    if (this.a.jdField_d_of_type_Long == 0L) {
      paramVarArgs = this.a.e + "/" + this.a.f + "/" + this.a.g;
    }
    try
    {
      this.a.jdField_a_of_type_JavaUtilList = Arrays.asList(paramVarArgs.split("/"));
      if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        i = 0;
        if (i >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          break label778;
        }
      }
    }
    catch (Exception paramVarArgs)
    {
      try
      {
        do
        {
          for (;;)
          {
            paramVarArgs = ((String)this.a.jdField_a_of_type_JavaUtilList.get(i)).split(",");
            this.a.jdField_a_of_type_JavaUtilList.set(i, paramVarArgs[1]);
            int j = Integer.parseInt(paramVarArgs[0]);
            this.a.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Integer.valueOf(j));
            i += 1;
            continue;
            paramVarArgs = this.a.f + "/" + this.a.g;
          }
          paramVarArgs = paramVarArgs;
          paramVarArgs.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.i("ScoreActivity", 2, "parse exception : " + paramVarArgs.getMessage());
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          paramVarArgs.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("ScoreActivity", 2, "parse exception : " + paramVarArgs.getMessage());
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScoreActivity", 2, "processDataTask mDatas is invalid, use default!");
      }
      this.a.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.a.jdField_a_of_type_JavaUtilList.add(ajya.a(2131713587));
      this.a.jdField_a_of_type_JavaUtilList.add(ajya.a(2131713580));
      this.a.jdField_a_of_type_JavaUtilList.add(ajya.a(2131713583));
      this.a.jdField_a_of_type_JavaUtilList.add(ajya.a(2131713586));
      this.a.jdField_a_of_type_JavaUtilList.add(ajya.a(2131713581));
      this.a.jdField_a_of_type_JavaUtilList.add(ajya.a(2131713585));
      this.a.jdField_a_of_type_JavaUtilList.add(ajya.a(2131713582));
      this.a.jdField_a_of_type_JavaUtilList.add(ajya.a(2131713584));
      while (i < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        this.a.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Integer.valueOf(i));
        i += 1;
      }
    }
    label778:
    return this.a.jdField_a_of_type_JavaUtilHashMap;
  }
  
  protected void a(HashMap<Integer, Integer> paramHashMap)
  {
    super.onPostExecute(paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acaa
 * JD-Core Version:    0.7.0.1
 */