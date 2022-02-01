package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xt;
import com.tencent.mm.autogen.a.yb;
import com.tencent.mm.plugin.sns.ad.j.h;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends n
{
  com.tencent.mm.plugin.sns.ad.landingpage.component.info.f PQd;
  private IListener<yb> PQe;
  private IListener<xt> PQf;
  ViewGroup PQg;
  private ViewGroup PQh;
  private r PQi;
  private BroadcastReceiver PQj;
  int PQk;
  int PQl;
  int PQm;
  int PQn;
  boolean PQo;
  public boolean PQp = true;
  private TextView sQ;
  
  public f(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.info.f paramf, ViewGroup paramViewGroup)
  {
    this(paramContext, paramf, paramViewGroup, -1);
    AppMethodBeat.i(310693);
    int i = 0;
    if (paramf != null) {
      i = paramf.PRV;
    }
    int j = i;
    if (i <= 0) {
      j = 130;
    }
    this.PQn = com.tencent.mm.cd.a.fromDPToPix(this.context, j);
    AppMethodBeat.o(310693);
  }
  
  public f(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.info.f paramf, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramContext, paramf, paramViewGroup);
    this.PQd = paramf;
    this.PQk = 0;
    this.PQl = 0;
    this.PQn = paramInt;
    this.PQo = true;
  }
  
  final void Dn(boolean paramBoolean)
  {
    AppMethodBeat.i(310741);
    if ((this.PQi != null) && (this.PQi.QPn != null))
    {
      this.PQi.QPp = paramBoolean;
      this.PQi.QPn.performClick();
    }
    AppMethodBeat.o(310741);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(310700);
    try
    {
      if (this.PQj == null)
      {
        localObject1 = new IntentFilter();
        ((IntentFilter)localObject1).addAction("com.tencent.mm.adlanding.video_progressbar_change");
        this.PQj = new a((byte)0);
        androidx.i.a.a.al(this.context).a(this.PQj, (IntentFilter)localObject1);
      }
      if (this.PQe == null)
      {
        this.PQe = new AdLandingFloatJumpComp.2(this, com.tencent.mm.app.f.hfK);
        this.PQe.alive();
      }
      if (this.PQf == null)
      {
        this.PQf = new AdLandingFloatJumpComp.3(this, com.tencent.mm.app.f.hfK);
        this.PQf.alive();
      }
      if (this.contentView != null)
      {
        this.PQg = ((ViewGroup)this.contentView.findViewById(b.f.sns_ad_float_jump_root));
        this.sQ = ((TextView)this.contentView.findViewById(b.f.sns_ad_float_jump_title));
        this.PQh = ((ViewGroup)this.contentView.findViewById(b.f.sns_ad_float_jump_btn_container));
      }
      Object localObject1 = this.PQd;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.ad.landingpage.component.info.f)localObject1).PRW != null))
      {
        localObject1 = bb.a(this.context, ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.f)localObject1).PRW, this.PQh, 0);
        if ((localObject1 instanceof r))
        {
          this.PQi = ((r)localObject1);
          this.PQi.QPq = true;
          this.PQh.removeAllViews();
          this.PQh.addView(((n)localObject1).getView());
        }
      }
      if (this.PQg != null) {
        this.PQg.setOnClickListener(new f.1(this));
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310700);
    }
  }
  
  public final boolean M(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(310751);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(310751);
      return false;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (bP(localJSONObject))
      {
        localJSONObject.put("clickCount", this.PQk);
        localJSONObject.put("autoJumpCount", this.PQl);
        localJSONObject.put("swipeJumpCount", this.PQm);
        paramJSONArray.put(localJSONObject);
        localJSONObject = new JSONObject();
        if ((this.PQi != null) && (this.PQi.bP(localJSONObject))) {
          paramJSONArray.put(localJSONObject);
        }
        return true;
      }
    }
    finally
    {
      AppMethodBeat.o(310751);
    }
    return false;
  }
  
  public final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_floatjump;
  }
  
  public final void had()
  {
    AppMethodBeat.i(310704);
    try
    {
      super.had();
      TextView localTextView = this.sQ;
      com.tencent.mm.plugin.sns.ad.landingpage.component.info.f localf = this.PQd;
      if ((localTextView != null) && (localf != null)) {
        localTextView.setText(localf.MCJ);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310704);
    }
  }
  
  public final void hao()
  {
    AppMethodBeat.i(310717);
    try
    {
      super.hao();
      if (this.PQi != null) {
        this.PQi.hao();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310717);
    }
  }
  
  public final void hap()
  {
    AppMethodBeat.i(310725);
    try
    {
      super.hap();
      if (this.PQi != null) {
        this.PQi.hap();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310725);
    }
  }
  
  public final void has()
  {
    AppMethodBeat.i(310734);
    try
    {
      super.has();
      if (this.PQi != null) {
        this.PQi.has();
      }
      if (this.PQj != null)
      {
        androidx.i.a.a.al(this.context).unregisterReceiver(this.PQj);
        this.PQj = null;
      }
      if (this.PQe != null)
      {
        this.PQe.dead();
        this.PQe = null;
      }
      if (this.PQf != null)
      {
        this.PQf.dead();
        this.PQf = null;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310734);
    }
  }
  
  final class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(310679);
      try
      {
        int i = h.getIntExtra(paramIntent, "show", 0);
        int j = h.getIntExtra(paramIntent, "activity_code", 0);
        paramContext = f.this.context;
        if ((paramContext != null) && (j == paramContext.hashCode()))
        {
          if (i == 0)
          {
            if (!f.this.PQp) {
              break label106;
            }
            f.this.contentView.setVisibility(0);
            AppMethodBeat.o(310679);
            return;
          }
          f.this.contentView.setVisibility(8);
        }
      }
      finally
      {
        AppMethodBeat.o(310679);
        return;
      }
      Log.w("SnsAd.FloatJumpComp", "the context is not same!!");
      label106:
      AppMethodBeat.o(310679);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.f
 * JD-Core Version:    0.7.0.1
 */