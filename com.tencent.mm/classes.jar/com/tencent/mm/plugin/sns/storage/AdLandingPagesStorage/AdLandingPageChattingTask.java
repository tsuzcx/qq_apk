package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.o.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

public class AdLandingPageChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AdLandingPageChattingTask> CREATOR;
  public String kNe;
  public Runnable kuv;
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
  
  public final void aOX()
  {
    AppMethodBeat.i(96307);
    if (!g.ajP().gDk)
    {
      biG();
      AppMethodBeat.o(96307);
      return;
    }
    an localan = ((l)g.ab(l.class)).azF().BH(this.username);
    ae.d("MicroMsg.AdLandingPageChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.kNe, this.username, this.nickname });
    if ((localan == null) || ((int)localan.ght == 0))
    {
      localan = new an(this.username);
      localan.setType(0);
      localan.to(this.nickname);
      ((l)g.ab(l.class)).azF().an(localan);
      ae.i("MicroMsg.AdLandingPageChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    ((o)g.ab(o.class)).b(this.username, new o.a()
    {
      public final void b(WxaAttributes paramAnonymousWxaAttributes)
      {
        AppMethodBeat.i(96304);
        if (paramAnonymousWxaAttributes == null) {
          ae.w("MicroMsg.AdLandingPageChattingTask", "info is null, err");
        }
        AdLandingPageChattingTask.a(AdLandingPageChattingTask.this);
        AppMethodBeat.o(96304);
      }
    });
    AppMethodBeat.o(96307);
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(96308);
    if (this.kuv != null) {
      this.kuv.run();
    }
    AppMethodBeat.o(96308);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(96309);
    this.kNe = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    AppMethodBeat.o(96309);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96310);
    paramParcel.writeString(this.kNe);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(96310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask
 * JD-Core Version:    0.7.0.1
 */