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

class aiuv
  implements AdapterView.OnItemClickListener
{
  aiuv(aius paramaius) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject2 = null;
    paramAdapterView = aius.a(this.a).getList();
    aiup localaiup = (aiup)paramAdapterView.get(paramInt);
    if (0L != localaiup.a.skin_permission_state)
    {
      aiup.c = ((aiup)paramAdapterView.get(paramInt)).a.skin_id;
      aius.a(this.a).notifyDataSetChanged();
      return;
    }
    String str1 = localaiup.a.pop_dialog.dialog_title;
    String str2 = localaiup.a.pop_dialog.dialog_tips;
    paramView = localaiup.a.pop_dialog.left_tips;
    Object localObject1 = localaiup.a.pop_dialog.right_tips;
    paramAdapterView = paramView;
    if (TextUtils.isEmpty(paramView)) {
      paramAdapterView = null;
    }
    paramView = (View)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramView = null;
    }
    if ((paramAdapterView == null) && (paramView == null)) {
      paramAdapterView = alpo.a(2131705813);
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
        paramAdapterView = bdcd.a(aius.a(this.a), 230, str1, str2, paramAdapterView, paramView, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject1);
        paramAdapterView.setCancelable(false);
        paramAdapterView.setCanceledOnTouchOutside(false);
        paramAdapterView.show();
        return;
        localObject1 = new aiuw(this, localaiup);
        break;
        label229:
        localObject2 = new aiux(this, localaiup);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiuv
 * JD-Core Version:    0.7.0.1
 */