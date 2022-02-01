package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ra
  extends com.tencent.mm.bw.a
{
  public qs Gfp;
  public qr Gfq;
  public long Gfr;
  public qy Gfs;
  public rc Gft;
  public qx Gfu;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117850);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nJA);
      if (this.Gfp != null)
      {
        paramVarArgs.lJ(2, this.Gfp.computeSize());
        this.Gfp.writeFields(paramVarArgs);
      }
      if (this.Gfq != null)
      {
        paramVarArgs.lJ(3, this.Gfq.computeSize());
        this.Gfq.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(4, this.Gfr);
      if (this.Gfs != null)
      {
        paramVarArgs.lJ(5, this.Gfs.computeSize());
        this.Gfs.writeFields(paramVarArgs);
      }
      if (this.Gft != null)
      {
        paramVarArgs.lJ(6, this.Gft.computeSize());
        this.Gft.writeFields(paramVarArgs);
      }
      if (this.Gfu != null)
      {
        paramVarArgs.lJ(7, this.Gfu.computeSize());
        this.Gfu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nJA) + 0;
      paramInt = i;
      if (this.Gfp != null) {
        paramInt = i + f.a.a.a.lI(2, this.Gfp.computeSize());
      }
      i = paramInt;
      if (this.Gfq != null) {
        i = paramInt + f.a.a.a.lI(3, this.Gfq.computeSize());
      }
      i += f.a.a.b.b.a.p(4, this.Gfr);
      paramInt = i;
      if (this.Gfs != null) {
        paramInt = i + f.a.a.a.lI(5, this.Gfs.computeSize());
      }
      i = paramInt;
      if (this.Gft != null) {
        i = paramInt + f.a.a.a.lI(6, this.Gft.computeSize());
      }
      paramInt = i;
      if (this.Gfu != null) {
        paramInt = i + f.a.a.a.lI(7, this.Gfu.computeSize());
      }
      AppMethodBeat.o(117850);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ra localra = (ra)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117850);
        return -1;
      case 1: 
        localra.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117850);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localra.Gfp = ((qs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localra.Gfq = ((qr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 4: 
        localra.Gfr = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(117850);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localra.Gfs = ((qy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localra.Gft = ((rc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117850);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new qx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((qx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localra.Gfu = ((qx)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117850);
      return 0;
    }
    AppMethodBeat.o(117850);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ra
 * JD-Core Version:    0.7.0.1
 */