import android.view.View;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.XListView;

public abstract interface aetg
{
  public abstract void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat);
  
  public abstract void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean);
  
  public abstract boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage);
  
  public abstract boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayer paramAudioPlayer, int paramInt2);
  
  public abstract boolean b(ChatMessage paramChatMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetg
 * JD-Core Version:    0.7.0.1
 */