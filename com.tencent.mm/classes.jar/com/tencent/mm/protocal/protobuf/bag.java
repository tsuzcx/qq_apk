package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bag
  extends com.tencent.mm.bx.a
{
  public int FKN;
  public cvb Gxp;
  public bvm Gxq;
  public int Gxr;
  public boolean Gxs;
  public boolean Gxt;
  public int Gxu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175244);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gxp != null)
      {
        paramVarArgs.lC(1, this.Gxp.computeSize());
        this.Gxp.writeFields(paramVarArgs);
      }
      if (this.Gxq != null)
      {
        paramVarArgs.lC(2, this.Gxq.computeSize());
        this.Gxq.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Gxr);
      paramVarArgs.aS(4, this.FKN);
      paramVarArgs.bt(5, this.Gxs);
      paramVarArgs.bt(6, this.Gxt);
      paramVarArgs.aS(7, this.Gxu);
      AppMethodBeat.o(175244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gxp == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.lB(1, this.Gxp.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gxq != null) {
        i = paramInt + f.a.a.a.lB(2, this.Gxq.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Gxr);
      int j = f.a.a.b.b.a.bz(4, this.FKN);
      int k = f.a.a.b.b.a.alV(5);
      int m = f.a.a.b.b.a.alV(6);
      int n = f.a.a.b.b.a.bz(7, this.Gxu);
      AppMethodBeat.o(175244);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(175244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bag localbag = (bag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(175244);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbag.Gxp = ((cvb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbag.Gxq = ((bvm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(175244);
          return 0;
        case 3: 
          localbag.Gxr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(175244);
          return 0;
        case 4: 
          localbag.FKN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(175244);
          return 0;
        case 5: 
          localbag.Gxs = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(175244);
          return 0;
        case 6: 
          localbag.Gxt = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(175244);
          return 0;
        }
        localbag.Gxu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(175244);
        return 0;
      }
      AppMethodBeat.o(175244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bag
 * JD-Core Version:    0.7.0.1
 */