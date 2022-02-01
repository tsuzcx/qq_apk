package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_sub_getspaceright_rsp
  extends JceStruct
{
  static Map<Short, GROUP_RIGHT_INFO> cache_allGroups;
  static s_question cache_question;
  static Map<Long, FRIEND_INFO> cache_white_list;
  public Map<Short, GROUP_RIGHT_INFO> allGroups;
  public long cur_seq;
  public s_question question;
  public int rightval;
  public Map<Long, FRIEND_INFO> white_list;
  
  public mobile_sub_getspaceright_rsp() {}
  
  public mobile_sub_getspaceright_rsp(int paramInt, Map<Short, GROUP_RIGHT_INFO> paramMap, long paramLong, s_question params_question, Map<Long, FRIEND_INFO> paramMap1)
  {
    this.rightval = paramInt;
    this.allGroups = paramMap;
    this.cur_seq = paramLong;
    this.question = params_question;
    this.white_list = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.rightval = paramJceInputStream.read(this.rightval, 0, true);
    Object localObject;
    if (cache_allGroups == null)
    {
      cache_allGroups = new HashMap();
      localObject = new GROUP_RIGHT_INFO();
      cache_allGroups.put(Short.valueOf((short)0), localObject);
    }
    this.allGroups = ((Map)paramJceInputStream.read(cache_allGroups, 1, false));
    this.cur_seq = paramJceInputStream.read(this.cur_seq, 2, false);
    if (cache_question == null) {
      cache_question = new s_question();
    }
    this.question = ((s_question)paramJceInputStream.read(cache_question, 3, false));
    if (cache_white_list == null)
    {
      cache_white_list = new HashMap();
      localObject = new FRIEND_INFO();
      cache_white_list.put(Long.valueOf(0L), localObject);
    }
    this.white_list = ((Map)paramJceInputStream.read(cache_white_list, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.rightval, 0);
    Object localObject = this.allGroups;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 1);
    }
    paramJceOutputStream.write(this.cur_seq, 2);
    localObject = this.question;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.white_list;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_getspaceright_rsp
 * JD-Core Version:    0.7.0.1
 */