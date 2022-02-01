package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class all
  extends dop
{
  public String Lun;
  public String Luo;
  public long Lup;
  public double Luq;
  public double Lur;
  public String fuJ;
  public String fuK;
  public String rCq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91452);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.rCq != null) {
        paramVarArgs.e(2, this.rCq);
      }
      if (this.fuK != null) {
        paramVarArgs.e(3, this.fuK);
      }
      if (this.fuJ != null) {
        paramVarArgs.e(4, this.fuJ);
      }
      if (this.Lun != null) {
        paramVarArgs.e(5, this.Lun);
      }
      if (this.Luo != null) {
        paramVarArgs.e(6, this.Luo);
      }
      paramVarArgs.bb(7, this.Lup);
      paramVarArgs.e(8, this.Luq);
      paramVarArgs.e(9, this.Lur);
      AppMethodBeat.o(91452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label760;
      }
    }
    label760:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rCq != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.rCq);
      }
      i = paramInt;
      if (this.fuK != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.fuK);
      }
      paramInt = i;
      if (this.fuJ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.fuJ);
      }
      i = paramInt;
      if (this.Lun != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Lun);
      }
      paramInt = i;
      if (this.Luo != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Luo);
      }
      i = g.a.a.b.b.a.r(7, this.Lup);
      int j = g.a.a.b.b.a.fS(8);
      int k = g.a.a.b.b.a.fS(9);
      AppMethodBeat.o(91452);
      return paramInt + i + (j + 8) + (k + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        all localall = (all)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91452);
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
            localall.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91452);
          return 0;
        case 2: 
          localall.rCq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 3: 
          localall.fuK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 4: 
          localall.fuJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 5: 
          localall.Lun = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 6: 
          localall.Luo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91452);
          return 0;
        case 7: 
          localall.Lup = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91452);
          return 0;
        case 8: 
          localall.Luq = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(91452);
          return 0;
        }
        localall.Lur = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(91452);
        return 0;
      }
      AppMethodBeat.o(91452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.all
 * JD-Core Version:    0.7.0.1
 */