public class alib
{
  public double a;
  public int a;
  public String a;
  public alic[] a;
  public int b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int i;
    if ((this.jdField_a_of_type_ArrayOfAlic != null) && (this.jdField_a_of_type_ArrayOfAlic.length > 0)) {
      i = 0;
    }
    while (i < this.jdField_a_of_type_ArrayOfAlic.length)
    {
      localStringBuilder.append("\n index:").append(i).append(this.jdField_a_of_type_ArrayOfAlic[i].toString()).append('\n');
      i += 1;
      continue;
      localStringBuilder.append("\n only have one itemContent:" + this.jdField_a_of_type_JavaLangString + ",prob:" + this.jdField_a_of_type_Double).append('\n');
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alib
 * JD-Core Version:    0.7.0.1
 */