import android.support.annotation.NonNull;

public final class akjo
{
  public final int a;
  @NonNull
  public final akjm a;
  @NonNull
  public final String a;
  public final int b;
  @NonNull
  public final String b;
  
  public akjo(int paramInt1, @NonNull String paramString1, int paramInt2, @NonNull String paramString2, @NonNull akjm paramakjm)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Akjm = paramakjm;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (paramObject == null);
            bool1 = bool2;
          } while (getClass() != paramObject.getClass());
          paramObject = (akjo)paramObject;
          bool1 = bool2;
        } while (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int);
        bool1 = bool2;
      } while (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int);
      bool1 = bool2;
    } while (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString));
    return this.jdField_b_of_type_JavaLangString.equals(paramObject.jdField_b_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    return ((this.jdField_a_of_type_Int * 31 + this.jdField_a_of_type_JavaLangString.hashCode()) * 31 + this.jdField_b_of_type_Int) * 31 + this.jdField_b_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    return "MessageToShowBanner{bannerLev=" + this.jdField_a_of_type_Int + ", businessCategory='" + this.jdField_a_of_type_JavaLangString + '\'' + ", iconIdx=" + this.jdField_b_of_type_Int + ", wording='" + this.jdField_b_of_type_JavaLangString + '\'' + ", callback=" + this.jdField_a_of_type_Akjm + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjo
 * JD-Core Version:    0.7.0.1
 */