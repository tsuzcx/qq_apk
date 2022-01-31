import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.mobileqq.filemanager.activity.TroopFileZipPreviewActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;

public class aced
  extends FMObserver
{
  public aced(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.a.a != null)) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aced
 * JD-Core Version:    0.7.0.1
 */