import android.text.TextUtils;
import android.util.Xml;
import java.io.ByteArrayInputStream;
import org.xmlpull.v1.XmlPullParser;

public class akco
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public int d;
  public int e;
  
  public akco()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public static akco a(String paramString)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
    {
      akco localakco = new akco();
      XmlPullParser localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      for (int i = 0;; i = localXmlPullParser.next())
      {
        localObject = localakco;
        if (i == 1) {
          break;
        }
        if ((i == 2) && (localXmlPullParser.getName().equalsIgnoreCase("banner")))
        {
          int j = localXmlPullParser.getAttributeCount();
          i = 0;
          if (i < j)
          {
            paramString = localXmlPullParser.getAttributeName(i);
            if ("text".equals(paramString)) {
              localakco.jdField_b_of_type_JavaLangString = localXmlPullParser.getAttributeValue(i);
            }
            for (;;)
            {
              i += 1;
              break;
              if ("url".equals(paramString)) {
                localakco.jdField_a_of_type_JavaLangString = localXmlPullParser.getAttributeValue(i);
              } else if ("dayNum".equals(paramString)) {
                localakco.jdField_a_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(i)).intValue();
              } else if ("dayIntervalNum".equals(paramString)) {
                localakco.jdField_b_of_type_Int = Integer.valueOf(localXmlPullParser.getAttributeValue(i)).intValue();
              } else if ("totalNum".equals(paramString)) {
                localakco.c = Integer.valueOf(localXmlPullParser.getAttributeValue(i)).intValue();
              } else if ("loginNum".equals(paramString)) {
                localakco.e = Integer.valueOf(localXmlPullParser.getAttributeValue(i)).intValue();
              } else if ("banner".equals(paramString)) {
                localakco.jdField_a_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(i));
              } else if ("setEntry".equals(paramString)) {
                localakco.jdField_b_of_type_Boolean = "1".equals(localXmlPullParser.getAttributeValue(i));
              }
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public String toString()
  {
    return "MobileUnityBannerData [url=" + this.jdField_a_of_type_JavaLangString + ", text=" + this.jdField_b_of_type_JavaLangString + ", dayNum=" + this.jdField_a_of_type_Int + ", dayIntervalNum=" + this.jdField_b_of_type_Int + ", totalNum=" + this.c + ", loginNum = " + this.e + ", version=" + this.d + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akco
 * JD-Core Version:    0.7.0.1
 */