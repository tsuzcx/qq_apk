package com.tencent.ttpic.filter;

import android.annotation.TargetApi;
import android.opengl.GLES31;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.ProgramTools;
import com.tencent.ttpic.util.BenchUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(21)
public class ComputerFilter
{
  private static final String COMPUTE_SHADER = "#version 320 es\nlayout(local_size_x = 8) in;\nlayout(binding = 0) readonly buffer Input0 {\n    float data[];\n} input0;\nlayout(binding = 1) readonly buffer Input1 {\n    float data[];\n} input1;\nlayout(binding = 2) writeonly buffer Output {\n    float data[];\n} output0;\nvoid main()\n{\n    uint idx = gl_GlobalInvocationID.x;\n    float f = input0.data[idx] + input1.data[idx];    output0.data[idx] = f;\n}\n";
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(82118);
    TAG = ComputerFilter.class.getSimpleName();
    AppMethodBeat.o(82118);
  }
  
  public void init()
  {
    AppMethodBeat.i(82117);
    int j = ProgramTools.createComputeProgram("#version 320 es\nlayout(local_size_x = 8) in;\nlayout(binding = 0) readonly buffer Input0 {\n    float data[];\n} input0;\nlayout(binding = 1) readonly buffer Input1 {\n    float data[];\n} input1;\nlayout(binding = 2) writeonly buffer Output {\n    float data[];\n} output0;\nvoid main()\n{\n    uint idx = gl_GlobalInvocationID.x;\n    float f = input0.data[idx] + input1.data[idx];    output0.data[idx] = f;\n}\n");
    float[] arrayOfFloat1 = new float[8000];
    float[] arrayOfFloat2 = new float[8000];
    Object localObject1 = new float[8000];
    int i = 0;
    while (i < 8000)
    {
      arrayOfFloat1[i] = i;
      arrayOfFloat2[i] = i;
      i += 1;
    }
    Object localObject2 = new int[3];
    GLES31.glGenBuffers(3, (int[])localObject2, 0);
    int k = localObject2[0];
    int m = localObject2[1];
    int n = localObject2[2];
    BenchUtil.benchStart("setupSSBufferObject cpu");
    i = 0;
    while (i < 8000)
    {
      arrayOfFloat1[i] += arrayOfFloat2[i];
      i += 1;
    }
    BenchUtil.benchEnd("setupSSBufferObject cpu");
    BenchUtil.benchStart("setupSSBufferObject gpu");
    ProgramTools.setupSSBufferObject(k, 0, arrayOfFloat1, 8000);
    ProgramTools.setupSSBufferObject(m, 1, arrayOfFloat2, 8000);
    ProgramTools.setupSSBufferObject(n, 2, null, 8000);
    GLES31.glUseProgram(j);
    GLES31.glDispatchCompute(1000, 1, 1);
    GLES31.glMemoryBarrier(8192);
    GLES31.glFinish();
    GlUtil.checkGlError(TAG + " pre-glMapBufferRange ");
    BenchUtil.benchEnd("setupSSBufferObject gpu");
    GLES31.glBindBuffer(37074, n);
    localObject1 = (ByteBuffer)GLES31.glMapBufferRange(37074, 0, 32000, 1);
    ((ByteBuffer)localObject1).order(ByteOrder.nativeOrder());
    localObject1 = ((ByteBuffer)localObject1).asFloatBuffer();
    localObject2 = new float[((FloatBuffer)localObject1).remaining()];
    ((FloatBuffer)localObject1).get((float[])localObject2);
    i = 0;
    while (i < 8000)
    {
      if (Math.abs(localObject2[i] - (arrayOfFloat1[i] + arrayOfFloat2[i])) > 0.0001D)
      {
        GLES31.glUnmapBuffer(37074);
        AppMethodBeat.o(82117);
        return;
      }
      i += 1;
    }
    GLES31.glUnmapBuffer(37074);
    GLES31.glDeleteProgram(j);
    AppMethodBeat.o(82117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.ComputerFilter
 * JD-Core Version:    0.7.0.1
 */