package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzm
  extends cwj
{
  public int CreateTime;
  public int Gxq;
  public long Gxr;
  public int Iel;
  public String Ieu;
  public LinkedList<eao> Iev;
  public int fNf;
  
  public dzm()
  {
    AppMethodBeat.i(115879);
    this.Iev = new LinkedList();
    AppMethodBeat.o(115879);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115880);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115880);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aZ(3, this.Gxr);
      paramVarArgs.aS(4, this.CreateTime);
      paramVarArgs.aS(6, this.fNf);
      paramVarArgs.e(7, 8, this.Iev);
      if (this.Ieu != null) {
        paramVarArgs.d(8, this.Ieu);
      }
      paramVarArgs.aS(9, this.Iel);
      AppMethodBeat.o(115880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gxq) + f.a.a.b.b.a.p(3, this.Gxr) + f.a.a.b.b.a.bz(4, this.CreateTime) + f.a.a.b.b.a.bz(6, this.fNf) + f.a.a.a.c(7, 8, this.Iev);
      paramInt = i;
      if (this.Ieu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Ieu);
      }
      i = f.a.a.b.b.a.bz(9, this.Iel);
      AppMethodBeat.o(115880);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Iev.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115880);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115880);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzm localdzm = (dzm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(115880);
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
            localdzm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 2: 
          localdzm.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115880);
          return 0;
        case 3: 
          localdzm.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115880);
          return 0;
        case 4: 
          localdzm.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115880);
          return 0;
        case 6: 
          localdzm.fNf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115880);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eao();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eao)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzm.Iev.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 8: 
          localdzm.Ieu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(115880);
          return 0;
        }
        localdzm.Iel = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115880);
        return 0;
      }
      AppMethodBeat.o(115880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzm
 * JD-Core Version:    0.7.0.1
 */