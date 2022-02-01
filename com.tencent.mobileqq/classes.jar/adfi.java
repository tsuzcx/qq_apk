import ColorNick.QC.GroupNickEmoji;
import ColorNick.QC.GroupNickItem;
import ColorNick.QC.readItemInfoRsp;
import android.os.Handler;
import com.tencent.mobileqq.activity.EditInfoActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class adfi
  extends anam
{
  public adfi(EditInfoActivity paramEditInfoActivity) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    Object localObject1;
    if ((paramBoolean) && ((paramObject instanceof readItemInfoRsp)))
    {
      paramObject = (readItemInfoRsp)paramObject;
      EditInfoActivity.a(this.a, paramObject.index);
      localObject1 = paramObject.urlprefix;
      Iterator localIterator;
      Object localObject2;
      if ((paramObject.emojilist != null) && (paramObject.emojilist.size() > 0) && (EditInfoActivity.a(this.a).size() == 0))
      {
        localIterator = paramObject.emojilist.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (GroupNickEmoji)localIterator.next();
          EditInfoActivity.a(this.a).add(Integer.valueOf(((GroupNickEmoji)localObject2).itemid));
        }
        this.a.a.sendEmptyMessage(260);
      }
      if ((paramObject.itemlist != null) && (paramObject.itemlist.size() > 0))
      {
        localIterator = paramObject.itemlist.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (GroupNickItem)localIterator.next();
          String str = (String)localObject1 + ((GroupNickItem)localObject2).url;
          localObject2 = new bgdd(3, null, ((GroupNickItem)localObject2).itemid, str);
          EditInfoActivity.b(this.a).add(localObject2);
        }
        localObject1 = this.a;
        if (paramObject.left != 1) {
          break label257;
        }
      }
    }
    label257:
    for (paramBoolean = true;; paramBoolean = false)
    {
      EditInfoActivity.a((EditInfoActivity)localObject1, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfi
 * JD-Core Version:    0.7.0.1
 */