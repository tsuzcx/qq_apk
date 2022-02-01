package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvSongControlUIC;
import com.tencent.mm.plugin.secdata.c;
import com.tencent.mm.plugin.secdata.h;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "TAG", "", "getForceOrientation", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-mv_release"})
public abstract class BaseMusicMvUI
  extends MMSecDataActivity
{
  private final String TAG = "MicroMsg.Mv.BaseMusicMvUI";
  private HashMap _$_findViewCache;
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    return ak.setOf(new Class[] { SecDataUIC.class, MusicMvSongControlUIC.class });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = a.PRN;
    ((SecDataUIC)a.b((AppCompatActivity)this).get(SecDataUIC.class)).a((h)new c(cst.class, 7, (byte)0));
    paramBundle = SecDataUIC.CWq;
    paramBundle = (cst)SecDataUIC.a.a((Context)this, 7, cst.class);
    if (paramBundle != null)
    {
      localObject = SecDataUIC.CWq;
      localObject = (cst)SecDataUIC.a.b((Context)this, 7, cst.class);
      if (localObject != null)
      {
        paramBundle.scene = ((cst)localObject).scene;
        paramBundle.sGQ = ((cst)localObject).sGQ;
        paramBundle.MxI = ((cst)localObject).MxI;
        paramBundle.MxJ = ((cst)localObject).MxJ;
        paramBundle.Uuc = ((cst)localObject).Uuc;
        Log.i(this.TAG, "init mv page scene:" + ((cst)localObject).scene + " contextId:" + ((cst)localObject).sGQ + " finderCommentScene:" + ((cst)localObject).MxI + " finderContextId:" + ((cst)localObject).Uuc);
      }
    }
    Object localObject = getIntent().getByteArrayExtra("key_mv_report_data");
    if (localObject != null) {}
    try
    {
      paramBundle = new cst();
      paramBundle.parseFrom((byte[])localObject);
      localObject = SecDataUIC.CWq;
      localObject = (cst)SecDataUIC.a.a((Context)this, 7, cst.class);
      if (localObject != null)
      {
        ((cst)localObject).scene = paramBundle.scene;
        ((cst)localObject).sGQ = paramBundle.sGQ;
        ((cst)localObject).MxI = paramBundle.MxI;
        ((cst)localObject).MxJ = ((cst)localObject).MxJ;
        Log.i(this.TAG, "init mv page report data from intent, " + paramBundle.scene + ' ' + paramBundle.sGQ + ' ' + paramBundle.MxI);
      }
      return;
    }
    catch (Exception paramBundle)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramBundle, paramBundle.getMessage(), new Object[0]);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.BaseMusicMvUI
 * JD-Core Version:    0.7.0.1
 */