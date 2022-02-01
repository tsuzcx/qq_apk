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

public class aiir<T>
  extends RecyclerView.Adapter<aiix>
{
  private int jdField_a_of_type_Int;
  protected aiiq a;
  protected aiiv a;
  private aiiw jdField_a_of_type_Aiiw;
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  protected View a;
  protected List<T> a;
  protected boolean a;
  protected int b;
  protected Context b;
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_b_of_type_AndroidViewView;
  protected int c = -1;
  
  public aiir(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aiiq = new aiiq();
  }
  
  private aiir<T> a(aiiw paramaiiw)
  {
    if (paramaiiw != null) {
      this.jdField_a_of_type_Aiiw = paramaiiw;
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
  
  public aiir a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public aiir a(aiip<T> paramaiip)
  {
    this.jdField_a_of_type_Aiiq.a(paramaiip);
    return this;
  }
  
  public aiix a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2147483646)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        return aiix.a(paramViewGroup.getContext(), this.jdField_a_of_type_AndroidViewView);
      }
      return aiix.a(paramViewGroup.getContext(), paramViewGroup, this.jdField_b_of_type_Int);
    }
    if ((paramInt == 2147483645) && (a()))
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        return aiix.a(paramViewGroup.getContext(), this.jdField_b_of_type_AndroidViewView);
      }
      return aiix.a(paramViewGroup.getContext(), paramViewGroup, this.jdField_a_of_type_Int);
    }
    if ((paramInt >= 1000000) && (this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null)) {
      return aiix.a(paramViewGroup.getContext(), (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    }
    if ((paramInt >= 2000000) && (this.jdField_b_of_type_AndroidUtilSparseArray != null) && (this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt) != null)) {
      return aiix.a(paramViewGroup.getContext(), (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(paramInt));
    }
    int i = this.jdField_a_of_type_Aiiq.a(paramInt).a();
    aiix localaiix = b(this.jdField_b_of_type_AndroidContentContext, paramViewGroup, i);
    a(localaiix, localaiix.a());
    a(paramViewGroup, localaiix, paramInt);
    return localaiix;
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
  
  public void a(aiiv paramaiiv)
  {
    this.jdField_a_of_type_Aiiv = paramaiiv;
  }
  
  public void a(aiiw paramaiiw)
  {
    if (a()) {
      return;
    }
    a(paramaiiw);
    this.jdField_a_of_type_Boolean = true;
    notifyDataSetChanged();
  }
  
  public void a(aiix paramaiix)
  {
    super.onViewAttachedToWindow(paramaiix);
    if ((a(paramaiix.getLayoutPosition())) || (b(paramaiix.getLayoutPosition())) || (c(paramaiix.getLayoutPosition())) || (b()))
    {
      paramaiix = paramaiix.itemView.getLayoutParams();
      if ((paramaiix != null) && ((paramaiix instanceof StaggeredGridLayoutManager.LayoutParams))) {
        ((StaggeredGridLayoutManager.LayoutParams)paramaiix).setFullSpan(true);
      }
    }
  }
  
  public void a(aiix paramaiix, int paramInt)
  {
    if ((a(paramInt)) || (b(paramInt)) || (b())) {}
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramaiix, paramInt, getItemId(paramInt));
      return;
      if (c(paramInt))
      {
        if (this.jdField_a_of_type_Aiiw != null) {
          this.jdField_a_of_type_Aiiw.a();
        }
      }
      else {
        a(paramaiix, a(paramInt));
      }
    }
  }
  
  public void a(aiix paramaiix, View paramView) {}
  
  public void a(aiix paramaiix, T paramT)
  {
    this.jdField_a_of_type_Aiiq.a(paramaiix, paramT, paramaiix.getAdapterPosition());
  }
  
  protected void a(ViewGroup paramViewGroup, aiix paramaiix, int paramInt)
  {
    if (!d(paramInt)) {
      return;
    }
    paramaiix.a().setOnClickListener(new aiit(this, paramaiix));
    paramaiix.a().setOnLongClickListener(new aiiu(this, paramaiix));
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
  
  public aiix b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return aiix.a(paramContext, paramViewGroup, paramInt);
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
    return this.jdField_a_of_type_Aiiq.a() > 0;
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
      return this.jdField_a_of_type_Aiiq.a(a(paramInt), paramInt);
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
      paramRecyclerView.setSpanSizeLookup(new aiis(this, paramRecyclerView));
      paramRecyclerView.setSpanCount(paramRecyclerView.getSpanCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiir
 * JD-Core Version:    0.7.0.1
 */