package com.tencent.ttpic.shader;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShaderManager$1
  extends ThreadLocal<ShaderManager>
{
  protected final ShaderManager initialValue()
  {
    AppMethodBeat.i(83735);
    ShaderManager localShaderManager = new ShaderManager();
    AppMethodBeat.o(83735);
    return localShaderManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.shader.ShaderManager.1
 * JD-Core Version:    0.7.0.1
 */