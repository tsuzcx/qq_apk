import android.os.Bundle;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;

public class akgf
  implements ajtg
{
  protected void a(int paramInt, Bundle paramBundle) {}
  
  protected void a(int paramInt, String paramString) {}
  
  protected void a(Object paramObject) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void b(int paramInt, Bundle paramBundle) {}
  
  protected void b(int paramInt, String paramString) {}
  
  protected void b(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    String str = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int i = -1;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      b(paramInt, (Bundle)paramObject);
      return;
    case 2: 
      a(paramInt, (Bundle)paramObject);
      return;
    case 3: 
      i = 0;
      str = "";
      localObject1 = str;
      paramInt = i;
      if (paramBoolean)
      {
        paramObject = (Bundle)paramObject;
        localObject1 = str;
        paramInt = i;
        if (paramObject != null)
        {
          paramInt = paramObject.getInt("status");
          localObject1 = paramObject.getString("wording");
        }
      }
      a(paramBoolean, paramInt, (String)localObject1);
      return;
    case 4: 
      if (paramBoolean)
      {
        paramObject = (Bundle)paramObject;
        if (paramObject != null)
        {
          paramInt = paramObject.getInt(AuthDevRenameActivity.i);
          localObject1 = paramObject.getByteArray(AuthDevRenameActivity.h);
          paramObject = paramObject.getString(AuthDevRenameActivity.f);
        }
      }
      break;
    }
    for (;;)
    {
      a(paramBoolean, paramInt, (byte[])localObject1, paramObject);
      return;
      a(paramBoolean, (Bundle)paramObject);
      return;
      b(paramBoolean, (Bundle)paramObject);
      return;
      localObject1 = (Bundle)paramObject;
      paramObject = str;
      if (localObject1 != null)
      {
        i = ((Bundle)localObject1).getInt("ret_code", -1);
        paramObject = ((Bundle)localObject1).getString("err_msg");
      }
      a(i, paramObject);
      return;
      localObject1 = (Bundle)paramObject;
      paramObject = localObject2;
      if (localObject1 != null)
      {
        i = ((Bundle)localObject1).getInt("ret_code", -1);
        paramObject = ((Bundle)localObject1).getString("err_msg");
      }
      b(i, paramObject);
      return;
      a(paramObject);
      return;
      paramInt = -1;
      str = null;
      paramObject = localObject1;
      localObject1 = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akgf
 * JD-Core Version:    0.7.0.1
 */