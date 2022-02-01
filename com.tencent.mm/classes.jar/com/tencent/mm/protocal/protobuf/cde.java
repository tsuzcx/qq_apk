package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cde
  extends cld
{
  public int DZs;
  public int DZu;
  public int DZv;
  public int DdZ;
  public long Dea;
  public int oXv;
  public String oXw;
  public int sBd;
  public String sBe;
  public int sBs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32391);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32391);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.DdZ);
      paramVarArgs.aG(4, this.Dea);
      paramVarArgs.aR(5, this.DZu);
      paramVarArgs.aR(6, this.DZs);
      paramVarArgs.aR(7, this.sBs);
      paramVarArgs.aR(8, this.DZv);
      paramVarArgs.aR(9, this.oXv);
      if (this.oXw != null) {
        paramVarArgs.d(10, this.oXw);
      }
      paramVarArgs.aR(11, this.sBd);
      if (this.sBe != null) {
        paramVarArgs.d(12, this.sBe);
      }
      AppMethodBeat.o(32391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label855;
      }
    }
    label855:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(3, this.DdZ) + f.a.a.b.b.a.q(4, this.Dea) + f.a.a.b.b.a.bA(5, this.DZu) + f.a.a.b.b.a.bA(6, this.DZs) + f.a.a.b.b.a.bA(7, this.sBs) + f.a.a.b.b.a.bA(8, this.DZv) + f.a.a.b.b.a.bA(9, this.oXv);
      paramInt = i;
      if (this.oXw != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.oXw);
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.sBd);
      paramInt = i;
      if (this.sBe != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.sBe);
      }
      AppMethodBeat.o(32391);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32391);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32391);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cde localcde = (cde)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(32391);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcde.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32391);
          return 0;
        case 3: 
          localcde.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32391);
          return 0;
        case 4: 
          localcde.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32391);
          return 0;
        case 5: 
          localcde.DZu = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32391);
          return 0;
        case 6: 
          localcde.DZs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32391);
          return 0;
        case 7: 
          localcde.sBs = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32391);
          return 0;
        case 8: 
          localcde.DZv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32391);
          return 0;
        case 9: 
          localcde.oXv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32391);
          return 0;
        case 10: 
          localcde.oXw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32391);
          return 0;
        case 11: 
          localcde.sBd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32391);
          return 0;
        }
        localcde.sBe = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32391);
        return 0;
      }
      AppMethodBeat.o(32391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cde
 * JD-Core Version:    0.7.0.1
 */