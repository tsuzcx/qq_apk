import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class Foo2
{
  public static void inject()
  {
    QLog.class.toString();
    MessageMicro.class.toString();
    MessageMicro.FieldMap.class.toString();
    PBField.class.toString();
    ByteStringMicro.class.toString();
    JceInputStream.class.toString();
    JceOutputStream.class.toString();
    JceStruct.class.toString();
    PBUInt32Field.class.toString();
    PBUInt64Field.class.toString();
    PBStringField.class.toString();
    PBRepeatMessageField.class.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     Foo2
 * JD-Core Version:    0.7.0.1
 */