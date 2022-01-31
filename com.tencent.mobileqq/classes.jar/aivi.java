import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class aivi
  implements aihr
{
  aivi(aivd paramaivd, int paramInt, int[] paramArrayOfInt, List paramList, AppInterface paramAppInterface, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, aihq paramaihq)
  {
    aivd.a(this.jdField_a_of_type_Aivd).remove(this.jdField_a_of_type_Int);
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc onCheckFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        paramaihq = aihi.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
        if (paramaihq != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramaihq);
        }
        i += 1;
      }
      aihk.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new aivj(this), this.jdField_a_of_type_JavaUtilList, false, null);
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramaihq = aihi.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramaihq != null)
      {
        aivd localaivd = this.jdField_a_of_type_Aivd;
        int k = paramaihq.b;
        if (paramaihq.a())
        {
          j = 0;
          label167:
          paramaihq = aivd.a(localaivd, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramaihq);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label167;
        paramaihq = aivd.a(this.jdField_a_of_type_Aivd, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramaihq);
      }
    }
    this.jdField_a_of_type_Aivd.a(this.jdField_a_of_type_JavaLangString, ajjy.a(2131634705), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aivi
 * JD-Core Version:    0.7.0.1
 */