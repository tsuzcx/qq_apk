package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stElem
  extends JceStruct
{
  static stFace cache_face;
  static stText cache_text;
  public stFace face = null;
  public stText text = null;
  
  public stElem() {}
  
  public stElem(stText paramstText, stFace paramstFace)
  {
    this.text = paramstText;
    this.face = paramstFace;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_text == null) {
      cache_text = new stText();
    }
    this.text = ((stText)paramJceInputStream.read(cache_text, 0, false));
    if (cache_face == null) {
      cache_face = new stFace();
    }
    this.face = ((stFace)paramJceInputStream.read(cache_face, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.text;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.face;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MessageSvcPack.stElem
 * JD-Core Version:    0.7.0.1
 */