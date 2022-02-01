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
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference
  extends Preference
{
  protected TextView BfZ;
  private int NIs;
  public String OFU;
  public boolean OYB;
  private boolean OYC;
  private boolean OYD;
  private boolean OYE;
  private int OYF;
  public int OYG;
  protected ImageView OYH;
  public Drawable OYI;
  private List<View> OYJ;
  public int OYK;
  int OYL;
  private View contentView;
  public float gPN;
  protected TextView titleTv;
  
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
    AppMethodBeat.i(142578);
    this.OYB = true;
    this.OYC = false;
    this.OFU = null;
    this.OYD = false;
    this.OYE = false;
    this.NIs = 17;
    this.OYF = 17;
    this.OYG = 0;
    this.OYH = null;
    this.OYI = null;
    this.OYJ = new LinkedList();
    setLayoutResource(2131495538);
    AppMethodBeat.o(142578);
  }
  
  public final void BC(boolean paramBoolean)
  {
    AppMethodBeat.i(142582);
    this.OYC = paramBoolean;
    if (this.OYC) {
      setWidgetLayoutResource(2131495622);
    }
    AppMethodBeat.o(142582);
  }
  
  public final void alL(int paramInt)
  {
    AppMethodBeat.i(142581);
    this.OYL = paramInt;
    if (this.BfZ != null) {
      this.BfZ.setMaxLines(this.OYL);
    }
    AppMethodBeat.o(142581);
  }
  
  public final void gLI()
  {
    this.OYE = true;
    this.OYF = 5;
  }
  
  public final void gLJ()
  {
    AppMethodBeat.i(142583);
    this.OYJ.clear();
    AppMethodBeat.o(142583);
  }
  
  public final void gLK()
  {
    this.OYD = true;
    this.NIs = 49;
  }
  
  public final void gz(View paramView)
  {
    AppMethodBeat.i(142584);
    this.OYJ.add(paramView);
    AppMethodBeat.o(142584);
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(142580);
    super.onBindView(paramView);
    this.contentView = paramView.findViewById(2131307161);
    if (this.OZp != null) {
      this.contentView.setOnClickListener(new KeyValuePreference.1(this));
    }
    if (this.OZq != null) {
      paramView.setOnLongClickListener(new KeyValuePreference.2(this));
    }
    this.BfZ = ((TextView)paramView.findViewById(16908304));
    if (this.BfZ != null)
    {
      this.BfZ.setSingleLine(this.OYB);
      if (this.OYE) {
        this.BfZ.setGravity(this.OYF);
      }
    }
    if (this.OYC) {
      setWidgetLayoutResource(2131495622);
    }
    this.titleTv = ((TextView)paramView.findViewById(16908310));
    if (!Util.isNullOrNil(this.OFU)) {
      this.titleTv.setText(this.OFU);
    }
    Object localObject;
    int i;
    if (this.titleTv != null)
    {
      localObject = this.titleTv.getLayoutParams();
      if (this.OYK == 0)
      {
        i = a.aG(this.mContext, 2131165381);
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.titleTv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      this.OYH = ((ImageView)paramView.findViewById(2131302573));
      if (this.OYI == null) {
        break label368;
      }
      this.OYH.setVisibility(this.OYG);
      this.OYH.setImageDrawable(this.OYI);
    }
    for (;;)
    {
      if (this.OYD)
      {
        localObject = (LinearLayout)paramView.findViewById(2131299174);
        if (localObject != null) {
          ((LinearLayout)localObject).setGravity(this.NIs);
        }
      }
      if (this.OYJ.size() <= 0) {
        break label380;
      }
      paramView = (LinearLayout)paramView.findViewById(2131308771);
      paramView.removeAllViews();
      localObject = this.OYJ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        ViewGroup localViewGroup = (ViewGroup)localView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localView);
        }
        paramView.addView(localView);
      }
      i = this.OYK;
      break;
      label368:
      this.OYH.setVisibility(8);
    }
    label380:
    if (this.gPN != 0.0F)
    {
      this.titleTv.setTextSize(this.gPN);
      this.BfZ.setTextSize(this.gPN);
    }
    if (this.OYL > 0) {
      this.BfZ.setMaxLines(this.OYL);
    }
    AppMethodBeat.o(142580);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142579);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495567, localViewGroup);
    AppMethodBeat.o(142579);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.KeyValuePreference
 * JD-Core Version:    0.7.0.1
 */