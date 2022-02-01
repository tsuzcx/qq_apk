import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import java.lang.ref.WeakReference;

public class ajtu
  extends aahe
{
  WeakReference<aaha> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ajtu(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment, aaha paramaaha)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaaha);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    aaha localaaha = (aaha)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localaaha != null) {
      localaaha.a(paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtu
 * JD-Core Version:    0.7.0.1
 */