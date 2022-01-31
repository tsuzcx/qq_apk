package com.tencent.ttpic.filter;

import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.Map;

public class AlgoToothWhitenFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER;
  private static final String VERTEX_SHADER;
  private int algoTexture;
  private float centerX;
  private float centerY;
  private float eyePouch;
  private float radius;
  private float whiteTeeth;
  
  static
  {
    AppMethodBeat.i(81951);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/AlgoToothWhitenVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/AlgoToothWhitenFragmentShader.dat");
    AppMethodBeat.o(81951);
  }
  
  public AlgoToothWhitenFilter(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(81948);
    this.whiteTeeth = 0.0F;
    this.eyePouch = 0.0F;
    this.algoTexture = paramInt;
    this.radius = paramFloat1;
    this.centerX = paramFloat2;
    this.centerY = paramFloat3;
    initParams();
    AppMethodBeat.o(81948);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(81949);
    addParam(new m.f("radius", this.radius));
    addParam(new m.b("center", this.centerX, this.centerY));
    addParam(new m.f("whiteTeeth", this.whiteTeeth));
    addParam(new m.f("eyePouch", this.eyePouch));
    addParam(new m.n("inputAlgoTexture", this.algoTexture, 33985));
    AppMethodBeat.o(81949);
  }
  
  public void setParam(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(81950);
    if (paramMap.containsKey("whiteTeeth")) {
      this.whiteTeeth = ((Float)paramMap.get("whiteTeeth")).floatValue();
    }
    if (paramMap.containsKey("eyePouch")) {
      this.eyePouch = ((Float)paramMap.get("eyePouch")).floatValue();
    }
    this.whiteTeeth /= 100.0F;
    this.eyePouch /= 100.0F;
    addParam(new m.f("whiteTeeth", this.whiteTeeth));
    addParam(new m.f("eyePouch", this.eyePouch));
    AppMethodBeat.o(81950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.AlgoToothWhitenFilter
 * JD-Core Version:    0.7.0.1
 */