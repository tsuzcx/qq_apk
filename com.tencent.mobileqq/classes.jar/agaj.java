import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class agaj
  extends bjyh
{
  agaj(agab paramagab) {}
  
  protected void c(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramBoolean)
    {
      this.a.listAdapter.notifyDataSetChanged();
      QQToast.a(this.a.mActivity, this.a.getActivity().getString(2131697984), 0).b(this.a.mActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.mActivity, this.a.getActivity().getString(2131697983), 0).b(this.a.mActivity.getTitleBarHeight());
  }
  
  protected void d(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (this.a.sessionInfo != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.sessionInfo.curFriendUin != null) && (paramHashMap != null) && (this.a.sessionInfo.curFriendUin.equals(paramHashMap.uin)))
      {
        paramHashMap = this.a.a.a(this.a.mContext, this.a.sessionInfo.curFriendUin);
        if (paramHashMap != null)
        {
          this.a.setSubTitleVisable(true);
          this.a.mSubTilteText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          this.a.mTitleLayout.setOnClickListener(null);
          this.a.mSubTitleLayout.setOnClickListener(null);
          this.a.b = paramHashMap;
          this.a.setSubTitleText(paramHashMap);
          if (admg.a) {
            this.a.mSubTilteText.setContentDescription(paramHashMap);
          }
          this.a.mSingleTitle = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        this.a.setSubTitleVisable(false);
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.a.tag, 2, "onGetQidianUserDetailInfo not current curFriendUin");
      return;
    }
    QLog.d(this.a.tag, 2, "onGetQidianUserDetailInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agaj
 * JD-Core Version:    0.7.0.1
 */