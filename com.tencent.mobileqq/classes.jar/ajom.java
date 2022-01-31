import com.tencent.mobileqq.data.ApolloActionData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajom
{
  private List<WeakReference<ajov>> a = new ArrayList();
  
  public void a()
  {
    if (this.a != null) {
      this.a.clear();
    }
  }
  
  public void a(ajov paramajov)
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((localWeakReference == null) || (localWeakReference.get() != paramajov));
    }
    return;
    this.a.add(new WeakReference(paramajov));
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (this.a.get(i) != null)
        {
          ajov localajov = (ajov)((WeakReference)this.a.get(i)).get();
          if (localajov != null) {
            localajov.a(paramApolloActionData);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (this.a.get(i) != null)
        {
          ajov localajov = (ajov)((WeakReference)this.a.get(i)).get();
          if (localajov != null) {
            localajov.a(paramBoolean);
          }
        }
        i += 1;
      }
    }
  }
  
  public void b()
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (this.a.get(i) != null)
        {
          ajov localajov = (ajov)((WeakReference)this.a.get(i)).get();
          if (localajov != null) {
            localajov.a();
          }
        }
        i += 1;
      }
    }
  }
  
  public void b(ajov paramajov)
  {
    if (this.a != null) {
      this.a.remove(paramajov);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajom
 * JD-Core Version:    0.7.0.1
 */