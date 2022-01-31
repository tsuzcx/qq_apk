package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class s
  implements Serializable
{
  public int brC;
  public float height;
  public String oDg;
  public int oDh;
  public float oDi;
  public float oDj;
  public float oDk;
  public float oDl;
  public float oDm = -2.0F;
  public float oDn = -2.0F;
  public boolean oDo;
  public String oDp = "";
  public int oDq;
  public int oDr;
  public boolean oDs;
  public boolean oDt;
  public int oDu;
  public boolean oDv;
  public int oDw;
  public String ovV;
  public int type;
  public String uin;
  public float width;
  
  public final void On(String paramString)
  {
    this.ovV = paramString;
    Iterator localIterator = bEY().iterator();
    while (localIterator.hasNext()) {
      ((s)localIterator.next()).On(paramString);
    }
  }
  
  public final void Oo(String paramString)
  {
    this.uin = paramString;
    Iterator localIterator = bEY().iterator();
    while (localIterator.hasNext()) {
      ((s)localIterator.next()).Oo(paramString);
    }
  }
  
  protected List<s> bEY()
  {
    return Collections.emptyList();
  }
  
  public final void jm(boolean paramBoolean)
  {
    this.oDv = paramBoolean;
    Iterator localIterator = bEY().iterator();
    while (localIterator.hasNext()) {
      ((s)localIterator.next()).jm(paramBoolean);
    }
  }
  
  public final void yb(int paramInt)
  {
    this.oDu = paramInt;
    Iterator localIterator = bEY().iterator();
    while (localIterator.hasNext()) {
      ((s)localIterator.next()).yb(paramInt);
    }
  }
  
  public final void yc(int paramInt)
  {
    this.oDw = paramInt;
    Iterator localIterator = bEY().iterator();
    while (localIterator.hasNext()) {
      ((s)localIterator.next()).yc(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s
 * JD-Core Version:    0.7.0.1
 */