package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clv
  extends com.tencent.mm.bw.a
{
  public int MaY;
  public chl MlQ;
  public aah MlR;
  public long Mri;
  public String Mrj;
  public int Scene;
  public String SessionId;
  public String rBI;
  public int xMB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117878);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Scene);
      paramVarArgs.aM(2, this.MaY);
      if (this.MlQ != null)
      {
        paramVarArgs.ni(3, this.MlQ.computeSize());
        this.MlQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.xMB);
      if (this.rBI != null) {
        paramVarArgs.e(5, this.rBI);
      }
      paramVarArgs.bb(6, this.Mri);
      if (this.SessionId != null) {
        paramVarArgs.e(7, this.SessionId);
      }
      if (this.Mrj != null) {
        paramVarArgs.e(8, this.Mrj);
      }
      if (this.MlR != null)
      {
        paramVarArgs.ni(9, this.MlR.computeSize());
        this.MlR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Scene) + 0 + g.a.a.b.b.a.bu(2, this.MaY);
      paramInt = i;
      if (this.MlQ != null) {
        paramInt = i + g.a.a.a.nh(3, this.MlQ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.xMB);
      paramInt = i;
      if (this.rBI != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.rBI);
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.Mri);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.SessionId);
      }
      i = paramInt;
      if (this.Mrj != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Mrj);
      }
      paramInt = i;
      if (this.MlR != null) {
        paramInt = i + g.a.a.a.nh(9, this.MlR.computeSize());
      }
      AppMethodBeat.o(117878);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      clv localclv = (clv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117878);
        return -1;
      case 1: 
        localclv.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117878);
        return 0;
      case 2: 
        localclv.MaY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117878);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localclv.MlQ = ((chl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117878);
        return 0;
      case 4: 
        localclv.xMB = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117878);
        return 0;
      case 5: 
        localclv.rBI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117878);
        return 0;
      case 6: 
        localclv.Mri = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(117878);
        return 0;
      case 7: 
        localclv.SessionId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117878);
        return 0;
      case 8: 
        localclv.Mrj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117878);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aah();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aah)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localclv.MlR = ((aah)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    AppMethodBeat.o(117878);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clv
 * JD-Core Version:    0.7.0.1
 */