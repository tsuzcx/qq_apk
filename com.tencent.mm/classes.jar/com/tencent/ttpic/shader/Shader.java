package com.tencent.ttpic.shader;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.ProgramTools;
import com.tencent.view.g;

public class Shader
{
  private final String fragmentShaderSource;
  private int shaderProgram;
  private final String vertexShaderSource;
  
  public Shader(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50233);
    this.shaderProgram = 0;
    this.fragmentShaderSource = BaseFilter.nativeDecrypt(paramString2);
    this.vertexShaderSource = BaseFilter.nativeDecrypt(paramString1);
    AppMethodBeat.o(50233);
  }
  
  public void bind()
  {
    AppMethodBeat.i(50235);
    GLES20.glUseProgram(this.shaderProgram);
    g.checkGlError("glUseProgram:" + this.shaderProgram);
    AppMethodBeat.o(50235);
  }
  
  public void clear()
  {
    AppMethodBeat.i(50236);
    GLES20.glDeleteProgram(this.shaderProgram);
    this.shaderProgram = 0;
    AppMethodBeat.o(50236);
  }
  
  public void compile()
  {
    AppMethodBeat.i(50234);
    if (this.shaderProgram == 0) {
      this.shaderProgram = ProgramTools.createProgram(this.vertexShaderSource, this.fragmentShaderSource);
    }
    AppMethodBeat.o(50234);
  }
  
  String getFragmentShaderSource()
  {
    return this.fragmentShaderSource;
  }
  
  public int getShaderProgram()
  {
    return this.shaderProgram;
  }
  
  String getVertexShaderSource()
  {
    return this.vertexShaderSource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.shader.Shader
 * JD-Core Version:    0.7.0.1
 */