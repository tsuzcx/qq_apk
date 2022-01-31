import java.util.ArrayList;

class ajxe
{
  int jdField_a_of_type_Int = 3;
  long jdField_a_of_type_Long = 0L;
  ajxe jdField_a_of_type_Ajxe = null;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  boolean jdField_a_of_type_Boolean = false;
  
  static ajxe a()
  {
    ajxe localajxe = new ajxe();
    localajxe.a();
    return localajxe;
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
    if (this.jdField_a_of_type_Ajxe == null) {
      this.jdField_a_of_type_Ajxe = new ajxe();
    }
  }
  
  boolean a(String paramString)
  {
    ajxc.a("startLocation", String.format("filterId=%s , IdList=%s", new Object[] { paramString, this.jdField_a_of_type_JavaUtilArrayList.toString() }), null);
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
    this.jdField_a_of_type_Ajxe.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Ajxe.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Ajxe.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Ajxe.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Ajxe.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxe
 * JD-Core Version:    0.7.0.1
 */