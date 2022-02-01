package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class euq
  extends dop
{
  public int Llx;
  public int LsZ;
  public int NbR;
  public int NbS;
  public int NbT;
  public int NbU;
  public int NbV;
  public LinkedList<Integer> NbW;
  public int NbX;
  public int NbY;
  public LinkedList<Integer> NbZ;
  public int Nca;
  public int Ncb;
  
  public euq()
  {
    AppMethodBeat.i(115916);
    this.NbW = new LinkedList();
    this.NbZ = new LinkedList();
    AppMethodBeat.o(115916);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115917);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LsZ);
      paramVarArgs.aM(3, this.NbR);
      paramVarArgs.aM(4, this.Llx);
      paramVarArgs.aM(5, this.NbS);
      paramVarArgs.aM(6, this.NbT);
      paramVarArgs.aM(7, this.NbU);
      paramVarArgs.aM(8, this.NbV);
      paramVarArgs.f(9, 2, this.NbW);
      paramVarArgs.aM(10, this.NbX);
      paramVarArgs.aM(11, this.NbY);
      paramVarArgs.f(12, 2, this.NbZ);
      paramVarArgs.aM(13, this.Nca);
      paramVarArgs.aM(14, this.Ncb);
      AppMethodBeat.o(115917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label984;
      }
    }
    label984:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LsZ);
      int j = g.a.a.b.b.a.bu(3, this.NbR);
      int k = g.a.a.b.b.a.bu(4, this.Llx);
      int m = g.a.a.b.b.a.bu(5, this.NbS);
      int n = g.a.a.b.b.a.bu(6, this.NbT);
      int i1 = g.a.a.b.b.a.bu(7, this.NbU);
      int i2 = g.a.a.b.b.a.bu(8, this.NbV);
      int i3 = g.a.a.a.d(9, 2, this.NbW);
      int i4 = g.a.a.b.b.a.bu(10, this.NbX);
      int i5 = g.a.a.b.b.a.bu(11, this.NbY);
      int i6 = g.a.a.a.d(12, 2, this.NbZ);
      int i7 = g.a.a.b.b.a.bu(13, this.Nca);
      int i8 = g.a.a.b.b.a.bu(14, this.Ncb);
      AppMethodBeat.o(115917);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NbW.clear();
        this.NbZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(115917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        euq localeuq = (euq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115917);
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
            localeuq.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115917);
          return 0;
        case 2: 
          localeuq.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115917);
          return 0;
        case 3: 
          localeuq.NbR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115917);
          return 0;
        case 4: 
          localeuq.Llx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115917);
          return 0;
        case 5: 
          localeuq.NbS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115917);
          return 0;
        case 6: 
          localeuq.NbT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115917);
          return 0;
        case 7: 
          localeuq.NbU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115917);
          return 0;
        case 8: 
          localeuq.NbV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115917);
          return 0;
        case 9: 
          localeuq.NbW = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
          AppMethodBeat.o(115917);
          return 0;
        case 10: 
          localeuq.NbX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115917);
          return 0;
        case 11: 
          localeuq.NbY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115917);
          return 0;
        case 12: 
          localeuq.NbZ = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
          AppMethodBeat.o(115917);
          return 0;
        case 13: 
          localeuq.Nca = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115917);
          return 0;
        }
        localeuq.Ncb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115917);
        return 0;
      }
      AppMethodBeat.o(115917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euq
 * JD-Core Version:    0.7.0.1
 */