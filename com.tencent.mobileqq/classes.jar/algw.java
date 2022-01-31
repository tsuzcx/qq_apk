public class algw
  extends algp
{
  public int a;
  public String a;
  public algx[] a;
  public int b = -1;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e = 0;
  
  public algw()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfAlgx = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
  }
  
  public static boolean a(algw paramalgw)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramalgw != null)
    {
      bool1 = bool2;
      if (paramalgw.jdField_a_of_type_Int == 0)
      {
        bool1 = bool2;
        if (paramalgw.b == 0)
        {
          bool1 = bool2;
          if (paramalgw.jdField_a_of_type_ArrayOfAlgx != null)
          {
            bool1 = bool2;
            if (paramalgw.jdField_a_of_type_ArrayOfAlgx[0].jdField_c_of_type_Int == 0)
            {
              bool1 = bool2;
              if (paramalgw.jdField_a_of_type_ArrayOfAlgx[0].a != null) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfAlgx[0].a;
  }
  
  public String toString()
  {
    if (this.jdField_a_of_type_ArrayOfAlgx != null)
    {
      String str1 = "ImageTags{";
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= this.jdField_a_of_type_ArrayOfAlgx.length) {
          break;
        }
        str1 = str1 + ", imageTags[" + i + "] = " + this.jdField_a_of_type_ArrayOfAlgx[i];
        i += 1;
      }
    }
    String str2 = "null";
    return "ARCloudSceneRecogResult{retCode = " + this.jdField_a_of_type_Int + ", retMsg = " + this.jdField_a_of_type_JavaLangString + ", recogSvrRetCode = " + this.b + ", recogSvrRetMsg = " + this.jdField_c_of_type_JavaLangString + ", sessionId = " + this.jdField_d_of_type_JavaLangString + ", imageTags = " + str2 + ", timeLen = " + this.jdField_c_of_type_Int + ", score = " + this.jdField_d_of_type_Int + ", kptNum = " + this.e + super.toString() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     algw
 * JD-Core Version:    0.7.0.1
 */