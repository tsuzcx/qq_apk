import android.database.Cursor;
import android.os.Parcel;
import com.tencent.open.agent.datamodel.FriendGroup;
import com.tencent.open.component.cache.database.DbCacheData.DbCreator;
import com.tencent.open.component.cache.database.DbCacheData.Structure;

public final class alcv
  implements DbCacheData.DbCreator
{
  public int a()
  {
    return 0;
  }
  
  public FriendGroup a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getBlob(paramCursor.getColumnIndex("data"));
    if (localObject == null) {
      return null;
    }
    paramCursor = Parcel.obtain();
    paramCursor.unmarshall((byte[])localObject, 0, localObject.length);
    paramCursor.setDataPosition(0);
    localObject = new FriendGroup();
    ((FriendGroup)localObject).a(paramCursor);
    paramCursor.recycle();
    return localObject;
  }
  
  public String a()
  {
    return null;
  }
  
  public DbCacheData.Structure[] a()
  {
    return new DbCacheData.Structure[] { new DbCacheData.Structure("groupId", "INTEGER UNIQUE"), new DbCacheData.Structure("data", "BLOB") };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alcv
 * JD-Core Version:    0.7.0.1
 */