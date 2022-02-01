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
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.a.c.h;
import com.tencent.mm.aw.o;
import com.tencent.mm.aw.p;
import com.tencent.mm.aw.p.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import java.lang.ref.WeakReference;

public class NormalIconNewTipPreference
  extends NormalIconPreference
  implements com.tencent.mm.plugin.newtips.a.a
{
  private Context context;
  private View frN;
  private String path;
  public h tWJ;
  public boolean udA;
  private WeakReference<com.tencent.mm.ui.base.preference.f> udv;
  private String udw;
  private p.a udx;
  private a udy;
  private p.a udz;
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127184);
    this.udw = null;
    this.udv = null;
    this.udz = new p.a()
    {
      public final void a(final String paramAnonymousString1, Bitmap paramAnonymousBitmap, final String paramAnonymousString2)
      {
        AppMethodBeat.i(127183);
        paramAnonymousString2 = paramAnonymousBitmap;
        if (NormalIconNewTipPreference.a(NormalIconNewTipPreference.this))
        {
          paramAnonymousString2 = paramAnonymousBitmap;
          if (paramAnonymousBitmap != null)
          {
            paramAnonymousString2 = paramAnonymousBitmap;
            if (!paramAnonymousBitmap.isRecycled()) {
              paramAnonymousString2 = com.tencent.mm.sdk.platformtools.f.a(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() / 2);
            }
          }
        }
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(127182);
            StringBuilder localStringBuilder = new StringBuilder("download url ").append(paramAnonymousString1).append(" , result ");
            if (paramAnonymousString2 == null) {}
            for (boolean bool = true;; bool = false)
            {
              ad.i("MicroMsg.NewTips.NormalIconNewTipPreference", bool);
              if (paramAnonymousString1.equals(NormalIconNewTipPreference.b(NormalIconNewTipPreference.this)))
              {
                NormalIconNewTipPreference.this.aD(paramAnonymousString2);
                NormalIconNewTipPreference.c(NormalIconNewTipPreference.this);
                NormalIconNewTipPreference.d(NormalIconNewTipPreference.this);
              }
              AppMethodBeat.o(127182);
              return;
            }
          }
        });
        AppMethodBeat.o(127183);
      }
    };
    this.udA = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.NormalIconNewTipPreference, paramInt, 0);
    this.path = paramAttributeSet.getString(0);
    this.context = paramContext;
    paramAttributeSet.recycle();
    ad.i("MicroMsg.NewTips.NormalIconNewTipPreference", "NormalIconNewTipPreference() path:%s", new Object[] { this.path });
    AppMethodBeat.o(127184);
  }
  
  private void ajg(String paramString)
  {
    AppMethodBeat.i(127196);
    int i = this.context.getResources().getDimensionPixelOffset(2131165965);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = b.aih();
    o.ayK();
    ((c.a)localObject).hkl = null;
    ((c.a)localObject).hjU = true;
    ((c.a)localObject).gkG = true;
    ((c.a)localObject).hjS = true;
    ((c.a)localObject).gjw = i;
    ((c.a)localObject).gjv = i;
    localObject = ((c.a)localObject).azc();
    o.ayJ().a(paramString, eTA(), (com.tencent.mm.aw.a.a.c)localObject, this.tWJ);
    AppMethodBeat.o(127196);
  }
  
  private void notifyDataSetChanged()
  {
    AppMethodBeat.i(127195);
    if (this.udv != null)
    {
      com.tencent.mm.ui.base.preference.f localf = (com.tencent.mm.ui.base.preference.f)this.udv.get();
      if (localf != null) {
        localf.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(127195);
  }
  
  public final void a(p.a parama, a parama1)
  {
    this.udx = parama;
    this.udy = parama1;
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(127187);
    g.a(this, paramk, paramBoolean);
    AppMethodBeat.o(127187);
  }
  
  public final void a(com.tencent.mm.ui.base.preference.f paramf)
  {
    AppMethodBeat.i(127197);
    this.udv = new WeakReference(paramf);
    AppMethodBeat.o(127197);
  }
  
  public final boolean a(dcb paramdcb, boolean paramBoolean)
  {
    AppMethodBeat.i(202385);
    a(true, paramdcb);
    if (!paramBoolean) {
      vQ(false);
    }
    AppMethodBeat.o(202385);
    return true;
  }
  
  public final boolean a(boolean paramBoolean, dcb paramdcb)
  {
    AppMethodBeat.i(127191);
    ad.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointTitle() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      XS(8);
      XR(0);
      aN(paramdcb.title, -1, Color.parseColor("#8c8c8c"));
      vQ(true);
      XV(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127191);
      return true;
      XS(8);
      XR(8);
      XV(8);
      XQ(8);
    }
  }
  
  public final boolean b(boolean paramBoolean, dcb paramdcb)
  {
    AppMethodBeat.i(127192);
    ad.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      XS(8);
      XV(0);
      XU(0);
      XW(0);
      vQ(false);
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231875);
      if (this.udA) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131234850);
      }
      aD(localBitmap);
      if (this.tWJ != null) {
        ajg(paramdcb.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127192);
      return true;
      o.ayE();
      localBitmap = com.tencent.mm.aw.c.pT(paramdcb.url);
      if (this.udx != null)
      {
        if (localBitmap != null)
        {
          if (this.udy != null) {
            this.udy.ajh(null);
          }
          aD(localBitmap);
        }
        else
        {
          if (this.udy != null) {
            this.udy.ajh(paramdcb.url);
          }
          o.ayI().a(paramdcb.url, this.udx);
        }
      }
      else if (localBitmap != null)
      {
        this.udw = null;
        paramdcb = localBitmap;
        if (this.udA) {
          paramdcb = com.tencent.mm.sdk.platformtools.f.a(localBitmap, false, localBitmap.getWidth() / 2);
        }
        aD(paramdcb);
      }
      else
      {
        o.ayI().a(paramdcb.url, this.udz);
        this.udw = paramdcb.url;
        continue;
        XS(8);
        XR(8);
        XV(8);
        XQ(8);
      }
    }
  }
  
  public final boolean c(boolean paramBoolean, dcb paramdcb)
  {
    AppMethodBeat.i(127193);
    ad.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointPointTitleIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      XS(8);
      XV(0);
      XU(0);
      XW(0);
      XR(0);
      vQ(false);
      aN(paramdcb.title, -1, Color.parseColor("#8c8c8c"));
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231875);
      if (this.udA) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131234850);
      }
      aD(localBitmap);
      if (this.tWJ != null) {
        ajg(paramdcb.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127193);
      return true;
      o.ayE();
      localBitmap = com.tencent.mm.aw.c.pT(paramdcb.url);
      if (this.udx != null)
      {
        if (localBitmap != null)
        {
          if (this.udy != null) {
            this.udy.ajh(null);
          }
          aD(localBitmap);
        }
        else
        {
          o.ayI().a(paramdcb.url, this.udx);
          if (this.udy != null) {
            this.udy.ajh(paramdcb.url);
          }
        }
      }
      else if (localBitmap != null)
      {
        this.udw = null;
        paramdcb = localBitmap;
        if (this.udA) {
          paramdcb = com.tencent.mm.sdk.platformtools.f.a(localBitmap, false, localBitmap.getWidth() / 2);
        }
        aD(paramdcb);
      }
      else
      {
        o.ayI().a(paramdcb.url, this.udz);
        this.udw = paramdcb.url;
        continue;
        XS(8);
        XR(8);
        XV(8);
        XQ(8);
      }
    }
  }
  
  public final boolean cND()
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, dcb paramdcb)
  {
    AppMethodBeat.i(127194);
    ad.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showCounter() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      XQ(0);
      String str = paramdcb.glx;
      if (paramdcb.glx > 99) {
        str = this.context.getString(2131764343);
      }
      fV(str, u.aG(this.mContext, paramdcb.glx));
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127194);
      return true;
      XS(8);
      XR(8);
      XV(8);
      XQ(8);
    }
  }
  
  public final String getPath()
  {
    return this.path;
  }
  
  public final View getRoot()
  {
    AppMethodBeat.i(127186);
    if (this.frN == null) {
      this.frN = new View(this.context);
    }
    View localView = this.frN;
    AppMethodBeat.o(127186);
    return localView;
  }
  
  public final boolean mY(boolean paramBoolean)
  {
    AppMethodBeat.i(127188);
    paramBoolean = g.a(paramBoolean, this);
    AppMethodBeat.o(127188);
    return paramBoolean;
  }
  
  public final boolean mZ(boolean paramBoolean)
  {
    AppMethodBeat.i(127189);
    ad.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPoint() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      XS(0);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127189);
      return true;
      XS(8);
      XR(8);
      XV(8);
      XQ(8);
    }
  }
  
  public final boolean na(boolean paramBoolean)
  {
    AppMethodBeat.i(127190);
    ad.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showNew() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      XQ(0);
      fV(this.context.getString(2131755829), 2131233430);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127190);
      return true;
      XS(8);
      XR(8);
      XV(8);
      XQ(8);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127185);
    paramViewGroup = super.onCreateView(paramViewGroup);
    if (this.frN == null) {
      this.frN = paramViewGroup;
    }
    AppMethodBeat.o(127185);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void ajh(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NormalIconNewTipPreference
 * JD-Core Version:    0.7.0.1
 */