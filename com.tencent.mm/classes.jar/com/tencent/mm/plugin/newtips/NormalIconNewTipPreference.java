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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.o;
import com.tencent.mm.av.p;
import com.tencent.mm.av.p.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import java.lang.ref.WeakReference;

public class NormalIconNewTipPreference
  extends NormalIconPreference
  implements com.tencent.mm.plugin.newtips.a.a
{
  private Context context;
  private View fvu;
  private String path;
  public h vfu;
  private WeakReference<com.tencent.mm.ui.base.preference.f> vmu;
  private String vmv;
  private p.a vmw;
  private a vmx;
  private p.a vmy;
  public boolean vmz;
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127184);
    this.vmv = null;
    this.vmu = null;
    this.vmy = new p.a()
    {
      public final void a(final String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(127183);
        if ((NormalIconNewTipPreference.a(NormalIconNewTipPreference.this)) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {}
        for (paramAnonymousBitmap = com.tencent.mm.sdk.platformtools.f.a(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() / 2);; paramAnonymousBitmap = com.tencent.mm.sdk.platformtools.f.a(paramAnonymousBitmap, false, 0.1F * paramAnonymousBitmap.getWidth()))
        {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(127182);
              StringBuilder localStringBuilder = new StringBuilder("download url ").append(paramAnonymousString1).append(" , result ");
              if (paramAnonymousBitmap == null) {}
              for (boolean bool = true;; bool = false)
              {
                ac.i("MicroMsg.NewTips.NormalIconNewTipPreference", bool);
                if (paramAnonymousString1.equals(NormalIconNewTipPreference.b(NormalIconNewTipPreference.this)))
                {
                  NormalIconNewTipPreference.this.aF(paramAnonymousBitmap);
                  NormalIconNewTipPreference.c(NormalIconNewTipPreference.this);
                  NormalIconNewTipPreference.d(NormalIconNewTipPreference.this);
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
    this.vmz = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.NormalIconNewTipPreference, paramInt, 0);
    this.path = paramAttributeSet.getString(0);
    this.context = paramContext;
    paramAttributeSet.recycle();
    ac.i("MicroMsg.NewTips.NormalIconNewTipPreference", "NormalIconNewTipPreference() path:%s", new Object[] { this.path });
    AppMethodBeat.o(127184);
  }
  
  private void aoe(String paramString)
  {
    AppMethodBeat.i(127196);
    int i = this.context.getResources().getDimensionPixelOffset(2131165965);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = b.aph();
    o.aFC();
    ((c.a)localObject).hKO = null;
    ((c.a)localObject).hKx = true;
    ((c.a)localObject).gLt = true;
    ((c.a)localObject).hKv = true;
    ((c.a)localObject).gKh = i;
    ((c.a)localObject).gKg = i;
    localObject = ((c.a)localObject).aFT();
    o.aFB().a(paramString, fjm(), (com.tencent.mm.av.a.a.c)localObject, this.vfu);
    AppMethodBeat.o(127196);
  }
  
  private void notifyDataSetChanged()
  {
    AppMethodBeat.i(127195);
    if (this.vmu != null)
    {
      com.tencent.mm.ui.base.preference.f localf = (com.tencent.mm.ui.base.preference.f)this.vmu.get();
      if (localf != null) {
        localf.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(127195);
  }
  
  public final void a(p.a parama, a parama1)
  {
    this.vmw = parama;
    this.vmx = parama1;
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
    this.vmu = new WeakReference(paramf);
    AppMethodBeat.o(127197);
  }
  
  public final boolean a(dhn paramdhn, boolean paramBoolean)
  {
    AppMethodBeat.i(204962);
    a(true, paramdhn);
    if (!paramBoolean) {
      wU(false);
    }
    AppMethodBeat.o(204962);
    return true;
  }
  
  public final boolean a(boolean paramBoolean, dhn paramdhn)
  {
    AppMethodBeat.i(127191);
    ac.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointTitle() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      aad(8);
      aac(0);
      aQ(paramdhn.title, -1, Color.parseColor("#8c8c8c"));
      wU(true);
      aag(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127191);
      return true;
      aad(8);
      aac(8);
      aag(8);
      aab(8);
    }
  }
  
  public final boolean b(dhn paramdhn, boolean paramBoolean)
  {
    AppMethodBeat.i(204963);
    b(true, paramdhn);
    if (!paramBoolean) {
      aah(8);
    }
    AppMethodBeat.o(204963);
    return true;
  }
  
  public final boolean b(boolean paramBoolean, dhn paramdhn)
  {
    AppMethodBeat.i(127192);
    ac.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      aad(8);
      aag(0);
      aaf(0);
      aah(0);
      wU(false);
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231875);
      if (this.vmz) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131234853);
      }
      aF(localBitmap);
      if (this.vfu != null) {
        aoe(paramdhn.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127192);
      return true;
      o.aFw();
      localBitmap = com.tencent.mm.av.c.te(paramdhn.url);
      if (this.vmw != null)
      {
        if (localBitmap != null)
        {
          if (this.vmx != null) {
            this.vmx.aof(null);
          }
          aF(localBitmap);
        }
        else
        {
          if (this.vmx != null) {
            this.vmx.aof(paramdhn.url);
          }
          o.aFA().a(paramdhn.url, this.vmw);
        }
      }
      else
      {
        if (localBitmap != null)
        {
          this.vmv = null;
          if (this.vmz) {}
          for (paramdhn = com.tencent.mm.sdk.platformtools.f.a(localBitmap, false, localBitmap.getWidth() / 2);; paramdhn = com.tencent.mm.sdk.platformtools.f.a(localBitmap, false, 0.1F * localBitmap.getWidth()))
          {
            aF(paramdhn);
            break;
          }
        }
        o.aFA().a(paramdhn.url, this.vmy);
        this.vmv = paramdhn.url;
        continue;
        aad(8);
        aac(8);
        aag(8);
        aab(8);
      }
    }
  }
  
  public final boolean c(boolean paramBoolean, dhn paramdhn)
  {
    AppMethodBeat.i(127193);
    ac.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointPointTitleIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      aad(8);
      aag(0);
      aaf(0);
      aah(0);
      aac(0);
      wU(false);
      aQ(paramdhn.title, -1, Color.parseColor("#8c8c8c"));
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231875);
      if (this.vmz) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131234853);
      }
      aF(localBitmap);
      if (this.vfu != null) {
        aoe(paramdhn.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127193);
      return true;
      o.aFw();
      localBitmap = com.tencent.mm.av.c.te(paramdhn.url);
      if (this.vmw != null)
      {
        if (localBitmap != null)
        {
          if (this.vmx != null) {
            this.vmx.aof(null);
          }
          aF(localBitmap);
        }
        else
        {
          o.aFA().a(paramdhn.url, this.vmw);
          if (this.vmx != null) {
            this.vmx.aof(paramdhn.url);
          }
        }
      }
      else
      {
        if (localBitmap != null)
        {
          this.vmv = null;
          if (this.vmz) {}
          for (paramdhn = com.tencent.mm.sdk.platformtools.f.a(localBitmap, false, localBitmap.getWidth() / 2);; paramdhn = com.tencent.mm.sdk.platformtools.f.a(localBitmap, false, 0.1F * localBitmap.getWidth()))
          {
            aF(paramdhn);
            break;
          }
        }
        o.aFA().a(paramdhn.url, this.vmy);
        this.vmv = paramdhn.url;
        continue;
        aad(8);
        aac(8);
        aag(8);
        aab(8);
      }
    }
  }
  
  public final boolean d(boolean paramBoolean, dhn paramdhn)
  {
    AppMethodBeat.i(127194);
    ac.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showCounter() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      aab(0);
      String str = paramdhn.gMk;
      if (paramdhn.gMk > 99) {
        str = this.context.getString(2131764343);
      }
      fZ(str, u.aM(this.mContext, paramdhn.gMk));
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127194);
      return true;
      aad(8);
      aac(8);
      aag(8);
      aab(8);
    }
  }
  
  public final boolean dbk()
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
    if (this.fvu == null) {
      this.fvu = new View(this.context);
    }
    View localView = this.fvu;
    AppMethodBeat.o(127186);
    return localView;
  }
  
  public final boolean nR(boolean paramBoolean)
  {
    AppMethodBeat.i(127188);
    paramBoolean = g.a(paramBoolean, this);
    AppMethodBeat.o(127188);
    return paramBoolean;
  }
  
  public final boolean nS(boolean paramBoolean)
  {
    AppMethodBeat.i(127189);
    ac.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPoint() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      aad(0);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127189);
      return true;
      aad(8);
      aac(8);
      aag(8);
      aab(8);
    }
  }
  
  public final boolean nT(boolean paramBoolean)
  {
    AppMethodBeat.i(127190);
    ac.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showNew() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      aab(0);
      fZ(this.context.getString(2131755829), 2131233430);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127190);
      return true;
      aad(8);
      aac(8);
      aag(8);
      aab(8);
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127185);
    paramViewGroup = super.onCreateView(paramViewGroup);
    if (this.fvu == null) {
      this.fvu = paramViewGroup;
    }
    AppMethodBeat.o(127185);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void aof(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NormalIconNewTipPreference
 * JD-Core Version:    0.7.0.1
 */