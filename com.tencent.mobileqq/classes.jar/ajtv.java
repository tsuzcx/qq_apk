import com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment;
import java.lang.ref.WeakReference;

public class ajtv
  extends aahh
{
  WeakReference<aaha> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ajtv(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment, aaha paramaaha)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaaha);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    aaha localaaha = (aaha)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localaaha != null) {
      localaaha.a(paramBoolean, paramLong1, paramLong2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtv
 * JD-Core Version:    0.7.0.1
 */