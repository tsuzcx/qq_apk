package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dcr
  extends com.tencent.mm.cd.a
{
  public int CqV;
  public int Saq;
  public eae SfI;
  public abv SfL;
  public int TKC;
  public int TKD;
  public int rVU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133187);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SfL == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      if (this.SfI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.CqV);
      if (this.SfL != null)
      {
        paramVarArgs.oE(2, this.SfL.computeSize());
        this.SfL.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.Saq);
      if (this.SfI != null)
      {
        paramVarArgs.oE(4, this.SfI.computeSize());
        this.SfI.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.rVU);
      paramVarArgs.aY(6, this.TKC);
      paramVarArgs.aY(7, this.TKD);
      AppMethodBeat.o(133187);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CqV) + 0;
      paramInt = i;
      if (this.SfL != null) {
        paramInt = i + g.a.a.a.oD(2, this.SfL.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.Saq);
      paramInt = i;
      if (this.SfI != null) {
        paramInt = i + g.a.a.a.oD(4, this.SfI.computeSize());
      }
      i = g.a.a.b.b.a.bM(5, this.rVU);
      int j = g.a.a.b.b.a.bM(6, this.TKC);
      int k = g.a.a.b.b.a.bM(7, this.TKD);
      AppMethodBeat.o(133187);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.SfL == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      if (this.SfI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133187);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dcr localdcr = (dcr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133187);
        return -1;
      case 1: 
        localdcr.CqV = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133187);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new abv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((abv)localObject2).parseFrom((byte[])localObject1);
          }
          localdcr.SfL = ((abv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133187);
        return 0;
      case 3: 
        localdcr.Saq = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133187);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localdcr.SfI = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133187);
        return 0;
      case 5: 
        localdcr.rVU = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133187);
        return 0;
      case 6: 
        localdcr.TKC = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133187);
        return 0;
      }
      localdcr.TKD = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(133187);
      return 0;
    }
    AppMethodBeat.o(133187);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcr
 * JD-Core Version:    0.7.0.1
 */