package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doz
  extends cvp
{
  public cra FTQ;
  public int HDg;
  public ctf HDh;
  public String dxD;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72589);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      if (this.FTQ != null)
      {
        paramVarArgs.lC(4, this.FTQ.computeSize());
        this.FTQ.writeFields(paramVarArgs);
      }
      if (this.HDh != null)
      {
        paramVarArgs.lC(5, this.HDh.computeSize());
        this.HDh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.HDg);
      if (this.dxD != null) {
        paramVarArgs.d(7, this.dxD);
      }
      AppMethodBeat.o(72589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.FTQ != null) {
        i = paramInt + f.a.a.a.lB(4, this.FTQ.computeSize());
      }
      paramInt = i;
      if (this.HDh != null) {
        paramInt = i + f.a.a.a.lB(5, this.HDh.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HDg);
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dxD);
      }
      AppMethodBeat.o(72589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        doz localdoz = (doz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72589);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdoz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 2: 
          localdoz.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72589);
          return 0;
        case 3: 
          localdoz.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72589);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cra();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cra)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdoz.FTQ = ((cra)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdoz.HDh = ((ctf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 6: 
          localdoz.HDg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72589);
          return 0;
        }
        localdoz.dxD = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72589);
        return 0;
      }
      AppMethodBeat.o(72589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doz
 * JD-Core Version:    0.7.0.1
 */