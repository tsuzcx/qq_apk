package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class cluster_identify_face_rsp
  extends JceStruct
{
  static int cache_mode;
  static ArrayList<cluster_search_result> cache_results = new ArrayList();
  public boolean has_identify = false;
  public int mode = 1;
  public String msg = "";
  public ArrayList<cluster_search_result> results = null;
  public int ret = 0;
  public String url = "";
  
  static
  {
    cluster_search_result localcluster_search_result = new cluster_search_result();
    cache_results.add(localcluster_search_result);
  }
  
  public cluster_identify_face_rsp() {}
  
  public cluster_identify_face_rsp(int paramInt1, String paramString1, boolean paramBoolean, int paramInt2, ArrayList<cluster_search_result> paramArrayList, String paramString2)
  {
    this.ret = paramInt1;
    this.msg = paramString1;
    this.has_identify = paramBoolean;
    this.mode = paramInt2;
    this.results = paramArrayList;
    this.url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.has_identify = paramJceInputStream.read(this.has_identify, 2, false);
    this.mode = paramJceInputStream.read(this.mode, 3, false);
    this.results = ((ArrayList)paramJceInputStream.read(cache_results, 4, false));
    this.url = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.has_identify, 2);
    paramJceOutputStream.write(this.mode, 3);
    localObject = this.results;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    localObject = this.url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.cluster_identify_face_rsp
 * JD-Core Version:    0.7.0.1
 */