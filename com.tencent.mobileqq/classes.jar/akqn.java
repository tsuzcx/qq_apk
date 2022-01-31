import android.support.annotation.NonNull;
import java.util.HashSet;

public class akqn
{
  public static final HashSet<akqn> a;
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public long c;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public akqn(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.c = paramLong3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PushMsg0x210_c7Info{");
    localStringBuilder.append("fromUin:").append(this.jdField_a_of_type_Long).append(", ");
    localStringBuilder.append("msgSeq:").append(this.jdField_b_of_type_Long).append(", ");
    localStringBuilder.append("msgTime:").append(this.jdField_b_of_type_Int).append(", ");
    localStringBuilder.append("onlinePush:").append(this.jdField_a_of_type_Boolean).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akqn
 * JD-Core Version:    0.7.0.1
 */