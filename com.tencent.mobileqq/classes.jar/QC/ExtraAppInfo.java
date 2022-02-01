package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class ExtraAppInfo
  extends JceStruct
{
  static ArrayList<FuncallOp> cache_funcallOplist;
  static ArrayList<Integer> cache_usableScene = new ArrayList();
  public String desc = "";
  public int fontType = 0;
  public ArrayList<FuncallOp> funcallOplist = null;
  public String hideWordName = "";
  public int ringid = 0;
  public int specialType = 0;
  public int styleid = 0;
  public ArrayList<Integer> usableScene = null;
  
  static
  {
    cache_usableScene.add(Integer.valueOf(0));
    cache_funcallOplist = new ArrayList();
    FuncallOp localFuncallOp = new FuncallOp();
    cache_funcallOplist.add(localFuncallOp);
  }
  
  public ExtraAppInfo() {}
  
  public ExtraAppInfo(int paramInt1, int paramInt2, String paramString1, ArrayList<Integer> paramArrayList, String paramString2, int paramInt3, int paramInt4, ArrayList<FuncallOp> paramArrayList1)
  {
    this.fontType = paramInt1;
    this.specialType = paramInt2;
    this.desc = paramString1;
    this.usableScene = paramArrayList;
    this.hideWordName = paramString2;
    this.styleid = paramInt3;
    this.ringid = paramInt4;
    this.funcallOplist = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fontType = paramJceInputStream.read(this.fontType, 0, false);
    this.specialType = paramJceInputStream.read(this.specialType, 1, false);
    this.desc = paramJceInputStream.readString(2, false);
    this.usableScene = ((ArrayList)paramJceInputStream.read(cache_usableScene, 3, false));
    this.hideWordName = paramJceInputStream.readString(4, false);
    this.styleid = paramJceInputStream.read(this.styleid, 5, false);
    this.ringid = paramJceInputStream.read(this.ringid, 6, false);
    this.funcallOplist = ((ArrayList)paramJceInputStream.read(cache_funcallOplist, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fontType, 0);
    paramJceOutputStream.write(this.specialType, 1);
    Object localObject = this.desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.usableScene;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.hideWordName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.styleid, 5);
    paramJceOutputStream.write(this.ringid, 6);
    localObject = this.funcallOplist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.ExtraAppInfo
 * JD-Core Version:    0.7.0.1
 */