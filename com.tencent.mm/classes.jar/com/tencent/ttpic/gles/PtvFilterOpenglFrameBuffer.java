package com.tencent.ttpic.gles;

import android.opengl.GLES20;

public class PtvFilterOpenglFrameBuffer
{
  public static final boolean DEBUG_ON = true;
  private int[] mFrameBufferId = new int[1];
  private boolean mNeedDepth;
  private boolean mNeedStencil;
  private int[] mRenderBufferDepth = new int[1];
  private int[] mRenderBufferStencil = new int[1];
  private int[] mStatusCheck = new int[1];
  private int mVideoHeight;
  private int mVideoWidth;
  
  public static void GLLogMsg(String paramString) {}
  
  public static void checkErrorCode(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      GLLogMsg("checkErrorCode: errFunc =" + paramString + "err=" + i);
    }
  }
  
  private void initReanderBuffer()
  {
    if (this.mNeedDepth)
    {
      GLES20.glGenRenderbuffers(1, this.mRenderBufferDepth, 0);
      checkErrorCode("glGenRenderbuffers");
      GLES20.glBindRenderbuffer(36161, this.mRenderBufferDepth[0]);
      checkErrorCode("glBindRenderbuffer:0");
      GLES20.glRenderbufferStorage(36161, 33189, this.mVideoWidth, this.mVideoHeight);
      checkErrorCode("glRenderbufferStorage:0");
      GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.mRenderBufferDepth[0]);
      checkErrorCode("glFramebufferRenderbuffer:0");
    }
    if (this.mNeedStencil)
    {
      GLES20.glGenRenderbuffers(1, this.mRenderBufferStencil, 0);
      checkErrorCode("glGenRenderbuffers");
      GLES20.glBindRenderbuffer(36161, this.mRenderBufferStencil[0]);
      checkErrorCode("glBindRenderbuffer:0");
      GLES20.glRenderbufferStorage(36161, 36168, this.mVideoWidth, this.mVideoHeight);
      GLES20.glFramebufferRenderbuffer(36160, 36128, 36161, this.mRenderBufferStencil[0]);
    }
  }
  
  public boolean initFrameBuffer(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.mNeedDepth = paramBoolean1;
    this.mNeedStencil = paramBoolean2;
    checkErrorCode("glIsTexture");
    GLES20.glGenFramebuffers(1, this.mFrameBufferId, 0);
    checkErrorCode("glGenFramebuffers");
    GLES20.glBindFramebuffer(36160, this.mFrameBufferId[0]);
    checkErrorCode("glBindFramebuffer");
    initReanderBuffer();
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
    checkErrorCode("glFramebufferTexture2D");
    paramInt = GLES20.glCheckFramebufferStatus(36160);
    if (paramInt != 36053)
    {
      checkErrorCode("glCheckFramebufferStatus: status=" + paramInt);
      return false;
    }
    makeCurrentFrameBuffer();
    return true;
  }
  
  public void initSharedTextureMemory(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mVideoWidth = paramInt2;
    this.mVideoHeight = paramInt3;
    GLES20.glBindTexture(3553, paramInt1);
    checkErrorCode("glBindTexture");
    GLES20.glTexParameteri(3553, 10240, 9728);
    checkErrorCode("glTexParameteri");
    GLES20.glTexParameteri(3553, 10241, 9728);
    checkErrorCode("glTexParameteri");
    GLES20.glTexParameteri(3553, 10242, 33071);
    checkErrorCode("glTexParameteri");
    GLES20.glTexParameteri(3553, 10243, 33071);
    checkErrorCode("glTexParameteri");
    GLES20.glTexImage2D(3553, 0, 6408, this.mVideoWidth, this.mVideoHeight, 0, 6408, 5121, null);
    checkErrorCode("glTexImage2D");
    GLES20.glBindTexture(3553, 0);
    checkErrorCode("glBindTexture");
  }
  
  public void makeCurrentFrameBuffer()
  {
    GLES20.glBindFramebuffer(36160, this.mFrameBufferId[0]);
    GLES20.glGetIntegerv(36006, this.mStatusCheck, 0);
    GLLogMsg("[makeCurrentFrameBuffer]GL_FRAMEBUFFER_BINDING: mStatusCheck=" + this.mStatusCheck[0] + " mFrameBufferId[0]=" + this.mFrameBufferId[0]);
    checkErrorCode("glBindFramebuffer: [makeCurrentFrameBuffer]mFrameBufferId=" + this.mFrameBufferId[0]);
  }
  
  public void release()
  {
    restoreToWindFrameBuffer();
    if (this.mNeedDepth) {
      GLES20.glDeleteRenderbuffers(1, this.mRenderBufferDepth, 0);
    }
    if (this.mNeedStencil) {
      GLES20.glDeleteRenderbuffers(1, this.mRenderBufferStencil, 0);
    }
    GLES20.glDeleteFramebuffers(1, this.mFrameBufferId, 0);
    this.mFrameBufferId[0] = 0;
    this.mRenderBufferDepth[0] = 0;
    this.mRenderBufferStencil[0] = 0;
  }
  
  public void restoreToWindFrameBuffer()
  {
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glGetIntegerv(36006, this.mStatusCheck, 0);
    GLLogMsg("[restoreToWindFrameBuffer]GL_FRAMEBUFFER_BINDING: mStatusCheck=" + this.mStatusCheck[0]);
    checkErrorCode("glBindFramebuffer: [restoreToWindFrameBuffer]mFrameBufferId=0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.gles.PtvFilterOpenglFrameBuffer
 * JD-Core Version:    0.7.0.1
 */