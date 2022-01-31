package com.tencent.mm.plugin.nfc.b.a;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends com.tencent.mm.plugin.nfc.b.b
{
  private static a mGk = null;
  private Set<String> mGl;
  public d mGm = null;
  
  private boolean a(com.tencent.mm.plugin.nfc.b.a parama)
  {
    if (this.mGm == null)
    {
      y.e("MicroMsg.ApduEngine", "[NFC]ApduEngine not ready !");
      throw new IllegalStateException("ApduEngine not ready !");
    }
    if ((parama == null) || (parama.mGg == null))
    {
      y.e("MicroMsg.ApduEngine", "[NFC]apdu is null !");
      throw new IllegalArgumentException("apdu is null !");
    }
    y.i("MicroMsg.ApduEngine", "[NFC][" + parama.name + "] do cmd : " + parama.mGg.toString());
    Object localObject = parama.mGg;
    parama.mGh = this.mGm.a((com.tencent.mm.plugin.nfc.a.a)localObject);
    localObject = parama.mGh;
    int i = ((com.tencent.mm.plugin.nfc.a.c)localObject).bow();
    if ((short)(((com.tencent.mm.plugin.nfc.a.c)localObject).box() | i << 8) == -28672) {}
    for (i = 1; i != 0; i = 0)
    {
      y.i("MicroMsg.ApduEngine", "[NFC][" + parama.name + "] result==> OK : " + parama.mGh.toString());
      return true;
    }
    y.e("MicroMsg.ApduEngine", "[NFC][" + parama.name + "] result==> fail : " + parama.mGh.toString());
    return false;
  }
  
  public static a boy()
  {
    if (mGk == null) {
      mGk = new a();
    }
    return mGk;
  }
  
  public final com.tencent.mm.plugin.nfc.a.c a(com.tencent.mm.plugin.nfc.a.a parama)
  {
    parama = new com.tencent.mm.plugin.nfc.b.a(1, "def", parama);
    a(parama);
    return parama.mGh;
  }
  
  public final boolean a(Tag paramTag)
  {
    super.a(paramTag);
    this.mGl = new HashSet();
    String[] arrayOfString = paramTag.getTechList();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      y.d("MicroMsg.ApduEngine", "[NFC]tech : " + str);
      this.mGl.add(str);
      i += 1;
    }
    try
    {
      if ((this.mGm != null) && (this.mGm.isConnected())) {
        this.mGm.close();
      }
      if (this.mGl.contains(IsoDep.class.getName()))
      {
        this.mGm = new b(paramTag);
        return true;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ApduEngine", localIOException, "", new Object[0]);
        y.e("MicroMsg.ApduEngine", localIOException.toString());
      }
      if (this.mGl.contains(NfcA.class.getName()))
      {
        this.mGm = new c(paramTag);
        return true;
      }
      y.i("MicroMsg.ApduEngine", "[NFC]ApduEngine not support this tag");
    }
    return false;
  }
  
  public final boolean a(List<com.tencent.mm.plugin.nfc.b.a> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      boolean bool = a((com.tencent.mm.plugin.nfc.b.a)paramList.next());
      if ((!bool) && (paramBoolean1)) {
        return false;
      }
      if ((bool) && (paramBoolean2)) {
        return false;
      }
    }
    return true;
  }
  
  public final int dU(Context paramContext)
  {
    int j = 2;
    paramContext = NfcAdapter.getDefaultAdapter(paramContext);
    int i;
    if (paramContext == null)
    {
      y.i("MicroMsg.ApduEngine", "[NFC] No nfc chip !");
      i = 0;
    }
    for (;;)
    {
      return i;
      if (!paramContext.isEnabled()) {
        return 1;
      }
      if (this.mGm == null) {
        return 4;
      }
      i = j;
      try
      {
        if (this.mGm != null)
        {
          boolean bool = this.mGm.isConnected();
          i = j;
          if (bool) {
            return 3;
          }
        }
      }
      catch (IOException paramContext)
      {
        y.e("MicroMsg.ApduEngine", "[NFC] IOException : " + paramContext.toString());
      }
    }
    return 2;
  }
  
  public final int dV(Context paramContext)
  {
    int i = dU(paramContext);
    if ((i != 3) && (i != 2)) {
      return i;
    }
    try
    {
      if (this.mGm != null)
      {
        this.mGm.connect();
        boolean bool = this.mGm.isConnected();
        if (bool) {
          return 3;
        }
      }
      return 2;
    }
    catch (IOException paramContext)
    {
      y.e("MicroMsg.ApduEngine", "[NFC] IOException : " + paramContext.toString());
    }
    return 2;
  }
  
  public final String getInfo()
  {
    if (this.mGi == null)
    {
      y.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: tag null");
      return null;
    }
    long l = bk.UY();
    JSONObject localJSONObject2 = new JSONObject();
    y.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: mTechList = " + this.mGl.size());
    Iterator localIterator = this.mGl.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      y.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: tech = " + str);
      Object localObject;
      JSONObject localJSONObject1;
      for (;;)
      {
        try
        {
          if (!str.equals(NfcA.class.getName())) {
            break label241;
          }
          localObject = NfcA.get(this.mGi);
          if (localObject == null)
          {
            y.w("MicroMsg.ApduEngineNfcA", "lo-nfc-getInfoJsonObject: get nfcA null");
            str = null;
            localJSONObject2.put(NfcA.class.getSimpleName(), str);
          }
        }
        catch (JSONException localJSONException)
        {
          y.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: exp:+" + localJSONException.getLocalizedMessage());
          return localJSONObject2.toString();
        }
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("atqa", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(((NfcA)localObject).getAtqa()));
        localJSONObject1.put("sak", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.c.a.b(((NfcA)localObject).getSak())));
      }
      label241:
      if (localJSONObject1.equals(IsoDep.class.getName()))
      {
        localObject = IsoDep.get(this.mGi);
        if (localObject == null)
        {
          y.w("MicroMsg.ApduEngineIsoDep", "lo-nfc-getInfoJsonObject: get IsoDep null");
          localJSONObject1 = null;
        }
        for (;;)
        {
          localJSONObject2.put(IsoDep.class.getSimpleName(), localJSONObject1);
          break;
          localJSONObject1 = new JSONObject();
          localJSONObject1.put("hiLayerResponse", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(((IsoDep)localObject).getHiLayerResponse()));
          localJSONObject1.put("historicalBytes", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(((IsoDep)localObject).getHistoricalBytes()));
        }
      }
    }
    y.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: cost=" + (bk.UY() - l));
    y.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: res=" + localJSONObject2.toString());
    return localJSONObject2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.a.a
 * JD-Core Version:    0.7.0.1
 */