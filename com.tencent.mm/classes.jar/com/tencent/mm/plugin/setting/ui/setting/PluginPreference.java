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
import com.tencent.mm.cd.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginPreference
  extends Preference
  implements e.a
{
  private ImageView ikp;
  private MMActivity imP;
  int pSW;
  private String uCA;
  boolean weA;
  String wew;
  String wex;
  private int wey;
  private int wez;
  
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
    this.uCA = "";
    this.wey = -1;
    this.wez = 8;
    this.weA = false;
    this.ikp = null;
    this.pSW = 255;
    this.imP = ((MMActivity)paramContext);
    setLayoutResource(2131494804);
    p.auq().a(this);
    AppMethodBeat.o(73911);
  }
  
  private void dkd()
  {
    AppMethodBeat.i(73914);
    if (this.ikp != null) {
      a.b.c(this.ikp, this.wew);
    }
    AppMethodBeat.o(73914);
  }
  
  public final boolean amT(String paramString)
  {
    AppMethodBeat.i(73912);
    paramString = ((k)g.ab(k.class)).apM().aHY(paramString);
    if ((paramString == null) || ((int)paramString.fId == 0))
    {
      ad.e("MicroMsg.PluginPreference", "plugin do not exist");
      AppMethodBeat.o(73912);
      return false;
    }
    this.wew = paramString.field_username;
    this.wex = paramString.ZW();
    setKey("settings_plugins_list_#" + this.wew);
    AppMethodBeat.o(73912);
    return true;
  }
  
  public final boolean iu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73913);
    this.wew = paramString1;
    this.wex = paramString2;
    setKey("settings_plugins_list_#" + this.wew);
    AppMethodBeat.o(73913);
    return true;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73916);
    super.onBindView(paramView);
    this.ikp = ((ImageView)paramView.findViewById(2131300943));
    this.ikp.setAlpha(this.pSW);
    TextView localTextView = (TextView)paramView.findViewById(2131305745);
    if (localTextView != null)
    {
      localTextView.setVisibility(this.wez);
      localTextView.setText(this.uCA);
      if (this.wey != -1) {
        localTextView.setBackgroundDrawable(a.l(this.imP, this.wey));
      }
    }
    paramView = (TextView)paramView.findViewById(2131302741);
    if (paramView != null) {
      if (!this.weA) {
        break label125;
      }
    }
    label125:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      dkd();
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
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(73917);
    if ((this.wew != null) && (this.wew.equals(paramString))) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PluginPreference
 * JD-Core Version:    0.7.0.1
 */