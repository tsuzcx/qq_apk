package com.tencent.ttpic.shader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShaderManager
{
  private static final ThreadLocal<ShaderManager> shaderManager;
  private Map<ShaderCreateFactory.PROGRAM_TYPE, Shader> shaderMap;
  
  static
  {
    AppMethodBeat.i(83744);
    shaderManager = new ShaderManager.1();
    AppMethodBeat.o(83744);
  }
  
  public ShaderManager()
  {
    AppMethodBeat.i(83737);
    this.shaderMap = new HashMap();
    AppMethodBeat.o(83737);
  }
  
  public static ShaderManager getInstance()
  {
    AppMethodBeat.i(83740);
    ShaderManager localShaderManager = (ShaderManager)shaderManager.get();
    AppMethodBeat.o(83740);
    return localShaderManager;
  }
  
  public boolean bind(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    AppMethodBeat.i(83738);
    paramPROGRAM_TYPE = (Shader)this.shaderMap.get(paramPROGRAM_TYPE);
    if (paramPROGRAM_TYPE == null)
    {
      AppMethodBeat.o(83738);
      return false;
    }
    paramPROGRAM_TYPE.bind();
    AppMethodBeat.o(83738);
    return true;
  }
  
  public void clear()
  {
    AppMethodBeat.i(83743);
    Iterator localIterator = this.shaderMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Shader)localIterator.next()).clear();
    }
    this.shaderMap.clear();
    AppMethodBeat.o(83743);
  }
  
  public boolean clearShader(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    AppMethodBeat.i(83742);
    Shader localShader = (Shader)this.shaderMap.get(paramPROGRAM_TYPE);
    if (localShader == null)
    {
      AppMethodBeat.o(83742);
      return false;
    }
    localShader.clear();
    this.shaderMap.remove(paramPROGRAM_TYPE);
    AppMethodBeat.o(83742);
    return true;
  }
  
  public void compile()
  {
    AppMethodBeat.i(83741);
    Iterator localIterator = this.shaderMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Shader)localIterator.next()).compile();
    }
    AppMethodBeat.o(83741);
  }
  
  public Shader getShader(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    AppMethodBeat.i(83739);
    if (!this.shaderMap.containsKey(paramPROGRAM_TYPE))
    {
      Shader localShader = ShaderCreateFactory.createShader(paramPROGRAM_TYPE);
      this.shaderMap.put(paramPROGRAM_TYPE, localShader);
    }
    paramPROGRAM_TYPE = (Shader)this.shaderMap.get(paramPROGRAM_TYPE);
    AppMethodBeat.o(83739);
    return paramPROGRAM_TYPE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.shader.ShaderManager
 * JD-Core Version:    0.7.0.1
 */