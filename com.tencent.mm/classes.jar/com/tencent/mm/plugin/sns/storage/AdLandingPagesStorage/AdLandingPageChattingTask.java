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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;

public class AdLandingPageChattingTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AdLandingPageChattingTask> CREATOR;
  public Runnable jWP;
  public String koP;
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
  
  public final void aLq()
  {
    AppMethodBeat.i(96307);
    if (!g.agP().ggT)
    {
      bet();
      AppMethodBeat.o(96307);
      return;
    }
    ai localai = ((k)g.ab(k.class)).awB().aNt(this.username);
    ac.d("MicroMsg.AdLandingPageChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[] { this.koP, this.username, this.nickname });
    if ((localai == null) || ((int)localai.fLJ == 0))
    {
      localai = new ai(this.username);
      localai.setType(0);
      localai.qj(this.nickname);
      ((k)g.ab(k.class)).awB().ag(localai);
      ac.i("MicroMsg.AdLandingPageChattingTask", "%s save to contact_table", new Object[] { this.username });
    }
    ((m)g.ab(m.class)).b(this.username, new m.a()
    {
      public final void b(WxaAttributes paramAnonymousWxaAttributes)
      {
        AppMethodBeat.i(96304);
        if (paramAnonymousWxaAttributes == null) {
          ac.w("MicroMsg.AdLandingPageChattingTask", "info is null, err");
        }
        AdLandingPageChattingTask.a(AdLandingPageChattingTask.this);
        AppMethodBeat.o(96304);
      }
    });
    AppMethodBeat.o(96307);
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(96308);
    if (this.jWP != null) {
      this.jWP.run();
    }
    AppMethodBeat.o(96308);
  }
  
  public final void e(Parcel paramParcel)
  {
    AppMethodBeat.i(96309);
    this.koP = paramParcel.readString();
    this.username = paramParcel.readString();
    this.nickname = paramParcel.readString();
    AppMethodBeat.o(96309);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(96310);
    paramParcel.writeString(this.koP);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nickname);
    AppMethodBeat.o(96310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask
 * JD-Core Version:    0.7.0.1
 */