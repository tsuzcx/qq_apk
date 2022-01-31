package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_gamebar_pk_banner
  extends JceStruct
{
  public int banner_state;
  public String jump_url = "";
  public String pic_url = "";
  public String trace_info = "";
  
  public s_gamebar_pk_banner() {}
  
  public s_gamebar_pk_banner(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.banner_state = paramInt;
    this.pic_url = paramString1;
    this.jump_url = paramString2;
    this.trace_info = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.banner_state = paramJceInputStream.read(this.banner_state, 0, true);
    this.pic_url = paramJceInputStream.readString(1, true);
    this.jump_url = paramJceInputStream.readString(2, true);
    this.trace_info = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.banner_state, 0);
    paramJceOutputStream.write(this.pic_url, 1);
    paramJceOutputStream.write(this.jump_url, 2);
    paramJceOutputStream.write(this.trace_info, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_gamebar_pk_banner
 * JD-Core Version:    0.7.0.1
 */