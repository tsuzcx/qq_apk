import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ahal
  implements View.OnClickListener
{
  ahal(ahak paramahak) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("is_from_conversation", true);
    paramView.putExtra("bookid", ahak.a(this.a));
    paramView.putExtra("book_new_id", ahak.b(this.a));
    Intent localIntent = new Intent();
    localIntent.putExtras(paramView);
    localIntent.putExtra("readtype", "15");
    localIntent.setClassName(ahak.a(this.a), "cooperation.qqreader.QRBridgeActivity");
    localIntent.addFlags(268435456);
    ahak.a(this.a).startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahal
 * JD-Core Version:    0.7.0.1
 */