package com.tencent.mm.plugin.nfc.b.a;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  private static a Mtk = null;
  private Set<String> Mtl;
  public d Mtm = null;
  
  private boolean a(com.tencent.mm.plugin.nfc.b.a parama)
  {
    AppMethodBeat.i(26659);
    if (this.Mtm == null)
    {
      Log.e("MicroMsg.ApduEngine", "[NFC]ApduEngine not ready !");
      parama = new IllegalStateException("ApduEngine not ready !");
      AppMethodBeat.o(26659);
      throw parama;
    }
    if ((parama == null) || (parama.Mtg == null))
    {
      Log.e("MicroMsg.ApduEngine", "[NFC]apdu is null !");
      parama = new IllegalArgumentException("apdu is null !");
      AppMethodBeat.o(26659);
      throw parama;
    }
    Log.i("MicroMsg.ApduEngine", "[NFC][" + parama.name + "] do cmd : " + parama.Mtg.toString());
    parama.Mth = b(parama.Mtg);
    if (parama.Mth.gtp())
    {
      Log.i("MicroMsg.ApduEngine", "[NFC][" + parama.name + "] result==> OK : " + parama.Mth.toString());
      AppMethodBeat.o(26659);
      return true;
    }
    Log.e("MicroMsg.ApduEngine", "[NFC][" + parama.name + "] result==> fail : " + parama.Mth.toString());
    AppMethodBeat.o(26659);
    return false;
  }
  
  private com.tencent.mm.plugin.nfc.a.c b(com.tencent.mm.plugin.nfc.a.a parama)
  {
    AppMethodBeat.i(26660);
    parama = this.Mtm.a(parama);
    AppMethodBeat.o(26660);
    return parama;
  }
  
  public static a gtq()
  {
    AppMethodBeat.i(26656);
    if (Mtk == null) {
      Mtk = new a();
    }
    a locala = Mtk;
    AppMethodBeat.o(26656);
    return locala;
  }
  
  public final com.tencent.mm.plugin.nfc.a.c a(com.tencent.mm.plugin.nfc.a.a parama)
  {
    AppMethodBeat.i(26658);
    parama = new com.tencent.mm.plugin.nfc.b.a(1, "def", parama);
    a(parama);
    parama = parama.Mth;
    AppMethodBeat.o(26658);
    return parama;
  }
  
  public final boolean a(Tag paramTag)
  {
    AppMethodBeat.i(26657);
    super.a(paramTag);
    this.Mtl = new HashSet();
    String[] arrayOfString = paramTag.getTechList();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Log.d("MicroMsg.ApduEngine", "[NFC]tech : ".concat(String.valueOf(str)));
      this.Mtl.add(str);
      i += 1;
    }
    try
    {
      if ((this.Mtm != null) && (this.Mtm.isConnected())) {
        this.Mtm.close();
      }
      if (this.Mtl.contains(IsoDep.class.getName()))
      {
        this.Mtm = new b(paramTag);
        AppMethodBeat.o(26657);
        return true;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ApduEngine", localIOException, "", new Object[0]);
        Log.e("MicroMsg.ApduEngine", localIOException.toString());
      }
      if (this.Mtl.contains(NfcA.class.getName()))
      {
        this.Mtm = new c(paramTag);
        AppMethodBeat.o(26657);
        return true;
      }
      Log.i("MicroMsg.ApduEngine", "[NFC]ApduEngine not support this tag");
      AppMethodBeat.o(26657);
    }
    return false;
  }
  
  public final boolean c(List<com.tencent.mm.plugin.nfc.b.a> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(26661);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      boolean bool = a((com.tencent.mm.plugin.nfc.b.a)paramList.next());
      if ((!bool) && (paramBoolean1))
      {
        AppMethodBeat.o(26661);
        return false;
      }
      if ((bool) && (paramBoolean2))
      {
        AppMethodBeat.o(26661);
        return false;
      }
    }
    AppMethodBeat.o(26661);
    return true;
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(26664);
    if (ctW() == null)
    {
      Log.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: tag null");
      AppMethodBeat.o(26664);
      return null;
    }
    long l = Util.nowMilliSecond();
    JSONObject localJSONObject = new JSONObject();
    Log.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: mTechList = " + this.Mtl.size());
    Iterator localIterator = this.Mtl.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Log.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: tech = ".concat(String.valueOf(str)));
      Object localObject2;
      for (;;)
      {
        try
        {
          if (!str.equals(NfcA.class.getName())) {
            break label253;
          }
          localObject2 = NfcA.get(ctW());
          if (localObject2 == null)
          {
            Log.w("MicroMsg.ApduEngineNfcA", "lo-nfc-getInfoJsonObject: get nfcA null");
            str = null;
            localJSONObject.put(NfcA.class.getSimpleName(), str);
          }
        }
        catch (JSONException localJSONException)
        {
          Log.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: exp:+" + localJSONException.getLocalizedMessage());
          localObject1 = localJSONObject.toString();
          AppMethodBeat.o(26664);
          return localObject1;
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("atqa", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(((NfcA)localObject2).getAtqa()));
        ((JSONObject)localObject1).put("sak", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.c.a.f(((NfcA)localObject2).getSak())));
      }
      label253:
      if (((String)localObject1).equals(IsoDep.class.getName()))
      {
        localObject2 = IsoDep.get(ctW());
        if (localObject2 == null)
        {
          Log.w("MicroMsg.ApduEngineIsoDep", "lo-nfc-getInfoJsonObject: get IsoDep null");
          localObject1 = null;
        }
        for (;;)
        {
          localJSONObject.put(IsoDep.class.getSimpleName(), localObject1);
          break;
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("hiLayerResponse", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(((IsoDep)localObject2).getHiLayerResponse()));
          ((JSONObject)localObject1).put("historicalBytes", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(((IsoDep)localObject2).getHistoricalBytes()));
        }
      }
    }
    Log.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: cost=" + (Util.nowMilliSecond() - l));
    Log.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: res=" + localJSONObject.toString());
    Object localObject1 = localJSONObject.toString();
    AppMethodBeat.o(26664);
    return localObject1;
  }
  
  public final int jj(Context paramContext)
  {
    AppMethodBeat.i(26662);
    paramContext = NfcAdapter.getDefaultAdapter(paramContext);
    if (paramContext == null)
    {
      Log.i("MicroMsg.ApduEngine", "[NFC] No nfc chip !");
      AppMethodBeat.o(26662);
      return 0;
    }
    if (!paramContext.isEnabled())
    {
      AppMethodBeat.o(26662);
      return 1;
    }
    if (this.Mtm == null)
    {
      AppMethodBeat.o(26662);
      return 4;
    }
    try
    {
      if (this.Mtm != null)
      {
        boolean bool = this.Mtm.isConnected();
        if (bool)
        {
          AppMethodBeat.o(26662);
          return 3;
        }
      }
      AppMethodBeat.o(26662);
      return 2;
    }
    catch (IOException paramContext)
    {
      Log.e("MicroMsg.ApduEngine", "[NFC] IOException : " + paramContext.toString());
      AppMethodBeat.o(26662);
    }
    return 2;
  }
  
  public final int jk(Context paramContext)
  {
    AppMethodBeat.i(26663);
    int i = jj(paramContext);
    if ((i != 3) && (i != 2))
    {
      AppMethodBeat.o(26663);
      return i;
    }
    try
    {
      if ((this.Mtm != null) && (this.Mtm.cmB()))
      {
        boolean bool = this.Mtm.isConnected();
        if (bool)
        {
          AppMethodBeat.o(26663);
          return 3;
        }
      }
      AppMethodBeat.o(26663);
      return 2;
    }
    catch (IOException paramContext)
    {
      Log.e("MicroMsg.ApduEngine", "[NFC] IOException : " + paramContext.toString());
      AppMethodBeat.o(26663);
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.a.a
 * JD-Core Version:    0.7.0.1
 */