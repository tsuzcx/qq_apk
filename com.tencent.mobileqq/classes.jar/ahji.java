import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

class ahji
  implements bdbc
{
  ahji(ahjh paramahjh) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramInt2 = ahjh.a(this.a).getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = ahjh.a(this.a).getChildViewHolder(ahjh.a(this.a).getChildAt(paramInt1));
        if ((localObject instanceof ahjj))
        {
          localObject = (ahjj)localObject;
          if (((ahjj)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
            ((ahjj)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahji
 * JD-Core Version:    0.7.0.1
 */