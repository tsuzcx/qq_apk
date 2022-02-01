package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class pi
  extends com.tencent.mm.bx.a
{
  public String YIf;
  public String YSM;
  public int YSN;
  public boolean YSO;
  public geq YSP;
  public String nUM;
  public String title;
  public int wrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258383);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YIf != null) {
        paramVarArgs.g(1, this.YIf);
      }
      if (this.YSM != null) {
        paramVarArgs.g(2, this.YSM);
      }
      paramVarArgs.bS(3, this.wrl);
      if (this.title != null) {
        paramVarArgs.g(4, this.title);
      }
      paramVarArgs.bS(5, this.YSN);
      if (this.nUM != null) {
        paramVarArgs.g(6, this.nUM);
      }
      paramVarArgs.di(7, this.YSO);
      if (this.YSP != null)
      {
        paramVarArgs.qD(8, this.YSP.computeSize());
        this.YSP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258383);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YIf == null) {
        break label660;
      }
    }
    label660:
    for (paramInt = i.a.a.b.b.a.h(1, this.YIf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YSM != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YSM);
      }
      i += i.a.a.b.b.a.cJ(3, this.wrl);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.title);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YSN);
      paramInt = i;
      if (this.nUM != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.nUM);
      }
      i = paramInt + (i.a.a.b.b.a.ko(7) + 1);
      paramInt = i;
      if (this.YSP != null) {
        paramInt = i + i.a.a.a.qC(8, this.YSP.computeSize());
      }
      AppMethodBeat.o(258383);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258383);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        pi localpi = (pi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258383);
          return -1;
        case 1: 
          localpi.YIf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258383);
          return 0;
        case 2: 
          localpi.YSM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258383);
          return 0;
        case 3: 
          localpi.wrl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258383);
          return 0;
        case 4: 
          localpi.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258383);
          return 0;
        case 5: 
          localpi.YSN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258383);
          return 0;
        case 6: 
          localpi.nUM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258383);
          return 0;
        case 7: 
          localpi.YSO = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(258383);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          geq localgeq = new geq();
          if ((localObject != null) && (localObject.length > 0)) {
            localgeq.parseFrom((byte[])localObject);
          }
          localpi.YSP = localgeq;
          paramInt += 1;
        }
        AppMethodBeat.o(258383);
        return 0;
      }
      AppMethodBeat.o(258383);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pi
 * JD-Core Version:    0.7.0.1
 */