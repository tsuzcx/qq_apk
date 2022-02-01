package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ctl
  extends cwj
{
  public String FUM;
  public LinkedList<duy> HEx;
  public dpk HEy;
  public int HgD;
  public int nID;
  
  public ctl()
  {
    AppMethodBeat.i(56260);
    this.HEx = new LinkedList();
    AppMethodBeat.o(56260);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56261);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56261);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nID);
      paramVarArgs.e(3, 8, this.HEx);
      if (this.FUM != null) {
        paramVarArgs.d(4, this.FUM);
      }
      paramVarArgs.aS(5, this.HgD);
      if (this.HEy != null)
      {
        paramVarArgs.lJ(6, this.HEy.computeSize());
        this.HEy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56261);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nID) + f.a.a.a.c(3, 8, this.HEx);
      paramInt = i;
      if (this.FUM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FUM);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HgD);
      paramInt = i;
      if (this.HEy != null) {
        paramInt = i + f.a.a.a.lI(6, this.HEy.computeSize());
      }
      AppMethodBeat.o(56261);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HEx.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56261);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56261);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctl localctl = (ctl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56261);
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
            localctl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56261);
          return 0;
        case 2: 
          localctl.nID = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56261);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new duy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((duy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctl.HEx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56261);
          return 0;
        case 4: 
          localctl.FUM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(56261);
          return 0;
        case 5: 
          localctl.HgD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(56261);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localctl.HEy = ((dpk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56261);
        return 0;
      }
      AppMethodBeat.o(56261);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctl
 * JD-Core Version:    0.7.0.1
 */