package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.appbrand.service.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public class AdLandingPageChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AdLandingPageChattingTask> CREATOR;
  public Runnable hxp;
  public String nickname;
  public String sessionFrom;
  public String username;
  
  static
  {
    AppMethodBeat.i(145295);
    CREATOR = new AdLandingPageChattingTask.2();
    AppMethodBeat.o(145295);
  }
  
  public AdLandingPageChattingTask() {}
  
  public AdLandingPageChattingTask(Parcel paramParcel)
  {
    AppMethodBeat.i(145289);
    f(paramParcel);
    AppMethodBeat.o(145289);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(145290);
    if (!g.RJ().eHg)
    {
      aBp();
      AppMethodBeat.o(145290);
      return;
    }
    ad localad = ((j)g.E(j.class)).YA().arw(this.username);
    ab.d("MicroMsg.AdLandingPageChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.sessionFrom, this.username, this.nickname });
    if ((localad == null) || ((int)localad.euF == 0))
    {
      localad = new ad(this.username);
      localad.setType(0);
      localad.jp(this.nickname);
      ((j)g.E(j.class)).YA().Y(localad);
      ab.i("MicroMsg.AdLandingPageChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    ((i)g.E(i.class)).b(this.username, new i.a()
    {
      public final void d(WxaAttributes paramAnonymousWxaAttributes)
      {
        AppMethodBeat.i(145287);
        if (paramAnonymousWxaAttributes == null) {
          ab.w("MicroMsg.AdLandingPageChattingTask", "info is null, err");
        }
        AdLandingPageChattingTask.a(AdLandingPageChattingTask.this);
        AppMethodBeat.o(145287);
      }
    });
    AppMethodBeat.o(145290);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(145291);
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(145291);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(145292);
    this.sessionFrom = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    AppMethodBeat.o(145292);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(145293);
    paramParcel.writeString(this.sessionFrom);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(145293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask
 * JD-Core Version:    0.7.0.1
 */