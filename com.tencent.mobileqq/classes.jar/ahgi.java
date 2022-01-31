public class ahgi
{
  public int a;
  public long a;
  public String a;
  public String b;
  
  public ahgi(int paramInt, long paramLong, String paramString)
  {
    this.b = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1001: 
      return "action_show_entry";
    case 1002: 
      return "action_hide_entry";
    case 2001: 
      return "action_show_default_pendant";
    case 2002: 
      return "action_hide_default_pendant";
    case 3001: 
      return "action_show_special_banner";
    case 3002: 
      return "action_hide_special_banner";
    case 4001: 
      return "action_show_preview";
    }
    return "action_hide_preview";
  }
  
  public String a()
  {
    return a(this.jdField_a_of_type_Int);
  }
  
  public String toString()
  {
    String str = bbkp.b(this.jdField_a_of_type_Long);
    return String.format("[action:%s,time:%s,id:%s,entryId:%s]", new Object[] { a(), str, this.jdField_a_of_type_JavaLangString, this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgi
 * JD-Core Version:    0.7.0.1
 */