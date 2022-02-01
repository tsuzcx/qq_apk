package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class ItemInfo
  extends JceStruct
{
  static ArrayList<ActionInfo> cache_action_infos;
  static RuleInfo cache_rule_info;
  static ArrayList<String> cache_sub_item_id = new ArrayList();
  public ArrayList<ActionInfo> action_infos = null;
  public String busi_info = "";
  public String item_id = "";
  public String item_type = "";
  public String module_id = "";
  public String position_id = "";
  public RuleInfo rule_info = null;
  public ArrayList<String> sub_item_id = null;
  public String sub_module_id = "";
  public String trigger_info = "";
  
  static
  {
    cache_sub_item_id.add("");
    cache_rule_info = new RuleInfo();
    cache_action_infos = new ArrayList();
    ActionInfo localActionInfo = new ActionInfo();
    cache_action_infos.add(localActionInfo);
  }
  
  public ItemInfo() {}
  
  public ItemInfo(String paramString1, ArrayList<String> paramArrayList, String paramString2, String paramString3, String paramString4, RuleInfo paramRuleInfo, ArrayList<ActionInfo> paramArrayList1, String paramString5, String paramString6, String paramString7)
  {
    this.item_id = paramString1;
    this.sub_item_id = paramArrayList;
    this.module_id = paramString2;
    this.sub_module_id = paramString3;
    this.position_id = paramString4;
    this.rule_info = paramRuleInfo;
    this.action_infos = paramArrayList1;
    this.trigger_info = paramString5;
    this.busi_info = paramString6;
    this.item_type = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.item_id = paramJceInputStream.readString(0, true);
    this.sub_item_id = ((ArrayList)paramJceInputStream.read(cache_sub_item_id, 1, false));
    this.module_id = paramJceInputStream.readString(2, false);
    this.sub_module_id = paramJceInputStream.readString(3, false);
    this.position_id = paramJceInputStream.readString(4, false);
    this.rule_info = ((RuleInfo)paramJceInputStream.read(cache_rule_info, 5, false));
    this.action_infos = ((ArrayList)paramJceInputStream.read(cache_action_infos, 6, true));
    this.trigger_info = paramJceInputStream.readString(7, false);
    this.busi_info = paramJceInputStream.readString(8, false);
    this.item_type = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.item_id, 0);
    Object localObject = this.sub_item_id;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.module_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.sub_module_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.position_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.rule_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.action_infos, 6);
    localObject = this.trigger_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.busi_info;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.item_type;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_USER_ACTION_REPORT.ItemInfo
 * JD-Core Version:    0.7.0.1
 */