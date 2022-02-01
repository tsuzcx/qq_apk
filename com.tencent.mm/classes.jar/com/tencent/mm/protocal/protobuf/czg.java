package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class czg
  extends cld
{
  public int Ctq;
  public String Emn;
  public int EnI;
  public long Eql;
  public int Erg;
  public LinkedList<cyt> Erh;
  public int Eri;
  public int Erj;
  
  public czg()
  {
    AppMethodBeat.i(118477);
    this.Erh = new LinkedList();
    AppMethodBeat.o(118477);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118478);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118478);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Emn != null) {
        paramVarArgs.d(2, this.Emn);
      }
      paramVarArgs.aR(3, this.Erg);
      paramVarArgs.e(4, 8, this.Erh);
      paramVarArgs.aR(5, this.Eri);
      paramVarArgs.aR(6, this.Erj);
      paramVarArgs.aR(7, this.EnI);
      paramVarArgs.aG(8, this.Eql);
      paramVarArgs.aR(9, this.Ctq);
      AppMethodBeat.o(118478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Emn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Emn);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.Erg);
      int j = f.a.a.a.c(4, 8, this.Erh);
      int k = f.a.a.b.b.a.bA(5, this.Eri);
      int m = f.a.a.b.b.a.bA(6, this.Erj);
      int n = f.a.a.b.b.a.bA(7, this.EnI);
      int i1 = f.a.a.b.b.a.q(8, this.Eql);
      int i2 = f.a.a.b.b.a.bA(9, this.Ctq);
      AppMethodBeat.o(118478);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Erh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118478);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czg localczg = (czg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118478);
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
            localczg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118478);
          return 0;
        case 2: 
          localczg.Emn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118478);
          return 0;
        case 3: 
          localczg.Erg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118478);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczg.Erh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118478);
          return 0;
        case 5: 
          localczg.Eri = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118478);
          return 0;
        case 6: 
          localczg.Erj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118478);
          return 0;
        case 7: 
          localczg.EnI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118478);
          return 0;
        case 8: 
          localczg.Eql = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(118478);
          return 0;
        }
        localczg.Ctq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118478);
        return 0;
      }
      AppMethodBeat.o(118478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czg
 * JD-Core Version:    0.7.0.1
 */