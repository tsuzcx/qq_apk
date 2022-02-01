import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DnaDetail;

public class agmg
{
  public int a;
  public String a;
  public int b;
  
  public static agmg a(oidb_0xcf4.DnaDetail paramDnaDetail)
  {
    Object localObject;
    if ((paramDnaDetail == null) || (!paramDnaDetail.has())) {
      localObject = null;
    }
    agmg localagmg;
    do
    {
      return localObject;
      localagmg = new agmg();
      if (paramDnaDetail.bytes_desc.has()) {
        localagmg.jdField_a_of_type_JavaLangString = paramDnaDetail.bytes_desc.get().toStringUtf8();
      }
      if (paramDnaDetail.uint32_bold_index.has()) {
        localagmg.jdField_a_of_type_Int = paramDnaDetail.uint32_bold_index.get();
      }
      localObject = localagmg;
    } while (!paramDnaDetail.uint32_bold_len.has());
    localagmg.b = paramDnaDetail.uint32_bold_len.get();
    return localagmg;
  }
  
  public String toString()
  {
    return "DnaDetail{description=" + this.jdField_a_of_type_JavaLangString + ", boldIndex=" + this.jdField_a_of_type_Int + ", boldLen=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmg
 * JD-Core Version:    0.7.0.1
 */