import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class afwu
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject1 = (ChatMessage)paramCompoundButton.getTag();
    if (localObject1 == null) {}
    label507:
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if ((localObject1 instanceof MessageForPtt))
      {
        localObject2 = MediaPlayerManager.a(BaseActivity.sTopActivity.app).a();
        if ((localObject2 == localObject1) || (((localObject2 instanceof MessageForPtt)) && (((ChatMessage)localObject2).uniseq == ((ChatMessage)localObject1).uniseq))) {
          MediaPlayerManager.a(BaseActivity.sTopActivity.app).c(false);
        }
      }
      Object localObject2 = AIOLongShotHelper.a();
      if ((localObject2 != null) && (((AIOLongShotHelper)localObject2).a()))
      {
        if ((paramBoolean != ((AIOLongShotHelper)localObject2).a((ChatMessage)localObject1)) && (BaseChatItemLayout.a != null)) {
          BaseChatItemLayout.a.a((ChatMessage)localObject1, paramCompoundButton, paramBoolean);
        }
      }
      else if (paramBoolean != awwm.a().a((ChatMessage)localObject1))
      {
        if (!paramBoolean) {
          awwm.a().a((ChatMessage)localObject1, paramBoolean);
        }
        for (;;)
        {
          if (BaseChatItemLayout.a == null) {
            break label507;
          }
          BaseChatItemLayout.a.a((ChatMessage)localObject1, paramCompoundButton, paramBoolean);
          break;
          if ((localObject1 instanceof MessageForFile))
          {
            localObject2 = atvo.a(BaseActivity.sTopActivity.app, (MessageForFile)localObject1);
            if ((((FileManagerEntity)localObject2).getCloudType() == 1) && (((FileManagerEntity)localObject2).status == 2))
            {
              localObject1 = paramCompoundButton.getContext().getString(2131692330);
              QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject1, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
              paramCompoundButton.setChecked(false);
              break;
            }
          }
          if ((localObject1 instanceof MessageForTroopFile))
          {
            localObject2 = (MessageForTroopFile)localObject1;
            localObject2 = bfsj.a(BaseActivity.sTopActivity.app, (MessageForTroopFile)localObject2);
            if ((localObject2 != null) && ((((bety)localObject2).b == 0) || (((bety)localObject2).b == 1) || (((bety)localObject2).b == 2) || (((bety)localObject2).b == 3) || (((bety)localObject2).b == 4)))
            {
              localObject1 = paramCompoundButton.getContext().getString(2131692330);
              QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject1, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
              paramCompoundButton.setChecked(false);
              break;
            }
          }
          int i = awwm.a().a();
          if (awwm.a().a((ChatMessage)localObject1, i))
          {
            if (awwm.a().a == 7) {}
            for (localObject1 = paramCompoundButton.getContext().getString(2131697674, new Object[] { Integer.valueOf(i) });; localObject1 = paramCompoundButton.getContext().getString(2131697673, new Object[] { Integer.valueOf(i) }))
            {
              QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject1, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
              paramCompoundButton.setChecked(false);
              break;
            }
          }
          awwm.a().a((ChatMessage)localObject1, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwu
 * JD-Core Version:    0.7.0.1
 */