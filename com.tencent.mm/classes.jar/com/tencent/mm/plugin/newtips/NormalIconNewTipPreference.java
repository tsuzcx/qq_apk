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
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.av.r.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
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
  private View fQH;
  private String path;
  public com.tencent.mm.av.a.c.h wAy;
  public boolean wHA;
  private WeakReference<f> wHv;
  private String wHw;
  private r.a wHx;
  private a wHy;
  private r.a wHz;
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127184);
    this.wHw = null;
    this.wHv = null;
    this.wHz = new r.a()
    {
      public final void a(final String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(127183);
        if ((NormalIconNewTipPreference.a(NormalIconNewTipPreference.this)) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {}
        for (paramAnonymousBitmap = com.tencent.mm.sdk.platformtools.h.a(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() / 2);; paramAnonymousBitmap = com.tencent.mm.sdk.platformtools.h.a(paramAnonymousBitmap, false, 0.1F * paramAnonymousBitmap.getWidth()))
        {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(127182);
              StringBuilder localStringBuilder = new StringBuilder("download url ").append(paramAnonymousString1).append(" , result ");
              if (paramAnonymousBitmap == null) {}
              for (boolean bool = true;; bool = false)
              {
                ae.i("MicroMsg.NewTips.NormalIconNewTipPreference", bool);
                if (paramAnonymousString1.equals(NormalIconNewTipPreference.b(NormalIconNewTipPreference.this)))
                {
                  NormalIconNewTipPreference.this.aI(paramAnonymousBitmap);
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
    this.wHA = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.NormalIconNewTipPreference, paramInt, 0);
    this.path = paramAttributeSet.getString(0);
    this.context = paramContext;
    paramAttributeSet.recycle();
    ae.i("MicroMsg.NewTips.NormalIconNewTipPreference", "NormalIconNewTipPreference() path:%s", new Object[] { this.path });
    AppMethodBeat.o(127184);
  }
  
  private void auq(String paramString)
  {
    AppMethodBeat.i(127196);
    int i = this.context.getResources().getDimensionPixelOffset(2131165965);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = b.asj();
    q.aJc();
    ((c.a)localObject).igB = null;
    ((c.a)localObject).igk = true;
    ((c.a)localObject).hhW = true;
    ((c.a)localObject).igi = true;
    ((c.a)localObject).hgG = i;
    ((c.a)localObject).hgF = i;
    localObject = ((c.a)localObject).aJu();
    q.aJb().a(paramString, fDD(), (c)localObject, this.wAy);
    AppMethodBeat.o(127196);
  }
  
  public final void a(r.a parama, a parama1)
  {
    this.wHx = parama;
    this.wHy = parama1;
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(127187);
    g.a(this, paramk, paramBoolean);
    AppMethodBeat.o(127187);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(127197);
    this.wHv = new WeakReference(paramf);
    AppMethodBeat.o(127197);
  }
  
  public boolean a(boolean paramBoolean, dnz paramdnz)
  {
    AppMethodBeat.i(127191);
    ae.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointTitle() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      acU(8);
      acT(0);
      aX(paramdnz.title, -1, Color.parseColor("#8c8c8c"));
      xM(true);
      acX(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127191);
      return true;
      acU(8);
      acT(8);
      acX(8);
      acS(8);
    }
  }
  
  public boolean a(boolean paramBoolean1, dnz paramdnz, boolean paramBoolean2)
  {
    AppMethodBeat.i(200588);
    a(paramBoolean1, paramdnz);
    if (!paramBoolean2) {
      xM(false);
    }
    AppMethodBeat.o(200588);
    return true;
  }
  
  public final boolean b(boolean paramBoolean, dnz paramdnz)
  {
    AppMethodBeat.i(127192);
    ae.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      acU(8);
      acX(0);
      acW(0);
      acY(0);
      xM(false);
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231875);
      if (this.wHA) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131234853);
      }
      aI(localBitmap);
      if (this.wAy != null) {
        auq(paramdnz.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127192);
      return true;
      q.aIW();
      localBitmap = d.wA(paramdnz.url);
      if (this.wHx != null)
      {
        if (localBitmap != null)
        {
          if (this.wHy != null) {
            this.wHy.aur(null);
          }
          aI(localBitmap);
        }
        else
        {
          if (this.wHy != null) {
            this.wHy.aur(paramdnz.url);
          }
          q.aJa().a(paramdnz.url, this.wHx);
        }
      }
      else
      {
        if (localBitmap != null)
        {
          this.wHw = null;
          if (this.wHA) {}
          for (paramdnz = com.tencent.mm.sdk.platformtools.h.a(localBitmap, false, localBitmap.getWidth() / 2);; paramdnz = com.tencent.mm.sdk.platformtools.h.a(localBitmap, false, 0.1F * localBitmap.getWidth()))
          {
            aI(paramdnz);
            break;
          }
        }
        q.aJa().a(paramdnz.url, this.wHz);
        this.wHw = paramdnz.url;
        continue;
        acU(8);
        acT(8);
        acX(8);
        acS(8);
      }
    }
  }
  
  public final boolean c(boolean paramBoolean, dnz paramdnz)
  {
    AppMethodBeat.i(127193);
    ae.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointPointTitleIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      acU(8);
      acX(0);
      acW(0);
      acY(0);
      acT(0);
      xM(false);
      aX(paramdnz.title, -1, Color.parseColor("#8c8c8c"));
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231875);
      if (this.wHA) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131234853);
      }
      aI(localBitmap);
      if (this.wAy != null) {
        auq(paramdnz.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127193);
      return true;
      q.aIW();
      localBitmap = d.wA(paramdnz.url);
      if (this.wHx != null)
      {
        if (localBitmap != null)
        {
          if (this.wHy != null) {
            this.wHy.aur(null);
          }
          aI(localBitmap);
        }
        else
        {
          q.aJa().a(paramdnz.url, this.wHx);
          if (this.wHy != null) {
            this.wHy.aur(paramdnz.url);
          }
        }
      }
      else
      {
        if (localBitmap != null)
        {
          this.wHw = null;
          if (this.wHA) {}
          for (paramdnz = com.tencent.mm.sdk.platformtools.h.a(localBitmap, false, localBitmap.getWidth() / 2);; paramdnz = com.tencent.mm.sdk.platformtools.h.a(localBitmap, false, 0.1F * localBitmap.getWidth()))
          {
            aI(paramdnz);
            break;
          }
        }
        q.aJa().a(paramdnz.url, this.wHz);
        this.wHw = paramdnz.url;
        continue;
        acU(8);
        acT(8);
        acX(8);
        acS(8);
      }
    }
  }
  
  public final boolean d(boolean paramBoolean, dnz paramdnz)
  {
    AppMethodBeat.i(127194);
    ae.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showCounter() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      acS(0);
      String str = paramdnz.hiV;
      if (paramdnz.hiV > 99) {
        str = this.context.getString(2131764343);
      }
      gF(str, u.aP(this.mContext, paramdnz.hiV));
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127194);
      return true;
      acU(8);
      acT(8);
      acX(8);
      acS(8);
    }
  }
  
  public final boolean dnD()
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
    if (this.fQH == null) {
      this.fQH = new View(this.context);
    }
    View localView = this.fQH;
    AppMethodBeat.o(127186);
    return localView;
  }
  
  protected final void notifyDataSetChanged()
  {
    AppMethodBeat.i(127195);
    if (this.wHv != null)
    {
      f localf = (f)this.wHv.get();
      if (localf != null) {
        localf.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(127195);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127185);
    paramViewGroup = super.onCreateView(paramViewGroup);
    if (this.fQH == null) {
      this.fQH = paramViewGroup;
    }
    AppMethodBeat.o(127185);
    return paramViewGroup;
  }
  
  public final boolean oq(boolean paramBoolean)
  {
    AppMethodBeat.i(127188);
    paramBoolean = g.a(paramBoolean, this);
    AppMethodBeat.o(127188);
    return paramBoolean;
  }
  
  public boolean or(boolean paramBoolean)
  {
    AppMethodBeat.i(127189);
    ae.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPoint() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      acU(0);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127189);
      return true;
      acU(8);
      acT(8);
      acX(8);
      acS(8);
    }
  }
  
  public boolean os(boolean paramBoolean)
  {
    AppMethodBeat.i(127190);
    ae.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showNew() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      acS(0);
      gF(this.context.getString(2131755829), 2131233430);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127190);
      return true;
      acU(8);
      acT(8);
      acX(8);
      acS(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aur(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NormalIconNewTipPreference
 * JD-Core Version:    0.7.0.1
 */