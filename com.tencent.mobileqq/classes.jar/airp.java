import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.util.List;

public class airp
  implements Handler.Callback
{
  public airp(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    switch (paramMessage.arg2)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      break;
      switch (paramMessage.arg1)
      {
      default: 
        break;
      case 20: 
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131715002));
        paramMessage = TroopMemberHistoryFragment.a(this.a).getContext().getResources();
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.dp2px(320.0F, paramMessage);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.dp2px(177.5F, paramMessage);
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
        paramMessage = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171229/e4f73825907a4cdeb29db9c6688cd82c.png", (URLDrawable.URLDrawableOptions)localObject);
        localObject = (ImageView)this.a.jdField_a_of_type_AndroidViewView.findViewById(2131378884);
        ((ImageView)localObject).setImageDrawable(paramMessage);
        ((ImageView)localObject).setVisibility(0);
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
        continue;
        if ((paramMessage.obj instanceof List))
        {
          this.a.jdField_a_of_type_Airt.a((List)paramMessage.obj);
          this.a.jdField_a_of_type_Airt.notifyDataSetChanged();
        }
        switch (paramMessage.arg1)
        {
        default: 
          break;
        case 20: 
          this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
          continue;
          if (paramMessage.arg1 == 20)
          {
            this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131697333);
            this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
          break;
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airp
 * JD-Core Version:    0.7.0.1
 */