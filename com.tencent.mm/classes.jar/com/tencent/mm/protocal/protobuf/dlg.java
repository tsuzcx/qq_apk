package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dlg
  extends cwj
{
  public int FRO;
  public String Gua;
  public he HKf;
  public hi HSM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123658);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123658);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HKf != null)
      {
        paramVarArgs.lJ(2, this.HKf.computeSize());
        this.HKf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.FRO);
      if (this.HSM != null)
      {
        paramVarArgs.lJ(4, this.HSM.computeSize());
        this.HSM.writeFields(paramVarArgs);
      }
      if (this.Gua != null) {
        paramVarArgs.d(5, this.Gua);
      }
      AppMethodBeat.o(123658);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HKf != null) {
        i = paramInt + f.a.a.a.lI(2, this.HKf.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.FRO);
      paramInt = i;
      if (this.HSM != null) {
        paramInt = i + f.a.a.a.lI(4, this.HSM.computeSize());
      }
      i = paramInt;
      if (this.Gua != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gua);
      }
      AppMethodBeat.o(123658);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123658);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123658);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlg localdlg = (dlg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123658);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new he();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((he)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlg.HKf = ((he)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        case 3: 
          localdlg.FRO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123658);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlg.HSM = ((hi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123658);
          return 0;
        }
        localdlg.Gua = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123658);
        return 0;
      }
      AppMethodBeat.o(123658);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlg
 * JD-Core Version:    0.7.0.1
 */