import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.util.FaceDecoderImpl;

public class akhg
  extends FriendListObserver
{
  private akhg(FaceDecoderImpl paramFaceDecoderImpl) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    this.a.a(paramBoolean, 1, paramString, 0);
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    this.a.a(paramBoolean, 11, paramString, 0);
  }
  
  protected void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.a.a(paramBoolean1, 16, paramString, paramInt);
  }
  
  protected void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.a.a(paramBoolean1, 32, paramString, paramInt);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    this.a.a(paramBoolean, 4, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akhg
 * JD-Core Version:    0.7.0.1
 */