package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class csd
  extends cld
{
  public LinkedList<csb> Ekc;
  public int Ekd;
  public int Ret;
  public int mAK;
  public String uwt;
  
  public csd()
  {
    AppMethodBeat.i(32442);
    this.Ekc = new LinkedList();
    AppMethodBeat.o(32442);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32443);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32443);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.mAK);
      paramVarArgs.e(3, 8, this.Ekc);
      if (this.uwt != null) {
        paramVarArgs.d(4, this.uwt);
      }
      paramVarArgs.aR(5, this.Ekd);
      paramVarArgs.aR(6, this.Ret);
      AppMethodBeat.o(32443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mAK) + f.a.a.a.c(3, 8, this.Ekc);
      paramInt = i;
      if (this.uwt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uwt);
      }
      i = f.a.a.b.b.a.bA(5, this.Ekd);
      int j = f.a.a.b.b.a.bA(6, this.Ret);
      AppMethodBeat.o(32443);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ekc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32443);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csd localcsd = (csd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32443);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32443);
          return 0;
        case 2: 
          localcsd.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32443);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcsd.Ekc.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32443);
          return 0;
        case 4: 
          localcsd.uwt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32443);
          return 0;
        case 5: 
          localcsd.Ekd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32443);
          return 0;
        }
        localcsd.Ret = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32443);
        return 0;
      }
      AppMethodBeat.o(32443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csd
 * JD-Core Version:    0.7.0.1
 */