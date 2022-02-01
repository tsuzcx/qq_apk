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
import com.tencent.mm.ui.tools.b.a;
import com.tencent.mm.ui.widget.a.e;

@Deprecated
public abstract interface m
{
  public abstract void a(Activity paramActivity, Intent paramIntent, int paramInt);
  
  public abstract void a(Activity paramActivity, Intent paramIntent1, Intent paramIntent2, String paramString, b.a parama);
  
  public abstract void a(Activity paramActivity, String paramString1, WXMediaMessage paramWXMediaMessage, String paramString2, String paramString3);
  
  public abstract void a(Context paramContext, Intent paramIntent1, Intent paramIntent2);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, y.a parama);
  
  public abstract void a(Intent paramIntent, int paramInt, MMActivity.a parama, MMActivity paramMMActivity);
  
  public abstract void a(Intent paramIntent, int paramInt, MMActivity paramMMActivity);
  
  public abstract void a(Intent paramIntent1, int paramInt, MMActivity paramMMActivity, Intent paramIntent2);
  
  public abstract void a(Intent paramIntent, Activity paramActivity);
  
  public abstract void a(Intent paramIntent, Activity paramActivity, int paramInt);
  
  public abstract void a(Intent paramIntent, Context paramContext);
  
  public abstract void a(Intent paramIntent, MMActivity.a parama, MMActivity paramMMActivity);
  
  public abstract void a(MMWizardActivity paramMMWizardActivity, Intent paramIntent);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, Context paramContext, String paramString, int paramInt1, int paramInt2);
  
  public abstract boolean a(Context paramContext, String paramString, Object... paramVarArgs);
  
  public abstract void aDA();
  
  public abstract void b(Intent paramIntent, Activity paramActivity);
  
  public abstract void b(Intent paramIntent, Context paramContext);
  
  public abstract boolean b(Context paramContext, String paramString, Bundle paramBundle);
  
  public abstract void c(Intent paramIntent, Context paramContext);
  
  public abstract void cH(Context paramContext);
  
  public abstract e cI(Context paramContext);
  
  public abstract Intent cJ(Context paramContext);
  
  public abstract void cK(Context paramContext);
  
  public abstract void cL(Context paramContext);
  
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
  
  public abstract void iH(String paramString);
  
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
  
  public abstract void z(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.m
 * JD-Core Version:    0.7.0.1
 */