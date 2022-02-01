package com.tencent.mm.plugin.mv.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.ui.uic.v;
import com.tencent.mm.plugin.secdata.c;
import com.tencent.mm.plugin.secdata.h;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.dbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.report.MMSecDataActivity;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/BaseMusicMvUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "TAG", "", "getForceOrientation", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "plugin-mv_release"})
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
    Set localSet = super.importUIComponents();
    if (localSet != null) {
      return ak.b(localSet, (Iterable)ak.setOf(v.class));
    }
    return null;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = g.Xox;
    ((a)g.b((AppCompatActivity)this).i(a.class)).a((h)new c(dbs.class, 7, (byte)0));
    paramBundle = a.JbV;
    paramBundle = (dbs)a.a.a((Context)this, 7, dbs.class);
    if (paramBundle != null)
    {
      localObject = a.JbV;
      localObject = (dbs)a.a.b((Context)this, 7, dbs.class);
      if (localObject != null)
      {
        paramBundle.scene = ((dbs)localObject).scene;
        paramBundle.wmL = ((dbs)localObject).wmL;
        paramBundle.TIZ = ((dbs)localObject).TIZ;
        paramBundle.TJa = ((dbs)localObject).TJa;
        paramBundle.AtM = ((dbs)localObject).AtM;
        Log.i(this.TAG, "init mv page scene:" + ((dbs)localObject).scene + " contextId:" + ((dbs)localObject).wmL + " finderCommentScene:" + ((dbs)localObject).TIZ + " finderContextId:" + ((dbs)localObject).AtM);
      }
    }
    Object localObject = getIntent().getByteArrayExtra("key_mv_report_data");
    if (localObject != null) {}
    try
    {
      paramBundle = new dbs();
      paramBundle.parseFrom((byte[])localObject);
      localObject = a.JbV;
      localObject = (dbs)a.a.a((Context)this, 7, dbs.class);
      if (localObject != null)
      {
        ((dbs)localObject).scene = paramBundle.scene;
        ((dbs)localObject).wmL = paramBundle.wmL;
        ((dbs)localObject).TIZ = paramBundle.TIZ;
        ((dbs)localObject).TJa = ((dbs)localObject).TJa;
        Log.i(this.TAG, "init mv page report data from intent, " + paramBundle.scene + ' ' + paramBundle.wmL + ' ' + paramBundle.TIZ);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.BaseMusicMvUI
 * JD-Core Version:    0.7.0.1
 */