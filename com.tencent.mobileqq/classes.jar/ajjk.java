import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class ajjk
  implements aiuk
{
  ajjk(ajjf paramajjf, int paramInt, int[] paramArrayOfInt, List paramList, AppInterface paramAppInterface, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, aiuj paramaiuj)
  {
    ajjf.a(this.jdField_a_of_type_Ajjf).remove(this.jdField_a_of_type_Int);
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc onCheckFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        paramaiuj = aiub.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
        if (paramaiuj != null) {
          this.jdField_a_of_type_JavaUtilList.add(paramaiuj);
        }
        i += 1;
      }
      aiud.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "", new ajjl(this), this.jdField_a_of_type_JavaUtilList, false, null);
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      paramaiuj = aiub.a().a(8, this.jdField_a_of_type_ArrayOfInt[i]);
      int j;
      if (paramaiuj != null)
      {
        ajjf localajjf = this.jdField_a_of_type_Ajjf;
        int k = paramaiuj.b;
        if (paramaiuj.a())
        {
          j = 0;
          label167:
          paramaiuj = ajjf.a(localajjf, 8, String.valueOf(k), j);
          this.jdField_a_of_type_OrgJsonJSONArray.put(paramaiuj);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label167;
        paramaiuj = ajjf.a(this.jdField_a_of_type_Ajjf, 8, String.valueOf(this.jdField_a_of_type_ArrayOfInt[i]), 2);
        this.jdField_a_of_type_OrgJsonJSONArray.put(paramaiuj);
      }
    }
    this.jdField_a_of_type_Ajjf.a(this.jdField_a_of_type_JavaLangString, ajyc.a(2131700490), this.jdField_a_of_type_OrgJsonJSONArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajjk
 * JD-Core Version:    0.7.0.1
 */