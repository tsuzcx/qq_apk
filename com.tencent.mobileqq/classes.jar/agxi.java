import android.support.annotation.Nullable;
import com.tencent.mobileqq.datarecv.pb.ZhituReportMsg.ReqBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class agxi
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  @Nullable
  public String f;
  @Nullable
  public String g;
  
  public ZhituReportMsg.ReqBody a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    if (this.c == null) {
      this.c = "";
    }
    if (this.b == null) {
      this.b = "";
    }
    if (this.d == null) {
      this.d = "";
    }
    if (this.e == null) {
      this.e = "";
    }
    if (this.f == null) {
      this.f = "";
    }
    if (this.g == null) {
      this.g = "";
    }
    ZhituReportMsg.ReqBody localReqBody = new ZhituReportMsg.ReqBody();
    localReqBody.bytes_pass.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localReqBody.bytes_pic_id.set(ByteStringMicro.copyFromUtf8(this.b));
    localReqBody.bytes_style.set(ByteStringMicro.copyFromUtf8(this.c));
    localReqBody.uint32_action.set(this.jdField_a_of_type_Int);
    localReqBody.bytes_aio_type.set(ByteStringMicro.copyFromUtf8(this.d));
    localReqBody.bytes_mobile_type.set(ByteStringMicro.copyFromUtf8("android"));
    localReqBody.bytes_current_text.set(ByteStringMicro.copyFromUtf8(this.e));
    return localReqBody;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ZhituReportData{pass='").append(this.jdField_a_of_type_JavaLangString).append('\'').append(", imgId='").append(this.b).append('\'').append(", styles='").append(this.c).append('\'').append(", action=").append(this.jdField_a_of_type_Int).append(", aioType='").append(this.d).append('\'').append(", queryText='");
    if (this.e != null)
    {
      str = bhma.a(this.e);
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", lastMessage='");
      if (this.f == null) {
        break label207;
      }
      str = bhma.a(this.f);
      label139:
      localStringBuilder = localStringBuilder.append(str).append('\'').append(", lastTwoMessage='");
      if (this.g == null) {
        break label213;
      }
    }
    label207:
    label213:
    for (String str = bhma.a(this.g);; str = "null")
    {
      return str + '\'' + ", isReported=" + this.jdField_a_of_type_Boolean + '}';
      str = "null";
      break;
      str = "null";
      break label139;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxi
 * JD-Core Version:    0.7.0.1
 */