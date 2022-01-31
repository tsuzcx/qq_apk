package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_decorate
  extends JceStruct
{
  static stcustomPraise cache_customPraise = new stcustomPraise();
  static s_HighFive cache_highFive;
  static ArrayList<s_KapuPraise> cache_kapuPraise;
  static Map<String, byte[]> cache_mapInfoData;
  static ArrayList<s_PolyPraise> cache_pokePraise;
  static s_PolyPraise cache_polyPraise = new s_PolyPraise();
  static s_PrdData cache_sprdData;
  public stcustomPraise customPraise;
  public s_HighFive highFive;
  public ArrayList<s_KapuPraise> kapuPraise;
  public Map<String, byte[]> mapInfoData;
  public ArrayList<s_PolyPraise> pokePraise;
  public s_PolyPraise polyPraise;
  public s_PrdData sprdData;
  
  static
  {
    cache_highFive = new s_HighFive();
    cache_mapInfoData = new HashMap();
    Object localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_mapInfoData.put("", localObject);
    cache_sprdData = new s_PrdData();
    cache_pokePraise = new ArrayList();
    localObject = new s_PolyPraise();
    cache_pokePraise.add(localObject);
    cache_kapuPraise = new ArrayList();
    localObject = new s_KapuPraise();
    cache_kapuPraise.add(localObject);
  }
  
  public cell_decorate() {}
  
  public cell_decorate(stcustomPraise paramstcustomPraise, s_PolyPraise params_PolyPraise, s_HighFive params_HighFive, Map<String, byte[]> paramMap, s_PrdData params_PrdData, ArrayList<s_PolyPraise> paramArrayList, ArrayList<s_KapuPraise> paramArrayList1)
  {
    this.customPraise = paramstcustomPraise;
    this.polyPraise = params_PolyPraise;
    this.highFive = params_HighFive;
    this.mapInfoData = paramMap;
    this.sprdData = params_PrdData;
    this.pokePraise = paramArrayList;
    this.kapuPraise = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.customPraise = ((stcustomPraise)paramJceInputStream.read(cache_customPraise, 0, false));
    this.polyPraise = ((s_PolyPraise)paramJceInputStream.read(cache_polyPraise, 1, false));
    this.highFive = ((s_HighFive)paramJceInputStream.read(cache_highFive, 2, false));
    this.mapInfoData = ((Map)paramJceInputStream.read(cache_mapInfoData, 3, false));
    this.sprdData = ((s_PrdData)paramJceInputStream.read(cache_sprdData, 4, false));
    this.pokePraise = ((ArrayList)paramJceInputStream.read(cache_pokePraise, 5, false));
    this.kapuPraise = ((ArrayList)paramJceInputStream.read(cache_kapuPraise, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.customPraise != null) {
      paramJceOutputStream.write(this.customPraise, 0);
    }
    if (this.polyPraise != null) {
      paramJceOutputStream.write(this.polyPraise, 1);
    }
    if (this.highFive != null) {
      paramJceOutputStream.write(this.highFive, 2);
    }
    if (this.mapInfoData != null) {
      paramJceOutputStream.write(this.mapInfoData, 3);
    }
    if (this.sprdData != null) {
      paramJceOutputStream.write(this.sprdData, 4);
    }
    if (this.pokePraise != null) {
      paramJceOutputStream.write(this.pokePraise, 5);
    }
    if (this.kapuPraise != null) {
      paramJceOutputStream.write(this.kapuPraise, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_decorate
 * JD-Core Version:    0.7.0.1
 */