package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends l
{
  private TextView Wf;
  private c<uc> hJu;
  com.tencent.mm.plugin.sns.ad.landingpage.component.b.a yWY;
  private ViewGroup yWZ;
  private ViewGroup yXa;
  private p yXb;
  private BroadcastReceiver yXc;
  int yXd;
  int yXe;
  
  public a(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.b.a parama, ViewGroup paramViewGroup)
  {
    super(paramContext, parama, paramViewGroup);
    this.yWY = parama;
    this.yXd = 0;
    this.yXe = 0;
  }
  
  public final boolean D(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(197569);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(197569);
      return false;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (aQ(localJSONObject))
      {
        localJSONObject.put("clickCount", this.yXd);
        localJSONObject.put("autoJumpCount", this.yXe);
        paramJSONArray.put(localJSONObject);
        localJSONObject = new JSONObject();
        if ((this.yXb != null) && (this.yXb.aQ(localJSONObject))) {
          paramJSONArray.put(localJSONObject);
        }
        AppMethodBeat.o(197569);
        return true;
      }
    }
    catch (Throwable paramJSONArray)
    {
      AppMethodBeat.o(197569);
    }
    return false;
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(197563);
    try
    {
      if (this.yXc == null)
      {
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.video_progressbar_change");
        this.yXc = new a((byte)0);
        android.support.v4.content.d.U(this.context).a(this.yXc, (IntentFilter)localObject);
      }
      if (this.hJu == null)
      {
        this.hJu = new c()
        {
          private boolean dRp()
          {
            AppMethodBeat.i(197560);
            try
            {
              locala = a.this;
              ad.d("SnsAd.FloatJumpComp", "the SnsAdVideoBonusSceneEvent is received!");
              com.tencent.mm.plugin.sns.ad.landingpage.component.b.a locala1 = locala.yWY;
              if ((locala1 != null) && (locala1.yXh > 0))
              {
                if (locala.yXd > 0) {
                  break label98;
                }
                if (locala.yXe <= 0) {
                  break label64;
                }
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                a locala;
                label64:
                ad.w("SnsAd.FloatJumpComp", "onEventCall called has wrong!");
                continue;
                int i = 1;
                if (i == 0) {}
              }
            }
            ad.d("SnsAd.FloatJumpComp", "the comp is clicked, or the auto jump is less than 0!");
            for (;;)
            {
              AppMethodBeat.o(197560);
              return true;
              i = 0;
              break;
              locala.yXe += 1;
              locala.rh(true);
            }
          }
        };
        this.hJu.alive();
      }
      if (this.contentView != null)
      {
        this.yWZ = ((ViewGroup)this.contentView.findViewById(2131308211));
        this.Wf = ((TextView)this.contentView.findViewById(2131308212));
        this.yXa = ((ViewGroup)this.contentView.findViewById(2131308210));
      }
      Object localObject = this.yWY;
      if ((localObject != null) && (((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject).yXi != null))
      {
        localObject = av.a(this.context, ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject).yXi, this.yXa, 0);
        if ((localObject instanceof p))
        {
          this.yXb = ((p)localObject);
          this.yXa.removeAllViews();
          this.yXa.addView(((l)localObject).getView());
        }
      }
      if (this.yWZ != null) {
        this.yWZ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(197558);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingFloatJumpComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            try
            {
              ad.d("SnsAd.FloatJumpComp", "the root is clicked!");
              paramAnonymousView = a.this;
              paramAnonymousView.yXd += 1;
              a.this.rh(false);
              label64:
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingFloatJumpComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(197558);
              return;
            }
            catch (Throwable paramAnonymousView)
            {
              break label64;
            }
          }
        });
      }
      AppMethodBeat.o(197563);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197563);
    }
  }
  
  public final void dRl()
  {
    AppMethodBeat.i(197564);
    try
    {
      super.dRl();
      TextView localTextView = this.Wf;
      com.tencent.mm.plugin.sns.ad.landingpage.component.b.a locala = this.yWY;
      if ((localTextView != null) && (locala != null)) {
        localTextView.setText(locala.yXg);
      }
      AppMethodBeat.o(197564);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197564);
    }
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(197565);
    try
    {
      super.dRm();
      if (this.yXb != null) {
        this.yXb.dRm();
      }
      AppMethodBeat.o(197565);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197565);
    }
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(197566);
    try
    {
      super.dRn();
      if (this.yXb != null) {
        this.yXb.dRn();
      }
      AppMethodBeat.o(197566);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197566);
    }
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(197567);
    try
    {
      super.dRo();
      if (this.yXb != null) {
        this.yXb.dRo();
      }
      if (this.yXc != null)
      {
        android.support.v4.content.d.U(this.context).unregisterReceiver(this.yXc);
        this.yXc = null;
      }
      if (this.hJu != null) {
        this.hJu.dead();
      }
      AppMethodBeat.o(197567);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(197567);
    }
  }
  
  public final int getLayout()
  {
    return 2131496425;
  }
  
  final void rh(boolean paramBoolean)
  {
    AppMethodBeat.i(197568);
    if ((this.yXb != null) && (this.yXb.zEd != null))
    {
      this.yXb.zEf = paramBoolean;
      this.yXb.zEd.performClick();
    }
    AppMethodBeat.o(197568);
  }
  
  final class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(197562);
      try
      {
        int i = com.tencent.mm.plugin.sns.ad.e.d.getIntExtra(paramIntent, "show", 0);
        int j = com.tencent.mm.plugin.sns.ad.e.d.getIntExtra(paramIntent, "activity_code", 0);
        paramContext = a.this.context;
        if ((paramContext != null) && (j == paramContext.hashCode()))
        {
          if (i == 0)
          {
            a.this.contentView.setVisibility(0);
            AppMethodBeat.o(197562);
            return;
          }
          a.this.contentView.setVisibility(8);
          AppMethodBeat.o(197562);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(197562);
        return;
      }
      ad.w("SnsAd.FloatJumpComp", "the context is not same!!");
      AppMethodBeat.o(197562);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.a
 * JD-Core Version:    0.7.0.1
 */