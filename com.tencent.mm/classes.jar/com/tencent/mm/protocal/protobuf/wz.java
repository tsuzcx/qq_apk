package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wz
  extends com.tencent.mm.bx.a
{
  public String ZeK;
  public String ZeL;
  public LinkedList<fxr> ZeM;
  
  public wz()
  {
    AppMethodBeat.i(258750);
    this.ZeM = new LinkedList();
    AppMethodBeat.o(258750);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258753);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZeK != null) {
        paramVarArgs.g(1, this.ZeK);
      }
      if (this.ZeL != null) {
        paramVarArgs.g(2, this.ZeL);
      }
      paramVarArgs.e(3, 8, this.ZeM);
      AppMethodBeat.o(258753);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZeK == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZeK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZeL != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZeL);
      }
      paramInt = i.a.a.a.c(3, 8, this.ZeM);
      AppMethodBeat.o(258753);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZeM.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258753);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        wz localwz = (wz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258753);
          return -1;
        case 1: 
          localwz.ZeK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258753);
          return 0;
        case 2: 
          localwz.ZeL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258753);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fxr localfxr = new fxr();
          if ((localObject != null) && (localObject.length > 0)) {
            localfxr.parseFrom((byte[])localObject);
          }
          localwz.ZeM.add(localfxr);
          paramInt += 1;
        }
        AppMethodBeat.o(258753);
        return 0;
      }
      AppMethodBeat.o(258753);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wz
 * JD-Core Version:    0.7.0.1
 */