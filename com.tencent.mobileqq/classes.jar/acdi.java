import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/MotiveBrowsingData;", "", "event", "", "script", "", "leftSecond", "(ILjava/lang/String;I)V", "getEvent", "()I", "getLeftSecond", "getScript", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class acdi
{
  public static final acdj a;
  private final int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final int b;
  
  static
  {
    jdField_a_of_type_Acdj = new acdj(null);
  }
  
  public acdi(int paramInt1, @NotNull String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof acdi))
      {
        paramObject = (acdi)paramObject;
        if ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (this.b != paramObject.b)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0) {
      return (i + j * 31) * 31 + this.b;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "MotiveBrowsingData(event=" + this.jdField_a_of_type_Int + ", script=" + this.jdField_a_of_type_JavaLangString + ", leftSecond=" + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdi
 * JD-Core Version:    0.7.0.1
 */