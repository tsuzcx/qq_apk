package PUSH_UPDATE_FEEDS;

import NS_MOBILE_FEEDS.SimpleComment;
import NS_MOBILE_FEEDS.s_commment;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class CommentReplyInfo
  extends JceStruct
{
  static ArrayList<SimpleComment> cache_all_commont_list = new ArrayList();
  static s_commment cache_cur_comment_reply = new s_commment();
  public ArrayList<SimpleComment> all_commont_list = null;
  public s_commment cur_comment_reply = null;
  public int real_num = 0;
  public int total_num = 0;
  
  static
  {
    SimpleComment localSimpleComment = new SimpleComment();
    cache_all_commont_list.add(localSimpleComment);
  }
  
  public CommentReplyInfo() {}
  
  public CommentReplyInfo(ArrayList<SimpleComment> paramArrayList, s_commment params_commment, int paramInt1, int paramInt2)
  {
    this.all_commont_list = paramArrayList;
    this.cur_comment_reply = params_commment;
    this.total_num = paramInt1;
    this.real_num = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.all_commont_list = ((ArrayList)paramJceInputStream.read(cache_all_commont_list, 0, false));
    this.cur_comment_reply = ((s_commment)paramJceInputStream.read(cache_cur_comment_reply, 1, false));
    this.total_num = paramJceInputStream.read(this.total_num, 2, false);
    this.real_num = paramJceInputStream.read(this.real_num, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.all_commont_list;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.cur_comment_reply;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    paramJceOutputStream.write(this.total_num, 2);
    paramJceOutputStream.write(this.real_num, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     PUSH_UPDATE_FEEDS.CommentReplyInfo
 * JD-Core Version:    0.7.0.1
 */