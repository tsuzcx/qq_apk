package com.tencent.tav.codec;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.DecoderUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/codec/MediaCodecAnalyse;", "Lcom/tencent/tav/codec/IMediaCodec;", "()V", "data", "Lcom/tencent/tav/codec/MediaCodecAnalyse$Companion$MediaCodecData;", "bindSurfaceTexture", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "configure", "format", "Landroid/media/MediaFormat;", "surface", "Landroid/view/Surface;", "crypto", "Landroid/media/MediaCrypto;", "flags", "", "createInputSurface", "dequeueInputBuffer", "timeoutUs", "", "dequeueOutputBuffer", "info", "Landroid/media/MediaCodec$BufferInfo;", "flush", "getCodec", "Landroid/media/MediaCodec;", "getInputBuffer", "Ljava/nio/ByteBuffer;", "index", "getOutputBuffer", "getOutputFormat", "queueInputBuffer", "offset", "size", "presentationTimeUs", "release", "releaseOutputBuffer", "render", "", "reset", "setDataSource", "path", "", "signalEndOfInputStream", "start", "stop", "Companion", "avfoundation_release"}, k=1, mv={1, 1, 15})
public final class MediaCodecAnalyse
  implements IMediaCodec
{
  public static final Companion Companion;
  private static int DEBUG_COUNT = 0;
  private static final String DEFAULT_SCENE = "default";
  private static final String STATE_CREATE = "create";
  private static final String STATE_RELEASE = "release";
  private static final String STATE_RESET = "reset";
  private static final String STATE_START = "start";
  private static final String STATE_STOP = "stop";
  private static final String TAG = "MediaCodecAnalyse";
  private static final ArrayList<MediaCodecAnalyse.Companion.MediaCodecData> analyseList;
  private final MediaCodecAnalyse.Companion.MediaCodecData data;
  
  static
  {
    AppMethodBeat.i(214748);
    Companion = new Companion(null);
    analyseList = new ArrayList();
    AppMethodBeat.o(214748);
  }
  
  public MediaCodecAnalyse()
  {
    AppMethodBeat.i(214736);
    this.data = new MediaCodecAnalyse.Companion.MediaCodecData(null, null, false, null, null, null, 63, null);
    AppMethodBeat.o(214736);
  }
  
  public static final MediaCodecAnalyse createDecoderByType(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214796);
    paramString1 = Companion.createDecoderByType(paramString1, paramString2);
    AppMethodBeat.o(214796);
    return paramString1;
  }
  
  public static final MediaCodecAnalyse createEncoderByType(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214809);
    paramString1 = Companion.createEncoderByType(paramString1, paramString2);
    AppMethodBeat.o(214809);
    return paramString1;
  }
  
  public final void bindSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(214879);
    s.t(paramSurfaceTexture, "surfaceTexture");
    AppMethodBeat.o(214879);
  }
  
  public final void configure(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt)
  {
    AppMethodBeat.i(214819);
    this.data.setFormat(paramMediaFormat);
    MediaCodec localMediaCodec = this.data.getCodec();
    if (localMediaCodec != null)
    {
      localMediaCodec.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
      AppMethodBeat.o(214819);
      return;
    }
    AppMethodBeat.o(214819);
  }
  
  public final Surface createInputSurface()
  {
    AppMethodBeat.i(214951);
    Object localObject = this.data.getCodec();
    if (localObject != null)
    {
      localObject = ((MediaCodec)localObject).createInputSurface();
      AppMethodBeat.o(214951);
      return localObject;
    }
    AppMethodBeat.o(214951);
    return null;
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    AppMethodBeat.i(214897);
    MediaCodec localMediaCodec = this.data.getCodec();
    if (localMediaCodec != null)
    {
      int i = localMediaCodec.dequeueInputBuffer(paramLong);
      AppMethodBeat.o(214897);
      return i;
    }
    AppMethodBeat.o(214897);
    return -1;
  }
  
  public final int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    AppMethodBeat.i(214886);
    s.t(paramBufferInfo, "info");
    MediaCodec localMediaCodec = this.data.getCodec();
    if (localMediaCodec != null)
    {
      int i = localMediaCodec.dequeueOutputBuffer(paramBufferInfo, paramLong);
      AppMethodBeat.o(214886);
      return i;
    }
    AppMethodBeat.o(214886);
    return -1;
  }
  
  public final void flush()
  {
    AppMethodBeat.i(214842);
    MediaCodec localMediaCodec = this.data.getCodec();
    if (localMediaCodec != null)
    {
      localMediaCodec.flush();
      AppMethodBeat.o(214842);
      return;
    }
    AppMethodBeat.o(214842);
  }
  
  public final MediaCodec getCodec()
  {
    AppMethodBeat.i(214986);
    MediaCodec localMediaCodec = this.data.getCodec();
    AppMethodBeat.o(214986);
    return localMediaCodec;
  }
  
  public final ByteBuffer getInputBuffer(int paramInt)
  {
    AppMethodBeat.i(214931);
    ByteBuffer localByteBuffer = DecoderUtils.getInputBuffer(this, paramInt);
    AppMethodBeat.o(214931);
    return localByteBuffer;
  }
  
  public final ByteBuffer getOutputBuffer(int paramInt)
  {
    AppMethodBeat.i(214902);
    ByteBuffer localByteBuffer = DecoderUtils.getOutputBuffer(this, paramInt);
    AppMethodBeat.o(214902);
    return localByteBuffer;
  }
  
  public final MediaFormat getOutputFormat()
  {
    AppMethodBeat.i(214977);
    Object localObject = this.data.getCodec();
    if (localObject != null)
    {
      localObject = ((MediaCodec)localObject).getOutputFormat();
      AppMethodBeat.o(214977);
      return localObject;
    }
    AppMethodBeat.o(214977);
    return null;
  }
  
  public final void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(214911);
    MediaCodec localMediaCodec = this.data.getCodec();
    if (localMediaCodec != null)
    {
      localMediaCodec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
      AppMethodBeat.o(214911);
      return;
    }
    AppMethodBeat.o(214911);
  }
  
  public final void release()
  {
    AppMethodBeat.i(214863);
    Companion.access$removeInstance(Companion, this.data);
    this.data.setState("release");
    MediaCodec localMediaCodec = this.data.getCodec();
    if (localMediaCodec != null)
    {
      localMediaCodec.release();
      AppMethodBeat.o(214863);
      return;
    }
    AppMethodBeat.o(214863);
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(214941);
    MediaCodec localMediaCodec = this.data.getCodec();
    if (localMediaCodec != null)
    {
      localMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      AppMethodBeat.o(214941);
      return;
    }
    AppMethodBeat.o(214941);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(214970);
    this.data.setState("reset");
    MediaCodec localMediaCodec = this.data.getCodec();
    if (localMediaCodec != null)
    {
      localMediaCodec.reset();
      AppMethodBeat.o(214970);
      return;
    }
    AppMethodBeat.o(214970);
  }
  
  public final void setDataSource(String paramString) {}
  
  public final void signalEndOfInputStream()
  {
    AppMethodBeat.i(214962);
    MediaCodec localMediaCodec = this.data.getCodec();
    if (localMediaCodec != null)
    {
      localMediaCodec.signalEndOfInputStream();
      AppMethodBeat.o(214962);
      return;
    }
    AppMethodBeat.o(214962);
  }
  
  public final void start()
  {
    AppMethodBeat.i(214829);
    this.data.setState("start");
    MediaCodec localMediaCodec = this.data.getCodec();
    if (localMediaCodec != null)
    {
      localMediaCodec.start();
      AppMethodBeat.o(214829);
      return;
    }
    AppMethodBeat.o(214829);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(214850);
    this.data.setState("stop");
    MediaCodec localMediaCodec = this.data.getCodec();
    if (localMediaCodec != null)
    {
      localMediaCodec.stop();
      AppMethodBeat.o(214850);
      return;
    }
    AppMethodBeat.o(214850);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/codec/MediaCodecAnalyse$Companion;", "", "()V", "DEBUG_COUNT", "", "getDEBUG_COUNT", "()I", "setDEBUG_COUNT", "(I)V", "DEFAULT_SCENE", "", "STATE_CREATE", "STATE_RELEASE", "STATE_RESET", "STATE_START", "STATE_STOP", "TAG", "analyseList", "Ljava/util/ArrayList;", "Lcom/tencent/tav/codec/MediaCodecAnalyse$Companion$MediaCodecData;", "Lkotlin/collections/ArrayList;", "addNewInstance", "", "data", "createDecoderByType", "Lcom/tencent/tav/codec/MediaCodecAnalyse;", "type", "scene", "createEncoderByType", "getCodecInfo", "Lorg/json/JSONArray;", "instanceCount", "makeDebugCountIncrease", "removeInstance", "MediaCodecData", "avfoundation_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    private final void addNewInstance(MediaCodecData paramMediaCodecData)
    {
      AppMethodBeat.i(214746);
      MediaCodecAnalyse.access$getAnalyseList$cp().add(paramMediaCodecData);
      AppMethodBeat.o(214746);
    }
    
    private final void removeInstance(MediaCodecData paramMediaCodecData)
    {
      AppMethodBeat.i(214754);
      MediaCodecAnalyse.access$getAnalyseList$cp().remove(paramMediaCodecData);
      AppMethodBeat.o(214754);
    }
    
    public final MediaCodecAnalyse createDecoderByType(String paramString1, String paramString2)
    {
      AppMethodBeat.i(214870);
      s.t(paramString1, "type");
      s.t(paramString2, "scene");
      MediaCodecAnalyse localMediaCodecAnalyse = new MediaCodecAnalyse();
      MediaCodecAnalyse.access$getData$p(localMediaCodecAnalyse).setScene(paramString2);
      MediaCodecAnalyse.access$getData$p(localMediaCodecAnalyse).setCodec(MediaCodec.createDecoderByType(paramString1));
      paramString2 = MediaCodecAnalyse.access$getData$p(localMediaCodecAnalyse);
      paramString1 = MediaCodecAnalyse.access$getData$p(localMediaCodecAnalyse).getCodec();
      if (paramString1 != null) {}
      for (paramString1 = paramString1.getName();; paramString1 = null)
      {
        paramString2.setName(paramString1);
        MediaCodecAnalyse.access$getData$p(localMediaCodecAnalyse).setEncoder(false);
        MediaCodecAnalyse.Companion.addNewInstance(MediaCodecAnalyse.access$getData$p(localMediaCodecAnalyse));
        AppMethodBeat.o(214870);
        return localMediaCodecAnalyse;
      }
    }
    
    public final MediaCodecAnalyse createEncoderByType(String paramString1, String paramString2)
    {
      AppMethodBeat.i(214884);
      s.t(paramString1, "type");
      s.t(paramString2, "scene");
      MediaCodecAnalyse localMediaCodecAnalyse = new MediaCodecAnalyse();
      MediaCodecAnalyse.access$getData$p(localMediaCodecAnalyse).setScene(paramString2);
      MediaCodecAnalyse.access$getData$p(localMediaCodecAnalyse).setCodec(MediaCodec.createEncoderByType(paramString1));
      paramString2 = MediaCodecAnalyse.access$getData$p(localMediaCodecAnalyse);
      paramString1 = MediaCodecAnalyse.access$getData$p(localMediaCodecAnalyse).getCodec();
      if (paramString1 != null) {}
      for (paramString1 = paramString1.getName();; paramString1 = null)
      {
        paramString2.setName(paramString1);
        MediaCodecAnalyse.access$getData$p(localMediaCodecAnalyse).setEncoder(true);
        MediaCodecAnalyse.Companion.addNewInstance(MediaCodecAnalyse.access$getData$p(localMediaCodecAnalyse));
        AppMethodBeat.o(214884);
        return localMediaCodecAnalyse;
      }
    }
    
    public final JSONArray getCodecInfo()
    {
      AppMethodBeat.i(214847);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = ((Iterable)MediaCodecAnalyse.access$getAnalyseList$cp()).iterator();
      if (localIterator.hasNext())
      {
        MediaCodecData localMediaCodecData = (MediaCodecData)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        if (localMediaCodecData != null)
        {
          localObject = localMediaCodecData.getName();
          label65:
          localJSONObject.put("name", localObject);
          if (localMediaCodecData == null) {
            break label184;
          }
          localObject = Boolean.valueOf(localMediaCodecData.getEncoder());
          label88:
          localJSONObject.put("encoder", ((Boolean)localObject).booleanValue());
          if (localMediaCodecData == null) {
            break label189;
          }
          localObject = localMediaCodecData.getScene();
          label111:
          localJSONObject.put("scene", localObject);
          if (localMediaCodecData == null) {
            break label194;
          }
          localObject = localMediaCodecData.getState();
          label131:
          localJSONObject.put("state", localObject);
          if (localMediaCodecData == null) {
            break label199;
          }
          localObject = localMediaCodecData.getFormat();
          if (localObject == null) {
            break label199;
          }
        }
        label184:
        label189:
        label194:
        label199:
        for (Object localObject = ((MediaFormat)localObject).toString();; localObject = null)
        {
          localJSONObject.put("format", localObject);
          localJSONArray.put(localJSONObject);
          break;
          localObject = null;
          break label65;
          localObject = null;
          break label88;
          localObject = null;
          break label111;
          localObject = null;
          break label131;
        }
      }
      AppMethodBeat.o(214847);
      return localJSONArray;
    }
    
    public final int getDEBUG_COUNT()
    {
      AppMethodBeat.i(214812);
      int i = MediaCodecAnalyse.access$getDEBUG_COUNT$cp();
      AppMethodBeat.o(214812);
      return i;
    }
    
    public final int instanceCount()
    {
      AppMethodBeat.i(214856);
      int i = MediaCodecAnalyse.access$getAnalyseList$cp().size();
      AppMethodBeat.o(214856);
      return i;
    }
    
    public final void makeDebugCountIncrease()
    {
      AppMethodBeat.i(214832);
      Companion localCompanion = (Companion)this;
      localCompanion.setDEBUG_COUNT(localCompanion.getDEBUG_COUNT() + 1);
      AppMethodBeat.o(214832);
    }
    
    public final void setDEBUG_COUNT(int paramInt)
    {
      AppMethodBeat.i(214824);
      MediaCodecAnalyse.access$setDEBUG_COUNT$cp(paramInt);
      AppMethodBeat.o(214824);
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/codec/MediaCodecAnalyse$Companion$MediaCodecData;", "", "name", "", "codec", "Landroid/media/MediaCodec;", "encoder", "", "format", "Landroid/media/MediaFormat;", "scene", "state", "(Ljava/lang/String;Landroid/media/MediaCodec;ZLandroid/media/MediaFormat;Ljava/lang/String;Ljava/lang/String;)V", "getCodec", "()Landroid/media/MediaCodec;", "setCodec", "(Landroid/media/MediaCodec;)V", "getEncoder", "()Z", "setEncoder", "(Z)V", "getFormat", "()Landroid/media/MediaFormat;", "setFormat", "(Landroid/media/MediaFormat;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getScene", "setScene", "getState", "setState", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "avfoundation_release"}, k=1, mv={1, 1, 15})
    static final class MediaCodecData
    {
      private MediaCodec codec;
      private boolean encoder;
      private MediaFormat format;
      private String name;
      private String scene;
      private String state;
      
      public MediaCodecData()
      {
        this(null, null, false, null, null, null, 63, null);
      }
      
      public MediaCodecData(String paramString1, MediaCodec paramMediaCodec, boolean paramBoolean, MediaFormat paramMediaFormat, String paramString2, String paramString3)
      {
        AppMethodBeat.i(214778);
        this.name = paramString1;
        this.codec = paramMediaCodec;
        this.encoder = paramBoolean;
        this.format = paramMediaFormat;
        this.scene = paramString2;
        this.state = paramString3;
        AppMethodBeat.o(214778);
      }
      
      public final String component1()
      {
        return this.name;
      }
      
      public final MediaCodec component2()
      {
        return this.codec;
      }
      
      public final boolean component3()
      {
        return this.encoder;
      }
      
      public final MediaFormat component4()
      {
        return this.format;
      }
      
      public final String component5()
      {
        return this.scene;
      }
      
      public final String component6()
      {
        return this.state;
      }
      
      public final MediaCodecData copy(String paramString1, MediaCodec paramMediaCodec, boolean paramBoolean, MediaFormat paramMediaFormat, String paramString2, String paramString3)
      {
        AppMethodBeat.i(215004);
        s.t(paramString2, "scene");
        s.t(paramString3, "state");
        paramString1 = new MediaCodecData(paramString1, paramMediaCodec, paramBoolean, paramMediaFormat, paramString2, paramString3);
        AppMethodBeat.o(215004);
        return paramString1;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(215036);
        if (this != paramObject)
        {
          if (!(paramObject instanceof MediaCodecData)) {
            break label121;
          }
          paramObject = (MediaCodecData)paramObject;
          if ((!s.p(this.name, paramObject.name)) || (!s.p(this.codec, paramObject.codec))) {
            break label121;
          }
          if (this.encoder != paramObject.encoder) {
            break label116;
          }
        }
        label116:
        for (int i = 1; (i != 0) && (s.p(this.format, paramObject.format)) && (s.p(this.scene, paramObject.scene)) && (s.p(this.state, paramObject.state)); i = 0)
        {
          AppMethodBeat.o(215036);
          return true;
        }
        label121:
        AppMethodBeat.o(215036);
        return false;
      }
      
      public final MediaCodec getCodec()
      {
        return this.codec;
      }
      
      public final boolean getEncoder()
      {
        return this.encoder;
      }
      
      public final MediaFormat getFormat()
      {
        return this.format;
      }
      
      public final String getName()
      {
        return this.name;
      }
      
      public final String getScene()
      {
        return this.scene;
      }
      
      public final String getState()
      {
        return this.state;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final void setCodec(MediaCodec paramMediaCodec)
      {
        this.codec = paramMediaCodec;
      }
      
      public final void setEncoder(boolean paramBoolean)
      {
        this.encoder = paramBoolean;
      }
      
      public final void setFormat(MediaFormat paramMediaFormat)
      {
        this.format = paramMediaFormat;
      }
      
      public final void setName(String paramString)
      {
        this.name = paramString;
      }
      
      public final void setScene(String paramString)
      {
        AppMethodBeat.i(214928);
        s.t(paramString, "<set-?>");
        this.scene = paramString;
        AppMethodBeat.o(214928);
      }
      
      public final void setState(String paramString)
      {
        AppMethodBeat.i(214950);
        s.t(paramString, "<set-?>");
        this.state = paramString;
        AppMethodBeat.o(214950);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(215013);
        String str = "MediaCodecData(name=" + this.name + ", codec=" + this.codec + ", encoder=" + this.encoder + ", format=" + this.format + ", scene=" + this.scene + ", state=" + this.state + ")";
        AppMethodBeat.o(215013);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.codec.MediaCodecAnalyse
 * JD-Core Version:    0.7.0.1
 */