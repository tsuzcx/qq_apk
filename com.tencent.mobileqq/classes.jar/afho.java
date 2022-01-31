import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

class afho
  implements baxz
{
  afho(afhn paramafhn) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramInt2 = afhn.a(this.a).getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = afhn.a(this.a).getChildViewHolder(afhn.a(this.a).getChildAt(paramInt1));
        if ((localObject instanceof afhp))
        {
          localObject = (afhp)localObject;
          if (((afhp)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
            ((afhp)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afho
 * JD-Core Version:    0.7.0.1
 */