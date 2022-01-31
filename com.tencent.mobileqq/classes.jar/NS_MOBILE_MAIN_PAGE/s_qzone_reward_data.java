package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_qzone_reward_data
  extends JceStruct
{
  static ArrayList<s_reward_node> cache_vec_nodes = new ArrayList();
  public boolean show_entry = true;
  public ArrayList<s_reward_node> vec_nodes;
  
  static
  {
    s_reward_node locals_reward_node = new s_reward_node();
    cache_vec_nodes.add(locals_reward_node);
  }
  
  public s_qzone_reward_data() {}
  
  public s_qzone_reward_data(boolean paramBoolean, ArrayList<s_reward_node> paramArrayList)
  {
    this.show_entry = paramBoolean;
    this.vec_nodes = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.show_entry = paramJceInputStream.read(this.show_entry, 0, true);
    this.vec_nodes = ((ArrayList)paramJceInputStream.read(cache_vec_nodes, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.show_entry, 0);
    if (this.vec_nodes != null) {
      paramJceOutputStream.write(this.vec_nodes, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_qzone_reward_data
 * JD-Core Version:    0.7.0.1
 */