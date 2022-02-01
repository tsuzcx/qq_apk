package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class vr
  extends dpc
{
  public String LgG;
  public String LgH;
  public String LgI;
  public String LgJ;
  public int dDN;
  public String dTx;
  public String qwn;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200191);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(200191);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      if (this.title != null) {
        paramVarArgs.e(4, this.title);
      }
      if (this.dTx != null) {
        paramVarArgs.e(5, this.dTx);
      }
      if (this.LgG != null) {
        paramVarArgs.e(6, this.LgG);
      }
      if (this.LgH != null) {
        paramVarArgs.e(7, this.LgH);
      }
      if (this.LgI != null) {
        paramVarArgs.e(8, this.LgI);
      }
      if (this.LgJ != null) {
        paramVarArgs.e(9, this.LgJ);
      }
      AppMethodBeat.o(200191);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.title);
      }
      paramInt = i;
      if (this.dTx != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.dTx);
      }
      i = paramInt;
      if (this.LgG != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LgG);
      }
      paramInt = i;
      if (this.LgH != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LgH);
      }
      i = paramInt;
      if (this.LgI != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.LgI);
      }
      paramInt = i;
      if (this.LgJ != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LgJ);
      }
      AppMethodBeat.o(200191);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(200191);
          throw paramVarArgs;
        }
        AppMethodBeat.o(200191);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        vr localvr = (vr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200191);
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
            localvr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200191);
          return 0;
        case 2: 
          localvr.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(200191);
          return 0;
        case 3: 
          localvr.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200191);
          return 0;
        case 4: 
          localvr.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200191);
          return 0;
        case 5: 
          localvr.dTx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200191);
          return 0;
        case 6: 
          localvr.LgG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200191);
          return 0;
        case 7: 
          localvr.LgH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200191);
          return 0;
        case 8: 
          localvr.LgI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200191);
          return 0;
        }
        localvr.LgJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(200191);
        return 0;
      }
      AppMethodBeat.o(200191);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vr
 * JD-Core Version:    0.7.0.1
 */