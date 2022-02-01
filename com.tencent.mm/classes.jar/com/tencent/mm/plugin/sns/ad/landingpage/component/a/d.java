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
import com.tencent.mm.g.a.uy;
import com.tencent.mm.g.a.ve;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ad.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends m
{
  com.tencent.mm.plugin.sns.ad.landingpage.component.b.d DtD;
  private IListener<ve> DtE;
  private IListener<uy> DtF;
  ViewGroup DtG;
  private ViewGroup DtH;
  private q DtI;
  private BroadcastReceiver DtJ;
  int DtK;
  int DtL;
  int DtM;
  int DtN;
  boolean DtO;
  private TextView Ws;
  
  public d(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.b.d paramd, ViewGroup paramViewGroup)
  {
    this(paramContext, paramd, paramViewGroup, -1);
    AppMethodBeat.i(201991);
    int i = 0;
    if (paramd != null) {
      i = paramd.DtU;
    }
    int j = i;
    if (i <= 0) {
      j = 130;
    }
    this.DtN = com.tencent.mm.cb.a.fromDPToPix(this.context, j);
    AppMethodBeat.o(201991);
  }
  
  public d(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.b.d paramd, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramContext, paramd, paramViewGroup);
    this.DtD = paramd;
    this.DtK = 0;
    this.DtL = 0;
    this.DtN = paramInt;
    this.DtO = true;
  }
  
  public final boolean G(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(201998);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(201998);
      return false;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (bp(localJSONObject))
      {
        localJSONObject.put("clickCount", this.DtK);
        localJSONObject.put("autoJumpCount", this.DtL);
        localJSONObject.put("swipeJumpCount", this.DtM);
        paramJSONArray.put(localJSONObject);
        localJSONObject = new JSONObject();
        if ((this.DtI != null) && (this.DtI.bp(localJSONObject))) {
          paramJSONArray.put(localJSONObject);
        }
        AppMethodBeat.o(201998);
        return true;
      }
    }
    catch (Throwable paramJSONArray)
    {
      AppMethodBeat.o(201998);
    }
    return false;
  }
  
  public final void eWT()
  {
    AppMethodBeat.i(201993);
    try
    {
      super.eWT();
      TextView localTextView = this.Ws;
      com.tencent.mm.plugin.sns.ad.landingpage.component.b.d locald = this.DtD;
      if ((localTextView != null) && (locald != null)) {
        localTextView.setText(locald.DtS);
      }
      AppMethodBeat.o(201993);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(201993);
    }
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(201994);
    try
    {
      super.eWZ();
      if (this.DtI != null) {
        this.DtI.eWZ();
      }
      AppMethodBeat.o(201994);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(201994);
    }
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(201995);
    try
    {
      super.eXa();
      if (this.DtI != null) {
        this.DtI.eXa();
      }
      AppMethodBeat.o(201995);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(201995);
    }
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(201996);
    try
    {
      super.eXd();
      if (this.DtI != null) {
        this.DtI.eXd();
      }
      if (this.DtJ != null)
      {
        android.support.v4.content.d.W(this.context).unregisterReceiver(this.DtJ);
        this.DtJ = null;
      }
      if (this.DtE != null)
      {
        this.DtE.dead();
        this.DtE = null;
      }
      if (this.DtF != null)
      {
        this.DtF.dead();
        this.DtF = null;
      }
      AppMethodBeat.o(201996);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(201996);
    }
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(201992);
    try
    {
      if (this.DtJ == null)
      {
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.video_progressbar_change");
        this.DtJ = new a((byte)0);
        android.support.v4.content.d.W(this.context).a(this.DtJ, (IntentFilter)localObject);
      }
      if (this.DtE == null)
      {
        this.DtE = new IListener()
        {
          private boolean eXf()
          {
            AppMethodBeat.i(201986);
            try
            {
              locald = d.this;
              Log.d("SnsAd.FloatJumpComp", "the SnsAdVideoBonusSceneEvent is received!");
              com.tencent.mm.plugin.sns.ad.landingpage.component.b.d locald1 = locald.DtD;
              if ((locald1 != null) && (locald1.DtT > 0))
              {
                if ((locald.DtK > 0) || (locald.DtL > 0)) {
                  break label105;
                }
                if (locald.DtM <= 0) {
                  break label71;
                }
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                d locald;
                label71:
                Log.w("SnsAd.FloatJumpComp", "onEventCall called has wrong!");
                continue;
                int i = 1;
                if (i == 0) {}
              }
            }
            Log.d("SnsAd.FloatJumpComp", "the comp is clicked, or the auto jump is less than 0!");
            for (;;)
            {
              AppMethodBeat.o(201986);
              return true;
              i = 0;
              break;
              locald.DtL += 1;
              locald.uK(true);
            }
          }
        };
        this.DtE.alive();
      }
      if (this.DtF == null)
      {
        this.DtF = new IListener() {};
        this.DtF.alive();
      }
      if (this.contentView != null)
      {
        this.DtG = ((ViewGroup)this.contentView.findViewById(2131308027));
        this.Ws = ((TextView)this.contentView.findViewById(2131308028));
        this.DtH = ((ViewGroup)this.contentView.findViewById(2131308026));
      }
      Object localObject = this.DtD;
      if ((localObject != null) && (((com.tencent.mm.plugin.sns.ad.landingpage.component.b.d)localObject).DtV != null))
      {
        localObject = ay.a(this.context, ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.d)localObject).DtV, this.DtH, 0);
        if ((localObject instanceof q))
        {
          this.DtI = ((q)localObject);
          this.DtI.Eds = true;
          this.DtH.removeAllViews();
          this.DtH.addView(((m)localObject).getView());
        }
      }
      if (this.DtG != null) {
        this.DtG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(201984);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingFloatJumpComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            try
            {
              Log.d("SnsAd.FloatJumpComp", "the root is clicked!");
              paramAnonymousView = d.this;
              paramAnonymousView.DtK += 1;
              d.this.uK(false);
              label64:
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingFloatJumpComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(201984);
              return;
            }
            catch (Throwable paramAnonymousView)
            {
              break label64;
            }
          }
        });
      }
      AppMethodBeat.o(201992);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(201992);
    }
  }
  
  public final int getLayout()
  {
    return 2131496385;
  }
  
  final void uK(boolean paramBoolean)
  {
    AppMethodBeat.i(201997);
    if ((this.DtI != null) && (this.DtI.Edp != null))
    {
      this.DtI.Edr = paramBoolean;
      this.DtI.Edp.performClick();
    }
    AppMethodBeat.o(201997);
  }
  
  final class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(201990);
      try
      {
        int i = g.getIntExtra(paramIntent, "show", 0);
        int j = g.getIntExtra(paramIntent, "activity_code", 0);
        paramContext = d.this.context;
        if ((paramContext != null) && (j == paramContext.hashCode()))
        {
          if (i == 0)
          {
            d.this.contentView.setVisibility(0);
            AppMethodBeat.o(201990);
            return;
          }
          d.this.contentView.setVisibility(8);
          AppMethodBeat.o(201990);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(201990);
        return;
      }
      Log.w("SnsAd.FloatJumpComp", "the context is not same!!");
      AppMethodBeat.o(201990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.d
 * JD-Core Version:    0.7.0.1
 */