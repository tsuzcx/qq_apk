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
  private int cP;
  private final ArrayList<af> fg = new ArrayList();
  private t fh;
  private TabHost.OnTabChangeListener fi;
  private af fj;
  private boolean fk;
  private Context mContext;
  
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.cP = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
  }
  
  private ag a(String paramString, ag paramag)
  {
    af localaf = c(paramString);
    paramString = paramag;
    if (this.fj != localaf)
    {
      paramString = paramag;
      if (paramag == null) {
        paramString = this.fh.ao();
      }
      if ((this.fj != null) && (this.fj.bV != null)) {
        paramString.b(this.fj.bV);
      }
      if (localaf != null)
      {
        if (localaf.bV != null) {
          break label116;
        }
        localaf.bV = Fragment.a(this.mContext, localaf.fm.getName(), localaf.fn);
        paramString.a(this.cP, localaf.bV, localaf.tag);
      }
    }
    for (;;)
    {
      this.fj = localaf;
      return paramString;
      label116:
      paramString.c(localaf.bV);
    }
  }
  
  private af c(String paramString)
  {
    int j = this.fg.size();
    int i = 0;
    while (i < j)
    {
      af localaf = (af)this.fg.get(i);
      if (localaf.tag.equals(paramString)) {
        return localaf;
      }
      i += 1;
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    Object localObject1 = null;
    int j = this.fg.size();
    int i = 0;
    if (i < j)
    {
      af localaf = (af)this.fg.get(i);
      localaf.bV = this.fh.b(localaf.tag);
      Object localObject2 = localObject1;
      if (localaf.bV != null)
      {
        localObject2 = localObject1;
        if (!localaf.bV.cS)
        {
          if (!localaf.tag.equals(str)) {
            break label114;
          }
          this.fj = localaf;
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
          localObject2 = this.fh.ao();
        }
        ((ag)localObject2).b(localaf.bV);
      }
    }
    this.fk = true;
    localObject1 = a(str, (ag)localObject1);
    if (localObject1 != null)
    {
      ((ag)localObject1).commit();
      this.fh.executePendingTransactions();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.fk = false;
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
    setCurrentTabByTag(paramParcelable.fl);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    FragmentTabHost.SavedState localSavedState = new FragmentTabHost.SavedState(super.onSaveInstanceState());
    localSavedState.fl = getCurrentTabTag();
    return localSavedState;
  }
  
  public void onTabChanged(String paramString)
  {
    if (this.fk)
    {
      ag localag = a(paramString, null);
      if (localag != null) {
        localag.commit();
      }
    }
    if (this.fi != null) {
      this.fi.onTabChanged(paramString);
    }
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.fi = paramOnTabChangeListener;
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