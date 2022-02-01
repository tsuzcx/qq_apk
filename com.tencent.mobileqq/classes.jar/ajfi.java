import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

class ajfi
  implements aoog
{
  ajfi(ajfh paramajfh) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramInt2 = ajfh.a(this.a).getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = ajfh.a(this.a).getChildViewHolder(ajfh.a(this.a).getChildAt(paramInt1));
        if ((localObject instanceof ajfj))
        {
          localObject = (ajfj)localObject;
          if (((ajfj)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
            ((ajfj)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfi
 * JD-Core Version:    0.7.0.1
 */