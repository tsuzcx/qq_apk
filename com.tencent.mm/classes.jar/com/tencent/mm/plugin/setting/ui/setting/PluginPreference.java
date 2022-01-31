package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginPreference
  extends Preference
  implements d.a
{
  private MMActivity bER;
  private ImageView ffK = null;
  int jRP = 255;
  String nSe;
  String nSf;
  private String nSg = "";
  private int nSh = -1;
  private int nSi = 8;
  boolean nSj = false;
  
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
    this.bER = ((MMActivity)paramContext);
    setLayoutResource(a.g.mm_preference);
    o.JQ().a(this);
  }
  
  private void bww()
  {
    if (this.ffK != null) {
      a.b.a(this.ffK, this.nSe);
    }
  }
  
  public final boolean Mp(String paramString)
  {
    paramString = ((j)g.r(j.class)).Fw().abl(paramString);
    if ((paramString == null) || ((int)paramString.dBe == 0))
    {
      y.e("MicroMsg.PluginPreference", "plugin do not exist");
      return false;
    }
    this.nSe = paramString.field_username;
    this.nSf = paramString.Bp();
    setKey("settings_plugins_list_#" + this.nSe);
    return true;
  }
  
  public final void kk(String paramString)
  {
    if ((this.nSe != null) && (this.nSe.equals(paramString))) {
      new ah(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          PluginPreference.a(PluginPreference.this);
        }
      });
    }
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.ffK = ((ImageView)paramView.findViewById(a.f.image_iv));
    this.ffK.setAlpha(this.jRP);
    TextView localTextView = (TextView)paramView.findViewById(a.f.text_tv_one);
    if (localTextView != null)
    {
      localTextView.setVisibility(this.nSi);
      localTextView.setText(this.nSg);
      if (this.nSh != -1) {
        localTextView.setBackgroundDrawable(com.tencent.mm.cb.a.g(this.bER, this.nSh));
      }
    }
    paramView = (TextView)paramView.findViewById(a.f.new_dot);
    if (paramView != null) {
      if (!this.nSj) {
        break label118;
      }
    }
    label118:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      bww();
      return;
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.f.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(a.g.mm_preference_content_plugin, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PluginPreference
 * JD-Core Version:    0.7.0.1
 */