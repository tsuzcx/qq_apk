package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zn;
import com.tencent.mm.g.a.zn.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.brz;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.wallet_core.ui.e;
import org.json.JSONObject;

public final class m
{
  boolean GMQ;
  a Lye;
  f Lyf;
  c<zi> Lyg;
  public boolean Lyh;
  boolean dlh;
  String dxD;
  String kzK;
  String kzL;
  String title;
  int uxt;
  c<zn> vGc;
  
  public m()
  {
    AppMethodBeat.i(72770);
    this.dlh = false;
    this.vGc = new c() {};
    this.Lyg = new c() {};
    this.Lyh = false;
    AppMethodBeat.o(72770);
  }
  
  public static m a(brz parambrz)
  {
    AppMethodBeat.i(72771);
    if (parambrz == null)
    {
      AppMethodBeat.o(72771);
      return null;
    }
    m localm = new m();
    localm.GMQ = parambrz.GMQ;
    localm.uxt = parambrz.uxt;
    localm.dxD = parambrz.dxD;
    localm.kzK = parambrz.kzK;
    localm.kzL = parambrz.kzL;
    localm.title = parambrz.title;
    localm.Lye = new a();
    if (parambrz.GMR != null)
    {
      localm.Lye.type = parambrz.GMR.type;
      localm.Lye.duW = parambrz.GMR.duW;
      localm.Lye.HkU = parambrz.GMR.HkU;
      localm.Lye.path = parambrz.GMR.path;
      localm.Lye.CwG = parambrz.GMR.CwG;
    }
    AppMethodBeat.o(72771);
    return localm;
  }
  
  public static m bJ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72772);
    label268:
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.JumpRemind", "feed %s", new Object[] { paramJSONObject });
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
            ((m)localObject).uxt = paramJSONObject.optInt("jump_type");
            ((m)localObject).GMQ = paramJSONObject.optBoolean("is_pop_up_windows");
            ((m)localObject).dxD = paramJSONObject.optString("wording");
            ((m)localObject).kzK = paramJSONObject.optString("left_button_wording");
            ((m)localObject).kzL = paramJSONObject.optString("right_button_wording");
            ((m)localObject).title = paramJSONObject.optString("title");
            paramJSONObject = paramJSONObject.optJSONObject("url");
            ((m)localObject).Lye = new a();
            if (paramJSONObject != null)
            {
              ((m)localObject).Lye.type = paramJSONObject.optInt("type");
              ((m)localObject).Lye.duW = paramJSONObject.optString("appid");
              ((m)localObject).Lye.HkU = paramJSONObject.optString("app_version");
              ((m)localObject).Lye.path = paramJSONObject.optString("path");
              ((m)localObject).Lye.CwG = paramJSONObject.optString("button_name");
            }
            AppMethodBeat.o(72772);
            return localObject;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        ad.printErrStackTrace("MicroMsg.JumpRemind", paramJSONObject, "error create", new Object[0]);
        AppMethodBeat.o(72772);
        return null;
      }
    }
  }
  
  public final boolean a(final Activity paramActivity, f paramf)
  {
    AppMethodBeat.i(72773);
    this.Lyf = paramf;
    if (this.GMQ)
    {
      com.tencent.mm.ui.base.h.e(paramActivity, this.dxD, this.title, this.kzL, this.kzK, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72761);
          ad.i("MicroMsg.JumpRemind", "onClick1 ");
          if ((m.this.Lye != null) && (m.this.Lye.CwG.equals("right_button_wording")))
          {
            m.this.kM(paramActivity);
            AppMethodBeat.o(72761);
            return;
          }
          m.this.Lyf.onCancel();
          AppMethodBeat.o(72761);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72762);
          ad.i("MicroMsg.JumpRemind", "onClick2");
          if ((m.this.Lye != null) && (m.this.Lye.CwG.equals("left_button_wording")))
          {
            m.this.kM(paramActivity);
            AppMethodBeat.o(72762);
            return;
          }
          m.this.Lyf.onCancel();
          AppMethodBeat.o(72762);
        }
      });
      AppMethodBeat.o(72773);
      return true;
    }
    kM(paramActivity);
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
        if (m.this.fRt())
        {
          paramg.djA();
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
        if (m.this.fRt())
        {
          paramg.djA();
          AppMethodBeat.o(72765);
          return;
        }
        paramActivity.finish();
        AppMethodBeat.o(72765);
      }
      
      public final void onUrlOk()
      {
        AppMethodBeat.i(72764);
        if (m.this.fRt()) {
          paramg.djA();
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
    com.tencent.mm.ui.base.h.e(paramActivity, this.dxD, this.title, this.kzL, this.kzK, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72766);
        ad.i("MicroMsg.JumpRemind", "onClick1 ");
        if ((m.this.Lye != null) && (m.this.Lye.CwG.equals("right_button_wording")))
        {
          paramh.bv(m.this.Lye.type, m.this.Lye.path);
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
        ad.i("MicroMsg.JumpRemind", "onClick2");
        if ((m.this.Lye != null) && (m.this.Lye.CwG.equals("left_button_wording")))
        {
          paramh.bv(m.this.Lye.type, m.this.Lye.path);
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
  
  public final boolean fRt()
  {
    return this.uxt == 1;
  }
  
  public final void fRu()
  {
    AppMethodBeat.i(199367);
    if ((this.Lye == null) || (bt.isNullOrNil(this.Lye.path)))
    {
      AppMethodBeat.o(199367);
      return;
    }
    if (this.Lye.path.contains("clientversion"))
    {
      ad.w("MicroMsg.JumpRemind", "url.path contain clientversion");
      AppMethodBeat.o(199367);
      return;
    }
    this.Lye.path = v.q(this.Lye.path, new String[] { "clientversion" + "=" + d.Fnj });
    AppMethodBeat.o(199367);
  }
  
  public final void fRv()
  {
    AppMethodBeat.i(72777);
    this.vGc.dead();
    this.Lyg.dead();
    AppMethodBeat.o(72777);
  }
  
  final void kM(Context paramContext)
  {
    AppMethodBeat.i(72776);
    Intent localIntent;
    if ((paramContext instanceof i))
    {
      ((i)paramContext).register(new k()
      {
        public final void fRs()
        {
          AppMethodBeat.i(72769);
          m.this.vGc.dead();
          m.this.Lyg.dead();
          AppMethodBeat.o(72769);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(72768);
          m.this.vGc.dead();
          m.this.Lyg.dead();
          AppMethodBeat.o(72768);
        }
      });
      this.vGc.alive();
      this.Lyg.alive();
      this.dlh = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.Lye.path);
      localIntent.putExtra("showShare", false);
      this.Lyf.onEnter();
      e.an(paramContext, localIntent);
      AppMethodBeat.o(72776);
      return;
    }
    if (this.Lyh)
    {
      this.vGc.alive();
      this.Lyg.alive();
      this.dlh = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.Lye.path);
      localIntent.putExtra("showShare", false);
      this.Lyf.onEnter();
      e.an(paramContext, localIntent);
    }
    AppMethodBeat.o(72776);
  }
  
  static final class a
  {
    String CwG;
    String HkU;
    String duW;
    String path;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.m
 * JD-Core Version:    0.7.0.1
 */