package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_count
  extends JceStruct
{
  public int blog_allnum;
  public int message_allnum;
  public int pic_allnum;
  public int qz_house_num;
  public int shuoshuo_allnum;
  
  public s_count() {}
  
  public s_count(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.pic_allnum = paramInt1;
    this.blog_allnum = paramInt2;
    this.shuoshuo_allnum = paramInt3;
    this.message_allnum = paramInt4;
    this.qz_house_num = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pic_allnum = paramJceInputStream.read(this.pic_allnum, 0, false);
    this.blog_allnum = paramJceInputStream.read(this.blog_allnum, 1, false);
    this.shuoshuo_allnum = paramJceInputStream.read(this.shuoshuo_allnum, 2, false);
    this.message_allnum = paramJceInputStream.read(this.message_allnum, 3, false);
    this.qz_house_num = paramJceInputStream.read(this.qz_house_num, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pic_allnum, 0);
    paramJceOutputStream.write(this.blog_allnum, 1);
    paramJceOutputStream.write(this.shuoshuo_allnum, 2);
    paramJceOutputStream.write(this.message_allnum, 3);
    paramJceOutputStream.write(this.qz_house_num, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_count
 * JD-Core Version:    0.7.0.1
 */