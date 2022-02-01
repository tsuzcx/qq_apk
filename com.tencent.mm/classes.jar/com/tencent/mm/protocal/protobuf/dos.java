package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dos
  extends dop
{
  public int KBv;
  public long MBH;
  public int MRV;
  public int MRW;
  public String dNI;
  public int yPJ;
  public String yPK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91671);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      paramVarArgs.aM(3, this.yPJ);
      paramVarArgs.aM(4, this.KBv);
      paramVarArgs.bb(5, this.MBH);
      paramVarArgs.aM(6, this.MRV);
      if (this.yPK != null) {
        paramVarArgs.e(7, this.yPK);
      }
      paramVarArgs.aM(8, this.MRW);
      AppMethodBeat.o(91671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dNI);
      }
      i = i + g.a.a.b.b.a.bu(3, this.yPJ) + g.a.a.b.b.a.bu(4, this.KBv) + g.a.a.b.b.a.r(5, this.MBH) + g.a.a.b.b.a.bu(6, this.MRV);
      paramInt = i;
      if (this.yPK != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.yPK);
      }
      i = g.a.a.b.b.a.bu(8, this.MRW);
      AppMethodBeat.o(91671);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dos localdos = (dos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91671);
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
            localdos.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91671);
          return 0;
        case 2: 
          localdos.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91671);
          return 0;
        case 3: 
          localdos.yPJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91671);
          return 0;
        case 4: 
          localdos.KBv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91671);
          return 0;
        case 5: 
          localdos.MBH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91671);
          return 0;
        case 6: 
          localdos.MRV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91671);
          return 0;
        case 7: 
          localdos.yPK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91671);
          return 0;
        }
        localdos.MRW = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91671);
        return 0;
      }
      AppMethodBeat.o(91671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dos
 * JD-Core Version:    0.7.0.1
 */