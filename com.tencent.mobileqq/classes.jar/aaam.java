import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;

public abstract interface aaam<T extends SimpleBaseEvent>
{
  public abstract ArrayList<Class<T>> getEventClass();
  
  public abstract void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaam
 * JD-Core Version:    0.7.0.1
 */