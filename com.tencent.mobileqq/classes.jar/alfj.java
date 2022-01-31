import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class alfj
  implements akqj
{
  alfj(alfe paramalfe, int paramInt, int[] paramArrayOfInt, List paramList, AppInterface paramAppInterface, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, akqi paramakqi)
  {
    alfe.a(this.jdField_a_of_type_Alfe).remove(this.jdField_a_of_type_Int);
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc onCheckFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        paramakqi = akqa.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
        if (paramakqi != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramakqi);
        }
        i += 1;
      }
      akqc.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new alfk(this), this.jdField_a_of_type_JavaUtilList, false, null);
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramakqi = akqa.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramakqi != null)
      {
        alfe localalfe = this.jdField_a_of_type_Alfe;
        int k = paramakqi.b;
        if (paramakqi.a())
        {
          j = 0;
          label167:
          paramakqi = alfe.a(localalfe, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramakqi);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label167;
        paramakqi = alfe.a(this.jdField_a_of_type_Alfe, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramakqi);
      }
    }
    this.jdField_a_of_type_Alfe.a(this.jdField_a_of_type_JavaLangString, alud.a(2131700882), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfj
 * JD-Core Version:    0.7.0.1
 */