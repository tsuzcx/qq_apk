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

public class agtt
  extends agsj
{
  private bbjp jdField_a_of_type_Bbjp;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  boolean c = false;
  
  private agtt(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public static agsc b(NewPhotoListActivity paramNewPhotoListActivity)
  {
    if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {}
    try
    {
      if ((jdField_a_of_type_Agsc == null) || (jdField_a_of_type_Agsc.jdField_a_of_type_MqqUtilWeakReference.get() != paramNewPhotoListActivity)) {
        jdField_a_of_type_Agsc = new agtt(paramNewPhotoListActivity);
      }
      return jdField_a_of_type_Agsc;
    }
    finally {}
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    axqy.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 3, 0, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() + "", "", "", "");
    if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt).selectStatus != 1) {
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Agrz.jdField_a_of_type_Int) {
        break label152;
      }
    }
    label152:
    for (int i = 2;; i = 1)
    {
      axqy.b(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i, 0, "", "", "", "");
      return super.a(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_Agrz.jdField_a_of_type_Int;
    return ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695100, new Object[] { Integer.valueOf(i) });
  }
  
  protected void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Agrz.d = true;
    this.b = paramIntent.getBooleanExtra("KEY_IS_ANONYMOUS", false);
    super.a(paramIntent);
    this.jdField_a_of_type_Agsb.h = true;
    this.jdField_a_of_type_Agsb.c = false;
    this.jdField_a_of_type_Agsb.p = true;
    this.jdField_a_of_type_Agsb.n = true;
    this.jdField_a_of_type_Agsb.jdField_a_of_type_Aglv.a(true);
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", false);
    this.jdField_a_of_type_Agsb.jdField_a_of_type_JavaLangString = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131695147);
    if (this.jdField_a_of_type_Agrz.jdField_c_of_type_Int == 2) {
      this.c = true;
    }
    paramIntent = new bbjp().a(this.jdField_a_of_type_Agrz.jdField_b_of_type_Int).b(this.jdField_a_of_type_Agrz.jdField_b_of_type_Long);
    if ((!this.b) && (!this.jdField_a_of_type_Agsb.w)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Bbjp = paramIntent.a(bool);
      return;
    }
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    Object localObject = new com.tencent.util.Pair(new ArrayList(), new ArrayList());
    boolean bool;
    if (this.jdField_a_of_type_Bbjp != null)
    {
      localObject = this.jdField_a_of_type_Bbjp;
      if (this.jdField_a_of_type_Agrz.jdField_c_of_type_Int == 2)
      {
        bool = true;
        paramArrayList = ((bbjp)localObject).a(paramArrayList, bool, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap);
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
    if (this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      int i = PhotoUtils.c(this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      axqy.b(null, "CliOper", "", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString, "0X800A916", "0X800A916", i, 0, "", "", "", "");
    }
    super.a(paramView);
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt);
    ArrayList localArrayList = this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 2, "current select count:" + localArrayList.size());
    }
    int k = paramView.selectStatus;
    int i;
    if ((k != 1) && (localArrayList.size() >= this.jdField_a_of_type_Agrz.jdField_a_of_type_Int))
    {
      i = 1;
      if (i == 0) {
        break label217;
      }
    }
    label217:
    for (int j = 2;; j = 1)
    {
      axqy.b(null, "dc00898", "", "", "0X800AB6C", "0X800AB6C", j, 0, "", "", "", "");
      if (i == 0) {
        break label223;
      }
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_Agsb.jdField_b_of_type_Long >= 1000L)
      {
        bcql.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), a(paramView), 0).b(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).g);
        paramCheckBox.setChecked(false);
        this.jdField_a_of_type_Agsb.jdField_b_of_type_Long = l;
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
      localObject1 = agmm.a(paramView.mMimeType);
      if (!bool1) {
        break label774;
      }
      Object localObject2;
      if (this.jdField_a_of_type_Bbjp != null)
      {
        localObject2 = this.jdField_a_of_type_Bbjp;
        Context localContext = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
        if (this.jdField_a_of_type_Agrz.jdField_c_of_type_Int != 2) {
          break label768;
        }
        bool2 = true;
        label312:
        ((bbjp)localObject2).a(localContext, paramCheckBox, bool2, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap, true);
      }
      if ((this.jdField_a_of_type_Agsb.h) && (localObject1 != null) && ("video".equals(localObject1[0])))
      {
        localObject2 = this.jdField_a_of_type_Agsb;
        ((agsb)localObject2).d += 1;
        if (this.jdField_a_of_type_Agsb.d == 1) {
          this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramView;
        }
      }
      if ((!TextUtils.isEmpty(paramView.mMimeType)) && ("image/gif".equals(paramView.mMimeType)))
      {
        localObject2 = this.jdField_a_of_type_Agsb;
        ((agsb)localObject2).e += 1;
      }
      localArrayList.add(paramCheckBox);
      this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.add(paramView.position);
      if (this.jdField_a_of_type_Agrz.d) {
        this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.put(paramCheckBox, paramView);
      }
      if ((localPresendPicMgr != null) && (localObject1 != null) && (localObject1[0] != null) && (!"video".equals(localObject1[0]))) {
        localPresendPicMgr.a(paramCheckBox, 1052, ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent().getIntExtra("entrance", 0));
      }
      agqd.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_totalSelNum");
      paramView = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
      if (!paramView.hasExtra("param_initTime")) {
        paramView.putExtra("param_initTime", System.currentTimeMillis());
      }
      paramView = (LinkedHashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
      if (paramView != null) {
        break label1011;
      }
      paramView = new LinkedHashMap();
      bbbx.jdField_b_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, paramView);
    }
    label710:
    label1011:
    for (;;)
    {
      paramView.put(paramCheckBox, Integer.valueOf(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()));
      paramView = bbbx.jdField_c_of_type_JavaUtilHashMap;
      if (!paramView.containsKey(paramCheckBox)) {
        paramView.put(paramCheckBox, new android.util.Pair(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString));
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
        if ((this.jdField_a_of_type_Agsb.h) && (localObject1 != null) && ("video".equals(localObject1[0])))
        {
          localObject1 = this.jdField_a_of_type_Agsb;
          ((agsb)localObject1).d -= 1;
          if (this.jdField_a_of_type_Agsb.d == 1) {
            this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramView;
          }
        }
        if ((!TextUtils.isEmpty(paramView.mMimeType)) && ("image/gif".equals(paramView.mMimeType)))
        {
          localObject1 = this.jdField_a_of_type_Agsb;
          ((agsb)localObject1).e -= 1;
        }
        localArrayList.remove(paramCheckBox);
        this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilArrayList.remove(paramView.position);
        if (this.jdField_a_of_type_Agrz.d) {
          this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.remove(paramCheckBox);
        }
        if (localPresendPicMgr != null) {
          localPresendPicMgr.b(paramCheckBox, 1013);
        }
        agqd.a(((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent(), "param_cancelSelNum");
        paramView = (HashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString);
        if (paramView != null) {
          paramView.remove(paramCheckBox);
        }
        paramView = bbbx.jdField_c_of_type_JavaUtilHashMap;
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
      if (this.jdField_a_of_type_Bbjp != null)
      {
        if (!this.c) {
          this.jdField_a_of_type_Bbjp.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList, paramBoolean, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap);
        }
      }
      else
      {
        this.jdField_a_of_type_Agrz.jdField_c_of_type_Int = 2;
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setVisibility(0);
        j();
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Agsb.o) {
        ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).b.setVisibility(8);
      }
      return;
      this.c = false;
      break;
      this.jdField_a_of_type_Agrz.jdField_c_of_type_Int = 0;
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
    bbjp localbbjp;
    Context localContext;
    if ((paramBoolean) && (bool) && (this.jdField_a_of_type_Bbjp != null))
    {
      localbbjp = this.jdField_a_of_type_Bbjp;
      localContext = (Context)this.jdField_a_of_type_MqqUtilWeakReference.get();
      paramLocalMediaInfo = paramLocalMediaInfo.path;
      if (this.jdField_a_of_type_Agrz.jdField_c_of_type_Int != 2) {
        break label85;
      }
    }
    label85:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localbbjp.a(localContext, paramLocalMediaInfo, paramBoolean, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaUtilHashMap, true);
      return bool;
    }
  }
  
  protected void b(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      int i = PhotoUtils.c(this.jdField_a_of_type_Agsb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      axqy.b(null, "CliOper", "", this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString, "0X800A915", "0X800A915", i, 0, "", "", "", "");
    }
    super.b(paramIntent);
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    axqy.b(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 2, 0, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() + "", "", "", "");
  }
  
  public void b(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrs.a(paramInt).selectStatus != 1) {
      if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_Agrz.jdField_a_of_type_Int) {
        break label82;
      }
    }
    label82:
    for (int i = 2;; i = 1)
    {
      axqy.b(null, "dc00898", "", "", "0X800AB6D", "0X800AB6D", i, 0, "", "", "", "");
      super.b(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
  }
  
  protected void d()
  {
    super.d();
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap.size())) {
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
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList.size() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  protected void h()
  {
    Intent localIntent = ((NewPhotoListActivity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getIntent();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaUtilHashMap.size() > 0))
    {
      if (this.jdField_a_of_type_Agrz.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")) {
        axrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumRecent", true, 0L, 0L, null, "");
      }
      for (;;)
      {
        a(localIntent, true, this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilArrayList);
        return;
        if ((this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString.equalsIgnoreCase("Camera")) || (this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString.equalsIgnoreCase("camera")) || (this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString.contains("Camera")) || (this.jdField_a_of_type_Agrz.jdField_b_of_type_JavaLangString.contains("camera"))) {
          axrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumRecent", false, 0L, 0L, null, "");
        } else {
          axrn.a((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(null, "sendAlbumOther", true, 0L, 0L, null, "");
        }
      }
    }
    super.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtt
 * JD-Core Version:    0.7.0.1
 */