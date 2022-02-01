import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;

class aaqg
  implements aaea
{
  aaqg(aaqc paramaaqc) {}
  
  public void callback(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("isSuccess")))
    {
      ArrayList localArrayList = paramBundle.getStringArrayList("uins");
      paramBundle = paramBundle.getStringArrayList("tinyIds");
      int i = 0;
      while (i < localArrayList.size())
      {
        aaqc.a(this.a).put(paramBundle.get(i), localArrayList.get(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqg
 * JD-Core Version:    0.7.0.1
 */