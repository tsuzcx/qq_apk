package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

public final class m
  extends r
{
  private static HashMap<Long, Long> PNJ;
  protected com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a.a QOM;
  protected a QON;
  private String QOO;
  private String QOP;
  private String QOQ;
  protected String QdA;
  protected w lKp;
  protected f vlk;
  
  static
  {
    AppMethodBeat.i(307171);
    PNJ = new HashMap();
    AppMethodBeat.o(307171);
  }
  
  public m(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a.a parama, ViewGroup paramViewGroup)
  {
    super(paramContext, parama, paramViewGroup);
    AppMethodBeat.i(307101);
    this.QdA = "0";
    this.QOM = parama;
    if (this.QOM.PMg != null) {
      this.QPl.mx("appointmentId", parama.PMg.PKZ);
    }
    for (;;)
    {
      this.QOO = this.QOM.PSc;
      this.QOP = this.QOM.QJR;
      this.QOQ = this.QOM.QJV;
      this.QON = new a(paramContext, this, this.QOM.PMg.PKZ);
      AppMethodBeat.o(307101);
      return;
      Log.e("ADAppointment.AdLandingPageAppointmentBtnComp", "appointmentInfo==null");
      this.QPl.mx("appointmentId", "");
    }
  }
  
  private void hjg()
  {
    AppMethodBeat.i(307111);
    if (this.QOM.PMg == null)
    {
      AppMethodBeat.o(307111);
      return;
    }
    Log.i("ADAppointment.AdLandingPageAppointmentBtnComp", "updateBtnUI, status=" + this.QdA);
    if (this.QPn != null) {
      this.QPn.setEnabled(true);
    }
    if ("0".equals(this.QdA))
    {
      this.QOM.PSc = this.QOO;
      this.QOM.QJR = this.QOP;
      this.QOM.QJV = this.QOQ;
    }
    for (;;)
    {
      super.hjs();
      if (!"1".equals(this.QdA)) {
        break;
      }
      this.QPn.setText(this.QOM.PMg.PLd);
      AppMethodBeat.o(307111);
      return;
      int i = (int)(Util.safeParseDouble("0.6") * 255.0D);
      String str;
      if (!TextUtils.isEmpty(this.QOO))
      {
        str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.QOO.substring(1) });
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).PSc = str;
      }
      if (!TextUtils.isEmpty(this.QOP))
      {
        str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.QOP.substring(1) });
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJR = str;
      }
      if (!TextUtils.isEmpty(this.QOQ))
      {
        str = String.format("#%02x%s", new Object[] { Integer.valueOf(i), this.QOQ.substring(1) });
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QJV = str;
      }
      if (("1000".equals(this.QdA)) && (this.QPn != null)) {
        this.QPn.setEnabled(false);
      }
    }
    if ("1000".equals(this.QdA)) {
      this.QPn.setText(this.QOM.PMg.PLj);
    }
    AppMethodBeat.o(307111);
  }
  
  private void q(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(307118);
    Log.i("ADAppointment.AdLandingPageAppointmentBtnComp", "sendAppointmentReq, opType=" + paramInt + ", id=" + paramLong + ", uxInfo=" + paramString);
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L))
    {
      AppMethodBeat.o(307118);
      return;
    }
    if (paramInt == 0) {
      showLoading();
    }
    for (;;)
    {
      AdLandingPagesProxy.getInstance().sendAppointmentReq(paramString, paramLong, paramInt, this.QON);
      AppMethodBeat.o(307118);
      return;
      if (paramInt == 1) {
        showLoading();
      }
    }
  }
  
  private void showLoading()
  {
    AppMethodBeat.i(307125);
    try
    {
      String str = this.context.getString(b.j.app_waiting);
      if (this.lKp == null) {
        this.lKp = w.a(this.context, str, true);
      }
      if (!this.lKp.isShowing()) {
        this.lKp.show();
      }
      AppMethodBeat.o(307125);
      return;
    }
    finally
    {
      Log.e("ADAppointment.AdLandingPageAppointmentBtnComp", "showLoading exp=" + localObject.toString());
      AppMethodBeat.o(307125);
    }
  }
  
  protected final void had()
  {
    AppMethodBeat.i(307181);
    super.had();
    if (this.QOM.PMg == null)
    {
      Log.e("ADAppointment.AdLandingPageAppointmentBtnComp", "fillItem,appointmentInfo==null");
      AppMethodBeat.o(307181);
      return;
    }
    long l2 = this.QOM.PMg.PKZ;
    ai localai = hjn();
    String str1 = localai.QLy;
    com.tencent.mm.plugin.sns.ad.d.a.um(l2);
    String str2 = com.tencent.mm.plugin.sns.ad.d.a.a(str1, this.QOM.PMg);
    Log.i("ADAppointment.AdLandingPageAppointmentBtnComp", "fillItem, snsId=" + str1 + ", cacheStatus=" + str2);
    this.QdA = str2;
    hjg();
    if (!"1000".equals(this.QdA)) {
      if (!PNJ.containsKey(Long.valueOf(l2))) {
        break label218;
      }
    }
    label218:
    for (long l1 = ((Long)PNJ.get(Long.valueOf(l2))).longValue();; l1 = 0L)
    {
      if ((l1 == 0L) || (System.currentTimeMillis() - l1 > 30000L))
      {
        q(localai.uxInfo, l2, 2);
        PNJ.put(Long.valueOf(l2), Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(307181);
      return;
    }
  }
  
  protected final void hiZ()
  {
    AppMethodBeat.i(307188);
    if (this.QOM.PMg == null)
    {
      AppMethodBeat.o(307188);
      return;
    }
    Log.i("ADAppointment.AdLandingPageAppointmentBtnComp", "onBtnClick, status=" + this.QdA);
    if ("0".equals(this.QdA))
    {
      q(hjn().uxInfo, this.QOM.PMg.PKZ, 0);
      this.QPl.bD("opType", 0L);
    }
    for (;;)
    {
      hja();
      AppMethodBeat.o(307188);
      return;
      if ("1".equals(this.QdA))
      {
        if (this.QOM.PMg != null)
        {
          this.vlk = new f(this.context, 1, false);
          this.vlk.Vtg = new u.g()
          {
            public final void onCreateMMMenu(s paramAnonymouss)
            {
              AppMethodBeat.i(307007);
              paramAnonymouss.a(1, m.this.context.getResources().getColor(b.c.red_text_color_selector), m.this.QOM.PMg.PLc);
              AppMethodBeat.o(307007);
            }
          };
          this.vlk.sRz = true;
          this.vlk.GAC = new u.i()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
            {
              AppMethodBeat.i(307003);
              if (paramAnonymousMenuItem != null) {}
              try
              {
                if (paramAnonymousMenuItem.getItemId() == 1)
                {
                  m.a(m.this, m.this.hjn().uxInfo, m.this.QOM.PMg.PKZ);
                  m.a(m.this);
                }
                if ((m.this.context instanceof SnsAdNativeLandingPagesUI)) {
                  ar.bs((SnsAdNativeLandingPagesUI)m.this.context);
                }
                AppMethodBeat.o(307003);
                return;
              }
              finally
              {
                Log.e("ADAppointment.AdLandingPageAppointmentBtnComp", "onMMMenuItemSelected exp=" + paramAnonymousMenuItem.toString());
                AppMethodBeat.o(307003);
              }
            }
          };
          this.vlk.dDn();
        }
        this.QPl.bD("opType", 1L);
      }
    }
  }
  
  protected final void hideLoading()
  {
    AppMethodBeat.i(307196);
    try
    {
      if ((this.lKp != null) && (this.lKp.isShowing())) {
        this.lKp.dismiss();
      }
      if ((this.context instanceof SnsAdNativeLandingPagesUI)) {
        ar.bs((SnsAdNativeLandingPagesUI)this.context);
      }
      AppMethodBeat.o(307196);
      return;
    }
    finally
    {
      Log.e("ADAppointment.AdLandingPageAppointmentBtnComp", "showLoading exp=" + localObject.toString());
      AppMethodBeat.o(307196);
    }
  }
  
  static final class a
    implements AdLandingPagesProxy.e
  {
    private long PNM;
    private WeakReference<m> QOS;
    private WeakReference<Context> mContextRef;
    
    public a(Context paramContext, m paramm, long paramLong)
    {
      AppMethodBeat.i(306898);
      this.mContextRef = new WeakReference(paramContext);
      this.QOS = new WeakReference(paramm);
      this.PNM = paramLong;
      AppMethodBeat.o(306898);
    }
    
    public final void h(final int paramInt1, final int paramInt2, final Object paramObject)
    {
      AppMethodBeat.i(306902);
      Log.i("ADAppointment.AdLandingPageAppointmentBtnComp", "onCallback, errType=" + paramInt1 + ", errCode=" + paramInt2 + ", data=" + paramObject);
      Context localContext = (Context)this.mContextRef.get();
      final m localm = (m)this.QOS.get();
      if (((localContext instanceof Activity)) && (((Activity)localContext).isFinishing()))
      {
        Log.w("ADAppointment.AdLandingPageAppointmentBtnComp", "onCallback, isFinishing return");
        AppMethodBeat.o(306902);
        return;
      }
      if (localm == null)
      {
        Log.w("ADAppointment.AdLandingPageAppointmentBtnComp", "onCallback, btnComp == null");
        AppMethodBeat.o(306902);
        return;
      }
      h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(306889);
          for (;;)
          {
            try
            {
              if ((paramInt1 != 0) || (paramInt2 != 0)) {
                break label230;
              }
              i = 1;
              localm.hideLoading();
              String str = "-1";
              int j = -1;
              if ((paramObject instanceof String))
              {
                JSONObject localJSONObject = new JSONObject((String)paramObject);
                str = localJSONObject.optString("status");
                j = localJSONObject.optInt("opType");
              }
              Log.i("ADAppointment.AdLandingPageAppointmentBtnComp", "onCallback, status=" + str + ", opType=" + j + ", appointmentId=" + m.a.a(m.a.this));
              if (i != 0)
              {
                if ((j == 0) && ("1".equals(str)))
                {
                  m.b(localm);
                  m.a(localm, str);
                  AppMethodBeat.o(306889);
                  return;
                }
                if ((j != 1) || (!"0".equals(str))) {
                  continue;
                }
                m.a(localm, j, true);
                continue;
              }
              m.a(localm, j, false);
            }
            finally
            {
              Log.e("ADAppointment.AdLandingPageAppointmentBtnComp", "onCallback exp=" + localObject.toString());
              AppMethodBeat.o(306889);
              return;
            }
            AppMethodBeat.o(306889);
            return;
            label230:
            int i = 0;
          }
        }
      });
      AppMethodBeat.o(306902);
    }
    
    public final void onCallback(Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
 * JD-Core Version:    0.7.0.1
 */