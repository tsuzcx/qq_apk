package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjj
  extends cvw
{
  public bb Ghz;
  public int HvW;
  public String wSZ;
  public int wTg;
  public String wTr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91575);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HvW);
      if (this.wSZ != null) {
        paramVarArgs.d(3, this.wSZ);
      }
      paramVarArgs.aS(4, this.wTg);
      if (this.wTr != null) {
        paramVarArgs.d(5, this.wTr);
      }
      if (this.Ghz != null)
      {
        paramVarArgs.lJ(6, this.Ghz.computeSize());
        this.Ghz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91575);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HvW);
      paramInt = i;
      if (this.wSZ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.wSZ);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.wTg);
      paramInt = i;
      if (this.wTr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wTr);
      }
      i = paramInt;
      if (this.Ghz != null) {
        i = paramInt + f.a.a.a.lI(6, this.Ghz.computeSize());
      }
      AppMethodBeat.o(91575);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91575);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjj localcjj = (cjj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91575);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91575);
          return 0;
        case 2: 
          localcjj.HvW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91575);
          return 0;
        case 3: 
          localcjj.wSZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91575);
          return 0;
        case 4: 
          localcjj.wTg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91575);
          return 0;
        case 5: 
          localcjj.wTr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91575);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcjj.Ghz = ((bb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91575);
        return 0;
      }
      AppMethodBeat.o(91575);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjj
 * JD-Core Version:    0.7.0.1
 */