import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ajdq<T>
  extends RecyclerView.Adapter<ajdw>
{
  private int jdField_a_of_type_Int;
  protected ajdp a;
  protected ajdu a;
  private ajdv jdField_a_of_type_Ajdv;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  protected View a;
  protected List<T> a;
  protected boolean a;
  protected int b;
  protected Context b;
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_b_of_type_AndroidViewView;
  protected int c = -1;
  
  public ajdq(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ajdp = new ajdp();
  }
  
  private ajdq<T> a(ajdv paramajdv)
  {
    if (paramajdv != null) {
      this.jdField_a_of_type_Ajdv = paramajdv;
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
  
  public ajdq a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ajdq a(ajdo<T> paramajdo)
  {
    this.jdField_a_of_type_Ajdp.a(paramajdo);
    return this;
  }
  
  public ajdw a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2147483646)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        return ajdw.a(paramViewGroup.getContext(), this.jdField_a_of_type_AndroidViewView);
      }
      return ajdw.a(paramViewGroup.getContext(), paramViewGroup, this.jdField_b_of_type_Int);
    }
    if ((paramInt == 2147483645) && (a()))
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        return ajdw.a(paramViewGroup.getContext(), this.jdField_b_of_type_AndroidViewView);
      }
      return ajdw.a(paramViewGroup.getContext(), paramViewGroup, this.jdField_a_of_type_Int);
    }
    if ((paramInt >= 1000000) && (this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null)) {
      return ajdw.a(paramViewGroup.getContext(), (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    }
    if ((paramInt >= 2000000) && (this.jdField_b_of_type_AndroidUtilSparseArray != null) && (this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt) != null)) {
      return ajdw.a(paramViewGroup.getContext(), (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt));
    }
    int i = this.jdField_a_of_type_Ajdp.a(paramInt).a();
    ajdw localajdw = b(this.jdField_b_of_type_AndroidContentContext, paramViewGroup, i);
    a(localajdw, localajdw.a());
    a(paramViewGroup, localajdw, paramInt);
    return localajdw;
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
  
  public void a(ajdu paramajdu)
  {
    this.jdField_a_of_type_Ajdu = paramajdu;
  }
  
  public void a(ajdv paramajdv)
  {
    if (a()) {
      return;
    }
    a(paramajdv);
    this.jdField_a_of_type_Boolean = true;
    notifyDataSetChanged();
  }
  
  public void a(ajdw paramajdw)
  {
    super.onViewAttachedToWindow(paramajdw);
    if ((a(paramajdw.getLayoutPosition())) || (b(paramajdw.getLayoutPosition())) || (c(paramajdw.getLayoutPosition())) || (b()))
    {
      paramajdw = paramajdw.itemView.getLayoutParams();
      if ((paramajdw != null) && ((paramajdw instanceof StaggeredGridLayoutManager.LayoutParams))) {
        ((StaggeredGridLayoutManager.LayoutParams)paramajdw).setFullSpan(true);
      }
    }
  }
  
  public void a(ajdw paramajdw, int paramInt)
  {
    if ((a(paramInt)) || (b(paramInt)) || (b())) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramajdw, paramInt, getItemId(paramInt));
      return;
      if (c(paramInt))
      {
        if (this.jdField_a_of_type_Ajdv != null) {
          this.jdField_a_of_type_Ajdv.a();
        }
      }
      else {
        a(paramajdw, a(paramInt));
      }
    }
  }
  
  public void a(ajdw paramajdw, View paramView) {}
  
  public void a(ajdw paramajdw, T paramT)
  {
    this.jdField_a_of_type_Ajdp.a(paramajdw, paramT, paramajdw.getAdapterPosition());
  }
  
  protected void a(ViewGroup paramViewGroup, ajdw paramajdw, int paramInt)
  {
    if (!d(paramInt)) {
      return;
    }
    paramajdw.a().setOnClickListener(new ajds(this, paramajdw));
    paramajdw.a().setOnLongClickListener(new ajdt(this, paramajdw));
  }
  
  public void a(List<T> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (b())
      {
        notifyItemRemoved(this.c);
        notifyDataSetChanged();
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
  
  public ajdw b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return ajdw.a(paramContext, paramViewGroup, paramInt);
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
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
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
    return this.jdField_a_of_type_Ajdp.a() > 0;
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
      return this.jdField_a_of_type_Ajdp.a(a(paramInt), paramInt);
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
      paramRecyclerView.setSpanSizeLookup(new ajdr(this, paramRecyclerView));
      paramRecyclerView.setSpanCount(paramRecyclerView.getSpanCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdq
 * JD-Core Version:    0.7.0.1
 */