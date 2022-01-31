package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference
  extends Preference
{
  private View contentView;
  public float nEC;
  protected TextView pAD;
  protected TextView titleTv;
  public String zaD;
  private List<View> zrA;
  public int zrB;
  int zrC;
  public boolean zrr;
  private boolean zrs;
  private boolean zrt;
  private boolean zru;
  private int zrv;
  private int zrw;
  public int zrx;
  protected ImageView zry;
  public Drawable zrz;
  
  public KeyValuePreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public KeyValuePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public KeyValuePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107201);
    this.zrr = true;
    this.zrs = false;
    this.zaD = null;
    this.zrt = false;
    this.zru = false;
    this.zrv = 17;
    this.zrw = 17;
    this.zrx = 0;
    this.zry = null;
    this.zrz = null;
    this.zrA = new LinkedList();
    setLayoutResource(2130970179);
    AppMethodBeat.o(107201);
  }
  
  public final void OT(int paramInt)
  {
    AppMethodBeat.i(107204);
    this.zrC = paramInt;
    if (this.pAD != null) {
      this.pAD.setMaxLines(this.zrC);
    }
    AppMethodBeat.o(107204);
  }
  
  public final void dEM()
  {
    this.zru = true;
    this.zrw = 5;
  }
  
  public final void dEN()
  {
    AppMethodBeat.i(107206);
    this.zrA.clear();
    AppMethodBeat.o(107206);
  }
  
  public final void dEO()
  {
    this.zrt = true;
    this.zrv = 49;
  }
  
  public final void eO(View paramView)
  {
    AppMethodBeat.i(107207);
    this.zrA.add(paramView);
    AppMethodBeat.o(107207);
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(107203);
    super.onBindView(paramView);
    this.contentView = paramView.findViewById(2131826191);
    if (this.zsc != null) {
      this.contentView.setOnClickListener(new KeyValuePreference.1(this));
    }
    if (this.zsd != null) {
      paramView.setOnLongClickListener(new KeyValuePreference.2(this));
    }
    this.pAD = ((TextView)paramView.findViewById(16908304));
    if (this.pAD != null)
    {
      this.pAD.setSingleLine(this.zrr);
      if (this.zru) {
        this.pAD.setGravity(this.zrw);
      }
    }
    if (this.zrs) {
      setWidgetLayoutResource(2130970254);
    }
    this.titleTv = ((TextView)paramView.findViewById(16908310));
    if (!bo.isNullOrNil(this.zaD)) {
      this.titleTv.setText(this.zaD);
    }
    Object localObject;
    int i;
    if (this.titleTv != null)
    {
      localObject = this.titleTv.getLayoutParams();
      if (this.zrB == 0)
      {
        i = a.ao(this.mContext, 2131427664);
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.titleTv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      this.zry = ((ImageView)paramView.findViewById(2131822243));
      if (this.zrz == null) {
        break label368;
      }
      this.zry.setVisibility(this.zrx);
      this.zry.setImageDrawable(this.zrz);
    }
    for (;;)
    {
      if (this.zrt)
      {
        localObject = (LinearLayout)paramView.findViewById(2131821084);
        if (localObject != null) {
          ((LinearLayout)localObject).setGravity(this.zrv);
        }
      }
      if (this.zrA.size() <= 0) {
        break label380;
      }
      paramView = (LinearLayout)paramView.findViewById(2131826218);
      paramView.removeAllViews();
      localObject = this.zrA.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        ViewGroup localViewGroup = (ViewGroup)localView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localView);
        }
        paramView.addView(localView);
      }
      i = this.zrB;
      break;
      label368:
      this.zry.setVisibility(8);
    }
    label380:
    if (this.nEC != 0.0F)
    {
      this.titleTv.setTextSize(this.nEC);
      this.pAD.setTextSize(this.nEC);
    }
    if (this.zrC > 0) {
      this.pAD.setMaxLines(this.zrC);
    }
    AppMethodBeat.o(107203);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107202);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970205, localViewGroup);
    AppMethodBeat.o(107202);
    return paramViewGroup;
  }
  
  public final void qJ(boolean paramBoolean)
  {
    AppMethodBeat.i(107205);
    this.zrs = paramBoolean;
    if (this.zrs) {
      setWidgetLayoutResource(2130970254);
    }
    AppMethodBeat.o(107205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.KeyValuePreference
 * JD-Core Version:    0.7.0.1
 */