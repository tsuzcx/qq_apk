import Wallet.PopDialog;
import Wallet.SkinInfo;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class agog
  implements AdapterView.OnItemClickListener
{
  agog(agod paramagod) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject2 = null;
    paramAdapterView = agod.a(this.a).getList();
    agoa localagoa = (agoa)paramAdapterView.get(paramInt);
    if (0L != localagoa.a.skin_permission_state)
    {
      agoa.c = ((agoa)paramAdapterView.get(paramInt)).a.skin_id;
      agod.a(this.a).notifyDataSetChanged();
      return;
    }
    String str1 = localagoa.a.pop_dialog.dialog_title;
    String str2 = localagoa.a.pop_dialog.dialog_tips;
    paramView = localagoa.a.pop_dialog.left_tips;
    Object localObject1 = localagoa.a.pop_dialog.right_tips;
    paramAdapterView = paramView;
    if (TextUtils.isEmpty(paramView)) {
      paramAdapterView = null;
    }
    paramView = (View)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramView = null;
    }
    if ((paramAdapterView == null) && (paramView == null)) {
      paramAdapterView = ajjy.a(2131639645);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramAdapterView))
      {
        localObject1 = null;
        if (!TextUtils.isEmpty(paramView)) {
          break label229;
        }
      }
      for (;;)
      {
        paramAdapterView = babr.a(agod.a(this.a), 230, str1, str2, paramAdapterView, paramView, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject1);
        paramAdapterView.setCancelable(false);
        paramAdapterView.setCanceledOnTouchOutside(false);
        paramAdapterView.show();
        return;
        localObject1 = new agoh(this, localagoa);
        break;
        label229:
        localObject2 = new agoi(this, localagoa);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agog
 * JD-Core Version:    0.7.0.1
 */