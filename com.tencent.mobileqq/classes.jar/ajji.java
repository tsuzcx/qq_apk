import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class ajji
  implements aiui
{
  ajji(ajjd paramajjd, int paramInt, int[] paramArrayOfInt, List paramList, AppInterface paramAppInterface, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, aiuh paramaiuh)
  {
    ajjd.a(this.jdField_a_of_type_Ajjd).remove(this.jdField_a_of_type_Int);
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc onCheckFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        paramaiuh = aitz.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
        if (paramaiuh != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramaiuh);
        }
        i += 1;
      }
      aiub.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new ajjj(this), this.jdField_a_of_type_JavaUtilList, false, null);
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramaiuh = aitz.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramaiuh != null)
      {
        ajjd localajjd = this.jdField_a_of_type_Ajjd;
        int k = paramaiuh.b;
        if (paramaiuh.a())
        {
          j = 0;
          label167:
          paramaiuh = ajjd.a(localajjd, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramaiuh);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label167;
        paramaiuh = ajjd.a(this.jdField_a_of_type_Ajjd, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramaiuh);
      }
    }
    this.jdField_a_of_type_Ajjd.a(this.jdField_a_of_type_JavaLangString, ajya.a(2131700501), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajji
 * JD-Core Version:    0.7.0.1
 */