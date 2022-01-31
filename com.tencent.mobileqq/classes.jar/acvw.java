import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;

public class acvw
{
  public int a;
  public acvx a;
  public acvy a;
  public byte[] a;
  
  public static acvw a(submsgtype0xc7.RelationalChainInfo paramRelationalChainInfo)
  {
    if (paramRelationalChainInfo != null)
    {
      acvw localacvw = new acvw();
      localacvw.jdField_a_of_type_Int = paramRelationalChainInfo.uint64_type.get();
      if (paramRelationalChainInfo.bytes_attr.has()) {
        localacvw.jdField_a_of_type_Acvy = acvy.a(localacvw.jdField_a_of_type_Int, paramRelationalChainInfo.bytes_attr.get().toByteArray());
      }
      if (paramRelationalChainInfo.bytes_intimate_info.has()) {
        localacvw.jdField_a_of_type_Acvx = acvx.a(paramRelationalChainInfo.bytes_intimate_info.get().toByteArray());
      }
      if (paramRelationalChainInfo.bytes_mutualmark_alienation.has()) {
        localacvw.jdField_a_of_type_ArrayOfByte = paramRelationalChainInfo.bytes_mutualmark_alienation.get().toByteArray();
      }
      return localacvw;
    }
    return null;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Acvy != null) {
      return (int)this.jdField_a_of_type_Acvy.b;
    }
    if ((this.jdField_a_of_type_Acvx != null) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))) {
      return this.jdField_a_of_type_Acvx.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsRelationalChainPushInfo{");
    localStringBuilder.append("relation_type:").append(this.jdField_a_of_type_Int).append(", ");
    localStringBuilder.append("mutualMarkInfo:").append(this.jdField_a_of_type_Acvy).append(", ");
    localStringBuilder.append("intimateInfo:").append(this.jdField_a_of_type_Acvx).append(", ");
    localStringBuilder.append("relationIconFlag:");
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      int i = 0;
      while ((i < this.jdField_a_of_type_ArrayOfByte.length) && (i < 10))
      {
        localStringBuilder.append(this.jdField_a_of_type_ArrayOfByte[0]).append(" ");
        i += 1;
      }
    }
    localStringBuilder.append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acvw
 * JD-Core Version:    0.7.0.1
 */