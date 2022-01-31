import android.util.SparseIntArray;
import java.util.ArrayList;

public class aixn
  implements aiya
{
  public static SparseIntArray a = new SparseIntArray();
  
  public static int a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    int k = 0;
    int j = 0;
    int i;
    if (paramInt3 != 0) {
      i = 1;
    }
    while ((paramInt2 == 0) && (!paramBoolean2)) {
      if (i != 0)
      {
        paramInt2 = j;
        return paramInt2;
        i = 0;
      }
      else
      {
        return 6;
      }
    }
    if ((paramInt2 != 1) && (paramInt2 != 2)) {
      return 101;
    }
    if (a.get(paramInt1) == 0)
    {
      j = 1;
      switch (paramInt2)
      {
      default: 
        label67:
        paramInt3 = k;
        label95:
        a.put(paramInt1, 1);
        if (paramBoolean1) {
          if (paramInt2 == 1) {
            paramInt2 = 4;
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramInt3 = paramInt2;
      if (paramInt1 == 1)
      {
        paramInt3 = paramInt2;
        if (!aiyr.b) {
          paramInt3 = paramInt2 + 10;
        }
      }
      paramInt2 = paramInt3;
      if (paramInt1 != 1) {
        break;
      }
      paramInt2 = paramInt3;
      if (aiyr.jdField_d_of_type_Boolean) {
        break;
      }
      return paramInt3 | 0x20;
      j = 0;
      break label67;
      paramInt3 = k;
      if (j != 0) {
        break label95;
      }
      paramInt3 = 1;
      break label95;
      if (j != 0)
      {
        paramInt3 = 2;
        break label95;
      }
      paramInt3 = 3;
      break label95;
      paramInt2 = 5;
      continue;
      paramInt2 = paramInt3;
      if (i == 0) {
        paramInt2 = paramInt3 + 6;
      }
    }
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "_sprite_aio";
    case 2: 
      return "_sprite_drawer";
    case 3: 
      return "_sprite_friend_card";
    case 4: 
      return "_sprite_action_fps";
    case 10: 
      return "_apollo_so";
    case 20: 
      return "_apollo_crash";
    case 30: 
      return "_apollo_resource_download";
    case 40: 
      return "_apollo_store_sso";
    }
    return "_apollo_view_re_attach";
  }
  
  public void a()
  {
    a.clear();
  }
  
  public boolean a(int paramInt)
  {
    return aiyr.jdField_d_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aixn
 * JD-Core Version:    0.7.0.1
 */