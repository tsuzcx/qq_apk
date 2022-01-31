import android.os.Bundle;
import eipc.EIPCResult;

class alvk
  implements ajte
{
  alvk(alvj paramalvj, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putBoolean("sucess", paramBoolean);
    localBundle.putString("data", (String)paramObject);
    paramObject = EIPCResult.createResult(0, localBundle);
    this.jdField_a_of_type_Alvj.callbackResult(this.jdField_a_of_type_Int, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alvk
 * JD-Core Version:    0.7.0.1
 */