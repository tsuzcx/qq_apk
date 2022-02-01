import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ahle
  extends binf
{
  ahle(ahkz paramahkz) {}
  
  protected void c(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramBoolean)
    {
      this.a.listAdapter.notifyDataSetChanged();
      QQToast.a(this.a.mActivity, this.a.getActivity().getString(2131697701), 0).b(this.a.mActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.mActivity, this.a.getActivity().getString(2131697700), 0).b(this.a.mActivity.getTitleBarHeight());
  }
  
  protected void d(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (((this.a.sessionInfo.curType == 1025) || (this.a.sessionInfo.curType == 1024)) && (paramBoolean) && (paramHashMap != null) && (this.a.sessionInfo != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.sessionInfo.curFriendUin != null) && (paramHashMap != null) && (this.a.sessionInfo.curFriendUin.equals(paramHashMap.uin)))
      {
        if (this.a.sessionInfo.curType == 1024) {
          this.a.sessionInfo.curType = 1025;
        }
        paramHashMap = this.a.a.a(this.a.mContext, this.a.sessionInfo.curFriendUin);
        if (paramHashMap != null)
        {
          ahkz.a(this.a, true);
          this.a.mSubTilteText.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          ahkz.a(this.a).setOnClickListener(null);
          ahkz.b(this.a).setOnClickListener(null);
          this.a.mSubTilteText.setText(paramHashMap);
          if (acvu.a) {
            this.a.mSubTilteText.setContentDescription(paramHashMap);
          }
          ahkz.a(this.a, true);
          this.a.updateAddFriendAndShieldView();
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          return;
          ahkz.b(this.a, false);
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.a.tag, 2, "onGetQidianUserDetailInfo not current curFriendUin");
      return;
    }
    QLog.d(this.a.tag, 2, "onGetQidianUserDetailInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahle
 * JD-Core Version:    0.7.0.1
 */