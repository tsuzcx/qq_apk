package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class beb
  extends com.tencent.mm.bx.a
{
  public String ZOC;
  public bim ZOD;
  public int ZOE;
  public String ZOF;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258772);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOC != null) {
        paramVarArgs.g(1, this.ZOC);
      }
      if (this.ZOD != null)
      {
        paramVarArgs.qD(2, this.ZOD.computeSize());
        this.ZOD.writeFields(paramVarArgs);
      }
      if (this.content != null) {
        paramVarArgs.g(3, this.content);
      }
      paramVarArgs.bS(4, this.ZOE);
      if (this.ZOF != null) {
        paramVarArgs.g(5, this.ZOF);
      }
      AppMethodBeat.o(258772);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOC == null) {
        break label508;
      }
    }
    label508:
    for (int i = i.a.a.b.b.a.h(1, this.ZOC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZOD != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZOD.computeSize());
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.content);
      }
      i += i.a.a.b.b.a.cJ(4, this.ZOE);
      paramInt = i;
      if (this.ZOF != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZOF);
      }
      AppMethodBeat.o(258772);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258772);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        beb localbeb = (beb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258772);
          return -1;
        case 1: 
          localbeb.ZOC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258772);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bim localbim = new bim();
            if ((localObject != null) && (localObject.length > 0)) {
              localbim.parseFrom((byte[])localObject);
            }
            localbeb.ZOD = localbim;
            paramInt += 1;
          }
          AppMethodBeat.o(258772);
          return 0;
        case 3: 
          localbeb.content = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258772);
          return 0;
        case 4: 
          localbeb.ZOE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258772);
          return 0;
        }
        localbeb.ZOF = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258772);
        return 0;
      }
      AppMethodBeat.o(258772);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beb
 * JD-Core Version:    0.7.0.1
 */