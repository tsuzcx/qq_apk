package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fcd
  extends com.tencent.mm.bx.a
{
  public String DUT;
  public String Zem;
  public String abBF;
  public String abBG;
  public ajz abBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259235);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.DUT != null) {
        paramVarArgs.g(1, this.DUT);
      }
      if (this.abBF != null) {
        paramVarArgs.g(2, this.abBF);
      }
      if (this.Zem != null) {
        paramVarArgs.g(3, this.Zem);
      }
      if (this.abBG != null) {
        paramVarArgs.g(4, this.abBG);
      }
      if (this.abBH != null)
      {
        paramVarArgs.qD(5, this.abBH.computeSize());
        this.abBH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259235);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUT == null) {
        break label524;
      }
    }
    label524:
    for (int i = i.a.a.b.b.a.h(1, this.DUT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abBF != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abBF);
      }
      i = paramInt;
      if (this.Zem != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zem);
      }
      paramInt = i;
      if (this.abBG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abBG);
      }
      i = paramInt;
      if (this.abBH != null) {
        i = paramInt + i.a.a.a.qC(5, this.abBH.computeSize());
      }
      AppMethodBeat.o(259235);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259235);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fcd localfcd = (fcd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259235);
          return -1;
        case 1: 
          localfcd.DUT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259235);
          return 0;
        case 2: 
          localfcd.abBF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259235);
          return 0;
        case 3: 
          localfcd.Zem = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259235);
          return 0;
        case 4: 
          localfcd.abBG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259235);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ajz localajz = new ajz();
          if ((localObject != null) && (localObject.length > 0)) {
            localajz.parseFrom((byte[])localObject);
          }
          localfcd.abBH = localajz;
          paramInt += 1;
        }
        AppMethodBeat.o(259235);
        return 0;
      }
      AppMethodBeat.o(259235);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcd
 * JD-Core Version:    0.7.0.1
 */