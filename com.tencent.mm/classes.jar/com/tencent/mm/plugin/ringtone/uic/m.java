package com.tencent.mm.plugin.ringtone.uic;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.b;
import com.tencent.mm.protocal.protobuf.a.c;
import com.tencent.mm.protocal.protobuf.a.u;
import com.tencent.mm.protocal.protobuf.a.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtoneSelectReportUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "channel", "", "listSize", "mCalledType", "mCanVibrate", "", "mClickRingtone", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;", "mClickTimes", "", "mScene", "mSearchKey", "", "mSetType", "mUserName", "reportSessionId", "getReportSessionId", "()J", "setReportSessionId", "(J)V", "addItem", "", "doReportChoiceRingtone", "ringtoneData", "doReportClickRingtone", "canVibrate", "doReportRecommendExit", "happenClickRingtone", "initScene", "scene", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "setSearchKey", "key", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends UIComponent
{
  public static final m.a OFH;
  private int OED;
  long OFI;
  int OFJ;
  int OFK;
  String OFL;
  e OFM;
  long OFN;
  boolean OFO;
  int channel;
  String luk;
  int mScene;
  
  static
  {
    AppMethodBeat.i(273321);
    OFH = new m.a((byte)0);
    AppMethodBeat.o(273321);
  }
  
  public m(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273314);
    this.OED = 1;
    this.luk = "";
    this.OFL = "";
    AppMethodBeat.o(273314);
  }
  
  final void BR(boolean paramBoolean)
  {
    long l2 = 0L;
    AppMethodBeat.i(273371);
    Object localObject = this.OFM;
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      AppMethodBeat.o(273371);
      return;
      localObject = ((e)localObject).OCa;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Integer.valueOf(((aa)localObject).vhJ);
      }
    }
    int j = ((Integer)localObject).intValue();
    int i = j;
    if (j == 100) {
      i = 3;
    }
    switch (i)
    {
    default: 
      localObject = Integer.valueOf(0);
    }
    while (localObject == null)
    {
      AppMethodBeat.o(273371);
      return;
      localObject = this.OFM;
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        localObject = ((e)localObject).OCa;
        if (localObject == null)
        {
          localObject = null;
        }
        else
        {
          localObject = ((aa)localObject).acjr;
          if (localObject == null)
          {
            localObject = null;
          }
          else
          {
            localObject = ((v)localObject).acjj;
            if (localObject == null)
            {
              localObject = null;
            }
            else
            {
              localObject = Integer.valueOf(((u)localObject).aaYO);
              continue;
              localObject = this.OFM;
              if (localObject == null) {
                l1 = l2;
              }
              for (;;)
              {
                localObject = com.tencent.mm.ae.d.hF(l1);
                break;
                localObject = ((e)localObject).OCa;
                l1 = l2;
                if (localObject != null)
                {
                  localObject = ((aa)localObject).acjs;
                  l1 = l2;
                  if (localObject != null)
                  {
                    localObject = ((c)localObject).aciR;
                    l1 = l2;
                    if (localObject != null) {
                      l1 = ((b)localObject).aacf;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    long l1 = Util.ticksToNow(this.OFN);
    com.tencent.mm.plugin.ringtone.h.a locala = com.tencent.mm.plugin.ringtone.h.a.ODG;
    com.tencent.mm.plugin.ringtone.h.a.a(String.valueOf(this.OFI), localObject.toString(), i, this.mScene, (int)l1, this.OED, this.luk, this.OFK, this.channel, this.OFL, paramBoolean);
    this.OFM = null;
    AppMethodBeat.o(273371);
  }
  
  public final void a(e parame)
  {
    long l2 = 0L;
    AppMethodBeat.i(273386);
    s.u(parame, "ringtoneData");
    if ((s.p(parame, this.OFM)) && (this.OFM != null))
    {
      parame = this.OFM;
      if (parame == null) {
        parame = null;
      }
      while (parame == null)
      {
        AppMethodBeat.o(273386);
        return;
        parame = parame.OCa;
        if (parame == null) {
          parame = null;
        } else {
          parame = Integer.valueOf(parame.vhJ);
        }
      }
      int j = parame.intValue();
      int i = j;
      if (j == 100) {
        i = 3;
      }
      switch (i)
      {
      default: 
        parame = Integer.valueOf(0);
      }
      while (parame == null)
      {
        AppMethodBeat.o(273386);
        return;
        parame = this.OFM;
        if (parame == null)
        {
          parame = null;
        }
        else
        {
          parame = parame.OCa;
          if (parame == null)
          {
            parame = null;
          }
          else
          {
            parame = parame.acjr;
            if (parame == null)
            {
              parame = null;
            }
            else
            {
              parame = parame.acjj;
              if (parame == null)
              {
                parame = null;
              }
              else
              {
                parame = Integer.valueOf(parame.aaYO);
                continue;
                parame = this.OFM;
                if (parame == null) {
                  l1 = l2;
                }
                for (;;)
                {
                  parame = com.tencent.mm.ae.d.hF(l1);
                  break;
                  parame = parame.OCa;
                  l1 = l2;
                  if (parame != null)
                  {
                    parame = parame.acjs;
                    l1 = l2;
                    if (parame != null)
                    {
                      parame = parame.aciR;
                      l1 = l2;
                      if (parame != null) {
                        l1 = parame.aacf;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      long l1 = Util.ticksToNow(this.OFN);
      com.tencent.mm.plugin.ringtone.h.a.a(String.valueOf(this.OFI), parame.toString(), i, this.mScene, (int)l1, this.OED, this.luk, this.OFK, this.channel, this.OFL);
    }
    AppMethodBeat.o(273386);
  }
  
  public final void cy()
  {
    this.OFJ += 1;
  }
  
  public final void gPb()
  {
    AppMethodBeat.i(273392);
    if (this.mScene == 1)
    {
      l = Util.ticksToNow(this.OFI);
      com.tencent.mm.plugin.ringtone.h.a.a(String.valueOf(this.OFI), this.OFJ, this.mScene, l, this.OED, this.luk, this.OFK, this.channel);
      AppMethodBeat.o(273392);
      return;
    }
    long l = Util.ticksToNow(this.OFI);
    com.tencent.mm.plugin.ringtone.h.a.a(String.valueOf(this.OFI), this.OFJ, this.mScene, l, this.OED, this.luk, this.OFK, this.channel, this.OFL);
    this.OFI = Util.currentTicks();
    this.OFJ = 0;
    AppMethodBeat.o(273392);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(273355);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.OED = getIntent().getIntExtra("ringtone_caller", 1);
    String str = getIntent().getStringExtra("exclusvie_name");
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    this.luk = paramIntent;
    if (((CharSequence)this.luk).length() == 0)
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        Log.e("MicroMsg.RingtoneKVReportUIC", "not pass exclusive ringtone name, default my username");
        paramIntent = z.bAM();
        s.s(paramIntent, "getUsernameFromUserInfo()");
        this.luk = paramIntent;
      }
      this.OFI = Util.currentTicks();
      if ((com.tencent.mm.plugin.ringtone.d.a.tK(this.luk.hashCode()) == null) && (com.tencent.mm.plugin.ringtone.d.aUs(this.luk) == null)) {
        break label148;
      }
    }
    label148:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      this.OFK = paramInt1;
      AppMethodBeat.o(273355);
      return;
      paramInt1 = 0;
      break;
    }
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(273333);
    super.onCreateAfter(paramBundle);
    this.OED = getIntent().getIntExtra("ringtone_caller", 1);
    String str = getIntent().getStringExtra("exclusvie_name");
    paramBundle = str;
    if (str == null) {
      paramBundle = "";
    }
    this.luk = paramBundle;
    this.channel = getIntent().getIntExtra("channel", 0);
    if (((CharSequence)this.luk).length() == 0)
    {
      i = 1;
      if (i != 0)
      {
        Log.e("MicroMsg.RingtoneKVReportUIC", "not pass exclusive ringtone name, default my username");
        paramBundle = z.bAM();
        s.s(paramBundle, "getUsernameFromUserInfo()");
        this.luk = paramBundle;
      }
      this.OFI = Util.currentTicks();
      if ((com.tencent.mm.plugin.ringtone.d.a.tK(this.luk.hashCode()) == null) && (com.tencent.mm.plugin.ringtone.d.aUs(this.luk) == null)) {
        break label160;
      }
    }
    label160:
    for (int i = 2;; i = 1)
    {
      this.OFK = i;
      AppMethodBeat.o(273333);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273400);
    super.onDestroy();
    BR(this.OFO);
    gPb();
    AppMethodBeat.o(273400);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(273377);
    super.onPause();
    BR(this.OFO);
    AppMethodBeat.o(273377);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.m
 * JD-Core Version:    0.7.0.1
 */