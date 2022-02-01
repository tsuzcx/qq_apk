package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aii
  extends dyl
{
  public int HlE;
  public long HlH;
  public String RIi;
  public String RJQ;
  public int RVD;
  public int Sat;
  public long Stb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148652);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.HlE);
      paramVarArgs.aY(2, this.Sat);
      paramVarArgs.aY(3, this.RVD);
      if (this.RJQ != null) {
        paramVarArgs.f(4, this.RJQ);
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(5, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.HlH);
      if (this.RIi != null) {
        paramVarArgs.f(7, this.RIi);
      }
      paramVarArgs.bm(8, this.Stb);
      AppMethodBeat.o(148652);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.HlE) + 0 + g.a.a.b.b.a.bM(2, this.Sat) + g.a.a.b.b.a.bM(3, this.RVD);
      paramInt = i;
      if (this.RJQ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RJQ);
      }
      i = paramInt;
      if (this.BaseRequest != null) {
        i = paramInt + g.a.a.a.oD(5, this.BaseRequest.computeSize());
      }
      i += g.a.a.b.b.a.p(6, this.HlH);
      paramInt = i;
      if (this.RIi != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RIi);
      }
      i = g.a.a.b.b.a.p(8, this.Stb);
      AppMethodBeat.o(148652);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(148652);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      aii localaii = (aii)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(148652);
        return -1;
      case 1: 
        localaii.HlE = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(148652);
        return 0;
      case 2: 
        localaii.Sat = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(148652);
        return 0;
      case 3: 
        localaii.RVD = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(148652);
        return 0;
      case 4: 
        localaii.RJQ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(148652);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          jg localjg = new jg();
          if ((localObject != null) && (localObject.length > 0)) {
            localjg.parseFrom((byte[])localObject);
          }
          localaii.BaseRequest = localjg;
          paramInt += 1;
        }
        AppMethodBeat.o(148652);
        return 0;
      case 6: 
        localaii.HlH = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(148652);
        return 0;
      case 7: 
        localaii.RIi = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(148652);
        return 0;
      }
      localaii.Stb = ((g.a.a.a.a)localObject).abFh.AN();
      AppMethodBeat.o(148652);
      return 0;
    }
    AppMethodBeat.o(148652);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aii
 * JD-Core Version:    0.7.0.1
 */