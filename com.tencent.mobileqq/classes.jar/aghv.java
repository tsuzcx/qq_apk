import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.util.WeakReference;

public class aghv
  extends aggm
{
  boolean a;
  
  private aghv(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static aggh b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Aggh == null) || (jdField_a_of_type_Aggh.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Aggh = new aghv(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Aggh;
    }
    finally {}
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(str) == 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  public Intent a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().putExtra("key_pic_to_edit_from", 3);
    awqx.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 3, 0, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() + "", "", "", "");
    return super.a(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    return "最多只能选择" + this.jdField_a_of_type_Aggf.jdField_a_of_type_Int + "张图片\\视频";
  }
  
  protected void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Aggg.w = true;
    super.a(paramIntent);
    this.jdField_a_of_type_Aggg.s = true;
    this.jdField_a_of_type_Aggg.e = false;
    this.jdField_a_of_type_Aggg.h = true;
    this.jdField_a_of_type_Aggg.f = true;
    this.jdField_a_of_type_Aggg.jdField_a_of_type_Afzz.a(true);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.jdField_a_of_type_Aggg.jdField_c_of_type_JavaLangString = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131629465);
  }
  
  protected void a(View paramView)
  {
    if (this.jdField_a_of_type_Aggg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      int i = PhotoUtils.c(this.jdField_a_of_type_Aggg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      awqx.b(null, "CliOper", "", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString, "0X800A916", "0X800A916", i, 0, "", "", "", "");
    }
    super.a(paramView);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfv.a(paramInt);
    if (localLocalMediaInfo.selectStatus == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      String[] arrayOfString = agaq.a(localLocalMediaInfo.mMimeType);
      if ((!this.jdField_a_of_type_Aggg.s) || (arrayOfString == null) || (!"video".equals(arrayOfString[0])) || ((localLocalMediaInfo.mDuration <= 1200000L) && (localLocalMediaInfo.fileSize <= this.jdField_a_of_type_Aggg.jdField_a_of_type_Long))) {
        break;
      }
      bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131653672), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131167766));
      localLocalMediaInfo.selectStatus = 2;
      paramCheckBox.setChecked(localLocalMediaInfo.mChecked);
      return;
    }
    super.a(paramView, paramInt, paramCheckBox);
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramLocalMediaInfo.path) == 1)
    {
      LocalMediaInfo localLocalMediaInfo = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramLocalMediaInfo.path);
      if ((localLocalMediaInfo != null) && (localLocalMediaInfo.fileSize > 104345600L) && (paramLocalMediaInfo.selectStatus == 1))
      {
        bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131653694), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131167766));
        baaf.d();
      }
      return;
    }
    super.a(paramLocalMediaInfo);
  }
  
  protected void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("key_pic_to_edit_from", 2);
    super.a(paramBoolean, paramIntent);
  }
  
  protected boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((baaf.a(paramLocalMediaInfo) == 1) && ((paramLocalMediaInfo.mDuration > 1200000L) || (paramLocalMediaInfo.fileSize > this.jdField_a_of_type_Aggg.jdField_a_of_type_Long)))
      {
        bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131653672), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131167766));
        return false;
      }
      if ((((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (baaf.a(paramLocalMediaInfo) == 1) && (paramLocalMediaInfo.fileSize > 104345600L))
      {
        bbmy.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131653694), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDimensionPixelSize(2131167766));
        baaf.d();
      }
    }
    return super.a(paramLocalMediaInfo, paramBoolean);
  }
  
  protected void b(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aggg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      int i = PhotoUtils.c(this.jdField_a_of_type_Aggg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      awqx.b(null, "CliOper", "", this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString, "0X800A915", "0X800A915", i, 0, "", "", "", "");
    }
    super.b(paramIntent);
  }
  
  protected void c(View paramView)
  {
    super.c(paramView);
    awqx.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 2, 0, this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() + "", "", "", "");
  }
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap.size())) {
          break;
        }
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      return;
    }
    if (b())
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    Button localButton = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetButton;
    if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilArrayList.size() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  protected void e()
  {
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaUtilHashMap.size() > 0))
    {
      if (this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")) {
        awrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      }
      for (;;)
      {
        a(localIntent, true);
        return;
        if ((this.jdField_a_of_type_Aggf.b.equalsIgnoreCase("Camera")) || (this.jdField_a_of_type_Aggf.b.equalsIgnoreCase("camera")) || (this.jdField_a_of_type_Aggf.b.contains("Camera")) || (this.jdField_a_of_type_Aggf.b.contains("camera"))) {
          awrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        } else {
          awrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
        }
      }
    }
    super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aghv
 * JD-Core Version:    0.7.0.1
 */