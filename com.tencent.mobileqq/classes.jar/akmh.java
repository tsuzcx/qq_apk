import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.QQComicStep;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class akmh
  extends akav
{
  public akmh(QQComicStep paramQQComicStep) {}
  
  public void a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = new ArrayList(paramList).iterator();
      while (paramList.hasNext())
      {
        Object localObject = axuy.a(((MessageRecord)paramList.next()).msgData);
        if ((localObject instanceof StructMsgForImageShare))
        {
          localObject = (StructMsgForImageShare)localObject;
          if ((((StructMsgForImageShare)localObject).mMsgActionData != null) && (((StructMsgForImageShare)localObject).mMsgActionData.startsWith("comic_plugin.apk")))
          {
            String[] arrayOfString = ((StructMsgForImageShare)localObject).mMsgActionData.substring(((StructMsgForImageShare)localObject).mMsgActionData.indexOf("|") + 1).split("\\|");
            if (arrayOfString.length >= 8) {
              bghg.a(this.a.a.mApp, "3009", "1", "30014", arrayOfString[0], new String[] { arrayOfString[2], arrayOfString[4], aehv.a(((StructMsgForImageShare)localObject).mMsgActionData) });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akmh
 * JD-Core Version:    0.7.0.1
 */