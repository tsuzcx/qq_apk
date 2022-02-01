package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csi
  extends cpx
{
  public int EuD;
  public String FEI;
  public String FEJ;
  public int FnA;
  public LinkedList<String> FnB;
  public String djj;
  public String state;
  
  public csi()
  {
    AppMethodBeat.i(82470);
    this.FnB = new LinkedList();
    AppMethodBeat.o(82470);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.FnA);
      paramVarArgs.e(4, 1, this.FnB);
      if (this.djj != null) {
        paramVarArgs.d(5, this.djj);
      }
      if (this.state != null) {
        paramVarArgs.d(6, this.state);
      }
      if (this.FEI != null) {
        paramVarArgs.d(7, this.FEI);
      }
      paramVarArgs.aR(8, this.EuD);
      if (this.FEJ != null) {
        paramVarArgs.d(14, this.FEJ);
      }
      AppMethodBeat.o(82471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label726;
      }
    }
    label726:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(3, this.FnA) + f.a.a.a.c(4, 1, this.FnB);
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.djj);
      }
      i = paramInt;
      if (this.state != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.state);
      }
      paramInt = i;
      if (this.FEI != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FEI);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.EuD);
      paramInt = i;
      if (this.FEJ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FEJ);
      }
      AppMethodBeat.o(82471);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FnB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        csi localcsi = (csi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(82471);
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
            localcsi.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82471);
          return 0;
        case 3: 
          localcsi.FnA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82471);
          return 0;
        case 4: 
          localcsi.FnB.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(82471);
          return 0;
        case 5: 
          localcsi.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 6: 
          localcsi.state = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 7: 
          localcsi.FEI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 8: 
          localcsi.EuD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82471);
          return 0;
        }
        localcsi.FEJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(82471);
        return 0;
      }
      AppMethodBeat.o(82471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csi
 * JD-Core Version:    0.7.0.1
 */