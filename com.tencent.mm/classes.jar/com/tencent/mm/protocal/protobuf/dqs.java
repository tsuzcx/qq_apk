package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dqs
  extends cvp
{
  public int HEE;
  public gx HEF;
  public aw HEG;
  public ccd HEH;
  public ht HEI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133205);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HEE);
      if (this.HEF != null)
      {
        paramVarArgs.lC(3, this.HEF.computeSize());
        this.HEF.writeFields(paramVarArgs);
      }
      if (this.HEG != null)
      {
        paramVarArgs.lC(4, this.HEG.computeSize());
        this.HEG.writeFields(paramVarArgs);
      }
      if (this.HEH != null)
      {
        paramVarArgs.lC(5, this.HEH.computeSize());
        this.HEH.writeFields(paramVarArgs);
      }
      if (this.HEI != null)
      {
        paramVarArgs.lC(6, this.HEI.computeSize());
        this.HEI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1022;
      }
    }
    label1022:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HEE);
      paramInt = i;
      if (this.HEF != null) {
        paramInt = i + f.a.a.a.lB(3, this.HEF.computeSize());
      }
      i = paramInt;
      if (this.HEG != null) {
        i = paramInt + f.a.a.a.lB(4, this.HEG.computeSize());
      }
      paramInt = i;
      if (this.HEH != null) {
        paramInt = i + f.a.a.a.lB(5, this.HEH.computeSize());
      }
      i = paramInt;
      if (this.HEI != null) {
        i = paramInt + f.a.a.a.lB(6, this.HEI.computeSize());
      }
      AppMethodBeat.o(133205);
      return i;
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
          AppMethodBeat.o(133205);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133205);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqs localdqs = (dqs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133205);
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
            localdqs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 2: 
          localdqs.HEE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(133205);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqs.HEF = ((gx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqs.HEG = ((aw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqs.HEH = ((ccd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ht();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqs.HEI = ((ht)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133205);
        return 0;
      }
      AppMethodBeat.o(133205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqs
 * JD-Core Version:    0.7.0.1
 */