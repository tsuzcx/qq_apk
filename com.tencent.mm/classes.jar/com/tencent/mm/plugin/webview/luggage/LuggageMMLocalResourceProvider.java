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
  public final String Eu()
  {
    return "weixin://resourceid/.*";
  }
  
  public final WebResourceResponse bW(String paramString)
  {
    AppMethodBeat.i(78221);
    final PipedOutputStream localPipedOutputStream = new PipedOutputStream();
    try
    {
      PipedInputStream localPipedInputStream = new PipedInputStream(localPipedOutputStream);
      final GetLocalResourceInfoTask localGetLocalResourceInfoTask = new GetLocalResourceInfoTask((byte)0);
      localGetLocalResourceInfoTask.diQ = paramString;
      localGetLocalResourceInfoTask.infoType = 1;
      localGetLocalResourceInfoTask.kiJ = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78214);
          h.Iye.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78213);
              Object localObject3 = null;
              Object localObject1 = null;
              try
              {
                InputStream localInputStream = com.tencent.mm.vfs.i.openRead(LuggageMMLocalResourceProvider.1.this.ASP.path);
                localObject1 = localInputStream;
                localObject3 = localInputStream;
                PipedOutputStream localPipedOutputStream = LuggageMMLocalResourceProvider.1.this.ASQ;
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
                  LuggageMMLocalResourceProvider.1.this.ASQ.close();
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
                  LuggageMMLocalResourceProvider.1.this.ASQ.close();
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
                  LuggageMMLocalResourceProvider.1.this.ASQ.close();
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
    String diQ;
    int infoType;
    Runnable kiJ;
    String path;
    
    static
    {
      AppMethodBeat.i(78220);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(78220);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(78217);
      if (this.kiJ != null) {
        this.kiJ.run();
      }
      AppMethodBeat.o(78217);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(78216);
      switch (this.infoType)
      {
      }
      for (;;)
      {
        aXw();
        AppMethodBeat.o(78216);
        return;
        this.path = aw.awI(this.diQ);
        continue;
        this.path = aw.awJ(this.diQ);
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(78219);
      this.diQ = paramParcel.readString();
      this.infoType = paramParcel.readInt();
      this.path = paramParcel.readString();
      AppMethodBeat.o(78219);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(78218);
      paramParcel.writeString(this.diQ);
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