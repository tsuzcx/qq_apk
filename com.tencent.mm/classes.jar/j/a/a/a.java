package j.a.a;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class a
  implements io.flutter.embedding.engine.plugins.a, k.c
{
  private static final Logger Upy;
  private Runnable UpA;
  boolean UpB;
  private final Map<String, b> Upz;
  k bbv;
  private Context context;
  private final Handler handler;
  
  static
  {
    AppMethodBeat.i(204508);
    Upy = Logger.getLogger(a.class.getCanonicalName());
    AppMethodBeat.o(204508);
  }
  
  public a()
  {
    AppMethodBeat.i(204501);
    this.Upz = new HashMap();
    this.handler = new Handler();
    AppMethodBeat.o(204501);
  }
  
  static Map<String, Object> J(String paramString, Object paramObject)
  {
    AppMethodBeat.i(204505);
    HashMap localHashMap = new HashMap();
    localHashMap.put("playerId", paramString);
    localHashMap.put("value", paramObject);
    AppMethodBeat.o(204505);
    return localHashMap;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(204502);
    k localk = new k(paramb.SOH, "xyz.luan/audioplayers");
    this.bbv = localk;
    this.context = paramb.applicationContext;
    this.UpB = false;
    localk.a(this);
    AppMethodBeat.o(204502);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(204503);
    for (;;)
    {
      String str2;
      String str1;
      Object localObject;
      try
      {
        str2 = (String)paramj.btq("playerId");
        str1 = (String)paramj.btq("mode");
        if (!this.Upz.containsKey(str2))
        {
          if (str1.equalsIgnoreCase("PlayerMode.MEDIA_PLAYER"))
          {
            localObject = new d(this, str2);
            this.Upz.put(str2, localObject);
          }
        }
        else
        {
          localObject = (b)this.Upz.get(str2);
          str2 = paramj.method;
          i = -1;
        }
        switch (str2.hashCode())
        {
        case 3443508: 
          paramd.dLv();
          AppMethodBeat.o(204503);
          return;
          localObject = new e(this, str2);
          continue;
          if (!str2.equals("play")) {
            break label898;
          }
        }
      }
      catch (Exception paramj)
      {
        Upy.log(Level.SEVERE, "Unexpected error!", paramj);
        paramd.b("Unexpected error!", paramj.getMessage(), paramj);
        AppMethodBeat.o(204503);
        return;
      }
      int i = 0;
      break label898;
      if (str2.equals("resume"))
      {
        i = 1;
        break label898;
        if (str2.equals("pause"))
        {
          i = 2;
          break label898;
          if (str2.equals("stop"))
          {
            i = 3;
            break label898;
            if (str2.equals("release"))
            {
              i = 4;
              break label898;
              if (str2.equals("seek"))
              {
                i = 5;
                break label898;
                if (str2.equals("setVolume"))
                {
                  i = 6;
                  break label898;
                  if (str2.equals("setUrl"))
                  {
                    i = 7;
                    break label898;
                    if (str2.equals("setPlaybackRate"))
                    {
                      i = 8;
                      break label898;
                      if (str2.equals("getDuration"))
                      {
                        i = 9;
                        break label898;
                        if (str2.equals("getCurrentPosition"))
                        {
                          i = 10;
                          break label898;
                          if (str2.equals("setReleaseMode"))
                          {
                            i = 11;
                            break label898;
                            if (str2.equals("earpieceOrSpeakersToggle"))
                            {
                              i = 12;
                              break label898;
                              str2 = (String)paramj.btq("url");
                              double d = ((Double)paramj.btq("volume")).doubleValue();
                              Integer localInteger = (Integer)paramj.btq("position");
                              boolean bool1 = ((Boolean)paramj.btq("respectSilence")).booleanValue();
                              boolean bool2 = ((Boolean)paramj.btq("isLocal")).booleanValue();
                              ((b)localObject).a(bool1, ((Boolean)paramj.btq("stayAwake")).booleanValue(), this.context.getApplicationContext());
                              ((b)localObject).u(d);
                              ((b)localObject).a(str2, bool2, this.context.getApplicationContext());
                              if ((localInteger != null) && (!str1.equals("PlayerMode.LOW_LATENCY"))) {
                                ((b)localObject).seek(localInteger.intValue());
                              }
                              ((b)localObject).mb(this.context.getApplicationContext());
                              for (;;)
                              {
                                paramd.ba(Integer.valueOf(1));
                                AppMethodBeat.o(204503);
                                return;
                                ((b)localObject).mb(this.context.getApplicationContext());
                                continue;
                                ((b)localObject).pause();
                                continue;
                                ((b)localObject).stop();
                                continue;
                                ((b)localObject).release();
                                continue;
                                ((b)localObject).seek(((Integer)paramj.btq("position")).intValue());
                                continue;
                                ((b)localObject).u(((Double)paramj.btq("volume")).doubleValue());
                                continue;
                                ((b)localObject).a((String)paramj.btq("url"), ((Boolean)paramj.btq("isLocal")).booleanValue(), this.context.getApplicationContext());
                                continue;
                                paramd.ba(Integer.valueOf(((b)localObject).P(((Double)paramj.btq("playbackRate")).doubleValue())));
                                AppMethodBeat.o(204503);
                                return;
                                paramd.ba(Integer.valueOf(((b)localObject).getDuration()));
                                AppMethodBeat.o(204503);
                                return;
                                paramd.ba(Integer.valueOf(((b)localObject).getCurrentPosition()));
                                AppMethodBeat.o(204503);
                                return;
                                ((b)localObject).a(c.valueOf(((String)paramj.btq("releaseMode")).substring(12)));
                                continue;
                                ((b)localObject).p((String)paramj.btq("playingRoute"), this.context.getApplicationContext());
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label898:
      switch (i)
      {
      }
    }
  }
  
  public final void b(a.b paramb) {}
  
  public final void hRr()
  {
    AppMethodBeat.i(204504);
    if (this.UpA == null)
    {
      this.UpA = new a(this.Upz, this.bbv, this.handler, this, (byte)0);
      this.handler.post(this.UpA);
    }
    AppMethodBeat.o(204504);
  }
  
  static final class a
    implements Runnable
  {
    private final WeakReference<Map<String, b>> UpC;
    private final WeakReference<k> UpD;
    private final WeakReference<Handler> UpE;
    private final WeakReference<a> UpF;
    
    private a(Map<String, b> paramMap, k paramk, Handler paramHandler, a parama)
    {
      AppMethodBeat.i(204499);
      this.UpC = new WeakReference(paramMap);
      this.UpD = new WeakReference(paramk);
      this.UpE = new WeakReference(paramHandler);
      this.UpF = new WeakReference(parama);
      AppMethodBeat.o(204499);
    }
    
    public final void run()
    {
      AppMethodBeat.i(204500);
      Object localObject = (Map)this.UpC.get();
      k localk = (k)this.UpD.get();
      Handler localHandler = (Handler)this.UpE.get();
      a locala = (a)this.UpF.get();
      if ((localObject == null) || (localk == null) || (localHandler == null) || (locala == null))
      {
        if (locala != null) {
          a.a(locala);
        }
        AppMethodBeat.o(204500);
        return;
      }
      int i = 1;
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        if (localb.hRs())
        {
          int j = 0;
          try
          {
            String str = localb.esX();
            i = localb.getDuration();
            int k = localb.getCurrentPosition();
            localk.a("audio.onDuration", a.K(str, Integer.valueOf(i)), null);
            localk.a("audio.onCurrentPosition", a.K(str, Integer.valueOf(k)), null);
            i = j;
            if (a.b(locala))
            {
              localk.a("audio.onSeekComplete", a.K(localb.esX(), Boolean.TRUE), null);
              a.c(locala);
              i = j;
            }
          }
          catch (UnsupportedOperationException localUnsupportedOperationException)
          {
            i = j;
          }
        }
      }
      if (i != 0)
      {
        a.a(locala);
        AppMethodBeat.o(204500);
        return;
      }
      localHandler.postDelayed(this, 200L);
      AppMethodBeat.o(204500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     j.a.a.a
 * JD-Core Version:    0.7.0.1
 */