import com.tencent.mobileqq.data.ApolloActionData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajak
{
  private List<WeakReference<ajat>> a = new ArrayList();
  
  public void a()
  {
    if (this.a != null) {
      this.a.clear();
    }
  }
  
  public void a(ajat paramajat)
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
      } while ((localWeakReference == null) || (localWeakReference.get() != paramajat));
    }
    return;
    this.a.add(new WeakReference(paramajat));
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
          ajat localajat = (ajat)((WeakReference)this.a.get(i)).get();
          if (localajat != null) {
            localajat.a(paramApolloActionData);
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
          ajat localajat = (ajat)((WeakReference)this.a.get(i)).get();
          if (localajat != null) {
            localajat.a(paramBoolean);
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
          ajat localajat = (ajat)((WeakReference)this.a.get(i)).get();
          if (localajat != null) {
            localajat.a();
          }
        }
        i += 1;
      }
    }
  }
  
  public void b(ajat paramajat)
  {
    if (this.a != null) {
      this.a.remove(paramajat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajak
 * JD-Core Version:    0.7.0.1
 */