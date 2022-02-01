package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class awz
  extends cld
{
  public int Cxm;
  public int Dwe;
  public LinkedList<bur> Dwf;
  public String Dwg;
  public int Dwh;
  
  public awz()
  {
    AppMethodBeat.i(32254);
    this.Dwf = new LinkedList();
    AppMethodBeat.o(32254);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32255);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32255);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Dwe);
      paramVarArgs.e(3, 8, this.Dwf);
      if (this.Dwg != null) {
        paramVarArgs.d(4, this.Dwg);
      }
      paramVarArgs.aR(5, this.Cxm);
      paramVarArgs.aR(6, this.Dwh);
      AppMethodBeat.o(32255);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Dwe) + f.a.a.a.c(3, 8, this.Dwf);
      paramInt = i;
      if (this.Dwg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dwg);
      }
      i = f.a.a.b.b.a.bA(5, this.Cxm);
      int j = f.a.a.b.b.a.bA(6, this.Dwh);
      AppMethodBeat.o(32255);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dwf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32255);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32255);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awz localawz = (awz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32255);
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
            localawz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32255);
          return 0;
        case 2: 
          localawz.Dwe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32255);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bur();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bur)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawz.Dwf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32255);
          return 0;
        case 4: 
          localawz.Dwg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32255);
          return 0;
        case 5: 
          localawz.Cxm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32255);
          return 0;
        }
        localawz.Dwh = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32255);
        return 0;
      }
      AppMethodBeat.o(32255);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awz
 * JD-Core Version:    0.7.0.1
 */