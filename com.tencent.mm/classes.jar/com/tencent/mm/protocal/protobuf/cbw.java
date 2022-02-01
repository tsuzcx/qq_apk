package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbw
  extends com.tencent.mm.bx.a
{
  public dmo FsP;
  public cby GVM;
  public cbx GVN;
  public cbx GVO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FsP != null)
      {
        paramVarArgs.lC(1, this.FsP.computeSize());
        this.FsP.writeFields(paramVarArgs);
      }
      if (this.GVM != null)
      {
        paramVarArgs.lC(2, this.GVM.computeSize());
        this.GVM.writeFields(paramVarArgs);
      }
      if (this.GVN != null)
      {
        paramVarArgs.lC(3, this.GVN.computeSize());
        this.GVN.writeFields(paramVarArgs);
      }
      if (this.GVO != null)
      {
        paramVarArgs.lC(4, this.GVO.computeSize());
        this.GVO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FsP == null) {
        break label774;
      }
    }
    label774:
    for (int i = f.a.a.a.lB(1, this.FsP.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GVM != null) {
        paramInt = i + f.a.a.a.lB(2, this.GVM.computeSize());
      }
      i = paramInt;
      if (this.GVN != null) {
        i = paramInt + f.a.a.a.lB(3, this.GVN.computeSize());
      }
      paramInt = i;
      if (this.GVO != null) {
        paramInt = i + f.a.a.a.lB(4, this.GVO.computeSize());
      }
      AppMethodBeat.o(91550);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbw localcbw = (cbw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91550);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbw.FsP = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cby();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cby)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbw.GVM = ((cby)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbw.GVN = ((cbx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cbx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcbw.GVO = ((cbx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91550);
        return 0;
      }
      AppMethodBeat.o(91550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbw
 * JD-Core Version:    0.7.0.1
 */