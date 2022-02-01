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
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.av.r.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.v;
import java.lang.ref.WeakReference;

public class NormalIconNewTipPreference
  extends NormalIconPreference
  implements com.tencent.mm.plugin.newtips.a.a
{
  private WeakReference<f> ACF;
  private String ACG;
  private r.a ACH;
  private a ACI;
  private r.a ACJ;
  public boolean ACK;
  public h Akx;
  private Context context;
  protected View gvQ;
  private String path;
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127184);
    this.ACG = null;
    this.ACF = null;
    this.ACJ = new r.a()
    {
      public final void a(final String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
      {
        AppMethodBeat.i(127183);
        if ((NormalIconNewTipPreference.a(NormalIconNewTipPreference.this)) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {}
        for (paramAnonymousBitmap = BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, paramAnonymousBitmap.getWidth() / 2);; paramAnonymousBitmap = BitmapUtil.getRoundedCornerBitmap(paramAnonymousBitmap, false, 0.1F * paramAnonymousBitmap.getWidth()))
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(127182);
              StringBuilder localStringBuilder = new StringBuilder("download url ").append(paramAnonymousString1).append(" , result ");
              if (paramAnonymousBitmap == null) {}
              for (boolean bool = true;; bool = false)
              {
                Log.i("MicroMsg.NewTips.NormalIconNewTipPreference", bool);
                if (paramAnonymousString1.equals(NormalIconNewTipPreference.b(NormalIconNewTipPreference.this)))
                {
                  NormalIconNewTipPreference.this.aL(paramAnonymousBitmap);
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
    this.ACK = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.NormalIconNewTipPreference, paramInt, 0);
    this.path = paramAttributeSet.getString(0);
    this.context = paramContext;
    paramAttributeSet.recycle();
    Log.i("MicroMsg.NewTips.NormalIconNewTipPreference", "NormalIconNewTipPreference() path:%s", new Object[] { this.path });
    AppMethodBeat.o(127184);
  }
  
  private void aIz(String paramString)
  {
    AppMethodBeat.i(127196);
    int i = this.context.getResources().getDimensionPixelOffset(2131165997);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = b.aKJ();
    q.bcW();
    ((c.a)localObject).jbw = null;
    ((c.a)localObject).jbf = true;
    ((c.a)localObject).iaT = true;
    ((c.a)localObject).jbd = true;
    ((c.a)localObject).hZA = i;
    ((c.a)localObject).hZz = i;
    localObject = ((c.a)localObject).bdv();
    q.bcV().a(paramString, gLG(), (c)localObject, this.Akx);
    AppMethodBeat.o(127196);
  }
  
  public final void a(r.a parama, a parama1)
  {
    this.ACH = parama;
    this.ACI = parama1;
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
    this.ACF = new WeakReference(paramf);
    AppMethodBeat.o(127197);
  }
  
  public boolean a(boolean paramBoolean, ehv paramehv)
  {
    AppMethodBeat.i(127191);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointTitle() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      alF(8);
      alE(0);
      aS(paramehv.title, -1, Color.parseColor("#8c8c8c"));
      BB(true);
      alI(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127191);
      return true;
      alF(8);
      alE(8);
      alI(8);
      alD(8);
    }
  }
  
  public final boolean b(boolean paramBoolean, ehv paramehv)
  {
    AppMethodBeat.i(127192);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      alF(8);
      alI(0);
      alH(0);
      alJ(0);
      BB(false);
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231957);
      if (this.ACK) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231966);
      }
      aL(localBitmap);
      if (this.Akx != null) {
        aIz(paramehv.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127192);
      return true;
      q.bcQ();
      localBitmap = d.EP(paramehv.url);
      if (this.ACH != null)
      {
        if (localBitmap != null)
        {
          if (this.ACI != null) {
            this.ACI.aIA(null);
          }
          aL(localBitmap);
        }
        else
        {
          if (this.ACI != null) {
            this.ACI.aIA(paramehv.url);
          }
          q.bcU().a(paramehv.url, this.ACH);
        }
      }
      else
      {
        if (localBitmap != null)
        {
          this.ACG = null;
          if (this.ACK) {}
          for (paramehv = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth() / 2);; paramehv = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, 0.1F * localBitmap.getWidth()))
          {
            aL(paramehv);
            break;
          }
        }
        q.bcU().a(paramehv.url, this.ACJ);
        this.ACG = paramehv.url;
        continue;
        alF(8);
        alE(8);
        alI(8);
        alD(8);
      }
    }
  }
  
  public final boolean c(boolean paramBoolean, ehv paramehv)
  {
    AppMethodBeat.i(127193);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointPointTitleIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      alF(8);
      alI(0);
      alH(0);
      alJ(0);
      alE(0);
      BB(false);
      aS(paramehv.title, -1, Color.parseColor("#8c8c8c"));
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231957);
      if (this.ACK) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), 2131231966);
      }
      aL(localBitmap);
      if (this.Akx != null) {
        aIz(paramehv.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127193);
      return true;
      q.bcQ();
      localBitmap = d.EP(paramehv.url);
      if (this.ACH != null)
      {
        if (localBitmap != null)
        {
          if (this.ACI != null) {
            this.ACI.aIA(null);
          }
          aL(localBitmap);
        }
        else
        {
          q.bcU().a(paramehv.url, this.ACH);
          if (this.ACI != null) {
            this.ACI.aIA(paramehv.url);
          }
        }
      }
      else
      {
        if (localBitmap != null)
        {
          this.ACG = null;
          if (this.ACK) {}
          for (paramehv = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth() / 2);; paramehv = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, 0.1F * localBitmap.getWidth()))
          {
            aL(paramehv);
            break;
          }
        }
        q.bcU().a(paramehv.url, this.ACJ);
        this.ACG = paramehv.url;
        continue;
        alF(8);
        alE(8);
        alI(8);
        alD(8);
      }
    }
  }
  
  public final boolean d(boolean paramBoolean, ehv paramehv)
  {
    AppMethodBeat.i(127194);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showCounter() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      alD(0);
      String str = paramehv.ibS;
      if (paramehv.ibS > 99) {
        str = this.context.getString(2131766602);
      }
      gY(str, v.aQ(this.mContext, paramehv.ibS));
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127194);
      return true;
      alF(8);
      alE(8);
      alI(8);
      alD(8);
    }
  }
  
  public final boolean ehp()
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
    if (this.gvQ == null) {
      this.gvQ = new View(this.context);
    }
    View localView = this.gvQ;
    AppMethodBeat.o(127186);
    return localView;
  }
  
  protected final void notifyDataSetChanged()
  {
    AppMethodBeat.i(127195);
    if (this.ACF != null)
    {
      f localf = (f)this.ACF.get();
      if (localf != null) {
        localf.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(127195);
  }
  
  public View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(127185);
    paramViewGroup = super.onCreateView(paramViewGroup);
    if (this.gvQ == null) {
      this.gvQ = paramViewGroup;
    }
    AppMethodBeat.o(127185);
    return paramViewGroup;
  }
  
  public final boolean qV(boolean paramBoolean)
  {
    AppMethodBeat.i(127188);
    paramBoolean = g.a(paramBoolean, this);
    AppMethodBeat.o(127188);
    return paramBoolean;
  }
  
  public boolean qW(boolean paramBoolean)
  {
    AppMethodBeat.i(127189);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPoint() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      alF(0);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127189);
      return true;
      alF(8);
      alE(8);
      alI(8);
      alD(8);
    }
  }
  
  public boolean qX(boolean paramBoolean)
  {
    AppMethodBeat.i(127190);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showNew() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      alD(0);
      gY(this.context.getString(2131755915), 2131234232);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127190);
      return true;
      alF(8);
      alE(8);
      alI(8);
      alD(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aIA(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NormalIconNewTipPreference
 * JD-Core Version:    0.7.0.1
 */