package Sound;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UploadRsp
  extends JceStruct
  implements Cloneable
{
  public int result = 0;
  public String voice_id = "";
  
  public UploadRsp() {}
  
  public UploadRsp(int paramInt, String paramString)
  {
    this.result = paramInt;
    this.voice_id = paramString;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.result, "result");
    paramStringBuilder.display(this.voice_id, "voice_id");
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.voice_id = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    if (this.voice_id != null) {
      paramJceOutputStream.write(this.voice_id, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     Sound.UploadRsp
 * JD-Core Version:    0.7.0.1
 */