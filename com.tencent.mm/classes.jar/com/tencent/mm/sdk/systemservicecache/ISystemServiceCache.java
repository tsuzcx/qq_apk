package com.tencent.mm.sdk.systemservicecache;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/systemservicecache/ISystemServiceCache;", "P", "", "initCache", "", "p", "(Ljava/lang/Object;)V", "updateCache", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ISystemServiceCache<P>
{
  public abstract void initCache(P paramP);
  
  public abstract void updateCache(P paramP);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.systemservicecache.ISystemServiceCache
 * JD-Core Version:    0.7.0.1
 */