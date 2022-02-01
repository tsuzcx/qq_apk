import Wallet.PopDialog;
import Wallet.SkinInfo;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class alcn
  implements AdapterView.OnItemClickListener
{
  alcn(alck paramalck) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject4 = null;
    Object localObject1 = alck.a(this.a).getList();
    alch localalch = (alch)((List)localObject1).get(paramInt);
    if (0L != localalch.a.skin_permission_state)
    {
      alch.c = ((alch)((List)localObject1).get(paramInt)).a.skin_id;
      alck.a(this.a).notifyDataSetChanged();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    String str1 = localalch.a.pop_dialog.dialog_title;
    String str2 = localalch.a.pop_dialog.dialog_tips;
    Object localObject2 = localalch.a.pop_dialog.left_tips;
    Object localObject3 = localalch.a.pop_dialog.right_tips;
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = null;
    }
    localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = null;
    }
    if ((localObject1 == null) && (localObject2 == null)) {
      localObject1 = anzj.a(2131704333);
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = null;
        label193:
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label263;
        }
      }
      for (;;)
      {
        localObject1 = bhlq.a(alck.a(this.a), 230, str1, str2, (String)localObject1, (String)localObject2, (DialogInterface.OnClickListener)localObject4, (DialogInterface.OnClickListener)localObject3);
        ((Dialog)localObject1).setCancelable(false);
        ((Dialog)localObject1).setCanceledOnTouchOutside(false);
        ((Dialog)localObject1).show();
        break;
        localObject3 = new alco(this, localalch);
        break label193;
        label263:
        localObject4 = new alcp(this, localalch);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alcn
 * JD-Core Version:    0.7.0.1
 */