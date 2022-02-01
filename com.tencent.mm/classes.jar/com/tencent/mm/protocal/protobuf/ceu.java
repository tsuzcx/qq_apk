package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ceu
  extends dop
{
  public int Lqj;
  public int MjY;
  public int MjZ;
  public fdg Mka;
  public String Mkp;
  public String jfi;
  public b oTm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123618);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jfi != null) {
        paramVarArgs.e(2, this.jfi);
      }
      if (this.oTm != null) {
        paramVarArgs.c(3, this.oTm);
      }
      if (this.Mkp != null) {
        paramVarArgs.e(4, this.Mkp);
      }
      paramVarArgs.aM(5, this.MjY);
      paramVarArgs.aM(6, this.MjZ);
      if (this.Mka != null)
      {
        paramVarArgs.ni(7, this.Mka.computeSize());
        this.Mka.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.Lqj);
      AppMethodBeat.o(123618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jfi);
      }
      i = paramInt;
      if (this.oTm != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.oTm);
      }
      paramInt = i;
      if (this.Mkp != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mkp);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MjY) + g.a.a.b.b.a.bu(6, this.MjZ);
      paramInt = i;
      if (this.Mka != null) {
        paramInt = i + g.a.a.a.nh(7, this.Mka.computeSize());
      }
      i = g.a.a.b.b.a.bu(8, this.Lqj);
      AppMethodBeat.o(123618);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ceu localceu = (ceu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123618);
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
            localceu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        case 2: 
          localceu.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 3: 
          localceu.oTm = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(123618);
          return 0;
        case 4: 
          localceu.Mkp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 5: 
          localceu.MjY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123618);
          return 0;
        case 6: 
          localceu.MjZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123618);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fdg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fdg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localceu.Mka = ((fdg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        }
        localceu.Lqj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123618);
        return 0;
      }
      AppMethodBeat.o(123618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceu
 * JD-Core Version:    0.7.0.1
 */