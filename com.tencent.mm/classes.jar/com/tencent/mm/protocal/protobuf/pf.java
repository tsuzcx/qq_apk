package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pf
  extends com.tencent.mm.cd.a
{
  public String CPq;
  public int RIs;
  public String RRW;
  public LinkedList<String> RXF;
  public int RXG;
  public String RXL;
  public LinkedList<pe> RXM;
  public String UserName;
  public String mVB;
  public String rWI;
  
  public pf()
  {
    AppMethodBeat.i(210574);
    this.RXM = new LinkedList();
    this.RXF = new LinkedList();
    AppMethodBeat.o(210574);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210577);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RIs);
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(3, this.rWI);
      }
      if (this.CPq != null) {
        paramVarArgs.f(4, this.CPq);
      }
      if (this.mVB != null) {
        paramVarArgs.f(5, this.mVB);
      }
      if (this.RRW != null) {
        paramVarArgs.f(6, this.RRW);
      }
      if (this.RXL != null) {
        paramVarArgs.f(7, this.RXL);
      }
      paramVarArgs.e(8, 8, this.RXM);
      paramVarArgs.e(9, 1, this.RXF);
      paramVarArgs.aY(10, this.RXG);
      AppMethodBeat.o(210577);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.RIs) + 0;
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.rWI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.rWI);
      }
      paramInt = i;
      if (this.CPq != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CPq);
      }
      i = paramInt;
      if (this.mVB != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.mVB);
      }
      paramInt = i;
      if (this.RRW != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RRW);
      }
      i = paramInt;
      if (this.RXL != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RXL);
      }
      paramInt = g.a.a.a.c(8, 8, this.RXM);
      int j = g.a.a.a.c(9, 1, this.RXF);
      int k = g.a.a.b.b.a.bM(10, this.RXG);
      AppMethodBeat.o(210577);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RXM.clear();
      this.RXF.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(210577);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      pf localpf = (pf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(210577);
        return -1;
      case 1: 
        localpf.RIs = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(210577);
        return 0;
      case 2: 
        localpf.UserName = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(210577);
        return 0;
      case 3: 
        localpf.rWI = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(210577);
        return 0;
      case 4: 
        localpf.CPq = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(210577);
        return 0;
      case 5: 
        localpf.mVB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(210577);
        return 0;
      case 6: 
        localpf.RRW = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(210577);
        return 0;
      case 7: 
        localpf.RXL = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(210577);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          pe localpe = new pe();
          if ((localObject != null) && (localObject.length > 0)) {
            localpe.parseFrom((byte[])localObject);
          }
          localpf.RXM.add(localpe);
          paramInt += 1;
        }
        AppMethodBeat.o(210577);
        return 0;
      case 9: 
        localpf.RXF.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(210577);
        return 0;
      }
      localpf.RXG = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(210577);
      return 0;
    }
    AppMethodBeat.o(210577);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pf
 * JD-Core Version:    0.7.0.1
 */