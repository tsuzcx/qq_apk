package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aav;
import com.tencent.mm.g.a.aba;
import com.tencent.mm.g.a.aba.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.w;
import org.json.JSONObject;

public final class m
{
  boolean Mlw;
  a RtJ;
  f RtK;
  IListener<aav> RtL;
  public boolean RtM;
  boolean dDz;
  String dQx;
  String lHA;
  String lHB;
  String title;
  int uSc;
  IListener<aba> zmm;
  
  public m()
  {
    AppMethodBeat.i(72770);
    this.dDz = false;
    this.zmm = new IListener() {};
    this.RtL = new IListener() {};
    this.RtM = false;
    AppMethodBeat.o(72770);
  }
  
  public static m a(cfm paramcfm)
  {
    AppMethodBeat.i(72771);
    if (paramcfm == null)
    {
      AppMethodBeat.o(72771);
      return null;
    }
    m localm = new m();
    localm.Mlw = paramcfm.Mlw;
    localm.uSc = paramcfm.uSc;
    localm.dQx = paramcfm.dQx;
    localm.lHA = paramcfm.lHA;
    localm.lHB = paramcfm.lHB;
    localm.title = paramcfm.title;
    localm.RtJ = new a();
    if (paramcfm.Mlx != null)
    {
      localm.RtJ.type = paramcfm.Mlx.type;
      localm.RtJ.dNI = paramcfm.Mlx.dNI;
      localm.RtJ.MPC = paramcfm.Mlx.MPC;
      localm.RtJ.path = paramcfm.Mlx.path;
      localm.RtJ.gTt = paramcfm.Mlx.gTt;
    }
    AppMethodBeat.o(72771);
    return localm;
  }
  
  public static m cj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72772);
    label268:
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.JumpRemind", "feed %s", new Object[] { paramJSONObject });
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
            ((m)localObject).uSc = paramJSONObject.optInt("jump_type");
            ((m)localObject).Mlw = paramJSONObject.optBoolean("is_pop_up_windows");
            ((m)localObject).dQx = paramJSONObject.optString("wording");
            ((m)localObject).lHA = paramJSONObject.optString("left_button_wording");
            ((m)localObject).lHB = paramJSONObject.optString("right_button_wording");
            ((m)localObject).title = paramJSONObject.optString("title");
            paramJSONObject = paramJSONObject.optJSONObject("url");
            ((m)localObject).RtJ = new a();
            if (paramJSONObject != null)
            {
              ((m)localObject).RtJ.type = paramJSONObject.optInt("type");
              ((m)localObject).RtJ.dNI = paramJSONObject.optString("appid");
              ((m)localObject).RtJ.MPC = paramJSONObject.optString("app_version");
              ((m)localObject).RtJ.path = paramJSONObject.optString("path");
              ((m)localObject).RtJ.gTt = paramJSONObject.optString("button_name");
            }
            AppMethodBeat.o(72772);
            return localObject;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.printErrStackTrace("MicroMsg.JumpRemind", paramJSONObject, "error create", new Object[0]);
        AppMethodBeat.o(72772);
        return null;
      }
    }
  }
  
  public final boolean a(final Activity paramActivity, f paramf)
  {
    AppMethodBeat.i(72773);
    this.RtK = paramf;
    if (this.Mlw)
    {
      com.tencent.mm.ui.base.h.c(paramActivity, this.dQx, this.title, this.lHB, this.lHA, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72761);
          Log.i("MicroMsg.JumpRemind", "onClick1 ");
          if ((m.this.RtJ != null) && (m.this.RtJ.gTt.equals("right_button_wording")))
          {
            m.this.kP(paramActivity);
            AppMethodBeat.o(72761);
            return;
          }
          m.this.RtK.onCancel();
          AppMethodBeat.o(72761);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72762);
          Log.i("MicroMsg.JumpRemind", "onClick2");
          if ((m.this.RtJ != null) && (m.this.RtJ.gTt.equals("left_button_wording")))
          {
            m.this.kP(paramActivity);
            AppMethodBeat.o(72762);
            return;
          }
          m.this.RtK.onCancel();
          AppMethodBeat.o(72762);
        }
      });
      AppMethodBeat.o(72773);
      return true;
    }
    kP(paramActivity);
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
        if (m.this.hhm())
        {
          paramg.eeY();
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
        if (m.this.hhm())
        {
          paramg.eeY();
          AppMethodBeat.o(72765);
          return;
        }
        paramActivity.finish();
        AppMethodBeat.o(72765);
      }
      
      public final void onUrlOk()
      {
        AppMethodBeat.i(72764);
        if (m.this.hhm()) {
          paramg.eeY();
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
    com.tencent.mm.ui.base.h.c(paramActivity, this.dQx, this.title, this.lHB, this.lHA, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72766);
        Log.i("MicroMsg.JumpRemind", "onClick1 ");
        if ((m.this.RtJ != null) && (m.this.RtJ.gTt.equals("right_button_wording")))
        {
          paramh.bG(m.this.RtJ.type, m.this.RtJ.path);
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
        Log.i("MicroMsg.JumpRemind", "onClick2");
        if ((m.this.RtJ != null) && (m.this.RtJ.gTt.equals("left_button_wording")))
        {
          paramh.bG(m.this.RtJ.type, m.this.RtJ.path);
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
  
  public final boolean hhm()
  {
    return this.uSc == 1;
  }
  
  public final void hhn()
  {
    AppMethodBeat.i(214332);
    if ((this.RtJ == null) || (Util.isNullOrNil(this.RtJ.path)))
    {
      AppMethodBeat.o(214332);
      return;
    }
    if (this.RtJ.path.contains("clientversion"))
    {
      Log.w("MicroMsg.JumpRemind", "url.path contain clientversion");
      AppMethodBeat.o(214332);
      return;
    }
    this.RtJ.path = w.q(this.RtJ.path, new String[] { "clientversion" + "=" + d.KyO });
    AppMethodBeat.o(214332);
  }
  
  public final void hho()
  {
    AppMethodBeat.i(72777);
    this.zmm.dead();
    this.RtL.dead();
    AppMethodBeat.o(72777);
  }
  
  final void kP(Context paramContext)
  {
    AppMethodBeat.i(72776);
    Intent localIntent;
    if ((paramContext instanceof i))
    {
      ((i)paramContext).register(new k()
      {
        public final void hhl()
        {
          AppMethodBeat.i(72769);
          m.this.zmm.dead();
          m.this.RtL.dead();
          AppMethodBeat.o(72769);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(72768);
          m.this.zmm.dead();
          m.this.RtL.dead();
          AppMethodBeat.o(72768);
        }
      });
      this.zmm.alive();
      this.RtL.alive();
      this.dDz = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.RtJ.path);
      localIntent.putExtra("showShare", false);
      this.RtK.onEnter();
      com.tencent.mm.wallet_core.ui.f.aA(paramContext, localIntent);
      AppMethodBeat.o(72776);
      return;
    }
    if (this.RtM)
    {
      this.zmm.alive();
      this.RtL.alive();
      this.dDz = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.RtJ.path);
      localIntent.putExtra("showShare", false);
      this.RtK.onEnter();
      com.tencent.mm.wallet_core.ui.f.aA(paramContext, localIntent);
    }
    AppMethodBeat.o(72776);
  }
  
  static final class a
  {
    String MPC;
    String dNI;
    String gTt;
    String path;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.m
 * JD-Core Version:    0.7.0.1
 */