package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference
  extends Preference
{
  private int GoZ;
  public boolean HET;
  private boolean HEU;
  private boolean HEV;
  private boolean HEW;
  private int HEX;
  public int HEY;
  protected ImageView HEZ;
  public Drawable HFa;
  private List<View> HFb;
  public int HFc;
  int HFd;
  public String Hnl;
  private View contentView;
  public float oTC;
  protected TextView titleTv;
  protected TextView vLf;
  
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
    this.HET = true;
    this.HEU = false;
    this.Hnl = null;
    this.HEV = false;
    this.HEW = false;
    this.GoZ = 17;
    this.HEX = 17;
    this.HEY = 0;
    this.HEZ = null;
    this.HFa = null;
    this.HFb = new LinkedList();
    setLayoutResource(2131494804);
    AppMethodBeat.o(142578);
  }
  
  public final void aaj(int paramInt)
  {
    AppMethodBeat.i(142581);
    this.HFd = paramInt;
    if (this.vLf != null) {
      this.vLf.setMaxLines(this.HFd);
    }
    AppMethodBeat.o(142581);
  }
  
  public final void fT(View paramView)
  {
    AppMethodBeat.i(142584);
    this.HFb.add(paramView);
    AppMethodBeat.o(142584);
  }
  
  public final void fjo()
  {
    this.HEW = true;
    this.HEX = 5;
  }
  
  public final void fjp()
  {
    AppMethodBeat.i(142583);
    this.HFb.clear();
    AppMethodBeat.o(142583);
  }
  
  public final void fjq()
  {
    this.HEV = true;
    this.GoZ = 49;
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(142580);
    super.onBindView(paramView);
    this.contentView = paramView.findViewById(2131304242);
    if (this.HFD != null) {
      this.contentView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(142576);
          KeyValuePreference.this.HFD.dpE();
          AppMethodBeat.o(142576);
        }
      });
    }
    if (this.HFE != null) {
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(142577);
          boolean bool = KeyValuePreference.this.HFE.dqS();
          AppMethodBeat.o(142577);
          return bool;
        }
      });
    }
    this.vLf = ((TextView)paramView.findViewById(16908304));
    if (this.vLf != null)
    {
      this.vLf.setSingleLine(this.HET);
      if (this.HEW) {
        this.vLf.setGravity(this.HEX);
      }
    }
    if (this.HEU) {
      setWidgetLayoutResource(2131494884);
    }
    this.titleTv = ((TextView)paramView.findViewById(16908310));
    if (!bs.isNullOrNil(this.Hnl)) {
      this.titleTv.setText(this.Hnl);
    }
    Object localObject;
    int i;
    if (this.titleTv != null)
    {
      localObject = this.titleTv.getLayoutParams();
      if (this.HFc == 0)
      {
        i = a.au(this.mContext, 2131165370);
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.titleTv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      this.HEZ = ((ImageView)paramView.findViewById(2131300943));
      if (this.HFa == null) {
        break label368;
      }
      this.HEZ.setVisibility(this.HEY);
      this.HEZ.setImageDrawable(this.HFa);
    }
    for (;;)
    {
      if (this.HEV)
      {
        localObject = (LinearLayout)paramView.findViewById(2131298736);
        if (localObject != null) {
          ((LinearLayout)localObject).setGravity(this.GoZ);
        }
      }
      if (this.HFb.size() <= 0) {
        break label380;
      }
      paramView = (LinearLayout)paramView.findViewById(2131305550);
      paramView.removeAllViews();
      localObject = this.HFb.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        ViewGroup localViewGroup = (ViewGroup)localView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localView);
        }
        paramView.addView(localView);
      }
      i = this.HFc;
      break;
      label368:
      this.HEZ.setVisibility(8);
    }
    label380:
    if (this.oTC != 0.0F)
    {
      this.titleTv.setTextSize(this.oTC);
      this.vLf.setTextSize(this.oTC);
    }
    if (this.HFd > 0) {
      this.vLf.setMaxLines(this.HFd);
    }
    AppMethodBeat.o(142580);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142579);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494832, localViewGroup);
    AppMethodBeat.o(142579);
    return paramViewGroup;
  }
  
  public final void wV(boolean paramBoolean)
  {
    AppMethodBeat.i(142582);
    this.HEU = paramBoolean;
    if (this.HEU) {
      setWidgetLayoutResource(2131494884);
    }
    AppMethodBeat.o(142582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.KeyValuePreference
 * JD-Core Version:    0.7.0.1
 */