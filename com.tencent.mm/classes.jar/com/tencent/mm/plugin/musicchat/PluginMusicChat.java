package com.tencent.mm.plugin.musicchat;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.musicchat.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.util.b.a;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/musicchat/PluginMusicChat;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/musicchat/api/IPluginMusicChat;", "()V", "APPID_QQ_MUSIC", "", "ARTISTER_KEY", "HISTORY_KEY", "SEND_MUSIC_CHAT_CONFIG", "SEND_MUSIC_CHAT_KEY", "TAG", "TITLE_KEY", "job", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sender", "Lcom/tencent/mm/plugin/musicchat/api/IPluginSendMusicToChat;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getMusicSender", "isEnableMusicChat", "", "isQQMusic", "appid", "onExitChat", "setMusicSender", "startSendMusic", "context", "Landroid/content/Context;", "writImpl", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "writMusicHistory", "MusicHistory", "plugin-music-chat_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginMusicChat
  extends com.tencent.mm.kernel.b.f
  implements a
{
  private com.tencent.mm.plugin.musicchat.a.b LRk;
  private final String LRl;
  private final String LRm;
  private final String LRn;
  private final String LRo;
  private final String LRp;
  private final String LRq;
  private final String TAG;
  private cb job;
  private final aq scope;
  
  public PluginMusicChat()
  {
    AppMethodBeat.i(261401);
    this.TAG = "MicroMsg.PluginMusicChat";
    this.LRl = "musicHistory_config";
    this.LRm = "musicHistory";
    this.LRn = "historys";
    this.LRo = "musicTitle";
    this.LRp = "artister";
    this.LRq = "wx5aa333606550dfd5";
    this.scope = ar.kBZ();
    AppMethodBeat.o(261401);
  }
  
  private final boolean isQQMusic(String paramString)
  {
    AppMethodBeat.i(261427);
    boolean bool = s.p(paramString, this.LRq);
    AppMethodBeat.o(261427);
    return bool;
  }
  
  private final void writImpl(com.tencent.mm.aw.f paramf)
  {
    j = 0;
    for (;;)
    {
      String str;
      int m;
      try
      {
        AppMethodBeat.i(261420);
        if (paramf != null)
        {
          if (paramf.oOI != null)
          {
            localObject1 = paramf.oOI;
            s.s(localObject1, "AppId");
            if (isQQMusic((String)localObject1)) {}
          }
          else
          {
            AppMethodBeat.o(261420);
            return;
          }
          com.tencent.mm.kernel.h.baC();
          str = com.tencent.mm.kernel.b.aZs();
          localObject1 = (List)new ArrayList();
          localObject2 = MultiProcessMMKV.getMMKV(s.X(this.LRl, str)).getString(this.LRm, "");
        }
      }
      finally {}
      try
      {
        localObject2 = new JSONObject((String)localObject2).getJSONArray(this.LRn);
        m = ((JSONArray)localObject2).length();
        if (m <= 0) {
          continue;
        }
        i = 0;
      }
      catch (JSONException localJSONException1)
      {
        continue;
        continue;
      }
      k = i + 1;
      JSONObject localJSONObject = new JSONObject(((JSONArray)localObject2).getString(i));
      a locala = new a();
      try
      {
        locala.LRr = localJSONObject.getString(this.LRo);
        locala.LRs = localJSONObject.getString(this.LRp);
        ((List)localObject1).add(locala);
      }
      catch (JSONException localJSONException2)
      {
        continue;
        i = j;
        continue;
        paramf = (com.tencent.mm.aw.f)localObject1;
        continue;
        i = k;
      }
      if (k < m) {
        break label458;
      }
      Object localObject2 = new a();
      ((a)localObject2).LRr = paramf.oOx;
      ((a)localObject2).LRs = paramf.oOy;
      if (((List)localObject1).contains(localObject2)) {
        ((List)localObject1).remove(localObject2);
      }
      ((List)localObject1).add(0, localObject2);
      if (((List)localObject1).size() <= 10) {
        break label452;
      }
      paramf = ((List)localObject1).subList(0, 10);
      localObject1 = new JSONArray();
      localObject2 = new JSONObject();
      k = paramf.size();
      if (k > 0)
      {
        i = j;
        j = i + 1;
        localJSONObject = new JSONObject();
        locala = (a)paramf.get(i);
        localJSONObject.put(this.LRo, locala.LRr);
        localJSONObject.put(this.LRp, locala.LRs);
        ((JSONArray)localObject1).put(i, localJSONObject);
        if (j < k) {
          break label447;
        }
      }
      ((JSONObject)localObject2).put(this.LRn, localObject1);
      MultiProcessMMKV.getMMKV(s.X(this.LRl, str)).putString(this.LRm, ((JSONObject)localObject2).toString());
      AppMethodBeat.o(261420);
    }
  }
  
  private static final void writMusicHistory$lambda-0(PluginMusicChat paramPluginMusicChat, com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(261437);
    s.u(paramPluginMusicChat, "this$0");
    paramPluginMusicChat.writImpl(paramf);
    AppMethodBeat.o(261437);
  }
  
  public final void execute(g paramg) {}
  
  public final com.tencent.mm.plugin.musicchat.a.b getMusicSender()
  {
    return this.LRk;
  }
  
  public final boolean isEnableMusicChat()
  {
    AppMethodBeat.i(261469);
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yQB, b.a.agrb, 0) == 1)
    {
      AppMethodBeat.o(261469);
      return true;
    }
    AppMethodBeat.o(261469);
    return false;
  }
  
  public final void onExitChat()
  {
    AppMethodBeat.i(261513);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onExitChat, job:").append(this.job).append(" isActive:");
    Object localObject = this.job;
    if (localObject == null) {}
    for (localObject = null;; localObject = Boolean.valueOf(((cb)localObject).isActive()))
    {
      Log.i(str, localObject);
      localObject = this.job;
      if (localObject != null) {
        ((cb)localObject).a(null);
      }
      AppMethodBeat.o(261513);
      return;
    }
  }
  
  public final void setMusicSender(com.tencent.mm.plugin.musicchat.a.b paramb)
  {
    this.LRk = paramb;
  }
  
  public final void startSendMusic(Context paramContext)
  {
    AppMethodBeat.i(261479);
    s.u(paramContext, "context");
    cb localcb = this.job;
    if (localcb != null) {
      localcb.a(null);
    }
    this.job = j.a(this.scope, null, null, (m)new PluginMusicChat.b(paramContext, null), 3);
    AppMethodBeat.o(261479);
  }
  
  public final void writMusicHistory(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(261501);
    com.tencent.threadpool.h.ahAA.bn(new PluginMusicChat..ExternalSyntheticLambda0(this, paramf));
    AppMethodBeat.o(261501);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/musicchat/PluginMusicChat$MusicHistory;", "", "(Lcom/tencent/mm/plugin/musicchat/PluginMusicChat;)V", "artister", "", "getArtister", "()Ljava/lang/String;", "setArtister", "(Ljava/lang/String;)V", "musicTitle", "getMusicTitle", "setMusicTitle", "equals", "", "other", "hashCode", "", "plugin-music-chat_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
  {
    String LRr;
    String LRs;
    
    public a()
    {
      AppMethodBeat.i(261382);
      AppMethodBeat.o(261382);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(261389);
      if ((paramObject instanceof a))
      {
        if ((s.p(this.LRr, ((a)paramObject).LRr)) && (s.p(this.LRs, ((a)paramObject).LRs)))
        {
          AppMethodBeat.o(261389);
          return true;
        }
        AppMethodBeat.o(261389);
        return false;
      }
      boolean bool = super.equals(paramObject);
      AppMethodBeat.o(261389);
      return bool;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(261393);
      String str = this.LRr;
      int i;
      if (str == null)
      {
        i = 0;
        str = this.LRs;
        if (str != null) {
          break label47;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(261393);
        return i * 31 + j;
        i = str.hashCode();
        break;
        label47:
        j = str.hashCode();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.musicchat.PluginMusicChat
 * JD-Core Version:    0.7.0.1
 */