import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainInfo;

public class agia
{
  public int a;
  public agib a;
  public agic a;
  public byte[] a;
  
  public static agia a(submsgtype0xc7.RelationalChainInfo paramRelationalChainInfo)
  {
    if (paramRelationalChainInfo != null)
    {
      agia localagia = new agia();
      localagia.jdField_a_of_type_Int = paramRelationalChainInfo.uint64_type.get();
      if (paramRelationalChainInfo.bytes_attr.has()) {
        localagia.jdField_a_of_type_Agic = agic.a(localagia.jdField_a_of_type_Int, paramRelationalChainInfo.bytes_attr.get().toByteArray());
      }
      if (paramRelationalChainInfo.bytes_intimate_info.has()) {
        localagia.jdField_a_of_type_Agib = agib.a(paramRelationalChainInfo.bytes_intimate_info.get().toByteArray());
      }
      if (paramRelationalChainInfo.bytes_mutualmark_alienation.has()) {
        localagia.jdField_a_of_type_ArrayOfByte = paramRelationalChainInfo.bytes_mutualmark_alienation.get().toByteArray();
      }
      return localagia;
    }
    return null;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Agic != null) {
      return (int)this.jdField_a_of_type_Agic.b;
    }
    if ((this.jdField_a_of_type_Agib != null) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))) {
      return this.jdField_a_of_type_Agib.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Agic != null) {
      return (int)this.jdField_a_of_type_Agic.h;
    }
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsRelationalChainPushInfo{");
    localStringBuilder.append("relation_type:").append(this.jdField_a_of_type_Int).append(", ");
    localStringBuilder.append("mutualMarkInfo:").append(this.jdField_a_of_type_Agic).append(", ");
    localStringBuilder.append("intimateInfo:").append(this.jdField_a_of_type_Agib).append(", ");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agia
 * JD-Core Version:    0.7.0.1
 */