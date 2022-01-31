import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class ajjh
  implements ajif
{
  ajjh(ajjd paramajjd, String paramString1, File paramFile, JSONArray paramJSONArray, int[] paramArrayOfInt, String paramString2) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:" + paramBoolean);
    Object localObject = this.jdField_a_of_type_Ajjd;
    String str = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_JavaIoFile.exists()) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = ajjd.a((ajjd)localObject, 6, str, paramInt);
      this.jdField_a_of_type_OrgJsonJSONArray.put(localObject);
      if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > 0)) {
        break;
      }
      this.jdField_a_of_type_Ajjd.a(this.b, ajya.a(2131700505), this.jdField_a_of_type_OrgJsonJSONArray);
      return;
    }
    ajjd.a(this.jdField_a_of_type_Ajjd, this.jdField_a_of_type_ArrayOfInt, this.b, this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajjh
 * JD-Core Version:    0.7.0.1
 */