package com.tencent.mm.plugin.repairer.ui;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerResetConfigUI
  extends BaseRepairerUI
{
  public static final RepairerResetConfigUI.a Owx;
  
  static
  {
    AppMethodBeat.i(277996);
    Owx = new RepairerResetConfigUI.a((byte)0);
    AppMethodBeat.o(277996);
  }
  
  private static final void a(RepairerResetConfigUI paramRepairerResetConfigUI, View paramView)
  {
    AppMethodBeat.i(277963);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerResetConfigUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerResetConfigUI, "this$0");
    ((EditText)paramRepairerResetConfigUI.findViewById(b.c.Ouo)).getText();
    paramRepairerResetConfigUI.findViewById(b.c.Our);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277963);
  }
  
  private static final boolean a(RepairerResetConfigUI paramRepairerResetConfigUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(277953);
    s.u(paramRepairerResetConfigUI, "this$0");
    paramRepairerResetConfigUI.finish();
    AppMethodBeat.o(277953);
    return false;
  }
  
  private static final void b(RepairerResetConfigUI paramRepairerResetConfigUI, View paramView)
  {
    AppMethodBeat.i(277974);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramRepairerResetConfigUI);
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(paramRepairerResetConfigUI, "this$0");
    try
    {
      paramView = ((MMEditText)paramRepairerResetConfigUI.findViewById(b.c.Ouo)).getText().toString();
      localObject1 = ((MMEditText)paramRepairerResetConfigUI.findViewById(b.c.Our)).getText().toString();
      localObject2 = at.a.valueOf(paramView);
      paramView = (CharSequence)paramView;
      paramView = ((Collection)new k("_").o(paramView, 0)).toArray(new String[0]);
      if (paramView != null) {
        break label194;
      }
      paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(277974);
      throw paramView;
    }
    catch (Exception paramView)
    {
      aa.makeText((Context)paramRepairerResetConfigUI.getContext(), (CharSequence)paramRepairerResetConfigUI.getString(b.f.app_modify_failed), 0).show();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277974);
    return;
    label194:
    String[] arrayOfString = (String[])paramView;
    paramView = arrayOfString[(arrayOfString.length - 1)];
    if (s.p(paramView, "SYNC"))
    {
      paramView = arrayOfString[(arrayOfString.length - 2)];
      label227:
      switch (paramView.hashCode())
      {
      }
    }
    for (;;)
    {
      label288:
      paramView = new RuntimeException();
      AppMethodBeat.o(277974);
      throw paramView;
      if (paramView.equals("FLOAT"))
      {
        h.baE().ban().set((at.a)localObject2, Float.valueOf(Float.parseFloat((String)localObject1)));
        for (;;)
        {
          aa.makeText((Context)paramRepairerResetConfigUI.getContext(), (CharSequence)paramRepairerResetConfigUI.getString(b.f.app_modify_success), 0).show();
          break;
          if (!paramView.equals("STRING")) {
            break label288;
          }
          h.baE().ban().set((at.a)localObject2, localObject1);
          continue;
          if (!paramView.equals("DOUBLE")) {
            break label288;
          }
          h.baE().ban().set((at.a)localObject2, Double.valueOf(Double.parseDouble((String)localObject1)));
          continue;
          if (!paramView.equals("INT")) {
            break label288;
          }
          h.baE().ban().set((at.a)localObject2, Integer.valueOf(Integer.parseInt((String)localObject1)));
          continue;
          if (!paramView.equals("BOOLEAN")) {
            break label288;
          }
          h.baE().ban().set((at.a)localObject2, Boolean.valueOf(Boolean.parseBoolean((String)localObject1)));
          continue;
          if (!paramView.equals("LONG")) {
            break label288;
          }
          h.baE().ban().set((at.a)localObject2, Long.valueOf(Long.parseLong((String)localObject1)));
        }
        break label227;
      }
    }
  }
  
  private static final void c(RepairerResetConfigUI paramRepairerResetConfigUI, View paramView)
  {
    AppMethodBeat.i(277981);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerResetConfigUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerResetConfigUI, "this$0");
    try
    {
      paramView = ((MMEditText)paramRepairerResetConfigUI.findViewById(b.c.OtS)).getText().toString();
      localObject = ((MMEditText)paramRepairerResetConfigUI.findViewById(b.c.OtU)).getText().toString();
      ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().put(paramView, (String)localObject);
      aa.makeText((Context)paramRepairerResetConfigUI.getContext(), (CharSequence)paramRepairerResetConfigUI.getString(b.f.app_modify_success), 0).show();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277981);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        aa.makeText((Context)paramRepairerResetConfigUI.getContext(), (CharSequence)paramRepairerResetConfigUI.getString(b.f.app_modify_failed), 0).show();
      }
    }
  }
  
  private static final void d(RepairerResetConfigUI paramRepairerResetConfigUI, View paramView)
  {
    AppMethodBeat.i(277989);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerResetConfigUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerResetConfigUI, "this$0");
    try
    {
      paramView = ((MMEditText)paramRepairerResetConfigUI.findViewById(b.c.Out)).getText().toString();
      localObject = ((MMEditText)paramRepairerResetConfigUI.findViewById(b.c.Ouv)).getText().toString();
      switch (Integer.parseInt(((MMEditText)paramRepairerResetConfigUI.findViewById(b.c.Ouw)).getText().toString()))
      {
      case 1: 
        for (;;)
        {
          aa.makeText((Context)paramRepairerResetConfigUI.getContext(), (CharSequence)paramRepairerResetConfigUI.getString(b.f.app_modify_success), 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerResetConfigUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(277989);
          return;
          MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putInt(paramView, Integer.parseInt((String)localObject)).commit();
        }
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        aa.makeText((Context)paramRepairerResetConfigUI.getContext(), (CharSequence)paramRepairerResetConfigUI.getString(b.f.app_modify_failed), 0).show();
        continue;
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putLong(paramView, Long.parseLong((String)localObject)).commit();
        continue;
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putString(paramView, (String)localObject).commit();
        continue;
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean(paramView, Boolean.parseBoolean((String)localObject)).commit();
        continue;
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putFloat(paramView, Float.parseFloat((String)localObject)).commit();
      }
    }
  }
  
  public final int getLayoutId()
  {
    return b.d.OvZ;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278030);
    super.onCreate(paramBundle);
    setMMTitle("微信设置本地配置");
    setBackBtn(new RepairerResetConfigUI..ExternalSyntheticLambda0(this));
    paramBundle = (Button)findViewById(b.c.Ouq);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new RepairerResetConfigUI..ExternalSyntheticLambda2(this));
    }
    ((Button)findViewById(b.c.Oup)).setOnClickListener(new RepairerResetConfigUI..ExternalSyntheticLambda3(this));
    ((Button)findViewById(b.c.OtT)).setOnClickListener(new RepairerResetConfigUI..ExternalSyntheticLambda4(this));
    ((Button)findViewById(b.c.Ouu)).setOnClickListener(new RepairerResetConfigUI..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(278030);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerResetConfigUI
 * JD-Core Version:    0.7.0.1
 */