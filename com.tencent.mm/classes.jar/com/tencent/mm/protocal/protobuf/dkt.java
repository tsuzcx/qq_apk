package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dkt
  extends cvp
{
  public String FyM;
  public int Grd;
  public String Gre;
  public String GsS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91705);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91705);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FyM != null) {
        paramVarArgs.d(2, this.FyM);
      }
      if (this.GsS != null) {
        paramVarArgs.d(3, this.GsS);
      }
      paramVarArgs.aS(4, this.Grd);
      if (this.Gre != null) {
        paramVarArgs.d(5, this.Gre);
      }
      AppMethodBeat.o(91705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FyM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FyM);
      }
      i = paramInt;
      if (this.GsS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GsS);
      }
      i += f.a.a.b.b.a.bz(4, this.Grd);
      paramInt = i;
      if (this.Gre != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gre);
      }
      AppMethodBeat.o(91705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91705);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkt localdkt = (dkt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91705);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91705);
          return 0;
        case 2: 
          localdkt.FyM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91705);
          return 0;
        case 3: 
          localdkt.GsS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91705);
          return 0;
        case 4: 
          localdkt.Grd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91705);
          return 0;
        }
        localdkt.Gre = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91705);
        return 0;
      }
      AppMethodBeat.o(91705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkt
 * JD-Core Version:    0.7.0.1
 */