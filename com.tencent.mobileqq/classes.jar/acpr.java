import com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.HashMap;

public class acpr
  implements INetEngine.IBreakDownFix
{
  public acpr(ExtendFriendResourceDownloader paramExtendFriendResourceDownloader) {}
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq != null) && (paramNetResp != null) && ((paramNetReq instanceof HttpNetReq)))
    {
      paramNetReq = (HttpNetReq)paramNetReq;
      paramNetReq.jdField_a_of_type_Long += paramNetResp.c;
      paramNetResp.c = 0L;
      paramNetResp = "bytes=" + paramNetReq.jdField_a_of_type_Long + "-";
      paramNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
      paramNetResp = paramNetReq.jdField_a_of_type_JavaLangString;
      if (paramNetResp.contains("range="))
      {
        paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
        paramNetReq.jdField_a_of_type_JavaLangString = (paramNetResp + "range=" + paramNetReq.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpr
 * JD-Core Version:    0.7.0.1
 */