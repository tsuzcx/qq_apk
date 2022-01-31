package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_part_error
  extends JceStruct
{
  public int is_happen;
  public String part_error_msg = "";
  public int part_error_place;
  
  public s_part_error() {}
  
  public s_part_error(int paramInt1, int paramInt2, String paramString)
  {
    this.is_happen = paramInt1;
    this.part_error_place = paramInt2;
    this.part_error_msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.is_happen = paramJceInputStream.read(this.is_happen, 0, false);
    this.part_error_place = paramJceInputStream.read(this.part_error_place, 1, false);
    this.part_error_msg = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.is_happen, 0);
    paramJceOutputStream.write(this.part_error_place, 1);
    if (this.part_error_msg != null) {
      paramJceOutputStream.write(this.part_error_msg, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_part_error
 * JD-Core Version:    0.7.0.1
 */