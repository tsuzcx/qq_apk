package NS_STORE_APP_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MiniAppStore$StGetFirstPageByTypeReq
  extends MessageMicro<StGetFirstPageByTypeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "uiPageType" }, new Object[] { null, Integer.valueOf(0) }, StGetFirstPageByTypeReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field uiPageType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.MiniAppStore.StGetFirstPageByTypeReq
 * JD-Core Version:    0.7.0.1
 */