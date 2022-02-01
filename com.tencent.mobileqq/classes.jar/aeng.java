import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.widget.AdapterView;
import java.lang.ref.WeakReference;
import java.util.List;

public class aeng
  implements bljm
{
  public aeng(EmosmActivity paramEmosmActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    label10:
    EmoticonPackage localEmoticonPackage;
    label244:
    do
    {
      int i;
      do
      {
        break label10;
        do
        {
          return;
        } while (this.a.jdField_a_of_type_Bjbs.isShowing());
        i = paramInt - this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeaderViewsCount();
      } while (i < 0);
      localEmoticonPackage = (EmoticonPackage)this.a.jdField_a_of_type_Ashn.getItem(i);
      if (this.a.jdField_b_of_type_Boolean)
      {
        this.a.jdField_a_of_type_Ashn.a(i);
        this.a.jdField_a_of_type_Ashn.notifyDataSetChanged();
        paramAdapterView = this.a.jdField_a_of_type_Ashn.a();
        if ((paramAdapterView != null) && (paramAdapterView.size() > 0)) {
          this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
        }
        for (;;)
        {
          paramInt = 0;
          if (paramAdapterView != null) {
            paramInt = paramAdapterView.size();
          }
          this.a.setTitle(String.format(this.a.getResources().getString(2131691935), new Object[] { Integer.valueOf(paramInt) }));
          if (!this.a.jdField_a_of_type_Ashn.a(i)) {
            break;
          }
          if (this.a.jdField_b_of_type_Int != 1) {
            break label244;
          }
          bdll.b(this.a.app, "dc00898", "", "", "0X800AB11", "0X800AB11", 0, 0, "", "", "", "");
          return;
          this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
        bdll.b(this.a.app, "dc00898", "", "", "0X800AB17", "0X800AB17", 0, 0, "", "", "", "");
        return;
      }
    } while (!asfa.a(this.a));
    this.a.jdField_a_of_type_Boolean = true;
    paramAdapterView = localEmoticonPackage.epId;
    boolean bool1 = false;
    if (localEmoticonPackage.jobType == 2)
    {
      paramAdapterView = localEmoticonPackage.kinId;
      bool1 = true;
    }
    paramView = null;
    if (localEmoticonPackage.jobType == 4)
    {
      paramView = new Intent();
      paramView.putExtra("EXTRA_KEY_IS_SMALL_EMOTICON", true);
    }
    boolean bool2;
    if (localEmoticonPackage.jobType == 4)
    {
      bool2 = true;
      if (1 != this.a.getIntent().getExtras().getInt("emojimall_src", 3)) {
        break label494;
      }
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.app.getAccount(), 8, paramAdapterView, bool1, paramView, bool2);
    }
    for (;;)
    {
      bdll.b(this.a.app, "CliOper", "", "", "ep_mall", "Clk_ep_mine_detail", 0, 0, localEmoticonPackage.epId, "", "", "");
      if (this.a.jdField_b_of_type_Int != 1) {
        break label530;
      }
      bdll.b(this.a.app, "dc00898", "", "", "0X800AB0E", "0X800AB0E", 0, 0, "", "", "", "");
      return;
      bool2 = false;
      break;
      label494:
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.app.getAccount(), 4, paramAdapterView, bool1, paramView, bool2);
    }
    label530:
    bdll.b(this.a.app, "dc00898", "", "", "0X800AB13", "0X800AB13", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeng
 * JD-Core Version:    0.7.0.1
 */