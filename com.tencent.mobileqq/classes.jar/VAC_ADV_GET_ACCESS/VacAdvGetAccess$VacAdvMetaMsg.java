package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import common.QqAdGetProtos.QQAdGetRsp.AdInfo;

public final class VacAdvGetAccess$VacAdvMetaMsg
  extends MessageMicro<VacAdvMetaMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "adv_rsp", "insert_pos", "recomm_cookie" }, new Object[] { null, Integer.valueOf(0), "" }, VacAdvMetaMsg.class);
  public QqAdGetProtos.QQAdGetRsp.AdInfo adv_rsp = new QqAdGetProtos.QQAdGetRsp.AdInfo();
  public final PBInt32Field insert_pos = PBField.initInt32(0);
  public final PBStringField recomm_cookie = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacAdvMetaMsg
 * JD-Core Version:    0.7.0.1
 */