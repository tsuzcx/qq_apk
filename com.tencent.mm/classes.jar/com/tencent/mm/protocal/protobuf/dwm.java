package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwm
  extends com.tencent.mm.bx.a
{
  public dwf EKf;
  public String EKx;
  public int EKy;
  public int EKz;
  public LinkedList<Integer> EzL;
  
  public dwm()
  {
    AppMethodBeat.i(153345);
    this.EzL = new LinkedList();
    AppMethodBeat.o(153345);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153346);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EKf != null)
      {
        paramVarArgs.kX(1, this.EKf.computeSize());
        this.EKf.writeFields(paramVarArgs);
      }
      if (this.EKx != null) {
        paramVarArgs.d(2, this.EKx);
      }
      paramVarArgs.e(3, 2, this.EzL);
      paramVarArgs.aR(4, this.EKy);
      paramVarArgs.aR(5, this.EKz);
      AppMethodBeat.o(153346);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EKf == null) {
        break label525;
      }
    }
    label525:
    for (paramInt = f.a.a.a.kW(1, this.EKf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EKx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EKx);
      }
      paramInt = f.a.a.a.c(3, 2, this.EzL);
      int j = f.a.a.b.b.a.bA(4, this.EKy);
      int k = f.a.a.b.b.a.bA(5, this.EKz);
      AppMethodBeat.o(153346);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EzL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153346);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwm localdwm = (dwm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153346);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dwf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwm.EKf = ((dwf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153346);
          return 0;
        case 2: 
          localdwm.EKx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153346);
          return 0;
        case 3: 
          localdwm.EzL.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
          AppMethodBeat.o(153346);
          return 0;
        case 4: 
          localdwm.EKy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153346);
          return 0;
        }
        localdwm.EKz = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153346);
        return 0;
      }
      AppMethodBeat.o(153346);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwm
 * JD-Core Version:    0.7.0.1
 */