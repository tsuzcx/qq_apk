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
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.p;
import com.tencent.mm.cc.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginPreference
  extends Preference
  implements e.a
{
  private MMActivity fLP;
  private ImageView jdF;
  int rlt;
  private String wSC;
  String yEn;
  String yEo;
  private int yEp;
  private int yEq;
  boolean yEr;
  
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
    this.wSC = "";
    this.yEp = -1;
    this.yEq = 8;
    this.yEr = false;
    this.jdF = null;
    this.rlt = 255;
    this.fLP = ((MMActivity)paramContext);
    setLayoutResource(2131494804);
    p.aEk().a(this);
    AppMethodBeat.o(73911);
  }
  
  private void dJx()
  {
    AppMethodBeat.i(73914);
    if (this.jdF != null) {
      a.b.c(this.jdF, this.yEn);
    }
    AppMethodBeat.o(73914);
  }
  
  public final void De(String paramString)
  {
    AppMethodBeat.i(73917);
    if ((this.yEn != null) && (this.yEn.equals(paramString))) {
      new ap(Looper.getMainLooper()).post(new Runnable()
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
  
  public final boolean axc(String paramString)
  {
    AppMethodBeat.i(73912);
    paramString = ((l)g.ab(l.class)).azp().Bf(paramString);
    if ((paramString == null) || ((int)paramString.gfj == 0))
    {
      ad.e("MicroMsg.PluginPreference", "plugin do not exist");
      AppMethodBeat.o(73912);
      return false;
    }
    this.yEn = paramString.field_username;
    this.yEo = paramString.adu();
    setKey("settings_plugins_list_#" + this.yEn);
    AppMethodBeat.o(73912);
    return true;
  }
  
  public final boolean jb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73913);
    this.yEn = paramString1;
    this.yEo = paramString2;
    setKey("settings_plugins_list_#" + this.yEn);
    AppMethodBeat.o(73913);
    return true;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73916);
    super.onBindView(paramView);
    this.jdF = ((ImageView)paramView.findViewById(2131300943));
    this.jdF.setAlpha(this.rlt);
    TextView localTextView = (TextView)paramView.findViewById(2131305745);
    if (localTextView != null)
    {
      localTextView.setVisibility(this.yEq);
      localTextView.setText(this.wSC);
      if (this.yEp != -1) {
        localTextView.setBackgroundDrawable(a.l(this.fLP, this.yEp));
      }
    }
    paramView = (TextView)paramView.findViewById(2131302741);
    if (paramView != null) {
      if (!this.yEr) {
        break label125;
      }
    }
    label125:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      dJx();
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