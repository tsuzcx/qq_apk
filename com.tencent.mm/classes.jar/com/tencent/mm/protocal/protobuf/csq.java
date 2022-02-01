package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class csq
  extends com.tencent.mm.cd.a
{
  public int DpE;
  public LinkedList<csr> TAq;
  public LinkedList<csr> TAr;
  public csr TAs;
  public int TAt;
  public long fNu;
  public String key;
  
  public csq()
  {
    AppMethodBeat.i(239431);
    this.TAq = new LinkedList();
    this.TAr = new LinkedList();
    AppMethodBeat.o(239431);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(239436);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.TAq);
      paramVarArgs.e(2, 8, this.TAr);
      if (this.TAs != null)
      {
        paramVarArgs.oE(3, this.TAs.computeSize());
        this.TAs.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.DpE);
      paramVarArgs.aY(5, this.TAt);
      paramVarArgs.bm(6, this.fNu);
      if (this.key != null) {
        paramVarArgs.f(7, this.key);
      }
      AppMethodBeat.o(239436);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.TAq) + 0 + g.a.a.a.c(2, 8, this.TAr);
      paramInt = i;
      if (this.TAs != null) {
        paramInt = i + g.a.a.a.oD(3, this.TAs.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.DpE) + g.a.a.b.b.a.bM(5, this.TAt) + g.a.a.b.b.a.p(6, this.fNu);
      paramInt = i;
      if (this.key != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.key);
      }
      AppMethodBeat.o(239436);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TAq.clear();
      this.TAr.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(239436);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      csq localcsq = (csq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      csr localcsr;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(239436);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localcsr = new csr();
          if ((localObject != null) && (localObject.length > 0)) {
            localcsr.parseFrom((byte[])localObject);
          }
          localcsq.TAq.add(localcsr);
          paramInt += 1;
        }
        AppMethodBeat.o(239436);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localcsr = new csr();
          if ((localObject != null) && (localObject.length > 0)) {
            localcsr.parseFrom((byte[])localObject);
          }
          localcsq.TAr.add(localcsr);
          paramInt += 1;
        }
        AppMethodBeat.o(239436);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localcsr = new csr();
          if ((localObject != null) && (localObject.length > 0)) {
            localcsr.parseFrom((byte[])localObject);
          }
          localcsq.TAs = localcsr;
          paramInt += 1;
        }
        AppMethodBeat.o(239436);
        return 0;
      case 4: 
        localcsq.DpE = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(239436);
        return 0;
      case 5: 
        localcsq.TAt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(239436);
        return 0;
      case 6: 
        localcsq.fNu = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(239436);
        return 0;
      }
      localcsq.key = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(239436);
      return 0;
    }
    AppMethodBeat.o(239436);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csq
 * JD-Core Version:    0.7.0.1
 */