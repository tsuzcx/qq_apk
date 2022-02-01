package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetSkinListRsp
  extends JceStruct
{
  static ArrayList<SkinInfo> cache_skin_list = new ArrayList();
  public boolean is_hide_list = false;
  public String more_skin_url = "";
  public String operate_desc = "";
  public String operate_url = "";
  public int selected_id = 0;
  public ArrayList<SkinInfo> skin_list = null;
  
  static
  {
    SkinInfo localSkinInfo = new SkinInfo();
    cache_skin_list.add(localSkinInfo);
  }
  
  public GetSkinListRsp() {}
  
  public GetSkinListRsp(ArrayList<SkinInfo> paramArrayList, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.skin_list = paramArrayList;
    this.selected_id = paramInt;
    this.more_skin_url = paramString1;
    this.operate_url = paramString2;
    this.operate_desc = paramString3;
    this.is_hide_list = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.skin_list = ((ArrayList)paramJceInputStream.read(cache_skin_list, 0, true));
    this.selected_id = paramJceInputStream.read(this.selected_id, 1, true);
    this.more_skin_url = paramJceInputStream.readString(2, false);
    this.operate_url = paramJceInputStream.readString(3, false);
    this.operate_desc = paramJceInputStream.readString(4, false);
    this.is_hide_list = paramJceInputStream.read(this.is_hide_list, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.skin_list, 0);
    paramJceOutputStream.write(this.selected_id, 1);
    String str = this.more_skin_url;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.operate_url;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.operate_desc;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.is_hide_list, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.GetSkinListRsp
 * JD-Core Version:    0.7.0.1
 */