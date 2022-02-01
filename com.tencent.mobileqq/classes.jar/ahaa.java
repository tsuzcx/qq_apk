import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

abstract class ahaa<T extends afrj>
{
  private T a;
  
  private ahaa(agvm paramagvm) {}
  
  protected abstract T a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter);
  
  protected boolean a()
  {
    return true;
  }
  
  protected T b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (this.a == null) {
      this.a = a(paramChatMessage, paramBaseAdapter);
    }
    if (a()) {
      this.b.a(this.a, paramBaseAdapter);
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahaa
 * JD-Core Version:    0.7.0.1
 */