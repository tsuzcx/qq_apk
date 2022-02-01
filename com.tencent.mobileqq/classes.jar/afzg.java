import android.text.TextUtils;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.Iterator;

public class afzg
  extends anuw
{
  public afzg(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
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
        afzm localafzm;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localafzm = (afzm)localIterator.next();
        } while ((localafzm.a == null) || (!(localafzm.a instanceof Friends)) || (!paramObject.uin.equals(((Friends)localafzm.a).uin)));
      }
      for (int i = 1; i != 0; i = 0)
      {
        UncommonlyUsedContactsActivity.a(this.a);
        this.a.jdField_a_of_type_Afzk.notifyDataSetChanged();
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzg
 * JD-Core Version:    0.7.0.1
 */