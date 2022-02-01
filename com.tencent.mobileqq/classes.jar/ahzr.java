import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;

class ahzr
  implements FaceDecoder.DecodeTaskCompletionListener
{
  ahzr(ahzq paramahzq) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramInt2 = ahzq.a(this.a).getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = ahzq.a(this.a).getChildViewHolder(ahzq.a(this.a).getChildAt(paramInt1));
        if ((localObject instanceof ahzs))
        {
          localObject = (ahzs)localObject;
          if (((ahzs)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
            ((ahzs)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzr
 * JD-Core Version:    0.7.0.1
 */