package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wp
  extends dpc
{
  public String KHN;
  public String LhB;
  public String LhN;
  public String Lhy;
  public String Lhz;
  public int dDN;
  public String dNQ;
  public String qwn;
  public int yRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72438);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72438);
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
      if (this.dNQ != null) {
        paramVarArgs.e(4, this.dNQ);
      }
      if (this.LhB != null) {
        paramVarArgs.e(5, this.LhB);
      }
      if (this.KHN != null) {
        paramVarArgs.e(6, this.KHN);
      }
      paramVarArgs.aM(7, this.yRL);
      if (this.LhN != null) {
        paramVarArgs.e(8, this.LhN);
      }
      if (this.Lhz != null) {
        paramVarArgs.e(9, this.Lhz);
      }
      if (this.Lhy != null) {
        paramVarArgs.e(10, this.Lhy);
      }
      AppMethodBeat.o(72438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.dNQ != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.dNQ);
      }
      paramInt = i;
      if (this.LhB != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LhB);
      }
      i = paramInt;
      if (this.KHN != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KHN);
      }
      i += g.a.a.b.b.a.bu(7, this.yRL);
      paramInt = i;
      if (this.LhN != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LhN);
      }
      i = paramInt;
      if (this.Lhz != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Lhz);
      }
      paramInt = i;
      if (this.Lhy != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Lhy);
      }
      AppMethodBeat.o(72438);
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
          AppMethodBeat.o(72438);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        wp localwp = (wp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72438);
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
            localwp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72438);
          return 0;
        case 2: 
          localwp.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72438);
          return 0;
        case 3: 
          localwp.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 4: 
          localwp.dNQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 5: 
          localwp.LhB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 6: 
          localwp.KHN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 7: 
          localwp.yRL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72438);
          return 0;
        case 8: 
          localwp.LhN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72438);
          return 0;
        case 9: 
          localwp.Lhz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72438);
          return 0;
        }
        localwp.Lhy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72438);
        return 0;
      }
      AppMethodBeat.o(72438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wp
 * JD-Core Version:    0.7.0.1
 */