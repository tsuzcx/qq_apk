package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgz
  extends com.tencent.mm.bx.a
{
  public String aapD;
  public xy aapJ;
  public String aapK;
  public boolean aapL;
  public int aapM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114024);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aapJ != null)
      {
        paramVarArgs.qD(1, this.aapJ.computeSize());
        this.aapJ.writeFields(paramVarArgs);
      }
      if (this.aapD != null) {
        paramVarArgs.g(2, this.aapD);
      }
      if (this.aapK != null) {
        paramVarArgs.g(3, this.aapK);
      }
      paramVarArgs.di(4, this.aapL);
      paramVarArgs.bS(5, this.aapM);
      AppMethodBeat.o(114024);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aapJ == null) {
        break label492;
      }
    }
    label492:
    for (int i = i.a.a.a.qC(1, this.aapJ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aapD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aapD);
      }
      i = paramInt;
      if (this.aapK != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aapK);
      }
      paramInt = i.a.a.b.b.a.ko(4);
      int j = i.a.a.b.b.a.cJ(5, this.aapM);
      AppMethodBeat.o(114024);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114024);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cgz localcgz = (cgz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114024);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            xy localxy = new xy();
            if ((localObject != null) && (localObject.length > 0)) {
              localxy.parseFrom((byte[])localObject);
            }
            localcgz.aapJ = localxy;
            paramInt += 1;
          }
          AppMethodBeat.o(114024);
          return 0;
        case 2: 
          localcgz.aapD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 3: 
          localcgz.aapK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114024);
          return 0;
        case 4: 
          localcgz.aapL = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(114024);
          return 0;
        }
        localcgz.aapM = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(114024);
        return 0;
      }
      AppMethodBeat.o(114024);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgz
 * JD-Core Version:    0.7.0.1
 */