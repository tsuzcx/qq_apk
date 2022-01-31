package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private int be;
  private final ArrayList<ad> dr = new ArrayList();
  private s ds;
  private TabHost.OnTabChangeListener dt;
  private ad du;
  private boolean dv;
  private Context mContext;
  
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.be = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
  }
  
  private ae a(String paramString, ae paramae)
  {
    int j = this.dr.size();
    int i = 0;
    ad localad;
    if (i < j)
    {
      localad = (ad)this.dr.get(i);
      if (localad.tag.equals(paramString))
      {
        label42:
        paramString = paramae;
        if (this.du != localad)
        {
          paramString = paramae;
          if (paramae == null) {
            paramString = this.ds.Z();
          }
          if ((this.du != null) && (this.du.am != null)) {
            paramString.b(this.du.am);
          }
          if (localad != null)
          {
            if (localad.am != null) {
              break label174;
            }
            localad.am = Fragment.a(this.mContext, localad.dx.getName(), localad.dy);
            paramString.a(this.be, localad.am, localad.tag);
          }
        }
      }
    }
    for (;;)
    {
      this.du = localad;
      return paramString;
      i += 1;
      break;
      localad = null;
      break label42;
      label174:
      paramString.c(localad.am);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    Object localObject1 = null;
    int j = this.dr.size();
    int i = 0;
    if (i < j)
    {
      ad localad = (ad)this.dr.get(i);
      localad.am = this.ds.c(localad.tag);
      Object localObject2 = localObject1;
      if (localad.am != null)
      {
        localObject2 = localObject1;
        if (!localad.am.bh)
        {
          if (!localad.tag.equals(str)) {
            break label114;
          }
          this.du = localad;
          localObject2 = localObject1;
        }
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        label114:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.ds.Z();
        }
        ((ae)localObject2).b(localad.am);
      }
    }
    this.dv = true;
    localObject1 = a(str, (ae)localObject1);
    if (localObject1 != null)
    {
      ((ae)localObject1).commit();
      this.ds.executePendingTransactions();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.dv = false;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof FragmentTabHost.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (FragmentTabHost.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.dw);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    FragmentTabHost.SavedState localSavedState = new FragmentTabHost.SavedState(super.onSaveInstanceState());
    localSavedState.dw = getCurrentTabTag();
    return localSavedState;
  }
  
  public void onTabChanged(String paramString)
  {
    if (this.dv)
    {
      ae localae = a(paramString, null);
      if (localae != null) {
        localae.commit();
      }
    }
    if (this.dt != null) {
      this.dt.onTabChanged(paramString);
    }
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.dt = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */