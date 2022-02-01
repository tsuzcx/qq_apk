package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nm
  extends com.tencent.mm.bx.a
{
  public nl YPs;
  public int YPt;
  public String YPu;
  public String YPv;
  public LinkedList<nl> YPw;
  
  public nm()
  {
    AppMethodBeat.i(258563);
    this.YPw = new LinkedList();
    AppMethodBeat.o(258563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258567);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YPs != null)
      {
        paramVarArgs.qD(1, this.YPs.computeSize());
        this.YPs.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YPt);
      if (this.YPu != null) {
        paramVarArgs.g(3, this.YPu);
      }
      if (this.YPv != null) {
        paramVarArgs.g(4, this.YPv);
      }
      paramVarArgs.e(5, 8, this.YPw);
      AppMethodBeat.o(258567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YPs == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = i.a.a.a.qC(1, this.YPs.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YPt);
      paramInt = i;
      if (this.YPu != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YPu);
      }
      i = paramInt;
      if (this.YPv != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YPv);
      }
      paramInt = i.a.a.a.c(5, 8, this.YPw);
      AppMethodBeat.o(258567);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YPw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        nm localnm = (nm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        nl localnl;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258567);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localnl = new nl();
            if ((localObject != null) && (localObject.length > 0)) {
              localnl.parseFrom((byte[])localObject);
            }
            localnm.YPs = localnl;
            paramInt += 1;
          }
          AppMethodBeat.o(258567);
          return 0;
        case 2: 
          localnm.YPt = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258567);
          return 0;
        case 3: 
          localnm.YPu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258567);
          return 0;
        case 4: 
          localnm.YPv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258567);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localnl = new nl();
          if ((localObject != null) && (localObject.length > 0)) {
            localnl.parseFrom((byte[])localObject);
          }
          localnm.YPw.add(localnl);
          paramInt += 1;
        }
        AppMethodBeat.o(258567);
        return 0;
      }
      AppMethodBeat.o(258567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nm
 * JD-Core Version:    0.7.0.1
 */