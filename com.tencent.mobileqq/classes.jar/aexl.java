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

public class aexl<T>
  extends RecyclerView.Adapter<aexr>
{
  private int jdField_a_of_type_Int;
  protected aexk a;
  protected aexp a;
  private aexq jdField_a_of_type_Aexq;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  protected View a;
  protected List<T> a;
  protected boolean a;
  protected int b;
  protected Context b;
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_b_of_type_AndroidViewView;
  protected int c = -1;
  
  public aexl(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aexk = new aexk();
  }
  
  private aexl<T> a(aexq paramaexq)
  {
    if (paramaexq != null) {
      this.jdField_a_of_type_Aexq = paramaexq;
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
  
  public aexl a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public aexl a(aexj<T> paramaexj)
  {
    this.jdField_a_of_type_Aexk.a(paramaexj);
    return this;
  }
  
  public aexr a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return aexr.a(paramContext, paramViewGroup, paramInt);
  }
  
  public aexr a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2147483646)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        return aexr.a(paramViewGroup.getContext(), this.jdField_a_of_type_AndroidViewView);
      }
      return aexr.a(paramViewGroup.getContext(), paramViewGroup, this.jdField_b_of_type_Int);
    }
    if ((paramInt == 2147483645) && (a()))
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        return aexr.a(paramViewGroup.getContext(), this.jdField_b_of_type_AndroidViewView);
      }
      return aexr.a(paramViewGroup.getContext(), paramViewGroup, this.jdField_a_of_type_Int);
    }
    if ((paramInt >= 1000000) && (this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null)) {
      return aexr.a(paramViewGroup.getContext(), (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    }
    if ((paramInt >= 2000000) && (this.jdField_b_of_type_AndroidUtilSparseArray != null) && (this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt) != null)) {
      return aexr.a(paramViewGroup.getContext(), (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt));
    }
    int i = this.jdField_a_of_type_Aexk.a(paramInt).a();
    aexr localaexr = a(this.jdField_b_of_type_AndroidContentContext, paramViewGroup, i);
    a(localaexr, localaexr.a());
    a(paramViewGroup, localaexr, paramInt);
    return localaexr;
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
  
  public void a(aexp paramaexp)
  {
    this.jdField_a_of_type_Aexp = paramaexp;
  }
  
  public void a(aexq paramaexq)
  {
    if (a()) {
      return;
    }
    a(paramaexq);
    this.jdField_a_of_type_Boolean = true;
    notifyDataSetChanged();
  }
  
  public void a(aexr paramaexr)
  {
    super.onViewAttachedToWindow(paramaexr);
    if ((a(paramaexr.getLayoutPosition())) || (b(paramaexr.getLayoutPosition())) || (c(paramaexr.getLayoutPosition())) || (b()))
    {
      paramaexr = paramaexr.itemView.getLayoutParams();
      if ((paramaexr != null) && ((paramaexr instanceof StaggeredGridLayoutManager.LayoutParams))) {
        ((StaggeredGridLayoutManager.LayoutParams)paramaexr).setFullSpan(true);
      }
    }
  }
  
  public void a(aexr paramaexr, int paramInt)
  {
    if ((a(paramInt)) || (b(paramInt)) || (b())) {}
    do
    {
      return;
      if (!c(paramInt)) {
        break;
      }
    } while (this.jdField_a_of_type_Aexq == null);
    this.jdField_a_of_type_Aexq.a();
    return;
    a(paramaexr, a(paramInt));
  }
  
  public void a(aexr paramaexr, View paramView) {}
  
  public void a(aexr paramaexr, T paramT)
  {
    this.jdField_a_of_type_Aexk.a(paramaexr, paramT, paramaexr.getAdapterPosition());
  }
  
  protected void a(ViewGroup paramViewGroup, aexr paramaexr, int paramInt)
  {
    if (!d(paramInt)) {
      return;
    }
    paramaexr.a().setOnClickListener(new aexn(this, paramaexr));
    paramaexr.a().setOnLongClickListener(new aexo(this, paramaexr));
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
    return this.jdField_a_of_type_Aexk.a() > 0;
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
      return this.jdField_a_of_type_Aexk.a(a(paramInt), paramInt);
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
      paramRecyclerView.setSpanSizeLookup(new aexm(this, paramRecyclerView));
      paramRecyclerView.setSpanCount(paramRecyclerView.getSpanCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexl
 * JD-Core Version:    0.7.0.1
 */