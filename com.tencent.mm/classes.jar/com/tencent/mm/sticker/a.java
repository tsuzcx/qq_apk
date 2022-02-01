package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/BaseJsonObject;", "", "()V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "Companion", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  private static final String TAG = "MicroMsg.BaseJsonObject";
  public static final a acBM = new a((byte)0);
  
  public a G(JSONObject paramJSONObject)
  {
    s.u(paramJSONObject, "jsonObj");
    return this;
  }
  
  public JSONObject toJson()
  {
    return new JSONObject();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/BaseJsonObject$Companion;", "", "()V", "TAG", "", "parseJson", "", "jsonFile", "obj", "Lcom/tencent/mm/sticker/BaseJsonObject;", "saveJson", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(a parama, String paramString)
    {
      AppMethodBeat.i(105886);
      s.u(parama, "obj");
      s.u(paramString, "jsonFile");
      try
      {
        parama = parama.toJson().toString();
        s.s(parama, "obj.toJson().toString()");
        parama = parama.getBytes(d.UTF_8);
        s.s(parama, "(this as java.lang.String).getBytes(charset)");
        y.f(paramString, parama, parama.length);
        AppMethodBeat.o(105886);
        return;
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace(a.access$getTAG$cp(), (Throwable)parama, "", new Object[0]);
        AppMethodBeat.o(105886);
      }
    }
    
    public static void a(String paramString, a parama)
    {
      AppMethodBeat.i(105885);
      s.u(paramString, "jsonFile");
      s.u(parama, "obj");
      try
      {
        paramString = h.Fn(y.bEn(paramString));
        s.s(paramString, "jsonObj");
        parama.G(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.a
 * JD-Core Version:    0.7.0.1
 */