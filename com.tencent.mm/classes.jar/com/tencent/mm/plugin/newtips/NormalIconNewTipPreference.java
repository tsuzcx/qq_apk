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
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.ay.d;
import com.tencent.mm.ay.q;
import com.tencent.mm.ay.r;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.w;
import java.lang.ref.WeakReference;

public class NormalIconNewTipPreference
  extends NormalIconPreference
  implements com.tencent.mm.plugin.newtips.a.a
{
  public h FRB;
  private WeakReference<f> GvI;
  private String GvK;
  private r.a GvL;
  private a GvM;
  private r.a GvN;
  public boolean GvO;
  private Context context;
  protected View jac;
  private String path;
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127184);
    this.GvK = null;
    this.GvI = null;
    this.GvN = new r.a()
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
                  NormalIconNewTipPreference.this.aK(paramAnonymousBitmap);
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
    this.GvO = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.f.NormalIconNewTipPreference, paramInt, 0);
    this.path = paramAttributeSet.getString(b.f.NormalIconNewTipPreference_path);
    this.context = paramContext;
    paramAttributeSet.recycle();
    Log.i("MicroMsg.NewTips.NormalIconNewTipPreference", "NormalIconNewTipPreference() path:%s", new Object[] { this.path });
    AppMethodBeat.o(127184);
  }
  
  private void aST(String paramString)
  {
    AppMethodBeat.i(127196);
    int i = this.context.getResources().getDimensionPixelOffset(b.a.card_entrance_icon_height);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = b.aSL();
    q.bmm();
    ((c.a)localObject).lRV = null;
    ((c.a)localObject).lRD = true;
    ((c.a)localObject).kPz = true;
    ((c.a)localObject).lRB = true;
    ((c.a)localObject).kOg = i;
    ((c.a)localObject).kOf = i;
    localObject = ((c.a)localObject).bmL();
    q.bml().a(paramString, hKJ(), (c)localObject, this.FRB);
    AppMethodBeat.o(127196);
  }
  
  public final void a(r.a parama, a parama1)
  {
    this.GvL = parama;
    this.GvM = parama1;
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
    this.GvI = new WeakReference(paramf);
    AppMethodBeat.o(127197);
  }
  
  public boolean a(boolean paramBoolean, erx paramerx)
  {
    AppMethodBeat.i(127191);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointTitle() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      aak(8);
      auD(0);
      aU(paramerx.title, -1, Color.parseColor("#8c8c8c"));
      FT(true);
      auG(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127191);
      return true;
      aak(8);
      auD(8);
      auG(8);
      abe(8);
    }
  }
  
  public final boolean b(boolean paramBoolean, erx paramerx)
  {
    AppMethodBeat.i(127192);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      aak(8);
      auG(0);
      auF(0);
      auH(0);
      FT(false);
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), b.b.default_avatar);
      if (this.GvO) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), b.b.default_round_avatar);
      }
      aK(localBitmap);
      if (this.FRB != null) {
        aST(paramerx.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127192);
      return true;
      q.bmg();
      localBitmap = d.LI(paramerx.url);
      if (this.GvL != null)
      {
        if (localBitmap != null)
        {
          if (this.GvM != null) {
            this.GvM.aSU(null);
          }
          aK(localBitmap);
        }
        else
        {
          if (this.GvM != null) {
            this.GvM.aSU(paramerx.url);
          }
          q.bmk().a(paramerx.url, this.GvL);
        }
      }
      else
      {
        if (localBitmap != null)
        {
          this.GvK = null;
          if (this.GvO) {}
          for (paramerx = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth() / 2);; paramerx = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, 0.1F * localBitmap.getWidth()))
          {
            aK(paramerx);
            break;
          }
        }
        q.bmk().a(paramerx.url, this.GvN);
        this.GvK = paramerx.url;
        continue;
        aak(8);
        auD(8);
        auG(8);
        abe(8);
      }
    }
  }
  
  public final boolean c(boolean paramBoolean, erx paramerx)
  {
    AppMethodBeat.i(127193);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointPointTitleIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      aak(8);
      auG(0);
      auF(0);
      auH(0);
      auD(0);
      FT(false);
      aU(paramerx.title, -1, Color.parseColor("#8c8c8c"));
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), b.b.default_avatar);
      if (this.GvO) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), b.b.default_round_avatar);
      }
      aK(localBitmap);
      if (this.FRB != null) {
        aST(paramerx.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127193);
      return true;
      q.bmg();
      localBitmap = d.LI(paramerx.url);
      if (this.GvL != null)
      {
        if (localBitmap != null)
        {
          if (this.GvM != null) {
            this.GvM.aSU(null);
          }
          aK(localBitmap);
        }
        else
        {
          q.bmk().a(paramerx.url, this.GvL);
          if (this.GvM != null) {
            this.GvM.aSU(paramerx.url);
          }
        }
      }
      else
      {
        if (localBitmap != null)
        {
          this.GvK = null;
          if (this.GvO) {}
          for (paramerx = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth() / 2);; paramerx = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, 0.1F * localBitmap.getWidth()))
          {
            aK(paramerx);
            break;
          }
        }
        q.bmk().a(paramerx.url, this.GvN);
        this.GvK = paramerx.url;
        continue;
        aak(8);
        auD(8);
        auG(8);
        abe(8);
      }
    }
  }
  
  public boolean d(boolean paramBoolean, erx paramerx)
  {
    AppMethodBeat.i(127194);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showCounter() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      abe(0);
      String str = paramerx.num;
      if (paramerx.num > 99) {
        str = this.context.getString(b.e.tab_msg_tip_over);
      }
      fC(str, w.bj(this.mContext, paramerx.num));
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127194);
      return true;
      aak(8);
      auD(8);
      auG(8);
      abe(8);
    }
  }
  
  public final boolean eQW()
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
    if (this.jac == null) {
      this.jac = new View(this.context);
    }
    View localView = this.jac;
    AppMethodBeat.o(127186);
    return localView;
  }
  
  protected final void notifyDataSetChanged()
  {
    AppMethodBeat.i(127195);
    if (this.GvI != null)
    {
      f localf = (f)this.GvI.get();
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
    if (this.jac == null) {
      this.jac = paramViewGroup;
    }
    AppMethodBeat.o(127185);
    return paramViewGroup;
  }
  
  public final boolean tX(boolean paramBoolean)
  {
    AppMethodBeat.i(127188);
    paramBoolean = g.a(paramBoolean, this);
    AppMethodBeat.o(127188);
    return paramBoolean;
  }
  
  public boolean tY(boolean paramBoolean)
  {
    AppMethodBeat.i(127189);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPoint() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      aak(0);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127189);
      return true;
      aak(8);
      auD(8);
      auG(8);
      abe(8);
    }
  }
  
  public boolean tZ(boolean paramBoolean)
  {
    AppMethodBeat.i(127190);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showNew() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      abe(0);
      fC(this.context.getString(b.e.app_new), b.b.new_tips_bg);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127190);
      return true;
      aak(8);
      auD(8);
      auG(8);
      abe(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aSU(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NormalIconNewTipPreference
 * JD-Core Version:    0.7.0.1
 */