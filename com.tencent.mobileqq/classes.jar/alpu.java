import java.util.ArrayList;

class alpu
{
  int jdField_a_of_type_Int = 3;
  long jdField_a_of_type_Long = 0L;
  alpu jdField_a_of_type_Alpu = null;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  boolean jdField_a_of_type_Boolean = false;
  
  static alpu a()
  {
    alpu localalpu = new alpu();
    localalpu.a();
    return localalpu;
  }
  
  String a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return "LBS_REQ_OK";
    case 1: 
      return "LBS_REQ_PENDING";
    }
    return "LBS_REQ_PERM_OK";
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Alpu == null) {
      this.jdField_a_of_type_Alpu = new alpu();
    }
  }
  
  boolean a(String paramString)
  {
    alps.a("startLocation", String.format("filterId=%s , IdList=%s", new Object[] { paramString, this.jdField_a_of_type_JavaUtilArrayList.toString() }), null);
    return this.jdField_a_of_type_JavaUtilArrayList.contains(paramString);
  }
  
  void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 3;
  }
  
  void c()
  {
    this.jdField_a_of_type_Alpu.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Alpu.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Alpu.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Alpu.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Alpu.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alpu
 * JD-Core Version:    0.7.0.1
 */