package com.tencent.xweb;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.Log;

public final class aq
{
  private final int WvN = 0;
  private final int WvO = 1;
  private final int WvP = 2;
  public boolean aign = false;
  private boolean aigo = false;
  private WebView aigp;
  private a aigq;
  
  public aq(WebView paramWebView, a parama)
  {
    this.aigp = paramWebView;
    this.aigq = parama;
  }
  
  public final void ci(Bundle paramBundle)
  {
    AppMethodBeat.i(212494);
    Log.i("XWebTranslateLogic", "translate: replaceTranslatedString mIsTranslateMode =" + this.aign);
    if (!this.aign)
    {
      AppMethodBeat.o(212494);
      return;
    }
    Object localObject1 = (HashMap)paramBundle.getSerializable("translate_hashmap");
    boolean bool = paramBundle.getBoolean("is_mp_url");
    paramBundle = paramBundle.getString("translate_tips");
    Object localObject2 = new HashMap();
    Iterator localIterator = ((HashMap)localObject1).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)((HashMap)localObject1).get(str1);
      if ((str1 == null) || (str1.isEmpty()) || (str2 == null) || (str2.isEmpty())) {
        Log.d("XWebTranslateLogic", "translate: string is err !!!  key = " + str1 + " value = " + str2);
      } else if ((str2.trim().length() == 0) || (str2.trim().equals("\n")) || (str2.trim().equals("\r"))) {
        Log.d("XWebTranslateLogic", "translate: string is space  or change line  value = ".concat(String.valueOf(str2)));
      } else {
        ((HashMap)localObject2).put(str1, str2);
      }
    }
    Log.d("XWebTranslateLogic", "translate: replaceTranslatedString orgHashMap size = " + ((HashMap)localObject1).size() + " resultHashMap size = " + ((HashMap)localObject2).size());
    this.aigq.replaceTranslatedString((Map)localObject2);
    bool = Boolean.valueOf(bool).booleanValue();
    if ((this.aign) && (!this.aigo))
    {
      this.aigo = true;
      Log.i("XWebTranslateLogic", "getTranslateTipsView");
      localObject1 = new FrameLayout.LayoutParams(-1, 144);
      ((FrameLayout.LayoutParams)localObject1).gravity = 51;
      localObject2 = new TextView(this.aigp.getContext());
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setText(paramBundle);
      ((TextView)localObject2).setTextColor(Color.argb(127, 0, 0, 0));
      ((TextView)localObject2).setTextSize(0, 42.0F);
      if (!bool) {
        break label470;
      }
      ((TextView)localObject2).setBackgroundColor(-328966);
    }
    for (;;)
    {
      ((ViewGroup)this.aigp.getParent()).addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      ((FrameLayout.LayoutParams)this.aigp.getLayoutParams()).topMargin = 144;
      this.aigp.requestLayout();
      Log.d("XWebTranslateLogic", "translate: onTranslateFinish");
      this.aigq.irA();
      AppMethodBeat.o(212494);
      return;
      label470:
      ((TextView)localObject2).setBackgroundColor(-855310);
    }
  }
  
  public final void ds(Map<String, String> paramMap)
  {
    AppMethodBeat.i(212470);
    Bundle localBundle = new Bundle();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    Log.d("XWebTranslateLogic", "translate: onGetTranslateString orgHashMap size = " + paramMap.size() + " resultHashMap size = " + localHashMap.size());
    if ((localHashMap.size() == 0) && (this.aign))
    {
      Log.d("XWebTranslateLogic", "translate: onTranslateFinish");
      this.aigq.irA();
    }
    localBundle.putSerializable("translate_hashmap", localHashMap);
    this.aigq.A("onGetTranslateString", localBundle);
    AppMethodBeat.o(212470);
  }
  
  public final void dt(Map<String, String> paramMap)
  {
    AppMethodBeat.i(212483);
    Bundle localBundle = new Bundle();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    Log.d("XWebTranslateLogic", "translate: OnGetSampleString orgHashMap size = " + paramMap.size() + " resultHashMap size = " + localHashMap.size());
    localBundle.putSerializable("sample_hashmap", localHashMap);
    this.aigq.A("onGetSampleString", localBundle);
    AppMethodBeat.o(212483);
  }
  
  public final void kgy()
  {
    AppMethodBeat.i(212461);
    if (this.aign)
    {
      Log.d("XWebTranslateLogic", "onTranslateStart setTranslateMode true ");
      this.aigq.kgz();
    }
    AppMethodBeat.o(212461);
  }
  
  public static abstract interface a
  {
    public abstract void A(String paramString, Bundle paramBundle);
    
    public abstract void irA();
    
    public abstract void kgz();
    
    public abstract void replaceTranslatedString(Map<String, String> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.aq
 * JD-Core Version:    0.7.0.1
 */