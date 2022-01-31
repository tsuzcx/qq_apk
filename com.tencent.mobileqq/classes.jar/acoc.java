import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout.OnClickListener;
import com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class acoc
  implements EmoticonPanelLinearLayout.OnClickListener
{
  public acoc(FavoriteEmotionAdapter paramFavoriteEmotionAdapter) {}
  
  public boolean a(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo == null) || (paramView == null)) {
      return false;
    }
    if (TextUtils.isEmpty(paramEmoticonInfo.a))
    {
      URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131361968);
      paramView = (URLImageView)paramView.findViewById(2131361969);
      if ((localURLImageView.getDrawable() instanceof URLDrawable))
      {
        URLDrawable localURLDrawable = (URLDrawable)localURLImageView.getDrawable();
        if ((localURLDrawable.getStatus() == 3) || (localURLDrawable.getStatus() == 2))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FavoriteEmotionAdapter", 2, "now  favorite EmoticonInfo loading failed, restart download " + paramEmoticonInfo.toString());
          }
          localURLImageView.setVisibility(8);
          paramView.setVisibility(0);
          localURLDrawable.restartDownload();
          if (!(paramView.getDrawable() instanceof Animatable))
          {
            paramEmoticonInfo = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130838602);
            paramView.setImageDrawable((Drawable)paramEmoticonInfo);
            paramEmoticonInfo.start();
          }
          for (;;)
          {
            return true;
            ((Animatable)paramView.getDrawable()).start();
          }
        }
        if (localURLDrawable.getStatus() == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i("FavoriteEmotionAdapter", 2, "now  favorite EmoticonInfo loading " + paramEmoticonInfo.toString());
          }
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acoc
 * JD-Core Version:    0.7.0.1
 */