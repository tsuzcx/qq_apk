import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.arcard.ARCardHeadIconManager;
import java.util.ArrayList;
import java.util.Hashtable;

public class aalv
  extends BroadcastReceiver
{
  public aalv(ARCardHeadIconManager paramARCardHeadIconManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())))
    {
      ArrayList localArrayList = paramIntent.getExtras().getStringArrayList("uinList");
      paramIntent = paramIntent.getExtras().getStringArrayList("headPathList");
      if ((localArrayList != null) && (paramIntent != null))
      {
        int i = 0;
        if (i < localArrayList.size())
        {
          String str1 = (String)paramIntent.get(i);
          if (str1 != null)
          {
            String str2 = (String)localArrayList.get(i);
            paramContext = (aalw)ARCardHeadIconManager.a(this.a).get(str2);
            if (paramContext != null) {
              break label147;
            }
            paramContext = new aalw(this.a);
            paramContext.jdField_a_of_type_JavaLangString = str1;
            ARCardHeadIconManager.a(this.a).put(str2, paramContext);
          }
          for (;;)
          {
            paramContext.jdField_a_of_type_Boolean = false;
            i += 1;
            break;
            label147:
            paramContext.jdField_a_of_type_JavaLangString = str1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalv
 * JD-Core Version:    0.7.0.1
 */