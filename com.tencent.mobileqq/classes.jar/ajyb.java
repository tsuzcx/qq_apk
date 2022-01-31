import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.mobileqq.data.ChatMessage;

public abstract interface ajyb
{
  public abstract void bind(@Nullable ajyd paramajyd);
  
  public abstract void clearHighlightContent();
  
  @Nullable
  public abstract CharSequence content();
  
  public abstract int contentLength();
  
  @Nullable
  public abstract ajyd delegate();
  
  public abstract void doSelecting(ChatMessage paramChatMessage);
  
  public abstract boolean hasSelected();
  
  public abstract void highlightBackgroundColor(@ColorInt int paramInt);
  
  public abstract void highlightContent();
  
  public abstract void locationByIndex(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean);
  
  @Nullable
  public abstract CharSequence selectContent();
  
  public abstract void selectContent(int paramInt1, int paramInt2);
  
  public abstract int touchIndex(int paramInt1, int paramInt2);
  
  @NonNull
  public abstract View view();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyb
 * JD-Core Version:    0.7.0.1
 */