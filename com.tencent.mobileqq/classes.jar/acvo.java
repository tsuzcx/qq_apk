import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.12.1;

public class acvo
  extends altm
{
  public acvo(EditInfoActivity paramEditInfoActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (!this.a.f.equals(paramString1)) {}
    while (!this.a.j) {
      return;
    }
    this.a.j = false;
    this.a.runOnUiThread(new EditInfoActivity.12.1(this, paramBoolean, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvo
 * JD-Core Version:    0.7.0.1
 */