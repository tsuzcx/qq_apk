package io.a.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.w;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lio/github/ponnamkarthik/toast/fluttertoast/MethodCallHandlerImpl;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "mToast", "Landroid/widget/Toast;", "onMethodCall", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "resetToast", "fluttertoast_release"}, k=1, mv={1, 1, 16})
public final class b
  implements MethodChannel.MethodCallHandler
{
  private Context context;
  private Toast uzW;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(189468);
    this.context = paramContext;
    AppMethodBeat.o(189468);
  }
  
  public final void kkO()
  {
    AppMethodBeat.i(189492);
    if (((b)this).uzW != null)
    {
      Object localObject = this.uzW;
      if (localObject == null) {
        s.bIx("mToast");
      }
      if (localObject != null)
      {
        localObject = this.uzW;
        if (localObject == null) {
          s.bIx("mToast");
        }
        localObject = ((Toast)localObject).getView();
        if ((localObject == null) || (((View)localObject).getVisibility() != 0))
        {
          if (this.uzW == null) {
            s.bIx("mToast");
          }
          AppMethodBeat.o(189492);
          return;
        }
        new Handler().postDelayed((Runnable)new b.b(this), 1000L);
      }
    }
    AppMethodBeat.o(189492);
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(189485);
    s.t(paramMethodCall, "call");
    s.t(paramResult, "result");
    Object localObject1 = paramMethodCall.method;
    if (localObject1 == null) {}
    do
    {
      for (;;)
      {
        paramResult.notImplemented();
        AppMethodBeat.o(189485);
        return;
        switch (((String)localObject1).hashCode())
        {
        }
      }
    } while (!((String)localObject1).equals("showToast"));
    String str = String.valueOf(paramMethodCall.argument("msg"));
    Object localObject2 = String.valueOf(paramMethodCall.argument("length"));
    Object localObject3 = String.valueOf(paramMethodCall.argument("gravity"));
    Number localNumber2 = (Number)paramMethodCall.argument("bgcolor");
    localObject1 = (Number)paramMethodCall.argument("textcolor");
    Number localNumber1 = (Number)paramMethodCall.argument("fontSize");
    label184:
    int i;
    label187:
    int j;
    switch (((String)localObject3).hashCode())
    {
    default: 
      i = 80;
      if (s.p(localObject2, "long")) {
        j = 1;
      }
      break;
    }
    for (;;)
    {
      if ((localNumber2 != null) && (Build.VERSION.SDK_INT < 30))
      {
        paramMethodCall = this.context.getSystemService("layout_inflater");
        if (paramMethodCall == null)
        {
          paramMethodCall = new w("null cannot be cast to non-null type android.view.LayoutInflater");
          AppMethodBeat.o(189485);
          throw paramMethodCall;
          if (!((String)localObject1).equals("cancel")) {
            break;
          }
          if (((b)this).uzW != null)
          {
            paramMethodCall = this.uzW;
            if (paramMethodCall == null) {
              s.bIx("mToast");
            }
            paramMethodCall.cancel();
          }
          paramResult.success(Boolean.TRUE);
          AppMethodBeat.o(189485);
          return;
          if (!((String)localObject3).equals("top")) {
            break label184;
          }
          i = 48;
          break label187;
          if (!((String)localObject3).equals("center")) {
            break label184;
          }
          i = 17;
          break label187;
          j = 0;
          continue;
        }
        localObject2 = ((LayoutInflater)paramMethodCall).inflate(c.c.toast_custom, null);
        localObject3 = (TextView)((View)localObject2).findViewById(c.b.text);
        s.r(localObject3, "text");
        ((TextView)localObject3).setText((CharSequence)str);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramMethodCall = this.context.getDrawable(c.a.corner);
          if (paramMethodCall == null) {
            s.klw();
          }
          s.r(paramMethodCall, "context.getDrawable(R.drawable.corner)!!");
          paramMethodCall.setColorFilter(localNumber2.intValue(), PorterDuff.Mode.SRC_IN);
          ((TextView)localObject3).setBackground(paramMethodCall);
          if (localNumber1 != null) {
            ((TextView)localObject3).setTextSize(localNumber1.floatValue());
          }
          if (localObject1 != null) {
            ((TextView)localObject3).setTextColor(((Number)localObject1).intValue());
          }
          this.uzW = new Toast(this.context);
          paramMethodCall = this.uzW;
          if (paramMethodCall == null) {
            s.bIx("mToast");
          }
          paramMethodCall.setDuration(j);
          paramMethodCall = this.uzW;
          if (paramMethodCall == null) {
            s.bIx("mToast");
          }
          paramMethodCall.setView((View)localObject2);
          label513:
          if (Build.VERSION.SDK_INT < 30) {
            switch (i)
            {
            default: 
              paramMethodCall = this.uzW;
              if (paramMethodCall == null) {
                s.bIx("mToast");
              }
              paramMethodCall.setGravity(i, 0, 100);
            }
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (!(this.context instanceof Activity)) {
          break label833;
        }
        paramMethodCall = this.context;
        if (paramMethodCall != null) {
          break label796;
        }
        paramMethodCall = new w("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(189485);
        throw paramMethodCall;
        paramMethodCall = this.context.getResources().getDrawable(c.a.corner);
        s.r(paramMethodCall, "context.resources.getDrawable(R.drawable.corner)");
        break;
        paramMethodCall = Toast.makeText(this.context, (CharSequence)str, j);
        s.r(paramMethodCall, "Toast.makeText(context, mMessage, mDuration)");
        this.uzW = paramMethodCall;
        if (Build.VERSION.SDK_INT >= 30) {
          break label513;
        }
        try
        {
          paramMethodCall = this.uzW;
          if (paramMethodCall == null) {
            s.bIx("mToast");
          }
          paramMethodCall = paramMethodCall.getView();
          if (paramMethodCall == null) {
            s.klw();
          }
          paramMethodCall = paramMethodCall.findViewById(16908299);
          s.r(paramMethodCall, "mToast.view!!.findViewById(android.R.id.message)");
          paramMethodCall = (TextView)paramMethodCall;
          if (localNumber1 != null) {
            paramMethodCall.setTextSize(localNumber1.floatValue());
          }
          if (localObject1 == null) {
            break label513;
          }
          paramMethodCall.setTextColor(((Number)localObject1).intValue());
        }
        catch (Exception paramMethodCall) {}
      }
      break label513;
      paramMethodCall = this.uzW;
      if (paramMethodCall == null) {
        s.bIx("mToast");
      }
      paramMethodCall.setGravity(i, 0, 0);
      continue;
      paramMethodCall = this.uzW;
      if (paramMethodCall == null) {
        s.bIx("mToast");
      }
      paramMethodCall.setGravity(i, 0, 100);
      continue;
      label796:
      ((Activity)paramMethodCall).runOnUiThread((Runnable)new b.a(this));
    }
    for (;;)
    {
      kkO();
      paramResult.success(Boolean.TRUE);
      AppMethodBeat.o(189485);
      return;
      label833:
      paramMethodCall = this.uzW;
      if (paramMethodCall == null) {
        s.bIx("mToast");
      }
      paramMethodCall.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */