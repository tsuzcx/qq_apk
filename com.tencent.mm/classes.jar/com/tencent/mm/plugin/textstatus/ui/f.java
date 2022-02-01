package com.tencent.mm.plugin.textstatus.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/NotifyPageUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends UIComponent
{
  public static final a Tww;
  private static int Twx;
  
  static
  {
    AppMethodBeat.i(291248);
    Tww = new a((byte)0);
    AppMethodBeat.o(291248);
  }
  
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(291239);
    AppMethodBeat.o(291239);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291253);
    super.onCreate(paramBundle);
    Twx += 1;
    AppMethodBeat.o(291253);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291258);
    super.onDestroy();
    Twx -= 1;
    AppMethodBeat.o(291258);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/NotifyPageUIC$Companion;", "", "()V", "isInNotifyPage", "", "()Z", "notifyCnt", "", "getNotifyCnt", "()I", "setNotifyCnt", "(I)V", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.f
 * JD-Core Version:    0.7.0.1
 */