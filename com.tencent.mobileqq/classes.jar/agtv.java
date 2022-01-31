import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import mqq.util.WeakReference;

public class agtv
  extends agsl
{
  private bbjb jdField_a_of_type_Bbjb;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c = false;
  
  private agtv(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static agse b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agse == null) || (jdField_a_of_type_Agse.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agse == null) || (jdField_a_of_type_Agse.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agse = new agtv(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agse;
    }
    finally {}
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    axqw.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 3, 0, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() + "", "", "", "");
    if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agru.a(paramInt).selectStatus != 1) {
      if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Agsb.jdField_a_of_type_Int) {
        break label152;
      }
    }
    label152:
    for (int i = 2;; i = 1)
    {
      axqw.b(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i, 0, "", "", "", "");
      return super.a(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_Agsb.jdField_a_of_type_Int;
    return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695099, new Object[] { Integer.valueOf(i) });
  }
  
  protected void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Agsb.d = true;
    this.b = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    super.a(paramIntent);
    this.jdField_a_of_type_Agsd.h = true;
    this.jdField_a_of_type_Agsd.c = false;
    this.jdField_a_of_type_Agsd.p = true;
    this.jdField_a_of_type_Agsd.n = true;
    this.jdField_a_of_type_Agsd.jdField_a_of_type_Aglx.a(true);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.jdField_a_of_type_Agsd.jdField_a_of_type_JavaLangString = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695146);
    if (this.jdField_a_of_type_Agsb.jdField_c_of_type_Int == 2) {
      this.c = true;
    }
    paramIntent = new bbjb().a(this.jdField_a_of_type_Agsb.jdField_b_of_type_Int).b(this.jdField_a_of_type_Agsb.jdField_b_of_type_Long);
    if ((!this.b) && (!this.jdField_a_of_type_Agsd.w)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Bbjb = paramIntent.a(bool);
      return;
    }
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Object localObject = new com.tencent.util.Pair(new ArrayList(), new ArrayList());
    boolean bool;
    if (this.jdField_a_of_type_Bbjb != null)
    {
      localObject = this.jdField_a_of_type_Bbjb;
      if (this.jdField_a_of_type_Agsb.jdField_c_of_type_Int == 2)
      {
        bool = true;
        paramArrayList = ((bbjb)localObject).a(paramArrayList, bool, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap);
        paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (ArrayList)paramArrayList.second);
      }
    }
    for (;;)
    {
      super.a(paramIntent, paramBoolean, (ArrayList)paramArrayList.first);
      return;
      bool = false;
      break;
      ((ArrayList)((com.tencent.util.Pair)localObject).first).addAll(paramArrayList);
      paramArrayList = (ArrayList<String>)localObject;
    }
  }
  
  protected void a(View paramView)
  {
    if (this.jdField_a_of_type_Agsd.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      int i = PhotoUtils.c(this.jdField_a_of_type_Agsd.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      axqw.b(null, "CliOper", "", this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaLangString, "0X800A916", "0X800A916", i, 0, "", "", "", "");
    }
    super.a(paramView);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agru.a(paramInt);
    ArrayList localArrayList = this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "current select count:" + localArrayList.size());
    }
    int k = paramView.selectStatus;
    int i;
    if ((k != 1) && (localArrayList.size() >= this.jdField_a_of_type_Agsb.jdField_a_of_type_Int))
    {
      i = 1;
      if (i == 0) {
        break label217;
      }
    }
    label217:
    for (int j = 2;; j = 1)
    {
      axqw.b(null, "dc00898", "", "", "0X800AB6C", "0X800AB6C", j, 0, "", "", "", "");
      if (i == 0) {
        break label223;
      }
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Agsd.jdField_b_of_type_Long >= 1000L)
      {
        bcpw.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), a(paramView), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).g);
        paramCheckBox.setChecked(false);
        this.jdField_a_of_type_Agsd.jdField_b_of_type_Long = l;
        k();
      }
      return;
      i = 0;
      break;
    }
    label223:
    boolean bool1;
    label249:
    PresendPicMgr localPresendPicMgr;
    Object localObject1;
    boolean bool2;
    if (k == 1)
    {
      i = 2;
      paramView.selectStatus = i;
      if (paramView.selectStatus != 1) {
        break label762;
      }
      bool1 = true;
      paramCheckBox = paramView.path;
      localPresendPicMgr = PresendPicMgr.a();
      localObject1 = agmo.a(paramView.mMimeType);
      if (!bool1) {
        break label774;
      }
      Object localObject2;
      if (this.jdField_a_of_type_Bbjb != null)
      {
        localObject2 = this.jdField_a_of_type_Bbjb;
        Context localContext = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if (this.jdField_a_of_type_Agsb.jdField_c_of_type_Int != 2) {
          break label768;
        }
        bool2 = true;
        label312:
        ((bbjb)localObject2).a(localContext, paramCheckBox, bool2, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap, true);
      }
      if ((this.jdField_a_of_type_Agsd.h) && (localObject1 != null) && ("video".equals(localObject1[0])))
      {
        localObject2 = this.jdField_a_of_type_Agsd;
        ((agsd)localObject2).d += 1;
        if (this.jdField_a_of_type_Agsd.d == 1) {
          this.jdField_a_of_type_Agsd.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramView;
        }
      }
      if ((!TextUtils.isEmpty(paramView.mMimeType)) && ("image/gif".equals(paramView.mMimeType)))
      {
        localObject2 = this.jdField_a_of_type_Agsd;
        ((agsd)localObject2).e += 1;
      }
      localArrayList.add(paramCheckBox);
      this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.add(paramView.position);
      if (this.jdField_a_of_type_Agsb.d) {
        this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap.put(paramCheckBox, paramView);
      }
      if ((localPresendPicMgr != null) && (localObject1 != null) && (localObject1[0] != null) && (!"video".equals(localObject1[0]))) {
        localPresendPicMgr.a(paramCheckBox, 1052, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getIntExtra("entrance", 0));
      }
      agqf.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_totalSelNum");
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)bbbj.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaLangString);
      if (paramView != null) {
        break label1011;
      }
      paramView = new LinkedHashMap();
      bbbj.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaLangString, paramView);
    }
    label710:
    label1011:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()));
      paramView = bbbj.jdField_c_of_type_JavaUtilHashMap;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new android.util.Pair(this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaLangString));
      }
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, bool1);
      paramView = (NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        paramView.b(bool1);
        d();
        return;
        i = 1;
        break;
        label762:
        bool1 = false;
        break label249;
        bool2 = false;
        break label312;
        if ((this.jdField_a_of_type_Agsd.h) && (localObject1 != null) && ("video".equals(localObject1[0])))
        {
          localObject1 = this.jdField_a_of_type_Agsd;
          ((agsd)localObject1).d -= 1;
          if (this.jdField_a_of_type_Agsd.d == 1) {
            this.jdField_a_of_type_Agsd.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramView;
          }
        }
        if ((!TextUtils.isEmpty(paramView.mMimeType)) && ("image/gif".equals(paramView.mMimeType)))
        {
          localObject1 = this.jdField_a_of_type_Agsd;
          ((agsd)localObject1).e -= 1;
        }
        localArrayList.remove(paramCheckBox);
        this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilArrayList.remove(paramView.position);
        if (this.jdField_a_of_type_Agsb.d) {
          this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap.remove(paramCheckBox);
        }
        if (localPresendPicMgr != null) {
          localPresendPicMgr.b(paramCheckBox, 1013);
        }
        agqf.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_cancelSelNum");
        paramView = (HashMap)bbbj.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaLangString);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = bbbj.jdField_c_of_type_JavaUtilHashMap;
        if (!paramView.containsKey(paramCheckBox)) {
          break label710;
        }
        paramView.remove(paramCheckBox);
        break label710;
      }
    }
  }
  
  protected void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_Bbjb != null)
      {
        if (!this.c) {
          this.jdField_a_of_type_Bbjb.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList, paramBoolean, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap);
        }
      }
      else
      {
        this.jdField_a_of_type_Agsb.jdField_c_of_type_Int = 2;
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setVisibility(0);
        j();
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Agsd.o) {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setVisibility(8);
      }
      return;
      this.c = false;
      break;
      this.jdField_a_of_type_Agsb.jdField_c_of_type_Int = 0;
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setVisibility(4);
    }
  }
  
  protected void a(boolean paramBoolean, Intent paramIntent)
  {
    paramIntent.putExtra("key_pic_to_edit_from", 2);
    super.a(paramBoolean, paramIntent);
  }
  
  protected boolean a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = super.a(paramLocalMediaInfo, paramBoolean);
    bbjb localbbjb;
    Context localContext;
    if ((paramBoolean) && (bool) && (this.jdField_a_of_type_Bbjb != null))
    {
      localbbjb = this.jdField_a_of_type_Bbjb;
      localContext = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
      paramLocalMediaInfo = paramLocalMediaInfo.path;
      if (this.jdField_a_of_type_Agsb.jdField_c_of_type_Int != 2) {
        break label85;
      }
    }
    label85:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localbbjb.a(localContext, paramLocalMediaInfo, paramBoolean, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaUtilHashMap, true);
      return bool;
    }
  }
  
  protected void b(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Agsd.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      int i = PhotoUtils.c(this.jdField_a_of_type_Agsd.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      axqw.b(null, "CliOper", "", this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaLangString, "0X800A915", "0X800A915", i, 0, "", "", "", "");
    }
    super.b(paramIntent);
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    axqw.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 2, 0, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() + "", "", "", "");
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agru.a(paramInt).selectStatus != 1) {
      if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Agsb.jdField_a_of_type_Int) {
        break label82;
      }
    }
    label82:
    for (int i = 2;; i = 1)
    {
      axqw.b(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i, 0, "", "", "", "");
      super.b(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaUtilHashMap.size())) {
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
    if (this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList.size() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  protected void h()
  {
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaUtilHashMap.size() > 0))
    {
      if (this.jdField_a_of_type_Agsb.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")) {
        axrl.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      }
      for (;;)
      {
        a(localIntent, true, this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaUtilArrayList);
        return;
        if ((this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaLangString.equalsIgnoreCase("Camera")) || (this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaLangString.equalsIgnoreCase("camera")) || (this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaLangString.contains("Camera")) || (this.jdField_a_of_type_Agsb.jdField_b_of_type_JavaLangString.contains("camera"))) {
          axrl.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        } else {
          axrl.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
        }
      }
    }
    super.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtv
 * JD-Core Version:    0.7.0.1
 */