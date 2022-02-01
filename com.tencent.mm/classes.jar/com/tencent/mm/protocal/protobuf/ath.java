package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ath
  extends dop
{
  public aov LBM;
  public String LEc;
  public long LEd;
  public long LEe;
  public String LEf;
  public int LEg;
  public String pPz;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209442);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.scene);
      if (this.pPz != null) {
        paramVarArgs.e(3, this.pPz);
      }
      if (this.LBM != null)
      {
        paramVarArgs.ni(4, this.LBM.computeSize());
        this.LBM.writeFields(paramVarArgs);
      }
      if (this.LEc != null) {
        paramVarArgs.e(5, this.LEc);
      }
      paramVarArgs.bb(6, this.LEd);
      paramVarArgs.bb(7, this.LEe);
      if (this.LEf != null) {
        paramVarArgs.e(8, this.LEf);
      }
      paramVarArgs.aM(9, this.LEg);
      AppMethodBeat.o(209442);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.scene);
      paramInt = i;
      if (this.pPz != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pPz);
      }
      i = paramInt;
      if (this.LBM != null) {
        i = paramInt + g.a.a.a.nh(4, this.LBM.computeSize());
      }
      paramInt = i;
      if (this.LEc != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LEc);
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.LEd) + g.a.a.b.b.a.r(7, this.LEe);
      paramInt = i;
      if (this.LEf != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LEf);
      }
      i = g.a.a.b.b.a.bu(9, this.LEg);
      AppMethodBeat.o(209442);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209442);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ath localath = (ath)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209442);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localath.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209442);
          return 0;
        case 2: 
          localath.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209442);
          return 0;
        case 3: 
          localath.pPz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209442);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localath.LBM = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209442);
          return 0;
        case 5: 
          localath.LEc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209442);
          return 0;
        case 6: 
          localath.LEd = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209442);
          return 0;
        case 7: 
          localath.LEe = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209442);
          return 0;
        case 8: 
          localath.LEf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209442);
          return 0;
        }
        localath.LEg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209442);
        return 0;
      }
      AppMethodBeat.o(209442);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ath
 * JD-Core Version:    0.7.0.1
 */