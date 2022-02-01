package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class s_send_gift_item
  extends JceStruct
{
  static s_gift_card cache_giftCard = new s_gift_card();
  static Map<String, String> cache_mapExt;
  static ArrayList<Long> cache_receiver = new ArrayList();
  public int arch = 0;
  public String clientIp = "";
  public String content = "";
  public s_gift_card giftCard = null;
  public long giftItemId = 0L;
  public int giftType = 0;
  public boolean isBack = true;
  public boolean isPrivate = true;
  public boolean isTiming = true;
  public Map<String, String> mapExt = null;
  public ArrayList<Long> receiver = null;
  public int recv_source = 0;
  public String s_back_id = "";
  public String sendTime = "";
  public String url = "";
  
  static
  {
    cache_receiver.add(Long.valueOf(0L));
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public s_send_gift_item() {}
  
  public s_send_gift_item(s_gift_card params_gift_card, int paramInt1, ArrayList<Long> paramArrayList, long paramLong, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3, String paramString3, int paramInt2, String paramString4, String paramString5, int paramInt3, Map<String, String> paramMap)
  {
    this.giftCard = params_gift_card;
    this.giftType = paramInt1;
    this.receiver = paramArrayList;
    this.giftItemId = paramLong;
    this.content = paramString1;
    this.isBack = paramBoolean1;
    this.isPrivate = paramBoolean2;
    this.url = paramString2;
    this.isTiming = paramBoolean3;
    this.sendTime = paramString3;
    this.arch = paramInt2;
    this.s_back_id = paramString4;
    this.clientIp = paramString5;
    this.recv_source = paramInt3;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.giftCard = ((s_gift_card)paramJceInputStream.read(cache_giftCard, 0, false));
    this.giftType = paramJceInputStream.read(this.giftType, 1, true);
    this.receiver = ((ArrayList)paramJceInputStream.read(cache_receiver, 2, true));
    this.giftItemId = paramJceInputStream.read(this.giftItemId, 3, true);
    this.content = paramJceInputStream.readString(4, false);
    this.isBack = paramJceInputStream.read(this.isBack, 5, false);
    this.isPrivate = paramJceInputStream.read(this.isPrivate, 6, false);
    this.url = paramJceInputStream.readString(7, false);
    this.isTiming = paramJceInputStream.read(this.isTiming, 8, false);
    this.sendTime = paramJceInputStream.readString(9, false);
    this.arch = paramJceInputStream.read(this.arch, 10, false);
    this.s_back_id = paramJceInputStream.readString(11, false);
    this.clientIp = paramJceInputStream.readString(12, false);
    this.recv_source = paramJceInputStream.read(this.recv_source, 13, false);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 14, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.giftCard;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    paramJceOutputStream.write(this.giftType, 1);
    paramJceOutputStream.write(this.receiver, 2);
    paramJceOutputStream.write(this.giftItemId, 3);
    localObject = this.content;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.isBack, 5);
    paramJceOutputStream.write(this.isPrivate, 6);
    localObject = this.url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.isTiming, 8);
    localObject = this.sendTime;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    paramJceOutputStream.write(this.arch, 10);
    localObject = this.s_back_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.clientIp;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    paramJceOutputStream.write(this.recv_source, 13);
    localObject = this.mapExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.s_send_gift_item
 * JD-Core Version:    0.7.0.1
 */