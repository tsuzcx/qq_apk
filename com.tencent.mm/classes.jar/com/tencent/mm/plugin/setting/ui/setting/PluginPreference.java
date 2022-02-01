package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.p;
import com.tencent.mm.cb.a;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginPreference
  extends Preference
  implements e.a
{
  private MMActivity fNT;
  private ImageView jgy;
  int rty;
  private String xit;
  String yUs;
  String yUt;
  private int yUu;
  private int yUv;
  boolean yUw;
  
  public PluginPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PluginPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PluginPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73911);
    this.xit = "";
    this.yUu = -1;
    this.yUv = 8;
    this.yUw = false;
    this.jgy = null;
    this.rty = 255;
    this.fNT = ((MMActivity)paramContext);
    setLayoutResource(2131494804);
    p.aEA().a(this);
    AppMethodBeat.o(73911);
  }
  
  private void dMP()
  {
    AppMethodBeat.i(73914);
    if (this.jgy != null) {
      a.b.c(this.jgy, this.yUs);
    }
    AppMethodBeat.o(73914);
  }
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(73917);
    if ((this.yUs != null) && (this.yUs.equals(paramString))) {
      new aq(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(73910);
          PluginPreference.a(PluginPreference.this);
          AppMethodBeat.o(73910);
        }
      });
    }
    AppMethodBeat.o(73917);
  }
  
  public final boolean ays(String paramString)
  {
    AppMethodBeat.i(73912);
    paramString = ((l)g.ab(l.class)).azF().BH(paramString);
    if ((paramString == null) || ((int)paramString.ght == 0))
    {
      ae.e("MicroMsg.PluginPreference", "plugin do not exist");
      AppMethodBeat.o(73912);
      return false;
    }
    this.yUs = paramString.field_username;
    this.yUt = paramString.adF();
    setKey("settings_plugins_list_#" + this.yUs);
    AppMethodBeat.o(73912);
    return true;
  }
  
  public final boolean jh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73913);
    this.yUs = paramString1;
    this.yUt = paramString2;
    setKey("settings_plugins_list_#" + this.yUs);
    AppMethodBeat.o(73913);
    return true;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73916);
    super.onBindView(paramView);
    this.jgy = ((ImageView)paramView.findViewById(2131300943));
    this.jgy.setAlpha(this.rty);
    TextView localTextView = (TextView)paramView.findViewById(2131305745);
    if (localTextView != null)
    {
      localTextView.setVisibility(this.yUv);
      localTextView.setText(this.xit);
      if (this.yUu != -1) {
        localTextView.setBackgroundDrawable(a.l(this.fNT, this.yUu));
      }
    }
    paramView = (TextView)paramView.findViewById(2131302741);
    if (paramView != null) {
      if (!this.yUw) {
        break label125;
      }
    }
    label125:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      dMP();
      AppMethodBeat.o(73916);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(73915);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494839, localViewGroup);
    AppMethodBeat.o(73915);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PluginPreference
 * JD-Core Version:    0.7.0.1
 */