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

public final class aeqk
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject1 = (ChatMessage)paramCompoundButton.getTag();
    if (localObject1 == null) {}
    for (;;)
    {
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
      else if (paramBoolean != aupg.a().a((ChatMessage)localObject1))
      {
        if (!paramBoolean) {
          aupg.a().a((ChatMessage)localObject1, paramBoolean);
        }
        while (BaseChatItemLayout.a != null)
        {
          BaseChatItemLayout.a.a((ChatMessage)localObject1, paramCompoundButton, paramBoolean);
          return;
          if ((localObject1 instanceof MessageForFile))
          {
            localObject2 = arrr.a(BaseActivity.sTopActivity.app, (MessageForFile)localObject1);
            if ((((FileManagerEntity)localObject2).getCloudType() == 1) && (((FileManagerEntity)localObject2).status == 2))
            {
              localObject1 = paramCompoundButton.getContext().getString(2131692763);
              QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject1, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
              paramCompoundButton.setChecked(false);
              return;
            }
          }
          if ((localObject1 instanceof MessageForTroopFile))
          {
            localObject2 = (MessageForTroopFile)localObject1;
            localObject2 = bcnt.a(BaseActivity.sTopActivity.app, (MessageForTroopFile)localObject2);
            if ((localObject2 != null) && ((((bbtn)localObject2).b == 0) || (((bbtn)localObject2).b == 1) || (((bbtn)localObject2).b == 2) || (((bbtn)localObject2).b == 3) || (((bbtn)localObject2).b == 4)))
            {
              localObject1 = paramCompoundButton.getContext().getString(2131692763);
              QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject1, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
              paramCompoundButton.setChecked(false);
              return;
            }
          }
          int i = aupg.a().a();
          if (aupg.a().a((ChatMessage)localObject1, i))
          {
            if (aupg.a().a == 7) {}
            for (localObject1 = paramCompoundButton.getContext().getString(2131698789, new Object[] { Integer.valueOf(i) });; localObject1 = paramCompoundButton.getContext().getString(2131698788, new Object[] { Integer.valueOf(i) }))
            {
              QQToast.a(paramCompoundButton.getContext(), (CharSequence)localObject1, 0).b(((BaseActivity)paramCompoundButton.getContext()).getTitleBarHeight());
              paramCompoundButton.setChecked(false);
              return;
            }
          }
          aupg.a().a((ChatMessage)localObject1, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeqk
 * JD-Core Version:    0.7.0.1
 */