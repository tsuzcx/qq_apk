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
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginPreference
  extends Preference
  implements d.a
{
  private MMActivity cmc;
  private ImageView gxs;
  int mml;
  private String pAS;
  String qGc;
  String qGd;
  private int qGe;
  private int qGf;
  boolean qGg;
  
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
    AppMethodBeat.i(126980);
    this.pAS = "";
    this.qGe = -1;
    this.qGf = 8;
    this.qGg = false;
    this.gxs = null;
    this.mml = 255;
    this.cmc = ((MMActivity)paramContext);
    setLayoutResource(2130970179);
    o.acQ().a(this);
    AppMethodBeat.o(126980);
  }
  
  private void chm()
  {
    AppMethodBeat.i(126982);
    if (this.gxs != null) {
      a.b.c(this.gxs, this.qGc);
    }
    AppMethodBeat.o(126982);
  }
  
  public final boolean YT(String paramString)
  {
    AppMethodBeat.i(126981);
    paramString = ((j)g.E(j.class)).YA().arw(paramString);
    if ((paramString == null) || ((int)paramString.euF == 0))
    {
      ab.e("MicroMsg.PluginPreference", "plugin do not exist");
      AppMethodBeat.o(126981);
      return false;
    }
    this.qGc = paramString.field_username;
    this.qGd = paramString.Oe();
    setKey("settings_plugins_list_#" + this.qGc);
    AppMethodBeat.o(126981);
    return true;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(126984);
    super.onBindView(paramView);
    this.gxs = ((ImageView)paramView.findViewById(2131822243));
    this.gxs.setAlpha(this.mml);
    TextView localTextView = (TextView)paramView.findViewById(2131822409);
    if (localTextView != null)
    {
      localTextView.setVisibility(this.qGf);
      localTextView.setText(this.pAS);
      if (this.qGe != -1) {
        localTextView.setBackgroundDrawable(com.tencent.mm.cb.a.k(this.cmc, this.qGe));
      }
    }
    paramView = (TextView)paramView.findViewById(2131825202);
    if (paramView != null) {
      if (!this.qGg) {
        break label125;
      }
    }
    label125:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      chm();
      AppMethodBeat.o(126984);
      return;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(126983);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970212, localViewGroup);
    AppMethodBeat.o(126983);
    return paramViewGroup;
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(126985);
    if ((this.qGc != null) && (this.qGc.equals(paramString))) {
      new ak(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(126979);
          PluginPreference.a(PluginPreference.this);
          AppMethodBeat.o(126979);
        }
      });
    }
    AppMethodBeat.o(126985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PluginPreference
 * JD-Core Version:    0.7.0.1
 */