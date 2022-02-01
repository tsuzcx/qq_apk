import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiag
  extends aift
{
  public aiag(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.sessionInfo.curType != 10009) {
          break;
        }
        localObject = (ChatMessage)this.app.getMessageProxy(this.sessionInfo.curType).a(this.sessionInfo.curFriendUin, this.sessionInfo.curType, paramLong);
        paramString = "2";
        if ((localObject instanceof MessageForText))
        {
          paramString = "2";
          break label138;
          avdu.a("0", "1", "176", "969", "96902", "206999", paramString, "0", "20", (String)localObject);
        }
        else if ((localObject instanceof MessageForPic))
        {
          paramString = "0";
        }
        else if ((localObject instanceof MessageForPtt))
        {
          paramString = "1";
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("GameBuddyChatPie", 1, paramString, new Object[0]);
        return;
      }
      Object localObject = "1";
      continue;
      label138:
      if (paramBoolean) {
        localObject = "0";
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      avdu.a("0", "1", "176", "969", "96902", "206998", "", "0", "20", "0");
    }
  }
  
  public void onPanelIconClick(Object paramObject)
  {
    super.onPanelIconClick(paramObject);
    int i = ((Integer)paramObject).intValue();
    paramObject = "";
    if (i == 2) {
      paramObject = "206997";
    }
    for (;;)
    {
      avdu.a("0", "1", "176", "969", "96902", paramObject, "", "0", "20", "0");
      return;
      if (i == 3) {
        paramObject = "206996";
      } else if (i == 24) {
        paramObject = "207004";
      } else if (i == 4) {
        paramObject = "207000";
      } else if (i == 5) {
        paramObject = "207005";
      }
    }
  }
  
  public void onShowFirst(int paramInt)
  {
    super.onShowFirst(paramInt);
    avdu.a("0", "1", "176", "969", "96901", "206994", "", "0", "7", "0");
  }
  
  public void refreshListAdapter()
  {
    super.refreshListAdapter();
    setSubTitleVisable(true);
    if ((this.mSubTilteText != null) && (this.mContext != null))
    {
      String str = avdu.d;
      if (this.app != null) {
        str = ((avds)this.app.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a();
      }
      this.mSubTilteText.setText(this.mContext.getString(2131698267) + str);
    }
  }
  
  public boolean showorhideAddFriend()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiag
 * JD-Core Version:    0.7.0.1
 */