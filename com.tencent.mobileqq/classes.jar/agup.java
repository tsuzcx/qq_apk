import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicWeiyun.1;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;

public class agup
  extends agsj
{
  private boolean a;
  
  private agup(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static agsc b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agsc = new agup(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agsc;
    }
    finally {}
  }
  
  protected List<LocalMediaInfo> a()
  {
    Object localObject2 = (NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localObject2 == null) || (((NewPhotoListActivity)localObject2).isFinishing()))
    {
      bbfb.a("PEAK", "getAlbumMedias");
      return null;
    }
    Object localObject1 = bifz.a(((NewPhotoListActivity)localObject2).getApplicationContext(), this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString, "pref_select_album");
    List localList;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localList = bifz.a((String)localObject1);
      if ((localList != null) && (!localList.isEmpty()) && (!TextUtils.equals((CharSequence)localList.get(0), "$RecentAlbumId")))
      {
        localObject1 = new ArrayList();
        ((List)localObject1).add(localList.get(0));
      }
    }
    for (;;)
    {
      localList = bbbx.a((Context)localObject2, 1000, (List)localObject1, this.jdField_a_of_type_Agsb.a);
      bbfb.a("PEAK", "getAlbumMedias");
      if (localList == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
        return null;
      }
      int j;
      if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() != 0))
      {
        i = 0;
        if (i < this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject1 = (String)this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
            j = i;
          }
          for (;;)
          {
            i = j + 1;
            break;
            j = i;
            if (!new File((String)localObject1).exists()) {
              if ((((String)localObject1).startsWith("http")) && (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap != null))
              {
                j = i;
                if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject1)) {}
              }
              else
              {
                this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.remove(i);
                i -= 1;
                j = i;
                if (this.jdField_a_of_type_Agrz.d)
                {
                  j = i;
                  if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap != null)
                  {
                    j = i;
                    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject1))
                    {
                      this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.remove(localObject1);
                      j = i;
                    }
                  }
                }
              }
            }
          }
        }
      }
      int i = localList.size();
      localObject2 = ((NewPhotoListActivity)localObject2).getIntent().getStringArrayListExtra("weiyun_filter_data");
      if (localObject2 != null)
      {
        i -= 1;
        if (i >= 0)
        {
          localObject1 = (LocalMediaInfo)localList.get(i);
          j = ((LocalMediaInfo)localObject1).path.lastIndexOf("/");
          String str = ((LocalMediaInfo)localObject1).path.substring(j + 1);
          File localFile = new File(((LocalMediaInfo)localObject1).path);
          if (localFile.exists()) {}
          for (localObject1 = str + localFile.length();; localObject1 = str + ((LocalMediaInfo)localObject1).fileSize)
          {
            if (((ArrayList)localObject2).contains(localObject1)) {
              localList.remove(i);
            }
            i -= 1;
            break;
          }
        }
      }
      return localList;
      localObject1 = null;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    ArrayList localArrayList;
    if ((localNewPhotoListActivity != null) && (!localNewPhotoListActivity.isFinishing()) && (paramInt1 == 100010))
    {
      if (paramInt2 != -1) {
        break label115;
      }
      Intent localIntent = new Intent();
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) {
        break label103;
      }
      localArrayList = new ArrayList(0);
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      localNewPhotoListActivity.setResult(-1, localIntent);
      localNewPhotoListActivity.finish();
      bbbx.a(localNewPhotoListActivity, false, false);
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2, paramIntent);
      return;
      label103:
      localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
      break;
      label115:
      d();
      localNewPhotoListActivity.runOnUiThread(new PhotoListLogicWeiyun.1(this, localNewPhotoListActivity));
    }
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    Object localObject = (NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localObject == null) || (((NewPhotoListActivity)localObject).isFinishing())) {
      return;
    }
    this.jdField_a_of_type_Agrz.b = paramIntent.getStringExtra("ALBUM_NAME");
    localObject = bifz.a(((NewPhotoListActivity)localObject).getApplicationContext(), this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString, "pref_select_album");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = bifz.a((String)localObject);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString = ((String)((List)localObject).get(0));
      }
    }
    this.jdField_a_of_type_Agsb.d = false;
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.ENTER_ALBUM_LIST", false);
  }
  
  protected void a(View paramView)
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localNewPhotoListActivity != null) && (!localNewPhotoListActivity.isFinishing())) {
      localNewPhotoListActivity.setResult(-1, new Intent());
    }
    super.a(paramView);
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) && (!paramBoolean)) {
      a(null);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void c()
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localNewPhotoListActivity == null) || (localNewPhotoListActivity.isFinishing())) {}
    do
    {
      return;
      View localView = localNewPhotoListActivity.findViewById(2131368429);
      if (localView != null) {
        localView.setContentDescription(localNewPhotoListActivity.getString(2131720922));
      }
    } while (!this.jdField_a_of_type_Boolean);
    b(localNewPhotoListActivity.getIntent());
    localNewPhotoListActivity.a(true);
  }
  
  protected void c(Intent paramIntent)
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localNewPhotoListActivity == null) || (localNewPhotoListActivity.isFinishing())) {
      return;
    }
    localNewPhotoListActivity.startActivityForResult(paramIntent, 100010);
  }
  
  protected void h()
  {
    NewPhotoListActivity localNewPhotoListActivity = (NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localNewPhotoListActivity == null) || (localNewPhotoListActivity.isFinishing())) {
      return;
    }
    Intent localIntent;
    if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId"))
    {
      axrn.a(localNewPhotoListActivity).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null)
      {
        agqd.a(localNewPhotoListActivity.getIntent(), this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size());
        agqd.a(localNewPhotoListActivity.getIntent(), this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size(), this.jdField_a_of_type_Agrz.jdField_c_of_type_Int);
      }
      localIntent = new Intent();
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList != null) {
        break label265;
      }
    }
    label265:
    for (ArrayList localArrayList = new ArrayList(0);; localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList)
    {
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      localNewPhotoListActivity.setResult(-1, localIntent);
      localNewPhotoListActivity.finish();
      bbbx.a(localNewPhotoListActivity, false, false);
      return;
      if ((this.jdField_a_of_type_Agrz.b.equalsIgnoreCase("Camera")) || (this.jdField_a_of_type_Agrz.b.equalsIgnoreCase("camera")) || (this.jdField_a_of_type_Agrz.b.contains("Camera")) || (this.jdField_a_of_type_Agrz.b.contains("camera")))
      {
        axrn.a(localNewPhotoListActivity).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        break;
      }
      axrn.a(localNewPhotoListActivity).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agup
 * JD-Core Version:    0.7.0.1
 */