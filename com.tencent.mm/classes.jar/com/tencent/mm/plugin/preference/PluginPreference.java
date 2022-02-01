package com.tencent.mm.plugin.preference;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.am.f.a;
import com.tencent.mm.am.q;
import com.tencent.mm.ci.a;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.plugin.newtips.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class PluginPreference
  extends Preference
  implements f.a
{
  public String GRE;
  public String GRF;
  private String GRG;
  private int GRH;
  private int GRI;
  public boolean GRJ;
  private TextView GRK;
  private TextView GRL;
  private MMActivity iXq;
  private ImageView mWb;
  public int wzX;
  
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
    AppMethodBeat.i(186491);
    this.GRG = "";
    this.GRH = -1;
    this.GRI = 8;
    this.GRJ = false;
    this.mWb = null;
    this.wzX = 255;
    this.iXq = ((MMActivity)paramContext);
    setLayoutResource(b.d.mm_preference);
    q.bhz().a(this);
    AppMethodBeat.o(186491);
  }
  
  private void foI()
  {
    AppMethodBeat.i(186500);
    if (this.mWb != null) {
      a.b.c(this.mWb, this.GRE);
    }
    AppMethodBeat.o(186500);
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(186510);
    if ((this.GRE != null) && (this.GRE.equals(paramString))) {
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186410);
          PluginPreference.a(PluginPreference.this);
          AppMethodBeat.o(186410);
        }
      });
    }
    AppMethodBeat.o(186510);
  }
  
  public final boolean aUx(String paramString)
  {
    AppMethodBeat.i(186495);
    paramString = ((n)h.ae(n.class)).bbL().RG(paramString);
    if ((paramString == null) || ((int)paramString.jxt == 0))
    {
      Log.e("MicroMsg.PluginPreference", "plugin do not exist");
      AppMethodBeat.o(186495);
      return false;
    }
    this.GRE = paramString.field_username;
    this.GRF = paramString.ayr();
    setKey("settings_plugins_list_#" + this.GRE);
    AppMethodBeat.o(186495);
    return true;
  }
  
  public final void abe(int paramInt)
  {
    this.GRI = paramInt;
  }
  
  public final void fC(String paramString, int paramInt)
  {
    this.GRG = paramString;
    this.GRH = paramInt;
  }
  
  public final boolean jA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186498);
    this.GRE = paramString1;
    this.GRF = paramString2;
    setKey("settings_plugins_list_#" + this.GRE);
    AppMethodBeat.o(186498);
    return true;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(186503);
    super.onBindView(paramView);
    this.mWb = ((ImageView)paramView.findViewById(b.c.image_iv));
    this.mWb.setAlpha(this.wzX);
    this.GRL = ((TextView)paramView.findViewById(b.c.text_tv_one));
    if (this.GRL != null)
    {
      this.GRL.setVisibility(this.GRI);
      this.GRL.setText(this.GRG);
      if (this.GRH != -1) {
        this.GRL.setBackgroundDrawable(a.m(this.iXq, this.GRH));
      }
    }
    this.GRK = ((TextView)paramView.findViewById(b.c.new_dot));
    if (this.GRK != null)
    {
      paramView = this.GRK;
      if (!this.GRJ) {
        break label154;
      }
    }
    label154:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      foI();
      AppMethodBeat.o(186503);
      return;
    }
  }
  
  public View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(186502);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(b.c.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(b.d.mm_preference_content_plugin, localViewGroup);
    AppMethodBeat.o(186502);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.preference.PluginPreference
 * JD-Core Version:    0.7.0.1
 */