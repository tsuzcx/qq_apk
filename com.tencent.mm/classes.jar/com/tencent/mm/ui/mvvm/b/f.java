package com.tencent.mm.ui.mvvm.b;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kx;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.util.c;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/uic/SelectContactReportUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onCreateStartTime", "", "getOnCreateStartTime", "()J", "setOnCreateStartTime", "(J)V", "reportSessionId", "", "getReportSessionId", "()Ljava/lang/String;", "setReportSessionId", "(Ljava/lang/String;)V", "reportType", "getReportType", "setReportType", "onCreateBefore", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.mvvmbase.a
{
  private String afid;
  private long afie;
  private String qYC;
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250589);
    this.afid = "";
    this.qYC = "";
    AppMethodBeat.o(250589);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(250591);
    this.afie = cn.bDw();
    this.afid = (getActivity().getClass().getSimpleName() + '-' + getIntent().getIntExtra("list_type", -1));
    paramBundle = UUID.randomUUID().toString();
    s.s(paramBundle, "randomUUID().toString()");
    this.qYC = paramBundle;
    AppMethodBeat.o(250591);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(250600);
    if (!Util.isNullOrNil(this.qYC))
    {
      kx localkx = new kx();
      Object localObject = localkx.tS(this.afid).tT(this.qYC);
      ((kx)localObject).iYo = 0L;
      ((kx)localObject).ijA = (cn.bDw() - this.afie);
      ((kx)localObject).bMH();
      localObject = c.agsX;
      c.a((com.tencent.mm.plugin.report.a)localkx);
      this.qYC = "";
    }
    AppMethodBeat.o(250600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.b.f
 * JD-Core Version:    0.7.0.1
 */