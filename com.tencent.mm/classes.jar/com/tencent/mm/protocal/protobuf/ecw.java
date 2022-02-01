package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ecw
  extends dyl
{
  public String RYJ;
  public long UdA;
  public long UdF;
  public int Uhm;
  public long Uhn;
  public boolean Uho;
  public fox Uhp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117921);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RYJ != null) {
        paramVarArgs.f(2, this.RYJ);
      }
      paramVarArgs.bm(3, this.UdA);
      paramVarArgs.aY(4, this.Uhm);
      paramVarArgs.bm(5, this.Uhn);
      paramVarArgs.co(6, this.Uho);
      if (this.Uhp != null)
      {
        paramVarArgs.oE(7, this.Uhp.computeSize());
        this.Uhp.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(8, this.UdF);
      AppMethodBeat.o(117921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label698;
      }
    }
    label698:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RYJ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RYJ);
      }
      i = i + g.a.a.b.b.a.p(3, this.UdA) + g.a.a.b.b.a.bM(4, this.Uhm) + g.a.a.b.b.a.p(5, this.Uhn) + (g.a.a.b.b.a.gL(6) + 1);
      paramInt = i;
      if (this.Uhp != null) {
        paramInt = i + g.a.a.a.oD(7, this.Uhp.computeSize());
      }
      i = g.a.a.b.b.a.p(8, this.UdF);
      AppMethodBeat.o(117921);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ecw localecw = (ecw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117921);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localecw.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117921);
          return 0;
        case 2: 
          localecw.RYJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117921);
          return 0;
        case 3: 
          localecw.UdA = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(117921);
          return 0;
        case 4: 
          localecw.Uhm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117921);
          return 0;
        case 5: 
          localecw.Uhn = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(117921);
          return 0;
        case 6: 
          localecw.Uho = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(117921);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fox();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fox)localObject2).parseFrom((byte[])localObject1);
            }
            localecw.Uhp = ((fox)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117921);
          return 0;
        }
        localecw.UdF = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(117921);
        return 0;
      }
      AppMethodBeat.o(117921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecw
 * JD-Core Version:    0.7.0.1
 */