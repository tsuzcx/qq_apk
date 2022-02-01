package com.tencent.mm.wallet_core.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aea;
import com.tencent.mm.autogen.a.aef;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.dfd;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.w;
import org.json.JSONObject;

public class m
{
  private IListener<aef> KMb;
  boolean aaKW;
  a agTb;
  f agTc;
  public boolean agTd;
  private IListener<aea> agTe;
  public boolean agTf;
  boolean hAE;
  int jump_type;
  String rGU;
  String right_button_wording;
  String title;
  String wording;
  
  public m()
  {
    AppMethodBeat.i(72770);
    this.hAE = false;
    this.agTd = true;
    this.KMb = new JumpRemind.1(this, com.tencent.mm.app.f.hfK);
    this.agTe = new JumpRemind.2(this, com.tencent.mm.app.f.hfK);
    this.agTf = false;
    AppMethodBeat.o(72770);
  }
  
  public static m a(dfd paramdfd)
  {
    AppMethodBeat.i(72771);
    if (paramdfd == null)
    {
      AppMethodBeat.o(72771);
      return null;
    }
    m localm = new m();
    localm.aaKW = paramdfd.aaKW;
    localm.jump_type = paramdfd.jump_type;
    localm.wording = paramdfd.wording;
    localm.rGU = paramdfd.rGU;
    localm.right_button_wording = paramdfd.right_button_wording;
    localm.title = paramdfd.title;
    localm.agTb = new a();
    if (paramdfd.aaKX != null)
    {
      localm.agTb.type = paramdfd.aaKX.type;
      localm.agTb.appid = paramdfd.aaKX.appid;
      localm.agTb.absO = paramdfd.aaKX.absO;
      localm.agTb.path = paramdfd.aaKX.path;
      localm.agTb.mdR = paramdfd.aaKX.mdR;
    }
    AppMethodBeat.o(72771);
    return localm;
  }
  
  public static m cP(JSONObject paramJSONObject)
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
            ((m)localObject).aaKW = paramJSONObject.optBoolean("is_pop_up_windows");
            ((m)localObject).wording = paramJSONObject.optString("wording");
            ((m)localObject).rGU = paramJSONObject.optString("left_button_wording");
            ((m)localObject).right_button_wording = paramJSONObject.optString("right_button_wording");
            ((m)localObject).title = paramJSONObject.optString("title");
            paramJSONObject = paramJSONObject.optJSONObject("url");
            ((m)localObject).agTb = new a();
            if (paramJSONObject != null)
            {
              ((m)localObject).agTb.type = paramJSONObject.optInt("type");
              ((m)localObject).agTb.appid = paramJSONObject.optString("appid");
              ((m)localObject).agTb.absO = paramJSONObject.optString("app_version");
              ((m)localObject).agTb.path = paramJSONObject.optString("path");
              ((m)localObject).agTb.mdR = paramJSONObject.optString("button_name");
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
  
  private void nQ(Context paramContext)
  {
    AppMethodBeat.i(72776);
    Intent localIntent;
    if ((paramContext instanceof i))
    {
      ((i)paramContext).register(new k()
      {
        public final void jOI()
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
      this.KMb.alive();
      this.agTe.alive();
      this.hAE = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.agTb.path);
      localIntent.putExtra("showShare", false);
      this.agTc.onEnter();
      com.tencent.mm.wallet_core.ui.i.aS(paramContext, localIntent);
      AppMethodBeat.o(72776);
      return;
    }
    if (this.agTf)
    {
      this.KMb.alive();
      this.agTe.alive();
      this.hAE = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.agTb.path);
      localIntent.putExtra("showShare", false);
      this.agTc.onEnter();
      com.tencent.mm.wallet_core.ui.i.aS(paramContext, localIntent);
    }
    AppMethodBeat.o(72776);
  }
  
  public final boolean a(final Activity paramActivity, f paramf)
  {
    AppMethodBeat.i(72773);
    this.agTc = paramf;
    if (this.aaKW)
    {
      com.tencent.mm.ui.base.k.a(paramActivity, this.agTd, this.wording, this.title, this.right_button_wording, this.rGU, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72761);
          Log.i("MicroMsg.JumpRemind", "onClick1 ");
          if ((m.this.agTb != null) && (m.this.agTb.mdR.equals("right_button_wording")))
          {
            m.a(m.this, paramActivity);
            AppMethodBeat.o(72761);
            return;
          }
          m.this.agTc.onCancel();
          AppMethodBeat.o(72761);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72762);
          Log.i("MicroMsg.JumpRemind", "onClick2");
          if ((m.this.agTb != null) && (m.this.agTb.mdR.equals("left_button_wording")))
          {
            m.a(m.this, paramActivity);
            AppMethodBeat.o(72762);
            return;
          }
          m.this.agTc.onCancel();
          AppMethodBeat.o(72762);
        }
      });
      AppMethodBeat.o(72773);
      return true;
    }
    nQ(paramActivity);
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
        if (m.this.jOJ())
        {
          paramg.fWQ();
          AppMethodBeat.o(72763);
          return;
        }
        paramActivity.finish();
        AppMethodBeat.o(72763);
      }
      
      public final void onEnter()
      {
        AppMethodBeat.i(242150);
        m.this.jOJ();
        AppMethodBeat.o(242150);
      }
      
      public final void onUrlCancel()
      {
        AppMethodBeat.i(72765);
        if (m.this.jOJ())
        {
          paramg.fWQ();
          AppMethodBeat.o(72765);
          return;
        }
        paramActivity.finish();
        AppMethodBeat.o(72765);
      }
      
      public final void onUrlOk()
      {
        AppMethodBeat.i(72764);
        if (m.this.jOJ()) {
          paramg.fWQ();
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
    com.tencent.mm.ui.base.k.b(paramActivity, this.wording, this.title, this.right_button_wording, this.rGU, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72766);
        Log.i("MicroMsg.JumpRemind", "onClick1 ");
        if ((m.this.agTb != null) && (m.this.agTb.mdR.equals("right_button_wording")))
        {
          paramh.cm(m.this.agTb.type, m.this.agTb.path);
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
        if ((m.this.agTb != null) && (m.this.agTb.mdR.equals("left_button_wording")))
        {
          paramh.cm(m.this.agTb.type, m.this.agTb.path);
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
  
  public final boolean jOJ()
  {
    return this.jump_type == 1;
  }
  
  public final void jOK()
  {
    AppMethodBeat.i(242148);
    if ((this.agTb == null) || (Util.isNullOrNil(this.agTb.path)))
    {
      AppMethodBeat.o(242148);
      return;
    }
    if (this.agTb.path.contains("clientversion"))
    {
      Log.w("MicroMsg.JumpRemind", "url.path contain clientversion");
      AppMethodBeat.o(242148);
      return;
    }
    this.agTb.path = w.q(this.agTb.path, new String[] { "clientversion" + "=" + d.Yxh });
    AppMethodBeat.o(242148);
  }
  
  public final void jOL()
  {
    AppMethodBeat.i(72777);
    this.KMb.dead();
    this.agTe.dead();
    AppMethodBeat.o(72777);
  }
  
  static final class a
  {
    String absO;
    String appid;
    String mdR;
    String path;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.m
 * JD-Core Version:    0.7.0.1
 */