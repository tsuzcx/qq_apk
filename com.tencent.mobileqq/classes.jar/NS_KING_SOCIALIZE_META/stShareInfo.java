package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stShareInfo
  extends JceStruct
{
  static Map<Integer, stShareBody> cache_body_map = new HashMap();
  static Map<Integer, stShareBody> cache_haibao_body_map;
  static stSqArk cache_sq_ark_info;
  static stWxMiniProg cache_wx_mini_program;
  public int activity_type;
  public String background_title_color = "";
  public String background_url = "";
  public Map<Integer, stShareBody> body_map;
  public String feed_cover_updtime = "";
  public Map<Integer, stShareBody> haibao_body_map;
  public String haibao_desc = "";
  public String haibao_jump_url = "";
  public String jump_url = "";
  public String share_icon_title = "";
  public String share_icon_url = "";
  public int share_num;
  public stSqArk sq_ark_info;
  public stWxMiniProg wx_mini_program;
  
  static
  {
    stShareBody localstShareBody = new stShareBody();
    cache_body_map.put(Integer.valueOf(0), localstShareBody);
    cache_wx_mini_program = new stWxMiniProg();
    cache_sq_ark_info = new stSqArk();
    cache_haibao_body_map = new HashMap();
    localstShareBody = new stShareBody();
    cache_haibao_body_map.put(Integer.valueOf(0), localstShareBody);
  }
  
  public stShareInfo() {}
  
  public stShareInfo(String paramString1, Map<Integer, stShareBody> paramMap1, stWxMiniProg paramstWxMiniProg, stSqArk paramstSqArk, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, Map<Integer, stShareBody> paramMap2, String paramString6, String paramString7, int paramInt2, String paramString8)
  {
    this.jump_url = paramString1;
    this.body_map = paramMap1;
    this.wx_mini_program = paramstWxMiniProg;
    this.sq_ark_info = paramstSqArk;
    this.share_icon_url = paramString2;
    this.share_icon_title = paramString3;
    this.background_url = paramString4;
    this.activity_type = paramInt1;
    this.haibao_jump_url = paramString5;
    this.haibao_body_map = paramMap2;
    this.background_title_color = paramString6;
    this.haibao_desc = paramString7;
    this.share_num = paramInt2;
    this.feed_cover_updtime = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.jump_url = paramJceInputStream.readString(0, false);
    this.body_map = ((Map)paramJceInputStream.read(cache_body_map, 1, false));
    this.wx_mini_program = ((stWxMiniProg)paramJceInputStream.read(cache_wx_mini_program, 2, false));
    this.sq_ark_info = ((stSqArk)paramJceInputStream.read(cache_sq_ark_info, 3, false));
    this.share_icon_url = paramJceInputStream.readString(4, false);
    this.share_icon_title = paramJceInputStream.readString(5, false);
    this.background_url = paramJceInputStream.readString(6, false);
    this.activity_type = paramJceInputStream.read(this.activity_type, 7, false);
    this.haibao_jump_url = paramJceInputStream.readString(8, false);
    this.haibao_body_map = ((Map)paramJceInputStream.read(cache_haibao_body_map, 9, false));
    this.background_title_color = paramJceInputStream.readString(10, false);
    this.haibao_desc = paramJceInputStream.readString(11, false);
    this.share_num = paramJceInputStream.read(this.share_num, 12, false);
    this.feed_cover_updtime = paramJceInputStream.readString(13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.jump_url != null) {
      paramJceOutputStream.write(this.jump_url, 0);
    }
    if (this.body_map != null) {
      paramJceOutputStream.write(this.body_map, 1);
    }
    if (this.wx_mini_program != null) {
      paramJceOutputStream.write(this.wx_mini_program, 2);
    }
    if (this.sq_ark_info != null) {
      paramJceOutputStream.write(this.sq_ark_info, 3);
    }
    if (this.share_icon_url != null) {
      paramJceOutputStream.write(this.share_icon_url, 4);
    }
    if (this.share_icon_title != null) {
      paramJceOutputStream.write(this.share_icon_title, 5);
    }
    if (this.background_url != null) {
      paramJceOutputStream.write(this.background_url, 6);
    }
    paramJceOutputStream.write(this.activity_type, 7);
    if (this.haibao_jump_url != null) {
      paramJceOutputStream.write(this.haibao_jump_url, 8);
    }
    if (this.haibao_body_map != null) {
      paramJceOutputStream.write(this.haibao_body_map, 9);
    }
    if (this.background_title_color != null) {
      paramJceOutputStream.write(this.background_title_color, 10);
    }
    if (this.haibao_desc != null) {
      paramJceOutputStream.write(this.haibao_desc, 11);
    }
    paramJceOutputStream.write(this.share_num, 12);
    if (this.feed_cover_updtime != null) {
      paramJceOutputStream.write(this.feed_cover_updtime, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stShareInfo
 * JD-Core Version:    0.7.0.1
 */