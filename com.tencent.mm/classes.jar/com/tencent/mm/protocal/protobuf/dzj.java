package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzj
  extends cvw
{
  public SKBuiltinBuffer_t FTj;
  public int Gxq;
  public long Gxr;
  public int HzI;
  public int Ieo;
  public int Iep;
  public int Ieq;
  public int Ier;
  public int Ies;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115876);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FTj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115876);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aZ(3, this.Gxr);
      paramVarArgs.aS(4, this.HzI);
      paramVarArgs.aS(5, this.Ieo);
      paramVarArgs.aS(6, this.Iep);
      paramVarArgs.aS(7, this.Ieq);
      paramVarArgs.aS(8, this.Ier);
      paramVarArgs.aS(9, this.Ies);
      if (this.FTj != null)
      {
        paramVarArgs.lJ(10, this.FTj.computeSize());
        this.FTj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115876);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gxq) + f.a.a.b.b.a.p(3, this.Gxr) + f.a.a.b.b.a.bz(4, this.HzI) + f.a.a.b.b.a.bz(5, this.Ieo) + f.a.a.b.b.a.bz(6, this.Iep) + f.a.a.b.b.a.bz(7, this.Ieq) + f.a.a.b.b.a.bz(8, this.Ier) + f.a.a.b.b.a.bz(9, this.Ies);
      paramInt = i;
      if (this.FTj != null) {
        paramInt = i + f.a.a.a.lI(10, this.FTj.computeSize());
      }
      AppMethodBeat.o(115876);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FTj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(115876);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115876);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzj localdzj = (dzj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115876);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115876);
          return 0;
        case 2: 
          localdzj.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115876);
          return 0;
        case 3: 
          localdzj.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115876);
          return 0;
        case 4: 
          localdzj.HzI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115876);
          return 0;
        case 5: 
          localdzj.Ieo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115876);
          return 0;
        case 6: 
          localdzj.Iep = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115876);
          return 0;
        case 7: 
          localdzj.Ieq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115876);
          return 0;
        case 8: 
          localdzj.Ier = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115876);
          return 0;
        case 9: 
          localdzj.Ies = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115876);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdzj.FTj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115876);
        return 0;
      }
      AppMethodBeat.o(115876);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzj
 * JD-Core Version:    0.7.0.1
 */