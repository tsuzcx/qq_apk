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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class afhp
  extends RecyclerView.Adapter
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private baxk jdField_a_of_type_Baxk;
  private baxl jdField_a_of_type_Baxl = new afhq(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<afif> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  
  public afhp(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_Baxk = new baxk(paramFragmentActivity, paramQQAppInterface);
    this.jdField_a_of_type_Baxk.a(this.jdField_a_of_type_Baxl);
    this.jdField_a_of_type_Boolean = axmt.b();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private String a(String paramString)
  {
    ajxn localajxn = (ajxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localajxn == null) {}
    while (!localajxn.b(paramString)) {
      return paramString;
    }
    return bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  private void a(String paramString)
  {
    paramString = new ProfileActivity.AllInOne(paramString, 113);
    paramString.h = 126;
    ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
  }
  
  private void a(boolean paramBoolean, RecyclerView.ViewHolder paramViewHolder, afif paramafif)
  {
    int i;
    if (paramBoolean)
    {
      paramafif = (afhs)paramViewHolder;
      paramViewHolder = paramafif.jdField_a_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 2130839559;
        paramViewHolder.setImageResource(i);
        paramafif.jdField_a_of_type_AndroidWidgetTextView.setText(null);
        paramafif.jdField_a_of_type_JavaLangString = "";
        paramafif.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label94;
        }
        paramViewHolder = "face2face/jianjie_loading.json";
        label63:
        paramafif.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        paramafif.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
        paramafif.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
      }
    }
    label94:
    afhr localafhr;
    do
    {
      return;
      i = 2130839560;
      break;
      paramViewHolder = "face2face/normal_loading.json";
      break label63;
      localafhr = (afhr)paramViewHolder;
    } while ((paramafif == null) || (TextUtils.isEmpty(paramafif.jdField_a_of_type_JavaLangString)));
    localafhr.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramafif.jdField_a_of_type_JavaLangString));
    localafhr.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(muf.a);
    localafhr.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localafhr);
    if (TextUtils.isEmpty(paramafif.b))
    {
      paramViewHolder = a(paramafif.jdField_a_of_type_JavaLangString);
      localafhr.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramViewHolder));
      localafhr.jdField_a_of_type_JavaLangString = paramafif.jdField_a_of_type_JavaLangString;
      if (!paramafif.a()) {
        break label319;
      }
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramafif.jdField_a_of_type_JavaLangString))
      {
        localafhr.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        localafhr.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label313;
        }
        paramViewHolder = "face2face/jianjie_avatar.json";
        label250:
        localafhr.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        localafhr.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
        localafhr.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(localafhr);
      }
    }
    for (;;)
    {
      ViewCompat.setImportantForAccessibility(localafhr.jdField_a_of_type_AndroidWidgetTextView, 1);
      ViewCompat.setImportantForAccessibility(localafhr.jdField_a_of_type_AndroidWidgetImageView, 1);
      ViewCompat.setImportantForAccessibility(localafhr.itemView, 1);
      return;
      paramViewHolder = paramafif.b;
      break;
      label313:
      paramViewHolder = "face2face/normal_avatar.json";
      break label250;
      label319:
      if ((localafhr.jdField_a_of_type_AndroidWidgetImageView.getAlpha() < 1.0D) || (localafhr.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() != 4))
      {
        localafhr.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(4);
        localafhr.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
    }
  }
  
  protected Bitmap a(String paramString)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Baxk != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_Baxk.a(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        this.jdField_a_of_type_Baxk.a(paramString, 1, false, (byte)1);
        localObject = localBitmap;
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = bbdr.a();
    }
    return paramString;
  }
  
  public List<afif> a()
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
    if (this.jdField_a_of_type_Baxk != null)
    {
      this.jdField_a_of_type_Baxk.a(null);
      this.jdField_a_of_type_Baxl = null;
      this.jdField_a_of_type_Baxk.d();
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
    if ((paramViewHolder instanceof afhs))
    {
      a(true, paramViewHolder, null);
      return;
    }
    a(false, paramViewHolder, (afif)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131560782, paramViewGroup, false);
    if (paramInt == 1) {
      return new afhs(this, paramViewGroup);
    }
    return new afhr(this, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afhp
 * JD-Core Version:    0.7.0.1
 */