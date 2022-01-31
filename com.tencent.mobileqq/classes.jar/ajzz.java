import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.util.FaceManager;

public class ajzz
  extends FriendListObserver
{
  private ajzz(FaceManager paramFaceManager) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    this.a.a(4, paramBoolean, new Object[] { paramString });
  }
  
  public void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    this.a.a(39, paramBoolean, new Object[] { paramString });
  }
  
  protected void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.a.a(6, paramBoolean1, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
  }
  
  protected void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.a.a(5, paramBoolean1, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    this.a.a(30, paramBoolean, new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzz
 * JD-Core Version:    0.7.0.1
 */