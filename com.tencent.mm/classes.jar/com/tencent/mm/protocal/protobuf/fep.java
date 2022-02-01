package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fep
  extends com.tencent.mm.bw.a
{
  public int KSa;
  public int MSo;
  public int MSq;
  public String Md5;
  public int NAa;
  public boolean NAb;
  public String NAc;
  public int NAd;
  public fem NzO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153341);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NzO != null)
      {
        paramVarArgs.ni(1, this.NzO.computeSize());
        this.NzO.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.NAa);
      paramVarArgs.aM(3, this.MSo);
      paramVarArgs.aM(4, this.MSq);
      paramVarArgs.cc(5, this.NAb);
      paramVarArgs.aM(6, this.KSa);
      if (this.Md5 != null) {
        paramVarArgs.e(7, this.Md5);
      }
      if (this.NAc != null) {
        paramVarArgs.e(8, this.NAc);
      }
      paramVarArgs.aM(9, this.NAd);
      AppMethodBeat.o(153341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NzO == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = g.a.a.a.nh(1, this.NzO.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.NAa) + g.a.a.b.b.a.bu(3, this.MSo) + g.a.a.b.b.a.bu(4, this.MSq) + (g.a.a.b.b.a.fS(5) + 1) + g.a.a.b.b.a.bu(6, this.KSa);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Md5);
      }
      i = paramInt;
      if (this.NAc != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.NAc);
      }
      paramInt = g.a.a.b.b.a.bu(9, this.NAd);
      AppMethodBeat.o(153341);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fep localfep = (fep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153341);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fem();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((fem)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfep.NzO = ((fem)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153341);
          return 0;
        case 2: 
          localfep.NAa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153341);
          return 0;
        case 3: 
          localfep.MSo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153341);
          return 0;
        case 4: 
          localfep.MSq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153341);
          return 0;
        case 5: 
          localfep.NAb = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153341);
          return 0;
        case 6: 
          localfep.KSa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153341);
          return 0;
        case 7: 
          localfep.Md5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153341);
          return 0;
        case 8: 
          localfep.NAc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153341);
          return 0;
        }
        localfep.NAd = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(153341);
        return 0;
      }
      AppMethodBeat.o(153341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fep
 * JD-Core Version:    0.7.0.1
 */