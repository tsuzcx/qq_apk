import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.HashMap;

public final class aitt
  implements INetEngine.IBreakDownFix
{
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    label8:
    do
    {
      do
      {
        do
        {
          break label8;
          do
          {
            return;
          } while (!(paramNetReq instanceof HttpNetReq));
          paramNetReq = (HttpNetReq)paramNetReq;
          paramNetReq.jdField_a_of_type_Long += paramNetResp.c;
          if (0L != paramNetReq.b) {
            break;
          }
          paramNetResp.c = 0L;
          paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-";
          paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
          paramNetResp = paramNetReq.jdField_a_of_type_JavaLangString;
        } while (!paramNetResp.contains("range="));
        paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
        paramNetReq.jdField_a_of_type_JavaLangString = (paramNetResp + "range=" + paramNetReq.jdField_a_of_type_Long);
        return;
      } while ((paramNetReq.jdField_a_of_type_Long <= 0L) || (paramNetReq.b <= 0L) || (paramNetReq.jdField_a_of_type_Long >= paramNetReq.b));
      paramNetResp.c = 0L;
      paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-" + paramNetReq.b;
      paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
      paramNetResp = paramNetReq.jdField_a_of_type_JavaLangString;
    } while (!paramNetResp.contains("range="));
    paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
    paramNetReq.jdField_a_of_type_JavaLangString = (paramNetResp + "range=" + paramNetReq.jdField_a_of_type_Long + "-" + paramNetReq.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitt
 * JD-Core Version:    0.7.0.1
 */