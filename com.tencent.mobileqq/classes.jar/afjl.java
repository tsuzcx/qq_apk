import android.text.TextUtils;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.Iterator;

public class afjl
  extends CardObserver
{
  public afjl(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  public void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramObject != null) && (!TextUtils.isEmpty(paramObject.uin)))
      {
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        afjr localafjr;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localafjr = (afjr)localIterator.next();
        } while ((localafjr.a == null) || (!(localafjr.a instanceof Friends)) || (!paramObject.uin.equals(((Friends)localafjr.a).uin)));
      }
      for (int i = 1; i != 0; i = 0)
      {
        UncommonlyUsedContactsActivity.a(this.a);
        this.a.jdField_a_of_type_Afjp.notifyDataSetChanged();
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjl
 * JD-Core Version:    0.7.0.1
 */