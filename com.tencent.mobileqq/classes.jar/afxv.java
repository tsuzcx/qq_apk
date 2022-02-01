import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.widget.BubbleImageView;

public class afxv
  extends aezf
{
  public afxu a;
  public ImageView a;
  public URLDrawable a;
  public PicProgressView a;
  public BubbleImageView a;
  public boolean a;
  public View c;
  final int e = 0;
  final int f = 1;
  final int g = 2;
  final int h = 3;
  final int i = 4;
  final int j = 5;
  
  public afxv(afxq paramafxq) {}
  
  int a(MessageForPic paramMessageForPic)
  {
    if (!paramMessageForPic.isSendFromLocal())
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)) {
        return 1;
      }
    }
    else
    {
      if (paramMessageForPic.size > 0L) {
        return 2;
      }
      paramMessageForPic = this.jdField_a_of_type_Afxq.a.getTransFileController().findProcessor(paramMessageForPic.frienduin, paramMessageForPic.uniseq);
      if ((paramMessageForPic instanceof BaseTransProcessor))
      {
        paramMessageForPic = (BaseTransProcessor)paramMessageForPic;
        long l = paramMessageForPic.getFileStatus();
        if ((l == 1005L) || (l == 1006L) || (l == 1004L) || (paramMessageForPic.getLastFileStatus() == 1003L)) {
          return 4;
        }
        return 3;
      }
      return 5;
    }
    return 0;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Afxu != null) {
      return this.jdField_a_of_type_Afxu.b;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxv
 * JD-Core Version:    0.7.0.1
 */