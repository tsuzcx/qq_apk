package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.g.a.yt;
import com.tencent.mm.g.a.yt.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.cnk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.wallet_core.ui.e;
import org.json.JSONObject;

public final class m
{
  boolean Fdo;
  a JFa;
  f JFb;
  c<yo> JFc;
  public boolean JFd;
  boolean cZP;
  String dlQ;
  String title;
  c<yt> uDk;
  String unW;
  String unX;
  int vjP;
  
  public m()
  {
    AppMethodBeat.i(72770);
    this.cZP = false;
    this.uDk = new c() {};
    this.JFc = new c() {};
    this.JFd = false;
    AppMethodBeat.o(72770);
  }
  
  public static m a(bno parambno)
  {
    AppMethodBeat.i(72771);
    if (parambno == null)
    {
      AppMethodBeat.o(72771);
      return null;
    }
    m localm = new m();
    localm.Fdo = parambno.Fdo;
    localm.vjP = parambno.vjP;
    localm.dlQ = parambno.dlQ;
    localm.unW = parambno.unW;
    localm.unX = parambno.unX;
    localm.title = parambno.title;
    localm.JFa = new a();
    if (parambno.Fdp != null)
    {
      localm.JFa.type = parambno.Fdp.type;
      localm.JFa.djj = parambno.Fdp.djj;
      localm.JFa.FAG = parambno.Fdp.FAG;
      localm.JFa.path = parambno.Fdp.path;
      localm.JFa.AWx = parambno.Fdp.AWx;
    }
    AppMethodBeat.o(72771);
    return localm;
  }
  
  public static m bA(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72772);
    label268:
    for (;;)
    {
      try
      {
        ac.i("MicroMsg.JumpRemind", "feed %s", new Object[] { paramJSONObject });
        Object localObject = paramJSONObject.optJSONObject("bindquerynew_resp");
        if (localObject == null) {
          break label268;
        }
        paramJSONObject = (JSONObject)localObject;
        JSONObject localJSONObject = paramJSONObject.optJSONObject("bindqueryresp");
        localObject = paramJSONObject;
        if (localJSONObject != null) {
          localObject = localJSONObject;
        }
        localJSONObject = ((JSONObject)localObject).optJSONObject("jumpRemind");
        paramJSONObject = localJSONObject;
        if (localJSONObject == null) {
          paramJSONObject = ((JSONObject)localObject).optJSONObject("jump_remind");
        }
        if (paramJSONObject == null)
        {
          paramJSONObject = ((JSONObject)localObject).optJSONObject("jump_remind_info");
          if (paramJSONObject != null)
          {
            localObject = new m();
            ((m)localObject).vjP = paramJSONObject.optInt("jump_type");
            ((m)localObject).Fdo = paramJSONObject.optBoolean("is_pop_up_windows");
            ((m)localObject).dlQ = paramJSONObject.optString("wording");
            ((m)localObject).unW = paramJSONObject.optString("left_button_wording");
            ((m)localObject).unX = paramJSONObject.optString("right_button_wording");
            ((m)localObject).title = paramJSONObject.optString("title");
            paramJSONObject = paramJSONObject.optJSONObject("url");
            ((m)localObject).JFa = new a();
            if (paramJSONObject != null)
            {
              ((m)localObject).JFa.type = paramJSONObject.optInt("type");
              ((m)localObject).JFa.djj = paramJSONObject.optString("appid");
              ((m)localObject).JFa.FAG = paramJSONObject.optString("app_version");
              ((m)localObject).JFa.path = paramJSONObject.optString("path");
              ((m)localObject).JFa.AWx = paramJSONObject.optString("button_name");
            }
            AppMethodBeat.o(72772);
            return localObject;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        ac.printErrStackTrace("MicroMsg.JumpRemind", paramJSONObject, "error create", new Object[0]);
        AppMethodBeat.o(72772);
        return null;
      }
    }
  }
  
  public final boolean a(final Activity paramActivity, f paramf)
  {
    AppMethodBeat.i(72773);
    this.JFb = paramf;
    if (this.Fdo)
    {
      com.tencent.mm.ui.base.h.d(paramActivity, this.dlQ, this.title, this.unX, this.unW, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72761);
          ac.i("MicroMsg.JumpRemind", "onClick1 ");
          if ((m.this.JFa != null) && (m.this.JFa.AWx.equals("right_button_wording")))
          {
            m.this.kA(paramActivity);
            AppMethodBeat.o(72761);
            return;
          }
          m.this.JFb.onCancel();
          AppMethodBeat.o(72761);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72762);
          ac.i("MicroMsg.JumpRemind", "onClick2");
          if ((m.this.JFa != null) && (m.this.JFa.AWx.equals("left_button_wording")))
          {
            m.this.kA(paramActivity);
            AppMethodBeat.o(72762);
            return;
          }
          m.this.JFb.onCancel();
          AppMethodBeat.o(72762);
        }
      });
      AppMethodBeat.o(72773);
      return true;
    }
    kA(paramActivity);
    AppMethodBeat.o(72773);
    return true;
  }
  
  public final boolean a(final Activity paramActivity, final g paramg)
  {
    AppMethodBeat.i(72774);
    boolean bool = a(paramActivity, new f()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(72763);
        if (m.this.fAj())
        {
          paramg.dan();
          AppMethodBeat.o(72763);
          return;
        }
        paramActivity.finish();
        AppMethodBeat.o(72763);
      }
      
      public final void onEnter() {}
      
      public final void onUrlCancel()
      {
        AppMethodBeat.i(72765);
        if (m.this.fAj())
        {
          paramg.dan();
          AppMethodBeat.o(72765);
          return;
        }
        paramActivity.finish();
        AppMethodBeat.o(72765);
      }
      
      public final void onUrlOk()
      {
        AppMethodBeat.i(72764);
        if (m.this.fAj()) {
          paramg.dan();
        }
        AppMethodBeat.o(72764);
      }
    });
    AppMethodBeat.o(72774);
    return bool;
  }
  
  public final boolean a(Activity paramActivity, final h paramh)
  {
    AppMethodBeat.i(72775);
    com.tencent.mm.ui.base.h.d(paramActivity, this.dlQ, this.title, this.unX, this.unW, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72766);
        ac.i("MicroMsg.JumpRemind", "onClick1 ");
        if ((m.this.JFa != null) && (m.this.JFa.AWx.equals("right_button_wording")))
        {
          paramh.br(m.this.JFa.type, m.this.JFa.path);
          AppMethodBeat.o(72766);
          return;
        }
        paramh.onCancel();
        AppMethodBeat.o(72766);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72767);
        ac.i("MicroMsg.JumpRemind", "onClick2");
        if ((m.this.JFa != null) && (m.this.JFa.AWx.equals("left_button_wording")))
        {
          paramh.br(m.this.JFa.type, m.this.JFa.path);
          AppMethodBeat.o(72767);
          return;
        }
        paramh.onCancel();
        AppMethodBeat.o(72767);
      }
    });
    AppMethodBeat.o(72775);
    return true;
  }
  
  public final boolean fAj()
  {
    return this.vjP == 1;
  }
  
  public final void fAk()
  {
    AppMethodBeat.i(207325);
    if ((this.JFa == null) || (bs.isNullOrNil(this.JFa.path)))
    {
      AppMethodBeat.o(207325);
      return;
    }
    if (this.JFa.path.contains("clientversion"))
    {
      ac.w("MicroMsg.JumpRemind", "url.path contain clientversion");
      AppMethodBeat.o(207325);
      return;
    }
    this.JFa.path = v.q(this.JFa.path, new String[] { "clientversion" + "=" + d.DIc });
    AppMethodBeat.o(207325);
  }
  
  public final void fAl()
  {
    AppMethodBeat.i(72777);
    this.uDk.dead();
    this.JFc.dead();
    AppMethodBeat.o(72777);
  }
  
  final void kA(Context paramContext)
  {
    AppMethodBeat.i(72776);
    Intent localIntent;
    if ((paramContext instanceof i))
    {
      ((i)paramContext).register(new k()
      {
        public final void fAi()
        {
          AppMethodBeat.i(72769);
          m.this.uDk.dead();
          m.this.JFc.dead();
          AppMethodBeat.o(72769);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(72768);
          m.this.uDk.dead();
          m.this.JFc.dead();
          AppMethodBeat.o(72768);
        }
      });
      this.uDk.alive();
      this.JFc.alive();
      this.cZP = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.JFa.path);
      localIntent.putExtra("showShare", false);
      this.JFb.onEnter();
      e.al(paramContext, localIntent);
      AppMethodBeat.o(72776);
      return;
    }
    if (this.JFd)
    {
      this.uDk.alive();
      this.JFc.alive();
      this.cZP = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.JFa.path);
      localIntent.putExtra("showShare", false);
      this.JFb.onEnter();
      e.al(paramContext, localIntent);
    }
    AppMethodBeat.o(72776);
  }
  
  static final class a
  {
    String AWx;
    String FAG;
    String djj;
    String path;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.m
 * JD-Core Version:    0.7.0.1
 */