import java.util.List;
import tencent.im.nearfield_group.nearfield_group.BusiRespHead;

public class alxk
  implements alpg
{
  public void a(aqkt paramaqkt) {}
  
  public void a(aqkx paramaqkx) {}
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead) {}
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, String paramString) {}
  
  public void a(nearfield_group.BusiRespHead paramBusiRespHead, List<aqkt> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        if ((paramBoolean) && (paramObject != null))
        {
          paramObject = (Object[])paramObject;
          a((nearfield_group.BusiRespHead)paramObject[0], (List)paramObject[1]);
          return;
        }
        a(null, null);
        return;
        if ((paramBoolean) && (paramObject != null))
        {
          a((nearfield_group.BusiRespHead)((Object[])(Object[])paramObject)[0]);
          return;
        }
        a(null);
        return;
        if ((paramBoolean) && (paramObject != null))
        {
          paramObject = (Object[])paramObject;
          a((nearfield_group.BusiRespHead)paramObject[0], (String)paramObject[1]);
          return;
        }
        a(null, "");
        return;
      } while ((!paramBoolean) || (paramObject == null));
      a((aqkt)((Object[])(Object[])paramObject)[0]);
      return;
    } while ((!paramBoolean) || (paramObject == null));
    a((aqkx)((Object[])(Object[])paramObject)[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alxk
 * JD-Core Version:    0.7.0.1
 */