import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class aivk
  implements aihm
{
  aivk(aivd paramaivd, int[] paramArrayOfInt, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, List<aihj> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramString1 = aihi.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramString1 != null)
      {
        paramList = this.jdField_a_of_type_Aivd;
        int k = paramString1.b;
        if (paramString1.a())
        {
          j = 0;
          label79:
          paramString1 = aivd.a(paramList, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramString1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label79;
        paramString1 = aivd.a(this.jdField_a_of_type_Aivd, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramString1);
      }
    }
    this.jdField_a_of_type_Aivd.a(this.jdField_a_of_type_JavaLangString, ajjy.a(2131634717), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aivk
 * JD-Core Version:    0.7.0.1
 */