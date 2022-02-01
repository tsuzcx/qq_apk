package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwc
  extends com.tencent.mm.cd.a
{
  public int SsD;
  public int SsE;
  public int Ssu;
  public String Ssv;
  public String Ssw;
  public int Ssx;
  public int Ssy;
  public int Ssz;
  public fdc Ucb;
  public fdc Ucc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115848);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Ssu);
      if (this.Ssv != null) {
        paramVarArgs.f(2, this.Ssv);
      }
      if (this.Ssw != null) {
        paramVarArgs.f(3, this.Ssw);
      }
      paramVarArgs.aY(4, this.Ssx);
      paramVarArgs.aY(5, this.Ssy);
      paramVarArgs.aY(6, this.Ssz);
      if (this.Ucb != null)
      {
        paramVarArgs.oE(7, this.Ucb.computeSize());
        this.Ucb.writeFields(paramVarArgs);
      }
      if (this.Ucc != null)
      {
        paramVarArgs.oE(8, this.Ucc.computeSize());
        this.Ucc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.SsD);
      paramVarArgs.aY(10, this.SsE);
      AppMethodBeat.o(115848);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Ssu) + 0;
      paramInt = i;
      if (this.Ssv != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Ssv);
      }
      i = paramInt;
      if (this.Ssw != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ssw);
      }
      i = i + g.a.a.b.b.a.bM(4, this.Ssx) + g.a.a.b.b.a.bM(5, this.Ssy) + g.a.a.b.b.a.bM(6, this.Ssz);
      paramInt = i;
      if (this.Ucb != null) {
        paramInt = i + g.a.a.a.oD(7, this.Ucb.computeSize());
      }
      i = paramInt;
      if (this.Ucc != null) {
        i = paramInt + g.a.a.a.oD(8, this.Ucc.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(9, this.SsD);
      int j = g.a.a.b.b.a.bM(10, this.SsE);
      AppMethodBeat.o(115848);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(115848);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dwc localdwc = (dwc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      fdc localfdc;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115848);
        return -1;
      case 1: 
        localdwc.Ssu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115848);
        return 0;
      case 2: 
        localdwc.Ssv = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(115848);
        return 0;
      case 3: 
        localdwc.Ssw = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(115848);
        return 0;
      case 4: 
        localdwc.Ssx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115848);
        return 0;
      case 5: 
        localdwc.Ssy = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115848);
        return 0;
      case 6: 
        localdwc.Ssz = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115848);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfdc = new fdc();
          if ((localObject != null) && (localObject.length > 0)) {
            localfdc.parseFrom((byte[])localObject);
          }
          localdwc.Ucb = localfdc;
          paramInt += 1;
        }
        AppMethodBeat.o(115848);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localfdc = new fdc();
          if ((localObject != null) && (localObject.length > 0)) {
            localfdc.parseFrom((byte[])localObject);
          }
          localdwc.Ucc = localfdc;
          paramInt += 1;
        }
        AppMethodBeat.o(115848);
        return 0;
      case 9: 
        localdwc.SsD = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115848);
        return 0;
      }
      localdwc.SsE = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(115848);
      return 0;
    }
    AppMethodBeat.o(115848);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwc
 * JD-Core Version:    0.7.0.1
 */