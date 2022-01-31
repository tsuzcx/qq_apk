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

public class ahes
  extends RecyclerView.Adapter
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bcws jdField_a_of_type_Bcws;
  private bcwt jdField_a_of_type_Bcwt = new ahet(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<ahfi> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  
  public ahes(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_Bcws = new bcws(paramFragmentActivity, paramQQAppInterface);
    this.jdField_a_of_type_Bcws.a(this.jdField_a_of_type_Bcwt);
    this.jdField_a_of_type_Boolean = azib.b();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private String a(String paramString)
  {
    aloz localaloz = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localaloz == null) {}
    while (!localaloz.b(paramString)) {
      return paramString;
    }
    return bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  private void a(String paramString)
  {
    paramString = new ProfileActivity.AllInOne(paramString, 113);
    paramString.h = 126;
    ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
  }
  
  private void a(boolean paramBoolean, RecyclerView.ViewHolder paramViewHolder, ahfi paramahfi)
  {
    int i;
    if (paramBoolean)
    {
      paramahfi = (ahev)paramViewHolder;
      paramViewHolder = paramahfi.jdField_a_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 2130839656;
        paramViewHolder.setImageResource(i);
        paramahfi.jdField_a_of_type_AndroidWidgetTextView.setText(null);
        paramahfi.jdField_a_of_type_JavaLangString = "";
        paramahfi.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label94;
        }
        paramViewHolder = "face2face/jianjie_loading.json";
        label63:
        paramahfi.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        paramahfi.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
        paramahfi.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
      }
    }
    label94:
    aheu localaheu;
    do
    {
      return;
      i = 2130839657;
      break;
      paramViewHolder = "face2face/normal_loading.json";
      break label63;
      localaheu = (aheu)paramViewHolder;
    } while ((paramahfi == null) || (TextUtils.isEmpty(paramahfi.jdField_a_of_type_JavaLangString)));
    localaheu.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramahfi.jdField_a_of_type_JavaLangString));
    localaheu.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(mww.a);
    localaheu.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localaheu);
    if (TextUtils.isEmpty(paramahfi.b))
    {
      paramViewHolder = a(paramahfi.jdField_a_of_type_JavaLangString);
      localaheu.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramViewHolder));
      localaheu.jdField_a_of_type_JavaLangString = paramahfi.jdField_a_of_type_JavaLangString;
      if (!paramahfi.a()) {
        break label319;
      }
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramahfi.jdField_a_of_type_JavaLangString))
      {
        localaheu.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        localaheu.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label313;
        }
        paramViewHolder = "face2face/jianjie_avatar.json";
        label250:
        localaheu.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        localaheu.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
        localaheu.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(localaheu);
      }
    }
    for (;;)
    {
      ViewCompat.setImportantForAccessibility(localaheu.jdField_a_of_type_AndroidWidgetTextView, 1);
      ViewCompat.setImportantForAccessibility(localaheu.jdField_a_of_type_AndroidWidgetImageView, 1);
      ViewCompat.setImportantForAccessibility(localaheu.itemView, 1);
      return;
      paramViewHolder = paramahfi.b;
      break;
      label313:
      paramViewHolder = "face2face/normal_avatar.json";
      break label250;
      label319:
      if ((localaheu.jdField_a_of_type_AndroidWidgetImageView.getAlpha() < 1.0D) || (localaheu.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() != 4))
      {
        localaheu.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(4);
        localaheu.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
    }
  }
  
  protected Bitmap a(String paramString)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Bcws != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_Bcws.a(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        this.jdField_a_of_type_Bcws.a(paramString, 1, false, (byte)1);
        localObject = localBitmap;
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = bdda.a();
    }
    return paramString;
  }
  
  public List<ahfi> a()
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
    if (this.jdField_a_of_type_Bcws != null)
    {
      this.jdField_a_of_type_Bcws.a(null);
      this.jdField_a_of_type_Bcwt = null;
      this.jdField_a_of_type_Bcws.d();
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
    if ((paramViewHolder instanceof ahev))
    {
      a(true, paramViewHolder, null);
      return;
    }
    a(false, paramViewHolder, (ahfi)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131560964, paramViewGroup, false);
    if (paramInt == 1) {
      return new ahev(this, paramViewGroup);
    }
    return new aheu(this, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahes
 * JD-Core Version:    0.7.0.1
 */