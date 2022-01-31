import com.tencent.mobileqq.troop.widget.TrooFileTextViewMenuBuilder;
import com.tencent.mobileqq.troop.widget.TroopFileItemBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;

public class akaz
  extends TrooFileTextViewMenuBuilder
{
  public akaz(TroopFileItemBuilder paramTroopFileItemBuilder, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public void a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 2) {
        break label22;
      }
    }
    label22:
    do
    {
      do
      {
        return;
        paramObject = paramObject[0];
      } while (!(paramObject instanceof boolean[]));
      paramObject = (boolean[])paramObject;
    } while ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0) || (paramObject.length != 3));
    if ((paramArrayOfSwipRightMenuItem.length < 0) && (paramObject[0] != 0))
    {
      paramArrayOfSwipRightMenuItem[0].b = 0;
      paramArrayOfSwipRightMenuItem[0].a = 0;
    }
    for (int i = 1;; i = 0)
    {
      paramInt = i;
      if (i < paramArrayOfSwipRightMenuItem.length)
      {
        paramInt = i;
        if (paramObject[1] != 0)
        {
          paramArrayOfSwipRightMenuItem[i].b = 1;
          paramArrayOfSwipRightMenuItem[i].a = 1;
          paramInt = i + 1;
        }
      }
      i = paramInt;
      if (paramInt < paramArrayOfSwipRightMenuItem.length)
      {
        i = paramInt;
        if (paramObject[2] != 0)
        {
          paramArrayOfSwipRightMenuItem[paramInt].b = 2;
          paramArrayOfSwipRightMenuItem[paramInt].a = 0;
          i = paramInt + 1;
        }
      }
      while (i < paramArrayOfSwipRightMenuItem.length)
      {
        paramArrayOfSwipRightMenuItem[i].b = -1;
        paramArrayOfSwipRightMenuItem[i].a = -1;
        i += 1;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akaz
 * JD-Core Version:    0.7.0.1
 */