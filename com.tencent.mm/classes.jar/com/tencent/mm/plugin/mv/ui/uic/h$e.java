package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.repairer.a;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.vfs.u;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
final class h$e
  implements q.g
{
  h$e(h paramh, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONArray paramJSONArray1, JSONArray paramJSONArray2, JSONObject paramJSONObject3) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(229252);
    p.j(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(229252);
      return;
    case 1201: 
      paramMenuItem = g.FRy;
      u.deleteDir(g.feS());
      this.Gjb.getActivity().finish();
      Toast.makeText((Context)this.Gjb.getActivity(), b.h.app_clear_ok, 0).show();
      AppMethodBeat.o(229252);
      return;
    }
    paramMenuItem = "music_mv_info_" + f.formatTime("yyyy-MM-dd_HH_mm_ss", System.currentTimeMillis() / 1000L) + ".json";
    Object localObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject3).put("songInfoText", this.Gjc);
      ((JSONObject)localObject3).put("mvHeadInfoText", this.Gjd);
      ((JSONObject)localObject3).put("mvTrackInfoText", this.Gje);
      ((JSONObject)localObject3).put("mvRefObjInfoText", this.Gjf);
      ((JSONObject)localObject3).put("cgiInfo", this.Gjg);
      a locala = (a)com.tencent.mm.kernel.h.ag(a.class);
      localObject2 = ((JSONObject)localObject3).toString();
      p.j(localObject2, "saveObj.toString()");
      localObject3 = d.UTF_8;
      if (localObject2 == null)
      {
        paramMenuItem = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(229252);
        throw paramMenuItem;
      }
      localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
      p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
      locala.saveRepairerFile(paramMenuItem, (byte[])localObject2, true);
      AppMethodBeat.o(229252);
      return;
    }
    finally
    {
      Object localObject2 = (a)com.tencent.mm.kernel.h.ag(a.class);
      localObject3 = ((JSONObject)localObject3).toString();
      p.j(localObject3, "saveObj.toString()");
      Charset localCharset = d.UTF_8;
      if (localObject3 == null)
      {
        paramMenuItem = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(229252);
        throw paramMenuItem;
      }
      localObject3 = ((String)localObject3).getBytes(localCharset);
      p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
      ((a)localObject2).saveRepairerFile(paramMenuItem, (byte[])localObject3, true);
      AppMethodBeat.o(229252);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.h.e
 * JD-Core Version:    0.7.0.1
 */