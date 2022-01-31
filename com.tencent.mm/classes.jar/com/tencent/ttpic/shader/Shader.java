package com.tencent.ttpic.shader;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.gles.ProgramTools;
import com.tencent.view.f;

public class Shader
{
  private final String fragmentShaderSource;
  private int shaderProgram = 0;
  private final String vertexShaderSource;
  
  public Shader(String paramString1, String paramString2)
  {
    this.fragmentShaderSource = BaseFilter.nativeDecrypt(paramString2);
    this.vertexShaderSource = BaseFilter.nativeDecrypt(paramString1);
  }
  
  public void bind()
  {
    GLES20.glUseProgram(this.shaderProgram);
    f.checkGlError("glUseProgram:" + this.shaderProgram);
  }
  
  public void clear()
  {
    GLES20.glDeleteProgram(this.shaderProgram);
    this.shaderProgram = 0;
  }
  
  public void compile()
  {
    if (this.shaderProgram == 0) {
      this.shaderProgram = ProgramTools.createProgram(this.vertexShaderSource, this.fragmentShaderSource);
    }
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