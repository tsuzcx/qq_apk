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

class aizk
  implements AdapterView.OnItemClickListener
{
  aizk(aizh paramaizh) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject2 = null;
    paramAdapterView = aizh.a(this.a).getList();
    aize localaize = (aize)paramAdapterView.get(paramInt);
    if (0L != localaize.a.skin_permission_state)
    {
      aize.c = ((aize)paramAdapterView.get(paramInt)).a.skin_id;
      aizh.a(this.a).notifyDataSetChanged();
      return;
    }
    String str1 = localaize.a.pop_dialog.dialog_title;
    String str2 = localaize.a.pop_dialog.dialog_tips;
    paramView = localaize.a.pop_dialog.left_tips;
    Object localObject1 = localaize.a.pop_dialog.right_tips;
    paramAdapterView = paramView;
    if (TextUtils.isEmpty(paramView)) {
      paramAdapterView = null;
    }
    paramView = (View)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramView = null;
    }
    if ((paramAdapterView == null) && (paramView == null)) {
      paramAdapterView = alud.a(2131705825);
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
        paramAdapterView = bdgm.a(aizh.a(this.a), 230, str1, str2, paramAdapterView, paramView, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject1);
        paramAdapterView.setCancelable(false);
        paramAdapterView.setCanceledOnTouchOutside(false);
        paramAdapterView.show();
        return;
        localObject1 = new aizl(this, localaize);
        break;
        label229:
        localObject2 = new aizm(this, localaize);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizk
 * JD-Core Version:    0.7.0.1
 */