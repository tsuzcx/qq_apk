import com.tencent.image.Utils;

public class akpt
  extends akpu
{
  public akpt(String paramString)
  {
    super(paramString);
    this.a = "PhotoIncompatibleWebp";
    this.b = "reportGenerateHeif";
  }
  
  static boolean a(String paramString)
  {
    return Utils.isHeifFile(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpt
 * JD-Core Version:    0.7.0.1
 */