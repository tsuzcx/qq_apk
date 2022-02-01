import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class abbc
{
  public String a;
  private boolean jdField_a_of_type_Boolean;
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  
  public abbc(abay paramabay, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void a(String paramString)
  {
    Object localObject = new File(paramString);
    if (((File)localObject).exists())
    {
      this.jdField_a_of_type_Boolean = true;
      localObject = Arrays.asList(((File)localObject).list());
      String str;
      if (((List)localObject).contains("bg@2x.png"))
      {
        str = paramString + "/" + "bg@2x.png";
        if (!new File(str).exists()) {
          break label195;
        }
        this.c = str;
      }
      if (((List)localObject).contains("camera@2x.png"))
      {
        str = paramString + "/" + "camera@2x.png";
        if (!new File(str).exists()) {
          break label203;
        }
        this.d = str;
      }
    }
    for (;;)
    {
      if (((List)localObject).contains("point@2x.png"))
      {
        paramString = paramString + "/" + "point@2x.png";
        if (!new File(paramString).exists()) {
          break label211;
        }
        this.e = paramString;
      }
      return;
      label195:
      this.jdField_a_of_type_Boolean = false;
      break;
      label203:
      this.jdField_a_of_type_Boolean = false;
    }
    label211:
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetHelper", 1, "isResourceReady:" + this.jdField_a_of_type_Boolean);
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abbc
 * JD-Core Version:    0.7.0.1
 */