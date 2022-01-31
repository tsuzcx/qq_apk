import org.xmlpull.v1.XmlSerializer;

final class alzi
  extends azsm
{
  alzi(String paramString)
  {
    super(paramString);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "picture");
    if (this.S == null) {}
    for (String str = "";; str = this.S)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      paramXmlSerializer.endTag(null, "picture");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alzi
 * JD-Core Version:    0.7.0.1
 */