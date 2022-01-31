import android.text.TextUtils;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.Iterator;

public class acnx
  extends ajto
{
  public acnx(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
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
        acod localacod;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localacod = (acod)localIterator.next();
        } while ((localacod.a == null) || (!(localacod.a instanceof Friends)) || (!paramObject.uin.equals(((Friends)localacod.a).uin)));
      }
      for (int i = 1; i != 0; i = 0)
      {
        UncommonlyUsedContactsActivity.a(this.a);
        this.a.jdField_a_of_type_Acob.notifyDataSetChanged();
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acnx
 * JD-Core Version:    0.7.0.1
 */