package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class send_diy_gift_item
  extends JceStruct
{
  static ArrayList<send_gift_info> cache_info;
  public int arch;
  public String audioUrl = "";
  public String backId = "";
  public String content = "";
  public long id;
  public ArrayList<send_gift_info> info;
  public boolean isBack = true;
  public boolean isPrivate = true;
  public String picUrl = "";
  public int recv_source;
  
  public send_diy_gift_item() {}
  
  public send_diy_gift_item(ArrayList<send_gift_info> paramArrayList, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2)
  {
    this.info = paramArrayList;
    this.id = paramLong;
    this.isBack = paramBoolean1;
    this.isPrivate = paramBoolean2;
    this.audioUrl = paramString1;
    this.picUrl = paramString2;
    this.content = paramString3;
    this.arch = paramInt1;
    this.backId = paramString4;
    this.recv_source = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_info == null)
    {
      cache_info = new ArrayList();
      send_gift_info localsend_gift_info = new send_gift_info();
      cache_info.add(localsend_gift_info);
    }
    this.info = ((ArrayList)paramJceInputStream.read(cache_info, 0, true));
    this.id = paramJceInputStream.read(this.id, 1, true);
    this.isBack = paramJceInputStream.read(this.isBack, 2, true);
    this.isPrivate = paramJceInputStream.read(this.isPrivate, 3, true);
    this.audioUrl = paramJceInputStream.readString(4, true);
    this.picUrl = paramJceInputStream.readString(5, true);
    this.content = paramJceInputStream.readString(6, true);
    this.arch = paramJceInputStream.read(this.arch, 7, false);
    this.backId = paramJceInputStream.readString(8, false);
    this.recv_source = paramJceInputStream.read(this.recv_source, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.info, 0);
    paramJceOutputStream.write(this.id, 1);
    paramJceOutputStream.write(this.isBack, 2);
    paramJceOutputStream.write(this.isPrivate, 3);
    paramJceOutputStream.write(this.audioUrl, 4);
    paramJceOutputStream.write(this.picUrl, 5);
    paramJceOutputStream.write(this.content, 6);
    paramJceOutputStream.write(this.arch, 7);
    String str = this.backId;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    paramJceOutputStream.write(this.recv_source, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.send_diy_gift_item
 * JD-Core Version:    0.7.0.1
 */