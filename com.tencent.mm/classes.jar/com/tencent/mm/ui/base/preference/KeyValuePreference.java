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
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference
  extends Preference
{
  public String JAf;
  protected TextView MXN;
  private int acre;
  public boolean adZa;
  private boolean adZb;
  private boolean adZc;
  private boolean adZd;
  private int adZe;
  public int adZf;
  protected ImageView adZg;
  public Drawable adZh;
  private List<View> adZi;
  public int adZj;
  int adZk;
  private View contentView;
  protected TextView titleTv;
  public float xBL;
  
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
    this.adZa = true;
    this.adZb = false;
    this.JAf = null;
    this.adZc = false;
    this.adZd = false;
    this.acre = 17;
    this.adZe = 17;
    this.adZf = 0;
    this.adZg = null;
    this.adZh = null;
    this.adZi = new LinkedList();
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(142578);
  }
  
  public final void LG(boolean paramBoolean)
  {
    AppMethodBeat.i(142582);
    this.adZb = paramBoolean;
    if (this.adZb) {
      aBp(a.h.mm_preference_submenu);
    }
    AppMethodBeat.o(142582);
  }
  
  public final void aBm(int paramInt)
  {
    AppMethodBeat.i(142581);
    this.adZk = paramInt;
    if (this.MXN != null) {
      this.MXN.setMaxLines(this.adZk);
    }
    AppMethodBeat.o(142581);
  }
  
  public final void jnp()
  {
    this.adZd = true;
    this.adZe = 5;
  }
  
  public final void jnq()
  {
    AppMethodBeat.i(142583);
    this.adZi.clear();
    AppMethodBeat.o(142583);
  }
  
  public final void jnr()
  {
    this.adZc = true;
    this.acre = 49;
  }
  
  public final void lh(View paramView)
  {
    AppMethodBeat.i(142584);
    this.adZi.add(paramView);
    AppMethodBeat.o(142584);
  }
  
  public void onBindView(View paramView)
  {
    AppMethodBeat.i(142580);
    super.onBindView(paramView);
    this.contentView = paramView.findViewById(a.g.root_content);
    if (this.adZO != null) {
      this.contentView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(142576);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/preference/KeyValuePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          KeyValuePreference.this.adZO.gAW();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/preference/KeyValuePreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(142576);
        }
      });
    }
    if (this.adZP != null) {
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(142577);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/preference/KeyValuePreference$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          boolean bool = KeyValuePreference.this.adZP.gCr();
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/preference/KeyValuePreference$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(142577);
          return bool;
        }
      });
    }
    this.MXN = ((TextView)paramView.findViewById(16908304));
    if (this.MXN != null)
    {
      this.MXN.setSingleLine(this.adZa);
      if (this.adZd) {
        this.MXN.setGravity(this.adZe);
      }
    }
    if (this.adZb) {
      aBp(a.h.mm_preference_submenu);
    }
    this.titleTv = ((TextView)paramView.findViewById(16908310));
    if (!Util.isNullOrNil(this.JAf)) {
      this.titleTv.setText(this.JAf);
    }
    Object localObject;
    int i;
    if (this.titleTv != null)
    {
      localObject = this.titleTv.getLayoutParams();
      if (this.adZj == 0)
      {
        i = com.tencent.mm.cd.a.br(this.mContext, a.e.FixedTitleWidth);
        ((ViewGroup.LayoutParams)localObject).width = i;
        this.titleTv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    else
    {
      this.adZg = ((ImageView)paramView.findViewById(a.g.image_iv));
      if (this.adZh == null) {
        break label374;
      }
      this.adZg.setVisibility(this.adZf);
      this.adZg.setImageDrawable(this.adZh);
    }
    for (;;)
    {
      if (this.adZc)
      {
        localObject = (LinearLayout)paramView.findViewById(a.g.container);
        if (localObject != null) {
          ((LinearLayout)localObject).setGravity(this.acre);
        }
      }
      if (this.adZi.size() <= 0) {
        break label386;
      }
      paramView = (LinearLayout)paramView.findViewById(a.g.summary_container);
      paramView.removeAllViews();
      localObject = this.adZi.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = (View)((Iterator)localObject).next();
        ViewGroup localViewGroup = (ViewGroup)localView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localView);
        }
        paramView.addView(localView);
      }
      i = this.adZj;
      break;
      label374:
      this.adZg.setVisibility(8);
    }
    label386:
    if (this.xBL != 0.0F)
    {
      this.titleTv.setTextSize(this.xBL);
      this.MXN.setTextSize(this.xBL);
    }
    if (this.adZk > 0) {
      this.MXN.setMaxLines(this.adZk);
    }
    AppMethodBeat.o(142580);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142579);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(a.h.mm_preference_content_keyvalue, localViewGroup);
    AppMethodBeat.o(142579);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.KeyValuePreference
 * JD-Core Version:    0.7.0.1
 */