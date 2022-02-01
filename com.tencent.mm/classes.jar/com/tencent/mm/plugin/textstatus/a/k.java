package com.tencent.mm.plugin.textstatus.a;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.m;
import java.util.List;

public abstract class k
{
  protected String jumpType;
  
  public k(String paramString)
  {
    this.jumpType = paramString;
  }
  
  public void a(m paramm) {}
  
  public boolean d(FrameLayout paramFrameLayout)
  {
    return false;
  }
  
  public boolean e(FrameLayout paramFrameLayout)
  {
    return false;
  }
  
  public boolean eKU()
  {
    return true;
  }
  
  public boolean eKV()
  {
    return true;
  }
  
  public w eKW()
  {
    return null;
  }
  
  public String etP()
  {
    return "";
  }
  
  public abstract boolean etQ();
  
  public CharSequence etS()
  {
    return "";
  }
  
  public CharSequence etT()
  {
    return "";
  }
  
  public boolean f(FrameLayout paramFrameLayout)
  {
    return false;
  }
  
  public abstract boolean g(Context paramContext, Bundle paramBundle);
  
  public boolean gz(Context paramContext)
  {
    return false;
  }
  
  public String hFu()
  {
    return this.jumpType;
  }
  
  public boolean km(Context paramContext)
  {
    return g(paramContext, null);
  }
  
  public abstract void onDetach();
  
  public abstract void y(String paramString, List<TextStatusJumpInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.k
 * JD-Core Version:    0.7.0.1
 */