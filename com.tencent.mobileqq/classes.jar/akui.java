class akui
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public akui(String paramString, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int == 5) {
      return 0;
    }
    if (this.jdField_a_of_type_Int == 4) {
      return 60000;
    }
    if (this.jdField_a_of_type_Int == 3) {
      return 180000;
    }
    if (this.jdField_a_of_type_Int == 2) {
      return 600000;
    }
    return 1800000;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("businessId: ").append(this.jdField_a_of_type_JavaLangString).append(",").append("reqLonAndLat: ").append(this.jdField_a_of_type_Boolean).append(",").append("realTimeRequirement: ").append(this.jdField_a_of_type_Int).append(",").append("requestDataLevel: ").append(this.jdField_b_of_type_Int).append(",").append("reqGoon: ").append(this.jdField_b_of_type_Boolean).append(",").append("canUseGps: ").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akui
 * JD-Core Version:    0.7.0.1
 */