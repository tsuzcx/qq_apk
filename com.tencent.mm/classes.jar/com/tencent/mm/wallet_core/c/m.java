package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zo;
import com.tencent.mm.g.a.zt;
import com.tencent.mm.g.a.zt.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bst;
import com.tencent.mm.protocal.protobuf.cth;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.tools.v;
import org.json.JSONObject;

public final class m
{
  boolean Hgr;
  a LUT;
  f LUU;
  c<zo> LUV;
  public boolean LUW;
  boolean dmj;
  String dyI;
  String kCZ;
  String kDa;
  String title;
  int uIW;
  c<zt> vSg;
  
  public m()
  {
    AppMethodBeat.i(72770);
    this.dmj = false;
    this.vSg = new c() {};
    this.LUV = new c() {};
    this.LUW = false;
    AppMethodBeat.o(72770);
  }
  
  public static m a(bst parambst)
  {
    AppMethodBeat.i(72771);
    if (parambst == null)
    {
      AppMethodBeat.o(72771);
      return null;
    }
    m localm = new m();
    localm.Hgr = parambst.Hgr;
    localm.uIW = parambst.uIW;
    localm.dyI = parambst.dyI;
    localm.kCZ = parambst.kCZ;
    localm.kDa = parambst.kDa;
    localm.title = parambst.title;
    localm.LUT = new a();
    if (parambst.Hgs != null)
    {
      localm.LUT.type = parambst.Hgs.type;
      localm.LUT.dwb = parambst.Hgs.dwb;
      localm.LUT.HEu = parambst.Hgs.HEu;
      localm.LUT.path = parambst.Hgs.path;
      localm.LUT.COl = parambst.Hgs.COl;
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
        ae.i("MicroMsg.JumpRemind", "feed %s", new Object[] { paramJSONObject });
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
            ((m)localObject).uIW = paramJSONObject.optInt("jump_type");
            ((m)localObject).Hgr = paramJSONObject.optBoolean("is_pop_up_windows");
            ((m)localObject).dyI = paramJSONObject.optString("wording");
            ((m)localObject).kCZ = paramJSONObject.optString("left_button_wording");
            ((m)localObject).kDa = paramJSONObject.optString("right_button_wording");
            ((m)localObject).title = paramJSONObject.optString("title");
            paramJSONObject = paramJSONObject.optJSONObject("url");
            ((m)localObject).LUT = new a();
            if (paramJSONObject != null)
            {
              ((m)localObject).LUT.type = paramJSONObject.optInt("type");
              ((m)localObject).LUT.dwb = paramJSONObject.optString("appid");
              ((m)localObject).LUT.HEu = paramJSONObject.optString("app_version");
              ((m)localObject).LUT.path = paramJSONObject.optString("path");
              ((m)localObject).LUT.COl = paramJSONObject.optString("button_name");
            }
            AppMethodBeat.o(72772);
            return localObject;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        ae.printErrStackTrace("MicroMsg.JumpRemind", paramJSONObject, "error create", new Object[0]);
        AppMethodBeat.o(72772);
        return null;
      }
    }
  }
  
  public final boolean a(final Activity paramActivity, f paramf)
  {
    AppMethodBeat.i(72773);
    this.LUU = paramf;
    if (this.Hgr)
    {
      com.tencent.mm.ui.base.h.e(paramActivity, this.dyI, this.title, this.kDa, this.kCZ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72761);
          ae.i("MicroMsg.JumpRemind", "onClick1 ");
          if ((m.this.LUT != null) && (m.this.LUT.COl.equals("right_button_wording")))
          {
            m.this.kT(paramActivity);
            AppMethodBeat.o(72761);
            return;
          }
          m.this.LUU.onCancel();
          AppMethodBeat.o(72761);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72762);
          ae.i("MicroMsg.JumpRemind", "onClick2");
          if ((m.this.LUT != null) && (m.this.LUT.COl.equals("left_button_wording")))
          {
            m.this.kT(paramActivity);
            AppMethodBeat.o(72762);
            return;
          }
          m.this.LUU.onCancel();
          AppMethodBeat.o(72762);
        }
      });
      AppMethodBeat.o(72773);
      return true;
    }
    kT(paramActivity);
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
        if (m.this.fVP())
        {
          paramg.dmz();
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
        if (m.this.fVP())
        {
          paramg.dmz();
          AppMethodBeat.o(72765);
          return;
        }
        paramActivity.finish();
        AppMethodBeat.o(72765);
      }
      
      public final void onUrlOk()
      {
        AppMethodBeat.i(72764);
        if (m.this.fVP()) {
          paramg.dmz();
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
    com.tencent.mm.ui.base.h.e(paramActivity, this.dyI, this.title, this.kDa, this.kCZ, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72766);
        ae.i("MicroMsg.JumpRemind", "onClick1 ");
        if ((m.this.LUT != null) && (m.this.LUT.COl.equals("right_button_wording")))
        {
          paramh.bu(m.this.LUT.type, m.this.LUT.path);
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
        ae.i("MicroMsg.JumpRemind", "onClick2");
        if ((m.this.LUT != null) && (m.this.LUT.COl.equals("left_button_wording")))
        {
          paramh.bu(m.this.LUT.type, m.this.LUT.path);
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
  
  public final boolean fVP()
  {
    return this.uIW == 1;
  }
  
  public final void fVQ()
  {
    AppMethodBeat.i(190251);
    if ((this.LUT == null) || (bu.isNullOrNil(this.LUT.path)))
    {
      AppMethodBeat.o(190251);
      return;
    }
    if (this.LUT.path.contains("clientversion"))
    {
      ae.w("MicroMsg.JumpRemind", "url.path contain clientversion");
      AppMethodBeat.o(190251);
      return;
    }
    this.LUT.path = v.q(this.LUT.path, new String[] { "clientversion" + "=" + d.FFH });
    AppMethodBeat.o(190251);
  }
  
  public final void fVR()
  {
    AppMethodBeat.i(72777);
    this.vSg.dead();
    this.LUV.dead();
    AppMethodBeat.o(72777);
  }
  
  final void kT(Context paramContext)
  {
    AppMethodBeat.i(72776);
    Intent localIntent;
    if ((paramContext instanceof i))
    {
      ((i)paramContext).register(new k()
      {
        public final void fVO()
        {
          AppMethodBeat.i(72769);
          m.this.vSg.dead();
          m.this.LUV.dead();
          AppMethodBeat.o(72769);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(72768);
          m.this.vSg.dead();
          m.this.LUV.dead();
          AppMethodBeat.o(72768);
        }
      });
      this.vSg.alive();
      this.LUV.alive();
      this.dmj = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.LUT.path);
      localIntent.putExtra("showShare", false);
      this.LUU.onEnter();
      com.tencent.mm.wallet_core.ui.f.an(paramContext, localIntent);
      AppMethodBeat.o(72776);
      return;
    }
    if (this.LUW)
    {
      this.vSg.alive();
      this.LUV.alive();
      this.dmj = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.LUT.path);
      localIntent.putExtra("showShare", false);
      this.LUU.onEnter();
      com.tencent.mm.wallet_core.ui.f.an(paramContext, localIntent);
    }
    AppMethodBeat.o(72776);
  }
  
  static final class a
  {
    String COl;
    String HEu;
    String dwb;
    String path;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.m
 * JD-Core Version:    0.7.0.1
 */