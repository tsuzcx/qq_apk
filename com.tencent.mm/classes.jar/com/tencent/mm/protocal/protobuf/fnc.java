package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class fnc
  extends com.tencent.mm.bx.a
{
  public String YIf;
  public String YSM;
  public int YSN;
  public boolean YSO;
  public geq YSP;
  public long abNj;
  public String nQG;
  public String title;
  public int weight;
  public int wrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124569);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YIf != null) {
        paramVarArgs.g(1, this.YIf);
      }
      if (this.nQG != null) {
        paramVarArgs.g(2, this.nQG);
      }
      paramVarArgs.bS(3, this.weight);
      if (this.YSM != null) {
        paramVarArgs.g(4, this.YSM);
      }
      paramVarArgs.bS(5, this.wrl);
      if (this.title != null) {
        paramVarArgs.g(6, this.title);
      }
      paramVarArgs.bS(7, this.YSN);
      paramVarArgs.di(8, this.YSO);
      if (this.YSP != null)
      {
        paramVarArgs.qD(9, this.YSP.computeSize());
        this.YSP.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(10, this.abNj);
      AppMethodBeat.o(124569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YIf == null) {
        break label752;
      }
    }
    label752:
    for (paramInt = i.a.a.b.b.a.h(1, this.YIf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nQG != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.nQG);
      }
      i += i.a.a.b.b.a.cJ(3, this.weight);
      paramInt = i;
      if (this.YSM != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YSM);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.wrl);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.title);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.YSN) + (i.a.a.b.b.a.ko(8) + 1);
      paramInt = i;
      if (this.YSP != null) {
        paramInt = i + i.a.a.a.qC(9, this.YSP.computeSize());
      }
      i = i.a.a.b.b.a.q(10, this.abNj);
      AppMethodBeat.o(124569);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124569);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fnc localfnc = (fnc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124569);
          return -1;
        case 1: 
          localfnc.YIf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124569);
          return 0;
        case 2: 
          localfnc.nQG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124569);
          return 0;
        case 3: 
          localfnc.weight = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124569);
          return 0;
        case 4: 
          localfnc.YSM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124569);
          return 0;
        case 5: 
          localfnc.wrl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124569);
          return 0;
        case 6: 
          localfnc.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124569);
          return 0;
        case 7: 
          localfnc.YSN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124569);
          return 0;
        case 8: 
          localfnc.YSO = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(124569);
          return 0;
        case 9: 
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
            localfnc.YSP = localgeq;
            paramInt += 1;
          }
          AppMethodBeat.o(124569);
          return 0;
        }
        localfnc.abNj = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(124569);
        return 0;
      }
      AppMethodBeat.o(124569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnc
 * JD-Core Version:    0.7.0.1
 */