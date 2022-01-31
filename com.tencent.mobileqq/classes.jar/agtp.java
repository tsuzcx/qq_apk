import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class agtp
  extends agsl
{
  private agtp(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject;
    if ((paramLocalMediaInfo == null) || (TextUtils.isEmpty(paramLocalMediaInfo.path)) || (this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent() == null))
    {
      localObject = new StringBuilder().append("data error: ");
      if (paramLocalMediaInfo == null)
      {
        paramLocalMediaInfo = "";
        bizq.d("PhotoListLogicAECamera", paramLocalMediaInfo);
      }
    }
    do
    {
      return;
      paramLocalMediaInfo = paramLocalMediaInfo.path;
      break;
      m();
      if (!birc.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent()))
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).d();
        localObject = new Bundle();
        ((Bundle)localObject).putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", paramLocalMediaInfo.path);
        ((Bundle)localObject).putBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT", true);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
        a(paramLocalMediaInfo, (Bundle)localObject);
        return;
      }
      localObject = xhf.a().a(paramLocalMediaInfo.path, "2");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    bawu.a(paramLocalMediaInfo.path, localOptions);
    int i = axli.a;
    float f = localOptions.outWidth / localOptions.outHeight;
    int k = avtc.a(i);
    int m = avtc.a((int)(k / f));
    int j = k;
    i = m;
    if (m > bkxd.a)
    {
      j = avtc.a((int)(k * bkxd.a / m));
      i = bkxd.a;
    }
    xhf.a().a(paramLocalMediaInfo.path, (String)localObject, "2", j, i, false, 0, new agtt(this, (String)localObject, paramLocalMediaInfo));
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent() == null)) {}
    while (paramLocalMediaInfo == null) {
      return;
    }
    int i = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getIntExtra("entrance_type", 120);
    bkpe.a((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get(), paramLocalMediaInfo.path, paramLocalMediaInfo, 0, (int)paramLocalMediaInfo.mDuration, i, 10023, 0, null, null, false, 11, 14, paramBundle);
  }
  
  public static agse b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agse == null) || (jdField_a_of_type_Agse.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agse == null) || (jdField_a_of_type_Agse.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agse = new agtp(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agse;
    }
    finally {}
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent() != null)) {
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().putExtra("key_from_pic_choose", true);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    if (((paramInt1 == 10023) || (paramInt1 == 2)) && (paramInt2 == -1))
    {
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).setResult(paramInt2, paramIntent);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
    }
    else if (paramInt1 == 10023)
    {
      int i = j;
      if (paramIntent != null)
      {
        i = j;
        if (paramIntent.getBooleanExtra("key_edit_to_photo_list", false)) {
          i = 1;
        }
      }
      if (i != 0) {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null))
    {
      bizq.d("PhotoListLogicAECamera", "mActivity is null");
      return;
    }
    paramAdapterView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.a(paramInt);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c();
    agmi.a(BaseApplicationImpl.getContext()).a(new agtq(this), paramAdapterView);
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null))
    {
      bizq.d("PhotoListLogicAECamera", "mActivity is null.");
      return;
    }
    if (!bbbd.a())
    {
      bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131719044), 0).a();
      return;
    }
    paramAdapterView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.a(paramInt);
    if (paramAdapterView == null)
    {
      bizq.d("PhotoListLogicAECamera", "photoInfo is null.");
      return;
    }
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    paramView.putExtra("file_send_path", paramAdapterView.path);
    paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    paramView.putExtra("PhotoConst.VIDEO_SIZE", paramAdapterView.fileSize);
    paramView.putExtra("file_send_duration", paramAdapterView.mDuration);
    paramView.putExtra("file_width", paramAdapterView.mediaWidth);
    paramView.putExtra("file_height", paramAdapterView.mediaHeight);
    paramView.putExtra("media_info", paramAdapterView);
    paramView.putExtra("key_from_pic_choose", true);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramAdapterView.path);
    ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).c();
    m();
    agmi.a(BaseApplicationImpl.getContext()).a(new agtr(this, paramView, localArrayList), paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtp
 * JD-Core Version:    0.7.0.1
 */