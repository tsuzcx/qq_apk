package com.tencent.mm.plugin.webview.luggage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.webkit.WebResourceResponse;
import com.tencent.e.h;
import com.tencent.luggage.webview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.model.aw;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public final class LuggageMMLocalResourceProvider
  implements c
{
  public final String DX()
  {
    return "weixin://resourceid/.*";
  }
  
  public final WebResourceResponse bM(String paramString)
  {
    AppMethodBeat.i(78221);
    final PipedOutputStream localPipedOutputStream = new PipedOutputStream();
    try
    {
      PipedInputStream localPipedInputStream = new PipedInputStream(localPipedOutputStream);
      final GetLocalResourceInfoTask localGetLocalResourceInfoTask = new GetLocalResourceInfoTask((byte)0);
      localGetLocalResourceInfoTask.dgl = paramString;
      localGetLocalResourceInfoTask.infoType = 1;
      localGetLocalResourceInfoTask.kKa = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78214);
          h.JZN.aS(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78213);
              Object localObject3 = null;
              Object localObject1 = null;
              try
              {
                InputStream localInputStream = com.tencent.mm.vfs.i.openRead(LuggageMMLocalResourceProvider.1.this.Clc.path);
                localObject1 = localInputStream;
                localObject3 = localInputStream;
                PipedOutputStream localPipedOutputStream = LuggageMMLocalResourceProvider.1.this.Cld;
                localObject1 = localInputStream;
                localObject3 = localInputStream;
                byte[] arrayOfByte = new byte[1024];
                for (;;)
                {
                  localObject1 = localInputStream;
                  localObject3 = localInputStream;
                  int i = localInputStream.read(arrayOfByte);
                  if (i == -1) {
                    break;
                  }
                  localObject1 = localInputStream;
                  localObject3 = localInputStream;
                  localPipedOutputStream.write(arrayOfByte, 0, i);
                }
                try
                {
                  localException3.close();
                  LuggageMMLocalResourceProvider.1.this.Cld.close();
                }
                catch (Exception localException4)
                {
                  break label173;
                }
              }
              catch (Exception localException3)
              {
                if (localObject1 != null) {}
                try
                {
                  localObject1.close();
                  LuggageMMLocalResourceProvider.1.this.Cld.close();
                  AppMethodBeat.o(78213);
                  return;
                }
                catch (Exception localException2)
                {
                  AppMethodBeat.o(78213);
                  return;
                }
                if (localInputStream != null) {}
                try
                {
                  localInputStream.close();
                  LuggageMMLocalResourceProvider.1.this.Cld.close();
                  AppMethodBeat.o(78213);
                  return;
                }
                catch (Exception localException1)
                {
                  AppMethodBeat.o(78213);
                  return;
                }
              }
              finally
              {
                if (localException3 == null) {}
              }
              label173:
              AppMethodBeat.o(78213);
              throw localObject2;
            }
          });
          AppMethodBeat.o(78214);
        }
      };
      AppBrandMainProcessService.a(localGetLocalResourceInfoTask);
      paramString = new WebResourceResponse("image/*", "utf-8", localPipedInputStream);
      AppMethodBeat.o(78221);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(78221);
    }
    return null;
  }
  
  static class GetLocalResourceInfoTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetLocalResourceInfoTask> CREATOR;
    String dgl;
    int infoType;
    Runnable kKa;
    String path;
    
    static
    {
      AppMethodBeat.i(78220);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(78220);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(78216);
      switch (this.infoType)
      {
      }
      for (;;)
      {
        bet();
        AppMethodBeat.o(78216);
        return;
        this.path = aw.aCa(this.dgl);
        continue;
        this.path = aw.aCb(this.dgl);
      }
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(78217);
      if (this.kKa != null) {
        this.kKa.run();
      }
      AppMethodBeat.o(78217);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(78219);
      this.dgl = paramParcel.readString();
      this.infoType = paramParcel.readInt();
      this.path = paramParcel.readString();
      AppMethodBeat.o(78219);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(78218);
      paramParcel.writeString(this.dgl);
      paramParcel.writeInt(this.infoType);
      paramParcel.writeString(this.path);
      AppMethodBeat.o(78218);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider
 * JD-Core Version:    0.7.0.1
 */