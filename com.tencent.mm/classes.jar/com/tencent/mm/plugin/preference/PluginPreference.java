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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.cd.a;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.AvatarStorage.a;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.plugin.newtips.b.d;
import com.tencent.mm.plugin.newtips.b.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class PluginPreference
  extends Preference
  implements AvatarStorage.a
{
  public String MPi;
  public String MPj;
  private String MPk;
  private int MPl;
  private int MPm;
  public boolean MPn;
  private TextView MPo;
  private TextView MPp;
  private ImageView avatar;
  private MMActivity lzt;
  public int zWi;
  
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
    AppMethodBeat.i(260550);
    this.MPk = "";
    this.MPl = -1;
    this.MPm = 8;
    this.MPn = false;
    this.avatar = null;
    this.zWi = 255;
    this.lzt = ((MMActivity)paramContext);
    setLayoutResource(b.d.mm_preference);
    q.bFp().a(this);
    AppMethodBeat.o(260550);
  }
  
  private void gzL()
  {
    AppMethodBeat.i(260553);
    if (this.avatar != null)
    {
      if (this.MPi.equals("newsapp"))
      {
        this.avatar.setImageResource(b.e.default_readerapp_plugin);
        AppMethodBeat.o(260553);
        return;
      }
      a.b.g(this.avatar, this.MPi);
    }
    AppMethodBeat.o(260553);
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(260581);
    if ((this.MPi != null) && (this.MPi.equals(paramString))) {
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(260544);
          PluginPreference.a(PluginPreference.this);
          AppMethodBeat.o(260544);
        }
      });
    }
    AppMethodBeat.o(260581);
  }
  
  public final boolean aRF(String paramString)
  {
    AppMethodBeat.i(260561);
    paramString = ((n)h.ax(n.class)).bzA().JE(paramString);
    if ((paramString == null) || ((int)paramString.maN == 0))
    {
      Log.e("MicroMsg.PluginPreference", "plugin do not exist");
      AppMethodBeat.o(260561);
      return false;
    }
    this.MPi = paramString.field_username;
    this.MPj = paramString.aSU();
    setKey("settings_plugins_list_#" + this.MPi);
    AppMethodBeat.o(260561);
    return true;
  }
  
  public final void afx(int paramInt)
  {
    this.MPm = paramInt;
  }
  
  public final void gv(String paramString, int paramInt)
  {
    this.MPk = paramString;
    this.MPl = paramInt;
  }
  
  public final boolean kU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(260565);
    this.MPi = paramString1;
    this.MPj = paramString2;
    setKey("settings_plugins_list_#" + this.MPi);
    AppMethodBeat.o(260565);
    return true;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(260573);
    super.onBindView(paramView);
    this.avatar = ((ImageView)paramView.findViewById(b.c.image_iv));
    this.avatar.setAlpha(this.zWi);
    this.MPp = ((TextView)paramView.findViewById(b.c.text_tv_one));
    if (this.MPp != null)
    {
      this.MPp.setVisibility(this.MPm);
      this.MPp.setText(this.MPk);
      if (this.MPl != -1) {
        this.MPp.setBackgroundDrawable(a.m(this.lzt, this.MPl));
      }
    }
    this.MPo = ((TextView)paramView.findViewById(b.c.new_dot));
    if (this.MPo != null)
    {
      paramView = this.MPo;
      if (!this.MPn) {
        break label154;
      }
    }
    label154:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      gzL();
      AppMethodBeat.o(260573);
      return;
    }
  }
  
  public View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(260569);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(b.c.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(b.d.mm_preference_content_plugin, localViewGroup);
    AppMethodBeat.o(260569);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.preference.PluginPreference
 * JD-Core Version:    0.7.0.1
 */