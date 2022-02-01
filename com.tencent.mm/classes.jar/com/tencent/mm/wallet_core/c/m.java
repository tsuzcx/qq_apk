package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.acd;
import com.tencent.mm.f.a.aci;
import com.tencent.mm.f.a.aci.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.coj;
import com.tencent.mm.protocal.protobuf.dvp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.x;
import org.json.JSONObject;

public class m
{
  private IListener<aci> ERC;
  boolean Twp;
  a YVh;
  f YVi;
  public boolean YVj;
  private IListener<acd> YVk;
  public boolean YVl;
  boolean fwi;
  int jump_type;
  String oDJ;
  String oDK;
  String title;
  String wording;
  
  public m()
  {
    AppMethodBeat.i(72770);
    this.fwi = false;
    this.YVj = true;
    this.ERC = new IListener() {};
    this.YVk = new IListener() {};
    this.YVl = false;
    AppMethodBeat.o(72770);
  }
  
  public static m a(coj paramcoj)
  {
    AppMethodBeat.i(72771);
    if (paramcoj == null)
    {
      AppMethodBeat.o(72771);
      return null;
    }
    m localm = new m();
    localm.Twp = paramcoj.Twp;
    localm.jump_type = paramcoj.jump_type;
    localm.wording = paramcoj.wording;
    localm.oDJ = paramcoj.oDJ;
    localm.oDK = paramcoj.oDK;
    localm.title = paramcoj.title;
    localm.YVh = new a();
    if (paramcoj.Twq != null)
    {
      localm.YVh.type = paramcoj.Twq.type;
      localm.YVh.appid = paramcoj.Twq.appid;
      localm.YVh.UbG = paramcoj.Twq.UbG;
      localm.YVh.path = paramcoj.Twq.path;
      localm.YVh.jDV = paramcoj.Twq.jDV;
    }
    AppMethodBeat.o(72771);
    return localm;
  }
  
  public static m cu(JSONObject paramJSONObject)
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
            ((m)localObject).jump_type = paramJSONObject.optInt("jump_type");
            ((m)localObject).Twp = paramJSONObject.optBoolean("is_pop_up_windows");
            ((m)localObject).wording = paramJSONObject.optString("wording");
            ((m)localObject).oDJ = paramJSONObject.optString("left_button_wording");
            ((m)localObject).oDK = paramJSONObject.optString("right_button_wording");
            ((m)localObject).title = paramJSONObject.optString("title");
            paramJSONObject = paramJSONObject.optJSONObject("url");
            ((m)localObject).YVh = new a();
            if (paramJSONObject != null)
            {
              ((m)localObject).YVh.type = paramJSONObject.optInt("type");
              ((m)localObject).YVh.appid = paramJSONObject.optString("appid");
              ((m)localObject).YVh.UbG = paramJSONObject.optString("app_version");
              ((m)localObject).YVh.path = paramJSONObject.optString("path");
              ((m)localObject).YVh.jDV = paramJSONObject.optString("button_name");
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
  
  private void lL(Context paramContext)
  {
    AppMethodBeat.i(72776);
    Intent localIntent;
    if ((paramContext instanceof i))
    {
      ((i)paramContext).register(new k()
      {
        public final void iiN()
        {
          AppMethodBeat.i(72769);
          m.a(m.this).dead();
          m.b(m.this).dead();
          AppMethodBeat.o(72769);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(72768);
          m.a(m.this).dead();
          m.b(m.this).dead();
          AppMethodBeat.o(72768);
        }
      });
      this.ERC.alive();
      this.YVk.alive();
      this.fwi = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.YVh.path);
      localIntent.putExtra("showShare", false);
      this.YVi.onEnter();
      com.tencent.mm.wallet_core.ui.g.aJ(paramContext, localIntent);
      AppMethodBeat.o(72776);
      return;
    }
    if (this.YVl)
    {
      this.ERC.alive();
      this.YVk.alive();
      this.fwi = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.YVh.path);
      localIntent.putExtra("showShare", false);
      this.YVi.onEnter();
      com.tencent.mm.wallet_core.ui.g.aJ(paramContext, localIntent);
    }
    AppMethodBeat.o(72776);
  }
  
  public final boolean a(final Activity paramActivity, f paramf)
  {
    AppMethodBeat.i(72773);
    this.YVi = paramf;
    if (this.Twp)
    {
      com.tencent.mm.ui.base.h.a(paramActivity, this.YVj, this.wording, this.title, this.oDK, this.oDJ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72761);
          Log.i("MicroMsg.JumpRemind", "onClick1 ");
          if ((m.this.YVh != null) && (m.this.YVh.jDV.equals("right_button_wording")))
          {
            m.a(m.this, paramActivity);
            AppMethodBeat.o(72761);
            return;
          }
          m.this.YVi.onCancel();
          AppMethodBeat.o(72761);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72762);
          Log.i("MicroMsg.JumpRemind", "onClick2");
          if ((m.this.YVh != null) && (m.this.YVh.jDV.equals("left_button_wording")))
          {
            m.a(m.this, paramActivity);
            AppMethodBeat.o(72762);
            return;
          }
          m.this.YVi.onCancel();
          AppMethodBeat.o(72762);
        }
      });
      AppMethodBeat.o(72773);
      return true;
    }
    lL(paramActivity);
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
        if (m.this.iiO())
        {
          paramg.eOt();
          AppMethodBeat.o(72763);
          return;
        }
        paramActivity.finish();
        AppMethodBeat.o(72763);
      }
      
      public final void onEnter()
      {
        AppMethodBeat.i(187644);
        m.this.iiO();
        AppMethodBeat.o(187644);
      }
      
      public final void onUrlCancel()
      {
        AppMethodBeat.i(72765);
        if (m.this.iiO())
        {
          paramg.eOt();
          AppMethodBeat.o(72765);
          return;
        }
        paramActivity.finish();
        AppMethodBeat.o(72765);
      }
      
      public final void onUrlOk()
      {
        AppMethodBeat.i(72764);
        if (m.this.iiO()) {
          paramg.eOt();
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
    com.tencent.mm.ui.base.h.c(paramActivity, this.wording, this.title, this.oDK, this.oDJ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72766);
        Log.i("MicroMsg.JumpRemind", "onClick1 ");
        if ((m.this.YVh != null) && (m.this.YVh.jDV.equals("right_button_wording")))
        {
          paramh.bE(m.this.YVh.type, m.this.YVh.path);
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
        if ((m.this.YVh != null) && (m.this.YVh.jDV.equals("left_button_wording")))
        {
          paramh.bE(m.this.YVh.type, m.this.YVh.path);
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
  
  public final boolean iiO()
  {
    return this.jump_type == 1;
  }
  
  public final void iiP()
  {
    AppMethodBeat.i(269119);
    if ((this.YVh == null) || (Util.isNullOrNil(this.YVh.path)))
    {
      AppMethodBeat.o(269119);
      return;
    }
    if (this.YVh.path.contains("clientversion"))
    {
      Log.w("MicroMsg.JumpRemind", "url.path contain clientversion");
      AppMethodBeat.o(269119);
      return;
    }
    this.YVh.path = x.p(this.YVh.path, new String[] { "clientversion" + "=" + d.RAD });
    AppMethodBeat.o(269119);
  }
  
  public final void iiQ()
  {
    AppMethodBeat.i(72777);
    this.ERC.dead();
    this.YVk.dead();
    AppMethodBeat.o(72777);
  }
  
  static final class a
  {
    String UbG;
    String appid;
    String jDV;
    String path;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.m
 * JD-Core Version:    0.7.0.1
 */