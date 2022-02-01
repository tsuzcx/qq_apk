package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.appbrand.service.m.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;

public class AdLandingPageChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AdLandingPageChattingTask> CREATOR;
  public String jOo;
  public Runnable jwt;
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
  
  public final void aEA()
  {
    AppMethodBeat.i(96308);
    if (this.jwt != null) {
      this.jwt.run();
    }
    AppMethodBeat.o(96308);
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(96307);
    if (!g.afz().gcn)
    {
      aXw();
      AppMethodBeat.o(96307);
      return;
    }
    af localaf = ((k)g.ab(k.class)).apM().aHY(this.username);
    ad.d("MicroMsg.AdLandingPageChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.jOo, this.username, this.nickname });
    if ((localaf == null) || ((int)localaf.fId == 0))
    {
      localaf = new af(this.username);
      localaf.setType(0);
      localaf.nd(this.nickname);
      ((k)g.ab(k.class)).apM().af(localaf);
      ad.i("MicroMsg.AdLandingPageChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    ((m)g.ab(m.class)).b(this.username, new m.a()
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
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(96309);
    this.jOo = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    AppMethodBeat.o(96309);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96310);
    paramParcel.writeString(this.jOo);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(96310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask
 * JD-Core Version:    0.7.0.1
 */