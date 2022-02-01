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
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/glocom/GloComUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "gloComMap", "Ljava/util/HashMap;", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/ui/component/glocom/IGloUIComponent;", "Lkotlin/collections/HashMap;", "getGloComMap", "()Ljava/util/HashMap;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "registerGloCom", "gloCom", "unregisterGloCom", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
{
  private final HashMap<String, LinkedList<b>> afab;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250383);
    this.afab = new HashMap();
    AppMethodBeat.o(250383);
  }
  
  public a(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(250390);
    this.afab = new HashMap();
    AppMethodBeat.o(250390);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(250393);
    s.u(paramb, "gloCom");
    Object localObject;
    if (this.afab.containsKey(paramb.getTag()))
    {
      localObject = (LinkedList)this.afab.get(paramb.getTag());
      if (localObject != null)
      {
        ((LinkedList)localObject).add(paramb);
        AppMethodBeat.o(250393);
      }
    }
    else
    {
      localObject = (Map)this.afab;
      String str = paramb.getTag();
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(paramb);
      ((Map)localObject).put(str, localLinkedList);
    }
    AppMethodBeat.o(250393);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(250397);
    s.u(paramb, "gloCom");
    LinkedList localLinkedList = (LinkedList)this.afab.get(paramb.getTag());
    if (localLinkedList != null)
    {
      localLinkedList.remove(paramb);
      if (localLinkedList.isEmpty()) {
        this.afab.remove(paramb.getTag());
      }
    }
    AppMethodBeat.o(250397);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(250459);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(250459);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(250476);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((b)((Iterator)localObject1).next()).onBackPressed())
      {
        AppMethodBeat.o(250476);
        return true;
      }
    }
    AppMethodBeat.o(250476);
    return false;
  }
  
  public final void onBeforeFinish(Intent paramIntent)
  {
    AppMethodBeat.i(250504);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onBeforeFinish(paramIntent);
    }
    AppMethodBeat.o(250504);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(250471);
    s.u(paramConfiguration, "newConfig");
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onConfigurationChanged(paramConfiguration);
    }
    AppMethodBeat.o(250471);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(250407);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onCreateAfter(paramBundle);
    }
    AppMethodBeat.o(250407);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(250403);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onCreateBefore(paramBundle);
    }
    AppMethodBeat.o(250403);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(250453);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onDestroy();
    }
    AppMethodBeat.o(250453);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(250492);
    s.u(paramKeyEvent, "event");
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((b)((Iterator)localObject1).next()).onKeyDown(paramInt, paramKeyEvent))
      {
        AppMethodBeat.o(250492);
        return true;
      }
    }
    AppMethodBeat.o(250492);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(250499);
    s.u(paramKeyEvent, "event");
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((b)((Iterator)localObject1).next()).onKeyUp(paramInt, paramKeyEvent))
      {
        AppMethodBeat.o(250499);
        return true;
      }
    }
    AppMethodBeat.o(250499);
    return false;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(250484);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onNewIntent(paramIntent);
    }
    AppMethodBeat.o(250484);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(250439);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onPause();
    }
    AppMethodBeat.o(250439);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(250465);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(250465);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(250418);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onRestoreInstanceState(paramBundle);
    }
    AppMethodBeat.o(250418);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(250433);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onResume();
    }
    AppMethodBeat.o(250433);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(250411);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onSaveInstanceState(paramBundle);
    }
    AppMethodBeat.o(250411);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(250427);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onStart();
    }
    AppMethodBeat.o(250427);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(250447);
    Object localObject1 = new LinkedList();
    Object localObject2 = this.afab.values();
    s.s(localObject2, "gloComMap.values");
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((LinkedList)localObject1).addAll((Collection)((Iterator)localObject2).next());
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((b)((Iterator)localObject1).next()).onStop();
    }
    AppMethodBeat.o(250447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.component.glocom.a
 * JD-Core Version:    0.7.0.1
 */