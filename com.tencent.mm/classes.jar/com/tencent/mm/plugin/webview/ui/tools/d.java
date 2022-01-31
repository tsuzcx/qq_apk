package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
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
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.m;
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
public final class d
{
  Context context;
  private c gNn;
  private List<String> itt;
  private KeyStore itu;
  private final SimpleDateFormat pYf;
  WebView vaK;
  Map<String, List<m>> vaL;
  Map<String, Boolean> vaM;
  
  public d(Context paramContext, WebView paramWebView)
  {
    AppMethodBeat.i(7408);
    this.gNn = null;
    this.itt = null;
    this.itu = null;
    this.pYf = new SimpleDateFormat("yyyy-MM-dd HH:mmZ", Locale.getDefault());
    this.context = paramContext;
    this.vaK = paramWebView;
    this.vaL = new HashMap();
    this.vaM = new HashMap();
    AppMethodBeat.o(7408);
  }
  
  @TargetApi(8)
  private void a(String paramString, SslError paramSslError)
  {
    AppMethodBeat.i(7411);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("1");
    localStringBuilder.append(",");
    localStringBuilder.append(b(paramString, paramSslError));
    paramString = localStringBuilder.toString();
    ab.i("MicroMsg.WebView.MMSslErrorHandler", "reportWebViewSslError, value = %s", new Object[] { paramString });
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(11098, paramString);
    AppMethodBeat.o(7411);
  }
  
  @TargetApi(14)
  private String b(String paramString, SslError paramSslError)
  {
    AppMethodBeat.i(7412);
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
        localStringBuilder.append(Base64.encodeToString(this.pYf.format(new Date()).getBytes(), 0));
        localStringBuilder.append("</clienttime>");
        localStringBuilder.append("<currenturl>");
        if (!bo.isNullOrNil(paramString)) {
          localStringBuilder.append(bo.apT(paramString));
        }
        localStringBuilder.append("</currenturl>");
        if (paramSslError != null) {
          break label348;
        }
      }
      label348:
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
        AppMethodBeat.o(7412);
        return paramString;
        localObject = Integer.valueOf(paramSslError.getPrimaryError());
        break;
      }
      return "";
    }
    catch (Exception paramString)
    {
      ab.w("MicroMsg.WebView.MMSslErrorHandler", "buildXml ex = %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(7412);
    }
  }
  
  private boolean b(SslCertificate paramSslCertificate)
  {
    AppMethodBeat.i(7409);
    if (paramSslCertificate == null)
    {
      ab.i("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates sslCertificate is null");
      AppMethodBeat.o(7409);
      return false;
    }
    ab.i("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates dnName = %s", new Object[] { paramSslCertificate.getIssuedBy().getDName() });
    Object localObject2;
    boolean bool;
    try
    {
      localObject1 = paramSslCertificate.getClass().getDeclaredField("mX509Certificate");
      ((Field)localObject1).setAccessible(true);
      paramSslCertificate = (X509Certificate)((Field)localObject1).get(paramSslCertificate);
      if (this.itu == null)
      {
        this.itu = KeyStore.getInstance("AndroidCAStore");
        this.itu.load(null, null);
      }
      if (this.itt != null) {
        break label203;
      }
      this.itt = new ArrayList();
      localObject1 = this.itu.aliases();
      while (((Enumeration)localObject1).hasMoreElements())
      {
        localObject2 = (String)((Enumeration)localObject1).nextElement();
        if ((localObject2 != null) && (((String)localObject2).startsWith("user:"))) {
          this.itt.add(localObject2);
        }
      }
      AppMethodBeat.o(7409);
    }
    catch (Exception paramSslCertificate)
    {
      ab.e("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates ex %s", new Object[] { paramSslCertificate.getMessage() });
      bool = false;
    }
    return bool;
    label203:
    Object localObject1 = this.itt.iterator();
    for (;;)
    {
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = (X509Certificate)this.itu.getCertificate((String)localObject2);
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
  
  public final void a(final String paramString, m paramm, SslError paramSslError)
  {
    AppMethodBeat.i(7410);
    ab.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, currentUrl = %s", new Object[] { paramString });
    if (this.vaK == null)
    {
      ab.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError fail, has been detached");
      AppMethodBeat.o(7410);
      return;
    }
    if (bo.isNullOrNil(paramString))
    {
      paramm.cancel();
      AppMethodBeat.o(7410);
      return;
    }
    Boolean localBoolean = (Boolean)this.vaM.get(paramString);
    if (localBoolean != null)
    {
      ab.v("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, already selected = %b", new Object[] { localBoolean });
      if (localBoolean.booleanValue())
      {
        paramm.proceed();
        AppMethodBeat.o(7410);
        return;
      }
      paramm.cancel();
      AppMethodBeat.o(7410);
      return;
    }
    URL localURL;
    try
    {
      int i = ((a)g.E(a.class)).a(a.a.lUr, 1);
      ab.i("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError skipUserCert = %d", new Object[] { Integer.valueOf(i) });
      if ((i == 1) && (b(paramSslError.getCertificate())))
      {
        ab.i("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError use user certificatess");
        this.vaM.put(paramString, Boolean.TRUE);
        paramm.proceed();
        AppMethodBeat.o(7410);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError : " + localException.getLocalizedMessage());
      List localList;
      try
      {
        localURL = new URL(paramString);
        if ((((a)g.E(a.class)).a(a.a.lUq, 0) != 1) || (!localURL.getHost().endsWith(".qq.com"))) {
          break label533;
        }
        localList = (List)this.vaL.get(paramString);
        if ((localList == null) || (localList.size() == 0))
        {
          a(paramString, paramSslError);
          paramSslError = new ArrayList();
          paramSslError.add(paramm);
          this.vaL.put(paramString, paramSslError);
          if ((this.gNn != null) && (this.gNn.isShowing()))
          {
            paramm.cancel();
            AppMethodBeat.o(7410);
            return;
          }
          this.gNn = com.tencent.mm.ui.base.h.a(this.context, false, this.context.getString(2131305997, new Object[] { localURL.getHost() }), this.context.getString(2131305998), this.context.getString(2131296894), this.context.getString(2131296546), new d.1(this, paramString), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(7407);
              paramAnonymousDialogInterface = (List)d.this.vaL.get(paramString);
              if (paramAnonymousDialogInterface == null)
              {
                ab.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list should not be null");
                AppMethodBeat.o(7407);
                return;
              }
              d.this.vaM.put(paramString, Boolean.FALSE);
              ab.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list size = %d", new Object[] { Integer.valueOf(paramAnonymousDialogInterface.size()) });
              Iterator localIterator = paramAnonymousDialogInterface.iterator();
              while (localIterator.hasNext()) {
                ((m)localIterator.next()).cancel();
              }
              paramAnonymousDialogInterface.clear();
              d.this.vaK.clearSslPreferences();
              AppMethodBeat.o(7407);
            }
          });
          AppMethodBeat.o(7410);
          return;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.WebView.MMSslErrorHandler", "create url fail : " + paramString.getLocalizedMessage());
        AppMethodBeat.o(7410);
        return;
      }
      localList.add(paramm);
      AppMethodBeat.o(7410);
      return;
    }
    label533:
    ab.d("MicroMsg.WebView.MMSslErrorHandler", "host = " + localURL.getHost() + ", but it not end with '.qq.com'");
    paramm.cancel();
    AppMethodBeat.o(7410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.d
 * JD-Core Version:    0.7.0.1
 */