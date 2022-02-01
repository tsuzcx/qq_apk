package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arb
  extends com.tencent.mm.bx.a
{
  public dtx Zyq;
  public int Zyr;
  public int Zys;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258973);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zyq != null)
      {
        paramVarArgs.qD(1, this.Zyq.computeSize());
        this.Zyq.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zyr);
      paramVarArgs.bS(3, this.Zys);
      AppMethodBeat.o(258973);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zyq == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = i.a.a.a.qC(1, this.Zyq.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Zyr);
      int j = i.a.a.b.b.a.cJ(3, this.Zys);
      AppMethodBeat.o(258973);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258973);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        arb localarb = (arb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258973);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dtx localdtx = new dtx();
            if ((localObject != null) && (localObject.length > 0)) {
              localdtx.parseFrom((byte[])localObject);
            }
            localarb.Zyq = localdtx;
            paramInt += 1;
          }
          AppMethodBeat.o(258973);
          return 0;
        case 2: 
          localarb.Zyr = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258973);
          return 0;
        }
        localarb.Zys = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258973);
        return 0;
      }
      AppMethodBeat.o(258973);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arb
 * JD-Core Version:    0.7.0.1
 */