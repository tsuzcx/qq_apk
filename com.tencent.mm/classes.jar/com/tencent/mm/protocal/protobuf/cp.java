package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cp
  extends cpx
{
  public int DPL;
  public String DPM;
  public String DPN;
  public String hkN;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127430);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hkN != null) {
        paramVarArgs.d(2, this.hkN);
      }
      paramVarArgs.aR(3, this.ndI);
      paramVarArgs.aR(4, this.DPL);
      if (this.DPM != null) {
        paramVarArgs.d(5, this.DPM);
      }
      if (this.DPN != null) {
        paramVarArgs.d(6, this.DPN);
      }
      AppMethodBeat.o(127430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hkN != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hkN);
      }
      i = i + f.a.a.b.b.a.bx(3, this.ndI) + f.a.a.b.b.a.bx(4, this.DPL);
      paramInt = i;
      if (this.DPM != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DPM);
      }
      i = paramInt;
      if (this.DPN != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DPN);
      }
      AppMethodBeat.o(127430);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cp localcp = (cp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127430);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcp.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127430);
          return 0;
        case 2: 
          localcp.hkN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127430);
          return 0;
        case 3: 
          localcp.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127430);
          return 0;
        case 4: 
          localcp.DPL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127430);
          return 0;
        case 5: 
          localcp.DPM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127430);
          return 0;
        }
        localcp.DPN = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127430);
        return 0;
      }
      AppMethodBeat.o(127430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cp
 * JD-Core Version:    0.7.0.1
 */