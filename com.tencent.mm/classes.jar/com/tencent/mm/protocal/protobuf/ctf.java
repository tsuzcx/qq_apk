package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ctf
  extends com.tencent.mm.cd.a
{
  public long Icy;
  public fbn Sdr;
  public LinkedList<ctg> TBb;
  
  public ctf()
  {
    AppMethodBeat.i(140928);
    this.TBb = new LinkedList();
    AppMethodBeat.o(140928);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140929);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sdr == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140929);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.TBb);
      if (this.Sdr != null)
      {
        paramVarArgs.oE(2, this.Sdr.computeSize());
        this.Sdr.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(3, this.Icy);
      AppMethodBeat.o(140929);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.TBb) + 0;
      paramInt = i;
      if (this.Sdr != null) {
        paramInt = i + g.a.a.a.oD(2, this.Sdr.computeSize());
      }
      i = g.a.a.b.b.a.p(3, this.Icy);
      AppMethodBeat.o(140929);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TBb.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.Sdr == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140929);
        throw paramVarArgs;
      }
      AppMethodBeat.o(140929);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ctf localctf = (ctf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(140929);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ctg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ctg)localObject2).parseFrom((byte[])localObject1);
          }
          localctf.TBb.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(140929);
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
          localctf.Sdr = ((fbn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(140929);
        return 0;
      }
      localctf.Icy = ((g.a.a.a.a)localObject1).abFh.AN();
      AppMethodBeat.o(140929);
      return 0;
    }
    AppMethodBeat.o(140929);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctf
 * JD-Core Version:    0.7.0.1
 */