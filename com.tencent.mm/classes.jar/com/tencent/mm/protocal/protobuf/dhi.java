package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhi
  extends dop
{
  public String CpP;
  public int HuF;
  public String HuS;
  public String MJh;
  public int MKM;
  public String MLF;
  public int MLG;
  public int yba;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91641);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MLF != null) {
        paramVarArgs.e(2, this.MLF);
      }
      if (this.CpP != null) {
        paramVarArgs.e(3, this.CpP);
      }
      paramVarArgs.aM(4, this.MKM);
      paramVarArgs.aM(5, this.yba);
      if (this.MJh != null) {
        paramVarArgs.e(6, this.MJh);
      }
      paramVarArgs.aM(7, this.HuF);
      paramVarArgs.aM(8, this.MLG);
      if (this.HuS != null) {
        paramVarArgs.e(100, this.HuS);
      }
      AppMethodBeat.o(91641);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label762;
      }
    }
    label762:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MLF != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MLF);
      }
      i = paramInt;
      if (this.CpP != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.CpP);
      }
      i = i + g.a.a.b.b.a.bu(4, this.MKM) + g.a.a.b.b.a.bu(5, this.yba);
      paramInt = i;
      if (this.MJh != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MJh);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.HuF) + g.a.a.b.b.a.bu(8, this.MLG);
      paramInt = i;
      if (this.HuS != null) {
        paramInt = i + g.a.a.b.b.a.f(100, this.HuS);
      }
      AppMethodBeat.o(91641);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91641);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhi localdhi = (dhi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91641);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhi.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91641);
          return 0;
        case 2: 
          localdhi.MLF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 3: 
          localdhi.CpP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 4: 
          localdhi.MKM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91641);
          return 0;
        case 5: 
          localdhi.yba = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91641);
          return 0;
        case 6: 
          localdhi.MJh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 7: 
          localdhi.HuF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91641);
          return 0;
        case 8: 
          localdhi.MLG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91641);
          return 0;
        }
        localdhi.HuS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91641);
        return 0;
      }
      AppMethodBeat.o(91641);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhi
 * JD-Core Version:    0.7.0.1
 */