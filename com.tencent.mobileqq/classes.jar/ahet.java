import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

class ahet
  implements bcwt
{
  ahet(ahes paramahes) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramInt2 = ahes.a(this.a).getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = ahes.a(this.a).getChildViewHolder(ahes.a(this.a).getChildAt(paramInt1));
        if ((localObject instanceof aheu))
        {
          localObject = (aheu)localObject;
          if (((aheu)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
            ((aheu)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahet
 * JD-Core Version:    0.7.0.1
 */