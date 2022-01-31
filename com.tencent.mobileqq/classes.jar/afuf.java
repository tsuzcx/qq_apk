import android.widget.BaseAdapter;
import com.tencent.mobileqq.data.ChatMessage;

abstract class afuf<T extends aeqy>
{
  private T a;
  
  private afuf(afpy paramafpy) {}
  
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
 * Qualified Name:     afuf
 * JD-Core Version:    0.7.0.1
 */