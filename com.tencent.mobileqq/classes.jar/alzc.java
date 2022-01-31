import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import mqq.app.MobileQQ;

public class alzc
  implements Runnable
{
  public int a;
  public long a;
  public Cursor a;
  public String a;
  public boolean a;
  
  private alzc(FavoriteSearchEngine paramFavoriteSearchEngine) {}
  
  public void run()
  {
    Object localObject1 = FavoriteSearchEngine.a(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine).getApplication().getContentResolver();
    ??? = Uri.parse("content://qq.favorites/global_search/" + FavoriteSearchEngine.a(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine).getAccount());
    try
    {
      localObject1 = ((ContentResolver)localObject1).query((Uri)???, null, null, new String[] { this.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_Int, "" + this.jdField_a_of_type_Long, "" + this.jdField_a_of_type_Boolean }, null);
    }
    catch (Exception localException)
    {
      synchronized (FavoriteSearchEngine.a(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine))
      {
        if (FavoriteSearchEngine.a(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine) == Thread.currentThread())
        {
          this.jdField_a_of_type_AndroidDatabaseCursor = ((Cursor)localObject1);
          FavoriteSearchEngine.a(this.jdField_a_of_type_CooperationQqfavGlobalsearchFavoriteSearchEngine).notify();
        }
        Object localObject2;
        while (localObject2 == null)
        {
          return;
          localException = localException;
          localException.printStackTrace();
          localObject2 = null;
          break;
        }
        localObject2.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzc
 * JD-Core Version:    0.7.0.1
 */