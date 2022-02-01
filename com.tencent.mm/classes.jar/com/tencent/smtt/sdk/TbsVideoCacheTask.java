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
  private q d;
  private String e;
  private String f;
  private Object g;
  
  public TbsVideoCacheTask(Context paramContext, Bundle paramBundle, TbsVideoCacheListener paramTbsVideoCacheListener)
  {
    AppMethodBeat.i(54613);
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
    AppMethodBeat.o(54613);
  }
  
  private void a(Bundle paramBundle)
  {
    AppMethodBeat.i(54614);
    Object localObject;
    if (this.d == null)
    {
      e.a(true).a(this.a, false, false, null);
      localObject = e.a(true).a();
      if (localObject == null) {
        break label110;
      }
      localObject = ((TbsWizard)localObject).dexLoader();
      if (localObject == null) {
        break label129;
      }
      this.d = new q((DexLoader)localObject);
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
      AppMethodBeat.o(54614);
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
    AppMethodBeat.o(54614);
  }
  
  public long getContentLength()
  {
    AppMethodBeat.i(54619);
    StringBuilder localStringBuilder = new StringBuilder("getContentLength mWizard = ");
    if (this.d == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append("  mDownloadWorker = ");
      if (this.g != null) {
        break label91;
      }
    }
    label91:
    for (String str = "null";; str = "not null")
    {
      localStringBuilder.append(str);
      if ((this.d == null) || (this.g == null)) {
        break label97;
      }
      long l = this.d.d();
      AppMethodBeat.o(54619);
      return l;
      str = "not null";
      break;
    }
    label97:
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
    }
    AppMethodBeat.o(54619);
    return 0L;
  }
  
  public int getDownloadedSize()
  {
    AppMethodBeat.i(54620);
    StringBuilder localStringBuilder = new StringBuilder("getDownloadedSize mWizard = ");
    if (this.d == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append("  mDownloadWorker = ");
      if (this.g != null) {
        break label87;
      }
    }
    label87:
    for (String str = "null";; str = "not null")
    {
      localStringBuilder.append(str);
      if ((this.d == null) || (this.g == null)) {
        break label93;
      }
      int i = this.d.e();
      AppMethodBeat.o(54620);
      return i;
      str = "not null";
      break;
    }
    label93:
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
    }
    AppMethodBeat.o(54620);
    return 0;
  }
  
  public int getProgress()
  {
    AppMethodBeat.i(54621);
    StringBuilder localStringBuilder = new StringBuilder("getProgress mWizard = ");
    if (this.d == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append("  mDownloadWorker = ");
      if (this.g != null) {
        break label87;
      }
    }
    label87:
    for (String str = "null";; str = "not null")
    {
      localStringBuilder.append(str);
      if ((this.d == null) || (this.g == null)) {
        break label93;
      }
      int i = this.d.f();
      AppMethodBeat.o(54621);
      return i;
      str = "not null";
      break;
    }
    label93:
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
    }
    AppMethodBeat.o(54621);
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
    AppMethodBeat.i(54615);
    StringBuilder localStringBuilder = new StringBuilder("pauseTask mWizard = ");
    if (this.d == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append("  mDownloadWorker = ");
      if (this.g != null) {
        break label85;
      }
    }
    label85:
    for (String str = "null";; str = "not null")
    {
      localStringBuilder.append(str);
      if ((this.d == null) || (this.g == null)) {
        break label91;
      }
      this.d.a();
      AppMethodBeat.o(54615);
      return;
      str = "not null";
      break;
    }
    label91:
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
    }
    AppMethodBeat.o(54615);
  }
  
  public void removeTask(boolean paramBoolean)
  {
    AppMethodBeat.i(54618);
    StringBuilder localStringBuilder = new StringBuilder("removeTask mWizard = ");
    if (this.d == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append("  mDownloadWorker = ");
      if (this.g != null) {
        break label86;
      }
    }
    label86:
    for (String str = "null";; str = "not null")
    {
      localStringBuilder.append(str);
      if ((this.d == null) || (this.g == null)) {
        break label92;
      }
      this.d.a(paramBoolean);
      AppMethodBeat.o(54618);
      return;
      str = "not null";
      break;
    }
    label92:
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
    }
    AppMethodBeat.o(54618);
  }
  
  public void resumeTask()
  {
    AppMethodBeat.i(54617);
    StringBuilder localStringBuilder = new StringBuilder("resumeTask mWizard = ");
    if (this.d == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append("  mDownloadWorker = ");
      if (this.g != null) {
        break label85;
      }
    }
    label85:
    for (String str = "null";; str = "not null")
    {
      localStringBuilder.append(str);
      if ((this.d == null) || (this.g == null)) {
        break label91;
      }
      this.d.b();
      AppMethodBeat.o(54617);
      return;
      str = "not null";
      break;
    }
    label91:
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
    }
    AppMethodBeat.o(54617);
  }
  
  public void stopTask()
  {
    AppMethodBeat.i(54616);
    StringBuilder localStringBuilder = new StringBuilder("stopTask mWizard = ");
    if (this.d == null)
    {
      str = "null";
      localStringBuilder = localStringBuilder.append(str).append("  mDownloadWorker = ");
      if (this.g != null) {
        break label85;
      }
    }
    label85:
    for (String str = "null";; str = "not null")
    {
      localStringBuilder.append(str);
      if ((this.d == null) || (this.g == null)) {
        break label91;
      }
      this.d.c();
      AppMethodBeat.o(54616);
      return;
      str = "not null";
      break;
    }
    label91:
    if (this.b != null) {
      this.b.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
    }
    AppMethodBeat.o(54616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoCacheTask
 * JD-Core Version:    0.7.0.1
 */