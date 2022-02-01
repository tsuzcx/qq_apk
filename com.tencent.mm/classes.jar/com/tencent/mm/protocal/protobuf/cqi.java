package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqi
  extends dyl
{
  public int RLe;
  public eae RMM;
  public eae RMN;
  public float ScO;
  public float ScP;
  public int Sxt;
  public String Sxu;
  public String Sxv;
  public int Sxw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89926);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RLe);
      paramVarArgs.i(3, this.ScO);
      paramVarArgs.i(4, this.ScP);
      paramVarArgs.aY(5, this.Sxt);
      if (this.Sxu != null) {
        paramVarArgs.f(6, this.Sxu);
      }
      if (this.Sxv != null) {
        paramVarArgs.f(7, this.Sxv);
      }
      paramVarArgs.aY(8, this.Sxw);
      if (this.RMM != null)
      {
        paramVarArgs.oE(9, this.RMM.computeSize());
        this.RMM.writeFields(paramVarArgs);
      }
      if (this.RMN != null)
      {
        paramVarArgs.oE(10, this.RMN.computeSize());
        this.RMN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(89926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label898;
      }
    }
    label898:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RLe) + (g.a.a.b.b.a.gL(3) + 4) + (g.a.a.b.b.a.gL(4) + 4) + g.a.a.b.b.a.bM(5, this.Sxt);
      paramInt = i;
      if (this.Sxu != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Sxu);
      }
      i = paramInt;
      if (this.Sxv != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Sxv);
      }
      i += g.a.a.b.b.a.bM(8, this.Sxw);
      paramInt = i;
      if (this.RMM != null) {
        paramInt = i + g.a.a.a.oD(9, this.RMM.computeSize());
      }
      i = paramInt;
      if (this.RMN != null) {
        i = paramInt + g.a.a.a.oD(10, this.RMN.computeSize());
      }
      AppMethodBeat.o(89926);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(89926);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cqi localcqi = (cqi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89926);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localcqi.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(89926);
          return 0;
        case 2: 
          localcqi.RLe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89926);
          return 0;
        case 3: 
          localcqi.ScO = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(89926);
          return 0;
        case 4: 
          localcqi.ScP = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(89926);
          return 0;
        case 5: 
          localcqi.Sxt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89926);
          return 0;
        case 6: 
          localcqi.Sxu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89926);
          return 0;
        case 7: 
          localcqi.Sxv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(89926);
          return 0;
        case 8: 
          localcqi.Sxw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(89926);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localcqi.RMM = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(89926);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localcqi.RMN = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(89926);
        return 0;
      }
      AppMethodBeat.o(89926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqi
 * JD-Core Version:    0.7.0.1
 */