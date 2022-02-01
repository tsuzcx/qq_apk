package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csd
  extends dpc
{
  public String LIh;
  public String LIi;
  public String Mxl;
  public String Mxm;
  public String Mxn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256717);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LIh != null) {
        paramVarArgs.e(2, this.LIh);
      }
      if (this.Mxl != null) {
        paramVarArgs.e(3, this.Mxl);
      }
      if (this.Mxm != null) {
        paramVarArgs.e(4, this.Mxm);
      }
      if (this.LIi != null) {
        paramVarArgs.e(5, this.LIi);
      }
      if (this.Mxn != null) {
        paramVarArgs.e(6, this.Mxn);
      }
      AppMethodBeat.o(256717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LIh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LIh);
      }
      i = paramInt;
      if (this.Mxl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mxl);
      }
      paramInt = i;
      if (this.Mxm != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mxm);
      }
      i = paramInt;
      if (this.LIi != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LIi);
      }
      paramInt = i;
      if (this.Mxn != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mxn);
      }
      AppMethodBeat.o(256717);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256717);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        csd localcsd = (csd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256717);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcsd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(256717);
          return 0;
        case 2: 
          localcsd.LIh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256717);
          return 0;
        case 3: 
          localcsd.Mxl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256717);
          return 0;
        case 4: 
          localcsd.Mxm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256717);
          return 0;
        case 5: 
          localcsd.LIi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(256717);
          return 0;
        }
        localcsd.Mxn = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(256717);
        return 0;
      }
      AppMethodBeat.o(256717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csd
 * JD-Core Version:    0.7.0.1
 */