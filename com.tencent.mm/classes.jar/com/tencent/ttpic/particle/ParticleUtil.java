package com.tencent.ttpic.particle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Random;

public class ParticleUtil
{
  public static float dot(Vector2 paramVector21, Vector2 paramVector22)
  {
    return paramVector21.x * paramVector22.x + paramVector21.y * paramVector22.y;
  }
  
  public static float random0to1()
  {
    AppMethodBeat.i(83638);
    float f = new Random().nextFloat();
    AppMethodBeat.o(83638);
    return f;
  }
  
  public static float randomMinus1to1()
  {
    AppMethodBeat.i(83637);
    float f = new Random().nextFloat();
    AppMethodBeat.o(83637);
    return 1.0F - f * 2.0F;
  }
  
  public static Vector2 revert(Vector2 paramVector2)
  {
    AppMethodBeat.i(83639);
    paramVector2 = new Vector2(-paramVector2.x, -paramVector2.y);
    AppMethodBeat.o(83639);
    return paramVector2;
  }
  
  public static Vector2 vectorAdd(Vector2 paramVector21, Vector2 paramVector22)
  {
    AppMethodBeat.i(83636);
    paramVector21 = new Vector2(paramVector21.x + paramVector22.x, paramVector21.y + paramVector22.y);
    AppMethodBeat.o(83636);
    return paramVector21;
  }
  
  public static Vector2 vectorMultiplyScalar(Vector2 paramVector2, float paramFloat)
  {
    AppMethodBeat.i(83635);
    paramVector2 = new Vector2(paramVector2.x * paramFloat, paramVector2.y * paramFloat);
    AppMethodBeat.o(83635);
    return paramVector2;
  }
  
  public static Vector2 vectorNormalize(Vector2 paramVector2)
  {
    AppMethodBeat.i(83634);
    if ((Float.compare(paramVector2.x, 0.0F) == 0) && (Float.compare(paramVector2.y, 0.0F) == 0))
    {
      AppMethodBeat.o(83634);
      return null;
    }
    float f = (float)Math.sqrt(Math.pow(paramVector2.x, 2.0D) + Math.pow(paramVector2.x, 2.0D));
    paramVector2 = new Vector2(paramVector2.x / f, paramVector2.y / f);
    AppMethodBeat.o(83634);
    return paramVector2;
  }
  
  public static Vector2 vectorSubtract(Vector2 paramVector21, Vector2 paramVector22)
  {
    AppMethodBeat.i(83633);
    paramVector21 = new Vector2(paramVector21.x - paramVector22.x, paramVector21.y - paramVector22.y);
    AppMethodBeat.o(83633);
    return paramVector21;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.particle.ParticleUtil
 * JD-Core Version:    0.7.0.1
 */