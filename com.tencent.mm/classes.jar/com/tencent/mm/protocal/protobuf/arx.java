package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class arx
  extends cld
{
  public String Dsd;
  public int Dse;
  public cls Dsf;
  public long evU;
  public int foN;
  public String foO;
  public int foP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101808);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101808);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Dsd != null) {
        paramVarArgs.d(2, this.Dsd);
      }
      paramVarArgs.aR(3, this.foN);
      if (this.foO != null) {
        paramVarArgs.d(4, this.foO);
      }
      paramVarArgs.aR(5, this.foP);
      paramVarArgs.aR(6, this.Dse);
      paramVarArgs.aG(7, this.evU);
      if (this.Dsf != null)
      {
        paramVarArgs.kX(8, this.Dsf.computeSize());
        this.Dsf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label810;
      }
    }
    label810:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dsd != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Dsd);
      }
      i += f.a.a.b.b.a.bA(3, this.foN);
      paramInt = i;
      if (this.foO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.foO);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.foP) + f.a.a.b.b.a.bA(6, this.Dse) + f.a.a.b.b.a.q(7, this.evU);
      paramInt = i;
      if (this.Dsf != null) {
        paramInt = i + f.a.a.a.kW(8, this.Dsf.computeSize());
      }
      AppMethodBeat.o(101808);
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
          AppMethodBeat.o(101808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arx localarx = (arx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101808);
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
            localarx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        case 2: 
          localarx.Dsd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 3: 
          localarx.foN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101808);
          return 0;
        case 4: 
          localarx.foO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 5: 
          localarx.foP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101808);
          return 0;
        case 6: 
          localarx.Dse = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101808);
          return 0;
        case 7: 
          localarx.evU = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(101808);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cls();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cls)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localarx.Dsf = ((cls)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      AppMethodBeat.o(101808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arx
 * JD-Core Version:    0.7.0.1
 */