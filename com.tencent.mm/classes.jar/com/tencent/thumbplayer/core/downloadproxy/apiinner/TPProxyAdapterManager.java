package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPProxyAdapter;
import java.util.Map;

public class TPProxyAdapterManager
{
  private ITPProxyAdapter mAdapter = null;
  
  public static TPProxyAdapterManager getInstance()
  {
    AppMethodBeat.i(191460);
    TPProxyAdapterManager localTPProxyAdapterManager = SingletonHolder.INSTANCE;
    AppMethodBeat.o(191460);
    return localTPProxyAdapterManager;
  }
  
  public String checkVideoStatus(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191465);
    if (this.mAdapter != null)
    {
      paramString1 = this.mAdapter.checkVideoStatus(paramString1, paramString2);
      AppMethodBeat.o(191465);
      return paramString1;
    }
    AppMethodBeat.o(191465);
    return "";
  }
  
  public long getCurrentFilesize(int paramInt)
  {
    AppMethodBeat.i(191467);
    if (this.mAdapter != null)
    {
      long l = this.mAdapter.getFilesize(paramInt);
      AppMethodBeat.o(191467);
      return l;
    }
    AppMethodBeat.o(191467);
    return 0L;
  }
  
  public long getCurrentOffset(int paramInt)
  {
    AppMethodBeat.i(191466);
    if (this.mAdapter != null)
    {
      long l = this.mAdapter.getCurrentOffset(paramInt);
      AppMethodBeat.o(191466);
      return l;
    }
    AppMethodBeat.o(191466);
    return 0L;
  }
  
  public String getProxyClipUrl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191464);
    if (this.mAdapter != null)
    {
      String str = this.mAdapter.getProxyClipUrl(paramInt1, paramInt2);
      AppMethodBeat.o(191464);
      return str;
    }
    AppMethodBeat.o(191464);
    return "";
  }
  
  public int getRecordDuration(String paramString1, String paramString2)
  {
    AppMethodBeat.i(191468);
    if (this.mAdapter != null)
    {
      int i = this.mAdapter.getRecordDuration(paramString1, paramString2);
      AppMethodBeat.o(191468);
      return i;
    }
    AppMethodBeat.o(191468);
    return 0;
  }
  
  public void setProxyAdapter(ITPProxyAdapter paramITPProxyAdapter)
  {
    this.mAdapter = paramITPProxyAdapter;
  }
  
  public int startOnlineOrOfflinePlay(int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    AppMethodBeat.i(191462);
    if (this.mAdapter != null)
    {
      paramInt1 = this.mAdapter.startOnlineOrOfflinePlay(paramInt1, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2, paramInt2, paramMap1, paramMap2);
      AppMethodBeat.o(191462);
      return paramInt1;
    }
    AppMethodBeat.o(191462);
    return -1;
  }
  
  public void stopPlay(int paramInt)
  {
    AppMethodBeat.i(191463);
    if (this.mAdapter != null) {
      this.mAdapter.stopPlay(paramInt);
    }
    AppMethodBeat.o(191463);
  }
  
  public void updateProxyMessage(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(191461);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191461);
      return;
      TPListenerManager.getInstance().handleCallbackMessage(101, ((Integer)paramObject1).intValue(), null, null, null, null, null);
    }
  }
  
  static class SingletonHolder
  {
    private static final TPProxyAdapterManager INSTANCE;
    
    static
    {
      AppMethodBeat.i(191459);
      INSTANCE = new TPProxyAdapterManager(null);
      AppMethodBeat.o(191459);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPProxyAdapterManager
 * JD-Core Version:    0.7.0.1
 */