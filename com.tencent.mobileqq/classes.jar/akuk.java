import com.tencent.plato.PlatoLoadEvent;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public final class akuk
  implements Runnable
{
  public akuk(String paramString1, String paramString2) {}
  
  public void run()
  {
    PlatoLoadEvent localPlatoLoadEvent = PlatoLoadEvent.a(0, this.a, this.b);
    Dispatchers.get().dispatch(localPlatoLoadEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akuk
 * JD-Core Version:    0.7.0.1
 */