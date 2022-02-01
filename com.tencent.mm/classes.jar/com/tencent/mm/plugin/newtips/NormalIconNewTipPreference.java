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
import com.tencent.mm.loader.i.b;
import com.tencent.mm.modelimage.e;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelimage.s;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.fng;
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
  public h LMw;
  private WeakReference<f> MrH;
  private String MrJ;
  private s.a MrK;
  private a MrL;
  private s.a MrM;
  public boolean MrN;
  private Context context;
  protected View lBX;
  private String path;
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalIconNewTipPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(127184);
    this.MrJ = null;
    this.MrH = null;
    this.MrM = new s.a()
    {
      public final void onLoadImageEnd(final String paramAnonymousString1, final Bitmap paramAnonymousBitmap, String paramAnonymousString2)
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
                  NormalIconNewTipPreference.this.bd(paramAnonymousBitmap);
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
    this.MrN = false;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.g.NormalIconNewTipPreference, paramInt, 0);
    this.path = paramAttributeSet.getString(b.g.NormalIconNewTipPreference_path);
    this.context = paramContext;
    paramAttributeSet.recycle();
    Log.i("MicroMsg.NewTips.NormalIconNewTipPreference", "NormalIconNewTipPreference() path:%s", new Object[] { this.path });
    AppMethodBeat.o(127184);
  }
  
  private void aPS(String paramString)
  {
    AppMethodBeat.i(127196);
    int i = this.context.getResources().getDimensionPixelOffset(b.a.card_entrance_icon_height);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = b.bmz();
    ((c.a)localObject).oKH = r.bKf();
    ((c.a)localObject).oKp = true;
    ((c.a)localObject).nrc = true;
    ((c.a)localObject).oKn = true;
    ((c.a)localObject).npV = i;
    ((c.a)localObject).npU = i;
    localObject = ((c.a)localObject).bKx();
    r.bKe().a(paramString, jnm(), (c)localObject, this.LMw);
    AppMethodBeat.o(127196);
  }
  
  public final void a(s.a parama, a parama1)
  {
    this.MrK = parama;
    this.MrL = parama1;
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
    this.MrH = new WeakReference(paramf);
    AppMethodBeat.o(127197);
  }
  
  public boolean a(boolean paramBoolean, fng paramfng)
  {
    AppMethodBeat.i(127191);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointTitle() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      aeD(8);
      aBf(0);
      bd(paramfng.title, -1, Color.parseColor("#8c8c8c"));
      LF(true);
      aBi(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127191);
      return true;
      aeD(8);
      aBf(8);
      aBi(8);
      afx(8);
    }
  }
  
  public final boolean b(boolean paramBoolean, fng paramfng)
  {
    AppMethodBeat.i(127192);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      aeD(8);
      aBi(0);
      aBh(0);
      aBj(0);
      LF(false);
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), b.b.default_avatar);
      if (this.MrN) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), b.b.default_round_avatar);
      }
      bd(localBitmap);
      if (this.LMw != null) {
        aPS(paramfng.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127192);
      return true;
      r.bJZ();
      localBitmap = e.Eo(paramfng.url);
      if (this.MrK != null)
      {
        if (localBitmap != null)
        {
          if (this.MrL != null) {
            this.MrL.aPT(null);
          }
          bd(localBitmap);
        }
        else
        {
          if (this.MrL != null) {
            this.MrL.aPT(paramfng.url);
          }
          r.bKd().a(paramfng.url, this.MrK);
        }
      }
      else
      {
        if (localBitmap != null)
        {
          this.MrJ = null;
          if (this.MrN) {}
          for (paramfng = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth() / 2);; paramfng = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, 0.1F * localBitmap.getWidth()))
          {
            bd(paramfng);
            break;
          }
        }
        r.bKd().a(paramfng.url, this.MrM);
        this.MrJ = paramfng.url;
        continue;
        aeD(8);
        aBf(8);
        aBi(8);
        afx(8);
      }
    }
  }
  
  public final boolean c(boolean paramBoolean, fng paramfng)
  {
    AppMethodBeat.i(127193);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPointPointTitleIcon() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap;
    if (paramBoolean)
    {
      aeD(8);
      aBi(0);
      aBh(0);
      aBj(0);
      aBf(0);
      LF(false);
      bd(paramfng.title, -1, Color.parseColor("#8c8c8c"));
      localBitmap = BitmapFactory.decodeResource(this.context.getResources(), b.b.default_avatar);
      if (this.MrN) {
        localBitmap = BitmapFactory.decodeResource(this.context.getResources(), b.b.default_round_avatar);
      }
      bd(localBitmap);
      if (this.LMw != null) {
        aPS(paramfng.url);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127193);
      return true;
      r.bJZ();
      localBitmap = e.Eo(paramfng.url);
      if (this.MrK != null)
      {
        if (localBitmap != null)
        {
          if (this.MrL != null) {
            this.MrL.aPT(null);
          }
          bd(localBitmap);
        }
        else
        {
          r.bKd().a(paramfng.url, this.MrK);
          if (this.MrL != null) {
            this.MrL.aPT(paramfng.url);
          }
        }
      }
      else
      {
        if (localBitmap != null)
        {
          this.MrJ = null;
          if (this.MrN) {}
          for (paramfng = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, localBitmap.getWidth() / 2);; paramfng = BitmapUtil.getRoundedCornerBitmap(localBitmap, false, 0.1F * localBitmap.getWidth()))
          {
            bd(paramfng);
            break;
          }
        }
        r.bKd().a(paramfng.url, this.MrM);
        this.MrJ = paramfng.url;
        continue;
        aeD(8);
        aBf(8);
        aBi(8);
        afx(8);
      }
    }
  }
  
  public boolean d(boolean paramBoolean, fng paramfng)
  {
    AppMethodBeat.i(127194);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showCounter() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      afx(0);
      String str = paramfng.num;
      if (paramfng.num > 99) {
        str = this.context.getString(b.f.tab_msg_tip_over);
      }
      gv(str, v.bC(this.mContext, paramfng.num));
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127194);
      return true;
      aeD(8);
      aBf(8);
      aBi(8);
      afx(8);
    }
  }
  
  public final boolean fZD()
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
    if (this.lBX == null) {
      this.lBX = new View(this.context);
    }
    View localView = this.lBX;
    AppMethodBeat.o(127186);
    return localView;
  }
  
  protected final void notifyDataSetChanged()
  {
    AppMethodBeat.i(127195);
    if (this.MrH != null)
    {
      f localf = (f)this.MrH.get();
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
    if (this.lBX == null) {
      this.lBX = paramViewGroup;
    }
    AppMethodBeat.o(127185);
    return paramViewGroup;
  }
  
  public final boolean ym(boolean paramBoolean)
  {
    AppMethodBeat.i(127188);
    paramBoolean = g.a(paramBoolean, this);
    AppMethodBeat.o(127188);
    return paramBoolean;
  }
  
  public boolean yn(boolean paramBoolean)
  {
    AppMethodBeat.i(127189);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showRedPoint() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      aeD(0);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127189);
      return true;
      aeD(8);
      aBf(8);
      aBi(8);
      afx(8);
    }
  }
  
  public boolean yo(boolean paramBoolean)
  {
    AppMethodBeat.i(127190);
    Log.d("MicroMsg.NewTips.NormalIconNewTipPreference", "showNew() show:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      afx(0);
      gv(this.context.getString(b.f.app_new), b.b.new_tips_bg);
    }
    for (;;)
    {
      notifyDataSetChanged();
      AppMethodBeat.o(127190);
      return true;
      aeD(8);
      aBf(8);
      aBi(8);
      afx(8);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aPT(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.newtips.NormalIconNewTipPreference
 * JD-Core Version:    0.7.0.1
 */