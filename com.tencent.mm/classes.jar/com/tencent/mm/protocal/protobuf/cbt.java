package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbt
  extends ckq
{
  public int CYU;
  public int DXY;
  public int DXZ;
  public ia DYa;
  public int DYb;
  public String DYc;
  public String zFY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91624);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DXY);
      paramVarArgs.aR(3, this.DXZ);
      if (this.DYa != null)
      {
        paramVarArgs.kX(4, this.DYa.computeSize());
        this.DYa.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.CYU);
      paramVarArgs.aR(6, this.DYb);
      if (this.DYc != null) {
        paramVarArgs.d(7, this.DYc);
      }
      if (this.zFY != null) {
        paramVarArgs.d(100, this.zFY);
      }
      AppMethodBeat.o(91624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DXY) + f.a.a.b.b.a.bA(3, this.DXZ);
      paramInt = i;
      if (this.DYa != null) {
        paramInt = i + f.a.a.a.kW(4, this.DYa.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CYU) + f.a.a.b.b.a.bA(6, this.DYb);
      paramInt = i;
      if (this.DYc != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DYc);
      }
      i = paramInt;
      if (this.zFY != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.zFY);
      }
      AppMethodBeat.o(91624);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbt localcbt = (cbt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91624);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbt.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91624);
          return 0;
        case 2: 
          localcbt.DXY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91624);
          return 0;
        case 3: 
          localcbt.DXZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91624);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbt.DYa = ((ia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91624);
          return 0;
        case 5: 
          localcbt.CYU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91624);
          return 0;
        case 6: 
          localcbt.DYb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91624);
          return 0;
        case 7: 
          localcbt.DYc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91624);
          return 0;
        }
        localcbt.zFY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91624);
        return 0;
      }
      AppMethodBeat.o(91624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbt
 * JD-Core Version:    0.7.0.1
 */