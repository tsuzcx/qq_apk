package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacCpsGoodsListReq
  extends MessageMicro<VacCpsGoodsListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> category_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBStringField keyword = PBField.initString("");
  public final PBInt32Field page_nu = PBField.initInt32(0);
  public final PBInt32Field page_size = PBField.initInt32(0);
  public final PBStringField uid = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "uid", "keyword", "category_list", "page_nu", "page_size" }, new Object[] { "", "", localInteger, localInteger, localInteger }, VacCpsGoodsListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacCpsGoodsListReq
 * JD-Core Version:    0.7.0.1
 */