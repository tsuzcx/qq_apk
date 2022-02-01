import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public abstract class alqb
  implements alqd
{
  public int a;
  public long a;
  public bfoz a;
  public String a;
  public int b;
  public long b;
  public String b;
  public String c;
  
  public alqb()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_b_of_type_Int = -35072;
    this.jdField_a_of_type_Bfoz = new bfoz();
  }
  
  @Nullable
  public abstract Object a(int paramInt, bfoy parambfoy, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface);
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqb
 * JD-Core Version:    0.7.0.1
 */