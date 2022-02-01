package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class drh
  extends dop
{
  public int Lqj;
  public String MTQ;
  public String MTR;
  public b MTS;
  public int Mzq;
  public LinkedList<String> Mzr;
  public String dNI;
  public String state;
  
  public drh()
  {
    AppMethodBeat.i(82470);
    this.Mzr = new LinkedList();
    AppMethodBeat.o(82470);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82471);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.Mzq);
      paramVarArgs.e(4, 1, this.Mzr);
      if (this.dNI != null) {
        paramVarArgs.e(5, this.dNI);
      }
      if (this.state != null) {
        paramVarArgs.e(6, this.state);
      }
      if (this.MTQ != null) {
        paramVarArgs.e(7, this.MTQ);
      }
      paramVarArgs.aM(8, this.Lqj);
      if (this.MTR != null) {
        paramVarArgs.e(14, this.MTR);
      }
      if (this.MTS != null) {
        paramVarArgs.c(15, this.MTS);
      }
      AppMethodBeat.o(82471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(3, this.Mzq) + g.a.a.a.c(4, 1, this.Mzr);
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.dNI);
      }
      i = paramInt;
      if (this.state != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.state);
      }
      paramInt = i;
      if (this.MTQ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MTQ);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.Lqj);
      paramInt = i;
      if (this.MTR != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.MTR);
      }
      i = paramInt;
      if (this.MTS != null) {
        i = paramInt + g.a.a.b.b.a.b(15, this.MTS);
      }
      AppMethodBeat.o(82471);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mzr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        drh localdrh = (drh)paramVarArgs[1];
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
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82471);
          return 0;
        case 3: 
          localdrh.Mzq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82471);
          return 0;
        case 4: 
          localdrh.Mzr.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(82471);
          return 0;
        case 5: 
          localdrh.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 6: 
          localdrh.state = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 7: 
          localdrh.MTQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 8: 
          localdrh.Lqj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82471);
          return 0;
        case 14: 
          localdrh.MTR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82471);
          return 0;
        }
        localdrh.MTS = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(82471);
        return 0;
      }
      AppMethodBeat.o(82471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drh
 * JD-Core Version:    0.7.0.1
 */