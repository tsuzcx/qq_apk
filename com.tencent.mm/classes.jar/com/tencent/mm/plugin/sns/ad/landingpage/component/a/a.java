package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ad.f.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends m
{
  private TextView Wf;
  int znA;
  int znB;
  int znC;
  int znD;
  boolean znE;
  com.tencent.mm.plugin.sns.ad.landingpage.component.b.a znt;
  private c<ug> znu;
  private c<ua> znv;
  ViewGroup znw;
  private ViewGroup znx;
  private q zny;
  private BroadcastReceiver znz;
  
  public a(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.b.a parama, ViewGroup paramViewGroup)
  {
    this(paramContext, parama, paramViewGroup, -1);
    AppMethodBeat.i(219023);
    int i = 0;
    if (parama != null) {
      i = parama.znI;
    }
    int j = i;
    if (i <= 0) {
      j = 130;
    }
    this.znD = com.tencent.mm.cb.a.fromDPToPix(this.context, j);
    AppMethodBeat.o(219023);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.b.a parama, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramContext, parama, paramViewGroup);
    this.znt = parama;
    this.znA = 0;
    this.znB = 0;
    this.znD = paramInt;
    this.znE = true;
  }
  
  public final boolean E(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(219030);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(219030);
      return false;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (aQ(localJSONObject))
      {
        localJSONObject.put("clickCount", this.znA);
        localJSONObject.put("autoJumpCount", this.znB);
        localJSONObject.put("swipeJumpCount", this.znC);
        paramJSONArray.put(localJSONObject);
        localJSONObject = new JSONObject();
        if ((this.zny != null) && (this.zny.aQ(localJSONObject))) {
          paramJSONArray.put(localJSONObject);
        }
        AppMethodBeat.o(219030);
        return true;
      }
    }
    catch (Throwable paramJSONArray)
    {
      AppMethodBeat.o(219030);
    }
    return false;
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(219024);
    try
    {
      if (this.znz == null)
      {
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.video_progressbar_change");
        this.znz = new a((byte)0);
        d.V(this.context).a(this.znz, (IntentFilter)localObject);
      }
      if (this.znu == null)
      {
        this.znu = new c()
        {
          private boolean dUN()
          {
            AppMethodBeat.i(219018);
            try
            {
              locala = a.this;
              ae.d("SnsAd.FloatJumpComp", "the SnsAdVideoBonusSceneEvent is received!");
              com.tencent.mm.plugin.sns.ad.landingpage.component.b.a locala1 = locala.znt;
              if ((locala1 != null) && (locala1.znH > 0))
              {
                if ((locala.znA > 0) || (locala.znB > 0)) {
                  break label105;
                }
                if (locala.znC <= 0) {
                  break label71;
                }
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                a locala;
                label71:
                ae.w("SnsAd.FloatJumpComp", "onEventCall called has wrong!");
                continue;
                int i = 1;
                if (i == 0) {}
              }
            }
            ae.d("SnsAd.FloatJumpComp", "the comp is clicked, or the auto jump is less than 0!");
            for (;;)
            {
              AppMethodBeat.o(219018);
              return true;
              i = 0;
              break;
              locala.znB += 1;
              locala.ro(true);
            }
          }
        };
        this.znu.alive();
      }
      if (this.znv == null)
      {
        this.znv = new c() {};
        this.znv.alive();
      }
      if (this.contentView != null)
      {
        this.znw = ((ViewGroup)this.contentView.findViewById(2131308211));
        this.Wf = ((TextView)this.contentView.findViewById(2131308212));
        this.znx = ((ViewGroup)this.contentView.findViewById(2131308210));
      }
      Object localObject = this.znt;
      if ((localObject != null) && (((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject).znJ != null))
      {
        localObject = av.a(this.context, ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject).znJ, this.znx, 0);
        if ((localObject instanceof q))
        {
          this.zny = ((q)localObject);
          this.zny.zVl = true;
          this.znx.removeAllViews();
          this.znx.addView(((m)localObject).getView());
        }
      }
      if (this.znw != null) {
        this.znw.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(219016);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingFloatJumpComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            try
            {
              ae.d("SnsAd.FloatJumpComp", "the root is clicked!");
              paramAnonymousView = a.this;
              paramAnonymousView.znA += 1;
              a.this.ro(false);
              label64:
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/comp/AdLandingFloatJumpComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(219016);
              return;
            }
            catch (Throwable paramAnonymousView)
            {
              break label64;
            }
          }
        });
      }
      AppMethodBeat.o(219024);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219024);
    }
  }
  
  public final void dUJ()
  {
    AppMethodBeat.i(219025);
    try
    {
      super.dUJ();
      TextView localTextView = this.Wf;
      com.tencent.mm.plugin.sns.ad.landingpage.component.b.a locala = this.znt;
      if ((localTextView != null) && (locala != null)) {
        localTextView.setText(locala.znG);
      }
      AppMethodBeat.o(219025);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219025);
    }
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(219026);
    try
    {
      super.dUK();
      if (this.zny != null) {
        this.zny.dUK();
      }
      AppMethodBeat.o(219026);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219026);
    }
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(219027);
    try
    {
      super.dUL();
      if (this.zny != null) {
        this.zny.dUL();
      }
      AppMethodBeat.o(219027);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219027);
    }
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(219028);
    try
    {
      super.dUM();
      if (this.zny != null) {
        this.zny.dUM();
      }
      if (this.znz != null)
      {
        d.V(this.context).unregisterReceiver(this.znz);
        this.znz = null;
      }
      if (this.znu != null)
      {
        this.znu.dead();
        this.znu = null;
      }
      if (this.znv != null)
      {
        this.znv.dead();
        this.znv = null;
      }
      AppMethodBeat.o(219028);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(219028);
    }
  }
  
  public final int getLayout()
  {
    return 2131496425;
  }
  
  final void ro(boolean paramBoolean)
  {
    AppMethodBeat.i(219029);
    if ((this.zny != null) && (this.zny.zVi != null))
    {
      this.zny.zVk = paramBoolean;
      this.zny.zVi.performClick();
    }
    AppMethodBeat.o(219029);
  }
  
  final class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(219022);
      try
      {
        int i = e.getIntExtra(paramIntent, "show", 0);
        int j = e.getIntExtra(paramIntent, "activity_code", 0);
        paramContext = a.this.context;
        if ((paramContext != null) && (j == paramContext.hashCode()))
        {
          if (i == 0)
          {
            a.this.contentView.setVisibility(0);
            AppMethodBeat.o(219022);
            return;
          }
          a.this.contentView.setVisibility(8);
          AppMethodBeat.o(219022);
          return;
        }
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(219022);
        return;
      }
      ae.w("SnsAd.FloatJumpComp", "the context is not same!!");
      AppMethodBeat.o(219022);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.a
 * JD-Core Version:    0.7.0.1
 */