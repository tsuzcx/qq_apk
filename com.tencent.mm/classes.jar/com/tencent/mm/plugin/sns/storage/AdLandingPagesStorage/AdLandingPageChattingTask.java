package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.service.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;

public class AdLandingPageChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AdLandingPageChattingTask> CREATOR;
  public String kJP;
  public Runnable krg;
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
    e(paramParcel);
    AppMethodBeat.o(96306);
  }
  
  public final void aOA()
  {
    AppMethodBeat.i(96307);
    if (!g.ajA().gAD)
    {
      bhX();
      AppMethodBeat.o(96307);
      return;
    }
    am localam = ((l)g.ab(l.class)).azp().Bf(this.username);
    ad.d("MicroMsg.AdLandingPageChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.kJP, this.username, this.nickname });
    if ((localam == null) || ((int)localam.gfj == 0))
    {
      localam = new am(this.username);
      localam.setType(0);
      localam.sT(this.nickname);
      ((l)g.ab(l.class)).azp().ag(localam);
      ad.i("MicroMsg.AdLandingPageChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    ((n)g.ab(n.class)).b(this.username, new n.a()
    {
      public final void b(WxaAttributes paramAnonymousWxaAttributes)
      {
        AppMethodBeat.i(96304);
        if (paramAnonymousWxaAttributes == null) {
          ad.w("MicroMsg.AdLandingPageChattingTask", "info is null, err");
        }
        AdLandingPageChattingTask.a(AdLandingPageChattingTask.this);
        AppMethodBeat.o(96304);
      }
    });
    AppMethodBeat.o(96307);
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(96308);
    if (this.krg != null) {
      this.krg.run();
    }
    AppMethodBeat.o(96308);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(96309);
    this.kJP = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    AppMethodBeat.o(96309);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96310);
    paramParcel.writeString(this.kJP);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(96310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask
 * JD-Core Version:    0.7.0.1
 */