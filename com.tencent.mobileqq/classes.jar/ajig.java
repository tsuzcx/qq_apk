import android.os.Parcel;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.UnsupportedFieldTypeException;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ajig
  extends ajie
{
  private static final byte[] a = { 1, 2, 3, 0 };
  private static final byte[] b = { 2, 3, 4, 1 };
  
  private static final boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramArrayOfByte1 == null);
        bool1 = bool2;
      } while (paramArrayOfByte2 == null);
      bool1 = bool2;
    } while (paramArrayOfByte1.length != paramArrayOfByte2.length);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte1.length) {
        break label66;
      }
      bool1 = bool2;
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label66:
    return true;
  }
  
  protected Object a(Object paramObject, Field paramField, byte[] paramArrayOfByte)
  {
    if ((paramObject instanceof RecentBaseData))
    {
      if (paramField.getType() == MsgSummary.class)
      {
        paramObject = Parcel.obtain();
        try
        {
          paramObject.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
          paramObject.setDataPosition(0);
          paramField = new byte[4];
          paramObject.readByteArray(paramField);
          boolean bool = a(paramField, a);
          if (bool) {
            return null;
          }
          if (!a(paramField, b)) {
            throw new RuntimeException("Bad MsgSummary header");
          }
        }
        finally
        {
          paramObject.recycle();
        }
        paramField = new MsgSummary();
        b(paramField, paramObject, ParcelHelper.a(paramField));
        paramObject.recycle();
        return paramField;
      }
      QLog.e("Recent.Processor", 1, new Object[] { "unparcel unrecognize type ", paramField.getType(), "(", paramObject.getClass(), ")" });
      return null;
    }
    QLog.e("Recent.Processor", 1, new Object[] { "unparcel unrecognize type ", paramField.getType(), "(", paramObject.getClass(), ")" });
    return null;
  }
  
  void a(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel)
  {
    super.a(paramObject, paramArrayList, paramParcel);
  }
  
  protected byte[] a(Object paramObject, Field paramField)
  {
    if ((paramObject instanceof RecentBaseData))
    {
      if (paramField.getType() == MsgSummary.class)
      {
        Parcel localParcel = Parcel.obtain();
        localParcel.setDataPosition(0);
        try
        {
          localObject = (MsgSummary)paramField.get(paramObject);
          if (localObject == null) {
            localParcel.writeByteArray(a);
          }
          for (;;)
          {
            paramObject = localParcel.marshall();
            localParcel.recycle();
            return paramObject;
            localParcel.writeByteArray(b);
            c(localObject, ParcelHelper.a(localObject), localParcel);
          }
          paramObject = paramObject.getClass();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localObject = new StringBuilder().append("get MsgSummary error. object=");
          if (paramObject == null) {
            break label145;
          }
        }
        Object localObject = ((StringBuilder)localObject).append(paramObject).append(", field=");
        if (paramField != null) {}
        for (paramObject = paramField.getName();; paramObject = "NullField")
        {
          throw new RuntimeException(paramObject, localIllegalAccessException);
          label145:
          paramObject = "NullObject";
          break;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder().append("unrecognize type ");
      if (paramField != null)
      {
        paramField = paramField.getType();
        paramField = localStringBuilder.append(paramField).append("(");
        if (paramObject == null) {
          break label226;
        }
      }
      label226:
      for (paramObject = paramObject.getClass();; paramObject = "NullObject")
      {
        throw new ParcelHelper.UnsupportedFieldTypeException(paramObject + ")");
        paramField = "NullField";
        break;
      }
    }
    QLog.e("Recent.Processor", 1, new Object[] { "parcel unrecognize type ", paramField.getType(), "(", paramObject.getClass(), ")" });
    return null;
  }
  
  void b(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel)
  {
    super.b(paramObject, paramArrayList, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajig
 * JD-Core Version:    0.7.0.1
 */