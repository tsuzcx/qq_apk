package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_sq_mainpage_switch
  extends JceStruct
{
  public boolean is_show_weishi = false;
  
  public s_sq_mainpage_switch() {}
  
  public s_sq_mainpage_switch(boolean paramBoolean)
  {
    this.is_show_weishi = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.is_show_weishi = paramJceInputStream.read(this.is_show_weishi, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.is_show_weishi, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_sq_mainpage_switch
 * JD-Core Version:    0.7.0.1
 */