package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_lucky_money
  extends JceStruct
{
  static Map<String, String> cache_extendinfo;
  static ArrayList<s_user> cache_getLuckyMoneyMen = new ArrayList();
  public String actionUrl = "";
  public Map<String, String> extendinfo = null;
  public ArrayList<s_user> getLuckyMoneyMen = null;
  public int isGeted = 0;
  public int isGrabEnd = 0;
  public int luckyMoneyAllocType = 0;
  public String luckyMoneyId = "";
  public String luckyMoneyPayId = "";
  public int luckyMoneyType = 0;
  public int num = 0;
  public int paswdShowComment = 0;
  public long uiHbCreateTime = 0L;
  public long uiHbHostUin = 0L;
  
  static
  {
    s_user locals_user = new s_user();
    cache_getLuckyMoneyMen.add(locals_user);
    cache_extendinfo = new HashMap();
    cache_extendinfo.put("", "");
  }
  
  public cell_lucky_money() {}
  
  public cell_lucky_money(int paramInt1, int paramInt2, ArrayList<s_user> paramArrayList, String paramString1, Map<String, String> paramMap, String paramString2, String paramString3, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2)
  {
    this.num = paramInt1;
    this.isGeted = paramInt2;
    this.getLuckyMoneyMen = paramArrayList;
    this.actionUrl = paramString1;
    this.extendinfo = paramMap;
    this.luckyMoneyId = paramString2;
    this.luckyMoneyPayId = paramString3;
    this.isGrabEnd = paramInt3;
    this.luckyMoneyType = paramInt4;
    this.luckyMoneyAllocType = paramInt5;
    this.paswdShowComment = paramInt6;
    this.uiHbHostUin = paramLong1;
    this.uiHbCreateTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.num = paramJceInputStream.read(this.num, 0, false);
    this.isGeted = paramJceInputStream.read(this.isGeted, 1, false);
    this.getLuckyMoneyMen = ((ArrayList)paramJceInputStream.read(cache_getLuckyMoneyMen, 2, false));
    this.actionUrl = paramJceInputStream.readString(3, false);
    this.extendinfo = ((Map)paramJceInputStream.read(cache_extendinfo, 4, false));
    this.luckyMoneyId = paramJceInputStream.readString(5, false);
    this.luckyMoneyPayId = paramJceInputStream.readString(6, false);
    this.isGrabEnd = paramJceInputStream.read(this.isGrabEnd, 7, false);
    this.luckyMoneyType = paramJceInputStream.read(this.luckyMoneyType, 8, false);
    this.luckyMoneyAllocType = paramJceInputStream.read(this.luckyMoneyAllocType, 9, false);
    this.paswdShowComment = paramJceInputStream.read(this.paswdShowComment, 10, false);
    this.uiHbHostUin = paramJceInputStream.read(this.uiHbHostUin, 11, false);
    this.uiHbCreateTime = paramJceInputStream.read(this.uiHbCreateTime, 12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.num, 0);
    paramJceOutputStream.write(this.isGeted, 1);
    if (this.getLuckyMoneyMen != null) {
      paramJceOutputStream.write(this.getLuckyMoneyMen, 2);
    }
    if (this.actionUrl != null) {
      paramJceOutputStream.write(this.actionUrl, 3);
    }
    if (this.extendinfo != null) {
      paramJceOutputStream.write(this.extendinfo, 4);
    }
    if (this.luckyMoneyId != null) {
      paramJceOutputStream.write(this.luckyMoneyId, 5);
    }
    if (this.luckyMoneyPayId != null) {
      paramJceOutputStream.write(this.luckyMoneyPayId, 6);
    }
    paramJceOutputStream.write(this.isGrabEnd, 7);
    paramJceOutputStream.write(this.luckyMoneyType, 8);
    paramJceOutputStream.write(this.luckyMoneyAllocType, 9);
    paramJceOutputStream.write(this.paswdShowComment, 10);
    paramJceOutputStream.write(this.uiHbHostUin, 11);
    paramJceOutputStream.write(this.uiHbCreateTime, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_lucky_money
 * JD-Core Version:    0.7.0.1
 */