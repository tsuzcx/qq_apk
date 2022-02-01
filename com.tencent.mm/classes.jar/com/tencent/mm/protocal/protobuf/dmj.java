package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmj
  extends ckq
{
  public int DdZ;
  public long Dea;
  public long EAY;
  public String ECd;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115878);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DdZ);
      paramVarArgs.aG(3, this.Dea);
      if (this.ECd != null) {
        paramVarArgs.d(4, this.ECd);
      }
      paramVarArgs.aR(5, this.mBH);
      paramVarArgs.aG(6, this.EAY);
      AppMethodBeat.o(115878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DdZ) + f.a.a.b.b.a.q(3, this.Dea);
      paramInt = i;
      if (this.ECd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ECd);
      }
      i = f.a.a.b.b.a.bA(5, this.mBH);
      int j = f.a.a.b.b.a.q(6, this.EAY);
      AppMethodBeat.o(115878);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(115878);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmj localdmj = (dmj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115878);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmj.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115878);
          return 0;
        case 2: 
          localdmj.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115878);
          return 0;
        case 3: 
          localdmj.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115878);
          return 0;
        case 4: 
          localdmj.ECd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(115878);
          return 0;
        case 5: 
          localdmj.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115878);
          return 0;
        }
        localdmj.EAY = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(115878);
        return 0;
      }
      AppMethodBeat.o(115878);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmj
 * JD-Core Version:    0.7.0.1
 */