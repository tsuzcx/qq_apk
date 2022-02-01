package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aci
  extends cwj
{
  public LinkedList<cfn> FNS;
  public String Guf;
  public String Gug;
  public String iKu;
  
  public aci()
  {
    AppMethodBeat.i(152524);
    this.FNS = new LinkedList();
    AppMethodBeat.o(152524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152525);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.iKu != null) {
        paramVarArgs.d(2, this.iKu);
      }
      paramVarArgs.e(3, 8, this.FNS);
      if (this.Guf != null) {
        paramVarArgs.d(4, this.Guf);
      }
      if (this.Gug != null) {
        paramVarArgs.d(5, this.Gug);
      }
      AppMethodBeat.o(152525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iKu != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.iKu);
      }
      i += f.a.a.a.c(3, 8, this.FNS);
      paramInt = i;
      if (this.Guf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Guf);
      }
      i = paramInt;
      if (this.Gug != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gug);
      }
      AppMethodBeat.o(152525);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FNS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aci localaci = (aci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152525);
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
            localaci.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 2: 
          localaci.iKu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152525);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaci.FNS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152525);
          return 0;
        case 4: 
          localaci.Guf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152525);
          return 0;
        }
        localaci.Gug = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152525);
        return 0;
      }
      AppMethodBeat.o(152525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aci
 * JD-Core Version:    0.7.0.1
 */