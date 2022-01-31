import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.Iterator;
import java.util.List;

public class acmb
  extends AsyncTask
{
  public acmb(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(FileCategoryUtil.d(this.a));
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.stopTitleProgress();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileCategoryEntity localFileCategoryEntity = (FileCategoryEntity)localIterator.next();
      if (localFileCategoryEntity.e == 4)
      {
        localFileCategoryEntity.d = paramInteger.intValue();
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.startTitleProgress();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acmb
 * JD-Core Version:    0.7.0.1
 */