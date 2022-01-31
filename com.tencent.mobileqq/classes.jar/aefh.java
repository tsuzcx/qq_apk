import android.text.TextUtils;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.Iterator;

public class aefh
  extends allb
{
  public aefh(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
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
        aefn localaefn;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localaefn = (aefn)localIterator.next();
        } while ((localaefn.a == null) || (!(localaefn.a instanceof Friends)) || (!paramObject.uin.equals(((Friends)localaefn.a).uin)));
      }
      for (int i = 1; i != 0; i = 0)
      {
        UncommonlyUsedContactsActivity.a(this.a);
        this.a.jdField_a_of_type_Aefl.notifyDataSetChanged();
        return;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefh
 * JD-Core Version:    0.7.0.1
 */