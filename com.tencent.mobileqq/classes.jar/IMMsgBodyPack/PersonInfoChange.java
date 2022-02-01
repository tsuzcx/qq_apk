package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PersonInfoChange
  extends JceStruct
{
  static ArrayList<PersonInfoField> cache_vChgField;
  public byte cType = 0;
  public ArrayList<PersonInfoField> vChgField = null;
  
  public PersonInfoChange() {}
  
  public PersonInfoChange(byte paramByte, ArrayList<PersonInfoField> paramArrayList)
  {
    this.cType = paramByte;
    this.vChgField = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cType = paramJceInputStream.read(this.cType, 0, false);
    if (cache_vChgField == null)
    {
      cache_vChgField = new ArrayList();
      PersonInfoField localPersonInfoField = new PersonInfoField();
      cache_vChgField.add(localPersonInfoField);
    }
    this.vChgField = ((ArrayList)paramJceInputStream.read(cache_vChgField, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cType, 0);
    if (this.vChgField != null) {
      paramJceOutputStream.write(this.vChgField, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     IMMsgBodyPack.PersonInfoChange
 * JD-Core Version:    0.7.0.1
 */