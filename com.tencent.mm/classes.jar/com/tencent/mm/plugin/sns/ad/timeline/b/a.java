package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ja;
import com.tencent.mm.f.a.ja.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.e;
import java.lang.ref.WeakReference;
import org.xwalk.core.Log;

public final class a
{
  private static String JIQ;
  public ImageView Ewl;
  s JII;
  public AdClickActionInfo JIJ;
  a JIK;
  public TextView JIL;
  public TextView JIM;
  public TextView JIN;
  public TextView JIO;
  c.a JIP;
  public SnsInfo Jws;
  public ViewGroup mContainer;
  public View mContentView;
  public Context mContext;
  public e rZT;
  
  public a(Context paramContext, ViewGroup paramViewGroup, c.a parama)
  {
    this.mContext = paramContext;
    this.mContainer = paramViewGroup;
    this.JIP = parama;
  }
  
  public static String aeS(int paramInt)
  {
    AppMethodBeat.i(219266);
    if (JIQ == null) {
      JIQ = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    }
    if (JIQ == null) {
      JIQ = "";
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(219266);
      return "0";
    }
    if (paramInt <= 999)
    {
      AppMethodBeat.o(219266);
      return String.valueOf(paramInt);
    }
    if ((JIQ.equals("zh_CN")) || (JIQ.equals("zh_HK")) || (JIQ.equals("zh_TW")))
    {
      if (paramInt <= 9999)
      {
        AppMethodBeat.o(219266);
        return String.valueOf(paramInt);
      }
      if (paramInt <= 990000)
      {
        str = MMApplicationContext.getContext().getString(i.j.sns_number_10000, new Object[] { Double.valueOf(paramInt * 1.0F / 10000.0F - 0.05D) });
        AppMethodBeat.o(219266);
        return str;
      }
      str = MMApplicationContext.getContext().getString(i.j.sns_number_more_than_10000, new Object[] { Integer.valueOf(99) });
      AppMethodBeat.o(219266);
      return str;
    }
    if (paramInt <= 999000)
    {
      str = MMApplicationContext.getContext().getString(i.j.sns_number_10000_en, new Object[] { Double.valueOf(paramInt * 1.0F / 1000.0F - 0.05D) });
      AppMethodBeat.o(219266);
      return str;
    }
    String str = MMApplicationContext.getContext().getString(i.j.sns_number_more_than_10000_en, new Object[] { Integer.valueOf(999) });
    AppMethodBeat.o(219266);
    return str;
  }
  
  public static final class a
    extends IListener<ja>
  {
    WeakReference<a> JIS;
    
    public a(a parama)
    {
      AppMethodBeat.i(201618);
      this.JIS = new WeakReference(parama);
      this.__eventId = ja.class.getName().hashCode();
      AppMethodBeat.o(201618);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.a
 * JD-Core Version:    0.7.0.1
 */