package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public class AdLandingPageChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AdLandingPageChattingTask> CREATOR;
  public String lRW;
  public Runnable lyv;
  public String nickname;
  public String username;
  
  static
  {
    AppMethodBeat.i(96312);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(96312);
  }
  
  public AdLandingPageChattingTask() {}
  
  public AdLandingPageChattingTask(Parcel paramParcel)
  {
    AppMethodBeat.i(96306);
    f(paramParcel);
    AppMethodBeat.o(96306);
  }
  
  public final void bjj()
  {
    AppMethodBeat.i(96307);
    if (!g.aAf().hpY)
    {
      bDU();
      AppMethodBeat.o(96307);
      return;
    }
    as localas = ((l)g.af(l.class)).aSN().Kn(this.username);
    Log.d("MicroMsg.AdLandingPageChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.lRW, this.username, this.nickname });
    if ((localas == null) || ((int)localas.gMZ == 0))
    {
      localas = new as(this.username);
      localas.setType(0);
      localas.setNickname(this.nickname);
      ((l)g.af(l.class)).aSN().ap(localas);
      Log.i("MicroMsg.AdLandingPageChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    ((q)g.af(q.class)).c(this.username, new q.a()
    {
      public final void b(WxaAttributes paramAnonymousWxaAttributes)
      {
        AppMethodBeat.i(96304);
        if (paramAnonymousWxaAttributes == null) {
          Log.w("MicroMsg.AdLandingPageChattingTask", "info is null, err");
        }
        AdLandingPageChattingTask.a(AdLandingPageChattingTask.this);
        AppMethodBeat.o(96304);
      }
    });
    AppMethodBeat.o(96307);
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(96308);
    if (this.lyv != null) {
      this.lyv.run();
    }
    AppMethodBeat.o(96308);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(96309);
    this.lRW = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    AppMethodBeat.o(96309);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96310);
    paramParcel.writeString(this.lRW);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(96310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask
 * JD-Core Version:    0.7.0.1
 */