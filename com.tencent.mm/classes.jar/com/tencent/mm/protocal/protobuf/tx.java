package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class tx
  extends com.tencent.mm.cd.a
{
  public String IbE;
  public LinkedList<ta> Scn;
  public fbn Sdr;
  public int Sds;
  public int Sdt;
  
  public tx()
  {
    AppMethodBeat.i(257989);
    this.Scn = new LinkedList();
    AppMethodBeat.o(257989);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257990);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sdr == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(257990);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.Scn);
      if (this.Sdr != null)
      {
        paramVarArgs.oE(2, this.Sdr.computeSize());
        this.Sdr.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.Sds);
      paramVarArgs.aY(4, this.Sdt);
      if (this.IbE != null) {
        paramVarArgs.f(5, this.IbE);
      }
      AppMethodBeat.o(257990);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Scn) + 0;
      paramInt = i;
      if (this.Sdr != null) {
        paramInt = i + g.a.a.a.oD(2, this.Sdr.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.Sds) + g.a.a.b.b.a.bM(4, this.Sdt);
      paramInt = i;
      if (this.IbE != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.IbE);
      }
      AppMethodBeat.o(257990);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Scn.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.Sdr == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(257990);
        throw paramVarArgs;
      }
      AppMethodBeat.o(257990);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      tx localtx = (tx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257990);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ta();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ta)localObject2).parseFrom((byte[])localObject1);
          }
          localtx.Scn.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257990);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fbn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fbn)localObject2).parseFrom((byte[])localObject1);
          }
          localtx.Sdr = ((fbn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257990);
        return 0;
      case 3: 
        localtx.Sds = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(257990);
        return 0;
      case 4: 
        localtx.Sdt = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(257990);
        return 0;
      }
      localtx.IbE = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(257990);
      return 0;
    }
    AppMethodBeat.o(257990);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tx
 * JD-Core Version:    0.7.0.1
 */