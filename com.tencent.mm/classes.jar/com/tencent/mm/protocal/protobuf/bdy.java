package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdy
  extends cwj
{
  public com.tencent.mm.bw.b GTs;
  public LinkedList<bvm> GTu;
  public int GTv;
  public LinkedList<String> GTw;
  public int GTx;
  public boolean GTy;
  public bvj GTz;
  
  public bdy()
  {
    AppMethodBeat.i(215556);
    this.GTu = new LinkedList();
    this.GTw = new LinkedList();
    AppMethodBeat.o(215556);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215557);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(215557);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GTu);
      if (this.GTs != null) {
        paramVarArgs.c(3, this.GTs);
      }
      paramVarArgs.aS(4, this.GTv);
      paramVarArgs.e(5, 1, this.GTw);
      paramVarArgs.aS(6, this.GTx);
      paramVarArgs.bC(7, this.GTy);
      if (this.GTz != null)
      {
        paramVarArgs.lJ(8, this.GTz.computeSize());
        this.GTz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(215557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label898;
      }
    }
    label898:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GTu);
      paramInt = i;
      if (this.GTs != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.GTs);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GTv) + f.a.a.a.c(5, 1, this.GTw) + f.a.a.b.b.a.bz(6, this.GTx) + f.a.a.b.b.a.amF(7);
      paramInt = i;
      if (this.GTz != null) {
        paramInt = i + f.a.a.a.lI(8, this.GTz.computeSize());
      }
      AppMethodBeat.o(215557);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GTu.clear();
        this.GTw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(215557);
          throw paramVarArgs;
        }
        AppMethodBeat.o(215557);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdy localbdy = (bdy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215557);
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
            localbdy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215557);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdy.GTu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215557);
          return 0;
        case 3: 
          localbdy.GTs = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(215557);
          return 0;
        case 4: 
          localbdy.GTv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(215557);
          return 0;
        case 5: 
          localbdy.GTw.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(215557);
          return 0;
        case 6: 
          localbdy.GTx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(215557);
          return 0;
        case 7: 
          localbdy.GTy = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(215557);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbdy.GTz = ((bvj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215557);
        return 0;
      }
      AppMethodBeat.o(215557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdy
 * JD-Core Version:    0.7.0.1
 */