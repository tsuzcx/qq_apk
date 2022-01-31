import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class acsa
  extends alqv
{
  public acsa(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    super.a(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (i == 0) {
      this.a.a(8, alof.z, 6000);
    }
    while (i != 1) {
      return;
    }
    this.a.a(8, alof.A, 6000);
  }
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong.longValue());
    if (i == 0) {
      this.a.a(9, alof.z, 6003);
    }
    while (i != 1) {
      return;
    }
    this.a.a(8, alof.A, 6003);
  }
  
  protected void b(boolean paramBoolean, long paramLong, String paramString)
  {
    super.b(paramBoolean, paramLong, paramString);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (i == 0) {
      this.a.a(8, alof.z, 6000);
    }
    while (i != 1) {
      return;
    }
    this.a.a(8, alof.A, 6003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsa
 * JD-Core Version:    0.7.0.1
 */