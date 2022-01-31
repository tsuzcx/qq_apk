import android.os.Bundle;
import android.text.TextUtils;

public final class aaqw
{
  public Bundle a;
  
  public aaqw(Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public String a()
  {
    if (this.a != null) {
      return this.a.getString("IPC_ACTION");
    }
    return null;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(a())) && (!TextUtils.isEmpty(b()));
  }
  
  public String b()
  {
    if (this.a != null) {
      return this.a.getString("IPC_TO_PROCESS_NAME");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqw
 * JD-Core Version:    0.7.0.1
 */