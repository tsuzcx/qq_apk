import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AdapterView;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class agts
  extends agsj
{
  private agts(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static agsc b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agsc = new agts(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agsc;
    }
    finally {}
  }
  
  private void b(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Agsb.b >= 1000L)
    {
      this.jdField_a_of_type_Agsb.b = l;
      bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramString, 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).g);
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent() != null)) {
      return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getBooleanExtra("pic_back_type_result", false);
    }
    return false;
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Agrz.jdField_a_of_type_Int;
  }
  
  private void g(Intent paramIntent)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(-1, paramIntent);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    if ((!c()) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.a(paramInt).selectStatus != 1))
    {
      b(String.format(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131689790), new Object[] { Integer.valueOf(this.jdField_a_of_type_Agrz.jdField_a_of_type_Int) }));
      return;
    }
    super.a(paramView, paramInt, paramCheckBox);
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.a(paramInt);
    paramView = new Intent();
    if (b())
    {
      if (paramAdapterView == null) {}
      for (paramAdapterView = "";; paramAdapterView = paramAdapterView.path)
      {
        paramView.putExtra("PhotoConst.SELECTED_PATHS", paramAdapterView);
        g(paramView);
        return;
      }
    }
    if (paramAdapterView == null) {}
    for (paramAdapterView = "";; paramAdapterView = paramAdapterView.path)
    {
      paramView.putExtra("PhotoConst.SELECTED_PATHS", paramAdapterView);
      paramView.putExtra("pic_choose_in_node_id", ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getIntExtra("pic_choose_in_node_id", 0));
      paramView.putExtra("pic_result_back_type", 1);
      AETemplateInfoFragment.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramView);
      break;
    }
  }
  
  protected boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (paramLocalMediaInfo == null) {
      return false;
    }
    if ((paramLocalMediaInfo.selectStatus == 2) && (paramBoolean) && (!c()))
    {
      b(String.format(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131689790), new Object[] { Integer.valueOf(this.jdField_a_of_type_Agrz.jdField_a_of_type_Int) }));
      return false;
    }
    return super.a(paramLocalMediaInfo, paramBoolean);
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
  }
  
  protected void c(View paramView)
  {
    if (c())
    {
      b(String.format(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131689791), new Object[] { Integer.valueOf(this.jdField_a_of_type_Agrz.jdField_a_of_type_Int) }));
      return;
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setClickable(false);
    paramView = new Intent();
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
    paramView.putExtra("pic_choose_in_node_id", ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getIntExtra("pic_choose_in_node_id", 0));
    paramView.putExtra("pic_result_back_type", 0);
    AETemplateInfoFragment.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramView);
    bizt.a().x();
    g(paramView);
  }
  
  protected void d()
  {
    super.d();
    String str = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getString(2131717113);
    int i = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size();
    str = str + " " + i + "/" + this.jdField_a_of_type_Agrz.jdField_a_of_type_Int;
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setText(str);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setEnabled(true);
    if (c())
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setBackgroundResource(2130848703);
      return;
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c.setBackgroundResource(2130837669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agts
 * JD-Core Version:    0.7.0.1
 */