import android.os.FileObserver;

public class agmj
  extends FileObserver
{
  private agmg jdField_a_of_type_Agmg;
  private final String jdField_a_of_type_JavaLangString = "MediaScannerFileObserver";
  private String b;
  
  public agmj(agmg paramagmg, String paramString)
  {
    super(paramString);
    this.b = paramString;
    this.jdField_a_of_type_Agmg = paramagmg;
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Agmg == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramString == null) || (!paramString.endsWith(".mp4")));
    this.jdField_a_of_type_Agmg.a(paramInt, this.b, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agmj
 * JD-Core Version:    0.7.0.1
 */