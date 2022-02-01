package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/BaseJsonObject;", "", "()V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "Companion", "plugin-sticker_release"})
public abstract class a
{
  public static final a NMI = new a((byte)0);
  private static final String TAG = "MicroMsg.BaseJsonObject";
  
  public a au(JSONObject paramJSONObject)
  {
    p.h(paramJSONObject, "jsonObj");
    return this;
  }
  
  public JSONObject toJson()
  {
    return new JSONObject();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/BaseJsonObject$Companion;", "", "()V", "TAG", "", "parseJson", "", "jsonFile", "obj", "Lcom/tencent/mm/sticker/BaseJsonObject;", "saveJson", "plugin-sticker_release"})
  public static final class a
  {
    public static void a(a parama, String paramString)
    {
      AppMethodBeat.i(105886);
      p.h(parama, "obj");
      p.h(paramString, "jsonFile");
      Charset localCharset;
      try
      {
        parama = parama.toJson().toString();
        p.g(parama, "obj.toJson().toString()");
        localCharset = d.UTF_8;
        if (parama == null)
        {
          parama = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(105886);
          throw parama;
        }
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace(a.access$getTAG$cp(), (Throwable)parama, "", new Object[0]);
        AppMethodBeat.o(105886);
        return;
      }
      parama = parama.getBytes(localCharset);
      p.g(parama, "(this as java.lang.String).getBytes(charset)");
      s.C(paramString, parama);
      AppMethodBeat.o(105886);
    }
    
    public static void a(String paramString, a parama)
    {
      AppMethodBeat.i(105885);
      p.h(paramString, "jsonFile");
      p.h(parama, "obj");
      try
      {
        paramString = h.FE(s.boY(paramString));
        p.g(paramString, "jsonObj");
        parama.au(paramString);
        AppMethodBeat.o(105885);
        return;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(a.access$getTAG$cp(), (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(105885);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.a
 * JD-Core Version:    0.7.0.1
 */