import com.tencent.mobileqq.app.QQAppInterface;
import java.text.DecimalFormat;

public class ahfh
{
  public static String a;
  public static DecimalFormat a;
  private static boolean a;
  public static String b;
  public static String c;
  private static String d;
  public int a;
  public long a;
  public int b;
  public long b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://i.gtimg.cn/channel/exclusive_hb/socialpay_makehb_ani_";
    jdField_b_of_type_JavaLangString = "http://i.gtimg.cn/channel/exclusive_hb/socialpay_aio_ani_";
    c = jdField_a_of_type_JavaLangString;
    d = jdField_b_of_type_JavaLangString;
    jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#0.00");
  }
  
  public static String a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      QQAppInterface localQQAppInterface = ahiy.a();
      if (localQQAppInterface != null) {
        d = ((agzf)localQQAppInterface.getManager(245)).a("hb_exclusive", jdField_b_of_type_JavaLangString, new String[] { "aio_red", "prefix" });
      }
    }
    return d;
  }
  
  public String toString()
  {
    return "SpecifyAnimInfo{aId=" + this.jdField_a_of_type_Int + ", minPrice=" + this.jdField_a_of_type_Long + ", maxPrice=" + this.jdField_b_of_type_Long + ", skinId=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahfh
 * JD-Core Version:    0.7.0.1
 */