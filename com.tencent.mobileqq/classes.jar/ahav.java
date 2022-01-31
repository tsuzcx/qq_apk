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

class ahav
  implements AdapterView.OnItemClickListener
{
  ahav(ahas paramahas) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject2 = null;
    paramAdapterView = ahas.a(this.a).getList();
    ahap localahap = (ahap)paramAdapterView.get(paramInt);
    if (0L != localahap.a.skin_permission_state)
    {
      ahap.c = ((ahap)paramAdapterView.get(paramInt)).a.skin_id;
      ahas.a(this.a).notifyDataSetChanged();
      return;
    }
    String str1 = localahap.a.pop_dialog.dialog_title;
    String str2 = localahap.a.pop_dialog.dialog_tips;
    paramView = localahap.a.pop_dialog.left_tips;
    Object localObject1 = localahap.a.pop_dialog.right_tips;
    paramAdapterView = paramView;
    if (TextUtils.isEmpty(paramView)) {
      paramAdapterView = null;
    }
    paramView = (View)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramView = null;
    }
    if ((paramAdapterView == null) && (paramView == null)) {
      paramAdapterView = ajyc.a(2131705430);
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
        paramAdapterView = bbcv.a(ahas.a(this.a), 230, str1, str2, paramAdapterView, paramView, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject1);
        paramAdapterView.setCancelable(false);
        paramAdapterView.setCanceledOnTouchOutside(false);
        paramAdapterView.show();
        return;
        localObject1 = new ahaw(this, localahap);
        break;
        label229:
        localObject2 = new ahax(this, localahap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahav
 * JD-Core Version:    0.7.0.1
 */