import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.UpdateAppByNameTask;
import com.tencent.util.WeakReferenceHandler;

public class aaoh
  implements aapc
{
  public aaoh(ArkLocalAppMgr paramArkLocalAppMgr) {}
  
  public void a(ArkLocalAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask, Object paramObject)
  {
    paramObject = (aaow)paramObject;
    paramObject.a.post(new aaoi(this, paramUpdateAppByNameTask, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaoh
 * JD-Core Version:    0.7.0.1
 */