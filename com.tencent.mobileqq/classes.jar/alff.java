import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class alff
  implements aled
{
  alff(alfe paramalfe, JSONArray paramJSONArray, File paramFile, AppInterface paramAppInterface, String paramString1, int[] paramArrayOfInt, String paramString2) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    QLog.d("ApolloPluginRscLoader", 1, new Object[] { "getCombination onDownLoadFinish sucess:", Boolean.valueOf(paramBoolean) });
    label75:
    int i;
    if (paramInt1 > 0)
    {
      paramString = this.jdField_a_of_type_Alfe;
      if (ApolloUtil.d(paramInt1))
      {
        paramInt2 = 0;
        paramString = alfe.a(paramString, 1, String.valueOf(paramInt1), paramInt2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramString);
      }
    }
    else
    {
      if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
        break label147;
      }
      paramInt1 = 0;
      if (paramInt1 >= paramArrayOfInt.length) {
        break label147;
      }
      paramString = this.jdField_a_of_type_Alfe;
      i = paramArrayOfInt[paramInt1];
      if (!ApolloUtil.c(paramArrayOfInt[paramInt1])) {
        break label141;
      }
    }
    label141:
    for (paramInt2 = 0;; paramInt2 = 2)
    {
      paramString = alfe.a(paramString, 2, String.valueOf(i), paramInt2);
      this.jdField_a_of_type_OrgJsonJSONArray.put(paramString);
      paramInt1 += 1;
      break label75;
      paramInt2 = 2;
      break;
    }
    label147:
    if ((this.jdField_a_of_type_JavaIoFile != null) && (!this.jdField_a_of_type_JavaIoFile.exists()))
    {
      aldv.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString, new alfg(this));
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramString = alfe.a(this.jdField_a_of_type_Alfe, 6, this.jdField_a_of_type_JavaLangString, 0);
      this.jdField_a_of_type_OrgJsonJSONArray.put(paramString);
    }
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ArrayOfInt.length <= 0))
    {
      this.jdField_a_of_type_Alfe.a(this.b, alud.a(2131700870), this.jdField_a_of_type_OrgJsonJSONArray);
      return;
    }
    alfe.a(this.jdField_a_of_type_Alfe, this.jdField_a_of_type_ArrayOfInt, this.b, this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alff
 * JD-Core Version:    0.7.0.1
 */