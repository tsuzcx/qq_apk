import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class alau
  implements aklu
{
  alau(alap paramalap, int paramInt, int[] paramArrayOfInt, List paramList, AppInterface paramAppInterface, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, aklt paramaklt)
  {
    alap.a(this.jdField_a_of_type_Alap).remove(this.jdField_a_of_type_Int);
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc onCheckFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        paramaklt = akll.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
        if (paramaklt != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramaklt);
        }
        i += 1;
      }
      akln.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new alav(this), this.jdField_a_of_type_JavaUtilList, false, null);
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramaklt = akll.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramaklt != null)
      {
        alap localalap = this.jdField_a_of_type_Alap;
        int k = paramaklt.b;
        if (paramaklt.a())
        {
          j = 0;
          label167:
          paramaklt = alap.a(localalap, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramaklt);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label167;
        paramaklt = alap.a(this.jdField_a_of_type_Alap, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramaklt);
      }
    }
    this.jdField_a_of_type_Alap.a(this.jdField_a_of_type_JavaLangString, alpo.a(2131700870), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alau
 * JD-Core Version:    0.7.0.1
 */