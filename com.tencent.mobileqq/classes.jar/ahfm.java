import android.view.View;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class ahfm
{
  private Map<Integer, LinkedList<View>> a = new HashMap();
  
  View a(int paramInt)
  {
    LinkedList localLinkedList = (LinkedList)this.a.get(Integer.valueOf(paramInt));
    if (localLinkedList == null) {
      return null;
    }
    return (View)localLinkedList.poll();
  }
  
  void a()
  {
    this.a.clear();
  }
  
  void a(int paramInt, View paramView)
  {
    LinkedList localLinkedList2 = (LinkedList)this.a.get(Integer.valueOf(paramInt));
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null)
    {
      localLinkedList1 = new LinkedList();
      this.a.put(Integer.valueOf(paramInt), localLinkedList1);
    }
    localLinkedList1.add(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfm
 * JD-Core Version:    0.7.0.1
 */