package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.b;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.a;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  private g.a hhW;
  private Map<String, a> mwx;
  
  public m()
  {
    AppMethodBeat.i(91081);
    this.mwx = new HashMap();
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(91078);
        if (paramAnonymousc == null)
        {
          paramAnonymousc = "null";
          if (paramAnonymousd != null) {
            break label119;
          }
        }
        label119:
        for (String str = "null";; str = paramAnonymousd.toString())
        {
          ad.i("MicroMsg.ScannerCdnService", "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, str });
          paramAnonymousc = new m.b(m.this);
          if (paramAnonymousInt == 0) {
            break label129;
          }
          ad.e("MicroMsg.ScannerCdnService", "start failed : %d, media id is :%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          paramAnonymousc.errCode = paramAnonymousInt;
          m.a(m.this, paramAnonymousString, paramAnonymousc);
          AppMethodBeat.o(91078);
          return 0;
          paramAnonymousc = paramAnonymousc.toString();
          break;
        }
        label129:
        if (paramAnonymousd != null)
        {
          paramAnonymousc.errCode = paramAnonymousd.field_retCode;
          if (paramAnonymousd.field_retCode == 0) {
            break label198;
          }
          ad.e("MicroMsg.ScannerCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
        }
        for (;;)
        {
          m.a(m.this, paramAnonymousString, paramAnonymousc);
          AppMethodBeat.o(91078);
          return 0;
          label198:
          ad.i("MicroMsg.ScannerCdnService", "cdn trans suceess, media id : %s", new Object[] { paramAnonymousString });
          paramAnonymousc.fileId = paramAnonymousd.field_fileId;
          paramAnonymousc.aeskey = paramAnonymousd.field_aesKey;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream)
      {
        AppMethodBeat.i(91079);
        ad.i("MicroMsg.ScannerCdnService", "getCdnAuthInfo, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(91079);
      }
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(91080);
        ad.i("MicroMsg.ScannerCdnService", "decodePrepareResponse, mediaId = %s", new Object[] { paramAnonymousString });
        AppMethodBeat.o(91080);
        return null;
      }
    };
    AppMethodBeat.o(91081);
  }
  
  public static String amP(String paramString)
  {
    AppMethodBeat.i(91082);
    paramString = u.aqG() + "_" + paramString + "_" + System.currentTimeMillis();
    AppMethodBeat.o(91082);
    return paramString;
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, a parama)
  {
    AppMethodBeat.i(91083);
    g localg = new g();
    localg.fnH = this.hhW;
    localg.field_mediaId = paramString1;
    localg.field_fullpath = paramString2;
    localg.field_fileType = paramInt;
    localg.field_priority = a.fmV;
    localg.field_needStorage = false;
    localg.field_needCompressImage = true;
    localg.field_isStreamMedia = false;
    localg.field_force_aeskeycdn = true;
    localg.field_trysafecdn = false;
    this.mwx.put(paramString1, parama);
    f.awL().e(localg);
    AppMethodBeat.o(91083);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, m.b paramb);
  }
  
  public final class b
  {
    public String aeskey;
    public int errCode;
    public String fileId;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.m
 * JD-Core Version:    0.7.0.1
 */