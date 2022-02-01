package Wallet;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class ApkgConfig
  extends JceStruct
{
  private static final int BIT_DEBUG_RUNTIME = 4;
  private static final int BIT_INNER_USER = 2;
  private static final int BIT_RISK_SWITCH = 1;
  static ArrayList<AllowDomainInfo> cache_allow_domains;
  static Map<String, String> cache_sub_apkg_urls = new HashMap();
  public ArrayList<AllowDomainInfo> allow_domains = null;
  public String apkg_url = "";
  public String app_name = "";
  public int bit_control = 0;
  public String cos_sign = "";
  public String desc_info = "";
  public String icon_url = "";
  public String mini_appid = "";
  public int mini_version = 0;
  public String qq_qr_code = "";
  public String share_pic_url = "";
  public Map<String, String> sub_apkg_urls = null;
  public String union_id = "";
  public String wx_qr_code = "";
  
  static
  {
    cache_sub_apkg_urls.put("", "");
    cache_allow_domains = new ArrayList();
    AllowDomainInfo localAllowDomainInfo = new AllowDomainInfo();
    cache_allow_domains.add(localAllowDomainInfo);
  }
  
  public ApkgConfig() {}
  
  public ApkgConfig(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, Map<String, String> paramMap, String paramString6, String paramString7, int paramInt2, ArrayList<AllowDomainInfo> paramArrayList, String paramString8, String paramString9, String paramString10)
  {
    this.mini_appid = paramString1;
    this.union_id = paramString2;
    this.app_name = paramString3;
    this.mini_version = paramInt1;
    this.icon_url = paramString4;
    this.apkg_url = paramString5;
    this.sub_apkg_urls = paramMap;
    this.desc_info = paramString6;
    this.share_pic_url = paramString7;
    this.bit_control = paramInt2;
    this.allow_domains = paramArrayList;
    this.wx_qr_code = paramString8;
    this.qq_qr_code = paramString9;
    this.cos_sign = paramString10;
  }
  
  public boolean isInnerUser()
  {
    return (this.bit_control & 0x2) != 0;
  }
  
  public boolean isRiskOpen()
  {
    return (this.bit_control & 0x1) != 0;
  }
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.mini_appid)) && (!TextUtils.isEmpty(this.app_name)) && (!TextUtils.isEmpty(this.icon_url)) && (!TextUtils.isEmpty(this.apkg_url));
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mini_appid = paramJceInputStream.readString(0, false);
    this.union_id = paramJceInputStream.readString(1, false);
    this.app_name = paramJceInputStream.readString(2, false);
    this.mini_version = paramJceInputStream.read(this.mini_version, 3, false);
    this.icon_url = paramJceInputStream.readString(4, false);
    this.apkg_url = paramJceInputStream.readString(5, false);
    this.sub_apkg_urls = ((Map)paramJceInputStream.read(cache_sub_apkg_urls, 6, false));
    this.desc_info = paramJceInputStream.readString(7, false);
    this.share_pic_url = paramJceInputStream.readString(8, false);
    this.bit_control = paramJceInputStream.read(this.bit_control, 9, false);
    this.allow_domains = ((ArrayList)paramJceInputStream.read(cache_allow_domains, 10, false));
    this.wx_qr_code = paramJceInputStream.readString(11, false);
    this.qq_qr_code = paramJceInputStream.readString(12, false);
    this.cos_sign = paramJceInputStream.readString(13, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApkgConfig{mini_appid='");
    localStringBuilder.append(this.mini_appid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", union_id='");
    localStringBuilder.append(this.union_id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", app_name='");
    localStringBuilder.append(this.app_name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mini_version=");
    localStringBuilder.append(this.mini_version);
    localStringBuilder.append(", icon_url='");
    localStringBuilder.append(this.icon_url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadUrl='");
    localStringBuilder.append(this.apkg_url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", sub_apkg_urls=");
    localStringBuilder.append(this.sub_apkg_urls);
    localStringBuilder.append(", desc_info='");
    localStringBuilder.append(this.desc_info);
    localStringBuilder.append('\'');
    localStringBuilder.append(", share_pic_url='");
    localStringBuilder.append(this.share_pic_url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bit_control=");
    localStringBuilder.append(this.bit_control);
    localStringBuilder.append(", allow_domains=");
    localStringBuilder.append(this.allow_domains);
    localStringBuilder.append(", wx_qr_code='");
    localStringBuilder.append(this.wx_qr_code);
    localStringBuilder.append('\'');
    localStringBuilder.append(", qq_qr_code='");
    localStringBuilder.append(this.qq_qr_code);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cos_sign='");
    localStringBuilder.append(this.cos_sign);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.mini_appid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.union_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.app_name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.mini_version, 3);
    localObject = this.icon_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.apkg_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.sub_apkg_urls;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
    localObject = this.desc_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.share_pic_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.bit_control, 9);
    localObject = this.allow_domains;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 10);
    }
    localObject = this.wx_qr_code;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    localObject = this.qq_qr_code;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.cos_sign;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.ApkgConfig
 * JD-Core Version:    0.7.0.1
 */