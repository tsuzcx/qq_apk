package com.tencent.mm.plugin.newtips;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.a.c.h;
import com.tencent.mm.aw.d;
import com.tencent.mm.aw.q;
import com.tencent.mm.aw.r;
import com.tencent.mm.aw.r.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.u;
import java.lang.ref.WeakReference;

public class NormalIconNewTipPreference
  extends NormalIconPreference
  implements com.tencent.mm.plugin.newtips.a.a
{
  private Context context;
  private View fOB;
  private String path;
  public h wkP;
  private WeakReference<f> wrM;
  private String wrN;
  private r.a wrO;
  private a wrP;
  private r.a wrQ;
  public boolean wrR;
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127184);
    this.wrN = null;
    this.wrM = null;
    this.wrQ = new r.a()
    {
      public final void a(final String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(127183);
        if ((NormalIconNewTipPreference.a(NormalIconNewTipPreference.this)) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {}
        for (paramAnonymousBitmap = com.tencent.mm.sdk.platformtools.g.a(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() / 2);; paramAnonymousBitmap = com.tencent.mm.sdk.platformtools.g.a(paramAnonymousBitmap, false, 0.1F * paramAnonymousBitmap.getWidth()))
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(127182);
              StringBuilder localStringBuilder = new StringBuilder("download url ").append(paramAnonymousString1).append(" , result ");
              if (paramAnonymousBitmap == null) {}
              for (boolean bool = true;; bool = false)
              {
                ad.i("MicroMsg.NewTips.NormalIconNewTipPreference", bool);
                if (paramAnonymousString1.equals(NormalIconNewTipPreference.b(NormalIconNewTipPreference.this)))
                {
                  NormalIconNewTipPreference.this.aH(paramAnonymousBitmap);
                  NormalIconNewTipPreference.c(NormalIconNewTipPreference.this);
                  NormalIconNewTipPreference.this.notifyDataSetChanged();
                }
                AppMethodBeat.o(127182);
                return;
              }
            }
          });
          AppMethodBeat.o(127183);
          return;
        }
      }
    };
    this.wrR = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.NormalIconNewTipPreference, paramInt, 0);
    this.path = paramAttributeSet.getString(0);
    this.context = paramContext;
    paramAttributeSet.recycle();
    ad.i("MicroMsg.NewTips.NormalIconNewTipPreference", "NormalIconNewTipPreference() path:%s", new Object[] { this.path });
    AppMethodBeat.o(127184);
  }
  
  private void atd(String paramString)
  {
    AppMethodBeat.i(127196);
    int i = this.context.getResources().getDimensionPixelOffset(2131165965);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = b.arU();
    q.aIK();
    ((c.a)localObject).idJ = null;
    ((c.a)localObject).idr = true;
    ((c.a)localObject).hfi = true;
    ((c.a)localObject).idp = true;
    ((c.a)localObject).hdS = i;
    ((c.a)localObject).hdR = i;
    localObject = ((c.a)localObject).aJc();
    q.aIJ().a(paramString, fzB(), (c)localObject, this.wkP);
    AppMethodBeat.o(127196);
  }
  
  public final void a(r.a parama, a parama1)
  {
    this.wrO = parama;
    this.wrP = parama1;
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(127187);
    com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
    AppMethodBeat.o(127187);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(127197);
    this.wrM = new WeakReference(paramf);
    AppMethodBeat.o(127197);
  }
  
  public boolean a(boolean paramBoolean, dnc paramdnc)
  {
    AppMethodBeat.i(127191);
    ad.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointTitle() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      acn(8);
      acm(0);
      aU(paramdnc.title, -1, Color.parseColor("#8c8c8c"));
      xF(true);
      acq(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127191);
      return true;
      acn(8);
      acm(8);
      acq(8);
      acl(8);
    }
  }
  
  public boolean a(boolean paramBoolean1, dnc paramdnc, boolean paramBoolean2)
  {
    AppMethodBeat.i(214421);
    a(paramBoolean1, paramdnc);
    if (!paramBoolean2) {
      xF(false);
    }
    AppMethodBeat.o(214421);
    return true;
  }
  
  public final boolean b(boolean paramBoolean, dnc paramdnc)
  {
    AppMethodBeat.i(127192);
    ad.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      acn(8);
      acq(0);
      acp(0);
      acr(0);
      xF(false);
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231875);
      if (this.wrR) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131234853);
      }
      aH(localBitmap);
      if (this.wkP != null) {
        atd(paramdnc.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127192);
      return true;
      q.aIE();
      localBitmap = d.vT(paramdnc.url);
      if (this.wrO != null)
      {
        if (localBitmap != null)
        {
          if (this.wrP != null) {
            this.wrP.ate(null);
          }
          aH(localBitmap);
        }
        else
        {
          if (this.wrP != null) {
            this.wrP.ate(paramdnc.url);
          }
          q.aII().a(paramdnc.url, this.wrO);
        }
      }
      else
      {
        if (localBitmap != null)
        {
          this.wrN = null;
          if (this.wrR) {}
          for (paramdnc = com.tencent.mm.sdk.platformtools.g.a(localBitmap, false, localBitmap.getWidth() / 2);; paramdnc = com.tencent.mm.sdk.platformtools.g.a(localBitmap, false, 0.1F * localBitmap.getWidth()))
          {
            aH(paramdnc);
            break;
          }
        }
        q.aII().a(paramdnc.url, this.wrQ);
        this.wrN = paramdnc.url;
        continue;
        acn(8);
        acm(8);
        acq(8);
        acl(8);
      }
    }
  }
  
  public final boolean c(boolean paramBoolean, dnc paramdnc)
  {
    AppMethodBeat.i(127193);
    ad.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointPointTitleIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      acn(8);
      acq(0);
      acp(0);
      acr(0);
      acm(0);
      xF(false);
      aU(paramdnc.title, -1, Color.parseColor("#8c8c8c"));
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231875);
      if (this.wrR) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131234853);
      }
      aH(localBitmap);
      if (this.wkP != null) {
        atd(paramdnc.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127193);
      return true;
      q.aIE();
      localBitmap = d.vT(paramdnc.url);
      if (this.wrO != null)
      {
        if (localBitmap != null)
        {
          if (this.wrP != null) {
            this.wrP.ate(null);
          }
          aH(localBitmap);
        }
        else
        {
          q.aII().a(paramdnc.url, this.wrO);
          if (this.wrP != null) {
            this.wrP.ate(paramdnc.url);
          }
        }
      }
      else
      {
        if (localBitmap != null)
        {
          this.wrN = null;
          if (this.wrR) {}
          for (paramdnc = com.tencent.mm.sdk.platformtools.g.a(localBitmap, false, localBitmap.getWidth() / 2);; paramdnc = com.tencent.mm.sdk.platformtools.g.a(localBitmap, false, 0.1F * localBitmap.getWidth()))
          {
            aH(paramdnc);
            break;
          }
        }
        q.aII().a(paramdnc.url, this.wrQ);
        this.wrN = paramdnc.url;
        continue;
        acn(8);
        acm(8);
        acq(8);
        acl(8);
      }
    }
  }
  
  public final boolean d(boolean paramBoolean, dnc paramdnc)
  {
    AppMethodBeat.i(127194);
    ad.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showCounter() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      acl(0);
      String str = paramdnc.hgh;
      if (paramdnc.hgh > 99) {
        str = this.context.getString(2131764343);
      }
      gw(str, u.aP(this.mContext, paramdnc.hgh));
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127194);
      return true;
      acn(8);
      acm(8);
      acq(8);
      acl(8);
    }
  }
  
  public final boolean dkD()
  {
    return false;
  }
  
  public final String getPath()
  {
    return this.path;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(127186);
    if (this.fOB == null) {
      this.fOB = new View(this.context);
    }
    View localView = this.fOB;
    AppMethodBeat.o(127186);
    return localView;
  }
  
  protected final void notifyDataSetChanged()
  {
    AppMethodBeat.i(127195);
    if (this.wrM != null)
    {
      f localf = (f)this.wrM.get();
      if (localf != null) {
        localf.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(127195);
  }
  
  public final boolean ol(boolean paramBoolean)
  {
    AppMethodBeat.i(127188);
    paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
    AppMethodBeat.o(127188);
    return paramBoolean;
  }
  
  public boolean om(boolean paramBoolean)
  {
    AppMethodBeat.i(127189);
    ad.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPoint() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      acn(0);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127189);
      return true;
      acn(8);
      acm(8);
      acq(8);
      acl(8);
    }
  }
  
  public boolean on(boolean paramBoolean)
  {
    AppMethodBeat.i(127190);
    ad.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showNew() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      acl(0);
      gw(this.context.getString(2131755829), 2131233430);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127190);
      return true;
      acn(8);
      acm(8);
      acq(8);
      acl(8);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127185);
    paramViewGroup = super.onCreateView(paramViewGroup);
    if (this.fOB == null) {
      this.fOB = paramViewGroup;
    }
    AppMethodBeat.o(127185);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void ate(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NormalIconNewTipPreference
 * JD-Core Version:    0.7.0.1
 */