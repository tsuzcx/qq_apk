import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.utils.httputils.PkgTools;

class acnm
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MsgInfo jdField_a_of_type_OnlinePushPackMsgInfo;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public acnm(acnk paramacnk, MsgInfo paramMsgInfo, String paramString)
  {
    this.jdField_a_of_type_OnlinePushPackMsgInfo = paramMsgInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public acnm a()
  {
    byte[] arrayOfByte = new byte[4];
    if (this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg.length > 4) {
      PkgTools.copyData(arrayOfByte, 0, this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg, 0, 4);
    }
    this.jdField_a_of_type_Long = PkgTools.getLongData(arrayOfByte, 0);
    if (this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg.length >= 9)
    {
      arrayOfByte = new byte[this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg.length - 9];
      PkgTools.copyData(arrayOfByte, 0, this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg, 8, arrayOfByte.length);
      this.jdField_a_of_type_JavaLangString = new String(bcsc.a(arrayOfByte), "utf-8");
    }
    this.jdField_a_of_type_Int = 1020;
    this.b = -1000;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnm
 * JD-Core Version:    0.7.0.1
 */