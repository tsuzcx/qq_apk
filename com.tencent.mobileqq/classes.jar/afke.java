import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.ImageItem;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo.VideoItem;

class afke
  implements View.OnClickListener
{
  afke(afkd paramafkd) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    paramView = paramView.getTag();
    if (!(paramView instanceof afkf)) {}
    afkf localafkf;
    label42:
    do
    {
      do
      {
        return;
        localafkf = (afkf)paramView;
        paramView = afkf.a(localafkf);
        if (!TextUtils.isEmpty(paramView)) {
          break;
        }
        Log.i("AutoVideoItemBuilder", "onClick: empty schema");
        paramView = bdib.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.a.jdField_a_of_type_AndroidContentContext, paramView);
        if (paramView != null) {
          paramView.c();
        }
      } while (!(localafkf.a instanceof MessageForStructing));
      paramView = (MessageForStructing)localafkf.a;
    } while (!(paramView.structingMsg instanceof StructMsgSubImageVideo));
    paramView = (StructMsgSubImageVideo)paramView.structingMsg;
    label125:
    int i;
    label195:
    label213:
    int k;
    if (paramView.getVideoItem() != null)
    {
      paramView = paramView.getVideoItem().title;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        break label461;
      }
      azqs.b(null, "dc00898", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "auth_aio", "clk_content", 0, 0, "", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramView);
      return;
      if ((!paramView.contains("&width=")) && (!paramView.contains("?width=")))
      {
        i = 1;
        if ((paramView.contains("&height=")) || (paramView.contains("?height="))) {
          break label308;
        }
        if ((i == 0) && (j == 0)) {
          break label469;
        }
        k = paramView.indexOf("?");
        if (k >= 0) {
          break label313;
        }
        paramView = paramView + "?width=" + localafkf.e + "&height=" + localafkf.f;
      }
    }
    label275:
    label308:
    label313:
    label461:
    label469:
    for (;;)
    {
      Log.i("AutoVideoItemBuilder", "onClick: " + paramView);
      break label42;
      i = 0;
      break label195;
      j = 0;
      break label213;
      if (k == paramView.length() - 1)
      {
        paramView = paramView + "width=" + localafkf.e + "&height=" + localafkf.f;
      }
      else
      {
        if (i != 0) {}
        for (Object localObject = paramView + "&width=" + localafkf.e;; localObject = paramView)
        {
          paramView = (View)localObject;
          if (j == 0) {
            break label275;
          }
          paramView = (String)localObject + "&height=" + localafkf.f;
          break label275;
          if (paramView.getImageItem() != null)
          {
            paramView = paramView.getImageItem().title;
            break label125;
          }
          paramView = null;
          break label125;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afke
 * JD-Core Version:    0.7.0.1
 */