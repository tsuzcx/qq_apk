package com.tencent.mm.plugin.ringtone.uic;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.plugin.ringtone.b.g;
import com.tencent.mm.plugin.ringtone.b.g.b;
import com.tencent.mm.plugin.ringtone.b.g.e;
import com.tencent.mm.plugin.ringtone.e.b;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtoneDataFlowUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "mRingtoneDataSource", "Lcom/tencent/mm/plugin/ringtone/flow/RingtoneRemoteDataSource;", "getMRingtoneDataSource", "()Lcom/tencent/mm/plugin/ringtone/flow/RingtoneRemoteDataSource;", "setMRingtoneDataSource", "(Lcom/tencent/mm/plugin/ringtone/flow/RingtoneRemoteDataSource;)V", "mRingtoneViewModel", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneDataViewModel;", "getMRingtoneViewModel", "()Lcom/tencent/mm/plugin/ringtone/data/RingtoneDataViewModel;", "setMRingtoneViewModel", "(Lcom/tencent/mm/plugin/ringtone/data/RingtoneDataViewModel;)V", "clearDataSource", "", "loading", "noMoreDataLoad", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "refreshDataSource", "temp", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;", "Lkotlin/collections/ArrayList;", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
{
  g OEB;
  private b OEC;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273315);
    AppMethodBeat.o(273315);
  }
  
  public final void bq(ArrayList<e> paramArrayList)
  {
    AppMethodBeat.i(273342);
    s.u(paramArrayList, "temp");
    g localg = this.OEB;
    if (localg != null)
    {
      s.u(paramArrayList, "temp");
      localg.OCg = j.a(localg.OCd, null, null, (m)new g.b(localg, paramArrayList, null), 3);
    }
    AppMethodBeat.o(273342);
  }
  
  public final void gOO()
  {
    AppMethodBeat.i(273331);
    g localg = this.OEB;
    if (localg != null) {
      j.a(localg.OCd, null, null, (m)new g.e(localg, null), 3);
    }
    AppMethodBeat.o(273331);
  }
  
  public final void gOw()
  {
    AppMethodBeat.i(273351);
    g localg = this.OEB;
    if (localg != null) {
      localg.gOw();
    }
    AppMethodBeat.o(273351);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(273323);
    super.onCreateAfter(paramBundle);
    this.OEC = new b();
    paramBundle = this.OEC;
    if (paramBundle != null) {
      this.OEB = new g(paramBundle);
    }
    AppMethodBeat.o(273323);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273362);
    super.onDestroy();
    Object localObject = this.OEC;
    if (localObject != null) {
      ar.a(((b)localObject).OCJ, null);
    }
    this.OEC = null;
    localObject = this.OEB;
    if (localObject != null) {
      ((g)localObject).gOw();
    }
    this.OEC = null;
    AppMethodBeat.o(273362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.a
 * JD-Core Version:    0.7.0.1
 */