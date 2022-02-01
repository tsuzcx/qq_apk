package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fya
  extends com.tencent.mm.bx.a
{
  public LinkedList<eag> abAf;
  public String abVR;
  public String abVW;
  public int action;
  public String ctp;
  public int type;
  public String viewId;
  
  public fya()
  {
    AppMethodBeat.i(257786);
    this.abAf = new LinkedList();
    AppMethodBeat.o(257786);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257790);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.viewId != null) {
        paramVarArgs.g(1, this.viewId);
      }
      paramVarArgs.bS(2, this.type);
      if (this.ctp != null) {
        paramVarArgs.g(3, this.ctp);
      }
      paramVarArgs.bS(4, this.action);
      paramVarArgs.e(5, 8, this.abAf);
      if (this.abVR != null) {
        paramVarArgs.g(6, this.abVR);
      }
      if (this.abVW != null) {
        paramVarArgs.g(7, this.abVW);
      }
      AppMethodBeat.o(257790);
      return 0;
    }
    if (paramInt == 1) {
      if (this.viewId == null) {
        break label604;
      }
    }
    label604:
    for (paramInt = i.a.a.b.b.a.h(1, this.viewId) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.ctp != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ctp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.action) + i.a.a.a.c(5, 8, this.abAf);
      paramInt = i;
      if (this.abVR != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abVR);
      }
      i = paramInt;
      if (this.abVW != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abVW);
      }
      AppMethodBeat.o(257790);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abAf.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257790);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fya localfya = (fya)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257790);
          return -1;
        case 1: 
          localfya.viewId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257790);
          return 0;
        case 2: 
          localfya.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257790);
          return 0;
        case 3: 
          localfya.ctp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257790);
          return 0;
        case 4: 
          localfya.action = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257790);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eag localeag = new eag();
            if ((localObject != null) && (localObject.length > 0)) {
              localeag.parseFrom((byte[])localObject);
            }
            localfya.abAf.add(localeag);
            paramInt += 1;
          }
          AppMethodBeat.o(257790);
          return 0;
        case 6: 
          localfya.abVR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257790);
          return 0;
        }
        localfya.abVW = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257790);
        return 0;
      }
      AppMethodBeat.o(257790);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fya
 * JD-Core Version:    0.7.0.1
 */