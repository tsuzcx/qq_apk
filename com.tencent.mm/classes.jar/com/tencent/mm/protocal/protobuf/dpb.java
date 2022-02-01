package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpb
  extends cvp
{
  public ctf HDh;
  public String HDm;
  public String HDn;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72591);
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
      if (this.HDm != null) {
        paramVarArgs.d(4, this.HDm);
      }
      if (this.HDn != null) {
        paramVarArgs.d(5, this.HDn);
      }
      if (this.HDh != null)
      {
        paramVarArgs.lC(6, this.HDh.computeSize());
        this.HDh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.HDm != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HDm);
      }
      paramInt = i;
      if (this.HDn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HDn);
      }
      i = paramInt;
      if (this.HDh != null) {
        i = paramInt + f.a.a.a.lB(6, this.HDh.computeSize());
      }
      AppMethodBeat.o(72591);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpb localdpb = (dpb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72591);
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
            localdpb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72591);
          return 0;
        case 2: 
          localdpb.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72591);
          return 0;
        case 3: 
          localdpb.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72591);
          return 0;
        case 4: 
          localdpb.HDm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72591);
          return 0;
        case 5: 
          localdpb.HDn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72591);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ctf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdpb.HDh = ((ctf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72591);
        return 0;
      }
      AppMethodBeat.o(72591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpb
 * JD-Core Version:    0.7.0.1
 */