package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yd;
import com.tencent.mm.g.a.yi;
import com.tencent.mm.g.a.yi.a;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.e;
import org.json.JSONObject;

public final class m
{
  boolean DHT;
  c<yd> IdA;
  public boolean IdB;
  public a Idy;
  f Idz;
  boolean dcq;
  String doh;
  String tfH;
  String tfI;
  String title;
  c<yi> tuR;
  int uaQ;
  
  public m()
  {
    AppMethodBeat.i(72770);
    this.dcq = false;
    this.tuR = new c() {};
    this.IdA = new c() {};
    this.IdB = false;
    AppMethodBeat.o(72770);
  }
  
  public static m a(bju parambju)
  {
    AppMethodBeat.i(72771);
    if (parambju == null)
    {
      AppMethodBeat.o(72771);
      return null;
    }
    m localm = new m();
    localm.DHT = parambju.DHT;
    localm.uaQ = parambju.uaQ;
    localm.doh = parambju.doh;
    localm.tfH = parambju.tfH;
    localm.tfI = parambju.tfI;
    localm.title = parambju.title;
    localm.Idy = new a();
    if (parambju.DHU != null)
    {
      localm.Idy.type = parambju.DHU.type;
      localm.Idy.dlB = parambju.DHU.dlB;
      localm.Idy.EdI = parambju.DHU.EdI;
      localm.Idy.path = parambju.DHU.path;
      localm.Idy.zEk = parambju.DHU.zEk;
    }
    AppMethodBeat.o(72771);
    return localm;
  }
  
  public static m bz(JSONObject paramJSONObject)
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
            ((m)localObject).uaQ = paramJSONObject.optInt("jump_type");
            ((m)localObject).DHT = paramJSONObject.optBoolean("is_pop_up_windows");
            ((m)localObject).doh = paramJSONObject.optString("wording");
            ((m)localObject).tfH = paramJSONObject.optString("left_button_wording");
            ((m)localObject).tfI = paramJSONObject.optString("right_button_wording");
            ((m)localObject).title = paramJSONObject.optString("title");
            paramJSONObject = paramJSONObject.optJSONObject("url");
            ((m)localObject).Idy = new a();
            if (paramJSONObject != null)
            {
              ((m)localObject).Idy.type = paramJSONObject.optInt("type");
              ((m)localObject).Idy.dlB = paramJSONObject.optString("appid");
              ((m)localObject).Idy.EdI = paramJSONObject.optString("app_version");
              ((m)localObject).Idy.path = paramJSONObject.optString("path");
              ((m)localObject).Idy.zEk = paramJSONObject.optString("button_name");
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
    this.Idz = paramf;
    if (this.DHT)
    {
      com.tencent.mm.ui.base.h.d(paramActivity, this.doh, this.title, this.tfI, this.tfH, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72761);
          ad.i("MicroMsg.JumpRemind", "onClick1 ");
          if ((m.this.Idy != null) && (m.this.Idy.zEk.equals("right_button_wording")))
          {
            m.this.ko(paramActivity);
            AppMethodBeat.o(72761);
            return;
          }
          m.this.Idz.onCancel();
          AppMethodBeat.o(72761);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72762);
          ad.i("MicroMsg.JumpRemind", "onClick2");
          if ((m.this.Idy != null) && (m.this.Idy.zEk.equals("left_button_wording")))
          {
            m.this.ko(paramActivity);
            AppMethodBeat.o(72762);
            return;
          }
          m.this.Idz.onCancel();
          AppMethodBeat.o(72762);
        }
      });
      AppMethodBeat.o(72773);
      return true;
    }
    ko(paramActivity);
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
        if (m.this.fjU())
        {
          paramg.cMH();
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
        if (m.this.fjU())
        {
          paramg.cMH();
          AppMethodBeat.o(72765);
          return;
        }
        paramActivity.finish();
        AppMethodBeat.o(72765);
      }
      
      public final void onUrlOk()
      {
        AppMethodBeat.i(72764);
        if (m.this.fjU()) {
          paramg.cMH();
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
    com.tencent.mm.ui.base.h.d(paramActivity, this.doh, this.title, this.tfI, this.tfH, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(72766);
        ad.i("MicroMsg.JumpRemind", "onClick1 ");
        if ((m.this.Idy != null) && (m.this.Idy.zEk.equals("right_button_wording")))
        {
          paramh.bm(m.this.Idy.type, m.this.Idy.path);
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
        if ((m.this.Idy != null) && (m.this.Idy.zEk.equals("left_button_wording")))
        {
          paramh.bm(m.this.Idy.type, m.this.Idy.path);
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
  
  public final boolean fjU()
  {
    return this.uaQ == 1;
  }
  
  public final void fjV()
  {
    AppMethodBeat.i(72777);
    this.tuR.dead();
    this.IdA.dead();
    AppMethodBeat.o(72777);
  }
  
  final void ko(Context paramContext)
  {
    AppMethodBeat.i(72776);
    Intent localIntent;
    if ((paramContext instanceof i))
    {
      ((i)paramContext).register(new k()
      {
        public final void fjT()
        {
          AppMethodBeat.i(72769);
          m.this.tuR.dead();
          m.this.IdA.dead();
          AppMethodBeat.o(72769);
        }
        
        public final void onDestroy()
        {
          AppMethodBeat.i(72768);
          m.this.tuR.dead();
          m.this.IdA.dead();
          AppMethodBeat.o(72768);
        }
      });
      this.tuR.alive();
      this.IdA.alive();
      this.dcq = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.Idy.path);
      localIntent.putExtra("showShare", false);
      this.Idz.onEnter();
      e.X(paramContext, localIntent);
      AppMethodBeat.o(72776);
      return;
    }
    if (this.IdB)
    {
      this.tuR.alive();
      this.IdA.alive();
      this.dcq = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.Idy.path);
      localIntent.putExtra("showShare", false);
      this.Idz.onEnter();
      e.X(paramContext, localIntent);
    }
    AppMethodBeat.o(72776);
  }
  
  public static final class a
  {
    String EdI;
    String dlB;
    public String path;
    int type;
    String zEk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.m
 * JD-Core Version:    0.7.0.1
 */