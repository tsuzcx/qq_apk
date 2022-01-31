import com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager;

public class aecl
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  
  aecl(WerewolvesDataManager paramWerewolvesDataManager) {}
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof aecl))
    {
      paramObject = (aecl)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aecl
 * JD-Core Version:    0.7.0.1
 */