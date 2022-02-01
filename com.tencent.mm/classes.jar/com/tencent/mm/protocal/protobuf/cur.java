package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cur
  extends cvw
{
  public String HFt;
  public String HsZ;
  public int dGC;
  public String vAE;
  public String vwq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116341);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vwq != null) {
        paramVarArgs.d(2, this.vwq);
      }
      if (this.HsZ != null) {
        paramVarArgs.d(3, this.HsZ);
      }
      paramVarArgs.aS(4, this.dGC);
      if (this.vAE != null) {
        paramVarArgs.d(5, this.vAE);
      }
      if (this.HFt != null) {
        paramVarArgs.d(6, this.HFt);
      }
      AppMethodBeat.o(116341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vwq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vwq);
      }
      i = paramInt;
      if (this.HsZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HsZ);
      }
      i += f.a.a.b.b.a.bz(4, this.dGC);
      paramInt = i;
      if (this.vAE != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vAE);
      }
      i = paramInt;
      if (this.HFt != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HFt);
      }
      AppMethodBeat.o(116341);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cur localcur = (cur)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116341);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcur.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116341);
          return 0;
        case 2: 
          localcur.vwq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116341);
          return 0;
        case 3: 
          localcur.HsZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116341);
          return 0;
        case 4: 
          localcur.dGC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(116341);
          return 0;
        case 5: 
          localcur.vAE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(116341);
          return 0;
        }
        localcur.HFt = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(116341);
        return 0;
      }
      AppMethodBeat.o(116341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cur
 * JD-Core Version:    0.7.0.1
 */