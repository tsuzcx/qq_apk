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
import com.tencent.mm.cc.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginPreference
  extends Preference
  implements e.a
{
  private ImageView iKw;
  private MMActivity iMV;
  int qBD;
  private String vLt;
  String xpK;
  String xpL;
  private int xpM;
  private int xpN;
  boolean xpO;
  
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
    this.vLt = "";
    this.xpM = -1;
    this.xpN = 8;
    this.xpO = false;
    this.iKw = null;
    this.qBD = 255;
    this.iMV = ((MMActivity)paramContext);
    setLayoutResource(2131494804);
    p.aBh().a(this);
    AppMethodBeat.o(73911);
  }
  
  private void dyf()
  {
    AppMethodBeat.i(73914);
    if (this.iKw != null) {
      a.b.c(this.iKw, this.xpK);
    }
    AppMethodBeat.o(73914);
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(73917);
    if ((this.xpK != null) && (this.xpK.equals(paramString))) {
      new ao(Looper.getMainLooper()).post(new Runnable()
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
  
  public final boolean asc(String paramString)
  {
    AppMethodBeat.i(73912);
    paramString = ((k)g.ab(k.class)).awB().aNt(paramString);
    if ((paramString == null) || ((int)paramString.fLJ == 0))
    {
      ac.e("MicroMsg.PluginPreference", "plugin do not exist");
      AppMethodBeat.o(73912);
      return false;
    }
    this.xpK = paramString.field_username;
    this.xpL = paramString.aaR();
    setKey("settings_plugins_list_#" + this.xpK);
    AppMethodBeat.o(73912);
    return true;
  }
  
  public final boolean iQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73913);
    this.xpK = paramString1;
    this.xpL = paramString2;
    setKey("settings_plugins_list_#" + this.xpK);
    AppMethodBeat.o(73913);
    return true;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73916);
    super.onBindView(paramView);
    this.iKw = ((ImageView)paramView.findViewById(2131300943));
    this.iKw.setAlpha(this.qBD);
    TextView localTextView = (TextView)paramView.findViewById(2131305745);
    if (localTextView != null)
    {
      localTextView.setVisibility(this.xpN);
      localTextView.setText(this.vLt);
      if (this.xpM != -1) {
        localTextView.setBackgroundDrawable(a.l(this.iMV, this.xpM));
      }
    }
    paramView = (TextView)paramView.findViewById(2131302741);
    if (paramView != null) {
      if (!this.xpO) {
        break label125;
      }
    }
    label125:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      dyf();
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