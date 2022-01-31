import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.FieldChangedException;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.UnsupportedFieldTypeException;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ahqv
  extends ahqu
{
  private static int a(Field paramField)
  {
    paramField = paramField.getType();
    int i = -1;
    if (paramField == Byte.TYPE) {
      i = 0;
    }
    do
    {
      return i;
      if (paramField == Integer.TYPE) {
        return 1;
      }
      if (paramField == String.class) {
        return 2;
      }
      if (paramField == CharSequence.class) {
        return 3;
      }
      if (paramField == Boolean.TYPE) {
        return 5;
      }
    } while (paramField != Long.TYPE);
    return 6;
  }
  
  private void a(CharSequence paramCharSequence, Parcel paramParcel)
  {
    if ((paramCharSequence instanceof aykk)) {}
  }
  
  protected Object a(Object paramObject, Field paramField, byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public final void a(Object paramObject, Parcel paramParcel, ArrayList<Field> paramArrayList)
  {
    b(paramObject, paramParcel, paramArrayList);
  }
  
  void a(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel) {}
  
  protected byte[] a(Object paramObject, Field paramField)
  {
    return null;
  }
  
  protected void b(Object paramObject, Parcel paramParcel, ArrayList<Field> paramArrayList)
  {
    HashMap localHashMap = new HashMap(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    Object localObject;
    int i;
    int k;
    while (paramArrayList.hasNext())
    {
      localObject = (Field)paramArrayList.next();
      ((Field)localObject).setAccessible(true);
      String str = ((Field)localObject).getName();
      i = ((Field)localObject).getModifiers();
      localHashMap.put(str + "_" + i, localObject);
      continue;
      switch (k)
      {
      }
    }
    for (;;)
    {
      if (paramParcel.dataAvail() > 0)
      {
        localObject = paramParcel.readString();
        i = paramParcel.readInt();
        k = paramParcel.readInt();
        paramArrayList = (Field)localHashMap.remove((String)localObject + "_" + i);
        if (paramArrayList == null) {
          throw new ParcelHelper.FieldChangedException("Field " + (String)localObject + "(" + paramObject + ") not found");
        }
        int j = a(paramArrayList);
        i = j;
        if (k == 4)
        {
          i = j;
          if (j == -1) {
            i = 4;
          }
        }
        if (i == k) {
          break;
        }
        paramArrayList = new StringBuilder().append("Field ").append((String)localObject).append("(");
        paramParcel = paramObject;
        if (paramObject != null) {
          paramParcel = paramObject.getClass().getName();
        }
        throw new ParcelHelper.FieldChangedException(paramParcel + ") type changed" + k + "->" + i);
        try
        {
          paramArrayList.set(paramObject, Byte.valueOf(paramParcel.readByte()));
        }
        catch (ParcelHelper.FieldChangedException paramObject)
        {
          throw paramObject;
          paramArrayList.set(paramObject, Integer.valueOf(paramParcel.readInt()));
        }
        catch (Throwable paramObject)
        {
          throw new RuntimeException(paramObject);
        }
        paramArrayList.set(paramObject, paramParcel.readString());
        continue;
        paramArrayList.set(paramObject, TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
        continue;
        localObject = new byte[paramParcel.readInt()];
        paramParcel.readByteArray((byte[])localObject);
        paramArrayList.set(paramObject, a(paramObject, paramArrayList, (byte[])localObject));
        continue;
        if (paramParcel.readInt() != 1) {
          break label552;
        }
      }
    }
    label552:
    for (boolean bool = true;; bool = false)
    {
      paramArrayList.set(paramObject, Boolean.valueOf(bool));
      break;
      paramArrayList.set(paramObject, Long.valueOf(paramParcel.readLong()));
      break;
      if (localHashMap.size() > 0)
      {
        paramObject = "object " + paramObject.getClass() + " field changed";
        QLog.e("Recent.Parcel", 1, paramObject);
        throw new RuntimeException(paramObject);
      }
      return;
    }
  }
  
  void b(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel) {}
  
  final boolean b(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel)
  {
    return c(paramObject, paramArrayList, paramParcel);
  }
  
  protected final boolean c(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel)
  {
    Field localField;
    int j;
    for (;;)
    {
      try
      {
        localIterator = paramArrayList.iterator();
        paramArrayList = null;
      }
      catch (ParcelHelper.UnsupportedFieldTypeException paramObject)
      {
        Iterator localIterator;
        throw paramObject;
        paramParcel.writeInt(localField.getInt(paramObject));
        continue;
      }
      catch (IllegalAccessException paramObject)
      {
        label68:
        throw new RuntimeException(paramObject);
      }
      if (!localIterator.hasNext()) {
        break;
      }
      localField = (Field)localIterator.next();
      localField.setAccessible(true);
      j = a(localField);
      i = j;
      if (j == -1)
      {
        paramArrayList = a(paramObject, localField);
        if (paramArrayList == null) {
          break label331;
        }
        i = 4;
      }
      if (i == -1) {
        QLog.d("Recent.Parcel", 2, "Unsupported type " + paramObject.getClass() + "(" + localField.getName() + ")");
      }
      paramParcel.writeString(localField.getName());
      paramParcel.writeInt(localField.getModifiers());
      paramParcel.writeInt(i);
      switch (i)
      {
      case 0: 
        paramParcel.writeByte(localField.getByte(paramObject));
        break;
      case 1: 
      case 2: 
        paramParcel.writeString((String)localField.get(paramObject));
        break;
      case 7: 
        a((CharSequence)localField.get(paramObject), paramParcel);
        break;
      case 3: 
        TextUtils.writeToParcel((CharSequence)localField.get(paramObject), paramParcel, 0);
        break;
      case 4: 
        paramParcel.writeInt(paramArrayList.length);
        paramParcel.writeByteArray(paramArrayList);
      }
    }
    if (localField.getBoolean(paramObject)) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      break;
      paramParcel.writeLong(localField.getLong(paramObject));
      break;
      return true;
      label331:
      i = j;
      break label68;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahqv
 * JD-Core Version:    0.7.0.1
 */