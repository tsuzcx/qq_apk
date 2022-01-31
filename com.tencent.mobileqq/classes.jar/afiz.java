import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class afiz<T>
  extends RecyclerView.Adapter<afjf>
{
  private int jdField_a_of_type_Int;
  protected afiy a;
  protected afjd a;
  private afje jdField_a_of_type_Afje;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  protected View a;
  protected List<T> a;
  protected boolean a;
  protected int b;
  protected Context b;
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_b_of_type_AndroidViewView;
  protected int c = -1;
  
  public afiz(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Afiy = new afiy();
  }
  
  private afiz<T> a(afje paramafje)
  {
    if (paramafje != null) {
      this.jdField_a_of_type_Afje = paramafje;
    }
    return this;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public afiz a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public afiz a(afix<T> paramafix)
  {
    this.jdField_a_of_type_Afiy.a(paramafix);
    return this;
  }
  
  public afjf a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return afjf.a(paramContext, paramViewGroup, paramInt);
  }
  
  public afjf a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2147483646)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        return afjf.a(paramViewGroup.getContext(), this.jdField_a_of_type_AndroidViewView);
      }
      return afjf.a(paramViewGroup.getContext(), paramViewGroup, this.jdField_b_of_type_Int);
    }
    if ((paramInt == 2147483645) && (a()))
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        return afjf.a(paramViewGroup.getContext(), this.jdField_b_of_type_AndroidViewView);
      }
      return afjf.a(paramViewGroup.getContext(), paramViewGroup, this.jdField_a_of_type_Int);
    }
    if ((paramInt >= 1000000) && (this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null)) {
      return afjf.a(paramViewGroup.getContext(), (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    }
    if ((paramInt >= 2000000) && (this.jdField_b_of_type_AndroidUtilSparseArray != null) && (this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt) != null)) {
      return afjf.a(paramViewGroup.getContext(), (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt));
    }
    int i = this.jdField_a_of_type_Afiy.a(paramInt).a();
    afjf localafjf = a(this.jdField_b_of_type_AndroidContentContext, paramViewGroup, i);
    a(localafjf, localafjf.a());
    a(paramViewGroup, localafjf, paramInt);
    return localafjf;
  }
  
  protected T a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    do
    {
      return null;
      paramInt -= b();
    } while (paramInt >= this.jdField_a_of_type_JavaUtilList.size());
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(afjd paramafjd)
  {
    this.jdField_a_of_type_Afjd = paramafjd;
  }
  
  public void a(afje paramafje)
  {
    if (a()) {
      return;
    }
    a(paramafje);
    this.jdField_a_of_type_Boolean = true;
    notifyDataSetChanged();
  }
  
  public void a(afjf paramafjf)
  {
    super.onViewAttachedToWindow(paramafjf);
    if ((a(paramafjf.getLayoutPosition())) || (b(paramafjf.getLayoutPosition())) || (c(paramafjf.getLayoutPosition())) || (b()))
    {
      paramafjf = paramafjf.itemView.getLayoutParams();
      if ((paramafjf != null) && ((paramafjf instanceof StaggeredGridLayoutManager.LayoutParams))) {
        ((StaggeredGridLayoutManager.LayoutParams)paramafjf).setFullSpan(true);
      }
    }
  }
  
  public void a(afjf paramafjf, int paramInt)
  {
    if ((a(paramInt)) || (b(paramInt)) || (b())) {}
    do
    {
      return;
      if (!c(paramInt)) {
        break;
      }
    } while (this.jdField_a_of_type_Afje == null);
    this.jdField_a_of_type_Afje.a();
    return;
    a(paramafjf, a(paramInt));
  }
  
  public void a(afjf paramafjf, View paramView) {}
  
  public void a(afjf paramafjf, T paramT)
  {
    this.jdField_a_of_type_Afiy.a(paramafjf, paramT, paramafjf.getAdapterPosition());
  }
  
  protected void a(ViewGroup paramViewGroup, afjf paramafjf, int paramInt)
  {
    if (!d(paramInt)) {
      return;
    }
    paramafjf.a().setOnClickListener(new afjb(this, paramafjf));
    paramafjf.a().setOnLongClickListener(new afjc(this, paramafjf));
  }
  
  public void a(List<T> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (b()) {
        notifyItemRemoved(this.c);
      }
      int i = b();
      int j = a();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyItemRangeInserted(i + j, paramList.size());
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && ((this.jdField_b_of_type_AndroidViewView != null) || (this.jdField_a_of_type_Int != 0));
  }
  
  protected boolean a(int paramInt)
  {
    return paramInt < b();
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return this.jdField_a_of_type_AndroidUtilSparseArray.size();
    }
    return 0;
  }
  
  public void b()
  {
    if (a())
    {
      a(null);
      this.jdField_a_of_type_Boolean = false;
      notifyDataSetChanged();
    }
  }
  
  protected boolean b()
  {
    return ((this.jdField_a_of_type_AndroidViewView != null) || (this.jdField_b_of_type_Int != 0)) && (a() == 0);
  }
  
  protected boolean b(int paramInt)
  {
    return (paramInt >= a() + b() + e()) && (paramInt < a() + b() + e() + c());
  }
  
  public int c()
  {
    if (this.jdField_b_of_type_AndroidUtilSparseArray != null) {
      return this.jdField_b_of_type_AndroidUtilSparseArray.size();
    }
    return 0;
  }
  
  protected boolean c()
  {
    return this.jdField_a_of_type_Afiy.a() > 0;
  }
  
  protected boolean c(int paramInt)
  {
    return (a()) && (paramInt == a() + b() + e() + c());
  }
  
  protected int d()
  {
    if (a()) {
      return 1;
    }
    return 0;
  }
  
  protected boolean d(int paramInt)
  {
    return true;
  }
  
  protected int e()
  {
    if (b()) {
      return 1;
    }
    return 0;
  }
  
  public int getItemCount()
  {
    return b() + c() + a() + e() + d();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt)) {
      return this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(paramInt);
    }
    if ((b()) && ((this.c == -1) || (paramInt == this.c)))
    {
      this.c = paramInt;
      return 2147483646;
    }
    if (b(paramInt)) {
      return this.jdField_b_of_type_AndroidUtilSparseArray.keyAt(paramInt - b() - a() - e());
    }
    if (c(paramInt)) {
      return 2147483645;
    }
    if (c()) {
      return this.jdField_a_of_type_Afiy.a(a(paramInt), paramInt);
    }
    return super.getItemViewType(paramInt);
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if ((paramRecyclerView instanceof GridLayoutManager))
    {
      paramRecyclerView = (GridLayoutManager)paramRecyclerView;
      paramRecyclerView.setSpanSizeLookup(new afja(this, paramRecyclerView));
      paramRecyclerView.setSpanCount(paramRecyclerView.getSpanCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afiz
 * JD-Core Version:    0.7.0.1
 */