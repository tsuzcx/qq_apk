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

public class afhn
  extends RecyclerView.Adapter
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private baxy jdField_a_of_type_Baxy;
  private baxz jdField_a_of_type_Baxz = new afho(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<afid> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  
  public afhn(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_Baxy = new baxy(paramFragmentActivity, paramQQAppInterface);
    this.jdField_a_of_type_Baxy.a(this.jdField_a_of_type_Baxz);
    this.jdField_a_of_type_Boolean = axmv.b();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private String a(String paramString)
  {
    ajxl localajxl = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localajxl == null) {}
    while (!localajxl.b(paramString)) {
      return paramString;
    }
    return bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  private void a(String paramString)
  {
    paramString = new ProfileActivity.AllInOne(paramString, 113);
    paramString.h = 126;
    ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
  }
  
  private void a(boolean paramBoolean, RecyclerView.ViewHolder paramViewHolder, afid paramafid)
  {
    int i;
    if (paramBoolean)
    {
      paramafid = (afhq)paramViewHolder;
      paramViewHolder = paramafid.jdField_a_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 2130839559;
        paramViewHolder.setImageResource(i);
        paramafid.jdField_a_of_type_AndroidWidgetTextView.setText(null);
        paramafid.jdField_a_of_type_JavaLangString = "";
        paramafid.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label94;
        }
        paramViewHolder = "face2face/jianjie_loading.json";
        label63:
        paramafid.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        paramafid.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
        paramafid.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
      }
    }
    label94:
    afhp localafhp;
    do
    {
      return;
      i = 2130839560;
      break;
      paramViewHolder = "face2face/normal_loading.json";
      break label63;
      localafhp = (afhp)paramViewHolder;
    } while ((paramafid == null) || (TextUtils.isEmpty(paramafid.jdField_a_of_type_JavaLangString)));
    localafhp.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramafid.jdField_a_of_type_JavaLangString));
    localafhp.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(muc.a);
    localafhp.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localafhp);
    if (TextUtils.isEmpty(paramafid.b))
    {
      paramViewHolder = a(paramafid.jdField_a_of_type_JavaLangString);
      localafhp.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramViewHolder));
      localafhp.jdField_a_of_type_JavaLangString = paramafid.jdField_a_of_type_JavaLangString;
      if (!paramafid.a()) {
        break label319;
      }
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramafid.jdField_a_of_type_JavaLangString))
      {
        localafhp.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        localafhp.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label313;
        }
        paramViewHolder = "face2face/jianjie_avatar.json";
        label250:
        localafhp.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        localafhp.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
        localafhp.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(localafhp);
      }
    }
    for (;;)
    {
      ViewCompat.setImportantForAccessibility(localafhp.jdField_a_of_type_AndroidWidgetTextView, 1);
      ViewCompat.setImportantForAccessibility(localafhp.jdField_a_of_type_AndroidWidgetImageView, 1);
      ViewCompat.setImportantForAccessibility(localafhp.itemView, 1);
      return;
      paramViewHolder = paramafid.b;
      break;
      label313:
      paramViewHolder = "face2face/normal_avatar.json";
      break label250;
      label319:
      if ((localafhp.jdField_a_of_type_AndroidWidgetImageView.getAlpha() < 1.0D) || (localafhp.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() != 4))
      {
        localafhp.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(4);
        localafhp.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
    }
  }
  
  protected Bitmap a(String paramString)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Baxy != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_Baxy.a(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        this.jdField_a_of_type_Baxy.a(paramString, 1, false, (byte)1);
        localObject = localBitmap;
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = bbef.a();
    }
    return paramString;
  }
  
  public List<afid> a()
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
    if (this.jdField_a_of_type_Baxy != null)
    {
      this.jdField_a_of_type_Baxy.a(null);
      this.jdField_a_of_type_Baxz = null;
      this.jdField_a_of_type_Baxy.d();
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
    if ((paramViewHolder instanceof afhq))
    {
      a(true, paramViewHolder, null);
      return;
    }
    a(false, paramViewHolder, (afid)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131560781, paramViewGroup, false);
    if (paramInt == 1) {
      return new afhq(this, paramViewGroup);
    }
    return new afhp(this, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afhn
 * JD-Core Version:    0.7.0.1
 */