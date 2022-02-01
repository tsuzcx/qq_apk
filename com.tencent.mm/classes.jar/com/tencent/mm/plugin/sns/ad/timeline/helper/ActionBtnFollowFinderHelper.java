package com.tencent.mm.plugin.sns.ad.timeline.helper;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kb;
import com.tencent.mm.autogen.a.kb.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.a;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.lang.ref.WeakReference;
import org.xwalk.core.Log;

public final class ActionBtnFollowFinderHelper
{
  private static String PZS;
  public ImageView KoU;
  public SnsInfo PJQ;
  w PZK;
  public AdClickActionInfo PZL;
  FollowUserEventListener PZM;
  public TextView PZN;
  public TextView PZO;
  public TextView PZP;
  public TextView PZQ;
  c.a PZR;
  public ViewGroup mContainer;
  public View mContentView;
  public Context mContext;
  public com.tencent.mm.ui.widget.a.f vlk;
  
  public ActionBtnFollowFinderHelper(Context paramContext, ViewGroup paramViewGroup, c.a parama)
  {
    this.mContext = paramContext;
    this.mContainer = paramViewGroup;
    this.PZR = parama;
  }
  
  public static String ajA(int paramInt)
  {
    AppMethodBeat.i(311076);
    if (PZS == null) {
      PZS = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    }
    if (PZS == null) {
      PZS = "";
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(311076);
      return "0";
    }
    if (paramInt <= 999)
    {
      AppMethodBeat.o(311076);
      return String.valueOf(paramInt);
    }
    if ((PZS.equals("zh_CN")) || (PZS.equals("zh_HK")) || (PZS.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(311076);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 990000)
      {
        str = MMApplicationContext.getContext().getString(b.j.sns_number_10000, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F - 0.05D) });
        AppMethodBeat.o(311076);
        return str;
      }
      str = MMApplicationContext.getContext().getString(b.j.sns_number_more_than_10000, new Object[] { Integer.valueOf(99) });
      AppMethodBeat.o(311076);
      return str;
    }
    if (paramInt <= 999000)
    {
      str = MMApplicationContext.getContext().getString(b.j.sns_number_10000_en, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(311076);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(b.j.sns_number_more_than_10000_en, new Object[] { Integer.valueOf(999) });
    AppMethodBeat.o(311076);
    return str;
  }
  
  public static class FollowUserEventListener
    extends IListener<kb>
  {
    WeakReference<ActionBtnFollowFinderHelper> PZU;
    
    public FollowUserEventListener(ActionBtnFollowFinderHelper paramActionBtnFollowFinderHelper)
    {
      super();
      AppMethodBeat.i(311129);
      this.PZU = new WeakReference(paramActionBtnFollowFinderHelper);
      this.__eventId = kb.class.getName().hashCode();
      AppMethodBeat.o(311129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.ActionBtnFollowFinderHelper
 * JD-Core Version:    0.7.0.1
 */