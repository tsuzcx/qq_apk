import com.tencent.mobileqq.app.TroopManager;

public class akii
{
  public int a;
  public String a;
  
  public akii(TroopManager paramTroopManager) {}
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof akii))
    {
      paramObject = (akii)paramObject;
      if ((paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) && (paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int + this.jdField_a_of_type_JavaLangString.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akii
 * JD-Core Version:    0.7.0.1
 */