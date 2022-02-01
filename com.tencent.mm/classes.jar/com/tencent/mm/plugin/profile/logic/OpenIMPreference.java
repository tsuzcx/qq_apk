package com.tencent.mm.plugin.profile.logic;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.openim.api.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;

public class OpenIMPreference
  extends KeyValuePreference
{
  public boolean MUA = false;
  public g.b MUz = null;
  private String TAG = "MicroMsg.OpenIMPreference";
  
  public OpenIMPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public OpenIMPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OpenIMPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(306249);
    super.onBindView(paramView);
    if (this.MUz == null)
    {
      Log.w(this.TAG, "onBindView detail null");
      AppMethodBeat.o(306249);
      return;
    }
    if (this.MXN != null) {
      if ((this.MUz.action != 2) && (this.MUz.action != 3)) {
        break label134;
      }
    }
    label134:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.MXN.setTextColor(MMApplicationContext.getResources().getColorStateList(R.e.fkS));
      }
      if ((this.adZg != null) && (!TextUtils.isEmpty(this.MUz.icon)))
      {
        this.adZg.setVisibility(0);
        r.bKe().loadImage(this.MUz.icon, this.adZg);
      }
      AppMethodBeat.o(306249);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(306240);
    if (this.MUA)
    {
      paramViewGroup = super.onCreateView(paramViewGroup);
      LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
      localViewGroup.removeAllViews();
      localLayoutInflater.inflate(R.i.glS, localViewGroup);
      AppMethodBeat.o(306240);
      return paramViewGroup;
    }
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(306240);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.logic.OpenIMPreference
 * JD-Core Version:    0.7.0.1
 */