package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cao
  extends com.tencent.mm.bx.a
{
  public dti DWY;
  public dtl DWZ;
  public dte DXa;
  public String sag;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110851);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sag == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(110851);
        throw paramVarArgs;
      }
      if (this.sag != null) {
        paramVarArgs.d(1, this.sag);
      }
      if (this.DWY != null)
      {
        paramVarArgs.kX(2, this.DWY.computeSize());
        this.DWY.writeFields(paramVarArgs);
      }
      if (this.DWZ != null)
      {
        paramVarArgs.kX(3, this.DWZ.computeSize());
        this.DWZ.writeFields(paramVarArgs);
      }
      if (this.DXa != null)
      {
        paramVarArgs.kX(4, this.DXa.computeSize());
        this.DXa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110851);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sag == null) {
        break label726;
      }
    }
    label726:
    for (int i = f.a.a.b.b.a.e(1, this.sag) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DWY != null) {
        paramInt = i + f.a.a.a.kW(2, this.DWY.computeSize());
      }
      i = paramInt;
      if (this.DWZ != null) {
        i = paramInt + f.a.a.a.kW(3, this.DWZ.computeSize());
      }
      paramInt = i;
      if (this.DXa != null) {
        paramInt = i + f.a.a.a.kW(4, this.DXa.computeSize());
      }
      AppMethodBeat.o(110851);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.sag == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(110851);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cao localcao = (cao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110851);
          return -1;
        case 1: 
          localcao.sag = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(110851);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcao.DWY = ((dti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcao.DWZ = ((dtl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110851);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dte();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dte)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcao.DXa = ((dte)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110851);
        return 0;
      }
      AppMethodBeat.o(110851);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cao
 * JD-Core Version:    0.7.0.1
 */