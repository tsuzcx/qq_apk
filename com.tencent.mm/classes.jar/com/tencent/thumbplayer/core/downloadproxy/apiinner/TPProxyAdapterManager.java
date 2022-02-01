package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPProxyAdapter;
import java.util.Map;

public class TPProxyAdapterManager
{
  private ITPProxyAdapter mAdapter = null;
  
  public static TPProxyAdapterManager getInstance()
  {
    AppMethodBeat.i(207313);
    TPProxyAdapterManager localTPProxyAdapterManager = SingletonHolder.INSTANCE;
    AppMethodBeat.o(207313);
    return localTPProxyAdapterManager;
  }
  
  public String checkVideoStatus(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207318);
    if (this.mAdapter != null)
    {
      paramString1 = this.mAdapter.checkVideoStatus(paramString1, paramString2);
      AppMethodBeat.o(207318);
      return paramString1;
    }
    AppMethodBeat.o(207318);
    return "";
  }
  
  public long getCurrentFilesize(int paramInt)
  {
    AppMethodBeat.i(207320);
    if (this.mAdapter != null)
    {
      long l = this.mAdapter.getFilesize(paramInt);
      AppMethodBeat.o(207320);
      return l;
    }
    AppMethodBeat.o(207320);
    return 0L;
  }
  
  public long getCurrentOffset(int paramInt)
  {
    AppMethodBeat.i(207319);
    if (this.mAdapter != null)
    {
      long l = this.mAdapter.getCurrentOffset(paramInt);
      AppMethodBeat.o(207319);
      return l;
    }
    AppMethodBeat.o(207319);
    return 0L;
  }
  
  public String getProxyClipUrl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207317);
    if (this.mAdapter != null)
    {
      String str = this.mAdapter.getProxyClipUrl(paramInt1, paramInt2);
      AppMethodBeat.o(207317);
      return str;
    }
    AppMethodBeat.o(207317);
    return "";
  }
  
  public int getRecordDuration(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207321);
    if (this.mAdapter != null)
    {
      int i = this.mAdapter.getRecordDuration(paramString1, paramString2);
      AppMethodBeat.o(207321);
      return i;
    }
    AppMethodBeat.o(207321);
    return 0;
  }
  
  public void setProxyAdapter(ITPProxyAdapter paramITPProxyAdapter)
  {
    this.mAdapter = paramITPProxyAdapter;
  }
  
  public int startOnlineOrOfflinePlay(int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    AppMethodBeat.i(207315);
    if (this.mAdapter != null)
    {
      paramInt1 = this.mAdapter.startOnlineOrOfflinePlay(paramInt1, paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2, paramInt2, paramMap1, paramMap2);
      AppMethodBeat.o(207315);
      return paramInt1;
    }
    AppMethodBeat.o(207315);
    return -1;
  }
  
  public void stopPlay(int paramInt)
  {
    AppMethodBeat.i(207316);
    if (this.mAdapter != null) {
      this.mAdapter.stopPlay(paramInt);
    }
    AppMethodBeat.o(207316);
  }
  
  public void updateProxyMessage(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(207314);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207314);
      return;
      TPListenerManager.getInstance().handleCallbackMessage(101, ((Integer)paramObject1).intValue(), null, null, null, null, null);
    }
  }
  
  static class SingletonHolder
  {
    private static final TPProxyAdapterManager INSTANCE;
    
    static
    {
      AppMethodBeat.i(207312);
      INSTANCE = new TPProxyAdapterManager(null);
      AppMethodBeat.o(207312);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPProxyAdapterManager
 * JD-Core Version:    0.7.0.1
 */