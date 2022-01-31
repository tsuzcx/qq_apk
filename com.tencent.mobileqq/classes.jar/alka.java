import com.tencent.plato.PlatoLoadEvent;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public final class alka
  implements Runnable
{
  public alka(String paramString1, String paramString2) {}
  
  public void run()
  {
    PlatoLoadEvent localPlatoLoadEvent = PlatoLoadEvent.a(0, this.a, this.b);
    Dispatchers.get().dispatch(localPlatoLoadEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alka
 * JD-Core Version:    0.7.0.1
 */