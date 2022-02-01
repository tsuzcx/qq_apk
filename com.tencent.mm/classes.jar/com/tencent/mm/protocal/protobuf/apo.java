package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apo
  extends com.tencent.mm.bw.a
{
  public float GGC;
  public float GGD;
  public float GGE;
  public float GGF;
  public float GGG;
  public boolean GGH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189369);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.y(1, this.GGC);
      paramVarArgs.y(2, this.GGD);
      paramVarArgs.y(3, this.GGE);
      paramVarArgs.y(4, this.GGF);
      paramVarArgs.y(5, this.GGG);
      paramVarArgs.bC(6, this.GGH);
      AppMethodBeat.o(189369);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amE(1);
      int i = f.a.a.b.b.a.amE(2);
      int j = f.a.a.b.b.a.amE(3);
      int k = f.a.a.b.b.a.amE(4);
      int m = f.a.a.b.b.a.amE(5);
      int n = f.a.a.b.b.a.amF(6);
      AppMethodBeat.o(189369);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189369);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      apo localapo = (apo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189369);
        return -1;
      case 1: 
        localapo.GGC = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(189369);
        return 0;
      case 2: 
        localapo.GGD = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(189369);
        return 0;
      case 3: 
        localapo.GGE = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(189369);
        return 0;
      case 4: 
        localapo.GGF = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(189369);
        return 0;
      case 5: 
        localapo.GGG = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(189369);
        return 0;
      }
      localapo.GGH = locala.OmT.gvY();
      AppMethodBeat.o(189369);
      return 0;
    }
    AppMethodBeat.o(189369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apo
 * JD-Core Version:    0.7.0.1
 */