import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class aicv
  implements INetEngine.IBreakDownFix
{
  public aicv(ShortVideoDownloadProcessor paramShortVideoDownloadProcessor) {}
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    label8:
    HttpNetReq localHttpNetReq;
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
          localHttpNetReq = (HttpNetReq)paramNetReq;
          if (ShortVideoDownloadProcessor.a(this.a))
          {
            File localFile = new File(paramNetReq.d);
            if (paramNetResp.c == localFile.length())
            {
              paramNetResp.c = 0L;
              if (QLog.isColorLevel()) {
                QLog.e("ShortVideoDownloadProcessor", 2, "fixProgressiveRange, mStartDownOffset = " + paramNetReq.jdField_a_of_type_Long);
              }
            }
          }
          localHttpNetReq.jdField_a_of_type_Long += paramNetResp.c;
          if (0L != localHttpNetReq.b) {
            break;
          }
          paramNetResp.c = 0L;
          paramNetReq = "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-";
          localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetReq);
          paramNetReq = localHttpNetReq.jdField_a_of_type_JavaLangString;
        } while (!paramNetReq.contains("range="));
        paramNetReq = paramNetReq.substring(0, paramNetReq.lastIndexOf("range="));
        localHttpNetReq.jdField_a_of_type_JavaLangString = (paramNetReq + "range=" + localHttpNetReq.jdField_a_of_type_Long);
        return;
      } while ((localHttpNetReq.jdField_a_of_type_Long <= 0L) || (localHttpNetReq.b <= 0L) || (localHttpNetReq.jdField_a_of_type_Long >= localHttpNetReq.b));
      paramNetResp.c = 0L;
      paramNetReq = "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-" + localHttpNetReq.b;
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetReq);
      paramNetReq = localHttpNetReq.jdField_a_of_type_JavaLangString;
    } while (!paramNetReq.contains("range="));
    paramNetReq = paramNetReq.substring(0, paramNetReq.lastIndexOf("range="));
    localHttpNetReq.jdField_a_of_type_JavaLangString = (paramNetReq + "range=" + localHttpNetReq.jdField_a_of_type_Long + "-" + localHttpNetReq.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aicv
 * JD-Core Version:    0.7.0.1
 */