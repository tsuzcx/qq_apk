package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SkinInfo
  extends JceStruct
{
  static PopDialog cache_pop_dialog = new PopDialog();
  public String blessing = "";
  public int is_hide_title = 0;
  public PopDialog pop_dialog = null;
  public int skin_id = 0;
  public String skin_name = "";
  public long skin_permission_state = 0L;
  
  public SkinInfo() {}
  
  public SkinInfo(int paramInt1, long paramLong, String paramString1, PopDialog paramPopDialog, int paramInt2, String paramString2)
  {
    this.skin_id = paramInt1;
    this.skin_permission_state = paramLong;
    this.skin_name = paramString1;
    this.pop_dialog = paramPopDialog;
    this.is_hide_title = paramInt2;
    this.blessing = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.skin_id = paramJceInputStream.read(this.skin_id, 0, true);
    this.skin_permission_state = paramJceInputStream.read(this.skin_permission_state, 1, true);
    this.skin_name = paramJceInputStream.readString(2, true);
    this.pop_dialog = ((PopDialog)paramJceInputStream.read(cache_pop_dialog, 3, false));
    this.is_hide_title = paramJceInputStream.read(this.is_hide_title, 4, false);
    this.blessing = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.skin_id, 0);
    paramJceOutputStream.write(this.skin_permission_state, 1);
    paramJceOutputStream.write(this.skin_name, 2);
    Object localObject = this.pop_dialog;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    paramJceOutputStream.write(this.is_hide_title, 4);
    localObject = this.blessing;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.SkinInfo
 * JD-Core Version:    0.7.0.1
 */