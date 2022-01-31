package com.tencent.mm.plugin.nfc.b.a;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static a pgq = null;
  private Set<String> pgr;
  public d pgs = null;
  
  private boolean a(com.tencent.mm.plugin.nfc.b.a parama)
  {
    AppMethodBeat.i(23032);
    if (this.pgs == null)
    {
      ab.e("MicroMsg.ApduEngine", "[NFC]ApduEngine not ready !");
      parama = new IllegalStateException("ApduEngine not ready !");
      AppMethodBeat.o(23032);
      throw parama;
    }
    if ((parama == null) || (parama.pgm == null))
    {
      ab.e("MicroMsg.ApduEngine", "[NFC]apdu is null !");
      parama = new IllegalArgumentException("apdu is null !");
      AppMethodBeat.o(23032);
      throw parama;
    }
    ab.i("MicroMsg.ApduEngine", "[NFC][" + parama.name + "] do cmd : " + parama.pgm.toString());
    parama.pgn = b(parama.pgm);
    if (parama.pgn.bWX())
    {
      ab.i("MicroMsg.ApduEngine", "[NFC][" + parama.name + "] result==> OK : " + parama.pgn.toString());
      AppMethodBeat.o(23032);
      return true;
    }
    ab.e("MicroMsg.ApduEngine", "[NFC][" + parama.name + "] result==> fail : " + parama.pgn.toString());
    AppMethodBeat.o(23032);
    return false;
  }
  
  private com.tencent.mm.plugin.nfc.a.c b(com.tencent.mm.plugin.nfc.a.a parama)
  {
    AppMethodBeat.i(23033);
    parama = this.pgs.a(parama);
    AppMethodBeat.o(23033);
    return parama;
  }
  
  public static a bWY()
  {
    AppMethodBeat.i(23029);
    if (pgq == null) {
      pgq = new a();
    }
    a locala = pgq;
    AppMethodBeat.o(23029);
    return locala;
  }
  
  public final com.tencent.mm.plugin.nfc.a.c a(com.tencent.mm.plugin.nfc.a.a parama)
  {
    AppMethodBeat.i(23031);
    parama = new com.tencent.mm.plugin.nfc.b.a(1, "def", parama);
    a(parama);
    parama = parama.pgn;
    AppMethodBeat.o(23031);
    return parama;
  }
  
  public final boolean a(Tag paramTag)
  {
    AppMethodBeat.i(23030);
    super.a(paramTag);
    this.pgr = new HashSet();
    String[] arrayOfString = paramTag.getTechList();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      ab.d("MicroMsg.ApduEngine", "[NFC]tech : ".concat(String.valueOf(str)));
      this.pgr.add(str);
      i += 1;
    }
    try
    {
      if ((this.pgs != null) && (this.pgs.isConnected())) {
        this.pgs.close();
      }
      if (this.pgr.contains(IsoDep.class.getName()))
      {
        this.pgs = new b(paramTag);
        AppMethodBeat.o(23030);
        return true;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ApduEngine", localIOException, "", new Object[0]);
        ab.e("MicroMsg.ApduEngine", localIOException.toString());
      }
      if (this.pgr.contains(NfcA.class.getName()))
      {
        this.pgs = new c(paramTag);
        AppMethodBeat.o(23030);
        return true;
      }
      ab.i("MicroMsg.ApduEngine", "[NFC]ApduEngine not support this tag");
      AppMethodBeat.o(23030);
    }
    return false;
  }
  
  public final boolean a(List<com.tencent.mm.plugin.nfc.b.a> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(23034);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      boolean bool = a((com.tencent.mm.plugin.nfc.b.a)paramList.next());
      if ((!bool) && (paramBoolean1))
      {
        AppMethodBeat.o(23034);
        return false;
      }
      if ((bool) && (paramBoolean2))
      {
        AppMethodBeat.o(23034);
        return false;
      }
    }
    AppMethodBeat.o(23034);
    return true;
  }
  
  public final int eI(Context paramContext)
  {
    AppMethodBeat.i(23035);
    paramContext = NfcAdapter.getDefaultAdapter(paramContext);
    if (paramContext == null)
    {
      ab.i("MicroMsg.ApduEngine", "[NFC] No nfc chip !");
      AppMethodBeat.o(23035);
      return 0;
    }
    if (!paramContext.isEnabled())
    {
      AppMethodBeat.o(23035);
      return 1;
    }
    if (this.pgs == null)
    {
      AppMethodBeat.o(23035);
      return 4;
    }
    try
    {
      if (this.pgs != null)
      {
        boolean bool = this.pgs.isConnected();
        if (bool)
        {
          AppMethodBeat.o(23035);
          return 3;
        }
      }
      AppMethodBeat.o(23035);
      return 2;
    }
    catch (IOException paramContext)
    {
      ab.e("MicroMsg.ApduEngine", "[NFC] IOException : " + paramContext.toString());
      AppMethodBeat.o(23035);
    }
    return 2;
  }
  
  public final int eJ(Context paramContext)
  {
    AppMethodBeat.i(23036);
    int i = eI(paramContext);
    if ((i != 3) && (i != 2))
    {
      AppMethodBeat.o(23036);
      return i;
    }
    try
    {
      if (this.pgs != null)
      {
        this.pgs.connect();
        boolean bool = this.pgs.isConnected();
        if (bool)
        {
          AppMethodBeat.o(23036);
          return 3;
        }
      }
      AppMethodBeat.o(23036);
      return 2;
    }
    catch (IOException paramContext)
    {
      ab.e("MicroMsg.ApduEngine", "[NFC] IOException : " + paramContext.toString());
      AppMethodBeat.o(23036);
    }
    return 2;
  }
  
  public final String getInfo()
  {
    AppMethodBeat.i(23037);
    if (this.pgo == null)
    {
      ab.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: tag null");
      AppMethodBeat.o(23037);
      return null;
    }
    long l = bo.aoy();
    JSONObject localJSONObject = new JSONObject();
    ab.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: mTechList = " + this.pgr.size());
    Iterator localIterator = this.pgr.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ab.d("MicroMsg.ApduEngine", "lo-nfc-getInfo: tech = ".concat(String.valueOf(str)));
      Object localObject2;
      for (;;)
      {
        try
        {
          if (!str.equals(NfcA.class.getName())) {
            break label255;
          }
          localObject2 = NfcA.get(this.pgo);
          if (localObject2 == null)
          {
            ab.w("MicroMsg.ApduEngineNfcA", "lo-nfc-getInfoJsonObject: get nfcA null");
            str = null;
            localJSONObject.put(NfcA.class.getSimpleName(), str);
          }
        }
        catch (JSONException localJSONException)
        {
          ab.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: exp:+" + localJSONException.getLocalizedMessage());
          localObject1 = localJSONObject.toString();
          AppMethodBeat.o(23037);
          return localObject1;
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("atqa", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(((NfcA)localObject2).getAtqa()));
        ((JSONObject)localObject1).put("sak", com.tencent.mm.plugin.nfc.c.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.c.a.b(((NfcA)localObject2).getSak())));
      }
      label255:
      if (((String)localObject1).equals(IsoDep.class.getName()))
      {
        localObject2 = IsoDep.get(this.pgo);
        if (localObject2 == null)
        {
          ab.w("MicroMsg.ApduEngineIsoDep", "lo-nfc-getInfoJsonObject: get IsoDep null");
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
    ab.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: cost=" + (bo.aoy() - l));
    ab.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: res=" + localJSONObject.toString());
    Object localObject1 = localJSONObject.toString();
    AppMethodBeat.o(23037);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nfc.b.a.a
 * JD-Core Version:    0.7.0.1
 */