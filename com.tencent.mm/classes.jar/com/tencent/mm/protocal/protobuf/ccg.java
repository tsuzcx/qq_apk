package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class ccg
  extends com.tencent.mm.bx.a
{
  public b aalG;
  public ccc aalH;
  public boolean aalI;
  public int aalJ;
  public String aalK;
  public String aalL;
  public int aalM;
  public String hzq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257828);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aalH != null)
      {
        paramVarArgs.qD(1, this.aalH.computeSize());
        this.aalH.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.aalI);
      paramVarArgs.bS(3, this.aalJ);
      if (this.aalK != null) {
        paramVarArgs.g(4, this.aalK);
      }
      if (this.aalL != null) {
        paramVarArgs.g(5, this.aalL);
      }
      paramVarArgs.bS(6, this.aalM);
      if (this.aalG != null) {
        paramVarArgs.d(7, this.aalG);
      }
      if (this.hzq != null) {
        paramVarArgs.g(8, this.hzq);
      }
      AppMethodBeat.o(257828);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aalH == null) {
        break label660;
      }
    }
    label660:
    for (paramInt = i.a.a.a.qC(1, this.aalH.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1) + i.a.a.b.b.a.cJ(3, this.aalJ);
      paramInt = i;
      if (this.aalK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aalK);
      }
      i = paramInt;
      if (this.aalL != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aalL);
      }
      i += i.a.a.b.b.a.cJ(6, this.aalM);
      paramInt = i;
      if (this.aalG != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.aalG);
      }
      i = paramInt;
      if (this.hzq != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.hzq);
      }
      AppMethodBeat.o(257828);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257828);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ccg localccg = (ccg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257828);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ccc localccc = new ccc();
            if ((localObject != null) && (localObject.length > 0)) {
              localccc.parseFrom((byte[])localObject);
            }
            localccg.aalH = localccc;
            paramInt += 1;
          }
          AppMethodBeat.o(257828);
          return 0;
        case 2: 
          localccg.aalI = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(257828);
          return 0;
        case 3: 
          localccg.aalJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257828);
          return 0;
        case 4: 
          localccg.aalK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257828);
          return 0;
        case 5: 
          localccg.aalL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257828);
          return 0;
        case 6: 
          localccg.aalM = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257828);
          return 0;
        case 7: 
          localccg.aalG = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(257828);
          return 0;
        }
        localccg.hzq = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257828);
        return 0;
      }
      AppMethodBeat.o(257828);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccg
 * JD-Core Version:    0.7.0.1
 */