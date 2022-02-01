import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBStringField;
import localpb.richMsg.SafeMsg.SafeMoreInfo;

class abxf
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MsgInfo jdField_a_of_type_OnlinePushPackMsgInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public abxf(abxc paramabxc, MsgInfo paramMsgInfo, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_OnlinePushPackMsgInfo = paramMsgInfo;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abxf a()
  {
    this.jdField_a_of_type_JavaLangString = new String(bblk.a(this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg), "utf-8");
    Object localObject = ((amsw)this.jdField_a_of_type_Abxc.a.getManager(51)).e(this.jdField_b_of_type_Long + "");
    if ((localObject != null) && (((Friends)localObject).isFriend())) {
      this.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localObject = new SafeMsg.SafeMoreInfo();
      ((SafeMsg.SafeMoreInfo)localObject).strFromMobile.set(this.jdField_a_of_type_OnlinePushPackMsgInfo.strFromMobile);
      ((SafeMsg.SafeMoreInfo)localObject).strFromName.set(this.jdField_a_of_type_OnlinePushPackMsgInfo.strFromName);
      ((SafeMsg.SafeMoreInfo)localObject).strMsgTxt.set(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ArrayOfByte = ((SafeMsg.SafeMoreInfo)localObject).toByteArray();
      this.jdField_b_of_type_Int = -1002;
      this.jdField_a_of_type_Boolean = true;
      return this;
      localObject = ((avsy)this.jdField_a_of_type_Abxc.a.getManager(11)).b(String.valueOf(this.jdField_a_of_type_Long));
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        this.jdField_a_of_type_Int = 1006;
      } else {
        this.jdField_a_of_type_Int = 1000;
      }
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxf
 * JD-Core Version:    0.7.0.1
 */