package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_tab_list_item
  extends JceStruct
{
  static int cache_tab_id = 0;
  public boolean can_edit = true;
  public String icon_url = "";
  public boolean is_custom = true;
  public String jump_url = "";
  public boolean need_clear_red = true;
  public int red_id_mainpage = 0;
  public int red_id_undelcount = 0;
  public int tab_id = 0;
  public String text = "";
  
  public s_tab_list_item() {}
  
  public s_tab_list_item(int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.tab_id = paramInt1;
    this.icon_url = paramString1;
    this.jump_url = paramString2;
    this.text = paramString3;
    this.is_custom = paramBoolean1;
    this.red_id_mainpage = paramInt2;
    this.red_id_undelcount = paramInt3;
    this.can_edit = paramBoolean2;
    this.need_clear_red = paramBoolean3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tab_id = paramJceInputStream.read(this.tab_id, 0, true);
    this.icon_url = paramJceInputStream.readString(1, true);
    this.jump_url = paramJceInputStream.readString(2, true);
    this.text = paramJceInputStream.readString(3, true);
    this.is_custom = paramJceInputStream.read(this.is_custom, 4, true);
    this.red_id_mainpage = paramJceInputStream.read(this.red_id_mainpage, 5, true);
    this.red_id_undelcount = paramJceInputStream.read(this.red_id_undelcount, 6, true);
    this.can_edit = paramJceInputStream.read(this.can_edit, 7, true);
    this.need_clear_red = paramJceInputStream.read(this.need_clear_red, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tab_id, 0);
    paramJceOutputStream.write(this.icon_url, 1);
    paramJceOutputStream.write(this.jump_url, 2);
    paramJceOutputStream.write(this.text, 3);
    paramJceOutputStream.write(this.is_custom, 4);
    paramJceOutputStream.write(this.red_id_mainpage, 5);
    paramJceOutputStream.write(this.red_id_undelcount, 6);
    paramJceOutputStream.write(this.can_edit, 7);
    paramJceOutputStream.write(this.need_clear_red, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_tab_list_item
 * JD-Core Version:    0.7.0.1
 */