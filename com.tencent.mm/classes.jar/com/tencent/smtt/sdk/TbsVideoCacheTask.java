package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

public class TbsVideoCacheTask
{
  public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
  public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
  public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
  public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";
  Context a;
  TbsVideoCacheListener b;
  private boolean c;
  private bg d;
  private String e;
  private String f;
  private Object g;
  
  public TbsVideoCacheTask(Context paramContext, Bundle paramBundle, TbsVideoCacheListener paramTbsVideoCacheListener)
  {
    AppMethodBeat.i(64605);
    this.a = null;
    this.b = null;
    this.c = false;
    this.d = null;
    this.g = null;
    this.a = paramContext;
    this.b = paramTbsVideoCacheListener;
    if (paramBundle != null)
    {
      this.e = paramBundle.getString("taskId");
      this.f = paramBundle.getString("url");
    }
    a(paramBundle);
    AppMethodBeat.o(64605);
  }
  
  private void a(Bundle paramBundle)
  {
    AppMethodBeat.i(64606);
    Object localObject;
    if (this.d == null)
    {
      o.a(true).a(this.a, false, false, null);
      localObject = o.a(true).a();
      if (localObject == null) {
        break label110;
      }
      localObject = ((bl)localObject).b();
      if (localObject == null) {
        break label129;
      }
      this.d = new bg((DexLoader)localObject);
    }
    for (;;)
    {
      if (this.d == null) {
        break label146;
      }
      this.g = this.d.a(this.a, this, paramBundle);
      if (this.g != null) {
        break label167;
      }
      this.b.onVideoDownloadError(this, -1, "init task error!", null);
      AppMethodBeat.o(64606);
      return;
      label110:
      this.b.onVideoDownloadError(this, -1, "init engine error!", null);
      localObject = null;
      break;
      label129:
      this.b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
    }
    label146:
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "init error!", null);
    }
    label167:
    AppMethodBeat.o(64606);
  }
  
  public long getContentLength()
  {
    AppMethodBeat.i(64611);
    if ((this.d != null) && (this.g != null))
    {
      long l = this.d.d();
      AppMethodBeat.o(64611);
      return l;
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
    }
    AppMethodBeat.o(64611);
    return 0L;
  }
  
  public int getDownloadedSize()
  {
    AppMethodBeat.i(64612);
    if ((this.d != null) && (this.g != null))
    {
      int i = this.d.e();
      AppMethodBeat.o(64612);
      return i;
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
    }
    AppMethodBeat.o(64612);
    return 0;
  }
  
  public int getProgress()
  {
    AppMethodBeat.i(64613);
    if ((this.d != null) && (this.g != null))
    {
      int i = this.d.f();
      AppMethodBeat.o(64613);
      return i;
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
    }
    AppMethodBeat.o(64613);
    return 0;
  }
  
  public String getTaskID()
  {
    return this.e;
  }
  
  public String getTaskUrl()
  {
    return this.f;
  }
  
  public void pauseTask()
  {
    AppMethodBeat.i(64607);
    if ((this.d != null) && (this.g != null))
    {
      this.d.a();
      AppMethodBeat.o(64607);
      return;
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
    }
    AppMethodBeat.o(64607);
  }
  
  public void removeTask(boolean paramBoolean)
  {
    AppMethodBeat.i(64610);
    if ((this.d != null) && (this.g != null))
    {
      this.d.a(paramBoolean);
      AppMethodBeat.o(64610);
      return;
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
    }
    AppMethodBeat.o(64610);
  }
  
  public void resumeTask()
  {
    AppMethodBeat.i(64609);
    if ((this.d != null) && (this.g != null))
    {
      this.d.b();
      AppMethodBeat.o(64609);
      return;
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
    }
    AppMethodBeat.o(64609);
  }
  
  public void stopTask()
  {
    AppMethodBeat.i(64608);
    if ((this.d != null) && (this.g != null))
    {
      this.d.c();
      AppMethodBeat.o(64608);
      return;
    }
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
    }
    AppMethodBeat.o(64608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoCacheTask
 * JD-Core Version:    0.7.0.1
 */