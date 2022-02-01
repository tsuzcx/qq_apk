package com.tencent.mm.ui.component.glocom;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/glocom/GloComUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "gloComMap", "Ljava/util/HashMap;", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/ui/component/glocom/IGloUIComponent;", "Lkotlin/collections/HashMap;", "getGloComMap", "()Ljava/util/HashMap;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "registerGloCom", "gloCom", "unregisterGloCom", "libmmui_release"})
public final class a
  extends UIComponent
{
  final HashMap<String, LinkedList<b>> XoQ;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(193401);
    this.XoQ = new HashMap();
    AppMethodBeat.o(193401);
  }
  
  public a(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(193403);
    this.XoQ = new HashMap();
    AppMethodBeat.o(193403);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(193372);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(193372);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(193385);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((b)((Iterator)localObject1).next()).onBackPressed())
      {
        AppMethodBeat.o(193385);
        return true;
      }
    }
    AppMethodBeat.o(193385);
    return false;
  }
  
  public final void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(193400);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onBeforeFinish(paramIntent);
    }
    AppMethodBeat.o(193400);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(193380);
    p.k(paramConfiguration, "newConfig");
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(193380);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(193330);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onCreateAfter(paramBundle);
    }
    AppMethodBeat.o(193330);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(193323);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onCreateBefore(paramBundle);
    }
    AppMethodBeat.o(193323);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(193367);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onDestroy();
    }
    AppMethodBeat.o(193367);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193391);
    p.k(paramKeyEvent, "event");
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((b)((Iterator)localObject1).next()).onKeyDown(paramInt, paramKeyEvent))
      {
        AppMethodBeat.o(193391);
        return true;
      }
    }
    AppMethodBeat.o(193391);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193397);
    p.k(paramKeyEvent, "event");
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((b)((Iterator)localObject1).next()).onKeyUp(paramInt, paramKeyEvent))
      {
        AppMethodBeat.o(193397);
        return true;
      }
    }
    AppMethodBeat.o(193397);
    return false;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(193388);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onNewIntent(paramIntent);
    }
    AppMethodBeat.o(193388);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(193353);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onPause();
    }
    AppMethodBeat.o(193353);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193376);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(193376);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(193341);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onRestoreInstanceState(paramBundle);
    }
    AppMethodBeat.o(193341);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(193349);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onResume();
    }
    AppMethodBeat.o(193349);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(193336);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onSaveInstanceState(paramBundle);
    }
    AppMethodBeat.o(193336);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(193346);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onStart();
    }
    AppMethodBeat.o(193346);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(193362);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.XoQ.values();
    p.j(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onStop();
    }
    AppMethodBeat.o(193362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.component.glocom.a
 * JD-Core Version:    0.7.0.1
 */