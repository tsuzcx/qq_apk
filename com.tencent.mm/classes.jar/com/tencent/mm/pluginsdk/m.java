package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.tools.a.a;
import com.tencent.mm.ui.widget.a.d;

@Deprecated
public abstract interface m
{
  public abstract void MP();
  
  public abstract void a(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void a(Activity paramActivity, Intent paramIntent1, Intent paramIntent2, String paramString, int paramInt, a.a parama);
  
  public abstract void a(Context paramContext, Intent paramIntent1, Intent paramIntent2);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, y.a parama);
  
  public abstract void a(Intent paramIntent, int paramInt, MMActivity.a parama, MMActivity paramMMActivity);
  
  public abstract void a(Intent paramIntent1, int paramInt, MMActivity paramMMActivity, Intent paramIntent2);
  
  public abstract void a(Intent paramIntent, Activity paramActivity);
  
  public abstract void a(Intent paramIntent, Activity paramActivity, int paramInt);
  
  public abstract void a(Intent paramIntent, Context paramContext);
  
  public abstract void a(Intent paramIntent, MMActivity.a parama, MMActivity paramMMActivity);
  
  public abstract void a(Intent paramIntent, MMActivity paramMMActivity);
  
  public abstract void a(MMActivity paramMMActivity, String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3);
  
  public abstract void a(MMWizardActivity paramMMWizardActivity, Intent paramIntent);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext, String paramString, int paramInt1, int paramInt2);
  
  public abstract boolean a(Context paramContext, String paramString, Object... paramVarArgs);
  
  public abstract void b(Intent paramIntent, Activity paramActivity);
  
  public abstract void b(Intent paramIntent, Context paramContext);
  
  public abstract boolean b(Context paramContext, String paramString, Bundle paramBundle);
  
  public abstract void bC(Context paramContext);
  
  public abstract d bD(Context paramContext);
  
  public abstract Intent bE(Context paramContext);
  
  public abstract void bF(Context paramContext);
  
  public abstract void bG(Context paramContext);
  
  public abstract void c(Intent paramIntent, Context paramContext);
  
  public abstract void cancelNotification(String paramString);
  
  public abstract void d(Context paramContext, Intent paramIntent);
  
  public abstract void d(Intent paramIntent, Context paramContext);
  
  public abstract void e(Context paramContext, Intent paramIntent);
  
  public abstract void e(Intent paramIntent, Context paramContext);
  
  public abstract void f(Context paramContext, Intent paramIntent);
  
  public abstract void f(Intent paramIntent, Context paramContext);
  
  public abstract void g(Context paramContext, Intent paramIntent);
  
  public abstract void g(Intent paramIntent, Context paramContext);
  
  public abstract void h(Context paramContext, Intent paramIntent);
  
  public abstract void h(Intent paramIntent, Context paramContext);
  
  public abstract void i(Intent paramIntent, Context paramContext);
  
  public abstract void j(Intent paramIntent, Context paramContext);
  
  public abstract void k(Intent paramIntent, Context paramContext);
  
  public abstract void l(Intent paramIntent, Context paramContext);
  
  public abstract void m(Intent paramIntent, Context paramContext);
  
  public abstract void n(Intent paramIntent, Context paramContext);
  
  public abstract void o(Intent paramIntent, Context paramContext);
  
  public abstract void p(Intent paramIntent, Context paramContext);
  
  public abstract void q(Intent paramIntent, Context paramContext);
  
  public abstract void r(Intent paramIntent, Context paramContext);
  
  public abstract void s(Intent paramIntent, Context paramContext);
  
  public abstract void t(Context paramContext, String paramString);
  
  public abstract void t(Intent paramIntent, Context paramContext);
  
  public abstract void u(Intent paramIntent, Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.m
 * JD-Core Version:    0.7.0.1
 */