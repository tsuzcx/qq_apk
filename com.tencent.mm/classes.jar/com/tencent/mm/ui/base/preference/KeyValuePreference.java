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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference
  extends Preference
{
  private int ERM;
  public String FNA;
  public boolean Gfe;
  private boolean Gff;
  private boolean Gfg;
  private boolean Gfh;
  private int Gfi;
  public int Gfj;
  protected ImageView Gfk;
  public Drawable Gfl;
  private List<View> Gfm;
  public int Gfn;
  int Gfo;
  private View contentView;
  public float oqc;
  protected TextView titleTv;
  protected TextView uCm;
  
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
    this.Gfe = true;
    this.Gff = false;
    this.FNA = null;
    this.Gfg = false;
    this.Gfh = false;
    this.ERM = 17;
    this.Gfi = 17;
    this.Gfj = 0;
    this.Gfk = null;
    this.Gfl = null;
    this.Gfm = new LinkedList();
    setLayoutResource(2131494804);
    AppMethodBeat.o(142578);
  }
  
  public final void XY(int paramInt)
  {
    AppMethodBeat.i(142581);
    this.Gfo = paramInt;
    if (this.uCm != null) {
      this.uCm.setMaxLines(this.Gfo);
    }
    AppMethodBeat.o(142581);
  }
  
  public final void eTC()
  {
    this.Gfh = true;
    this.Gfi = 5;
  }
  
  public final void eTD()
  {
    AppMethodBeat.i(142583);
    this.Gfm.clear();
    AppMethodBeat.o(142583);
  }
  
  public final void eTE()
  {
    this.Gfg = true;
    this.ERM = 49;
  }
  
  public final void fG(View paramView)
  {
    AppMethodBeat.i(142584);
    this.Gfm.add(paramView);
    AppMethodBeat.o(142584);
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(142580);
    super.onBindView(paramView);
    this.contentView = paramView.findViewById(2131304242);
    if (this.GfO != null) {
      this.contentView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(142576);
          KeyValuePreference.this.GfO.dbW();
          AppMethodBeat.o(142576);
        }
      });
    }
    if (this.GfP != null) {
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(142577);
          boolean bool = KeyValuePreference.this.GfP.ddk();
          AppMethodBeat.o(142577);
          return bool;
        }
      });
    }
    this.uCm = ((TextView)paramView.findViewById(16908304));
    if (this.uCm != null)
    {
      this.uCm.setSingleLine(this.Gfe);
      if (this.Gfh) {
        this.uCm.setGravity(this.Gfi);
      }
    }
    if (this.Gff) {
      setWidgetLayoutResource(2131494884);
    }
    this.titleTv = ((TextView)paramView.findViewById(16908310));
    if (!bt.isNullOrNil(this.FNA)) {
      this.titleTv.setText(this.FNA);
    }
    Object localObject;
    int i;
    if (this.titleTv != null)
    {
      localObject = this.titleTv.getLayoutParams();
      if (this.Gfn == 0)
      {
        i = a.ao(this.mContext, 2131165370);
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.titleTv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      this.Gfk = ((ImageView)paramView.findViewById(2131300943));
      if (this.Gfl == null) {
        break label368;
      }
      this.Gfk.setVisibility(this.Gfj);
      this.Gfk.setImageDrawable(this.Gfl);
    }
    for (;;)
    {
      if (this.Gfg)
      {
        localObject = (LinearLayout)paramView.findViewById(2131298736);
        if (localObject != null) {
          ((LinearLayout)localObject).setGravity(this.ERM);
        }
      }
      if (this.Gfm.size() <= 0) {
        break label380;
      }
      paramView = (LinearLayout)paramView.findViewById(2131305550);
      paramView.removeAllViews();
      localObject = this.Gfm.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        ViewGroup localViewGroup = (ViewGroup)localView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localView);
        }
        paramView.addView(localView);
      }
      i = this.Gfn;
      break;
      label368:
      this.Gfk.setVisibility(8);
    }
    label380:
    if (this.oqc != 0.0F)
    {
      this.titleTv.setTextSize(this.oqc);
      this.uCm.setTextSize(this.oqc);
    }
    if (this.Gfo > 0) {
      this.uCm.setMaxLines(this.Gfo);
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
  
  public final void vR(boolean paramBoolean)
  {
    AppMethodBeat.i(142582);
    this.Gff = paramBoolean;
    if (this.Gff) {
      setWidgetLayoutResource(2131494884);
    }
    AppMethodBeat.o(142582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.KeyValuePreference
 * JD-Core Version:    0.7.0.1
 */