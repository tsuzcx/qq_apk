import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class aies
  extends DefaultHandler
{
  private int jdField_a_of_type_Int;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ArrayList<String> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramArrayOfChar = paramArrayOfChar.toString();
    QLog.d("SAXForHandler", 4, "characters: " + paramArrayOfChar);
  }
  
  public void endDocument()
  {
    QLog.d("SAXForHandler", 4, "endDocument");
    super.endDocument();
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    QLog.d("SAXForHandler", 4, "endElement uri:" + paramString1 + " localName:" + paramString2 + " qName:" + paramString3);
  }
  
  public void startDocument()
  {
    QLog.d("SAXForHandler", 4, "startDocument");
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    int j = 0;
    int i = 0;
    QLog.d("SAXForHandler", 4, "startElement: uri:" + paramString1 + " localName:" + paramString2 + " qName:" + paramString3);
    if ("config".equals(paramString2)) {
      while (i < paramAttributes.getLength())
      {
        this.jdField_a_of_type_Int = Integer.valueOf(paramAttributes.getValue(i)).intValue();
        QLog.d("SAXForHandler", 4, "startElement: localName:" + paramString2 + " value: " + this.jdField_a_of_type_Int);
        i += 1;
      }
    }
    if ("Elem".equals(paramString2))
    {
      i = j;
      while (i < paramAttributes.getLength())
      {
        paramString1 = paramAttributes.getValue(i);
        paramString3 = paramAttributes.getLocalName(i);
        QLog.d("SAXForHandler", 4, "startElement: localName:" + paramString2 + "name: " + paramString3 + " url: " + paramString1);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString1);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aies
 * JD-Core Version:    0.7.0.1
 */