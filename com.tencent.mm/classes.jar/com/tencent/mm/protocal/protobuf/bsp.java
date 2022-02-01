package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public class bsp
  extends com.tencent.mm.cd.a
{
  public int SmI;
  public int SmJ;
  public int SmK;
  public b SmM;
  public cjk SmN;
  public int TcR;
  public int TcS;
  public int TcT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143973);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SmI);
      paramVarArgs.aY(2, this.SmJ);
      paramVarArgs.aY(3, this.SmK);
      if (this.SmM != null) {
        paramVarArgs.c(4, this.SmM);
      }
      paramVarArgs.aY(5, this.TcR);
      paramVarArgs.aY(6, this.TcS);
      paramVarArgs.aY(7, this.TcT);
      if (this.SmN != null)
      {
        paramVarArgs.oE(8, this.SmN.computeSize());
        this.SmN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.SmI) + 0 + g.a.a.b.b.a.bM(2, this.SmJ) + g.a.a.b.b.a.bM(3, this.SmK);
      paramInt = i;
      if (this.SmM != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.SmM);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.TcR) + g.a.a.b.b.a.bM(6, this.TcS) + g.a.a.b.b.a.bM(7, this.TcT);
      paramInt = i;
      if (this.SmN != null) {
        paramInt = i + g.a.a.a.oD(8, this.SmN.computeSize());
      }
      AppMethodBeat.o(143973);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bsp localbsp = (bsp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143973);
        return -1;
      case 1: 
        localbsp.SmI = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143973);
        return 0;
      case 2: 
        localbsp.SmJ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143973);
        return 0;
      case 3: 
        localbsp.SmK = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143973);
        return 0;
      case 4: 
        localbsp.SmM = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(143973);
        return 0;
      case 5: 
        localbsp.TcR = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143973);
        return 0;
      case 6: 
        localbsp.TcS = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143973);
        return 0;
      case 7: 
        localbsp.TcT = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143973);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        cjk localcjk = new cjk();
        if ((localObject != null) && (localObject.length > 0)) {
          localcjk.parseFrom((byte[])localObject);
        }
        localbsp.SmN = localcjk;
        paramInt += 1;
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    AppMethodBeat.o(143973);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsp
 * JD-Core Version:    0.7.0.1
 */