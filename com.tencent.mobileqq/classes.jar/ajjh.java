import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class ajjh
  implements ajih
{
  ajjh(ajjg paramajjg) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:" + paramBoolean);
    Object localObject = this.a.jdField_a_of_type_Ajjf;
    String str = this.a.jdField_a_of_type_JavaLangString;
    if (this.a.jdField_a_of_type_JavaIoFile.exists()) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = ajjf.a((ajjf)localObject, 6, str, paramInt);
      this.a.jdField_a_of_type_OrgJsonJSONArray.put(localObject);
      if ((this.a.jdField_a_of_type_ArrayOfInt != null) && (this.a.jdField_a_of_type_ArrayOfInt.length > 0)) {
        break;
      }
      this.a.jdField_a_of_type_Ajjf.a(this.a.b, ajyc.a(2131700479), this.a.jdField_a_of_type_OrgJsonJSONArray);
      return;
    }
    ajjf.a(this.a.jdField_a_of_type_Ajjf, this.a.jdField_a_of_type_ArrayOfInt, this.a.b, this.a.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajjh
 * JD-Core Version:    0.7.0.1
 */