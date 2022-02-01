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
import com.tencent.mm.f.a.wc;
import com.tencent.mm.f.a.wi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ad.i.h;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
  extends m
{
  private q JAA;
  private BroadcastReceiver JAB;
  int JAC;
  int JAD;
  int JAE;
  int JAF;
  boolean JAG;
  com.tencent.mm.plugin.sns.ad.landingpage.component.b.e JAv;
  private IListener<wi> JAw;
  private IListener<wc> JAx;
  ViewGroup JAy;
  private ViewGroup JAz;
  private TextView rR;
  
  public e(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.b.e parame, ViewGroup paramViewGroup)
  {
    this(paramContext, parame, paramViewGroup, -1);
    AppMethodBeat.i(205425);
    int i = 0;
    if (parame != null) {
      i = parame.JBN;
    }
    int j = i;
    if (i <= 0) {
      j = 130;
    }
    this.JAF = com.tencent.mm.ci.a.fromDPToPix(this.context, j);
    AppMethodBeat.o(205425);
  }
  
  public e(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.b.e parame, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramContext, parame, paramViewGroup);
    this.JAv = parame;
    this.JAC = 0;
    this.JAD = 0;
    this.JAF = paramInt;
    this.JAG = true;
  }
  
  public final boolean H(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(205433);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(205433);
      return false;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (by(localJSONObject))
      {
        localJSONObject.put("clickCount", this.JAC);
        localJSONObject.put("autoJumpCount", this.JAD);
        localJSONObject.put("swipeJumpCount", this.JAE);
        paramJSONArray.put(localJSONObject);
        localJSONObject = new JSONObject();
        if ((this.JAA != null) && (this.JAA.by(localJSONObject))) {
          paramJSONArray.put(localJSONObject);
        }
        AppMethodBeat.o(205433);
        return true;
      }
    }
    catch (Throwable paramJSONArray)
    {
      AppMethodBeat.o(205433);
    }
    return false;
  }
  
  public final void fKe()
  {
    AppMethodBeat.i(205428);
    try
    {
      super.fKe();
      TextView localTextView = this.rR;
      com.tencent.mm.plugin.sns.ad.landingpage.component.b.e locale = this.JAv;
      if ((localTextView != null) && (locale != null)) {
        localTextView.setText(locale.JBL);
      }
      AppMethodBeat.o(205428);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(205428);
    }
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(205429);
    try
    {
      super.fKk();
      if (this.JAA != null) {
        this.JAA.fKk();
      }
      AppMethodBeat.o(205429);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(205429);
    }
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(205430);
    try
    {
      super.fKl();
      if (this.JAA != null) {
        this.JAA.fKl();
      }
      AppMethodBeat.o(205430);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(205430);
    }
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(205431);
    try
    {
      super.fKo();
      if (this.JAA != null) {
        this.JAA.fKo();
      }
      if (this.JAB != null)
      {
        androidx.h.a.a.V(this.context).unregisterReceiver(this.JAB);
        this.JAB = null;
      }
      if (this.JAw != null)
      {
        this.JAw.dead();
        this.JAw = null;
      }
      if (this.JAx != null)
      {
        this.JAx.dead();
        this.JAx = null;
      }
      AppMethodBeat.o(205431);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(205431);
    }
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(205427);
    try
    {
      if (this.JAB == null)
      {
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.video_progressbar_change");
        this.JAB = new a((byte)0);
        androidx.h.a.a.V(this.context).a(this.JAB, (IntentFilter)localObject);
      }
      if (this.JAw == null)
      {
        this.JAw = new IListener()
        {
          private boolean fKq()
          {
            AppMethodBeat.i(261401);
            try
            {
              locale = e.this;
              Log.d("SnsAd.FloatJumpComp", "the SnsAdVideoBonusSceneEvent is received!");
              com.tencent.mm.plugin.sns.ad.landingpage.component.b.e locale1 = locale.JAv;
              if ((locale1 != null) && (locale1.JBM > 0))
              {
                if ((locale.JAC > 0) || (locale.JAD > 0)) {
                  break label105;
                }
                if (locale.JAE <= 0) {
                  break label71;
                }
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                e locale;
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
              AppMethodBeat.o(261401);
              return true;
              i = 0;
              break;
              locale.JAD += 1;
              locale.yi(true);
            }
          }
        };
        this.JAw.alive();
      }
      if (this.JAx == null)
      {
        this.JAx = new IListener() {};
        this.JAx.alive();
      }
      if (this.contentView != null)
      {
        this.JAy = ((ViewGroup)this.contentView.findViewById(i.f.sns_ad_float_jump_root));
        this.rR = ((TextView)this.contentView.findViewById(i.f.sns_ad_float_jump_title));
        this.JAz = ((ViewGroup)this.contentView.findViewById(i.f.sns_ad_float_jump_btn_container));
      }
      Object localObject = this.JAv;
      if ((localObject != null) && (((com.tencent.mm.plugin.sns.ad.landingpage.component.b.e)localObject).JBO != null))
      {
        localObject = ba.a(this.context, ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.e)localObject).JBO, this.JAz, 0);
        if ((localObject instanceof q))
        {
          this.JAA = ((q)localObject);
          this.JAA.KqV = true;
          this.JAz.removeAllViews();
          this.JAz.addView(((m)localObject).getView());
        }
      }
      if (this.JAy != null) {
        this.JAy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(249961);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingFloatJumpComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            try
            {
              Log.d("SnsAd.FloatJumpComp", "the root is clicked!");
              paramAnonymousView = e.this;
              paramAnonymousView.JAC += 1;
              e.this.yi(false);
              label64:
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingFloatJumpComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(249961);
              return;
            }
            catch (Throwable paramAnonymousView)
            {
              break label64;
            }
          }
        });
      }
      AppMethodBeat.o(205427);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(205427);
    }
  }
  
  public final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_floatjump;
  }
  
  final void yi(boolean paramBoolean)
  {
    AppMethodBeat.i(205432);
    if ((this.JAA != null) && (this.JAA.KqS != null))
    {
      this.JAA.KqU = paramBoolean;
      this.JAA.KqS.performClick();
    }
    AppMethodBeat.o(205432);
  }
  
  final class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(257974);
      try
      {
        int i = h.getIntExtra(paramIntent, "show", 0);
        int j = h.getIntExtra(paramIntent, "activity_code", 0);
        paramContext = e.this.context;
        if ((paramContext != null) && (j == paramContext.hashCode()))
        {
          if (i == 0)
          {
            e.this.contentView.setVisibility(0);
            AppMethodBeat.o(257974);
            return;
          }
          e.this.contentView.setVisibility(8);
          AppMethodBeat.o(257974);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(257974);
        return;
      }
      Log.w("SnsAd.FloatJumpComp", "the context is not same!!");
      AppMethodBeat.o(257974);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.e
 * JD-Core Version:    0.7.0.1
 */