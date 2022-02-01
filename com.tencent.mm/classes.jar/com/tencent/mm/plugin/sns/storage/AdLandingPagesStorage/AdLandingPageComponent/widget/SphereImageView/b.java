package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

public final class b
  implements GLTextureView.m
{
  private int Acj;
  private int Ack;
  private int Acl;
  private final float[] Acm;
  private FloatBuffer Acn;
  private FloatBuffer Aco;
  int Acp;
  public float Acq;
  public float Acr;
  public float Acs;
  final float[] Act;
  protected float Acu;
  protected float Acv;
  protected float Acw;
  protected Context mContext;
  final float[] mMVPMatrix;
  private int mProgram;
  private int mSize;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(97272);
    this.Acm = new float[16];
    this.Acq = 0.0F;
    this.Acr = 90.0F;
    this.Act = new float[16];
    this.mMVPMatrix = new float[16];
    this.Acu = 1.0F;
    this.Acv = 20.0F;
    this.Acw = 0.0F;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(97272);
  }
  
  private void init()
  {
    AppMethodBeat.i(97273);
    int i;
    int j;
    for (;;)
    {
      try
      {
        l = System.currentTimeMillis();
        localArrayList = new ArrayList();
        localObject = new ArrayList();
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        long l;
        ArrayList localArrayList;
        Object localObject;
        float f1;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        ae.e("SphereImageView.SphereRender", "init, exp:" + localThrowable.toString());
        AppMethodBeat.o(97273);
        return;
      }
      if (j >= 50) {
        break label1028;
      }
      f1 = (float)(i * 0.01999999955296516D);
      f2 = (float)(j * 0.01999999955296516D);
      f3 = (float)((i + 1) * 0.01999999955296516D);
      f4 = (float)(j * 0.01999999955296516D);
      f5 = (float)((i + 1) * 0.01999999955296516D);
      f6 = (float)((j + 1) * 0.01999999955296516D);
      f7 = (float)(i * 0.01999999955296516D);
      f8 = (float)((j + 1) * 0.01999999955296516D);
      ((ArrayList)localObject).add(Float.valueOf(f2));
      ((ArrayList)localObject).add(Float.valueOf(f1));
      ((ArrayList)localObject).add(Float.valueOf(f4));
      ((ArrayList)localObject).add(Float.valueOf(f3));
      ((ArrayList)localObject).add(Float.valueOf(f6));
      ((ArrayList)localObject).add(Float.valueOf(f5));
      ((ArrayList)localObject).add(Float.valueOf(f6));
      ((ArrayList)localObject).add(Float.valueOf(f5));
      ((ArrayList)localObject).add(Float.valueOf(f8));
      ((ArrayList)localObject).add(Float.valueOf(f7));
      ((ArrayList)localObject).add(Float.valueOf(f2));
      ((ArrayList)localObject).add(Float.valueOf(f1));
      f1 = (float)(Math.sin(i * 0.1256637061435917D / 2.0D) * Math.cos(j * 0.1256637061435917D));
      f2 = (float)(Math.sin(i * 0.1256637061435917D / 2.0D) * Math.sin(j * 0.1256637061435917D));
      f3 = (float)Math.cos(i * 0.1256637061435917D / 2.0D);
      f4 = (float)(Math.sin((i + 1) * 0.1256637061435917D / 2.0D) * Math.cos(j * 0.1256637061435917D));
      f5 = (float)(Math.sin((i + 1) * 0.1256637061435917D / 2.0D) * Math.sin(j * 0.1256637061435917D));
      f6 = (float)Math.cos((i + 1) * 0.1256637061435917D / 2.0D);
      f7 = (float)(Math.sin((i + 1) * 0.1256637061435917D / 2.0D) * Math.cos((j + 1) * 0.1256637061435917D));
      f8 = (float)(Math.sin((i + 1) * 0.1256637061435917D / 2.0D) * Math.sin((j + 1) * 0.1256637061435917D));
      f9 = (float)Math.cos((i + 1) * 0.1256637061435917D / 2.0D);
      f10 = (float)(Math.sin(i * 0.1256637061435917D / 2.0D) * Math.cos((j + 1) * 0.1256637061435917D));
      f11 = (float)(Math.sin(i * 0.1256637061435917D / 2.0D) * Math.sin((j + 1) * 0.1256637061435917D));
      f12 = (float)Math.cos(i * 0.1256637061435917D / 2.0D);
      localArrayList.add(Float.valueOf(f1));
      localArrayList.add(Float.valueOf(f3));
      localArrayList.add(Float.valueOf(f2));
      localArrayList.add(Float.valueOf(f4));
      localArrayList.add(Float.valueOf(f6));
      localArrayList.add(Float.valueOf(f5));
      localArrayList.add(Float.valueOf(f7));
      localArrayList.add(Float.valueOf(f9));
      localArrayList.add(Float.valueOf(f8));
      localArrayList.add(Float.valueOf(f7));
      localArrayList.add(Float.valueOf(f9));
      localArrayList.add(Float.valueOf(f8));
      localArrayList.add(Float.valueOf(f10));
      localArrayList.add(Float.valueOf(f12));
      localArrayList.add(Float.valueOf(f11));
      localArrayList.add(Float.valueOf(f1));
      localArrayList.add(Float.valueOf(f3));
      localArrayList.add(Float.valueOf(f2));
      j += 1;
    }
    label1028:
    label1035:
    for (;;)
    {
      this.mSize = (localArrayList.size() / 3);
      float[] arrayOfFloat = new float[this.mSize * 2];
      i = 0;
      while (i < arrayOfFloat.length)
      {
        arrayOfFloat[i] = ((Float)((ArrayList)localObject).get(i)).floatValue();
        i += 1;
      }
      this.Aco = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.Aco.put(arrayOfFloat);
      this.Aco.position(0);
      localObject = new float[this.mSize * 3];
      i = 0;
      while (i < localObject.length)
      {
        localObject[i] = ((Float)localArrayList.get(i)).floatValue();
        i += 1;
      }
      this.Acn = ByteBuffer.allocateDirect(localObject.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.Acn.put((float[])localObject);
      this.Acn.position(0);
      ae.i("SphereImageView.SphereRender", "init, timeCost=" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(97273);
      return;
      for (;;)
      {
        if (i >= 50) {
          break label1035;
        }
        j = 0;
        break;
        i += 1;
      }
    }
  }
  
  public final void ag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(97274);
    ae.i("SphereImageView.SphereRender", "setScaleParams, near=" + paramFloat1 + ", far=30.0, z=" + paramFloat2);
    if (paramFloat1 >= 30.0F)
    {
      AppMethodBeat.o(97274);
      return;
    }
    this.Acu = paramFloat1;
    this.Acv = 30.0F;
    this.Acw = paramFloat2;
    AppMethodBeat.o(97274);
  }
  
  public final void ebB()
  {
    AppMethodBeat.i(97277);
    ae.i("SphereImageView.SphereRender", "onSurfaceCreated");
    AppMethodBeat.o(97277);
  }
  
  public final void ebC()
  {
    AppMethodBeat.i(97275);
    try
    {
      Matrix.rotateM(this.Act, 0, -this.Acq, 1.0F, 0.0F, 0.0F);
      Matrix.rotateM(this.Act, 0, -this.Acr, 0.0F, 1.0F, 0.0F);
      Matrix.rotateM(this.Act, 0, -this.Acs, 0.0F, 0.0F, 1.0F);
      GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
      GLES20.glClear(16640);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.Acp);
      int i = this.Ack;
      Matrix.multiplyMM(this.mMVPMatrix, 0, this.Acm, 0, this.Act, 0);
      Matrix.setIdentityM(this.Act, 0);
      GLES20.glUniformMatrix4fv(i, 1, false, this.mMVPMatrix, 0);
      GLES20.glDrawArrays(4, 0, this.mSize);
      AppMethodBeat.o(97275);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.d("SphereImageView.SphereRender", "onDrawFrame, exp=" + localThrowable.toString());
      AppMethodBeat.o(97275);
    }
  }
  
  public final void hL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97276);
    try
    {
      ae.i("SphereImageView.SphereRender", "onSurfaceChanged, w=" + paramInt1 + ", h=" + paramInt2 + "， textureID=" + this.Acp + ", near=" + this.Acu + ", far=" + this.Acv + ", z=" + this.Acw);
      long l1 = System.currentTimeMillis();
      if (paramInt2 == 0)
      {
        AppMethodBeat.o(97276);
        return;
      }
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      GLES20.glEnable(2884);
      float f = paramInt1 / paramInt2;
      Matrix.frustumM(this.Acm, 0, -f, f, -1.0F, 1.0F, this.Acu, this.Acv);
      Matrix.setIdentityM(this.Act, 0);
      Matrix.setIdentityM(this.mMVPMatrix, 0);
      Matrix.translateM(this.Acm, 0, 0.0F, 0.0F, this.Acw);
      Matrix.scaleM(this.Acm, 0, 4.0F, 4.0F, 4.0F);
      paramInt1 = GLES20.glCreateProgram();
      paramInt2 = GLES20.glCreateShader(35632);
      int i = GLES20.glCreateShader(35633);
      GLES20.glShaderSource(i, "attribute vec4 aPosition;attribute vec2 aTextureCoord;uniform mat4 uProjectMatrix;varying vec2 vTextureCoord;void main(){gl_Position = uProjectMatrix * aPosition;\nvTextureCoord = aTextureCoord;\n}");
      GLES20.glShaderSource(paramInt2, "precision mediump float;varying vec2 vTextureCoord;uniform sampler2D uTexture;void main(){gl_FragColor = texture2D(uTexture, vTextureCoord);}");
      GLES20.glCompileShader(i);
      GLES20.glCompileShader(paramInt2);
      GLES20.glAttachShader(paramInt1, i);
      GLES20.glAttachShader(paramInt1, paramInt2);
      GLES20.glLinkProgram(paramInt1);
      this.mProgram = paramInt1;
      GLES20.glUseProgram(this.mProgram);
      this.Acj = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
      this.Ack = GLES20.glGetUniformLocation(this.mProgram, "uProjectMatrix");
      this.Acl = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
      ae.i("SphereImageView.SphereRender", "aPosition:" + this.Acj);
      ae.i("SphereImageView.SphereRender", "uProjectMatrix:" + this.Ack);
      ae.i("SphereImageView.SphereRender", "aTextureCoord:" + this.Acl);
      GLES20.glVertexAttribPointer(this.Acj, 3, 5126, false, 0, this.Acn);
      GLES20.glVertexAttribPointer(this.Acl, 2, 5126, false, 0, this.Aco);
      GLES20.glEnableVertexAttribArray(this.Acj);
      GLES20.glEnableVertexAttribArray(this.Acl);
      long l2 = System.currentTimeMillis();
      ae.i("SphereImageView.SphereRender", "onSurfaceChanged, timeCost=" + (l2 - l1));
      AppMethodBeat.o(97276);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("SphereImageView.SphereRender", "onSurfaceChanged, exp=" + localThrowable.toString());
      AppMethodBeat.o(97276);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.b
 * JD-Core Version:    0.7.0.1
 */