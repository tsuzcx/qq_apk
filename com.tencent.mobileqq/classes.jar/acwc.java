import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

class acwc
  implements Cursor
{
  private int jdField_a_of_type_Int = -1;
  private acwf jdField_a_of_type_Acwf;
  private List<MessageRecord> jdField_a_of_type_JavaUtilList;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "_id", "selfuin", "frienduin", "senderuin", "time", "msg", "msgtype", "isread", "issend", "msgseq", "shmsgseq", "istroop", "extraflag", "troopnick", "friendnick", "versionCode", "msgData", "vipBubbleID", "msgUid", "uniseq", "sendFailCode", "versionCode" };
  
  protected acwc(acwf paramacwf, List<MessageRecord> paramList)
  {
    this.jdField_a_of_type_Acwf = paramacwf;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private Object a(int paramInt)
  {
    MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
    case 1: 
      return Long.valueOf(localMessageRecord.msgId);
    case 2: 
      return localMessageRecord.selfuin;
    case 3: 
      return localMessageRecord.frienduin;
    case 4: 
      return localMessageRecord.senderuin;
    case 5: 
      return Long.valueOf(localMessageRecord.time);
    case 6: 
      return localMessageRecord.msg;
    case 7: 
      return Integer.valueOf(localMessageRecord.msgtype);
    case 8: 
      if (localMessageRecord.isread) {}
      for (paramInt = 1;; paramInt = 0) {
        return Integer.valueOf(paramInt);
      }
    case 9: 
      return Integer.valueOf(localMessageRecord.issend);
    case 10: 
      return Long.valueOf(localMessageRecord.msgseq);
    case 11: 
      return Long.valueOf(localMessageRecord.shmsgseq);
    case 12: 
      return Integer.valueOf(localMessageRecord.istroop);
    case 13: 
      return Integer.valueOf(localMessageRecord.extraflag);
    case 14: 
      return bglf.a(this.jdField_a_of_type_Acwf.a(), localMessageRecord.senderuin, localMessageRecord.frienduin, 1, 0);
    case 15: 
      if (localMessageRecord.istroop == 3000) {
        return bglf.d(this.jdField_a_of_type_Acwf.a(), localMessageRecord.senderuin);
      }
      if (localMessageRecord.istroop == 1) {
        return ((TroopManager)this.jdField_a_of_type_Acwf.a().getManager(52)).a(localMessageRecord.senderuin);
      }
      return bglf.a(this.jdField_a_of_type_Acwf.a(), localMessageRecord.senderuin);
    case 16: 
      return Integer.valueOf(((anmw)this.jdField_a_of_type_Acwf.a().getManager(51)).b(localMessageRecord.frienduin));
    case 17: 
      return Integer.valueOf(localMessageRecord.versionCode);
    case 18: 
      return localMessageRecord.msgData;
    case 19: 
      return Long.valueOf(localMessageRecord.vipBubbleID);
    case 20: 
      return Long.valueOf(localMessageRecord.msgUid);
    case 21: 
      return Long.valueOf(localMessageRecord.uniseq);
    case 22: 
      return Integer.valueOf(localMessageRecord.sendFailCode);
    }
    return Integer.valueOf(localMessageRecord.versionCode);
  }
  
  public void close() {}
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void deactivate() {}
  
  public byte[] getBlob(int paramInt)
  {
    localObject = a(paramInt);
    if ((localObject instanceof byte[])) {
      return (byte[])localObject;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(localObject);
      localObjectOutputStream.flush();
      localObject = localByteArrayOutputStream.toByteArray();
      try
      {
        localObjectOutputStream.close();
        localByteArrayOutputStream.close();
        return localObject;
      }
      catch (IOException localIOException1) {}
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        localObject = null;
      }
    }
    localIOException1.printStackTrace();
    return localObject;
  }
  
  public int getColumnCount()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString.length;
  }
  
  public int getColumnIndex(String paramString)
  {
    if ("_id".equalsIgnoreCase(paramString)) {
      return 1;
    }
    if ("selfuin".equals(paramString)) {
      return 2;
    }
    if ("frienduin".equals(paramString)) {
      return 3;
    }
    if ("senderuin".equals(paramString)) {
      return 4;
    }
    if ("time".equals(paramString)) {
      return 5;
    }
    if ("msg".equals(paramString)) {
      return 6;
    }
    if ("msgtype".equals(paramString)) {
      return 7;
    }
    if ("isread".equals(paramString)) {
      return 8;
    }
    if ("issend".equals(paramString)) {
      return 9;
    }
    if ("msgseq".equals(paramString)) {
      return 10;
    }
    if ("shmsgseq".equals(paramString)) {
      return 11;
    }
    if ("istroop".equals(paramString)) {
      return 12;
    }
    if ("extraflag".equals(paramString)) {
      return 13;
    }
    if ("troopnick".equals(paramString)) {
      return 14;
    }
    if ("friendnick".equals(paramString)) {
      return 15;
    }
    if ("friendstatus".equals(paramString)) {
      return 16;
    }
    if ("versionCode".equals(paramString)) {
      return 17;
    }
    if ("msgData".equals(paramString)) {
      return 18;
    }
    if ("vipBubbleID".equals(paramString)) {
      return 19;
    }
    if ("msgUid".equals(paramString)) {
      return 20;
    }
    if ("uniseq".equals(paramString)) {
      return 21;
    }
    if ("sendFailCode".equals(paramString)) {
      return 22;
    }
    if ("versionCode".equals(paramString)) {
      return 23;
    }
    return -1;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    if (getColumnIndex(paramString) < 0) {
      throw new IllegalArgumentException();
    }
    return getColumnIndex(paramString);
  }
  
  public String getColumnName(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length)) {
      return this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    return null;
  }
  
  public String[] getColumnNames()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public double getDouble(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public Bundle getExtras()
  {
    throw new UnsupportedOperationException();
  }
  
  public float getFloat(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public int getInt(int paramInt)
  {
    return ((Integer)a(paramInt)).intValue();
  }
  
  public long getLong(int paramInt)
  {
    return ((Long)a(paramInt)).longValue();
  }
  
  public Uri getNotificationUri()
  {
    throw new UnsupportedOperationException();
  }
  
  public int getPosition()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public short getShort(int paramInt)
  {
    return ((Short)a(paramInt)).shortValue();
  }
  
  public String getString(int paramInt)
  {
    return String.valueOf(a(paramInt));
  }
  
  public int getType(int paramInt)
  {
    return 0;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isAfterLast()
  {
    return this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size() - 1;
  }
  
  public boolean isBeforeFirst()
  {
    return this.jdField_a_of_type_Int > 0;
  }
  
  public boolean isClosed()
  {
    return false;
  }
  
  public boolean isFirst()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public boolean isLast()
  {
    return this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilList.size() - 1;
  }
  
  public boolean isNull(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean move(int paramInt)
  {
    if ((this.jdField_a_of_type_Int + paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (this.jdField_a_of_type_Int + paramInt >= 0))
    {
      this.jdField_a_of_type_Int += paramInt;
      return true;
    }
    return false;
  }
  
  public boolean moveToFirst()
  {
    boolean bool = false;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean moveToLast()
  {
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
    return true;
  }
  
  public boolean moveToNext()
  {
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      this.jdField_a_of_type_Int += 1;
      return true;
    }
    return false;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    if ((paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt >= 0))
    {
      this.jdField_a_of_type_Int = paramInt;
      return true;
    }
    return false;
  }
  
  public boolean moveToPrevious()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_Int -= 1;
      return true;
    }
    return false;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public boolean requery()
  {
    return false;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setExtras(Bundle paramBundle) {}
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    throw new UnsupportedOperationException();
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwc
 * JD-Core Version:    0.7.0.1
 */