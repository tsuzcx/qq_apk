package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ceo
  extends cvp
{
  public String FDq;
  public cky FDr;
  public cgb FDs;
  public String GYr;
  public String GYy;
  public bpu GYz;
  public int ozR;
  public String ozS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72531);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72531);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      if (this.GYr != null) {
        paramVarArgs.d(4, this.GYr);
      }
      if (this.FDq != null) {
        paramVarArgs.d(5, this.FDq);
      }
      if (this.GYy != null) {
        paramVarArgs.d(6, this.GYy);
      }
      if (this.FDr != null)
      {
        paramVarArgs.lC(7, this.FDr.computeSize());
        this.FDr.writeFields(paramVarArgs);
      }
      if (this.FDs != null)
      {
        paramVarArgs.lC(8, this.FDs.computeSize());
        this.FDs.writeFields(paramVarArgs);
      }
      if (this.GYz != null)
      {
        paramVarArgs.lC(9, this.GYz.computeSize());
        this.GYz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt;
      if (this.GYr != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GYr);
      }
      paramInt = i;
      if (this.FDq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FDq);
      }
      i = paramInt;
      if (this.GYy != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GYy);
      }
      paramInt = i;
      if (this.FDr != null) {
        paramInt = i + f.a.a.a.lB(7, this.FDr.computeSize());
      }
      i = paramInt;
      if (this.FDs != null) {
        i = paramInt + f.a.a.a.lB(8, this.FDs.computeSize());
      }
      paramInt = i;
      if (this.GYz != null) {
        paramInt = i + f.a.a.a.lB(9, this.GYz.computeSize());
      }
      AppMethodBeat.o(72531);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ceo localceo = (ceo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72531);
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
            localceo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 2: 
          localceo.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72531);
          return 0;
        case 3: 
          localceo.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 4: 
          localceo.GYr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 5: 
          localceo.FDq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 6: 
          localceo.GYy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cky();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cky)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceo.FDr = ((cky)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localceo.FDs = ((cgb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bpu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localceo.GYz = ((bpu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      AppMethodBeat.o(72531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceo
 * JD-Core Version:    0.7.0.1
 */