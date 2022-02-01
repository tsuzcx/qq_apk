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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginPreference
  extends Preference
  implements e.a
{
  private String Bgn;
  String CZi;
  String CZj;
  private int CZk;
  private int CZl;
  boolean CZm;
  private MMActivity gte;
  private ImageView keC;
  int sUb;
  
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
    this.Bgn = "";
    this.CZk = -1;
    this.CZl = 8;
    this.CZm = false;
    this.keC = null;
    this.sUb = 255;
    this.gte = ((MMActivity)paramContext);
    setLayoutResource(2131495538);
    p.aYn().a(this);
    AppMethodBeat.o(73911);
  }
  
  private void eNP()
  {
    AppMethodBeat.i(73914);
    if (this.keC != null) {
      a.b.c(this.keC, this.CZi);
    }
    AppMethodBeat.o(73914);
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(73917);
    if ((this.CZi != null) && (this.CZi.equals(paramString))) {
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
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
  
  public final boolean aNc(String paramString)
  {
    AppMethodBeat.i(73912);
    paramString = ((l)g.af(l.class)).aSN().Kn(paramString);
    if ((paramString == null) || ((int)paramString.gMZ == 0))
    {
      Log.e("MicroMsg.PluginPreference", "plugin do not exist");
      AppMethodBeat.o(73912);
      return false;
    }
    this.CZi = paramString.field_username;
    this.CZj = paramString.arI();
    setKey("settings_plugins_list_#" + this.CZi);
    AppMethodBeat.o(73912);
    return true;
  }
  
  public final boolean jT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73913);
    this.CZi = paramString1;
    this.CZj = paramString2;
    setKey("settings_plugins_list_#" + this.CZi);
    AppMethodBeat.o(73913);
    return true;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73916);
    super.onBindView(paramView);
    this.keC = ((ImageView)paramView.findViewById(2131302573));
    this.keC.setAlpha(this.sUb);
    TextView localTextView = (TextView)paramView.findViewById(2131309014);
    if (localTextView != null)
    {
      localTextView.setVisibility(this.CZl);
      localTextView.setText(this.Bgn);
      if (this.CZk != -1) {
        localTextView.setBackgroundDrawable(a.l(this.gte, this.CZk));
      }
    }
    paramView = (TextView)paramView.findViewById(2131305309);
    if (paramView != null) {
      if (!this.CZm) {
        break label125;
      }
    }
    label125:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      eNP();
      AppMethodBeat.o(73916);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(73915);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131299180);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131495574, localViewGroup);
    AppMethodBeat.o(73915);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PluginPreference
 * JD-Core Version:    0.7.0.1
 */