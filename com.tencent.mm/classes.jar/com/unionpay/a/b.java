package com.unionpay.a;

import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public final class b
  implements X509TrustManager
{
  private X509TrustManager aisL;
  private X509TrustManagerExtensions aisM;
  private Context c;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(207333);
    this.aisL = null;
    this.aisM = null;
    this.c = paramContext;
    paramContext = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    paramContext.init(null);
    paramContext = paramContext.getTrustManagers();
    if (paramContext.length == 0)
    {
      paramContext = new NoSuchAlgorithmException("no trust manager found");
      AppMethodBeat.o(207333);
      throw paramContext;
    }
    this.aisL = ((X509TrustManager)paramContext[0]);
    if (Build.VERSION.SDK_INT > 23) {
      this.aisM = new X509TrustManagerExtensions(this.aisL);
    }
    AppMethodBeat.o(207333);
  }
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    AppMethodBeat.i(207339);
    this.aisL.checkClientTrusted(paramArrayOfX509Certificate, paramString);
    AppMethodBeat.o(207339);
  }
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    AppMethodBeat.i(207349);
    if ((Build.VERSION.SDK_INT > 23) && (this.aisM != null)) {
      this.aisM.checkServerTrusted(paramArrayOfX509Certificate, paramString, "");
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = paramArrayOfX509Certificate[0].getIssuerX500Principal();
        localArrayList = new ArrayList(0);
        localArrayList.add(".*(GeoTrust|VeriSign|Symantec|GlobalSign|Entrust|Thawte|DigiCert).*");
        String str = com.unionpay.utils.b.a(this.c);
        if (TextUtils.isEmpty(str)) {
          break label294;
        }
        localArrayList.add(str);
      }
      catch (Exception paramArrayOfX509Certificate)
      {
        ArrayList localArrayList;
        paramArrayOfX509Certificate = new CertificateException();
        AppMethodBeat.o(207349);
        throw paramArrayOfX509Certificate;
      }
      if (i < localArrayList.size())
      {
        if (Pattern.compile((String)localArrayList.get(i), 2).matcher(paramString.getName()).matches())
        {
          i = 1;
          if (i == 0)
          {
            paramArrayOfX509Certificate = new CertificateException();
            AppMethodBeat.o(207349);
            throw paramArrayOfX509Certificate;
            this.aisL.checkServerTrusted(paramArrayOfX509Certificate, paramString);
          }
        }
        else
        {
          i += 1;
          continue;
        }
        paramArrayOfX509Certificate = paramArrayOfX509Certificate[0].getSubjectX500Principal();
        paramString = new ArrayList(0);
        paramString.add(".*CN=.*(\\.95516\\.com|\\.chinaunionpay\\.com|\\.unionpay\\.com|\\.unionpaysecure\\.com|\\.95516\\.net)(,.*|$)");
        i = 0;
        if (i < paramString.size()) {
          if (!Pattern.compile((String)paramString.get(i), 2).matcher(paramArrayOfX509Certificate.getName()).matches()) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0)
          {
            paramArrayOfX509Certificate = new CertificateException();
            AppMethodBeat.o(207349);
            throw paramArrayOfX509Certificate;
            i += 1;
            break;
          }
          AppMethodBeat.o(207349);
          return;
        }
      }
      else
      {
        i = 0;
        continue;
        label294:
        i = 0;
      }
    }
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    AppMethodBeat.i(207355);
    X509Certificate[] arrayOfX509Certificate = this.aisL.getAcceptedIssuers();
    AppMethodBeat.o(207355);
    return arrayOfX509Certificate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.a.b
 * JD-Core Version:    0.7.0.1
 */