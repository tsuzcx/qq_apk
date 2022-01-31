import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoPreviewActivity.ImageAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.Gallery.LayoutParams;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class aipc
  extends aimu
{
  boolean a;
  
  protected aipc(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  protected void c()
  {
    if ("FromFastImage".equals(this.jdField_a_of_type_Aimr.from))
    {
      azmj.b(null, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      aild.d();
    }
    if ("FromCamera".equals(this.jdField_a_of_type_Aimr.from)) {
      aild.b();
    }
    super.c();
    azmj.b(null, "CliOper", "", "", "0X8005147", "0X8005147", 0, 0, "", "", "", "");
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject4 = null;
    if (paramView != null) {
      return paramView;
    }
    Object localObject2 = ((NewPhotoPreviewActivity)this.mActivity).adapter.getItem(paramInt);
    int i;
    label44:
    Object localObject3;
    Object localObject1;
    label116:
    Object localObject5;
    if (((NewPhotoPreviewActivity)this.mActivity).getMediaType((String)localObject2) == 1)
    {
      i = 1;
      localObject3 = (URLDrawable)this.jdField_a_of_type_Aimr.activeDrawable.get(paramInt);
      if (i == 0) {
        break label215;
      }
      paramViewGroup = ((NewPhotoPreviewActivity)this.mActivity).getLayoutInflater().inflate(2131561137, null);
      paramViewGroup.setTag(2131296400, Boolean.valueOf(true));
      paramViewGroup.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      localObject1 = (ImageView)paramViewGroup.findViewById(2131372238);
      localObject5 = new File((String)localObject2);
      localObject5 = ((NewPhotoPreviewActivity)this.mActivity).getFileUrl((File)localObject5);
      if ((localObject3 == null) || (((URLDrawable)localObject3).getStatus() != 1) || (!((URLDrawable)localObject3).getURL().equals(localObject5))) {
        break label233;
      }
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
    }
    label215:
    label233:
    do
    {
      if (i == 0) {
        break label464;
      }
      ((ImageView)localObject1).setContentDescription(alpo.a(2131708520) + paramInt);
      return paramViewGroup;
      i = 0;
      break label44;
      localObject1 = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
      paramViewGroup = null;
      break label116;
      if (localObject2 == null) {
        break;
      }
      localObject3 = new File((String)localObject2);
    } while (!((File)localObject3).exists());
    for (;;)
    {
      try
      {
        paramView = baul.a;
        if (this.jdField_a_of_type_Aimr.cameraType != 103) {
          break label495;
        }
        localObject2 = BaseApplicationImpl.sImageCache.get((String)localObject2 + "#short_video_camera_preview_cache");
        if (!Bitmap.class.isInstance(localObject2)) {
          break label495;
        }
        paramView = (Bitmap)localObject2;
        localObject2 = new BitmapDrawable(((NewPhotoPreviewActivity)this.mActivity).getResources(), paramView);
        if (!QLog.isColorLevel()) {
          break label501;
        }
        QLog.d("PhotoPreviewActivity", 2, "shortVideo preview cache");
      }
      catch (Exception paramView)
      {
        localObject3 = localObject4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PhotoPreviewActivity", 2, paramView.getMessage());
        localObject3 = localObject4;
        continue;
      }
      localObject5 = ((NewPhotoPreviewActivity)this.mActivity).getFileUrl((File)localObject3);
      localObject3 = localObject4;
      if (localObject5 != null) {
        localObject3 = URLDrawable.getDrawable((URL)localObject5, ((NewPhotoPreviewActivity)this.mActivity).reqWidth, ((NewPhotoPreviewActivity)this.mActivity).reqHeight, paramView, (Drawable)localObject2, true);
      }
      if (localObject3 == null) {
        break;
      }
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
      this.jdField_a_of_type_Aimr.activeDrawable.put(paramInt, localObject3);
      break;
      label464:
      ((ImageView)localObject1).setContentDescription(alpo.a(2131708518) + paramInt);
      return localObject1;
      label495:
      localObject2 = null;
      continue;
      label501:
      paramView = (View)localObject2;
    }
  }
  
  public void initData(Intent paramIntent)
  {
    this.jdField_a_of_type_Aimr.c = true;
    super.initData(paramIntent);
    Object localObject = (BinderWarpper)paramIntent.getParcelableExtra("binder_presendService");
    if (localObject != null)
    {
      if (PresendPicMgr.a(null) != null) {
        PresendPicMgr.a(null).b();
      }
      localObject = PresendPicMgr.b(awek.a(((BinderWarpper)localObject).a));
      if (!"FromFastImage".equals(this.jdField_a_of_type_Aimr.from)) {
        break label243;
      }
    }
    label243:
    for (this.jdField_a_of_type_Aimr.f = 1037;; this.jdField_a_of_type_Aimr.f = 1008)
    {
      String str = (String)paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS").get(0);
      if (((NewPhotoPreviewActivity)this.mActivity).getMediaType(str) != 1)
      {
        ((PresendPicMgr)localObject).a(str, this.jdField_a_of_type_Aimr.f);
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "  initData , presendMgr = " + localObject + ",picpath = " + str + ",from = " + this.jdField_a_of_type_Aimr.from + ",mBusiType = " + this.jdField_a_of_type_Aimr.f);
        }
      }
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("callFromFastImage", false);
      if ("FromFastImage".equals(this.jdField_a_of_type_Aimr.from)) {
        aild.c();
      }
      if ("FromCamera".equals(this.jdField_a_of_type_Aimr.from)) {
        aild.a();
      }
      return;
    }
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).backToPhotoListBtn.setText(2131695280);
    ((NewPhotoPreviewActivity)this.mActivity).cancelTv.setVisibility(4);
    ((NewPhotoPreviewActivity)this.mActivity).selectedBox.setVisibility(8);
    ((NewPhotoPreviewActivity)this.mActivity).selectLayout.setVisibility(8);
  }
  
  public void onBackPressed(boolean paramBoolean)
  {
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (localPresendPicMgr != null) {
      if (!"FromCamera".equals(this.jdField_a_of_type_Aimr.from)) {
        break label44;
      }
    }
    label44:
    for (int i = 1016;; i = 1017)
    {
      localPresendPicMgr.a(i);
      ((NewPhotoPreviewActivity)this.mActivity).finish();
      return;
    }
  }
  
  public void onMagicStickClick(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aimr.a != null)
    {
      azmj.b(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_Boolean) {
        azmj.b(null, "CliOper", "", "", "0X8004D95", "0X8004D95", 0, 0, "", "", "", "");
      }
    }
    super.onMagicStickClick(paramView, paramInt1, paramBundle, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipc
 * JD-Core Version:    0.7.0.1
 */