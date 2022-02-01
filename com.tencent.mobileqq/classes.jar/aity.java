import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class aity
  extends RecyclerView.Adapter
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private aobu jdField_a_of_type_Aobu;
  private aobv jdField_a_of_type_Aobv = new aitz(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<aiuo> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  
  public aity(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_Aobu = new aobu(paramFragmentActivity, paramQQAppInterface);
    this.jdField_a_of_type_Aobu.a(this.jdField_a_of_type_Aobv);
    this.jdField_a_of_type_Boolean = bcnj.b();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private String a(String paramString)
  {
    anmw localanmw = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localanmw == null) {}
    while (!localanmw.b(paramString)) {
      return paramString;
    }
    return bglf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  private void a(String paramString)
  {
    paramString = new ProfileActivity.AllInOne(paramString, 113);
    paramString.h = 126;
    ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
  }
  
  private void a(boolean paramBoolean, RecyclerView.ViewHolder paramViewHolder, aiuo paramaiuo)
  {
    int i;
    if (paramBoolean)
    {
      paramaiuo = (aiub)paramViewHolder;
      paramViewHolder = paramaiuo.jdField_a_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 2130840063;
        paramViewHolder.setImageResource(i);
        paramaiuo.jdField_a_of_type_AndroidWidgetTextView.setText(null);
        paramaiuo.jdField_a_of_type_JavaLangString = "";
        paramaiuo.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label94;
        }
        paramViewHolder = "face2face/jianjie_loading.json";
        label63:
        paramaiuo.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        paramaiuo.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
        paramaiuo.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
      }
    }
    label94:
    aiua localaiua;
    do
    {
      return;
      i = 2130840064;
      break;
      paramViewHolder = "face2face/normal_loading.json";
      break label63;
      localaiua = (aiua)paramViewHolder;
    } while ((paramaiuo == null) || (TextUtils.isEmpty(paramaiuo.jdField_a_of_type_JavaLangString)));
    localaiua.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramaiuo.jdField_a_of_type_JavaLangString));
    localaiua.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(mue.a);
    localaiua.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localaiua);
    if (TextUtils.isEmpty(paramaiuo.b))
    {
      paramViewHolder = a(paramaiuo.jdField_a_of_type_JavaLangString);
      localaiua.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramViewHolder));
      localaiua.jdField_a_of_type_JavaLangString = paramaiuo.jdField_a_of_type_JavaLangString;
      if (!paramaiuo.a()) {
        break label319;
      }
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramaiuo.jdField_a_of_type_JavaLangString))
      {
        localaiua.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        localaiua.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label313;
        }
        paramViewHolder = "face2face/jianjie_avatar.json";
        label250:
        localaiua.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        localaiua.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
        localaiua.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(localaiua);
      }
    }
    for (;;)
    {
      ViewCompat.setImportantForAccessibility(localaiua.jdField_a_of_type_AndroidWidgetTextView, 1);
      ViewCompat.setImportantForAccessibility(localaiua.jdField_a_of_type_AndroidWidgetImageView, 1);
      ViewCompat.setImportantForAccessibility(localaiua.itemView, 1);
      return;
      paramViewHolder = paramaiuo.b;
      break;
      label313:
      paramViewHolder = "face2face/normal_avatar.json";
      break label250;
      label319:
      if ((localaiua.jdField_a_of_type_AndroidWidgetImageView.getAlpha() < 1.0D) || (localaiua.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() != 4))
      {
        localaiua.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(4);
        localaiua.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
    }
  }
  
  protected Bitmap a(String paramString)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Aobu != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_Aobu.a(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        this.jdField_a_of_type_Aobu.a(paramString, 1, false, (byte)1);
        localObject = localBitmap;
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = bgmo.a();
    }
    return paramString;
  }
  
  public List<aiuo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = null;
    a();
    if (this.jdField_a_of_type_Aobu != null)
    {
      this.jdField_a_of_type_Aobu.a(null);
      this.jdField_a_of_type_Aobv = null;
      this.jdField_a_of_type_Aobu.d();
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return 1;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof aiub)) {
      a(true, paramViewHolder, null);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      a(false, paramViewHolder, (aiuo)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561192, paramViewGroup, false);
    if (paramInt == 1) {
      return new aiub(this, paramViewGroup);
    }
    return new aiua(this, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aity
 * JD-Core Version:    0.7.0.1
 */