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

class ahat
  implements AdapterView.OnItemClickListener
{
  ahat(ahaq paramahaq) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject2 = null;
    paramAdapterView = ahaq.a(this.a).getList();
    ahan localahan = (ahan)paramAdapterView.get(paramInt);
    if (0L != localahan.a.skin_permission_state)
    {
      ahan.c = ((ahan)paramAdapterView.get(paramInt)).a.skin_id;
      ahaq.a(this.a).notifyDataSetChanged();
      return;
    }
    String str1 = localahan.a.pop_dialog.dialog_title;
    String str2 = localahan.a.pop_dialog.dialog_tips;
    paramView = localahan.a.pop_dialog.left_tips;
    Object localObject1 = localahan.a.pop_dialog.right_tips;
    paramAdapterView = paramView;
    if (TextUtils.isEmpty(paramView)) {
      paramAdapterView = null;
    }
    paramView = (View)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramView = null;
    }
    if ((paramAdapterView == null) && (paramView == null)) {
      paramAdapterView = ajya.a(2131705441);
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
        paramAdapterView = bbdj.a(ahaq.a(this.a), 230, str1, str2, paramAdapterView, paramView, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject1);
        paramAdapterView.setCancelable(false);
        paramAdapterView.setCanceledOnTouchOutside(false);
        paramAdapterView.show();
        return;
        localObject1 = new ahau(this, localahan);
        break;
        label229:
        localObject2 = new ahav(this, localahan);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahat
 * JD-Core Version:    0.7.0.1
 */