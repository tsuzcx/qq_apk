package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.net.http.SslError;
import android.util.Base64;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import java.lang.reflect.Field;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@JgClassChecked(author=20, fComment="checked", lastDate="20141210", reviewer=20, vComment={com.jg.EType.HTTPSCHECK})
public final class c
{
  WebView Ckf;
  Map<String, List<r>> CvB;
  Map<String, Boolean> CvC;
  Context context;
  private d jaW;
  private List<String> lxs;
  private KeyStore lxt;
  private final SimpleDateFormat wiM;
  
  public c(Context paramContext, WebView paramWebView)
  {
    AppMethodBeat.i(79605);
    this.jaW = null;
    this.lxs = null;
    this.lxt = null;
    this.wiM = new SimpleDateFormat("yyyy-MM-dd HH:mmZ", Locale.getDefault());
    this.context = paramContext;
    this.Ckf = paramWebView;
    this.CvB = new HashMap();
    this.CvC = new HashMap();
    AppMethodBeat.o(79605);
  }
  
  @TargetApi(8)
  private void a(String paramString, SslError paramSslError)
  {
    AppMethodBeat.i(79609);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("1");
    localStringBuilder.append(",");
    localStringBuilder.append(b(paramString, paramSslError));
    paramString = localStringBuilder.toString();
    ac.i("MicroMsg.WebView.MMSslErrorHandler", "reportWebViewSslError, value = %s", new Object[] { paramString });
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(11098, paramString);
    AppMethodBeat.o(79609);
  }
  
  @TargetApi(14)
  private String b(String paramString, SslError paramSslError)
  {
    AppMethodBeat.i(79610);
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<sslerror>");
      localStringBuilder.append("<primaryerror>");
      Object localObject;
      if (paramSslError == null)
      {
        localObject = "-1";
        localStringBuilder.append(localObject);
        localStringBuilder.append("</primaryerror>");
        localStringBuilder.append("<clienttime>");
        localStringBuilder.append(Base64.encodeToString(this.wiM.format(new Date()).getBytes(), 0));
        localStringBuilder.append("</clienttime>");
        localStringBuilder.append("<currenturl>");
        if (!bs.isNullOrNil(paramString)) {
          localStringBuilder.append(bs.aLw(paramString));
        }
        localStringBuilder.append("</currenturl>");
        if (paramSslError != null) {
          break label346;
        }
      }
      label346:
      for (paramString = null;; paramString = paramSslError.getCertificate())
      {
        if (paramString != null)
        {
          paramSslError = paramString.getIssuedBy();
          if (paramSslError != null)
          {
            localStringBuilder.append("<issuedby>");
            if (paramSslError.getDName() != null) {
              localStringBuilder.append(Base64.encodeToString(paramSslError.getDName().getBytes(), 0));
            }
            localStringBuilder.append("</issuedby>");
          }
          paramSslError = paramString.getIssuedTo();
          if (paramSslError != null)
          {
            localStringBuilder.append("<issuedto>");
            if (paramSslError.getDName() != null) {
              localStringBuilder.append(Base64.encodeToString(paramSslError.getDName().getBytes(), 0));
            }
            localStringBuilder.append("</issuedto>");
          }
          paramSslError = paramString.getValidNotAfter();
          if (paramSslError != null)
          {
            localStringBuilder.append("<getvalidnotafter>");
            localStringBuilder.append(Base64.encodeToString(paramSslError.getBytes(), 0));
            localStringBuilder.append("</getvalidnotafter>");
          }
          paramString = paramString.getValidNotBefore();
          if (paramString != null)
          {
            localStringBuilder.append("<getvalidnotbefore>");
            localStringBuilder.append(Base64.encodeToString(paramString.getBytes(), 0));
            localStringBuilder.append("</getvalidnotbefore>");
          }
        }
        localStringBuilder.append("</sslerror>");
        paramString = localStringBuilder.toString();
        AppMethodBeat.o(79610);
        return paramString;
        localObject = Integer.valueOf(paramSslError.getPrimaryError());
        break;
      }
      return "";
    }
    catch (Exception paramString)
    {
      ac.w("MicroMsg.WebView.MMSslErrorHandler", "buildXml ex = %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(79610);
    }
  }
  
  private boolean b(SslCertificate paramSslCertificate)
  {
    AppMethodBeat.i(79606);
    if (paramSslCertificate == null)
    {
      ac.i("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates sslCertificate is null");
      AppMethodBeat.o(79606);
      return false;
    }
    ac.i("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates dnName = %s", new Object[] { paramSslCertificate.getIssuedBy().getDName() });
    Object localObject2;
    boolean bool;
    try
    {
      localObject1 = paramSslCertificate.getClass().getDeclaredField("mX509Certificate");
      ((Field)localObject1).setAccessible(true);
      paramSslCertificate = (X509Certificate)((Field)localObject1).get(paramSslCertificate);
      if (this.lxt == null)
      {
        this.lxt = KeyStore.getInstance("AndroidCAStore");
        this.lxt.load(null, null);
      }
      if (this.lxs != null) {
        break label201;
      }
      this.lxs = new ArrayList();
      localObject1 = this.lxt.aliases();
      while (((Enumeration)localObject1).hasMoreElements())
      {
        localObject2 = (String)((Enumeration)localObject1).nextElement();
        if ((localObject2 != null) && (((String)localObject2).startsWith("user:"))) {
          this.lxs.add(localObject2);
        }
      }
      AppMethodBeat.o(79606);
    }
    catch (Exception paramSslCertificate)
    {
      ac.e("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates ex %s", new Object[] { paramSslCertificate.getMessage() });
      bool = false;
    }
    return bool;
    label201:
    Object localObject1 = this.lxs.iterator();
    for (;;)
    {
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = (X509Certificate)this.lxt.getCertificate((String)localObject2);
        }
        try
        {
          paramSslCertificate.verify(((X509Certificate)localObject2).getPublicKey());
          bool = true;
        }
        catch (Exception localException) {}
      }
      bool = false;
      break;
    }
  }
  
  public final void a(final String paramString, r paramr, SslError paramSslError)
  {
    AppMethodBeat.i(79607);
    ac.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, currentUrl = %s", new Object[] { paramString });
    if (this.Ckf == null)
    {
      ac.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError fail, has been detached");
      AppMethodBeat.o(79607);
      return;
    }
    if (bs.isNullOrNil(paramString))
    {
      paramr.cancel();
      AppMethodBeat.o(79607);
      return;
    }
    Boolean localBoolean = (Boolean)this.CvC.get(paramString);
    if (localBoolean != null)
    {
      ac.v("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, already selected = %b", new Object[] { localBoolean });
      if (localBoolean.booleanValue())
      {
        paramr.proceed();
        AppMethodBeat.o(79607);
        return;
      }
      paramr.cancel();
      AppMethodBeat.o(79607);
      return;
    }
    URL localURL;
    try
    {
      int i = ((b)g.ab(b.class)).a(b.a.pPB, 1);
      ac.i("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError skipUserCert = %d", new Object[] { Integer.valueOf(i) });
      if ((i == 1) && (b(paramSslError.getCertificate())))
      {
        ac.i("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError use user certificatess");
        this.CvC.put(paramString, Boolean.TRUE);
        paramr.proceed();
        AppMethodBeat.o(79607);
        return;
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError : " + localException.getLocalizedMessage());
      List localList;
      try
      {
        localURL = new URL(paramString);
        if ((((b)g.ab(b.class)).a(b.a.pPA, 0) != 1) || (!localURL.getHost().endsWith(".qq.com"))) {
          break label533;
        }
        localList = (List)this.CvB.get(paramString);
        if ((localList == null) || (localList.size() == 0))
        {
          a(paramString, paramSslError);
          paramSslError = new ArrayList();
          paramSslError.add(paramr);
          this.CvB.put(paramString, paramSslError);
          if ((this.jaW != null) && (this.jaW.isShowing()))
          {
            paramr.cancel();
            AppMethodBeat.o(79607);
            return;
          }
          this.jaW = com.tencent.mm.ui.base.h.a(this.context, false, this.context.getString(2131766245, new Object[] { localURL.getHost() }), this.context.getString(2131766246), this.context.getString(2131755700), this.context.getString(2131755281), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(79603);
              paramAnonymousDialogInterface = (List)c.this.CvB.get(paramString);
              if (paramAnonymousDialogInterface == null)
              {
                ac.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list should not be null");
                AppMethodBeat.o(79603);
                return;
              }
              c.this.CvC.put(paramString, Boolean.FALSE);
              ac.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list size = %d", new Object[] { Integer.valueOf(paramAnonymousDialogInterface.size()) });
              Iterator localIterator = paramAnonymousDialogInterface.iterator();
              while (localIterator.hasNext()) {
                ((r)localIterator.next()).cancel();
              }
              paramAnonymousDialogInterface.clear();
              c.this.Ckf.clearSslPreferences();
              new a();
              a.h((Activity)c.this.context, paramString);
              AppMethodBeat.o(79603);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(79604);
              paramAnonymousDialogInterface = (List)c.this.CvB.get(paramString);
              if (paramAnonymousDialogInterface == null)
              {
                ac.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list should not be null");
                AppMethodBeat.o(79604);
                return;
              }
              c.this.CvC.put(paramString, Boolean.FALSE);
              ac.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list size = %d", new Object[] { Integer.valueOf(paramAnonymousDialogInterface.size()) });
              Iterator localIterator = paramAnonymousDialogInterface.iterator();
              while (localIterator.hasNext()) {
                ((r)localIterator.next()).cancel();
              }
              paramAnonymousDialogInterface.clear();
              c.this.Ckf.clearSslPreferences();
              AppMethodBeat.o(79604);
            }
          });
          AppMethodBeat.o(79607);
          return;
        }
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.WebView.MMSslErrorHandler", "create url fail : " + paramString.getLocalizedMessage());
        AppMethodBeat.o(79607);
        return;
      }
      localList.add(paramr);
      AppMethodBeat.o(79607);
      return;
    }
    label533:
    ac.d("MicroMsg.WebView.MMSslErrorHandler", "host = " + localURL.getHost() + ", but it not end with '.qq.com'");
    paramr.cancel();
    AppMethodBeat.o(79607);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(79608);
    ac.i("MicroMsg.WebView.MMSslErrorHandler", "detach");
    this.context = null;
    this.Ckf = null;
    this.CvB.clear();
    this.CvC.clear();
    AppMethodBeat.o(79608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */