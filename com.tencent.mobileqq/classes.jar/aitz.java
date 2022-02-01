import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

class aitz
  implements aobv
{
  aitz(aity paramaity) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramInt2 = aity.a(this.a).getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = aity.a(this.a).getChildViewHolder(aity.a(this.a).getChildAt(paramInt1));
        if ((localObject instanceof aiua))
        {
          localObject = (aiua)localObject;
          if (((aiua)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
            ((aiua)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitz
 * JD-Core Version:    0.7.0.1
 */